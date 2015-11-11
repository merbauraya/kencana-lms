package com.kencana.lms.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.kencana.lms.model.PatronStatus;
import com.kencana.lms.service.PatronCategoryLocalServiceUtil;
import com.kencana.lms.service.PatronStatusLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class Kencana extends MVCPortlet{
	
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
	/**
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws SystemException
	 */
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

}
