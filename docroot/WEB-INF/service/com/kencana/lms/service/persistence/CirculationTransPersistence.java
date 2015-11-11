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

import com.kencana.lms.model.CirculationTrans;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the circulation trans service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see CirculationTransPersistenceImpl
 * @see CirculationTransUtil
 * @generated
 */
public interface CirculationTransPersistence extends BasePersistence<CirculationTrans> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CirculationTransUtil} to access the circulation trans persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the circulation transes where patronId = &#63;.
	*
	* @param patronId the patron ID
	* @return the matching circulation transes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CirculationTrans> findByPatronId(
		long patronId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the circulation transes where patronId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationTransModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param patronId the patron ID
	* @param start the lower bound of the range of circulation transes
	* @param end the upper bound of the range of circulation transes (not inclusive)
	* @return the range of matching circulation transes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CirculationTrans> findByPatronId(
		long patronId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the circulation transes where patronId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationTransModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param patronId the patron ID
	* @param start the lower bound of the range of circulation transes
	* @param end the upper bound of the range of circulation transes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching circulation transes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CirculationTrans> findByPatronId(
		long patronId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first circulation trans in the ordered set where patronId = &#63;.
	*
	* @param patronId the patron ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching circulation trans
	* @throws com.kencana.lms.NoSuchCirculationTransException if a matching circulation trans could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationTrans findByPatronId_First(
		long patronId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationTransException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first circulation trans in the ordered set where patronId = &#63;.
	*
	* @param patronId the patron ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching circulation trans, or <code>null</code> if a matching circulation trans could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationTrans fetchByPatronId_First(
		long patronId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last circulation trans in the ordered set where patronId = &#63;.
	*
	* @param patronId the patron ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching circulation trans
	* @throws com.kencana.lms.NoSuchCirculationTransException if a matching circulation trans could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationTrans findByPatronId_Last(
		long patronId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationTransException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last circulation trans in the ordered set where patronId = &#63;.
	*
	* @param patronId the patron ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching circulation trans, or <code>null</code> if a matching circulation trans could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationTrans fetchByPatronId_Last(
		long patronId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the circulation transes before and after the current circulation trans in the ordered set where patronId = &#63;.
	*
	* @param transId the primary key of the current circulation trans
	* @param patronId the patron ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next circulation trans
	* @throws com.kencana.lms.NoSuchCirculationTransException if a circulation trans with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationTrans[] findByPatronId_PrevAndNext(
		long transId, long patronId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationTransException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the circulation transes where patronId = &#63; from the database.
	*
	* @param patronId the patron ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPatronId(long patronId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of circulation transes where patronId = &#63;.
	*
	* @param patronId the patron ID
	* @return the number of matching circulation transes
	* @throws SystemException if a system exception occurred
	*/
	public int countByPatronId(long patronId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the circulation transes where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching circulation transes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CirculationTrans> findByCompanyGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the circulation transes where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationTransModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of circulation transes
	* @param end the upper bound of the range of circulation transes (not inclusive)
	* @return the range of matching circulation transes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CirculationTrans> findByCompanyGroup(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the circulation transes where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationTransModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of circulation transes
	* @param end the upper bound of the range of circulation transes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching circulation transes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CirculationTrans> findByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first circulation trans in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching circulation trans
	* @throws com.kencana.lms.NoSuchCirculationTransException if a matching circulation trans could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationTrans findByCompanyGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationTransException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first circulation trans in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching circulation trans, or <code>null</code> if a matching circulation trans could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationTrans fetchByCompanyGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last circulation trans in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching circulation trans
	* @throws com.kencana.lms.NoSuchCirculationTransException if a matching circulation trans could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationTrans findByCompanyGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationTransException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last circulation trans in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching circulation trans, or <code>null</code> if a matching circulation trans could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationTrans fetchByCompanyGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the circulation transes before and after the current circulation trans in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param transId the primary key of the current circulation trans
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next circulation trans
	* @throws com.kencana.lms.NoSuchCirculationTransException if a circulation trans with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationTrans[] findByCompanyGroup_PrevAndNext(
		long transId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationTransException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the circulation transes where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of circulation transes where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching circulation transes
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the circulation transes where companyId = &#63; and groupId = &#63; and libraryId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param libraryId the library ID
	* @return the matching circulation transes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CirculationTrans> findByCompanyGroupLibrary(
		long companyId, long groupId, long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the circulation transes where companyId = &#63; and groupId = &#63; and libraryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationTransModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param libraryId the library ID
	* @param start the lower bound of the range of circulation transes
	* @param end the upper bound of the range of circulation transes (not inclusive)
	* @return the range of matching circulation transes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CirculationTrans> findByCompanyGroupLibrary(
		long companyId, long groupId, long libraryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the circulation transes where companyId = &#63; and groupId = &#63; and libraryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationTransModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param libraryId the library ID
	* @param start the lower bound of the range of circulation transes
	* @param end the upper bound of the range of circulation transes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching circulation transes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CirculationTrans> findByCompanyGroupLibrary(
		long companyId, long groupId, long libraryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first circulation trans in the ordered set where companyId = &#63; and groupId = &#63; and libraryId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching circulation trans
	* @throws com.kencana.lms.NoSuchCirculationTransException if a matching circulation trans could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationTrans findByCompanyGroupLibrary_First(
		long companyId, long groupId, long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationTransException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first circulation trans in the ordered set where companyId = &#63; and groupId = &#63; and libraryId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching circulation trans, or <code>null</code> if a matching circulation trans could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationTrans fetchByCompanyGroupLibrary_First(
		long companyId, long groupId, long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last circulation trans in the ordered set where companyId = &#63; and groupId = &#63; and libraryId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching circulation trans
	* @throws com.kencana.lms.NoSuchCirculationTransException if a matching circulation trans could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationTrans findByCompanyGroupLibrary_Last(
		long companyId, long groupId, long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationTransException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last circulation trans in the ordered set where companyId = &#63; and groupId = &#63; and libraryId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching circulation trans, or <code>null</code> if a matching circulation trans could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationTrans fetchByCompanyGroupLibrary_Last(
		long companyId, long groupId, long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the circulation transes before and after the current circulation trans in the ordered set where companyId = &#63; and groupId = &#63; and libraryId = &#63;.
	*
	* @param transId the primary key of the current circulation trans
	* @param companyId the company ID
	* @param groupId the group ID
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next circulation trans
	* @throws com.kencana.lms.NoSuchCirculationTransException if a circulation trans with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationTrans[] findByCompanyGroupLibrary_PrevAndNext(
		long transId, long companyId, long groupId, long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationTransException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the circulation transes where companyId = &#63; and groupId = &#63; and libraryId = &#63; from the database.
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
	* Returns the number of circulation transes where companyId = &#63; and groupId = &#63; and libraryId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param libraryId the library ID
	* @return the number of matching circulation transes
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyGroupLibrary(long companyId, long groupId,
		long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the circulation transes where companyId = &#63; and patronId = &#63;.
	*
	* @param companyId the company ID
	* @param patronId the patron ID
	* @return the matching circulation transes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CirculationTrans> findByPatron(
		long companyId, long patronId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the circulation transes where companyId = &#63; and patronId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationTransModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param patronId the patron ID
	* @param start the lower bound of the range of circulation transes
	* @param end the upper bound of the range of circulation transes (not inclusive)
	* @return the range of matching circulation transes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CirculationTrans> findByPatron(
		long companyId, long patronId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the circulation transes where companyId = &#63; and patronId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationTransModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param patronId the patron ID
	* @param start the lower bound of the range of circulation transes
	* @param end the upper bound of the range of circulation transes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching circulation transes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CirculationTrans> findByPatron(
		long companyId, long patronId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first circulation trans in the ordered set where companyId = &#63; and patronId = &#63;.
	*
	* @param companyId the company ID
	* @param patronId the patron ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching circulation trans
	* @throws com.kencana.lms.NoSuchCirculationTransException if a matching circulation trans could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationTrans findByPatron_First(
		long companyId, long patronId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationTransException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first circulation trans in the ordered set where companyId = &#63; and patronId = &#63;.
	*
	* @param companyId the company ID
	* @param patronId the patron ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching circulation trans, or <code>null</code> if a matching circulation trans could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationTrans fetchByPatron_First(
		long companyId, long patronId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last circulation trans in the ordered set where companyId = &#63; and patronId = &#63;.
	*
	* @param companyId the company ID
	* @param patronId the patron ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching circulation trans
	* @throws com.kencana.lms.NoSuchCirculationTransException if a matching circulation trans could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationTrans findByPatron_Last(
		long companyId, long patronId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationTransException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last circulation trans in the ordered set where companyId = &#63; and patronId = &#63;.
	*
	* @param companyId the company ID
	* @param patronId the patron ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching circulation trans, or <code>null</code> if a matching circulation trans could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationTrans fetchByPatron_Last(
		long companyId, long patronId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the circulation transes before and after the current circulation trans in the ordered set where companyId = &#63; and patronId = &#63;.
	*
	* @param transId the primary key of the current circulation trans
	* @param companyId the company ID
	* @param patronId the patron ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next circulation trans
	* @throws com.kencana.lms.NoSuchCirculationTransException if a circulation trans with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationTrans[] findByPatron_PrevAndNext(
		long transId, long companyId, long patronId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationTransException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the circulation transes where companyId = &#63; and patronId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param patronId the patron ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPatron(long companyId, long patronId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of circulation transes where companyId = &#63; and patronId = &#63;.
	*
	* @param companyId the company ID
	* @param patronId the patron ID
	* @return the number of matching circulation transes
	* @throws SystemException if a system exception occurred
	*/
	public int countByPatron(long companyId, long patronId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the circulation trans where companyId = &#63; and catalogItemId = &#63; or throws a {@link com.kencana.lms.NoSuchCirculationTransException} if it could not be found.
	*
	* @param companyId the company ID
	* @param catalogItemId the catalog item ID
	* @return the matching circulation trans
	* @throws com.kencana.lms.NoSuchCirculationTransException if a matching circulation trans could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationTrans findByCatalogItem(
		long companyId, long catalogItemId)
		throws com.kencana.lms.NoSuchCirculationTransException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the circulation trans where companyId = &#63; and catalogItemId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param catalogItemId the catalog item ID
	* @return the matching circulation trans, or <code>null</code> if a matching circulation trans could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationTrans fetchByCatalogItem(
		long companyId, long catalogItemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the circulation trans where companyId = &#63; and catalogItemId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param catalogItemId the catalog item ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching circulation trans, or <code>null</code> if a matching circulation trans could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationTrans fetchByCatalogItem(
		long companyId, long catalogItemId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the circulation trans where companyId = &#63; and catalogItemId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param catalogItemId the catalog item ID
	* @return the circulation trans that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationTrans removeByCatalogItem(
		long companyId, long catalogItemId)
		throws com.kencana.lms.NoSuchCirculationTransException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of circulation transes where companyId = &#63; and catalogItemId = &#63;.
	*
	* @param companyId the company ID
	* @param catalogItemId the catalog item ID
	* @return the number of matching circulation transes
	* @throws SystemException if a system exception occurred
	*/
	public int countByCatalogItem(long companyId, long catalogItemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the circulation transes where companyId = &#63; and libraryId = &#63; and overdue = &#63;.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param overdue the overdue
	* @return the matching circulation transes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CirculationTrans> findByOverdueLibrary(
		long companyId, long libraryId, boolean overdue)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the circulation transes where companyId = &#63; and libraryId = &#63; and overdue = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationTransModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param overdue the overdue
	* @param start the lower bound of the range of circulation transes
	* @param end the upper bound of the range of circulation transes (not inclusive)
	* @return the range of matching circulation transes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CirculationTrans> findByOverdueLibrary(
		long companyId, long libraryId, boolean overdue, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the circulation transes where companyId = &#63; and libraryId = &#63; and overdue = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationTransModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param overdue the overdue
	* @param start the lower bound of the range of circulation transes
	* @param end the upper bound of the range of circulation transes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching circulation transes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CirculationTrans> findByOverdueLibrary(
		long companyId, long libraryId, boolean overdue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first circulation trans in the ordered set where companyId = &#63; and libraryId = &#63; and overdue = &#63;.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param overdue the overdue
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching circulation trans
	* @throws com.kencana.lms.NoSuchCirculationTransException if a matching circulation trans could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationTrans findByOverdueLibrary_First(
		long companyId, long libraryId, boolean overdue,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationTransException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first circulation trans in the ordered set where companyId = &#63; and libraryId = &#63; and overdue = &#63;.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param overdue the overdue
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching circulation trans, or <code>null</code> if a matching circulation trans could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationTrans fetchByOverdueLibrary_First(
		long companyId, long libraryId, boolean overdue,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last circulation trans in the ordered set where companyId = &#63; and libraryId = &#63; and overdue = &#63;.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param overdue the overdue
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching circulation trans
	* @throws com.kencana.lms.NoSuchCirculationTransException if a matching circulation trans could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationTrans findByOverdueLibrary_Last(
		long companyId, long libraryId, boolean overdue,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationTransException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last circulation trans in the ordered set where companyId = &#63; and libraryId = &#63; and overdue = &#63;.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param overdue the overdue
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching circulation trans, or <code>null</code> if a matching circulation trans could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationTrans fetchByOverdueLibrary_Last(
		long companyId, long libraryId, boolean overdue,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the circulation transes before and after the current circulation trans in the ordered set where companyId = &#63; and libraryId = &#63; and overdue = &#63;.
	*
	* @param transId the primary key of the current circulation trans
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param overdue the overdue
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next circulation trans
	* @throws com.kencana.lms.NoSuchCirculationTransException if a circulation trans with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationTrans[] findByOverdueLibrary_PrevAndNext(
		long transId, long companyId, long libraryId, boolean overdue,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchCirculationTransException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the circulation transes where companyId = &#63; and libraryId = &#63; and overdue = &#63; from the database.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param overdue the overdue
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOverdueLibrary(long companyId, long libraryId,
		boolean overdue)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of circulation transes where companyId = &#63; and libraryId = &#63; and overdue = &#63;.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param overdue the overdue
	* @return the number of matching circulation transes
	* @throws SystemException if a system exception occurred
	*/
	public int countByOverdueLibrary(long companyId, long libraryId,
		boolean overdue)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the circulation trans in the entity cache if it is enabled.
	*
	* @param circulationTrans the circulation trans
	*/
	public void cacheResult(
		com.kencana.lms.model.CirculationTrans circulationTrans);

	/**
	* Caches the circulation transes in the entity cache if it is enabled.
	*
	* @param circulationTranses the circulation transes
	*/
	public void cacheResult(
		java.util.List<com.kencana.lms.model.CirculationTrans> circulationTranses);

	/**
	* Creates a new circulation trans with the primary key. Does not add the circulation trans to the database.
	*
	* @param transId the primary key for the new circulation trans
	* @return the new circulation trans
	*/
	public com.kencana.lms.model.CirculationTrans create(long transId);

	/**
	* Removes the circulation trans with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param transId the primary key of the circulation trans
	* @return the circulation trans that was removed
	* @throws com.kencana.lms.NoSuchCirculationTransException if a circulation trans with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationTrans remove(long transId)
		throws com.kencana.lms.NoSuchCirculationTransException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.kencana.lms.model.CirculationTrans updateImpl(
		com.kencana.lms.model.CirculationTrans circulationTrans)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the circulation trans with the primary key or throws a {@link com.kencana.lms.NoSuchCirculationTransException} if it could not be found.
	*
	* @param transId the primary key of the circulation trans
	* @return the circulation trans
	* @throws com.kencana.lms.NoSuchCirculationTransException if a circulation trans with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationTrans findByPrimaryKey(long transId)
		throws com.kencana.lms.NoSuchCirculationTransException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the circulation trans with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param transId the primary key of the circulation trans
	* @return the circulation trans, or <code>null</code> if a circulation trans with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.CirculationTrans fetchByPrimaryKey(
		long transId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the circulation transes.
	*
	* @return the circulation transes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CirculationTrans> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the circulation transes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationTransModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of circulation transes
	* @param end the upper bound of the range of circulation transes (not inclusive)
	* @return the range of circulation transes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CirculationTrans> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the circulation transes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationTransModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of circulation transes
	* @param end the upper bound of the range of circulation transes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of circulation transes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.CirculationTrans> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the circulation transes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of circulation transes.
	*
	* @return the number of circulation transes
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}