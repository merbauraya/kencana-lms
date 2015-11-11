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
 * Provides the local service utility for PatronCategory. This utility wraps
 * {@link com.kencana.lms.service.impl.PatronCategoryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mazlan Mat
 * @see PatronCategoryLocalService
 * @see com.kencana.lms.service.base.PatronCategoryLocalServiceBaseImpl
 * @see com.kencana.lms.service.impl.PatronCategoryLocalServiceImpl
 * @generated
 */
public class PatronCategoryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.kencana.lms.service.impl.PatronCategoryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the patron category to the database. Also notifies the appropriate model listeners.
	*
	* @param patronCategory the patron category
	* @return the patron category that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.PatronCategory addPatronCategory(
		com.kencana.lms.model.PatronCategory patronCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addPatronCategory(patronCategory);
	}

	/**
	* Creates a new patron category with the primary key. Does not add the patron category to the database.
	*
	* @param patronCategoryId the primary key for the new patron category
	* @return the new patron category
	*/
	public static com.kencana.lms.model.PatronCategory createPatronCategory(
		long patronCategoryId) {
		return getService().createPatronCategory(patronCategoryId);
	}

	/**
	* Deletes the patron category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param patronCategoryId the primary key of the patron category
	* @return the patron category that was removed
	* @throws PortalException if a patron category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.PatronCategory deletePatronCategory(
		long patronCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePatronCategory(patronCategoryId);
	}

	/**
	* Deletes the patron category from the database. Also notifies the appropriate model listeners.
	*
	* @param patronCategory the patron category
	* @return the patron category that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.PatronCategory deletePatronCategory(
		com.kencana.lms.model.PatronCategory patronCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePatronCategory(patronCategory);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.kencana.lms.model.PatronCategory fetchPatronCategory(
		long patronCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchPatronCategory(patronCategoryId);
	}

	/**
	* Returns the patron category with the primary key.
	*
	* @param patronCategoryId the primary key of the patron category
	* @return the patron category
	* @throws PortalException if a patron category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.PatronCategory getPatronCategory(
		long patronCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPatronCategory(patronCategoryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the patron categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of patron categories
	* @param end the upper bound of the range of patron categories (not inclusive)
	* @return the range of patron categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.PatronCategory> getPatronCategories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPatronCategories(start, end);
	}

	/**
	* Returns the number of patron categories.
	*
	* @return the number of patron categories
	* @throws SystemException if a system exception occurred
	*/
	public static int getPatronCategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPatronCategoriesCount();
	}

	/**
	* Updates the patron category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param patronCategory the patron category
	* @return the patron category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.PatronCategory updatePatronCategory(
		com.kencana.lms.model.PatronCategory patronCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePatronCategory(patronCategory);
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

	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByCompany(companyId);
	}

	public static com.kencana.lms.model.PatronCategory add(long companyId,
		long groupId, java.lang.String name, java.lang.String notes)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().add(companyId, groupId, name, notes);
	}

	public static com.kencana.lms.model.PatronCategory update(
		long patronCategoryId, long groupId, long companyId,
		java.lang.String name, java.lang.String notes)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .update(patronCategoryId, groupId, companyId, name, notes);
	}

	public static java.util.List<com.kencana.lms.model.PatronCategory> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId);
	}

	public static java.util.List<com.kencana.lms.model.PatronCategory> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId, start, end);
	}

	public static java.util.List<com.kencana.lms.model.PatronCategory> findByCompanyGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompanyGroup(companyId, groupId);
	}

	public static java.util.List<com.kencana.lms.model.PatronCategory> findByGroupCompany(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroupCompany(companyId, groupId, start, end);
	}

	public static void clearService() {
		_service = null;
	}

	public static PatronCategoryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PatronCategoryLocalService.class.getName());

			if (invokableLocalService instanceof PatronCategoryLocalService) {
				_service = (PatronCategoryLocalService)invokableLocalService;
			}
			else {
				_service = new PatronCategoryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(PatronCategoryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(PatronCategoryLocalService service) {
	}

	private static PatronCategoryLocalService _service;
}