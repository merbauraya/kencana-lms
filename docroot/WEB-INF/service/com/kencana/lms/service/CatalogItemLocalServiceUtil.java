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
 * Provides the local service utility for CatalogItem. This utility wraps
 * {@link com.kencana.lms.service.impl.CatalogItemLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mazlan Mat
 * @see CatalogItemLocalService
 * @see com.kencana.lms.service.base.CatalogItemLocalServiceBaseImpl
 * @see com.kencana.lms.service.impl.CatalogItemLocalServiceImpl
 * @generated
 */
public class CatalogItemLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.kencana.lms.service.impl.CatalogItemLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the catalog item to the database. Also notifies the appropriate model listeners.
	*
	* @param catalogItem the catalog item
	* @return the catalog item that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogItem addCatalogItem(
		com.kencana.lms.model.CatalogItem catalogItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCatalogItem(catalogItem);
	}

	/**
	* Creates a new catalog item with the primary key. Does not add the catalog item to the database.
	*
	* @param catalogItemId the primary key for the new catalog item
	* @return the new catalog item
	*/
	public static com.kencana.lms.model.CatalogItem createCatalogItem(
		long catalogItemId) {
		return getService().createCatalogItem(catalogItemId);
	}

	/**
	* Deletes the catalog item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param catalogItemId the primary key of the catalog item
	* @return the catalog item that was removed
	* @throws PortalException if a catalog item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogItem deleteCatalogItem(
		long catalogItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCatalogItem(catalogItemId);
	}

	/**
	* Deletes the catalog item from the database. Also notifies the appropriate model listeners.
	*
	* @param catalogItem the catalog item
	* @return the catalog item that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogItem deleteCatalogItem(
		com.kencana.lms.model.CatalogItem catalogItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCatalogItem(catalogItem);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.kencana.lms.model.CatalogItem fetchCatalogItem(
		long catalogItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCatalogItem(catalogItemId);
	}

	/**
	* Returns the catalog item with the primary key.
	*
	* @param catalogItemId the primary key of the catalog item
	* @return the catalog item
	* @throws PortalException if a catalog item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogItem getCatalogItem(
		long catalogItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCatalogItem(catalogItemId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.kencana.lms.model.CatalogItem> getCatalogItems(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCatalogItems(start, end);
	}

	/**
	* Returns the number of catalog items.
	*
	* @return the number of catalog items
	* @throws SystemException if a system exception occurred
	*/
	public static int getCatalogItemsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCatalogItemsCount();
	}

	/**
	* Updates the catalog item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param catalogItem the catalog item
	* @return the catalog item that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.CatalogItem updateCatalogItem(
		com.kencana.lms.model.CatalogItem catalogItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCatalogItem(catalogItem);
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

	public static com.kencana.lms.model.CatalogItem newCatalogItem(
		long userId, long catalogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().newCatalogItem(userId, catalogId);
	}

	public static java.util.List<com.kencana.lms.model.CatalogItem> getByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getByCompanyGroup(companyId, groupId, start, end, obc);
	}

	public static int countByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByCompanyGroup(companyId, groupId);
	}

	public static int countUnreleasedByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countUnreleasedByCompanyGroup(companyId, groupId);
	}

	public static int countReleasedByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countReleasedByCompanyGroup(companyId, groupId);
	}

	public static java.util.List<com.kencana.lms.model.CatalogItem> getUnreleasedByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getUnreleasedByCompanyGroup(companyId, groupId, start, end,
			obc);
	}

	public static java.util.List<com.kencana.lms.model.CatalogItem> getReleaseByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getReleaseByCompanyGroup(companyId, groupId, start, end, obc);
	}

	public static com.kencana.lms.model.CatalogItem update(
		com.kencana.lms.model.CatalogItem catalogItem,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().update(catalogItem, serviceContext);
	}

	public static com.kencana.lms.model.CatalogItem findByBarcode(
		long companyId, java.lang.String barcode)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findByBarcode(companyId, barcode);
	}

	public static boolean isCheckOut(long companyId, long catalogItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().isCheckOut(companyId, catalogItemId);
	}

	public static void releaseCatalogItems(long[] catalogItemIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().releaseCatalogItems(catalogItemIds, serviceContext);
	}

	public static com.kencana.lms.model.CatalogItem withdrawCatalogItem(
		long catalogItemId, boolean lostStatus, boolean damageStatus,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.kencana.lms.NoSuchCatalogItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .withdrawCatalogItem(catalogItemId, lostStatus,
			damageStatus, serviceContext);
	}

	public static java.util.List<com.kencana.lms.model.CatalogItem> getByIds(
		long[] catalogItemIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByIds(catalogItemIds);
	}

	public static void clearService() {
		_service = null;
	}

	public static CatalogItemLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CatalogItemLocalService.class.getName());

			if (invokableLocalService instanceof CatalogItemLocalService) {
				_service = (CatalogItemLocalService)invokableLocalService;
			}
			else {
				_service = new CatalogItemLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CatalogItemLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(CatalogItemLocalService service) {
	}

	private static CatalogItemLocalService _service;
}