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

import com.kencana.lms.model.CircTransHistory;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the circ trans history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see CircTransHistoryPersistenceImpl
 * @see CircTransHistoryUtil
 * @generated
 */
public interface CircTransHistoryPersistence extends BasePersistence<CircTransHistory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CircTransHistoryUtil} to access the circ trans history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the circ trans histories where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching circ trans histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CircTransHistory> findByCompanyGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the circ trans histories where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CircTransHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of circ trans histories
	* @param end the upper bound of the range of circ trans histories (not inclusive)
	* @return the range of matching circ trans histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CircTransHistory> findByCompanyGroup(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the circ trans histories where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CircTransHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of circ trans histories
	* @param end the upper bound of the range of circ trans histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching circ trans histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CircTransHistory> findByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first circ trans history in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching circ trans history
	* @throws com.kencana.lms.NoSuchCircTransHistoryException if a matching circ trans history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CircTransHistory findByCompanyGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCircTransHistoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first circ trans history in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching circ trans history, or <code>null</code> if a matching circ trans history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CircTransHistory fetchByCompanyGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last circ trans history in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching circ trans history
	* @throws com.kencana.lms.NoSuchCircTransHistoryException if a matching circ trans history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CircTransHistory findByCompanyGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCircTransHistoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last circ trans history in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching circ trans history, or <code>null</code> if a matching circ trans history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CircTransHistory fetchByCompanyGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the circ trans histories before and after the current circ trans history in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param transId the primary key of the current circ trans history
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next circ trans history
	* @throws com.kencana.lms.NoSuchCircTransHistoryException if a circ trans history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CircTransHistory[] findByCompanyGroup_PrevAndNext(
		long transId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCircTransHistoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the circ trans histories where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of circ trans histories where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching circ trans histories
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the circ trans histories where companyId = &#63; and groupId = &#63; and libraryId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param libraryId the library ID
	* @return the matching circ trans histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CircTransHistory> findByCompanyGroupLibrary(
		long companyId, long groupId, long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the circ trans histories where companyId = &#63; and groupId = &#63; and libraryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CircTransHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param libraryId the library ID
	* @param start the lower bound of the range of circ trans histories
	* @param end the upper bound of the range of circ trans histories (not inclusive)
	* @return the range of matching circ trans histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CircTransHistory> findByCompanyGroupLibrary(
		long companyId, long groupId, long libraryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the circ trans histories where companyId = &#63; and groupId = &#63; and libraryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CircTransHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param libraryId the library ID
	* @param start the lower bound of the range of circ trans histories
	* @param end the upper bound of the range of circ trans histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching circ trans histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CircTransHistory> findByCompanyGroupLibrary(
		long companyId, long groupId, long libraryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first circ trans history in the ordered set where companyId = &#63; and groupId = &#63; and libraryId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching circ trans history
	* @throws com.kencana.lms.NoSuchCircTransHistoryException if a matching circ trans history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CircTransHistory findByCompanyGroupLibrary_First(
		long companyId, long groupId, long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCircTransHistoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first circ trans history in the ordered set where companyId = &#63; and groupId = &#63; and libraryId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching circ trans history, or <code>null</code> if a matching circ trans history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CircTransHistory fetchByCompanyGroupLibrary_First(
		long companyId, long groupId, long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last circ trans history in the ordered set where companyId = &#63; and groupId = &#63; and libraryId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching circ trans history
	* @throws com.kencana.lms.NoSuchCircTransHistoryException if a matching circ trans history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CircTransHistory findByCompanyGroupLibrary_Last(
		long companyId, long groupId, long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCircTransHistoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last circ trans history in the ordered set where companyId = &#63; and groupId = &#63; and libraryId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching circ trans history, or <code>null</code> if a matching circ trans history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CircTransHistory fetchByCompanyGroupLibrary_Last(
		long companyId, long groupId, long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the circ trans histories before and after the current circ trans history in the ordered set where companyId = &#63; and groupId = &#63; and libraryId = &#63;.
	*
	* @param transId the primary key of the current circ trans history
	* @param companyId the company ID
	* @param groupId the group ID
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next circ trans history
	* @throws com.kencana.lms.NoSuchCircTransHistoryException if a circ trans history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CircTransHistory[] findByCompanyGroupLibrary_PrevAndNext(
		long transId, long companyId, long groupId, long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCircTransHistoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the circ trans histories where companyId = &#63; and groupId = &#63; and libraryId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param libraryId the library ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyGroupLibrary(long companyId, long groupId,
		long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of circ trans histories where companyId = &#63; and groupId = &#63; and libraryId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param libraryId the library ID
	* @return the number of matching circ trans histories
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyGroupLibrary(long companyId, long groupId,
		long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the circ trans histories where companyId = &#63; and patronId = &#63;.
	*
	* @param companyId the company ID
	* @param patronId the patron ID
	* @return the matching circ trans histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CircTransHistory> findByPatron(
		long companyId, long patronId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the circ trans histories where companyId = &#63; and patronId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CircTransHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param patronId the patron ID
	* @param start the lower bound of the range of circ trans histories
	* @param end the upper bound of the range of circ trans histories (not inclusive)
	* @return the range of matching circ trans histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CircTransHistory> findByPatron(
		long companyId, long patronId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the circ trans histories where companyId = &#63; and patronId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CircTransHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param patronId the patron ID
	* @param start the lower bound of the range of circ trans histories
	* @param end the upper bound of the range of circ trans histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching circ trans histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CircTransHistory> findByPatron(
		long companyId, long patronId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first circ trans history in the ordered set where companyId = &#63; and patronId = &#63;.
	*
	* @param companyId the company ID
	* @param patronId the patron ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching circ trans history
	* @throws com.kencana.lms.NoSuchCircTransHistoryException if a matching circ trans history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CircTransHistory findByPatron_First(
		long companyId, long patronId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCircTransHistoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first circ trans history in the ordered set where companyId = &#63; and patronId = &#63;.
	*
	* @param companyId the company ID
	* @param patronId the patron ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching circ trans history, or <code>null</code> if a matching circ trans history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CircTransHistory fetchByPatron_First(
		long companyId, long patronId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last circ trans history in the ordered set where companyId = &#63; and patronId = &#63;.
	*
	* @param companyId the company ID
	* @param patronId the patron ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching circ trans history
	* @throws com.kencana.lms.NoSuchCircTransHistoryException if a matching circ trans history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CircTransHistory findByPatron_Last(
		long companyId, long patronId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCircTransHistoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last circ trans history in the ordered set where companyId = &#63; and patronId = &#63;.
	*
	* @param companyId the company ID
	* @param patronId the patron ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching circ trans history, or <code>null</code> if a matching circ trans history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CircTransHistory fetchByPatron_Last(
		long companyId, long patronId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the circ trans histories before and after the current circ trans history in the ordered set where companyId = &#63; and patronId = &#63;.
	*
	* @param transId the primary key of the current circ trans history
	* @param companyId the company ID
	* @param patronId the patron ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next circ trans history
	* @throws com.kencana.lms.NoSuchCircTransHistoryException if a circ trans history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CircTransHistory[] findByPatron_PrevAndNext(
		long transId, long companyId, long patronId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCircTransHistoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the circ trans histories where companyId = &#63; and patronId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param patronId the patron ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPatron(long companyId, long patronId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of circ trans histories where companyId = &#63; and patronId = &#63;.
	*
	* @param companyId the company ID
	* @param patronId the patron ID
	* @return the number of matching circ trans histories
	* @throws SystemException if a system exception occurred
	*/
	public int countByPatron(long companyId, long patronId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the circ trans histories where companyId = &#63; and catalogItemId = &#63;.
	*
	* @param companyId the company ID
	* @param catalogItemId the catalog item ID
	* @return the matching circ trans histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CircTransHistory> findByCatalogItem(
		long companyId, long catalogItemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the circ trans histories where companyId = &#63; and catalogItemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CircTransHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param catalogItemId the catalog item ID
	* @param start the lower bound of the range of circ trans histories
	* @param end the upper bound of the range of circ trans histories (not inclusive)
	* @return the range of matching circ trans histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CircTransHistory> findByCatalogItem(
		long companyId, long catalogItemId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the circ trans histories where companyId = &#63; and catalogItemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CircTransHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param catalogItemId the catalog item ID
	* @param start the lower bound of the range of circ trans histories
	* @param end the upper bound of the range of circ trans histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching circ trans histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CircTransHistory> findByCatalogItem(
		long companyId, long catalogItemId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first circ trans history in the ordered set where companyId = &#63; and catalogItemId = &#63;.
	*
	* @param companyId the company ID
	* @param catalogItemId the catalog item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching circ trans history
	* @throws com.kencana.lms.NoSuchCircTransHistoryException if a matching circ trans history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CircTransHistory findByCatalogItem_First(
		long companyId, long catalogItemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCircTransHistoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first circ trans history in the ordered set where companyId = &#63; and catalogItemId = &#63;.
	*
	* @param companyId the company ID
	* @param catalogItemId the catalog item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching circ trans history, or <code>null</code> if a matching circ trans history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CircTransHistory fetchByCatalogItem_First(
		long companyId, long catalogItemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last circ trans history in the ordered set where companyId = &#63; and catalogItemId = &#63;.
	*
	* @param companyId the company ID
	* @param catalogItemId the catalog item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching circ trans history
	* @throws com.kencana.lms.NoSuchCircTransHistoryException if a matching circ trans history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CircTransHistory findByCatalogItem_Last(
		long companyId, long catalogItemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCircTransHistoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last circ trans history in the ordered set where companyId = &#63; and catalogItemId = &#63;.
	*
	* @param companyId the company ID
	* @param catalogItemId the catalog item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching circ trans history, or <code>null</code> if a matching circ trans history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CircTransHistory fetchByCatalogItem_Last(
		long companyId, long catalogItemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the circ trans histories before and after the current circ trans history in the ordered set where companyId = &#63; and catalogItemId = &#63;.
	*
	* @param transId the primary key of the current circ trans history
	* @param companyId the company ID
	* @param catalogItemId the catalog item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next circ trans history
	* @throws com.kencana.lms.NoSuchCircTransHistoryException if a circ trans history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CircTransHistory[] findByCatalogItem_PrevAndNext(
		long transId, long companyId, long catalogItemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCircTransHistoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the circ trans histories where companyId = &#63; and catalogItemId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param catalogItemId the catalog item ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCatalogItem(long companyId, long catalogItemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of circ trans histories where companyId = &#63; and catalogItemId = &#63;.
	*
	* @param companyId the company ID
	* @param catalogItemId the catalog item ID
	* @return the number of matching circ trans histories
	* @throws SystemException if a system exception occurred
	*/
	public int countByCatalogItem(long companyId, long catalogItemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the circ trans history in the entity cache if it is enabled.
	*
	* @param circTransHistory the circ trans history
	*/
	public void cacheResult(
		com.kencana.lms.model.CircTransHistory circTransHistory);

	/**
	* Caches the circ trans histories in the entity cache if it is enabled.
	*
	* @param circTransHistories the circ trans histories
	*/
	public void cacheResult(
		java.util.List<com.kencana.lms.model.CircTransHistory> circTransHistories);

	/**
	* Creates a new circ trans history with the primary key. Does not add the circ trans history to the database.
	*
	* @param transId the primary key for the new circ trans history
	* @return the new circ trans history
	*/
	public com.kencana.lms.model.CircTransHistory create(long transId);

	/**
	* Removes the circ trans history with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param transId the primary key of the circ trans history
	* @return the circ trans history that was removed
	* @throws com.kencana.lms.NoSuchCircTransHistoryException if a circ trans history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CircTransHistory remove(long transId)
		throws com.kencana.lms.NoSuchCircTransHistoryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.kencana.lms.model.CircTransHistory updateImpl(
		com.kencana.lms.model.CircTransHistory circTransHistory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the circ trans history with the primary key or throws a {@link com.kencana.lms.NoSuchCircTransHistoryException} if it could not be found.
	*
	* @param transId the primary key of the circ trans history
	* @return the circ trans history
	* @throws com.kencana.lms.NoSuchCircTransHistoryException if a circ trans history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CircTransHistory findByPrimaryKey(long transId)
		throws com.kencana.lms.NoSuchCircTransHistoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the circ trans history with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param transId the primary key of the circ trans history
	* @return the circ trans history, or <code>null</code> if a circ trans history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CircTransHistory fetchByPrimaryKey(
		long transId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the circ trans histories.
	*
	* @return the circ trans histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CircTransHistory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.CircTransHistory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the circ trans histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CircTransHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of circ trans histories
	* @param end the upper bound of the range of circ trans histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of circ trans histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CircTransHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the circ trans histories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of circ trans histories.
	*
	* @return the number of circ trans histories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}