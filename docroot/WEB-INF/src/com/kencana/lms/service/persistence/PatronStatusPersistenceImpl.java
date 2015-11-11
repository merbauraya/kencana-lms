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

import com.kencana.lms.NoSuchPatronStatusException;
import com.kencana.lms.model.PatronStatus;
import com.kencana.lms.model.impl.PatronStatusImpl;
import com.kencana.lms.model.impl.PatronStatusModelImpl;

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
 * The persistence implementation for the patron status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see PatronStatusPersistence
 * @see PatronStatusUtil
 * @generated
 */
public class PatronStatusPersistenceImpl extends BasePersistenceImpl<PatronStatus>
	implements PatronStatusPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PatronStatusUtil} to access the patron status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PatronStatusImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PatronStatusModelImpl.ENTITY_CACHE_ENABLED,
			PatronStatusModelImpl.FINDER_CACHE_ENABLED, PatronStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PatronStatusModelImpl.ENTITY_CACHE_ENABLED,
			PatronStatusModelImpl.FINDER_CACHE_ENABLED, PatronStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PatronStatusModelImpl.ENTITY_CACHE_ENABLED,
			PatronStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(PatronStatusModelImpl.ENTITY_CACHE_ENABLED,
			PatronStatusModelImpl.FINDER_CACHE_ENABLED, PatronStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(PatronStatusModelImpl.ENTITY_CACHE_ENABLED,
			PatronStatusModelImpl.FINDER_CACHE_ENABLED, PatronStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			PatronStatusModelImpl.COMPANYID_COLUMN_BITMASK |
			PatronStatusModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYGROUP = new FinderPath(PatronStatusModelImpl.ENTITY_CACHE_ENABLED,
			PatronStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the patron statuses where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching patron statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatronStatus> findByCompanyGroup(long companyId, long groupId)
		throws SystemException {
		return findByCompanyGroup(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the patron statuses where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of patron statuses
	 * @param end the upper bound of the range of patron statuses (not inclusive)
	 * @return the range of matching patron statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatronStatus> findByCompanyGroup(long companyId, long groupId,
		int start, int end) throws SystemException {
		return findByCompanyGroup(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the patron statuses where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of patron statuses
	 * @param end the upper bound of the range of patron statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patron statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatronStatus> findByCompanyGroup(long companyId, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP;
			finderArgs = new Object[] { companyId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYGROUP;
			finderArgs = new Object[] {
					companyId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<PatronStatus> list = (List<PatronStatus>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PatronStatus patronStatus : list) {
				if ((companyId != patronStatus.getCompanyId()) ||
						(groupId != patronStatus.getGroupId())) {
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

			query.append(_SQL_SELECT_PATRONSTATUS_WHERE);

			query.append(_FINDER_COLUMN_COMPANYGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PatronStatusModelImpl.ORDER_BY_JPQL);
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
					list = (List<PatronStatus>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PatronStatus>(list);
				}
				else {
					list = (List<PatronStatus>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first patron status in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patron status
	 * @throws com.kencana.lms.NoSuchPatronStatusException if a matching patron status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronStatus findByCompanyGroup_First(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPatronStatusException, SystemException {
		PatronStatus patronStatus = fetchByCompanyGroup_First(companyId,
				groupId, orderByComparator);

		if (patronStatus != null) {
			return patronStatus;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPatronStatusException(msg.toString());
	}

	/**
	 * Returns the first patron status in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patron status, or <code>null</code> if a matching patron status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronStatus fetchByCompanyGroup_First(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PatronStatus> list = findByCompanyGroup(companyId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last patron status in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patron status
	 * @throws com.kencana.lms.NoSuchPatronStatusException if a matching patron status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronStatus findByCompanyGroup_Last(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPatronStatusException, SystemException {
		PatronStatus patronStatus = fetchByCompanyGroup_Last(companyId,
				groupId, orderByComparator);

		if (patronStatus != null) {
			return patronStatus;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPatronStatusException(msg.toString());
	}

	/**
	 * Returns the last patron status in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patron status, or <code>null</code> if a matching patron status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronStatus fetchByCompanyGroup_Last(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyGroup(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<PatronStatus> list = findByCompanyGroup(companyId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the patron statuses before and after the current patron status in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param patronStatusId the primary key of the current patron status
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patron status
	 * @throws com.kencana.lms.NoSuchPatronStatusException if a patron status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronStatus[] findByCompanyGroup_PrevAndNext(long patronStatusId,
		long companyId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchPatronStatusException, SystemException {
		PatronStatus patronStatus = findByPrimaryKey(patronStatusId);

		Session session = null;

		try {
			session = openSession();

			PatronStatus[] array = new PatronStatusImpl[3];

			array[0] = getByCompanyGroup_PrevAndNext(session, patronStatus,
					companyId, groupId, orderByComparator, true);

			array[1] = patronStatus;

			array[2] = getByCompanyGroup_PrevAndNext(session, patronStatus,
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

	protected PatronStatus getByCompanyGroup_PrevAndNext(Session session,
		PatronStatus patronStatus, long companyId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PATRONSTATUS_WHERE);

		query.append(_FINDER_COLUMN_COMPANYGROUP_COMPANYID_2);

		query.append(_FINDER_COLUMN_COMPANYGROUP_GROUPID_2);

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
			query.append(PatronStatusModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(patronStatus);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PatronStatus> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the patron statuses where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyGroup(long companyId, long groupId)
		throws SystemException {
		for (PatronStatus patronStatus : findByCompanyGroup(companyId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(patronStatus);
		}
	}

	/**
	 * Returns the number of patron statuses where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching patron statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompanyGroup(long companyId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYGROUP;

		Object[] finderArgs = new Object[] { companyId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PATRONSTATUS_WHERE);

			query.append(_FINDER_COLUMN_COMPANYGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUP_GROUPID_2);

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

	private static final String _FINDER_COLUMN_COMPANYGROUP_COMPANYID_2 = "patronStatus.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYGROUP_GROUPID_2 = "patronStatus.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(PatronStatusModelImpl.ENTITY_CACHE_ENABLED,
			PatronStatusModelImpl.FINDER_CACHE_ENABLED, PatronStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(PatronStatusModelImpl.ENTITY_CACHE_ENABLED,
			PatronStatusModelImpl.FINDER_CACHE_ENABLED, PatronStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			PatronStatusModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(PatronStatusModelImpl.ENTITY_CACHE_ENABLED,
			PatronStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the patron statuses where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching patron statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatronStatus> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the patron statuses where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of patron statuses
	 * @param end the upper bound of the range of patron statuses (not inclusive)
	 * @return the range of matching patron statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatronStatus> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the patron statuses where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of patron statuses
	 * @param end the upper bound of the range of patron statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patron statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatronStatus> findByCompany(long companyId, int start, int end,
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

		List<PatronStatus> list = (List<PatronStatus>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PatronStatus patronStatus : list) {
				if ((companyId != patronStatus.getCompanyId())) {
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

			query.append(_SQL_SELECT_PATRONSTATUS_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PatronStatusModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<PatronStatus>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PatronStatus>(list);
				}
				else {
					list = (List<PatronStatus>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first patron status in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patron status
	 * @throws com.kencana.lms.NoSuchPatronStatusException if a matching patron status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronStatus findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPatronStatusException, SystemException {
		PatronStatus patronStatus = fetchByCompany_First(companyId,
				orderByComparator);

		if (patronStatus != null) {
			return patronStatus;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPatronStatusException(msg.toString());
	}

	/**
	 * Returns the first patron status in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patron status, or <code>null</code> if a matching patron status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronStatus fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PatronStatus> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last patron status in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patron status
	 * @throws com.kencana.lms.NoSuchPatronStatusException if a matching patron status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronStatus findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPatronStatusException, SystemException {
		PatronStatus patronStatus = fetchByCompany_Last(companyId,
				orderByComparator);

		if (patronStatus != null) {
			return patronStatus;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPatronStatusException(msg.toString());
	}

	/**
	 * Returns the last patron status in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patron status, or <code>null</code> if a matching patron status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronStatus fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		if (count == 0) {
			return null;
		}

		List<PatronStatus> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the patron statuses before and after the current patron status in the ordered set where companyId = &#63;.
	 *
	 * @param patronStatusId the primary key of the current patron status
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patron status
	 * @throws com.kencana.lms.NoSuchPatronStatusException if a patron status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronStatus[] findByCompany_PrevAndNext(long patronStatusId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchPatronStatusException, SystemException {
		PatronStatus patronStatus = findByPrimaryKey(patronStatusId);

		Session session = null;

		try {
			session = openSession();

			PatronStatus[] array = new PatronStatusImpl[3];

			array[0] = getByCompany_PrevAndNext(session, patronStatus,
					companyId, orderByComparator, true);

			array[1] = patronStatus;

			array[2] = getByCompany_PrevAndNext(session, patronStatus,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PatronStatus getByCompany_PrevAndNext(Session session,
		PatronStatus patronStatus, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PATRONSTATUS_WHERE);

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
			query.append(PatronStatusModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(patronStatus);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PatronStatus> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the patron statuses where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompany(long companyId) throws SystemException {
		for (PatronStatus patronStatus : findByCompany(companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(patronStatus);
		}
	}

	/**
	 * Returns the number of patron statuses where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching patron statuses
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

			query.append(_SQL_COUNT_PATRONSTATUS_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "patronStatus.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(PatronStatusModelImpl.ENTITY_CACHE_ENABLED,
			PatronStatusModelImpl.FINDER_CACHE_ENABLED, PatronStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(PatronStatusModelImpl.ENTITY_CACHE_ENABLED,
			PatronStatusModelImpl.FINDER_CACHE_ENABLED, PatronStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			PatronStatusModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(PatronStatusModelImpl.ENTITY_CACHE_ENABLED,
			PatronStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the patron statuses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching patron statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatronStatus> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the patron statuses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of patron statuses
	 * @param end the upper bound of the range of patron statuses (not inclusive)
	 * @return the range of matching patron statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatronStatus> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the patron statuses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of patron statuses
	 * @param end the upper bound of the range of patron statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patron statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatronStatus> findByGroup(long groupId, int start, int end,
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

		List<PatronStatus> list = (List<PatronStatus>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PatronStatus patronStatus : list) {
				if ((groupId != patronStatus.getGroupId())) {
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

			query.append(_SQL_SELECT_PATRONSTATUS_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PatronStatusModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<PatronStatus>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PatronStatus>(list);
				}
				else {
					list = (List<PatronStatus>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first patron status in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patron status
	 * @throws com.kencana.lms.NoSuchPatronStatusException if a matching patron status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronStatus findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPatronStatusException, SystemException {
		PatronStatus patronStatus = fetchByGroup_First(groupId,
				orderByComparator);

		if (patronStatus != null) {
			return patronStatus;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPatronStatusException(msg.toString());
	}

	/**
	 * Returns the first patron status in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patron status, or <code>null</code> if a matching patron status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronStatus fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PatronStatus> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last patron status in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patron status
	 * @throws com.kencana.lms.NoSuchPatronStatusException if a matching patron status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronStatus findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPatronStatusException, SystemException {
		PatronStatus patronStatus = fetchByGroup_Last(groupId, orderByComparator);

		if (patronStatus != null) {
			return patronStatus;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPatronStatusException(msg.toString());
	}

	/**
	 * Returns the last patron status in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patron status, or <code>null</code> if a matching patron status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronStatus fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		if (count == 0) {
			return null;
		}

		List<PatronStatus> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the patron statuses before and after the current patron status in the ordered set where groupId = &#63;.
	 *
	 * @param patronStatusId the primary key of the current patron status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patron status
	 * @throws com.kencana.lms.NoSuchPatronStatusException if a patron status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronStatus[] findByGroup_PrevAndNext(long patronStatusId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchPatronStatusException, SystemException {
		PatronStatus patronStatus = findByPrimaryKey(patronStatusId);

		Session session = null;

		try {
			session = openSession();

			PatronStatus[] array = new PatronStatusImpl[3];

			array[0] = getByGroup_PrevAndNext(session, patronStatus, groupId,
					orderByComparator, true);

			array[1] = patronStatus;

			array[2] = getByGroup_PrevAndNext(session, patronStatus, groupId,
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

	protected PatronStatus getByGroup_PrevAndNext(Session session,
		PatronStatus patronStatus, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PATRONSTATUS_WHERE);

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
			query.append(PatronStatusModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(patronStatus);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PatronStatus> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the patron statuses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroup(long groupId) throws SystemException {
		for (PatronStatus patronStatus : findByGroup(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(patronStatus);
		}
	}

	/**
	 * Returns the number of patron statuses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching patron statuses
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

			query.append(_SQL_COUNT_PATRONSTATUS_WHERE);

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

	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "patronStatus.groupId = ?";

	public PatronStatusPersistenceImpl() {
		setModelClass(PatronStatus.class);
	}

	/**
	 * Caches the patron status in the entity cache if it is enabled.
	 *
	 * @param patronStatus the patron status
	 */
	@Override
	public void cacheResult(PatronStatus patronStatus) {
		EntityCacheUtil.putResult(PatronStatusModelImpl.ENTITY_CACHE_ENABLED,
			PatronStatusImpl.class, patronStatus.getPrimaryKey(), patronStatus);

		patronStatus.resetOriginalValues();
	}

	/**
	 * Caches the patron statuses in the entity cache if it is enabled.
	 *
	 * @param patronStatuses the patron statuses
	 */
	@Override
	public void cacheResult(List<PatronStatus> patronStatuses) {
		for (PatronStatus patronStatus : patronStatuses) {
			if (EntityCacheUtil.getResult(
						PatronStatusModelImpl.ENTITY_CACHE_ENABLED,
						PatronStatusImpl.class, patronStatus.getPrimaryKey()) == null) {
				cacheResult(patronStatus);
			}
			else {
				patronStatus.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all patron statuses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PatronStatusImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PatronStatusImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the patron status.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PatronStatus patronStatus) {
		EntityCacheUtil.removeResult(PatronStatusModelImpl.ENTITY_CACHE_ENABLED,
			PatronStatusImpl.class, patronStatus.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PatronStatus> patronStatuses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PatronStatus patronStatus : patronStatuses) {
			EntityCacheUtil.removeResult(PatronStatusModelImpl.ENTITY_CACHE_ENABLED,
				PatronStatusImpl.class, patronStatus.getPrimaryKey());
		}
	}

	/**
	 * Creates a new patron status with the primary key. Does not add the patron status to the database.
	 *
	 * @param patronStatusId the primary key for the new patron status
	 * @return the new patron status
	 */
	@Override
	public PatronStatus create(long patronStatusId) {
		PatronStatus patronStatus = new PatronStatusImpl();

		patronStatus.setNew(true);
		patronStatus.setPrimaryKey(patronStatusId);

		return patronStatus;
	}

	/**
	 * Removes the patron status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param patronStatusId the primary key of the patron status
	 * @return the patron status that was removed
	 * @throws com.kencana.lms.NoSuchPatronStatusException if a patron status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronStatus remove(long patronStatusId)
		throws NoSuchPatronStatusException, SystemException {
		return remove((Serializable)patronStatusId);
	}

	/**
	 * Removes the patron status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the patron status
	 * @return the patron status that was removed
	 * @throws com.kencana.lms.NoSuchPatronStatusException if a patron status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronStatus remove(Serializable primaryKey)
		throws NoSuchPatronStatusException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PatronStatus patronStatus = (PatronStatus)session.get(PatronStatusImpl.class,
					primaryKey);

			if (patronStatus == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPatronStatusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(patronStatus);
		}
		catch (NoSuchPatronStatusException nsee) {
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
	protected PatronStatus removeImpl(PatronStatus patronStatus)
		throws SystemException {
		patronStatus = toUnwrappedModel(patronStatus);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(patronStatus)) {
				patronStatus = (PatronStatus)session.get(PatronStatusImpl.class,
						patronStatus.getPrimaryKeyObj());
			}

			if (patronStatus != null) {
				session.delete(patronStatus);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (patronStatus != null) {
			clearCache(patronStatus);
		}

		return patronStatus;
	}

	@Override
	public PatronStatus updateImpl(
		com.kencana.lms.model.PatronStatus patronStatus)
		throws SystemException {
		patronStatus = toUnwrappedModel(patronStatus);

		boolean isNew = patronStatus.isNew();

		PatronStatusModelImpl patronStatusModelImpl = (PatronStatusModelImpl)patronStatus;

		Session session = null;

		try {
			session = openSession();

			if (patronStatus.isNew()) {
				session.save(patronStatus);

				patronStatus.setNew(false);
			}
			else {
				session.merge(patronStatus);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PatronStatusModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((patronStatusModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						patronStatusModelImpl.getOriginalCompanyId(),
						patronStatusModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);

				args = new Object[] {
						patronStatusModelImpl.getCompanyId(),
						patronStatusModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);
			}

			if ((patronStatusModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						patronStatusModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] { patronStatusModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((patronStatusModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						patronStatusModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] { patronStatusModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(PatronStatusModelImpl.ENTITY_CACHE_ENABLED,
			PatronStatusImpl.class, patronStatus.getPrimaryKey(), patronStatus);

		return patronStatus;
	}

	protected PatronStatus toUnwrappedModel(PatronStatus patronStatus) {
		if (patronStatus instanceof PatronStatusImpl) {
			return patronStatus;
		}

		PatronStatusImpl patronStatusImpl = new PatronStatusImpl();

		patronStatusImpl.setNew(patronStatus.isNew());
		patronStatusImpl.setPrimaryKey(patronStatus.getPrimaryKey());

		patronStatusImpl.setPatronStatusId(patronStatus.getPatronStatusId());
		patronStatusImpl.setPatronStatusName(patronStatus.getPatronStatusName());
		patronStatusImpl.setNoLogin(patronStatus.isNoLogin());
		patronStatusImpl.setNoCheckout(patronStatus.isNoCheckout());
		patronStatusImpl.setNoReserve(patronStatus.isNoReserve());
		patronStatusImpl.setNoRenew(patronStatus.isNoRenew());
		patronStatusImpl.setColor(patronStatus.getColor());
		patronStatusImpl.setGroupId(patronStatus.getGroupId());
		patronStatusImpl.setCompanyId(patronStatus.getCompanyId());

		return patronStatusImpl;
	}

	/**
	 * Returns the patron status with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the patron status
	 * @return the patron status
	 * @throws com.kencana.lms.NoSuchPatronStatusException if a patron status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronStatus findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPatronStatusException, SystemException {
		PatronStatus patronStatus = fetchByPrimaryKey(primaryKey);

		if (patronStatus == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPatronStatusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return patronStatus;
	}

	/**
	 * Returns the patron status with the primary key or throws a {@link com.kencana.lms.NoSuchPatronStatusException} if it could not be found.
	 *
	 * @param patronStatusId the primary key of the patron status
	 * @return the patron status
	 * @throws com.kencana.lms.NoSuchPatronStatusException if a patron status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronStatus findByPrimaryKey(long patronStatusId)
		throws NoSuchPatronStatusException, SystemException {
		return findByPrimaryKey((Serializable)patronStatusId);
	}

	/**
	 * Returns the patron status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the patron status
	 * @return the patron status, or <code>null</code> if a patron status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronStatus fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PatronStatus patronStatus = (PatronStatus)EntityCacheUtil.getResult(PatronStatusModelImpl.ENTITY_CACHE_ENABLED,
				PatronStatusImpl.class, primaryKey);

		if (patronStatus == _nullPatronStatus) {
			return null;
		}

		if (patronStatus == null) {
			Session session = null;

			try {
				session = openSession();

				patronStatus = (PatronStatus)session.get(PatronStatusImpl.class,
						primaryKey);

				if (patronStatus != null) {
					cacheResult(patronStatus);
				}
				else {
					EntityCacheUtil.putResult(PatronStatusModelImpl.ENTITY_CACHE_ENABLED,
						PatronStatusImpl.class, primaryKey, _nullPatronStatus);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PatronStatusModelImpl.ENTITY_CACHE_ENABLED,
					PatronStatusImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return patronStatus;
	}

	/**
	 * Returns the patron status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param patronStatusId the primary key of the patron status
	 * @return the patron status, or <code>null</code> if a patron status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronStatus fetchByPrimaryKey(long patronStatusId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)patronStatusId);
	}

	/**
	 * Returns all the patron statuses.
	 *
	 * @return the patron statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatronStatus> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the patron statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of patron statuses
	 * @param end the upper bound of the range of patron statuses (not inclusive)
	 * @return the range of patron statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatronStatus> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the patron statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of patron statuses
	 * @param end the upper bound of the range of patron statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of patron statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatronStatus> findAll(int start, int end,
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

		List<PatronStatus> list = (List<PatronStatus>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PATRONSTATUS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PATRONSTATUS;

				if (pagination) {
					sql = sql.concat(PatronStatusModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PatronStatus>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PatronStatus>(list);
				}
				else {
					list = (List<PatronStatus>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the patron statuses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PatronStatus patronStatus : findAll()) {
			remove(patronStatus);
		}
	}

	/**
	 * Returns the number of patron statuses.
	 *
	 * @return the number of patron statuses
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

				Query q = session.createQuery(_SQL_COUNT_PATRONSTATUS);

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
	 * Initializes the patron status persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.kencana.lms.model.PatronStatus")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PatronStatus>> listenersList = new ArrayList<ModelListener<PatronStatus>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PatronStatus>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PatronStatusImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PATRONSTATUS = "SELECT patronStatus FROM PatronStatus patronStatus";
	private static final String _SQL_SELECT_PATRONSTATUS_WHERE = "SELECT patronStatus FROM PatronStatus patronStatus WHERE ";
	private static final String _SQL_COUNT_PATRONSTATUS = "SELECT COUNT(patronStatus) FROM PatronStatus patronStatus";
	private static final String _SQL_COUNT_PATRONSTATUS_WHERE = "SELECT COUNT(patronStatus) FROM PatronStatus patronStatus WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "patronStatus.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PatronStatus exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PatronStatus exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PatronStatusPersistenceImpl.class);
	private static PatronStatus _nullPatronStatus = new PatronStatusImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PatronStatus> toCacheModel() {
				return _nullPatronStatusCacheModel;
			}
		};

	private static CacheModel<PatronStatus> _nullPatronStatusCacheModel = new CacheModel<PatronStatus>() {
			@Override
			public PatronStatus toEntityModel() {
				return _nullPatronStatus;
			}
		};
}