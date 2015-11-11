package com.kencana.lms.portlet;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MimeResponse;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.kencana.lms.NoSuchItemCategoryException;
import com.kencana.lms.NoSuchItemTypeException;
import com.kencana.lms.util.WebKeys;
import com.kencana.lms.model.CirculationRule;
import com.kencana.lms.model.ItemCategory;
import com.kencana.lms.model.ItemType;
import com.kencana.lms.model.Library;
import com.kencana.lms.model.Location;
import com.kencana.lms.service.CirculationRuleLocalServiceUtil;
import com.kencana.lms.service.ItemCategoryLocalServiceUtil;
import com.kencana.lms.service.ItemTypeLocalServiceUtil;
import com.kencana.lms.service.LibraryLocalServiceUtil;
import com.kencana.lms.service.LocationLocalServiceUtil;
import com.kencana.lms.service.PatronCategoryLocalServiceUtil;
import com.kencana.lms.service.PatronStatusLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.ImageTypeException;
import com.liferay.portal.NoSuchRepositoryException;
import com.liferay.portal.UserPortraitSizeException;
import com.liferay.portal.UserPortraitTypeException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.image.ImageBag;
import com.liferay.portal.kernel.image.ImageToolUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.TempFileUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.FileSizeException;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryException;
import com.liferay.portlet.documentlibrary.NoSuchFileException;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class Administration
 */
public class KencanaAdmin extends MVCPortlet 
{
	public void editCirculationRule(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException 
	{
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
				WebKeys.THEME_DISPLAY);
		
		String page = ParamUtil.getString(actionRequest, "page");
		long circulationRuleId = ParamUtil.getLong(actionRequest, "circulationRuleId");
		CirculationRule circulationRule = null;
		
		if (circulationRuleId <= 0)
		{
			circulationRule = CirculationRuleLocalServiceUtil.create();
		}else
		{
			circulationRule = CirculationRuleLocalServiceUtil.fetchCirculationRule(circulationRuleId);
		}
		long patronCategoryId = ParamUtil.getLong(actionRequest, "patronCategoryId");
		long itemTypeId = ParamUtil.getLong(actionRequest, "itemTypeId");
		long itemCategoryId = ParamUtil.getLong(actionRequest, "itemCategoryId");
		int periodUnit = ParamUtil.getInteger(actionRequest, "periodUnit");
		int loanPeriod = ParamUtil.getInteger(actionRequest, "loanPeriod");
		int loanPeriodIfReserved = ParamUtil.getInteger(actionRequest, "loanPeriodIfReserved");
		double rentalCharge = ParamUtil.getDouble(actionRequest, "rentalCharge");
		double finePerPeriod = ParamUtil.getDouble(actionRequest, "finePerPeriod");
		int fineGracePeriod = ParamUtil.getInteger(actionRequest, "fineGracePeriod");
		double maxFineAmount = ParamUtil.getDouble(actionRequest, "maxFineAmount");
		int maxCheckoutAllowed = ParamUtil.getInteger(actionRequest, "maxCheckoutAllowed");
		int renewalCountAllowed = ParamUtil.getInteger(actionRequest, "renewalCountAllowed");
		int reservedCountAllowed = ParamUtil.getInteger(actionRequest, "reservedCountAllowed");
		
		circulationRule.setItemTypeId(itemTypeId);
		circulationRule.setPatronCategoryId(patronCategoryId);
		circulationRule.setItemCategoryId(itemCategoryId);
		circulationRule.setUserId(themeDisplay.getUserId());
		circulationRule.setCreatedDate(new Date());
		circulationRule.setPeriodUnit(periodUnit);
		circulationRule.setLoanPeriod(loanPeriod);
		circulationRule.setLoanPeriodIfReserved(loanPeriodIfReserved);
		circulationRule.setRentalCharge(rentalCharge);
		circulationRule.setFinePerPeriod(finePerPeriod);
		circulationRule.setFineGracePeriod(fineGracePeriod);
		circulationRule.setMaxFineAmount(maxFineAmount);
		circulationRule.setMaxCheckoutAllowed(maxCheckoutAllowed);
		circulationRule.setReservedCountAllowed(reservedCountAllowed);
		circulationRule.setRenewalCountAllowed(renewalCountAllowed);
		
		
		circulationRule.setCompanyId(themeDisplay.getCompanyId());
		circulationRule.setGroupId(themeDisplay.getScopeGroupId());
		
		CirculationRuleLocalServiceUtil.update(circulationRule);
		
		
	}
	public void editItemType(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException
	{
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
				WebKeys.THEME_DISPLAY);
		
		long itemTypeId = ParamUtil.getLong(actionRequest, "itemTypeId");
		String itemTypeName = ParamUtil.getString(actionRequest, "itemTypeName");
		String checkinMessage = ParamUtil.getString(actionRequest, "checkinMessage");
		String checkoutMessage = ParamUtil.getString(actionRequest, "checkoutMessage");
		double rentalRate = ParamUtil.getDouble(actionRequest, "rentalRate");
		boolean notForLoan = ParamUtil.getBoolean(actionRequest, "notForLoan");
		ItemType itemType = ItemTypeLocalServiceUtil.updateItemType(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), 
				themeDisplay.getUserId(), itemTypeId, itemTypeName, 
				checkoutMessage, checkinMessage, rentalRate,notForLoan);
	
	}
	
	
	public void editItemTypeCover(ActionRequest actionRequest,ActionResponse actionResponse) throws Exception
	{
		
		
		try {
			String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

			if (cmd.equals(Constants.ADD_TEMP)) {
				
				addTempImageFile(actionRequest);
			}
			else {
				
				UploadPortletRequest uploadPortletRequest =
						PortalUtil.getUploadPortletRequest(actionRequest);
				
				long itemTypeId = ParamUtil.getLong(uploadPortletRequest, "itemTypeId");
				
				saveTempImageFile(actionRequest,itemTypeId);

				sendRedirect(actionRequest, actionResponse);
			}
		}
		catch (Exception e) {
			if (e instanceof NoSuchItemTypeException ||
				e instanceof PrincipalException) {

				SessionErrors.add(actionRequest, e.getClass());
				actionResponse.setRenderParameter("mvcPath", "/html/admin/error.jsp");
				
				SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

			}
			else if (e instanceof FileSizeException ||
					 e instanceof ImageTypeException ||
					 e instanceof NoSuchFileException ||
					 e instanceof UploadException ||
					 e instanceof UserPortraitSizeException ||
					 e instanceof UserPortraitTypeException) {

				SessionErrors.add(actionRequest, e.getClass());
			}
			else {
				throw e;
			}
		}
		
	}
	
	public void serveResource(ResourceRequest resourceRequest,	ResourceResponse resourceResponse)
	
	{
		
		try {
			String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);

			if (cmd.equals(Constants.GET_TEMP)) {
				FileEntry tempFileEntry = getTempImageFileEntry(
					resourceRequest);

				serveTempImageFile(
					resourceResponse, tempFileEntry.getContentStream());
			}
		}
		catch (NoSuchFileEntryException nsfee) {
		}
		catch (Exception e) {
			
		}
		
	}
	protected void serveTempImageFile(
			MimeResponse mimeResponse, InputStream tempImageStream)
		throws Exception {

		ImageBag imageBag = ImageToolUtil.read(tempImageStream);

		byte[] bytes = ImageToolUtil.getBytes(
			imageBag.getRenderedImage(), imageBag.getType());

		String contentType = MimeTypesUtil.getExtensionContentType(
			imageBag.getType());

		mimeResponse.setContentType(contentType);

		PortletResponseUtil.write(mimeResponse, bytes);
		
	}
	protected FileEntry getTempImageFileEntry(PortletRequest portletRequest)
			throws PortalException, SystemException {

			ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);
			UploadPortletRequest uploadPortletRequest =
					PortalUtil.getUploadPortletRequest(portletRequest);
			
			String fileName =  ParamUtil.getString(uploadPortletRequest, "itemTypeId");// getTempImageFileName(uploadPortletRequest);
			String folderName = getTempImageFolderName();
			
			return TempFileUtil.getTempFile(
				themeDisplay.getScopeGroupId(), themeDisplay.getUserId(),
				getTempImageFileName(portletRequest), getTempImageFolderName());
	}
	
	protected void saveTempImageFile(ActionRequest actionRequest,long itemTypeId)
			throws Exception 
	{
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
				WebKeys.THEME_DISPLAY);
		
		UploadPortletRequest uploadPortletRequest =
				PortalUtil.getUploadPortletRequest(actionRequest);
			FileEntry tempFileEntry = null;
			
			InputStream tempImageStream = null;

			try 
			{
				
				
				
				
				
				tempFileEntry = TempFileUtil.getTempFile(
						themeDisplay.getScopeGroupId(), themeDisplay.getUserId(),
						String.valueOf(itemTypeId), getTempImageFolderName());
				
				
				
				tempImageStream = tempFileEntry.getContentStream();

				ImageBag imageBag = ImageToolUtil.read(tempImageStream);

				RenderedImage renderedImage = imageBag.getRenderedImage();

				String cropRegionJSON = ParamUtil.getString(
					actionRequest, "cropRegion");

				if (Validator.isNotNull(cropRegionJSON)) {
					JSONObject jsonObject = JSONFactoryUtil.createJSONObject(
						cropRegionJSON);

					int height = jsonObject.getInt("height");
					int width = jsonObject.getInt("width");
					int x = jsonObject.getInt("x");
					int y = jsonObject.getInt("y");

					if ((height + y) > renderedImage.getHeight()) {
						height = renderedImage.getHeight() - y;
					}

					if ((width + x) > renderedImage.getWidth()) {
						width = renderedImage.getWidth() - x;
					}

					renderedImage = getCroppedRenderedImage(
						renderedImage, height, width, x, y);
				}

				byte[] bytes = ImageToolUtil.getBytes(
					renderedImage, imageBag.getType());
				
				saveTempImageFile(itemTypeId, bytes);
			}
			catch (NoSuchFileEntryException nsfee) {
				
				throw new UploadException(nsfee);
			}
			catch (NoSuchRepositoryException nsre) {
				nsre.printStackTrace();
				throw new UploadException(nsre);
			}
			finally {
				StreamUtil.cleanUp(tempImageStream);

				if (tempFileEntry != null) {
					TempFileUtil.deleteTempFile(tempFileEntry.getFileEntryId());
				}
			}
		}
	
	
	/**
	 * Add/Update Item Category
	 * @param actionRequest
	 * @param actionResponse
	 * @throws NoSuchItemCategoryException
	 * @throws SystemException
	 */
	public void editItemCategory (ActionRequest actionRequest,ActionResponse actionResponse) throws NoSuchItemCategoryException, SystemException
	{
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long itemCategoryId = ParamUtil.getLong(actionRequest, "itemCategoryId");
		String backPage = ParamUtil.getString(actionRequest, "backPage");
		String name = ParamUtil.getString(actionRequest, "itemCategoryName");
		
		ItemCategory itemCategory = ItemCategoryLocalServiceUtil.updateItemCategory(themeDisplay.getCompanyId(), 
				themeDisplay.getScopeGroupId(), themeDisplay.getUserId(), itemCategoryId, name);
		
		LOGGER.info(backPage);
		actionResponse.setRenderParameter("page", backPage);
	}
	
	/**
	 * Edit/Add Location
	 * @param actionRequest
	 * @param actionResponse
	 * @throws SystemException
	 */
	public void editLocation(ActionRequest actionRequest,ActionResponse actionResponse) throws SystemException 
	{
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		
		long locationId = ParamUtil.getLong(actionRequest, "locationId");
		long libraryId = ParamUtil.getLong(actionRequest, "libraryId");
		String name  = ParamUtil.getString(actionRequest, "locationName");
		
		Location location  = LocationLocalServiceUtil.updateLocation(themeDisplay.getUserId(), 
								themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), 
								libraryId, locationId, name);
		
	}

	
	/**
	 * Edit/Add library
	 * @param actionRequest
	 * @param actionResponse
	 * @throws SystemException
	 */
	public void editLibrary(ActionRequest actionRequest,ActionResponse actionResponse) throws SystemException
	{
		long libraryId = ParamUtil.getLong(actionRequest, "libraryId");
		String libraryName = ParamUtil.getString(actionRequest, "libraryName");
		String address1 = ParamUtil.getString(actionRequest, "address1");
		String address2 = ParamUtil.getString(actionRequest, "address2");
		String address3 = ParamUtil.getString(actionRequest, "address3");
		String city = ParamUtil.getString(actionRequest, "city");
		String country = ParamUtil.getString(actionRequest, "country");
		String zipcode = ParamUtil.getString(actionRequest, "zipcode");
		
		Library library = null;
		if (Validator.isNotNull(libraryId))
		{
			library = LibraryLocalServiceUtil.fetchLibrary(libraryId);
		}else
		{
			long newLibraryId = CounterLocalServiceUtil.increment(Library.class.getName());
			library = LibraryLocalServiceUtil.createLibrary(newLibraryId);
		}
			
		library.setLibraryName(libraryName);
		library.setAddress1(address1);
		library.setAddress2(address2);
		library.setAddress3(address3);
		library.setCity(city);
		library.setCountry(country);
		LibraryLocalServiceUtil.updateLibrary(library);
		
		
	}
	protected void saveTempImageFile(
			long itemTypeId, byte[] bytes)
		throws Exception {
		
		
		
		ItemTypeLocalServiceUtil.updateCover(itemTypeId, bytes);
	}
	
	protected RenderedImage getCroppedRenderedImage(
			RenderedImage renderedImage, int height, int width, int x, int y) 
	{

		Rectangle rectangle = new Rectangle(width, height);
	
		Rectangle croppedRectangle = rectangle.intersection(
			new Rectangle(renderedImage.getWidth(), renderedImage.getHeight()));
	
		BufferedImage bufferedImage = ImageToolUtil.getBufferedImage(
			renderedImage);
	
		return bufferedImage.getSubimage(
			x, y, croppedRectangle.width, croppedRectangle.height);
	}
	
	protected void addTempImageFile(PortletRequest portletRequest)
			throws Exception 
	{

			UploadPortletRequest uploadPortletRequest =
				PortalUtil.getUploadPortletRequest(portletRequest);

			ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

			String contentType = uploadPortletRequest.getContentType("fileName");
			

			if (!MimeTypesUtil.isWebImage(contentType)) {
				throw new ImageTypeException();
			}
			
			
			try {
				TempFileUtil.deleteTempFile(
					themeDisplay.getScopeGroupId(), themeDisplay.getUserId(),
					getTempImageFileName(portletRequest), getTempImageFolderName());
			}
			catch (Exception e) {
			}

			InputStream inputStream = null;

			try {
				inputStream = uploadPortletRequest.getFileAsStream("fileName");
				String tmpFolderName = getTempImageFolderName();
				String fileName = ParamUtil.getString(uploadPortletRequest, "itemTypeId"); //   getTempImageFileName(portletRequest);
			
				TempFileUtil.addTempFile(
					themeDisplay.getScopeGroupId(), themeDisplay.getUserId(),
					fileName, getTempImageFolderName(),
					inputStream, contentType);
				
			}
			finally {
				StreamUtil.cleanUp(inputStream);
			}
		}
	protected String getTempImageFileName(PortletRequest portletRequest) 
	{
		
		return ParamUtil.getString(portletRequest, "itemTypeId");
	}
	protected String getTempImageFolderName() {
		Class<?> clazz = getClass();

		return clazz.getName();
	}
 
	private static Log LOGGER = LogFactoryUtil.getLog(KencanaAdmin.class);
}
