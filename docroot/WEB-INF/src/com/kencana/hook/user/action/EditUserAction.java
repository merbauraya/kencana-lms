package com.kencana.hook.user.action;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;








import com.kencana.lms.ExpiryDateException;
import com.kencana.lms.NoSuchPatronException;
import com.kencana.lms.model.Patron;
import com.kencana.lms.service.PatronLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.DynamicActionRequest;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.struts.BaseStrutsPortletAction;
import com.liferay.portal.kernel.struts.StrutsPortletAction;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;


public class EditUserAction extends BaseStrutsPortletAction {
	private static Log LOGGER = LogFactoryUtil.getLog(EditUserAction.class);
	@Override
	public void processAction(
			StrutsPortletAction originalStrutsPortletAction,
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {
		
		LOGGER.info("EditUserAction");
		
		String actionName = ParamUtil.getString(
			actionRequest, ActionRequest.ACTION_NAME);
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long patronStatusId = ParamUtil.getLong(actionRequest, "patronStatusId");
		long patronCategoryId =  ParamUtil.getLong(actionRequest, "patronCategoryId");
		long userId = ParamUtil.getLong(actionRequest, "userId");
		long libraryId = ParamUtil.getLong(actionRequest, "libraryId");
		String cardNumber = ParamUtil.getString(actionRequest, "cardNumber");
		String patronNote = ParamUtil.getString(actionRequest, "patronNote");
		
		int expiryDateMonth = ParamUtil.getInteger(
				actionRequest, "expiryDateMonth");
		int expiryDateDay = ParamUtil.getInteger(actionRequest, "expiryDateDay");
		int expiryDateYear = ParamUtil.getInteger(actionRequest, "expiryDateYear");
		
		
		
		Date expiryDate = PortalUtil.getDate(
				expiryDateMonth, expiryDateDay, expiryDateYear,
				ExpiryDateException.class);
		
		
		//update kencana properties
		LOGGER.info("cn="+cardNumber + " uid="+ userId);
		
		
		
		
		
		Patron patron = null;
		if (userId <= 0)
		{
			LOGGER.info("user < 0: new user!");
		}else
		{
			
			patron = PatronLocalServiceUtil.safeFindByUserId(userId);
			patron.setUserId(userId);
			patron.setPatronCategoryId(patronCategoryId);
			patron.setPatronStatusId(patronStatusId);
			patron.setCardNumber(cardNumber);
			patron.setCompanyId(themeDisplay.getCompanyId());
			patron.setLibraryId(libraryId);
			patron.setPatronNote(patronNote);
			patron.setExpiryDate(expiryDate);
			PatronLocalServiceUtil.updatePatron(patron);
			
		}
		
		//originalStrutsPortletAction.processAction(
		//		portletConfig, actionRequest, actionResponse);

		
		originalStrutsPortletAction.processAction(
	            originalStrutsPortletAction, portletConfig, actionRequest,
	            actionResponse);
		/*
		
		updateUser(
				originalStrutsPortletAction, portletConfig, actionRequest,
				actionResponse);
		*/
	}

	@Override
	public String render(
			StrutsPortletAction originalStrutsPortletAction,
			PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse)
		throws Exception {

		return originalStrutsPortletAction.render(
			portletConfig, renderRequest, renderResponse);
	}

	@Override
	public void serveResource(
			StrutsPortletAction originalStrutsPortletAction,
			PortletConfig portletConfig, ResourceRequest resourceRequest,
			ResourceResponse resourceResponse)
		throws Exception {

		originalStrutsPortletAction.serveResource(
			portletConfig, resourceRequest, resourceResponse);
	}

	protected long[] getLongArray(PortletRequest portletRequest, String name) {
		String value = portletRequest.getParameter(name);

		if (value == null) {
			return null;
		}

		return StringUtil.split(GetterUtil.getString(value), 0L);
	}

	

	

	protected void updateUser(
			StrutsPortletAction originalStrutsPortletAction,
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		if (!cmd.equals(Constants.UPDATE)) {
			originalStrutsPortletAction.processAction(
				portletConfig, actionRequest, actionResponse);

			return;
		}
		DynamicActionRequest dynamicActionRequest = new DynamicActionRequest(
				actionRequest);
		
		
		originalStrutsPortletAction.processAction(
				portletConfig, dynamicActionRequest, actionResponse);
		
	}
}