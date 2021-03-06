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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the marc batch upload item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see MarcBatchUploadItemPersistenceImpl
 * @see MarcBatchUploadItemUtil
 * @generated
 */
public interface MarcBatchUploadItemPersistence extends BasePersistence<MarcBatchUploadItem> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MarcBatchUploadItemUtil} to access the marc batch upload item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the marc batch upload items where marcBatchUploadId = &#63;.
	*
	* @param marcBatchUploadId the marc batch upload ID
	* @return the matching marc batch upload items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.MarcBatchUploadItem> findByBatchId(
		long marcBatchUploadId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.MarcBatchUploadItem> findByBatchId(
		long marcBatchUploadId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.MarcBatchUploadItem> findByBatchId(
		long marcBatchUploadId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first marc batch upload item in the ordered set where marcBatchUploadId = &#63;.
	*
	* @param marcBatchUploadId the marc batch upload ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marc batch upload item
	* @throws com.kencana.lms.NoSuchMarcBatchUploadItemException if a matching marc batch upload item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.MarcBatchUploadItem findByBatchId_First(
		long marcBatchUploadId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchMarcBatchUploadItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first marc batch upload item in the ordered set where marcBatchUploadId = &#63;.
	*
	* @param marcBatchUploadId the marc batch upload ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marc batch upload item, or <code>null</code> if a matching marc batch upload item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.MarcBatchUploadItem fetchByBatchId_First(
		long marcBatchUploadId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last marc batch upload item in the ordered set where marcBatchUploadId = &#63;.
	*
	* @param marcBatchUploadId the marc batch upload ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marc batch upload item
	* @throws com.kencana.lms.NoSuchMarcBatchUploadItemException if a matching marc batch upload item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.MarcBatchUploadItem findByBatchId_Last(
		long marcBatchUploadId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchMarcBatchUploadItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last marc batch upload item in the ordered set where marcBatchUploadId = &#63;.
	*
	* @param marcBatchUploadId the marc batch upload ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marc batch upload item, or <code>null</code> if a matching marc batch upload item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.MarcBatchUploadItem fetchByBatchId_Last(
		long marcBatchUploadId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.MarcBatchUploadItem[] findByBatchId_PrevAndNext(
		long marcBatchUploadItemId, long marcBatchUploadId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchMarcBatchUploadItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the marc batch upload items where marcBatchUploadId = &#63; from the database.
	*
	* @param marcBatchUploadId the marc batch upload ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByBatchId(long marcBatchUploadId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of marc batch upload items where marcBatchUploadId = &#63;.
	*
	* @param marcBatchUploadId the marc batch upload ID
	* @return the number of matching marc batch upload items
	* @throws SystemException if a system exception occurred
	*/
	public int countByBatchId(long marcBatchUploadId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the marc batch upload items where marcBatchUploadId = &#63; and processed = &#63;.
	*
	* @param marcBatchUploadId the marc batch upload ID
	* @param processed the processed
	* @return the matching marc batch upload items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.MarcBatchUploadItem> findByBatchStatus(
		long marcBatchUploadId, boolean processed)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.MarcBatchUploadItem> findByBatchStatus(
		long marcBatchUploadId, boolean processed, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.MarcBatchUploadItem> findByBatchStatus(
		long marcBatchUploadId, boolean processed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.MarcBatchUploadItem findByBatchStatus_First(
		long marcBatchUploadId, boolean processed,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchMarcBatchUploadItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first marc batch upload item in the ordered set where marcBatchUploadId = &#63; and processed = &#63;.
	*
	* @param marcBatchUploadId the marc batch upload ID
	* @param processed the processed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marc batch upload item, or <code>null</code> if a matching marc batch upload item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.MarcBatchUploadItem fetchByBatchStatus_First(
		long marcBatchUploadId, boolean processed,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.MarcBatchUploadItem findByBatchStatus_Last(
		long marcBatchUploadId, boolean processed,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchMarcBatchUploadItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last marc batch upload item in the ordered set where marcBatchUploadId = &#63; and processed = &#63;.
	*
	* @param marcBatchUploadId the marc batch upload ID
	* @param processed the processed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marc batch upload item, or <code>null</code> if a matching marc batch upload item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.MarcBatchUploadItem fetchByBatchStatus_Last(
		long marcBatchUploadId, boolean processed,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.MarcBatchUploadItem[] findByBatchStatus_PrevAndNext(
		long marcBatchUploadItemId, long marcBatchUploadId, boolean processed,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchMarcBatchUploadItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the marc batch upload items where marcBatchUploadId = &#63; and processed = &#63; from the database.
	*
	* @param marcBatchUploadId the marc batch upload ID
	* @param processed the processed
	* @throws SystemException if a system exception occurred
	*/
	public void removeByBatchStatus(long marcBatchUploadId, boolean processed)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of marc batch upload items where marcBatchUploadId = &#63; and processed = &#63;.
	*
	* @param marcBatchUploadId the marc batch upload ID
	* @param processed the processed
	* @return the number of matching marc batch upload items
	* @throws SystemException if a system exception occurred
	*/
	public int countByBatchStatus(long marcBatchUploadId, boolean processed)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the marc batch upload item in the entity cache if it is enabled.
	*
	* @param marcBatchUploadItem the marc batch upload item
	*/
	public void cacheResult(
		com.kencana.lms.model.MarcBatchUploadItem marcBatchUploadItem);

	/**
	* Caches the marc batch upload items in the entity cache if it is enabled.
	*
	* @param marcBatchUploadItems the marc batch upload items
	*/
	public void cacheResult(
		java.util.List<com.kencana.lms.model.MarcBatchUploadItem> marcBatchUploadItems);

	/**
	* Creates a new marc batch upload item with the primary key. Does not add the marc batch upload item to the database.
	*
	* @param marcBatchUploadItemId the primary key for the new marc batch upload item
	* @return the new marc batch upload item
	*/
	public com.kencana.lms.model.MarcBatchUploadItem create(
		long marcBatchUploadItemId);

	/**
	* Removes the marc batch upload item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param marcBatchUploadItemId the primary key of the marc batch upload item
	* @return the marc batch upload item that was removed
	* @throws com.kencana.lms.NoSuchMarcBatchUploadItemException if a marc batch upload item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.MarcBatchUploadItem remove(
		long marcBatchUploadItemId)
		throws com.kencana.lms.NoSuchMarcBatchUploadItemException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.kencana.lms.model.MarcBatchUploadItem updateImpl(
		com.kencana.lms.model.MarcBatchUploadItem marcBatchUploadItem)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the marc batch upload item with the primary key or throws a {@link com.kencana.lms.NoSuchMarcBatchUploadItemException} if it could not be found.
	*
	* @param marcBatchUploadItemId the primary key of the marc batch upload item
	* @return the marc batch upload item
	* @throws com.kencana.lms.NoSuchMarcBatchUploadItemException if a marc batch upload item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.MarcBatchUploadItem findByPrimaryKey(
		long marcBatchUploadItemId)
		throws com.kencana.lms.NoSuchMarcBatchUploadItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the marc batch upload item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param marcBatchUploadItemId the primary key of the marc batch upload item
	* @return the marc batch upload item, or <code>null</code> if a marc batch upload item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.MarcBatchUploadItem fetchByPrimaryKey(
		long marcBatchUploadItemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the marc batch upload items.
	*
	* @return the marc batch upload items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.MarcBatchUploadItem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.MarcBatchUploadItem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.MarcBatchUploadItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the marc batch upload items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of marc batch upload items.
	*
	* @return the number of marc batch upload items
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}