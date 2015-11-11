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

import com.kencana.lms.model.Vendor;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the vendor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see VendorPersistenceImpl
 * @see VendorUtil
 * @generated
 */
public interface VendorPersistence extends BasePersistence<Vendor> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VendorUtil} to access the vendor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the vendors where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching vendors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.Vendor> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vendors where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @return the range of matching vendors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.Vendor> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vendors where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vendors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.Vendor> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vendor in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor
	* @throws com.kencana.lms.NoSuchVendorException if a matching vendor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Vendor findByCompany_First(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchVendorException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vendor in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor, or <code>null</code> if a matching vendor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Vendor fetchByCompany_First(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last vendor in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor
	* @throws com.kencana.lms.NoSuchVendorException if a matching vendor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Vendor findByCompany_Last(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchVendorException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last vendor in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor, or <code>null</code> if a matching vendor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Vendor fetchByCompany_Last(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vendors before and after the current vendor in the ordered set where companyId = &#63;.
	*
	* @param vendorId the primary key of the current vendor
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vendor
	* @throws com.kencana.lms.NoSuchVendorException if a vendor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Vendor[] findByCompany_PrevAndNext(
		long vendorId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchVendorException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vendors where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vendors where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching vendors
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the vendors where companyId = &#63; and vendorName LIKE &#63;.
	*
	* @param companyId the company ID
	* @param vendorName the vendor name
	* @return the matching vendors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.Vendor> findByC_VendorName(
		long companyId, java.lang.String vendorName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vendors where companyId = &#63; and vendorName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param vendorName the vendor name
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @return the range of matching vendors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.Vendor> findByC_VendorName(
		long companyId, java.lang.String vendorName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vendors where companyId = &#63; and vendorName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param vendorName the vendor name
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vendors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.Vendor> findByC_VendorName(
		long companyId, java.lang.String vendorName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vendor in the ordered set where companyId = &#63; and vendorName LIKE &#63;.
	*
	* @param companyId the company ID
	* @param vendorName the vendor name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor
	* @throws com.kencana.lms.NoSuchVendorException if a matching vendor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Vendor findByC_VendorName_First(
		long companyId, java.lang.String vendorName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchVendorException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vendor in the ordered set where companyId = &#63; and vendorName LIKE &#63;.
	*
	* @param companyId the company ID
	* @param vendorName the vendor name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor, or <code>null</code> if a matching vendor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Vendor fetchByC_VendorName_First(
		long companyId, java.lang.String vendorName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last vendor in the ordered set where companyId = &#63; and vendorName LIKE &#63;.
	*
	* @param companyId the company ID
	* @param vendorName the vendor name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor
	* @throws com.kencana.lms.NoSuchVendorException if a matching vendor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Vendor findByC_VendorName_Last(
		long companyId, java.lang.String vendorName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchVendorException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last vendor in the ordered set where companyId = &#63; and vendorName LIKE &#63;.
	*
	* @param companyId the company ID
	* @param vendorName the vendor name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor, or <code>null</code> if a matching vendor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Vendor fetchByC_VendorName_Last(
		long companyId, java.lang.String vendorName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vendors before and after the current vendor in the ordered set where companyId = &#63; and vendorName LIKE &#63;.
	*
	* @param vendorId the primary key of the current vendor
	* @param companyId the company ID
	* @param vendorName the vendor name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vendor
	* @throws com.kencana.lms.NoSuchVendorException if a vendor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Vendor[] findByC_VendorName_PrevAndNext(
		long vendorId, long companyId, java.lang.String vendorName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kencana.lms.NoSuchVendorException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vendors where companyId = &#63; and vendorName LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param vendorName the vendor name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_VendorName(long companyId, java.lang.String vendorName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vendors where companyId = &#63; and vendorName LIKE &#63;.
	*
	* @param companyId the company ID
	* @param vendorName the vendor name
	* @return the number of matching vendors
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_VendorName(long companyId, java.lang.String vendorName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the vendor in the entity cache if it is enabled.
	*
	* @param vendor the vendor
	*/
	public void cacheResult(com.kencana.lms.model.Vendor vendor);

	/**
	* Caches the vendors in the entity cache if it is enabled.
	*
	* @param vendors the vendors
	*/
	public void cacheResult(
		java.util.List<com.kencana.lms.model.Vendor> vendors);

	/**
	* Creates a new vendor with the primary key. Does not add the vendor to the database.
	*
	* @param vendorId the primary key for the new vendor
	* @return the new vendor
	*/
	public com.kencana.lms.model.Vendor create(long vendorId);

	/**
	* Removes the vendor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vendorId the primary key of the vendor
	* @return the vendor that was removed
	* @throws com.kencana.lms.NoSuchVendorException if a vendor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Vendor remove(long vendorId)
		throws com.kencana.lms.NoSuchVendorException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.kencana.lms.model.Vendor updateImpl(
		com.kencana.lms.model.Vendor vendor)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vendor with the primary key or throws a {@link com.kencana.lms.NoSuchVendorException} if it could not be found.
	*
	* @param vendorId the primary key of the vendor
	* @return the vendor
	* @throws com.kencana.lms.NoSuchVendorException if a vendor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Vendor findByPrimaryKey(long vendorId)
		throws com.kencana.lms.NoSuchVendorException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vendor with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param vendorId the primary key of the vendor
	* @return the vendor, or <code>null</code> if a vendor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kencana.lms.model.Vendor fetchByPrimaryKey(long vendorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the vendors.
	*
	* @return the vendors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.Vendor> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vendors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @return the range of vendors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.Vendor> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vendors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of vendors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kencana.lms.model.Vendor> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vendors from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vendors.
	*
	* @return the number of vendors
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}