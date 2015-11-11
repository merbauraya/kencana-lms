package com.kencana.lms.util;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.kencana.lms.model.CatalogItem;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.theme.ThemeDisplay;

public class CatalogItemHelper {
	
	public static final String CALL_NUMBER="callNumber";
	public static final String HOLDING_LIBRARY_ID = "holdingLibraryId";
	public static final String CURRENT_LIBRARY_ID = "currentLibraryId";
	public static final String ITEM_CATEGORY_ID = "itemCategoryId";
	public static final String ITEM_TYPE_ID = "itemTypeId";
	
	public static final String BARCODE = "barcode";
	public static final String COPY_NUMBER = "copyNumber";
	
	public static final String WITHDRAWN_STATUS="withdrawnStatus";
	public static final String LOST_STATUS = "lostStatus";
	public static final String DAMAGE_STATUS = "damageStatus";
	public static final String NOT_FOR_LOAN_STATUS = "notForLoanStatus";
	
	public static final String PURCHASE_PRICE = "purchasePrice";
	public static final String REPLACEMENT_PRICE="replacementPrice";
	
	public static final String PUBLIC_NOTE = "publicNote";
	public static final String PRIVATE_NOTE = "privateNote";
	
	public static CatalogItem updateProperty(CatalogItem catalogItem,HttpServletRequest request,ThemeDisplay themeDisplay)
	{
		CatalogItem item = catalogItem;
		
		
		long catalogId = ParamUtil.getLong(request, "catalogId");
		long holdingLibraryId = ParamUtil.getLong(request, HOLDING_LIBRARY_ID);
		long currentLibraryId = ParamUtil.getLong(request, CURRENT_LIBRARY_ID);
		long locationId = ParamUtil.getLong(request, "locationId");
		int copyNumber = ParamUtil.getInteger(request, COPY_NUMBER);
		long itemCategoryId = ParamUtil.getLong(request, ITEM_CATEGORY_ID);
		String barcode = ParamUtil.getString(request, BARCODE);
		String callNumber = ParamUtil.getString(request, CALL_NUMBER);
		double purchasePrice = ParamUtil.getDouble(request, PURCHASE_PRICE);
		double replacementPrice = ParamUtil.getDouble(request, REPLACEMENT_PRICE);
		
		
		String publicNote = ParamUtil.getString(request, PUBLIC_NOTE);
		String privateNote = ParamUtil.getString(request, PRIVATE_NOTE);
		boolean withdrawnStatus = ParamUtil.getBoolean(request, WITHDRAWN_STATUS);
		boolean lostStatus = ParamUtil.getBoolean(request, LOST_STATUS);
		boolean damageStatus = ParamUtil.getBoolean(request, DAMAGE_STATUS);
		boolean notForLoanStatus = ParamUtil.getBoolean(request, NOT_FOR_LOAN_STATUS);
		long itemTypeId = ParamUtil.getLong(request, ITEM_TYPE_ID);
		
		item.setHoldingLibraryId(holdingLibraryId);
		item.setCurrentLibraryId(currentLibraryId);
		item.setLocationId(locationId);
		item.setCatalogId(catalogId);
		item.setItemCategoryId(itemCategoryId);
		item.setItemTypeId(itemTypeId);
		item.setCallNumber(callNumber);
		item.setBarcode(barcode);
		item.setPurchasePrice(purchasePrice);
		item.setReplacementPrice(replacementPrice);
		item.setCopyNumber(copyNumber);
		item.setCompanyId(themeDisplay.getCompanyId());
		item.setGroupId(themeDisplay.getScopeGroupId());
		item.setLostStatus(lostStatus);
		item.setAcquiredDate(new Date());
		item.setPublicNote(publicNote);
		item.setPrivateNote(privateNote);
		
		item.setWithdrawnStatus(withdrawnStatus);
		item.setNotForLoanStatus(notForLoanStatus);
		item.setDamageStatus(damageStatus);
		
		if (Validator.isNull(item.getLastSeenDate()) || item.isNew())
		{
			Date now = new Date();
			item.setCreateDate(now);
			item.setLastSeenDate(now);
		}
		
		
		
		
		//withdrawn
		
		
		
		return item;
	}

}
