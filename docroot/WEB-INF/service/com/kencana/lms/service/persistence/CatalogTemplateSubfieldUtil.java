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

import com.kencana.lms.model.CatalogTemplateSubfield;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the catalog template subfield service. This utility wraps {@link CatalogTemplateSubfieldPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see CatalogTemplateSubfieldPersistence
 * @see CatalogTemplateSubfieldPersistenceImpl
 * @generated
 */
public class CatalogTemplateSubfieldUtil {
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
	public static void clearCache(
		CatalogTemplateSubfield catalogTemplateSubfield) {
		getPersistence().clearCache(catalogTemplateSubfield);
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
	public static List<CatalogTemplateSubfield> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CatalogTemplateSubfield> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CatalogTemplateSubfield> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CatalogTemplateSubfield update(
		CatalogTemplateSubfield catalogTemplateSubfield)
		throws SystemException {
		return getPersistence().update(catalogTemplateSubfield);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CatalogTemplateSubfield update(
		CatalogTemplateSubfield catalogTemplateSubfield,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(catalogTemplateSubfield, serviceContext);
	}

	/**
	* Returns all the catalog template subfields where catalogTemplateTagId = &#63;.
	*
	* @param catalogTemplateTagId the catalog template tag ID
	* @return the matching catalog template subfields
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CatalogTemplateSubfield> findByTag(
		long catalogTemplateTagId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTag(catalogTemplateTagId);
	}

	/**
	* Returns a range of all the catalog template subfields where catalogTemplateTagId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogTemplateSubfieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param catalogTemplateTagId the catalog template tag ID
	* @param start the lower bound of the range of catalog template subfields
	* @param end the upper bound of the range of catalog template subfields (not inclusive)
	* @return the range of matching catalog template subfields
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CatalogTemplateSubfield> findByTag(
		long catalogTemplateTagId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTag(catalogTemplateTagId, start, end);
	}

	/**
	* Returns an ordered range of all the catalog template subfields where catalogTemplateTagId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogTemplateSubfieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param catalogTemplateTagId the catalog template tag ID
	* @param start the lower bound of the range of catalog template subfields
	* @param end the upper bound of the range of catalog template subfields (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching catalog template subfields
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CatalogTemplateSubfield> findByTag(
		long catalogTemplateTagId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTag(catalogTemplateTagId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first catalog template subfield in the ordered set where catalogTemplateTagId = &#63;.
	*
	* @param catalogTemplateTagId the catalog template tag ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog template subfield
	* @throws com.kencana.lms.NoSuchCatalogTemplateSubfieldException if a matching catalog template subfield could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogTemplateSubfield findByTag_First(
		long catalogTemplateTagId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogTemplateSubfieldException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTag_First(catalogTemplateTagId, orderByComparator);
	}

	/**
	* Returns the first catalog template subfield in the ordered set where catalogTemplateTagId = &#63;.
	*
	* @param catalogTemplateTagId the catalog template tag ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog template subfield, or <code>null</code> if a matching catalog template subfield could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogTemplateSubfield fetchByTag_First(
		long catalogTemplateTagId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTag_First(catalogTemplateTagId, orderByComparator);
	}

	/**
	* Returns the last catalog template subfield in the ordered set where catalogTemplateTagId = &#63;.
	*
	* @param catalogTemplateTagId the catalog template tag ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog template subfield
	* @throws com.kencana.lms.NoSuchCatalogTemplateSubfieldException if a matching catalog template subfield could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogTemplateSubfield findByTag_Last(
		long catalogTemplateTagId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogTemplateSubfieldException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTag_Last(catalogTemplateTagId, orderByComparator);
	}

	/**
	* Returns the last catalog template subfield in the ordered set where catalogTemplateTagId = &#63;.
	*
	* @param catalogTemplateTagId the catalog template tag ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog template subfield, or <code>null</code> if a matching catalog template subfield could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogTemplateSubfield fetchByTag_Last(
		long catalogTemplateTagId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTag_Last(catalogTemplateTagId, orderByComparator);
	}

	/**
	* Returns the catalog template subfields before and after the current catalog template subfield in the ordered set where catalogTemplateTagId = &#63;.
	*
	* @param catalogTemplateSubfieldId the primary key of the current catalog template subfield
	* @param catalogTemplateTagId the catalog template tag ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next catalog template subfield
	* @throws com.kencana.lms.NoSuchCatalogTemplateSubfieldException if a catalog template subfield with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogTemplateSubfield[] findByTag_PrevAndNext(
		long catalogTemplateSubfieldId, long catalogTemplateTagId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogTemplateSubfieldException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTag_PrevAndNext(catalogTemplateSubfieldId,
			catalogTemplateTagId, orderByComparator);
	}

	/**
	* Removes all the catalog template subfields where catalogTemplateTagId = &#63; from the database.
	*
	* @param catalogTemplateTagId the catalog template tag ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTag(long catalogTemplateTagId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTag(catalogTemplateTagId);
	}

	/**
	* Returns the number of catalog template subfields where catalogTemplateTagId = &#63;.
	*
	* @param catalogTemplateTagId the catalog template tag ID
	* @return the number of matching catalog template subfields
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTag(long catalogTemplateTagId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTag(catalogTemplateTagId);
	}

	/**
	* Caches the catalog template subfield in the entity cache if it is enabled.
	*
	* @param catalogTemplateSubfield the catalog template subfield
	*/
	public static void cacheResult(
		com.kencana.lms.model.CatalogTemplateSubfield catalogTemplateSubfield) {
		getPersistence().cacheResult(catalogTemplateSubfield);
	}

	/**
	* Caches the catalog template subfields in the entity cache if it is enabled.
	*
	* @param catalogTemplateSubfields the catalog template subfields
	*/
	public static void cacheResult(
		java.util.List<com.kencana.lms.model.CatalogTemplateSubfield> catalogTemplateSubfields) {
		getPersistence().cacheResult(catalogTemplateSubfields);
	}

	/**
	* Creates a new catalog template subfield with the primary key. Does not add the catalog template subfield to the database.
	*
	* @param catalogTemplateSubfieldId the primary key for the new catalog template subfield
	* @return the new catalog template subfield
	*/
	public static com.kencana.lms.model.CatalogTemplateSubfield create(
		long catalogTemplateSubfieldId) {
		return getPersistence().create(catalogTemplateSubfieldId);
	}

	/**
	* Removes the catalog template subfield with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param catalogTemplateSubfieldId the primary key of the catalog template subfield
	* @return the catalog template subfield that was removed
	* @throws com.kencana.lms.NoSuchCatalogTemplateSubfieldException if a catalog template subfield with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogTemplateSubfield remove(
		long catalogTemplateSubfieldId)
		throws com.kencana.lms.NoSuchCatalogTemplateSubfieldException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(catalogTemplateSubfieldId);
	}

	public static com.kencana.lms.model.CatalogTemplateSubfield updateImpl(
		com.kencana.lms.model.CatalogTemplateSubfield catalogTemplateSubfield)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(catalogTemplateSubfield);
	}

	/**
	* Returns the catalog template subfield with the primary key or throws a {@link com.kencana.lms.NoSuchCatalogTemplateSubfieldException} if it could not be found.
	*
	* @param catalogTemplateSubfieldId the primary key of the catalog template subfield
	* @return the catalog template subfield
	* @throws com.kencana.lms.NoSuchCatalogTemplateSubfieldException if a catalog template subfield with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogTemplateSubfield findByPrimaryKey(
		long catalogTemplateSubfieldId)
		throws com.kencana.lms.NoSuchCatalogTemplateSubfieldException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(catalogTemplateSubfieldId);
	}

	/**
	* Returns the catalog template subfield with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param catalogTemplateSubfieldId the primary key of the catalog template subfield
	* @return the catalog template subfield, or <code>null</code> if a catalog template subfield with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogTemplateSubfield fetchByPrimaryKey(
		long catalogTemplateSubfieldId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(catalogTemplateSubfieldId);
	}

	/**
	* Returns all the catalog template subfields.
	*
	* @return the catalog template subfields
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CatalogTemplateSubfield> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the catalog template subfields.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogTemplateSubfieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of catalog template subfields
	* @param end the upper bound of the range of catalog template subfields (not inclusive)
	* @return the range of catalog template subfields
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CatalogTemplateSubfield> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the catalog template subfields.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogTemplateSubfieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of catalog template subfields
	* @param end the upper bound of the range of catalog template subfields (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of catalog template subfields
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CatalogTemplateSubfield> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the catalog template subfields from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of catalog template subfields.
	*
	* @return the number of catalog template subfields
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CatalogTemplateSubfieldPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CatalogTemplateSubfieldPersistence)PortletBeanLocatorUtil.locate(com.kencana.lms.service.ClpSerializer.getServletContextName(),
					CatalogTemplateSubfieldPersistence.class.getName());

			ReferenceRegistry.registerReference(CatalogTemplateSubfieldUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CatalogTemplateSubfieldPersistence persistence) {
	}

	private static CatalogTemplateSubfieldPersistence _persistence;
}