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
 * Provides a wrapper for {@link PatronLocalService}.
 *
 * @author Mazlan Mat
 * @see PatronLocalService
 * @generated
 */
public class PatronLocalServiceWrapper implements PatronLocalService,
	ServiceWrapper<PatronLocalService> {
	public PatronLocalServiceWrapper(PatronLocalService patronLocalService) {
		_patronLocalService = patronLocalService;
	}

	/**
	* Adds the patron to the database. Also notifies the appropriate model listeners.
	*
	* @param patron the patron
	* @return the patron that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.Patron addPatron(
		com.kencana.lms.model.Patron patron)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _patronLocalService.addPatron(patron);
	}

	/**
	* Creates a new patron with the primary key. Does not add the patron to the database.
	*
	* @param patronId the primary key for the new patron
	* @return the new patron
	*/
	@Override
	public com.kencana.lms.model.Patron createPatron(long patronId) {
		return _patronLocalService.createPatron(patronId);
	}

	/**
	* Deletes the patron with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param patronId the primary key of the patron
	* @return the patron that was removed
	* @throws PortalException if a patron with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.Patron deletePatron(long patronId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _patronLocalService.deletePatron(patronId);
	}

	/**
	* Deletes the patron from the database. Also notifies the appropriate model listeners.
	*
	* @param patron the patron
	* @return the patron that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.Patron deletePatron(
		com.kencana.lms.model.Patron patron)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _patronLocalService.deletePatron(patron);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _patronLocalService.dynamicQuery();
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
		return _patronLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _patronLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _patronLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _patronLocalService.dynamicQueryCount(dynamicQuery);
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
		return _patronLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.kencana.lms.model.Patron fetchPatron(long patronId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _patronLocalService.fetchPatron(patronId);
	}

	/**
	* Returns the patron with the primary key.
	*
	* @param patronId the primary key of the patron
	* @return the patron
	* @throws PortalException if a patron with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.Patron getPatron(long patronId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _patronLocalService.getPatron(patronId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _patronLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the patrons.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of patrons
	* @param end the upper bound of the range of patrons (not inclusive)
	* @return the range of patrons
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.kencana.lms.model.Patron> getPatrons(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _patronLocalService.getPatrons(start, end);
	}

	/**
	* Returns the number of patrons.
	*
	* @return the number of patrons
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPatronsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _patronLocalService.getPatronsCount();
	}

	/**
	* Updates the patron in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param patron the patron
	* @return the patron that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.Patron updatePatron(
		com.kencana.lms.model.Patron patron)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _patronLocalService.updatePatron(patron);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _patronLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_patronLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _patronLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.liferay.portal.kernel.search.Hits search(long companyId,
		java.lang.String keywords, int status,
		java.util.LinkedHashMap<java.lang.String, java.lang.Object> params,
		int start, int end, com.liferay.portal.kernel.search.Sort sort)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _patronLocalService.search(companyId, keywords, status, params,
			start, end, sort);
	}

	@Override
	public com.kencana.lms.model.Patron findByCardNumber(
		java.lang.String cardNumber)
		throws com.kencana.lms.NoSuchPatronException,
			com.liferay.portal.kernel.exception.SystemException {
		return _patronLocalService.findByCardNumber(cardNumber);
	}

	@Override
	public com.kencana.lms.model.Patron safeFindByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _patronLocalService.safeFindByUserId(userId);
	}

	@Override
	public com.kencana.lms.model.Patron findByUserId(long userId)
		throws com.kencana.lms.NoSuchPatronException,
			com.liferay.portal.kernel.exception.SystemException {
		return _patronLocalService.findByUserId(userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PatronLocalService getWrappedPatronLocalService() {
		return _patronLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPatronLocalService(
		PatronLocalService patronLocalService) {
		_patronLocalService = patronLocalService;
	}

	@Override
	public PatronLocalService getWrappedService() {
		return _patronLocalService;
	}

	@Override
	public void setWrappedService(PatronLocalService patronLocalService) {
		_patronLocalService = patronLocalService;
	}

	private PatronLocalService _patronLocalService;
}