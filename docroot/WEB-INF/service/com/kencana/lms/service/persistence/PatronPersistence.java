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

import com.kencana.lms.model.Patron;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the patron service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see PatronPersistenceImpl
 * @see PatronUtil
 * @generated
 */
public interface PatronPersistence extends BasePersistence<Patron> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PatronUtil} to access the patron persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the patron where userId = &#63; or throws a {@link com.kencana.lms.NoSuchPatronException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching patron
	* @throws com.kencana.lms.NoSuchPatronException if a matching patron could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Patron findByUserId(long userId)
		throws com.kencana.lms.NoSuchPatronException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patron where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching patron, or <code>null</code> if a matching patron could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Patron fetchByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patron where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching patron, or <code>null</code> if a matching patron could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Patron fetchByUserId(long userId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the patron where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @return the patron that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Patron removeByUserId(long userId)
		throws com.kencana.lms.NoSuchPatronException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of patrons where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching patrons
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the patrons where companyId = &#63; and libraryId = &#63;.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @return the matching patrons
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.Patron> findByLibraryId(
		long companyId, long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the patrons where companyId = &#63; and libraryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param start the lower bound of the range of patrons
	* @param end the upper bound of the range of patrons (not inclusive)
	* @return the range of matching patrons
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.Patron> findByLibraryId(
		long companyId, long libraryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the patrons where companyId = &#63; and libraryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param start the lower bound of the range of patrons
	* @param end the upper bound of the range of patrons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching patrons
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.Patron> findByLibraryId(
		long companyId, long libraryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patron in the ordered set where companyId = &#63; and libraryId = &#63;.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patron
	* @throws com.kencana.lms.NoSuchPatronException if a matching patron could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Patron findByLibraryId_First(long companyId,
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchPatronException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patron in the ordered set where companyId = &#63; and libraryId = &#63;.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patron, or <code>null</code> if a matching patron could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Patron fetchByLibraryId_First(long companyId,
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patron in the ordered set where companyId = &#63; and libraryId = &#63;.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patron
	* @throws com.kencana.lms.NoSuchPatronException if a matching patron could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Patron findByLibraryId_Last(long companyId,
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchPatronException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patron in the ordered set where companyId = &#63; and libraryId = &#63;.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patron, or <code>null</code> if a matching patron could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Patron fetchByLibraryId_Last(long companyId,
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patrons before and after the current patron in the ordered set where companyId = &#63; and libraryId = &#63;.
	*
	* @param patronId the primary key of the current patron
	* @param companyId the company ID
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next patron
	* @throws com.kencana.lms.NoSuchPatronException if a patron with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Patron[] findByLibraryId_PrevAndNext(
		long patronId, long companyId, long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchPatronException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the patrons where companyId = &#63; and libraryId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLibraryId(long companyId, long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of patrons where companyId = &#63; and libraryId = &#63;.
	*
	* @param companyId the company ID
	* @param libraryId the library ID
	* @return the number of matching patrons
	* @throws SystemException if a system exception occurred
	*/
	public int countByLibraryId(long companyId, long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patron where cardNumber = &#63; or throws a {@link com.kencana.lms.NoSuchPatronException} if it could not be found.
	*
	* @param cardNumber the card number
	* @return the matching patron
	* @throws com.kencana.lms.NoSuchPatronException if a matching patron could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Patron findByCardNumber(
		java.lang.String cardNumber)
		throws com.kencana.lms.NoSuchPatronException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patron where cardNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param cardNumber the card number
	* @return the matching patron, or <code>null</code> if a matching patron could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Patron fetchByCardNumber(
		java.lang.String cardNumber)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patron where cardNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param cardNumber the card number
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching patron, or <code>null</code> if a matching patron could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Patron fetchByCardNumber(
		java.lang.String cardNumber, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the patron where cardNumber = &#63; from the database.
	*
	* @param cardNumber the card number
	* @return the patron that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Patron removeByCardNumber(
		java.lang.String cardNumber)
		throws com.kencana.lms.NoSuchPatronException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of patrons where cardNumber = &#63;.
	*
	* @param cardNumber the card number
	* @return the number of matching patrons
	* @throws SystemException if a system exception occurred
	*/
	public int countByCardNumber(java.lang.String cardNumber)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the patrons where companyId = &#63; and groupId = &#63; and patronStatusId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param patronStatusId the patron status ID
	* @return the matching patrons
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.Patron> findByC_G_Status(
		long companyId, long groupId, long patronStatusId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the patrons where companyId = &#63; and groupId = &#63; and patronStatusId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param patronStatusId the patron status ID
	* @param start the lower bound of the range of patrons
	* @param end the upper bound of the range of patrons (not inclusive)
	* @return the range of matching patrons
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.Patron> findByC_G_Status(
		long companyId, long groupId, long patronStatusId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the patrons where companyId = &#63; and groupId = &#63; and patronStatusId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param patronStatusId the patron status ID
	* @param start the lower bound of the range of patrons
	* @param end the upper bound of the range of patrons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching patrons
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.Patron> findByC_G_Status(
		long companyId, long groupId, long patronStatusId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patron in the ordered set where companyId = &#63; and groupId = &#63; and patronStatusId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param patronStatusId the patron status ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patron
	* @throws com.kencana.lms.NoSuchPatronException if a matching patron could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Patron findByC_G_Status_First(long companyId,
		long groupId, long patronStatusId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchPatronException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patron in the ordered set where companyId = &#63; and groupId = &#63; and patronStatusId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param patronStatusId the patron status ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patron, or <code>null</code> if a matching patron could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Patron fetchByC_G_Status_First(
		long companyId, long groupId, long patronStatusId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patron in the ordered set where companyId = &#63; and groupId = &#63; and patronStatusId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param patronStatusId the patron status ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patron
	* @throws com.kencana.lms.NoSuchPatronException if a matching patron could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Patron findByC_G_Status_Last(long companyId,
		long groupId, long patronStatusId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchPatronException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patron in the ordered set where companyId = &#63; and groupId = &#63; and patronStatusId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param patronStatusId the patron status ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patron, or <code>null</code> if a matching patron could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Patron fetchByC_G_Status_Last(long companyId,
		long groupId, long patronStatusId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patrons before and after the current patron in the ordered set where companyId = &#63; and groupId = &#63; and patronStatusId = &#63;.
	*
	* @param patronId the primary key of the current patron
	* @param companyId the company ID
	* @param groupId the group ID
	* @param patronStatusId the patron status ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next patron
	* @throws com.kencana.lms.NoSuchPatronException if a patron with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Patron[] findByC_G_Status_PrevAndNext(
		long patronId, long companyId, long groupId, long patronStatusId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchPatronException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the patrons where companyId = &#63; and groupId = &#63; and patronStatusId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param patronStatusId the patron status ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_G_Status(long companyId, long groupId,
		long patronStatusId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of patrons where companyId = &#63; and groupId = &#63; and patronStatusId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param patronStatusId the patron status ID
	* @return the number of matching patrons
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G_Status(long companyId, long groupId,
		long patronStatusId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the patrons where companyId = &#63; and groupId = &#63; and patronCategoryId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param patronCategoryId the patron category ID
	* @return the matching patrons
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.Patron> findByC_G_Category(
		long companyId, long groupId, long patronCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the patrons where companyId = &#63; and groupId = &#63; and patronCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param patronCategoryId the patron category ID
	* @param start the lower bound of the range of patrons
	* @param end the upper bound of the range of patrons (not inclusive)
	* @return the range of matching patrons
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.Patron> findByC_G_Category(
		long companyId, long groupId, long patronCategoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the patrons where companyId = &#63; and groupId = &#63; and patronCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param patronCategoryId the patron category ID
	* @param start the lower bound of the range of patrons
	* @param end the upper bound of the range of patrons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching patrons
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.Patron> findByC_G_Category(
		long companyId, long groupId, long patronCategoryId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patron in the ordered set where companyId = &#63; and groupId = &#63; and patronCategoryId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param patronCategoryId the patron category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patron
	* @throws com.kencana.lms.NoSuchPatronException if a matching patron could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Patron findByC_G_Category_First(
		long companyId, long groupId, long patronCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchPatronException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patron in the ordered set where companyId = &#63; and groupId = &#63; and patronCategoryId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param patronCategoryId the patron category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patron, or <code>null</code> if a matching patron could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Patron fetchByC_G_Category_First(
		long companyId, long groupId, long patronCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patron in the ordered set where companyId = &#63; and groupId = &#63; and patronCategoryId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param patronCategoryId the patron category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patron
	* @throws com.kencana.lms.NoSuchPatronException if a matching patron could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Patron findByC_G_Category_Last(
		long companyId, long groupId, long patronCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchPatronException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patron in the ordered set where companyId = &#63; and groupId = &#63; and patronCategoryId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param patronCategoryId the patron category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patron, or <code>null</code> if a matching patron could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Patron fetchByC_G_Category_Last(
		long companyId, long groupId, long patronCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patrons before and after the current patron in the ordered set where companyId = &#63; and groupId = &#63; and patronCategoryId = &#63;.
	*
	* @param patronId the primary key of the current patron
	* @param companyId the company ID
	* @param groupId the group ID
	* @param patronCategoryId the patron category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next patron
	* @throws com.kencana.lms.NoSuchPatronException if a patron with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Patron[] findByC_G_Category_PrevAndNext(
		long patronId, long companyId, long groupId, long patronCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchPatronException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the patrons where companyId = &#63; and groupId = &#63; and patronCategoryId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param patronCategoryId the patron category ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_G_Category(long companyId, long groupId,
		long patronCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of patrons where companyId = &#63; and groupId = &#63; and patronCategoryId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param patronCategoryId the patron category ID
	* @return the number of matching patrons
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G_Category(long companyId, long groupId,
		long patronCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the patron in the entity cache if it is enabled.
	*
	* @param patron the patron
	*/
	public void cacheResult(com.kencana.lms.model.Patron patron);

	/**
	* Caches the patrons in the entity cache if it is enabled.
	*
	* @param patrons the patrons
	*/
	public void cacheResult(
		java.util.List<com.kencana.lms.model.Patron> patrons);

	/**
	* Creates a new patron with the primary key. Does not add the patron to the database.
	*
	* @param patronId the primary key for the new patron
	* @return the new patron
	*/
	public com.kencana.lms.model.Patron create(long patronId);

	/**
	* Removes the patron with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param patronId the primary key of the patron
	* @return the patron that was removed
	* @throws com.kencana.lms.NoSuchPatronException if a patron with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Patron remove(long patronId)
		throws com.kencana.lms.NoSuchPatronException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.kencana.lms.model.Patron updateImpl(
		com.kencana.lms.model.Patron patron)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patron with the primary key or throws a {@link com.kencana.lms.NoSuchPatronException} if it could not be found.
	*
	* @param patronId the primary key of the patron
	* @return the patron
	* @throws com.kencana.lms.NoSuchPatronException if a patron with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Patron findByPrimaryKey(long patronId)
		throws com.kencana.lms.NoSuchPatronException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patron with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param patronId the primary key of the patron
	* @return the patron, or <code>null</code> if a patron with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Patron fetchByPrimaryKey(long patronId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the patrons.
	*
	* @return the patrons
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.Patron> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.Patron> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the patrons.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of patrons
	* @param end the upper bound of the range of patrons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of patrons
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.Patron> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the patrons from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of patrons.
	*
	* @return the number of patrons
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}