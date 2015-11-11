/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.kencana.lms.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.kencana.lms.NoSuchPatronException;
import com.kencana.lms.model.Patron;
import com.kencana.lms.service.base.PatronLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.QueryConfig;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;

/**
 * The implementation of the patron local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.kencana.lms.service.PatronLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.kencana.lms.service.base.PatronLocalServiceBaseImpl
 * @see com.kencana.lms.service.PatronLocalServiceUtil
 */
public class PatronLocalServiceImpl extends PatronLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.kencana.lms.service.PatronLocalServiceUtil} to access the patron local service.
	 */
	
	
	public Hits search(
			long companyId, String keywords, int status,
			LinkedHashMap<String, Object> params, int start, int end, Sort sort)
		throws SystemException {

		String firstName = null;
		String middleName = null;
		String lastName = null;
		String fullName = null;
		String screenName = null;
		String emailAddress = null;
		String street = null;
		String city = null;
		String zip = null;
		String region = null;
		String country = null;
		String cardNumber = null;
		boolean andOperator = false;

		if (Validator.isNotNull(keywords)) {
			firstName = keywords;
			middleName = keywords;
			lastName = keywords;
			fullName = keywords;
			screenName = keywords;
			emailAddress = keywords;
			street = keywords;
			city = keywords;
			zip = keywords;
			region = keywords;
			country = keywords;
			cardNumber = keywords;
		}
		else {
			andOperator = true;
		}

		if (params != null) {
			params.put("keywords", keywords);
		}

		return search(
			companyId, firstName, middleName, lastName, fullName, screenName,
			emailAddress, street, city, zip, region, country, status, cardNumber,
			params,
			andOperator, start, end, sort);
	}
	
	protected Hits search(
			long companyId, String firstName, String middleName,
			String lastName, String fullName, String screenName,
			String emailAddress, String street, String city, String zip,
			String region, String country, int status, String cardNumber,
			LinkedHashMap<String, Object> params, boolean andSearch, int start,
			int end, Sort sort)
		throws SystemException {

		try {
			SearchContext searchContext = new SearchContext();

			searchContext.setAndSearch(andSearch);

			Map<String, Serializable> attributes =
				new HashMap<String, Serializable>();

			attributes.put("city", city);
			attributes.put("country", country);
			attributes.put("emailAddress", emailAddress);
			attributes.put("firstName", firstName);
			attributes.put("fullName", fullName);
			attributes.put("lastName", lastName);
			attributes.put("middleName", middleName);
			attributes.put("params", params);
			attributes.put("region", region);
			attributes.put("screenName", screenName);
			attributes.put("street", street);
			attributes.put("status", status);
			attributes.put("zip", zip);
			attributes.put("cardNumber", cardNumber);

			searchContext.setAttributes(attributes);

			searchContext.setCompanyId(companyId);
			searchContext.setEnd(end);

			if (params != null) {
				String keywords = (String)params.remove("keywords");

				if (Validator.isNotNull(keywords)) {
					searchContext.setKeywords(keywords);
				}
			}

			QueryConfig queryConfig = new QueryConfig();

			queryConfig.setHighlightEnabled(false);
			queryConfig.setScoreEnabled(false);

			searchContext.setQueryConfig(queryConfig);

			if (sort != null) {
				searchContext.setSorts(sort);
			}

			searchContext.setStart(start);

			Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
				User.class);

			return indexer.search(searchContext);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}
	
	public Patron findByCardNumber(String cardNumber) throws NoSuchPatronException, SystemException
	{
		return patronPersistence.findByCardNumber(cardNumber);
	}
	
	public Patron safeFindByUserId(long userId) throws SystemException
	{
		Patron patron = null;
		try {
			patron = patronPersistence.findByUserId(userId);
		} catch (NoSuchPatronException e) {
			//long patronId = CounterLocalServiceUtil.increment(Patron.class.getName());
			patron = patronPersistence.create(userId);
			patron.setUserId(userId);
		} 
		
		return patron;
	}
	public Patron findByUserId(long userId) throws NoSuchPatronException, SystemException
	{
		return patronPersistence.findByUserId(userId);
	}
	
}