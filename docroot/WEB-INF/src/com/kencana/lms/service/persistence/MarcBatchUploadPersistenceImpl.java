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

import com.kencana.lms.NoSuchMarcBatchUploadException;
import com.kencana.lms.model.MarcBatchUpload;
import com.kencana.lms.model.impl.MarcBatchUploadImpl;
import com.kencana.lms.model.impl.MarcBatchUploadModelImpl;

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
 * The persistence implementation for the marc batch upload service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see MarcBatchUploadPersistence
 * @see MarcBatchUploadUtil
 * @generated
 */
public class MarcBatchUploadPersistenceImpl extends BasePersistenceImpl<MarcBatchUpload>
	implements MarcBatchUploadPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MarcBatchUploadUtil} to access the marc batch upload persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MarcBatchUploadImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MarcBatchUploadModelImpl.ENTITY_CACHE_ENABLED,
			MarcBatchUploadModelImpl.FINDER_CACHE_ENABLED,
			MarcBatchUploadImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MarcBatchUploadModelImpl.ENTITY_CACHE_ENABLED,
			MarcBatchUploadModelImpl.FINDER_CACHE_ENABLED,
			MarcBatchUploadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MarcBatchUploadModelImpl.ENTITY_CACHE_ENABLED,
			MarcBatchUploadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(MarcBatchUploadModelImpl.ENTITY_CACHE_ENABLED,
			MarcBatchUploadModelImpl.FINDER_CACHE_ENABLED,
			MarcBatchUploadImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompanyGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(MarcBatchUploadModelImpl.ENTITY_CACHE_ENABLED,
			MarcBatchUploadModelImpl.FINDER_CACHE_ENABLED,
			MarcBatchUploadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			MarcBatchUploadModelImpl.COMPANYID_COLUMN_BITMASK |
			MarcBatchUploadModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYGROUP = new FinderPath(MarcBatchUploadModelImpl.ENTITY_CACHE_ENABLED,
			MarcBatchUploadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the marc batch uploads where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching marc batch uploads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MarcBatchUpload> findByCompanyGroup(long companyId, long groupId)
		throws SystemException {
		return findByCompanyGroup(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the marc batch uploads where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcBatchUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of marc batch uploads
	 * @param end the upper bound of the range of marc batch uploads (not inclusive)
	 * @return the range of matching marc batch uploads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MarcBatchUpload> findByCompanyGroup(long companyId,
		long groupId, int start, int end) throws SystemException {
		return findByCompanyGroup(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the marc batch uploads where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcBatchUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of marc batch uploads
	 * @param end the upper bound of the range of marc batch uploads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching marc batch uploads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MarcBatchUpload> findByCompanyGroup(long companyId,
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

		List<MarcBatchUpload> list = (List<MarcBatchUpload>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MarcBatchUpload marcBatchUpload : list) {
				if ((companyId != marcBatchUpload.getCompanyId()) ||
						(groupId != marcBatchUpload.getGroupId())) {
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

			query.append(_SQL_SELECT_MARCBATCHUPLOAD_WHERE);

			query.append(_FINDER_COLUMN_COMPANYGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MarcBatchUploadModelImpl.ORDER_BY_JPQL);
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
					list = (List<MarcBatchUpload>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MarcBatchUpload>(list);
				}
				else {
					list = (List<MarcBatchUpload>)QueryUtil.list(q,
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
	 * Returns the first marc batch upload in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marc batch upload
	 * @throws com.kencana.lms.NoSuchMarcBatchUploadException if a matching marc batch upload could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUpload findByCompanyGroup_First(long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchMarcBatchUploadException, SystemException {
		MarcBatchUpload marcBatchUpload = fetchByCompanyGroup_First(companyId,
				groupId, orderByComparator);

		if (marcBatchUpload != null) {
			return marcBatchUpload;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMarcBatchUploadException(msg.toString());
	}

	/**
	 * Returns the first marc batch upload in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marc batch upload, or <code>null</code> if a matching marc batch upload could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUpload fetchByCompanyGroup_First(long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<MarcBatchUpload> list = findByCompanyGroup(companyId, groupId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last marc batch upload in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marc batch upload
	 * @throws com.kencana.lms.NoSuchMarcBatchUploadException if a matching marc batch upload could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUpload findByCompanyGroup_Last(long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchMarcBatchUploadException, SystemException {
		MarcBatchUpload marcBatchUpload = fetchByCompanyGroup_Last(companyId,
				groupId, orderByComparator);

		if (marcBatchUpload != null) {
			return marcBatchUpload;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMarcBatchUploadException(msg.toString());
	}

	/**
	 * Returns the last marc batch upload in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marc batch upload, or <code>null</code> if a matching marc batch upload could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUpload fetchByCompanyGroup_Last(long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCompanyGroup(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<MarcBatchUpload> list = findByCompanyGroup(companyId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the marc batch uploads before and after the current marc batch upload in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param marcBatchUploadId the primary key of the current marc batch upload
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next marc batch upload
	 * @throws com.kencana.lms.NoSuchMarcBatchUploadException if a marc batch upload with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUpload[] findByCompanyGroup_PrevAndNext(
		long marcBatchUploadId, long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchMarcBatchUploadException, SystemException {
		MarcBatchUpload marcBatchUpload = findByPrimaryKey(marcBatchUploadId);

		Session session = null;

		try {
			session = openSession();

			MarcBatchUpload[] array = new MarcBatchUploadImpl[3];

			array[0] = getByCompanyGroup_PrevAndNext(session, marcBatchUpload,
					companyId, groupId, orderByComparator, true);

			array[1] = marcBatchUpload;

			array[2] = getByCompanyGroup_PrevAndNext(session, marcBatchUpload,
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

	protected MarcBatchUpload getByCompanyGroup_PrevAndNext(Session session,
		MarcBatchUpload marcBatchUpload, long companyId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MARCBATCHUPLOAD_WHERE);

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
			query.append(MarcBatchUploadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(marcBatchUpload);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MarcBatchUpload> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the marc batch uploads where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyGroup(long companyId, long groupId)
		throws SystemException {
		for (MarcBatchUpload marcBatchUpload : findByCompanyGroup(companyId,
				groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(marcBatchUpload);
		}
	}

	/**
	 * Returns the number of marc batch uploads where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching marc batch uploads
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

			query.append(_SQL_COUNT_MARCBATCHUPLOAD_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANYGROUP_COMPANYID_2 = "marcBatchUpload.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYGROUP_GROUPID_2 = "marcBatchUpload.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(MarcBatchUploadModelImpl.ENTITY_CACHE_ENABLED,
			MarcBatchUploadModelImpl.FINDER_CACHE_ENABLED,
			MarcBatchUploadImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroup",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(MarcBatchUploadModelImpl.ENTITY_CACHE_ENABLED,
			MarcBatchUploadModelImpl.FINDER_CACHE_ENABLED,
			MarcBatchUploadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			MarcBatchUploadModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(MarcBatchUploadModelImpl.ENTITY_CACHE_ENABLED,
			MarcBatchUploadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the marc batch uploads where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching marc batch uploads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MarcBatchUpload> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the marc batch uploads where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcBatchUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of marc batch uploads
	 * @param end the upper bound of the range of marc batch uploads (not inclusive)
	 * @return the range of matching marc batch uploads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MarcBatchUpload> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the marc batch uploads where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcBatchUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of marc batch uploads
	 * @param end the upper bound of the range of marc batch uploads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching marc batch uploads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MarcBatchUpload> findByGroup(long groupId, int start, int end,
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

		List<MarcBatchUpload> list = (List<MarcBatchUpload>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MarcBatchUpload marcBatchUpload : list) {
				if ((groupId != marcBatchUpload.getGroupId())) {
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

			query.append(_SQL_SELECT_MARCBATCHUPLOAD_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MarcBatchUploadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<MarcBatchUpload>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MarcBatchUpload>(list);
				}
				else {
					list = (List<MarcBatchUpload>)QueryUtil.list(q,
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
	 * Returns the first marc batch upload in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marc batch upload
	 * @throws com.kencana.lms.NoSuchMarcBatchUploadException if a matching marc batch upload could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUpload findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchMarcBatchUploadException, SystemException {
		MarcBatchUpload marcBatchUpload = fetchByGroup_First(groupId,
				orderByComparator);

		if (marcBatchUpload != null) {
			return marcBatchUpload;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMarcBatchUploadException(msg.toString());
	}

	/**
	 * Returns the first marc batch upload in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marc batch upload, or <code>null</code> if a matching marc batch upload could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUpload fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<MarcBatchUpload> list = findByGroup(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last marc batch upload in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marc batch upload
	 * @throws com.kencana.lms.NoSuchMarcBatchUploadException if a matching marc batch upload could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUpload findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchMarcBatchUploadException, SystemException {
		MarcBatchUpload marcBatchUpload = fetchByGroup_Last(groupId,
				orderByComparator);

		if (marcBatchUpload != null) {
			return marcBatchUpload;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMarcBatchUploadException(msg.toString());
	}

	/**
	 * Returns the last marc batch upload in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marc batch upload, or <code>null</code> if a matching marc batch upload could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUpload fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		if (count == 0) {
			return null;
		}

		List<MarcBatchUpload> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the marc batch uploads before and after the current marc batch upload in the ordered set where groupId = &#63;.
	 *
	 * @param marcBatchUploadId the primary key of the current marc batch upload
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next marc batch upload
	 * @throws com.kencana.lms.NoSuchMarcBatchUploadException if a marc batch upload with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUpload[] findByGroup_PrevAndNext(long marcBatchUploadId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchMarcBatchUploadException, SystemException {
		MarcBatchUpload marcBatchUpload = findByPrimaryKey(marcBatchUploadId);

		Session session = null;

		try {
			session = openSession();

			MarcBatchUpload[] array = new MarcBatchUploadImpl[3];

			array[0] = getByGroup_PrevAndNext(session, marcBatchUpload,
					groupId, orderByComparator, true);

			array[1] = marcBatchUpload;

			array[2] = getByGroup_PrevAndNext(session, marcBatchUpload,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MarcBatchUpload getByGroup_PrevAndNext(Session session,
		MarcBatchUpload marcBatchUpload, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MARCBATCHUPLOAD_WHERE);

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
			query.append(MarcBatchUploadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(marcBatchUpload);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MarcBatchUpload> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the marc batch uploads where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroup(long groupId) throws SystemException {
		for (MarcBatchUpload marcBatchUpload : findByGroup(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(marcBatchUpload);
		}
	}

	/**
	 * Returns the number of marc batch uploads where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching marc batch uploads
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

			query.append(_SQL_COUNT_MARCBATCHUPLOAD_WHERE);

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

	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "marcBatchUpload.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(MarcBatchUploadModelImpl.ENTITY_CACHE_ENABLED,
			MarcBatchUploadModelImpl.FINDER_CACHE_ENABLED,
			MarcBatchUploadImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(MarcBatchUploadModelImpl.ENTITY_CACHE_ENABLED,
			MarcBatchUploadModelImpl.FINDER_CACHE_ENABLED,
			MarcBatchUploadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			MarcBatchUploadModelImpl.GROUPID_COLUMN_BITMASK |
			MarcBatchUploadModelImpl.COMPANYID_COLUMN_BITMASK |
			MarcBatchUploadModelImpl.PROCESSED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(MarcBatchUploadModelImpl.ENTITY_CACHE_ENABLED,
			MarcBatchUploadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns all the marc batch uploads where groupId = &#63; and companyId = &#63; and processed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param processed the processed
	 * @return the matching marc batch uploads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MarcBatchUpload> findByStatus(long groupId, long companyId,
		boolean processed) throws SystemException {
		return findByStatus(groupId, companyId, processed, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the marc batch uploads where groupId = &#63; and companyId = &#63; and processed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcBatchUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param processed the processed
	 * @param start the lower bound of the range of marc batch uploads
	 * @param end the upper bound of the range of marc batch uploads (not inclusive)
	 * @return the range of matching marc batch uploads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MarcBatchUpload> findByStatus(long groupId, long companyId,
		boolean processed, int start, int end) throws SystemException {
		return findByStatus(groupId, companyId, processed, start, end, null);
	}

	/**
	 * Returns an ordered range of all the marc batch uploads where groupId = &#63; and companyId = &#63; and processed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcBatchUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param processed the processed
	 * @param start the lower bound of the range of marc batch uploads
	 * @param end the upper bound of the range of marc batch uploads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching marc batch uploads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MarcBatchUpload> findByStatus(long groupId, long companyId,
		boolean processed, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { groupId, companyId, processed };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] {
					groupId, companyId, processed,
					
					start, end, orderByComparator
				};
		}

		List<MarcBatchUpload> list = (List<MarcBatchUpload>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MarcBatchUpload marcBatchUpload : list) {
				if ((groupId != marcBatchUpload.getGroupId()) ||
						(companyId != marcBatchUpload.getCompanyId()) ||
						(processed != marcBatchUpload.getProcessed())) {
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

			query.append(_SQL_SELECT_MARCBATCHUPLOAD_WHERE);

			query.append(_FINDER_COLUMN_STATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_STATUS_COMPANYID_2);

			query.append(_FINDER_COLUMN_STATUS_PROCESSED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MarcBatchUploadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(processed);

				if (!pagination) {
					list = (List<MarcBatchUpload>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MarcBatchUpload>(list);
				}
				else {
					list = (List<MarcBatchUpload>)QueryUtil.list(q,
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
	 * Returns the first marc batch upload in the ordered set where groupId = &#63; and companyId = &#63; and processed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param processed the processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marc batch upload
	 * @throws com.kencana.lms.NoSuchMarcBatchUploadException if a matching marc batch upload could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUpload findByStatus_First(long groupId, long companyId,
		boolean processed, OrderByComparator orderByComparator)
		throws NoSuchMarcBatchUploadException, SystemException {
		MarcBatchUpload marcBatchUpload = fetchByStatus_First(groupId,
				companyId, processed, orderByComparator);

		if (marcBatchUpload != null) {
			return marcBatchUpload;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", processed=");
		msg.append(processed);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMarcBatchUploadException(msg.toString());
	}

	/**
	 * Returns the first marc batch upload in the ordered set where groupId = &#63; and companyId = &#63; and processed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param processed the processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marc batch upload, or <code>null</code> if a matching marc batch upload could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUpload fetchByStatus_First(long groupId, long companyId,
		boolean processed, OrderByComparator orderByComparator)
		throws SystemException {
		List<MarcBatchUpload> list = findByStatus(groupId, companyId,
				processed, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last marc batch upload in the ordered set where groupId = &#63; and companyId = &#63; and processed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param processed the processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marc batch upload
	 * @throws com.kencana.lms.NoSuchMarcBatchUploadException if a matching marc batch upload could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUpload findByStatus_Last(long groupId, long companyId,
		boolean processed, OrderByComparator orderByComparator)
		throws NoSuchMarcBatchUploadException, SystemException {
		MarcBatchUpload marcBatchUpload = fetchByStatus_Last(groupId,
				companyId, processed, orderByComparator);

		if (marcBatchUpload != null) {
			return marcBatchUpload;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", processed=");
		msg.append(processed);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMarcBatchUploadException(msg.toString());
	}

	/**
	 * Returns the last marc batch upload in the ordered set where groupId = &#63; and companyId = &#63; and processed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param processed the processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marc batch upload, or <code>null</code> if a matching marc batch upload could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUpload fetchByStatus_Last(long groupId, long companyId,
		boolean processed, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByStatus(groupId, companyId, processed);

		if (count == 0) {
			return null;
		}

		List<MarcBatchUpload> list = findByStatus(groupId, companyId,
				processed, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the marc batch uploads before and after the current marc batch upload in the ordered set where groupId = &#63; and companyId = &#63; and processed = &#63;.
	 *
	 * @param marcBatchUploadId the primary key of the current marc batch upload
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param processed the processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next marc batch upload
	 * @throws com.kencana.lms.NoSuchMarcBatchUploadException if a marc batch upload with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUpload[] findByStatus_PrevAndNext(long marcBatchUploadId,
		long groupId, long companyId, boolean processed,
		OrderByComparator orderByComparator)
		throws NoSuchMarcBatchUploadException, SystemException {
		MarcBatchUpload marcBatchUpload = findByPrimaryKey(marcBatchUploadId);

		Session session = null;

		try {
			session = openSession();

			MarcBatchUpload[] array = new MarcBatchUploadImpl[3];

			array[0] = getByStatus_PrevAndNext(session, marcBatchUpload,
					groupId, companyId, processed, orderByComparator, true);

			array[1] = marcBatchUpload;

			array[2] = getByStatus_PrevAndNext(session, marcBatchUpload,
					groupId, companyId, processed, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MarcBatchUpload getByStatus_PrevAndNext(Session session,
		MarcBatchUpload marcBatchUpload, long groupId, long companyId,
		boolean processed, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MARCBATCHUPLOAD_WHERE);

		query.append(_FINDER_COLUMN_STATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_STATUS_COMPANYID_2);

		query.append(_FINDER_COLUMN_STATUS_PROCESSED_2);

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
			query.append(MarcBatchUploadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		qPos.add(processed);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(marcBatchUpload);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MarcBatchUpload> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the marc batch uploads where groupId = &#63; and companyId = &#63; and processed = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param processed the processed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStatus(long groupId, long companyId, boolean processed)
		throws SystemException {
		for (MarcBatchUpload marcBatchUpload : findByStatus(groupId, companyId,
				processed, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(marcBatchUpload);
		}
	}

	/**
	 * Returns the number of marc batch uploads where groupId = &#63; and companyId = &#63; and processed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param processed the processed
	 * @return the number of matching marc batch uploads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStatus(long groupId, long companyId, boolean processed)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { groupId, companyId, processed };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_MARCBATCHUPLOAD_WHERE);

			query.append(_FINDER_COLUMN_STATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_STATUS_COMPANYID_2);

			query.append(_FINDER_COLUMN_STATUS_PROCESSED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(processed);

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

	private static final String _FINDER_COLUMN_STATUS_GROUPID_2 = "marcBatchUpload.groupId = ? AND ";
	private static final String _FINDER_COLUMN_STATUS_COMPANYID_2 = "marcBatchUpload.companyId = ? AND ";
	private static final String _FINDER_COLUMN_STATUS_PROCESSED_2 = "marcBatchUpload.processed = ?";

	public MarcBatchUploadPersistenceImpl() {
		setModelClass(MarcBatchUpload.class);
	}

	/**
	 * Caches the marc batch upload in the entity cache if it is enabled.
	 *
	 * @param marcBatchUpload the marc batch upload
	 */
	@Override
	public void cacheResult(MarcBatchUpload marcBatchUpload) {
		EntityCacheUtil.putResult(MarcBatchUploadModelImpl.ENTITY_CACHE_ENABLED,
			MarcBatchUploadImpl.class, marcBatchUpload.getPrimaryKey(),
			marcBatchUpload);

		marcBatchUpload.resetOriginalValues();
	}

	/**
	 * Caches the marc batch uploads in the entity cache if it is enabled.
	 *
	 * @param marcBatchUploads the marc batch uploads
	 */
	@Override
	public void cacheResult(List<MarcBatchUpload> marcBatchUploads) {
		for (MarcBatchUpload marcBatchUpload : marcBatchUploads) {
			if (EntityCacheUtil.getResult(
						MarcBatchUploadModelImpl.ENTITY_CACHE_ENABLED,
						MarcBatchUploadImpl.class,
						marcBatchUpload.getPrimaryKey()) == null) {
				cacheResult(marcBatchUpload);
			}
			else {
				marcBatchUpload.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all marc batch uploads.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MarcBatchUploadImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MarcBatchUploadImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the marc batch upload.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MarcBatchUpload marcBatchUpload) {
		EntityCacheUtil.removeResult(MarcBatchUploadModelImpl.ENTITY_CACHE_ENABLED,
			MarcBatchUploadImpl.class, marcBatchUpload.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<MarcBatchUpload> marcBatchUploads) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MarcBatchUpload marcBatchUpload : marcBatchUploads) {
			EntityCacheUtil.removeResult(MarcBatchUploadModelImpl.ENTITY_CACHE_ENABLED,
				MarcBatchUploadImpl.class, marcBatchUpload.getPrimaryKey());
		}
	}

	/**
	 * Creates a new marc batch upload with the primary key. Does not add the marc batch upload to the database.
	 *
	 * @param marcBatchUploadId the primary key for the new marc batch upload
	 * @return the new marc batch upload
	 */
	@Override
	public MarcBatchUpload create(long marcBatchUploadId) {
		MarcBatchUpload marcBatchUpload = new MarcBatchUploadImpl();

		marcBatchUpload.setNew(true);
		marcBatchUpload.setPrimaryKey(marcBatchUploadId);

		return marcBatchUpload;
	}

	/**
	 * Removes the marc batch upload with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param marcBatchUploadId the primary key of the marc batch upload
	 * @return the marc batch upload that was removed
	 * @throws com.kencana.lms.NoSuchMarcBatchUploadException if a marc batch upload with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUpload remove(long marcBatchUploadId)
		throws NoSuchMarcBatchUploadException, SystemException {
		return remove((Serializable)marcBatchUploadId);
	}

	/**
	 * Removes the marc batch upload with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the marc batch upload
	 * @return the marc batch upload that was removed
	 * @throws com.kencana.lms.NoSuchMarcBatchUploadException if a marc batch upload with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUpload remove(Serializable primaryKey)
		throws NoSuchMarcBatchUploadException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MarcBatchUpload marcBatchUpload = (MarcBatchUpload)session.get(MarcBatchUploadImpl.class,
					primaryKey);

			if (marcBatchUpload == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMarcBatchUploadException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(marcBatchUpload);
		}
		catch (NoSuchMarcBatchUploadException nsee) {
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
	protected MarcBatchUpload removeImpl(MarcBatchUpload marcBatchUpload)
		throws SystemException {
		marcBatchUpload = toUnwrappedModel(marcBatchUpload);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(marcBatchUpload)) {
				marcBatchUpload = (MarcBatchUpload)session.get(MarcBatchUploadImpl.class,
						marcBatchUpload.getPrimaryKeyObj());
			}

			if (marcBatchUpload != null) {
				session.delete(marcBatchUpload);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (marcBatchUpload != null) {
			clearCache(marcBatchUpload);
		}

		return marcBatchUpload;
	}

	@Override
	public MarcBatchUpload updateImpl(
		com.kencana.lms.model.MarcBatchUpload marcBatchUpload)
		throws SystemException {
		marcBatchUpload = toUnwrappedModel(marcBatchUpload);

		boolean isNew = marcBatchUpload.isNew();

		MarcBatchUploadModelImpl marcBatchUploadModelImpl = (MarcBatchUploadModelImpl)marcBatchUpload;

		Session session = null;

		try {
			session = openSession();

			if (marcBatchUpload.isNew()) {
				session.save(marcBatchUpload);

				marcBatchUpload.setNew(false);
			}
			else {
				session.merge(marcBatchUpload);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MarcBatchUploadModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((marcBatchUploadModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						marcBatchUploadModelImpl.getOriginalCompanyId(),
						marcBatchUploadModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);

				args = new Object[] {
						marcBatchUploadModelImpl.getCompanyId(),
						marcBatchUploadModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);
			}

			if ((marcBatchUploadModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						marcBatchUploadModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] { marcBatchUploadModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}

			if ((marcBatchUploadModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						marcBatchUploadModelImpl.getOriginalGroupId(),
						marcBatchUploadModelImpl.getOriginalCompanyId(),
						marcBatchUploadModelImpl.getOriginalProcessed()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] {
						marcBatchUploadModelImpl.getGroupId(),
						marcBatchUploadModelImpl.getCompanyId(),
						marcBatchUploadModelImpl.getProcessed()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(MarcBatchUploadModelImpl.ENTITY_CACHE_ENABLED,
			MarcBatchUploadImpl.class, marcBatchUpload.getPrimaryKey(),
			marcBatchUpload);

		return marcBatchUpload;
	}

	protected MarcBatchUpload toUnwrappedModel(MarcBatchUpload marcBatchUpload) {
		if (marcBatchUpload instanceof MarcBatchUploadImpl) {
			return marcBatchUpload;
		}

		MarcBatchUploadImpl marcBatchUploadImpl = new MarcBatchUploadImpl();

		marcBatchUploadImpl.setNew(marcBatchUpload.isNew());
		marcBatchUploadImpl.setPrimaryKey(marcBatchUpload.getPrimaryKey());

		marcBatchUploadImpl.setMarcBatchUploadId(marcBatchUpload.getMarcBatchUploadId());
		marcBatchUploadImpl.setGroupId(marcBatchUpload.getGroupId());
		marcBatchUploadImpl.setCompanyId(marcBatchUpload.getCompanyId());
		marcBatchUploadImpl.setCreateBy(marcBatchUpload.getCreateBy());
		marcBatchUploadImpl.setCreatedDate(marcBatchUpload.getCreatedDate());
		marcBatchUploadImpl.setProcessed(marcBatchUpload.isProcessed());
		marcBatchUploadImpl.setImportDate(marcBatchUpload.getImportDate());
		marcBatchUploadImpl.setImportByUserId(marcBatchUpload.getImportByUserId());
		marcBatchUploadImpl.setPartialImport(marcBatchUpload.isPartialImport());
		marcBatchUploadImpl.setFileCount(marcBatchUpload.getFileCount());
		marcBatchUploadImpl.setDescription(marcBatchUpload.getDescription());
		marcBatchUploadImpl.setRecordCount(marcBatchUpload.getRecordCount());

		return marcBatchUploadImpl;
	}

	/**
	 * Returns the marc batch upload with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the marc batch upload
	 * @return the marc batch upload
	 * @throws com.kencana.lms.NoSuchMarcBatchUploadException if a marc batch upload with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUpload findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMarcBatchUploadException, SystemException {
		MarcBatchUpload marcBatchUpload = fetchByPrimaryKey(primaryKey);

		if (marcBatchUpload == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMarcBatchUploadException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return marcBatchUpload;
	}

	/**
	 * Returns the marc batch upload with the primary key or throws a {@link com.kencana.lms.NoSuchMarcBatchUploadException} if it could not be found.
	 *
	 * @param marcBatchUploadId the primary key of the marc batch upload
	 * @return the marc batch upload
	 * @throws com.kencana.lms.NoSuchMarcBatchUploadException if a marc batch upload with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUpload findByPrimaryKey(long marcBatchUploadId)
		throws NoSuchMarcBatchUploadException, SystemException {
		return findByPrimaryKey((Serializable)marcBatchUploadId);
	}

	/**
	 * Returns the marc batch upload with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the marc batch upload
	 * @return the marc batch upload, or <code>null</code> if a marc batch upload with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUpload fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		MarcBatchUpload marcBatchUpload = (MarcBatchUpload)EntityCacheUtil.getResult(MarcBatchUploadModelImpl.ENTITY_CACHE_ENABLED,
				MarcBatchUploadImpl.class, primaryKey);

		if (marcBatchUpload == _nullMarcBatchUpload) {
			return null;
		}

		if (marcBatchUpload == null) {
			Session session = null;

			try {
				session = openSession();

				marcBatchUpload = (MarcBatchUpload)session.get(MarcBatchUploadImpl.class,
						primaryKey);

				if (marcBatchUpload != null) {
					cacheResult(marcBatchUpload);
				}
				else {
					EntityCacheUtil.putResult(MarcBatchUploadModelImpl.ENTITY_CACHE_ENABLED,
						MarcBatchUploadImpl.class, primaryKey,
						_nullMarcBatchUpload);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MarcBatchUploadModelImpl.ENTITY_CACHE_ENABLED,
					MarcBatchUploadImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return marcBatchUpload;
	}

	/**
	 * Returns the marc batch upload with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param marcBatchUploadId the primary key of the marc batch upload
	 * @return the marc batch upload, or <code>null</code> if a marc batch upload with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUpload fetchByPrimaryKey(long marcBatchUploadId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)marcBatchUploadId);
	}

	/**
	 * Returns all the marc batch uploads.
	 *
	 * @return the marc batch uploads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MarcBatchUpload> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the marc batch uploads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcBatchUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of marc batch uploads
	 * @param end the upper bound of the range of marc batch uploads (not inclusive)
	 * @return the range of marc batch uploads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MarcBatchUpload> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the marc batch uploads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcBatchUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of marc batch uploads
	 * @param end the upper bound of the range of marc batch uploads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of marc batch uploads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MarcBatchUpload> findAll(int start, int end,
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

		List<MarcBatchUpload> list = (List<MarcBatchUpload>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MARCBATCHUPLOAD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MARCBATCHUPLOAD;

				if (pagination) {
					sql = sql.concat(MarcBatchUploadModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MarcBatchUpload>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MarcBatchUpload>(list);
				}
				else {
					list = (List<MarcBatchUpload>)QueryUtil.list(q,
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
	 * Removes all the marc batch uploads from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (MarcBatchUpload marcBatchUpload : findAll()) {
			remove(marcBatchUpload);
		}
	}

	/**
	 * Returns the number of marc batch uploads.
	 *
	 * @return the number of marc batch uploads
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

				Query q = session.createQuery(_SQL_COUNT_MARCBATCHUPLOAD);

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
	 * Initializes the marc batch upload persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.kencana.lms.model.MarcBatchUpload")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MarcBatchUpload>> listenersList = new ArrayList<ModelListener<MarcBatchUpload>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MarcBatchUpload>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MarcBatchUploadImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MARCBATCHUPLOAD = "SELECT marcBatchUpload FROM MarcBatchUpload marcBatchUpload";
	private static final String _SQL_SELECT_MARCBATCHUPLOAD_WHERE = "SELECT marcBatchUpload FROM MarcBatchUpload marcBatchUpload WHERE ";
	private static final String _SQL_COUNT_MARCBATCHUPLOAD = "SELECT COUNT(marcBatchUpload) FROM MarcBatchUpload marcBatchUpload";
	private static final String _SQL_COUNT_MARCBATCHUPLOAD_WHERE = "SELECT COUNT(marcBatchUpload) FROM MarcBatchUpload marcBatchUpload WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "marcBatchUpload.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MarcBatchUpload exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MarcBatchUpload exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MarcBatchUploadPersistenceImpl.class);
	private static MarcBatchUpload _nullMarcBatchUpload = new MarcBatchUploadImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MarcBatchUpload> toCacheModel() {
				return _nullMarcBatchUploadCacheModel;
			}
		};

	private static CacheModel<MarcBatchUpload> _nullMarcBatchUploadCacheModel = new CacheModel<MarcBatchUpload>() {
			@Override
			public MarcBatchUpload toEntityModel() {
				return _nullMarcBatchUpload;
			}
		};
}