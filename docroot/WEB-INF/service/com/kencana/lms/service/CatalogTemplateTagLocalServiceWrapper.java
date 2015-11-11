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
 * Provides a wrapper for {@link CatalogTemplateTagLocalService}.
 *
 * @author Mazlan Mat
 * @see CatalogTemplateTagLocalService
 * @generated
 */
public class CatalogTemplateTagLocalServiceWrapper
	implements CatalogTemplateTagLocalService,
		ServiceWrapper<CatalogTemplateTagLocalService> {
	public CatalogTemplateTagLocalServiceWrapper(
		CatalogTemplateTagLocalService catalogTemplateTagLocalService) {
		_catalogTemplateTagLocalService = catalogTemplateTagLocalService;
	}

	/**
	* Adds the catalog template tag to the database. Also notifies the appropriate model listeners.
	*
	* @param catalogTemplateTag the catalog template tag
	* @return the catalog template tag that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.CatalogTemplateTag addCatalogTemplateTag(
		com.kencana.lms.model.CatalogTemplateTag catalogTemplateTag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogTemplateTagLocalService.addCatalogTemplateTag(catalogTemplateTag);
	}

	/**
	* Creates a new catalog template tag with the primary key. Does not add the catalog template tag to the database.
	*
	* @param catelogTemplateTagId the primary key for the new catalog template tag
	* @return the new catalog template tag
	*/
	@Override
	public com.kencana.lms.model.CatalogTemplateTag createCatalogTemplateTag(
		long catelogTemplateTagId) {
		return _catalogTemplateTagLocalService.createCatalogTemplateTag(catelogTemplateTagId);
	}

	/**
	* Deletes the catalog template tag with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param catelogTemplateTagId the primary key of the catalog template tag
	* @return the catalog template tag that was removed
	* @throws PortalException if a catalog template tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.CatalogTemplateTag deleteCatalogTemplateTag(
		long catelogTemplateTagId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _catalogTemplateTagLocalService.deleteCatalogTemplateTag(catelogTemplateTagId);
	}

	/**
	* Deletes the catalog template tag from the database. Also notifies the appropriate model listeners.
	*
	* @param catalogTemplateTag the catalog template tag
	* @return the catalog template tag that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.CatalogTemplateTag deleteCatalogTemplateTag(
		com.kencana.lms.model.CatalogTemplateTag catalogTemplateTag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogTemplateTagLocalService.deleteCatalogTemplateTag(catalogTemplateTag);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _catalogTemplateTagLocalService.dynamicQuery();
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
		return _catalogTemplateTagLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogTemplateTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _catalogTemplateTagLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogTemplateTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _catalogTemplateTagLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _catalogTemplateTagLocalService.dynamicQueryCount(dynamicQuery);
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
		return _catalogTemplateTagLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.kencana.lms.model.CatalogTemplateTag fetchCatalogTemplateTag(
		long catelogTemplateTagId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogTemplateTagLocalService.fetchCatalogTemplateTag(catelogTemplateTagId);
	}

	/**
	* Returns the catalog template tag with the primary key.
	*
	* @param catelogTemplateTagId the primary key of the catalog template tag
	* @return the catalog template tag
	* @throws PortalException if a catalog template tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.CatalogTemplateTag getCatalogTemplateTag(
		long catelogTemplateTagId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _catalogTemplateTagLocalService.getCatalogTemplateTag(catelogTemplateTagId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _catalogTemplateTagLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.kencana.lms.model.CatalogTemplateTag> getCatalogTemplateTags(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogTemplateTagLocalService.getCatalogTemplateTags(start, end);
	}

	/**
	* Returns the number of catalog template tags.
	*
	* @return the number of catalog template tags
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCatalogTemplateTagsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogTemplateTagLocalService.getCatalogTemplateTagsCount();
	}

	/**
	* Updates the catalog template tag in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param catalogTemplateTag the catalog template tag
	* @return the catalog template tag that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.CatalogTemplateTag updateCatalogTemplateTag(
		com.kencana.lms.model.CatalogTemplateTag catalogTemplateTag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogTemplateTagLocalService.updateCatalogTemplateTag(catalogTemplateTag);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _catalogTemplateTagLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_catalogTemplateTagLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _catalogTemplateTagLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CatalogTemplateTagLocalService getWrappedCatalogTemplateTagLocalService() {
		return _catalogTemplateTagLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCatalogTemplateTagLocalService(
		CatalogTemplateTagLocalService catalogTemplateTagLocalService) {
		_catalogTemplateTagLocalService = catalogTemplateTagLocalService;
	}

	@Override
	public CatalogTemplateTagLocalService getWrappedService() {
		return _catalogTemplateTagLocalService;
	}

	@Override
	public void setWrappedService(
		CatalogTemplateTagLocalService catalogTemplateTagLocalService) {
		_catalogTemplateTagLocalService = catalogTemplateTagLocalService;
	}

	private CatalogTemplateTagLocalService _catalogTemplateTagLocalService;
}