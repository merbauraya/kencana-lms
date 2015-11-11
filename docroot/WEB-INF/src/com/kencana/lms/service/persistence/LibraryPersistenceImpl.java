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

import com.kencana.lms.NoSuchLibraryException;
import com.kencana.lms.model.Library;
import com.kencana.lms.model.impl.LibraryImpl;
import com.kencana.lms.model.impl.LibraryModelImpl;

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
import com.liferay.portal.kernel.util.SetUtil;
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
import java.util.Set;

/**
 * The persistence implementation for the library service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see LibraryPersistence
 * @see LibraryUtil
 * @generated
 */
public class LibraryPersistenceImpl extends BasePersistenceImpl<Library>
	implements LibraryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LibraryUtil} to access the library persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LibraryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LibraryModelImpl.ENTITY_CACHE_ENABLED,
			LibraryModelImpl.FINDER_CACHE_ENABLED, LibraryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LibraryModelImpl.ENTITY_CACHE_ENABLED,
			LibraryModelImpl.FINDER_CACHE_ENABLED, LibraryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LibraryModelImpl.ENTITY_CACHE_ENABLED,
			LibraryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(LibraryModelImpl.ENTITY_CACHE_ENABLED,
			LibraryModelImpl.FINDER_CACHE_ENABLED, LibraryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(LibraryModelImpl.ENTITY_CACHE_ENABLED,
			LibraryModelImpl.FINDER_CACHE_ENABLED, LibraryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			LibraryModelImpl.COMPANYID_COLUMN_BITMASK |
			LibraryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYGROUP = new FinderPath(LibraryModelImpl.ENTITY_CACHE_ENABLED,
			LibraryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the libraries where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching libraries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Library> findByCompanyGroup(long companyId, long groupId)
		throws SystemException {
		return findByCompanyGroup(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the libraries where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.LibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of libraries
	 * @param end the upper bound of the range of libraries (not inclusive)
	 * @return the range of matching libraries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Library> findByCompanyGroup(long companyId, long groupId,
		int start, int end) throws SystemException {
		return findByCompanyGroup(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the libraries where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.LibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of libraries
	 * @param end the upper bound of the range of libraries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching libraries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Library> findByCompanyGroup(long companyId, long groupId,
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

		List<Library> list = (List<Library>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Library library : list) {
				if ((companyId != library.getCompanyId()) ||
						(groupId != library.getGroupId())) {
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

			query.append(_SQL_SELECT_LIBRARY_WHERE);

			query.append(_FINDER_COLUMN_COMPANYGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LibraryModelImpl.ORDER_BY_JPQL);
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
					list = (List<Library>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Library>(list);
				}
				else {
					list = (List<Library>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first library in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library
	 * @throws com.kencana.lms.NoSuchLibraryException if a matching library could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Library findByCompanyGroup_First(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLibraryException, SystemException {
		Library library = fetchByCompanyGroup_First(companyId, groupId,
				orderByComparator);

		if (library != null) {
			return library;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLibraryException(msg.toString());
	}

	/**
	 * Returns the first library in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library, or <code>null</code> if a matching library could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Library fetchByCompanyGroup_First(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Library> list = findByCompanyGroup(companyId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last library in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library
	 * @throws com.kencana.lms.NoSuchLibraryException if a matching library could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Library findByCompanyGroup_Last(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLibraryException, SystemException {
		Library library = fetchByCompanyGroup_Last(companyId, groupId,
				orderByComparator);

		if (library != null) {
			return library;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLibraryException(msg.toString());
	}

	/**
	 * Returns the last library in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library, or <code>null</code> if a matching library could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Library fetchByCompanyGroup_Last(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyGroup(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<Library> list = findByCompanyGroup(companyId, groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the libraries before and after the current library in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param libraryId the primary key of the current library
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next library
	 * @throws com.kencana.lms.NoSuchLibraryException if a library with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Library[] findByCompanyGroup_PrevAndNext(long libraryId,
		long companyId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchLibraryException, SystemException {
		Library library = findByPrimaryKey(libraryId);

		Session session = null;

		try {
			session = openSession();

			Library[] array = new LibraryImpl[3];

			array[0] = getByCompanyGroup_PrevAndNext(session, library,
					companyId, groupId, orderByComparator, true);

			array[1] = library;

			array[2] = getByCompanyGroup_PrevAndNext(session, library,
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

	protected Library getByCompanyGroup_PrevAndNext(Session session,
		Library library, long companyId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LIBRARY_WHERE);

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
			query.append(LibraryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(library);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Library> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the libraries where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyGroup(long companyId, long groupId)
		throws SystemException {
		for (Library library : findByCompanyGroup(companyId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(library);
		}
	}

	/**
	 * Returns the number of libraries where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching libraries
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

			query.append(_SQL_COUNT_LIBRARY_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANYGROUP_COMPANYID_2 = "library.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYGROUP_GROUPID_2 = "library.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(LibraryModelImpl.ENTITY_CACHE_ENABLED,
			LibraryModelImpl.FINDER_CACHE_ENABLED, LibraryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(LibraryModelImpl.ENTITY_CACHE_ENABLED,
			LibraryModelImpl.FINDER_CACHE_ENABLED, LibraryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			LibraryModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(LibraryModelImpl.ENTITY_CACHE_ENABLED,
			LibraryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the libraries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching libraries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Library> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the libraries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.LibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of libraries
	 * @param end the upper bound of the range of libraries (not inclusive)
	 * @return the range of matching libraries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Library> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the libraries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.LibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of libraries
	 * @param end the upper bound of the range of libraries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching libraries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Library> findByCompany(long companyId, int start, int end,
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

		List<Library> list = (List<Library>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Library library : list) {
				if ((companyId != library.getCompanyId())) {
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

			query.append(_SQL_SELECT_LIBRARY_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LibraryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Library>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Library>(list);
				}
				else {
					list = (List<Library>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first library in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library
	 * @throws com.kencana.lms.NoSuchLibraryException if a matching library could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Library findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchLibraryException, SystemException {
		Library library = fetchByCompany_First(companyId, orderByComparator);

		if (library != null) {
			return library;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLibraryException(msg.toString());
	}

	/**
	 * Returns the first library in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library, or <code>null</code> if a matching library could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Library fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Library> list = findByCompany(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last library in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library
	 * @throws com.kencana.lms.NoSuchLibraryException if a matching library could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Library findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchLibraryException, SystemException {
		Library library = fetchByCompany_Last(companyId, orderByComparator);

		if (library != null) {
			return library;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLibraryException(msg.toString());
	}

	/**
	 * Returns the last library in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library, or <code>null</code> if a matching library could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Library fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		if (count == 0) {
			return null;
		}

		List<Library> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the libraries before and after the current library in the ordered set where companyId = &#63;.
	 *
	 * @param libraryId the primary key of the current library
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next library
	 * @throws com.kencana.lms.NoSuchLibraryException if a library with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Library[] findByCompany_PrevAndNext(long libraryId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchLibraryException, SystemException {
		Library library = findByPrimaryKey(libraryId);

		Session session = null;

		try {
			session = openSession();

			Library[] array = new LibraryImpl[3];

			array[0] = getByCompany_PrevAndNext(session, library, companyId,
					orderByComparator, true);

			array[1] = library;

			array[2] = getByCompany_PrevAndNext(session, library, companyId,
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

	protected Library getByCompany_PrevAndNext(Session session,
		Library library, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LIBRARY_WHERE);

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
			query.append(LibraryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(library);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Library> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the libraries where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompany(long companyId) throws SystemException {
		for (Library library : findByCompany(companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(library);
		}
	}

	/**
	 * Returns the number of libraries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching libraries
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

			query.append(_SQL_COUNT_LIBRARY_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "library.companyId = ?";

	public LibraryPersistenceImpl() {
		setModelClass(Library.class);
	}

	/**
	 * Caches the library in the entity cache if it is enabled.
	 *
	 * @param library the library
	 */
	@Override
	public void cacheResult(Library library) {
		EntityCacheUtil.putResult(LibraryModelImpl.ENTITY_CACHE_ENABLED,
			LibraryImpl.class, library.getPrimaryKey(), library);

		library.resetOriginalValues();
	}

	/**
	 * Caches the libraries in the entity cache if it is enabled.
	 *
	 * @param libraries the libraries
	 */
	@Override
	public void cacheResult(List<Library> libraries) {
		for (Library library : libraries) {
			if (EntityCacheUtil.getResult(
						LibraryModelImpl.ENTITY_CACHE_ENABLED,
						LibraryImpl.class, library.getPrimaryKey()) == null) {
				cacheResult(library);
			}
			else {
				library.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all libraries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LibraryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LibraryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the library.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Library library) {
		EntityCacheUtil.removeResult(LibraryModelImpl.ENTITY_CACHE_ENABLED,
			LibraryImpl.class, library.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Library> libraries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Library library : libraries) {
			EntityCacheUtil.removeResult(LibraryModelImpl.ENTITY_CACHE_ENABLED,
				LibraryImpl.class, library.getPrimaryKey());
		}
	}

	/**
	 * Creates a new library with the primary key. Does not add the library to the database.
	 *
	 * @param libraryId the primary key for the new library
	 * @return the new library
	 */
	@Override
	public Library create(long libraryId) {
		Library library = new LibraryImpl();

		library.setNew(true);
		library.setPrimaryKey(libraryId);

		return library;
	}

	/**
	 * Removes the library with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param libraryId the primary key of the library
	 * @return the library that was removed
	 * @throws com.kencana.lms.NoSuchLibraryException if a library with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Library remove(long libraryId)
		throws NoSuchLibraryException, SystemException {
		return remove((Serializable)libraryId);
	}

	/**
	 * Removes the library with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the library
	 * @return the library that was removed
	 * @throws com.kencana.lms.NoSuchLibraryException if a library with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Library remove(Serializable primaryKey)
		throws NoSuchLibraryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Library library = (Library)session.get(LibraryImpl.class, primaryKey);

			if (library == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLibraryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(library);
		}
		catch (NoSuchLibraryException nsee) {
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
	protected Library removeImpl(Library library) throws SystemException {
		library = toUnwrappedModel(library);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(library)) {
				library = (Library)session.get(LibraryImpl.class,
						library.getPrimaryKeyObj());
			}

			if (library != null) {
				session.delete(library);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (library != null) {
			clearCache(library);
		}

		return library;
	}

	@Override
	public Library updateImpl(com.kencana.lms.model.Library library)
		throws SystemException {
		library = toUnwrappedModel(library);

		boolean isNew = library.isNew();

		LibraryModelImpl libraryModelImpl = (LibraryModelImpl)library;

		Session session = null;

		try {
			session = openSession();

			if (library.isNew()) {
				session.save(library);

				library.setNew(false);
			}
			else {
				session.merge(library);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LibraryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((libraryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						libraryModelImpl.getOriginalCompanyId(),
						libraryModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);

				args = new Object[] {
						libraryModelImpl.getCompanyId(),
						libraryModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);
			}

			if ((libraryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						libraryModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] { libraryModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}
		}

		EntityCacheUtil.putResult(LibraryModelImpl.ENTITY_CACHE_ENABLED,
			LibraryImpl.class, library.getPrimaryKey(), library);

		return library;
	}

	protected Library toUnwrappedModel(Library library) {
		if (library instanceof LibraryImpl) {
			return library;
		}

		LibraryImpl libraryImpl = new LibraryImpl();

		libraryImpl.setNew(library.isNew());
		libraryImpl.setPrimaryKey(library.getPrimaryKey());

		libraryImpl.setLibraryId(library.getLibraryId());
		libraryImpl.setLibraryName(library.getLibraryName());
		libraryImpl.setGroupId(library.getGroupId());
		libraryImpl.setCompanyId(library.getCompanyId());
		libraryImpl.setAddress1(library.getAddress1());
		libraryImpl.setAddress2(library.getAddress2());
		libraryImpl.setAddress3(library.getAddress3());
		libraryImpl.setZipcode(library.getZipcode());
		libraryImpl.setCity(library.getCity());
		libraryImpl.setState(library.getState());
		libraryImpl.setCountry(library.getCountry());
		libraryImpl.setPhone(library.getPhone());
		libraryImpl.setEmail(library.getEmail());
		libraryImpl.setWebsite(library.getWebsite());
		libraryImpl.setNotes(library.getNotes());

		return libraryImpl;
	}

	/**
	 * Returns the library with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the library
	 * @return the library
	 * @throws com.kencana.lms.NoSuchLibraryException if a library with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Library findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLibraryException, SystemException {
		Library library = fetchByPrimaryKey(primaryKey);

		if (library == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLibraryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return library;
	}

	/**
	 * Returns the library with the primary key or throws a {@link com.kencana.lms.NoSuchLibraryException} if it could not be found.
	 *
	 * @param libraryId the primary key of the library
	 * @return the library
	 * @throws com.kencana.lms.NoSuchLibraryException if a library with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Library findByPrimaryKey(long libraryId)
		throws NoSuchLibraryException, SystemException {
		return findByPrimaryKey((Serializable)libraryId);
	}

	/**
	 * Returns the library with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the library
	 * @return the library, or <code>null</code> if a library with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Library fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Library library = (Library)EntityCacheUtil.getResult(LibraryModelImpl.ENTITY_CACHE_ENABLED,
				LibraryImpl.class, primaryKey);

		if (library == _nullLibrary) {
			return null;
		}

		if (library == null) {
			Session session = null;

			try {
				session = openSession();

				library = (Library)session.get(LibraryImpl.class, primaryKey);

				if (library != null) {
					cacheResult(library);
				}
				else {
					EntityCacheUtil.putResult(LibraryModelImpl.ENTITY_CACHE_ENABLED,
						LibraryImpl.class, primaryKey, _nullLibrary);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LibraryModelImpl.ENTITY_CACHE_ENABLED,
					LibraryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return library;
	}

	/**
	 * Returns the library with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param libraryId the primary key of the library
	 * @return the library, or <code>null</code> if a library with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Library fetchByPrimaryKey(long libraryId) throws SystemException {
		return fetchByPrimaryKey((Serializable)libraryId);
	}

	/**
	 * Returns all the libraries.
	 *
	 * @return the libraries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Library> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the libraries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.LibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of libraries
	 * @param end the upper bound of the range of libraries (not inclusive)
	 * @return the range of libraries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Library> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the libraries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.LibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of libraries
	 * @param end the upper bound of the range of libraries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of libraries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Library> findAll(int start, int end,
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

		List<Library> list = (List<Library>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LIBRARY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LIBRARY;

				if (pagination) {
					sql = sql.concat(LibraryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Library>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Library>(list);
				}
				else {
					list = (List<Library>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the libraries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Library library : findAll()) {
			remove(library);
		}
	}

	/**
	 * Returns the number of libraries.
	 *
	 * @return the number of libraries
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

				Query q = session.createQuery(_SQL_COUNT_LIBRARY);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the library persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.kencana.lms.model.Library")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Library>> listenersList = new ArrayList<ModelListener<Library>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Library>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LibraryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LIBRARY = "SELECT library FROM Library library";
	private static final String _SQL_SELECT_LIBRARY_WHERE = "SELECT library FROM Library library WHERE ";
	private static final String _SQL_COUNT_LIBRARY = "SELECT COUNT(library) FROM Library library";
	private static final String _SQL_COUNT_LIBRARY_WHERE = "SELECT COUNT(library) FROM Library library WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "library.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Library exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Library exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LibraryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"state"
			});
	private static Library _nullLibrary = new LibraryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Library> toCacheModel() {
				return _nullLibraryCacheModel;
			}
		};

	private static CacheModel<Library> _nullLibraryCacheModel = new CacheModel<Library>() {
			@Override
			public Library toEntityModel() {
				return _nullLibrary;
			}
		};
}