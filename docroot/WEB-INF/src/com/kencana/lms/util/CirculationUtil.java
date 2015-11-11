package com.kencana.lms.util;

import java.util.List;

import com.kencana.lms.NoSuchCatalogItemException;
import com.kencana.lms.model.CatalogItem;
import com.kencana.lms.model.CirculationTrans;
import com.kencana.lms.model.ItemType;
import com.kencana.lms.service.CatalogItemLocalServiceUtil;
import com.kencana.lms.service.ItemTypeLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.theme.ThemeDisplay;

public class CirculationUtil {
	
	public static final int UNIT_DAY = 1;
	public static final int UNIT_HOUR = 2;
	
	/* serve Resource constants */
	public static final String RESOURCE_VALIDATE_PATRON_CHECKOUT = "validatePatronCheckout";
	public static final String RESOURCE_VALIDATE_CATALOGITEM_CHECKOUT = "validateCatalogItemCheckout";
	public static final String RESOURCE_PATRON_INFO = "patronInfo";
	public static boolean isPatronValidForCheckout(long patronId)
	{
		//List<CirculationTrans> trans = CirculationTransLocalServiceUtil.
		return true;
	}
	public static JSONObject isCatatalogItemValidForCheckout(ThemeDisplay themeDisplay,String barcode) 
	{
		
		JSONObject itemJSON = JSONFactoryUtil.createJSONObject();

		
		try {
			CatalogItem catalogItem = CatalogItemLocalServiceUtil.findByBarcode(themeDisplay.getCompanyId(), barcode);
			ItemType itemType = ItemTypeLocalServiceUtil.fetchItemType(catalogItem.getItemTypeId());
			String reason = StringPool.BLANK;
			boolean validForCheckout = false;
			
			itemJSON.put("validForCheckOut", false);
			if (Validator.isNotNull(catalogItem.getDueDate()))
			{
				reason = LanguageUtil.get(themeDisplay.getLocale(), "catalog-item-is-already-checkout");
			}
			
			if (itemType.getNotForLoan())
			{
				
				reason =  LanguageUtil.get(themeDisplay.getLocale(), "catalog-item-not-for-loan");
			
			}
			
			if (catalogItem.getNotForLoanStatus())
			{
				reason = LanguageUtil.get(themeDisplay.getLocale(), "catalog-item-not-for-loan");
			}
			
			if (reason.equals(StringPool.BLANK))
			{
				validForCheckout = true;
			}
			
			itemJSON.put("validForCheckOut", validForCheckout);
			itemJSON.put("reason", reason);
			return itemJSON;
			
		
		} catch (NoSuchCatalogItemException e) 
		{
			itemJSON.put("validForCheckOut", false);
			itemJSON.put("reason", LanguageUtil.get(themeDisplay.getLocale(), "catalog-item-not-found"));
			return itemJSON;
		} catch (SystemException e)
		{
			itemJSON.put("validForCheckOut", false);
			itemJSON.put("reason", LanguageUtil.get(themeDisplay.getLocale(), "system-error"));
			return itemJSON;
		}
		
	}
	
	
}
