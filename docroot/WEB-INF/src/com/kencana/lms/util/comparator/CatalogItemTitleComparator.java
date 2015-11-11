package com.kencana.lms.util.comparator;

import java.util.Date;

import com.kencana.lms.model.CatalogItem;
import com.liferay.portal.kernel.util.OrderByComparator;

public class CatalogItemTitleComparator extends OrderByComparator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CatalogItemTitleComparator(
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

		String title1 = catalogItem1.getCatalogTitle();
		String title2 = catalogItem2.getCatalogTitle();
		

		int value = title1.compareTo(title2);

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