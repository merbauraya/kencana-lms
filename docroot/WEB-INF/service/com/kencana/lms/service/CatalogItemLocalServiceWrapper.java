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
 * Provides a wrapper for {@link CatalogItemLocalService}.
 *
 * @author Mazlan Mat
 * @see CatalogItemLocalService
 * @generated
 */
public class CatalogItemLocalServiceWrapper implements CatalogItemLocalService,
	ServiceWrapper<CatalogItemLocalService> {
	public CatalogItemLocalServiceWrapper(
		CatalogItemLocalService catalogItemLocalService) {
		_catalogItemLocalService = catalogItemLocalService;
	}

	/**
	* Adds the catalog item to the database. Also notifies the appropriate model listeners.
	*
	* @param catalogItem the catalog item
	* @return the catalog item that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.CatalogItem addCatalogItem(
		com.kencana.lms.model.CatalogItem catalogItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogItemLocalService.addCatalogItem(catalogItem);
	}

	/**
	* Creates a new catalog item with the primary key. Does not add the catalog item to the database.
	*
	* @param catalogItemId the primary key for the new catalog item
	* @return the new catalog item
	*/
	@Override
	public com.kencana.lms.model.CatalogItem createCatalogItem(
		long catalogItemId) {
		return _catalogItemLocalService.createCatalogItem(catalogItemId);
	}

	/**
	* Deletes the catalog item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param catalogItemId the primary key of the catalog item
	* @return the catalog item that was removed
	* @throws PortalException if a catalog item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.CatalogItem deleteCatalogItem(
		long catalogItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _catalogItemLocalService.deleteCatalogItem(catalogItemId);
	}

	/**
	* Deletes the catalog item from the database. Also notifies the appropriate model listeners.
	*
	* @param catalogItem the catalog item
	* @return the catalog item that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.CatalogItem deleteCatalogItem(
		com.kencana.lms.model.CatalogItem catalogItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogItemLocalService.deleteCatalogItem(catalogItem);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _catalogItemLocalService.dynamicQuery();
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
		return _catalogItemLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _catalogItemLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _catalogItemLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _catalogItemLocalService.dynamicQueryCount(dynamicQuery);
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
		return _catalogItemLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.kencana.lms.model.CatalogItem fetchCatalogItem(
		long catalogItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogItemLocalService.fetchCatalogItem(catalogItemId);
	}

	/**
	* Returns the catalog item with the primary key.
	*
	* @param catalogItemId the primary key of the catalog item
	* @return the catalog item
	* @throws PortalException if a catalog item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.CatalogItem getCatalogItem(long catalogItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _catalogItemLocalService.getCatalogItem(catalogItemId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _catalogItemLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.kencana.lms.model.CatalogItem> getCatalogItems(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogItemLocalService.getCatalogItems(start, end);
	}

	/**
	* Returns the number of catalog items.
	*
	* @return the number of catalog items
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCatalogItemsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogItemLocalService.getCatalogItemsCount();
	}

	/**
	* Updates the catalog item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param catalogItem the catalog item
	* @return the catalog item that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.CatalogItem updateCatalogItem(
		com.kencana.lms.model.CatalogItem catalogItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogItemLocalService.updateCatalogItem(catalogItem);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _catalogItemLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_catalogItemLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _catalogItemLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.kencana.lms.model.CatalogItem newCatalogItem(long userId,
		long catalogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogItemLocalService.newCatalogItem(userId, catalogId);
	}

	@Override
	public java.util.List<com.kencana.lms.model.CatalogItem> getByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogItemLocalService.getByCompanyGroup(companyId, groupId,
			start, end, obc);
	}

	@Override
	public int countByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogItemLocalService.countByCompanyGroup(companyId, groupId);
	}

	@Override
	public int countUnreleasedByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogItemLocalService.countUnreleasedByCompanyGroup(companyId,
			groupId);
	}

	@Override
	public int countReleasedByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogItemLocalService.countReleasedByCompanyGroup(companyId,
			groupId);
	}

	@Override
	public java.util.List<com.kencana.lms.model.CatalogItem> getUnreleasedByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogItemLocalService.getUnreleasedByCompanyGroup(companyId,
			groupId, start, end, obc);
	}

	@Override
	public java.util.List<com.kencana.lms.model.CatalogItem> getReleaseByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogItemLocalService.getReleaseByCompanyGroup(companyId,
			groupId, start, end, obc);
	}

	@Override
	public com.kencana.lms.model.CatalogItem update(
		com.kencana.lms.model.CatalogItem catalogItem,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _catalogItemLocalService.update(catalogItem, serviceContext);
	}

	@Override
	public com.kencana.lms.model.CatalogItem findByBarcode(long companyId,
		java.lang.String barcode)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return _catalogItemLocalService.findByBarcode(companyId, barcode);
	}

	@Override
	public boolean isCheckOut(long companyId, long catalogItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogItemLocalService.isCheckOut(companyId, catalogItemId);
	}

	@Override
	public void releaseCatalogItems(long[] catalogItemIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		_catalogItemLocalService.releaseCatalogItems(catalogItemIds,
			serviceContext);
	}

	@Override
	public com.kencana.lms.model.CatalogItem withdrawCatalogItem(
		long catalogItemId, boolean lostStatus, boolean damageStatus,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return _catalogItemLocalService.withdrawCatalogItem(catalogItemId,
			lostStatus, damageStatus, serviceContext);
	}

	@Override
	public java.util.List<com.kencana.lms.model.CatalogItem> getByIds(
		long[] catalogItemIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogItemLocalService.getByIds(catalogItemIds);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CatalogItemLocalService getWrappedCatalogItemLocalService() {
		return _catalogItemLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCatalogItemLocalService(
		CatalogItemLocalService catalogItemLocalService) {
		_catalogItemLocalService = catalogItemLocalService;
	}

	@Override
	public CatalogItemLocalService getWrappedService() {
		return _catalogItemLocalService;
	}

	@Override
	public void setWrappedService(
		CatalogItemLocalService catalogItemLocalService) {
		_catalogItemLocalService = catalogItemLocalService;
	}

	private CatalogItemLocalService _catalogItemLocalService;
}