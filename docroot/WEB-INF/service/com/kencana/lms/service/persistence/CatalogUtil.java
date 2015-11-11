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

import com.kencana.lms.model.Catalog;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the catalog service. This utility wraps {@link CatalogPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see CatalogPersistence
 * @see CatalogPersistenceImpl
 * @generated
 */
public class CatalogUtil {
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
	public static void clearCache(Catalog catalog) {
		getPersistence().clearCache(catalog);
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
	public static List<Catalog> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Catalog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Catalog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Catalog update(Catalog catalog) throws SystemException {
		return getPersistence().update(catalog);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Catalog update(Catalog catalog, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(catalog, serviceContext);
	}

	/**
	* Returns all the catalogs where templateId = &#63;.
	*
	* @param templateId the template ID
	* @return the matching catalogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.Catalog> findByTemplateId(
		long templateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTemplateId(templateId);
	}

	/**
	* Returns a range of all the catalogs where templateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param templateId the template ID
	* @param start the lower bound of the range of catalogs
	* @param end the upper bound of the range of catalogs (not inclusive)
	* @return the range of matching catalogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.Catalog> findByTemplateId(
		long templateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTemplateId(templateId, start, end);
	}

	/**
	* Returns an ordered range of all the catalogs where templateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param templateId the template ID
	* @param start the lower bound of the range of catalogs
	* @param end the upper bound of the range of catalogs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching catalogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.Catalog> findByTemplateId(
		long templateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateId(templateId, start, end, orderByComparator);
	}

	/**
	* Returns the first catalog in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog
	* @throws com.kencana.lms.NoSuchCatalogException if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog findByTemplateId_First(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateId_First(templateId, orderByComparator);
	}

	/**
	* Returns the first catalog in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog, or <code>null</code> if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog fetchByTemplateId_First(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTemplateId_First(templateId, orderByComparator);
	}

	/**
	* Returns the last catalog in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog
	* @throws com.kencana.lms.NoSuchCatalogException if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog findByTemplateId_Last(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateId_Last(templateId, orderByComparator);
	}

	/**
	* Returns the last catalog in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog, or <code>null</code> if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog fetchByTemplateId_Last(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTemplateId_Last(templateId, orderByComparator);
	}

	/**
	* Returns the catalogs before and after the current catalog in the ordered set where templateId = &#63;.
	*
	* @param catalogId the primary key of the current catalog
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next catalog
	* @throws com.kencana.lms.NoSuchCatalogException if a catalog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog[] findByTemplateId_PrevAndNext(
		long catalogId, long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateId_PrevAndNext(catalogId, templateId,
			orderByComparator);
	}

	/**
	* Removes all the catalogs where templateId = &#63; from the database.
	*
	* @param templateId the template ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTemplateId(long templateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTemplateId(templateId);
	}

	/**
	* Returns the number of catalogs where templateId = &#63;.
	*
	* @param templateId the template ID
	* @return the number of matching catalogs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTemplateId(long templateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTemplateId(templateId);
	}

	/**
	* Returns all the catalogs where itemTypeId = &#63;.
	*
	* @param itemTypeId the item type ID
	* @return the matching catalogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.Catalog> findByItemType(
		long itemTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByItemType(itemTypeId);
	}

	/**
	* Returns a range of all the catalogs where itemTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param itemTypeId the item type ID
	* @param start the lower bound of the range of catalogs
	* @param end the upper bound of the range of catalogs (not inclusive)
	* @return the range of matching catalogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.Catalog> findByItemType(
		long itemTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByItemType(itemTypeId, start, end);
	}

	/**
	* Returns an ordered range of all the catalogs where itemTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param itemTypeId the item type ID
	* @param start the lower bound of the range of catalogs
	* @param end the upper bound of the range of catalogs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching catalogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.Catalog> findByItemType(
		long itemTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByItemType(itemTypeId, start, end, orderByComparator);
	}

	/**
	* Returns the first catalog in the ordered set where itemTypeId = &#63;.
	*
	* @param itemTypeId the item type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog
	* @throws com.kencana.lms.NoSuchCatalogException if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog findByItemType_First(
		long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByItemType_First(itemTypeId, orderByComparator);
	}

	/**
	* Returns the first catalog in the ordered set where itemTypeId = &#63;.
	*
	* @param itemTypeId the item type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog, or <code>null</code> if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog fetchByItemType_First(
		long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByItemType_First(itemTypeId, orderByComparator);
	}

	/**
	* Returns the last catalog in the ordered set where itemTypeId = &#63;.
	*
	* @param itemTypeId the item type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog
	* @throws com.kencana.lms.NoSuchCatalogException if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog findByItemType_Last(
		long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByItemType_Last(itemTypeId, orderByComparator);
	}

	/**
	* Returns the last catalog in the ordered set where itemTypeId = &#63;.
	*
	* @param itemTypeId the item type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog, or <code>null</code> if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog fetchByItemType_Last(
		long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByItemType_Last(itemTypeId, orderByComparator);
	}

	/**
	* Returns the catalogs before and after the current catalog in the ordered set where itemTypeId = &#63;.
	*
	* @param catalogId the primary key of the current catalog
	* @param itemTypeId the item type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next catalog
	* @throws com.kencana.lms.NoSuchCatalogException if a catalog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog[] findByItemType_PrevAndNext(
		long catalogId, long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByItemType_PrevAndNext(catalogId, itemTypeId,
			orderByComparator);
	}

	/**
	* Removes all the catalogs where itemTypeId = &#63; from the database.
	*
	* @param itemTypeId the item type ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByItemType(long itemTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByItemType(itemTypeId);
	}

	/**
	* Returns the number of catalogs where itemTypeId = &#63;.
	*
	* @param itemTypeId the item type ID
	* @return the number of matching catalogs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByItemType(long itemTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByItemType(itemTypeId);
	}

	/**
	* Returns all the catalogs where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the matching catalogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.Catalog> findByGroupCompany(
		long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupCompany(groupId, companyId);
	}

	/**
	* Returns a range of all the catalogs where groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param start the lower bound of the range of catalogs
	* @param end the upper bound of the range of catalogs (not inclusive)
	* @return the range of matching catalogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.Catalog> findByGroupCompany(
		long groupId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCompany(groupId, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the catalogs where groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param start the lower bound of the range of catalogs
	* @param end the upper bound of the range of catalogs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching catalogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.Catalog> findByGroupCompany(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCompany(groupId, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first catalog in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog
	* @throws com.kencana.lms.NoSuchCatalogException if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog findByGroupCompany_First(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCompany_First(groupId, companyId,
			orderByComparator);
	}

	/**
	* Returns the first catalog in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog, or <code>null</code> if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog fetchByGroupCompany_First(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupCompany_First(groupId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last catalog in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog
	* @throws com.kencana.lms.NoSuchCatalogException if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog findByGroupCompany_Last(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCompany_Last(groupId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last catalog in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog, or <code>null</code> if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog fetchByGroupCompany_Last(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupCompany_Last(groupId, companyId,
			orderByComparator);
	}

	/**
	* Returns the catalogs before and after the current catalog in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param catalogId the primary key of the current catalog
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next catalog
	* @throws com.kencana.lms.NoSuchCatalogException if a catalog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog[] findByGroupCompany_PrevAndNext(
		long catalogId, long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCompany_PrevAndNext(catalogId, groupId,
			companyId, orderByComparator);
	}

	/**
	* Returns all the catalogs that the user has permission to view where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the matching catalogs that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.Catalog> filterFindByGroupCompany(
		long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupCompany(groupId, companyId);
	}

	/**
	* Returns a range of all the catalogs that the user has permission to view where groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param start the lower bound of the range of catalogs
	* @param end the upper bound of the range of catalogs (not inclusive)
	* @return the range of matching catalogs that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.Catalog> filterFindByGroupCompany(
		long groupId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupCompany(groupId, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the catalogs that the user has permissions to view where groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param start the lower bound of the range of catalogs
	* @param end the upper bound of the range of catalogs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching catalogs that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.Catalog> filterFindByGroupCompany(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupCompany(groupId, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the catalogs before and after the current catalog in the ordered set of catalogs that the user has permission to view where groupId = &#63; and companyId = &#63;.
	*
	* @param catalogId the primary key of the current catalog
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next catalog
	* @throws com.kencana.lms.NoSuchCatalogException if a catalog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog[] filterFindByGroupCompany_PrevAndNext(
		long catalogId, long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupCompany_PrevAndNext(catalogId, groupId,
			companyId, orderByComparator);
	}

	/**
	* Removes all the catalogs where groupId = &#63; and companyId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupCompany(long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupCompany(groupId, companyId);
	}

	/**
	* Returns the number of catalogs where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the number of matching catalogs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupCompany(long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupCompany(groupId, companyId);
	}

	/**
	* Returns the number of catalogs that the user has permission to view where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the number of matching catalogs that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupCompany(long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroupCompany(groupId, companyId);
	}

	/**
	* Returns all the catalogs where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching catalogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.Catalog> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

	/**
	* Returns a range of all the catalogs where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of catalogs
	* @param end the upper bound of the range of catalogs (not inclusive)
	* @return the range of matching catalogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.Catalog> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the catalogs where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of catalogs
	* @param end the upper bound of the range of catalogs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching catalogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.Catalog> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first catalog in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog
	* @throws com.kencana.lms.NoSuchCatalogException if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first catalog in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog, or <code>null</code> if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last catalog in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog
	* @throws com.kencana.lms.NoSuchCatalogException if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last catalog in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog, or <code>null</code> if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the catalogs before and after the current catalog in the ordered set where companyId = &#63;.
	*
	* @param catalogId the primary key of the current catalog
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next catalog
	* @throws com.kencana.lms.NoSuchCatalogException if a catalog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog[] findByCompany_PrevAndNext(
		long catalogId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany_PrevAndNext(catalogId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the catalogs where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Returns the number of catalogs where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching catalogs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns all the catalogs where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching catalogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.Catalog> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

	/**
	* Returns a range of all the catalogs where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of catalogs
	* @param end the upper bound of the range of catalogs (not inclusive)
	* @return the range of matching catalogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.Catalog> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the catalogs where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of catalogs
	* @param end the upper bound of the range of catalogs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching catalogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.Catalog> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first catalog in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog
	* @throws com.kencana.lms.NoSuchCatalogException if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first catalog in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog, or <code>null</code> if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last catalog in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog
	* @throws com.kencana.lms.NoSuchCatalogException if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog findByGroup_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last catalog in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog, or <code>null</code> if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the catalogs before and after the current catalog in the ordered set where groupId = &#63;.
	*
	* @param catalogId the primary key of the current catalog
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next catalog
	* @throws com.kencana.lms.NoSuchCatalogException if a catalog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog[] findByGroup_PrevAndNext(
		long catalogId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup_PrevAndNext(catalogId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the catalogs that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching catalogs that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.Catalog> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId);
	}

	/**
	* Returns a range of all the catalogs that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of catalogs
	* @param end the upper bound of the range of catalogs (not inclusive)
	* @return the range of matching catalogs that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.Catalog> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the catalogs that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of catalogs
	* @param end the upper bound of the range of catalogs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching catalogs that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.Catalog> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the catalogs before and after the current catalog in the ordered set of catalogs that the user has permission to view where groupId = &#63;.
	*
	* @param catalogId the primary key of the current catalog
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next catalog
	* @throws com.kencana.lms.NoSuchCatalogException if a catalog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog[] filterFindByGroup_PrevAndNext(
		long catalogId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup_PrevAndNext(catalogId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the catalogs where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Returns the number of catalogs where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching catalogs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of catalogs that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching catalogs that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroup(groupId);
	}

	/**
	* Returns all the catalogs where groupId = &#63; and workflowStatus = &#63;.
	*
	* @param groupId the group ID
	* @param workflowStatus the workflow status
	* @return the matching catalogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.Catalog> findByGroupStatus(
		long groupId, int workflowStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupStatus(groupId, workflowStatus);
	}

	/**
	* Returns a range of all the catalogs where groupId = &#63; and workflowStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param workflowStatus the workflow status
	* @param start the lower bound of the range of catalogs
	* @param end the upper bound of the range of catalogs (not inclusive)
	* @return the range of matching catalogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.Catalog> findByGroupStatus(
		long groupId, int workflowStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupStatus(groupId, workflowStatus, start, end);
	}

	/**
	* Returns an ordered range of all the catalogs where groupId = &#63; and workflowStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param workflowStatus the workflow status
	* @param start the lower bound of the range of catalogs
	* @param end the upper bound of the range of catalogs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching catalogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.Catalog> findByGroupStatus(
		long groupId, int workflowStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupStatus(groupId, workflowStatus, start, end,
			orderByComparator);
	}

	/**
	* Returns the first catalog in the ordered set where groupId = &#63; and workflowStatus = &#63;.
	*
	* @param groupId the group ID
	* @param workflowStatus the workflow status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog
	* @throws com.kencana.lms.NoSuchCatalogException if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog findByGroupStatus_First(
		long groupId, int workflowStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupStatus_First(groupId, workflowStatus,
			orderByComparator);
	}

	/**
	* Returns the first catalog in the ordered set where groupId = &#63; and workflowStatus = &#63;.
	*
	* @param groupId the group ID
	* @param workflowStatus the workflow status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog, or <code>null</code> if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog fetchByGroupStatus_First(
		long groupId, int workflowStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupStatus_First(groupId, workflowStatus,
			orderByComparator);
	}

	/**
	* Returns the last catalog in the ordered set where groupId = &#63; and workflowStatus = &#63;.
	*
	* @param groupId the group ID
	* @param workflowStatus the workflow status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog
	* @throws com.kencana.lms.NoSuchCatalogException if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog findByGroupStatus_Last(
		long groupId, int workflowStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupStatus_Last(groupId, workflowStatus,
			orderByComparator);
	}

	/**
	* Returns the last catalog in the ordered set where groupId = &#63; and workflowStatus = &#63;.
	*
	* @param groupId the group ID
	* @param workflowStatus the workflow status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog, or <code>null</code> if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog fetchByGroupStatus_Last(
		long groupId, int workflowStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupStatus_Last(groupId, workflowStatus,
			orderByComparator);
	}

	/**
	* Returns the catalogs before and after the current catalog in the ordered set where groupId = &#63; and workflowStatus = &#63;.
	*
	* @param catalogId the primary key of the current catalog
	* @param groupId the group ID
	* @param workflowStatus the workflow status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next catalog
	* @throws com.kencana.lms.NoSuchCatalogException if a catalog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog[] findByGroupStatus_PrevAndNext(
		long catalogId, long groupId, int workflowStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupStatus_PrevAndNext(catalogId, groupId,
			workflowStatus, orderByComparator);
	}

	/**
	* Returns all the catalogs that the user has permission to view where groupId = &#63; and workflowStatus = &#63;.
	*
	* @param groupId the group ID
	* @param workflowStatus the workflow status
	* @return the matching catalogs that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.Catalog> filterFindByGroupStatus(
		long groupId, int workflowStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupStatus(groupId, workflowStatus);
	}

	/**
	* Returns a range of all the catalogs that the user has permission to view where groupId = &#63; and workflowStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param workflowStatus the workflow status
	* @param start the lower bound of the range of catalogs
	* @param end the upper bound of the range of catalogs (not inclusive)
	* @return the range of matching catalogs that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.Catalog> filterFindByGroupStatus(
		long groupId, int workflowStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupStatus(groupId, workflowStatus, start, end);
	}

	/**
	* Returns an ordered range of all the catalogs that the user has permissions to view where groupId = &#63; and workflowStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param workflowStatus the workflow status
	* @param start the lower bound of the range of catalogs
	* @param end the upper bound of the range of catalogs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching catalogs that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.Catalog> filterFindByGroupStatus(
		long groupId, int workflowStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupStatus(groupId, workflowStatus, start,
			end, orderByComparator);
	}

	/**
	* Returns the catalogs before and after the current catalog in the ordered set of catalogs that the user has permission to view where groupId = &#63; and workflowStatus = &#63;.
	*
	* @param catalogId the primary key of the current catalog
	* @param groupId the group ID
	* @param workflowStatus the workflow status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next catalog
	* @throws com.kencana.lms.NoSuchCatalogException if a catalog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog[] filterFindByGroupStatus_PrevAndNext(
		long catalogId, long groupId, int workflowStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupStatus_PrevAndNext(catalogId, groupId,
			workflowStatus, orderByComparator);
	}

	/**
	* Removes all the catalogs where groupId = &#63; and workflowStatus = &#63; from the database.
	*
	* @param groupId the group ID
	* @param workflowStatus the workflow status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupStatus(long groupId, int workflowStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupStatus(groupId, workflowStatus);
	}

	/**
	* Returns the number of catalogs where groupId = &#63; and workflowStatus = &#63;.
	*
	* @param groupId the group ID
	* @param workflowStatus the workflow status
	* @return the number of matching catalogs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupStatus(long groupId, int workflowStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupStatus(groupId, workflowStatus);
	}

	/**
	* Returns the number of catalogs that the user has permission to view where groupId = &#63; and workflowStatus = &#63;.
	*
	* @param groupId the group ID
	* @param workflowStatus the workflow status
	* @return the number of matching catalogs that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupStatus(long groupId, int workflowStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroupStatus(groupId, workflowStatus);
	}

	/**
	* Caches the catalog in the entity cache if it is enabled.
	*
	* @param catalog the catalog
	*/
	public static void cacheResult(com.kencana.lms.model.Catalog catalog) {
		getPersistence().cacheResult(catalog);
	}

	/**
	* Caches the catalogs in the entity cache if it is enabled.
	*
	* @param catalogs the catalogs
	*/
	public static void cacheResult(
		java.util.List<com.kencana.lms.model.Catalog> catalogs) {
		getPersistence().cacheResult(catalogs);
	}

	/**
	* Creates a new catalog with the primary key. Does not add the catalog to the database.
	*
	* @param catalogId the primary key for the new catalog
	* @return the new catalog
	*/
	public static com.kencana.lms.model.Catalog create(long catalogId) {
		return getPersistence().create(catalogId);
	}

	/**
	* Removes the catalog with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param catalogId the primary key of the catalog
	* @return the catalog that was removed
	* @throws com.kencana.lms.NoSuchCatalogException if a catalog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog remove(long catalogId)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(catalogId);
	}

	public static com.kencana.lms.model.Catalog updateImpl(
		com.kencana.lms.model.Catalog catalog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(catalog);
	}

	/**
	* Returns the catalog with the primary key or throws a {@link com.kencana.lms.NoSuchCatalogException} if it could not be found.
	*
	* @param catalogId the primary key of the catalog
	* @return the catalog
	* @throws com.kencana.lms.NoSuchCatalogException if a catalog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog findByPrimaryKey(long catalogId)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(catalogId);
	}

	/**
	* Returns the catalog with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param catalogId the primary key of the catalog
	* @return the catalog, or <code>null</code> if a catalog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog fetchByPrimaryKey(
		long catalogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(catalogId);
	}

	/**
	* Returns all the catalogs.
	*
	* @return the catalogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.Catalog> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the catalogs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of catalogs
	* @param end the upper bound of the range of catalogs (not inclusive)
	* @return the range of catalogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.Catalog> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the catalogs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of catalogs
	* @param end the upper bound of the range of catalogs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of catalogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.Catalog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the catalogs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of catalogs.
	*
	* @return the number of catalogs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CatalogPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CatalogPersistence)PortletBeanLocatorUtil.locate(com.kencana.lms.service.ClpSerializer.getServletContextName(),
					CatalogPersistence.class.getName());

			ReferenceRegistry.registerReference(CatalogUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CatalogPersistence persistence) {
	}

	private static CatalogPersistence _persistence;
}