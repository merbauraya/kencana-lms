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

package com.kencana.lms.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Catalog. This utility wraps
 * {@link com.kencana.lms.service.impl.CatalogLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mazlan Mat
 * @see CatalogLocalService
 * @see com.kencana.lms.service.base.CatalogLocalServiceBaseImpl
 * @see com.kencana.lms.service.impl.CatalogLocalServiceImpl
 * @generated
 */
public class CatalogLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.kencana.lms.service.impl.CatalogLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the catalog to the database. Also notifies the appropriate model listeners.
	*
	* @param catalog the catalog
	* @return the catalog that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog addCatalog(
		com.kencana.lms.model.Catalog catalog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCatalog(catalog);
	}

	/**
	* Creates a new catalog with the primary key. Does not add the catalog to the database.
	*
	* @param catalogId the primary key for the new catalog
	* @return the new catalog
	*/
	public static com.kencana.lms.model.Catalog createCatalog(long catalogId) {
		return getService().createCatalog(catalogId);
	}

	/**
	* Deletes the catalog with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param catalogId the primary key of the catalog
	* @return the catalog that was removed
	* @throws PortalException if a catalog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog deleteCatalog(long catalogId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCatalog(catalogId);
	}

	/**
	* Deletes the catalog from the database. Also notifies the appropriate model listeners.
	*
	* @param catalog the catalog
	* @return the catalog that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog deleteCatalog(
		com.kencana.lms.model.Catalog catalog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCatalog(catalog);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.kencana.lms.model.Catalog fetchCatalog(long catalogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCatalog(catalogId);
	}

	/**
	* Returns the catalog with the primary key.
	*
	* @param catalogId the primary key of the catalog
	* @return the catalog
	* @throws PortalException if a catalog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog getCatalog(long catalogId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCatalog(catalogId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.kencana.lms.model.Catalog> getCatalogs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCatalogs(start, end);
	}

	/**
	* Returns the number of catalogs.
	*
	* @return the number of catalogs
	* @throws SystemException if a system exception occurred
	*/
	public static int getCatalogsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCatalogsCount();
	}

	/**
	* Updates the catalog in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param catalog the catalog
	* @return the catalog that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Catalog updateCatalog(
		com.kencana.lms.model.Catalog catalog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCatalog(catalog);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.kencana.lms.model.Catalog addCatalog(long userId,
		long companyId, long groupId, long itemTypeId,
		org.marc4j.marc.Record marcRecord,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addCatalog(userId, companyId, groupId, itemTypeId,
			marcRecord, serviceContext);
	}

	public static void deleteCatalog(long[] catalogIds,
		boolean removeCatalogItem,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCatalog(catalogIds, removeCatalogItem, serviceContext);
	}

	public static void indexCatalog(long[] catalogIds)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.search.SearchException {
		getService().indexCatalog(catalogIds);
	}

	public static com.kencana.lms.model.Catalog updateCatalog(
		com.kencana.lms.model.Catalog catalog, long userId,
		org.marc4j.marc.Record marcRecord,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateCatalog(catalog, userId, marcRecord, serviceContext);
	}

	public static com.kencana.lms.model.Catalog editCatalog(long userId,
		long catalogId, long itemTypeId, org.marc4j.marc.Record marcRecord,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .editCatalog(userId, catalogId, itemTypeId, marcRecord,
			serviceContext);
	}

	public static java.util.List<com.kencana.lms.model.Catalog> findByGroupCompany(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroupCompany(companyId, groupId, start, end);
	}

	public static int countByGroupCompany(long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByGroupCompany(groupId, companyId);
	}

	public static java.util.List<com.kencana.lms.model.Catalog> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId, start, end);
	}

	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByGroup(groupId);
	}

	public static java.util.List<com.kencana.lms.model.CatalogItem> getItems(
		long catalogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getItems(catalogId);
	}

	/**
	* Return list of catalog based long array of catalog Id
	*
	* @param catalogIds
	* @return list of catalog
	* @throws SystemException
	*/
	public static java.util.List<com.kencana.lms.model.Catalog> getByIds(
		long[] catalogIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByIds(catalogIds);
	}

	public static void clearService() {
		_service = null;
	}

	public static CatalogLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CatalogLocalService.class.getName());

			if (invokableLocalService instanceof CatalogLocalService) {
				_service = (CatalogLocalService)invokableLocalService;
			}
			else {
				_service = new CatalogLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CatalogLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(CatalogLocalService service) {
	}

	private static CatalogLocalService _service;
}