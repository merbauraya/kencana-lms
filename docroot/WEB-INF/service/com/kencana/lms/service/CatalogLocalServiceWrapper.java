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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CatalogLocalService}.
 *
 * @author Mazlan Mat
 * @see CatalogLocalService
 * @generated
 */
public class CatalogLocalServiceWrapper implements CatalogLocalService,
	ServiceWrapper<CatalogLocalService> {
	public CatalogLocalServiceWrapper(CatalogLocalService catalogLocalService) {
		_catalogLocalService = catalogLocalService;
	}

	/**
	* Adds the catalog to the database. Also notifies the appropriate model listeners.
	*
	* @param catalog the catalog
	* @return the catalog that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.Catalog addCatalog(
		com.kencana.lms.model.Catalog catalog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogLocalService.addCatalog(catalog);
	}

	/**
	* Creates a new catalog with the primary key. Does not add the catalog to the database.
	*
	* @param catalogId the primary key for the new catalog
	* @return the new catalog
	*/
	@Override
	public com.kencana.lms.model.Catalog createCatalog(long catalogId) {
		return _catalogLocalService.createCatalog(catalogId);
	}

	/**
	* Deletes the catalog with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param catalogId the primary key of the catalog
	* @return the catalog that was removed
	* @throws PortalException if a catalog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.Catalog deleteCatalog(long catalogId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _catalogLocalService.deleteCatalog(catalogId);
	}

	/**
	* Deletes the catalog from the database. Also notifies the appropriate model listeners.
	*
	* @param catalog the catalog
	* @return the catalog that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.Catalog deleteCatalog(
		com.kencana.lms.model.Catalog catalog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogLocalService.deleteCatalog(catalog);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _catalogLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.kencana.lms.model.Catalog fetchCatalog(long catalogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogLocalService.fetchCatalog(catalogId);
	}

	/**
	* Returns the catalog with the primary key.
	*
	* @param catalogId the primary key of the catalog
	* @return the catalog
	* @throws PortalException if a catalog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.Catalog getCatalog(long catalogId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _catalogLocalService.getCatalog(catalogId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _catalogLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.kencana.lms.model.Catalog> getCatalogs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogLocalService.getCatalogs(start, end);
	}

	/**
	* Returns the number of catalogs.
	*
	* @return the number of catalogs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCatalogsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogLocalService.getCatalogsCount();
	}

	/**
	* Updates the catalog in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param catalog the catalog
	* @return the catalog that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.Catalog updateCatalog(
		com.kencana.lms.model.Catalog catalog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogLocalService.updateCatalog(catalog);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _catalogLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_catalogLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _catalogLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.kencana.lms.model.Catalog addCatalog(long userId,
		long companyId, long groupId, long itemTypeId,
		org.marc4j.marc.Record marcRecord,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _catalogLocalService.addCatalog(userId, companyId, groupId,
			itemTypeId, marcRecord, serviceContext);
	}

	@Override
	public void deleteCatalog(long[] catalogIds, boolean removeCatalogItem,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_catalogLocalService.deleteCatalog(catalogIds, removeCatalogItem,
			serviceContext);
	}

	@Override
	public void indexCatalog(long[] catalogIds)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.search.SearchException {
		_catalogLocalService.indexCatalog(catalogIds);
	}

	@Override
	public com.kencana.lms.model.Catalog updateCatalog(
		com.kencana.lms.model.Catalog catalog, long userId,
		org.marc4j.marc.Record marcRecord,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _catalogLocalService.updateCatalog(catalog, userId, marcRecord,
			serviceContext);
	}

	@Override
	public com.kencana.lms.model.Catalog editCatalog(long userId,
		long catalogId, long itemTypeId, org.marc4j.marc.Record marcRecord,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _catalogLocalService.editCatalog(userId, catalogId, itemTypeId,
			marcRecord, serviceContext);
	}

	@Override
	public java.util.List<com.kencana.lms.model.Catalog> findByGroupCompany(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogLocalService.findByGroupCompany(companyId, groupId,
			start, end);
	}

	@Override
	public int countByGroupCompany(long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogLocalService.countByGroupCompany(groupId, companyId);
	}

	@Override
	public java.util.List<com.kencana.lms.model.Catalog> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogLocalService.findByGroup(groupId, start, end);
	}

	@Override
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogLocalService.countByGroup(groupId);
	}

	@Override
	public java.util.List<com.kencana.lms.model.CatalogItem> getItems(
		long catalogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogLocalService.getItems(catalogId);
	}

	/**
	* Return list of catalog based long array of catalog Id
	*
	* @param catalogIds
	* @return list of catalog
	* @throws SystemException
	*/
	@Override
	public java.util.List<com.kencana.lms.model.Catalog> getByIds(
		long[] catalogIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogLocalService.getByIds(catalogIds);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CatalogLocalService getWrappedCatalogLocalService() {
		return _catalogLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCatalogLocalService(
		CatalogLocalService catalogLocalService) {
		_catalogLocalService = catalogLocalService;
	}

	@Override
	public CatalogLocalService getWrappedService() {
		return _catalogLocalService;
	}

	@Override
	public void setWrappedService(CatalogLocalService catalogLocalService) {
		_catalogLocalService = catalogLocalService;
	}

	private CatalogLocalService _catalogLocalService;
}