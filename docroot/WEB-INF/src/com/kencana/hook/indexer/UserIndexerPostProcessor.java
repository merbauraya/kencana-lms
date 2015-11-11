package com.kencana.hook.indexer;

import java.util.LinkedHashMap;
import java.util.List;

import com.kencana.lms.model.Patron;
import com.kencana.lms.service.PatronLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexerPostProcessor;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;


public class UserIndexerPostProcessor extends BaseIndexerPostProcessor {
	Log LOGGER = LogFactoryUtil.getLog(UserIndexerPostProcessor.class);
	
	@Override
	public void postProcessContextQuery(
			BooleanQuery contextQuery, SearchContext searchContext)
		throws Exception {
		
		LinkedHashMap<String, Object> params =
			(LinkedHashMap<String, Object>)searchContext.getAttribute("params");

		if (params != null) {
			Object cardNumber = params.get("cardNumber");
			//Object expertise = params.get("expertise");

			if (Validator.isNotNull(cardNumber)) {
				contextQuery.addRequiredTerm(
					"cardNumber", String.valueOf(cardNumber), true);
			}
			
		}
	}

	@Override
	public void postProcessDocument(Document document, Object obj)
		throws Exception {
		
		User user = (User)obj;
		
		try {
			Patron patron = PatronLocalServiceUtil.findByUserId(user.getUserId());
			document.addText("cardNumber",patron.getCardNumber());
			document.addKeyword("patronCategoryId", patron.getPatronCategoryId());
			document.addKeyword("patronStatusId", patron.getPatronStatusId());
			document.addKeyword("libraryId", patron.getLibraryId());
		} catch (Exception ex)
		{}
		
		
		
		
		
		LOGGER.info("postProcessDocument");

	}

	@Override
	public void postProcessSearchQuery(
			BooleanQuery searchQuery, SearchContext searchContext)
		throws Exception {

		String keywords = searchContext.getKeywords();
		
		if (Validator.isNotNull(keywords)) {
			searchQuery.addTerm("cardNumber", keywords, true);
			
			
		}
	}
}