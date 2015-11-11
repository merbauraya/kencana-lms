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
 * Provides a wrapper for {@link MarcBatchUploadItemLocalService}.
 *
 * @author Mazlan Mat
 * @see MarcBatchUploadItemLocalService
 * @generated
 */
public class MarcBatchUploadItemLocalServiceWrapper
	implements MarcBatchUploadItemLocalService,
		ServiceWrapper<MarcBatchUploadItemLocalService> {
	public MarcBatchUploadItemLocalServiceWrapper(
		MarcBatchUploadItemLocalService marcBatchUploadItemLocalService) {
		_marcBatchUploadItemLocalService = marcBatchUploadItemLocalService;
	}

	/**
	* Adds the marc batch upload item to the database. Also notifies the appropriate model listeners.
	*
	* @param marcBatchUploadItem the marc batch upload item
	* @return the marc batch upload item that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.MarcBatchUploadItem addMarcBatchUploadItem(
		com.kencana.lms.model.MarcBatchUploadItem marcBatchUploadItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _marcBatchUploadItemLocalService.addMarcBatchUploadItem(marcBatchUploadItem);
	}

	/**
	* Creates a new marc batch upload item with the primary key. Does not add the marc batch upload item to the database.
	*
	* @param marcBatchUploadItemId the primary key for the new marc batch upload item
	* @return the new marc batch upload item
	*/
	@Override
	public com.kencana.lms.model.MarcBatchUploadItem createMarcBatchUploadItem(
		long marcBatchUploadItemId) {
		return _marcBatchUploadItemLocalService.createMarcBatchUploadItem(marcBatchUploadItemId);
	}

	/**
	* Deletes the marc batch upload item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param marcBatchUploadItemId the primary key of the marc batch upload item
	* @return the marc batch upload item that was removed
	* @throws PortalException if a marc batch upload item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.MarcBatchUploadItem deleteMarcBatchUploadItem(
		long marcBatchUploadItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _marcBatchUploadItemLocalService.deleteMarcBatchUploadItem(marcBatchUploadItemId);
	}

	/**
	* Deletes the marc batch upload item from the database. Also notifies the appropriate model listeners.
	*
	* @param marcBatchUploadItem the marc batch upload item
	* @return the marc batch upload item that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.MarcBatchUploadItem deleteMarcBatchUploadItem(
		com.kencana.lms.model.MarcBatchUploadItem marcBatchUploadItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _marcBatchUploadItemLocalService.deleteMarcBatchUploadItem(marcBatchUploadItem);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _marcBatchUploadItemLocalService.dynamicQuery();
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
		return _marcBatchUploadItemLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _marcBatchUploadItemLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _marcBatchUploadItemLocalService.dynamicQuery(dynamicQuery,
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
		return _marcBatchUploadItemLocalService.dynamicQueryCount(dynamicQuery);
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
		return _marcBatchUploadItemLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.kencana.lms.model.MarcBatchUploadItem fetchMarcBatchUploadItem(
		long marcBatchUploadItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _marcBatchUploadItemLocalService.fetchMarcBatchUploadItem(marcBatchUploadItemId);
	}

	/**
	* Returns the marc batch upload item with the primary key.
	*
	* @param marcBatchUploadItemId the primary key of the marc batch upload item
	* @return the marc batch upload item
	* @throws PortalException if a marc batch upload item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.MarcBatchUploadItem getMarcBatchUploadItem(
		long marcBatchUploadItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _marcBatchUploadItemLocalService.getMarcBatchUploadItem(marcBatchUploadItemId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _marcBatchUploadItemLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.kencana.lms.model.MarcBatchUploadItem> getMarcBatchUploadItems(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _marcBatchUploadItemLocalService.getMarcBatchUploadItems(start,
			end);
	}

	/**
	* Returns the number of marc batch upload items.
	*
	* @return the number of marc batch upload items
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getMarcBatchUploadItemsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _marcBatchUploadItemLocalService.getMarcBatchUploadItemsCount();
	}

	/**
	* Updates the marc batch upload item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param marcBatchUploadItem the marc batch upload item
	* @return the marc batch upload item that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.MarcBatchUploadItem updateMarcBatchUploadItem(
		com.kencana.lms.model.MarcBatchUploadItem marcBatchUploadItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _marcBatchUploadItemLocalService.updateMarcBatchUploadItem(marcBatchUploadItem);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _marcBatchUploadItemLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_marcBatchUploadItemLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _marcBatchUploadItemLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.kencana.lms.model.MarcBatchUploadItem create(long batchId,
		long userId, long companyId, long groupId, long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _marcBatchUploadItemLocalService.create(batchId, userId,
			companyId, groupId, fileEntryId);
	}

	@Override
	public java.util.List<com.kencana.lms.model.MarcBatchUploadItem> findByBatchId(
		long batchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _marcBatchUploadItemLocalService.findByBatchId(batchId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MarcBatchUploadItemLocalService getWrappedMarcBatchUploadItemLocalService() {
		return _marcBatchUploadItemLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMarcBatchUploadItemLocalService(
		MarcBatchUploadItemLocalService marcBatchUploadItemLocalService) {
		_marcBatchUploadItemLocalService = marcBatchUploadItemLocalService;
	}

	@Override
	public MarcBatchUploadItemLocalService getWrappedService() {
		return _marcBatchUploadItemLocalService;
	}

	@Override
	public void setWrappedService(
		MarcBatchUploadItemLocalService marcBatchUploadItemLocalService) {
		_marcBatchUploadItemLocalService = marcBatchUploadItemLocalService;
	}

	private MarcBatchUploadItemLocalService _marcBatchUploadItemLocalService;
}