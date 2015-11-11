package com.kencana.lms.util.comparator;

import java.util.Date;

import com.kencana.lms.model.CatalogItem;
import com.liferay.portal.kernel.util.OrderByComparator;

public class CatalogItemCreateDateComparator extends OrderByComparator {

	public CatalogItemCreateDateComparator(
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

		Date createDate1 = catalogItem1.getCreateDate();
		Date createDate2 = catalogItem2.getCreateDate();

		int value = createDate1.compareTo(createDate2);

		if (value == 0) {
			Long catalogItemId1 = catalogItem1.getCatalogItemId();
			Long catalogItemId2 = catalogItem2.getCatalogItemId();

			value = catalogItemId1.compareTo(catalogItemId2);
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