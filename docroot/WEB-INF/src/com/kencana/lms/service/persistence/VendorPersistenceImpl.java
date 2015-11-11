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

import com.kencana.lms.NoSuchVendorException;
import com.kencana.lms.model.Vendor;
import com.kencana.lms.model.impl.VendorImpl;
import com.kencana.lms.model.impl.VendorModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the vendor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see VendorPersistence
 * @see VendorUtil
 * @generated
 */
public class VendorPersistenceImpl extends BasePersistenceImpl<Vendor>
	implements VendorPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VendorUtil} to access the vendor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VendorImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, VendorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, VendorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, VendorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, VendorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			VendorModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the vendors where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching vendors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Vendor> findByCompany(long companyId) throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	@Override
	public List<Vendor> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

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
	@Override
	public List<Vendor> findByCompany(long companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<Vendor> list = (List<Vendor>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Vendor vendor : list) {
				if ((companyId != vendor.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VENDOR_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VendorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Vendor>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Vendor>(list);
				}
				else {
					list = (List<Vendor>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first vendor in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vendor
	 * @throws com.kencana.lms.NoSuchVendorException if a matching vendor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Vendor findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchVendorException, SystemException {
		Vendor vendor = fetchByCompany_First(companyId, orderByComparator);

		if (vendor != null) {
			return vendor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVendorException(msg.toString());
	}

	/**
	 * Returns the first vendor in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vendor, or <code>null</code> if a matching vendor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Vendor fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Vendor> list = findByCompany(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vendor in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vendor
	 * @throws com.kencana.lms.NoSuchVendorException if a matching vendor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Vendor findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchVendorException, SystemException {
		Vendor vendor = fetchByCompany_Last(companyId, orderByComparator);

		if (vendor != null) {
			return vendor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVendorException(msg.toString());
	}

	/**
	 * Returns the last vendor in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vendor, or <code>null</code> if a matching vendor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Vendor fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		if (count == 0) {
			return null;
		}

		List<Vendor> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Vendor[] findByCompany_PrevAndNext(long vendorId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchVendorException, SystemException {
		Vendor vendor = findByPrimaryKey(vendorId);

		Session session = null;

		try {
			session = openSession();

			Vendor[] array = new VendorImpl[3];

			array[0] = getByCompany_PrevAndNext(session, vendor, companyId,
					orderByComparator, true);

			array[1] = vendor;

			array[2] = getByCompany_PrevAndNext(session, vendor, companyId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Vendor getByCompany_PrevAndNext(Session session, Vendor vendor,
		long companyId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VENDOR_WHERE);

		query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(VendorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vendor);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Vendor> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vendors where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompany(long companyId) throws SystemException {
		for (Vendor vendor : findByCompany(companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(vendor);
		}
	}

	/**
	 * Returns the number of vendors where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching vendors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompany(long companyId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANY;

		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VENDOR_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "vendor.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_VENDORNAME =
		new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, VendorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_VendorName",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_VENDORNAME =
		new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_VendorName",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the vendors where companyId = &#63; and vendorName LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param vendorName the vendor name
	 * @return the matching vendors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Vendor> findByC_VendorName(long companyId, String vendorName)
		throws SystemException {
		return findByC_VendorName(companyId, vendorName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Vendor> findByC_VendorName(long companyId, String vendorName,
		int start, int end) throws SystemException {
		return findByC_VendorName(companyId, vendorName, start, end, null);
	}

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
	@Override
	public List<Vendor> findByC_VendorName(long companyId, String vendorName,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_VENDORNAME;
		finderArgs = new Object[] {
				companyId, vendorName,
				
				start, end, orderByComparator
			};

		List<Vendor> list = (List<Vendor>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Vendor vendor : list) {
				if ((companyId != vendor.getCompanyId()) ||
						!StringUtil.wildcardMatches(vendor.getVendorName(),
							vendorName, CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true)) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_VENDOR_WHERE);

			query.append(_FINDER_COLUMN_C_VENDORNAME_COMPANYID_2);

			boolean bindVendorName = false;

			if (vendorName == null) {
				query.append(_FINDER_COLUMN_C_VENDORNAME_VENDORNAME_1);
			}
			else if (vendorName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_VENDORNAME_VENDORNAME_3);
			}
			else {
				bindVendorName = true;

				query.append(_FINDER_COLUMN_C_VENDORNAME_VENDORNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VendorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindVendorName) {
					qPos.add(vendorName);
				}

				if (!pagination) {
					list = (List<Vendor>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Vendor>(list);
				}
				else {
					list = (List<Vendor>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

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
	@Override
	public Vendor findByC_VendorName_First(long companyId, String vendorName,
		OrderByComparator orderByComparator)
		throws NoSuchVendorException, SystemException {
		Vendor vendor = fetchByC_VendorName_First(companyId, vendorName,
				orderByComparator);

		if (vendor != null) {
			return vendor;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", vendorName=");
		msg.append(vendorName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVendorException(msg.toString());
	}

	/**
	 * Returns the first vendor in the ordered set where companyId = &#63; and vendorName LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param vendorName the vendor name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vendor, or <code>null</code> if a matching vendor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Vendor fetchByC_VendorName_First(long companyId, String vendorName,
		OrderByComparator orderByComparator) throws SystemException {
		List<Vendor> list = findByC_VendorName(companyId, vendorName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Vendor findByC_VendorName_Last(long companyId, String vendorName,
		OrderByComparator orderByComparator)
		throws NoSuchVendorException, SystemException {
		Vendor vendor = fetchByC_VendorName_Last(companyId, vendorName,
				orderByComparator);

		if (vendor != null) {
			return vendor;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", vendorName=");
		msg.append(vendorName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVendorException(msg.toString());
	}

	/**
	 * Returns the last vendor in the ordered set where companyId = &#63; and vendorName LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param vendorName the vendor name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vendor, or <code>null</code> if a matching vendor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Vendor fetchByC_VendorName_Last(long companyId, String vendorName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_VendorName(companyId, vendorName);

		if (count == 0) {
			return null;
		}

		List<Vendor> list = findByC_VendorName(companyId, vendorName,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Vendor[] findByC_VendorName_PrevAndNext(long vendorId,
		long companyId, String vendorName, OrderByComparator orderByComparator)
		throws NoSuchVendorException, SystemException {
		Vendor vendor = findByPrimaryKey(vendorId);

		Session session = null;

		try {
			session = openSession();

			Vendor[] array = new VendorImpl[3];

			array[0] = getByC_VendorName_PrevAndNext(session, vendor,
					companyId, vendorName, orderByComparator, true);

			array[1] = vendor;

			array[2] = getByC_VendorName_PrevAndNext(session, vendor,
					companyId, vendorName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Vendor getByC_VendorName_PrevAndNext(Session session,
		Vendor vendor, long companyId, String vendorName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VENDOR_WHERE);

		query.append(_FINDER_COLUMN_C_VENDORNAME_COMPANYID_2);

		boolean bindVendorName = false;

		if (vendorName == null) {
			query.append(_FINDER_COLUMN_C_VENDORNAME_VENDORNAME_1);
		}
		else if (vendorName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_VENDORNAME_VENDORNAME_3);
		}
		else {
			bindVendorName = true;

			query.append(_FINDER_COLUMN_C_VENDORNAME_VENDORNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(VendorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (bindVendorName) {
			qPos.add(vendorName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vendor);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Vendor> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vendors where companyId = &#63; and vendorName LIKE &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param vendorName the vendor name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_VendorName(long companyId, String vendorName)
		throws SystemException {
		for (Vendor vendor : findByC_VendorName(companyId, vendorName,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(vendor);
		}
	}

	/**
	 * Returns the number of vendors where companyId = &#63; and vendorName LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param vendorName the vendor name
	 * @return the number of matching vendors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_VendorName(long companyId, String vendorName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_VENDORNAME;

		Object[] finderArgs = new Object[] { companyId, vendorName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VENDOR_WHERE);

			query.append(_FINDER_COLUMN_C_VENDORNAME_COMPANYID_2);

			boolean bindVendorName = false;

			if (vendorName == null) {
				query.append(_FINDER_COLUMN_C_VENDORNAME_VENDORNAME_1);
			}
			else if (vendorName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_VENDORNAME_VENDORNAME_3);
			}
			else {
				bindVendorName = true;

				query.append(_FINDER_COLUMN_C_VENDORNAME_VENDORNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindVendorName) {
					qPos.add(vendorName);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_VENDORNAME_COMPANYID_2 = "vendor.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_VENDORNAME_VENDORNAME_1 = "vendor.vendorName LIKE NULL";
	private static final String _FINDER_COLUMN_C_VENDORNAME_VENDORNAME_2 = "vendor.vendorName LIKE ?";
	private static final String _FINDER_COLUMN_C_VENDORNAME_VENDORNAME_3 = "(vendor.vendorName IS NULL OR vendor.vendorName LIKE '')";

	public VendorPersistenceImpl() {
		setModelClass(Vendor.class);
	}

	/**
	 * Caches the vendor in the entity cache if it is enabled.
	 *
	 * @param vendor the vendor
	 */
	@Override
	public void cacheResult(Vendor vendor) {
		EntityCacheUtil.putResult(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorImpl.class, vendor.getPrimaryKey(), vendor);

		vendor.resetOriginalValues();
	}

	/**
	 * Caches the vendors in the entity cache if it is enabled.
	 *
	 * @param vendors the vendors
	 */
	@Override
	public void cacheResult(List<Vendor> vendors) {
		for (Vendor vendor : vendors) {
			if (EntityCacheUtil.getResult(
						VendorModelImpl.ENTITY_CACHE_ENABLED, VendorImpl.class,
						vendor.getPrimaryKey()) == null) {
				cacheResult(vendor);
			}
			else {
				vendor.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vendors.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VendorImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VendorImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vendor.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Vendor vendor) {
		EntityCacheUtil.removeResult(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorImpl.class, vendor.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Vendor> vendors) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Vendor vendor : vendors) {
			EntityCacheUtil.removeResult(VendorModelImpl.ENTITY_CACHE_ENABLED,
				VendorImpl.class, vendor.getPrimaryKey());
		}
	}

	/**
	 * Creates a new vendor with the primary key. Does not add the vendor to the database.
	 *
	 * @param vendorId the primary key for the new vendor
	 * @return the new vendor
	 */
	@Override
	public Vendor create(long vendorId) {
		Vendor vendor = new VendorImpl();

		vendor.setNew(true);
		vendor.setPrimaryKey(vendorId);

		return vendor;
	}

	/**
	 * Removes the vendor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vendorId the primary key of the vendor
	 * @return the vendor that was removed
	 * @throws com.kencana.lms.NoSuchVendorException if a vendor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Vendor remove(long vendorId)
		throws NoSuchVendorException, SystemException {
		return remove((Serializable)vendorId);
	}

	/**
	 * Removes the vendor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vendor
	 * @return the vendor that was removed
	 * @throws com.kencana.lms.NoSuchVendorException if a vendor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Vendor remove(Serializable primaryKey)
		throws NoSuchVendorException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Vendor vendor = (Vendor)session.get(VendorImpl.class, primaryKey);

			if (vendor == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVendorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vendor);
		}
		catch (NoSuchVendorException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Vendor removeImpl(Vendor vendor) throws SystemException {
		vendor = toUnwrappedModel(vendor);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vendor)) {
				vendor = (Vendor)session.get(VendorImpl.class,
						vendor.getPrimaryKeyObj());
			}

			if (vendor != null) {
				session.delete(vendor);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (vendor != null) {
			clearCache(vendor);
		}

		return vendor;
	}

	@Override
	public Vendor updateImpl(com.kencana.lms.model.Vendor vendor)
		throws SystemException {
		vendor = toUnwrappedModel(vendor);

		boolean isNew = vendor.isNew();

		VendorModelImpl vendorModelImpl = (VendorModelImpl)vendor;

		Session session = null;

		try {
			session = openSession();

			if (vendor.isNew()) {
				session.save(vendor);

				vendor.setNew(false);
			}
			else {
				session.merge(vendor);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VendorModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vendorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vendorModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] { vendorModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}
		}

		EntityCacheUtil.putResult(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorImpl.class, vendor.getPrimaryKey(), vendor);

		return vendor;
	}

	protected Vendor toUnwrappedModel(Vendor vendor) {
		if (vendor instanceof VendorImpl) {
			return vendor;
		}

		VendorImpl vendorImpl = new VendorImpl();

		vendorImpl.setNew(vendor.isNew());
		vendorImpl.setPrimaryKey(vendor.getPrimaryKey());

		vendorImpl.setVendorId(vendor.getVendorId());
		vendorImpl.setVendorCode(vendor.getVendorCode());
		vendorImpl.setVendorName(vendor.getVendorName());
		vendorImpl.setEmail(vendor.getEmail());
		vendorImpl.setUrl(vendor.getUrl());
		vendorImpl.setCompanyId(vendor.getCompanyId());
		vendorImpl.setGroupId(vendor.getGroupId());
		vendorImpl.setAddress1(vendor.getAddress1());
		vendorImpl.setAddress2(vendor.getAddress2());
		vendorImpl.setAddress3(vendor.getAddress3());
		vendorImpl.setCity(vendor.getCity());
		vendorImpl.setZipcode(vendor.getZipcode());
		vendorImpl.setContactPerson(vendor.getContactPerson());
		vendorImpl.setPhone(vendor.getPhone());
		vendorImpl.setFax(vendor.getFax());
		vendorImpl.setIsPublisher(vendor.isIsPublisher());
		vendorImpl.setIsBinder(vendor.isIsBinder());
		vendorImpl.setIsActive(vendor.isIsActive());
		vendorImpl.setRating(vendor.getRating());
		vendorImpl.setBankName(vendor.getBankName());
		vendorImpl.setBankAccount(vendor.getBankAccount());
		vendorImpl.setLastOrderDate(vendor.getLastOrderDate());
		vendorImpl.setNote(vendor.getNote());

		return vendorImpl;
	}

	/**
	 * Returns the vendor with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the vendor
	 * @return the vendor
	 * @throws com.kencana.lms.NoSuchVendorException if a vendor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Vendor findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVendorException, SystemException {
		Vendor vendor = fetchByPrimaryKey(primaryKey);

		if (vendor == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVendorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return vendor;
	}

	/**
	 * Returns the vendor with the primary key or throws a {@link com.kencana.lms.NoSuchVendorException} if it could not be found.
	 *
	 * @param vendorId the primary key of the vendor
	 * @return the vendor
	 * @throws com.kencana.lms.NoSuchVendorException if a vendor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Vendor findByPrimaryKey(long vendorId)
		throws NoSuchVendorException, SystemException {
		return findByPrimaryKey((Serializable)vendorId);
	}

	/**
	 * Returns the vendor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vendor
	 * @return the vendor, or <code>null</code> if a vendor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Vendor fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Vendor vendor = (Vendor)EntityCacheUtil.getResult(VendorModelImpl.ENTITY_CACHE_ENABLED,
				VendorImpl.class, primaryKey);

		if (vendor == _nullVendor) {
			return null;
		}

		if (vendor == null) {
			Session session = null;

			try {
				session = openSession();

				vendor = (Vendor)session.get(VendorImpl.class, primaryKey);

				if (vendor != null) {
					cacheResult(vendor);
				}
				else {
					EntityCacheUtil.putResult(VendorModelImpl.ENTITY_CACHE_ENABLED,
						VendorImpl.class, primaryKey, _nullVendor);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VendorModelImpl.ENTITY_CACHE_ENABLED,
					VendorImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return vendor;
	}

	/**
	 * Returns the vendor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param vendorId the primary key of the vendor
	 * @return the vendor, or <code>null</code> if a vendor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Vendor fetchByPrimaryKey(long vendorId) throws SystemException {
		return fetchByPrimaryKey((Serializable)vendorId);
	}

	/**
	 * Returns all the vendors.
	 *
	 * @return the vendors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Vendor> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Vendor> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Vendor> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Vendor> list = (List<Vendor>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VENDOR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VENDOR;

				if (pagination) {
					sql = sql.concat(VendorModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Vendor>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Vendor>(list);
				}
				else {
					list = (List<Vendor>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the vendors from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Vendor vendor : findAll()) {
			remove(vendor);
		}
	}

	/**
	 * Returns the number of vendors.
	 *
	 * @return the number of vendors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VENDOR);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the vendor persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.kencana.lms.model.Vendor")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Vendor>> listenersList = new ArrayList<ModelListener<Vendor>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Vendor>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(VendorImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VENDOR = "SELECT vendor FROM Vendor vendor";
	private static final String _SQL_SELECT_VENDOR_WHERE = "SELECT vendor FROM Vendor vendor WHERE ";
	private static final String _SQL_COUNT_VENDOR = "SELECT COUNT(vendor) FROM Vendor vendor";
	private static final String _SQL_COUNT_VENDOR_WHERE = "SELECT COUNT(vendor) FROM Vendor vendor WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vendor.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Vendor exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Vendor exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VendorPersistenceImpl.class);
	private static Vendor _nullVendor = new VendorImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Vendor> toCacheModel() {
				return _nullVendorCacheModel;
			}
		};

	private static CacheModel<Vendor> _nullVendorCacheModel = new CacheModel<Vendor>() {
			@Override
			public Vendor toEntityModel() {
				return _nullVendor;
			}
		};
}