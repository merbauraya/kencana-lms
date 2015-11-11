package com.kencana.lms.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.kencana.lms.model.CatalogItem;
import com.kencana.lms.util.comparator.CatalogItemComparatorUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;

public class CatalogItemSearch extends SearchContainer<CatalogItem>
{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-accession-were-found";
	public CatalogItemSearch(PortletRequest portletRequest, PortletURL iteratorURL) 
	{
		super(
				portletRequest, new CatalogItemDisplayTerms(portletRequest),
				new CatalogItemSearchTerms(portletRequest), DEFAULT_CUR_PARAM,
				DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		
		
		CatalogItemDisplayTerms displayTerms = (CatalogItemDisplayTerms)getDisplayTerms();
		
		
		String orderByCol = ParamUtil.getString(
				portletRequest, "orderByCol");
		String orderByType = ParamUtil.getString(
				portletRequest, "orderByType");
		
		OrderByComparator orderByComparator =
				CatalogItemComparatorUtil.getComparator(orderByCol, orderByType);
		setOrderByCol(orderByCol);
		setOrderByType(orderByType);
		setOrderByComparator(orderByComparator);
		
	}

}
