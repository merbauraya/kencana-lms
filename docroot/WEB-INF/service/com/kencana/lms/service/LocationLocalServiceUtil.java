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
 * Provides the local service utility for Location. This utility wraps
 * {@link com.kencana.lms.service.impl.LocationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mazlan Mat
 * @see LocationLocalService
 * @see com.kencana.lms.service.base.LocationLocalServiceBaseImpl
 * @see com.kencana.lms.service.impl.LocationLocalServiceImpl
 * @generated
 */
public class LocationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.kencana.lms.service.impl.LocationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the location to the database. Also notifies the appropriate model listeners.
	*
	* @param location the location
	* @return the location that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Location addLocation(
		com.kencana.lms.model.Location location)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLocation(location);
	}

	/**
	* Creates a new location with the primary key. Does not add the location to the database.
	*
	* @param locationId the primary key for the new location
	* @return the new location
	*/
	public static com.kencana.lms.model.Location createLocation(long locationId) {
		return getService().createLocation(locationId);
	}

	/**
	* Deletes the location with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param locationId the primary key of the location
	* @return the location that was removed
	* @throws PortalException if a location with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Location deleteLocation(long locationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLocation(locationId);
	}

	/**
	* Deletes the location from the database. Also notifies the appropriate model listeners.
	*
	* @param location the location
	* @return the location that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Location deleteLocation(
		com.kencana.lms.model.Location location)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLocation(location);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.LocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.LocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.kencana.lms.model.Location fetchLocation(long locationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLocation(locationId);
	}

	/**
	* Returns the location with the primary key.
	*
	* @param locationId the primary key of the location
	* @return the location
	* @throws PortalException if a location with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Location getLocation(long locationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLocation(locationId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the locations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.LocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of locations
	* @param end the upper bound of the range of locations (not inclusive)
	* @return the range of locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.Location> getLocations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLocations(start, end);
	}

	/**
	* Returns the number of locations.
	*
	* @return the number of locations
	* @throws SystemException if a system exception occurred
	*/
	public static int getLocationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLocationsCount();
	}

	/**
	* Updates the location in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param location the location
	* @return the location that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.Location updateLocation(
		com.kencana.lms.model.Location location)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLocation(location);
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

	/**
	* Return list of locations based on library
	*
	* @param libraryId
	* @return
	* @throws SystemException
	*/
	public static java.util.List<com.kencana.lms.model.Location> findByLibrary(
		long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByLibrary(libraryId);
	}

	/**
	* Add/Update location
	*
	* @param userId
	* @param companyId
	* @param groupId
	* @param libaryId
	* @param locationId
	* @param description
	* @return
	* @throws SystemException
	*/
	public static com.kencana.lms.model.Location updateLocation(long userId,
		long companyId, long groupId, long libraryId, long locationId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateLocation(userId, companyId, groupId, libraryId,
			locationId, name);
	}

	public static java.util.List<com.kencana.lms.model.Location> findByGroupCompany(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroupCompany(companyId, groupId);
	}

	public static java.util.List<com.kencana.lms.model.Location> findByGroupCompany(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByGroupCompany(companyId, groupId, start, end, obc);
	}

	public static void clearService() {
		_service = null;
	}

	public static LocationLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LocationLocalService.class.getName());

			if (invokableLocalService instanceof LocationLocalService) {
				_service = (LocationLocalService)invokableLocalService;
			}
			else {
				_service = new LocationLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(LocationLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(LocationLocalService service) {
	}

	private static LocationLocalService _service;
}