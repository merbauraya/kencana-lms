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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the catalog item service. This utility wraps {@link CatalogItemPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see CatalogItemPersistence
 * @see CatalogItemPersistenceImpl
 * @generated
 */
public class CatalogItemUtil {
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
	public static void clearCache(CatalogItem catalogItem) {
		getPersistence().clearCache(catalogItem);
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
	public static List<CatalogItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CatalogItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CatalogItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CatalogItem update(CatalogItem catalogItem)
		throws SystemException {
		return getPersistence().update(catalogItem);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CatalogItem update(CatalogItem catalogItem,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(catalogItem, serviceContext);
	}

	/**
	* Returns all the catalog items where catalogId = &#63;.
	*
	* @param catalogId the catalog ID
	* @return the matching catalog items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CatalogItem> findByCatalog(
		long catalogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCatalog(catalogId);
	}

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
	public static java.util.List<com.kencana.lms.model.CatalogItem> findByCatalog(
		long catalogId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCatalog(catalogId, start, end);
	}

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
	public static java.util.List<com.kencana.lms.model.CatalogItem> findByCatalog(
		long catalogId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCatalog(catalogId, start, end, orderByComparator);
	}

	/**
	* Returns the first catalog item in the ordered set where catalogId = &#63;.
	*
	* @param catalogId the catalog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog item
	* @throws com.kencana.lms.NoSuchCatalogItemException if a matching catalog item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogItem findByCatalog_First(
		long catalogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCatalog_First(catalogId, orderByComparator);
	}

	/**
	* Returns the first catalog item in the ordered set where catalogId = &#63;.
	*
	* @param catalogId the catalog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog item, or <code>null</code> if a matching catalog item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogItem fetchByCatalog_First(
		long catalogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCatalog_First(catalogId, orderByComparator);
	}

	/**
	* Returns the last catalog item in the ordered set where catalogId = &#63;.
	*
	* @param catalogId the catalog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog item
	* @throws com.kencana.lms.NoSuchCatalogItemException if a matching catalog item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogItem findByCatalog_Last(
		long catalogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCatalog_Last(catalogId, orderByComparator);
	}

	/**
	* Returns the last catalog item in the ordered set where catalogId = &#63;.
	*
	* @param catalogId the catalog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog item, or <code>null</code> if a matching catalog item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogItem fetchByCatalog_Last(
		long catalogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCatalog_Last(catalogId, orderByComparator);
	}

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
	public static com.kencana.lms.model.CatalogItem[] findByCatalog_PrevAndNext(
		long catalogItemId, long catalogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCatalog_PrevAndNext(catalogItemId, catalogId,
			orderByComparator);
	}

	/**
	* Removes all the catalog items where catalogId = &#63; from the database.
	*
	* @param catalogId the catalog ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCatalog(long catalogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCatalog(catalogId);
	}

	/**
	* Returns the number of catalog items where catalogId = &#63;.
	*
	* @param catalogId the catalog ID
	* @return the number of matching catalog items
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCatalog(long catalogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCatalog(catalogId);
	}

	/**
	* Returns the catalog item where companyId = &#63; and barcode = &#63; or throws a {@link com.kencana.lms.NoSuchCatalogItemException} if it could not be found.
	*
	* @param companyId the company ID
	* @param barcode the barcode
	* @return the matching catalog item
	* @throws com.kencana.lms.NoSuchCatalogItemException if a matching catalog item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogItem findByBarcode(
		long companyId, java.lang.String barcode)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBarcode(companyId, barcode);
	}

	/**
	* Returns the catalog item where companyId = &#63; and barcode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param barcode the barcode
	* @return the matching catalog item, or <code>null</code> if a matching catalog item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogItem fetchByBarcode(
		long companyId, java.lang.String barcode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByBarcode(companyId, barcode);
	}

	/**
	* Returns the catalog item where companyId = &#63; and barcode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param barcode the barcode
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching catalog item, or <code>null</code> if a matching catalog item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogItem fetchByBarcode(
		long companyId, java.lang.String barcode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBarcode(companyId, barcode, retrieveFromCache);
	}

	/**
	* Removes the catalog item where companyId = &#63; and barcode = &#63; from the database.
	*
	* @param companyId the company ID
	* @param barcode the barcode
	* @return the catalog item that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogItem removeByBarcode(
		long companyId, java.lang.String barcode)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByBarcode(companyId, barcode);
	}

	/**
	* Returns the number of catalog items where companyId = &#63; and barcode = &#63;.
	*
	* @param companyId the company ID
	* @param barcode the barcode
	* @return the number of matching catalog items
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBarcode(long companyId, java.lang.String barcode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBarcode(companyId, barcode);
	}

	/**
	* Returns all the catalog items where holdingLibraryId = &#63;.
	*
	* @param holdingLibraryId the holding library ID
	* @return the matching catalog items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CatalogItem> findByHoldingLibrary(
		long holdingLibraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByHoldingLibrary(holdingLibraryId);
	}

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
	public static java.util.List<com.kencana.lms.model.CatalogItem> findByHoldingLibrary(
		long holdingLibraryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByHoldingLibrary(holdingLibraryId, start, end);
	}

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
	public static java.util.List<com.kencana.lms.model.CatalogItem> findByHoldingLibrary(
		long holdingLibraryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByHoldingLibrary(holdingLibraryId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first catalog item in the ordered set where holdingLibraryId = &#63;.
	*
	* @param holdingLibraryId the holding library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog item
	* @throws com.kencana.lms.NoSuchCatalogItemException if a matching catalog item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogItem findByHoldingLibrary_First(
		long holdingLibraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByHoldingLibrary_First(holdingLibraryId,
			orderByComparator);
	}

	/**
	* Returns the first catalog item in the ordered set where holdingLibraryId = &#63;.
	*
	* @param holdingLibraryId the holding library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog item, or <code>null</code> if a matching catalog item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogItem fetchByHoldingLibrary_First(
		long holdingLibraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByHoldingLibrary_First(holdingLibraryId,
			orderByComparator);
	}

	/**
	* Returns the last catalog item in the ordered set where holdingLibraryId = &#63;.
	*
	* @param holdingLibraryId the holding library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog item
	* @throws com.kencana.lms.NoSuchCatalogItemException if a matching catalog item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogItem findByHoldingLibrary_Last(
		long holdingLibraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByHoldingLibrary_Last(holdingLibraryId,
			orderByComparator);
	}

	/**
	* Returns the last catalog item in the ordered set where holdingLibraryId = &#63;.
	*
	* @param holdingLibraryId the holding library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog item, or <code>null</code> if a matching catalog item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogItem fetchByHoldingLibrary_Last(
		long holdingLibraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByHoldingLibrary_Last(holdingLibraryId,
			orderByComparator);
	}

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
	public static com.kencana.lms.model.CatalogItem[] findByHoldingLibrary_PrevAndNext(
		long catalogItemId, long holdingLibraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByHoldingLibrary_PrevAndNext(catalogItemId,
			holdingLibraryId, orderByComparator);
	}

	/**
	* Removes all the catalog items where holdingLibraryId = &#63; from the database.
	*
	* @param holdingLibraryId the holding library ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByHoldingLibrary(long holdingLibraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByHoldingLibrary(holdingLibraryId);
	}

	/**
	* Returns the number of catalog items where holdingLibraryId = &#63;.
	*
	* @param holdingLibraryId the holding library ID
	* @return the number of matching catalog items
	* @throws SystemException if a system exception occurred
	*/
	public static int countByHoldingLibrary(long holdingLibraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByHoldingLibrary(holdingLibraryId);
	}

	/**
	* Returns all the catalog items where companyId = &#63; and groupId = &#63; and released = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param released the released
	* @return the matching catalog items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CatalogItem> findByReleasedCompanyGroup(
		long companyId, long groupId, boolean released)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReleasedCompanyGroup(companyId, groupId, released);
	}

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
	public static java.util.List<com.kencana.lms.model.CatalogItem> findByReleasedCompanyGroup(
		long companyId, long groupId, boolean released, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReleasedCompanyGroup(companyId, groupId, released,
			start, end);
	}

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
	public static java.util.List<com.kencana.lms.model.CatalogItem> findByReleasedCompanyGroup(
		long companyId, long groupId, boolean released, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReleasedCompanyGroup(companyId, groupId, released,
			start, end, orderByComparator);
	}

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
	public static com.kencana.lms.model.CatalogItem findByReleasedCompanyGroup_First(
		long companyId, long groupId, boolean released,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReleasedCompanyGroup_First(companyId, groupId,
			released, orderByComparator);
	}

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
	public static com.kencana.lms.model.CatalogItem fetchByReleasedCompanyGroup_First(
		long companyId, long groupId, boolean released,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByReleasedCompanyGroup_First(companyId, groupId,
			released, orderByComparator);
	}

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
	public static com.kencana.lms.model.CatalogItem findByReleasedCompanyGroup_Last(
		long companyId, long groupId, boolean released,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReleasedCompanyGroup_Last(companyId, groupId,
			released, orderByComparator);
	}

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
	public static com.kencana.lms.model.CatalogItem fetchByReleasedCompanyGroup_Last(
		long companyId, long groupId, boolean released,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByReleasedCompanyGroup_Last(companyId, groupId,
			released, orderByComparator);
	}

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
	public static com.kencana.lms.model.CatalogItem[] findByReleasedCompanyGroup_PrevAndNext(
		long catalogItemId, long companyId, long groupId, boolean released,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReleasedCompanyGroup_PrevAndNext(catalogItemId,
			companyId, groupId, released, orderByComparator);
	}

	/**
	* Returns all the catalog items that the user has permission to view where companyId = &#63; and groupId = &#63; and released = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param released the released
	* @return the matching catalog items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CatalogItem> filterFindByReleasedCompanyGroup(
		long companyId, long groupId, boolean released)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByReleasedCompanyGroup(companyId, groupId,
			released);
	}

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
	public static java.util.List<com.kencana.lms.model.CatalogItem> filterFindByReleasedCompanyGroup(
		long companyId, long groupId, boolean released, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByReleasedCompanyGroup(companyId, groupId,
			released, start, end);
	}

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
	public static java.util.List<com.kencana.lms.model.CatalogItem> filterFindByReleasedCompanyGroup(
		long companyId, long groupId, boolean released, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByReleasedCompanyGroup(companyId, groupId,
			released, start, end, orderByComparator);
	}

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
	public static com.kencana.lms.model.CatalogItem[] filterFindByReleasedCompanyGroup_PrevAndNext(
		long catalogItemId, long companyId, long groupId, boolean released,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByReleasedCompanyGroup_PrevAndNext(catalogItemId,
			companyId, groupId, released, orderByComparator);
	}

	/**
	* Removes all the catalog items where companyId = &#63; and groupId = &#63; and released = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param released the released
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByReleasedCompanyGroup(long companyId,
		long groupId, boolean released)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByReleasedCompanyGroup(companyId, groupId, released);
	}

	/**
	* Returns the number of catalog items where companyId = &#63; and groupId = &#63; and released = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param released the released
	* @return the number of matching catalog items
	* @throws SystemException if a system exception occurred
	*/
	public static int countByReleasedCompanyGroup(long companyId, long groupId,
		boolean released)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByReleasedCompanyGroup(companyId, groupId, released);
	}

	/**
	* Returns the number of catalog items that the user has permission to view where companyId = &#63; and groupId = &#63; and released = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param released the released
	* @return the number of matching catalog items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByReleasedCompanyGroup(long companyId,
		long groupId, boolean released)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByReleasedCompanyGroup(companyId, groupId,
			released);
	}

	/**
	* Returns all the catalog items where companyId = &#63; and groupId = &#63; and withdrawnStatus = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param withdrawnStatus the withdrawn status
	* @return the matching catalog items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CatalogItem> findByWithdrawnCompanyGroup(
		long companyId, long groupId, boolean withdrawnStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByWithdrawnCompanyGroup(companyId, groupId,
			withdrawnStatus);
	}

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
	public static java.util.List<com.kencana.lms.model.CatalogItem> findByWithdrawnCompanyGroup(
		long companyId, long groupId, boolean withdrawnStatus, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByWithdrawnCompanyGroup(companyId, groupId,
			withdrawnStatus, start, end);
	}

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
	public static java.util.List<com.kencana.lms.model.CatalogItem> findByWithdrawnCompanyGroup(
		long companyId, long groupId, boolean withdrawnStatus, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByWithdrawnCompanyGroup(companyId, groupId,
			withdrawnStatus, start, end, orderByComparator);
	}

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
	public static com.kencana.lms.model.CatalogItem findByWithdrawnCompanyGroup_First(
		long companyId, long groupId, boolean withdrawnStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByWithdrawnCompanyGroup_First(companyId, groupId,
			withdrawnStatus, orderByComparator);
	}

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
	public static com.kencana.lms.model.CatalogItem fetchByWithdrawnCompanyGroup_First(
		long companyId, long groupId, boolean withdrawnStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByWithdrawnCompanyGroup_First(companyId, groupId,
			withdrawnStatus, orderByComparator);
	}

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
	public static com.kencana.lms.model.CatalogItem findByWithdrawnCompanyGroup_Last(
		long companyId, long groupId, boolean withdrawnStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByWithdrawnCompanyGroup_Last(companyId, groupId,
			withdrawnStatus, orderByComparator);
	}

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
	public static com.kencana.lms.model.CatalogItem fetchByWithdrawnCompanyGroup_Last(
		long companyId, long groupId, boolean withdrawnStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByWithdrawnCompanyGroup_Last(companyId, groupId,
			withdrawnStatus, orderByComparator);
	}

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
	public static com.kencana.lms.model.CatalogItem[] findByWithdrawnCompanyGroup_PrevAndNext(
		long catalogItemId, long companyId, long groupId,
		boolean withdrawnStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByWithdrawnCompanyGroup_PrevAndNext(catalogItemId,
			companyId, groupId, withdrawnStatus, orderByComparator);
	}

	/**
	* Returns all the catalog items that the user has permission to view where companyId = &#63; and groupId = &#63; and withdrawnStatus = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param withdrawnStatus the withdrawn status
	* @return the matching catalog items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CatalogItem> filterFindByWithdrawnCompanyGroup(
		long companyId, long groupId, boolean withdrawnStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByWithdrawnCompanyGroup(companyId, groupId,
			withdrawnStatus);
	}

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
	public static java.util.List<com.kencana.lms.model.CatalogItem> filterFindByWithdrawnCompanyGroup(
		long companyId, long groupId, boolean withdrawnStatus, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByWithdrawnCompanyGroup(companyId, groupId,
			withdrawnStatus, start, end);
	}

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
	public static java.util.List<com.kencana.lms.model.CatalogItem> filterFindByWithdrawnCompanyGroup(
		long companyId, long groupId, boolean withdrawnStatus, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByWithdrawnCompanyGroup(companyId, groupId,
			withdrawnStatus, start, end, orderByComparator);
	}

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
	public static com.kencana.lms.model.CatalogItem[] filterFindByWithdrawnCompanyGroup_PrevAndNext(
		long catalogItemId, long companyId, long groupId,
		boolean withdrawnStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByWithdrawnCompanyGroup_PrevAndNext(catalogItemId,
			companyId, groupId, withdrawnStatus, orderByComparator);
	}

	/**
	* Removes all the catalog items where companyId = &#63; and groupId = &#63; and withdrawnStatus = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param withdrawnStatus the withdrawn status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByWithdrawnCompanyGroup(long companyId,
		long groupId, boolean withdrawnStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByWithdrawnCompanyGroup(companyId, groupId, withdrawnStatus);
	}

	/**
	* Returns the number of catalog items where companyId = &#63; and groupId = &#63; and withdrawnStatus = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param withdrawnStatus the withdrawn status
	* @return the number of matching catalog items
	* @throws SystemException if a system exception occurred
	*/
	public static int countByWithdrawnCompanyGroup(long companyId,
		long groupId, boolean withdrawnStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByWithdrawnCompanyGroup(companyId, groupId,
			withdrawnStatus);
	}

	/**
	* Returns the number of catalog items that the user has permission to view where companyId = &#63; and groupId = &#63; and withdrawnStatus = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param withdrawnStatus the withdrawn status
	* @return the number of matching catalog items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByWithdrawnCompanyGroup(long companyId,
		long groupId, boolean withdrawnStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByWithdrawnCompanyGroup(companyId, groupId,
			withdrawnStatus);
	}

	/**
	* Returns all the catalog items where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching catalog items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CatalogItem> findByCompanyGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyGroup(companyId, groupId);
	}

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
	public static java.util.List<com.kencana.lms.model.CatalogItem> findByCompanyGroup(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyGroup(companyId, groupId, start, end);
	}

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
	public static java.util.List<com.kencana.lms.model.CatalogItem> findByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyGroup(companyId, groupId, start, end,
			orderByComparator);
	}

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
	public static com.kencana.lms.model.CatalogItem findByCompanyGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyGroup_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first catalog item in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog item, or <code>null</code> if a matching catalog item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogItem fetchByCompanyGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyGroup_First(companyId, groupId,
			orderByComparator);
	}

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
	public static com.kencana.lms.model.CatalogItem findByCompanyGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyGroup_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last catalog item in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog item, or <code>null</code> if a matching catalog item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogItem fetchByCompanyGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyGroup_Last(companyId, groupId,
			orderByComparator);
	}

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
	public static com.kencana.lms.model.CatalogItem[] findByCompanyGroup_PrevAndNext(
		long catalogItemId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyGroup_PrevAndNext(catalogItemId, companyId,
			groupId, orderByComparator);
	}

	/**
	* Returns all the catalog items that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching catalog items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CatalogItem> filterFindByCompanyGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByCompanyGroup(companyId, groupId);
	}

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
	public static java.util.List<com.kencana.lms.model.CatalogItem> filterFindByCompanyGroup(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCompanyGroup(companyId, groupId, start, end);
	}

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
	public static java.util.List<com.kencana.lms.model.CatalogItem> filterFindByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCompanyGroup(companyId, groupId, start, end,
			orderByComparator);
	}

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
	public static com.kencana.lms.model.CatalogItem[] filterFindByCompanyGroup_PrevAndNext(
		long catalogItemId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCompanyGroup_PrevAndNext(catalogItemId,
			companyId, groupId, orderByComparator);
	}

	/**
	* Removes all the catalog items where companyId = &#63; and groupId = &#63; from the database.
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
	* Returns the number of catalog items where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching catalog items
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyGroup(companyId, groupId);
	}

	/**
	* Returns the number of catalog items that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching catalog items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByCompanyGroup(companyId, groupId);
	}

	/**
	* Caches the catalog item in the entity cache if it is enabled.
	*
	* @param catalogItem the catalog item
	*/
	public static void cacheResult(
		com.kencana.lms.model.CatalogItem catalogItem) {
		getPersistence().cacheResult(catalogItem);
	}

	/**
	* Caches the catalog items in the entity cache if it is enabled.
	*
	* @param catalogItems the catalog items
	*/
	public static void cacheResult(
		java.util.List<com.kencana.lms.model.CatalogItem> catalogItems) {
		getPersistence().cacheResult(catalogItems);
	}

	/**
	* Creates a new catalog item with the primary key. Does not add the catalog item to the database.
	*
	* @param catalogItemId the primary key for the new catalog item
	* @return the new catalog item
	*/
	public static com.kencana.lms.model.CatalogItem create(long catalogItemId) {
		return getPersistence().create(catalogItemId);
	}

	/**
	* Removes the catalog item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param catalogItemId the primary key of the catalog item
	* @return the catalog item that was removed
	* @throws com.kencana.lms.NoSuchCatalogItemException if a catalog item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogItem remove(long catalogItemId)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(catalogItemId);
	}

	public static com.kencana.lms.model.CatalogItem updateImpl(
		com.kencana.lms.model.CatalogItem catalogItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(catalogItem);
	}

	/**
	* Returns the catalog item with the primary key or throws a {@link com.kencana.lms.NoSuchCatalogItemException} if it could not be found.
	*
	* @param catalogItemId the primary key of the catalog item
	* @return the catalog item
	* @throws com.kencana.lms.NoSuchCatalogItemException if a catalog item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogItem findByPrimaryKey(
		long catalogItemId)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(catalogItemId);
	}

	/**
	* Returns the catalog item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param catalogItemId the primary key of the catalog item
	* @return the catalog item, or <code>null</code> if a catalog item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogItem fetchByPrimaryKey(
		long catalogItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(catalogItemId);
	}

	/**
	* Returns all the catalog items.
	*
	* @return the catalog items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CatalogItem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.kencana.lms.model.CatalogItem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.kencana.lms.model.CatalogItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the catalog items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of catalog items.
	*
	* @return the number of catalog items
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CatalogItemPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CatalogItemPersistence)PortletBeanLocatorUtil.locate(com.kencana.lms.service.ClpSerializer.getServletContextName(),
					CatalogItemPersistence.class.getName());

			ReferenceRegistry.registerReference(CatalogItemUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CatalogItemPersistence persistence) {
	}

	private static CatalogItemPersistence _persistence;
}