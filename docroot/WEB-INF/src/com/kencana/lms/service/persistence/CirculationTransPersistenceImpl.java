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

import com.kencana.lms.NoSuchCirculationTransException;
import com.kencana.lms.model.CirculationTrans;
import com.kencana.lms.model.impl.CirculationTransImpl;
import com.kencana.lms.model.impl.CirculationTransModelImpl;

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
 * The persistence implementation for the circulation trans service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see CirculationTransPersistence
 * @see CirculationTransUtil
 * @generated
 */
public class CirculationTransPersistenceImpl extends BasePersistenceImpl<CirculationTrans>
	implements CirculationTransPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CirculationTransUtil} to access the circulation trans persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CirculationTransImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CirculationTransModelImpl.ENTITY_CACHE_ENABLED,
			CirculationTransModelImpl.FINDER_CACHE_ENABLED,
			CirculationTransImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CirculationTransModelImpl.ENTITY_CACHE_ENABLED,
			CirculationTransModelImpl.FINDER_CACHE_ENABLED,
			CirculationTransImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CirculationTransModelImpl.ENTITY_CACHE_ENABLED,
			CirculationTransModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PATRONID = new FinderPath(CirculationTransModelImpl.ENTITY_CACHE_ENABLED,
			CirculationTransModelImpl.FINDER_CACHE_ENABLED,
			CirculationTransImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPatronId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PATRONID =
		new FinderPath(CirculationTransModelImpl.ENTITY_CACHE_ENABLED,
			CirculationTransModelImpl.FINDER_CACHE_ENABLED,
			CirculationTransImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPatronId",
			new String[] { Long.class.getName() },
			CirculationTransModelImpl.PATRONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PATRONID = new FinderPath(CirculationTransModelImpl.ENTITY_CACHE_ENABLED,
			CirculationTransModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPatronId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the circulation transes where patronId = &#63;.
	 *
	 * @param patronId the patron ID
	 * @return the matching circulation transes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CirculationTrans> findByPatronId(long patronId)
		throws SystemException {
		return findByPatronId(patronId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the circulation transes where patronId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationTransModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param patronId the patron ID
	 * @param start the lower bound of the range of circulation transes
	 * @param end the upper bound of the range of circulation transes (not inclusive)
	 * @return the range of matching circulation transes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CirculationTrans> findByPatronId(long patronId, int start,
		int end) throws SystemException {
		return findByPatronId(patronId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the circulation transes where patronId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationTransModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param patronId the patron ID
	 * @param start the lower bound of the range of circulation transes
	 * @param end the upper bound of the range of circulation transes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching circulation transes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CirculationTrans> findByPatronId(long patronId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PATRONID;
			finderArgs = new Object[] { patronId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PATRONID;
			finderArgs = new Object[] { patronId, start, end, orderByComparator };
		}

		List<CirculationTrans> list = (List<CirculationTrans>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CirculationTrans circulationTrans : list) {
				if ((patronId != circulationTrans.getPatronId())) {
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

			query.append(_SQL_SELECT_CIRCULATIONTRANS_WHERE);

			query.append(_FINDER_COLUMN_PATRONID_PATRONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CirculationTransModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(patronId);

				if (!pagination) {
					list = (List<CirculationTrans>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CirculationTrans>(list);
				}
				else {
					list = (List<CirculationTrans>)QueryUtil.list(q,
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
	 * Returns the first circulation trans in the ordered set where patronId = &#63;.
	 *
	 * @param patronId the patron ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching circulation trans
	 * @throws com.kencana.lms.NoSuchCirculationTransException if a matching circulation trans could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationTrans findByPatronId_First(long patronId,
		OrderByComparator orderByComparator)
		throws NoSuchCirculationTransException, SystemException {
		CirculationTrans circulationTrans = fetchByPatronId_First(patronId,
				orderByComparator);

		if (circulationTrans != null) {
			return circulationTrans;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("patronId=");
		msg.append(patronId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCirculationTransException(msg.toString());
	}

	/**
	 * Returns the first circulation trans in the ordered set where patronId = &#63;.
	 *
	 * @param patronId the patron ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching circulation trans, or <code>null</code> if a matching circulation trans could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationTrans fetchByPatronId_First(long patronId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CirculationTrans> list = findByPatronId(patronId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last circulation trans in the ordered set where patronId = &#63;.
	 *
	 * @param patronId the patron ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching circulation trans
	 * @throws com.kencana.lms.NoSuchCirculationTransException if a matching circulation trans could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationTrans findByPatronId_Last(long patronId,
		OrderByComparator orderByComparator)
		throws NoSuchCirculationTransException, SystemException {
		CirculationTrans circulationTrans = fetchByPatronId_Last(patronId,
				orderByComparator);

		if (circulationTrans != null) {
			return circulationTrans;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("patronId=");
		msg.append(patronId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCirculationTransException(msg.toString());
	}

	/**
	 * Returns the last circulation trans in the ordered set where patronId = &#63;.
	 *
	 * @param patronId the patron ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching circulation trans, or <code>null</code> if a matching circulation trans could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationTrans fetchByPatronId_Last(long patronId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPatronId(patronId);

		if (count == 0) {
			return null;
		}

		List<CirculationTrans> list = findByPatronId(patronId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the circulation transes before and after the current circulation trans in the ordered set where patronId = &#63;.
	 *
	 * @param transId the primary key of the current circulation trans
	 * @param patronId the patron ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next circulation trans
	 * @throws com.kencana.lms.NoSuchCirculationTransException if a circulation trans with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationTrans[] findByPatronId_PrevAndNext(long transId,
		long patronId, OrderByComparator orderByComparator)
		throws NoSuchCirculationTransException, SystemException {
		CirculationTrans circulationTrans = findByPrimaryKey(transId);

		Session session = null;

		try {
			session = openSession();

			CirculationTrans[] array = new CirculationTransImpl[3];

			array[0] = getByPatronId_PrevAndNext(session, circulationTrans,
					patronId, orderByComparator, true);

			array[1] = circulationTrans;

			array[2] = getByPatronId_PrevAndNext(session, circulationTrans,
					patronId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CirculationTrans getByPatronId_PrevAndNext(Session session,
		CirculationTrans circulationTrans, long patronId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CIRCULATIONTRANS_WHERE);

		query.append(_FINDER_COLUMN_PATRONID_PATRONID_2);

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
			query.append(CirculationTransModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(patronId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(circulationTrans);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CirculationTrans> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the circulation transes where patronId = &#63; from the database.
	 *
	 * @param patronId the patron ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPatronId(long patronId) throws SystemException {
		for (CirculationTrans circulationTrans : findByPatronId(patronId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(circulationTrans);
		}
	}

	/**
	 * Returns the number of circulation transes where patronId = &#63;.
	 *
	 * @param patronId the patron ID
	 * @return the number of matching circulation transes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPatronId(long patronId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PATRONID;

		Object[] finderArgs = new Object[] { patronId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CIRCULATIONTRANS_WHERE);

			query.append(_FINDER_COLUMN_PATRONID_PATRONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_PATRONID_PATRONID_2 = "circulationTrans.patronId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(CirculationTransModelImpl.ENTITY_CACHE_ENABLED,
			CirculationTransModelImpl.FINDER_CACHE_ENABLED,
			CirculationTransImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompanyGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(CirculationTransModelImpl.ENTITY_CACHE_ENABLED,
			CirculationTransModelImpl.FINDER_CACHE_ENABLED,
			CirculationTransImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			CirculationTransModelImpl.COMPANYID_COLUMN_BITMASK |
			CirculationTransModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYGROUP = new FinderPath(CirculationTransModelImpl.ENTITY_CACHE_ENABLED,
			CirculationTransModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the circulation transes where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching circulation transes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CirculationTrans> findByCompanyGroup(long companyId,
		long groupId) throws SystemException {
		return findByCompanyGroup(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the circulation transes where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationTransModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of circulation transes
	 * @param end the upper bound of the range of circulation transes (not inclusive)
	 * @return the range of matching circulation transes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CirculationTrans> findByCompanyGroup(long companyId,
		long groupId, int start, int end) throws SystemException {
		return findByCompanyGroup(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the circulation transes where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationTransModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of circulation transes
	 * @param end the upper bound of the range of circulation transes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching circulation transes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CirculationTrans> findByCompanyGroup(long companyId,
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

		List<CirculationTrans> list = (List<CirculationTrans>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CirculationTrans circulationTrans : list) {
				if ((companyId != circulationTrans.getCompanyId()) ||
						(groupId != circulationTrans.getGroupId())) {
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

			query.append(_SQL_SELECT_CIRCULATIONTRANS_WHERE);

			query.append(_FINDER_COLUMN_COMPANYGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CirculationTransModelImpl.ORDER_BY_JPQL);
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
					list = (List<CirculationTrans>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CirculationTrans>(list);
				}
				else {
					list = (List<CirculationTrans>)QueryUtil.list(q,
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
	 * Returns the first circulation trans in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching circulation trans
	 * @throws com.kencana.lms.NoSuchCirculationTransException if a matching circulation trans could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationTrans findByCompanyGroup_First(long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCirculationTransException, SystemException {
		CirculationTrans circulationTrans = fetchByCompanyGroup_First(companyId,
				groupId, orderByComparator);

		if (circulationTrans != null) {
			return circulationTrans;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCirculationTransException(msg.toString());
	}

	/**
	 * Returns the first circulation trans in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching circulation trans, or <code>null</code> if a matching circulation trans could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationTrans fetchByCompanyGroup_First(long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<CirculationTrans> list = findByCompanyGroup(companyId, groupId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last circulation trans in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching circulation trans
	 * @throws com.kencana.lms.NoSuchCirculationTransException if a matching circulation trans could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationTrans findByCompanyGroup_Last(long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCirculationTransException, SystemException {
		CirculationTrans circulationTrans = fetchByCompanyGroup_Last(companyId,
				groupId, orderByComparator);

		if (circulationTrans != null) {
			return circulationTrans;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCirculationTransException(msg.toString());
	}

	/**
	 * Returns the last circulation trans in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching circulation trans, or <code>null</code> if a matching circulation trans could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationTrans fetchByCompanyGroup_Last(long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCompanyGroup(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<CirculationTrans> list = findByCompanyGroup(companyId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the circulation transes before and after the current circulation trans in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param transId the primary key of the current circulation trans
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next circulation trans
	 * @throws com.kencana.lms.NoSuchCirculationTransException if a circulation trans with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationTrans[] findByCompanyGroup_PrevAndNext(long transId,
		long companyId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchCirculationTransException, SystemException {
		CirculationTrans circulationTrans = findByPrimaryKey(transId);

		Session session = null;

		try {
			session = openSession();

			CirculationTrans[] array = new CirculationTransImpl[3];

			array[0] = getByCompanyGroup_PrevAndNext(session, circulationTrans,
					companyId, groupId, orderByComparator, true);

			array[1] = circulationTrans;

			array[2] = getByCompanyGroup_PrevAndNext(session, circulationTrans,
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

	protected CirculationTrans getByCompanyGroup_PrevAndNext(Session session,
		CirculationTrans circulationTrans, long companyId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CIRCULATIONTRANS_WHERE);

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
			query.append(CirculationTransModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(circulationTrans);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CirculationTrans> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the circulation transes where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyGroup(long companyId, long groupId)
		throws SystemException {
		for (CirculationTrans circulationTrans : findByCompanyGroup(companyId,
				groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(circulationTrans);
		}
	}

	/**
	 * Returns the number of circulation transes where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching circulation transes
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

			query.append(_SQL_COUNT_CIRCULATIONTRANS_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANYGROUP_COMPANYID_2 = "circulationTrans.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYGROUP_GROUPID_2 = "circulationTrans.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYGROUPLIBRARY =
		new FinderPath(CirculationTransModelImpl.ENTITY_CACHE_ENABLED,
			CirculationTransModelImpl.FINDER_CACHE_ENABLED,
			CirculationTransImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompanyGroupLibrary",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUPLIBRARY =
		new FinderPath(CirculationTransModelImpl.ENTITY_CACHE_ENABLED,
			CirculationTransModelImpl.FINDER_CACHE_ENABLED,
			CirculationTransImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCompanyGroupLibrary",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			CirculationTransModelImpl.COMPANYID_COLUMN_BITMASK |
			CirculationTransModelImpl.GROUPID_COLUMN_BITMASK |
			CirculationTransModelImpl.LIBRARYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYGROUPLIBRARY = new FinderPath(CirculationTransModelImpl.ENTITY_CACHE_ENABLED,
			CirculationTransModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCompanyGroupLibrary",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the circulation transes where companyId = &#63; and groupId = &#63; and libraryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param libraryId the library ID
	 * @return the matching circulation transes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CirculationTrans> findByCompanyGroupLibrary(long companyId,
		long groupId, long libraryId) throws SystemException {
		return findByCompanyGroupLibrary(companyId, groupId, libraryId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the circulation transes where companyId = &#63; and groupId = &#63; and libraryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationTransModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param libraryId the library ID
	 * @param start the lower bound of the range of circulation transes
	 * @param end the upper bound of the range of circulation transes (not inclusive)
	 * @return the range of matching circulation transes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CirculationTrans> findByCompanyGroupLibrary(long companyId,
		long groupId, long libraryId, int start, int end)
		throws SystemException {
		return findByCompanyGroupLibrary(companyId, groupId, libraryId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the circulation transes where companyId = &#63; and groupId = &#63; and libraryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationTransModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param libraryId the library ID
	 * @param start the lower bound of the range of circulation transes
	 * @param end the upper bound of the range of circulation transes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching circulation transes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CirculationTrans> findByCompanyGroupLibrary(long companyId,
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

		List<CirculationTrans> list = (List<CirculationTrans>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CirculationTrans circulationTrans : list) {
				if ((companyId != circulationTrans.getCompanyId()) ||
						(groupId != circulationTrans.getGroupId()) ||
						(libraryId != circulationTrans.getLibraryId())) {
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

			query.append(_SQL_SELECT_CIRCULATIONTRANS_WHERE);

			query.append(_FINDER_COLUMN_COMPANYGROUPLIBRARY_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUPLIBRARY_GROUPID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUPLIBRARY_LIBRARYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CirculationTransModelImpl.ORDER_BY_JPQL);
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
					list = (List<CirculationTrans>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CirculationTrans>(list);
				}
				else {
					list = (List<CirculationTrans>)QueryUtil.list(q,
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
	 * Returns the first circulation trans in the ordered set where companyId = &#63; and groupId = &#63; and libraryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching circulation trans
	 * @throws com.kencana.lms.NoSuchCirculationTransException if a matching circulation trans could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationTrans findByCompanyGroupLibrary_First(long companyId,
		long groupId, long libraryId, OrderByComparator orderByComparator)
		throws NoSuchCirculationTransException, SystemException {
		CirculationTrans circulationTrans = fetchByCompanyGroupLibrary_First(companyId,
				groupId, libraryId, orderByComparator);

		if (circulationTrans != null) {
			return circulationTrans;
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

		throw new NoSuchCirculationTransException(msg.toString());
	}

	/**
	 * Returns the first circulation trans in the ordered set where companyId = &#63; and groupId = &#63; and libraryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching circulation trans, or <code>null</code> if a matching circulation trans could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationTrans fetchByCompanyGroupLibrary_First(long companyId,
		long groupId, long libraryId, OrderByComparator orderByComparator)
		throws SystemException {
		List<CirculationTrans> list = findByCompanyGroupLibrary(companyId,
				groupId, libraryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last circulation trans in the ordered set where companyId = &#63; and groupId = &#63; and libraryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching circulation trans
	 * @throws com.kencana.lms.NoSuchCirculationTransException if a matching circulation trans could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationTrans findByCompanyGroupLibrary_Last(long companyId,
		long groupId, long libraryId, OrderByComparator orderByComparator)
		throws NoSuchCirculationTransException, SystemException {
		CirculationTrans circulationTrans = fetchByCompanyGroupLibrary_Last(companyId,
				groupId, libraryId, orderByComparator);

		if (circulationTrans != null) {
			return circulationTrans;
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

		throw new NoSuchCirculationTransException(msg.toString());
	}

	/**
	 * Returns the last circulation trans in the ordered set where companyId = &#63; and groupId = &#63; and libraryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching circulation trans, or <code>null</code> if a matching circulation trans could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationTrans fetchByCompanyGroupLibrary_Last(long companyId,
		long groupId, long libraryId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCompanyGroupLibrary(companyId, groupId, libraryId);

		if (count == 0) {
			return null;
		}

		List<CirculationTrans> list = findByCompanyGroupLibrary(companyId,
				groupId, libraryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the circulation transes before and after the current circulation trans in the ordered set where companyId = &#63; and groupId = &#63; and libraryId = &#63;.
	 *
	 * @param transId the primary key of the current circulation trans
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next circulation trans
	 * @throws com.kencana.lms.NoSuchCirculationTransException if a circulation trans with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationTrans[] findByCompanyGroupLibrary_PrevAndNext(
		long transId, long companyId, long groupId, long libraryId,
		OrderByComparator orderByComparator)
		throws NoSuchCirculationTransException, SystemException {
		CirculationTrans circulationTrans = findByPrimaryKey(transId);

		Session session = null;

		try {
			session = openSession();

			CirculationTrans[] array = new CirculationTransImpl[3];

			array[0] = getByCompanyGroupLibrary_PrevAndNext(session,
					circulationTrans, companyId, groupId, libraryId,
					orderByComparator, true);

			array[1] = circulationTrans;

			array[2] = getByCompanyGroupLibrary_PrevAndNext(session,
					circulationTrans, companyId, groupId, libraryId,
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

	protected CirculationTrans getByCompanyGroupLibrary_PrevAndNext(
		Session session, CirculationTrans circulationTrans, long companyId,
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

		query.append(_SQL_SELECT_CIRCULATIONTRANS_WHERE);

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
			query.append(CirculationTransModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(circulationTrans);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CirculationTrans> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the circulation transes where companyId = &#63; and groupId = &#63; and libraryId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param libraryId the library ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyGroupLibrary(long companyId, long groupId,
		long libraryId) throws SystemException {
		for (CirculationTrans circulationTrans : findByCompanyGroupLibrary(
				companyId, groupId, libraryId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(circulationTrans);
		}
	}

	/**
	 * Returns the number of circulation transes where companyId = &#63; and groupId = &#63; and libraryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param libraryId the library ID
	 * @return the number of matching circulation transes
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

			query.append(_SQL_COUNT_CIRCULATIONTRANS_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANYGROUPLIBRARY_COMPANYID_2 = "circulationTrans.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYGROUPLIBRARY_GROUPID_2 = "circulationTrans.groupId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYGROUPLIBRARY_LIBRARYID_2 = "circulationTrans.libraryId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PATRON = new FinderPath(CirculationTransModelImpl.ENTITY_CACHE_ENABLED,
			CirculationTransModelImpl.FINDER_CACHE_ENABLED,
			CirculationTransImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPatron",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PATRON =
		new FinderPath(CirculationTransModelImpl.ENTITY_CACHE_ENABLED,
			CirculationTransModelImpl.FINDER_CACHE_ENABLED,
			CirculationTransImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPatron",
			new String[] { Long.class.getName(), Long.class.getName() },
			CirculationTransModelImpl.COMPANYID_COLUMN_BITMASK |
			CirculationTransModelImpl.PATRONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PATRON = new FinderPath(CirculationTransModelImpl.ENTITY_CACHE_ENABLED,
			CirculationTransModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPatron",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the circulation transes where companyId = &#63; and patronId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param patronId the patron ID
	 * @return the matching circulation transes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CirculationTrans> findByPatron(long companyId, long patronId)
		throws SystemException {
		return findByPatron(companyId, patronId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the circulation transes where companyId = &#63; and patronId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationTransModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param patronId the patron ID
	 * @param start the lower bound of the range of circulation transes
	 * @param end the upper bound of the range of circulation transes (not inclusive)
	 * @return the range of matching circulation transes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CirculationTrans> findByPatron(long companyId, long patronId,
		int start, int end) throws SystemException {
		return findByPatron(companyId, patronId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the circulation transes where companyId = &#63; and patronId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationTransModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param patronId the patron ID
	 * @param start the lower bound of the range of circulation transes
	 * @param end the upper bound of the range of circulation transes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching circulation transes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CirculationTrans> findByPatron(long companyId, long patronId,
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

		List<CirculationTrans> list = (List<CirculationTrans>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CirculationTrans circulationTrans : list) {
				if ((companyId != circulationTrans.getCompanyId()) ||
						(patronId != circulationTrans.getPatronId())) {
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

			query.append(_SQL_SELECT_CIRCULATIONTRANS_WHERE);

			query.append(_FINDER_COLUMN_PATRON_COMPANYID_2);

			query.append(_FINDER_COLUMN_PATRON_PATRONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CirculationTransModelImpl.ORDER_BY_JPQL);
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
					list = (List<CirculationTrans>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CirculationTrans>(list);
				}
				else {
					list = (List<CirculationTrans>)QueryUtil.list(q,
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
	 * Returns the first circulation trans in the ordered set where companyId = &#63; and patronId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param patronId the patron ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching circulation trans
	 * @throws com.kencana.lms.NoSuchCirculationTransException if a matching circulation trans could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationTrans findByPatron_First(long companyId, long patronId,
		OrderByComparator orderByComparator)
		throws NoSuchCirculationTransException, SystemException {
		CirculationTrans circulationTrans = fetchByPatron_First(companyId,
				patronId, orderByComparator);

		if (circulationTrans != null) {
			return circulationTrans;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", patronId=");
		msg.append(patronId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCirculationTransException(msg.toString());
	}

	/**
	 * Returns the first circulation trans in the ordered set where companyId = &#63; and patronId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param patronId the patron ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching circulation trans, or <code>null</code> if a matching circulation trans could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationTrans fetchByPatron_First(long companyId, long patronId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CirculationTrans> list = findByPatron(companyId, patronId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last circulation trans in the ordered set where companyId = &#63; and patronId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param patronId the patron ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching circulation trans
	 * @throws com.kencana.lms.NoSuchCirculationTransException if a matching circulation trans could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationTrans findByPatron_Last(long companyId, long patronId,
		OrderByComparator orderByComparator)
		throws NoSuchCirculationTransException, SystemException {
		CirculationTrans circulationTrans = fetchByPatron_Last(companyId,
				patronId, orderByComparator);

		if (circulationTrans != null) {
			return circulationTrans;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", patronId=");
		msg.append(patronId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCirculationTransException(msg.toString());
	}

	/**
	 * Returns the last circulation trans in the ordered set where companyId = &#63; and patronId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param patronId the patron ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching circulation trans, or <code>null</code> if a matching circulation trans could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationTrans fetchByPatron_Last(long companyId, long patronId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPatron(companyId, patronId);

		if (count == 0) {
			return null;
		}

		List<CirculationTrans> list = findByPatron(companyId, patronId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the circulation transes before and after the current circulation trans in the ordered set where companyId = &#63; and patronId = &#63;.
	 *
	 * @param transId the primary key of the current circulation trans
	 * @param companyId the company ID
	 * @param patronId the patron ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next circulation trans
	 * @throws com.kencana.lms.NoSuchCirculationTransException if a circulation trans with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationTrans[] findByPatron_PrevAndNext(long transId,
		long companyId, long patronId, OrderByComparator orderByComparator)
		throws NoSuchCirculationTransException, SystemException {
		CirculationTrans circulationTrans = findByPrimaryKey(transId);

		Session session = null;

		try {
			session = openSession();

			CirculationTrans[] array = new CirculationTransImpl[3];

			array[0] = getByPatron_PrevAndNext(session, circulationTrans,
					companyId, patronId, orderByComparator, true);

			array[1] = circulationTrans;

			array[2] = getByPatron_PrevAndNext(session, circulationTrans,
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

	protected CirculationTrans getByPatron_PrevAndNext(Session session,
		CirculationTrans circulationTrans, long companyId, long patronId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CIRCULATIONTRANS_WHERE);

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
			query.append(CirculationTransModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(patronId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(circulationTrans);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CirculationTrans> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the circulation transes where companyId = &#63; and patronId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param patronId the patron ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPatron(long companyId, long patronId)
		throws SystemException {
		for (CirculationTrans circulationTrans : findByPatron(companyId,
				patronId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(circulationTrans);
		}
	}

	/**
	 * Returns the number of circulation transes where companyId = &#63; and patronId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param patronId the patron ID
	 * @return the number of matching circulation transes
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

			query.append(_SQL_COUNT_CIRCULATIONTRANS_WHERE);

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

	private static final String _FINDER_COLUMN_PATRON_COMPANYID_2 = "circulationTrans.companyId = ? AND ";
	private static final String _FINDER_COLUMN_PATRON_PATRONID_2 = "circulationTrans.patronId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_CATALOGITEM = new FinderPath(CirculationTransModelImpl.ENTITY_CACHE_ENABLED,
			CirculationTransModelImpl.FINDER_CACHE_ENABLED,
			CirculationTransImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByCatalogItem",
			new String[] { Long.class.getName(), Long.class.getName() },
			CirculationTransModelImpl.COMPANYID_COLUMN_BITMASK |
			CirculationTransModelImpl.CATALOGITEMID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATALOGITEM = new FinderPath(CirculationTransModelImpl.ENTITY_CACHE_ENABLED,
			CirculationTransModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCatalogItem",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the circulation trans where companyId = &#63; and catalogItemId = &#63; or throws a {@link com.kencana.lms.NoSuchCirculationTransException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param catalogItemId the catalog item ID
	 * @return the matching circulation trans
	 * @throws com.kencana.lms.NoSuchCirculationTransException if a matching circulation trans could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationTrans findByCatalogItem(long companyId, long catalogItemId)
		throws NoSuchCirculationTransException, SystemException {
		CirculationTrans circulationTrans = fetchByCatalogItem(companyId,
				catalogItemId);

		if (circulationTrans == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", catalogItemId=");
			msg.append(catalogItemId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCirculationTransException(msg.toString());
		}

		return circulationTrans;
	}

	/**
	 * Returns the circulation trans where companyId = &#63; and catalogItemId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param catalogItemId the catalog item ID
	 * @return the matching circulation trans, or <code>null</code> if a matching circulation trans could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationTrans fetchByCatalogItem(long companyId,
		long catalogItemId) throws SystemException {
		return fetchByCatalogItem(companyId, catalogItemId, true);
	}

	/**
	 * Returns the circulation trans where companyId = &#63; and catalogItemId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param catalogItemId the catalog item ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching circulation trans, or <code>null</code> if a matching circulation trans could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationTrans fetchByCatalogItem(long companyId,
		long catalogItemId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, catalogItemId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CATALOGITEM,
					finderArgs, this);
		}

		if (result instanceof CirculationTrans) {
			CirculationTrans circulationTrans = (CirculationTrans)result;

			if ((companyId != circulationTrans.getCompanyId()) ||
					(catalogItemId != circulationTrans.getCatalogItemId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CIRCULATIONTRANS_WHERE);

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

				List<CirculationTrans> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CATALOGITEM,
						finderArgs, list);
				}
				else {
					CirculationTrans circulationTrans = list.get(0);

					result = circulationTrans;

					cacheResult(circulationTrans);

					if ((circulationTrans.getCompanyId() != companyId) ||
							(circulationTrans.getCatalogItemId() != catalogItemId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CATALOGITEM,
							finderArgs, circulationTrans);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CATALOGITEM,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (CirculationTrans)result;
		}
	}

	/**
	 * Removes the circulation trans where companyId = &#63; and catalogItemId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param catalogItemId the catalog item ID
	 * @return the circulation trans that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationTrans removeByCatalogItem(long companyId,
		long catalogItemId)
		throws NoSuchCirculationTransException, SystemException {
		CirculationTrans circulationTrans = findByCatalogItem(companyId,
				catalogItemId);

		return remove(circulationTrans);
	}

	/**
	 * Returns the number of circulation transes where companyId = &#63; and catalogItemId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param catalogItemId the catalog item ID
	 * @return the number of matching circulation transes
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

			query.append(_SQL_COUNT_CIRCULATIONTRANS_WHERE);

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

	private static final String _FINDER_COLUMN_CATALOGITEM_COMPANYID_2 = "circulationTrans.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CATALOGITEM_CATALOGITEMID_2 = "circulationTrans.catalogItemId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OVERDUELIBRARY =
		new FinderPath(CirculationTransModelImpl.ENTITY_CACHE_ENABLED,
			CirculationTransModelImpl.FINDER_CACHE_ENABLED,
			CirculationTransImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByOverdueLibrary",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OVERDUELIBRARY =
		new FinderPath(CirculationTransModelImpl.ENTITY_CACHE_ENABLED,
			CirculationTransModelImpl.FINDER_CACHE_ENABLED,
			CirculationTransImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOverdueLibrary",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			CirculationTransModelImpl.COMPANYID_COLUMN_BITMASK |
			CirculationTransModelImpl.LIBRARYID_COLUMN_BITMASK |
			CirculationTransModelImpl.OVERDUE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OVERDUELIBRARY = new FinderPath(CirculationTransModelImpl.ENTITY_CACHE_ENABLED,
			CirculationTransModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOverdueLibrary",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns all the circulation transes where companyId = &#63; and libraryId = &#63; and overdue = &#63;.
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param overdue the overdue
	 * @return the matching circulation transes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CirculationTrans> findByOverdueLibrary(long companyId,
		long libraryId, boolean overdue) throws SystemException {
		return findByOverdueLibrary(companyId, libraryId, overdue,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the circulation transes where companyId = &#63; and libraryId = &#63; and overdue = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationTransModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param overdue the overdue
	 * @param start the lower bound of the range of circulation transes
	 * @param end the upper bound of the range of circulation transes (not inclusive)
	 * @return the range of matching circulation transes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CirculationTrans> findByOverdueLibrary(long companyId,
		long libraryId, boolean overdue, int start, int end)
		throws SystemException {
		return findByOverdueLibrary(companyId, libraryId, overdue, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the circulation transes where companyId = &#63; and libraryId = &#63; and overdue = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationTransModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param overdue the overdue
	 * @param start the lower bound of the range of circulation transes
	 * @param end the upper bound of the range of circulation transes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching circulation transes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CirculationTrans> findByOverdueLibrary(long companyId,
		long libraryId, boolean overdue, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OVERDUELIBRARY;
			finderArgs = new Object[] { companyId, libraryId, overdue };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OVERDUELIBRARY;
			finderArgs = new Object[] {
					companyId, libraryId, overdue,
					
					start, end, orderByComparator
				};
		}

		List<CirculationTrans> list = (List<CirculationTrans>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CirculationTrans circulationTrans : list) {
				if ((companyId != circulationTrans.getCompanyId()) ||
						(libraryId != circulationTrans.getLibraryId()) ||
						(overdue != circulationTrans.getOverdue())) {
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

			query.append(_SQL_SELECT_CIRCULATIONTRANS_WHERE);

			query.append(_FINDER_COLUMN_OVERDUELIBRARY_COMPANYID_2);

			query.append(_FINDER_COLUMN_OVERDUELIBRARY_LIBRARYID_2);

			query.append(_FINDER_COLUMN_OVERDUELIBRARY_OVERDUE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CirculationTransModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(libraryId);

				qPos.add(overdue);

				if (!pagination) {
					list = (List<CirculationTrans>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CirculationTrans>(list);
				}
				else {
					list = (List<CirculationTrans>)QueryUtil.list(q,
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
	 * Returns the first circulation trans in the ordered set where companyId = &#63; and libraryId = &#63; and overdue = &#63;.
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param overdue the overdue
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching circulation trans
	 * @throws com.kencana.lms.NoSuchCirculationTransException if a matching circulation trans could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationTrans findByOverdueLibrary_First(long companyId,
		long libraryId, boolean overdue, OrderByComparator orderByComparator)
		throws NoSuchCirculationTransException, SystemException {
		CirculationTrans circulationTrans = fetchByOverdueLibrary_First(companyId,
				libraryId, overdue, orderByComparator);

		if (circulationTrans != null) {
			return circulationTrans;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", libraryId=");
		msg.append(libraryId);

		msg.append(", overdue=");
		msg.append(overdue);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCirculationTransException(msg.toString());
	}

	/**
	 * Returns the first circulation trans in the ordered set where companyId = &#63; and libraryId = &#63; and overdue = &#63;.
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param overdue the overdue
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching circulation trans, or <code>null</code> if a matching circulation trans could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationTrans fetchByOverdueLibrary_First(long companyId,
		long libraryId, boolean overdue, OrderByComparator orderByComparator)
		throws SystemException {
		List<CirculationTrans> list = findByOverdueLibrary(companyId,
				libraryId, overdue, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last circulation trans in the ordered set where companyId = &#63; and libraryId = &#63; and overdue = &#63;.
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param overdue the overdue
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching circulation trans
	 * @throws com.kencana.lms.NoSuchCirculationTransException if a matching circulation trans could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationTrans findByOverdueLibrary_Last(long companyId,
		long libraryId, boolean overdue, OrderByComparator orderByComparator)
		throws NoSuchCirculationTransException, SystemException {
		CirculationTrans circulationTrans = fetchByOverdueLibrary_Last(companyId,
				libraryId, overdue, orderByComparator);

		if (circulationTrans != null) {
			return circulationTrans;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", libraryId=");
		msg.append(libraryId);

		msg.append(", overdue=");
		msg.append(overdue);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCirculationTransException(msg.toString());
	}

	/**
	 * Returns the last circulation trans in the ordered set where companyId = &#63; and libraryId = &#63; and overdue = &#63;.
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param overdue the overdue
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching circulation trans, or <code>null</code> if a matching circulation trans could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationTrans fetchByOverdueLibrary_Last(long companyId,
		long libraryId, boolean overdue, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByOverdueLibrary(companyId, libraryId, overdue);

		if (count == 0) {
			return null;
		}

		List<CirculationTrans> list = findByOverdueLibrary(companyId,
				libraryId, overdue, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the circulation transes before and after the current circulation trans in the ordered set where companyId = &#63; and libraryId = &#63; and overdue = &#63;.
	 *
	 * @param transId the primary key of the current circulation trans
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param overdue the overdue
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next circulation trans
	 * @throws com.kencana.lms.NoSuchCirculationTransException if a circulation trans with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationTrans[] findByOverdueLibrary_PrevAndNext(long transId,
		long companyId, long libraryId, boolean overdue,
		OrderByComparator orderByComparator)
		throws NoSuchCirculationTransException, SystemException {
		CirculationTrans circulationTrans = findByPrimaryKey(transId);

		Session session = null;

		try {
			session = openSession();

			CirculationTrans[] array = new CirculationTransImpl[3];

			array[0] = getByOverdueLibrary_PrevAndNext(session,
					circulationTrans, companyId, libraryId, overdue,
					orderByComparator, true);

			array[1] = circulationTrans;

			array[2] = getByOverdueLibrary_PrevAndNext(session,
					circulationTrans, companyId, libraryId, overdue,
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

	protected CirculationTrans getByOverdueLibrary_PrevAndNext(
		Session session, CirculationTrans circulationTrans, long companyId,
		long libraryId, boolean overdue, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CIRCULATIONTRANS_WHERE);

		query.append(_FINDER_COLUMN_OVERDUELIBRARY_COMPANYID_2);

		query.append(_FINDER_COLUMN_OVERDUELIBRARY_LIBRARYID_2);

		query.append(_FINDER_COLUMN_OVERDUELIBRARY_OVERDUE_2);

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
			query.append(CirculationTransModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(libraryId);

		qPos.add(overdue);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(circulationTrans);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CirculationTrans> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the circulation transes where companyId = &#63; and libraryId = &#63; and overdue = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param overdue the overdue
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOverdueLibrary(long companyId, long libraryId,
		boolean overdue) throws SystemException {
		for (CirculationTrans circulationTrans : findByOverdueLibrary(
				companyId, libraryId, overdue, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(circulationTrans);
		}
	}

	/**
	 * Returns the number of circulation transes where companyId = &#63; and libraryId = &#63; and overdue = &#63;.
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param overdue the overdue
	 * @return the number of matching circulation transes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOverdueLibrary(long companyId, long libraryId,
		boolean overdue) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OVERDUELIBRARY;

		Object[] finderArgs = new Object[] { companyId, libraryId, overdue };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CIRCULATIONTRANS_WHERE);

			query.append(_FINDER_COLUMN_OVERDUELIBRARY_COMPANYID_2);

			query.append(_FINDER_COLUMN_OVERDUELIBRARY_LIBRARYID_2);

			query.append(_FINDER_COLUMN_OVERDUELIBRARY_OVERDUE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(libraryId);

				qPos.add(overdue);

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

	private static final String _FINDER_COLUMN_OVERDUELIBRARY_COMPANYID_2 = "circulationTrans.companyId = ? AND ";
	private static final String _FINDER_COLUMN_OVERDUELIBRARY_LIBRARYID_2 = "circulationTrans.libraryId = ? AND ";
	private static final String _FINDER_COLUMN_OVERDUELIBRARY_OVERDUE_2 = "circulationTrans.overdue = ?";

	public CirculationTransPersistenceImpl() {
		setModelClass(CirculationTrans.class);
	}

	/**
	 * Caches the circulation trans in the entity cache if it is enabled.
	 *
	 * @param circulationTrans the circulation trans
	 */
	@Override
	public void cacheResult(CirculationTrans circulationTrans) {
		EntityCacheUtil.putResult(CirculationTransModelImpl.ENTITY_CACHE_ENABLED,
			CirculationTransImpl.class, circulationTrans.getPrimaryKey(),
			circulationTrans);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CATALOGITEM,
			new Object[] {
				circulationTrans.getCompanyId(),
				circulationTrans.getCatalogItemId()
			}, circulationTrans);

		circulationTrans.resetOriginalValues();
	}

	/**
	 * Caches the circulation transes in the entity cache if it is enabled.
	 *
	 * @param circulationTranses the circulation transes
	 */
	@Override
	public void cacheResult(List<CirculationTrans> circulationTranses) {
		for (CirculationTrans circulationTrans : circulationTranses) {
			if (EntityCacheUtil.getResult(
						CirculationTransModelImpl.ENTITY_CACHE_ENABLED,
						CirculationTransImpl.class,
						circulationTrans.getPrimaryKey()) == null) {
				cacheResult(circulationTrans);
			}
			else {
				circulationTrans.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all circulation transes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CirculationTransImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CirculationTransImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the circulation trans.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CirculationTrans circulationTrans) {
		EntityCacheUtil.removeResult(CirculationTransModelImpl.ENTITY_CACHE_ENABLED,
			CirculationTransImpl.class, circulationTrans.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(circulationTrans);
	}

	@Override
	public void clearCache(List<CirculationTrans> circulationTranses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CirculationTrans circulationTrans : circulationTranses) {
			EntityCacheUtil.removeResult(CirculationTransModelImpl.ENTITY_CACHE_ENABLED,
				CirculationTransImpl.class, circulationTrans.getPrimaryKey());

			clearUniqueFindersCache(circulationTrans);
		}
	}

	protected void cacheUniqueFindersCache(CirculationTrans circulationTrans) {
		if (circulationTrans.isNew()) {
			Object[] args = new Object[] {
					circulationTrans.getCompanyId(),
					circulationTrans.getCatalogItemId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CATALOGITEM, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CATALOGITEM, args,
				circulationTrans);
		}
		else {
			CirculationTransModelImpl circulationTransModelImpl = (CirculationTransModelImpl)circulationTrans;

			if ((circulationTransModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CATALOGITEM.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						circulationTrans.getCompanyId(),
						circulationTrans.getCatalogItemId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CATALOGITEM,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CATALOGITEM,
					args, circulationTrans);
			}
		}
	}

	protected void clearUniqueFindersCache(CirculationTrans circulationTrans) {
		CirculationTransModelImpl circulationTransModelImpl = (CirculationTransModelImpl)circulationTrans;

		Object[] args = new Object[] {
				circulationTrans.getCompanyId(),
				circulationTrans.getCatalogItemId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATALOGITEM, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CATALOGITEM, args);

		if ((circulationTransModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CATALOGITEM.getColumnBitmask()) != 0) {
			args = new Object[] {
					circulationTransModelImpl.getOriginalCompanyId(),
					circulationTransModelImpl.getOriginalCatalogItemId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATALOGITEM, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CATALOGITEM, args);
		}
	}

	/**
	 * Creates a new circulation trans with the primary key. Does not add the circulation trans to the database.
	 *
	 * @param transId the primary key for the new circulation trans
	 * @return the new circulation trans
	 */
	@Override
	public CirculationTrans create(long transId) {
		CirculationTrans circulationTrans = new CirculationTransImpl();

		circulationTrans.setNew(true);
		circulationTrans.setPrimaryKey(transId);

		return circulationTrans;
	}

	/**
	 * Removes the circulation trans with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param transId the primary key of the circulation trans
	 * @return the circulation trans that was removed
	 * @throws com.kencana.lms.NoSuchCirculationTransException if a circulation trans with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationTrans remove(long transId)
		throws NoSuchCirculationTransException, SystemException {
		return remove((Serializable)transId);
	}

	/**
	 * Removes the circulation trans with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the circulation trans
	 * @return the circulation trans that was removed
	 * @throws com.kencana.lms.NoSuchCirculationTransException if a circulation trans with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationTrans remove(Serializable primaryKey)
		throws NoSuchCirculationTransException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CirculationTrans circulationTrans = (CirculationTrans)session.get(CirculationTransImpl.class,
					primaryKey);

			if (circulationTrans == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCirculationTransException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(circulationTrans);
		}
		catch (NoSuchCirculationTransException nsee) {
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
	protected CirculationTrans removeImpl(CirculationTrans circulationTrans)
		throws SystemException {
		circulationTrans = toUnwrappedModel(circulationTrans);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(circulationTrans)) {
				circulationTrans = (CirculationTrans)session.get(CirculationTransImpl.class,
						circulationTrans.getPrimaryKeyObj());
			}

			if (circulationTrans != null) {
				session.delete(circulationTrans);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (circulationTrans != null) {
			clearCache(circulationTrans);
		}

		return circulationTrans;
	}

	@Override
	public CirculationTrans updateImpl(
		com.kencana.lms.model.CirculationTrans circulationTrans)
		throws SystemException {
		circulationTrans = toUnwrappedModel(circulationTrans);

		boolean isNew = circulationTrans.isNew();

		CirculationTransModelImpl circulationTransModelImpl = (CirculationTransModelImpl)circulationTrans;

		Session session = null;

		try {
			session = openSession();

			if (circulationTrans.isNew()) {
				session.save(circulationTrans);

				circulationTrans.setNew(false);
			}
			else {
				session.merge(circulationTrans);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CirculationTransModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((circulationTransModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PATRONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						circulationTransModelImpl.getOriginalPatronId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PATRONID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PATRONID,
					args);

				args = new Object[] { circulationTransModelImpl.getPatronId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PATRONID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PATRONID,
					args);
			}

			if ((circulationTransModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						circulationTransModelImpl.getOriginalCompanyId(),
						circulationTransModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);

				args = new Object[] {
						circulationTransModelImpl.getCompanyId(),
						circulationTransModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);
			}

			if ((circulationTransModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUPLIBRARY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						circulationTransModelImpl.getOriginalCompanyId(),
						circulationTransModelImpl.getOriginalGroupId(),
						circulationTransModelImpl.getOriginalLibraryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUPLIBRARY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUPLIBRARY,
					args);

				args = new Object[] {
						circulationTransModelImpl.getCompanyId(),
						circulationTransModelImpl.getGroupId(),
						circulationTransModelImpl.getLibraryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUPLIBRARY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUPLIBRARY,
					args);
			}

			if ((circulationTransModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PATRON.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						circulationTransModelImpl.getOriginalCompanyId(),
						circulationTransModelImpl.getOriginalPatronId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PATRON, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PATRON,
					args);

				args = new Object[] {
						circulationTransModelImpl.getCompanyId(),
						circulationTransModelImpl.getPatronId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PATRON, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PATRON,
					args);
			}

			if ((circulationTransModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OVERDUELIBRARY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						circulationTransModelImpl.getOriginalCompanyId(),
						circulationTransModelImpl.getOriginalLibraryId(),
						circulationTransModelImpl.getOriginalOverdue()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OVERDUELIBRARY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OVERDUELIBRARY,
					args);

				args = new Object[] {
						circulationTransModelImpl.getCompanyId(),
						circulationTransModelImpl.getLibraryId(),
						circulationTransModelImpl.getOverdue()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OVERDUELIBRARY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OVERDUELIBRARY,
					args);
			}
		}

		EntityCacheUtil.putResult(CirculationTransModelImpl.ENTITY_CACHE_ENABLED,
			CirculationTransImpl.class, circulationTrans.getPrimaryKey(),
			circulationTrans);

		clearUniqueFindersCache(circulationTrans);
		cacheUniqueFindersCache(circulationTrans);

		return circulationTrans;
	}

	protected CirculationTrans toUnwrappedModel(
		CirculationTrans circulationTrans) {
		if (circulationTrans instanceof CirculationTransImpl) {
			return circulationTrans;
		}

		CirculationTransImpl circulationTransImpl = new CirculationTransImpl();

		circulationTransImpl.setNew(circulationTrans.isNew());
		circulationTransImpl.setPrimaryKey(circulationTrans.getPrimaryKey());

		circulationTransImpl.setTransId(circulationTrans.getTransId());
		circulationTransImpl.setCompanyId(circulationTrans.getCompanyId());
		circulationTransImpl.setGroupId(circulationTrans.getGroupId());
		circulationTransImpl.setLibraryId(circulationTrans.getLibraryId());
		circulationTransImpl.setPatronId(circulationTrans.getPatronId());
		circulationTransImpl.setCatalogItemId(circulationTrans.getCatalogItemId());
		circulationTransImpl.setTransDate(circulationTrans.getTransDate());
		circulationTransImpl.setDueDate(circulationTrans.getDueDate());
		circulationTransImpl.setOverdue(circulationTrans.isOverdue());
		circulationTransImpl.setReturnDate(circulationTrans.getReturnDate());
		circulationTransImpl.setLastRenewDate(circulationTrans.getLastRenewDate());
		circulationTransImpl.setRenewCount(circulationTrans.getRenewCount());

		return circulationTransImpl;
	}

	/**
	 * Returns the circulation trans with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the circulation trans
	 * @return the circulation trans
	 * @throws com.kencana.lms.NoSuchCirculationTransException if a circulation trans with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationTrans findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCirculationTransException, SystemException {
		CirculationTrans circulationTrans = fetchByPrimaryKey(primaryKey);

		if (circulationTrans == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCirculationTransException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return circulationTrans;
	}

	/**
	 * Returns the circulation trans with the primary key or throws a {@link com.kencana.lms.NoSuchCirculationTransException} if it could not be found.
	 *
	 * @param transId the primary key of the circulation trans
	 * @return the circulation trans
	 * @throws com.kencana.lms.NoSuchCirculationTransException if a circulation trans with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationTrans findByPrimaryKey(long transId)
		throws NoSuchCirculationTransException, SystemException {
		return findByPrimaryKey((Serializable)transId);
	}

	/**
	 * Returns the circulation trans with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the circulation trans
	 * @return the circulation trans, or <code>null</code> if a circulation trans with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationTrans fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CirculationTrans circulationTrans = (CirculationTrans)EntityCacheUtil.getResult(CirculationTransModelImpl.ENTITY_CACHE_ENABLED,
				CirculationTransImpl.class, primaryKey);

		if (circulationTrans == _nullCirculationTrans) {
			return null;
		}

		if (circulationTrans == null) {
			Session session = null;

			try {
				session = openSession();

				circulationTrans = (CirculationTrans)session.get(CirculationTransImpl.class,
						primaryKey);

				if (circulationTrans != null) {
					cacheResult(circulationTrans);
				}
				else {
					EntityCacheUtil.putResult(CirculationTransModelImpl.ENTITY_CACHE_ENABLED,
						CirculationTransImpl.class, primaryKey,
						_nullCirculationTrans);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CirculationTransModelImpl.ENTITY_CACHE_ENABLED,
					CirculationTransImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return circulationTrans;
	}

	/**
	 * Returns the circulation trans with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param transId the primary key of the circulation trans
	 * @return the circulation trans, or <code>null</code> if a circulation trans with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationTrans fetchByPrimaryKey(long transId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)transId);
	}

	/**
	 * Returns all the circulation transes.
	 *
	 * @return the circulation transes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CirculationTrans> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the circulation transes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationTransModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of circulation transes
	 * @param end the upper bound of the range of circulation transes (not inclusive)
	 * @return the range of circulation transes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CirculationTrans> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the circulation transes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationTransModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of circulation transes
	 * @param end the upper bound of the range of circulation transes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of circulation transes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CirculationTrans> findAll(int start, int end,
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

		List<CirculationTrans> list = (List<CirculationTrans>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CIRCULATIONTRANS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CIRCULATIONTRANS;

				if (pagination) {
					sql = sql.concat(CirculationTransModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CirculationTrans>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CirculationTrans>(list);
				}
				else {
					list = (List<CirculationTrans>)QueryUtil.list(q,
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
	 * Removes all the circulation transes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CirculationTrans circulationTrans : findAll()) {
			remove(circulationTrans);
		}
	}

	/**
	 * Returns the number of circulation transes.
	 *
	 * @return the number of circulation transes
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

				Query q = session.createQuery(_SQL_COUNT_CIRCULATIONTRANS);

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
	 * Initializes the circulation trans persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.kencana.lms.model.CirculationTrans")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CirculationTrans>> listenersList = new ArrayList<ModelListener<CirculationTrans>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CirculationTrans>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CirculationTransImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CIRCULATIONTRANS = "SELECT circulationTrans FROM CirculationTrans circulationTrans";
	private static final String _SQL_SELECT_CIRCULATIONTRANS_WHERE = "SELECT circulationTrans FROM CirculationTrans circulationTrans WHERE ";
	private static final String _SQL_COUNT_CIRCULATIONTRANS = "SELECT COUNT(circulationTrans) FROM CirculationTrans circulationTrans";
	private static final String _SQL_COUNT_CIRCULATIONTRANS_WHERE = "SELECT COUNT(circulationTrans) FROM CirculationTrans circulationTrans WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "circulationTrans.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CirculationTrans exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CirculationTrans exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CirculationTransPersistenceImpl.class);
	private static CirculationTrans _nullCirculationTrans = new CirculationTransImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CirculationTrans> toCacheModel() {
				return _nullCirculationTransCacheModel;
			}
		};

	private static CacheModel<CirculationTrans> _nullCirculationTransCacheModel = new CacheModel<CirculationTrans>() {
			@Override
			public CirculationTrans toEntityModel() {
				return _nullCirculationTrans;
			}
		};
}