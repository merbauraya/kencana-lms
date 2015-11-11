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

import com.kencana.lms.NoSuchPatronException;
import com.kencana.lms.model.Patron;
import com.kencana.lms.model.impl.PatronImpl;
import com.kencana.lms.model.impl.PatronModelImpl;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the patron service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see PatronPersistence
 * @see PatronUtil
 * @generated
 */
public class PatronPersistenceImpl extends BasePersistenceImpl<Patron>
	implements PatronPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PatronUtil} to access the patron persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PatronImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PatronModelImpl.ENTITY_CACHE_ENABLED,
			PatronModelImpl.FINDER_CACHE_ENABLED, PatronImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PatronModelImpl.ENTITY_CACHE_ENABLED,
			PatronModelImpl.FINDER_CACHE_ENABLED, PatronImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PatronModelImpl.ENTITY_CACHE_ENABLED,
			PatronModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_USERID = new FinderPath(PatronModelImpl.ENTITY_CACHE_ENABLED,
			PatronModelImpl.FINDER_CACHE_ENABLED, PatronImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUserId",
			new String[] { Long.class.getName() },
			PatronModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(PatronModelImpl.ENTITY_CACHE_ENABLED,
			PatronModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the patron where userId = &#63; or throws a {@link com.kencana.lms.NoSuchPatronException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching patron
	 * @throws com.kencana.lms.NoSuchPatronException if a matching patron could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Patron findByUserId(long userId)
		throws NoSuchPatronException, SystemException {
		Patron patron = fetchByUserId(userId);

		if (patron == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchPatronException(msg.toString());
		}

		return patron;
	}

	/**
	 * Returns the patron where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching patron, or <code>null</code> if a matching patron could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Patron fetchByUserId(long userId) throws SystemException {
		return fetchByUserId(userId, true);
	}

	/**
	 * Returns the patron where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching patron, or <code>null</code> if a matching patron could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Patron fetchByUserId(long userId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERID,
					finderArgs, this);
		}

		if (result instanceof Patron) {
			Patron patron = (Patron)result;

			if ((userId != patron.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PATRON_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				List<Patron> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"PatronPersistenceImpl.fetchByUserId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Patron patron = list.get(0);

					result = patron;

					cacheResult(patron);

					if ((patron.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
							finderArgs, patron);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID,
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
			return (Patron)result;
		}
	}

	/**
	 * Removes the patron where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the patron that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Patron removeByUserId(long userId)
		throws NoSuchPatronException, SystemException {
		Patron patron = findByUserId(userId);

		return remove(patron);
	}

	/**
	 * Returns the number of patrons where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching patrons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PATRON_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "patron.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LIBRARYID =
		new FinderPath(PatronModelImpl.ENTITY_CACHE_ENABLED,
			PatronModelImpl.FINDER_CACHE_ENABLED, PatronImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLibraryId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYID =
		new FinderPath(PatronModelImpl.ENTITY_CACHE_ENABLED,
			PatronModelImpl.FINDER_CACHE_ENABLED, PatronImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLibraryId",
			new String[] { Long.class.getName(), Long.class.getName() },
			PatronModelImpl.COMPANYID_COLUMN_BITMASK |
			PatronModelImpl.LIBRARYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LIBRARYID = new FinderPath(PatronModelImpl.ENTITY_CACHE_ENABLED,
			PatronModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLibraryId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the patrons where companyId = &#63; and libraryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @return the matching patrons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Patron> findByLibraryId(long companyId, long libraryId)
		throws SystemException {
		return findByLibraryId(companyId, libraryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the patrons where companyId = &#63; and libraryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param start the lower bound of the range of patrons
	 * @param end the upper bound of the range of patrons (not inclusive)
	 * @return the range of matching patrons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Patron> findByLibraryId(long companyId, long libraryId,
		int start, int end) throws SystemException {
		return findByLibraryId(companyId, libraryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the patrons where companyId = &#63; and libraryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param start the lower bound of the range of patrons
	 * @param end the upper bound of the range of patrons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patrons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Patron> findByLibraryId(long companyId, long libraryId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYID;
			finderArgs = new Object[] { companyId, libraryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LIBRARYID;
			finderArgs = new Object[] {
					companyId, libraryId,
					
					start, end, orderByComparator
				};
		}

		List<Patron> list = (List<Patron>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Patron patron : list) {
				if ((companyId != patron.getCompanyId()) ||
						(libraryId != patron.getLibraryId())) {
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

			query.append(_SQL_SELECT_PATRON_WHERE);

			query.append(_FINDER_COLUMN_LIBRARYID_COMPANYID_2);

			query.append(_FINDER_COLUMN_LIBRARYID_LIBRARYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PatronModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(libraryId);

				if (!pagination) {
					list = (List<Patron>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Patron>(list);
				}
				else {
					list = (List<Patron>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first patron in the ordered set where companyId = &#63; and libraryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patron
	 * @throws com.kencana.lms.NoSuchPatronException if a matching patron could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Patron findByLibraryId_First(long companyId, long libraryId,
		OrderByComparator orderByComparator)
		throws NoSuchPatronException, SystemException {
		Patron patron = fetchByLibraryId_First(companyId, libraryId,
				orderByComparator);

		if (patron != null) {
			return patron;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", libraryId=");
		msg.append(libraryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPatronException(msg.toString());
	}

	/**
	 * Returns the first patron in the ordered set where companyId = &#63; and libraryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patron, or <code>null</code> if a matching patron could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Patron fetchByLibraryId_First(long companyId, long libraryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Patron> list = findByLibraryId(companyId, libraryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last patron in the ordered set where companyId = &#63; and libraryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patron
	 * @throws com.kencana.lms.NoSuchPatronException if a matching patron could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Patron findByLibraryId_Last(long companyId, long libraryId,
		OrderByComparator orderByComparator)
		throws NoSuchPatronException, SystemException {
		Patron patron = fetchByLibraryId_Last(companyId, libraryId,
				orderByComparator);

		if (patron != null) {
			return patron;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", libraryId=");
		msg.append(libraryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPatronException(msg.toString());
	}

	/**
	 * Returns the last patron in the ordered set where companyId = &#63; and libraryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patron, or <code>null</code> if a matching patron could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Patron fetchByLibraryId_Last(long companyId, long libraryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLibraryId(companyId, libraryId);

		if (count == 0) {
			return null;
		}

		List<Patron> list = findByLibraryId(companyId, libraryId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the patrons before and after the current patron in the ordered set where companyId = &#63; and libraryId = &#63;.
	 *
	 * @param patronId the primary key of the current patron
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patron
	 * @throws com.kencana.lms.NoSuchPatronException if a patron with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Patron[] findByLibraryId_PrevAndNext(long patronId, long companyId,
		long libraryId, OrderByComparator orderByComparator)
		throws NoSuchPatronException, SystemException {
		Patron patron = findByPrimaryKey(patronId);

		Session session = null;

		try {
			session = openSession();

			Patron[] array = new PatronImpl[3];

			array[0] = getByLibraryId_PrevAndNext(session, patron, companyId,
					libraryId, orderByComparator, true);

			array[1] = patron;

			array[2] = getByLibraryId_PrevAndNext(session, patron, companyId,
					libraryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Patron getByLibraryId_PrevAndNext(Session session, Patron patron,
		long companyId, long libraryId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PATRON_WHERE);

		query.append(_FINDER_COLUMN_LIBRARYID_COMPANYID_2);

		query.append(_FINDER_COLUMN_LIBRARYID_LIBRARYID_2);

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
			query.append(PatronModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(libraryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(patron);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Patron> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the patrons where companyId = &#63; and libraryId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLibraryId(long companyId, long libraryId)
		throws SystemException {
		for (Patron patron : findByLibraryId(companyId, libraryId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(patron);
		}
	}

	/**
	 * Returns the number of patrons where companyId = &#63; and libraryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param libraryId the library ID
	 * @return the number of matching patrons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLibraryId(long companyId, long libraryId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LIBRARYID;

		Object[] finderArgs = new Object[] { companyId, libraryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PATRON_WHERE);

			query.append(_FINDER_COLUMN_LIBRARYID_COMPANYID_2);

			query.append(_FINDER_COLUMN_LIBRARYID_LIBRARYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_LIBRARYID_COMPANYID_2 = "patron.companyId = ? AND ";
	private static final String _FINDER_COLUMN_LIBRARYID_LIBRARYID_2 = "patron.libraryId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_CARDNUMBER = new FinderPath(PatronModelImpl.ENTITY_CACHE_ENABLED,
			PatronModelImpl.FINDER_CACHE_ENABLED, PatronImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCardNumber",
			new String[] { String.class.getName() },
			PatronModelImpl.CARDNUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CARDNUMBER = new FinderPath(PatronModelImpl.ENTITY_CACHE_ENABLED,
			PatronModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCardNumber",
			new String[] { String.class.getName() });

	/**
	 * Returns the patron where cardNumber = &#63; or throws a {@link com.kencana.lms.NoSuchPatronException} if it could not be found.
	 *
	 * @param cardNumber the card number
	 * @return the matching patron
	 * @throws com.kencana.lms.NoSuchPatronException if a matching patron could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Patron findByCardNumber(String cardNumber)
		throws NoSuchPatronException, SystemException {
		Patron patron = fetchByCardNumber(cardNumber);

		if (patron == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("cardNumber=");
			msg.append(cardNumber);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchPatronException(msg.toString());
		}

		return patron;
	}

	/**
	 * Returns the patron where cardNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cardNumber the card number
	 * @return the matching patron, or <code>null</code> if a matching patron could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Patron fetchByCardNumber(String cardNumber)
		throws SystemException {
		return fetchByCardNumber(cardNumber, true);
	}

	/**
	 * Returns the patron where cardNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cardNumber the card number
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching patron, or <code>null</code> if a matching patron could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Patron fetchByCardNumber(String cardNumber, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { cardNumber };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CARDNUMBER,
					finderArgs, this);
		}

		if (result instanceof Patron) {
			Patron patron = (Patron)result;

			if (!Validator.equals(cardNumber, patron.getCardNumber())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PATRON_WHERE);

			boolean bindCardNumber = false;

			if (cardNumber == null) {
				query.append(_FINDER_COLUMN_CARDNUMBER_CARDNUMBER_1);
			}
			else if (cardNumber.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CARDNUMBER_CARDNUMBER_3);
			}
			else {
				bindCardNumber = true;

				query.append(_FINDER_COLUMN_CARDNUMBER_CARDNUMBER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCardNumber) {
					qPos.add(cardNumber);
				}

				List<Patron> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CARDNUMBER,
						finderArgs, list);
				}
				else {
					Patron patron = list.get(0);

					result = patron;

					cacheResult(patron);

					if ((patron.getCardNumber() == null) ||
							!patron.getCardNumber().equals(cardNumber)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CARDNUMBER,
							finderArgs, patron);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CARDNUMBER,
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
			return (Patron)result;
		}
	}

	/**
	 * Removes the patron where cardNumber = &#63; from the database.
	 *
	 * @param cardNumber the card number
	 * @return the patron that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Patron removeByCardNumber(String cardNumber)
		throws NoSuchPatronException, SystemException {
		Patron patron = findByCardNumber(cardNumber);

		return remove(patron);
	}

	/**
	 * Returns the number of patrons where cardNumber = &#63;.
	 *
	 * @param cardNumber the card number
	 * @return the number of matching patrons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCardNumber(String cardNumber) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CARDNUMBER;

		Object[] finderArgs = new Object[] { cardNumber };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PATRON_WHERE);

			boolean bindCardNumber = false;

			if (cardNumber == null) {
				query.append(_FINDER_COLUMN_CARDNUMBER_CARDNUMBER_1);
			}
			else if (cardNumber.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CARDNUMBER_CARDNUMBER_3);
			}
			else {
				bindCardNumber = true;

				query.append(_FINDER_COLUMN_CARDNUMBER_CARDNUMBER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCardNumber) {
					qPos.add(cardNumber);
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

	private static final String _FINDER_COLUMN_CARDNUMBER_CARDNUMBER_1 = "patron.cardNumber IS NULL";
	private static final String _FINDER_COLUMN_CARDNUMBER_CARDNUMBER_2 = "patron.cardNumber = ?";
	private static final String _FINDER_COLUMN_CARDNUMBER_CARDNUMBER_3 = "(patron.cardNumber IS NULL OR patron.cardNumber = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_STATUS =
		new FinderPath(PatronModelImpl.ENTITY_CACHE_ENABLED,
			PatronModelImpl.FINDER_CACHE_ENABLED, PatronImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G_Status",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_STATUS =
		new FinderPath(PatronModelImpl.ENTITY_CACHE_ENABLED,
			PatronModelImpl.FINDER_CACHE_ENABLED, PatronImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G_Status",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			PatronModelImpl.COMPANYID_COLUMN_BITMASK |
			PatronModelImpl.GROUPID_COLUMN_BITMASK |
			PatronModelImpl.PATRONSTATUSID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G_STATUS = new FinderPath(PatronModelImpl.ENTITY_CACHE_ENABLED,
			PatronModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_Status",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the patrons where companyId = &#63; and groupId = &#63; and patronStatusId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param patronStatusId the patron status ID
	 * @return the matching patrons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Patron> findByC_G_Status(long companyId, long groupId,
		long patronStatusId) throws SystemException {
		return findByC_G_Status(companyId, groupId, patronStatusId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the patrons where companyId = &#63; and groupId = &#63; and patronStatusId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param patronStatusId the patron status ID
	 * @param start the lower bound of the range of patrons
	 * @param end the upper bound of the range of patrons (not inclusive)
	 * @return the range of matching patrons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Patron> findByC_G_Status(long companyId, long groupId,
		long patronStatusId, int start, int end) throws SystemException {
		return findByC_G_Status(companyId, groupId, patronStatusId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the patrons where companyId = &#63; and groupId = &#63; and patronStatusId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param patronStatusId the patron status ID
	 * @param start the lower bound of the range of patrons
	 * @param end the upper bound of the range of patrons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patrons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Patron> findByC_G_Status(long companyId, long groupId,
		long patronStatusId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_STATUS;
			finderArgs = new Object[] { companyId, groupId, patronStatusId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_STATUS;
			finderArgs = new Object[] {
					companyId, groupId, patronStatusId,
					
					start, end, orderByComparator
				};
		}

		List<Patron> list = (List<Patron>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Patron patron : list) {
				if ((companyId != patron.getCompanyId()) ||
						(groupId != patron.getGroupId()) ||
						(patronStatusId != patron.getPatronStatusId())) {
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

			query.append(_SQL_SELECT_PATRON_WHERE);

			query.append(_FINDER_COLUMN_C_G_STATUS_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_STATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_C_G_STATUS_PATRONSTATUSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PatronModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(patronStatusId);

				if (!pagination) {
					list = (List<Patron>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Patron>(list);
				}
				else {
					list = (List<Patron>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first patron in the ordered set where companyId = &#63; and groupId = &#63; and patronStatusId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param patronStatusId the patron status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patron
	 * @throws com.kencana.lms.NoSuchPatronException if a matching patron could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Patron findByC_G_Status_First(long companyId, long groupId,
		long patronStatusId, OrderByComparator orderByComparator)
		throws NoSuchPatronException, SystemException {
		Patron patron = fetchByC_G_Status_First(companyId, groupId,
				patronStatusId, orderByComparator);

		if (patron != null) {
			return patron;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", patronStatusId=");
		msg.append(patronStatusId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPatronException(msg.toString());
	}

	/**
	 * Returns the first patron in the ordered set where companyId = &#63; and groupId = &#63; and patronStatusId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param patronStatusId the patron status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patron, or <code>null</code> if a matching patron could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Patron fetchByC_G_Status_First(long companyId, long groupId,
		long patronStatusId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Patron> list = findByC_G_Status(companyId, groupId,
				patronStatusId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last patron in the ordered set where companyId = &#63; and groupId = &#63; and patronStatusId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param patronStatusId the patron status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patron
	 * @throws com.kencana.lms.NoSuchPatronException if a matching patron could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Patron findByC_G_Status_Last(long companyId, long groupId,
		long patronStatusId, OrderByComparator orderByComparator)
		throws NoSuchPatronException, SystemException {
		Patron patron = fetchByC_G_Status_Last(companyId, groupId,
				patronStatusId, orderByComparator);

		if (patron != null) {
			return patron;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", patronStatusId=");
		msg.append(patronStatusId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPatronException(msg.toString());
	}

	/**
	 * Returns the last patron in the ordered set where companyId = &#63; and groupId = &#63; and patronStatusId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param patronStatusId the patron status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patron, or <code>null</code> if a matching patron could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Patron fetchByC_G_Status_Last(long companyId, long groupId,
		long patronStatusId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_G_Status(companyId, groupId, patronStatusId);

		if (count == 0) {
			return null;
		}

		List<Patron> list = findByC_G_Status(companyId, groupId,
				patronStatusId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the patrons before and after the current patron in the ordered set where companyId = &#63; and groupId = &#63; and patronStatusId = &#63;.
	 *
	 * @param patronId the primary key of the current patron
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param patronStatusId the patron status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patron
	 * @throws com.kencana.lms.NoSuchPatronException if a patron with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Patron[] findByC_G_Status_PrevAndNext(long patronId, long companyId,
		long groupId, long patronStatusId, OrderByComparator orderByComparator)
		throws NoSuchPatronException, SystemException {
		Patron patron = findByPrimaryKey(patronId);

		Session session = null;

		try {
			session = openSession();

			Patron[] array = new PatronImpl[3];

			array[0] = getByC_G_Status_PrevAndNext(session, patron, companyId,
					groupId, patronStatusId, orderByComparator, true);

			array[1] = patron;

			array[2] = getByC_G_Status_PrevAndNext(session, patron, companyId,
					groupId, patronStatusId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Patron getByC_G_Status_PrevAndNext(Session session,
		Patron patron, long companyId, long groupId, long patronStatusId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PATRON_WHERE);

		query.append(_FINDER_COLUMN_C_G_STATUS_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_STATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_C_G_STATUS_PATRONSTATUSID_2);

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
			query.append(PatronModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(patronStatusId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(patron);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Patron> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the patrons where companyId = &#63; and groupId = &#63; and patronStatusId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param patronStatusId the patron status ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_G_Status(long companyId, long groupId,
		long patronStatusId) throws SystemException {
		for (Patron patron : findByC_G_Status(companyId, groupId,
				patronStatusId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(patron);
		}
	}

	/**
	 * Returns the number of patrons where companyId = &#63; and groupId = &#63; and patronStatusId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param patronStatusId the patron status ID
	 * @return the number of matching patrons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_G_Status(long companyId, long groupId,
		long patronStatusId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_G_STATUS;

		Object[] finderArgs = new Object[] { companyId, groupId, patronStatusId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_PATRON_WHERE);

			query.append(_FINDER_COLUMN_C_G_STATUS_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_STATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_C_G_STATUS_PATRONSTATUSID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(patronStatusId);

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

	private static final String _FINDER_COLUMN_C_G_STATUS_COMPANYID_2 = "patron.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_STATUS_GROUPID_2 = "patron.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_STATUS_PATRONSTATUSID_2 = "patron.patronStatusId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_CATEGORY =
		new FinderPath(PatronModelImpl.ENTITY_CACHE_ENABLED,
			PatronModelImpl.FINDER_CACHE_ENABLED, PatronImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G_Category",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_CATEGORY =
		new FinderPath(PatronModelImpl.ENTITY_CACHE_ENABLED,
			PatronModelImpl.FINDER_CACHE_ENABLED, PatronImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G_Category",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			PatronModelImpl.COMPANYID_COLUMN_BITMASK |
			PatronModelImpl.GROUPID_COLUMN_BITMASK |
			PatronModelImpl.PATRONCATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G_CATEGORY = new FinderPath(PatronModelImpl.ENTITY_CACHE_ENABLED,
			PatronModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_Category",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the patrons where companyId = &#63; and groupId = &#63; and patronCategoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param patronCategoryId the patron category ID
	 * @return the matching patrons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Patron> findByC_G_Category(long companyId, long groupId,
		long patronCategoryId) throws SystemException {
		return findByC_G_Category(companyId, groupId, patronCategoryId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the patrons where companyId = &#63; and groupId = &#63; and patronCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param patronCategoryId the patron category ID
	 * @param start the lower bound of the range of patrons
	 * @param end the upper bound of the range of patrons (not inclusive)
	 * @return the range of matching patrons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Patron> findByC_G_Category(long companyId, long groupId,
		long patronCategoryId, int start, int end) throws SystemException {
		return findByC_G_Category(companyId, groupId, patronCategoryId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the patrons where companyId = &#63; and groupId = &#63; and patronCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param patronCategoryId the patron category ID
	 * @param start the lower bound of the range of patrons
	 * @param end the upper bound of the range of patrons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patrons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Patron> findByC_G_Category(long companyId, long groupId,
		long patronCategoryId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_CATEGORY;
			finderArgs = new Object[] { companyId, groupId, patronCategoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_CATEGORY;
			finderArgs = new Object[] {
					companyId, groupId, patronCategoryId,
					
					start, end, orderByComparator
				};
		}

		List<Patron> list = (List<Patron>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Patron patron : list) {
				if ((companyId != patron.getCompanyId()) ||
						(groupId != patron.getGroupId()) ||
						(patronCategoryId != patron.getPatronCategoryId())) {
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

			query.append(_SQL_SELECT_PATRON_WHERE);

			query.append(_FINDER_COLUMN_C_G_CATEGORY_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_CATEGORY_GROUPID_2);

			query.append(_FINDER_COLUMN_C_G_CATEGORY_PATRONCATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PatronModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(patronCategoryId);

				if (!pagination) {
					list = (List<Patron>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Patron>(list);
				}
				else {
					list = (List<Patron>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first patron in the ordered set where companyId = &#63; and groupId = &#63; and patronCategoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param patronCategoryId the patron category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patron
	 * @throws com.kencana.lms.NoSuchPatronException if a matching patron could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Patron findByC_G_Category_First(long companyId, long groupId,
		long patronCategoryId, OrderByComparator orderByComparator)
		throws NoSuchPatronException, SystemException {
		Patron patron = fetchByC_G_Category_First(companyId, groupId,
				patronCategoryId, orderByComparator);

		if (patron != null) {
			return patron;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", patronCategoryId=");
		msg.append(patronCategoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPatronException(msg.toString());
	}

	/**
	 * Returns the first patron in the ordered set where companyId = &#63; and groupId = &#63; and patronCategoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param patronCategoryId the patron category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patron, or <code>null</code> if a matching patron could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Patron fetchByC_G_Category_First(long companyId, long groupId,
		long patronCategoryId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Patron> list = findByC_G_Category(companyId, groupId,
				patronCategoryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last patron in the ordered set where companyId = &#63; and groupId = &#63; and patronCategoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param patronCategoryId the patron category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patron
	 * @throws com.kencana.lms.NoSuchPatronException if a matching patron could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Patron findByC_G_Category_Last(long companyId, long groupId,
		long patronCategoryId, OrderByComparator orderByComparator)
		throws NoSuchPatronException, SystemException {
		Patron patron = fetchByC_G_Category_Last(companyId, groupId,
				patronCategoryId, orderByComparator);

		if (patron != null) {
			return patron;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", patronCategoryId=");
		msg.append(patronCategoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPatronException(msg.toString());
	}

	/**
	 * Returns the last patron in the ordered set where companyId = &#63; and groupId = &#63; and patronCategoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param patronCategoryId the patron category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patron, or <code>null</code> if a matching patron could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Patron fetchByC_G_Category_Last(long companyId, long groupId,
		long patronCategoryId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_G_Category(companyId, groupId, patronCategoryId);

		if (count == 0) {
			return null;
		}

		List<Patron> list = findByC_G_Category(companyId, groupId,
				patronCategoryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the patrons before and after the current patron in the ordered set where companyId = &#63; and groupId = &#63; and patronCategoryId = &#63;.
	 *
	 * @param patronId the primary key of the current patron
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param patronCategoryId the patron category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patron
	 * @throws com.kencana.lms.NoSuchPatronException if a patron with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Patron[] findByC_G_Category_PrevAndNext(long patronId,
		long companyId, long groupId, long patronCategoryId,
		OrderByComparator orderByComparator)
		throws NoSuchPatronException, SystemException {
		Patron patron = findByPrimaryKey(patronId);

		Session session = null;

		try {
			session = openSession();

			Patron[] array = new PatronImpl[3];

			array[0] = getByC_G_Category_PrevAndNext(session, patron,
					companyId, groupId, patronCategoryId, orderByComparator,
					true);

			array[1] = patron;

			array[2] = getByC_G_Category_PrevAndNext(session, patron,
					companyId, groupId, patronCategoryId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Patron getByC_G_Category_PrevAndNext(Session session,
		Patron patron, long companyId, long groupId, long patronCategoryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PATRON_WHERE);

		query.append(_FINDER_COLUMN_C_G_CATEGORY_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_CATEGORY_GROUPID_2);

		query.append(_FINDER_COLUMN_C_G_CATEGORY_PATRONCATEGORYID_2);

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
			query.append(PatronModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(patronCategoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(patron);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Patron> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the patrons where companyId = &#63; and groupId = &#63; and patronCategoryId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param patronCategoryId the patron category ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_G_Category(long companyId, long groupId,
		long patronCategoryId) throws SystemException {
		for (Patron patron : findByC_G_Category(companyId, groupId,
				patronCategoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(patron);
		}
	}

	/**
	 * Returns the number of patrons where companyId = &#63; and groupId = &#63; and patronCategoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param patronCategoryId the patron category ID
	 * @return the number of matching patrons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_G_Category(long companyId, long groupId,
		long patronCategoryId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_G_CATEGORY;

		Object[] finderArgs = new Object[] { companyId, groupId, patronCategoryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_PATRON_WHERE);

			query.append(_FINDER_COLUMN_C_G_CATEGORY_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_CATEGORY_GROUPID_2);

			query.append(_FINDER_COLUMN_C_G_CATEGORY_PATRONCATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_C_G_CATEGORY_COMPANYID_2 = "patron.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_CATEGORY_GROUPID_2 = "patron.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_CATEGORY_PATRONCATEGORYID_2 = "patron.patronCategoryId = ?";

	public PatronPersistenceImpl() {
		setModelClass(Patron.class);
	}

	/**
	 * Caches the patron in the entity cache if it is enabled.
	 *
	 * @param patron the patron
	 */
	@Override
	public void cacheResult(Patron patron) {
		EntityCacheUtil.putResult(PatronModelImpl.ENTITY_CACHE_ENABLED,
			PatronImpl.class, patron.getPrimaryKey(), patron);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
			new Object[] { patron.getUserId() }, patron);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CARDNUMBER,
			new Object[] { patron.getCardNumber() }, patron);

		patron.resetOriginalValues();
	}

	/**
	 * Caches the patrons in the entity cache if it is enabled.
	 *
	 * @param patrons the patrons
	 */
	@Override
	public void cacheResult(List<Patron> patrons) {
		for (Patron patron : patrons) {
			if (EntityCacheUtil.getResult(
						PatronModelImpl.ENTITY_CACHE_ENABLED, PatronImpl.class,
						patron.getPrimaryKey()) == null) {
				cacheResult(patron);
			}
			else {
				patron.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all patrons.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PatronImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PatronImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the patron.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Patron patron) {
		EntityCacheUtil.removeResult(PatronModelImpl.ENTITY_CACHE_ENABLED,
			PatronImpl.class, patron.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(patron);
	}

	@Override
	public void clearCache(List<Patron> patrons) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Patron patron : patrons) {
			EntityCacheUtil.removeResult(PatronModelImpl.ENTITY_CACHE_ENABLED,
				PatronImpl.class, patron.getPrimaryKey());

			clearUniqueFindersCache(patron);
		}
	}

	protected void cacheUniqueFindersCache(Patron patron) {
		if (patron.isNew()) {
			Object[] args = new Object[] { patron.getUserId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID, args, patron);

			args = new Object[] { patron.getCardNumber() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CARDNUMBER, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CARDNUMBER, args,
				patron);
		}
		else {
			PatronModelImpl patronModelImpl = (PatronModelImpl)patron;

			if ((patronModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { patron.getUserId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID, args,
					patron);
			}

			if ((patronModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CARDNUMBER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { patron.getCardNumber() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CARDNUMBER,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CARDNUMBER,
					args, patron);
			}
		}
	}

	protected void clearUniqueFindersCache(Patron patron) {
		PatronModelImpl patronModelImpl = (PatronModelImpl)patron;

		Object[] args = new Object[] { patron.getUserId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);

		if ((patronModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
			args = new Object[] { patronModelImpl.getOriginalUserId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);
		}

		args = new Object[] { patron.getCardNumber() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CARDNUMBER, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CARDNUMBER, args);

		if ((patronModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CARDNUMBER.getColumnBitmask()) != 0) {
			args = new Object[] { patronModelImpl.getOriginalCardNumber() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CARDNUMBER, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CARDNUMBER, args);
		}
	}

	/**
	 * Creates a new patron with the primary key. Does not add the patron to the database.
	 *
	 * @param patronId the primary key for the new patron
	 * @return the new patron
	 */
	@Override
	public Patron create(long patronId) {
		Patron patron = new PatronImpl();

		patron.setNew(true);
		patron.setPrimaryKey(patronId);

		return patron;
	}

	/**
	 * Removes the patron with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param patronId the primary key of the patron
	 * @return the patron that was removed
	 * @throws com.kencana.lms.NoSuchPatronException if a patron with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Patron remove(long patronId)
		throws NoSuchPatronException, SystemException {
		return remove((Serializable)patronId);
	}

	/**
	 * Removes the patron with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the patron
	 * @return the patron that was removed
	 * @throws com.kencana.lms.NoSuchPatronException if a patron with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Patron remove(Serializable primaryKey)
		throws NoSuchPatronException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Patron patron = (Patron)session.get(PatronImpl.class, primaryKey);

			if (patron == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPatronException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(patron);
		}
		catch (NoSuchPatronException nsee) {
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
	protected Patron removeImpl(Patron patron) throws SystemException {
		patron = toUnwrappedModel(patron);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(patron)) {
				patron = (Patron)session.get(PatronImpl.class,
						patron.getPrimaryKeyObj());
			}

			if (patron != null) {
				session.delete(patron);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (patron != null) {
			clearCache(patron);
		}

		return patron;
	}

	@Override
	public Patron updateImpl(com.kencana.lms.model.Patron patron)
		throws SystemException {
		patron = toUnwrappedModel(patron);

		boolean isNew = patron.isNew();

		PatronModelImpl patronModelImpl = (PatronModelImpl)patron;

		Session session = null;

		try {
			session = openSession();

			if (patron.isNew()) {
				session.save(patron);

				patron.setNew(false);
			}
			else {
				session.merge(patron);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PatronModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((patronModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						patronModelImpl.getOriginalCompanyId(),
						patronModelImpl.getOriginalLibraryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYID,
					args);

				args = new Object[] {
						patronModelImpl.getCompanyId(),
						patronModelImpl.getLibraryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYID,
					args);
			}

			if ((patronModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						patronModelImpl.getOriginalCompanyId(),
						patronModelImpl.getOriginalGroupId(),
						patronModelImpl.getOriginalPatronStatusId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_STATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_STATUS,
					args);

				args = new Object[] {
						patronModelImpl.getCompanyId(),
						patronModelImpl.getGroupId(),
						patronModelImpl.getPatronStatusId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_STATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_STATUS,
					args);
			}

			if ((patronModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_CATEGORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						patronModelImpl.getOriginalCompanyId(),
						patronModelImpl.getOriginalGroupId(),
						patronModelImpl.getOriginalPatronCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_CATEGORY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_CATEGORY,
					args);

				args = new Object[] {
						patronModelImpl.getCompanyId(),
						patronModelImpl.getGroupId(),
						patronModelImpl.getPatronCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_CATEGORY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_CATEGORY,
					args);
			}
		}

		EntityCacheUtil.putResult(PatronModelImpl.ENTITY_CACHE_ENABLED,
			PatronImpl.class, patron.getPrimaryKey(), patron);

		clearUniqueFindersCache(patron);
		cacheUniqueFindersCache(patron);

		return patron;
	}

	protected Patron toUnwrappedModel(Patron patron) {
		if (patron instanceof PatronImpl) {
			return patron;
		}

		PatronImpl patronImpl = new PatronImpl();

		patronImpl.setNew(patron.isNew());
		patronImpl.setPrimaryKey(patron.getPrimaryKey());

		patronImpl.setPatronId(patron.getPatronId());
		patronImpl.setCardNumber(patron.getCardNumber());
		patronImpl.setUserId(patron.getUserId());
		patronImpl.setGroupId(patron.getGroupId());
		patronImpl.setCompanyId(patron.getCompanyId());
		patronImpl.setLibraryId(patron.getLibraryId());
		patronImpl.setExpiryDate(patron.getExpiryDate());
		patronImpl.setPatronCategoryId(patron.getPatronCategoryId());
		patronImpl.setPatronStatusId(patron.getPatronStatusId());
		patronImpl.setPatronNote(patron.getPatronNote());

		return patronImpl;
	}

	/**
	 * Returns the patron with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the patron
	 * @return the patron
	 * @throws com.kencana.lms.NoSuchPatronException if a patron with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Patron findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPatronException, SystemException {
		Patron patron = fetchByPrimaryKey(primaryKey);

		if (patron == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPatronException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return patron;
	}

	/**
	 * Returns the patron with the primary key or throws a {@link com.kencana.lms.NoSuchPatronException} if it could not be found.
	 *
	 * @param patronId the primary key of the patron
	 * @return the patron
	 * @throws com.kencana.lms.NoSuchPatronException if a patron with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Patron findByPrimaryKey(long patronId)
		throws NoSuchPatronException, SystemException {
		return findByPrimaryKey((Serializable)patronId);
	}

	/**
	 * Returns the patron with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the patron
	 * @return the patron, or <code>null</code> if a patron with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Patron fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Patron patron = (Patron)EntityCacheUtil.getResult(PatronModelImpl.ENTITY_CACHE_ENABLED,
				PatronImpl.class, primaryKey);

		if (patron == _nullPatron) {
			return null;
		}

		if (patron == null) {
			Session session = null;

			try {
				session = openSession();

				patron = (Patron)session.get(PatronImpl.class, primaryKey);

				if (patron != null) {
					cacheResult(patron);
				}
				else {
					EntityCacheUtil.putResult(PatronModelImpl.ENTITY_CACHE_ENABLED,
						PatronImpl.class, primaryKey, _nullPatron);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PatronModelImpl.ENTITY_CACHE_ENABLED,
					PatronImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return patron;
	}

	/**
	 * Returns the patron with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param patronId the primary key of the patron
	 * @return the patron, or <code>null</code> if a patron with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Patron fetchByPrimaryKey(long patronId) throws SystemException {
		return fetchByPrimaryKey((Serializable)patronId);
	}

	/**
	 * Returns all the patrons.
	 *
	 * @return the patrons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Patron> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the patrons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of patrons
	 * @param end the upper bound of the range of patrons (not inclusive)
	 * @return the range of patrons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Patron> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the patrons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.PatronModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of patrons
	 * @param end the upper bound of the range of patrons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of patrons
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Patron> findAll(int start, int end,
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

		List<Patron> list = (List<Patron>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PATRON);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PATRON;

				if (pagination) {
					sql = sql.concat(PatronModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Patron>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Patron>(list);
				}
				else {
					list = (List<Patron>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the patrons from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Patron patron : findAll()) {
			remove(patron);
		}
	}

	/**
	 * Returns the number of patrons.
	 *
	 * @return the number of patrons
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

				Query q = session.createQuery(_SQL_COUNT_PATRON);

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
	 * Initializes the patron persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.kencana.lms.model.Patron")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Patron>> listenersList = new ArrayList<ModelListener<Patron>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Patron>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PatronImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PATRON = "SELECT patron FROM Patron patron";
	private static final String _SQL_SELECT_PATRON_WHERE = "SELECT patron FROM Patron patron WHERE ";
	private static final String _SQL_COUNT_PATRON = "SELECT COUNT(patron) FROM Patron patron";
	private static final String _SQL_COUNT_PATRON_WHERE = "SELECT COUNT(patron) FROM Patron patron WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "patron.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Patron exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Patron exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PatronPersistenceImpl.class);
	private static Patron _nullPatron = new PatronImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Patron> toCacheModel() {
				return _nullPatronCacheModel;
			}
		};

	private static CacheModel<Patron> _nullPatronCacheModel = new CacheModel<Patron>() {
			@Override
			public Patron toEntityModel() {
				return _nullPatron;
			}
		};
}