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
 * Provides a wrapper for {@link PatronStatusLocalService}.
 *
 * @author Mazlan Mat
 * @see PatronStatusLocalService
 * @generated
 */
public class PatronStatusLocalServiceWrapper implements PatronStatusLocalService,
	ServiceWrapper<PatronStatusLocalService> {
	public PatronStatusLocalServiceWrapper(
		PatronStatusLocalService patronStatusLocalService) {
		_patronStatusLocalService = patronStatusLocalService;
	}

	/**
	* Adds the patron status to the database. Also notifies the appropriate model listeners.
	*
	* @param patronStatus the patron status
	* @return the patron status that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.PatronStatus addPatronStatus(
		com.kencana.lms.model.PatronStatus patronStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _patronStatusLocalService.addPatronStatus(patronStatus);
	}

	/**
	* Creates a new patron status with the primary key. Does not add the patron status to the database.
	*
	* @param patronStatusId the primary key for the new patron status
	* @return the new patron status
	*/
	@Override
	public com.kencana.lms.model.PatronStatus createPatronStatus(
		long patronStatusId) {
		return _patronStatusLocalService.createPatronStatus(patronStatusId);
	}

	/**
	* Deletes the patron status with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param patronStatusId the primary key of the patron status
	* @return the patron status that was removed
	* @throws PortalException if a patron status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	* @throws com.kencana.lms.NoSuchPatronStatusException
	*/
	@Override
	public com.kencana.lms.model.PatronStatus deletePatronStatus(
		long patronStatusId)
		throws com.kencana.lms.NoSuchPatronStatusException,
			com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _patronStatusLocalService.deletePatronStatus(patronStatusId);
	}

	/**
	* Deletes the patron status from the database. Also notifies the appropriate model listeners.
	*
	* @param patronStatus the patron status
	* @return the patron status that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.PatronStatus deletePatronStatus(
		com.kencana.lms.model.PatronStatus patronStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _patronStatusLocalService.deletePatronStatus(patronStatus);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _patronStatusLocalService.dynamicQuery();
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
		return _patronStatusLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _patronStatusLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _patronStatusLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _patronStatusLocalService.dynamicQueryCount(dynamicQuery);
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
		return _patronStatusLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.kencana.lms.model.PatronStatus fetchPatronStatus(
		long patronStatusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _patronStatusLocalService.fetchPatronStatus(patronStatusId);
	}

	/**
	* Returns the patron status with the primary key.
	*
	* @param patronStatusId the primary key of the patron status
	* @return the patron status
	* @throws PortalException if a patron status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.PatronStatus getPatronStatus(
		long patronStatusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _patronStatusLocalService.getPatronStatus(patronStatusId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _patronStatusLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the patron statuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of patron statuses
	* @param end the upper bound of the range of patron statuses (not inclusive)
	* @return the range of patron statuses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.kencana.lms.model.PatronStatus> getPatronStatuses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _patronStatusLocalService.getPatronStatuses(start, end);
	}

	/**
	* Returns the number of patron statuses.
	*
	* @return the number of patron statuses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPatronStatusesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _patronStatusLocalService.getPatronStatusesCount();
	}

	/**
	* Updates the patron status in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param patronStatus the patron status
	* @return the patron status that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.PatronStatus updatePatronStatus(
		com.kencana.lms.model.PatronStatus patronStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _patronStatusLocalService.updatePatronStatus(patronStatus);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _patronStatusLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_patronStatusLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _patronStatusLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.kencana.lms.model.PatronStatus addPatronStatus(long groupId,
		long companyId, java.lang.String patronStatusName, boolean noLogin,
		boolean noCheckout, boolean noReserve, int color)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _patronStatusLocalService.addPatronStatus(groupId, companyId,
			patronStatusName, noLogin, noCheckout, noReserve, color);
	}

	@Override
	public com.kencana.lms.model.PatronStatus updatePatronStatus(
		long patronStatusId, long groupId, long companyId,
		java.lang.String patronStatusName, boolean noLogin, boolean noCheckout,
		boolean noReserve, int color)
		throws com.kencana.lms.NoSuchPatronStatusException,
			com.liferay.portal.kernel.exception.SystemException {
		return _patronStatusLocalService.updatePatronStatus(patronStatusId,
			groupId, companyId, patronStatusName, noLogin, noCheckout,
			noReserve, color);
	}

	@Override
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _patronStatusLocalService.countByGroup(groupId);
	}

	@Override
	public java.util.List<com.kencana.lms.model.PatronStatus> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _patronStatusLocalService.findByGroup(groupId, start, end);
	}

	@Override
	public java.util.List<com.kencana.lms.model.PatronStatus> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _patronStatusLocalService.findByCompany(companyId, start, end);
	}

	@Override
	public java.util.List<com.kencana.lms.model.PatronStatus> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _patronStatusLocalService.findByCompany(companyId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PatronStatusLocalService getWrappedPatronStatusLocalService() {
		return _patronStatusLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPatronStatusLocalService(
		PatronStatusLocalService patronStatusLocalService) {
		_patronStatusLocalService = patronStatusLocalService;
	}

	@Override
	public PatronStatusLocalService getWrappedService() {
		return _patronStatusLocalService;
	}

	@Override
	public void setWrappedService(
		PatronStatusLocalService patronStatusLocalService) {
		_patronStatusLocalService = patronStatusLocalService;
	}

	private PatronStatusLocalService _patronStatusLocalService;
}