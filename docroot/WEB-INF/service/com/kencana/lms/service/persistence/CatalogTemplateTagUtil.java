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

import com.kencana.lms.model.CatalogTemplateTag;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the catalog template tag service. This utility wraps {@link CatalogTemplateTagPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see CatalogTemplateTagPersistence
 * @see CatalogTemplateTagPersistenceImpl
 * @generated
 */
public class CatalogTemplateTagUtil {
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
	public static void clearCache(CatalogTemplateTag catalogTemplateTag) {
		getPersistence().clearCache(catalogTemplateTag);
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
	public static List<CatalogTemplateTag> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CatalogTemplateTag> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CatalogTemplateTag> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CatalogTemplateTag update(
		CatalogTemplateTag catalogTemplateTag) throws SystemException {
		return getPersistence().update(catalogTemplateTag);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CatalogTemplateTag update(
		CatalogTemplateTag catalogTemplateTag, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(catalogTemplateTag, serviceContext);
	}

	/**
	* Returns all the catalog template tags where catelogTemplateId = &#63;.
	*
	* @param catelogTemplateId the catelog template ID
	* @return the matching catalog template tags
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CatalogTemplateTag> findByTemplate(
		long catelogTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTemplate(catelogTemplateId);
	}

	/**
	* Returns a range of all the catalog template tags where catelogTemplateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogTemplateTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param catelogTemplateId the catelog template ID
	* @param start the lower bound of the range of catalog template tags
	* @param end the upper bound of the range of catalog template tags (not inclusive)
	* @return the range of matching catalog template tags
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CatalogTemplateTag> findByTemplate(
		long catelogTemplateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTemplate(catelogTemplateId, start, end);
	}

	/**
	* Returns an ordered range of all the catalog template tags where catelogTemplateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogTemplateTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param catelogTemplateId the catelog template ID
	* @param start the lower bound of the range of catalog template tags
	* @param end the upper bound of the range of catalog template tags (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching catalog template tags
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CatalogTemplateTag> findByTemplate(
		long catelogTemplateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplate(catelogTemplateId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first catalog template tag in the ordered set where catelogTemplateId = &#63;.
	*
	* @param catelogTemplateId the catelog template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog template tag
	* @throws com.kencana.lms.NoSuchCatalogTemplateTagException if a matching catalog template tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogTemplateTag findByTemplate_First(
		long catelogTemplateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogTemplateTagException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplate_First(catelogTemplateId, orderByComparator);
	}

	/**
	* Returns the first catalog template tag in the ordered set where catelogTemplateId = &#63;.
	*
	* @param catelogTemplateId the catelog template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching catalog template tag, or <code>null</code> if a matching catalog template tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogTemplateTag fetchByTemplate_First(
		long catelogTemplateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTemplate_First(catelogTemplateId, orderByComparator);
	}

	/**
	* Returns the last catalog template tag in the ordered set where catelogTemplateId = &#63;.
	*
	* @param catelogTemplateId the catelog template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog template tag
	* @throws com.kencana.lms.NoSuchCatalogTemplateTagException if a matching catalog template tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogTemplateTag findByTemplate_Last(
		long catelogTemplateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogTemplateTagException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplate_Last(catelogTemplateId, orderByComparator);
	}

	/**
	* Returns the last catalog template tag in the ordered set where catelogTemplateId = &#63;.
	*
	* @param catelogTemplateId the catelog template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching catalog template tag, or <code>null</code> if a matching catalog template tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogTemplateTag fetchByTemplate_Last(
		long catelogTemplateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTemplate_Last(catelogTemplateId, orderByComparator);
	}

	/**
	* Returns the catalog template tags before and after the current catalog template tag in the ordered set where catelogTemplateId = &#63;.
	*
	* @param catelogTemplateTagId the primary key of the current catalog template tag
	* @param catelogTemplateId the catelog template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next catalog template tag
	* @throws com.kencana.lms.NoSuchCatalogTemplateTagException if a catalog template tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogTemplateTag[] findByTemplate_PrevAndNext(
		long catelogTemplateTagId, long catelogTemplateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCatalogTemplateTagException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplate_PrevAndNext(catelogTemplateTagId,
			catelogTemplateId, orderByComparator);
	}

	/**
	* Removes all the catalog template tags where catelogTemplateId = &#63; from the database.
	*
	* @param catelogTemplateId the catelog template ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTemplate(long catelogTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTemplate(catelogTemplateId);
	}

	/**
	* Returns the number of catalog template tags where catelogTemplateId = &#63;.
	*
	* @param catelogTemplateId the catelog template ID
	* @return the number of matching catalog template tags
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTemplate(long catelogTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTemplate(catelogTemplateId);
	}

	/**
	* Caches the catalog template tag in the entity cache if it is enabled.
	*
	* @param catalogTemplateTag the catalog template tag
	*/
	public static void cacheResult(
		com.kencana.lms.model.CatalogTemplateTag catalogTemplateTag) {
		getPersistence().cacheResult(catalogTemplateTag);
	}

	/**
	* Caches the catalog template tags in the entity cache if it is enabled.
	*
	* @param catalogTemplateTags the catalog template tags
	*/
	public static void cacheResult(
		java.util.List<com.kencana.lms.model.CatalogTemplateTag> catalogTemplateTags) {
		getPersistence().cacheResult(catalogTemplateTags);
	}

	/**
	* Creates a new catalog template tag with the primary key. Does not add the catalog template tag to the database.
	*
	* @param catelogTemplateTagId the primary key for the new catalog template tag
	* @return the new catalog template tag
	*/
	public static com.kencana.lms.model.CatalogTemplateTag create(
		long catelogTemplateTagId) {
		return getPersistence().create(catelogTemplateTagId);
	}

	/**
	* Removes the catalog template tag with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param catelogTemplateTagId the primary key of the catalog template tag
	* @return the catalog template tag that was removed
	* @throws com.kencana.lms.NoSuchCatalogTemplateTagException if a catalog template tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogTemplateTag remove(
		long catelogTemplateTagId)
		throws com.kencana.lms.NoSuchCatalogTemplateTagException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(catelogTemplateTagId);
	}

	public static com.kencana.lms.model.CatalogTemplateTag updateImpl(
		com.kencana.lms.model.CatalogTemplateTag catalogTemplateTag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(catalogTemplateTag);
	}

	/**
	* Returns the catalog template tag with the primary key or throws a {@link com.kencana.lms.NoSuchCatalogTemplateTagException} if it could not be found.
	*
	* @param catelogTemplateTagId the primary key of the catalog template tag
	* @return the catalog template tag
	* @throws com.kencana.lms.NoSuchCatalogTemplateTagException if a catalog template tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogTemplateTag findByPrimaryKey(
		long catelogTemplateTagId)
		throws com.kencana.lms.NoSuchCatalogTemplateTagException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(catelogTemplateTagId);
	}

	/**
	* Returns the catalog template tag with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param catelogTemplateTagId the primary key of the catalog template tag
	* @return the catalog template tag, or <code>null</code> if a catalog template tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogTemplateTag fetchByPrimaryKey(
		long catelogTemplateTagId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(catelogTemplateTagId);
	}

	/**
	* Returns all the catalog template tags.
	*
	* @return the catalog template tags
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CatalogTemplateTag> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the catalog template tags.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogTemplateTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of catalog template tags
	* @param end the upper bound of the range of catalog template tags (not inclusive)
	* @return the range of catalog template tags
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CatalogTemplateTag> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the catalog template tags.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogTemplateTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of catalog template tags
	* @param end the upper bound of the range of catalog template tags (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of catalog template tags
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.CatalogTemplateTag> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the catalog template tags from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of catalog template tags.
	*
	* @return the number of catalog template tags
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CatalogTemplateTagPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CatalogTemplateTagPersistence)PortletBeanLocatorUtil.locate(com.kencana.lms.service.ClpSerializer.getServletContextName(),
					CatalogTemplateTagPersistence.class.getName());

			ReferenceRegistry.registerReference(CatalogTemplateTagUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CatalogTemplateTagPersistence persistence) {
	}

	private static CatalogTemplateTagPersistence _persistence;
}