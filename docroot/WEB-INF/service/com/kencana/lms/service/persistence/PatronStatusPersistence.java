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

package com.kencana.lms.service.persistence;

import com.kencana.lms.model.PatronStatus;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the patron status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see PatronStatusPersistenceImpl
 * @see PatronStatusUtil
 * @generated
 */
public interface PatronStatusPersistence extends BasePersistence<PatronStatus> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PatronStatusUtil} to access the patron status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the patron statuses where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching patron statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.PatronStatus> findByCompanyGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the patron statuses where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of patron statuses
	* @param end the upper bound of the range of patron statuses (not inclusive)
	* @return the range of matching patron statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.PatronStatus> findByCompanyGroup(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the patron statuses where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of patron statuses
	* @param end the upper bound of the range of patron statuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching patron statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.PatronStatus> findByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patron status in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patron status
	* @throws com.kencana.lms.NoSuchPatronStatusException if a matching patron status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.PatronStatus findByCompanyGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchPatronStatusException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patron status in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patron status, or <code>null</code> if a matching patron status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.PatronStatus fetchByCompanyGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patron status in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patron status
	* @throws com.kencana.lms.NoSuchPatronStatusException if a matching patron status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.PatronStatus findByCompanyGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchPatronStatusException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patron status in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patron status, or <code>null</code> if a matching patron status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.PatronStatus fetchByCompanyGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patron statuses before and after the current patron status in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param patronStatusId the primary key of the current patron status
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next patron status
	* @throws com.kencana.lms.NoSuchPatronStatusException if a patron status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.PatronStatus[] findByCompanyGroup_PrevAndNext(
		long patronStatusId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchPatronStatusException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the patron statuses where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of patron statuses where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching patron statuses
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the patron statuses where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching patron statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.PatronStatus> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the patron statuses where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of patron statuses
	* @param end the upper bound of the range of patron statuses (not inclusive)
	* @return the range of matching patron statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.PatronStatus> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the patron statuses where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of patron statuses
	* @param end the upper bound of the range of patron statuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching patron statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.PatronStatus> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patron status in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patron status
	* @throws com.kencana.lms.NoSuchPatronStatusException if a matching patron status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.PatronStatus findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchPatronStatusException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patron status in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patron status, or <code>null</code> if a matching patron status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.PatronStatus fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patron status in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patron status
	* @throws com.kencana.lms.NoSuchPatronStatusException if a matching patron status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.PatronStatus findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchPatronStatusException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patron status in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patron status, or <code>null</code> if a matching patron status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.PatronStatus fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patron statuses before and after the current patron status in the ordered set where companyId = &#63;.
	*
	* @param patronStatusId the primary key of the current patron status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next patron status
	* @throws com.kencana.lms.NoSuchPatronStatusException if a patron status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.PatronStatus[] findByCompany_PrevAndNext(
		long patronStatusId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchPatronStatusException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the patron statuses where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of patron statuses where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching patron statuses
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the patron statuses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching patron statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.PatronStatus> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the patron statuses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of patron statuses
	* @param end the upper bound of the range of patron statuses (not inclusive)
	* @return the range of matching patron statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.PatronStatus> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the patron statuses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of patron statuses
	* @param end the upper bound of the range of patron statuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching patron statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.PatronStatus> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patron status in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patron status
	* @throws com.kencana.lms.NoSuchPatronStatusException if a matching patron status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.PatronStatus findByGroup_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchPatronStatusException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patron status in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patron status, or <code>null</code> if a matching patron status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.PatronStatus fetchByGroup_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patron status in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patron status
	* @throws com.kencana.lms.NoSuchPatronStatusException if a matching patron status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.PatronStatus findByGroup_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchPatronStatusException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patron status in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patron status, or <code>null</code> if a matching patron status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.PatronStatus fetchByGroup_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patron statuses before and after the current patron status in the ordered set where groupId = &#63;.
	*
	* @param patronStatusId the primary key of the current patron status
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next patron status
	* @throws com.kencana.lms.NoSuchPatronStatusException if a patron status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.PatronStatus[] findByGroup_PrevAndNext(
		long patronStatusId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchPatronStatusException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the patron statuses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of patron statuses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching patron statuses
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the patron status in the entity cache if it is enabled.
	*
	* @param patronStatus the patron status
	*/
	public void cacheResult(com.kencana.lms.model.PatronStatus patronStatus);

	/**
	* Caches the patron statuses in the entity cache if it is enabled.
	*
	* @param patronStatuses the patron statuses
	*/
	public void cacheResult(
		java.util.List<com.kencana.lms.model.PatronStatus> patronStatuses);

	/**
	* Creates a new patron status with the primary key. Does not add the patron status to the database.
	*
	* @param patronStatusId the primary key for the new patron status
	* @return the new patron status
	*/
	public com.kencana.lms.model.PatronStatus create(long patronStatusId);

	/**
	* Removes the patron status with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param patronStatusId the primary key of the patron status
	* @return the patron status that was removed
	* @throws com.kencana.lms.NoSuchPatronStatusException if a patron status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.PatronStatus remove(long patronStatusId)
		throws com.kencana.lms.NoSuchPatronStatusException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.kencana.lms.model.PatronStatus updateImpl(
		com.kencana.lms.model.PatronStatus patronStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patron status with the primary key or throws a {@link com.kencana.lms.NoSuchPatronStatusException} if it could not be found.
	*
	* @param patronStatusId the primary key of the patron status
	* @return the patron status
	* @throws com.kencana.lms.NoSuchPatronStatusException if a patron status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.PatronStatus findByPrimaryKey(
		long patronStatusId)
		throws com.kencana.lms.NoSuchPatronStatusException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patron status with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param patronStatusId the primary key of the patron status
	* @return the patron status, or <code>null</code> if a patron status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.PatronStatus fetchByPrimaryKey(
		long patronStatusId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the patron statuses.
	*
	* @return the patron statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.PatronStatus> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.PatronStatus> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the patron statuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of patron statuses
	* @param end the upper bound of the range of patron statuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of patron statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.PatronStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the patron statuses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of patron statuses.
	*
	* @return the number of patron statuses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}