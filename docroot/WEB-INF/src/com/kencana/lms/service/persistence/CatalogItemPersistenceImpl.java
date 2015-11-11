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

import com.kencana.lms.NoSuchCatalogItemException;
import com.kencana.lms.model.CatalogItem;
import com.kencana.lms.model.impl.CatalogItemImpl;
import com.kencana.lms.model.impl.CatalogItemModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
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
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the catalog item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see CatalogItemPersistence
 * @see CatalogItemUtil
 * @generated
 */
public class CatalogItemPersistenceImpl extends BasePersistenceImpl<CatalogItem>
	implements CatalogItemPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CatalogItemUtil} to access the catalog item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CatalogItemImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CatalogItemModelImpl.ENTITY_CACHE_ENABLED,
			CatalogItemModelImpl.FINDER_CACHE_ENABLED, CatalogItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CatalogItemModelImpl.ENTITY_CACHE_ENABLED,
			CatalogItemModelImpl.FINDER_CACHE_ENABLED, CatalogItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CatalogItemModelImpl.ENTITY_CACHE_ENABLED,
			CatalogItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATALOG = new FinderPath(CatalogItemModelImpl.ENTITY_CACHE_ENABLED,
			CatalogItemModelImpl.FINDER_CACHE_ENABLED, CatalogItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCatalog",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATALOG =
		new FinderPath(CatalogItemModelImpl.ENTITY_CACHE_ENABLED,
			CatalogItemModelImpl.FINDER_CACHE_ENABLED, CatalogItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCatalog",
			new String[] { Long.class.getName() },
			CatalogItemModelImpl.CATALOGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATALOG = new FinderPath(CatalogItemModelImpl.ENTITY_CACHE_ENABLED,
			CatalogItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCatalog",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the catalog items where catalogId = &#63;.
	 *
	 * @param catalogId the catalog ID
	 * @return the matching catalog items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogItem> findByCatalog(long catalogId)
		throws SystemException {
		return findByCatalog(catalogId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the catalog items where catalogId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param catalogId the catalog ID
	 * @param start the lower bound of the range of catalog items
	 * @param end the upper bound of the range of catalog items (not inclusive)
	 * @return the range of matching catalog items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogItem> findByCatalog(long catalogId, int start, int end)
		throws SystemException {
		return findByCatalog(catalogId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the catalog items where catalogId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param catalogId the catalog ID
	 * @param start the lower bound of the range of catalog items
	 * @param end the upper bound of the range of catalog items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching catalog items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogItem> findByCatalog(long catalogId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATALOG;
			finderArgs = new Object[] { catalogId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATALOG;
			finderArgs = new Object[] { catalogId, start, end, orderByComparator };
		}

		List<CatalogItem> list = (List<CatalogItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CatalogItem catalogItem : list) {
				if ((catalogId != catalogItem.getCatalogId())) {
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

			query.append(_SQL_SELECT_CATALOGITEM_WHERE);

			query.append(_FINDER_COLUMN_CATALOG_CATALOGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CatalogItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(catalogId);

				if (!pagination) {
					list = (List<CatalogItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CatalogItem>(list);
				}
				else {
					list = (List<CatalogItem>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first catalog item in the ordered set where catalogId = &#63;.
	 *
	 * @param catalogId the catalog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog item
	 * @throws com.kencana.lms.NoSuchCatalogItemException if a matching catalog item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem findByCatalog_First(long catalogId,
		OrderByComparator orderByComparator)
		throws NoSuchCatalogItemException, SystemException {
		CatalogItem catalogItem = fetchByCatalog_First(catalogId,
				orderByComparator);

		if (catalogItem != null) {
			return catalogItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("catalogId=");
		msg.append(catalogId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCatalogItemException(msg.toString());
	}

	/**
	 * Returns the first catalog item in the ordered set where catalogId = &#63;.
	 *
	 * @param catalogId the catalog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog item, or <code>null</code> if a matching catalog item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem fetchByCatalog_First(long catalogId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CatalogItem> list = findByCatalog(catalogId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last catalog item in the ordered set where catalogId = &#63;.
	 *
	 * @param catalogId the catalog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog item
	 * @throws com.kencana.lms.NoSuchCatalogItemException if a matching catalog item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem findByCatalog_Last(long catalogId,
		OrderByComparator orderByComparator)
		throws NoSuchCatalogItemException, SystemException {
		CatalogItem catalogItem = fetchByCatalog_Last(catalogId,
				orderByComparator);

		if (catalogItem != null) {
			return catalogItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("catalogId=");
		msg.append(catalogId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCatalogItemException(msg.toString());
	}

	/**
	 * Returns the last catalog item in the ordered set where catalogId = &#63;.
	 *
	 * @param catalogId the catalog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog item, or <code>null</code> if a matching catalog item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem fetchByCatalog_Last(long catalogId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCatalog(catalogId);

		if (count == 0) {
			return null;
		}

		List<CatalogItem> list = findByCatalog(catalogId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the catalog items before and after the current catalog item in the ordered set where catalogId = &#63;.
	 *
	 * @param catalogItemId the primary key of the current catalog item
	 * @param catalogId the catalog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog item
	 * @throws com.kencana.lms.NoSuchCatalogItemException if a catalog item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem[] findByCatalog_PrevAndNext(long catalogItemId,
		long catalogId, OrderByComparator orderByComparator)
		throws NoSuchCatalogItemException, SystemException {
		CatalogItem catalogItem = findByPrimaryKey(catalogItemId);

		Session session = null;

		try {
			session = openSession();

			CatalogItem[] array = new CatalogItemImpl[3];

			array[0] = getByCatalog_PrevAndNext(session, catalogItem,
					catalogId, orderByComparator, true);

			array[1] = catalogItem;

			array[2] = getByCatalog_PrevAndNext(session, catalogItem,
					catalogId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CatalogItem getByCatalog_PrevAndNext(Session session,
		CatalogItem catalogItem, long catalogId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CATALOGITEM_WHERE);

		query.append(_FINDER_COLUMN_CATALOG_CATALOGID_2);

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
			query.append(CatalogItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(catalogId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(catalogItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CatalogItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the catalog items where catalogId = &#63; from the database.
	 *
	 * @param catalogId the catalog ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCatalog(long catalogId) throws SystemException {
		for (CatalogItem catalogItem : findByCatalog(catalogId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(catalogItem);
		}
	}

	/**
	 * Returns the number of catalog items where catalogId = &#63;.
	 *
	 * @param catalogId the catalog ID
	 * @return the number of matching catalog items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCatalog(long catalogId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATALOG;

		Object[] finderArgs = new Object[] { catalogId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CATALOGITEM_WHERE);

			query.append(_FINDER_COLUMN_CATALOG_CATALOGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(catalogId);

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

	private static final String _FINDER_COLUMN_CATALOG_CATALOGID_2 = "catalogItem.catalogId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_BARCODE = new FinderPath(CatalogItemModelImpl.ENTITY_CACHE_ENABLED,
			CatalogItemModelImpl.FINDER_CACHE_ENABLED, CatalogItemImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByBarcode",
			new String[] { Long.class.getName(), String.class.getName() },
			CatalogItemModelImpl.COMPANYID_COLUMN_BITMASK |
			CatalogItemModelImpl.BARCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BARCODE = new FinderPath(CatalogItemModelImpl.ENTITY_CACHE_ENABLED,
			CatalogItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBarcode",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the catalog item where companyId = &#63; and barcode = &#63; or throws a {@link com.kencana.lms.NoSuchCatalogItemException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param barcode the barcode
	 * @return the matching catalog item
	 * @throws com.kencana.lms.NoSuchCatalogItemException if a matching catalog item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem findByBarcode(long companyId, String barcode)
		throws NoSuchCatalogItemException, SystemException {
		CatalogItem catalogItem = fetchByBarcode(companyId, barcode);

		if (catalogItem == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", barcode=");
			msg.append(barcode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCatalogItemException(msg.toString());
		}

		return catalogItem;
	}

	/**
	 * Returns the catalog item where companyId = &#63; and barcode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param barcode the barcode
	 * @return the matching catalog item, or <code>null</code> if a matching catalog item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem fetchByBarcode(long companyId, String barcode)
		throws SystemException {
		return fetchByBarcode(companyId, barcode, true);
	}

	/**
	 * Returns the catalog item where companyId = &#63; and barcode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param barcode the barcode
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching catalog item, or <code>null</code> if a matching catalog item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem fetchByBarcode(long companyId, String barcode,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { companyId, barcode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_BARCODE,
					finderArgs, this);
		}

		if (result instanceof CatalogItem) {
			CatalogItem catalogItem = (CatalogItem)result;

			if ((companyId != catalogItem.getCompanyId()) ||
					!Validator.equals(barcode, catalogItem.getBarcode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CATALOGITEM_WHERE);

			query.append(_FINDER_COLUMN_BARCODE_COMPANYID_2);

			boolean bindBarcode = false;

			if (barcode == null) {
				query.append(_FINDER_COLUMN_BARCODE_BARCODE_1);
			}
			else if (barcode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BARCODE_BARCODE_3);
			}
			else {
				bindBarcode = true;

				query.append(_FINDER_COLUMN_BARCODE_BARCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindBarcode) {
					qPos.add(barcode);
				}

				List<CatalogItem> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BARCODE,
						finderArgs, list);
				}
				else {
					CatalogItem catalogItem = list.get(0);

					result = catalogItem;

					cacheResult(catalogItem);

					if ((catalogItem.getCompanyId() != companyId) ||
							(catalogItem.getBarcode() == null) ||
							!catalogItem.getBarcode().equals(barcode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BARCODE,
							finderArgs, catalogItem);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BARCODE,
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
			return (CatalogItem)result;
		}
	}

	/**
	 * Removes the catalog item where companyId = &#63; and barcode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param barcode the barcode
	 * @return the catalog item that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem removeByBarcode(long companyId, String barcode)
		throws NoSuchCatalogItemException, SystemException {
		CatalogItem catalogItem = findByBarcode(companyId, barcode);

		return remove(catalogItem);
	}

	/**
	 * Returns the number of catalog items where companyId = &#63; and barcode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param barcode the barcode
	 * @return the number of matching catalog items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBarcode(long companyId, String barcode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BARCODE;

		Object[] finderArgs = new Object[] { companyId, barcode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CATALOGITEM_WHERE);

			query.append(_FINDER_COLUMN_BARCODE_COMPANYID_2);

			boolean bindBarcode = false;

			if (barcode == null) {
				query.append(_FINDER_COLUMN_BARCODE_BARCODE_1);
			}
			else if (barcode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BARCODE_BARCODE_3);
			}
			else {
				bindBarcode = true;

				query.append(_FINDER_COLUMN_BARCODE_BARCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindBarcode) {
					qPos.add(barcode);
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

	private static final String _FINDER_COLUMN_BARCODE_COMPANYID_2 = "catalogItem.companyId = ? AND ";
	private static final String _FINDER_COLUMN_BARCODE_BARCODE_1 = "catalogItem.barcode IS NULL";
	private static final String _FINDER_COLUMN_BARCODE_BARCODE_2 = "catalogItem.barcode = ?";
	private static final String _FINDER_COLUMN_BARCODE_BARCODE_3 = "(catalogItem.barcode IS NULL OR catalogItem.barcode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_HOLDINGLIBRARY =
		new FinderPath(CatalogItemModelImpl.ENTITY_CACHE_ENABLED,
			CatalogItemModelImpl.FINDER_CACHE_ENABLED, CatalogItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByHoldingLibrary",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOLDINGLIBRARY =
		new FinderPath(CatalogItemModelImpl.ENTITY_CACHE_ENABLED,
			CatalogItemModelImpl.FINDER_CACHE_ENABLED, CatalogItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByHoldingLibrary",
			new String[] { Long.class.getName() },
			CatalogItemModelImpl.HOLDINGLIBRARYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_HOLDINGLIBRARY = new FinderPath(CatalogItemModelImpl.ENTITY_CACHE_ENABLED,
			CatalogItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByHoldingLibrary",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the catalog items where holdingLibraryId = &#63;.
	 *
	 * @param holdingLibraryId the holding library ID
	 * @return the matching catalog items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogItem> findByHoldingLibrary(long holdingLibraryId)
		throws SystemException {
		return findByHoldingLibrary(holdingLibraryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the catalog items where holdingLibraryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param holdingLibraryId the holding library ID
	 * @param start the lower bound of the range of catalog items
	 * @param end the upper bound of the range of catalog items (not inclusive)
	 * @return the range of matching catalog items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogItem> findByHoldingLibrary(long holdingLibraryId,
		int start, int end) throws SystemException {
		return findByHoldingLibrary(holdingLibraryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the catalog items where holdingLibraryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param holdingLibraryId the holding library ID
	 * @param start the lower bound of the range of catalog items
	 * @param end the upper bound of the range of catalog items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching catalog items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogItem> findByHoldingLibrary(long holdingLibraryId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOLDINGLIBRARY;
			finderArgs = new Object[] { holdingLibraryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_HOLDINGLIBRARY;
			finderArgs = new Object[] {
					holdingLibraryId,
					
					start, end, orderByComparator
				};
		}

		List<CatalogItem> list = (List<CatalogItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CatalogItem catalogItem : list) {
				if ((holdingLibraryId != catalogItem.getHoldingLibraryId())) {
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

			query.append(_SQL_SELECT_CATALOGITEM_WHERE);

			query.append(_FINDER_COLUMN_HOLDINGLIBRARY_HOLDINGLIBRARYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CatalogItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(holdingLibraryId);

				if (!pagination) {
					list = (List<CatalogItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CatalogItem>(list);
				}
				else {
					list = (List<CatalogItem>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first catalog item in the ordered set where holdingLibraryId = &#63;.
	 *
	 * @param holdingLibraryId the holding library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog item
	 * @throws com.kencana.lms.NoSuchCatalogItemException if a matching catalog item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem findByHoldingLibrary_First(long holdingLibraryId,
		OrderByComparator orderByComparator)
		throws NoSuchCatalogItemException, SystemException {
		CatalogItem catalogItem = fetchByHoldingLibrary_First(holdingLibraryId,
				orderByComparator);

		if (catalogItem != null) {
			return catalogItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("holdingLibraryId=");
		msg.append(holdingLibraryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCatalogItemException(msg.toString());
	}

	/**
	 * Returns the first catalog item in the ordered set where holdingLibraryId = &#63;.
	 *
	 * @param holdingLibraryId the holding library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog item, or <code>null</code> if a matching catalog item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem fetchByHoldingLibrary_First(long holdingLibraryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CatalogItem> list = findByHoldingLibrary(holdingLibraryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last catalog item in the ordered set where holdingLibraryId = &#63;.
	 *
	 * @param holdingLibraryId the holding library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog item
	 * @throws com.kencana.lms.NoSuchCatalogItemException if a matching catalog item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem findByHoldingLibrary_Last(long holdingLibraryId,
		OrderByComparator orderByComparator)
		throws NoSuchCatalogItemException, SystemException {
		CatalogItem catalogItem = fetchByHoldingLibrary_Last(holdingLibraryId,
				orderByComparator);

		if (catalogItem != null) {
			return catalogItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("holdingLibraryId=");
		msg.append(holdingLibraryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCatalogItemException(msg.toString());
	}

	/**
	 * Returns the last catalog item in the ordered set where holdingLibraryId = &#63;.
	 *
	 * @param holdingLibraryId the holding library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog item, or <code>null</code> if a matching catalog item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem fetchByHoldingLibrary_Last(long holdingLibraryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByHoldingLibrary(holdingLibraryId);

		if (count == 0) {
			return null;
		}

		List<CatalogItem> list = findByHoldingLibrary(holdingLibraryId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the catalog items before and after the current catalog item in the ordered set where holdingLibraryId = &#63;.
	 *
	 * @param catalogItemId the primary key of the current catalog item
	 * @param holdingLibraryId the holding library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog item
	 * @throws com.kencana.lms.NoSuchCatalogItemException if a catalog item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem[] findByHoldingLibrary_PrevAndNext(long catalogItemId,
		long holdingLibraryId, OrderByComparator orderByComparator)
		throws NoSuchCatalogItemException, SystemException {
		CatalogItem catalogItem = findByPrimaryKey(catalogItemId);

		Session session = null;

		try {
			session = openSession();

			CatalogItem[] array = new CatalogItemImpl[3];

			array[0] = getByHoldingLibrary_PrevAndNext(session, catalogItem,
					holdingLibraryId, orderByComparator, true);

			array[1] = catalogItem;

			array[2] = getByHoldingLibrary_PrevAndNext(session, catalogItem,
					holdingLibraryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CatalogItem getByHoldingLibrary_PrevAndNext(Session session,
		CatalogItem catalogItem, long holdingLibraryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CATALOGITEM_WHERE);

		query.append(_FINDER_COLUMN_HOLDINGLIBRARY_HOLDINGLIBRARYID_2);

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
			query.append(CatalogItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(holdingLibraryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(catalogItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CatalogItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the catalog items where holdingLibraryId = &#63; from the database.
	 *
	 * @param holdingLibraryId the holding library ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByHoldingLibrary(long holdingLibraryId)
		throws SystemException {
		for (CatalogItem catalogItem : findByHoldingLibrary(holdingLibraryId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(catalogItem);
		}
	}

	/**
	 * Returns the number of catalog items where holdingLibraryId = &#63;.
	 *
	 * @param holdingLibraryId the holding library ID
	 * @return the number of matching catalog items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByHoldingLibrary(long holdingLibraryId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_HOLDINGLIBRARY;

		Object[] finderArgs = new Object[] { holdingLibraryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CATALOGITEM_WHERE);

			query.append(_FINDER_COLUMN_HOLDINGLIBRARY_HOLDINGLIBRARYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(holdingLibraryId);

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

	private static final String _FINDER_COLUMN_HOLDINGLIBRARY_HOLDINGLIBRARYID_2 =
		"catalogItem.holdingLibraryId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RELEASEDCOMPANYGROUP =
		new FinderPath(CatalogItemModelImpl.ENTITY_CACHE_ENABLED,
			CatalogItemModelImpl.FINDER_CACHE_ENABLED, CatalogItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByReleasedCompanyGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RELEASEDCOMPANYGROUP =
		new FinderPath(CatalogItemModelImpl.ENTITY_CACHE_ENABLED,
			CatalogItemModelImpl.FINDER_CACHE_ENABLED, CatalogItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByReleasedCompanyGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			CatalogItemModelImpl.COMPANYID_COLUMN_BITMASK |
			CatalogItemModelImpl.GROUPID_COLUMN_BITMASK |
			CatalogItemModelImpl.RELEASED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RELEASEDCOMPANYGROUP = new FinderPath(CatalogItemModelImpl.ENTITY_CACHE_ENABLED,
			CatalogItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByReleasedCompanyGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns all the catalog items where companyId = &#63; and groupId = &#63; and released = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param released the released
	 * @return the matching catalog items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogItem> findByReleasedCompanyGroup(long companyId,
		long groupId, boolean released) throws SystemException {
		return findByReleasedCompanyGroup(companyId, groupId, released,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the catalog items where companyId = &#63; and groupId = &#63; and released = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param released the released
	 * @param start the lower bound of the range of catalog items
	 * @param end the upper bound of the range of catalog items (not inclusive)
	 * @return the range of matching catalog items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogItem> findByReleasedCompanyGroup(long companyId,
		long groupId, boolean released, int start, int end)
		throws SystemException {
		return findByReleasedCompanyGroup(companyId, groupId, released, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the catalog items where companyId = &#63; and groupId = &#63; and released = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param released the released
	 * @param start the lower bound of the range of catalog items
	 * @param end the upper bound of the range of catalog items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching catalog items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogItem> findByReleasedCompanyGroup(long companyId,
		long groupId, boolean released, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RELEASEDCOMPANYGROUP;
			finderArgs = new Object[] { companyId, groupId, released };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RELEASEDCOMPANYGROUP;
			finderArgs = new Object[] {
					companyId, groupId, released,
					
					start, end, orderByComparator
				};
		}

		List<CatalogItem> list = (List<CatalogItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CatalogItem catalogItem : list) {
				if ((companyId != catalogItem.getCompanyId()) ||
						(groupId != catalogItem.getGroupId()) ||
						(released != catalogItem.getReleased())) {
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

			query.append(_SQL_SELECT_CATALOGITEM_WHERE);

			query.append(_FINDER_COLUMN_RELEASEDCOMPANYGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_RELEASEDCOMPANYGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_RELEASEDCOMPANYGROUP_RELEASED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CatalogItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(released);

				if (!pagination) {
					list = (List<CatalogItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CatalogItem>(list);
				}
				else {
					list = (List<CatalogItem>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first catalog item in the ordered set where companyId = &#63; and groupId = &#63; and released = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param released the released
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog item
	 * @throws com.kencana.lms.NoSuchCatalogItemException if a matching catalog item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem findByReleasedCompanyGroup_First(long companyId,
		long groupId, boolean released, OrderByComparator orderByComparator)
		throws NoSuchCatalogItemException, SystemException {
		CatalogItem catalogItem = fetchByReleasedCompanyGroup_First(companyId,
				groupId, released, orderByComparator);

		if (catalogItem != null) {
			return catalogItem;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", released=");
		msg.append(released);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCatalogItemException(msg.toString());
	}

	/**
	 * Returns the first catalog item in the ordered set where companyId = &#63; and groupId = &#63; and released = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param released the released
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog item, or <code>null</code> if a matching catalog item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem fetchByReleasedCompanyGroup_First(long companyId,
		long groupId, boolean released, OrderByComparator orderByComparator)
		throws SystemException {
		List<CatalogItem> list = findByReleasedCompanyGroup(companyId, groupId,
				released, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last catalog item in the ordered set where companyId = &#63; and groupId = &#63; and released = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param released the released
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog item
	 * @throws com.kencana.lms.NoSuchCatalogItemException if a matching catalog item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem findByReleasedCompanyGroup_Last(long companyId,
		long groupId, boolean released, OrderByComparator orderByComparator)
		throws NoSuchCatalogItemException, SystemException {
		CatalogItem catalogItem = fetchByReleasedCompanyGroup_Last(companyId,
				groupId, released, orderByComparator);

		if (catalogItem != null) {
			return catalogItem;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", released=");
		msg.append(released);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCatalogItemException(msg.toString());
	}

	/**
	 * Returns the last catalog item in the ordered set where companyId = &#63; and groupId = &#63; and released = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param released the released
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog item, or <code>null</code> if a matching catalog item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem fetchByReleasedCompanyGroup_Last(long companyId,
		long groupId, boolean released, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByReleasedCompanyGroup(companyId, groupId, released);

		if (count == 0) {
			return null;
		}

		List<CatalogItem> list = findByReleasedCompanyGroup(companyId, groupId,
				released, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the catalog items before and after the current catalog item in the ordered set where companyId = &#63; and groupId = &#63; and released = &#63;.
	 *
	 * @param catalogItemId the primary key of the current catalog item
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param released the released
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog item
	 * @throws com.kencana.lms.NoSuchCatalogItemException if a catalog item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem[] findByReleasedCompanyGroup_PrevAndNext(
		long catalogItemId, long companyId, long groupId, boolean released,
		OrderByComparator orderByComparator)
		throws NoSuchCatalogItemException, SystemException {
		CatalogItem catalogItem = findByPrimaryKey(catalogItemId);

		Session session = null;

		try {
			session = openSession();

			CatalogItem[] array = new CatalogItemImpl[3];

			array[0] = getByReleasedCompanyGroup_PrevAndNext(session,
					catalogItem, companyId, groupId, released,
					orderByComparator, true);

			array[1] = catalogItem;

			array[2] = getByReleasedCompanyGroup_PrevAndNext(session,
					catalogItem, companyId, groupId, released,
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

	protected CatalogItem getByReleasedCompanyGroup_PrevAndNext(
		Session session, CatalogItem catalogItem, long companyId, long groupId,
		boolean released, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CATALOGITEM_WHERE);

		query.append(_FINDER_COLUMN_RELEASEDCOMPANYGROUP_COMPANYID_2);

		query.append(_FINDER_COLUMN_RELEASEDCOMPANYGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_RELEASEDCOMPANYGROUP_RELEASED_2);

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
			query.append(CatalogItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(released);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(catalogItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CatalogItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the catalog items that the user has permission to view where companyId = &#63; and groupId = &#63; and released = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param released the released
	 * @return the matching catalog items that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogItem> filterFindByReleasedCompanyGroup(long companyId,
		long groupId, boolean released) throws SystemException {
		return filterFindByReleasedCompanyGroup(companyId, groupId, released,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the catalog items that the user has permission to view where companyId = &#63; and groupId = &#63; and released = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param released the released
	 * @param start the lower bound of the range of catalog items
	 * @param end the upper bound of the range of catalog items (not inclusive)
	 * @return the range of matching catalog items that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogItem> filterFindByReleasedCompanyGroup(long companyId,
		long groupId, boolean released, int start, int end)
		throws SystemException {
		return filterFindByReleasedCompanyGroup(companyId, groupId, released,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the catalog items that the user has permissions to view where companyId = &#63; and groupId = &#63; and released = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param released the released
	 * @param start the lower bound of the range of catalog items
	 * @param end the upper bound of the range of catalog items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching catalog items that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogItem> filterFindByReleasedCompanyGroup(long companyId,
		long groupId, boolean released, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByReleasedCompanyGroup(companyId, groupId, released,
				start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CATALOGITEM_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CATALOGITEM_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_RELEASEDCOMPANYGROUP_COMPANYID_2);

		query.append(_FINDER_COLUMN_RELEASEDCOMPANYGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_RELEASEDCOMPANYGROUP_RELEASED_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CATALOGITEM_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CatalogItemModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CatalogItemModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CatalogItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CatalogItemImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CatalogItemImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			qPos.add(released);

			return (List<CatalogItem>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the catalog items before and after the current catalog item in the ordered set of catalog items that the user has permission to view where companyId = &#63; and groupId = &#63; and released = &#63;.
	 *
	 * @param catalogItemId the primary key of the current catalog item
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param released the released
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog item
	 * @throws com.kencana.lms.NoSuchCatalogItemException if a catalog item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem[] filterFindByReleasedCompanyGroup_PrevAndNext(
		long catalogItemId, long companyId, long groupId, boolean released,
		OrderByComparator orderByComparator)
		throws NoSuchCatalogItemException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByReleasedCompanyGroup_PrevAndNext(catalogItemId,
				companyId, groupId, released, orderByComparator);
		}

		CatalogItem catalogItem = findByPrimaryKey(catalogItemId);

		Session session = null;

		try {
			session = openSession();

			CatalogItem[] array = new CatalogItemImpl[3];

			array[0] = filterGetByReleasedCompanyGroup_PrevAndNext(session,
					catalogItem, companyId, groupId, released,
					orderByComparator, true);

			array[1] = catalogItem;

			array[2] = filterGetByReleasedCompanyGroup_PrevAndNext(session,
					catalogItem, companyId, groupId, released,
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

	protected CatalogItem filterGetByReleasedCompanyGroup_PrevAndNext(
		Session session, CatalogItem catalogItem, long companyId, long groupId,
		boolean released, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CATALOGITEM_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CATALOGITEM_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_RELEASEDCOMPANYGROUP_COMPANYID_2);

		query.append(_FINDER_COLUMN_RELEASEDCOMPANYGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_RELEASEDCOMPANYGROUP_RELEASED_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CATALOGITEM_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CatalogItemModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CatalogItemModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CatalogItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CatalogItemImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CatalogItemImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(released);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(catalogItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CatalogItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the catalog items where companyId = &#63; and groupId = &#63; and released = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param released the released
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByReleasedCompanyGroup(long companyId, long groupId,
		boolean released) throws SystemException {
		for (CatalogItem catalogItem : findByReleasedCompanyGroup(companyId,
				groupId, released, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(catalogItem);
		}
	}

	/**
	 * Returns the number of catalog items where companyId = &#63; and groupId = &#63; and released = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param released the released
	 * @return the number of matching catalog items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByReleasedCompanyGroup(long companyId, long groupId,
		boolean released) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RELEASEDCOMPANYGROUP;

		Object[] finderArgs = new Object[] { companyId, groupId, released };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CATALOGITEM_WHERE);

			query.append(_FINDER_COLUMN_RELEASEDCOMPANYGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_RELEASEDCOMPANYGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_RELEASEDCOMPANYGROUP_RELEASED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(released);

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

	/**
	 * Returns the number of catalog items that the user has permission to view where companyId = &#63; and groupId = &#63; and released = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param released the released
	 * @return the number of matching catalog items that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByReleasedCompanyGroup(long companyId, long groupId,
		boolean released) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByReleasedCompanyGroup(companyId, groupId, released);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_CATALOGITEM_WHERE);

		query.append(_FINDER_COLUMN_RELEASEDCOMPANYGROUP_COMPANYID_2);

		query.append(_FINDER_COLUMN_RELEASEDCOMPANYGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_RELEASEDCOMPANYGROUP_RELEASED_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CatalogItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			qPos.add(released);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_RELEASEDCOMPANYGROUP_COMPANYID_2 = "catalogItem.companyId = ? AND ";
	private static final String _FINDER_COLUMN_RELEASEDCOMPANYGROUP_GROUPID_2 = "catalogItem.groupId = ? AND ";
	private static final String _FINDER_COLUMN_RELEASEDCOMPANYGROUP_RELEASED_2 = "catalogItem.released = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_WITHDRAWNCOMPANYGROUP =
		new FinderPath(CatalogItemModelImpl.ENTITY_CACHE_ENABLED,
			CatalogItemModelImpl.FINDER_CACHE_ENABLED, CatalogItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByWithdrawnCompanyGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WITHDRAWNCOMPANYGROUP =
		new FinderPath(CatalogItemModelImpl.ENTITY_CACHE_ENABLED,
			CatalogItemModelImpl.FINDER_CACHE_ENABLED, CatalogItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByWithdrawnCompanyGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			CatalogItemModelImpl.COMPANYID_COLUMN_BITMASK |
			CatalogItemModelImpl.GROUPID_COLUMN_BITMASK |
			CatalogItemModelImpl.WITHDRAWNSTATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_WITHDRAWNCOMPANYGROUP = new FinderPath(CatalogItemModelImpl.ENTITY_CACHE_ENABLED,
			CatalogItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByWithdrawnCompanyGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns all the catalog items where companyId = &#63; and groupId = &#63; and withdrawnStatus = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param withdrawnStatus the withdrawn status
	 * @return the matching catalog items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogItem> findByWithdrawnCompanyGroup(long companyId,
		long groupId, boolean withdrawnStatus) throws SystemException {
		return findByWithdrawnCompanyGroup(companyId, groupId, withdrawnStatus,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the catalog items where companyId = &#63; and groupId = &#63; and withdrawnStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param withdrawnStatus the withdrawn status
	 * @param start the lower bound of the range of catalog items
	 * @param end the upper bound of the range of catalog items (not inclusive)
	 * @return the range of matching catalog items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogItem> findByWithdrawnCompanyGroup(long companyId,
		long groupId, boolean withdrawnStatus, int start, int end)
		throws SystemException {
		return findByWithdrawnCompanyGroup(companyId, groupId, withdrawnStatus,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the catalog items where companyId = &#63; and groupId = &#63; and withdrawnStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param withdrawnStatus the withdrawn status
	 * @param start the lower bound of the range of catalog items
	 * @param end the upper bound of the range of catalog items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching catalog items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogItem> findByWithdrawnCompanyGroup(long companyId,
		long groupId, boolean withdrawnStatus, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WITHDRAWNCOMPANYGROUP;
			finderArgs = new Object[] { companyId, groupId, withdrawnStatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_WITHDRAWNCOMPANYGROUP;
			finderArgs = new Object[] {
					companyId, groupId, withdrawnStatus,
					
					start, end, orderByComparator
				};
		}

		List<CatalogItem> list = (List<CatalogItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CatalogItem catalogItem : list) {
				if ((companyId != catalogItem.getCompanyId()) ||
						(groupId != catalogItem.getGroupId()) ||
						(withdrawnStatus != catalogItem.getWithdrawnStatus())) {
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

			query.append(_SQL_SELECT_CATALOGITEM_WHERE);

			query.append(_FINDER_COLUMN_WITHDRAWNCOMPANYGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_WITHDRAWNCOMPANYGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_WITHDRAWNCOMPANYGROUP_WITHDRAWNSTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CatalogItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(withdrawnStatus);

				if (!pagination) {
					list = (List<CatalogItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CatalogItem>(list);
				}
				else {
					list = (List<CatalogItem>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first catalog item in the ordered set where companyId = &#63; and groupId = &#63; and withdrawnStatus = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param withdrawnStatus the withdrawn status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog item
	 * @throws com.kencana.lms.NoSuchCatalogItemException if a matching catalog item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem findByWithdrawnCompanyGroup_First(long companyId,
		long groupId, boolean withdrawnStatus,
		OrderByComparator orderByComparator)
		throws NoSuchCatalogItemException, SystemException {
		CatalogItem catalogItem = fetchByWithdrawnCompanyGroup_First(companyId,
				groupId, withdrawnStatus, orderByComparator);

		if (catalogItem != null) {
			return catalogItem;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", withdrawnStatus=");
		msg.append(withdrawnStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCatalogItemException(msg.toString());
	}

	/**
	 * Returns the first catalog item in the ordered set where companyId = &#63; and groupId = &#63; and withdrawnStatus = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param withdrawnStatus the withdrawn status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog item, or <code>null</code> if a matching catalog item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem fetchByWithdrawnCompanyGroup_First(long companyId,
		long groupId, boolean withdrawnStatus,
		OrderByComparator orderByComparator) throws SystemException {
		List<CatalogItem> list = findByWithdrawnCompanyGroup(companyId,
				groupId, withdrawnStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last catalog item in the ordered set where companyId = &#63; and groupId = &#63; and withdrawnStatus = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param withdrawnStatus the withdrawn status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog item
	 * @throws com.kencana.lms.NoSuchCatalogItemException if a matching catalog item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem findByWithdrawnCompanyGroup_Last(long companyId,
		long groupId, boolean withdrawnStatus,
		OrderByComparator orderByComparator)
		throws NoSuchCatalogItemException, SystemException {
		CatalogItem catalogItem = fetchByWithdrawnCompanyGroup_Last(companyId,
				groupId, withdrawnStatus, orderByComparator);

		if (catalogItem != null) {
			return catalogItem;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", withdrawnStatus=");
		msg.append(withdrawnStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCatalogItemException(msg.toString());
	}

	/**
	 * Returns the last catalog item in the ordered set where companyId = &#63; and groupId = &#63; and withdrawnStatus = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param withdrawnStatus the withdrawn status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog item, or <code>null</code> if a matching catalog item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem fetchByWithdrawnCompanyGroup_Last(long companyId,
		long groupId, boolean withdrawnStatus,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByWithdrawnCompanyGroup(companyId, groupId,
				withdrawnStatus);

		if (count == 0) {
			return null;
		}

		List<CatalogItem> list = findByWithdrawnCompanyGroup(companyId,
				groupId, withdrawnStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the catalog items before and after the current catalog item in the ordered set where companyId = &#63; and groupId = &#63; and withdrawnStatus = &#63;.
	 *
	 * @param catalogItemId the primary key of the current catalog item
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param withdrawnStatus the withdrawn status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog item
	 * @throws com.kencana.lms.NoSuchCatalogItemException if a catalog item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem[] findByWithdrawnCompanyGroup_PrevAndNext(
		long catalogItemId, long companyId, long groupId,
		boolean withdrawnStatus, OrderByComparator orderByComparator)
		throws NoSuchCatalogItemException, SystemException {
		CatalogItem catalogItem = findByPrimaryKey(catalogItemId);

		Session session = null;

		try {
			session = openSession();

			CatalogItem[] array = new CatalogItemImpl[3];

			array[0] = getByWithdrawnCompanyGroup_PrevAndNext(session,
					catalogItem, companyId, groupId, withdrawnStatus,
					orderByComparator, true);

			array[1] = catalogItem;

			array[2] = getByWithdrawnCompanyGroup_PrevAndNext(session,
					catalogItem, companyId, groupId, withdrawnStatus,
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

	protected CatalogItem getByWithdrawnCompanyGroup_PrevAndNext(
		Session session, CatalogItem catalogItem, long companyId, long groupId,
		boolean withdrawnStatus, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CATALOGITEM_WHERE);

		query.append(_FINDER_COLUMN_WITHDRAWNCOMPANYGROUP_COMPANYID_2);

		query.append(_FINDER_COLUMN_WITHDRAWNCOMPANYGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_WITHDRAWNCOMPANYGROUP_WITHDRAWNSTATUS_2);

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
			query.append(CatalogItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(withdrawnStatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(catalogItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CatalogItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the catalog items that the user has permission to view where companyId = &#63; and groupId = &#63; and withdrawnStatus = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param withdrawnStatus the withdrawn status
	 * @return the matching catalog items that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogItem> filterFindByWithdrawnCompanyGroup(long companyId,
		long groupId, boolean withdrawnStatus) throws SystemException {
		return filterFindByWithdrawnCompanyGroup(companyId, groupId,
			withdrawnStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the catalog items that the user has permission to view where companyId = &#63; and groupId = &#63; and withdrawnStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param withdrawnStatus the withdrawn status
	 * @param start the lower bound of the range of catalog items
	 * @param end the upper bound of the range of catalog items (not inclusive)
	 * @return the range of matching catalog items that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogItem> filterFindByWithdrawnCompanyGroup(long companyId,
		long groupId, boolean withdrawnStatus, int start, int end)
		throws SystemException {
		return filterFindByWithdrawnCompanyGroup(companyId, groupId,
			withdrawnStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the catalog items that the user has permissions to view where companyId = &#63; and groupId = &#63; and withdrawnStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param withdrawnStatus the withdrawn status
	 * @param start the lower bound of the range of catalog items
	 * @param end the upper bound of the range of catalog items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching catalog items that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogItem> filterFindByWithdrawnCompanyGroup(long companyId,
		long groupId, boolean withdrawnStatus, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByWithdrawnCompanyGroup(companyId, groupId,
				withdrawnStatus, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CATALOGITEM_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CATALOGITEM_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_WITHDRAWNCOMPANYGROUP_COMPANYID_2);

		query.append(_FINDER_COLUMN_WITHDRAWNCOMPANYGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_WITHDRAWNCOMPANYGROUP_WITHDRAWNSTATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CATALOGITEM_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CatalogItemModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CatalogItemModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CatalogItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CatalogItemImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CatalogItemImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			qPos.add(withdrawnStatus);

			return (List<CatalogItem>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the catalog items before and after the current catalog item in the ordered set of catalog items that the user has permission to view where companyId = &#63; and groupId = &#63; and withdrawnStatus = &#63;.
	 *
	 * @param catalogItemId the primary key of the current catalog item
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param withdrawnStatus the withdrawn status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog item
	 * @throws com.kencana.lms.NoSuchCatalogItemException if a catalog item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem[] filterFindByWithdrawnCompanyGroup_PrevAndNext(
		long catalogItemId, long companyId, long groupId,
		boolean withdrawnStatus, OrderByComparator orderByComparator)
		throws NoSuchCatalogItemException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByWithdrawnCompanyGroup_PrevAndNext(catalogItemId,
				companyId, groupId, withdrawnStatus, orderByComparator);
		}

		CatalogItem catalogItem = findByPrimaryKey(catalogItemId);

		Session session = null;

		try {
			session = openSession();

			CatalogItem[] array = new CatalogItemImpl[3];

			array[0] = filterGetByWithdrawnCompanyGroup_PrevAndNext(session,
					catalogItem, companyId, groupId, withdrawnStatus,
					orderByComparator, true);

			array[1] = catalogItem;

			array[2] = filterGetByWithdrawnCompanyGroup_PrevAndNext(session,
					catalogItem, companyId, groupId, withdrawnStatus,
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

	protected CatalogItem filterGetByWithdrawnCompanyGroup_PrevAndNext(
		Session session, CatalogItem catalogItem, long companyId, long groupId,
		boolean withdrawnStatus, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CATALOGITEM_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CATALOGITEM_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_WITHDRAWNCOMPANYGROUP_COMPANYID_2);

		query.append(_FINDER_COLUMN_WITHDRAWNCOMPANYGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_WITHDRAWNCOMPANYGROUP_WITHDRAWNSTATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CATALOGITEM_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CatalogItemModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CatalogItemModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CatalogItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CatalogItemImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CatalogItemImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(withdrawnStatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(catalogItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CatalogItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the catalog items where companyId = &#63; and groupId = &#63; and withdrawnStatus = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param withdrawnStatus the withdrawn status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByWithdrawnCompanyGroup(long companyId, long groupId,
		boolean withdrawnStatus) throws SystemException {
		for (CatalogItem catalogItem : findByWithdrawnCompanyGroup(companyId,
				groupId, withdrawnStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(catalogItem);
		}
	}

	/**
	 * Returns the number of catalog items where companyId = &#63; and groupId = &#63; and withdrawnStatus = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param withdrawnStatus the withdrawn status
	 * @return the number of matching catalog items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByWithdrawnCompanyGroup(long companyId, long groupId,
		boolean withdrawnStatus) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_WITHDRAWNCOMPANYGROUP;

		Object[] finderArgs = new Object[] { companyId, groupId, withdrawnStatus };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CATALOGITEM_WHERE);

			query.append(_FINDER_COLUMN_WITHDRAWNCOMPANYGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_WITHDRAWNCOMPANYGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_WITHDRAWNCOMPANYGROUP_WITHDRAWNSTATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(withdrawnStatus);

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

	/**
	 * Returns the number of catalog items that the user has permission to view where companyId = &#63; and groupId = &#63; and withdrawnStatus = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param withdrawnStatus the withdrawn status
	 * @return the number of matching catalog items that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByWithdrawnCompanyGroup(long companyId, long groupId,
		boolean withdrawnStatus) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByWithdrawnCompanyGroup(companyId, groupId,
				withdrawnStatus);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_CATALOGITEM_WHERE);

		query.append(_FINDER_COLUMN_WITHDRAWNCOMPANYGROUP_COMPANYID_2);

		query.append(_FINDER_COLUMN_WITHDRAWNCOMPANYGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_WITHDRAWNCOMPANYGROUP_WITHDRAWNSTATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CatalogItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			qPos.add(withdrawnStatus);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_WITHDRAWNCOMPANYGROUP_COMPANYID_2 =
		"catalogItem.companyId = ? AND ";
	private static final String _FINDER_COLUMN_WITHDRAWNCOMPANYGROUP_GROUPID_2 = "catalogItem.groupId = ? AND ";
	private static final String _FINDER_COLUMN_WITHDRAWNCOMPANYGROUP_WITHDRAWNSTATUS_2 =
		"catalogItem.withdrawnStatus = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(CatalogItemModelImpl.ENTITY_CACHE_ENABLED,
			CatalogItemModelImpl.FINDER_CACHE_ENABLED, CatalogItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(CatalogItemModelImpl.ENTITY_CACHE_ENABLED,
			CatalogItemModelImpl.FINDER_CACHE_ENABLED, CatalogItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			CatalogItemModelImpl.COMPANYID_COLUMN_BITMASK |
			CatalogItemModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYGROUP = new FinderPath(CatalogItemModelImpl.ENTITY_CACHE_ENABLED,
			CatalogItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the catalog items where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching catalog items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogItem> findByCompanyGroup(long companyId, long groupId)
		throws SystemException {
		return findByCompanyGroup(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the catalog items where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of catalog items
	 * @param end the upper bound of the range of catalog items (not inclusive)
	 * @return the range of matching catalog items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogItem> findByCompanyGroup(long companyId, long groupId,
		int start, int end) throws SystemException {
		return findByCompanyGroup(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the catalog items where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of catalog items
	 * @param end the upper bound of the range of catalog items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching catalog items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogItem> findByCompanyGroup(long companyId, long groupId,
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

		List<CatalogItem> list = (List<CatalogItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CatalogItem catalogItem : list) {
				if ((companyId != catalogItem.getCompanyId()) ||
						(groupId != catalogItem.getGroupId())) {
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

			query.append(_SQL_SELECT_CATALOGITEM_WHERE);

			query.append(_FINDER_COLUMN_COMPANYGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CatalogItemModelImpl.ORDER_BY_JPQL);
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
					list = (List<CatalogItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CatalogItem>(list);
				}
				else {
					list = (List<CatalogItem>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first catalog item in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog item
	 * @throws com.kencana.lms.NoSuchCatalogItemException if a matching catalog item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem findByCompanyGroup_First(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCatalogItemException, SystemException {
		CatalogItem catalogItem = fetchByCompanyGroup_First(companyId, groupId,
				orderByComparator);

		if (catalogItem != null) {
			return catalogItem;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCatalogItemException(msg.toString());
	}

	/**
	 * Returns the first catalog item in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog item, or <code>null</code> if a matching catalog item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem fetchByCompanyGroup_First(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CatalogItem> list = findByCompanyGroup(companyId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last catalog item in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog item
	 * @throws com.kencana.lms.NoSuchCatalogItemException if a matching catalog item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem findByCompanyGroup_Last(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCatalogItemException, SystemException {
		CatalogItem catalogItem = fetchByCompanyGroup_Last(companyId, groupId,
				orderByComparator);

		if (catalogItem != null) {
			return catalogItem;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCatalogItemException(msg.toString());
	}

	/**
	 * Returns the last catalog item in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog item, or <code>null</code> if a matching catalog item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem fetchByCompanyGroup_Last(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyGroup(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<CatalogItem> list = findByCompanyGroup(companyId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the catalog items before and after the current catalog item in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param catalogItemId the primary key of the current catalog item
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog item
	 * @throws com.kencana.lms.NoSuchCatalogItemException if a catalog item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem[] findByCompanyGroup_PrevAndNext(long catalogItemId,
		long companyId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchCatalogItemException, SystemException {
		CatalogItem catalogItem = findByPrimaryKey(catalogItemId);

		Session session = null;

		try {
			session = openSession();

			CatalogItem[] array = new CatalogItemImpl[3];

			array[0] = getByCompanyGroup_PrevAndNext(session, catalogItem,
					companyId, groupId, orderByComparator, true);

			array[1] = catalogItem;

			array[2] = getByCompanyGroup_PrevAndNext(session, catalogItem,
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

	protected CatalogItem getByCompanyGroup_PrevAndNext(Session session,
		CatalogItem catalogItem, long companyId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CATALOGITEM_WHERE);

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
			query.append(CatalogItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(catalogItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CatalogItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the catalog items that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching catalog items that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogItem> filterFindByCompanyGroup(long companyId,
		long groupId) throws SystemException {
		return filterFindByCompanyGroup(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the catalog items that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of catalog items
	 * @param end the upper bound of the range of catalog items (not inclusive)
	 * @return the range of matching catalog items that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogItem> filterFindByCompanyGroup(long companyId,
		long groupId, int start, int end) throws SystemException {
		return filterFindByCompanyGroup(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the catalog items that the user has permissions to view where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of catalog items
	 * @param end the upper bound of the range of catalog items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching catalog items that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogItem> filterFindByCompanyGroup(long companyId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByCompanyGroup(companyId, groupId, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CATALOGITEM_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CATALOGITEM_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_COMPANYGROUP_COMPANYID_2);

		query.append(_FINDER_COLUMN_COMPANYGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CATALOGITEM_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CatalogItemModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CatalogItemModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CatalogItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CatalogItemImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CatalogItemImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			return (List<CatalogItem>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the catalog items before and after the current catalog item in the ordered set of catalog items that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * @param catalogItemId the primary key of the current catalog item
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog item
	 * @throws com.kencana.lms.NoSuchCatalogItemException if a catalog item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem[] filterFindByCompanyGroup_PrevAndNext(
		long catalogItemId, long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCatalogItemException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByCompanyGroup_PrevAndNext(catalogItemId, companyId,
				groupId, orderByComparator);
		}

		CatalogItem catalogItem = findByPrimaryKey(catalogItemId);

		Session session = null;

		try {
			session = openSession();

			CatalogItem[] array = new CatalogItemImpl[3];

			array[0] = filterGetByCompanyGroup_PrevAndNext(session,
					catalogItem, companyId, groupId, orderByComparator, true);

			array[1] = catalogItem;

			array[2] = filterGetByCompanyGroup_PrevAndNext(session,
					catalogItem, companyId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CatalogItem filterGetByCompanyGroup_PrevAndNext(Session session,
		CatalogItem catalogItem, long companyId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CATALOGITEM_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CATALOGITEM_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_COMPANYGROUP_COMPANYID_2);

		query.append(_FINDER_COLUMN_COMPANYGROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CATALOGITEM_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CatalogItemModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CatalogItemModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CatalogItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CatalogItemImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CatalogItemImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(catalogItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CatalogItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the catalog items where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyGroup(long companyId, long groupId)
		throws SystemException {
		for (CatalogItem catalogItem : findByCompanyGroup(companyId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(catalogItem);
		}
	}

	/**
	 * Returns the number of catalog items where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching catalog items
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

			query.append(_SQL_COUNT_CATALOGITEM_WHERE);

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

	/**
	 * Returns the number of catalog items that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching catalog items that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByCompanyGroup(long companyId, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByCompanyGroup(companyId, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_CATALOGITEM_WHERE);

		query.append(_FINDER_COLUMN_COMPANYGROUP_COMPANYID_2);

		query.append(_FINDER_COLUMN_COMPANYGROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CatalogItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_COMPANYGROUP_COMPANYID_2 = "catalogItem.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYGROUP_GROUPID_2 = "catalogItem.groupId = ?";

	public CatalogItemPersistenceImpl() {
		setModelClass(CatalogItem.class);
	}

	/**
	 * Caches the catalog item in the entity cache if it is enabled.
	 *
	 * @param catalogItem the catalog item
	 */
	@Override
	public void cacheResult(CatalogItem catalogItem) {
		EntityCacheUtil.putResult(CatalogItemModelImpl.ENTITY_CACHE_ENABLED,
			CatalogItemImpl.class, catalogItem.getPrimaryKey(), catalogItem);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BARCODE,
			new Object[] { catalogItem.getCompanyId(), catalogItem.getBarcode() },
			catalogItem);

		catalogItem.resetOriginalValues();
	}

	/**
	 * Caches the catalog items in the entity cache if it is enabled.
	 *
	 * @param catalogItems the catalog items
	 */
	@Override
	public void cacheResult(List<CatalogItem> catalogItems) {
		for (CatalogItem catalogItem : catalogItems) {
			if (EntityCacheUtil.getResult(
						CatalogItemModelImpl.ENTITY_CACHE_ENABLED,
						CatalogItemImpl.class, catalogItem.getPrimaryKey()) == null) {
				cacheResult(catalogItem);
			}
			else {
				catalogItem.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all catalog items.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CatalogItemImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CatalogItemImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the catalog item.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CatalogItem catalogItem) {
		EntityCacheUtil.removeResult(CatalogItemModelImpl.ENTITY_CACHE_ENABLED,
			CatalogItemImpl.class, catalogItem.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(catalogItem);
	}

	@Override
	public void clearCache(List<CatalogItem> catalogItems) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CatalogItem catalogItem : catalogItems) {
			EntityCacheUtil.removeResult(CatalogItemModelImpl.ENTITY_CACHE_ENABLED,
				CatalogItemImpl.class, catalogItem.getPrimaryKey());

			clearUniqueFindersCache(catalogItem);
		}
	}

	protected void cacheUniqueFindersCache(CatalogItem catalogItem) {
		if (catalogItem.isNew()) {
			Object[] args = new Object[] {
					catalogItem.getCompanyId(), catalogItem.getBarcode()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BARCODE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BARCODE, args,
				catalogItem);
		}
		else {
			CatalogItemModelImpl catalogItemModelImpl = (CatalogItemModelImpl)catalogItem;

			if ((catalogItemModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_BARCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						catalogItem.getCompanyId(), catalogItem.getBarcode()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BARCODE, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BARCODE, args,
					catalogItem);
			}
		}
	}

	protected void clearUniqueFindersCache(CatalogItem catalogItem) {
		CatalogItemModelImpl catalogItemModelImpl = (CatalogItemModelImpl)catalogItem;

		Object[] args = new Object[] {
				catalogItem.getCompanyId(), catalogItem.getBarcode()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BARCODE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BARCODE, args);

		if ((catalogItemModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_BARCODE.getColumnBitmask()) != 0) {
			args = new Object[] {
					catalogItemModelImpl.getOriginalCompanyId(),
					catalogItemModelImpl.getOriginalBarcode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BARCODE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BARCODE, args);
		}
	}

	/**
	 * Creates a new catalog item with the primary key. Does not add the catalog item to the database.
	 *
	 * @param catalogItemId the primary key for the new catalog item
	 * @return the new catalog item
	 */
	@Override
	public CatalogItem create(long catalogItemId) {
		CatalogItem catalogItem = new CatalogItemImpl();

		catalogItem.setNew(true);
		catalogItem.setPrimaryKey(catalogItemId);

		return catalogItem;
	}

	/**
	 * Removes the catalog item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param catalogItemId the primary key of the catalog item
	 * @return the catalog item that was removed
	 * @throws com.kencana.lms.NoSuchCatalogItemException if a catalog item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem remove(long catalogItemId)
		throws NoSuchCatalogItemException, SystemException {
		return remove((Serializable)catalogItemId);
	}

	/**
	 * Removes the catalog item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the catalog item
	 * @return the catalog item that was removed
	 * @throws com.kencana.lms.NoSuchCatalogItemException if a catalog item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem remove(Serializable primaryKey)
		throws NoSuchCatalogItemException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CatalogItem catalogItem = (CatalogItem)session.get(CatalogItemImpl.class,
					primaryKey);

			if (catalogItem == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCatalogItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(catalogItem);
		}
		catch (NoSuchCatalogItemException nsee) {
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
	protected CatalogItem removeImpl(CatalogItem catalogItem)
		throws SystemException {
		catalogItem = toUnwrappedModel(catalogItem);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(catalogItem)) {
				catalogItem = (CatalogItem)session.get(CatalogItemImpl.class,
						catalogItem.getPrimaryKeyObj());
			}

			if (catalogItem != null) {
				session.delete(catalogItem);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (catalogItem != null) {
			clearCache(catalogItem);
		}

		return catalogItem;
	}

	@Override
	public CatalogItem updateImpl(com.kencana.lms.model.CatalogItem catalogItem)
		throws SystemException {
		catalogItem = toUnwrappedModel(catalogItem);

		boolean isNew = catalogItem.isNew();

		CatalogItemModelImpl catalogItemModelImpl = (CatalogItemModelImpl)catalogItem;

		Session session = null;

		try {
			session = openSession();

			if (catalogItem.isNew()) {
				session.save(catalogItem);

				catalogItem.setNew(false);
			}
			else {
				session.merge(catalogItem);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CatalogItemModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((catalogItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATALOG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						catalogItemModelImpl.getOriginalCatalogId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATALOG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATALOG,
					args);

				args = new Object[] { catalogItemModelImpl.getCatalogId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATALOG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATALOG,
					args);
			}

			if ((catalogItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOLDINGLIBRARY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						catalogItemModelImpl.getOriginalHoldingLibraryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HOLDINGLIBRARY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOLDINGLIBRARY,
					args);

				args = new Object[] { catalogItemModelImpl.getHoldingLibraryId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HOLDINGLIBRARY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOLDINGLIBRARY,
					args);
			}

			if ((catalogItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RELEASEDCOMPANYGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						catalogItemModelImpl.getOriginalCompanyId(),
						catalogItemModelImpl.getOriginalGroupId(),
						catalogItemModelImpl.getOriginalReleased()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RELEASEDCOMPANYGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RELEASEDCOMPANYGROUP,
					args);

				args = new Object[] {
						catalogItemModelImpl.getCompanyId(),
						catalogItemModelImpl.getGroupId(),
						catalogItemModelImpl.getReleased()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RELEASEDCOMPANYGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RELEASEDCOMPANYGROUP,
					args);
			}

			if ((catalogItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WITHDRAWNCOMPANYGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						catalogItemModelImpl.getOriginalCompanyId(),
						catalogItemModelImpl.getOriginalGroupId(),
						catalogItemModelImpl.getOriginalWithdrawnStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WITHDRAWNCOMPANYGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WITHDRAWNCOMPANYGROUP,
					args);

				args = new Object[] {
						catalogItemModelImpl.getCompanyId(),
						catalogItemModelImpl.getGroupId(),
						catalogItemModelImpl.getWithdrawnStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WITHDRAWNCOMPANYGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WITHDRAWNCOMPANYGROUP,
					args);
			}

			if ((catalogItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						catalogItemModelImpl.getOriginalCompanyId(),
						catalogItemModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);

				args = new Object[] {
						catalogItemModelImpl.getCompanyId(),
						catalogItemModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(CatalogItemModelImpl.ENTITY_CACHE_ENABLED,
			CatalogItemImpl.class, catalogItem.getPrimaryKey(), catalogItem);

		clearUniqueFindersCache(catalogItem);
		cacheUniqueFindersCache(catalogItem);

		return catalogItem;
	}

	protected CatalogItem toUnwrappedModel(CatalogItem catalogItem) {
		if (catalogItem instanceof CatalogItemImpl) {
			return catalogItem;
		}

		CatalogItemImpl catalogItemImpl = new CatalogItemImpl();

		catalogItemImpl.setNew(catalogItem.isNew());
		catalogItemImpl.setPrimaryKey(catalogItem.getPrimaryKey());

		catalogItemImpl.setCatalogItemId(catalogItem.getCatalogItemId());
		catalogItemImpl.setCatalogId(catalogItem.getCatalogId());
		catalogItemImpl.setCatalogTitle(catalogItem.getCatalogTitle());
		catalogItemImpl.setCallNumber(catalogItem.getCallNumber());
		catalogItemImpl.setHoldingLibraryId(catalogItem.getHoldingLibraryId());
		catalogItemImpl.setCurrentLibraryId(catalogItem.getCurrentLibraryId());
		catalogItemImpl.setBarcode(catalogItem.getBarcode());
		catalogItemImpl.setCopyNumber(catalogItem.getCopyNumber());
		catalogItemImpl.setLocationId(catalogItem.getLocationId());
		catalogItemImpl.setItemCategoryId(catalogItem.getItemCategoryId());
		catalogItemImpl.setItemTypeId(catalogItem.getItemTypeId());
		catalogItemImpl.setWithdrawnStatus(catalogItem.isWithdrawnStatus());
		catalogItemImpl.setLostStatus(catalogItem.isLostStatus());
		catalogItemImpl.setDamageStatus(catalogItem.isDamageStatus());
		catalogItemImpl.setNotForLoanStatus(catalogItem.isNotForLoanStatus());
		catalogItemImpl.setLastSeenDate(catalogItem.getLastSeenDate());
		catalogItemImpl.setWithdrawnDate(catalogItem.getWithdrawnDate());
		catalogItemImpl.setLostDate(catalogItem.getLostDate());
		catalogItemImpl.setLastCheckOutDate(catalogItem.getLastCheckOutDate());
		catalogItemImpl.setCirculationCount(catalogItem.getCirculationCount());
		catalogItemImpl.setRenewalCount(catalogItem.getRenewalCount());
		catalogItemImpl.setReservedCount(catalogItem.getReservedCount());
		catalogItemImpl.setCheckedOutDate(catalogItem.getCheckedOutDate());
		catalogItemImpl.setReservedBy(catalogItem.getReservedBy());
		catalogItemImpl.setClaimCount(catalogItem.getClaimCount());
		catalogItemImpl.setDueDate(catalogItem.getDueDate());
		catalogItemImpl.setCheckOutBy(catalogItem.getCheckOutBy());
		catalogItemImpl.setReleased(catalogItem.isReleased());
		catalogItemImpl.setReleaseDate(catalogItem.getReleaseDate());
		catalogItemImpl.setReleaseByUserId(catalogItem.getReleaseByUserId());
		catalogItemImpl.setVendorId(catalogItem.getVendorId());
		catalogItemImpl.setInvoiceId(catalogItem.getInvoiceId());
		catalogItemImpl.setPurchasePrice(catalogItem.getPurchasePrice());
		catalogItemImpl.setReplacementPrice(catalogItem.getReplacementPrice());
		catalogItemImpl.setCurrencyId(catalogItem.getCurrencyId());
		catalogItemImpl.setLocalPurchasePrice(catalogItem.getLocalPurchasePrice());
		catalogItemImpl.setPublicNote(catalogItem.getPublicNote());
		catalogItemImpl.setPrivateNote(catalogItem.getPrivateNote());
		catalogItemImpl.setCompanyId(catalogItem.getCompanyId());
		catalogItemImpl.setGroupId(catalogItem.getGroupId());
		catalogItemImpl.setUserId(catalogItem.getUserId());
		catalogItemImpl.setUserName(catalogItem.getUserName());
		catalogItemImpl.setCreateDate(catalogItem.getCreateDate());
		catalogItemImpl.setModifiedDate(catalogItem.getModifiedDate());
		catalogItemImpl.setAcquiredDate(catalogItem.getAcquiredDate());
		catalogItemImpl.setWorkflowStatus(catalogItem.getWorkflowStatus());

		return catalogItemImpl;
	}

	/**
	 * Returns the catalog item with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the catalog item
	 * @return the catalog item
	 * @throws com.kencana.lms.NoSuchCatalogItemException if a catalog item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCatalogItemException, SystemException {
		CatalogItem catalogItem = fetchByPrimaryKey(primaryKey);

		if (catalogItem == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCatalogItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return catalogItem;
	}

	/**
	 * Returns the catalog item with the primary key or throws a {@link com.kencana.lms.NoSuchCatalogItemException} if it could not be found.
	 *
	 * @param catalogItemId the primary key of the catalog item
	 * @return the catalog item
	 * @throws com.kencana.lms.NoSuchCatalogItemException if a catalog item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem findByPrimaryKey(long catalogItemId)
		throws NoSuchCatalogItemException, SystemException {
		return findByPrimaryKey((Serializable)catalogItemId);
	}

	/**
	 * Returns the catalog item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the catalog item
	 * @return the catalog item, or <code>null</code> if a catalog item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CatalogItem catalogItem = (CatalogItem)EntityCacheUtil.getResult(CatalogItemModelImpl.ENTITY_CACHE_ENABLED,
				CatalogItemImpl.class, primaryKey);

		if (catalogItem == _nullCatalogItem) {
			return null;
		}

		if (catalogItem == null) {
			Session session = null;

			try {
				session = openSession();

				catalogItem = (CatalogItem)session.get(CatalogItemImpl.class,
						primaryKey);

				if (catalogItem != null) {
					cacheResult(catalogItem);
				}
				else {
					EntityCacheUtil.putResult(CatalogItemModelImpl.ENTITY_CACHE_ENABLED,
						CatalogItemImpl.class, primaryKey, _nullCatalogItem);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CatalogItemModelImpl.ENTITY_CACHE_ENABLED,
					CatalogItemImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return catalogItem;
	}

	/**
	 * Returns the catalog item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param catalogItemId the primary key of the catalog item
	 * @return the catalog item, or <code>null</code> if a catalog item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogItem fetchByPrimaryKey(long catalogItemId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)catalogItemId);
	}

	/**
	 * Returns all the catalog items.
	 *
	 * @return the catalog items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogItem> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the catalog items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of catalog items
	 * @param end the upper bound of the range of catalog items (not inclusive)
	 * @return the range of catalog items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogItem> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the catalog items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of catalog items
	 * @param end the upper bound of the range of catalog items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of catalog items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogItem> findAll(int start, int end,
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

		List<CatalogItem> list = (List<CatalogItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CATALOGITEM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CATALOGITEM;

				if (pagination) {
					sql = sql.concat(CatalogItemModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CatalogItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CatalogItem>(list);
				}
				else {
					list = (List<CatalogItem>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the catalog items from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CatalogItem catalogItem : findAll()) {
			remove(catalogItem);
		}
	}

	/**
	 * Returns the number of catalog items.
	 *
	 * @return the number of catalog items
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

				Query q = session.createQuery(_SQL_COUNT_CATALOGITEM);

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
	 * Initializes the catalog item persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.kencana.lms.model.CatalogItem")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CatalogItem>> listenersList = new ArrayList<ModelListener<CatalogItem>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CatalogItem>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CatalogItemImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CATALOGITEM = "SELECT catalogItem FROM CatalogItem catalogItem";
	private static final String _SQL_SELECT_CATALOGITEM_WHERE = "SELECT catalogItem FROM CatalogItem catalogItem WHERE ";
	private static final String _SQL_COUNT_CATALOGITEM = "SELECT COUNT(catalogItem) FROM CatalogItem catalogItem";
	private static final String _SQL_COUNT_CATALOGITEM_WHERE = "SELECT COUNT(catalogItem) FROM CatalogItem catalogItem WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "catalogItem.catalogItemId";
	private static final String _FILTER_SQL_SELECT_CATALOGITEM_WHERE = "SELECT DISTINCT {catalogItem.*} FROM Kencana_CatalogItem catalogItem WHERE ";
	private static final String _FILTER_SQL_SELECT_CATALOGITEM_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {Kencana_CatalogItem.*} FROM (SELECT DISTINCT catalogItem.catalogItemId FROM Kencana_CatalogItem catalogItem WHERE ";
	private static final String _FILTER_SQL_SELECT_CATALOGITEM_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN Kencana_CatalogItem ON TEMP_TABLE.catalogItemId = Kencana_CatalogItem.catalogItemId";
	private static final String _FILTER_SQL_COUNT_CATALOGITEM_WHERE = "SELECT COUNT(DISTINCT catalogItem.catalogItemId) AS COUNT_VALUE FROM Kencana_CatalogItem catalogItem WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "catalogItem";
	private static final String _FILTER_ENTITY_TABLE = "Kencana_CatalogItem";
	private static final String _ORDER_BY_ENTITY_ALIAS = "catalogItem.";
	private static final String _ORDER_BY_ENTITY_TABLE = "Kencana_CatalogItem.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CatalogItem exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CatalogItem exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CatalogItemPersistenceImpl.class);
	private static CatalogItem _nullCatalogItem = new CatalogItemImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CatalogItem> toCacheModel() {
				return _nullCatalogItemCacheModel;
			}
		};

	private static CacheModel<CatalogItem> _nullCatalogItemCacheModel = new CacheModel<CatalogItem>() {
			@Override
			public CatalogItem toEntityModel() {
				return _nullCatalogItem;
			}
		};
}