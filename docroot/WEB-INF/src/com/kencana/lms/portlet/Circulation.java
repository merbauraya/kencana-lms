package com.kencana.lms.portlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.kencana.lms.NoSuchPatronException;
import com.kencana.lms.model.CatalogItem;
import com.kencana.lms.model.Patron;
import com.kencana.lms.model.PatronStatus;
import com.kencana.lms.service.CatalogItemLocalServiceUtil;
import com.kencana.lms.service.PatronLocalServiceUtil;
import com.kencana.lms.service.PatronStatusLocalServiceUtil;
import com.kencana.lms.util.CirculationUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class Circulation
 */
public class Circulation extends MVCPortlet 
{
	
	 public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException
	 {
		 String cmd = ParamUtil.getString(resourceRequest, "cmd");
		 
		 if (cmd.equals(CirculationUtil.RESOURCE_VALIDATE_PATRON_CHECKOUT))
		 {
			 String cardNumber = ParamUtil.getString(resourceRequest, "cardNumber");
			 LOGGER.info("card="+cardNumber);
			 patronCheckoutValidation (resourceRequest, resourceResponse,cardNumber);
		 }else if (cmd.equals(CirculationUtil.RESOURCE_VALIDATE_CATALOGITEM_CHECKOUT))
		 {
			 String barcode = ParamUtil.getString(resourceRequest, "barcode");
			 catalogItemCheckoutValidation(resourceRequest, resourceResponse,barcode);
		 }else if (cmd.equals(CirculationUtil.RESOURCE_PATRON_INFO))
		 {
			 String page = ParamUtil.getString(resourceRequest, "page");
			 PortletRequestDispatcher dispatcher = resourceRequest.getPortletSession().getPortletContext().getRequestDispatcher(page);
			 dispatcher.include(resourceRequest, resourceResponse);

		 }
	 }
	 protected void catalogItemCheckoutValidation (ResourceRequest resourceRequest, ResourceResponse resourceResponse,String barcode) throws IOException
	 {
		 

		 ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		 
		 
		
		 JSONObject catalogItemJSON = CirculationUtil.isCatatalogItemValidForCheckout(themeDisplay, barcode);
		 PrintWriter out = resourceResponse.getWriter();
		 out.println(catalogItemJSON.toString());

		 
	 }
	 protected void patronCheckoutValidation(ResourceRequest resourceRequest, ResourceResponse resourceResponse,String cardNumber) throws IOException
	 {
		 Patron patron = null;
		 User user = null;
		 ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		 JSONObject patronJSON = JSONFactoryUtil.createJSONObject();
		 try
		 {
			 patron = PatronLocalServiceUtil.findByCardNumber(cardNumber);
			 patronJSON.put("patronExists", true);
			 patronJSON.put("patronId", patron.getPatronId());
			 user = UserLocalServiceUtil.fetchUser(patron.getPatronId());
			 patronJSON.put("patronName", user.getFullName());
			 LOGGER.info(themeDisplay.getPathImage());
			 String portraitURL = user.getPortraitURL(themeDisplay);
			 patronJSON.put("patronPortrait", portraitURL);
			 PatronStatus patronStatus = PatronStatusLocalServiceUtil.getPatronStatus(patron.getPatronStatusId());
			 patronJSON.put("patronStatus", patronStatus.getPatronStatusName());
			 
			 
			 if (CirculationUtil.isPatronValidForCheckout(patron.getPatronId()))
			 {
				 patronJSON.put("validForCheckout", true);
			 }else
			 {
				 patronJSON.put("validForCheckout", false);
			 }
			 
			 
		 }catch (NoSuchPatronException nspe)
		 {
			 patronJSON.put("patronExists", false);
		 }
		
		 catch (SystemException | PortalException ex) 
		 {
		
			 patronJSON.put("error", "System Error");
		}
		 PrintWriter out = resourceResponse.getWriter();
		 out.println(patronJSON.toString());
	 }
	 
		private static Log LOGGER = LogFactoryUtil.getLog(Circulation.class);


}
