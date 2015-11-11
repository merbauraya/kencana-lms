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

package com.kencana.lms.service.persistence;

import com.kencana.lms.model.CirculationRule;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the circulation rule service. This utility wraps {@link CirculationRulePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see CirculationRulePersistence
 * @see CirculationRulePersistenceImpl
 * @generated
 */
public class CirculationRuleUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(CirculationRule circulationRule) {
		getPersistence().clearCache(circulationRule);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CirculationRule> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CirculationRule> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CirculationRule> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CirculationRule update(CirculationRule circulationRule)
		throws SystemException {
		return getPersistence().update(circulationRule);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CirculationRule update(CirculationRule circulationRule,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(circulationRule, serviceContext);
	}

	/**
	* Returns all the circulation rules where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching circulation rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CirculationRule> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

	/**
	* Returns a range of all the circulation rules where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of circulation rules
	* @param end the upper bound of the range of circulation rules (not inclusive)
	* @return the range of matching circulation rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CirculationRule> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the circulation rules where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of circulation rules
	* @param end the upper bound of the range of circulation rules (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching circulation rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CirculationRule> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first circulation rule in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching circulation rule
	* @throws com.kencana.lms.NoSuchCirculationRuleException if a matching circulation rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CirculationRule findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first circulation rule in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching circulation rule, or <code>null</code> if a matching circulation rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CirculationRule fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last circulation rule in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching circulation rule
	* @throws com.kencana.lms.NoSuchCirculationRuleException if a matching circulation rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CirculationRule findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last circulation rule in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching circulation rule, or <code>null</code> if a matching circulation rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CirculationRule fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the circulation rules before and after the current circulation rule in the ordered set where companyId = &#63;.
	*
	* @param circulationRuleId the primary key of the current circulation rule
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next circulation rule
	* @throws com.kencana.lms.NoSuchCirculationRuleException if a circulation rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CirculationRule[] findByCompany_PrevAndNext(
		long circulationRuleId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany_PrevAndNext(circulationRuleId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the circulation rules where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Returns the number of circulation rules where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching circulation rules
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns all the circulation rules where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching circulation rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CirculationRule> findByCompanyGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyGroup(companyId, groupId);
	}

	/**
	* Returns a range of all the circulation rules where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of circulation rules
	* @param end the upper bound of the range of circulation rules (not inclusive)
	* @return the range of matching circulation rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CirculationRule> findByCompanyGroup(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyGroup(companyId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the circulation rules where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of circulation rules
	* @param end the upper bound of the range of circulation rules (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching circulation rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CirculationRule> findByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyGroup(companyId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first circulation rule in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching circulation rule
	* @throws com.kencana.lms.NoSuchCirculationRuleException if a matching circulation rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CirculationRule findByCompanyGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyGroup_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first circulation rule in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching circulation rule, or <code>null</code> if a matching circulation rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CirculationRule fetchByCompanyGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyGroup_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last circulation rule in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching circulation rule
	* @throws com.kencana.lms.NoSuchCirculationRuleException if a matching circulation rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CirculationRule findByCompanyGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyGroup_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last circulation rule in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching circulation rule, or <code>null</code> if a matching circulation rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CirculationRule fetchByCompanyGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyGroup_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the circulation rules before and after the current circulation rule in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param circulationRuleId the primary key of the current circulation rule
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next circulation rule
	* @throws com.kencana.lms.NoSuchCirculationRuleException if a circulation rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CirculationRule[] findByCompanyGroup_PrevAndNext(
		long circulationRuleId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyGroup_PrevAndNext(circulationRuleId,
			companyId, groupId, orderByComparator);
	}

	/**
	* Removes all the circulation rules where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyGroup(companyId, groupId);
	}

	/**
	* Returns the number of circulation rules where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching circulation rules
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyGroup(companyId, groupId);
	}

	/**
	* Returns all the circulation rules where companyId = &#63; and libraryId = &#63; and itemTypeId = &#63;.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param itemTypeId the item type ID
	* @return the matching circulation rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CirculationRule> findByItemType(
		long companyId, long libraryId, long itemTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByItemType(companyId, libraryId, itemTypeId);
	}

	/**
	* Returns a range of all the circulation rules where companyId = &#63; and libraryId = &#63; and itemTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param itemTypeId the item type ID
	* @param start the lower bound of the range of circulation rules
	* @param end the upper bound of the range of circulation rules (not inclusive)
	* @return the range of matching circulation rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CirculationRule> findByItemType(
		long companyId, long libraryId, long itemTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByItemType(companyId, libraryId, itemTypeId, start, end);
	}

	/**
	* Returns an ordered range of all the circulation rules where companyId = &#63; and libraryId = &#63; and itemTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param itemTypeId the item type ID
	* @param start the lower bound of the range of circulation rules
	* @param end the upper bound of the range of circulation rules (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching circulation rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CirculationRule> findByItemType(
		long companyId, long libraryId, long itemTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByItemType(companyId, libraryId, itemTypeId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first circulation rule in the ordered set where companyId = &#63; and libraryId = &#63; and itemTypeId = &#63;.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param itemTypeId the item type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching circulation rule
	* @throws com.kencana.lms.NoSuchCirculationRuleException if a matching circulation rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CirculationRule findByItemType_First(
		long companyId, long libraryId, long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByItemType_First(companyId, libraryId, itemTypeId,
			orderByComparator);
	}

	/**
	* Returns the first circulation rule in the ordered set where companyId = &#63; and libraryId = &#63; and itemTypeId = &#63;.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param itemTypeId the item type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching circulation rule, or <code>null</code> if a matching circulation rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CirculationRule fetchByItemType_First(
		long companyId, long libraryId, long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByItemType_First(companyId, libraryId, itemTypeId,
			orderByComparator);
	}

	/**
	* Returns the last circulation rule in the ordered set where companyId = &#63; and libraryId = &#63; and itemTypeId = &#63;.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param itemTypeId the item type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching circulation rule
	* @throws com.kencana.lms.NoSuchCirculationRuleException if a matching circulation rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CirculationRule findByItemType_Last(
		long companyId, long libraryId, long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByItemType_Last(companyId, libraryId, itemTypeId,
			orderByComparator);
	}

	/**
	* Returns the last circulation rule in the ordered set where companyId = &#63; and libraryId = &#63; and itemTypeId = &#63;.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param itemTypeId the item type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching circulation rule, or <code>null</code> if a matching circulation rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CirculationRule fetchByItemType_Last(
		long companyId, long libraryId, long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByItemType_Last(companyId, libraryId, itemTypeId,
			orderByComparator);
	}

	/**
	* Returns the circulation rules before and after the current circulation rule in the ordered set where companyId = &#63; and libraryId = &#63; and itemTypeId = &#63;.
	*
	* @param circulationRuleId the primary key of the current circulation rule
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param itemTypeId the item type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next circulation rule
	* @throws com.kencana.lms.NoSuchCirculationRuleException if a circulation rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CirculationRule[] findByItemType_PrevAndNext(
		long circulationRuleId, long companyId, long libraryId,
		long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByItemType_PrevAndNext(circulationRuleId, companyId,
			libraryId, itemTypeId, orderByComparator);
	}

	/**
	* Removes all the circulation rules where companyId = &#63; and libraryId = &#63; and itemTypeId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param itemTypeId the item type ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByItemType(long companyId, long libraryId,
		long itemTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByItemType(companyId, libraryId, itemTypeId);
	}

	/**
	* Returns the number of circulation rules where companyId = &#63; and libraryId = &#63; and itemTypeId = &#63;.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param itemTypeId the item type ID
	* @return the number of matching circulation rules
	* @throws SystemException if a system exception occurred
	*/
	public static int countByItemType(long companyId, long libraryId,
		long itemTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByItemType(companyId, libraryId, itemTypeId);
	}

	/**
	* Returns all the circulation rules where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63;.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param patronCategoryId the patron category ID
	* @return the matching circulation rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CirculationRule> findByPatronCategory(
		long companyId, long libraryId, long patronCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPatronCategory(companyId, libraryId, patronCategoryId);
	}

	/**
	* Returns a range of all the circulation rules where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param patronCategoryId the patron category ID
	* @param start the lower bound of the range of circulation rules
	* @param end the upper bound of the range of circulation rules (not inclusive)
	* @return the range of matching circulation rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CirculationRule> findByPatronCategory(
		long companyId, long libraryId, long patronCategoryId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPatronCategory(companyId, libraryId,
			patronCategoryId, start, end);
	}

	/**
	* Returns an ordered range of all the circulation rules where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param patronCategoryId the patron category ID
	* @param start the lower bound of the range of circulation rules
	* @param end the upper bound of the range of circulation rules (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching circulation rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CirculationRule> findByPatronCategory(
		long companyId, long libraryId, long patronCategoryId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPatronCategory(companyId, libraryId,
			patronCategoryId, start, end, orderByComparator);
	}

	/**
	* Returns the first circulation rule in the ordered set where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63;.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param patronCategoryId the patron category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching circulation rule
	* @throws com.kencana.lms.NoSuchCirculationRuleException if a matching circulation rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CirculationRule findByPatronCategory_First(
		long companyId, long libraryId, long patronCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPatronCategory_First(companyId, libraryId,
			patronCategoryId, orderByComparator);
	}

	/**
	* Returns the first circulation rule in the ordered set where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63;.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param patronCategoryId the patron category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching circulation rule, or <code>null</code> if a matching circulation rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CirculationRule fetchByPatronCategory_First(
		long companyId, long libraryId, long patronCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPatronCategory_First(companyId, libraryId,
			patronCategoryId, orderByComparator);
	}

	/**
	* Returns the last circulation rule in the ordered set where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63;.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param patronCategoryId the patron category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching circulation rule
	* @throws com.kencana.lms.NoSuchCirculationRuleException if a matching circulation rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CirculationRule findByPatronCategory_Last(
		long companyId, long libraryId, long patronCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPatronCategory_Last(companyId, libraryId,
			patronCategoryId, orderByComparator);
	}

	/**
	* Returns the last circulation rule in the ordered set where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63;.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param patronCategoryId the patron category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching circulation rule, or <code>null</code> if a matching circulation rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CirculationRule fetchByPatronCategory_Last(
		long companyId, long libraryId, long patronCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPatronCategory_Last(companyId, libraryId,
			patronCategoryId, orderByComparator);
	}

	/**
	* Returns the circulation rules before and after the current circulation rule in the ordered set where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63;.
	*
	* @param circulationRuleId the primary key of the current circulation rule
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param patronCategoryId the patron category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next circulation rule
	* @throws com.kencana.lms.NoSuchCirculationRuleException if a circulation rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CirculationRule[] findByPatronCategory_PrevAndNext(
		long circulationRuleId, long companyId, long libraryId,
		long patronCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPatronCategory_PrevAndNext(circulationRuleId,
			companyId, libraryId, patronCategoryId, orderByComparator);
	}

	/**
	* Removes all the circulation rules where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param patronCategoryId the patron category ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPatronCategory(long companyId, long libraryId,
		long patronCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByPatronCategory(companyId, libraryId, patronCategoryId);
	}

	/**
	* Returns the number of circulation rules where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63;.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param patronCategoryId the patron category ID
	* @return the number of matching circulation rules
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPatronCategory(long companyId, long libraryId,
		long patronCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByPatronCategory(companyId, libraryId, patronCategoryId);
	}

	/**
	* Returns all the circulation rules where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63; and itemTypeId = &#63;.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param patronCategoryId the patron category ID
	* @param itemTypeId the item type ID
	* @return the matching circulation rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CirculationRule> findByItemTypePatronCategory(
		long companyId, long libraryId, long patronCategoryId, long itemTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByItemTypePatronCategory(companyId, libraryId,
			patronCategoryId, itemTypeId);
	}

	/**
	* Returns a range of all the circulation rules where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63; and itemTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param patronCategoryId the patron category ID
	* @param itemTypeId the item type ID
	* @param start the lower bound of the range of circulation rules
	* @param end the upper bound of the range of circulation rules (not inclusive)
	* @return the range of matching circulation rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CirculationRule> findByItemTypePatronCategory(
		long companyId, long libraryId, long patronCategoryId, long itemTypeId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByItemTypePatronCategory(companyId, libraryId,
			patronCategoryId, itemTypeId, start, end);
	}

	/**
	* Returns an ordered range of all the circulation rules where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63; and itemTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param patronCategoryId the patron category ID
	* @param itemTypeId the item type ID
	* @param start the lower bound of the range of circulation rules
	* @param end the upper bound of the range of circulation rules (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching circulation rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CirculationRule> findByItemTypePatronCategory(
		long companyId, long libraryId, long patronCategoryId, long itemTypeId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByItemTypePatronCategory(companyId, libraryId,
			patronCategoryId, itemTypeId, start, end, orderByComparator);
	}

	/**
	* Returns the first circulation rule in the ordered set where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63; and itemTypeId = &#63;.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param patronCategoryId the patron category ID
	* @param itemTypeId the item type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching circulation rule
	* @throws com.kencana.lms.NoSuchCirculationRuleException if a matching circulation rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CirculationRule findByItemTypePatronCategory_First(
		long companyId, long libraryId, long patronCategoryId, long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByItemTypePatronCategory_First(companyId, libraryId,
			patronCategoryId, itemTypeId, orderByComparator);
	}

	/**
	* Returns the first circulation rule in the ordered set where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63; and itemTypeId = &#63;.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param patronCategoryId the patron category ID
	* @param itemTypeId the item type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching circulation rule, or <code>null</code> if a matching circulation rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CirculationRule fetchByItemTypePatronCategory_First(
		long companyId, long libraryId, long patronCategoryId, long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByItemTypePatronCategory_First(companyId, libraryId,
			patronCategoryId, itemTypeId, orderByComparator);
	}

	/**
	* Returns the last circulation rule in the ordered set where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63; and itemTypeId = &#63;.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param patronCategoryId the patron category ID
	* @param itemTypeId the item type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching circulation rule
	* @throws com.kencana.lms.NoSuchCirculationRuleException if a matching circulation rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CirculationRule findByItemTypePatronCategory_Last(
		long companyId, long libraryId, long patronCategoryId, long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByItemTypePatronCategory_Last(companyId, libraryId,
			patronCategoryId, itemTypeId, orderByComparator);
	}

	/**
	* Returns the last circulation rule in the ordered set where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63; and itemTypeId = &#63;.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param patronCategoryId the patron category ID
	* @param itemTypeId the item type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching circulation rule, or <code>null</code> if a matching circulation rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CirculationRule fetchByItemTypePatronCategory_Last(
		long companyId, long libraryId, long patronCategoryId, long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByItemTypePatronCategory_Last(companyId, libraryId,
			patronCategoryId, itemTypeId, orderByComparator);
	}

	/**
	* Returns the circulation rules before and after the current circulation rule in the ordered set where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63; and itemTypeId = &#63;.
	*
	* @param circulationRuleId the primary key of the current circulation rule
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param patronCategoryId the patron category ID
	* @param itemTypeId the item type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next circulation rule
	* @throws com.kencana.lms.NoSuchCirculationRuleException if a circulation rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CirculationRule[] findByItemTypePatronCategory_PrevAndNext(
		long circulationRuleId, long companyId, long libraryId,
		long patronCategoryId, long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByItemTypePatronCategory_PrevAndNext(circulationRuleId,
			companyId, libraryId, patronCategoryId, itemTypeId,
			orderByComparator);
	}

	/**
	* Removes all the circulation rules where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63; and itemTypeId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param patronCategoryId the patron category ID
	* @param itemTypeId the item type ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByItemTypePatronCategory(long companyId,
		long libraryId, long patronCategoryId, long itemTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByItemTypePatronCategory(companyId, libraryId,
			patronCategoryId, itemTypeId);
	}

	/**
	* Returns the number of circulation rules where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63; and itemTypeId = &#63;.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param patronCategoryId the patron category ID
	* @param itemTypeId the item type ID
	* @return the number of matching circulation rules
	* @throws SystemException if a system exception occurred
	*/
	public static int countByItemTypePatronCategory(long companyId,
		long libraryId, long patronCategoryId, long itemTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByItemTypePatronCategory(companyId, libraryId,
			patronCategoryId, itemTypeId);
	}

	/**
	* Returns the circulation rule where companyId = &#63; and patronCategoryId = &#63; and itemTypeId = &#63; and itemCategoryId = &#63; or throws a {@link com.kencana.lms.NoSuchCirculationRuleException} if it could not be found.
	*
	* @param companyId the company ID
	* @param patronCategoryId the patron category ID
	* @param itemTypeId the item type ID
	* @param itemCategoryId the item category ID
	* @return the matching circulation rule
	* @throws com.kencana.lms.NoSuchCirculationRuleException if a matching circulation rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CirculationRule findByCirculationRule(
		long companyId, long patronCategoryId, long itemTypeId,
		long itemCategoryId)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCirculationRule(companyId, patronCategoryId,
			itemTypeId, itemCategoryId);
	}

	/**
	* Returns the circulation rule where companyId = &#63; and patronCategoryId = &#63; and itemTypeId = &#63; and itemCategoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param patronCategoryId the patron category ID
	* @param itemTypeId the item type ID
	* @param itemCategoryId the item category ID
	* @return the matching circulation rule, or <code>null</code> if a matching circulation rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CirculationRule fetchByCirculationRule(
		long companyId, long patronCategoryId, long itemTypeId,
		long itemCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCirculationRule(companyId, patronCategoryId,
			itemTypeId, itemCategoryId);
	}

	/**
	* Returns the circulation rule where companyId = &#63; and patronCategoryId = &#63; and itemTypeId = &#63; and itemCategoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param patronCategoryId the patron category ID
	* @param itemTypeId the item type ID
	* @param itemCategoryId the item category ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching circulation rule, or <code>null</code> if a matching circulation rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CirculationRule fetchByCirculationRule(
		long companyId, long patronCategoryId, long itemTypeId,
		long itemCategoryId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCirculationRule(companyId, patronCategoryId,
			itemTypeId, itemCategoryId, retrieveFromCache);
	}

	/**
	* Removes the circulation rule where companyId = &#63; and patronCategoryId = &#63; and itemTypeId = &#63; and itemCategoryId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param patronCategoryId the patron category ID
	* @param itemTypeId the item type ID
	* @param itemCategoryId the item category ID
	* @return the circulation rule that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CirculationRule removeByCirculationRule(
		long companyId, long patronCategoryId, long itemTypeId,
		long itemCategoryId)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByCirculationRule(companyId, patronCategoryId,
			itemTypeId, itemCategoryId);
	}

	/**
	* Returns the number of circulation rules where companyId = &#63; and patronCategoryId = &#63; and itemTypeId = &#63; and itemCategoryId = &#63;.
	*
	* @param companyId the company ID
	* @param patronCategoryId the patron category ID
	* @param itemTypeId the item type ID
	* @param itemCategoryId the item category ID
	* @return the number of matching circulation rules
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCirculationRule(long companyId,
		long patronCategoryId, long itemTypeId, long itemCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCirculationRule(companyId, patronCategoryId,
			itemTypeId, itemCategoryId);
	}

	/**
	* Caches the circulation rule in the entity cache if it is enabled.
	*
	* @param circulationRule the circulation rule
	*/
	public static void cacheResult(
		com.kencana.lms.model.CirculationRule circulationRule) {
		getPersistence().cacheResult(circulationRule);
	}

	/**
	* Caches the circulation rules in the entity cache if it is enabled.
	*
	* @param circulationRules the circulation rules
	*/
	public static void cacheResult(
		java.util.List<com.kencana.lms.model.CirculationRule> circulationRules) {
		getPersistence().cacheResult(circulationRules);
	}

	/**
	* Creates a new circulation rule with the primary key. Does not add the circulation rule to the database.
	*
	* @param circulationRuleId the primary key for the new circulation rule
	* @return the new circulation rule
	*/
	public static com.kencana.lms.model.CirculationRule create(
		long circulationRuleId) {
		return getPersistence().create(circulationRuleId);
	}

	/**
	* Removes the circulation rule with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param circulationRuleId the primary key of the circulation rule
	* @return the circulation rule that was removed
	* @throws com.kencana.lms.NoSuchCirculationRuleException if a circulation rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CirculationRule remove(
		long circulationRuleId)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(circulationRuleId);
	}

	public static com.kencana.lms.model.CirculationRule updateImpl(
		com.kencana.lms.model.CirculationRule circulationRule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(circulationRule);
	}

	/**
	* Returns the circulation rule with the primary key or throws a {@link com.kencana.lms.NoSuchCirculationRuleException} if it could not be found.
	*
	* @param circulationRuleId the primary key of the circulation rule
	* @return the circulation rule
	* @throws com.kencana.lms.NoSuchCirculationRuleException if a circulation rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CirculationRule findByPrimaryKey(
		long circulationRuleId)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(circulationRuleId);
	}

	/**
	* Returns the circulation rule with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param circulationRuleId the primary key of the circulation rule
	* @return the circulation rule, or <code>null</code> if a circulation rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CirculationRule fetchByPrimaryKey(
		long circulationRuleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(circulationRuleId);
	}

	/**
	* Returns all the circulation rules.
	*
	* @return the circulation rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CirculationRule> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the circulation rules.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of circulation rules
	* @param end the upper bound of the range of circulation rules (not inclusive)
	* @return the range of circulation rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CirculationRule> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the circulation rules.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of circulation rules
	* @param end the upper bound of the range of circulation rules (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of circulation rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CirculationRule> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the circulation rules from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of circulation rules.
	*
	* @return the number of circulation rules
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CirculationRulePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CirculationRulePersistence)PortletBeanLocatorUtil.locate(com.kencana.lms.service.ClpSerializer.getServletContextName(),
					CirculationRulePersistence.class.getName());

			ReferenceRegistry.registerReference(CirculationRuleUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CirculationRulePersistence persistence) {
	}

	private static CirculationRulePersistence _persistence;
}