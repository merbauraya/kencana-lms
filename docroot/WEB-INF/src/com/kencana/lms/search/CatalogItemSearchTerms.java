package com.kencana.lms.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.util.Validator;

public class CatalogItemSearchTerms extends CatalogItemDisplayTerms
{

	public CatalogItemSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);
		
		
	}
	public boolean hasSearchTerms() {
		if (isAdvancedSearch()) {
			if (Validator.isNotNull(catalogItemId) || Validator.isNotNull(title)) {
				return true;
			}
		}
		else {
			if (Validator.isNotNull(keywords)) {
				return true;
			}
		}

		return false;
	}


}
