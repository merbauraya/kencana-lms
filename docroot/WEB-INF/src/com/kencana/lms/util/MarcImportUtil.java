package com.kencana.lms.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.marc4j.MarcReader;
import org.marc4j.MarcStreamReader;
import org.marc4j.marc.Record;













import com.kencana.lms.model.Catalog;
import com.kencana.lms.model.MarcBatchUploadItem;
import com.kencana.lms.service.CatalogLocalServiceUtil;
import com.kencana.lms.service.MarcBatchUploadItemLocalServiceUtil;
import com.kencana.lms.service.MarcBatchUploadLocalServiceUtil;
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
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;

public class MarcImportUtil {
	
	
	//process the whole batch
	public  static long[] importMultiplceBatchs(long[] batchIds,ThemeDisplay themeDisplay,ServiceContext serviceContext) throws SystemException, PortalException
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
	public static long[] importSingleBatch(long batchId,ThemeDisplay themeDisplay,ServiceContext serviceContext) throws PortalException
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
				fileEntry = DLAppServiceUtil.getFileEntry(uploadItem.getFileEntryId());
				LOGGER.info("aft");
				String version = fileEntry.getVersion();
				
				
				FileVersion fv = fileEntry.getFileVersion(version);
				LOGGER.info("file="+fv.getTitle());
				in = fv.getContentStream(true);
				MarcReader reader = new MarcStreamReader(in);
				
				while (reader.hasNext()) {
			        Record record = reader.next();
			        
			        LOGGER.info(record.toString());
					Catalog catalog = CatalogLocalServiceUtil.addCatalog(themeDisplay.getUserId(), 
							themeDisplay.getCompanyId(),themeDisplay.getScopeGroupId(),
							0, record,serviceContext);
					catalogIds.add(catalog.getCatalogId());
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				LOGGER.error(e);
			} 
			
			
			
		    
			
		}
		
		
		try {
			MarcBatchUploadLocalServiceUtil.setFullProcessed(batchId, themeDisplay.getUserId());
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return ArrayUtil.toLongArray(catalogIds);
	}
	
	private static Log LOGGER = LogFactoryUtil.getLog(MarcImportUtil.class);

}
