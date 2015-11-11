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
 * Provides the local service utility for MarcBatchUploadItem. This utility wraps
 * {@link com.kencana.lms.service.impl.MarcBatchUploadItemLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mazlan Mat
 * @see MarcBatchUploadItemLocalService
 * @see com.kencana.lms.service.base.MarcBatchUploadItemLocalServiceBaseImpl
 * @see com.kencana.lms.service.impl.MarcBatchUploadItemLocalServiceImpl
 * @generated
 */
public class MarcBatchUploadItemLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.kencana.lms.service.impl.MarcBatchUploadItemLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the marc batch upload item to the database. Also notifies the appropriate model listeners.
	*
	* @param marcBatchUploadItem the marc batch upload item
	* @return the marc batch upload item that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.MarcBatchUploadItem addMarcBatchUploadItem(
		com.kencana.lms.model.MarcBatchUploadItem marcBatchUploadItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addMarcBatchUploadItem(marcBatchUploadItem);
	}

	/**
	* Creates a new marc batch upload item with the primary key. Does not add the marc batch upload item to the database.
	*
	* @param marcBatchUploadItemId the primary key for the new marc batch upload item
	* @return the new marc batch upload item
	*/
	public static com.kencana.lms.model.MarcBatchUploadItem createMarcBatchUploadItem(
		long marcBatchUploadItemId) {
		return getService().createMarcBatchUploadItem(marcBatchUploadItemId);
	}

	/**
	* Deletes the marc batch upload item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param marcBatchUploadItemId the primary key of the marc batch upload item
	* @return the marc batch upload item that was removed
	* @throws PortalException if a marc batch upload item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.MarcBatchUploadItem deleteMarcBatchUploadItem(
		long marcBatchUploadItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteMarcBatchUploadItem(marcBatchUploadItemId);
	}

	/**
	* Deletes the marc batch upload item from the database. Also notifies the appropriate model listeners.
	*
	* @param marcBatchUploadItem the marc batch upload item
	* @return the marc batch upload item that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.MarcBatchUploadItem deleteMarcBatchUploadItem(
		com.kencana.lms.model.MarcBatchUploadItem marcBatchUploadItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteMarcBatchUploadItem(marcBatchUploadItem);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcBatchUploadItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcBatchUploadItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.kencana.lms.model.MarcBatchUploadItem fetchMarcBatchUploadItem(
		long marcBatchUploadItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchMarcBatchUploadItem(marcBatchUploadItemId);
	}

	/**
	* Returns the marc batch upload item with the primary key.
	*
	* @param marcBatchUploadItemId the primary key of the marc batch upload item
	* @return the marc batch upload item
	* @throws PortalException if a marc batch upload item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.MarcBatchUploadItem getMarcBatchUploadItem(
		long marcBatchUploadItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getMarcBatchUploadItem(marcBatchUploadItemId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the marc batch upload items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcBatchUploadItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marc batch upload items
	* @param end the upper bound of the range of marc batch upload items (not inclusive)
	* @return the range of marc batch upload items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.MarcBatchUploadItem> getMarcBatchUploadItems(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMarcBatchUploadItems(start, end);
	}

	/**
	* Returns the number of marc batch upload items.
	*
	* @return the number of marc batch upload items
	* @throws SystemException if a system exception occurred
	*/
	public static int getMarcBatchUploadItemsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMarcBatchUploadItemsCount();
	}

	/**
	* Updates the marc batch upload item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param marcBatchUploadItem the marc batch upload item
	* @return the marc batch upload item that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.MarcBatchUploadItem updateMarcBatchUploadItem(
		com.kencana.lms.model.MarcBatchUploadItem marcBatchUploadItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateMarcBatchUploadItem(marcBatchUploadItem);
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

	public static com.kencana.lms.model.MarcBatchUploadItem create(
		long batchId, long userId, long companyId, long groupId,
		long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .create(batchId, userId, companyId, groupId, fileEntryId);
	}

	public static java.util.List<com.kencana.lms.model.MarcBatchUploadItem> findByBatchId(
		long batchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByBatchId(batchId);
	}

	public static void clearService() {
		_service = null;
	}

	public static MarcBatchUploadItemLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					MarcBatchUploadItemLocalService.class.getName());

			if (invokableLocalService instanceof MarcBatchUploadItemLocalService) {
				_service = (MarcBatchUploadItemLocalService)invokableLocalService;
			}
			else {
				_service = new MarcBatchUploadItemLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(MarcBatchUploadItemLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(MarcBatchUploadItemLocalService service) {
	}

	private static MarcBatchUploadItemLocalService _service;
}