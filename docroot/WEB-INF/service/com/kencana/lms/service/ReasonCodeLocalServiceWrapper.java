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
 * Provides a wrapper for {@link ReasonCodeLocalService}.
 *
 * @author Mazlan Mat
 * @see ReasonCodeLocalService
 * @generated
 */
public class ReasonCodeLocalServiceWrapper implements ReasonCodeLocalService,
	ServiceWrapper<ReasonCodeLocalService> {
	public ReasonCodeLocalServiceWrapper(
		ReasonCodeLocalService reasonCodeLocalService) {
		_reasonCodeLocalService = reasonCodeLocalService;
	}

	/**
	* Adds the reason code to the database. Also notifies the appropriate model listeners.
	*
	* @param reasonCode the reason code
	* @return the reason code that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.ReasonCode addReasonCode(
		com.kencana.lms.model.ReasonCode reasonCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reasonCodeLocalService.addReasonCode(reasonCode);
	}

	/**
	* Creates a new reason code with the primary key. Does not add the reason code to the database.
	*
	* @param reasonCodeId the primary key for the new reason code
	* @return the new reason code
	*/
	@Override
	public com.kencana.lms.model.ReasonCode createReasonCode(long reasonCodeId) {
		return _reasonCodeLocalService.createReasonCode(reasonCodeId);
	}

	/**
	* Deletes the reason code with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param reasonCodeId the primary key of the reason code
	* @return the reason code that was removed
	* @throws PortalException if a reason code with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.ReasonCode deleteReasonCode(long reasonCodeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _reasonCodeLocalService.deleteReasonCode(reasonCodeId);
	}

	/**
	* Deletes the reason code from the database. Also notifies the appropriate model listeners.
	*
	* @param reasonCode the reason code
	* @return the reason code that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.ReasonCode deleteReasonCode(
		com.kencana.lms.model.ReasonCode reasonCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reasonCodeLocalService.deleteReasonCode(reasonCode);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _reasonCodeLocalService.dynamicQuery();
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
		return _reasonCodeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.ReasonCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _reasonCodeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.ReasonCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _reasonCodeLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _reasonCodeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _reasonCodeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.kencana.lms.model.ReasonCode fetchReasonCode(long reasonCodeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reasonCodeLocalService.fetchReasonCode(reasonCodeId);
	}

	/**
	* Returns the reason code with the primary key.
	*
	* @param reasonCodeId the primary key of the reason code
	* @return the reason code
	* @throws PortalException if a reason code with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.ReasonCode getReasonCode(long reasonCodeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _reasonCodeLocalService.getReasonCode(reasonCodeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _reasonCodeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the reason codes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.ReasonCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of reason codes
	* @param end the upper bound of the range of reason codes (not inclusive)
	* @return the range of reason codes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.kencana.lms.model.ReasonCode> getReasonCodes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reasonCodeLocalService.getReasonCodes(start, end);
	}

	/**
	* Returns the number of reason codes.
	*
	* @return the number of reason codes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getReasonCodesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reasonCodeLocalService.getReasonCodesCount();
	}

	/**
	* Updates the reason code in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param reasonCode the reason code
	* @return the reason code that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.ReasonCode updateReasonCode(
		com.kencana.lms.model.ReasonCode reasonCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reasonCodeLocalService.updateReasonCode(reasonCode);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _reasonCodeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_reasonCodeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _reasonCodeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ReasonCodeLocalService getWrappedReasonCodeLocalService() {
		return _reasonCodeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedReasonCodeLocalService(
		ReasonCodeLocalService reasonCodeLocalService) {
		_reasonCodeLocalService = reasonCodeLocalService;
	}

	@Override
	public ReasonCodeLocalService getWrappedService() {
		return _reasonCodeLocalService;
	}

	@Override
	public void setWrappedService(ReasonCodeLocalService reasonCodeLocalService) {
		_reasonCodeLocalService = reasonCodeLocalService;
	}

	private ReasonCodeLocalService _reasonCodeLocalService;
}