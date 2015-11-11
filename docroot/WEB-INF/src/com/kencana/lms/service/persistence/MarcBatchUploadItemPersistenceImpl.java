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

import com.kencana.lms.NoSuchMarcBatchUploadItemException;
import com.kencana.lms.model.MarcBatchUploadItem;
import com.kencana.lms.model.impl.MarcBatchUploadItemImpl;
import com.kencana.lms.model.impl.MarcBatchUploadItemModelImpl;

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
 * The persistence implementation for the marc batch upload item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see MarcBatchUploadItemPersistence
 * @see MarcBatchUploadItemUtil
 * @generated
 */
public class MarcBatchUploadItemPersistenceImpl extends BasePersistenceImpl<MarcBatchUploadItem>
	implements MarcBatchUploadItemPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MarcBatchUploadItemUtil} to access the marc batch upload item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MarcBatchUploadItemImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MarcBatchUploadItemModelImpl.ENTITY_CACHE_ENABLED,
			MarcBatchUploadItemModelImpl.FINDER_CACHE_ENABLED,
			MarcBatchUploadItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MarcBatchUploadItemModelImpl.ENTITY_CACHE_ENABLED,
			MarcBatchUploadItemModelImpl.FINDER_CACHE_ENABLED,
			MarcBatchUploadItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MarcBatchUploadItemModelImpl.ENTITY_CACHE_ENABLED,
			MarcBatchUploadItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BATCHID = new FinderPath(MarcBatchUploadItemModelImpl.ENTITY_CACHE_ENABLED,
			MarcBatchUploadItemModelImpl.FINDER_CACHE_ENABLED,
			MarcBatchUploadItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBatchId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BATCHID =
		new FinderPath(MarcBatchUploadItemModelImpl.ENTITY_CACHE_ENABLED,
			MarcBatchUploadItemModelImpl.FINDER_CACHE_ENABLED,
			MarcBatchUploadItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBatchId",
			new String[] { Long.class.getName() },
			MarcBatchUploadItemModelImpl.MARCBATCHUPLOADID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BATCHID = new FinderPath(MarcBatchUploadItemModelImpl.ENTITY_CACHE_ENABLED,
			MarcBatchUploadItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBatchId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the marc batch upload items where marcBatchUploadId = &#63;.
	 *
	 * @param marcBatchUploadId the marc batch upload ID
	 * @return the matching marc batch upload items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MarcBatchUploadItem> findByBatchId(long marcBatchUploadId)
		throws SystemException {
		return findByBatchId(marcBatchUploadId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the marc batch upload items where marcBatchUploadId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcBatchUploadItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marcBatchUploadId the marc batch upload ID
	 * @param start the lower bound of the range of marc batch upload items
	 * @param end the upper bound of the range of marc batch upload items (not inclusive)
	 * @return the range of matching marc batch upload items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MarcBatchUploadItem> findByBatchId(long marcBatchUploadId,
		int start, int end) throws SystemException {
		return findByBatchId(marcBatchUploadId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the marc batch upload items where marcBatchUploadId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcBatchUploadItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marcBatchUploadId the marc batch upload ID
	 * @param start the lower bound of the range of marc batch upload items
	 * @param end the upper bound of the range of marc batch upload items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching marc batch upload items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MarcBatchUploadItem> findByBatchId(long marcBatchUploadId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BATCHID;
			finderArgs = new Object[] { marcBatchUploadId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BATCHID;
			finderArgs = new Object[] {
					marcBatchUploadId,
					
					start, end, orderByComparator
				};
		}

		List<MarcBatchUploadItem> list = (List<MarcBatchUploadItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MarcBatchUploadItem marcBatchUploadItem : list) {
				if ((marcBatchUploadId != marcBatchUploadItem.getMarcBatchUploadId())) {
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

			query.append(_SQL_SELECT_MARCBATCHUPLOADITEM_WHERE);

			query.append(_FINDER_COLUMN_BATCHID_MARCBATCHUPLOADID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MarcBatchUploadItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(marcBatchUploadId);

				if (!pagination) {
					list = (List<MarcBatchUploadItem>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MarcBatchUploadItem>(list);
				}
				else {
					list = (List<MarcBatchUploadItem>)QueryUtil.list(q,
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
	 * Returns the first marc batch upload item in the ordered set where marcBatchUploadId = &#63;.
	 *
	 * @param marcBatchUploadId the marc batch upload ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marc batch upload item
	 * @throws com.kencana.lms.NoSuchMarcBatchUploadItemException if a matching marc batch upload item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUploadItem findByBatchId_First(long marcBatchUploadId,
		OrderByComparator orderByComparator)
		throws NoSuchMarcBatchUploadItemException, SystemException {
		MarcBatchUploadItem marcBatchUploadItem = fetchByBatchId_First(marcBatchUploadId,
				orderByComparator);

		if (marcBatchUploadItem != null) {
			return marcBatchUploadItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("marcBatchUploadId=");
		msg.append(marcBatchUploadId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMarcBatchUploadItemException(msg.toString());
	}

	/**
	 * Returns the first marc batch upload item in the ordered set where marcBatchUploadId = &#63;.
	 *
	 * @param marcBatchUploadId the marc batch upload ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marc batch upload item, or <code>null</code> if a matching marc batch upload item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUploadItem fetchByBatchId_First(long marcBatchUploadId,
		OrderByComparator orderByComparator) throws SystemException {
		List<MarcBatchUploadItem> list = findByBatchId(marcBatchUploadId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last marc batch upload item in the ordered set where marcBatchUploadId = &#63;.
	 *
	 * @param marcBatchUploadId the marc batch upload ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marc batch upload item
	 * @throws com.kencana.lms.NoSuchMarcBatchUploadItemException if a matching marc batch upload item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUploadItem findByBatchId_Last(long marcBatchUploadId,
		OrderByComparator orderByComparator)
		throws NoSuchMarcBatchUploadItemException, SystemException {
		MarcBatchUploadItem marcBatchUploadItem = fetchByBatchId_Last(marcBatchUploadId,
				orderByComparator);

		if (marcBatchUploadItem != null) {
			return marcBatchUploadItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("marcBatchUploadId=");
		msg.append(marcBatchUploadId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMarcBatchUploadItemException(msg.toString());
	}

	/**
	 * Returns the last marc batch upload item in the ordered set where marcBatchUploadId = &#63;.
	 *
	 * @param marcBatchUploadId the marc batch upload ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marc batch upload item, or <code>null</code> if a matching marc batch upload item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUploadItem fetchByBatchId_Last(long marcBatchUploadId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByBatchId(marcBatchUploadId);

		if (count == 0) {
			return null;
		}

		List<MarcBatchUploadItem> list = findByBatchId(marcBatchUploadId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the marc batch upload items before and after the current marc batch upload item in the ordered set where marcBatchUploadId = &#63;.
	 *
	 * @param marcBatchUploadItemId the primary key of the current marc batch upload item
	 * @param marcBatchUploadId the marc batch upload ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next marc batch upload item
	 * @throws com.kencana.lms.NoSuchMarcBatchUploadItemException if a marc batch upload item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUploadItem[] findByBatchId_PrevAndNext(
		long marcBatchUploadItemId, long marcBatchUploadId,
		OrderByComparator orderByComparator)
		throws NoSuchMarcBatchUploadItemException, SystemException {
		MarcBatchUploadItem marcBatchUploadItem = findByPrimaryKey(marcBatchUploadItemId);

		Session session = null;

		try {
			session = openSession();

			MarcBatchUploadItem[] array = new MarcBatchUploadItemImpl[3];

			array[0] = getByBatchId_PrevAndNext(session, marcBatchUploadItem,
					marcBatchUploadId, orderByComparator, true);

			array[1] = marcBatchUploadItem;

			array[2] = getByBatchId_PrevAndNext(session, marcBatchUploadItem,
					marcBatchUploadId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MarcBatchUploadItem getByBatchId_PrevAndNext(Session session,
		MarcBatchUploadItem marcBatchUploadItem, long marcBatchUploadId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MARCBATCHUPLOADITEM_WHERE);

		query.append(_FINDER_COLUMN_BATCHID_MARCBATCHUPLOADID_2);

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
			query.append(MarcBatchUploadItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(marcBatchUploadId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(marcBatchUploadItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MarcBatchUploadItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the marc batch upload items where marcBatchUploadId = &#63; from the database.
	 *
	 * @param marcBatchUploadId the marc batch upload ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByBatchId(long marcBatchUploadId)
		throws SystemException {
		for (MarcBatchUploadItem marcBatchUploadItem : findByBatchId(
				marcBatchUploadId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(marcBatchUploadItem);
		}
	}

	/**
	 * Returns the number of marc batch upload items where marcBatchUploadId = &#63;.
	 *
	 * @param marcBatchUploadId the marc batch upload ID
	 * @return the number of matching marc batch upload items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBatchId(long marcBatchUploadId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BATCHID;

		Object[] finderArgs = new Object[] { marcBatchUploadId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MARCBATCHUPLOADITEM_WHERE);

			query.append(_FINDER_COLUMN_BATCHID_MARCBATCHUPLOADID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(marcBatchUploadId);

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

	private static final String _FINDER_COLUMN_BATCHID_MARCBATCHUPLOADID_2 = "marcBatchUploadItem.marcBatchUploadId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BATCHSTATUS =
		new FinderPath(MarcBatchUploadItemModelImpl.ENTITY_CACHE_ENABLED,
			MarcBatchUploadItemModelImpl.FINDER_CACHE_ENABLED,
			MarcBatchUploadItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBatchStatus",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BATCHSTATUS =
		new FinderPath(MarcBatchUploadItemModelImpl.ENTITY_CACHE_ENABLED,
			MarcBatchUploadItemModelImpl.FINDER_CACHE_ENABLED,
			MarcBatchUploadItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBatchStatus",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			MarcBatchUploadItemModelImpl.MARCBATCHUPLOADID_COLUMN_BITMASK |
			MarcBatchUploadItemModelImpl.PROCESSED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BATCHSTATUS = new FinderPath(MarcBatchUploadItemModelImpl.ENTITY_CACHE_ENABLED,
			MarcBatchUploadItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBatchStatus",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the marc batch upload items where marcBatchUploadId = &#63; and processed = &#63;.
	 *
	 * @param marcBatchUploadId the marc batch upload ID
	 * @param processed the processed
	 * @return the matching marc batch upload items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MarcBatchUploadItem> findByBatchStatus(long marcBatchUploadId,
		boolean processed) throws SystemException {
		return findByBatchStatus(marcBatchUploadId, processed,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the marc batch upload items where marcBatchUploadId = &#63; and processed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcBatchUploadItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marcBatchUploadId the marc batch upload ID
	 * @param processed the processed
	 * @param start the lower bound of the range of marc batch upload items
	 * @param end the upper bound of the range of marc batch upload items (not inclusive)
	 * @return the range of matching marc batch upload items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MarcBatchUploadItem> findByBatchStatus(long marcBatchUploadId,
		boolean processed, int start, int end) throws SystemException {
		return findByBatchStatus(marcBatchUploadId, processed, start, end, null);
	}

	/**
	 * Returns an ordered range of all the marc batch upload items where marcBatchUploadId = &#63; and processed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcBatchUploadItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param marcBatchUploadId the marc batch upload ID
	 * @param processed the processed
	 * @param start the lower bound of the range of marc batch upload items
	 * @param end the upper bound of the range of marc batch upload items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching marc batch upload items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MarcBatchUploadItem> findByBatchStatus(long marcBatchUploadId,
		boolean processed, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BATCHSTATUS;
			finderArgs = new Object[] { marcBatchUploadId, processed };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BATCHSTATUS;
			finderArgs = new Object[] {
					marcBatchUploadId, processed,
					
					start, end, orderByComparator
				};
		}

		List<MarcBatchUploadItem> list = (List<MarcBatchUploadItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MarcBatchUploadItem marcBatchUploadItem : list) {
				if ((marcBatchUploadId != marcBatchUploadItem.getMarcBatchUploadId()) ||
						(processed != marcBatchUploadItem.getProcessed())) {
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

			query.append(_SQL_SELECT_MARCBATCHUPLOADITEM_WHERE);

			query.append(_FINDER_COLUMN_BATCHSTATUS_MARCBATCHUPLOADID_2);

			query.append(_FINDER_COLUMN_BATCHSTATUS_PROCESSED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MarcBatchUploadItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(marcBatchUploadId);

				qPos.add(processed);

				if (!pagination) {
					list = (List<MarcBatchUploadItem>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MarcBatchUploadItem>(list);
				}
				else {
					list = (List<MarcBatchUploadItem>)QueryUtil.list(q,
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
	 * Returns the first marc batch upload item in the ordered set where marcBatchUploadId = &#63; and processed = &#63;.
	 *
	 * @param marcBatchUploadId the marc batch upload ID
	 * @param processed the processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marc batch upload item
	 * @throws com.kencana.lms.NoSuchMarcBatchUploadItemException if a matching marc batch upload item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUploadItem findByBatchStatus_First(long marcBatchUploadId,
		boolean processed, OrderByComparator orderByComparator)
		throws NoSuchMarcBatchUploadItemException, SystemException {
		MarcBatchUploadItem marcBatchUploadItem = fetchByBatchStatus_First(marcBatchUploadId,
				processed, orderByComparator);

		if (marcBatchUploadItem != null) {
			return marcBatchUploadItem;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("marcBatchUploadId=");
		msg.append(marcBatchUploadId);

		msg.append(", processed=");
		msg.append(processed);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMarcBatchUploadItemException(msg.toString());
	}

	/**
	 * Returns the first marc batch upload item in the ordered set where marcBatchUploadId = &#63; and processed = &#63;.
	 *
	 * @param marcBatchUploadId the marc batch upload ID
	 * @param processed the processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marc batch upload item, or <code>null</code> if a matching marc batch upload item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUploadItem fetchByBatchStatus_First(
		long marcBatchUploadId, boolean processed,
		OrderByComparator orderByComparator) throws SystemException {
		List<MarcBatchUploadItem> list = findByBatchStatus(marcBatchUploadId,
				processed, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last marc batch upload item in the ordered set where marcBatchUploadId = &#63; and processed = &#63;.
	 *
	 * @param marcBatchUploadId the marc batch upload ID
	 * @param processed the processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marc batch upload item
	 * @throws com.kencana.lms.NoSuchMarcBatchUploadItemException if a matching marc batch upload item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUploadItem findByBatchStatus_Last(long marcBatchUploadId,
		boolean processed, OrderByComparator orderByComparator)
		throws NoSuchMarcBatchUploadItemException, SystemException {
		MarcBatchUploadItem marcBatchUploadItem = fetchByBatchStatus_Last(marcBatchUploadId,
				processed, orderByComparator);

		if (marcBatchUploadItem != null) {
			return marcBatchUploadItem;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("marcBatchUploadId=");
		msg.append(marcBatchUploadId);

		msg.append(", processed=");
		msg.append(processed);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMarcBatchUploadItemException(msg.toString());
	}

	/**
	 * Returns the last marc batch upload item in the ordered set where marcBatchUploadId = &#63; and processed = &#63;.
	 *
	 * @param marcBatchUploadId the marc batch upload ID
	 * @param processed the processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marc batch upload item, or <code>null</code> if a matching marc batch upload item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUploadItem fetchByBatchStatus_Last(long marcBatchUploadId,
		boolean processed, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByBatchStatus(marcBatchUploadId, processed);

		if (count == 0) {
			return null;
		}

		List<MarcBatchUploadItem> list = findByBatchStatus(marcBatchUploadId,
				processed, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the marc batch upload items before and after the current marc batch upload item in the ordered set where marcBatchUploadId = &#63; and processed = &#63;.
	 *
	 * @param marcBatchUploadItemId the primary key of the current marc batch upload item
	 * @param marcBatchUploadId the marc batch upload ID
	 * @param processed the processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next marc batch upload item
	 * @throws com.kencana.lms.NoSuchMarcBatchUploadItemException if a marc batch upload item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUploadItem[] findByBatchStatus_PrevAndNext(
		long marcBatchUploadItemId, long marcBatchUploadId, boolean processed,
		OrderByComparator orderByComparator)
		throws NoSuchMarcBatchUploadItemException, SystemException {
		MarcBatchUploadItem marcBatchUploadItem = findByPrimaryKey(marcBatchUploadItemId);

		Session session = null;

		try {
			session = openSession();

			MarcBatchUploadItem[] array = new MarcBatchUploadItemImpl[3];

			array[0] = getByBatchStatus_PrevAndNext(session,
					marcBatchUploadItem, marcBatchUploadId, processed,
					orderByComparator, true);

			array[1] = marcBatchUploadItem;

			array[2] = getByBatchStatus_PrevAndNext(session,
					marcBatchUploadItem, marcBatchUploadId, processed,
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

	protected MarcBatchUploadItem getByBatchStatus_PrevAndNext(
		Session session, MarcBatchUploadItem marcBatchUploadItem,
		long marcBatchUploadId, boolean processed,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MARCBATCHUPLOADITEM_WHERE);

		query.append(_FINDER_COLUMN_BATCHSTATUS_MARCBATCHUPLOADID_2);

		query.append(_FINDER_COLUMN_BATCHSTATUS_PROCESSED_2);

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
			query.append(MarcBatchUploadItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(marcBatchUploadId);

		qPos.add(processed);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(marcBatchUploadItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MarcBatchUploadItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the marc batch upload items where marcBatchUploadId = &#63; and processed = &#63; from the database.
	 *
	 * @param marcBatchUploadId the marc batch upload ID
	 * @param processed the processed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByBatchStatus(long marcBatchUploadId, boolean processed)
		throws SystemException {
		for (MarcBatchUploadItem marcBatchUploadItem : findByBatchStatus(
				marcBatchUploadId, processed, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(marcBatchUploadItem);
		}
	}

	/**
	 * Returns the number of marc batch upload items where marcBatchUploadId = &#63; and processed = &#63;.
	 *
	 * @param marcBatchUploadId the marc batch upload ID
	 * @param processed the processed
	 * @return the number of matching marc batch upload items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBatchStatus(long marcBatchUploadId, boolean processed)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BATCHSTATUS;

		Object[] finderArgs = new Object[] { marcBatchUploadId, processed };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MARCBATCHUPLOADITEM_WHERE);

			query.append(_FINDER_COLUMN_BATCHSTATUS_MARCBATCHUPLOADID_2);

			query.append(_FINDER_COLUMN_BATCHSTATUS_PROCESSED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(marcBatchUploadId);

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

	private static final String _FINDER_COLUMN_BATCHSTATUS_MARCBATCHUPLOADID_2 = "marcBatchUploadItem.marcBatchUploadId = ? AND ";
	private static final String _FINDER_COLUMN_BATCHSTATUS_PROCESSED_2 = "marcBatchUploadItem.processed = ?";

	public MarcBatchUploadItemPersistenceImpl() {
		setModelClass(MarcBatchUploadItem.class);
	}

	/**
	 * Caches the marc batch upload item in the entity cache if it is enabled.
	 *
	 * @param marcBatchUploadItem the marc batch upload item
	 */
	@Override
	public void cacheResult(MarcBatchUploadItem marcBatchUploadItem) {
		EntityCacheUtil.putResult(MarcBatchUploadItemModelImpl.ENTITY_CACHE_ENABLED,
			MarcBatchUploadItemImpl.class, marcBatchUploadItem.getPrimaryKey(),
			marcBatchUploadItem);

		marcBatchUploadItem.resetOriginalValues();
	}

	/**
	 * Caches the marc batch upload items in the entity cache if it is enabled.
	 *
	 * @param marcBatchUploadItems the marc batch upload items
	 */
	@Override
	public void cacheResult(List<MarcBatchUploadItem> marcBatchUploadItems) {
		for (MarcBatchUploadItem marcBatchUploadItem : marcBatchUploadItems) {
			if (EntityCacheUtil.getResult(
						MarcBatchUploadItemModelImpl.ENTITY_CACHE_ENABLED,
						MarcBatchUploadItemImpl.class,
						marcBatchUploadItem.getPrimaryKey()) == null) {
				cacheResult(marcBatchUploadItem);
			}
			else {
				marcBatchUploadItem.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all marc batch upload items.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MarcBatchUploadItemImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MarcBatchUploadItemImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the marc batch upload item.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MarcBatchUploadItem marcBatchUploadItem) {
		EntityCacheUtil.removeResult(MarcBatchUploadItemModelImpl.ENTITY_CACHE_ENABLED,
			MarcBatchUploadItemImpl.class, marcBatchUploadItem.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<MarcBatchUploadItem> marcBatchUploadItems) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MarcBatchUploadItem marcBatchUploadItem : marcBatchUploadItems) {
			EntityCacheUtil.removeResult(MarcBatchUploadItemModelImpl.ENTITY_CACHE_ENABLED,
				MarcBatchUploadItemImpl.class,
				marcBatchUploadItem.getPrimaryKey());
		}
	}

	/**
	 * Creates a new marc batch upload item with the primary key. Does not add the marc batch upload item to the database.
	 *
	 * @param marcBatchUploadItemId the primary key for the new marc batch upload item
	 * @return the new marc batch upload item
	 */
	@Override
	public MarcBatchUploadItem create(long marcBatchUploadItemId) {
		MarcBatchUploadItem marcBatchUploadItem = new MarcBatchUploadItemImpl();

		marcBatchUploadItem.setNew(true);
		marcBatchUploadItem.setPrimaryKey(marcBatchUploadItemId);

		return marcBatchUploadItem;
	}

	/**
	 * Removes the marc batch upload item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param marcBatchUploadItemId the primary key of the marc batch upload item
	 * @return the marc batch upload item that was removed
	 * @throws com.kencana.lms.NoSuchMarcBatchUploadItemException if a marc batch upload item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUploadItem remove(long marcBatchUploadItemId)
		throws NoSuchMarcBatchUploadItemException, SystemException {
		return remove((Serializable)marcBatchUploadItemId);
	}

	/**
	 * Removes the marc batch upload item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the marc batch upload item
	 * @return the marc batch upload item that was removed
	 * @throws com.kencana.lms.NoSuchMarcBatchUploadItemException if a marc batch upload item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUploadItem remove(Serializable primaryKey)
		throws NoSuchMarcBatchUploadItemException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MarcBatchUploadItem marcBatchUploadItem = (MarcBatchUploadItem)session.get(MarcBatchUploadItemImpl.class,
					primaryKey);

			if (marcBatchUploadItem == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMarcBatchUploadItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(marcBatchUploadItem);
		}
		catch (NoSuchMarcBatchUploadItemException nsee) {
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
	protected MarcBatchUploadItem removeImpl(
		MarcBatchUploadItem marcBatchUploadItem) throws SystemException {
		marcBatchUploadItem = toUnwrappedModel(marcBatchUploadItem);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(marcBatchUploadItem)) {
				marcBatchUploadItem = (MarcBatchUploadItem)session.get(MarcBatchUploadItemImpl.class,
						marcBatchUploadItem.getPrimaryKeyObj());
			}

			if (marcBatchUploadItem != null) {
				session.delete(marcBatchUploadItem);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (marcBatchUploadItem != null) {
			clearCache(marcBatchUploadItem);
		}

		return marcBatchUploadItem;
	}

	@Override
	public MarcBatchUploadItem updateImpl(
		com.kencana.lms.model.MarcBatchUploadItem marcBatchUploadItem)
		throws SystemException {
		marcBatchUploadItem = toUnwrappedModel(marcBatchUploadItem);

		boolean isNew = marcBatchUploadItem.isNew();

		MarcBatchUploadItemModelImpl marcBatchUploadItemModelImpl = (MarcBatchUploadItemModelImpl)marcBatchUploadItem;

		Session session = null;

		try {
			session = openSession();

			if (marcBatchUploadItem.isNew()) {
				session.save(marcBatchUploadItem);

				marcBatchUploadItem.setNew(false);
			}
			else {
				session.merge(marcBatchUploadItem);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MarcBatchUploadItemModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((marcBatchUploadItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BATCHID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						marcBatchUploadItemModelImpl.getOriginalMarcBatchUploadId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BATCHID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BATCHID,
					args);

				args = new Object[] {
						marcBatchUploadItemModelImpl.getMarcBatchUploadId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BATCHID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BATCHID,
					args);
			}

			if ((marcBatchUploadItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BATCHSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						marcBatchUploadItemModelImpl.getOriginalMarcBatchUploadId(),
						marcBatchUploadItemModelImpl.getOriginalProcessed()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BATCHSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BATCHSTATUS,
					args);

				args = new Object[] {
						marcBatchUploadItemModelImpl.getMarcBatchUploadId(),
						marcBatchUploadItemModelImpl.getProcessed()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BATCHSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BATCHSTATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(MarcBatchUploadItemModelImpl.ENTITY_CACHE_ENABLED,
			MarcBatchUploadItemImpl.class, marcBatchUploadItem.getPrimaryKey(),
			marcBatchUploadItem);

		return marcBatchUploadItem;
	}

	protected MarcBatchUploadItem toUnwrappedModel(
		MarcBatchUploadItem marcBatchUploadItem) {
		if (marcBatchUploadItem instanceof MarcBatchUploadItemImpl) {
			return marcBatchUploadItem;
		}

		MarcBatchUploadItemImpl marcBatchUploadItemImpl = new MarcBatchUploadItemImpl();

		marcBatchUploadItemImpl.setNew(marcBatchUploadItem.isNew());
		marcBatchUploadItemImpl.setPrimaryKey(marcBatchUploadItem.getPrimaryKey());

		marcBatchUploadItemImpl.setMarcBatchUploadItemId(marcBatchUploadItem.getMarcBatchUploadItemId());
		marcBatchUploadItemImpl.setMarcBatchUploadId(marcBatchUploadItem.getMarcBatchUploadId());
		marcBatchUploadItemImpl.setGroupId(marcBatchUploadItem.getGroupId());
		marcBatchUploadItemImpl.setCompanyId(marcBatchUploadItem.getCompanyId());
		marcBatchUploadItemImpl.setCreatedBy(marcBatchUploadItem.getCreatedBy());
		marcBatchUploadItemImpl.setCreatedDate(marcBatchUploadItem.getCreatedDate());
		marcBatchUploadItemImpl.setProcessed(marcBatchUploadItem.isProcessed());
		marcBatchUploadItemImpl.setImportDate(marcBatchUploadItem.getImportDate());
		marcBatchUploadItemImpl.setImportByUserId(marcBatchUploadItem.getImportByUserId());
		marcBatchUploadItemImpl.setMarcContent(marcBatchUploadItem.getMarcContent());
		marcBatchUploadItemImpl.setFileName(marcBatchUploadItem.getFileName());
		marcBatchUploadItemImpl.setFileEntryId(marcBatchUploadItem.getFileEntryId());

		return marcBatchUploadItemImpl;
	}

	/**
	 * Returns the marc batch upload item with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the marc batch upload item
	 * @return the marc batch upload item
	 * @throws com.kencana.lms.NoSuchMarcBatchUploadItemException if a marc batch upload item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUploadItem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMarcBatchUploadItemException, SystemException {
		MarcBatchUploadItem marcBatchUploadItem = fetchByPrimaryKey(primaryKey);

		if (marcBatchUploadItem == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMarcBatchUploadItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return marcBatchUploadItem;
	}

	/**
	 * Returns the marc batch upload item with the primary key or throws a {@link com.kencana.lms.NoSuchMarcBatchUploadItemException} if it could not be found.
	 *
	 * @param marcBatchUploadItemId the primary key of the marc batch upload item
	 * @return the marc batch upload item
	 * @throws com.kencana.lms.NoSuchMarcBatchUploadItemException if a marc batch upload item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUploadItem findByPrimaryKey(long marcBatchUploadItemId)
		throws NoSuchMarcBatchUploadItemException, SystemException {
		return findByPrimaryKey((Serializable)marcBatchUploadItemId);
	}

	/**
	 * Returns the marc batch upload item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the marc batch upload item
	 * @return the marc batch upload item, or <code>null</code> if a marc batch upload item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUploadItem fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		MarcBatchUploadItem marcBatchUploadItem = (MarcBatchUploadItem)EntityCacheUtil.getResult(MarcBatchUploadItemModelImpl.ENTITY_CACHE_ENABLED,
				MarcBatchUploadItemImpl.class, primaryKey);

		if (marcBatchUploadItem == _nullMarcBatchUploadItem) {
			return null;
		}

		if (marcBatchUploadItem == null) {
			Session session = null;

			try {
				session = openSession();

				marcBatchUploadItem = (MarcBatchUploadItem)session.get(MarcBatchUploadItemImpl.class,
						primaryKey);

				if (marcBatchUploadItem != null) {
					cacheResult(marcBatchUploadItem);
				}
				else {
					EntityCacheUtil.putResult(MarcBatchUploadItemModelImpl.ENTITY_CACHE_ENABLED,
						MarcBatchUploadItemImpl.class, primaryKey,
						_nullMarcBatchUploadItem);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MarcBatchUploadItemModelImpl.ENTITY_CACHE_ENABLED,
					MarcBatchUploadItemImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return marcBatchUploadItem;
	}

	/**
	 * Returns the marc batch upload item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param marcBatchUploadItemId the primary key of the marc batch upload item
	 * @return the marc batch upload item, or <code>null</code> if a marc batch upload item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcBatchUploadItem fetchByPrimaryKey(long marcBatchUploadItemId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)marcBatchUploadItemId);
	}

	/**
	 * Returns all the marc batch upload items.
	 *
	 * @return the marc batch upload items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MarcBatchUploadItem> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the marc batch upload items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcBatchUploadItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of marc batch upload items
	 * @param end the upper bound of the range of marc batch upload items (not inclusive)
	 * @return the range of marc batch upload items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MarcBatchUploadItem> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the marc batch upload items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcBatchUploadItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of marc batch upload items
	 * @param end the upper bound of the range of marc batch upload items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of marc batch upload items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MarcBatchUploadItem> findAll(int start, int end,
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

		List<MarcBatchUploadItem> list = (List<MarcBatchUploadItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MARCBATCHUPLOADITEM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MARCBATCHUPLOADITEM;

				if (pagination) {
					sql = sql.concat(MarcBatchUploadItemModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MarcBatchUploadItem>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MarcBatchUploadItem>(list);
				}
				else {
					list = (List<MarcBatchUploadItem>)QueryUtil.list(q,
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
	 * Removes all the marc batch upload items from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (MarcBatchUploadItem marcBatchUploadItem : findAll()) {
			remove(marcBatchUploadItem);
		}
	}

	/**
	 * Returns the number of marc batch upload items.
	 *
	 * @return the number of marc batch upload items
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

				Query q = session.createQuery(_SQL_COUNT_MARCBATCHUPLOADITEM);

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
	 * Initializes the marc batch upload item persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.kencana.lms.model.MarcBatchUploadItem")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MarcBatchUploadItem>> listenersList = new ArrayList<ModelListener<MarcBatchUploadItem>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MarcBatchUploadItem>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MarcBatchUploadItemImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MARCBATCHUPLOADITEM = "SELECT marcBatchUploadItem FROM MarcBatchUploadItem marcBatchUploadItem";
	private static final String _SQL_SELECT_MARCBATCHUPLOADITEM_WHERE = "SELECT marcBatchUploadItem FROM MarcBatchUploadItem marcBatchUploadItem WHERE ";
	private static final String _SQL_COUNT_MARCBATCHUPLOADITEM = "SELECT COUNT(marcBatchUploadItem) FROM MarcBatchUploadItem marcBatchUploadItem";
	private static final String _SQL_COUNT_MARCBATCHUPLOADITEM_WHERE = "SELECT COUNT(marcBatchUploadItem) FROM MarcBatchUploadItem marcBatchUploadItem WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "marcBatchUploadItem.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MarcBatchUploadItem exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MarcBatchUploadItem exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MarcBatchUploadItemPersistenceImpl.class);
	private static MarcBatchUploadItem _nullMarcBatchUploadItem = new MarcBatchUploadItemImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MarcBatchUploadItem> toCacheModel() {
				return _nullMarcBatchUploadItemCacheModel;
			}
		};

	private static CacheModel<MarcBatchUploadItem> _nullMarcBatchUploadItemCacheModel =
		new CacheModel<MarcBatchUploadItem>() {
			@Override
			public MarcBatchUploadItem toEntityModel() {
				return _nullMarcBatchUploadItem;
			}
		};
}