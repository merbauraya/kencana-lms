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

import java.util.List;

import com.kencana.lms.model.MarcBatchUploadItem;
import com.kencana.lms.service.base.MarcBatchUploadItemLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the marc batch upload item local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.kencana.lms.service.MarcBatchUploadItemLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.kencana.lms.service.base.MarcBatchUploadItemLocalServiceBaseImpl
 * @see com.kencana.lms.service.MarcBatchUploadItemLocalServiceUtil
 */
public class MarcBatchUploadItemLocalServiceImpl
	extends MarcBatchUploadItemLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.kencana.lms.service.MarcBatchUploadItemLocalServiceUtil} to access the marc batch upload item local service.
	 */
	
	public MarcBatchUploadItem create (long batchId,long userId,long companyId,long groupId,long fileEntryId) throws SystemException
	{
		long id = CounterLocalServiceUtil.increment(MarcBatchUploadItem.class.getName());
		
		MarcBatchUploadItem uploadItem = marcBatchUploadItemPersistence.create(id);
		
		uploadItem.setMarcBatchUploadItemId(batchId);
		uploadItem.setCreatedBy(userId);
		uploadItem.setCompanyId(companyId);
		uploadItem.setGroupId(groupId);
		uploadItem.setFileEntryId(fileEntryId);
		uploadItem.setMarcBatchUploadId(batchId);
		
		marcBatchUploadItemPersistence.update(uploadItem);
		return uploadItem;
	}
	public List<MarcBatchUploadItem> findByBatchId(long batchId) throws SystemException
	{
		return marcBatchUploadItemPersistence.findByBatchId(batchId);
	}
}