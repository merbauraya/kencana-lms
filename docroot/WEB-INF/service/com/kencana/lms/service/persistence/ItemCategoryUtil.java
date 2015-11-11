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

import com.kencana.lms.model.ItemCategory;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the item category service. This utility wraps {@link ItemCategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemCategoryPersistence
 * @see ItemCategoryPersistenceImpl
 * @generated
 */
public class ItemCategoryUtil {
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
	public static void clearCache(ItemCategory itemCategory) {
		getPersistence().clearCache(itemCategory);
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
	public static List<ItemCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ItemCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ItemCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ItemCategory update(ItemCategory itemCategory)
		throws SystemException {
		return getPersistence().update(itemCategory);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ItemCategory update(ItemCategory itemCategory,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(itemCategory, serviceContext);
	}

	/**
	* Returns all the item categories where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching item categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.ItemCategory> findByGroupCompany(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupCompany(companyId, groupId);
	}

	/**
	* Returns a range of all the item categories where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.ItemCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of item categories
	* @param end the upper bound of the range of item categories (not inclusive)
	* @return the range of matching item categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.ItemCategory> findByGroupCompany(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCompany(companyId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the item categories where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.ItemCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of item categories
	* @param end the upper bound of the range of item categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching item categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.ItemCategory> findByGroupCompany(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCompany(companyId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first item category in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item category
	* @throws com.kencana.lms.NoSuchItemCategoryException if a matching item category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.ItemCategory findByGroupCompany_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchItemCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCompany_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first item category in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item category, or <code>null</code> if a matching item category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.ItemCategory fetchByGroupCompany_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupCompany_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last item category in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item category
	* @throws com.kencana.lms.NoSuchItemCategoryException if a matching item category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.ItemCategory findByGroupCompany_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchItemCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCompany_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last item category in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item category, or <code>null</code> if a matching item category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.ItemCategory fetchByGroupCompany_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupCompany_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the item categories before and after the current item category in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param itemCategoryId the primary key of the current item category
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next item category
	* @throws com.kencana.lms.NoSuchItemCategoryException if a item category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.ItemCategory[] findByGroupCompany_PrevAndNext(
		long itemCategoryId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchItemCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCompany_PrevAndNext(itemCategoryId, companyId,
			groupId, orderByComparator);
	}

	/**
	* Removes all the item categories where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupCompany(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupCompany(companyId, groupId);
	}

	/**
	* Returns the number of item categories where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching item categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupCompany(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupCompany(companyId, groupId);
	}

	/**
	* Returns all the item categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching item categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.ItemCategory> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

	/**
	* Returns a range of all the item categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.ItemCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of item categories
	* @param end the upper bound of the range of item categories (not inclusive)
	* @return the range of matching item categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.ItemCategory> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the item categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.ItemCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of item categories
	* @param end the upper bound of the range of item categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching item categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.ItemCategory> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first item category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item category
	* @throws com.kencana.lms.NoSuchItemCategoryException if a matching item category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.ItemCategory findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchItemCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first item category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item category, or <code>null</code> if a matching item category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.ItemCategory fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last item category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item category
	* @throws com.kencana.lms.NoSuchItemCategoryException if a matching item category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.ItemCategory findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchItemCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last item category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item category, or <code>null</code> if a matching item category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.ItemCategory fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the item categories before and after the current item category in the ordered set where groupId = &#63;.
	*
	* @param itemCategoryId the primary key of the current item category
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next item category
	* @throws com.kencana.lms.NoSuchItemCategoryException if a item category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.ItemCategory[] findByGroup_PrevAndNext(
		long itemCategoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchItemCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup_PrevAndNext(itemCategoryId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the item categories where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Returns the number of item categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching item categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Caches the item category in the entity cache if it is enabled.
	*
	* @param itemCategory the item category
	*/
	public static void cacheResult(
		com.kencana.lms.model.ItemCategory itemCategory) {
		getPersistence().cacheResult(itemCategory);
	}

	/**
	* Caches the item categories in the entity cache if it is enabled.
	*
	* @param itemCategories the item categories
	*/
	public static void cacheResult(
		java.util.List<com.kencana.lms.model.ItemCategory> itemCategories) {
		getPersistence().cacheResult(itemCategories);
	}

	/**
	* Creates a new item category with the primary key. Does not add the item category to the database.
	*
	* @param itemCategoryId the primary key for the new item category
	* @return the new item category
	*/
	public static com.kencana.lms.model.ItemCategory create(long itemCategoryId) {
		return getPersistence().create(itemCategoryId);
	}

	/**
	* Removes the item category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemCategoryId the primary key of the item category
	* @return the item category that was removed
	* @throws com.kencana.lms.NoSuchItemCategoryException if a item category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.ItemCategory remove(long itemCategoryId)
		throws com.kencana.lms.NoSuchItemCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(itemCategoryId);
	}

	public static com.kencana.lms.model.ItemCategory updateImpl(
		com.kencana.lms.model.ItemCategory itemCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(itemCategory);
	}

	/**
	* Returns the item category with the primary key or throws a {@link com.kencana.lms.NoSuchItemCategoryException} if it could not be found.
	*
	* @param itemCategoryId the primary key of the item category
	* @return the item category
	* @throws com.kencana.lms.NoSuchItemCategoryException if a item category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.ItemCategory findByPrimaryKey(
		long itemCategoryId)
		throws com.kencana.lms.NoSuchItemCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(itemCategoryId);
	}

	/**
	* Returns the item category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param itemCategoryId the primary key of the item category
	* @return the item category, or <code>null</code> if a item category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.ItemCategory fetchByPrimaryKey(
		long itemCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(itemCategoryId);
	}

	/**
	* Returns all the item categories.
	*
	* @return the item categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.ItemCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the item categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.ItemCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of item categories
	* @param end the upper bound of the range of item categories (not inclusive)
	* @return the range of item categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.ItemCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the item categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.ItemCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of item categories
	* @param end the upper bound of the range of item categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of item categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.ItemCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the item categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of item categories.
	*
	* @return the number of item categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ItemCategoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ItemCategoryPersistence)PortletBeanLocatorUtil.locate(com.kencana.lms.service.ClpSerializer.getServletContextName(),
					ItemCategoryPersistence.class.getName());

			ReferenceRegistry.registerReference(ItemCategoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ItemCategoryPersistence persistence) {
	}

	private static ItemCategoryPersistence _persistence;
}