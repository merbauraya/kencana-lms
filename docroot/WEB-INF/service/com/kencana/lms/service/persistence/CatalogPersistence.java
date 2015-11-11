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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the catalog service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see CatalogPersistenceImpl
 * @see CatalogUtil
 * @generated
 */
public interface CatalogPersistence extends BasePersistence<Catalog> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CatalogUtil} to access the catalog persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the catalogs where templateId = &#63;.
	*
	* @param templateId the template ID
	* @return the matching catalogs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.Catalog> findByTemplateId(
		long templateId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.Catalog> findByTemplateId(
		long templateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.Catalog> findByTemplateId(
		long templateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first catalog in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog
	* @throws com.kencana.lms.NoSuchCatalogException if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Catalog findByTemplateId_First(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first catalog in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog, or <code>null</code> if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Catalog fetchByTemplateId_First(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last catalog in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog
	* @throws com.kencana.lms.NoSuchCatalogException if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Catalog findByTemplateId_Last(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last catalog in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog, or <code>null</code> if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Catalog fetchByTemplateId_Last(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.Catalog[] findByTemplateId_PrevAndNext(
		long catalogId, long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the catalogs where templateId = &#63; from the database.
	*
	* @param templateId the template ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTemplateId(long templateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of catalogs where templateId = &#63;.
	*
	* @param templateId the template ID
	* @return the number of matching catalogs
	* @throws SystemException if a system exception occurred
	*/
	public int countByTemplateId(long templateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the catalogs where itemTypeId = &#63;.
	*
	* @param itemTypeId the item type ID
	* @return the matching catalogs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.Catalog> findByItemType(
		long itemTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.Catalog> findByItemType(
		long itemTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.Catalog> findByItemType(
		long itemTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first catalog in the ordered set where itemTypeId = &#63;.
	*
	* @param itemTypeId the item type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog
	* @throws com.kencana.lms.NoSuchCatalogException if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Catalog findByItemType_First(long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first catalog in the ordered set where itemTypeId = &#63;.
	*
	* @param itemTypeId the item type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog, or <code>null</code> if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Catalog fetchByItemType_First(
		long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last catalog in the ordered set where itemTypeId = &#63;.
	*
	* @param itemTypeId the item type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog
	* @throws com.kencana.lms.NoSuchCatalogException if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Catalog findByItemType_Last(long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last catalog in the ordered set where itemTypeId = &#63;.
	*
	* @param itemTypeId the item type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog, or <code>null</code> if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Catalog fetchByItemType_Last(long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.Catalog[] findByItemType_PrevAndNext(
		long catalogId, long itemTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the catalogs where itemTypeId = &#63; from the database.
	*
	* @param itemTypeId the item type ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByItemType(long itemTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of catalogs where itemTypeId = &#63;.
	*
	* @param itemTypeId the item type ID
	* @return the number of matching catalogs
	* @throws SystemException if a system exception occurred
	*/
	public int countByItemType(long itemTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the catalogs where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the matching catalogs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.Catalog> findByGroupCompany(
		long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.Catalog> findByGroupCompany(
		long groupId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.Catalog> findByGroupCompany(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.Catalog findByGroupCompany_First(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first catalog in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog, or <code>null</code> if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Catalog fetchByGroupCompany_First(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.Catalog findByGroupCompany_Last(long groupId,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last catalog in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog, or <code>null</code> if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Catalog fetchByGroupCompany_Last(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.Catalog[] findByGroupCompany_PrevAndNext(
		long catalogId, long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the catalogs that the user has permission to view where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the matching catalogs that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.Catalog> filterFindByGroupCompany(
		long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.Catalog> filterFindByGroupCompany(
		long groupId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.Catalog> filterFindByGroupCompany(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.Catalog[] filterFindByGroupCompany_PrevAndNext(
		long catalogId, long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the catalogs where groupId = &#63; and companyId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupCompany(long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of catalogs where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the number of matching catalogs
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupCompany(long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of catalogs that the user has permission to view where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the number of matching catalogs that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupCompany(long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the catalogs where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching catalogs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.Catalog> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.Catalog> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.Catalog> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first catalog in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog
	* @throws com.kencana.lms.NoSuchCatalogException if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Catalog findByCompany_First(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first catalog in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog, or <code>null</code> if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Catalog fetchByCompany_First(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last catalog in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog
	* @throws com.kencana.lms.NoSuchCatalogException if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Catalog findByCompany_Last(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last catalog in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog, or <code>null</code> if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Catalog fetchByCompany_Last(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.Catalog[] findByCompany_PrevAndNext(
		long catalogId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the catalogs where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of catalogs where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching catalogs
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the catalogs where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching catalogs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.Catalog> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.Catalog> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.Catalog> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first catalog in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog
	* @throws com.kencana.lms.NoSuchCatalogException if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Catalog findByGroup_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first catalog in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog, or <code>null</code> if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Catalog fetchByGroup_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last catalog in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog
	* @throws com.kencana.lms.NoSuchCatalogException if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Catalog findByGroup_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last catalog in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog, or <code>null</code> if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Catalog fetchByGroup_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.Catalog[] findByGroup_PrevAndNext(
		long catalogId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the catalogs that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching catalogs that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.Catalog> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.Catalog> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.Catalog> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.Catalog[] filterFindByGroup_PrevAndNext(
		long catalogId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the catalogs where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of catalogs where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching catalogs
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of catalogs that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching catalogs that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the catalogs where groupId = &#63; and workflowStatus = &#63;.
	*
	* @param groupId the group ID
	* @param workflowStatus the workflow status
	* @return the matching catalogs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.Catalog> findByGroupStatus(
		long groupId, int workflowStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.Catalog> findByGroupStatus(
		long groupId, int workflowStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.Catalog> findByGroupStatus(
		long groupId, int workflowStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.Catalog findByGroupStatus_First(long groupId,
		int workflowStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first catalog in the ordered set where groupId = &#63; and workflowStatus = &#63;.
	*
	* @param groupId the group ID
	* @param workflowStatus the workflow status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog, or <code>null</code> if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Catalog fetchByGroupStatus_First(
		long groupId, int workflowStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.Catalog findByGroupStatus_Last(long groupId,
		int workflowStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last catalog in the ordered set where groupId = &#63; and workflowStatus = &#63;.
	*
	* @param groupId the group ID
	* @param workflowStatus the workflow status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog, or <code>null</code> if a matching catalog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Catalog fetchByGroupStatus_Last(long groupId,
		int workflowStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.Catalog[] findByGroupStatus_PrevAndNext(
		long catalogId, long groupId, int workflowStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the catalogs that the user has permission to view where groupId = &#63; and workflowStatus = &#63;.
	*
	* @param groupId the group ID
	* @param workflowStatus the workflow status
	* @return the matching catalogs that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.Catalog> filterFindByGroupStatus(
		long groupId, int workflowStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.Catalog> filterFindByGroupStatus(
		long groupId, int workflowStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.Catalog> filterFindByGroupStatus(
		long groupId, int workflowStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.kencana.lms.model.Catalog[] filterFindByGroupStatus_PrevAndNext(
		long catalogId, long groupId, int workflowStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the catalogs where groupId = &#63; and workflowStatus = &#63; from the database.
	*
	* @param groupId the group ID
	* @param workflowStatus the workflow status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupStatus(long groupId, int workflowStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of catalogs where groupId = &#63; and workflowStatus = &#63;.
	*
	* @param groupId the group ID
	* @param workflowStatus the workflow status
	* @return the number of matching catalogs
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupStatus(long groupId, int workflowStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of catalogs that the user has permission to view where groupId = &#63; and workflowStatus = &#63;.
	*
	* @param groupId the group ID
	* @param workflowStatus the workflow status
	* @return the number of matching catalogs that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupStatus(long groupId, int workflowStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the catalog in the entity cache if it is enabled.
	*
	* @param catalog the catalog
	*/
	public void cacheResult(com.kencana.lms.model.Catalog catalog);

	/**
	* Caches the catalogs in the entity cache if it is enabled.
	*
	* @param catalogs the catalogs
	*/
	public void cacheResult(
		java.util.List<com.kencana.lms.model.Catalog> catalogs);

	/**
	* Creates a new catalog with the primary key. Does not add the catalog to the database.
	*
	* @param catalogId the primary key for the new catalog
	* @return the new catalog
	*/
	public com.kencana.lms.model.Catalog create(long catalogId);

	/**
	* Removes the catalog with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param catalogId the primary key of the catalog
	* @return the catalog that was removed
	* @throws com.kencana.lms.NoSuchCatalogException if a catalog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Catalog remove(long catalogId)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.kencana.lms.model.Catalog updateImpl(
		com.kencana.lms.model.Catalog catalog)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the catalog with the primary key or throws a {@link com.kencana.lms.NoSuchCatalogException} if it could not be found.
	*
	* @param catalogId the primary key of the catalog
	* @return the catalog
	* @throws com.kencana.lms.NoSuchCatalogException if a catalog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Catalog findByPrimaryKey(long catalogId)
		throws com.kencana.lms.NoSuchCatalogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the catalog with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param catalogId the primary key of the catalog
	* @return the catalog, or <code>null</code> if a catalog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Catalog fetchByPrimaryKey(long catalogId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the catalogs.
	*
	* @return the catalogs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.Catalog> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.Catalog> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.Catalog> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the catalogs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of catalogs.
	*
	* @return the number of catalogs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}