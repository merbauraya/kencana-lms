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

import com.kencana.lms.model.CatalogItem;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the catalog item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see CatalogItemPersistenceImpl
 * @see CatalogItemUtil
 * @generated
 */
public interface CatalogItemPersistence extends BasePersistence<CatalogItem> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CatalogItemUtil} to access the catalog item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the catalog items where catalogId = &#63;.
	*
	* @param catalogId the catalog ID
	* @return the matching catalog items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CatalogItem> findByCatalog(
		long catalogId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the catalog items where catalogId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param catalogId the catalog ID
	* @param start the lower bound of the range of catalog items
	* @param end the upper bound of the range of catalog items (not inclusive)
	* @return the range of matching catalog items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CatalogItem> findByCatalog(
		long catalogId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the catalog items where catalogId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param catalogId the catalog ID
	* @param start the lower bound of the range of catalog items
	* @param end the upper bound of the range of catalog items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching catalog items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CatalogItem> findByCatalog(
		long catalogId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first catalog item in the ordered set where catalogId = &#63;.
	*
	* @param catalogId the catalog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog item
	* @throws com.kencana.lms.NoSuchCatalogItemException if a matching catalog item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CatalogItem findByCatalog_First(
		long catalogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first catalog item in the ordered set where catalogId = &#63;.
	*
	* @param catalogId the catalog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog item, or <code>null</code> if a matching catalog item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CatalogItem fetchByCatalog_First(
		long catalogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last catalog item in the ordered set where catalogId = &#63;.
	*
	* @param catalogId the catalog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog item
	* @throws com.kencana.lms.NoSuchCatalogItemException if a matching catalog item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CatalogItem findByCatalog_Last(
		long catalogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last catalog item in the ordered set where catalogId = &#63;.
	*
	* @param catalogId the catalog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog item, or <code>null</code> if a matching catalog item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CatalogItem fetchByCatalog_Last(
		long catalogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the catalog items before and after the current catalog item in the ordered set where catalogId = &#63;.
	*
	* @param catalogItemId the primary key of the current catalog item
	* @param catalogId the catalog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next catalog item
	* @throws com.kencana.lms.NoSuchCatalogItemException if a catalog item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CatalogItem[] findByCatalog_PrevAndNext(
		long catalogItemId, long catalogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the catalog items where catalogId = &#63; from the database.
	*
	* @param catalogId the catalog ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCatalog(long catalogId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of catalog items where catalogId = &#63;.
	*
	* @param catalogId the catalog ID
	* @return the number of matching catalog items
	* @throws SystemException if a system exception occurred
	*/
	public int countByCatalog(long catalogId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the catalog item where companyId = &#63; and barcode = &#63; or throws a {@link com.kencana.lms.NoSuchCatalogItemException} if it could not be found.
	*
	* @param companyId the company ID
	* @param barcode the barcode
	* @return the matching catalog item
	* @throws com.kencana.lms.NoSuchCatalogItemException if a matching catalog item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CatalogItem findByBarcode(long companyId,
		java.lang.String barcode)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the catalog item where companyId = &#63; and barcode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param barcode the barcode
	* @return the matching catalog item, or <code>null</code> if a matching catalog item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CatalogItem fetchByBarcode(long companyId,
		java.lang.String barcode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the catalog item where companyId = &#63; and barcode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param barcode the barcode
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching catalog item, or <code>null</code> if a matching catalog item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CatalogItem fetchByBarcode(long companyId,
		java.lang.String barcode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the catalog item where companyId = &#63; and barcode = &#63; from the database.
	*
	* @param companyId the company ID
	* @param barcode the barcode
	* @return the catalog item that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CatalogItem removeByBarcode(long companyId,
		java.lang.String barcode)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of catalog items where companyId = &#63; and barcode = &#63;.
	*
	* @param companyId the company ID
	* @param barcode the barcode
	* @return the number of matching catalog items
	* @throws SystemException if a system exception occurred
	*/
	public int countByBarcode(long companyId, java.lang.String barcode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the catalog items where holdingLibraryId = &#63;.
	*
	* @param holdingLibraryId the holding library ID
	* @return the matching catalog items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CatalogItem> findByHoldingLibrary(
		long holdingLibraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the catalog items where holdingLibraryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param holdingLibraryId the holding library ID
	* @param start the lower bound of the range of catalog items
	* @param end the upper bound of the range of catalog items (not inclusive)
	* @return the range of matching catalog items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CatalogItem> findByHoldingLibrary(
		long holdingLibraryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the catalog items where holdingLibraryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param holdingLibraryId the holding library ID
	* @param start the lower bound of the range of catalog items
	* @param end the upper bound of the range of catalog items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching catalog items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CatalogItem> findByHoldingLibrary(
		long holdingLibraryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first catalog item in the ordered set where holdingLibraryId = &#63;.
	*
	* @param holdingLibraryId the holding library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog item
	* @throws com.kencana.lms.NoSuchCatalogItemException if a matching catalog item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CatalogItem findByHoldingLibrary_First(
		long holdingLibraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first catalog item in the ordered set where holdingLibraryId = &#63;.
	*
	* @param holdingLibraryId the holding library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog item, or <code>null</code> if a matching catalog item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CatalogItem fetchByHoldingLibrary_First(
		long holdingLibraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last catalog item in the ordered set where holdingLibraryId = &#63;.
	*
	* @param holdingLibraryId the holding library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog item
	* @throws com.kencana.lms.NoSuchCatalogItemException if a matching catalog item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CatalogItem findByHoldingLibrary_Last(
		long holdingLibraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last catalog item in the ordered set where holdingLibraryId = &#63;.
	*
	* @param holdingLibraryId the holding library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog item, or <code>null</code> if a matching catalog item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CatalogItem fetchByHoldingLibrary_Last(
		long holdingLibraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the catalog items before and after the current catalog item in the ordered set where holdingLibraryId = &#63;.
	*
	* @param catalogItemId the primary key of the current catalog item
	* @param holdingLibraryId the holding library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next catalog item
	* @throws com.kencana.lms.NoSuchCatalogItemException if a catalog item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CatalogItem[] findByHoldingLibrary_PrevAndNext(
		long catalogItemId, long holdingLibraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the catalog items where holdingLibraryId = &#63; from the database.
	*
	* @param holdingLibraryId the holding library ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByHoldingLibrary(long holdingLibraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of catalog items where holdingLibraryId = &#63;.
	*
	* @param holdingLibraryId the holding library ID
	* @return the number of matching catalog items
	* @throws SystemException if a system exception occurred
	*/
	public int countByHoldingLibrary(long holdingLibraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the catalog items where companyId = &#63; and groupId = &#63; and released = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param released the released
	* @return the matching catalog items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CatalogItem> findByReleasedCompanyGroup(
		long companyId, long groupId, boolean released)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the catalog items where companyId = &#63; and groupId = &#63; and released = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param released the released
	* @param start the lower bound of the range of catalog items
	* @param end the upper bound of the range of catalog items (not inclusive)
	* @return the range of matching catalog items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CatalogItem> findByReleasedCompanyGroup(
		long companyId, long groupId, boolean released, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the catalog items where companyId = &#63; and groupId = &#63; and released = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param released the released
	* @param start the lower bound of the range of catalog items
	* @param end the upper bound of the range of catalog items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching catalog items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CatalogItem> findByReleasedCompanyGroup(
		long companyId, long groupId, boolean released, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first catalog item in the ordered set where companyId = &#63; and groupId = &#63; and released = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param released the released
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog item
	* @throws com.kencana.lms.NoSuchCatalogItemException if a matching catalog item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CatalogItem findByReleasedCompanyGroup_First(
		long companyId, long groupId, boolean released,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first catalog item in the ordered set where companyId = &#63; and groupId = &#63; and released = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param released the released
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog item, or <code>null</code> if a matching catalog item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CatalogItem fetchByReleasedCompanyGroup_First(
		long companyId, long groupId, boolean released,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last catalog item in the ordered set where companyId = &#63; and groupId = &#63; and released = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param released the released
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog item
	* @throws com.kencana.lms.NoSuchCatalogItemException if a matching catalog item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CatalogItem findByReleasedCompanyGroup_Last(
		long companyId, long groupId, boolean released,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last catalog item in the ordered set where companyId = &#63; and groupId = &#63; and released = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param released the released
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog item, or <code>null</code> if a matching catalog item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CatalogItem fetchByReleasedCompanyGroup_Last(
		long companyId, long groupId, boolean released,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the catalog items before and after the current catalog item in the ordered set where companyId = &#63; and groupId = &#63; and released = &#63;.
	*
	* @param catalogItemId the primary key of the current catalog item
	* @param companyId the company ID
	* @param groupId the group ID
	* @param released the released
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next catalog item
	* @throws com.kencana.lms.NoSuchCatalogItemException if a catalog item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CatalogItem[] findByReleasedCompanyGroup_PrevAndNext(
		long catalogItemId, long companyId, long groupId, boolean released,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the catalog items that the user has permission to view where companyId = &#63; and groupId = &#63; and released = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param released the released
	* @return the matching catalog items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CatalogItem> filterFindByReleasedCompanyGroup(
		long companyId, long groupId, boolean released)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the catalog items that the user has permission to view where companyId = &#63; and groupId = &#63; and released = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param released the released
	* @param start the lower bound of the range of catalog items
	* @param end the upper bound of the range of catalog items (not inclusive)
	* @return the range of matching catalog items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CatalogItem> filterFindByReleasedCompanyGroup(
		long companyId, long groupId, boolean released, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the catalog items that the user has permissions to view where companyId = &#63; and groupId = &#63; and released = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param released the released
	* @param start the lower bound of the range of catalog items
	* @param end the upper bound of the range of catalog items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching catalog items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CatalogItem> filterFindByReleasedCompanyGroup(
		long companyId, long groupId, boolean released, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the catalog items before and after the current catalog item in the ordered set of catalog items that the user has permission to view where companyId = &#63; and groupId = &#63; and released = &#63;.
	*
	* @param catalogItemId the primary key of the current catalog item
	* @param companyId the company ID
	* @param groupId the group ID
	* @param released the released
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next catalog item
	* @throws com.kencana.lms.NoSuchCatalogItemException if a catalog item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CatalogItem[] filterFindByReleasedCompanyGroup_PrevAndNext(
		long catalogItemId, long companyId, long groupId, boolean released,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the catalog items where companyId = &#63; and groupId = &#63; and released = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param released the released
	* @throws SystemException if a system exception occurred
	*/
	public void removeByReleasedCompanyGroup(long companyId, long groupId,
		boolean released)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of catalog items where companyId = &#63; and groupId = &#63; and released = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param released the released
	* @return the number of matching catalog items
	* @throws SystemException if a system exception occurred
	*/
	public int countByReleasedCompanyGroup(long companyId, long groupId,
		boolean released)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of catalog items that the user has permission to view where companyId = &#63; and groupId = &#63; and released = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param released the released
	* @return the number of matching catalog items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByReleasedCompanyGroup(long companyId, long groupId,
		boolean released)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the catalog items where companyId = &#63; and groupId = &#63; and withdrawnStatus = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param withdrawnStatus the withdrawn status
	* @return the matching catalog items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CatalogItem> findByWithdrawnCompanyGroup(
		long companyId, long groupId, boolean withdrawnStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the catalog items where companyId = &#63; and groupId = &#63; and withdrawnStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param withdrawnStatus the withdrawn status
	* @param start the lower bound of the range of catalog items
	* @param end the upper bound of the range of catalog items (not inclusive)
	* @return the range of matching catalog items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CatalogItem> findByWithdrawnCompanyGroup(
		long companyId, long groupId, boolean withdrawnStatus, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the catalog items where companyId = &#63; and groupId = &#63; and withdrawnStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param withdrawnStatus the withdrawn status
	* @param start the lower bound of the range of catalog items
	* @param end the upper bound of the range of catalog items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching catalog items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CatalogItem> findByWithdrawnCompanyGroup(
		long companyId, long groupId, boolean withdrawnStatus, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first catalog item in the ordered set where companyId = &#63; and groupId = &#63; and withdrawnStatus = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param withdrawnStatus the withdrawn status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog item
	* @throws com.kencana.lms.NoSuchCatalogItemException if a matching catalog item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CatalogItem findByWithdrawnCompanyGroup_First(
		long companyId, long groupId, boolean withdrawnStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first catalog item in the ordered set where companyId = &#63; and groupId = &#63; and withdrawnStatus = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param withdrawnStatus the withdrawn status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog item, or <code>null</code> if a matching catalog item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CatalogItem fetchByWithdrawnCompanyGroup_First(
		long companyId, long groupId, boolean withdrawnStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last catalog item in the ordered set where companyId = &#63; and groupId = &#63; and withdrawnStatus = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param withdrawnStatus the withdrawn status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog item
	* @throws com.kencana.lms.NoSuchCatalogItemException if a matching catalog item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CatalogItem findByWithdrawnCompanyGroup_Last(
		long companyId, long groupId, boolean withdrawnStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last catalog item in the ordered set where companyId = &#63; and groupId = &#63; and withdrawnStatus = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param withdrawnStatus the withdrawn status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog item, or <code>null</code> if a matching catalog item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CatalogItem fetchByWithdrawnCompanyGroup_Last(
		long companyId, long groupId, boolean withdrawnStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the catalog items before and after the current catalog item in the ordered set where companyId = &#63; and groupId = &#63; and withdrawnStatus = &#63;.
	*
	* @param catalogItemId the primary key of the current catalog item
	* @param companyId the company ID
	* @param groupId the group ID
	* @param withdrawnStatus the withdrawn status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next catalog item
	* @throws com.kencana.lms.NoSuchCatalogItemException if a catalog item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CatalogItem[] findByWithdrawnCompanyGroup_PrevAndNext(
		long catalogItemId, long companyId, long groupId,
		boolean withdrawnStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the catalog items that the user has permission to view where companyId = &#63; and groupId = &#63; and withdrawnStatus = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param withdrawnStatus the withdrawn status
	* @return the matching catalog items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CatalogItem> filterFindByWithdrawnCompanyGroup(
		long companyId, long groupId, boolean withdrawnStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the catalog items that the user has permission to view where companyId = &#63; and groupId = &#63; and withdrawnStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param withdrawnStatus the withdrawn status
	* @param start the lower bound of the range of catalog items
	* @param end the upper bound of the range of catalog items (not inclusive)
	* @return the range of matching catalog items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CatalogItem> filterFindByWithdrawnCompanyGroup(
		long companyId, long groupId, boolean withdrawnStatus, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the catalog items that the user has permissions to view where companyId = &#63; and groupId = &#63; and withdrawnStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param withdrawnStatus the withdrawn status
	* @param start the lower bound of the range of catalog items
	* @param end the upper bound of the range of catalog items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching catalog items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CatalogItem> filterFindByWithdrawnCompanyGroup(
		long companyId, long groupId, boolean withdrawnStatus, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the catalog items before and after the current catalog item in the ordered set of catalog items that the user has permission to view where companyId = &#63; and groupId = &#63; and withdrawnStatus = &#63;.
	*
	* @param catalogItemId the primary key of the current catalog item
	* @param companyId the company ID
	* @param groupId the group ID
	* @param withdrawnStatus the withdrawn status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next catalog item
	* @throws com.kencana.lms.NoSuchCatalogItemException if a catalog item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CatalogItem[] filterFindByWithdrawnCompanyGroup_PrevAndNext(
		long catalogItemId, long companyId, long groupId,
		boolean withdrawnStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the catalog items where companyId = &#63; and groupId = &#63; and withdrawnStatus = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param withdrawnStatus the withdrawn status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByWithdrawnCompanyGroup(long companyId, long groupId,
		boolean withdrawnStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of catalog items where companyId = &#63; and groupId = &#63; and withdrawnStatus = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param withdrawnStatus the withdrawn status
	* @return the number of matching catalog items
	* @throws SystemException if a system exception occurred
	*/
	public int countByWithdrawnCompanyGroup(long companyId, long groupId,
		boolean withdrawnStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of catalog items that the user has permission to view where companyId = &#63; and groupId = &#63; and withdrawnStatus = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param withdrawnStatus the withdrawn status
	* @return the number of matching catalog items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByWithdrawnCompanyGroup(long companyId, long groupId,
		boolean withdrawnStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the catalog items where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching catalog items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CatalogItem> findByCompanyGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the catalog items where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of catalog items
	* @param end the upper bound of the range of catalog items (not inclusive)
	* @return the range of matching catalog items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CatalogItem> findByCompanyGroup(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the catalog items where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of catalog items
	* @param end the upper bound of the range of catalog items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching catalog items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CatalogItem> findByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first catalog item in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog item
	* @throws com.kencana.lms.NoSuchCatalogItemException if a matching catalog item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CatalogItem findByCompanyGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first catalog item in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog item, or <code>null</code> if a matching catalog item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CatalogItem fetchByCompanyGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last catalog item in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog item
	* @throws com.kencana.lms.NoSuchCatalogItemException if a matching catalog item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CatalogItem findByCompanyGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last catalog item in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog item, or <code>null</code> if a matching catalog item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CatalogItem fetchByCompanyGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the catalog items before and after the current catalog item in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param catalogItemId the primary key of the current catalog item
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next catalog item
	* @throws com.kencana.lms.NoSuchCatalogItemException if a catalog item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CatalogItem[] findByCompanyGroup_PrevAndNext(
		long catalogItemId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the catalog items that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching catalog items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CatalogItem> filterFindByCompanyGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the catalog items that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of catalog items
	* @param end the upper bound of the range of catalog items (not inclusive)
	* @return the range of matching catalog items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CatalogItem> filterFindByCompanyGroup(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the catalog items that the user has permissions to view where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of catalog items
	* @param end the upper bound of the range of catalog items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching catalog items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CatalogItem> filterFindByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the catalog items before and after the current catalog item in the ordered set of catalog items that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param catalogItemId the primary key of the current catalog item
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next catalog item
	* @throws com.kencana.lms.NoSuchCatalogItemException if a catalog item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CatalogItem[] filterFindByCompanyGroup_PrevAndNext(
		long catalogItemId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the catalog items where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of catalog items where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching catalog items
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of catalog items that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching catalog items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the catalog item in the entity cache if it is enabled.
	*
	* @param catalogItem the catalog item
	*/
	public void cacheResult(com.kencana.lms.model.CatalogItem catalogItem);

	/**
	* Caches the catalog items in the entity cache if it is enabled.
	*
	* @param catalogItems the catalog items
	*/
	public void cacheResult(
		java.util.List<com.kencana.lms.model.CatalogItem> catalogItems);

	/**
	* Creates a new catalog item with the primary key. Does not add the catalog item to the database.
	*
	* @param catalogItemId the primary key for the new catalog item
	* @return the new catalog item
	*/
	public com.kencana.lms.model.CatalogItem create(long catalogItemId);

	/**
	* Removes the catalog item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param catalogItemId the primary key of the catalog item
	* @return the catalog item that was removed
	* @throws com.kencana.lms.NoSuchCatalogItemException if a catalog item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CatalogItem remove(long catalogItemId)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.kencana.lms.model.CatalogItem updateImpl(
		com.kencana.lms.model.CatalogItem catalogItem)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the catalog item with the primary key or throws a {@link com.kencana.lms.NoSuchCatalogItemException} if it could not be found.
	*
	* @param catalogItemId the primary key of the catalog item
	* @return the catalog item
	* @throws com.kencana.lms.NoSuchCatalogItemException if a catalog item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CatalogItem findByPrimaryKey(
		long catalogItemId)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the catalog item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param catalogItemId the primary key of the catalog item
	* @return the catalog item, or <code>null</code> if a catalog item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CatalogItem fetchByPrimaryKey(
		long catalogItemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the catalog items.
	*
	* @return the catalog items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CatalogItem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the catalog items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of catalog items
	* @param end the upper bound of the range of catalog items (not inclusive)
	* @return the range of catalog items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CatalogItem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the catalog items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of catalog items
	* @param end the upper bound of the range of catalog items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of catalog items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CatalogItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the catalog items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of catalog items.
	*
	* @return the number of catalog items
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}