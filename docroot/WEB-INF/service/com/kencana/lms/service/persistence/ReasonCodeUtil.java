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

import com.kencana.lms.model.ReasonCode;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the reason code service. This utility wraps {@link ReasonCodePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ReasonCodePersistence
 * @see ReasonCodePersistenceImpl
 * @generated
 */
public class ReasonCodeUtil {
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
	public static void clearCache(ReasonCode reasonCode) {
		getPersistence().clearCache(reasonCode);
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
	public static List<ReasonCode> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ReasonCode> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ReasonCode> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ReasonCode update(ReasonCode reasonCode)
		throws SystemException {
		return getPersistence().update(reasonCode);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ReasonCode update(ReasonCode reasonCode,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(reasonCode, serviceContext);
	}

	/**
	* Returns all the reason codes where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching reason codes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.ReasonCode> findByGroupCompany(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupCompany(companyId, groupId);
	}

	/**
	* Returns a range of all the reason codes where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.ReasonCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of reason codes
	* @param end the upper bound of the range of reason codes (not inclusive)
	* @return the range of matching reason codes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.ReasonCode> findByGroupCompany(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCompany(companyId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the reason codes where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.ReasonCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of reason codes
	* @param end the upper bound of the range of reason codes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching reason codes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.ReasonCode> findByGroupCompany(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCompany(companyId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first reason code in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching reason code
	* @throws com.kencana.lms.NoSuchReasonCodeException if a matching reason code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.ReasonCode findByGroupCompany_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchReasonCodeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCompany_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first reason code in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching reason code, or <code>null</code> if a matching reason code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.ReasonCode fetchByGroupCompany_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupCompany_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last reason code in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching reason code
	* @throws com.kencana.lms.NoSuchReasonCodeException if a matching reason code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.ReasonCode findByGroupCompany_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchReasonCodeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCompany_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last reason code in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching reason code, or <code>null</code> if a matching reason code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.ReasonCode fetchByGroupCompany_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupCompany_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the reason codes before and after the current reason code in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param reasonCodeId the primary key of the current reason code
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next reason code
	* @throws com.kencana.lms.NoSuchReasonCodeException if a reason code with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.ReasonCode[] findByGroupCompany_PrevAndNext(
		long reasonCodeId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchReasonCodeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCompany_PrevAndNext(reasonCodeId, companyId,
			groupId, orderByComparator);
	}

	/**
	* Removes all the reason codes where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupCompany(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupCompany(companyId, groupId);
	}

	/**
	* Returns the number of reason codes where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching reason codes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupCompany(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupCompany(companyId, groupId);
	}

	/**
	* Returns all the reason codes where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching reason codes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.ReasonCode> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

	/**
	* Returns a range of all the reason codes where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.ReasonCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of reason codes
	* @param end the upper bound of the range of reason codes (not inclusive)
	* @return the range of matching reason codes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.ReasonCode> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the reason codes where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.ReasonCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of reason codes
	* @param end the upper bound of the range of reason codes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching reason codes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.ReasonCode> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first reason code in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching reason code
	* @throws com.kencana.lms.NoSuchReasonCodeException if a matching reason code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.ReasonCode findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchReasonCodeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first reason code in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching reason code, or <code>null</code> if a matching reason code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.ReasonCode fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last reason code in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching reason code
	* @throws com.kencana.lms.NoSuchReasonCodeException if a matching reason code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.ReasonCode findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchReasonCodeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last reason code in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching reason code, or <code>null</code> if a matching reason code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.ReasonCode fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the reason codes before and after the current reason code in the ordered set where groupId = &#63;.
	*
	* @param reasonCodeId the primary key of the current reason code
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next reason code
	* @throws com.kencana.lms.NoSuchReasonCodeException if a reason code with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.ReasonCode[] findByGroup_PrevAndNext(
		long reasonCodeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchReasonCodeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup_PrevAndNext(reasonCodeId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the reason codes where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Returns the number of reason codes where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching reason codes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Caches the reason code in the entity cache if it is enabled.
	*
	* @param reasonCode the reason code
	*/
	public static void cacheResult(com.kencana.lms.model.ReasonCode reasonCode) {
		getPersistence().cacheResult(reasonCode);
	}

	/**
	* Caches the reason codes in the entity cache if it is enabled.
	*
	* @param reasonCodes the reason codes
	*/
	public static void cacheResult(
		java.util.List<com.kencana.lms.model.ReasonCode> reasonCodes) {
		getPersistence().cacheResult(reasonCodes);
	}

	/**
	* Creates a new reason code with the primary key. Does not add the reason code to the database.
	*
	* @param reasonCodeId the primary key for the new reason code
	* @return the new reason code
	*/
	public static com.kencana.lms.model.ReasonCode create(long reasonCodeId) {
		return getPersistence().create(reasonCodeId);
	}

	/**
	* Removes the reason code with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param reasonCodeId the primary key of the reason code
	* @return the reason code that was removed
	* @throws com.kencana.lms.NoSuchReasonCodeException if a reason code with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.ReasonCode remove(long reasonCodeId)
		throws com.kencana.lms.NoSuchReasonCodeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(reasonCodeId);
	}

	public static com.kencana.lms.model.ReasonCode updateImpl(
		com.kencana.lms.model.ReasonCode reasonCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(reasonCode);
	}

	/**
	* Returns the reason code with the primary key or throws a {@link com.kencana.lms.NoSuchReasonCodeException} if it could not be found.
	*
	* @param reasonCodeId the primary key of the reason code
	* @return the reason code
	* @throws com.kencana.lms.NoSuchReasonCodeException if a reason code with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.ReasonCode findByPrimaryKey(
		long reasonCodeId)
		throws com.kencana.lms.NoSuchReasonCodeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(reasonCodeId);
	}

	/**
	* Returns the reason code with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param reasonCodeId the primary key of the reason code
	* @return the reason code, or <code>null</code> if a reason code with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kencana.lms.model.ReasonCode fetchByPrimaryKey(
		long reasonCodeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(reasonCodeId);
	}

	/**
	* Returns all the reason codes.
	*
	* @return the reason codes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.ReasonCode> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the reason codes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.ReasonCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of reason codes
	* @param end the upper bound of the range of reason codes (not inclusive)
	* @return the range of reason codes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.ReasonCode> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the reason codes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.ReasonCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of reason codes
	* @param end the upper bound of the range of reason codes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of reason codes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kencana.lms.model.ReasonCode> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the reason codes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of reason codes.
	*
	* @return the number of reason codes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ReasonCodePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ReasonCodePersistence)PortletBeanLocatorUtil.locate(com.kencana.lms.service.ClpSerializer.getServletContextName(),
					ReasonCodePersistence.class.getName());

			ReferenceRegistry.registerReference(ReasonCodeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ReasonCodePersistence persistence) {
	}

	private static ReasonCodePersistence _persistence;
}