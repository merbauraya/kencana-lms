package com.kencana.lms.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;

public class CatalogItemComparatorUtil 
{

	
	public static OrderByComparator getCreateDateComparator(boolean ascending) {
		return new CatalogItemCreateDateComparator(
				ascending, "createDate ASC, catalogItemId ASC",
				"createDate DESC, catalogItemId DESC",
				new String[] {"createDate", "catalogItemId"});
	}

	
	public static OrderByComparator getCatalogIdComparator(boolean ascending) {
		
		return new CatalogItemCatalogIdComparator(
				ascending, "catalogId ASC, createDate ASC",
				"catalogId DESC, createDate DESC",
				new String[] {"catalogId", "createDate"});
	}
	
public static OrderByComparator getCatalogTitleComparator(boolean ascending) {
		
		return new CatalogItemCatalogIdComparator(
				ascending, "catalogTitle ASC, createDate ASC",
				"catalogTitle DESC, createDate DESC",
				new String[] {"catalogTitle", "createDate"});
	}

	
	public static OrderByComparator getComparator(String orderByCol, String orderByType) {
		
		boolean orderByAsc = false;
		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}
		if (orderByCol.equals("createDate")){
			return getCreateDateComparator(orderByAsc);
			
		}else if (orderByCol.equals("catalogId"))
		{
			return getCatalogIdComparator(orderByAsc);
		}else if (orderByCol.equals("title"))
		{
			return getCatalogTitleComparator(orderByAsc);
		}else
		{
			return getCreateDateComparator(orderByAsc);
		}
	}

}
