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

import com.kencana.lms.NoSuchPatronCategoryException;
import com.kencana.lms.model.PatronCategory;
import com.kencana.lms.model.impl.PatronCategoryImpl;
import com.kencana.lms.model.impl.PatronCategoryModelImpl;

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
 * The persistence implementation for the patron category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see PatronCategoryPersistence
 * @see PatronCategoryUtil
 * @generated
 */
public class PatronCategoryPersistenceImpl extends BasePersistenceImpl<PatronCategory>
	implements PatronCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PatronCategoryUtil} to access the patron category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PatronCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PatronCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PatronCategoryModelImpl.FINDER_CACHE_ENABLED,
			PatronCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PatronCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PatronCategoryModelImpl.FINDER_CACHE_ENABLED,
			PatronCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PatronCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PatronCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(PatronCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PatronCategoryModelImpl.FINDER_CACHE_ENABLED,
			PatronCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompanyGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(PatronCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PatronCategoryModelImpl.FINDER_CACHE_ENABLED,
			PatronCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			PatronCategoryModelImpl.COMPANYID_COLUMN_BITMASK |
			PatronCategoryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYGROUP = new FinderPath(PatronCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PatronCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the patron categories where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching patron categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatronCategory> findByCompanyGroup(long companyId, long groupId)
		throws SystemException {
		return findByCompanyGroup(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the patron categories where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of patron categories
	 * @param end the upper bound of the range of patron categories (not inclusive)
	 * @return the range of matching patron categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatronCategory> findByCompanyGroup(long companyId,
		long groupId, int start, int end) throws SystemException {
		return findByCompanyGroup(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the patron categories where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of patron categories
	 * @param end the upper bound of the range of patron categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patron categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatronCategory> findByCompanyGroup(long companyId,
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

		List<PatronCategory> list = (List<PatronCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PatronCategory patronCategory : list) {
				if ((companyId != patronCategory.getCompanyId()) ||
						(groupId != patronCategory.getGroupId())) {
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

			query.append(_SQL_SELECT_PATRONCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_COMPANYGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PatronCategoryModelImpl.ORDER_BY_JPQL);
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
					list = (List<PatronCategory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PatronCategory>(list);
				}
				else {
					list = (List<PatronCategory>)QueryUtil.list(q,
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
	 * Returns the first patron category in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patron category
	 * @throws com.kencana.lms.NoSuchPatronCategoryException if a matching patron category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronCategory findByCompanyGroup_First(long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchPatronCategoryException, SystemException {
		PatronCategory patronCategory = fetchByCompanyGroup_First(companyId,
				groupId, orderByComparator);

		if (patronCategory != null) {
			return patronCategory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPatronCategoryException(msg.toString());
	}

	/**
	 * Returns the first patron category in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patron category, or <code>null</code> if a matching patron category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronCategory fetchByCompanyGroup_First(long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<PatronCategory> list = findByCompanyGroup(companyId, groupId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last patron category in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patron category
	 * @throws com.kencana.lms.NoSuchPatronCategoryException if a matching patron category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronCategory findByCompanyGroup_Last(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPatronCategoryException, SystemException {
		PatronCategory patronCategory = fetchByCompanyGroup_Last(companyId,
				groupId, orderByComparator);

		if (patronCategory != null) {
			return patronCategory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPatronCategoryException(msg.toString());
	}

	/**
	 * Returns the last patron category in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patron category, or <code>null</code> if a matching patron category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronCategory fetchByCompanyGroup_Last(long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCompanyGroup(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<PatronCategory> list = findByCompanyGroup(companyId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the patron categories before and after the current patron category in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param patronCategoryId the primary key of the current patron category
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patron category
	 * @throws com.kencana.lms.NoSuchPatronCategoryException if a patron category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronCategory[] findByCompanyGroup_PrevAndNext(
		long patronCategoryId, long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPatronCategoryException, SystemException {
		PatronCategory patronCategory = findByPrimaryKey(patronCategoryId);

		Session session = null;

		try {
			session = openSession();

			PatronCategory[] array = new PatronCategoryImpl[3];

			array[0] = getByCompanyGroup_PrevAndNext(session, patronCategory,
					companyId, groupId, orderByComparator, true);

			array[1] = patronCategory;

			array[2] = getByCompanyGroup_PrevAndNext(session, patronCategory,
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

	protected PatronCategory getByCompanyGroup_PrevAndNext(Session session,
		PatronCategory patronCategory, long companyId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PATRONCATEGORY_WHERE);

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
			query.append(PatronCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(patronCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PatronCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the patron categories where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyGroup(long companyId, long groupId)
		throws SystemException {
		for (PatronCategory patronCategory : findByCompanyGroup(companyId,
				groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(patronCategory);
		}
	}

	/**
	 * Returns the number of patron categories where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching patron categories
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

			query.append(_SQL_COUNT_PATRONCATEGORY_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANYGROUP_COMPANYID_2 = "patronCategory.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYGROUP_GROUPID_2 = "patronCategory.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(PatronCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PatronCategoryModelImpl.FINDER_CACHE_ENABLED,
			PatronCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompany",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(PatronCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PatronCategoryModelImpl.FINDER_CACHE_ENABLED,
			PatronCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			PatronCategoryModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(PatronCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PatronCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the patron categories where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching patron categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatronCategory> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the patron categories where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of patron categories
	 * @param end the upper bound of the range of patron categories (not inclusive)
	 * @return the range of matching patron categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatronCategory> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the patron categories where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of patron categories
	 * @param end the upper bound of the range of patron categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patron categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatronCategory> findByCompany(long companyId, int start,
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

		List<PatronCategory> list = (List<PatronCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PatronCategory patronCategory : list) {
				if ((companyId != patronCategory.getCompanyId())) {
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

			query.append(_SQL_SELECT_PATRONCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PatronCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<PatronCategory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PatronCategory>(list);
				}
				else {
					list = (List<PatronCategory>)QueryUtil.list(q,
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
	 * Returns the first patron category in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patron category
	 * @throws com.kencana.lms.NoSuchPatronCategoryException if a matching patron category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronCategory findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPatronCategoryException, SystemException {
		PatronCategory patronCategory = fetchByCompany_First(companyId,
				orderByComparator);

		if (patronCategory != null) {
			return patronCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPatronCategoryException(msg.toString());
	}

	/**
	 * Returns the first patron category in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patron category, or <code>null</code> if a matching patron category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronCategory fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PatronCategory> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last patron category in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patron category
	 * @throws com.kencana.lms.NoSuchPatronCategoryException if a matching patron category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronCategory findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPatronCategoryException, SystemException {
		PatronCategory patronCategory = fetchByCompany_Last(companyId,
				orderByComparator);

		if (patronCategory != null) {
			return patronCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPatronCategoryException(msg.toString());
	}

	/**
	 * Returns the last patron category in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patron category, or <code>null</code> if a matching patron category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronCategory fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		if (count == 0) {
			return null;
		}

		List<PatronCategory> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the patron categories before and after the current patron category in the ordered set where companyId = &#63;.
	 *
	 * @param patronCategoryId the primary key of the current patron category
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patron category
	 * @throws com.kencana.lms.NoSuchPatronCategoryException if a patron category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronCategory[] findByCompany_PrevAndNext(long patronCategoryId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchPatronCategoryException, SystemException {
		PatronCategory patronCategory = findByPrimaryKey(patronCategoryId);

		Session session = null;

		try {
			session = openSession();

			PatronCategory[] array = new PatronCategoryImpl[3];

			array[0] = getByCompany_PrevAndNext(session, patronCategory,
					companyId, orderByComparator, true);

			array[1] = patronCategory;

			array[2] = getByCompany_PrevAndNext(session, patronCategory,
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

	protected PatronCategory getByCompany_PrevAndNext(Session session,
		PatronCategory patronCategory, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PATRONCATEGORY_WHERE);

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
			query.append(PatronCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(patronCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PatronCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the patron categories where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompany(long companyId) throws SystemException {
		for (PatronCategory patronCategory : findByCompany(companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(patronCategory);
		}
	}

	/**
	 * Returns the number of patron categories where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching patron categories
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

			query.append(_SQL_COUNT_PATRONCATEGORY_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "patronCategory.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(PatronCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PatronCategoryModelImpl.FINDER_CACHE_ENABLED,
			PatronCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBygroup",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(PatronCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PatronCategoryModelImpl.FINDER_CACHE_ENABLED,
			PatronCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBygroup",
			new String[] { Long.class.getName() },
			PatronCategoryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(PatronCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PatronCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBygroup",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the patron categories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching patron categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatronCategory> findBygroup(long groupId)
		throws SystemException {
		return findBygroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the patron categories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of patron categories
	 * @param end the upper bound of the range of patron categories (not inclusive)
	 * @return the range of matching patron categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatronCategory> findBygroup(long groupId, int start, int end)
		throws SystemException {
		return findBygroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the patron categories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of patron categories
	 * @param end the upper bound of the range of patron categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patron categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatronCategory> findBygroup(long groupId, int start, int end,
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

		List<PatronCategory> list = (List<PatronCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PatronCategory patronCategory : list) {
				if ((groupId != patronCategory.getGroupId())) {
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

			query.append(_SQL_SELECT_PATRONCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PatronCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<PatronCategory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PatronCategory>(list);
				}
				else {
					list = (List<PatronCategory>)QueryUtil.list(q,
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
	 * Returns the first patron category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patron category
	 * @throws com.kencana.lms.NoSuchPatronCategoryException if a matching patron category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronCategory findBygroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPatronCategoryException, SystemException {
		PatronCategory patronCategory = fetchBygroup_First(groupId,
				orderByComparator);

		if (patronCategory != null) {
			return patronCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPatronCategoryException(msg.toString());
	}

	/**
	 * Returns the first patron category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patron category, or <code>null</code> if a matching patron category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronCategory fetchBygroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PatronCategory> list = findBygroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last patron category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patron category
	 * @throws com.kencana.lms.NoSuchPatronCategoryException if a matching patron category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronCategory findBygroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPatronCategoryException, SystemException {
		PatronCategory patronCategory = fetchBygroup_Last(groupId,
				orderByComparator);

		if (patronCategory != null) {
			return patronCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPatronCategoryException(msg.toString());
	}

	/**
	 * Returns the last patron category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patron category, or <code>null</code> if a matching patron category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronCategory fetchBygroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBygroup(groupId);

		if (count == 0) {
			return null;
		}

		List<PatronCategory> list = findBygroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the patron categories before and after the current patron category in the ordered set where groupId = &#63;.
	 *
	 * @param patronCategoryId the primary key of the current patron category
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patron category
	 * @throws com.kencana.lms.NoSuchPatronCategoryException if a patron category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronCategory[] findBygroup_PrevAndNext(long patronCategoryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchPatronCategoryException, SystemException {
		PatronCategory patronCategory = findByPrimaryKey(patronCategoryId);

		Session session = null;

		try {
			session = openSession();

			PatronCategory[] array = new PatronCategoryImpl[3];

			array[0] = getBygroup_PrevAndNext(session, patronCategory, groupId,
					orderByComparator, true);

			array[1] = patronCategory;

			array[2] = getBygroup_PrevAndNext(session, patronCategory, groupId,
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

	protected PatronCategory getBygroup_PrevAndNext(Session session,
		PatronCategory patronCategory, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PATRONCATEGORY_WHERE);

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
			query.append(PatronCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(patronCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PatronCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the patron categories where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBygroup(long groupId) throws SystemException {
		for (PatronCategory patronCategory : findBygroup(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(patronCategory);
		}
	}

	/**
	 * Returns the number of patron categories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching patron categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBygroup(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUP;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PATRONCATEGORY_WHERE);

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

	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "patronCategory.groupId = ?";

	public PatronCategoryPersistenceImpl() {
		setModelClass(PatronCategory.class);
	}

	/**
	 * Caches the patron category in the entity cache if it is enabled.
	 *
	 * @param patronCategory the patron category
	 */
	@Override
	public void cacheResult(PatronCategory patronCategory) {
		EntityCacheUtil.putResult(PatronCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PatronCategoryImpl.class, patronCategory.getPrimaryKey(),
			patronCategory);

		patronCategory.resetOriginalValues();
	}

	/**
	 * Caches the patron categories in the entity cache if it is enabled.
	 *
	 * @param patronCategories the patron categories
	 */
	@Override
	public void cacheResult(List<PatronCategory> patronCategories) {
		for (PatronCategory patronCategory : patronCategories) {
			if (EntityCacheUtil.getResult(
						PatronCategoryModelImpl.ENTITY_CACHE_ENABLED,
						PatronCategoryImpl.class, patronCategory.getPrimaryKey()) == null) {
				cacheResult(patronCategory);
			}
			else {
				patronCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all patron categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PatronCategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PatronCategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the patron category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PatronCategory patronCategory) {
		EntityCacheUtil.removeResult(PatronCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PatronCategoryImpl.class, patronCategory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PatronCategory> patronCategories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PatronCategory patronCategory : patronCategories) {
			EntityCacheUtil.removeResult(PatronCategoryModelImpl.ENTITY_CACHE_ENABLED,
				PatronCategoryImpl.class, patronCategory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new patron category with the primary key. Does not add the patron category to the database.
	 *
	 * @param patronCategoryId the primary key for the new patron category
	 * @return the new patron category
	 */
	@Override
	public PatronCategory create(long patronCategoryId) {
		PatronCategory patronCategory = new PatronCategoryImpl();

		patronCategory.setNew(true);
		patronCategory.setPrimaryKey(patronCategoryId);

		return patronCategory;
	}

	/**
	 * Removes the patron category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param patronCategoryId the primary key of the patron category
	 * @return the patron category that was removed
	 * @throws com.kencana.lms.NoSuchPatronCategoryException if a patron category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronCategory remove(long patronCategoryId)
		throws NoSuchPatronCategoryException, SystemException {
		return remove((Serializable)patronCategoryId);
	}

	/**
	 * Removes the patron category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the patron category
	 * @return the patron category that was removed
	 * @throws com.kencana.lms.NoSuchPatronCategoryException if a patron category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronCategory remove(Serializable primaryKey)
		throws NoSuchPatronCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PatronCategory patronCategory = (PatronCategory)session.get(PatronCategoryImpl.class,
					primaryKey);

			if (patronCategory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPatronCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(patronCategory);
		}
		catch (NoSuchPatronCategoryException nsee) {
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
	protected PatronCategory removeImpl(PatronCategory patronCategory)
		throws SystemException {
		patronCategory = toUnwrappedModel(patronCategory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(patronCategory)) {
				patronCategory = (PatronCategory)session.get(PatronCategoryImpl.class,
						patronCategory.getPrimaryKeyObj());
			}

			if (patronCategory != null) {
				session.delete(patronCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (patronCategory != null) {
			clearCache(patronCategory);
		}

		return patronCategory;
	}

	@Override
	public PatronCategory updateImpl(
		com.kencana.lms.model.PatronCategory patronCategory)
		throws SystemException {
		patronCategory = toUnwrappedModel(patronCategory);

		boolean isNew = patronCategory.isNew();

		PatronCategoryModelImpl patronCategoryModelImpl = (PatronCategoryModelImpl)patronCategory;

		Session session = null;

		try {
			session = openSession();

			if (patronCategory.isNew()) {
				session.save(patronCategory);

				patronCategory.setNew(false);
			}
			else {
				session.merge(patronCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PatronCategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((patronCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						patronCategoryModelImpl.getOriginalCompanyId(),
						patronCategoryModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);

				args = new Object[] {
						patronCategoryModelImpl.getCompanyId(),
						patronCategoryModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);
			}

			if ((patronCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						patronCategoryModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] { patronCategoryModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((patronCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						patronCategoryModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] { patronCategoryModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(PatronCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PatronCategoryImpl.class, patronCategory.getPrimaryKey(),
			patronCategory);

		return patronCategory;
	}

	protected PatronCategory toUnwrappedModel(PatronCategory patronCategory) {
		if (patronCategory instanceof PatronCategoryImpl) {
			return patronCategory;
		}

		PatronCategoryImpl patronCategoryImpl = new PatronCategoryImpl();

		patronCategoryImpl.setNew(patronCategory.isNew());
		patronCategoryImpl.setPrimaryKey(patronCategory.getPrimaryKey());

		patronCategoryImpl.setPatronCategoryId(patronCategory.getPatronCategoryId());
		patronCategoryImpl.setPatronCategoryName(patronCategory.getPatronCategoryName());
		patronCategoryImpl.setNotes(patronCategory.getNotes());
		patronCategoryImpl.setGroupId(patronCategory.getGroupId());
		patronCategoryImpl.setCompanyId(patronCategory.getCompanyId());

		return patronCategoryImpl;
	}

	/**
	 * Returns the patron category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the patron category
	 * @return the patron category
	 * @throws com.kencana.lms.NoSuchPatronCategoryException if a patron category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPatronCategoryException, SystemException {
		PatronCategory patronCategory = fetchByPrimaryKey(primaryKey);

		if (patronCategory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPatronCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return patronCategory;
	}

	/**
	 * Returns the patron category with the primary key or throws a {@link com.kencana.lms.NoSuchPatronCategoryException} if it could not be found.
	 *
	 * @param patronCategoryId the primary key of the patron category
	 * @return the patron category
	 * @throws com.kencana.lms.NoSuchPatronCategoryException if a patron category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronCategory findByPrimaryKey(long patronCategoryId)
		throws NoSuchPatronCategoryException, SystemException {
		return findByPrimaryKey((Serializable)patronCategoryId);
	}

	/**
	 * Returns the patron category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the patron category
	 * @return the patron category, or <code>null</code> if a patron category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronCategory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PatronCategory patronCategory = (PatronCategory)EntityCacheUtil.getResult(PatronCategoryModelImpl.ENTITY_CACHE_ENABLED,
				PatronCategoryImpl.class, primaryKey);

		if (patronCategory == _nullPatronCategory) {
			return null;
		}

		if (patronCategory == null) {
			Session session = null;

			try {
				session = openSession();

				patronCategory = (PatronCategory)session.get(PatronCategoryImpl.class,
						primaryKey);

				if (patronCategory != null) {
					cacheResult(patronCategory);
				}
				else {
					EntityCacheUtil.putResult(PatronCategoryModelImpl.ENTITY_CACHE_ENABLED,
						PatronCategoryImpl.class, primaryKey,
						_nullPatronCategory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PatronCategoryModelImpl.ENTITY_CACHE_ENABLED,
					PatronCategoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return patronCategory;
	}

	/**
	 * Returns the patron category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param patronCategoryId the primary key of the patron category
	 * @return the patron category, or <code>null</code> if a patron category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatronCategory fetchByPrimaryKey(long patronCategoryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)patronCategoryId);
	}

	/**
	 * Returns all the patron categories.
	 *
	 * @return the patron categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatronCategory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the patron categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of patron categories
	 * @param end the upper bound of the range of patron categories (not inclusive)
	 * @return the range of patron categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatronCategory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the patron categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of patron categories
	 * @param end the upper bound of the range of patron categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of patron categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatronCategory> findAll(int start, int end,
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

		List<PatronCategory> list = (List<PatronCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PATRONCATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PATRONCATEGORY;

				if (pagination) {
					sql = sql.concat(PatronCategoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PatronCategory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PatronCategory>(list);
				}
				else {
					list = (List<PatronCategory>)QueryUtil.list(q,
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
	 * Removes all the patron categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PatronCategory patronCategory : findAll()) {
			remove(patronCategory);
		}
	}

	/**
	 * Returns the number of patron categories.
	 *
	 * @return the number of patron categories
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

				Query q = session.createQuery(_SQL_COUNT_PATRONCATEGORY);

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
	 * Initializes the patron category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.kencana.lms.model.PatronCategory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PatronCategory>> listenersList = new ArrayList<ModelListener<PatronCategory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PatronCategory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PatronCategoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PATRONCATEGORY = "SELECT patronCategory FROM PatronCategory patronCategory";
	private static final String _SQL_SELECT_PATRONCATEGORY_WHERE = "SELECT patronCategory FROM PatronCategory patronCategory WHERE ";
	private static final String _SQL_COUNT_PATRONCATEGORY = "SELECT COUNT(patronCategory) FROM PatronCategory patronCategory";
	private static final String _SQL_COUNT_PATRONCATEGORY_WHERE = "SELECT COUNT(patronCategory) FROM PatronCategory patronCategory WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "patronCategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PatronCategory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PatronCategory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PatronCategoryPersistenceImpl.class);
	private static PatronCategory _nullPatronCategory = new PatronCategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PatronCategory> toCacheModel() {
				return _nullPatronCategoryCacheModel;
			}
		};

	private static CacheModel<PatronCategory> _nullPatronCategoryCacheModel = new CacheModel<PatronCategory>() {
			@Override
			public PatronCategory toEntityModel() {
				return _nullPatronCategory;
			}
		};
}