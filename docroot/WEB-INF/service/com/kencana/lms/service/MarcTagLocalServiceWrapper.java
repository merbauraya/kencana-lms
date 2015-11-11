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
 * Provides a wrapper for {@link MarcTagLocalService}.
 *
 * @author Mazlan Mat
 * @see MarcTagLocalService
 * @generated
 */
public class MarcTagLocalServiceWrapper implements MarcTagLocalService,
	ServiceWrapper<MarcTagLocalService> {
	public MarcTagLocalServiceWrapper(MarcTagLocalService marcTagLocalService) {
		_marcTagLocalService = marcTagLocalService;
	}

	/**
	* Adds the marc tag to the database. Also notifies the appropriate model listeners.
	*
	* @param marcTag the marc tag
	* @return the marc tag that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.MarcTag addMarcTag(
		com.kencana.lms.model.MarcTag marcTag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _marcTagLocalService.addMarcTag(marcTag);
	}

	/**
	* Creates a new marc tag with the primary key. Does not add the marc tag to the database.
	*
	* @param tagId the primary key for the new marc tag
	* @return the new marc tag
	*/
	@Override
	public com.kencana.lms.model.MarcTag createMarcTag(long tagId) {
		return _marcTagLocalService.createMarcTag(tagId);
	}

	/**
	* Deletes the marc tag with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tagId the primary key of the marc tag
	* @return the marc tag that was removed
	* @throws PortalException if a marc tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.MarcTag deleteMarcTag(long tagId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _marcTagLocalService.deleteMarcTag(tagId);
	}

	/**
	* Deletes the marc tag from the database. Also notifies the appropriate model listeners.
	*
	* @param marcTag the marc tag
	* @return the marc tag that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.MarcTag deleteMarcTag(
		com.kencana.lms.model.MarcTag marcTag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _marcTagLocalService.deleteMarcTag(marcTag);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _marcTagLocalService.dynamicQuery();
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
		return _marcTagLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _marcTagLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _marcTagLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _marcTagLocalService.dynamicQueryCount(dynamicQuery);
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
		return _marcTagLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.kencana.lms.model.MarcTag fetchMarcTag(long tagId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _marcTagLocalService.fetchMarcTag(tagId);
	}

	/**
	* Returns the marc tag with the primary key.
	*
	* @param tagId the primary key of the marc tag
	* @return the marc tag
	* @throws PortalException if a marc tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.MarcTag getMarcTag(long tagId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _marcTagLocalService.getMarcTag(tagId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _marcTagLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the marc tags.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marc tags
	* @param end the upper bound of the range of marc tags (not inclusive)
	* @return the range of marc tags
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.kencana.lms.model.MarcTag> getMarcTags(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _marcTagLocalService.getMarcTags(start, end);
	}

	/**
	* Returns the number of marc tags.
	*
	* @return the number of marc tags
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getMarcTagsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _marcTagLocalService.getMarcTagsCount();
	}

	/**
	* Updates the marc tag in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param marcTag the marc tag
	* @return the marc tag that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.MarcTag updateMarcTag(
		com.kencana.lms.model.MarcTag marcTag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _marcTagLocalService.updateMarcTag(marcTag);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _marcTagLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_marcTagLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _marcTagLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MarcTagLocalService getWrappedMarcTagLocalService() {
		return _marcTagLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMarcTagLocalService(
		MarcTagLocalService marcTagLocalService) {
		_marcTagLocalService = marcTagLocalService;
	}

	@Override
	public MarcTagLocalService getWrappedService() {
		return _marcTagLocalService;
	}

	@Override
	public void setWrappedService(MarcTagLocalService marcTagLocalService) {
		_marcTagLocalService = marcTagLocalService;
	}

	private MarcTagLocalService _marcTagLocalService;
}