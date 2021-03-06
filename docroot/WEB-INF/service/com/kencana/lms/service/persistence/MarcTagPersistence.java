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

import com.kencana.lms.model.MarcTag;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the marc tag service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see MarcTagPersistenceImpl
 * @see MarcTagUtil
 * @generated
 */
public interface MarcTagPersistence extends BasePersistence<MarcTag> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MarcTagUtil} to access the marc tag persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the marc tag where tag = &#63; and tagType = &#63; or throws a {@link com.kencana.lms.NoSuchMarcTagException} if it could not be found.
	*
	* @param tag the tag
	* @param tagType the tag type
	* @return the matching marc tag
	* @throws com.kencana.lms.NoSuchMarcTagException if a matching marc tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.MarcTag findByTagTagType(
		java.lang.String tag, java.lang.String tagType)
		throws com.kencana.lms.NoSuchMarcTagException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the marc tag where tag = &#63; and tagType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param tag the tag
	* @param tagType the tag type
	* @return the matching marc tag, or <code>null</code> if a matching marc tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.MarcTag fetchByTagTagType(
		java.lang.String tag, java.lang.String tagType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the marc tag where tag = &#63; and tagType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param tag the tag
	* @param tagType the tag type
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching marc tag, or <code>null</code> if a matching marc tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.MarcTag fetchByTagTagType(
		java.lang.String tag, java.lang.String tagType,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the marc tag where tag = &#63; and tagType = &#63; from the database.
	*
	* @param tag the tag
	* @param tagType the tag type
	* @return the marc tag that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.MarcTag removeByTagTagType(
		java.lang.String tag, java.lang.String tagType)
		throws com.kencana.lms.NoSuchMarcTagException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of marc tags where tag = &#63; and tagType = &#63;.
	*
	* @param tag the tag
	* @param tagType the tag type
	* @return the number of matching marc tags
	* @throws SystemException if a system exception occurred
	*/
	public int countByTagTagType(java.lang.String tag, java.lang.String tagType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the marc tags where tagType = &#63;.
	*
	* @param tagType the tag type
	* @return the matching marc tags
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.MarcTag> findByTagType(
		java.lang.String tagType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the marc tags where tagType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tagType the tag type
	* @param start the lower bound of the range of marc tags
	* @param end the upper bound of the range of marc tags (not inclusive)
	* @return the range of matching marc tags
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.MarcTag> findByTagType(
		java.lang.String tagType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the marc tags where tagType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tagType the tag type
	* @param start the lower bound of the range of marc tags
	* @param end the upper bound of the range of marc tags (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching marc tags
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.MarcTag> findByTagType(
		java.lang.String tagType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first marc tag in the ordered set where tagType = &#63;.
	*
	* @param tagType the tag type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marc tag
	* @throws com.kencana.lms.NoSuchMarcTagException if a matching marc tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.MarcTag findByTagType_First(
		java.lang.String tagType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchMarcTagException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first marc tag in the ordered set where tagType = &#63;.
	*
	* @param tagType the tag type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marc tag, or <code>null</code> if a matching marc tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.MarcTag fetchByTagType_First(
		java.lang.String tagType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last marc tag in the ordered set where tagType = &#63;.
	*
	* @param tagType the tag type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marc tag
	* @throws com.kencana.lms.NoSuchMarcTagException if a matching marc tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.MarcTag findByTagType_Last(
		java.lang.String tagType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchMarcTagException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last marc tag in the ordered set where tagType = &#63;.
	*
	* @param tagType the tag type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marc tag, or <code>null</code> if a matching marc tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.MarcTag fetchByTagType_Last(
		java.lang.String tagType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the marc tags before and after the current marc tag in the ordered set where tagType = &#63;.
	*
	* @param tagId the primary key of the current marc tag
	* @param tagType the tag type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marc tag
	* @throws com.kencana.lms.NoSuchMarcTagException if a marc tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.MarcTag[] findByTagType_PrevAndNext(
		long tagId, java.lang.String tagType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchMarcTagException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the marc tags where tagType = &#63; from the database.
	*
	* @param tagType the tag type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTagType(java.lang.String tagType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of marc tags where tagType = &#63;.
	*
	* @param tagType the tag type
	* @return the number of matching marc tags
	* @throws SystemException if a system exception occurred
	*/
	public int countByTagType(java.lang.String tagType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the marc tag in the entity cache if it is enabled.
	*
	* @param marcTag the marc tag
	*/
	public void cacheResult(com.kencana.lms.model.MarcTag marcTag);

	/**
	* Caches the marc tags in the entity cache if it is enabled.
	*
	* @param marcTags the marc tags
	*/
	public void cacheResult(
		java.util.List<com.kencana.lms.model.MarcTag> marcTags);

	/**
	* Creates a new marc tag with the primary key. Does not add the marc tag to the database.
	*
	* @param tagId the primary key for the new marc tag
	* @return the new marc tag
	*/
	public com.kencana.lms.model.MarcTag create(long tagId);

	/**
	* Removes the marc tag with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tagId the primary key of the marc tag
	* @return the marc tag that was removed
	* @throws com.kencana.lms.NoSuchMarcTagException if a marc tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.MarcTag remove(long tagId)
		throws com.kencana.lms.NoSuchMarcTagException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.kencana.lms.model.MarcTag updateImpl(
		com.kencana.lms.model.MarcTag marcTag)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the marc tag with the primary key or throws a {@link com.kencana.lms.NoSuchMarcTagException} if it could not be found.
	*
	* @param tagId the primary key of the marc tag
	* @return the marc tag
	* @throws com.kencana.lms.NoSuchMarcTagException if a marc tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.MarcTag findByPrimaryKey(long tagId)
		throws com.kencana.lms.NoSuchMarcTagException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the marc tag with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tagId the primary key of the marc tag
	* @return the marc tag, or <code>null</code> if a marc tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.MarcTag fetchByPrimaryKey(long tagId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the marc tags.
	*
	* @return the marc tags
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.MarcTag> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kencana.lms.model.MarcTag> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the marc tags.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marc tags
	* @param end the upper bound of the range of marc tags (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of marc tags
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.MarcTag> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the marc tags from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of marc tags.
	*
	* @return the number of marc tags
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}