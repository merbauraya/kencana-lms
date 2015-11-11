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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the circulation rule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see CirculationRulePersistenceImpl
 * @see CirculationRuleUtil
 * @generated
 */
public interface CirculationRulePersistence extends BasePersistence<CirculationRule> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CirculationRuleUtil} to access the circulation rule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the circulation rules where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching circulation rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CirculationRule> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.CirculationRule> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.CirculationRule> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first circulation rule in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching circulation rule
	* @throws com.kencana.lms.NoSuchCirculationRuleException if a matching circulation rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationRule findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first circulation rule in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching circulation rule, or <code>null</code> if a matching circulation rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationRule fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last circulation rule in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching circulation rule
	* @throws com.kencana.lms.NoSuchCirculationRuleException if a matching circulation rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationRule findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last circulation rule in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching circulation rule, or <code>null</code> if a matching circulation rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationRule fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.CirculationRule[] findByCompany_PrevAndNext(
		long circulationRuleId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the circulation rules where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of circulation rules where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching circulation rules
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the circulation rules where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching circulation rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CirculationRule> findByCompanyGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.CirculationRule> findByCompanyGroup(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.CirculationRule> findByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.CirculationRule findByCompanyGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first circulation rule in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching circulation rule, or <code>null</code> if a matching circulation rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationRule fetchByCompanyGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.CirculationRule findByCompanyGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last circulation rule in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching circulation rule, or <code>null</code> if a matching circulation rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationRule fetchByCompanyGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.CirculationRule[] findByCompanyGroup_PrevAndNext(
		long circulationRuleId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the circulation rules where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of circulation rules where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching circulation rules
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the circulation rules where companyId = &#63; and libraryId = &#63; and itemTypeId = &#63;.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param itemTypeId the item type ID
	* @return the matching circulation rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CirculationRule> findByItemType(
		long companyId, long libraryId, long itemTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.CirculationRule> findByItemType(
		long companyId, long libraryId, long itemTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.CirculationRule> findByItemType(
		long companyId, long libraryId, long itemTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.CirculationRule findByItemType_First(
		long companyId, long libraryId, long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.CirculationRule fetchByItemType_First(
		long companyId, long libraryId, long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.CirculationRule findByItemType_Last(
		long companyId, long libraryId, long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.CirculationRule fetchByItemType_Last(
		long companyId, long libraryId, long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.CirculationRule[] findByItemType_PrevAndNext(
		long circulationRuleId, long companyId, long libraryId,
		long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the circulation rules where companyId = &#63; and libraryId = &#63; and itemTypeId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param itemTypeId the item type ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByItemType(long companyId, long libraryId, long itemTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of circulation rules where companyId = &#63; and libraryId = &#63; and itemTypeId = &#63;.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param itemTypeId the item type ID
	* @return the number of matching circulation rules
	* @throws SystemException if a system exception occurred
	*/
	public int countByItemType(long companyId, long libraryId, long itemTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the circulation rules where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63;.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param patronCategoryId the patron category ID
	* @return the matching circulation rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CirculationRule> findByPatronCategory(
		long companyId, long libraryId, long patronCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.CirculationRule> findByPatronCategory(
		long companyId, long libraryId, long patronCategoryId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.CirculationRule> findByPatronCategory(
		long companyId, long libraryId, long patronCategoryId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.CirculationRule findByPatronCategory_First(
		long companyId, long libraryId, long patronCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.CirculationRule fetchByPatronCategory_First(
		long companyId, long libraryId, long patronCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.CirculationRule findByPatronCategory_Last(
		long companyId, long libraryId, long patronCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.CirculationRule fetchByPatronCategory_Last(
		long companyId, long libraryId, long patronCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.CirculationRule[] findByPatronCategory_PrevAndNext(
		long circulationRuleId, long companyId, long libraryId,
		long patronCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the circulation rules where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param patronCategoryId the patron category ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPatronCategory(long companyId, long libraryId,
		long patronCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of circulation rules where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63;.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param patronCategoryId the patron category ID
	* @return the number of matching circulation rules
	* @throws SystemException if a system exception occurred
	*/
	public int countByPatronCategory(long companyId, long libraryId,
		long patronCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.CirculationRule> findByItemTypePatronCategory(
		long companyId, long libraryId, long patronCategoryId, long itemTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.CirculationRule> findByItemTypePatronCategory(
		long companyId, long libraryId, long patronCategoryId, long itemTypeId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.CirculationRule> findByItemTypePatronCategory(
		long companyId, long libraryId, long patronCategoryId, long itemTypeId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.CirculationRule findByItemTypePatronCategory_First(
		long companyId, long libraryId, long patronCategoryId, long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.CirculationRule fetchByItemTypePatronCategory_First(
		long companyId, long libraryId, long patronCategoryId, long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.CirculationRule findByItemTypePatronCategory_Last(
		long companyId, long libraryId, long patronCategoryId, long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.CirculationRule fetchByItemTypePatronCategory_Last(
		long companyId, long libraryId, long patronCategoryId, long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.CirculationRule[] findByItemTypePatronCategory_PrevAndNext(
		long circulationRuleId, long companyId, long libraryId,
		long patronCategoryId, long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the circulation rules where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63; and itemTypeId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param patronCategoryId the patron category ID
	* @param itemTypeId the item type ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByItemTypePatronCategory(long companyId, long libraryId,
		long patronCategoryId, long itemTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByItemTypePatronCategory(long companyId, long libraryId,
		long patronCategoryId, long itemTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.CirculationRule findByCirculationRule(
		long companyId, long patronCategoryId, long itemTypeId,
		long itemCategoryId)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.CirculationRule fetchByCirculationRule(
		long companyId, long patronCategoryId, long itemTypeId,
		long itemCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.CirculationRule fetchByCirculationRule(
		long companyId, long patronCategoryId, long itemTypeId,
		long itemCategoryId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.CirculationRule removeByCirculationRule(
		long companyId, long patronCategoryId, long itemTypeId,
		long itemCategoryId)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public int countByCirculationRule(long companyId, long patronCategoryId,
		long itemTypeId, long itemCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the circulation rule in the entity cache if it is enabled.
	*
	* @param circulationRule the circulation rule
	*/
	public void cacheResult(
		com.kencana.lms.model.CirculationRule circulationRule);

	/**
	* Caches the circulation rules in the entity cache if it is enabled.
	*
	* @param circulationRules the circulation rules
	*/
	public void cacheResult(
		java.util.List<com.kencana.lms.model.CirculationRule> circulationRules);

	/**
	* Creates a new circulation rule with the primary key. Does not add the circulation rule to the database.
	*
	* @param circulationRuleId the primary key for the new circulation rule
	* @return the new circulation rule
	*/
	public com.kencana.lms.model.CirculationRule create(long circulationRuleId);

	/**
	* Removes the circulation rule with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param circulationRuleId the primary key of the circulation rule
	* @return the circulation rule that was removed
	* @throws com.kencana.lms.NoSuchCirculationRuleException if a circulation rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationRule remove(long circulationRuleId)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.kencana.lms.model.CirculationRule updateImpl(
		com.kencana.lms.model.CirculationRule circulationRule)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the circulation rule with the primary key or throws a {@link com.kencana.lms.NoSuchCirculationRuleException} if it could not be found.
	*
	* @param circulationRuleId the primary key of the circulation rule
	* @return the circulation rule
	* @throws com.kencana.lms.NoSuchCirculationRuleException if a circulation rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationRule findByPrimaryKey(
		long circulationRuleId)
		throws com.kencana.lms.NoSuchCirculationRuleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the circulation rule with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param circulationRuleId the primary key of the circulation rule
	* @return the circulation rule, or <code>null</code> if a circulation rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationRule fetchByPrimaryKey(
		long circulationRuleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the circulation rules.
	*
	* @return the circulation rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CirculationRule> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.CirculationRule> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.CirculationRule> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the circulation rules from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of circulation rules.
	*
	* @return the number of circulation rules
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}