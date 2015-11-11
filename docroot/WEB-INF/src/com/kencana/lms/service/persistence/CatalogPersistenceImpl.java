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

import com.kencana.lms.NoSuchCatalogException;
import com.kencana.lms.model.Catalog;
import com.kencana.lms.model.impl.CatalogImpl;
import com.kencana.lms.model.impl.CatalogModelImpl;

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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the catalog service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see CatalogPersistence
 * @see CatalogUtil
 * @generated
 */
public class CatalogPersistenceImpl extends BasePersistenceImpl<Catalog>
	implements CatalogPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CatalogUtil} to access the catalog persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CatalogImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CatalogModelImpl.ENTITY_CACHE_ENABLED,
			CatalogModelImpl.FINDER_CACHE_ENABLED, CatalogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CatalogModelImpl.ENTITY_CACHE_ENABLED,
			CatalogModelImpl.FINDER_CACHE_ENABLED, CatalogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CatalogModelImpl.ENTITY_CACHE_ENABLED,
			CatalogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TEMPLATEID =
		new FinderPath(CatalogModelImpl.ENTITY_CACHE_ENABLED,
			CatalogModelImpl.FINDER_CACHE_ENABLED, CatalogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTemplateId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID =
		new FinderPath(CatalogModelImpl.ENTITY_CACHE_ENABLED,
			CatalogModelImpl.FINDER_CACHE_ENABLED, CatalogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTemplateId",
			new String[] { Long.class.getName() },
			CatalogModelImpl.TEMPLATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TEMPLATEID = new FinderPath(CatalogModelImpl.ENTITY_CACHE_ENABLED,
			CatalogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTemplateId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the catalogs where templateId = &#63;.
	 *
	 * @param templateId the template ID
	 * @return the matching catalogs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Catalog> findByTemplateId(long templateId)
		throws SystemException {
		return findByTemplateId(templateId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the catalogs where templateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param templateId the template ID
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @return the range of matching catalogs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Catalog> findByTemplateId(long templateId, int start, int end)
		throws SystemException {
		return findByTemplateId(templateId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the catalogs where templateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param templateId the template ID
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching catalogs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Catalog> findByTemplateId(long templateId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID;
			finderArgs = new Object[] { templateId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TEMPLATEID;
			finderArgs = new Object[] { templateId, start, end, orderByComparator };
		}

		List<Catalog> list = (List<Catalog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Catalog catalog : list) {
				if ((templateId != catalog.getTemplateId())) {
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

			query.append(_SQL_SELECT_CATALOG_WHERE);

			query.append(_FINDER_COLUMN_TEMPLATEID_TEMPLATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CatalogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(templateId);

				if (!pagination) {
					list = (List<Catalog>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Catalog>(list);
				}
				else {
					list = (List<Catalog>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first catalog in the ordered set where templateId = &#63;.
	 *
	 * @param templateId the template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog
	 * @throws com.kencana.lms.NoSuchCatalogException if a matching catalog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog findByTemplateId_First(long templateId,
		OrderByComparator orderByComparator)
		throws NoSuchCatalogException, SystemException {
		Catalog catalog = fetchByTemplateId_First(templateId, orderByComparator);

		if (catalog != null) {
			return catalog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("templateId=");
		msg.append(templateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCatalogException(msg.toString());
	}

	/**
	 * Returns the first catalog in the ordered set where templateId = &#63;.
	 *
	 * @param templateId the template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog, or <code>null</code> if a matching catalog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog fetchByTemplateId_First(long templateId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Catalog> list = findByTemplateId(templateId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last catalog in the ordered set where templateId = &#63;.
	 *
	 * @param templateId the template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog
	 * @throws com.kencana.lms.NoSuchCatalogException if a matching catalog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog findByTemplateId_Last(long templateId,
		OrderByComparator orderByComparator)
		throws NoSuchCatalogException, SystemException {
		Catalog catalog = fetchByTemplateId_Last(templateId, orderByComparator);

		if (catalog != null) {
			return catalog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("templateId=");
		msg.append(templateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCatalogException(msg.toString());
	}

	/**
	 * Returns the last catalog in the ordered set where templateId = &#63;.
	 *
	 * @param templateId the template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog, or <code>null</code> if a matching catalog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog fetchByTemplateId_Last(long templateId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTemplateId(templateId);

		if (count == 0) {
			return null;
		}

		List<Catalog> list = findByTemplateId(templateId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the catalogs before and after the current catalog in the ordered set where templateId = &#63;.
	 *
	 * @param catalogId the primary key of the current catalog
	 * @param templateId the template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog
	 * @throws com.kencana.lms.NoSuchCatalogException if a catalog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog[] findByTemplateId_PrevAndNext(long catalogId,
		long templateId, OrderByComparator orderByComparator)
		throws NoSuchCatalogException, SystemException {
		Catalog catalog = findByPrimaryKey(catalogId);

		Session session = null;

		try {
			session = openSession();

			Catalog[] array = new CatalogImpl[3];

			array[0] = getByTemplateId_PrevAndNext(session, catalog,
					templateId, orderByComparator, true);

			array[1] = catalog;

			array[2] = getByTemplateId_PrevAndNext(session, catalog,
					templateId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Catalog getByTemplateId_PrevAndNext(Session session,
		Catalog catalog, long templateId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CATALOG_WHERE);

		query.append(_FINDER_COLUMN_TEMPLATEID_TEMPLATEID_2);

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
			query.append(CatalogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(templateId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(catalog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Catalog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the catalogs where templateId = &#63; from the database.
	 *
	 * @param templateId the template ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTemplateId(long templateId) throws SystemException {
		for (Catalog catalog : findByTemplateId(templateId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(catalog);
		}
	}

	/**
	 * Returns the number of catalogs where templateId = &#63;.
	 *
	 * @param templateId the template ID
	 * @return the number of matching catalogs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTemplateId(long templateId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TEMPLATEID;

		Object[] finderArgs = new Object[] { templateId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CATALOG_WHERE);

			query.append(_FINDER_COLUMN_TEMPLATEID_TEMPLATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(templateId);

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

	private static final String _FINDER_COLUMN_TEMPLATEID_TEMPLATEID_2 = "catalog.templateId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ITEMTYPE = new FinderPath(CatalogModelImpl.ENTITY_CACHE_ENABLED,
			CatalogModelImpl.FINDER_CACHE_ENABLED, CatalogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByItemType",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMTYPE =
		new FinderPath(CatalogModelImpl.ENTITY_CACHE_ENABLED,
			CatalogModelImpl.FINDER_CACHE_ENABLED, CatalogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByItemType",
			new String[] { Long.class.getName() },
			CatalogModelImpl.ITEMTYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ITEMTYPE = new FinderPath(CatalogModelImpl.ENTITY_CACHE_ENABLED,
			CatalogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByItemType",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the catalogs where itemTypeId = &#63;.
	 *
	 * @param itemTypeId the item type ID
	 * @return the matching catalogs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Catalog> findByItemType(long itemTypeId)
		throws SystemException {
		return findByItemType(itemTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the catalogs where itemTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param itemTypeId the item type ID
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @return the range of matching catalogs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Catalog> findByItemType(long itemTypeId, int start, int end)
		throws SystemException {
		return findByItemType(itemTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the catalogs where itemTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param itemTypeId the item type ID
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching catalogs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Catalog> findByItemType(long itemTypeId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMTYPE;
			finderArgs = new Object[] { itemTypeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ITEMTYPE;
			finderArgs = new Object[] { itemTypeId, start, end, orderByComparator };
		}

		List<Catalog> list = (List<Catalog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Catalog catalog : list) {
				if ((itemTypeId != catalog.getItemTypeId())) {
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

			query.append(_SQL_SELECT_CATALOG_WHERE);

			query.append(_FINDER_COLUMN_ITEMTYPE_ITEMTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CatalogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(itemTypeId);

				if (!pagination) {
					list = (List<Catalog>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Catalog>(list);
				}
				else {
					list = (List<Catalog>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first catalog in the ordered set where itemTypeId = &#63;.
	 *
	 * @param itemTypeId the item type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog
	 * @throws com.kencana.lms.NoSuchCatalogException if a matching catalog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog findByItemType_First(long itemTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchCatalogException, SystemException {
		Catalog catalog = fetchByItemType_First(itemTypeId, orderByComparator);

		if (catalog != null) {
			return catalog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("itemTypeId=");
		msg.append(itemTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCatalogException(msg.toString());
	}

	/**
	 * Returns the first catalog in the ordered set where itemTypeId = &#63;.
	 *
	 * @param itemTypeId the item type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog, or <code>null</code> if a matching catalog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog fetchByItemType_First(long itemTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Catalog> list = findByItemType(itemTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last catalog in the ordered set where itemTypeId = &#63;.
	 *
	 * @param itemTypeId the item type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog
	 * @throws com.kencana.lms.NoSuchCatalogException if a matching catalog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog findByItemType_Last(long itemTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchCatalogException, SystemException {
		Catalog catalog = fetchByItemType_Last(itemTypeId, orderByComparator);

		if (catalog != null) {
			return catalog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("itemTypeId=");
		msg.append(itemTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCatalogException(msg.toString());
	}

	/**
	 * Returns the last catalog in the ordered set where itemTypeId = &#63;.
	 *
	 * @param itemTypeId the item type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog, or <code>null</code> if a matching catalog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog fetchByItemType_Last(long itemTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByItemType(itemTypeId);

		if (count == 0) {
			return null;
		}

		List<Catalog> list = findByItemType(itemTypeId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the catalogs before and after the current catalog in the ordered set where itemTypeId = &#63;.
	 *
	 * @param catalogId the primary key of the current catalog
	 * @param itemTypeId the item type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog
	 * @throws com.kencana.lms.NoSuchCatalogException if a catalog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog[] findByItemType_PrevAndNext(long catalogId,
		long itemTypeId, OrderByComparator orderByComparator)
		throws NoSuchCatalogException, SystemException {
		Catalog catalog = findByPrimaryKey(catalogId);

		Session session = null;

		try {
			session = openSession();

			Catalog[] array = new CatalogImpl[3];

			array[0] = getByItemType_PrevAndNext(session, catalog, itemTypeId,
					orderByComparator, true);

			array[1] = catalog;

			array[2] = getByItemType_PrevAndNext(session, catalog, itemTypeId,
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

	protected Catalog getByItemType_PrevAndNext(Session session,
		Catalog catalog, long itemTypeId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CATALOG_WHERE);

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
			query.append(CatalogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(itemTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(catalog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Catalog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the catalogs where itemTypeId = &#63; from the database.
	 *
	 * @param itemTypeId the item type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByItemType(long itemTypeId) throws SystemException {
		for (Catalog catalog : findByItemType(itemTypeId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(catalog);
		}
	}

	/**
	 * Returns the number of catalogs where itemTypeId = &#63;.
	 *
	 * @param itemTypeId the item type ID
	 * @return the number of matching catalogs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByItemType(long itemTypeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ITEMTYPE;

		Object[] finderArgs = new Object[] { itemTypeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CATALOG_WHERE);

			query.append(_FINDER_COLUMN_ITEMTYPE_ITEMTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_ITEMTYPE_ITEMTYPEID_2 = "catalog.itemTypeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPCOMPANY =
		new FinderPath(CatalogModelImpl.ENTITY_CACHE_ENABLED,
			CatalogModelImpl.FINDER_CACHE_ENABLED, CatalogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCOMPANY =
		new FinderPath(CatalogModelImpl.ENTITY_CACHE_ENABLED,
			CatalogModelImpl.FINDER_CACHE_ENABLED, CatalogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupCompany",
			new String[] { Long.class.getName(), Long.class.getName() },
			CatalogModelImpl.GROUPID_COLUMN_BITMASK |
			CatalogModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPCOMPANY = new FinderPath(CatalogModelImpl.ENTITY_CACHE_ENABLED,
			CatalogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupCompany",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the catalogs where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching catalogs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Catalog> findByGroupCompany(long groupId, long companyId)
		throws SystemException {
		return findByGroupCompany(groupId, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the catalogs where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @return the range of matching catalogs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Catalog> findByGroupCompany(long groupId, long companyId,
		int start, int end) throws SystemException {
		return findByGroupCompany(groupId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the catalogs where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching catalogs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Catalog> findByGroupCompany(long groupId, long companyId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCOMPANY;
			finderArgs = new Object[] { groupId, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPCOMPANY;
			finderArgs = new Object[] {
					groupId, companyId,
					
					start, end, orderByComparator
				};
		}

		List<Catalog> list = (List<Catalog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Catalog catalog : list) {
				if ((groupId != catalog.getGroupId()) ||
						(companyId != catalog.getCompanyId())) {
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

			query.append(_SQL_SELECT_CATALOG_WHERE);

			query.append(_FINDER_COLUMN_GROUPCOMPANY_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPCOMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CatalogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Catalog>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Catalog>(list);
				}
				else {
					list = (List<Catalog>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first catalog in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog
	 * @throws com.kencana.lms.NoSuchCatalogException if a matching catalog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog findByGroupCompany_First(long groupId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCatalogException, SystemException {
		Catalog catalog = fetchByGroupCompany_First(groupId, companyId,
				orderByComparator);

		if (catalog != null) {
			return catalog;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCatalogException(msg.toString());
	}

	/**
	 * Returns the first catalog in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog, or <code>null</code> if a matching catalog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog fetchByGroupCompany_First(long groupId, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Catalog> list = findByGroupCompany(groupId, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last catalog in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog
	 * @throws com.kencana.lms.NoSuchCatalogException if a matching catalog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog findByGroupCompany_Last(long groupId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCatalogException, SystemException {
		Catalog catalog = fetchByGroupCompany_Last(groupId, companyId,
				orderByComparator);

		if (catalog != null) {
			return catalog;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCatalogException(msg.toString());
	}

	/**
	 * Returns the last catalog in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog, or <code>null</code> if a matching catalog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog fetchByGroupCompany_Last(long groupId, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupCompany(groupId, companyId);

		if (count == 0) {
			return null;
		}

		List<Catalog> list = findByGroupCompany(groupId, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the catalogs before and after the current catalog in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param catalogId the primary key of the current catalog
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog
	 * @throws com.kencana.lms.NoSuchCatalogException if a catalog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog[] findByGroupCompany_PrevAndNext(long catalogId,
		long groupId, long companyId, OrderByComparator orderByComparator)
		throws NoSuchCatalogException, SystemException {
		Catalog catalog = findByPrimaryKey(catalogId);

		Session session = null;

		try {
			session = openSession();

			Catalog[] array = new CatalogImpl[3];

			array[0] = getByGroupCompany_PrevAndNext(session, catalog, groupId,
					companyId, orderByComparator, true);

			array[1] = catalog;

			array[2] = getByGroupCompany_PrevAndNext(session, catalog, groupId,
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

	protected Catalog getByGroupCompany_PrevAndNext(Session session,
		Catalog catalog, long groupId, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CATALOG_WHERE);

		query.append(_FINDER_COLUMN_GROUPCOMPANY_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPCOMPANY_COMPANYID_2);

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
			query.append(CatalogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(catalog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Catalog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the catalogs that the user has permission to view where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching catalogs that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Catalog> filterFindByGroupCompany(long groupId, long companyId)
		throws SystemException {
		return filterFindByGroupCompany(groupId, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the catalogs that the user has permission to view where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @return the range of matching catalogs that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Catalog> filterFindByGroupCompany(long groupId, long companyId,
		int start, int end) throws SystemException {
		return filterFindByGroupCompany(groupId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the catalogs that the user has permissions to view where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching catalogs that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Catalog> filterFindByGroupCompany(long groupId, long companyId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupCompany(groupId, companyId, start, end,
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
			query.append(_FILTER_SQL_SELECT_CATALOG_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CATALOG_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPCOMPANY_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPCOMPANY_COMPANYID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CATALOG_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CatalogModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CatalogModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Catalog.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CatalogImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CatalogImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(companyId);

			return (List<Catalog>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the catalogs before and after the current catalog in the ordered set of catalogs that the user has permission to view where groupId = &#63; and companyId = &#63;.
	 *
	 * @param catalogId the primary key of the current catalog
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog
	 * @throws com.kencana.lms.NoSuchCatalogException if a catalog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog[] filterFindByGroupCompany_PrevAndNext(long catalogId,
		long groupId, long companyId, OrderByComparator orderByComparator)
		throws NoSuchCatalogException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupCompany_PrevAndNext(catalogId, groupId,
				companyId, orderByComparator);
		}

		Catalog catalog = findByPrimaryKey(catalogId);

		Session session = null;

		try {
			session = openSession();

			Catalog[] array = new CatalogImpl[3];

			array[0] = filterGetByGroupCompany_PrevAndNext(session, catalog,
					groupId, companyId, orderByComparator, true);

			array[1] = catalog;

			array[2] = filterGetByGroupCompany_PrevAndNext(session, catalog,
					groupId, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Catalog filterGetByGroupCompany_PrevAndNext(Session session,
		Catalog catalog, long groupId, long companyId,
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
			query.append(_FILTER_SQL_SELECT_CATALOG_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CATALOG_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPCOMPANY_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPCOMPANY_COMPANYID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CATALOG_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CatalogModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CatalogModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Catalog.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CatalogImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CatalogImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(catalog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Catalog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the catalogs where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupCompany(long groupId, long companyId)
		throws SystemException {
		for (Catalog catalog : findByGroupCompany(groupId, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(catalog);
		}
	}

	/**
	 * Returns the number of catalogs where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching catalogs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupCompany(long groupId, long companyId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPCOMPANY;

		Object[] finderArgs = new Object[] { groupId, companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CATALOG_WHERE);

			query.append(_FINDER_COLUMN_GROUPCOMPANY_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPCOMPANY_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

	/**
	 * Returns the number of catalogs that the user has permission to view where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching catalogs that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByGroupCompany(long groupId, long companyId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupCompany(groupId, companyId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_CATALOG_WHERE);

		query.append(_FINDER_COLUMN_GROUPCOMPANY_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPCOMPANY_COMPANYID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Catalog.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_GROUPCOMPANY_GROUPID_2 = "catalog.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPCOMPANY_COMPANYID_2 = "catalog.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(CatalogModelImpl.ENTITY_CACHE_ENABLED,
			CatalogModelImpl.FINDER_CACHE_ENABLED, CatalogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(CatalogModelImpl.ENTITY_CACHE_ENABLED,
			CatalogModelImpl.FINDER_CACHE_ENABLED, CatalogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			CatalogModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(CatalogModelImpl.ENTITY_CACHE_ENABLED,
			CatalogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the catalogs where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching catalogs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Catalog> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the catalogs where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @return the range of matching catalogs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Catalog> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the catalogs where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching catalogs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Catalog> findByCompany(long companyId, int start, int end,
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

		List<Catalog> list = (List<Catalog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Catalog catalog : list) {
				if ((companyId != catalog.getCompanyId())) {
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

			query.append(_SQL_SELECT_CATALOG_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CatalogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Catalog>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Catalog>(list);
				}
				else {
					list = (List<Catalog>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first catalog in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog
	 * @throws com.kencana.lms.NoSuchCatalogException if a matching catalog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCatalogException, SystemException {
		Catalog catalog = fetchByCompany_First(companyId, orderByComparator);

		if (catalog != null) {
			return catalog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCatalogException(msg.toString());
	}

	/**
	 * Returns the first catalog in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog, or <code>null</code> if a matching catalog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Catalog> list = findByCompany(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last catalog in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog
	 * @throws com.kencana.lms.NoSuchCatalogException if a matching catalog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCatalogException, SystemException {
		Catalog catalog = fetchByCompany_Last(companyId, orderByComparator);

		if (catalog != null) {
			return catalog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCatalogException(msg.toString());
	}

	/**
	 * Returns the last catalog in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog, or <code>null</code> if a matching catalog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		if (count == 0) {
			return null;
		}

		List<Catalog> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the catalogs before and after the current catalog in the ordered set where companyId = &#63;.
	 *
	 * @param catalogId the primary key of the current catalog
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog
	 * @throws com.kencana.lms.NoSuchCatalogException if a catalog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog[] findByCompany_PrevAndNext(long catalogId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCatalogException, SystemException {
		Catalog catalog = findByPrimaryKey(catalogId);

		Session session = null;

		try {
			session = openSession();

			Catalog[] array = new CatalogImpl[3];

			array[0] = getByCompany_PrevAndNext(session, catalog, companyId,
					orderByComparator, true);

			array[1] = catalog;

			array[2] = getByCompany_PrevAndNext(session, catalog, companyId,
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

	protected Catalog getByCompany_PrevAndNext(Session session,
		Catalog catalog, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CATALOG_WHERE);

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
			query.append(CatalogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(catalog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Catalog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the catalogs where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompany(long companyId) throws SystemException {
		for (Catalog catalog : findByCompany(companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(catalog);
		}
	}

	/**
	 * Returns the number of catalogs where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching catalogs
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

			query.append(_SQL_COUNT_CATALOG_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "catalog.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(CatalogModelImpl.ENTITY_CACHE_ENABLED,
			CatalogModelImpl.FINDER_CACHE_ENABLED, CatalogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(CatalogModelImpl.ENTITY_CACHE_ENABLED,
			CatalogModelImpl.FINDER_CACHE_ENABLED, CatalogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			CatalogModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(CatalogModelImpl.ENTITY_CACHE_ENABLED,
			CatalogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the catalogs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching catalogs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Catalog> findByGroup(long groupId) throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the catalogs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @return the range of matching catalogs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Catalog> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the catalogs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching catalogs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Catalog> findByGroup(long groupId, int start, int end,
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

		List<Catalog> list = (List<Catalog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Catalog catalog : list) {
				if ((groupId != catalog.getGroupId())) {
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

			query.append(_SQL_SELECT_CATALOG_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CatalogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Catalog>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Catalog>(list);
				}
				else {
					list = (List<Catalog>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first catalog in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog
	 * @throws com.kencana.lms.NoSuchCatalogException if a matching catalog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCatalogException, SystemException {
		Catalog catalog = fetchByGroup_First(groupId, orderByComparator);

		if (catalog != null) {
			return catalog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCatalogException(msg.toString());
	}

	/**
	 * Returns the first catalog in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog, or <code>null</code> if a matching catalog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Catalog> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last catalog in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog
	 * @throws com.kencana.lms.NoSuchCatalogException if a matching catalog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCatalogException, SystemException {
		Catalog catalog = fetchByGroup_Last(groupId, orderByComparator);

		if (catalog != null) {
			return catalog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCatalogException(msg.toString());
	}

	/**
	 * Returns the last catalog in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog, or <code>null</code> if a matching catalog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		if (count == 0) {
			return null;
		}

		List<Catalog> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the catalogs before and after the current catalog in the ordered set where groupId = &#63;.
	 *
	 * @param catalogId the primary key of the current catalog
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog
	 * @throws com.kencana.lms.NoSuchCatalogException if a catalog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog[] findByGroup_PrevAndNext(long catalogId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCatalogException, SystemException {
		Catalog catalog = findByPrimaryKey(catalogId);

		Session session = null;

		try {
			session = openSession();

			Catalog[] array = new CatalogImpl[3];

			array[0] = getByGroup_PrevAndNext(session, catalog, groupId,
					orderByComparator, true);

			array[1] = catalog;

			array[2] = getByGroup_PrevAndNext(session, catalog, groupId,
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

	protected Catalog getByGroup_PrevAndNext(Session session, Catalog catalog,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CATALOG_WHERE);

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
			query.append(CatalogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(catalog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Catalog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the catalogs that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching catalogs that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Catalog> filterFindByGroup(long groupId)
		throws SystemException {
		return filterFindByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the catalogs that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @return the range of matching catalogs that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Catalog> filterFindByGroup(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the catalogs that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching catalogs that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Catalog> filterFindByGroup(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup(groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CATALOG_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CATALOG_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CATALOG_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CatalogModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CatalogModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Catalog.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CatalogImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CatalogImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<Catalog>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the catalogs before and after the current catalog in the ordered set of catalogs that the user has permission to view where groupId = &#63;.
	 *
	 * @param catalogId the primary key of the current catalog
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog
	 * @throws com.kencana.lms.NoSuchCatalogException if a catalog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog[] filterFindByGroup_PrevAndNext(long catalogId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCatalogException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(catalogId, groupId, orderByComparator);
		}

		Catalog catalog = findByPrimaryKey(catalogId);

		Session session = null;

		try {
			session = openSession();

			Catalog[] array = new CatalogImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session, catalog, groupId,
					orderByComparator, true);

			array[1] = catalog;

			array[2] = filterGetByGroup_PrevAndNext(session, catalog, groupId,
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

	protected Catalog filterGetByGroup_PrevAndNext(Session session,
		Catalog catalog, long groupId, OrderByComparator orderByComparator,
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
			query.append(_FILTER_SQL_SELECT_CATALOG_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CATALOG_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CATALOG_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CatalogModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CatalogModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Catalog.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CatalogImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CatalogImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(catalog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Catalog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the catalogs where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroup(long groupId) throws SystemException {
		for (Catalog catalog : findByGroup(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(catalog);
		}
	}

	/**
	 * Returns the number of catalogs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching catalogs
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

			query.append(_SQL_COUNT_CATALOG_WHERE);

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

	/**
	 * Returns the number of catalogs that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching catalogs that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByGroup(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_CATALOG_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Catalog.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "catalog.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPSTATUS =
		new FinderPath(CatalogModelImpl.ENTITY_CACHE_ENABLED,
			CatalogModelImpl.FINDER_CACHE_ENABLED, CatalogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPSTATUS =
		new FinderPath(CatalogModelImpl.ENTITY_CACHE_ENABLED,
			CatalogModelImpl.FINDER_CACHE_ENABLED, CatalogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupStatus",
			new String[] { Long.class.getName(), Integer.class.getName() },
			CatalogModelImpl.GROUPID_COLUMN_BITMASK |
			CatalogModelImpl.WORKFLOWSTATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPSTATUS = new FinderPath(CatalogModelImpl.ENTITY_CACHE_ENABLED,
			CatalogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupStatus",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the catalogs where groupId = &#63; and workflowStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workflowStatus the workflow status
	 * @return the matching catalogs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Catalog> findByGroupStatus(long groupId, int workflowStatus)
		throws SystemException {
		return findByGroupStatus(groupId, workflowStatus, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the catalogs where groupId = &#63; and workflowStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param workflowStatus the workflow status
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @return the range of matching catalogs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Catalog> findByGroupStatus(long groupId, int workflowStatus,
		int start, int end) throws SystemException {
		return findByGroupStatus(groupId, workflowStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the catalogs where groupId = &#63; and workflowStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param workflowStatus the workflow status
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching catalogs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Catalog> findByGroupStatus(long groupId, int workflowStatus,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPSTATUS;
			finderArgs = new Object[] { groupId, workflowStatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPSTATUS;
			finderArgs = new Object[] {
					groupId, workflowStatus,
					
					start, end, orderByComparator
				};
		}

		List<Catalog> list = (List<Catalog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Catalog catalog : list) {
				if ((groupId != catalog.getGroupId()) ||
						(workflowStatus != catalog.getWorkflowStatus())) {
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

			query.append(_SQL_SELECT_CATALOG_WHERE);

			query.append(_FINDER_COLUMN_GROUPSTATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPSTATUS_WORKFLOWSTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CatalogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(workflowStatus);

				if (!pagination) {
					list = (List<Catalog>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Catalog>(list);
				}
				else {
					list = (List<Catalog>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first catalog in the ordered set where groupId = &#63; and workflowStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workflowStatus the workflow status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog
	 * @throws com.kencana.lms.NoSuchCatalogException if a matching catalog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog findByGroupStatus_First(long groupId, int workflowStatus,
		OrderByComparator orderByComparator)
		throws NoSuchCatalogException, SystemException {
		Catalog catalog = fetchByGroupStatus_First(groupId, workflowStatus,
				orderByComparator);

		if (catalog != null) {
			return catalog;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", workflowStatus=");
		msg.append(workflowStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCatalogException(msg.toString());
	}

	/**
	 * Returns the first catalog in the ordered set where groupId = &#63; and workflowStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workflowStatus the workflow status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog, or <code>null</code> if a matching catalog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog fetchByGroupStatus_First(long groupId, int workflowStatus,
		OrderByComparator orderByComparator) throws SystemException {
		List<Catalog> list = findByGroupStatus(groupId, workflowStatus, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last catalog in the ordered set where groupId = &#63; and workflowStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workflowStatus the workflow status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog
	 * @throws com.kencana.lms.NoSuchCatalogException if a matching catalog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog findByGroupStatus_Last(long groupId, int workflowStatus,
		OrderByComparator orderByComparator)
		throws NoSuchCatalogException, SystemException {
		Catalog catalog = fetchByGroupStatus_Last(groupId, workflowStatus,
				orderByComparator);

		if (catalog != null) {
			return catalog;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", workflowStatus=");
		msg.append(workflowStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCatalogException(msg.toString());
	}

	/**
	 * Returns the last catalog in the ordered set where groupId = &#63; and workflowStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workflowStatus the workflow status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog, or <code>null</code> if a matching catalog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog fetchByGroupStatus_Last(long groupId, int workflowStatus,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupStatus(groupId, workflowStatus);

		if (count == 0) {
			return null;
		}

		List<Catalog> list = findByGroupStatus(groupId, workflowStatus,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the catalogs before and after the current catalog in the ordered set where groupId = &#63; and workflowStatus = &#63;.
	 *
	 * @param catalogId the primary key of the current catalog
	 * @param groupId the group ID
	 * @param workflowStatus the workflow status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog
	 * @throws com.kencana.lms.NoSuchCatalogException if a catalog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog[] findByGroupStatus_PrevAndNext(long catalogId,
		long groupId, int workflowStatus, OrderByComparator orderByComparator)
		throws NoSuchCatalogException, SystemException {
		Catalog catalog = findByPrimaryKey(catalogId);

		Session session = null;

		try {
			session = openSession();

			Catalog[] array = new CatalogImpl[3];

			array[0] = getByGroupStatus_PrevAndNext(session, catalog, groupId,
					workflowStatus, orderByComparator, true);

			array[1] = catalog;

			array[2] = getByGroupStatus_PrevAndNext(session, catalog, groupId,
					workflowStatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Catalog getByGroupStatus_PrevAndNext(Session session,
		Catalog catalog, long groupId, int workflowStatus,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CATALOG_WHERE);

		query.append(_FINDER_COLUMN_GROUPSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPSTATUS_WORKFLOWSTATUS_2);

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
			query.append(CatalogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(workflowStatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(catalog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Catalog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the catalogs that the user has permission to view where groupId = &#63; and workflowStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workflowStatus the workflow status
	 * @return the matching catalogs that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Catalog> filterFindByGroupStatus(long groupId,
		int workflowStatus) throws SystemException {
		return filterFindByGroupStatus(groupId, workflowStatus,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the catalogs that the user has permission to view where groupId = &#63; and workflowStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param workflowStatus the workflow status
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @return the range of matching catalogs that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Catalog> filterFindByGroupStatus(long groupId,
		int workflowStatus, int start, int end) throws SystemException {
		return filterFindByGroupStatus(groupId, workflowStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the catalogs that the user has permissions to view where groupId = &#63; and workflowStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param workflowStatus the workflow status
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching catalogs that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Catalog> filterFindByGroupStatus(long groupId,
		int workflowStatus, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupStatus(groupId, workflowStatus, start, end,
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
			query.append(_FILTER_SQL_SELECT_CATALOG_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CATALOG_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPSTATUS_WORKFLOWSTATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CATALOG_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CatalogModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CatalogModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Catalog.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CatalogImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CatalogImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(workflowStatus);

			return (List<Catalog>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the catalogs before and after the current catalog in the ordered set of catalogs that the user has permission to view where groupId = &#63; and workflowStatus = &#63;.
	 *
	 * @param catalogId the primary key of the current catalog
	 * @param groupId the group ID
	 * @param workflowStatus the workflow status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog
	 * @throws com.kencana.lms.NoSuchCatalogException if a catalog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog[] filterFindByGroupStatus_PrevAndNext(long catalogId,
		long groupId, int workflowStatus, OrderByComparator orderByComparator)
		throws NoSuchCatalogException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupStatus_PrevAndNext(catalogId, groupId,
				workflowStatus, orderByComparator);
		}

		Catalog catalog = findByPrimaryKey(catalogId);

		Session session = null;

		try {
			session = openSession();

			Catalog[] array = new CatalogImpl[3];

			array[0] = filterGetByGroupStatus_PrevAndNext(session, catalog,
					groupId, workflowStatus, orderByComparator, true);

			array[1] = catalog;

			array[2] = filterGetByGroupStatus_PrevAndNext(session, catalog,
					groupId, workflowStatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Catalog filterGetByGroupStatus_PrevAndNext(Session session,
		Catalog catalog, long groupId, int workflowStatus,
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
			query.append(_FILTER_SQL_SELECT_CATALOG_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CATALOG_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPSTATUS_WORKFLOWSTATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CATALOG_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(CatalogModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CatalogModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Catalog.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CatalogImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CatalogImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(workflowStatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(catalog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Catalog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the catalogs where groupId = &#63; and workflowStatus = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param workflowStatus the workflow status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupStatus(long groupId, int workflowStatus)
		throws SystemException {
		for (Catalog catalog : findByGroupStatus(groupId, workflowStatus,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(catalog);
		}
	}

	/**
	 * Returns the number of catalogs where groupId = &#63; and workflowStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workflowStatus the workflow status
	 * @return the number of matching catalogs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupStatus(long groupId, int workflowStatus)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPSTATUS;

		Object[] finderArgs = new Object[] { groupId, workflowStatus };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CATALOG_WHERE);

			query.append(_FINDER_COLUMN_GROUPSTATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPSTATUS_WORKFLOWSTATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(workflowStatus);

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
	 * Returns the number of catalogs that the user has permission to view where groupId = &#63; and workflowStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workflowStatus the workflow status
	 * @return the number of matching catalogs that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByGroupStatus(long groupId, int workflowStatus)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupStatus(groupId, workflowStatus);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_CATALOG_WHERE);

		query.append(_FINDER_COLUMN_GROUPSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPSTATUS_WORKFLOWSTATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Catalog.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(workflowStatus);

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

	private static final String _FINDER_COLUMN_GROUPSTATUS_GROUPID_2 = "catalog.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPSTATUS_WORKFLOWSTATUS_2 = "catalog.workflowStatus = ?";

	public CatalogPersistenceImpl() {
		setModelClass(Catalog.class);
	}

	/**
	 * Caches the catalog in the entity cache if it is enabled.
	 *
	 * @param catalog the catalog
	 */
	@Override
	public void cacheResult(Catalog catalog) {
		EntityCacheUtil.putResult(CatalogModelImpl.ENTITY_CACHE_ENABLED,
			CatalogImpl.class, catalog.getPrimaryKey(), catalog);

		catalog.resetOriginalValues();
	}

	/**
	 * Caches the catalogs in the entity cache if it is enabled.
	 *
	 * @param catalogs the catalogs
	 */
	@Override
	public void cacheResult(List<Catalog> catalogs) {
		for (Catalog catalog : catalogs) {
			if (EntityCacheUtil.getResult(
						CatalogModelImpl.ENTITY_CACHE_ENABLED,
						CatalogImpl.class, catalog.getPrimaryKey()) == null) {
				cacheResult(catalog);
			}
			else {
				catalog.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all catalogs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CatalogImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CatalogImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the catalog.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Catalog catalog) {
		EntityCacheUtil.removeResult(CatalogModelImpl.ENTITY_CACHE_ENABLED,
			CatalogImpl.class, catalog.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Catalog> catalogs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Catalog catalog : catalogs) {
			EntityCacheUtil.removeResult(CatalogModelImpl.ENTITY_CACHE_ENABLED,
				CatalogImpl.class, catalog.getPrimaryKey());
		}
	}

	/**
	 * Creates a new catalog with the primary key. Does not add the catalog to the database.
	 *
	 * @param catalogId the primary key for the new catalog
	 * @return the new catalog
	 */
	@Override
	public Catalog create(long catalogId) {
		Catalog catalog = new CatalogImpl();

		catalog.setNew(true);
		catalog.setPrimaryKey(catalogId);

		return catalog;
	}

	/**
	 * Removes the catalog with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param catalogId the primary key of the catalog
	 * @return the catalog that was removed
	 * @throws com.kencana.lms.NoSuchCatalogException if a catalog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog remove(long catalogId)
		throws NoSuchCatalogException, SystemException {
		return remove((Serializable)catalogId);
	}

	/**
	 * Removes the catalog with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the catalog
	 * @return the catalog that was removed
	 * @throws com.kencana.lms.NoSuchCatalogException if a catalog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog remove(Serializable primaryKey)
		throws NoSuchCatalogException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Catalog catalog = (Catalog)session.get(CatalogImpl.class, primaryKey);

			if (catalog == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCatalogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(catalog);
		}
		catch (NoSuchCatalogException nsee) {
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
	protected Catalog removeImpl(Catalog catalog) throws SystemException {
		catalog = toUnwrappedModel(catalog);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(catalog)) {
				catalog = (Catalog)session.get(CatalogImpl.class,
						catalog.getPrimaryKeyObj());
			}

			if (catalog != null) {
				session.delete(catalog);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (catalog != null) {
			clearCache(catalog);
		}

		return catalog;
	}

	@Override
	public Catalog updateImpl(com.kencana.lms.model.Catalog catalog)
		throws SystemException {
		catalog = toUnwrappedModel(catalog);

		boolean isNew = catalog.isNew();

		CatalogModelImpl catalogModelImpl = (CatalogModelImpl)catalog;

		Session session = null;

		try {
			session = openSession();

			if (catalog.isNew()) {
				session.save(catalog);

				catalog.setNew(false);
			}
			else {
				session.merge(catalog);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CatalogModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((catalogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						catalogModelImpl.getOriginalTemplateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEMPLATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID,
					args);

				args = new Object[] { catalogModelImpl.getTemplateId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEMPLATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID,
					args);
			}

			if ((catalogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						catalogModelImpl.getOriginalItemTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ITEMTYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMTYPE,
					args);

				args = new Object[] { catalogModelImpl.getItemTypeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ITEMTYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMTYPE,
					args);
			}

			if ((catalogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						catalogModelImpl.getOriginalGroupId(),
						catalogModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCOMPANY,
					args);

				args = new Object[] {
						catalogModelImpl.getGroupId(),
						catalogModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCOMPANY,
					args);
			}

			if ((catalogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						catalogModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] { catalogModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}

			if ((catalogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						catalogModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] { catalogModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}

			if ((catalogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						catalogModelImpl.getOriginalGroupId(),
						catalogModelImpl.getOriginalWorkflowStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPSTATUS,
					args);

				args = new Object[] {
						catalogModelImpl.getGroupId(),
						catalogModelImpl.getWorkflowStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPSTATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(CatalogModelImpl.ENTITY_CACHE_ENABLED,
			CatalogImpl.class, catalog.getPrimaryKey(), catalog);

		return catalog;
	}

	protected Catalog toUnwrappedModel(Catalog catalog) {
		if (catalog instanceof CatalogImpl) {
			return catalog;
		}

		CatalogImpl catalogImpl = new CatalogImpl();

		catalogImpl.setNew(catalog.isNew());
		catalogImpl.setPrimaryKey(catalog.getPrimaryKey());

		catalogImpl.setCatalogId(catalog.getCatalogId());
		catalogImpl.setCompanyId(catalog.getCompanyId());
		catalogImpl.setGroupId(catalog.getGroupId());
		catalogImpl.setUserId(catalog.getUserId());
		catalogImpl.setUserName(catalog.getUserName());
		catalogImpl.setCreatedByUserId(catalog.getCreatedByUserId());
		catalogImpl.setCreateDate(catalog.getCreateDate());
		catalogImpl.setModifiedDate(catalog.getModifiedDate());
		catalogImpl.setItemTypeId(catalog.getItemTypeId());
		catalogImpl.setTitle(catalog.getTitle());
		catalogImpl.setAuthor(catalog.getAuthor());
		catalogImpl.setPublisher(catalog.getPublisher());
		catalogImpl.setIsbn(catalog.getIsbn());
		catalogImpl.setIssn(catalog.getIssn());
		catalogImpl.setCallNumber(catalog.getCallNumber());
		catalogImpl.setUUID(catalog.getUUID());
		catalogImpl.setCatalogAbstract(catalog.getCatalogAbstract());
		catalogImpl.setTemplateId(catalog.getTemplateId());
		catalogImpl.setVisible(catalog.isVisible());
		catalogImpl.setCoverImageId(catalog.getCoverImageId());
		catalogImpl.setMarc(catalog.getMarc());
		catalogImpl.setWorkflowStatus(catalog.getWorkflowStatus());

		return catalogImpl;
	}

	/**
	 * Returns the catalog with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the catalog
	 * @return the catalog
	 * @throws com.kencana.lms.NoSuchCatalogException if a catalog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCatalogException, SystemException {
		Catalog catalog = fetchByPrimaryKey(primaryKey);

		if (catalog == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCatalogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return catalog;
	}

	/**
	 * Returns the catalog with the primary key or throws a {@link com.kencana.lms.NoSuchCatalogException} if it could not be found.
	 *
	 * @param catalogId the primary key of the catalog
	 * @return the catalog
	 * @throws com.kencana.lms.NoSuchCatalogException if a catalog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog findByPrimaryKey(long catalogId)
		throws NoSuchCatalogException, SystemException {
		return findByPrimaryKey((Serializable)catalogId);
	}

	/**
	 * Returns the catalog with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the catalog
	 * @return the catalog, or <code>null</code> if a catalog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Catalog catalog = (Catalog)EntityCacheUtil.getResult(CatalogModelImpl.ENTITY_CACHE_ENABLED,
				CatalogImpl.class, primaryKey);

		if (catalog == _nullCatalog) {
			return null;
		}

		if (catalog == null) {
			Session session = null;

			try {
				session = openSession();

				catalog = (Catalog)session.get(CatalogImpl.class, primaryKey);

				if (catalog != null) {
					cacheResult(catalog);
				}
				else {
					EntityCacheUtil.putResult(CatalogModelImpl.ENTITY_CACHE_ENABLED,
						CatalogImpl.class, primaryKey, _nullCatalog);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CatalogModelImpl.ENTITY_CACHE_ENABLED,
					CatalogImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return catalog;
	}

	/**
	 * Returns the catalog with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param catalogId the primary key of the catalog
	 * @return the catalog, or <code>null</code> if a catalog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Catalog fetchByPrimaryKey(long catalogId) throws SystemException {
		return fetchByPrimaryKey((Serializable)catalogId);
	}

	/**
	 * Returns all the catalogs.
	 *
	 * @return the catalogs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Catalog> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the catalogs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @return the range of catalogs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Catalog> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the catalogs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of catalogs
	 * @param end the upper bound of the range of catalogs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of catalogs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Catalog> findAll(int start, int end,
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

		List<Catalog> list = (List<Catalog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CATALOG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CATALOG;

				if (pagination) {
					sql = sql.concat(CatalogModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Catalog>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Catalog>(list);
				}
				else {
					list = (List<Catalog>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the catalogs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Catalog catalog : findAll()) {
			remove(catalog);
		}
	}

	/**
	 * Returns the number of catalogs.
	 *
	 * @return the number of catalogs
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

				Query q = session.createQuery(_SQL_COUNT_CATALOG);

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
	 * Initializes the catalog persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.kencana.lms.model.Catalog")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Catalog>> listenersList = new ArrayList<ModelListener<Catalog>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Catalog>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CatalogImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CATALOG = "SELECT catalog FROM Catalog catalog";
	private static final String _SQL_SELECT_CATALOG_WHERE = "SELECT catalog FROM Catalog catalog WHERE ";
	private static final String _SQL_COUNT_CATALOG = "SELECT COUNT(catalog) FROM Catalog catalog";
	private static final String _SQL_COUNT_CATALOG_WHERE = "SELECT COUNT(catalog) FROM Catalog catalog WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "catalog.catalogId";
	private static final String _FILTER_SQL_SELECT_CATALOG_WHERE = "SELECT DISTINCT {catalog.*} FROM Kencana_Catalog catalog WHERE ";
	private static final String _FILTER_SQL_SELECT_CATALOG_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {Kencana_Catalog.*} FROM (SELECT DISTINCT catalog.catalogId FROM Kencana_Catalog catalog WHERE ";
	private static final String _FILTER_SQL_SELECT_CATALOG_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN Kencana_Catalog ON TEMP_TABLE.catalogId = Kencana_Catalog.catalogId";
	private static final String _FILTER_SQL_COUNT_CATALOG_WHERE = "SELECT COUNT(DISTINCT catalog.catalogId) AS COUNT_VALUE FROM Kencana_Catalog catalog WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "catalog";
	private static final String _FILTER_ENTITY_TABLE = "Kencana_Catalog";
	private static final String _ORDER_BY_ENTITY_ALIAS = "catalog.";
	private static final String _ORDER_BY_ENTITY_TABLE = "Kencana_Catalog.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Catalog exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Catalog exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CatalogPersistenceImpl.class);
	private static Catalog _nullCatalog = new CatalogImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Catalog> toCacheModel() {
				return _nullCatalogCacheModel;
			}
		};

	private static CacheModel<Catalog> _nullCatalogCacheModel = new CacheModel<Catalog>() {
			@Override
			public Catalog toEntityModel() {
				return _nullCatalog;
			}
		};
}