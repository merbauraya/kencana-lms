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
 * Provides a wrapper for {@link CatalogTemplateLocalService}.
 *
 * @author Mazlan Mat
 * @see CatalogTemplateLocalService
 * @generated
 */
public class CatalogTemplateLocalServiceWrapper
	implements CatalogTemplateLocalService,
		ServiceWrapper<CatalogTemplateLocalService> {
	public CatalogTemplateLocalServiceWrapper(
		CatalogTemplateLocalService catalogTemplateLocalService) {
		_catalogTemplateLocalService = catalogTemplateLocalService;
	}

	/**
	* Adds the catalog template to the database. Also notifies the appropriate model listeners.
	*
	* @param catalogTemplate the catalog template
	* @return the catalog template that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.CatalogTemplate addCatalogTemplate(
		com.kencana.lms.model.CatalogTemplate catalogTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogTemplateLocalService.addCatalogTemplate(catalogTemplate);
	}

	/**
	* Creates a new catalog template with the primary key. Does not add the catalog template to the database.
	*
	* @param templateId the primary key for the new catalog template
	* @return the new catalog template
	*/
	@Override
	public com.kencana.lms.model.CatalogTemplate createCatalogTemplate(
		long templateId) {
		return _catalogTemplateLocalService.createCatalogTemplate(templateId);
	}

	/**
	* Deletes the catalog template with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param templateId the primary key of the catalog template
	* @return the catalog template that was removed
	* @throws PortalException if a catalog template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.CatalogTemplate deleteCatalogTemplate(
		long templateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _catalogTemplateLocalService.deleteCatalogTemplate(templateId);
	}

	/**
	* Deletes the catalog template from the database. Also notifies the appropriate model listeners.
	*
	* @param catalogTemplate the catalog template
	* @return the catalog template that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.CatalogTemplate deleteCatalogTemplate(
		com.kencana.lms.model.CatalogTemplate catalogTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogTemplateLocalService.deleteCatalogTemplate(catalogTemplate);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _catalogTemplateLocalService.dynamicQuery();
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
		return _catalogTemplateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _catalogTemplateLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _catalogTemplateLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _catalogTemplateLocalService.dynamicQueryCount(dynamicQuery);
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
		return _catalogTemplateLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.kencana.lms.model.CatalogTemplate fetchCatalogTemplate(
		long templateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogTemplateLocalService.fetchCatalogTemplate(templateId);
	}

	/**
	* Returns the catalog template with the primary key.
	*
	* @param templateId the primary key of the catalog template
	* @return the catalog template
	* @throws PortalException if a catalog template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.CatalogTemplate getCatalogTemplate(
		long templateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _catalogTemplateLocalService.getCatalogTemplate(templateId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _catalogTemplateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the catalog templates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of catalog templates
	* @param end the upper bound of the range of catalog templates (not inclusive)
	* @return the range of catalog templates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.kencana.lms.model.CatalogTemplate> getCatalogTemplates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogTemplateLocalService.getCatalogTemplates(start, end);
	}

	/**
	* Returns the number of catalog templates.
	*
	* @return the number of catalog templates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCatalogTemplatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogTemplateLocalService.getCatalogTemplatesCount();
	}

	/**
	* Updates the catalog template in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param catalogTemplate the catalog template
	* @return the catalog template that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.CatalogTemplate updateCatalogTemplate(
		com.kencana.lms.model.CatalogTemplate catalogTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogTemplateLocalService.updateCatalogTemplate(catalogTemplate);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _catalogTemplateLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_catalogTemplateLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _catalogTemplateLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CatalogTemplateLocalService getWrappedCatalogTemplateLocalService() {
		return _catalogTemplateLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCatalogTemplateLocalService(
		CatalogTemplateLocalService catalogTemplateLocalService) {
		_catalogTemplateLocalService = catalogTemplateLocalService;
	}

	@Override
	public CatalogTemplateLocalService getWrappedService() {
		return _catalogTemplateLocalService;
	}

	@Override
	public void setWrappedService(
		CatalogTemplateLocalService catalogTemplateLocalService) {
		_catalogTemplateLocalService = catalogTemplateLocalService;
	}

	private CatalogTemplateLocalService _catalogTemplateLocalService;
}