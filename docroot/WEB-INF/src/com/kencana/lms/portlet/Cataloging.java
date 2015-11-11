package com.kencana.lms.portlet;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;












import com.kencana.lms.marc.MarcBuilder;
import com.kencana.lms.model.Catalog;
import com.kencana.lms.model.CatalogItem;
import com.kencana.lms.model.Location;
import com.kencana.lms.model.MarcBatchUpload;
import com.kencana.lms.model.MarcBatchUploadItem;
import com.kencana.lms.model.PatronStatus;
import com.kencana.lms.search.KencanaField;
import com.kencana.lms.service.CatalogItemLocalServiceUtil;
import com.kencana.lms.service.CatalogLocalServiceUtil;
import com.kencana.lms.service.LocationLocalServiceUtil;
import com.kencana.lms.service.MarcBatchUploadItemLocalServiceUtil;
import com.kencana.lms.service.MarcBatchUploadLocalServiceUtil;
import com.kencana.lms.service.PatronCategoryLocalServiceUtil;
import com.kencana.lms.service.PatronStatusLocalServiceUtil;
import com.kencana.lms.util.CatalogItemHelper;
import com.kencana.lms.util.FolderUtil;
import com.kencana.lms.util.KencanaConstant;
import com.kencana.lms.util.KencanaUtil;
import com.liferay.portal.NoSuchResourceException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.TempFileUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.FileSizeException;
import com.liferay.portlet.documentlibrary.model.DLFileEntryTypeConstants;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

































import org.marc4j.marc.Record;
import org.marc4j.MarcStreamWriter;
import org.marc4j.MarcWriter;
/**
 * Portlet implementation class Cataloging
 */
public class Cataloging extends MVCPortlet {
 
	@Override
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse)
	{
		String resourceID = resourceRequest.getResourceID();
		
		if (resourceID.equals("locationByLibrary"))
		{
			long libraryId = ParamUtil.getLong(resourceRequest, "libraryId");
			
			try {
				ajaxLocationByLibrary(libraryId,resourceResponse);
			} catch (SystemException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void ajaxLocationByLibrary(long libraryId,ResourceResponse resourceResponse) throws SystemException, IOException
	{
		List<Location> locations = LocationLocalServiceUtil.findByLibrary(libraryId);
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		for (Location location : locations)
		{
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject(); 
            jsonObject.put("locationId",location.getLocationId() ); 
            jsonObject.put("locationName",location.getLocationName() ); 
            jsonArray.put(jsonObject);



		}
		
		PrintWriter writer = resourceResponse.getWriter();
        writer.write(jsonArray.toString());
        writer.flush();
		
	}
	public void z3950Search(ActionRequest actionRequest, ActionResponse actionResponse)
	{
		
	}
	public void editCatalogSimple(ActionRequest request,ActionResponse response) throws PortalException, SystemException, UnsupportedEncodingException 
	{
		
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		Record record = MarcBuilder.buildMarcSimple(request, response);
	
		long catalogId = ParamUtil.getLong(request, "catalogId");
		Catalog catalog = null;
		
		
		if (catalogId > 0)
		{
			catalog = CatalogLocalServiceUtil.fetchCatalog(catalogId);
		}
		
		
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
		         Catalog.class.getName(), request);
		
		MarcWriter writer = new MarcStreamWriter(os);
		writer.write(record);
		writer.close(); 
		
		//String marcContent = new String(os.toByteArray());
		
		String callNumber = ParamUtil.getString(request, "callNumber");
		long itemTypeId = ParamUtil.getLong(request, KencanaField.ITEM_TYPE);
		if (Validator.isNull(catalog))
		{
			
			
			CatalogLocalServiceUtil.addCatalog(themeDisplay.getUserId(), 
					themeDisplay.getCompanyId(),themeDisplay.getScopeGroupId(),
					itemTypeId, record,serviceContext);
		}
		else
		{
			catalog.setCallNumber(callNumber);
			
			//CatalogLocalServiceUtil.editCatalog(themeDisplay.getUserId(),catalog.getCatalogId(),itemTypeId,record,serviceContext);
			CatalogLocalServiceUtil.updateCatalog(catalog, themeDisplay.getUserId(), record, serviceContext);
		}
		
	}
	public void releaseAccession(ActionRequest actionRequest,ActionResponse response) throws PortalException, SystemException 
	{
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
		         CatalogItem.class.getName(), actionRequest);
		
		long[] catalogItemIds = ParamUtil.getLongValues(actionRequest, "catalogItemIds");
		
		CatalogItemLocalServiceUtil.releaseCatalogItems(catalogItemIds, serviceContext);
	}
	public void editCatalogItem(ActionRequest request,ActionResponse response) throws SystemException, PortalException
	{
		
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		long catalogId = ParamUtil.getLong(request, "catalogId");
		long catalogItemId = ParamUtil.getLong(request, "catalogItemId");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
		         CatalogItem.class.getName(), request);
		
		CatalogItem catalogItem = null;
		
		LOGGER.info("catitemID="+catalogItemId);
		if (catalogItemId <= 0)
		{
			catalogItem = CatalogItemLocalServiceUtil.newCatalogItem(themeDisplay.getUserId(),catalogId);
			
		}else
		{
			catalogItem = CatalogItemLocalServiceUtil.fetchCatalogItem(catalogItemId);
		}
		
		HttpServletRequest servletReq = PortalUtil.getHttpServletRequest(request);
		
		catalogItem = CatalogItemHelper.updateProperty(catalogItem, servletReq, themeDisplay);
		//get categorys
		long[] assetCategoryIds = getCategoryIds(request);
		
		
		LOGGER.info(catalogItem.getCatalogItemId());
		
		serviceContext.setAssetCategoryIds(assetCategoryIds);
		
		
		CatalogItemLocalServiceUtil.update(catalogItem, serviceContext);// .updateCatalogItem(catalogItem,serviceContext);
		
	}
	
	private long[] getCategoryIds(ActionRequest request)
	{
		Map<String, String[]> parameterMap = request.getParameterMap();
		
		List<Long> assetCategoryIdsList = new ArrayList<>();
		boolean updateAssetCategoryIds = false;
		
		for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) 
		{
			String name = entry.getKey();

			if (name.startsWith("assetCategoryIds")) 
			{
				updateAssetCategoryIds = true;

				long[] assetVocabularyAssetCategoryIds = StringUtil.split(
					ParamUtil.getString(request, name), 0L);

				for (long assetCategoryId : assetVocabularyAssetCategoryIds) {
					assetCategoryIdsList.add(assetCategoryId);
				}
			}
		}
		if (updateAssetCategoryIds) 
		{
			long[] assetCategoryIds = ArrayUtil.toArray(
				assetCategoryIdsList.toArray(
					new Long[assetCategoryIdsList.size()]));

			return assetCategoryIds;
		}
		return null;
	}
	
	
	public void processUploadedMarc(ActionRequest request,ActionResponse response) throws PortalException, SystemException, UnsupportedEncodingException 
	{
		
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
		         CatalogItem.class.getName(), request);
		String[] selectedIdString = ParamUtil.getParameterValues(request, "rowIds");
		long[] selectedIds = null;
		
		//rowchecker
		if (ArrayUtil.isNotEmpty(selectedIdString))
		{
			selectedIds = new long[selectedIdString.length];
			for (int i = 0; i < selectedIdString.length; i++)
			{
				selectedIds[i] = Long.parseLong(selectedIdString[i]);
			}
		}else //individu process
		{
			long batchId = ParamUtil.getLong(request, "batchId");
			selectedIds = new long[]{batchId};
			
		}
		
		long[] newCatalogIds = MarcBatchUploadLocalServiceUtil.importMultiplceBatchs(selectedIds, themeDisplay,serviceContext);
		
		String batchIds = KencanaUtil.ArrayToString(selectedIds);
		String catalogIds = KencanaUtil.ArrayToString(newCatalogIds);
		
		String redirect = getRedirect(request, response);

		redirect = HttpUtil.setParameter(
			redirect, response.getNamespace() + "catalogIds",
			catalogIds);

		request.setAttribute(WebKeys.REDIRECT, redirect);
		/*
		request.setAttribute("batchIds", batchIds);
		request.setAttribute("catalogIds", "catalogIds");
		
		response.setRenderParameter("catalogIds",catalogIds);
		response.setRenderParameter("batchIds", batchIds);
		
		response.setRenderParameter("mvcPath", "/html/cataloging/marc_upload/batch_import_summary.jsp");
		
		*/
		
		
	}
	public void deleteCatalog(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException
	{
		long[] catalogIds = ParamUtil.getLongValues(actionRequest, "catalogIds");
		String backPage = ParamUtil.getString(actionRequest, "page");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
		         Catalog.class.getName(), actionRequest);
		
		CatalogLocalServiceUtil.deleteCatalog(catalogIds, true, serviceContext);
		
		if (Validator.isNotNull(backPage))
		{
			actionResponse.setRenderParameter("page", backPage);
		}
	}
	/**
	 * Edit/add Patron Category
	 * @param actionRequest
	 * @param actionResponse
	 * @throws SystemException
	 */
	public void editPatronCategory(ActionRequest actionRequest,ActionResponse actionResponse) throws SystemException
	{
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long patronCategoryId = ParamUtil.getLong(actionRequest, "patronCategoryId");
		String name = ParamUtil.getString(actionRequest, "patronCategoryName");
		String notes = ParamUtil.getString(actionRequest, "notes");
		
		long companyId = themeDisplay.getCompanyId();
		long groupId = themeDisplay.getScopeGroupId();
		
		if (patronCategoryId <= 0)
		{
			PatronCategoryLocalServiceUtil.add(companyId, groupId, name, notes);
		}else
		{
			PatronCategoryLocalServiceUtil.update(patronCategoryId, groupId, companyId, name, notes);
		}
		
	}
	public void editPatronStatus (ActionRequest actionRequest,ActionResponse actionResponse) throws SystemException
	{
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId = themeDisplay.getCompanyId();
		long groupId = themeDisplay.getScopeGroupId();
		
		long patronStatusId = ParamUtil.getLong(actionRequest, "patronStatusId");
		String patronStatusName = ParamUtil.getString(actionRequest, "patronStatusName");
		boolean noLogin = ParamUtil.getBoolean(actionRequest, "noLogin");
		boolean noCheckout = ParamUtil.getBoolean(actionRequest, "noCheckout");
		boolean noReserve = ParamUtil.getBoolean(actionRequest, "noReserve");
		boolean noRenew = ParamUtil.getBoolean(actionRequest, "noRenew");
		
		int color = 0; //future use
		
		
		if (patronStatusId <= 0)
		{
			PatronStatus patronStatus = PatronStatusLocalServiceUtil.addPatronStatus(groupId, companyId, 
					patronStatusName, noLogin, noCheckout, 
					noReserve, color);
		
		}else
		{
			PatronStatus patronStatus = PatronStatusLocalServiceUtil.fetchPatronStatus(patronStatusId);
			patronStatus.setCompanyId(companyId);
			patronStatus.setGroupId(groupId);
			patronStatus.setNoLogin(noLogin);
			patronStatus.setNoCheckout(noCheckout);
			patronStatus.setNoRenew(noRenew);
			patronStatus.setNoReserve(noReserve);
			patronStatus.setColor(color);
			PatronStatusLocalServiceUtil.updatePatronStatus(patronStatus);
		}
		
		
	}
	
	public void importMARC(ActionRequest request,ActionResponse response) throws PortalException, SystemException, UnsupportedEncodingException 
	{
		
		ThemeDisplay	themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		long groupId = themeDisplay.getScopeGroupId();
		long companyId = themeDisplay.getCompanyId();
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
		String description = ParamUtil.getString(uploadRequest, "description");
		//selected temp file for upload
		String[] selectedFiles = uploadRequest.getParameterValues("selectUploadedFileCheckbox");
		long[] fileEntries = {};		
		if (selectedFiles != null)
		{
			int fileCount = selectedFiles.length;
			MarcBatchUpload batchUpload = MarcBatchUploadLocalServiceUtil.create(userId, companyId, groupId, fileCount,description);
			fileEntries = processTempFile(batchUpload.getMarcBatchUploadId(), selectedFiles,request,themeDisplay);
			
		}
		
	}
	
	protected long[] processTempFile(long batchId,String[] selectedFile,ActionRequest actionRequest, ThemeDisplay themeDisplay)
	{
		
		long companyId = themeDisplay.getCompanyId();
		long groupId = themeDisplay.getScopeGroupId();
		long userId = themeDisplay.getUserId();
		List<FileEntry> tempFileEntrys = new ArrayList<FileEntry>();
		
		long[] fileEntries = {};
		
		long folderId = FolderUtil.getFolderId(actionRequest, themeDisplay);
		String changeLog = StringPool.BLANK;
		String description = StringPool.BLANK;
		boolean incrementCounter = false;
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);

		try
	    {
	        
	    
	        
	        

	        if(selectedFile != null)
	        {
	            for(int i = 0; i < selectedFile.length; ++i)
	            {
	                FileEntry tmpfile = TempFileUtil.getTempFile(themeDisplay.getScopeGroupId(), themeDisplay.getUserId(), selectedFile[i], KencanaConstant.TEMP_UPLOAD_FOLDER);
	                if(tmpfile!=null && tmpfile.getTitle()!=null && (!tmpfile.getTitle().equals("")))
	                {
	                    tempFileEntrys.add(tmpfile);
	                    
	                }
	            }
	        }
	        fileEntries = new long[tempFileEntrys.size()];
	        ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
	        		
        	
        	serviceContext.setAddGuestPermissions(true);
        	serviceContext.setAddGroupPermissions(true);
        	long fileEntryTypeId = DLFileEntryTypeConstants.FILE_ENTRY_TYPE_ID_ALL;
        	serviceContext.setAttribute("fileEntryTypeId", fileEntryTypeId);
        	
        	//serviceContext.setGuestPermissions(guestPermissions);
	        for (int i = 0; i < tempFileEntrys.size(); i++)  //(FileEntry tmpFileEntry : tempFileEntrys)
	        {
	        	FileEntry tmpFileEntry = tempFileEntrys.get(i);
	        	long fileEntryId = tmpFileEntry.getFileEntryId();
	        	File file = DLFileEntryLocalServiceUtil.getFile(userId, fileEntryId, tmpFileEntry.getVersion(), incrementCounter);
	        	
	        	
	        	
	        	
	        	
	        	String version = tmpFileEntry.getVersion();
	        	String sourceFileName = file.getName() + "."+ tmpFileEntry.getExtension();
	        	String title = tmpFileEntry.getTitle();
	        	String mimeType = tmpFileEntry.getMimeType();
	        	
	        	String extension = tmpFileEntry.getExtension();
	        	long repositoryId = themeDisplay.getScopeGroupId();
	        	
	    		

	        	//InputStream is = DLFileEntryLocalServiceUtil.getFileAsStream(themeDisplay.getUserId(),fileEntry.getFileEntryId(), fileEntry.getVersion());
	        	//DLFileEntryLocalServiceUtil.addFileEntry(userId, groupId, repositoryId, folderId, sourceFileName, mimeType, title, description, changeLog, fileEntryTypeId, fieldsMap, file, is, size, new ServiceContext());
		       // FileEntry fileEntry = DLAppServiceUtil.addFileEntry(themeDisplay.getScopeGroupId(), folderId, sourceFileName, mimeType, title, description, changeLog, file,  serviceContext);
		        
		        FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(userId, repositoryId, folderId, sourceFileName, mimeType, title,
						description, changeLog, file,serviceContext);
		        
		        
		        
		        fileEntries[i] = fileEntry.getFileEntryId();
		        MarcBatchUploadItem uploadItem = MarcBatchUploadItemLocalServiceUtil.create(batchId, userId, companyId, groupId, fileEntry.getFileEntryId());
		        
	        }
	        
	        
	    }
	    catch (Exception e) 
	    {
	        e.printStackTrace();
	        
	    }
	    finally
	    {
	        //delete all tmp files uploaded in liferay tmp folder
	        for (FileEntry tmp : tempFileEntrys) 
	        {
	            try 
	            {
	                TempFileUtil.deleteTempFile(tmp.getFileEntryId());
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }
		return fileEntries;
	}
	public void manageTempFileUpload(ActionRequest request,ActionResponse response) throws Exception
	{
		
		
		//upload file in liferay tmp folder
	    UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);
	    ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
	    //long folderId = SuburFolderUtil.getFolderId(request, themeDisplay);// .xxx();  ParamUtil.getLong(uploadPortletRequest, "folderId");
	    long folderId = ParamUtil.getLong(uploadPortletRequest, "folderId");

	    String sourceFileName = uploadPortletRequest.getFileName("file");
	    
	    
	    File file;
	    String title = sourceFileName;
	    
	    
	    InputStream inputStream = null;
	    
	    try 
	    {
	        inputStream = uploadPortletRequest.getFileAsStream("file");
	        file = uploadPortletRequest.getFile("file");
	        String mimeType = MimeTypesUtil.getContentType(file);
	        String contentType = uploadPortletRequest.getContentType("file");
	        //FileEntry fileEntry = DLAppServiceUtil.addFileEntry(themeDisplay.getScopeGroupId(), folderId, sourceFileName, mimeType, title, description, changeLog, file,  new ServiceContext());
	        
	        DLAppServiceUtil.addTempFileEntry(themeDisplay.getScopeGroupId(), folderId, sourceFileName,KencanaConstant.TEMP_UPLOAD_FOLDER, inputStream, contentType);
	        
	        JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
	        jsonObject.put("name", sourceFileName);
	        jsonObject.put("title", sourceFileName);
	        writeJSON(request, response, jsonObject);
	        
	     
	    }
	    catch (Exception e)
	    {
	    	
	    	UploadException uploadException =(UploadException)request.getAttribute(WebKeys.UPLOAD_EXCEPTION);
	        if ((uploadException != null) &&uploadException.isExceededSizeLimit()) 
	        {
	            throw new FileSizeException(uploadException.getCause());
	        }
	        else 
	        {
	            LOGGER.error(e);
	        	throw e;
	        }
	    }
	    finally 
	    {
	        StreamUtil.cleanUp(inputStream);
	    }
	}
	
	
	
	protected void doDispatch(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		if (SessionErrors.contains(
				renderRequest, NoSuchResourceException.class.getName()) ||
			SessionErrors.contains(
				renderRequest, PrincipalException.class.getName())) {

			include("/error.jsp", renderRequest, renderResponse);
		}
		else {
			super.doDispatch(renderRequest, renderResponse);
		}
	}

	private static Log LOGGER = LogFactoryUtil.getLog(Cataloging.class);
}
