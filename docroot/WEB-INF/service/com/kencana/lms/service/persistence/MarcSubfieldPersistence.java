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

import com.kencana.lms.model.MarcSubfield;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the marc subfield service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see MarcSubfieldPersistenceImpl
 * @see MarcSubfieldUtil
 * @generated
 */
public interface MarcSubfieldPersistence extends BasePersistence<MarcSubfield> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MarcSubfieldUtil} to access the marc subfield persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the marc subfield where tag = &#63; and tagType = &#63; and subfield = &#63; or throws a {@link com.kencana.lms.NoSuchMarcSubfieldException} if it could not be found.
	*
	* @param tag the tag
	* @param tagType the tag type
	* @param subfield the subfield
	* @return the matching marc subfield
	* @throws com.kencana.lms.NoSuchMarcSubfieldException if a matching marc subfield could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.MarcSubfield findBySubfield(
		java.lang.String tag, java.lang.String tagType,
		java.lang.String subfield)
		throws com.kencana.lms.NoSuchMarcSubfieldException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the marc subfield where tag = &#63; and tagType = &#63; and subfield = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param tag the tag
	* @param tagType the tag type
	* @param subfield the subfield
	* @return the matching marc subfield, or <code>null</code> if a matching marc subfield could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.MarcSubfield fetchBySubfield(
		java.lang.String tag, java.lang.String tagType,
		java.lang.String subfield)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the marc subfield where tag = &#63; and tagType = &#63; and subfield = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param tag the tag
	* @param tagType the tag type
	* @param subfield the subfield
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching marc subfield, or <code>null</code> if a matching marc subfield could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.MarcSubfield fetchBySubfield(
		java.lang.String tag, java.lang.String tagType,
		java.lang.String subfield, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the marc subfield where tag = &#63; and tagType = &#63; and subfield = &#63; from the database.
	*
	* @param tag the tag
	* @param tagType the tag type
	* @param subfield the subfield
	* @return the marc subfield that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.MarcSubfield removeBySubfield(
		java.lang.String tag, java.lang.String tagType,
		java.lang.String subfield)
		throws com.kencana.lms.NoSuchMarcSubfieldException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of marc subfields where tag = &#63; and tagType = &#63; and subfield = &#63;.
	*
	* @param tag the tag
	* @param tagType the tag type
	* @param subfield the subfield
	* @return the number of matching marc subfields
	* @throws SystemException if a system exception occurred
	*/
	public int countBySubfield(java.lang.String tag, java.lang.String tagType,
		java.lang.String subfield)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the marc subfield in the entity cache if it is enabled.
	*
	* @param marcSubfield the marc subfield
	*/
	public void cacheResult(com.kencana.lms.model.MarcSubfield marcSubfield);

	/**
	* Caches the marc subfields in the entity cache if it is enabled.
	*
	* @param marcSubfields the marc subfields
	*/
	public void cacheResult(
		java.util.List<com.kencana.lms.model.MarcSubfield> marcSubfields);

	/**
	* Creates a new marc subfield with the primary key. Does not add the marc subfield to the database.
	*
	* @param MarcSubfieldId the primary key for the new marc subfield
	* @return the new marc subfield
	*/
	public com.kencana.lms.model.MarcSubfield create(long MarcSubfieldId);

	/**
	* Removes the marc subfield with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param MarcSubfieldId the primary key of the marc subfield
	* @return the marc subfield that was removed
	* @throws com.kencana.lms.NoSuchMarcSubfieldException if a marc subfield with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.MarcSubfield remove(long MarcSubfieldId)
		throws com.kencana.lms.NoSuchMarcSubfieldException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.kencana.lms.model.MarcSubfield updateImpl(
		com.kencana.lms.model.MarcSubfield marcSubfield)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the marc subfield with the primary key or throws a {@link com.kencana.lms.NoSuchMarcSubfieldException} if it could not be found.
	*
	* @param MarcSubfieldId the primary key of the marc subfield
	* @return the marc subfield
	* @throws com.kencana.lms.NoSuchMarcSubfieldException if a marc subfield with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.MarcSubfield findByPrimaryKey(
		long MarcSubfieldId)
		throws com.kencana.lms.NoSuchMarcSubfieldException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the marc subfield with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param MarcSubfieldId the primary key of the marc subfield
	* @return the marc subfield, or <code>null</code> if a marc subfield with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.MarcSubfield fetchByPrimaryKey(
		long MarcSubfieldId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the marc subfields.
	*
	* @return the marc subfields
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.MarcSubfield> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.MarcSubfield> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the marc subfields.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcSubfieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marc subfields
	* @param end the upper bound of the range of marc subfields (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of marc subfields
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.MarcSubfield> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the marc subfields from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of marc subfields.
	*
	* @return the number of marc subfields
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}