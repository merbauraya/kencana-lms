/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.kencana.lms.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.marc4j.MarcReader;
import org.marc4j.MarcStreamReader;
import org.marc4j.marc.Record;

import com.kencana.lms.model.Catalog;
import com.kencana.lms.model.MarcBatchUpload;
import com.kencana.lms.model.MarcBatchUploadItem;
import com.kencana.lms.service.CatalogLocalServiceUtil;
import com.kencana.lms.service.MarcBatchUploadItemLocalServiceUtil;
import com.kencana.lms.service.MarcBatchUploadLocalServiceUtil;
import com.kencana.lms.service.base.MarcBatchUploadLocalServiceBaseImpl;
import com.kencana.lms.util.MarcImportUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileVersion;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;

/**
 * The implementation of the marc batch upload local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.kencana.lms.service.MarcBatchUploadLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.kencana.lms.service.base.MarcBatchUploadLocalServiceBaseImpl
 * @see com.kencana.lms.service.MarcBatchUploadLocalServiceUtil
 */
public class MarcBatchUploadLocalServiceImpl
	extends MarcBatchUploadLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.kencana.lms.service.MarcBatchUploadLocalServiceUtil} to access the marc batch upload local service.
	 */
	
	public MarcBatchUpload create(long userId,long companyId,long groupId,int fileCount,String description) throws SystemException
	{
		long batchId = CounterLocalServiceUtil.increment(MarcBatchUpload.class.getName());
		MarcBatchUpload batchUpload = marcBatchUploadPersistence.create(batchId);
		
		Date now = new Date();
		batchUpload.setCreateBy(userId);
		batchUpload.setCompanyId(companyId);
		batchUpload.setGroupId(groupId);
		
		batchUpload.setCreatedDate(now);
		batchUpload.setFileCount(fileCount);
		batchUpload.setDescription(description);
		marcBatchUploadPersistence.update(batchUpload);
		
		return batchUpload;
		
		
	}
	public List<MarcBatchUpload> getUnprocessed(long companyId,long groupId,int start,int end) throws SystemException
	{
		List<MarcBatchUpload> uploads = marcBatchUploadPersistence.findByStatus(groupId, companyId, false,start,end);
		
		return uploads;
	}
	/**
	 * Update import status to fully processed
	 * @param batchId
	 * @param userId
	 * @throws SystemException
	 */
	public void setFullProcessed(long batchId,long userId) throws SystemException
	{
		MarcBatchUpload batchUpload = marcBatchUploadPersistence.fetchByPrimaryKey(batchId);
		batchUpload.setProcessed(true);
		batchUpload.setImportDate(new Date());
		batchUpload.setImportByUserId(userId);
		marcBatchUploadPersistence.update(batchUpload);
		
		
	}
	/**
	 * Update import status to partially processed.
	 * @param batchId
	 * @param userId
	 * @throws SystemException
	 */
	public void setPartialProcessed(long batchId, long userId) throws SystemException
	{
		MarcBatchUpload batchUpload = marcBatchUploadPersistence.fetchByPrimaryKey(batchId);
		batchUpload.setPartialImport(true);
		batchUpload.setImportDate(new Date());
		batchUpload.setImportByUserId(userId);
		marcBatchUploadPersistence.update(batchUpload);
	}
	//process the whole batch
	public  long[] importMultiplceBatchs(long[] batchIds,ThemeDisplay themeDisplay,ServiceContext serviceContext) throws SystemException, PortalException
		{
			long[] catalogIds = new long[]{};
			for (long batchId : batchIds)
			{
				LOGGER.info("batch="+batchId);
				long[] newCatalogIds = importSingleBatch(batchId,themeDisplay,serviceContext);
				catalogIds = ArrayUtil.append(catalogIds,newCatalogIds);
			}
			return catalogIds;
		}
	public long[] importSingleBatch(long batchId,ThemeDisplay themeDisplay,ServiceContext serviceContext) throws PortalException
	{
			
			
		List<MarcBatchUploadItem> uploadItems = null;
		try {
			uploadItems = MarcBatchUploadItemLocalServiceUtil.findByBatchId(batchId);
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<Long> catalogIds = new ArrayList<Long>();
		
		LOGGER.info("item size="+uploadItems.size());
		for (MarcBatchUploadItem uploadItem : uploadItems)
		{
			
			LOGGER.info("itemId="+uploadItem.getMarcBatchUploadItemId());
			//fetch file by fileId from our DL
			FileEntry fileEntry;
			InputStream in;
			try {
				LOGGER.info("try");
				
				fileEntry = DLAppLocalServiceUtil.getFileEntry(uploadItem.getFileEntryId());
			
				String version = fileEntry.getVersion();
				
				
				FileVersion fv = fileEntry.getFileVersion(version);
				
				in = fv.getContentStream(true);
				MarcReader reader = new MarcStreamReader(in);
				
				while (reader.hasNext()) {
			        Record record = reader.next();
			        
			        LOGGER.info(record.toString());
					Catalog catalog = CatalogLocalServiceUtil.addCatalog(themeDisplay.getUserId(), 
							themeDisplay.getCompanyId(),themeDisplay.getScopeGroupId(),
							0, record,serviceContext);
					LOGGER.info("new catalog created");
					catalogIds.add(catalog.getCatalogId());
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				LOGGER.error(e);
			} 
			
			
			
		    
			
		}
		
		
		
		try {
			setFullProcessed(batchId, themeDisplay.getUserId());
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ArrayUtil.toLongArray(catalogIds);
	}
		
		private static Log LOGGER = LogFactoryUtil.getLog(MarcBatchUploadLocalServiceImpl.class);
}