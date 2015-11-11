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
 * Provides a wrapper for {@link LibraryLocalService}.
 *
 * @author Mazlan Mat
 * @see LibraryLocalService
 * @generated
 */
public class LibraryLocalServiceWrapper implements LibraryLocalService,
	ServiceWrapper<LibraryLocalService> {
	public LibraryLocalServiceWrapper(LibraryLocalService libraryLocalService) {
		_libraryLocalService = libraryLocalService;
	}

	/**
	* Adds the library to the database. Also notifies the appropriate model listeners.
	*
	* @param library the library
	* @return the library that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.Library addLibrary(
		com.kencana.lms.model.Library library)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _libraryLocalService.addLibrary(library);
	}

	/**
	* Creates a new library with the primary key. Does not add the library to the database.
	*
	* @param libraryId the primary key for the new library
	* @return the new library
	*/
	@Override
	public com.kencana.lms.model.Library createLibrary(long libraryId) {
		return _libraryLocalService.createLibrary(libraryId);
	}

	/**
	* Deletes the library with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param libraryId the primary key of the library
	* @return the library that was removed
	* @throws PortalException if a library with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.Library deleteLibrary(long libraryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _libraryLocalService.deleteLibrary(libraryId);
	}

	/**
	* Deletes the library from the database. Also notifies the appropriate model listeners.
	*
	* @param library the library
	* @return the library that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.Library deleteLibrary(
		com.kencana.lms.model.Library library)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _libraryLocalService.deleteLibrary(library);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _libraryLocalService.dynamicQuery();
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
		return _libraryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.LibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _libraryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.LibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _libraryLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _libraryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _libraryLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.kencana.lms.model.Library fetchLibrary(long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _libraryLocalService.fetchLibrary(libraryId);
	}

	/**
	* Returns the library with the primary key.
	*
	* @param libraryId the primary key of the library
	* @return the library
	* @throws PortalException if a library with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.Library getLibrary(long libraryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _libraryLocalService.getLibrary(libraryId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _libraryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the libraries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.LibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of libraries
	* @param end the upper bound of the range of libraries (not inclusive)
	* @return the range of libraries
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.kencana.lms.model.Library> getLibraries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _libraryLocalService.getLibraries(start, end);
	}

	/**
	* Returns the number of libraries.
	*
	* @return the number of libraries
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLibrariesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _libraryLocalService.getLibrariesCount();
	}

	/**
	* Updates the library in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param library the library
	* @return the library that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.Library updateLibrary(
		com.kencana.lms.model.Library library)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _libraryLocalService.updateLibrary(library);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _libraryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_libraryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _libraryLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.kencana.lms.model.Library> findByGroupCompany(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _libraryLocalService.findByGroupCompany(companyId, groupId);
	}

	@Override
	public java.util.List<com.kencana.lms.model.Library> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _libraryLocalService.findByCompany(companyId, start, end);
	}

	@Override
	public java.util.List<com.kencana.lms.model.Library> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _libraryLocalService.findByCompany(companyId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LibraryLocalService getWrappedLibraryLocalService() {
		return _libraryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLibraryLocalService(
		LibraryLocalService libraryLocalService) {
		_libraryLocalService = libraryLocalService;
	}

	@Override
	public LibraryLocalService getWrappedService() {
		return _libraryLocalService;
	}

	@Override
	public void setWrappedService(LibraryLocalService libraryLocalService) {
		_libraryLocalService = libraryLocalService;
	}

	private LibraryLocalService _libraryLocalService;
}