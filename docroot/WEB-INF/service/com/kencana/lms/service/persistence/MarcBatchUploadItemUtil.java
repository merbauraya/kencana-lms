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

import com.kencana.lms.model.MarcBatchUploadItem;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the marc batch upload item service. This utility wraps {@link MarcBatchUploadItemPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see MarcBatchUploadItemPersistence
 * @see MarcBatchUploadItemPersistenceImpl
 * @generated
 */
public class MarcBatchUploadItemUtil {
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
	public static void clearCache(MarcBatchUploadItem marcBatchUploadItem) {
		getPersistence().clearCache(marcBatchUploadItem);
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
	public static List<MarcBatchUploadItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MarcBatchUploadItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MarcBatchUploadItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static MarcBatchUploadItem update(
		MarcBatchUploadItem marcBatchUploadItem) throws SystemException {
		return getPersistence().update(marcBatchUploadItem);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static MarcBatchUploadItem update(
		MarcBatchUploadItem marcBatchUploadItem, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(marcBatchUploadItem, serviceContext);
	}

	/**
	* Returns all the marc batch upload items where marcBatchUploadId = &#63;.
	*
	* @param marcBatchUploadId the marc batch upload ID
	* @return the matching marc batch upload items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.MarcBatchUploadItem> findByBatchId(
		long marcBatchUploadId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBatchId(marcBatchUploadId);
	}

	/**
	* Returns a range of all the marc batch upload items where marcBatchUploadId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcBatchUploadItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marcBatchUploadId the marc batch upload ID
	* @param start the lower bound of the range of marc batch upload items
	* @param end the upper bound of the range of marc batch upload items (not inclusive)
	* @return the range of matching marc batch upload items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.MarcBatchUploadItem> findByBatchId(
		long marcBatchUploadId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBatchId(marcBatchUploadId, start, end);
	}

	/**
	* Returns an ordered range of all the marc batch upload items where marcBatchUploadId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcBatchUploadItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marcBatchUploadId the marc batch upload ID
	* @param start the lower bound of the range of marc batch upload items
	* @param end the upper bound of the range of marc batch upload items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching marc batch upload items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.MarcBatchUploadItem> findByBatchId(
		long marcBatchUploadId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBatchId(marcBatchUploadId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first marc batch upload item in the ordered set where marcBatchUploadId = &#63;.
	*
	* @param marcBatchUploadId the marc batch upload ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marc batch upload item
	* @throws com.kencana.lms.NoSuchMarcBatchUploadItemException if a matching marc batch upload item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.MarcBatchUploadItem findByBatchId_First(
		long marcBatchUploadId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchMarcBatchUploadItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBatchId_First(marcBatchUploadId, orderByComparator);
	}

	/**
	* Returns the first marc batch upload item in the ordered set where marcBatchUploadId = &#63;.
	*
	* @param marcBatchUploadId the marc batch upload ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marc batch upload item, or <code>null</code> if a matching marc batch upload item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.MarcBatchUploadItem fetchByBatchId_First(
		long marcBatchUploadId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBatchId_First(marcBatchUploadId, orderByComparator);
	}

	/**
	* Returns the last marc batch upload item in the ordered set where marcBatchUploadId = &#63;.
	*
	* @param marcBatchUploadId the marc batch upload ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marc batch upload item
	* @throws com.kencana.lms.NoSuchMarcBatchUploadItemException if a matching marc batch upload item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.MarcBatchUploadItem findByBatchId_Last(
		long marcBatchUploadId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchMarcBatchUploadItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBatchId_Last(marcBatchUploadId, orderByComparator);
	}

	/**
	* Returns the last marc batch upload item in the ordered set where marcBatchUploadId = &#63;.
	*
	* @param marcBatchUploadId the marc batch upload ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marc batch upload item, or <code>null</code> if a matching marc batch upload item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.MarcBatchUploadItem fetchByBatchId_Last(
		long marcBatchUploadId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBatchId_Last(marcBatchUploadId, orderByComparator);
	}

	/**
	* Returns the marc batch upload items before and after the current marc batch upload item in the ordered set where marcBatchUploadId = &#63;.
	*
	* @param marcBatchUploadItemId the primary key of the current marc batch upload item
	* @param marcBatchUploadId the marc batch upload ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marc batch upload item
	* @throws com.kencana.lms.NoSuchMarcBatchUploadItemException if a marc batch upload item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.MarcBatchUploadItem[] findByBatchId_PrevAndNext(
		long marcBatchUploadItemId, long marcBatchUploadId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchMarcBatchUploadItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBatchId_PrevAndNext(marcBatchUploadItemId,
			marcBatchUploadId, orderByComparator);
	}

	/**
	* Removes all the marc batch upload items where marcBatchUploadId = &#63; from the database.
	*
	* @param marcBatchUploadId the marc batch upload ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByBatchId(long marcBatchUploadId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByBatchId(marcBatchUploadId);
	}

	/**
	* Returns the number of marc batch upload items where marcBatchUploadId = &#63;.
	*
	* @param marcBatchUploadId the marc batch upload ID
	* @return the number of matching marc batch upload items
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBatchId(long marcBatchUploadId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBatchId(marcBatchUploadId);
	}

	/**
	* Returns all the marc batch upload items where marcBatchUploadId = &#63; and processed = &#63;.
	*
	* @param marcBatchUploadId the marc batch upload ID
	* @param processed the processed
	* @return the matching marc batch upload items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.MarcBatchUploadItem> findByBatchStatus(
		long marcBatchUploadId, boolean processed)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBatchStatus(marcBatchUploadId, processed);
	}

	/**
	* Returns a range of all the marc batch upload items where marcBatchUploadId = &#63; and processed = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcBatchUploadItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marcBatchUploadId the marc batch upload ID
	* @param processed the processed
	* @param start the lower bound of the range of marc batch upload items
	* @param end the upper bound of the range of marc batch upload items (not inclusive)
	* @return the range of matching marc batch upload items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.MarcBatchUploadItem> findByBatchStatus(
		long marcBatchUploadId, boolean processed, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBatchStatus(marcBatchUploadId, processed, start, end);
	}

	/**
	* Returns an ordered range of all the marc batch upload items where marcBatchUploadId = &#63; and processed = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcBatchUploadItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param marcBatchUploadId the marc batch upload ID
	* @param processed the processed
	* @param start the lower bound of the range of marc batch upload items
	* @param end the upper bound of the range of marc batch upload items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching marc batch upload items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.MarcBatchUploadItem> findByBatchStatus(
		long marcBatchUploadId, boolean processed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBatchStatus(marcBatchUploadId, processed, start, end,
			orderByComparator);
	}

	/**
	* Returns the first marc batch upload item in the ordered set where marcBatchUploadId = &#63; and processed = &#63;.
	*
	* @param marcBatchUploadId the marc batch upload ID
	* @param processed the processed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marc batch upload item
	* @throws com.kencana.lms.NoSuchMarcBatchUploadItemException if a matching marc batch upload item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.MarcBatchUploadItem findByBatchStatus_First(
		long marcBatchUploadId, boolean processed,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchMarcBatchUploadItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBatchStatus_First(marcBatchUploadId, processed,
			orderByComparator);
	}

	/**
	* Returns the first marc batch upload item in the ordered set where marcBatchUploadId = &#63; and processed = &#63;.
	*
	* @param marcBatchUploadId the marc batch upload ID
	* @param processed the processed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marc batch upload item, or <code>null</code> if a matching marc batch upload item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.MarcBatchUploadItem fetchByBatchStatus_First(
		long marcBatchUploadId, boolean processed,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBatchStatus_First(marcBatchUploadId, processed,
			orderByComparator);
	}

	/**
	* Returns the last marc batch upload item in the ordered set where marcBatchUploadId = &#63; and processed = &#63;.
	*
	* @param marcBatchUploadId the marc batch upload ID
	* @param processed the processed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marc batch upload item
	* @throws com.kencana.lms.NoSuchMarcBatchUploadItemException if a matching marc batch upload item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.MarcBatchUploadItem findByBatchStatus_Last(
		long marcBatchUploadId, boolean processed,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchMarcBatchUploadItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBatchStatus_Last(marcBatchUploadId, processed,
			orderByComparator);
	}

	/**
	* Returns the last marc batch upload item in the ordered set where marcBatchUploadId = &#63; and processed = &#63;.
	*
	* @param marcBatchUploadId the marc batch upload ID
	* @param processed the processed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marc batch upload item, or <code>null</code> if a matching marc batch upload item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.MarcBatchUploadItem fetchByBatchStatus_Last(
		long marcBatchUploadId, boolean processed,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBatchStatus_Last(marcBatchUploadId, processed,
			orderByComparator);
	}

	/**
	* Returns the marc batch upload items before and after the current marc batch upload item in the ordered set where marcBatchUploadId = &#63; and processed = &#63;.
	*
	* @param marcBatchUploadItemId the primary key of the current marc batch upload item
	* @param marcBatchUploadId the marc batch upload ID
	* @param processed the processed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marc batch upload item
	* @throws com.kencana.lms.NoSuchMarcBatchUploadItemException if a marc batch upload item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.MarcBatchUploadItem[] findByBatchStatus_PrevAndNext(
		long marcBatchUploadItemId, long marcBatchUploadId, boolean processed,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchMarcBatchUploadItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBatchStatus_PrevAndNext(marcBatchUploadItemId,
			marcBatchUploadId, processed, orderByComparator);
	}

	/**
	* Removes all the marc batch upload items where marcBatchUploadId = &#63; and processed = &#63; from the database.
	*
	* @param marcBatchUploadId the marc batch upload ID
	* @param processed the processed
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByBatchStatus(long marcBatchUploadId,
		boolean processed)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByBatchStatus(marcBatchUploadId, processed);
	}

	/**
	* Returns the number of marc batch upload items where marcBatchUploadId = &#63; and processed = &#63;.
	*
	* @param marcBatchUploadId the marc batch upload ID
	* @param processed the processed
	* @return the number of matching marc batch upload items
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBatchStatus(long marcBatchUploadId,
		boolean processed)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBatchStatus(marcBatchUploadId, processed);
	}

	/**
	* Caches the marc batch upload item in the entity cache if it is enabled.
	*
	* @param marcBatchUploadItem the marc batch upload item
	*/
	public static void cacheResult(
		com.kencana.lms.model.MarcBatchUploadItem marcBatchUploadItem) {
		getPersistence().cacheResult(marcBatchUploadItem);
	}

	/**
	* Caches the marc batch upload items in the entity cache if it is enabled.
	*
	* @param marcBatchUploadItems the marc batch upload items
	*/
	public static void cacheResult(
		java.util.List<com.kencana.lms.model.MarcBatchUploadItem> marcBatchUploadItems) {
		getPersistence().cacheResult(marcBatchUploadItems);
	}

	/**
	* Creates a new marc batch upload item with the primary key. Does not add the marc batch upload item to the database.
	*
	* @param marcBatchUploadItemId the primary key for the new marc batch upload item
	* @return the new marc batch upload item
	*/
	public static com.kencana.lms.model.MarcBatchUploadItem create(
		long marcBatchUploadItemId) {
		return getPersistence().create(marcBatchUploadItemId);
	}

	/**
	* Removes the marc batch upload item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param marcBatchUploadItemId the primary key of the marc batch upload item
	* @return the marc batch upload item that was removed
	* @throws com.kencana.lms.NoSuchMarcBatchUploadItemException if a marc batch upload item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.MarcBatchUploadItem remove(
		long marcBatchUploadItemId)
		throws com.kencana.lms.NoSuchMarcBatchUploadItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(marcBatchUploadItemId);
	}

	public static com.kencana.lms.model.MarcBatchUploadItem updateImpl(
		com.kencana.lms.model.MarcBatchUploadItem marcBatchUploadItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(marcBatchUploadItem);
	}

	/**
	* Returns the marc batch upload item with the primary key or throws a {@link com.kencana.lms.NoSuchMarcBatchUploadItemException} if it could not be found.
	*
	* @param marcBatchUploadItemId the primary key of the marc batch upload item
	* @return the marc batch upload item
	* @throws com.kencana.lms.NoSuchMarcBatchUploadItemException if a marc batch upload item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.MarcBatchUploadItem findByPrimaryKey(
		long marcBatchUploadItemId)
		throws com.kencana.lms.NoSuchMarcBatchUploadItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(marcBatchUploadItemId);
	}

	/**
	* Returns the marc batch upload item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param marcBatchUploadItemId the primary key of the marc batch upload item
	* @return the marc batch upload item, or <code>null</code> if a marc batch upload item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.MarcBatchUploadItem fetchByPrimaryKey(
		long marcBatchUploadItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(marcBatchUploadItemId);
	}

	/**
	* Returns all the marc batch upload items.
	*
	* @return the marc batch upload items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.MarcBatchUploadItem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the marc batch upload items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcBatchUploadItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marc batch upload items
	* @param end the upper bound of the range of marc batch upload items (not inclusive)
	* @return the range of marc batch upload items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.MarcBatchUploadItem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the marc batch upload items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcBatchUploadItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marc batch upload items
	* @param end the upper bound of the range of marc batch upload items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of marc batch upload items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.MarcBatchUploadItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the marc batch upload items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of marc batch upload items.
	*
	* @return the number of marc batch upload items
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MarcBatchUploadItemPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MarcBatchUploadItemPersistence)PortletBeanLocatorUtil.locate(com.kencana.lms.service.ClpSerializer.getServletContextName(),
					MarcBatchUploadItemPersistence.class.getName());

			ReferenceRegistry.registerReference(MarcBatchUploadItemUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(MarcBatchUploadItemPersistence persistence) {
	}

	private static MarcBatchUploadItemPersistence _persistence;
}