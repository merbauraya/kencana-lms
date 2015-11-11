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
 * Provides a wrapper for {@link MarcBatchUploadLocalService}.
 *
 * @author Mazlan Mat
 * @see MarcBatchUploadLocalService
 * @generated
 */
public class MarcBatchUploadLocalServiceWrapper
	implements MarcBatchUploadLocalService,
		ServiceWrapper<MarcBatchUploadLocalService> {
	public MarcBatchUploadLocalServiceWrapper(
		MarcBatchUploadLocalService marcBatchUploadLocalService) {
		_marcBatchUploadLocalService = marcBatchUploadLocalService;
	}

	/**
	* Adds the marc batch upload to the database. Also notifies the appropriate model listeners.
	*
	* @param marcBatchUpload the marc batch upload
	* @return the marc batch upload that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.MarcBatchUpload addMarcBatchUpload(
		com.kencana.lms.model.MarcBatchUpload marcBatchUpload)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _marcBatchUploadLocalService.addMarcBatchUpload(marcBatchUpload);
	}

	/**
	* Creates a new marc batch upload with the primary key. Does not add the marc batch upload to the database.
	*
	* @param marcBatchUploadId the primary key for the new marc batch upload
	* @return the new marc batch upload
	*/
	@Override
	public com.kencana.lms.model.MarcBatchUpload createMarcBatchUpload(
		long marcBatchUploadId) {
		return _marcBatchUploadLocalService.createMarcBatchUpload(marcBatchUploadId);
	}

	/**
	* Deletes the marc batch upload with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param marcBatchUploadId the primary key of the marc batch upload
	* @return the marc batch upload that was removed
	* @throws PortalException if a marc batch upload with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.MarcBatchUpload deleteMarcBatchUpload(
		long marcBatchUploadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _marcBatchUploadLocalService.deleteMarcBatchUpload(marcBatchUploadId);
	}

	/**
	* Deletes the marc batch upload from the database. Also notifies the appropriate model listeners.
	*
	* @param marcBatchUpload the marc batch upload
	* @return the marc batch upload that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.MarcBatchUpload deleteMarcBatchUpload(
		com.kencana.lms.model.MarcBatchUpload marcBatchUpload)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _marcBatchUploadLocalService.deleteMarcBatchUpload(marcBatchUpload);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _marcBatchUploadLocalService.dynamicQuery();
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
		return _marcBatchUploadLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcBatchUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _marcBatchUploadLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcBatchUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _marcBatchUploadLocalService.dynamicQuery(dynamicQuery, start,
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
		return _marcBatchUploadLocalService.dynamicQueryCount(dynamicQuery);
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
		return _marcBatchUploadLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.kencana.lms.model.MarcBatchUpload fetchMarcBatchUpload(
		long marcBatchUploadId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _marcBatchUploadLocalService.fetchMarcBatchUpload(marcBatchUploadId);
	}

	/**
	* Returns the marc batch upload with the primary key.
	*
	* @param marcBatchUploadId the primary key of the marc batch upload
	* @return the marc batch upload
	* @throws PortalException if a marc batch upload with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.MarcBatchUpload getMarcBatchUpload(
		long marcBatchUploadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _marcBatchUploadLocalService.getMarcBatchUpload(marcBatchUploadId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _marcBatchUploadLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the marc batch uploads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcBatchUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marc batch uploads
	* @param end the upper bound of the range of marc batch uploads (not inclusive)
	* @return the range of marc batch uploads
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.kencana.lms.model.MarcBatchUpload> getMarcBatchUploads(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _marcBatchUploadLocalService.getMarcBatchUploads(start, end);
	}

	/**
	* Returns the number of marc batch uploads.
	*
	* @return the number of marc batch uploads
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getMarcBatchUploadsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _marcBatchUploadLocalService.getMarcBatchUploadsCount();
	}

	/**
	* Updates the marc batch upload in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param marcBatchUpload the marc batch upload
	* @return the marc batch upload that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.MarcBatchUpload updateMarcBatchUpload(
		com.kencana.lms.model.MarcBatchUpload marcBatchUpload)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _marcBatchUploadLocalService.updateMarcBatchUpload(marcBatchUpload);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _marcBatchUploadLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_marcBatchUploadLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _marcBatchUploadLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.kencana.lms.model.MarcBatchUpload create(long userId,
		long companyId, long groupId, int fileCount,
		java.lang.String description)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _marcBatchUploadLocalService.create(userId, companyId, groupId,
			fileCount, description);
	}

	@Override
	public java.util.List<com.kencana.lms.model.MarcBatchUpload> getUnprocessed(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _marcBatchUploadLocalService.getUnprocessed(companyId, groupId,
			start, end);
	}

	/**
	* Update import status to fully processed
	*
	* @param batchId
	* @param userId
	* @throws SystemException
	*/
	@Override
	public void setFullProcessed(long batchId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_marcBatchUploadLocalService.setFullProcessed(batchId, userId);
	}

	/**
	* Update import status to partially processed.
	*
	* @param batchId
	* @param userId
	* @throws SystemException
	*/
	@Override
	public void setPartialProcessed(long batchId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_marcBatchUploadLocalService.setPartialProcessed(batchId, userId);
	}

	@Override
	public long[] importMultiplceBatchs(long[] batchIds,
		com.liferay.portal.theme.ThemeDisplay themeDisplay,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _marcBatchUploadLocalService.importMultiplceBatchs(batchIds,
			themeDisplay, serviceContext);
	}

	@Override
	public long[] importSingleBatch(long batchId,
		com.liferay.portal.theme.ThemeDisplay themeDisplay,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _marcBatchUploadLocalService.importSingleBatch(batchId,
			themeDisplay, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MarcBatchUploadLocalService getWrappedMarcBatchUploadLocalService() {
		return _marcBatchUploadLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMarcBatchUploadLocalService(
		MarcBatchUploadLocalService marcBatchUploadLocalService) {
		_marcBatchUploadLocalService = marcBatchUploadLocalService;
	}

	@Override
	public MarcBatchUploadLocalService getWrappedService() {
		return _marcBatchUploadLocalService;
	}

	@Override
	public void setWrappedService(
		MarcBatchUploadLocalService marcBatchUploadLocalService) {
		_marcBatchUploadLocalService = marcBatchUploadLocalService;
	}

	private MarcBatchUploadLocalService _marcBatchUploadLocalService;
}