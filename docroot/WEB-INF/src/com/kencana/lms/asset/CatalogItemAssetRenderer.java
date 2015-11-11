package com.kencana.lms.asset;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.kencana.lms.model.CatalogItem;
import com.liferay.portlet.asset.model.BaseAssetRenderer;



public class CatalogItemAssetRenderer extends BaseAssetRenderer 
{
	private CatalogItem _catalogItem;
	
	public CatalogItemAssetRenderer(CatalogItem catalogItem)
	{
		_catalogItem = catalogItem;
	}

	@Override
	public String getClassName() {
		
		return CLASS_NAME;
		
	}

	@Override
	public long getClassPK() {
		return _catalogItem.getCatalogItemId();
	}

	@Override
	public long getGroupId() {

		return _catalogItem.getGroupId();
	}

	@Override
	public String getSummary(Locale arg0) {
		
		return null;
	}

	@Override
	public String getTitle(Locale arg0) {
		
		return null;
	}

	@Override
	public long getUserId() {

		return _catalogItem.getUserId();
		
	}

	@Override
	public String getUserName() {
		return _catalogItem.getUserName();
	}

	@Override
	public String getUuid() {
		
		return null;
		
	}

	@Override
	public String render(RenderRequest arg0, RenderResponse arg1, String arg2)
			throws Exception {
		
		return null;
	}
	
	protected static String CLASS_NAME = CatalogItem.class.getName();

}
