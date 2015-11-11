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
 * Provides a wrapper for {@link CircTransHistoryLocalService}.
 *
 * @author Mazlan Mat
 * @see CircTransHistoryLocalService
 * @generated
 */
public class CircTransHistoryLocalServiceWrapper
	implements CircTransHistoryLocalService,
		ServiceWrapper<CircTransHistoryLocalService> {
	public CircTransHistoryLocalServiceWrapper(
		CircTransHistoryLocalService circTransHistoryLocalService) {
		_circTransHistoryLocalService = circTransHistoryLocalService;
	}

	/**
	* Adds the circ trans history to the database. Also notifies the appropriate model listeners.
	*
	* @param circTransHistory the circ trans history
	* @return the circ trans history that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.CircTransHistory addCircTransHistory(
		com.kencana.lms.model.CircTransHistory circTransHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _circTransHistoryLocalService.addCircTransHistory(circTransHistory);
	}

	/**
	* Creates a new circ trans history with the primary key. Does not add the circ trans history to the database.
	*
	* @param transId the primary key for the new circ trans history
	* @return the new circ trans history
	*/
	@Override
	public com.kencana.lms.model.CircTransHistory createCircTransHistory(
		long transId) {
		return _circTransHistoryLocalService.createCircTransHistory(transId);
	}

	/**
	* Deletes the circ trans history with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param transId the primary key of the circ trans history
	* @return the circ trans history that was removed
	* @throws PortalException if a circ trans history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.CircTransHistory deleteCircTransHistory(
		long transId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _circTransHistoryLocalService.deleteCircTransHistory(transId);
	}

	/**
	* Deletes the circ trans history from the database. Also notifies the appropriate model listeners.
	*
	* @param circTransHistory the circ trans history
	* @return the circ trans history that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.CircTransHistory deleteCircTransHistory(
		com.kencana.lms.model.CircTransHistory circTransHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _circTransHistoryLocalService.deleteCircTransHistory(circTransHistory);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _circTransHistoryLocalService.dynamicQuery();
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
		return _circTransHistoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CircTransHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _circTransHistoryLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CircTransHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _circTransHistoryLocalService.dynamicQuery(dynamicQuery, start,
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
		return _circTransHistoryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _circTransHistoryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.kencana.lms.model.CircTransHistory fetchCircTransHistory(
		long transId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _circTransHistoryLocalService.fetchCircTransHistory(transId);
	}

	/**
	* Returns the circ trans history with the primary key.
	*
	* @param transId the primary key of the circ trans history
	* @return the circ trans history
	* @throws PortalException if a circ trans history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.CircTransHistory getCircTransHistory(
		long transId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _circTransHistoryLocalService.getCircTransHistory(transId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _circTransHistoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the circ trans histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CircTransHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of circ trans histories
	* @param end the upper bound of the range of circ trans histories (not inclusive)
	* @return the range of circ trans histories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.kencana.lms.model.CircTransHistory> getCircTransHistories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _circTransHistoryLocalService.getCircTransHistories(start, end);
	}

	/**
	* Returns the number of circ trans histories.
	*
	* @return the number of circ trans histories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCircTransHistoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _circTransHistoryLocalService.getCircTransHistoriesCount();
	}

	/**
	* Updates the circ trans history in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param circTransHistory the circ trans history
	* @return the circ trans history that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.CircTransHistory updateCircTransHistory(
		com.kencana.lms.model.CircTransHistory circTransHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _circTransHistoryLocalService.updateCircTransHistory(circTransHistory);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _circTransHistoryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_circTransHistoryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _circTransHistoryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CircTransHistoryLocalService getWrappedCircTransHistoryLocalService() {
		return _circTransHistoryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCircTransHistoryLocalService(
		CircTransHistoryLocalService circTransHistoryLocalService) {
		_circTransHistoryLocalService = circTransHistoryLocalService;
	}

	@Override
	public CircTransHistoryLocalService getWrappedService() {
		return _circTransHistoryLocalService;
	}

	@Override
	public void setWrappedService(
		CircTransHistoryLocalService circTransHistoryLocalService) {
		_circTransHistoryLocalService = circTransHistoryLocalService;
	}

	private CircTransHistoryLocalService _circTransHistoryLocalService;
}