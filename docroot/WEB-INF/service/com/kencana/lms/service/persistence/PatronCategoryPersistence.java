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

import com.kencana.lms.model.PatronCategory;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the patron category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see PatronCategoryPersistenceImpl
 * @see PatronCategoryUtil
 * @generated
 */
public interface PatronCategoryPersistence extends BasePersistence<PatronCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PatronCategoryUtil} to access the patron category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the patron categories where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching patron categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.PatronCategory> findByCompanyGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the patron categories where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of patron categories
	* @param end the upper bound of the range of patron categories (not inclusive)
	* @return the range of matching patron categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.PatronCategory> findByCompanyGroup(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the patron categories where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of patron categories
	* @param end the upper bound of the range of patron categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching patron categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.PatronCategory> findByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patron category in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patron category
	* @throws com.kencana.lms.NoSuchPatronCategoryException if a matching patron category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.PatronCategory findByCompanyGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchPatronCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patron category in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patron category, or <code>null</code> if a matching patron category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.PatronCategory fetchByCompanyGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patron category in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patron category
	* @throws com.kencana.lms.NoSuchPatronCategoryException if a matching patron category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.PatronCategory findByCompanyGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchPatronCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patron category in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patron category, or <code>null</code> if a matching patron category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.PatronCategory fetchByCompanyGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patron categories before and after the current patron category in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param patronCategoryId the primary key of the current patron category
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next patron category
	* @throws com.kencana.lms.NoSuchPatronCategoryException if a patron category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.PatronCategory[] findByCompanyGroup_PrevAndNext(
		long patronCategoryId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchPatronCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the patron categories where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of patron categories where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching patron categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the patron categories where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching patron categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.PatronCategory> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the patron categories where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of patron categories
	* @param end the upper bound of the range of patron categories (not inclusive)
	* @return the range of matching patron categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.PatronCategory> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the patron categories where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of patron categories
	* @param end the upper bound of the range of patron categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching patron categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.PatronCategory> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patron category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patron category
	* @throws com.kencana.lms.NoSuchPatronCategoryException if a matching patron category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.PatronCategory findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchPatronCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patron category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patron category, or <code>null</code> if a matching patron category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.PatronCategory fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patron category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patron category
	* @throws com.kencana.lms.NoSuchPatronCategoryException if a matching patron category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.PatronCategory findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchPatronCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patron category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patron category, or <code>null</code> if a matching patron category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.PatronCategory fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patron categories before and after the current patron category in the ordered set where companyId = &#63;.
	*
	* @param patronCategoryId the primary key of the current patron category
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next patron category
	* @throws com.kencana.lms.NoSuchPatronCategoryException if a patron category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.PatronCategory[] findByCompany_PrevAndNext(
		long patronCategoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchPatronCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the patron categories where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of patron categories where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching patron categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the patron categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching patron categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.PatronCategory> findBygroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the patron categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of patron categories
	* @param end the upper bound of the range of patron categories (not inclusive)
	* @return the range of matching patron categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.PatronCategory> findBygroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the patron categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of patron categories
	* @param end the upper bound of the range of patron categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching patron categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.PatronCategory> findBygroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patron category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patron category
	* @throws com.kencana.lms.NoSuchPatronCategoryException if a matching patron category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.PatronCategory findBygroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchPatronCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patron category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patron category, or <code>null</code> if a matching patron category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.PatronCategory fetchBygroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patron category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patron category
	* @throws com.kencana.lms.NoSuchPatronCategoryException if a matching patron category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.PatronCategory findBygroup_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchPatronCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patron category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patron category, or <code>null</code> if a matching patron category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.PatronCategory fetchBygroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patron categories before and after the current patron category in the ordered set where groupId = &#63;.
	*
	* @param patronCategoryId the primary key of the current patron category
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next patron category
	* @throws com.kencana.lms.NoSuchPatronCategoryException if a patron category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.PatronCategory[] findBygroup_PrevAndNext(
		long patronCategoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchPatronCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the patron categories where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBygroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of patron categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching patron categories
	* @throws SystemException if a system exception occurred
	*/
	public int countBygroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the patron category in the entity cache if it is enabled.
	*
	* @param patronCategory the patron category
	*/
	public void cacheResult(com.kencana.lms.model.PatronCategory patronCategory);

	/**
	* Caches the patron categories in the entity cache if it is enabled.
	*
	* @param patronCategories the patron categories
	*/
	public void cacheResult(
		java.util.List<com.kencana.lms.model.PatronCategory> patronCategories);

	/**
	* Creates a new patron category with the primary key. Does not add the patron category to the database.
	*
	* @param patronCategoryId the primary key for the new patron category
	* @return the new patron category
	*/
	public com.kencana.lms.model.PatronCategory create(long patronCategoryId);

	/**
	* Removes the patron category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param patronCategoryId the primary key of the patron category
	* @return the patron category that was removed
	* @throws com.kencana.lms.NoSuchPatronCategoryException if a patron category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.PatronCategory remove(long patronCategoryId)
		throws com.kencana.lms.NoSuchPatronCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.kencana.lms.model.PatronCategory updateImpl(
		com.kencana.lms.model.PatronCategory patronCategory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patron category with the primary key or throws a {@link com.kencana.lms.NoSuchPatronCategoryException} if it could not be found.
	*
	* @param patronCategoryId the primary key of the patron category
	* @return the patron category
	* @throws com.kencana.lms.NoSuchPatronCategoryException if a patron category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.PatronCategory findByPrimaryKey(
		long patronCategoryId)
		throws com.kencana.lms.NoSuchPatronCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patron category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param patronCategoryId the primary key of the patron category
	* @return the patron category, or <code>null</code> if a patron category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.PatronCategory fetchByPrimaryKey(
		long patronCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the patron categories.
	*
	* @return the patron categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.PatronCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the patron categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of patron categories
	* @param end the upper bound of the range of patron categories (not inclusive)
	* @return the range of patron categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.PatronCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the patron categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of patron categories
	* @param end the upper bound of the range of patron categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of patron categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.PatronCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the patron categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of patron categories.
	*
	* @return the number of patron categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}