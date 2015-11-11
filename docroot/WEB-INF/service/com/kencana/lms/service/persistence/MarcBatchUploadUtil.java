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

import com.kencana.lms.model.MarcBatchUpload;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the marc batch upload service. This utility wraps {@link MarcBatchUploadPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see MarcBatchUploadPersistence
 * @see MarcBatchUploadPersistenceImpl
 * @generated
 */
public class MarcBatchUploadUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(MarcBatchUpload marcBatchUpload) {
		getPersistence().clearCache(marcBatchUpload);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MarcBatchUpload> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MarcBatchUpload> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MarcBatchUpload> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static MarcBatchUpload update(MarcBatchUpload marcBatchUpload)
		throws SystemException {
		return getPersistence().update(marcBatchUpload);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static MarcBatchUpload update(MarcBatchUpload marcBatchUpload,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(marcBatchUpload, serviceContext);
	}

	/**
	* Returns all the marc batch uploads where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching marc batch uploads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.MarcBatchUpload> findByCompanyGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyGroup(companyId, groupId);
	}

	/**
	* Returns a range of all the marc batch uploads where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcBatchUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of marc batch uploads
	* @param end the upper bound of the range of marc batch uploads (not inclusive)
	* @return the range of matching marc batch uploads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.MarcBatchUpload> findByCompanyGroup(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyGroup(companyId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the marc batch uploads where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcBatchUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of marc batch uploads
	* @param end the upper bound of the range of marc batch uploads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching marc batch uploads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.MarcBatchUpload> findByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyGroup(companyId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first marc batch upload in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marc batch upload
	* @throws com.kencana.lms.NoSuchMarcBatchUploadException if a matching marc batch upload could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.MarcBatchUpload findByCompanyGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchMarcBatchUploadException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyGroup_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first marc batch upload in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marc batch upload, or <code>null</code> if a matching marc batch upload could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.MarcBatchUpload fetchByCompanyGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyGroup_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last marc batch upload in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marc batch upload
	* @throws com.kencana.lms.NoSuchMarcBatchUploadException if a matching marc batch upload could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.MarcBatchUpload findByCompanyGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchMarcBatchUploadException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyGroup_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last marc batch upload in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marc batch upload, or <code>null</code> if a matching marc batch upload could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.MarcBatchUpload fetchByCompanyGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyGroup_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the marc batch uploads before and after the current marc batch upload in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param marcBatchUploadId the primary key of the current marc batch upload
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marc batch upload
	* @throws com.kencana.lms.NoSuchMarcBatchUploadException if a marc batch upload with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.MarcBatchUpload[] findByCompanyGroup_PrevAndNext(
		long marcBatchUploadId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchMarcBatchUploadException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyGroup_PrevAndNext(marcBatchUploadId,
			companyId, groupId, orderByComparator);
	}

	/**
	* Removes all the marc batch uploads where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyGroup(companyId, groupId);
	}

	/**
	* Returns the number of marc batch uploads where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching marc batch uploads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyGroup(companyId, groupId);
	}

	/**
	* Returns all the marc batch uploads where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching marc batch uploads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.MarcBatchUpload> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

	/**
	* Returns a range of all the marc batch uploads where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcBatchUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of marc batch uploads
	* @param end the upper bound of the range of marc batch uploads (not inclusive)
	* @return the range of matching marc batch uploads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.MarcBatchUpload> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the marc batch uploads where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcBatchUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of marc batch uploads
	* @param end the upper bound of the range of marc batch uploads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching marc batch uploads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.MarcBatchUpload> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first marc batch upload in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marc batch upload
	* @throws com.kencana.lms.NoSuchMarcBatchUploadException if a matching marc batch upload could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.MarcBatchUpload findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchMarcBatchUploadException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first marc batch upload in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marc batch upload, or <code>null</code> if a matching marc batch upload could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.MarcBatchUpload fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last marc batch upload in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marc batch upload
	* @throws com.kencana.lms.NoSuchMarcBatchUploadException if a matching marc batch upload could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.MarcBatchUpload findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchMarcBatchUploadException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last marc batch upload in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marc batch upload, or <code>null</code> if a matching marc batch upload could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.MarcBatchUpload fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the marc batch uploads before and after the current marc batch upload in the ordered set where groupId = &#63;.
	*
	* @param marcBatchUploadId the primary key of the current marc batch upload
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marc batch upload
	* @throws com.kencana.lms.NoSuchMarcBatchUploadException if a marc batch upload with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.MarcBatchUpload[] findByGroup_PrevAndNext(
		long marcBatchUploadId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchMarcBatchUploadException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup_PrevAndNext(marcBatchUploadId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the marc batch uploads where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Returns the number of marc batch uploads where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching marc batch uploads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns all the marc batch uploads where groupId = &#63; and companyId = &#63; and processed = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param processed the processed
	* @return the matching marc batch uploads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.MarcBatchUpload> findByStatus(
		long groupId, long companyId, boolean processed)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(groupId, companyId, processed);
	}

	/**
	* Returns a range of all the marc batch uploads where groupId = &#63; and companyId = &#63; and processed = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcBatchUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param processed the processed
	* @param start the lower bound of the range of marc batch uploads
	* @param end the upper bound of the range of marc batch uploads (not inclusive)
	* @return the range of matching marc batch uploads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.MarcBatchUpload> findByStatus(
		long groupId, long companyId, boolean processed, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus(groupId, companyId, processed, start, end);
	}

	/**
	* Returns an ordered range of all the marc batch uploads where groupId = &#63; and companyId = &#63; and processed = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcBatchUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param processed the processed
	* @param start the lower bound of the range of marc batch uploads
	* @param end the upper bound of the range of marc batch uploads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching marc batch uploads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.MarcBatchUpload> findByStatus(
		long groupId, long companyId, boolean processed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus(groupId, companyId, processed, start, end,
			orderByComparator);
	}

	/**
	* Returns the first marc batch upload in the ordered set where groupId = &#63; and companyId = &#63; and processed = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param processed the processed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marc batch upload
	* @throws com.kencana.lms.NoSuchMarcBatchUploadException if a matching marc batch upload could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.MarcBatchUpload findByStatus_First(
		long groupId, long companyId, boolean processed,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchMarcBatchUploadException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus_First(groupId, companyId, processed,
			orderByComparator);
	}

	/**
	* Returns the first marc batch upload in the ordered set where groupId = &#63; and companyId = &#63; and processed = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param processed the processed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marc batch upload, or <code>null</code> if a matching marc batch upload could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.MarcBatchUpload fetchByStatus_First(
		long groupId, long companyId, boolean processed,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatus_First(groupId, companyId, processed,
			orderByComparator);
	}

	/**
	* Returns the last marc batch upload in the ordered set where groupId = &#63; and companyId = &#63; and processed = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param processed the processed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marc batch upload
	* @throws com.kencana.lms.NoSuchMarcBatchUploadException if a matching marc batch upload could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.MarcBatchUpload findByStatus_Last(
		long groupId, long companyId, boolean processed,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchMarcBatchUploadException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus_Last(groupId, companyId, processed,
			orderByComparator);
	}

	/**
	* Returns the last marc batch upload in the ordered set where groupId = &#63; and companyId = &#63; and processed = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param processed the processed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marc batch upload, or <code>null</code> if a matching marc batch upload could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.MarcBatchUpload fetchByStatus_Last(
		long groupId, long companyId, boolean processed,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatus_Last(groupId, companyId, processed,
			orderByComparator);
	}

	/**
	* Returns the marc batch uploads before and after the current marc batch upload in the ordered set where groupId = &#63; and companyId = &#63; and processed = &#63;.
	*
	* @param marcBatchUploadId the primary key of the current marc batch upload
	* @param groupId the group ID
	* @param companyId the company ID
	* @param processed the processed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marc batch upload
	* @throws com.kencana.lms.NoSuchMarcBatchUploadException if a marc batch upload with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.MarcBatchUpload[] findByStatus_PrevAndNext(
		long marcBatchUploadId, long groupId, long companyId,
		boolean processed,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchMarcBatchUploadException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus_PrevAndNext(marcBatchUploadId, groupId,
			companyId, processed, orderByComparator);
	}

	/**
	* Removes all the marc batch uploads where groupId = &#63; and companyId = &#63; and processed = &#63; from the database.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param processed the processed
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatus(long groupId, long companyId,
		boolean processed)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatus(groupId, companyId, processed);
	}

	/**
	* Returns the number of marc batch uploads where groupId = &#63; and companyId = &#63; and processed = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param processed the processed
	* @return the number of matching marc batch uploads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatus(long groupId, long companyId,
		boolean processed)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatus(groupId, companyId, processed);
	}

	/**
	* Caches the marc batch upload in the entity cache if it is enabled.
	*
	* @param marcBatchUpload the marc batch upload
	*/
	public static void cacheResult(
		com.kencana.lms.model.MarcBatchUpload marcBatchUpload) {
		getPersistence().cacheResult(marcBatchUpload);
	}

	/**
	* Caches the marc batch uploads in the entity cache if it is enabled.
	*
	* @param marcBatchUploads the marc batch uploads
	*/
	public static void cacheResult(
		java.util.List<com.kencana.lms.model.MarcBatchUpload> marcBatchUploads) {
		getPersistence().cacheResult(marcBatchUploads);
	}

	/**
	* Creates a new marc batch upload with the primary key. Does not add the marc batch upload to the database.
	*
	* @param marcBatchUploadId the primary key for the new marc batch upload
	* @return the new marc batch upload
	*/
	public static com.kencana.lms.model.MarcBatchUpload create(
		long marcBatchUploadId) {
		return getPersistence().create(marcBatchUploadId);
	}

	/**
	* Removes the marc batch upload with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param marcBatchUploadId the primary key of the marc batch upload
	* @return the marc batch upload that was removed
	* @throws com.kencana.lms.NoSuchMarcBatchUploadException if a marc batch upload with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.MarcBatchUpload remove(
		long marcBatchUploadId)
		throws com.kencana.lms.NoSuchMarcBatchUploadException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(marcBatchUploadId);
	}

	public static com.kencana.lms.model.MarcBatchUpload updateImpl(
		com.kencana.lms.model.MarcBatchUpload marcBatchUpload)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(marcBatchUpload);
	}

	/**
	* Returns the marc batch upload with the primary key or throws a {@link com.kencana.lms.NoSuchMarcBatchUploadException} if it could not be found.
	*
	* @param marcBatchUploadId the primary key of the marc batch upload
	* @return the marc batch upload
	* @throws com.kencana.lms.NoSuchMarcBatchUploadException if a marc batch upload with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.MarcBatchUpload findByPrimaryKey(
		long marcBatchUploadId)
		throws com.kencana.lms.NoSuchMarcBatchUploadException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(marcBatchUploadId);
	}

	/**
	* Returns the marc batch upload with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param marcBatchUploadId the primary key of the marc batch upload
	* @return the marc batch upload, or <code>null</code> if a marc batch upload with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.MarcBatchUpload fetchByPrimaryKey(
		long marcBatchUploadId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(marcBatchUploadId);
	}

	/**
	* Returns all the marc batch uploads.
	*
	* @return the marc batch uploads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.MarcBatchUpload> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the marc batch uploads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcBatchUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marc batch uploads
	* @param end the upper bound of the range of marc batch uploads (not inclusive)
	* @return the range of marc batch uploads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.MarcBatchUpload> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the marc batch uploads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcBatchUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of marc batch uploads
	* @param end the upper bound of the range of marc batch uploads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of marc batch uploads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.MarcBatchUpload> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the marc batch uploads from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of marc batch uploads.
	*
	* @return the number of marc batch uploads
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MarcBatchUploadPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MarcBatchUploadPersistence)PortletBeanLocatorUtil.locate(com.kencana.lms.service.ClpSerializer.getServletContextName(),
					MarcBatchUploadPersistence.class.getName());

			ReferenceRegistry.registerReference(MarcBatchUploadUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(MarcBatchUploadPersistence persistence) {
	}

	private static MarcBatchUploadPersistence _persistence;
}