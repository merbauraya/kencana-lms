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

import com.kencana.lms.NoSuchReasonCodeException;
import com.kencana.lms.model.ReasonCode;
import com.kencana.lms.model.impl.ReasonCodeImpl;
import com.kencana.lms.model.impl.ReasonCodeModelImpl;

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
 * The persistence implementation for the reason code service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ReasonCodePersistence
 * @see ReasonCodeUtil
 * @generated
 */
public class ReasonCodePersistenceImpl extends BasePersistenceImpl<ReasonCode>
	implements ReasonCodePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ReasonCodeUtil} to access the reason code persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ReasonCodeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ReasonCodeModelImpl.ENTITY_CACHE_ENABLED,
			ReasonCodeModelImpl.FINDER_CACHE_ENABLED, ReasonCodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ReasonCodeModelImpl.ENTITY_CACHE_ENABLED,
			ReasonCodeModelImpl.FINDER_CACHE_ENABLED, ReasonCodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ReasonCodeModelImpl.ENTITY_CACHE_ENABLED,
			ReasonCodeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPCOMPANY =
		new FinderPath(ReasonCodeModelImpl.ENTITY_CACHE_ENABLED,
			ReasonCodeModelImpl.FINDER_CACHE_ENABLED, ReasonCodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCOMPANY =
		new FinderPath(ReasonCodeModelImpl.ENTITY_CACHE_ENABLED,
			ReasonCodeModelImpl.FINDER_CACHE_ENABLED, ReasonCodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupCompany",
			new String[] { Long.class.getName(), Long.class.getName() },
			ReasonCodeModelImpl.COMPANYID_COLUMN_BITMASK |
			ReasonCodeModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPCOMPANY = new FinderPath(ReasonCodeModelImpl.ENTITY_CACHE_ENABLED,
			ReasonCodeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupCompany",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the reason codes where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching reason codes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ReasonCode> findByGroupCompany(long companyId, long groupId)
		throws SystemException {
		return findByGroupCompany(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<ReasonCode> findByGroupCompany(long companyId, long groupId,
		int start, int end) throws SystemException {
		return findByGroupCompany(companyId, groupId, start, end, null);
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
	@Override
	public List<ReasonCode> findByGroupCompany(long companyId, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCOMPANY;
			finderArgs = new Object[] { companyId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPCOMPANY;
			finderArgs = new Object[] {
					companyId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<ReasonCode> list = (List<ReasonCode>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ReasonCode reasonCode : list) {
				if ((companyId != reasonCode.getCompanyId()) ||
						(groupId != reasonCode.getGroupId())) {
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

			query.append(_SQL_SELECT_REASONCODE_WHERE);

			query.append(_FINDER_COLUMN_GROUPCOMPANY_COMPANYID_2);

			query.append(_FINDER_COLUMN_GROUPCOMPANY_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ReasonCodeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ReasonCode>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ReasonCode>(list);
				}
				else {
					list = (List<ReasonCode>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first reason code in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reason code
	 * @throws com.kencana.lms.NoSuchReasonCodeException if a matching reason code could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReasonCode findByGroupCompany_First(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchReasonCodeException, SystemException {
		ReasonCode reasonCode = fetchByGroupCompany_First(companyId, groupId,
				orderByComparator);

		if (reasonCode != null) {
			return reasonCode;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchReasonCodeException(msg.toString());
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
	@Override
	public ReasonCode fetchByGroupCompany_First(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ReasonCode> list = findByGroupCompany(companyId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ReasonCode findByGroupCompany_Last(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchReasonCodeException, SystemException {
		ReasonCode reasonCode = fetchByGroupCompany_Last(companyId, groupId,
				orderByComparator);

		if (reasonCode != null) {
			return reasonCode;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchReasonCodeException(msg.toString());
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
	@Override
	public ReasonCode fetchByGroupCompany_Last(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupCompany(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<ReasonCode> list = findByGroupCompany(companyId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ReasonCode[] findByGroupCompany_PrevAndNext(long reasonCodeId,
		long companyId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchReasonCodeException, SystemException {
		ReasonCode reasonCode = findByPrimaryKey(reasonCodeId);

		Session session = null;

		try {
			session = openSession();

			ReasonCode[] array = new ReasonCodeImpl[3];

			array[0] = getByGroupCompany_PrevAndNext(session, reasonCode,
					companyId, groupId, orderByComparator, true);

			array[1] = reasonCode;

			array[2] = getByGroupCompany_PrevAndNext(session, reasonCode,
					companyId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ReasonCode getByGroupCompany_PrevAndNext(Session session,
		ReasonCode reasonCode, long companyId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_REASONCODE_WHERE);

		query.append(_FINDER_COLUMN_GROUPCOMPANY_COMPANYID_2);

		query.append(_FINDER_COLUMN_GROUPCOMPANY_GROUPID_2);

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
			query.append(ReasonCodeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(reasonCode);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ReasonCode> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the reason codes where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupCompany(long companyId, long groupId)
		throws SystemException {
		for (ReasonCode reasonCode : findByGroupCompany(companyId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(reasonCode);
		}
	}

	/**
	 * Returns the number of reason codes where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching reason codes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupCompany(long companyId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPCOMPANY;

		Object[] finderArgs = new Object[] { companyId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_REASONCODE_WHERE);

			query.append(_FINDER_COLUMN_GROUPCOMPANY_COMPANYID_2);

			query.append(_FINDER_COLUMN_GROUPCOMPANY_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_GROUPCOMPANY_COMPANYID_2 = "reasonCode.companyId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPCOMPANY_GROUPID_2 = "reasonCode.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(ReasonCodeModelImpl.ENTITY_CACHE_ENABLED,
			ReasonCodeModelImpl.FINDER_CACHE_ENABLED, ReasonCodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(ReasonCodeModelImpl.ENTITY_CACHE_ENABLED,
			ReasonCodeModelImpl.FINDER_CACHE_ENABLED, ReasonCodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			ReasonCodeModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(ReasonCodeModelImpl.ENTITY_CACHE_ENABLED,
			ReasonCodeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the reason codes where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching reason codes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ReasonCode> findByGroup(long groupId) throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ReasonCode> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
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
	@Override
	public List<ReasonCode> findByGroup(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<ReasonCode> list = (List<ReasonCode>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ReasonCode reasonCode : list) {
				if ((groupId != reasonCode.getGroupId())) {
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

			query.append(_SQL_SELECT_REASONCODE_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ReasonCodeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ReasonCode>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ReasonCode>(list);
				}
				else {
					list = (List<ReasonCode>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first reason code in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reason code
	 * @throws com.kencana.lms.NoSuchReasonCodeException if a matching reason code could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReasonCode findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchReasonCodeException, SystemException {
		ReasonCode reasonCode = fetchByGroup_First(groupId, orderByComparator);

		if (reasonCode != null) {
			return reasonCode;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchReasonCodeException(msg.toString());
	}

	/**
	 * Returns the first reason code in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reason code, or <code>null</code> if a matching reason code could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReasonCode fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ReasonCode> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ReasonCode findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchReasonCodeException, SystemException {
		ReasonCode reasonCode = fetchByGroup_Last(groupId, orderByComparator);

		if (reasonCode != null) {
			return reasonCode;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchReasonCodeException(msg.toString());
	}

	/**
	 * Returns the last reason code in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reason code, or <code>null</code> if a matching reason code could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReasonCode fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		if (count == 0) {
			return null;
		}

		List<ReasonCode> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ReasonCode[] findByGroup_PrevAndNext(long reasonCodeId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchReasonCodeException, SystemException {
		ReasonCode reasonCode = findByPrimaryKey(reasonCodeId);

		Session session = null;

		try {
			session = openSession();

			ReasonCode[] array = new ReasonCodeImpl[3];

			array[0] = getByGroup_PrevAndNext(session, reasonCode, groupId,
					orderByComparator, true);

			array[1] = reasonCode;

			array[2] = getByGroup_PrevAndNext(session, reasonCode, groupId,
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

	protected ReasonCode getByGroup_PrevAndNext(Session session,
		ReasonCode reasonCode, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_REASONCODE_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

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
			query.append(ReasonCodeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(reasonCode);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ReasonCode> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the reason codes where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroup(long groupId) throws SystemException {
		for (ReasonCode reasonCode : findByGroup(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(reasonCode);
		}
	}

	/**
	 * Returns the number of reason codes where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching reason codes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroup(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUP;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_REASONCODE_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "reasonCode.groupId = ?";

	public ReasonCodePersistenceImpl() {
		setModelClass(ReasonCode.class);
	}

	/**
	 * Caches the reason code in the entity cache if it is enabled.
	 *
	 * @param reasonCode the reason code
	 */
	@Override
	public void cacheResult(ReasonCode reasonCode) {
		EntityCacheUtil.putResult(ReasonCodeModelImpl.ENTITY_CACHE_ENABLED,
			ReasonCodeImpl.class, reasonCode.getPrimaryKey(), reasonCode);

		reasonCode.resetOriginalValues();
	}

	/**
	 * Caches the reason codes in the entity cache if it is enabled.
	 *
	 * @param reasonCodes the reason codes
	 */
	@Override
	public void cacheResult(List<ReasonCode> reasonCodes) {
		for (ReasonCode reasonCode : reasonCodes) {
			if (EntityCacheUtil.getResult(
						ReasonCodeModelImpl.ENTITY_CACHE_ENABLED,
						ReasonCodeImpl.class, reasonCode.getPrimaryKey()) == null) {
				cacheResult(reasonCode);
			}
			else {
				reasonCode.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all reason codes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ReasonCodeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ReasonCodeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the reason code.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ReasonCode reasonCode) {
		EntityCacheUtil.removeResult(ReasonCodeModelImpl.ENTITY_CACHE_ENABLED,
			ReasonCodeImpl.class, reasonCode.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ReasonCode> reasonCodes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ReasonCode reasonCode : reasonCodes) {
			EntityCacheUtil.removeResult(ReasonCodeModelImpl.ENTITY_CACHE_ENABLED,
				ReasonCodeImpl.class, reasonCode.getPrimaryKey());
		}
	}

	/**
	 * Creates a new reason code with the primary key. Does not add the reason code to the database.
	 *
	 * @param reasonCodeId the primary key for the new reason code
	 * @return the new reason code
	 */
	@Override
	public ReasonCode create(long reasonCodeId) {
		ReasonCode reasonCode = new ReasonCodeImpl();

		reasonCode.setNew(true);
		reasonCode.setPrimaryKey(reasonCodeId);

		return reasonCode;
	}

	/**
	 * Removes the reason code with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param reasonCodeId the primary key of the reason code
	 * @return the reason code that was removed
	 * @throws com.kencana.lms.NoSuchReasonCodeException if a reason code with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReasonCode remove(long reasonCodeId)
		throws NoSuchReasonCodeException, SystemException {
		return remove((Serializable)reasonCodeId);
	}

	/**
	 * Removes the reason code with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the reason code
	 * @return the reason code that was removed
	 * @throws com.kencana.lms.NoSuchReasonCodeException if a reason code with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReasonCode remove(Serializable primaryKey)
		throws NoSuchReasonCodeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ReasonCode reasonCode = (ReasonCode)session.get(ReasonCodeImpl.class,
					primaryKey);

			if (reasonCode == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchReasonCodeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(reasonCode);
		}
		catch (NoSuchReasonCodeException nsee) {
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
	protected ReasonCode removeImpl(ReasonCode reasonCode)
		throws SystemException {
		reasonCode = toUnwrappedModel(reasonCode);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(reasonCode)) {
				reasonCode = (ReasonCode)session.get(ReasonCodeImpl.class,
						reasonCode.getPrimaryKeyObj());
			}

			if (reasonCode != null) {
				session.delete(reasonCode);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (reasonCode != null) {
			clearCache(reasonCode);
		}

		return reasonCode;
	}

	@Override
	public ReasonCode updateImpl(com.kencana.lms.model.ReasonCode reasonCode)
		throws SystemException {
		reasonCode = toUnwrappedModel(reasonCode);

		boolean isNew = reasonCode.isNew();

		ReasonCodeModelImpl reasonCodeModelImpl = (ReasonCodeModelImpl)reasonCode;

		Session session = null;

		try {
			session = openSession();

			if (reasonCode.isNew()) {
				session.save(reasonCode);

				reasonCode.setNew(false);
			}
			else {
				session.merge(reasonCode);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ReasonCodeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((reasonCodeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						reasonCodeModelImpl.getOriginalCompanyId(),
						reasonCodeModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCOMPANY,
					args);

				args = new Object[] {
						reasonCodeModelImpl.getCompanyId(),
						reasonCodeModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCOMPANY,
					args);
			}

			if ((reasonCodeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						reasonCodeModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] { reasonCodeModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(ReasonCodeModelImpl.ENTITY_CACHE_ENABLED,
			ReasonCodeImpl.class, reasonCode.getPrimaryKey(), reasonCode);

		return reasonCode;
	}

	protected ReasonCode toUnwrappedModel(ReasonCode reasonCode) {
		if (reasonCode instanceof ReasonCodeImpl) {
			return reasonCode;
		}

		ReasonCodeImpl reasonCodeImpl = new ReasonCodeImpl();

		reasonCodeImpl.setNew(reasonCode.isNew());
		reasonCodeImpl.setPrimaryKey(reasonCode.getPrimaryKey());

		reasonCodeImpl.setReasonCodeId(reasonCode.getReasonCodeId());
		reasonCodeImpl.setReasonCodeName(reasonCode.getReasonCodeName());
		reasonCodeImpl.setGroupId(reasonCode.getGroupId());
		reasonCodeImpl.setCompanyId(reasonCode.getCompanyId());

		return reasonCodeImpl;
	}

	/**
	 * Returns the reason code with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the reason code
	 * @return the reason code
	 * @throws com.kencana.lms.NoSuchReasonCodeException if a reason code with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReasonCode findByPrimaryKey(Serializable primaryKey)
		throws NoSuchReasonCodeException, SystemException {
		ReasonCode reasonCode = fetchByPrimaryKey(primaryKey);

		if (reasonCode == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchReasonCodeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return reasonCode;
	}

	/**
	 * Returns the reason code with the primary key or throws a {@link com.kencana.lms.NoSuchReasonCodeException} if it could not be found.
	 *
	 * @param reasonCodeId the primary key of the reason code
	 * @return the reason code
	 * @throws com.kencana.lms.NoSuchReasonCodeException if a reason code with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReasonCode findByPrimaryKey(long reasonCodeId)
		throws NoSuchReasonCodeException, SystemException {
		return findByPrimaryKey((Serializable)reasonCodeId);
	}

	/**
	 * Returns the reason code with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the reason code
	 * @return the reason code, or <code>null</code> if a reason code with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReasonCode fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ReasonCode reasonCode = (ReasonCode)EntityCacheUtil.getResult(ReasonCodeModelImpl.ENTITY_CACHE_ENABLED,
				ReasonCodeImpl.class, primaryKey);

		if (reasonCode == _nullReasonCode) {
			return null;
		}

		if (reasonCode == null) {
			Session session = null;

			try {
				session = openSession();

				reasonCode = (ReasonCode)session.get(ReasonCodeImpl.class,
						primaryKey);

				if (reasonCode != null) {
					cacheResult(reasonCode);
				}
				else {
					EntityCacheUtil.putResult(ReasonCodeModelImpl.ENTITY_CACHE_ENABLED,
						ReasonCodeImpl.class, primaryKey, _nullReasonCode);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ReasonCodeModelImpl.ENTITY_CACHE_ENABLED,
					ReasonCodeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return reasonCode;
	}

	/**
	 * Returns the reason code with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param reasonCodeId the primary key of the reason code
	 * @return the reason code, or <code>null</code> if a reason code with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReasonCode fetchByPrimaryKey(long reasonCodeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)reasonCodeId);
	}

	/**
	 * Returns all the reason codes.
	 *
	 * @return the reason codes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ReasonCode> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ReasonCode> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<ReasonCode> findAll(int start, int end,
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

		List<ReasonCode> list = (List<ReasonCode>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_REASONCODE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_REASONCODE;

				if (pagination) {
					sql = sql.concat(ReasonCodeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ReasonCode>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ReasonCode>(list);
				}
				else {
					list = (List<ReasonCode>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the reason codes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ReasonCode reasonCode : findAll()) {
			remove(reasonCode);
		}
	}

	/**
	 * Returns the number of reason codes.
	 *
	 * @return the number of reason codes
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

				Query q = session.createQuery(_SQL_COUNT_REASONCODE);

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
	 * Initializes the reason code persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.kencana.lms.model.ReasonCode")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ReasonCode>> listenersList = new ArrayList<ModelListener<ReasonCode>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ReasonCode>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ReasonCodeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_REASONCODE = "SELECT reasonCode FROM ReasonCode reasonCode";
	private static final String _SQL_SELECT_REASONCODE_WHERE = "SELECT reasonCode FROM ReasonCode reasonCode WHERE ";
	private static final String _SQL_COUNT_REASONCODE = "SELECT COUNT(reasonCode) FROM ReasonCode reasonCode";
	private static final String _SQL_COUNT_REASONCODE_WHERE = "SELECT COUNT(reasonCode) FROM ReasonCode reasonCode WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "reasonCode.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ReasonCode exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ReasonCode exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ReasonCodePersistenceImpl.class);
	private static ReasonCode _nullReasonCode = new ReasonCodeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ReasonCode> toCacheModel() {
				return _nullReasonCodeCacheModel;
			}
		};

	private static CacheModel<ReasonCode> _nullReasonCodeCacheModel = new CacheModel<ReasonCode>() {
			@Override
			public ReasonCode toEntityModel() {
				return _nullReasonCode;
			}
		};
}