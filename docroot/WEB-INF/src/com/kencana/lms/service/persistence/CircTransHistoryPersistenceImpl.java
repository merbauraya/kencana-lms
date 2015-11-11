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

import com.kencana.lms.NoSuchCircTransHistoryException;
import com.kencana.lms.model.CircTransHistory;
import com.kencana.lms.model.impl.CircTransHistoryImpl;
import com.kencana.lms.model.impl.CircTransHistoryModelImpl;

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
 * The persistence implementation for the circ trans history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see CircTransHistoryPersistence
 * @see CircTransHistoryUtil
 * @generated
 */
public class CircTransHistoryPersistenceImpl extends BasePersistenceImpl<CircTransHistory>
	implements CircTransHistoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CircTransHistoryUtil} to access the circ trans history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CircTransHistoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CircTransHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CircTransHistoryModelImpl.FINDER_CACHE_ENABLED,
			CircTransHistoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CircTransHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CircTransHistoryModelImpl.FINDER_CACHE_ENABLED,
			CircTransHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CircTransHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CircTransHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(CircTransHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CircTransHistoryModelImpl.FINDER_CACHE_ENABLED,
			CircTransHistoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompanyGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(CircTransHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CircTransHistoryModelImpl.FINDER_CACHE_ENABLED,
			CircTransHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			CircTransHistoryModelImpl.COMPANYID_COLUMN_BITMASK |
			CircTransHistoryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYGROUP = new FinderPath(CircTransHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CircTransHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the circ trans histories where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching circ trans histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CircTransHistory> findByCompanyGroup(long companyId,
		long groupId) throws SystemException {
		return findByCompanyGroup(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the circ trans histories where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CircTransHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of circ trans histories
	 * @param end the upper bound of the range of circ trans histories (not inclusive)
	 * @return the range of matching circ trans histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CircTransHistory> findByCompanyGroup(long companyId,
		long groupId, int start, int end) throws SystemException {
		return findByCompanyGroup(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the circ trans histories where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CircTransHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of circ trans histories
	 * @param end the upper bound of the range of circ trans histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching circ trans histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CircTransHistory> findByCompanyGroup(long companyId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
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

		List<CircTransHistory> list = (List<CircTransHistory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CircTransHistory circTransHistory : list) {
				if ((companyId != circTransHistory.getCompanyId()) ||
						(groupId != circTransHistory.getGroupId())) {
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

			query.append(_SQL_SELECT_CIRCTRANSHISTORY_WHERE);

			query.append(_FINDER_COLUMN_COMPANYGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CircTransHistoryModelImpl.ORDER_BY_JPQL);
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
					list = (List<CircTransHistory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CircTransHistory>(list);
				}
				else {
					list = (List<CircTransHistory>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first circ trans history in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching circ trans history
	 * @throws com.kencana.lms.NoSuchCircTransHistoryException if a matching circ trans history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CircTransHistory findByCompanyGroup_First(long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCircTransHistoryException, SystemException {
		CircTransHistory circTransHistory = fetchByCompanyGroup_First(companyId,
				groupId, orderByComparator);

		if (circTransHistory != null) {
			return circTransHistory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCircTransHistoryException(msg.toString());
	}

	/**
	 * Returns the first circ trans history in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching circ trans history, or <code>null</code> if a matching circ trans history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CircTransHistory fetchByCompanyGroup_First(long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<CircTransHistory> list = findByCompanyGroup(companyId, groupId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last circ trans history in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching circ trans history
	 * @throws com.kencana.lms.NoSuchCircTransHistoryException if a matching circ trans history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CircTransHistory findByCompanyGroup_Last(long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCircTransHistoryException, SystemException {
		CircTransHistory circTransHistory = fetchByCompanyGroup_Last(companyId,
				groupId, orderByComparator);

		if (circTransHistory != null) {
			return circTransHistory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCircTransHistoryException(msg.toString());
	}

	/**
	 * Returns the last circ trans history in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching circ trans history, or <code>null</code> if a matching circ trans history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CircTransHistory fetchByCompanyGroup_Last(long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCompanyGroup(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<CircTransHistory> list = findByCompanyGroup(companyId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the circ trans histories before and after the current circ trans history in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param transId the primary key of the current circ trans history
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next circ trans history
	 * @throws com.kencana.lms.NoSuchCircTransHistoryException if a circ trans history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CircTransHistory[] findByCompanyGroup_PrevAndNext(long transId,
		long companyId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchCircTransHistoryException, SystemException {
		CircTransHistory circTransHistory = findByPrimaryKey(transId);

		Session session = null;

		try {
			session = openSession();

			CircTransHistory[] array = new CircTransHistoryImpl[3];

			array[0] = getByCompanyGroup_PrevAndNext(session, circTransHistory,
					companyId, groupId, orderByComparator, true);

			array[1] = circTransHistory;

			array[2] = getByCompanyGroup_PrevAndNext(session, circTransHistory,
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

	protected CircTransHistory getByCompanyGroup_PrevAndNext(Session session,
		CircTransHistory circTransHistory, long companyId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CIRCTRANSHISTORY_WHERE);

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
			query.append(CircTransHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(circTransHistory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CircTransHistory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the circ trans histories where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyGroup(long companyId, long groupId)
		throws SystemException {
		for (CircTransHistory circTransHistory : findByCompanyGroup(companyId,
				groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(circTransHistory);
		}
	}

	/**
	 * Returns the number of circ trans histories where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching circ trans histories
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

			query.append(_SQL_COUNT_CIRCTRANSHISTORY_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANYGROUP_COMPANYID_2 = "circTransHistory.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYGROUP_GROUPID_2 = "circTransHistory.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYGROUPLIBRARY =
		new FinderPath(CircTransHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CircTransHistoryModelImpl.FINDER_CACHE_ENABLED,
			CircTransHistoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompanyGroupLibrary",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUPLIBRARY =
		new FinderPath(CircTransHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CircTransHistoryModelImpl.FINDER_CACHE_ENABLED,
			CircTransHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCompanyGroupLibrary",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			CircTransHistoryModelImpl.COMPANYID_COLUMN_BITMASK |
			CircTransHistoryModelImpl.GROUPID_COLUMN_BITMASK |
			CircTransHistoryModelImpl.LIBRARYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYGROUPLIBRARY = new FinderPath(CircTransHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CircTransHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCompanyGroupLibrary",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the circ trans histories where companyId = &#63; and groupId = &#63; and libraryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param libraryId the library ID
	 * @return the matching circ trans histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CircTransHistory> findByCompanyGroupLibrary(long companyId,
		long groupId, long libraryId) throws SystemException {
		return findByCompanyGroupLibrary(companyId, groupId, libraryId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the circ trans histories where companyId = &#63; and groupId = &#63; and libraryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CircTransHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param libraryId the library ID
	 * @param start the lower bound of the range of circ trans histories
	 * @param end the upper bound of the range of circ trans histories (not inclusive)
	 * @return the range of matching circ trans histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CircTransHistory> findByCompanyGroupLibrary(long companyId,
		long groupId, long libraryId, int start, int end)
		throws SystemException {
		return findByCompanyGroupLibrary(companyId, groupId, libraryId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the circ trans histories where companyId = &#63; and groupId = &#63; and libraryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CircTransHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param libraryId the library ID
	 * @param start the lower bound of the range of circ trans histories
	 * @param end the upper bound of the range of circ trans histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching circ trans histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CircTransHistory> findByCompanyGroupLibrary(long companyId,
		long groupId, long libraryId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUPLIBRARY;
			finderArgs = new Object[] { companyId, groupId, libraryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYGROUPLIBRARY;
			finderArgs = new Object[] {
					companyId, groupId, libraryId,
					
					start, end, orderByComparator
				};
		}

		List<CircTransHistory> list = (List<CircTransHistory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CircTransHistory circTransHistory : list) {
				if ((companyId != circTransHistory.getCompanyId()) ||
						(groupId != circTransHistory.getGroupId()) ||
						(libraryId != circTransHistory.getLibraryId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_CIRCTRANSHISTORY_WHERE);

			query.append(_FINDER_COLUMN_COMPANYGROUPLIBRARY_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUPLIBRARY_GROUPID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUPLIBRARY_LIBRARYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CircTransHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(libraryId);

				if (!pagination) {
					list = (List<CircTransHistory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CircTransHistory>(list);
				}
				else {
					list = (List<CircTransHistory>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first circ trans history in the ordered set where companyId = &#63; and groupId = &#63; and libraryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching circ trans history
	 * @throws com.kencana.lms.NoSuchCircTransHistoryException if a matching circ trans history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CircTransHistory findByCompanyGroupLibrary_First(long companyId,
		long groupId, long libraryId, OrderByComparator orderByComparator)
		throws NoSuchCircTransHistoryException, SystemException {
		CircTransHistory circTransHistory = fetchByCompanyGroupLibrary_First(companyId,
				groupId, libraryId, orderByComparator);

		if (circTransHistory != null) {
			return circTransHistory;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", libraryId=");
		msg.append(libraryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCircTransHistoryException(msg.toString());
	}

	/**
	 * Returns the first circ trans history in the ordered set where companyId = &#63; and groupId = &#63; and libraryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching circ trans history, or <code>null</code> if a matching circ trans history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CircTransHistory fetchByCompanyGroupLibrary_First(long companyId,
		long groupId, long libraryId, OrderByComparator orderByComparator)
		throws SystemException {
		List<CircTransHistory> list = findByCompanyGroupLibrary(companyId,
				groupId, libraryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last circ trans history in the ordered set where companyId = &#63; and groupId = &#63; and libraryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching circ trans history
	 * @throws com.kencana.lms.NoSuchCircTransHistoryException if a matching circ trans history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CircTransHistory findByCompanyGroupLibrary_Last(long companyId,
		long groupId, long libraryId, OrderByComparator orderByComparator)
		throws NoSuchCircTransHistoryException, SystemException {
		CircTransHistory circTransHistory = fetchByCompanyGroupLibrary_Last(companyId,
				groupId, libraryId, orderByComparator);

		if (circTransHistory != null) {
			return circTransHistory;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", libraryId=");
		msg.append(libraryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCircTransHistoryException(msg.toString());
	}

	/**
	 * Returns the last circ trans history in the ordered set where companyId = &#63; and groupId = &#63; and libraryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching circ trans history, or <code>null</code> if a matching circ trans history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CircTransHistory fetchByCompanyGroupLibrary_Last(long companyId,
		long groupId, long libraryId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCompanyGroupLibrary(companyId, groupId, libraryId);

		if (count == 0) {
			return null;
		}

		List<CircTransHistory> list = findByCompanyGroupLibrary(companyId,
				groupId, libraryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the circ trans histories before and after the current circ trans history in the ordered set where companyId = &#63; and groupId = &#63; and libraryId = &#63;.
	 *
	 * @param transId the primary key of the current circ trans history
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next circ trans history
	 * @throws com.kencana.lms.NoSuchCircTransHistoryException if a circ trans history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CircTransHistory[] findByCompanyGroupLibrary_PrevAndNext(
		long transId, long companyId, long groupId, long libraryId,
		OrderByComparator orderByComparator)
		throws NoSuchCircTransHistoryException, SystemException {
		CircTransHistory circTransHistory = findByPrimaryKey(transId);

		Session session = null;

		try {
			session = openSession();

			CircTransHistory[] array = new CircTransHistoryImpl[3];

			array[0] = getByCompanyGroupLibrary_PrevAndNext(session,
					circTransHistory, companyId, groupId, libraryId,
					orderByComparator, true);

			array[1] = circTransHistory;

			array[2] = getByCompanyGroupLibrary_PrevAndNext(session,
					circTransHistory, companyId, groupId, libraryId,
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

	protected CircTransHistory getByCompanyGroupLibrary_PrevAndNext(
		Session session, CircTransHistory circTransHistory, long companyId,
		long groupId, long libraryId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CIRCTRANSHISTORY_WHERE);

		query.append(_FINDER_COLUMN_COMPANYGROUPLIBRARY_COMPANYID_2);

		query.append(_FINDER_COLUMN_COMPANYGROUPLIBRARY_GROUPID_2);

		query.append(_FINDER_COLUMN_COMPANYGROUPLIBRARY_LIBRARYID_2);

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
			query.append(CircTransHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(libraryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(circTransHistory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CircTransHistory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the circ trans histories where companyId = &#63; and groupId = &#63; and libraryId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param libraryId the library ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyGroupLibrary(long companyId, long groupId,
		long libraryId) throws SystemException {
		for (CircTransHistory circTransHistory : findByCompanyGroupLibrary(
				companyId, groupId, libraryId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(circTransHistory);
		}
	}

	/**
	 * Returns the number of circ trans histories where companyId = &#63; and groupId = &#63; and libraryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param libraryId the library ID
	 * @return the number of matching circ trans histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompanyGroupLibrary(long companyId, long groupId,
		long libraryId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYGROUPLIBRARY;

		Object[] finderArgs = new Object[] { companyId, groupId, libraryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CIRCTRANSHISTORY_WHERE);

			query.append(_FINDER_COLUMN_COMPANYGROUPLIBRARY_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUPLIBRARY_GROUPID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUPLIBRARY_LIBRARYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(libraryId);

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

	private static final String _FINDER_COLUMN_COMPANYGROUPLIBRARY_COMPANYID_2 = "circTransHistory.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYGROUPLIBRARY_GROUPID_2 = "circTransHistory.groupId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYGROUPLIBRARY_LIBRARYID_2 = "circTransHistory.libraryId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PATRON = new FinderPath(CircTransHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CircTransHistoryModelImpl.FINDER_CACHE_ENABLED,
			CircTransHistoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPatron",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PATRON =
		new FinderPath(CircTransHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CircTransHistoryModelImpl.FINDER_CACHE_ENABLED,
			CircTransHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPatron",
			new String[] { Long.class.getName(), Long.class.getName() },
			CircTransHistoryModelImpl.COMPANYID_COLUMN_BITMASK |
			CircTransHistoryModelImpl.PATRONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PATRON = new FinderPath(CircTransHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CircTransHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPatron",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the circ trans histories where companyId = &#63; and patronId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param patronId the patron ID
	 * @return the matching circ trans histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CircTransHistory> findByPatron(long companyId, long patronId)
		throws SystemException {
		return findByPatron(companyId, patronId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the circ trans histories where companyId = &#63; and patronId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CircTransHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param patronId the patron ID
	 * @param start the lower bound of the range of circ trans histories
	 * @param end the upper bound of the range of circ trans histories (not inclusive)
	 * @return the range of matching circ trans histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CircTransHistory> findByPatron(long companyId, long patronId,
		int start, int end) throws SystemException {
		return findByPatron(companyId, patronId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the circ trans histories where companyId = &#63; and patronId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CircTransHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param patronId the patron ID
	 * @param start the lower bound of the range of circ trans histories
	 * @param end the upper bound of the range of circ trans histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching circ trans histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CircTransHistory> findByPatron(long companyId, long patronId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PATRON;
			finderArgs = new Object[] { companyId, patronId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PATRON;
			finderArgs = new Object[] {
					companyId, patronId,
					
					start, end, orderByComparator
				};
		}

		List<CircTransHistory> list = (List<CircTransHistory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CircTransHistory circTransHistory : list) {
				if ((companyId != circTransHistory.getCompanyId()) ||
						(patronId != circTransHistory.getPatronId())) {
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

			query.append(_SQL_SELECT_CIRCTRANSHISTORY_WHERE);

			query.append(_FINDER_COLUMN_PATRON_COMPANYID_2);

			query.append(_FINDER_COLUMN_PATRON_PATRONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CircTransHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(patronId);

				if (!pagination) {
					list = (List<CircTransHistory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CircTransHistory>(list);
				}
				else {
					list = (List<CircTransHistory>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first circ trans history in the ordered set where companyId = &#63; and patronId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param patronId the patron ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching circ trans history
	 * @throws com.kencana.lms.NoSuchCircTransHistoryException if a matching circ trans history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CircTransHistory findByPatron_First(long companyId, long patronId,
		OrderByComparator orderByComparator)
		throws NoSuchCircTransHistoryException, SystemException {
		CircTransHistory circTransHistory = fetchByPatron_First(companyId,
				patronId, orderByComparator);

		if (circTransHistory != null) {
			return circTransHistory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", patronId=");
		msg.append(patronId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCircTransHistoryException(msg.toString());
	}

	/**
	 * Returns the first circ trans history in the ordered set where companyId = &#63; and patronId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param patronId the patron ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching circ trans history, or <code>null</code> if a matching circ trans history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CircTransHistory fetchByPatron_First(long companyId, long patronId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CircTransHistory> list = findByPatron(companyId, patronId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last circ trans history in the ordered set where companyId = &#63; and patronId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param patronId the patron ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching circ trans history
	 * @throws com.kencana.lms.NoSuchCircTransHistoryException if a matching circ trans history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CircTransHistory findByPatron_Last(long companyId, long patronId,
		OrderByComparator orderByComparator)
		throws NoSuchCircTransHistoryException, SystemException {
		CircTransHistory circTransHistory = fetchByPatron_Last(companyId,
				patronId, orderByComparator);

		if (circTransHistory != null) {
			return circTransHistory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", patronId=");
		msg.append(patronId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCircTransHistoryException(msg.toString());
	}

	/**
	 * Returns the last circ trans history in the ordered set where companyId = &#63; and patronId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param patronId the patron ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching circ trans history, or <code>null</code> if a matching circ trans history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CircTransHistory fetchByPatron_Last(long companyId, long patronId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPatron(companyId, patronId);

		if (count == 0) {
			return null;
		}

		List<CircTransHistory> list = findByPatron(companyId, patronId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the circ trans histories before and after the current circ trans history in the ordered set where companyId = &#63; and patronId = &#63;.
	 *
	 * @param transId the primary key of the current circ trans history
	 * @param companyId the company ID
	 * @param patronId the patron ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next circ trans history
	 * @throws com.kencana.lms.NoSuchCircTransHistoryException if a circ trans history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CircTransHistory[] findByPatron_PrevAndNext(long transId,
		long companyId, long patronId, OrderByComparator orderByComparator)
		throws NoSuchCircTransHistoryException, SystemException {
		CircTransHistory circTransHistory = findByPrimaryKey(transId);

		Session session = null;

		try {
			session = openSession();

			CircTransHistory[] array = new CircTransHistoryImpl[3];

			array[0] = getByPatron_PrevAndNext(session, circTransHistory,
					companyId, patronId, orderByComparator, true);

			array[1] = circTransHistory;

			array[2] = getByPatron_PrevAndNext(session, circTransHistory,
					companyId, patronId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CircTransHistory getByPatron_PrevAndNext(Session session,
		CircTransHistory circTransHistory, long companyId, long patronId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CIRCTRANSHISTORY_WHERE);

		query.append(_FINDER_COLUMN_PATRON_COMPANYID_2);

		query.append(_FINDER_COLUMN_PATRON_PATRONID_2);

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
			query.append(CircTransHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(patronId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(circTransHistory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CircTransHistory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the circ trans histories where companyId = &#63; and patronId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param patronId the patron ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPatron(long companyId, long patronId)
		throws SystemException {
		for (CircTransHistory circTransHistory : findByPatron(companyId,
				patronId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(circTransHistory);
		}
	}

	/**
	 * Returns the number of circ trans histories where companyId = &#63; and patronId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param patronId the patron ID
	 * @return the number of matching circ trans histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPatron(long companyId, long patronId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PATRON;

		Object[] finderArgs = new Object[] { companyId, patronId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CIRCTRANSHISTORY_WHERE);

			query.append(_FINDER_COLUMN_PATRON_COMPANYID_2);

			query.append(_FINDER_COLUMN_PATRON_PATRONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(patronId);

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

	private static final String _FINDER_COLUMN_PATRON_COMPANYID_2 = "circTransHistory.companyId = ? AND ";
	private static final String _FINDER_COLUMN_PATRON_PATRONID_2 = "circTransHistory.patronId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATALOGITEM =
		new FinderPath(CircTransHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CircTransHistoryModelImpl.FINDER_CACHE_ENABLED,
			CircTransHistoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCatalogItem",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATALOGITEM =
		new FinderPath(CircTransHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CircTransHistoryModelImpl.FINDER_CACHE_ENABLED,
			CircTransHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCatalogItem",
			new String[] { Long.class.getName(), Long.class.getName() },
			CircTransHistoryModelImpl.COMPANYID_COLUMN_BITMASK |
			CircTransHistoryModelImpl.CATALOGITEMID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATALOGITEM = new FinderPath(CircTransHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CircTransHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCatalogItem",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the circ trans histories where companyId = &#63; and catalogItemId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param catalogItemId the catalog item ID
	 * @return the matching circ trans histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CircTransHistory> findByCatalogItem(long companyId,
		long catalogItemId) throws SystemException {
		return findByCatalogItem(companyId, catalogItemId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the circ trans histories where companyId = &#63; and catalogItemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CircTransHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param catalogItemId the catalog item ID
	 * @param start the lower bound of the range of circ trans histories
	 * @param end the upper bound of the range of circ trans histories (not inclusive)
	 * @return the range of matching circ trans histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CircTransHistory> findByCatalogItem(long companyId,
		long catalogItemId, int start, int end) throws SystemException {
		return findByCatalogItem(companyId, catalogItemId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the circ trans histories where companyId = &#63; and catalogItemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CircTransHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param catalogItemId the catalog item ID
	 * @param start the lower bound of the range of circ trans histories
	 * @param end the upper bound of the range of circ trans histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching circ trans histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CircTransHistory> findByCatalogItem(long companyId,
		long catalogItemId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATALOGITEM;
			finderArgs = new Object[] { companyId, catalogItemId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATALOGITEM;
			finderArgs = new Object[] {
					companyId, catalogItemId,
					
					start, end, orderByComparator
				};
		}

		List<CircTransHistory> list = (List<CircTransHistory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CircTransHistory circTransHistory : list) {
				if ((companyId != circTransHistory.getCompanyId()) ||
						(catalogItemId != circTransHistory.getCatalogItemId())) {
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

			query.append(_SQL_SELECT_CIRCTRANSHISTORY_WHERE);

			query.append(_FINDER_COLUMN_CATALOGITEM_COMPANYID_2);

			query.append(_FINDER_COLUMN_CATALOGITEM_CATALOGITEMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CircTransHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(catalogItemId);

				if (!pagination) {
					list = (List<CircTransHistory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CircTransHistory>(list);
				}
				else {
					list = (List<CircTransHistory>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first circ trans history in the ordered set where companyId = &#63; and catalogItemId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param catalogItemId the catalog item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching circ trans history
	 * @throws com.kencana.lms.NoSuchCircTransHistoryException if a matching circ trans history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CircTransHistory findByCatalogItem_First(long companyId,
		long catalogItemId, OrderByComparator orderByComparator)
		throws NoSuchCircTransHistoryException, SystemException {
		CircTransHistory circTransHistory = fetchByCatalogItem_First(companyId,
				catalogItemId, orderByComparator);

		if (circTransHistory != null) {
			return circTransHistory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", catalogItemId=");
		msg.append(catalogItemId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCircTransHistoryException(msg.toString());
	}

	/**
	 * Returns the first circ trans history in the ordered set where companyId = &#63; and catalogItemId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param catalogItemId the catalog item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching circ trans history, or <code>null</code> if a matching circ trans history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CircTransHistory fetchByCatalogItem_First(long companyId,
		long catalogItemId, OrderByComparator orderByComparator)
		throws SystemException {
		List<CircTransHistory> list = findByCatalogItem(companyId,
				catalogItemId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last circ trans history in the ordered set where companyId = &#63; and catalogItemId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param catalogItemId the catalog item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching circ trans history
	 * @throws com.kencana.lms.NoSuchCircTransHistoryException if a matching circ trans history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CircTransHistory findByCatalogItem_Last(long companyId,
		long catalogItemId, OrderByComparator orderByComparator)
		throws NoSuchCircTransHistoryException, SystemException {
		CircTransHistory circTransHistory = fetchByCatalogItem_Last(companyId,
				catalogItemId, orderByComparator);

		if (circTransHistory != null) {
			return circTransHistory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", catalogItemId=");
		msg.append(catalogItemId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCircTransHistoryException(msg.toString());
	}

	/**
	 * Returns the last circ trans history in the ordered set where companyId = &#63; and catalogItemId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param catalogItemId the catalog item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching circ trans history, or <code>null</code> if a matching circ trans history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CircTransHistory fetchByCatalogItem_Last(long companyId,
		long catalogItemId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCatalogItem(companyId, catalogItemId);

		if (count == 0) {
			return null;
		}

		List<CircTransHistory> list = findByCatalogItem(companyId,
				catalogItemId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the circ trans histories before and after the current circ trans history in the ordered set where companyId = &#63; and catalogItemId = &#63;.
	 *
	 * @param transId the primary key of the current circ trans history
	 * @param companyId the company ID
	 * @param catalogItemId the catalog item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next circ trans history
	 * @throws com.kencana.lms.NoSuchCircTransHistoryException if a circ trans history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CircTransHistory[] findByCatalogItem_PrevAndNext(long transId,
		long companyId, long catalogItemId, OrderByComparator orderByComparator)
		throws NoSuchCircTransHistoryException, SystemException {
		CircTransHistory circTransHistory = findByPrimaryKey(transId);

		Session session = null;

		try {
			session = openSession();

			CircTransHistory[] array = new CircTransHistoryImpl[3];

			array[0] = getByCatalogItem_PrevAndNext(session, circTransHistory,
					companyId, catalogItemId, orderByComparator, true);

			array[1] = circTransHistory;

			array[2] = getByCatalogItem_PrevAndNext(session, circTransHistory,
					companyId, catalogItemId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CircTransHistory getByCatalogItem_PrevAndNext(Session session,
		CircTransHistory circTransHistory, long companyId, long catalogItemId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CIRCTRANSHISTORY_WHERE);

		query.append(_FINDER_COLUMN_CATALOGITEM_COMPANYID_2);

		query.append(_FINDER_COLUMN_CATALOGITEM_CATALOGITEMID_2);

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
			query.append(CircTransHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(catalogItemId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(circTransHistory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CircTransHistory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the circ trans histories where companyId = &#63; and catalogItemId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param catalogItemId the catalog item ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCatalogItem(long companyId, long catalogItemId)
		throws SystemException {
		for (CircTransHistory circTransHistory : findByCatalogItem(companyId,
				catalogItemId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(circTransHistory);
		}
	}

	/**
	 * Returns the number of circ trans histories where companyId = &#63; and catalogItemId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param catalogItemId the catalog item ID
	 * @return the number of matching circ trans histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCatalogItem(long companyId, long catalogItemId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATALOGITEM;

		Object[] finderArgs = new Object[] { companyId, catalogItemId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CIRCTRANSHISTORY_WHERE);

			query.append(_FINDER_COLUMN_CATALOGITEM_COMPANYID_2);

			query.append(_FINDER_COLUMN_CATALOGITEM_CATALOGITEMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(catalogItemId);

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

	private static final String _FINDER_COLUMN_CATALOGITEM_COMPANYID_2 = "circTransHistory.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CATALOGITEM_CATALOGITEMID_2 = "circTransHistory.catalogItemId = ?";

	public CircTransHistoryPersistenceImpl() {
		setModelClass(CircTransHistory.class);
	}

	/**
	 * Caches the circ trans history in the entity cache if it is enabled.
	 *
	 * @param circTransHistory the circ trans history
	 */
	@Override
	public void cacheResult(CircTransHistory circTransHistory) {
		EntityCacheUtil.putResult(CircTransHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CircTransHistoryImpl.class, circTransHistory.getPrimaryKey(),
			circTransHistory);

		circTransHistory.resetOriginalValues();
	}

	/**
	 * Caches the circ trans histories in the entity cache if it is enabled.
	 *
	 * @param circTransHistories the circ trans histories
	 */
	@Override
	public void cacheResult(List<CircTransHistory> circTransHistories) {
		for (CircTransHistory circTransHistory : circTransHistories) {
			if (EntityCacheUtil.getResult(
						CircTransHistoryModelImpl.ENTITY_CACHE_ENABLED,
						CircTransHistoryImpl.class,
						circTransHistory.getPrimaryKey()) == null) {
				cacheResult(circTransHistory);
			}
			else {
				circTransHistory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all circ trans histories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CircTransHistoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CircTransHistoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the circ trans history.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CircTransHistory circTransHistory) {
		EntityCacheUtil.removeResult(CircTransHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CircTransHistoryImpl.class, circTransHistory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CircTransHistory> circTransHistories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CircTransHistory circTransHistory : circTransHistories) {
			EntityCacheUtil.removeResult(CircTransHistoryModelImpl.ENTITY_CACHE_ENABLED,
				CircTransHistoryImpl.class, circTransHistory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new circ trans history with the primary key. Does not add the circ trans history to the database.
	 *
	 * @param transId the primary key for the new circ trans history
	 * @return the new circ trans history
	 */
	@Override
	public CircTransHistory create(long transId) {
		CircTransHistory circTransHistory = new CircTransHistoryImpl();

		circTransHistory.setNew(true);
		circTransHistory.setPrimaryKey(transId);

		return circTransHistory;
	}

	/**
	 * Removes the circ trans history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param transId the primary key of the circ trans history
	 * @return the circ trans history that was removed
	 * @throws com.kencana.lms.NoSuchCircTransHistoryException if a circ trans history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CircTransHistory remove(long transId)
		throws NoSuchCircTransHistoryException, SystemException {
		return remove((Serializable)transId);
	}

	/**
	 * Removes the circ trans history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the circ trans history
	 * @return the circ trans history that was removed
	 * @throws com.kencana.lms.NoSuchCircTransHistoryException if a circ trans history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CircTransHistory remove(Serializable primaryKey)
		throws NoSuchCircTransHistoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CircTransHistory circTransHistory = (CircTransHistory)session.get(CircTransHistoryImpl.class,
					primaryKey);

			if (circTransHistory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCircTransHistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(circTransHistory);
		}
		catch (NoSuchCircTransHistoryException nsee) {
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
	protected CircTransHistory removeImpl(CircTransHistory circTransHistory)
		throws SystemException {
		circTransHistory = toUnwrappedModel(circTransHistory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(circTransHistory)) {
				circTransHistory = (CircTransHistory)session.get(CircTransHistoryImpl.class,
						circTransHistory.getPrimaryKeyObj());
			}

			if (circTransHistory != null) {
				session.delete(circTransHistory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (circTransHistory != null) {
			clearCache(circTransHistory);
		}

		return circTransHistory;
	}

	@Override
	public CircTransHistory updateImpl(
		com.kencana.lms.model.CircTransHistory circTransHistory)
		throws SystemException {
		circTransHistory = toUnwrappedModel(circTransHistory);

		boolean isNew = circTransHistory.isNew();

		CircTransHistoryModelImpl circTransHistoryModelImpl = (CircTransHistoryModelImpl)circTransHistory;

		Session session = null;

		try {
			session = openSession();

			if (circTransHistory.isNew()) {
				session.save(circTransHistory);

				circTransHistory.setNew(false);
			}
			else {
				session.merge(circTransHistory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CircTransHistoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((circTransHistoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						circTransHistoryModelImpl.getOriginalCompanyId(),
						circTransHistoryModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);

				args = new Object[] {
						circTransHistoryModelImpl.getCompanyId(),
						circTransHistoryModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);
			}

			if ((circTransHistoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUPLIBRARY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						circTransHistoryModelImpl.getOriginalCompanyId(),
						circTransHistoryModelImpl.getOriginalGroupId(),
						circTransHistoryModelImpl.getOriginalLibraryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUPLIBRARY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUPLIBRARY,
					args);

				args = new Object[] {
						circTransHistoryModelImpl.getCompanyId(),
						circTransHistoryModelImpl.getGroupId(),
						circTransHistoryModelImpl.getLibraryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUPLIBRARY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUPLIBRARY,
					args);
			}

			if ((circTransHistoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PATRON.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						circTransHistoryModelImpl.getOriginalCompanyId(),
						circTransHistoryModelImpl.getOriginalPatronId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PATRON, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PATRON,
					args);

				args = new Object[] {
						circTransHistoryModelImpl.getCompanyId(),
						circTransHistoryModelImpl.getPatronId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PATRON, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PATRON,
					args);
			}

			if ((circTransHistoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATALOGITEM.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						circTransHistoryModelImpl.getOriginalCompanyId(),
						circTransHistoryModelImpl.getOriginalCatalogItemId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATALOGITEM,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATALOGITEM,
					args);

				args = new Object[] {
						circTransHistoryModelImpl.getCompanyId(),
						circTransHistoryModelImpl.getCatalogItemId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATALOGITEM,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATALOGITEM,
					args);
			}
		}

		EntityCacheUtil.putResult(CircTransHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CircTransHistoryImpl.class, circTransHistory.getPrimaryKey(),
			circTransHistory);

		return circTransHistory;
	}

	protected CircTransHistory toUnwrappedModel(
		CircTransHistory circTransHistory) {
		if (circTransHistory instanceof CircTransHistoryImpl) {
			return circTransHistory;
		}

		CircTransHistoryImpl circTransHistoryImpl = new CircTransHistoryImpl();

		circTransHistoryImpl.setNew(circTransHistory.isNew());
		circTransHistoryImpl.setPrimaryKey(circTransHistory.getPrimaryKey());

		circTransHistoryImpl.setTransId(circTransHistory.getTransId());
		circTransHistoryImpl.setCompanyId(circTransHistory.getCompanyId());
		circTransHistoryImpl.setGroupId(circTransHistory.getGroupId());
		circTransHistoryImpl.setLibraryId(circTransHistory.getLibraryId());
		circTransHistoryImpl.setPatronId(circTransHistory.getPatronId());
		circTransHistoryImpl.setCatalogItemId(circTransHistory.getCatalogItemId());
		circTransHistoryImpl.setTransDate(circTransHistory.getTransDate());
		circTransHistoryImpl.setDueDate(circTransHistory.getDueDate());
		circTransHistoryImpl.setOverdue(circTransHistory.isOverdue());
		circTransHistoryImpl.setReturnDate(circTransHistory.getReturnDate());
		circTransHistoryImpl.setLastRenewDate(circTransHistory.getLastRenewDate());
		circTransHistoryImpl.setRenewCount(circTransHistory.getRenewCount());
		circTransHistoryImpl.setFineAmount(circTransHistory.getFineAmount());

		return circTransHistoryImpl;
	}

	/**
	 * Returns the circ trans history with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the circ trans history
	 * @return the circ trans history
	 * @throws com.kencana.lms.NoSuchCircTransHistoryException if a circ trans history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CircTransHistory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCircTransHistoryException, SystemException {
		CircTransHistory circTransHistory = fetchByPrimaryKey(primaryKey);

		if (circTransHistory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCircTransHistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return circTransHistory;
	}

	/**
	 * Returns the circ trans history with the primary key or throws a {@link com.kencana.lms.NoSuchCircTransHistoryException} if it could not be found.
	 *
	 * @param transId the primary key of the circ trans history
	 * @return the circ trans history
	 * @throws com.kencana.lms.NoSuchCircTransHistoryException if a circ trans history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CircTransHistory findByPrimaryKey(long transId)
		throws NoSuchCircTransHistoryException, SystemException {
		return findByPrimaryKey((Serializable)transId);
	}

	/**
	 * Returns the circ trans history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the circ trans history
	 * @return the circ trans history, or <code>null</code> if a circ trans history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CircTransHistory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CircTransHistory circTransHistory = (CircTransHistory)EntityCacheUtil.getResult(CircTransHistoryModelImpl.ENTITY_CACHE_ENABLED,
				CircTransHistoryImpl.class, primaryKey);

		if (circTransHistory == _nullCircTransHistory) {
			return null;
		}

		if (circTransHistory == null) {
			Session session = null;

			try {
				session = openSession();

				circTransHistory = (CircTransHistory)session.get(CircTransHistoryImpl.class,
						primaryKey);

				if (circTransHistory != null) {
					cacheResult(circTransHistory);
				}
				else {
					EntityCacheUtil.putResult(CircTransHistoryModelImpl.ENTITY_CACHE_ENABLED,
						CircTransHistoryImpl.class, primaryKey,
						_nullCircTransHistory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CircTransHistoryModelImpl.ENTITY_CACHE_ENABLED,
					CircTransHistoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return circTransHistory;
	}

	/**
	 * Returns the circ trans history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param transId the primary key of the circ trans history
	 * @return the circ trans history, or <code>null</code> if a circ trans history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CircTransHistory fetchByPrimaryKey(long transId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)transId);
	}

	/**
	 * Returns all the circ trans histories.
	 *
	 * @return the circ trans histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CircTransHistory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the circ trans histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CircTransHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of circ trans histories
	 * @param end the upper bound of the range of circ trans histories (not inclusive)
	 * @return the range of circ trans histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CircTransHistory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the circ trans histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CircTransHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of circ trans histories
	 * @param end the upper bound of the range of circ trans histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of circ trans histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CircTransHistory> findAll(int start, int end,
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

		List<CircTransHistory> list = (List<CircTransHistory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CIRCTRANSHISTORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CIRCTRANSHISTORY;

				if (pagination) {
					sql = sql.concat(CircTransHistoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CircTransHistory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CircTransHistory>(list);
				}
				else {
					list = (List<CircTransHistory>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the circ trans histories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CircTransHistory circTransHistory : findAll()) {
			remove(circTransHistory);
		}
	}

	/**
	 * Returns the number of circ trans histories.
	 *
	 * @return the number of circ trans histories
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

				Query q = session.createQuery(_SQL_COUNT_CIRCTRANSHISTORY);

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
	 * Initializes the circ trans history persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.kencana.lms.model.CircTransHistory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CircTransHistory>> listenersList = new ArrayList<ModelListener<CircTransHistory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CircTransHistory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CircTransHistoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CIRCTRANSHISTORY = "SELECT circTransHistory FROM CircTransHistory circTransHistory";
	private static final String _SQL_SELECT_CIRCTRANSHISTORY_WHERE = "SELECT circTransHistory FROM CircTransHistory circTransHistory WHERE ";
	private static final String _SQL_COUNT_CIRCTRANSHISTORY = "SELECT COUNT(circTransHistory) FROM CircTransHistory circTransHistory";
	private static final String _SQL_COUNT_CIRCTRANSHISTORY_WHERE = "SELECT COUNT(circTransHistory) FROM CircTransHistory circTransHistory WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "circTransHistory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CircTransHistory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CircTransHistory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CircTransHistoryPersistenceImpl.class);
	private static CircTransHistory _nullCircTransHistory = new CircTransHistoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CircTransHistory> toCacheModel() {
				return _nullCircTransHistoryCacheModel;
			}
		};

	private static CacheModel<CircTransHistory> _nullCircTransHistoryCacheModel = new CacheModel<CircTransHistory>() {
			@Override
			public CircTransHistory toEntityModel() {
				return _nullCircTransHistory;
			}
		};
}