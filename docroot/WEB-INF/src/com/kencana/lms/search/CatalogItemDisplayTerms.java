package com.kencana.lms.search;

import java.util.Date;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;

public class CatalogItemDisplayTerms extends DisplayTerms
{
	protected long catalogItemId;
	protected String title;
	protected Date createDate;
	
	
	public CatalogItemDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		
		catalogItemId = ParamUtil.getLong(portletRequest, "catalogItemId");
		title = ParamUtil.getString(portletRequest, "catalogTitle");
		createDate = ParamUtil.getDate(portletRequest, "createDate", DateFormatFactoryUtil.getSimpleDateFormat("yyyy.MM.dd"));
		
	}
	public long getCatalogItemId()
	{
		return catalogItemId;
	}
	public String getTitle()
	{
		return title;
	}
	public Date getCreateDate()
	{
		return createDate;
	}

}
