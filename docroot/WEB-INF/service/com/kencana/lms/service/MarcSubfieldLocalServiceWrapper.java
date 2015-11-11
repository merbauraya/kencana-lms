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
 * Provides a wrapper for {@link MarcSubfieldLocalService}.
 *
 * @author Mazlan Mat
 * @see MarcSubfieldLocalService
 * @generated
 */
public class MarcSubfieldLocalServiceWrapper implements MarcSubfieldLocalService,
	ServiceWrapper<MarcSubfieldLocalService> {
	public MarcSubfieldLocalServiceWrapper(
		MarcSubfieldLocalService marcSubfieldLocalService) {
		_marcSubfieldLocalService = marcSubfieldLocalService;
	}

	/**
	* Adds the marc subfield to the database. Also notifies the appropriate model listeners.
	*
	* @param marcSubfield the marc subfield
	* @return the marc subfield that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.MarcSubfield addMarcSubfield(
		com.kencana.lms.model.MarcSubfield marcSubfield)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _marcSubfieldLocalService.addMarcSubfield(marcSubfield);
	}

	/**
	* Creates a new marc subfield with the primary key. Does not add the marc subfield to the database.
	*
	* @param MarcSubfieldId the primary key for the new marc subfield
	* @return the new marc subfield
	*/
	@Override
	public com.kencana.lms.model.MarcSubfield createMarcSubfield(
		long MarcSubfieldId) {
		return _marcSubfieldLocalService.createMarcSubfield(MarcSubfieldId);
	}

	/**
	* Deletes the marc subfield with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param MarcSubfieldId the primary key of the marc subfield
	* @return the marc subfield that was removed
	* @throws PortalException if a marc subfield with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.MarcSubfield deleteMarcSubfield(
		long MarcSubfieldId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _marcSubfieldLocalService.deleteMarcSubfield(MarcSubfieldId);
	}

	/**
	* Deletes the marc subfield from the database. Also notifies the appropriate model listeners.
	*
	* @param marcSubfield the marc subfield
	* @return the marc subfield that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.MarcSubfield deleteMarcSubfield(
		com.kencana.lms.model.MarcSubfield marcSubfield)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _marcSubfieldLocalService.deleteMarcSubfield(marcSubfield);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _marcSubfieldLocalService.dynamicQuery();
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
		return _marcSubfieldLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcSubfieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _marcSubfieldLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcSubfieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _marcSubfieldLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _marcSubfieldLocalService.dynamicQueryCount(dynamicQuery);
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
		return _marcSubfieldLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.kencana.lms.model.MarcSubfield fetchMarcSubfield(
		long MarcSubfieldId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _marcSubfieldLocalService.fetchMarcSubfield(MarcSubfieldId);
	}

	/**
	* Returns the marc subfield with the primary key.
	*
	* @param MarcSubfieldId the primary key of the marc subfield
	* @return the marc subfield
	* @throws PortalException if a marc subfield with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.MarcSubfield getMarcSubfield(
		long MarcSubfieldId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _marcSubfieldLocalService.getMarcSubfield(MarcSubfieldId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _marcSubfieldLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the marc subfields.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcSubfieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marc subfields
	* @param end the upper bound of the range of marc subfields (not inclusive)
	* @return the range of marc subfields
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.kencana.lms.model.MarcSubfield> getMarcSubfields(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _marcSubfieldLocalService.getMarcSubfields(start, end);
	}

	/**
	* Returns the number of marc subfields.
	*
	* @return the number of marc subfields
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getMarcSubfieldsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _marcSubfieldLocalService.getMarcSubfieldsCount();
	}

	/**
	* Updates the marc subfield in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param marcSubfield the marc subfield
	* @return the marc subfield that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.MarcSubfield updateMarcSubfield(
		com.kencana.lms.model.MarcSubfield marcSubfield)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _marcSubfieldLocalService.updateMarcSubfield(marcSubfield);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _marcSubfieldLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_marcSubfieldLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _marcSubfieldLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MarcSubfieldLocalService getWrappedMarcSubfieldLocalService() {
		return _marcSubfieldLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMarcSubfieldLocalService(
		MarcSubfieldLocalService marcSubfieldLocalService) {
		_marcSubfieldLocalService = marcSubfieldLocalService;
	}

	@Override
	public MarcSubfieldLocalService getWrappedService() {
		return _marcSubfieldLocalService;
	}

	@Override
	public void setWrappedService(
		MarcSubfieldLocalService marcSubfieldLocalService) {
		_marcSubfieldLocalService = marcSubfieldLocalService;
	}

	private MarcSubfieldLocalService _marcSubfieldLocalService;
}