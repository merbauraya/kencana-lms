package com.kencana.lms.util.comparator;

import java.util.Date;

import com.kencana.lms.model.CatalogItem;
import com.liferay.portal.kernel.util.OrderByComparator;

public class CatalogItemCatalogIdComparator extends OrderByComparator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CatalogItemCatalogIdComparator(
		boolean ascending, String orderByAsc, String orderByDesc,
		String[] orderByFields) {

		_ascending = ascending;
		_orderByAsc = orderByAsc;
		_orderByDesc = orderByDesc;
		_orderByFields = orderByFields;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		CatalogItem catalogItem1 = (CatalogItem)obj1;
		CatalogItem catalogItem2 = (CatalogItem)obj2;

		Long catalogId1 = catalogItem1.getCatalogId();
		Long catalogId2 = catalogItem2.getCatalogId();
		

		int value = catalogId1.compareTo(catalogId2);

		if (value == 0) 
		{
			Date createDate1 = catalogItem1.getCreateDate();
			Date createDate2 = catalogItem2.getCreateDate();

			value = createDate1.compareTo(createDate2);
		}

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	@Override
	public String getOrderBy() {
		if (isAscending()) {
			return _orderByAsc;
		}
		else {
			return _orderByDesc;
		}
	}

	@Override
	public String[] getOrderByFields() {
		return _orderByFields;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private boolean _ascending;
	private String _orderByAsc;
	private String _orderByDesc;
	private String[] _orderByFields;
}