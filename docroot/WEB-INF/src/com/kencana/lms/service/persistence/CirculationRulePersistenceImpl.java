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

import com.kencana.lms.NoSuchCirculationRuleException;
import com.kencana.lms.model.CirculationRule;
import com.kencana.lms.model.impl.CirculationRuleImpl;
import com.kencana.lms.model.impl.CirculationRuleModelImpl;

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
 * The persistence implementation for the circulation rule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see CirculationRulePersistence
 * @see CirculationRuleUtil
 * @generated
 */
public class CirculationRulePersistenceImpl extends BasePersistenceImpl<CirculationRule>
	implements CirculationRulePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CirculationRuleUtil} to access the circulation rule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CirculationRuleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CirculationRuleModelImpl.ENTITY_CACHE_ENABLED,
			CirculationRuleModelImpl.FINDER_CACHE_ENABLED,
			CirculationRuleImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CirculationRuleModelImpl.ENTITY_CACHE_ENABLED,
			CirculationRuleModelImpl.FINDER_CACHE_ENABLED,
			CirculationRuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CirculationRuleModelImpl.ENTITY_CACHE_ENABLED,
			CirculationRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(CirculationRuleModelImpl.ENTITY_CACHE_ENABLED,
			CirculationRuleModelImpl.FINDER_CACHE_ENABLED,
			CirculationRuleImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompany",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(CirculationRuleModelImpl.ENTITY_CACHE_ENABLED,
			CirculationRuleModelImpl.FINDER_CACHE_ENABLED,
			CirculationRuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			CirculationRuleModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(CirculationRuleModelImpl.ENTITY_CACHE_ENABLED,
			CirculationRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the circulation rules where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching circulation rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CirculationRule> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the circulation rules where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of circulation rules
	 * @param end the upper bound of the range of circulation rules (not inclusive)
	 * @return the range of matching circulation rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CirculationRule> findByCompany(long companyId, int start,
		int end) throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the circulation rules where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of circulation rules
	 * @param end the upper bound of the range of circulation rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching circulation rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CirculationRule> findByCompany(long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<CirculationRule> list = (List<CirculationRule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CirculationRule circulationRule : list) {
				if ((companyId != circulationRule.getCompanyId())) {
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

			query.append(_SQL_SELECT_CIRCULATIONRULE_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CirculationRuleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<CirculationRule>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CirculationRule>(list);
				}
				else {
					list = (List<CirculationRule>)QueryUtil.list(q,
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
	 * Returns the first circulation rule in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching circulation rule
	 * @throws com.kencana.lms.NoSuchCirculationRuleException if a matching circulation rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationRule findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCirculationRuleException, SystemException {
		CirculationRule circulationRule = fetchByCompany_First(companyId,
				orderByComparator);

		if (circulationRule != null) {
			return circulationRule;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCirculationRuleException(msg.toString());
	}

	/**
	 * Returns the first circulation rule in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching circulation rule, or <code>null</code> if a matching circulation rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationRule fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CirculationRule> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last circulation rule in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching circulation rule
	 * @throws com.kencana.lms.NoSuchCirculationRuleException if a matching circulation rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationRule findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCirculationRuleException, SystemException {
		CirculationRule circulationRule = fetchByCompany_Last(companyId,
				orderByComparator);

		if (circulationRule != null) {
			return circulationRule;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCirculationRuleException(msg.toString());
	}

	/**
	 * Returns the last circulation rule in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching circulation rule, or <code>null</code> if a matching circulation rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationRule fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		if (count == 0) {
			return null;
		}

		List<CirculationRule> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the circulation rules before and after the current circulation rule in the ordered set where companyId = &#63;.
	 *
	 * @param circulationRuleId the primary key of the current circulation rule
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next circulation rule
	 * @throws com.kencana.lms.NoSuchCirculationRuleException if a circulation rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationRule[] findByCompany_PrevAndNext(long circulationRuleId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchCirculationRuleException, SystemException {
		CirculationRule circulationRule = findByPrimaryKey(circulationRuleId);

		Session session = null;

		try {
			session = openSession();

			CirculationRule[] array = new CirculationRuleImpl[3];

			array[0] = getByCompany_PrevAndNext(session, circulationRule,
					companyId, orderByComparator, true);

			array[1] = circulationRule;

			array[2] = getByCompany_PrevAndNext(session, circulationRule,
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

	protected CirculationRule getByCompany_PrevAndNext(Session session,
		CirculationRule circulationRule, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CIRCULATIONRULE_WHERE);

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
			query.append(CirculationRuleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(circulationRule);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CirculationRule> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the circulation rules where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompany(long companyId) throws SystemException {
		for (CirculationRule circulationRule : findByCompany(companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(circulationRule);
		}
	}

	/**
	 * Returns the number of circulation rules where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching circulation rules
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

			query.append(_SQL_COUNT_CIRCULATIONRULE_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "circulationRule.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(CirculationRuleModelImpl.ENTITY_CACHE_ENABLED,
			CirculationRuleModelImpl.FINDER_CACHE_ENABLED,
			CirculationRuleImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompanyGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(CirculationRuleModelImpl.ENTITY_CACHE_ENABLED,
			CirculationRuleModelImpl.FINDER_CACHE_ENABLED,
			CirculationRuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			CirculationRuleModelImpl.COMPANYID_COLUMN_BITMASK |
			CirculationRuleModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYGROUP = new FinderPath(CirculationRuleModelImpl.ENTITY_CACHE_ENABLED,
			CirculationRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the circulation rules where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching circulation rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CirculationRule> findByCompanyGroup(long companyId, long groupId)
		throws SystemException {
		return findByCompanyGroup(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the circulation rules where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of circulation rules
	 * @param end the upper bound of the range of circulation rules (not inclusive)
	 * @return the range of matching circulation rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CirculationRule> findByCompanyGroup(long companyId,
		long groupId, int start, int end) throws SystemException {
		return findByCompanyGroup(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the circulation rules where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of circulation rules
	 * @param end the upper bound of the range of circulation rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching circulation rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CirculationRule> findByCompanyGroup(long companyId,
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

		List<CirculationRule> list = (List<CirculationRule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CirculationRule circulationRule : list) {
				if ((companyId != circulationRule.getCompanyId()) ||
						(groupId != circulationRule.getGroupId())) {
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

			query.append(_SQL_SELECT_CIRCULATIONRULE_WHERE);

			query.append(_FINDER_COLUMN_COMPANYGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CirculationRuleModelImpl.ORDER_BY_JPQL);
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
					list = (List<CirculationRule>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CirculationRule>(list);
				}
				else {
					list = (List<CirculationRule>)QueryUtil.list(q,
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
	 * Returns the first circulation rule in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching circulation rule
	 * @throws com.kencana.lms.NoSuchCirculationRuleException if a matching circulation rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationRule findByCompanyGroup_First(long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCirculationRuleException, SystemException {
		CirculationRule circulationRule = fetchByCompanyGroup_First(companyId,
				groupId, orderByComparator);

		if (circulationRule != null) {
			return circulationRule;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCirculationRuleException(msg.toString());
	}

	/**
	 * Returns the first circulation rule in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching circulation rule, or <code>null</code> if a matching circulation rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationRule fetchByCompanyGroup_First(long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<CirculationRule> list = findByCompanyGroup(companyId, groupId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last circulation rule in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching circulation rule
	 * @throws com.kencana.lms.NoSuchCirculationRuleException if a matching circulation rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationRule findByCompanyGroup_Last(long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCirculationRuleException, SystemException {
		CirculationRule circulationRule = fetchByCompanyGroup_Last(companyId,
				groupId, orderByComparator);

		if (circulationRule != null) {
			return circulationRule;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCirculationRuleException(msg.toString());
	}

	/**
	 * Returns the last circulation rule in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching circulation rule, or <code>null</code> if a matching circulation rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationRule fetchByCompanyGroup_Last(long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCompanyGroup(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<CirculationRule> list = findByCompanyGroup(companyId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the circulation rules before and after the current circulation rule in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param circulationRuleId the primary key of the current circulation rule
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next circulation rule
	 * @throws com.kencana.lms.NoSuchCirculationRuleException if a circulation rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationRule[] findByCompanyGroup_PrevAndNext(
		long circulationRuleId, long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCirculationRuleException, SystemException {
		CirculationRule circulationRule = findByPrimaryKey(circulationRuleId);

		Session session = null;

		try {
			session = openSession();

			CirculationRule[] array = new CirculationRuleImpl[3];

			array[0] = getByCompanyGroup_PrevAndNext(session, circulationRule,
					companyId, groupId, orderByComparator, true);

			array[1] = circulationRule;

			array[2] = getByCompanyGroup_PrevAndNext(session, circulationRule,
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

	protected CirculationRule getByCompanyGroup_PrevAndNext(Session session,
		CirculationRule circulationRule, long companyId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CIRCULATIONRULE_WHERE);

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
			query.append(CirculationRuleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(circulationRule);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CirculationRule> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the circulation rules where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyGroup(long companyId, long groupId)
		throws SystemException {
		for (CirculationRule circulationRule : findByCompanyGroup(companyId,
				groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(circulationRule);
		}
	}

	/**
	 * Returns the number of circulation rules where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching circulation rules
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

			query.append(_SQL_COUNT_CIRCULATIONRULE_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANYGROUP_COMPANYID_2 = "circulationRule.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYGROUP_GROUPID_2 = "circulationRule.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ITEMTYPE = new FinderPath(CirculationRuleModelImpl.ENTITY_CACHE_ENABLED,
			CirculationRuleModelImpl.FINDER_CACHE_ENABLED,
			CirculationRuleImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByItemType",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMTYPE =
		new FinderPath(CirculationRuleModelImpl.ENTITY_CACHE_ENABLED,
			CirculationRuleModelImpl.FINDER_CACHE_ENABLED,
			CirculationRuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByItemType",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			CirculationRuleModelImpl.COMPANYID_COLUMN_BITMASK |
			CirculationRuleModelImpl.LIBRARYID_COLUMN_BITMASK |
			CirculationRuleModelImpl.ITEMTYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ITEMTYPE = new FinderPath(CirculationRuleModelImpl.ENTITY_CACHE_ENABLED,
			CirculationRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByItemType",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the circulation rules where companyId = &#63; and libraryId = &#63; and itemTypeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param itemTypeId the item type ID
	 * @return the matching circulation rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CirculationRule> findByItemType(long companyId, long libraryId,
		long itemTypeId) throws SystemException {
		return findByItemType(companyId, libraryId, itemTypeId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the circulation rules where companyId = &#63; and libraryId = &#63; and itemTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param itemTypeId the item type ID
	 * @param start the lower bound of the range of circulation rules
	 * @param end the upper bound of the range of circulation rules (not inclusive)
	 * @return the range of matching circulation rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CirculationRule> findByItemType(long companyId, long libraryId,
		long itemTypeId, int start, int end) throws SystemException {
		return findByItemType(companyId, libraryId, itemTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the circulation rules where companyId = &#63; and libraryId = &#63; and itemTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param itemTypeId the item type ID
	 * @param start the lower bound of the range of circulation rules
	 * @param end the upper bound of the range of circulation rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching circulation rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CirculationRule> findByItemType(long companyId, long libraryId,
		long itemTypeId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMTYPE;
			finderArgs = new Object[] { companyId, libraryId, itemTypeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ITEMTYPE;
			finderArgs = new Object[] {
					companyId, libraryId, itemTypeId,
					
					start, end, orderByComparator
				};
		}

		List<CirculationRule> list = (List<CirculationRule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CirculationRule circulationRule : list) {
				if ((companyId != circulationRule.getCompanyId()) ||
						(libraryId != circulationRule.getLibraryId()) ||
						(itemTypeId != circulationRule.getItemTypeId())) {
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

			query.append(_SQL_SELECT_CIRCULATIONRULE_WHERE);

			query.append(_FINDER_COLUMN_ITEMTYPE_COMPANYID_2);

			query.append(_FINDER_COLUMN_ITEMTYPE_LIBRARYID_2);

			query.append(_FINDER_COLUMN_ITEMTYPE_ITEMTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CirculationRuleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(libraryId);

				qPos.add(itemTypeId);

				if (!pagination) {
					list = (List<CirculationRule>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CirculationRule>(list);
				}
				else {
					list = (List<CirculationRule>)QueryUtil.list(q,
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
	 * Returns the first circulation rule in the ordered set where companyId = &#63; and libraryId = &#63; and itemTypeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param itemTypeId the item type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching circulation rule
	 * @throws com.kencana.lms.NoSuchCirculationRuleException if a matching circulation rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationRule findByItemType_First(long companyId, long libraryId,
		long itemTypeId, OrderByComparator orderByComparator)
		throws NoSuchCirculationRuleException, SystemException {
		CirculationRule circulationRule = fetchByItemType_First(companyId,
				libraryId, itemTypeId, orderByComparator);

		if (circulationRule != null) {
			return circulationRule;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", libraryId=");
		msg.append(libraryId);

		msg.append(", itemTypeId=");
		msg.append(itemTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCirculationRuleException(msg.toString());
	}

	/**
	 * Returns the first circulation rule in the ordered set where companyId = &#63; and libraryId = &#63; and itemTypeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param itemTypeId the item type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching circulation rule, or <code>null</code> if a matching circulation rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationRule fetchByItemType_First(long companyId,
		long libraryId, long itemTypeId, OrderByComparator orderByComparator)
		throws SystemException {
		List<CirculationRule> list = findByItemType(companyId, libraryId,
				itemTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last circulation rule in the ordered set where companyId = &#63; and libraryId = &#63; and itemTypeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param itemTypeId the item type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching circulation rule
	 * @throws com.kencana.lms.NoSuchCirculationRuleException if a matching circulation rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationRule findByItemType_Last(long companyId, long libraryId,
		long itemTypeId, OrderByComparator orderByComparator)
		throws NoSuchCirculationRuleException, SystemException {
		CirculationRule circulationRule = fetchByItemType_Last(companyId,
				libraryId, itemTypeId, orderByComparator);

		if (circulationRule != null) {
			return circulationRule;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", libraryId=");
		msg.append(libraryId);

		msg.append(", itemTypeId=");
		msg.append(itemTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCirculationRuleException(msg.toString());
	}

	/**
	 * Returns the last circulation rule in the ordered set where companyId = &#63; and libraryId = &#63; and itemTypeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param itemTypeId the item type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching circulation rule, or <code>null</code> if a matching circulation rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationRule fetchByItemType_Last(long companyId, long libraryId,
		long itemTypeId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByItemType(companyId, libraryId, itemTypeId);

		if (count == 0) {
			return null;
		}

		List<CirculationRule> list = findByItemType(companyId, libraryId,
				itemTypeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the circulation rules before and after the current circulation rule in the ordered set where companyId = &#63; and libraryId = &#63; and itemTypeId = &#63;.
	 *
	 * @param circulationRuleId the primary key of the current circulation rule
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param itemTypeId the item type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next circulation rule
	 * @throws com.kencana.lms.NoSuchCirculationRuleException if a circulation rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationRule[] findByItemType_PrevAndNext(
		long circulationRuleId, long companyId, long libraryId,
		long itemTypeId, OrderByComparator orderByComparator)
		throws NoSuchCirculationRuleException, SystemException {
		CirculationRule circulationRule = findByPrimaryKey(circulationRuleId);

		Session session = null;

		try {
			session = openSession();

			CirculationRule[] array = new CirculationRuleImpl[3];

			array[0] = getByItemType_PrevAndNext(session, circulationRule,
					companyId, libraryId, itemTypeId, orderByComparator, true);

			array[1] = circulationRule;

			array[2] = getByItemType_PrevAndNext(session, circulationRule,
					companyId, libraryId, itemTypeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CirculationRule getByItemType_PrevAndNext(Session session,
		CirculationRule circulationRule, long companyId, long libraryId,
		long itemTypeId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CIRCULATIONRULE_WHERE);

		query.append(_FINDER_COLUMN_ITEMTYPE_COMPANYID_2);

		query.append(_FINDER_COLUMN_ITEMTYPE_LIBRARYID_2);

		query.append(_FINDER_COLUMN_ITEMTYPE_ITEMTYPEID_2);

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
			query.append(CirculationRuleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(libraryId);

		qPos.add(itemTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(circulationRule);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CirculationRule> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the circulation rules where companyId = &#63; and libraryId = &#63; and itemTypeId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param itemTypeId the item type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByItemType(long companyId, long libraryId, long itemTypeId)
		throws SystemException {
		for (CirculationRule circulationRule : findByItemType(companyId,
				libraryId, itemTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(circulationRule);
		}
	}

	/**
	 * Returns the number of circulation rules where companyId = &#63; and libraryId = &#63; and itemTypeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param itemTypeId the item type ID
	 * @return the number of matching circulation rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByItemType(long companyId, long libraryId, long itemTypeId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ITEMTYPE;

		Object[] finderArgs = new Object[] { companyId, libraryId, itemTypeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CIRCULATIONRULE_WHERE);

			query.append(_FINDER_COLUMN_ITEMTYPE_COMPANYID_2);

			query.append(_FINDER_COLUMN_ITEMTYPE_LIBRARYID_2);

			query.append(_FINDER_COLUMN_ITEMTYPE_ITEMTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(libraryId);

				qPos.add(itemTypeId);

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

	private static final String _FINDER_COLUMN_ITEMTYPE_COMPANYID_2 = "circulationRule.companyId = ? AND ";
	private static final String _FINDER_COLUMN_ITEMTYPE_LIBRARYID_2 = "circulationRule.libraryId = ? AND ";
	private static final String _FINDER_COLUMN_ITEMTYPE_ITEMTYPEID_2 = "circulationRule.itemTypeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PATRONCATEGORY =
		new FinderPath(CirculationRuleModelImpl.ENTITY_CACHE_ENABLED,
			CirculationRuleModelImpl.FINDER_CACHE_ENABLED,
			CirculationRuleImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPatronCategory",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PATRONCATEGORY =
		new FinderPath(CirculationRuleModelImpl.ENTITY_CACHE_ENABLED,
			CirculationRuleModelImpl.FINDER_CACHE_ENABLED,
			CirculationRuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPatronCategory",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			CirculationRuleModelImpl.COMPANYID_COLUMN_BITMASK |
			CirculationRuleModelImpl.LIBRARYID_COLUMN_BITMASK |
			CirculationRuleModelImpl.PATRONCATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PATRONCATEGORY = new FinderPath(CirculationRuleModelImpl.ENTITY_CACHE_ENABLED,
			CirculationRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPatronCategory",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the circulation rules where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param patronCategoryId the patron category ID
	 * @return the matching circulation rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CirculationRule> findByPatronCategory(long companyId,
		long libraryId, long patronCategoryId) throws SystemException {
		return findByPatronCategory(companyId, libraryId, patronCategoryId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the circulation rules where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param patronCategoryId the patron category ID
	 * @param start the lower bound of the range of circulation rules
	 * @param end the upper bound of the range of circulation rules (not inclusive)
	 * @return the range of matching circulation rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CirculationRule> findByPatronCategory(long companyId,
		long libraryId, long patronCategoryId, int start, int end)
		throws SystemException {
		return findByPatronCategory(companyId, libraryId, patronCategoryId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the circulation rules where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param patronCategoryId the patron category ID
	 * @param start the lower bound of the range of circulation rules
	 * @param end the upper bound of the range of circulation rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching circulation rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CirculationRule> findByPatronCategory(long companyId,
		long libraryId, long patronCategoryId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PATRONCATEGORY;
			finderArgs = new Object[] { companyId, libraryId, patronCategoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PATRONCATEGORY;
			finderArgs = new Object[] {
					companyId, libraryId, patronCategoryId,
					
					start, end, orderByComparator
				};
		}

		List<CirculationRule> list = (List<CirculationRule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CirculationRule circulationRule : list) {
				if ((companyId != circulationRule.getCompanyId()) ||
						(libraryId != circulationRule.getLibraryId()) ||
						(patronCategoryId != circulationRule.getPatronCategoryId())) {
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

			query.append(_SQL_SELECT_CIRCULATIONRULE_WHERE);

			query.append(_FINDER_COLUMN_PATRONCATEGORY_COMPANYID_2);

			query.append(_FINDER_COLUMN_PATRONCATEGORY_LIBRARYID_2);

			query.append(_FINDER_COLUMN_PATRONCATEGORY_PATRONCATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CirculationRuleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(libraryId);

				qPos.add(patronCategoryId);

				if (!pagination) {
					list = (List<CirculationRule>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CirculationRule>(list);
				}
				else {
					list = (List<CirculationRule>)QueryUtil.list(q,
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
	 * Returns the first circulation rule in the ordered set where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param patronCategoryId the patron category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching circulation rule
	 * @throws com.kencana.lms.NoSuchCirculationRuleException if a matching circulation rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationRule findByPatronCategory_First(long companyId,
		long libraryId, long patronCategoryId,
		OrderByComparator orderByComparator)
		throws NoSuchCirculationRuleException, SystemException {
		CirculationRule circulationRule = fetchByPatronCategory_First(companyId,
				libraryId, patronCategoryId, orderByComparator);

		if (circulationRule != null) {
			return circulationRule;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", libraryId=");
		msg.append(libraryId);

		msg.append(", patronCategoryId=");
		msg.append(patronCategoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCirculationRuleException(msg.toString());
	}

	/**
	 * Returns the first circulation rule in the ordered set where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param patronCategoryId the patron category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching circulation rule, or <code>null</code> if a matching circulation rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationRule fetchByPatronCategory_First(long companyId,
		long libraryId, long patronCategoryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CirculationRule> list = findByPatronCategory(companyId, libraryId,
				patronCategoryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last circulation rule in the ordered set where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param patronCategoryId the patron category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching circulation rule
	 * @throws com.kencana.lms.NoSuchCirculationRuleException if a matching circulation rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationRule findByPatronCategory_Last(long companyId,
		long libraryId, long patronCategoryId,
		OrderByComparator orderByComparator)
		throws NoSuchCirculationRuleException, SystemException {
		CirculationRule circulationRule = fetchByPatronCategory_Last(companyId,
				libraryId, patronCategoryId, orderByComparator);

		if (circulationRule != null) {
			return circulationRule;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", libraryId=");
		msg.append(libraryId);

		msg.append(", patronCategoryId=");
		msg.append(patronCategoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCirculationRuleException(msg.toString());
	}

	/**
	 * Returns the last circulation rule in the ordered set where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param patronCategoryId the patron category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching circulation rule, or <code>null</code> if a matching circulation rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationRule fetchByPatronCategory_Last(long companyId,
		long libraryId, long patronCategoryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPatronCategory(companyId, libraryId, patronCategoryId);

		if (count == 0) {
			return null;
		}

		List<CirculationRule> list = findByPatronCategory(companyId, libraryId,
				patronCategoryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the circulation rules before and after the current circulation rule in the ordered set where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63;.
	 *
	 * @param circulationRuleId the primary key of the current circulation rule
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param patronCategoryId the patron category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next circulation rule
	 * @throws com.kencana.lms.NoSuchCirculationRuleException if a circulation rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationRule[] findByPatronCategory_PrevAndNext(
		long circulationRuleId, long companyId, long libraryId,
		long patronCategoryId, OrderByComparator orderByComparator)
		throws NoSuchCirculationRuleException, SystemException {
		CirculationRule circulationRule = findByPrimaryKey(circulationRuleId);

		Session session = null;

		try {
			session = openSession();

			CirculationRule[] array = new CirculationRuleImpl[3];

			array[0] = getByPatronCategory_PrevAndNext(session,
					circulationRule, companyId, libraryId, patronCategoryId,
					orderByComparator, true);

			array[1] = circulationRule;

			array[2] = getByPatronCategory_PrevAndNext(session,
					circulationRule, companyId, libraryId, patronCategoryId,
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

	protected CirculationRule getByPatronCategory_PrevAndNext(Session session,
		CirculationRule circulationRule, long companyId, long libraryId,
		long patronCategoryId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CIRCULATIONRULE_WHERE);

		query.append(_FINDER_COLUMN_PATRONCATEGORY_COMPANYID_2);

		query.append(_FINDER_COLUMN_PATRONCATEGORY_LIBRARYID_2);

		query.append(_FINDER_COLUMN_PATRONCATEGORY_PATRONCATEGORYID_2);

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
			query.append(CirculationRuleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(libraryId);

		qPos.add(patronCategoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(circulationRule);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CirculationRule> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the circulation rules where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param patronCategoryId the patron category ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPatronCategory(long companyId, long libraryId,
		long patronCategoryId) throws SystemException {
		for (CirculationRule circulationRule : findByPatronCategory(companyId,
				libraryId, patronCategoryId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(circulationRule);
		}
	}

	/**
	 * Returns the number of circulation rules where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param patronCategoryId the patron category ID
	 * @return the number of matching circulation rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPatronCategory(long companyId, long libraryId,
		long patronCategoryId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PATRONCATEGORY;

		Object[] finderArgs = new Object[] {
				companyId, libraryId, patronCategoryId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CIRCULATIONRULE_WHERE);

			query.append(_FINDER_COLUMN_PATRONCATEGORY_COMPANYID_2);

			query.append(_FINDER_COLUMN_PATRONCATEGORY_LIBRARYID_2);

			query.append(_FINDER_COLUMN_PATRONCATEGORY_PATRONCATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(libraryId);

				qPos.add(patronCategoryId);

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

	private static final String _FINDER_COLUMN_PATRONCATEGORY_COMPANYID_2 = "circulationRule.companyId = ? AND ";
	private static final String _FINDER_COLUMN_PATRONCATEGORY_LIBRARYID_2 = "circulationRule.libraryId = ? AND ";
	private static final String _FINDER_COLUMN_PATRONCATEGORY_PATRONCATEGORYID_2 =
		"circulationRule.patronCategoryId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ITEMTYPEPATRONCATEGORY =
		new FinderPath(CirculationRuleModelImpl.ENTITY_CACHE_ENABLED,
			CirculationRuleModelImpl.FINDER_CACHE_ENABLED,
			CirculationRuleImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByItemTypePatronCategory",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMTYPEPATRONCATEGORY =
		new FinderPath(CirculationRuleModelImpl.ENTITY_CACHE_ENABLED,
			CirculationRuleModelImpl.FINDER_CACHE_ENABLED,
			CirculationRuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByItemTypePatronCategory",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName()
			},
			CirculationRuleModelImpl.COMPANYID_COLUMN_BITMASK |
			CirculationRuleModelImpl.LIBRARYID_COLUMN_BITMASK |
			CirculationRuleModelImpl.PATRONCATEGORYID_COLUMN_BITMASK |
			CirculationRuleModelImpl.ITEMTYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ITEMTYPEPATRONCATEGORY = new FinderPath(CirculationRuleModelImpl.ENTITY_CACHE_ENABLED,
			CirculationRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByItemTypePatronCategory",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns all the circulation rules where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63; and itemTypeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param patronCategoryId the patron category ID
	 * @param itemTypeId the item type ID
	 * @return the matching circulation rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CirculationRule> findByItemTypePatronCategory(long companyId,
		long libraryId, long patronCategoryId, long itemTypeId)
		throws SystemException {
		return findByItemTypePatronCategory(companyId, libraryId,
			patronCategoryId, itemTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the circulation rules where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63; and itemTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param patronCategoryId the patron category ID
	 * @param itemTypeId the item type ID
	 * @param start the lower bound of the range of circulation rules
	 * @param end the upper bound of the range of circulation rules (not inclusive)
	 * @return the range of matching circulation rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CirculationRule> findByItemTypePatronCategory(long companyId,
		long libraryId, long patronCategoryId, long itemTypeId, int start,
		int end) throws SystemException {
		return findByItemTypePatronCategory(companyId, libraryId,
			patronCategoryId, itemTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the circulation rules where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63; and itemTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param patronCategoryId the patron category ID
	 * @param itemTypeId the item type ID
	 * @param start the lower bound of the range of circulation rules
	 * @param end the upper bound of the range of circulation rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching circulation rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CirculationRule> findByItemTypePatronCategory(long companyId,
		long libraryId, long patronCategoryId, long itemTypeId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMTYPEPATRONCATEGORY;
			finderArgs = new Object[] {
					companyId, libraryId, patronCategoryId, itemTypeId
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ITEMTYPEPATRONCATEGORY;
			finderArgs = new Object[] {
					companyId, libraryId, patronCategoryId, itemTypeId,
					
					start, end, orderByComparator
				};
		}

		List<CirculationRule> list = (List<CirculationRule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CirculationRule circulationRule : list) {
				if ((companyId != circulationRule.getCompanyId()) ||
						(libraryId != circulationRule.getLibraryId()) ||
						(patronCategoryId != circulationRule.getPatronCategoryId()) ||
						(itemTypeId != circulationRule.getItemTypeId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_CIRCULATIONRULE_WHERE);

			query.append(_FINDER_COLUMN_ITEMTYPEPATRONCATEGORY_COMPANYID_2);

			query.append(_FINDER_COLUMN_ITEMTYPEPATRONCATEGORY_LIBRARYID_2);

			query.append(_FINDER_COLUMN_ITEMTYPEPATRONCATEGORY_PATRONCATEGORYID_2);

			query.append(_FINDER_COLUMN_ITEMTYPEPATRONCATEGORY_ITEMTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CirculationRuleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(libraryId);

				qPos.add(patronCategoryId);

				qPos.add(itemTypeId);

				if (!pagination) {
					list = (List<CirculationRule>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CirculationRule>(list);
				}
				else {
					list = (List<CirculationRule>)QueryUtil.list(q,
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
	 * Returns the first circulation rule in the ordered set where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63; and itemTypeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param patronCategoryId the patron category ID
	 * @param itemTypeId the item type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching circulation rule
	 * @throws com.kencana.lms.NoSuchCirculationRuleException if a matching circulation rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationRule findByItemTypePatronCategory_First(long companyId,
		long libraryId, long patronCategoryId, long itemTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchCirculationRuleException, SystemException {
		CirculationRule circulationRule = fetchByItemTypePatronCategory_First(companyId,
				libraryId, patronCategoryId, itemTypeId, orderByComparator);

		if (circulationRule != null) {
			return circulationRule;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", libraryId=");
		msg.append(libraryId);

		msg.append(", patronCategoryId=");
		msg.append(patronCategoryId);

		msg.append(", itemTypeId=");
		msg.append(itemTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCirculationRuleException(msg.toString());
	}

	/**
	 * Returns the first circulation rule in the ordered set where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63; and itemTypeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param patronCategoryId the patron category ID
	 * @param itemTypeId the item type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching circulation rule, or <code>null</code> if a matching circulation rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationRule fetchByItemTypePatronCategory_First(long companyId,
		long libraryId, long patronCategoryId, long itemTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CirculationRule> list = findByItemTypePatronCategory(companyId,
				libraryId, patronCategoryId, itemTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last circulation rule in the ordered set where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63; and itemTypeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param patronCategoryId the patron category ID
	 * @param itemTypeId the item type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching circulation rule
	 * @throws com.kencana.lms.NoSuchCirculationRuleException if a matching circulation rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationRule findByItemTypePatronCategory_Last(long companyId,
		long libraryId, long patronCategoryId, long itemTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchCirculationRuleException, SystemException {
		CirculationRule circulationRule = fetchByItemTypePatronCategory_Last(companyId,
				libraryId, patronCategoryId, itemTypeId, orderByComparator);

		if (circulationRule != null) {
			return circulationRule;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", libraryId=");
		msg.append(libraryId);

		msg.append(", patronCategoryId=");
		msg.append(patronCategoryId);

		msg.append(", itemTypeId=");
		msg.append(itemTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCirculationRuleException(msg.toString());
	}

	/**
	 * Returns the last circulation rule in the ordered set where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63; and itemTypeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param patronCategoryId the patron category ID
	 * @param itemTypeId the item type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching circulation rule, or <code>null</code> if a matching circulation rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationRule fetchByItemTypePatronCategory_Last(long companyId,
		long libraryId, long patronCategoryId, long itemTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByItemTypePatronCategory(companyId, libraryId,
				patronCategoryId, itemTypeId);

		if (count == 0) {
			return null;
		}

		List<CirculationRule> list = findByItemTypePatronCategory(companyId,
				libraryId, patronCategoryId, itemTypeId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the circulation rules before and after the current circulation rule in the ordered set where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63; and itemTypeId = &#63;.
	 *
	 * @param circulationRuleId the primary key of the current circulation rule
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param patronCategoryId the patron category ID
	 * @param itemTypeId the item type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next circulation rule
	 * @throws com.kencana.lms.NoSuchCirculationRuleException if a circulation rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationRule[] findByItemTypePatronCategory_PrevAndNext(
		long circulationRuleId, long companyId, long libraryId,
		long patronCategoryId, long itemTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchCirculationRuleException, SystemException {
		CirculationRule circulationRule = findByPrimaryKey(circulationRuleId);

		Session session = null;

		try {
			session = openSession();

			CirculationRule[] array = new CirculationRuleImpl[3];

			array[0] = getByItemTypePatronCategory_PrevAndNext(session,
					circulationRule, companyId, libraryId, patronCategoryId,
					itemTypeId, orderByComparator, true);

			array[1] = circulationRule;

			array[2] = getByItemTypePatronCategory_PrevAndNext(session,
					circulationRule, companyId, libraryId, patronCategoryId,
					itemTypeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CirculationRule getByItemTypePatronCategory_PrevAndNext(
		Session session, CirculationRule circulationRule, long companyId,
		long libraryId, long patronCategoryId, long itemTypeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CIRCULATIONRULE_WHERE);

		query.append(_FINDER_COLUMN_ITEMTYPEPATRONCATEGORY_COMPANYID_2);

		query.append(_FINDER_COLUMN_ITEMTYPEPATRONCATEGORY_LIBRARYID_2);

		query.append(_FINDER_COLUMN_ITEMTYPEPATRONCATEGORY_PATRONCATEGORYID_2);

		query.append(_FINDER_COLUMN_ITEMTYPEPATRONCATEGORY_ITEMTYPEID_2);

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
			query.append(CirculationRuleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(libraryId);

		qPos.add(patronCategoryId);

		qPos.add(itemTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(circulationRule);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CirculationRule> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the circulation rules where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63; and itemTypeId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param patronCategoryId the patron category ID
	 * @param itemTypeId the item type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByItemTypePatronCategory(long companyId, long libraryId,
		long patronCategoryId, long itemTypeId) throws SystemException {
		for (CirculationRule circulationRule : findByItemTypePatronCategory(
				companyId, libraryId, patronCategoryId, itemTypeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(circulationRule);
		}
	}

	/**
	 * Returns the number of circulation rules where companyId = &#63; and libraryId = &#63; and patronCategoryId = &#63; and itemTypeId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param patronCategoryId the patron category ID
	 * @param itemTypeId the item type ID
	 * @return the number of matching circulation rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByItemTypePatronCategory(long companyId, long libraryId,
		long patronCategoryId, long itemTypeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ITEMTYPEPATRONCATEGORY;

		Object[] finderArgs = new Object[] {
				companyId, libraryId, patronCategoryId, itemTypeId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_CIRCULATIONRULE_WHERE);

			query.append(_FINDER_COLUMN_ITEMTYPEPATRONCATEGORY_COMPANYID_2);

			query.append(_FINDER_COLUMN_ITEMTYPEPATRONCATEGORY_LIBRARYID_2);

			query.append(_FINDER_COLUMN_ITEMTYPEPATRONCATEGORY_PATRONCATEGORYID_2);

			query.append(_FINDER_COLUMN_ITEMTYPEPATRONCATEGORY_ITEMTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(libraryId);

				qPos.add(patronCategoryId);

				qPos.add(itemTypeId);

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

	private static final String _FINDER_COLUMN_ITEMTYPEPATRONCATEGORY_COMPANYID_2 =
		"circulationRule.companyId = ? AND ";
	private static final String _FINDER_COLUMN_ITEMTYPEPATRONCATEGORY_LIBRARYID_2 =
		"circulationRule.libraryId = ? AND ";
	private static final String _FINDER_COLUMN_ITEMTYPEPATRONCATEGORY_PATRONCATEGORYID_2 =
		"circulationRule.patronCategoryId = ? AND ";
	private static final String _FINDER_COLUMN_ITEMTYPEPATRONCATEGORY_ITEMTYPEID_2 =
		"circulationRule.itemTypeId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_CIRCULATIONRULE = new FinderPath(CirculationRuleModelImpl.ENTITY_CACHE_ENABLED,
			CirculationRuleModelImpl.FINDER_CACHE_ENABLED,
			CirculationRuleImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByCirculationRule",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName()
			},
			CirculationRuleModelImpl.COMPANYID_COLUMN_BITMASK |
			CirculationRuleModelImpl.PATRONCATEGORYID_COLUMN_BITMASK |
			CirculationRuleModelImpl.ITEMTYPEID_COLUMN_BITMASK |
			CirculationRuleModelImpl.ITEMCATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CIRCULATIONRULE = new FinderPath(CirculationRuleModelImpl.ENTITY_CACHE_ENABLED,
			CirculationRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCirculationRule",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns the circulation rule where companyId = &#63; and patronCategoryId = &#63; and itemTypeId = &#63; and itemCategoryId = &#63; or throws a {@link com.kencana.lms.NoSuchCirculationRuleException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param patronCategoryId the patron category ID
	 * @param itemTypeId the item type ID
	 * @param itemCategoryId the item category ID
	 * @return the matching circulation rule
	 * @throws com.kencana.lms.NoSuchCirculationRuleException if a matching circulation rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationRule findByCirculationRule(long companyId,
		long patronCategoryId, long itemTypeId, long itemCategoryId)
		throws NoSuchCirculationRuleException, SystemException {
		CirculationRule circulationRule = fetchByCirculationRule(companyId,
				patronCategoryId, itemTypeId, itemCategoryId);

		if (circulationRule == null) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", patronCategoryId=");
			msg.append(patronCategoryId);

			msg.append(", itemTypeId=");
			msg.append(itemTypeId);

			msg.append(", itemCategoryId=");
			msg.append(itemCategoryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCirculationRuleException(msg.toString());
		}

		return circulationRule;
	}

	/**
	 * Returns the circulation rule where companyId = &#63; and patronCategoryId = &#63; and itemTypeId = &#63; and itemCategoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param patronCategoryId the patron category ID
	 * @param itemTypeId the item type ID
	 * @param itemCategoryId the item category ID
	 * @return the matching circulation rule, or <code>null</code> if a matching circulation rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationRule fetchByCirculationRule(long companyId,
		long patronCategoryId, long itemTypeId, long itemCategoryId)
		throws SystemException {
		return fetchByCirculationRule(companyId, patronCategoryId, itemTypeId,
			itemCategoryId, true);
	}

	/**
	 * Returns the circulation rule where companyId = &#63; and patronCategoryId = &#63; and itemTypeId = &#63; and itemCategoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param patronCategoryId the patron category ID
	 * @param itemTypeId the item type ID
	 * @param itemCategoryId the item category ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching circulation rule, or <code>null</code> if a matching circulation rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationRule fetchByCirculationRule(long companyId,
		long patronCategoryId, long itemTypeId, long itemCategoryId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, patronCategoryId, itemTypeId, itemCategoryId
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CIRCULATIONRULE,
					finderArgs, this);
		}

		if (result instanceof CirculationRule) {
			CirculationRule circulationRule = (CirculationRule)result;

			if ((companyId != circulationRule.getCompanyId()) ||
					(patronCategoryId != circulationRule.getPatronCategoryId()) ||
					(itemTypeId != circulationRule.getItemTypeId()) ||
					(itemCategoryId != circulationRule.getItemCategoryId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_SELECT_CIRCULATIONRULE_WHERE);

			query.append(_FINDER_COLUMN_CIRCULATIONRULE_COMPANYID_2);

			query.append(_FINDER_COLUMN_CIRCULATIONRULE_PATRONCATEGORYID_2);

			query.append(_FINDER_COLUMN_CIRCULATIONRULE_ITEMTYPEID_2);

			query.append(_FINDER_COLUMN_CIRCULATIONRULE_ITEMCATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(patronCategoryId);

				qPos.add(itemTypeId);

				qPos.add(itemCategoryId);

				List<CirculationRule> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CIRCULATIONRULE,
						finderArgs, list);
				}
				else {
					CirculationRule circulationRule = list.get(0);

					result = circulationRule;

					cacheResult(circulationRule);

					if ((circulationRule.getCompanyId() != companyId) ||
							(circulationRule.getPatronCategoryId() != patronCategoryId) ||
							(circulationRule.getItemTypeId() != itemTypeId) ||
							(circulationRule.getItemCategoryId() != itemCategoryId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CIRCULATIONRULE,
							finderArgs, circulationRule);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CIRCULATIONRULE,
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
			return (CirculationRule)result;
		}
	}

	/**
	 * Removes the circulation rule where companyId = &#63; and patronCategoryId = &#63; and itemTypeId = &#63; and itemCategoryId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param patronCategoryId the patron category ID
	 * @param itemTypeId the item type ID
	 * @param itemCategoryId the item category ID
	 * @return the circulation rule that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationRule removeByCirculationRule(long companyId,
		long patronCategoryId, long itemTypeId, long itemCategoryId)
		throws NoSuchCirculationRuleException, SystemException {
		CirculationRule circulationRule = findByCirculationRule(companyId,
				patronCategoryId, itemTypeId, itemCategoryId);

		return remove(circulationRule);
	}

	/**
	 * Returns the number of circulation rules where companyId = &#63; and patronCategoryId = &#63; and itemTypeId = &#63; and itemCategoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param patronCategoryId the patron category ID
	 * @param itemTypeId the item type ID
	 * @param itemCategoryId the item category ID
	 * @return the number of matching circulation rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCirculationRule(long companyId, long patronCategoryId,
		long itemTypeId, long itemCategoryId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CIRCULATIONRULE;

		Object[] finderArgs = new Object[] {
				companyId, patronCategoryId, itemTypeId, itemCategoryId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_CIRCULATIONRULE_WHERE);

			query.append(_FINDER_COLUMN_CIRCULATIONRULE_COMPANYID_2);

			query.append(_FINDER_COLUMN_CIRCULATIONRULE_PATRONCATEGORYID_2);

			query.append(_FINDER_COLUMN_CIRCULATIONRULE_ITEMTYPEID_2);

			query.append(_FINDER_COLUMN_CIRCULATIONRULE_ITEMCATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(patronCategoryId);

				qPos.add(itemTypeId);

				qPos.add(itemCategoryId);

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

	private static final String _FINDER_COLUMN_CIRCULATIONRULE_COMPANYID_2 = "circulationRule.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CIRCULATIONRULE_PATRONCATEGORYID_2 =
		"circulationRule.patronCategoryId = ? AND ";
	private static final String _FINDER_COLUMN_CIRCULATIONRULE_ITEMTYPEID_2 = "circulationRule.itemTypeId = ? AND ";
	private static final String _FINDER_COLUMN_CIRCULATIONRULE_ITEMCATEGORYID_2 = "circulationRule.itemCategoryId = ?";

	public CirculationRulePersistenceImpl() {
		setModelClass(CirculationRule.class);
	}

	/**
	 * Caches the circulation rule in the entity cache if it is enabled.
	 *
	 * @param circulationRule the circulation rule
	 */
	@Override
	public void cacheResult(CirculationRule circulationRule) {
		EntityCacheUtil.putResult(CirculationRuleModelImpl.ENTITY_CACHE_ENABLED,
			CirculationRuleImpl.class, circulationRule.getPrimaryKey(),
			circulationRule);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CIRCULATIONRULE,
			new Object[] {
				circulationRule.getCompanyId(),
				circulationRule.getPatronCategoryId(),
				circulationRule.getItemTypeId(),
				circulationRule.getItemCategoryId()
			}, circulationRule);

		circulationRule.resetOriginalValues();
	}

	/**
	 * Caches the circulation rules in the entity cache if it is enabled.
	 *
	 * @param circulationRules the circulation rules
	 */
	@Override
	public void cacheResult(List<CirculationRule> circulationRules) {
		for (CirculationRule circulationRule : circulationRules) {
			if (EntityCacheUtil.getResult(
						CirculationRuleModelImpl.ENTITY_CACHE_ENABLED,
						CirculationRuleImpl.class,
						circulationRule.getPrimaryKey()) == null) {
				cacheResult(circulationRule);
			}
			else {
				circulationRule.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all circulation rules.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CirculationRuleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CirculationRuleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the circulation rule.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CirculationRule circulationRule) {
		EntityCacheUtil.removeResult(CirculationRuleModelImpl.ENTITY_CACHE_ENABLED,
			CirculationRuleImpl.class, circulationRule.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(circulationRule);
	}

	@Override
	public void clearCache(List<CirculationRule> circulationRules) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CirculationRule circulationRule : circulationRules) {
			EntityCacheUtil.removeResult(CirculationRuleModelImpl.ENTITY_CACHE_ENABLED,
				CirculationRuleImpl.class, circulationRule.getPrimaryKey());

			clearUniqueFindersCache(circulationRule);
		}
	}

	protected void cacheUniqueFindersCache(CirculationRule circulationRule) {
		if (circulationRule.isNew()) {
			Object[] args = new Object[] {
					circulationRule.getCompanyId(),
					circulationRule.getPatronCategoryId(),
					circulationRule.getItemTypeId(),
					circulationRule.getItemCategoryId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CIRCULATIONRULE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CIRCULATIONRULE,
				args, circulationRule);
		}
		else {
			CirculationRuleModelImpl circulationRuleModelImpl = (CirculationRuleModelImpl)circulationRule;

			if ((circulationRuleModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CIRCULATIONRULE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						circulationRule.getCompanyId(),
						circulationRule.getPatronCategoryId(),
						circulationRule.getItemTypeId(),
						circulationRule.getItemCategoryId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CIRCULATIONRULE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CIRCULATIONRULE,
					args, circulationRule);
			}
		}
	}

	protected void clearUniqueFindersCache(CirculationRule circulationRule) {
		CirculationRuleModelImpl circulationRuleModelImpl = (CirculationRuleModelImpl)circulationRule;

		Object[] args = new Object[] {
				circulationRule.getCompanyId(),
				circulationRule.getPatronCategoryId(),
				circulationRule.getItemTypeId(),
				circulationRule.getItemCategoryId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CIRCULATIONRULE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CIRCULATIONRULE, args);

		if ((circulationRuleModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CIRCULATIONRULE.getColumnBitmask()) != 0) {
			args = new Object[] {
					circulationRuleModelImpl.getOriginalCompanyId(),
					circulationRuleModelImpl.getOriginalPatronCategoryId(),
					circulationRuleModelImpl.getOriginalItemTypeId(),
					circulationRuleModelImpl.getOriginalItemCategoryId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CIRCULATIONRULE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CIRCULATIONRULE,
				args);
		}
	}

	/**
	 * Creates a new circulation rule with the primary key. Does not add the circulation rule to the database.
	 *
	 * @param circulationRuleId the primary key for the new circulation rule
	 * @return the new circulation rule
	 */
	@Override
	public CirculationRule create(long circulationRuleId) {
		CirculationRule circulationRule = new CirculationRuleImpl();

		circulationRule.setNew(true);
		circulationRule.setPrimaryKey(circulationRuleId);

		return circulationRule;
	}

	/**
	 * Removes the circulation rule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param circulationRuleId the primary key of the circulation rule
	 * @return the circulation rule that was removed
	 * @throws com.kencana.lms.NoSuchCirculationRuleException if a circulation rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationRule remove(long circulationRuleId)
		throws NoSuchCirculationRuleException, SystemException {
		return remove((Serializable)circulationRuleId);
	}

	/**
	 * Removes the circulation rule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the circulation rule
	 * @return the circulation rule that was removed
	 * @throws com.kencana.lms.NoSuchCirculationRuleException if a circulation rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationRule remove(Serializable primaryKey)
		throws NoSuchCirculationRuleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CirculationRule circulationRule = (CirculationRule)session.get(CirculationRuleImpl.class,
					primaryKey);

			if (circulationRule == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCirculationRuleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(circulationRule);
		}
		catch (NoSuchCirculationRuleException nsee) {
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
	protected CirculationRule removeImpl(CirculationRule circulationRule)
		throws SystemException {
		circulationRule = toUnwrappedModel(circulationRule);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(circulationRule)) {
				circulationRule = (CirculationRule)session.get(CirculationRuleImpl.class,
						circulationRule.getPrimaryKeyObj());
			}

			if (circulationRule != null) {
				session.delete(circulationRule);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (circulationRule != null) {
			clearCache(circulationRule);
		}

		return circulationRule;
	}

	@Override
	public CirculationRule updateImpl(
		com.kencana.lms.model.CirculationRule circulationRule)
		throws SystemException {
		circulationRule = toUnwrappedModel(circulationRule);

		boolean isNew = circulationRule.isNew();

		CirculationRuleModelImpl circulationRuleModelImpl = (CirculationRuleModelImpl)circulationRule;

		Session session = null;

		try {
			session = openSession();

			if (circulationRule.isNew()) {
				session.save(circulationRule);

				circulationRule.setNew(false);
			}
			else {
				session.merge(circulationRule);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CirculationRuleModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((circulationRuleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						circulationRuleModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] { circulationRuleModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((circulationRuleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						circulationRuleModelImpl.getOriginalCompanyId(),
						circulationRuleModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);

				args = new Object[] {
						circulationRuleModelImpl.getCompanyId(),
						circulationRuleModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);
			}

			if ((circulationRuleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						circulationRuleModelImpl.getOriginalCompanyId(),
						circulationRuleModelImpl.getOriginalLibraryId(),
						circulationRuleModelImpl.getOriginalItemTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ITEMTYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMTYPE,
					args);

				args = new Object[] {
						circulationRuleModelImpl.getCompanyId(),
						circulationRuleModelImpl.getLibraryId(),
						circulationRuleModelImpl.getItemTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ITEMTYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMTYPE,
					args);
			}

			if ((circulationRuleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PATRONCATEGORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						circulationRuleModelImpl.getOriginalCompanyId(),
						circulationRuleModelImpl.getOriginalLibraryId(),
						circulationRuleModelImpl.getOriginalPatronCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PATRONCATEGORY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PATRONCATEGORY,
					args);

				args = new Object[] {
						circulationRuleModelImpl.getCompanyId(),
						circulationRuleModelImpl.getLibraryId(),
						circulationRuleModelImpl.getPatronCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PATRONCATEGORY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PATRONCATEGORY,
					args);
			}

			if ((circulationRuleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMTYPEPATRONCATEGORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						circulationRuleModelImpl.getOriginalCompanyId(),
						circulationRuleModelImpl.getOriginalLibraryId(),
						circulationRuleModelImpl.getOriginalPatronCategoryId(),
						circulationRuleModelImpl.getOriginalItemTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ITEMTYPEPATRONCATEGORY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMTYPEPATRONCATEGORY,
					args);

				args = new Object[] {
						circulationRuleModelImpl.getCompanyId(),
						circulationRuleModelImpl.getLibraryId(),
						circulationRuleModelImpl.getPatronCategoryId(),
						circulationRuleModelImpl.getItemTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ITEMTYPEPATRONCATEGORY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMTYPEPATRONCATEGORY,
					args);
			}
		}

		EntityCacheUtil.putResult(CirculationRuleModelImpl.ENTITY_CACHE_ENABLED,
			CirculationRuleImpl.class, circulationRule.getPrimaryKey(),
			circulationRule);

		clearUniqueFindersCache(circulationRule);
		cacheUniqueFindersCache(circulationRule);

		return circulationRule;
	}

	protected CirculationRule toUnwrappedModel(CirculationRule circulationRule) {
		if (circulationRule instanceof CirculationRuleImpl) {
			return circulationRule;
		}

		CirculationRuleImpl circulationRuleImpl = new CirculationRuleImpl();

		circulationRuleImpl.setNew(circulationRule.isNew());
		circulationRuleImpl.setPrimaryKey(circulationRule.getPrimaryKey());

		circulationRuleImpl.setCirculationRuleId(circulationRule.getCirculationRuleId());
		circulationRuleImpl.setLibraryId(circulationRule.getLibraryId());
		circulationRuleImpl.setCompanyId(circulationRule.getCompanyId());
		circulationRuleImpl.setGroupId(circulationRule.getGroupId());
		circulationRuleImpl.setPatronCategoryId(circulationRule.getPatronCategoryId());
		circulationRuleImpl.setItemTypeId(circulationRule.getItemTypeId());
		circulationRuleImpl.setItemCategoryId(circulationRule.getItemCategoryId());
		circulationRuleImpl.setMaxCheckoutAllowed(circulationRule.getMaxCheckoutAllowed());
		circulationRuleImpl.setRenewalCountAllowed(circulationRule.getRenewalCountAllowed());
		circulationRuleImpl.setReservedCountAllowed(circulationRule.getReservedCountAllowed());
		circulationRuleImpl.setPeriodUnit(circulationRule.getPeriodUnit());
		circulationRuleImpl.setLoanPeriod(circulationRule.getLoanPeriod());
		circulationRuleImpl.setLoanPeriodIfReserved(circulationRule.getLoanPeriodIfReserved());
		circulationRuleImpl.setRentalCharge(circulationRule.getRentalCharge());
		circulationRuleImpl.setFinePerPeriod(circulationRule.getFinePerPeriod());
		circulationRuleImpl.setFineGracePeriod(circulationRule.getFineGracePeriod());
		circulationRuleImpl.setMaxFineAmount(circulationRule.getMaxFineAmount());
		circulationRuleImpl.setUserId(circulationRule.getUserId());
		circulationRuleImpl.setCreatedDate(circulationRule.getCreatedDate());

		return circulationRuleImpl;
	}

	/**
	 * Returns the circulation rule with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the circulation rule
	 * @return the circulation rule
	 * @throws com.kencana.lms.NoSuchCirculationRuleException if a circulation rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationRule findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCirculationRuleException, SystemException {
		CirculationRule circulationRule = fetchByPrimaryKey(primaryKey);

		if (circulationRule == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCirculationRuleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return circulationRule;
	}

	/**
	 * Returns the circulation rule with the primary key or throws a {@link com.kencana.lms.NoSuchCirculationRuleException} if it could not be found.
	 *
	 * @param circulationRuleId the primary key of the circulation rule
	 * @return the circulation rule
	 * @throws com.kencana.lms.NoSuchCirculationRuleException if a circulation rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationRule findByPrimaryKey(long circulationRuleId)
		throws NoSuchCirculationRuleException, SystemException {
		return findByPrimaryKey((Serializable)circulationRuleId);
	}

	/**
	 * Returns the circulation rule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the circulation rule
	 * @return the circulation rule, or <code>null</code> if a circulation rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationRule fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CirculationRule circulationRule = (CirculationRule)EntityCacheUtil.getResult(CirculationRuleModelImpl.ENTITY_CACHE_ENABLED,
				CirculationRuleImpl.class, primaryKey);

		if (circulationRule == _nullCirculationRule) {
			return null;
		}

		if (circulationRule == null) {
			Session session = null;

			try {
				session = openSession();

				circulationRule = (CirculationRule)session.get(CirculationRuleImpl.class,
						primaryKey);

				if (circulationRule != null) {
					cacheResult(circulationRule);
				}
				else {
					EntityCacheUtil.putResult(CirculationRuleModelImpl.ENTITY_CACHE_ENABLED,
						CirculationRuleImpl.class, primaryKey,
						_nullCirculationRule);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CirculationRuleModelImpl.ENTITY_CACHE_ENABLED,
					CirculationRuleImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return circulationRule;
	}

	/**
	 * Returns the circulation rule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param circulationRuleId the primary key of the circulation rule
	 * @return the circulation rule, or <code>null</code> if a circulation rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CirculationRule fetchByPrimaryKey(long circulationRuleId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)circulationRuleId);
	}

	/**
	 * Returns all the circulation rules.
	 *
	 * @return the circulation rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CirculationRule> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the circulation rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of circulation rules
	 * @param end the upper bound of the range of circulation rules (not inclusive)
	 * @return the range of circulation rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CirculationRule> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the circulation rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CirculationRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of circulation rules
	 * @param end the upper bound of the range of circulation rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of circulation rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CirculationRule> findAll(int start, int end,
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

		List<CirculationRule> list = (List<CirculationRule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CIRCULATIONRULE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CIRCULATIONRULE;

				if (pagination) {
					sql = sql.concat(CirculationRuleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CirculationRule>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CirculationRule>(list);
				}
				else {
					list = (List<CirculationRule>)QueryUtil.list(q,
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
	 * Removes all the circulation rules from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CirculationRule circulationRule : findAll()) {
			remove(circulationRule);
		}
	}

	/**
	 * Returns the number of circulation rules.
	 *
	 * @return the number of circulation rules
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

				Query q = session.createQuery(_SQL_COUNT_CIRCULATIONRULE);

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
	 * Initializes the circulation rule persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.kencana.lms.model.CirculationRule")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CirculationRule>> listenersList = new ArrayList<ModelListener<CirculationRule>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CirculationRule>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CirculationRuleImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CIRCULATIONRULE = "SELECT circulationRule FROM CirculationRule circulationRule";
	private static final String _SQL_SELECT_CIRCULATIONRULE_WHERE = "SELECT circulationRule FROM CirculationRule circulationRule WHERE ";
	private static final String _SQL_COUNT_CIRCULATIONRULE = "SELECT COUNT(circulationRule) FROM CirculationRule circulationRule";
	private static final String _SQL_COUNT_CIRCULATIONRULE_WHERE = "SELECT COUNT(circulationRule) FROM CirculationRule circulationRule WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "circulationRule.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CirculationRule exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CirculationRule exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CirculationRulePersistenceImpl.class);
	private static CirculationRule _nullCirculationRule = new CirculationRuleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CirculationRule> toCacheModel() {
				return _nullCirculationRuleCacheModel;
			}
		};

	private static CacheModel<CirculationRule> _nullCirculationRuleCacheModel = new CacheModel<CirculationRule>() {
			@Override
			public CirculationRule toEntityModel() {
				return _nullCirculationRule;
			}
		};
}