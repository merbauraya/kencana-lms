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

import com.kencana.lms.NoSuchCatalogTemplateSubfieldException;
import com.kencana.lms.model.CatalogTemplateSubfield;
import com.kencana.lms.model.impl.CatalogTemplateSubfieldImpl;
import com.kencana.lms.model.impl.CatalogTemplateSubfieldModelImpl;

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
 * The persistence implementation for the catalog template subfield service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see CatalogTemplateSubfieldPersistence
 * @see CatalogTemplateSubfieldUtil
 * @generated
 */
public class CatalogTemplateSubfieldPersistenceImpl extends BasePersistenceImpl<CatalogTemplateSubfield>
	implements CatalogTemplateSubfieldPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CatalogTemplateSubfieldUtil} to access the catalog template subfield persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CatalogTemplateSubfieldImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CatalogTemplateSubfieldModelImpl.ENTITY_CACHE_ENABLED,
			CatalogTemplateSubfieldModelImpl.FINDER_CACHE_ENABLED,
			CatalogTemplateSubfieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CatalogTemplateSubfieldModelImpl.ENTITY_CACHE_ENABLED,
			CatalogTemplateSubfieldModelImpl.FINDER_CACHE_ENABLED,
			CatalogTemplateSubfieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CatalogTemplateSubfieldModelImpl.ENTITY_CACHE_ENABLED,
			CatalogTemplateSubfieldModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TAG = new FinderPath(CatalogTemplateSubfieldModelImpl.ENTITY_CACHE_ENABLED,
			CatalogTemplateSubfieldModelImpl.FINDER_CACHE_ENABLED,
			CatalogTemplateSubfieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTag",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAG = new FinderPath(CatalogTemplateSubfieldModelImpl.ENTITY_CACHE_ENABLED,
			CatalogTemplateSubfieldModelImpl.FINDER_CACHE_ENABLED,
			CatalogTemplateSubfieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTag",
			new String[] { Long.class.getName() },
			CatalogTemplateSubfieldModelImpl.CATALOGTEMPLATETAGID_COLUMN_BITMASK |
			CatalogTemplateSubfieldModelImpl.SUBFIELD_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TAG = new FinderPath(CatalogTemplateSubfieldModelImpl.ENTITY_CACHE_ENABLED,
			CatalogTemplateSubfieldModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTag",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the catalog template subfields where catalogTemplateTagId = &#63;.
	 *
	 * @param catalogTemplateTagId the catalog template tag ID
	 * @return the matching catalog template subfields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogTemplateSubfield> findByTag(long catalogTemplateTagId)
		throws SystemException {
		return findByTag(catalogTemplateTagId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the catalog template subfields where catalogTemplateTagId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogTemplateSubfieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param catalogTemplateTagId the catalog template tag ID
	 * @param start the lower bound of the range of catalog template subfields
	 * @param end the upper bound of the range of catalog template subfields (not inclusive)
	 * @return the range of matching catalog template subfields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogTemplateSubfield> findByTag(long catalogTemplateTagId,
		int start, int end) throws SystemException {
		return findByTag(catalogTemplateTagId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the catalog template subfields where catalogTemplateTagId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogTemplateSubfieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param catalogTemplateTagId the catalog template tag ID
	 * @param start the lower bound of the range of catalog template subfields
	 * @param end the upper bound of the range of catalog template subfields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching catalog template subfields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogTemplateSubfield> findByTag(long catalogTemplateTagId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAG;
			finderArgs = new Object[] { catalogTemplateTagId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TAG;
			finderArgs = new Object[] {
					catalogTemplateTagId,
					
					start, end, orderByComparator
				};
		}

		List<CatalogTemplateSubfield> list = (List<CatalogTemplateSubfield>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CatalogTemplateSubfield catalogTemplateSubfield : list) {
				if ((catalogTemplateTagId != catalogTemplateSubfield.getCatalogTemplateTagId())) {
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

			query.append(_SQL_SELECT_CATALOGTEMPLATESUBFIELD_WHERE);

			query.append(_FINDER_COLUMN_TAG_CATALOGTEMPLATETAGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CatalogTemplateSubfieldModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(catalogTemplateTagId);

				if (!pagination) {
					list = (List<CatalogTemplateSubfield>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CatalogTemplateSubfield>(list);
				}
				else {
					list = (List<CatalogTemplateSubfield>)QueryUtil.list(q,
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
	 * Returns the first catalog template subfield in the ordered set where catalogTemplateTagId = &#63;.
	 *
	 * @param catalogTemplateTagId the catalog template tag ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog template subfield
	 * @throws com.kencana.lms.NoSuchCatalogTemplateSubfieldException if a matching catalog template subfield could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogTemplateSubfield findByTag_First(long catalogTemplateTagId,
		OrderByComparator orderByComparator)
		throws NoSuchCatalogTemplateSubfieldException, SystemException {
		CatalogTemplateSubfield catalogTemplateSubfield = fetchByTag_First(catalogTemplateTagId,
				orderByComparator);

		if (catalogTemplateSubfield != null) {
			return catalogTemplateSubfield;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("catalogTemplateTagId=");
		msg.append(catalogTemplateTagId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCatalogTemplateSubfieldException(msg.toString());
	}

	/**
	 * Returns the first catalog template subfield in the ordered set where catalogTemplateTagId = &#63;.
	 *
	 * @param catalogTemplateTagId the catalog template tag ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog template subfield, or <code>null</code> if a matching catalog template subfield could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogTemplateSubfield fetchByTag_First(long catalogTemplateTagId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CatalogTemplateSubfield> list = findByTag(catalogTemplateTagId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last catalog template subfield in the ordered set where catalogTemplateTagId = &#63;.
	 *
	 * @param catalogTemplateTagId the catalog template tag ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog template subfield
	 * @throws com.kencana.lms.NoSuchCatalogTemplateSubfieldException if a matching catalog template subfield could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogTemplateSubfield findByTag_Last(long catalogTemplateTagId,
		OrderByComparator orderByComparator)
		throws NoSuchCatalogTemplateSubfieldException, SystemException {
		CatalogTemplateSubfield catalogTemplateSubfield = fetchByTag_Last(catalogTemplateTagId,
				orderByComparator);

		if (catalogTemplateSubfield != null) {
			return catalogTemplateSubfield;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("catalogTemplateTagId=");
		msg.append(catalogTemplateTagId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCatalogTemplateSubfieldException(msg.toString());
	}

	/**
	 * Returns the last catalog template subfield in the ordered set where catalogTemplateTagId = &#63;.
	 *
	 * @param catalogTemplateTagId the catalog template tag ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog template subfield, or <code>null</code> if a matching catalog template subfield could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogTemplateSubfield fetchByTag_Last(long catalogTemplateTagId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTag(catalogTemplateTagId);

		if (count == 0) {
			return null;
		}

		List<CatalogTemplateSubfield> list = findByTag(catalogTemplateTagId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the catalog template subfields before and after the current catalog template subfield in the ordered set where catalogTemplateTagId = &#63;.
	 *
	 * @param catalogTemplateSubfieldId the primary key of the current catalog template subfield
	 * @param catalogTemplateTagId the catalog template tag ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog template subfield
	 * @throws com.kencana.lms.NoSuchCatalogTemplateSubfieldException if a catalog template subfield with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogTemplateSubfield[] findByTag_PrevAndNext(
		long catalogTemplateSubfieldId, long catalogTemplateTagId,
		OrderByComparator orderByComparator)
		throws NoSuchCatalogTemplateSubfieldException, SystemException {
		CatalogTemplateSubfield catalogTemplateSubfield = findByPrimaryKey(catalogTemplateSubfieldId);

		Session session = null;

		try {
			session = openSession();

			CatalogTemplateSubfield[] array = new CatalogTemplateSubfieldImpl[3];

			array[0] = getByTag_PrevAndNext(session, catalogTemplateSubfield,
					catalogTemplateTagId, orderByComparator, true);

			array[1] = catalogTemplateSubfield;

			array[2] = getByTag_PrevAndNext(session, catalogTemplateSubfield,
					catalogTemplateTagId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CatalogTemplateSubfield getByTag_PrevAndNext(Session session,
		CatalogTemplateSubfield catalogTemplateSubfield,
		long catalogTemplateTagId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CATALOGTEMPLATESUBFIELD_WHERE);

		query.append(_FINDER_COLUMN_TAG_CATALOGTEMPLATETAGID_2);

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
			query.append(CatalogTemplateSubfieldModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(catalogTemplateTagId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(catalogTemplateSubfield);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CatalogTemplateSubfield> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the catalog template subfields where catalogTemplateTagId = &#63; from the database.
	 *
	 * @param catalogTemplateTagId the catalog template tag ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTag(long catalogTemplateTagId)
		throws SystemException {
		for (CatalogTemplateSubfield catalogTemplateSubfield : findByTag(
				catalogTemplateTagId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(catalogTemplateSubfield);
		}
	}

	/**
	 * Returns the number of catalog template subfields where catalogTemplateTagId = &#63;.
	 *
	 * @param catalogTemplateTagId the catalog template tag ID
	 * @return the number of matching catalog template subfields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTag(long catalogTemplateTagId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TAG;

		Object[] finderArgs = new Object[] { catalogTemplateTagId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CATALOGTEMPLATESUBFIELD_WHERE);

			query.append(_FINDER_COLUMN_TAG_CATALOGTEMPLATETAGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(catalogTemplateTagId);

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

	private static final String _FINDER_COLUMN_TAG_CATALOGTEMPLATETAGID_2 = "catalogTemplateSubfield.catalogTemplateTagId = ?";

	public CatalogTemplateSubfieldPersistenceImpl() {
		setModelClass(CatalogTemplateSubfield.class);
	}

	/**
	 * Caches the catalog template subfield in the entity cache if it is enabled.
	 *
	 * @param catalogTemplateSubfield the catalog template subfield
	 */
	@Override
	public void cacheResult(CatalogTemplateSubfield catalogTemplateSubfield) {
		EntityCacheUtil.putResult(CatalogTemplateSubfieldModelImpl.ENTITY_CACHE_ENABLED,
			CatalogTemplateSubfieldImpl.class,
			catalogTemplateSubfield.getPrimaryKey(), catalogTemplateSubfield);

		catalogTemplateSubfield.resetOriginalValues();
	}

	/**
	 * Caches the catalog template subfields in the entity cache if it is enabled.
	 *
	 * @param catalogTemplateSubfields the catalog template subfields
	 */
	@Override
	public void cacheResult(
		List<CatalogTemplateSubfield> catalogTemplateSubfields) {
		for (CatalogTemplateSubfield catalogTemplateSubfield : catalogTemplateSubfields) {
			if (EntityCacheUtil.getResult(
						CatalogTemplateSubfieldModelImpl.ENTITY_CACHE_ENABLED,
						CatalogTemplateSubfieldImpl.class,
						catalogTemplateSubfield.getPrimaryKey()) == null) {
				cacheResult(catalogTemplateSubfield);
			}
			else {
				catalogTemplateSubfield.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all catalog template subfields.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CatalogTemplateSubfieldImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CatalogTemplateSubfieldImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the catalog template subfield.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CatalogTemplateSubfield catalogTemplateSubfield) {
		EntityCacheUtil.removeResult(CatalogTemplateSubfieldModelImpl.ENTITY_CACHE_ENABLED,
			CatalogTemplateSubfieldImpl.class,
			catalogTemplateSubfield.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<CatalogTemplateSubfield> catalogTemplateSubfields) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CatalogTemplateSubfield catalogTemplateSubfield : catalogTemplateSubfields) {
			EntityCacheUtil.removeResult(CatalogTemplateSubfieldModelImpl.ENTITY_CACHE_ENABLED,
				CatalogTemplateSubfieldImpl.class,
				catalogTemplateSubfield.getPrimaryKey());
		}
	}

	/**
	 * Creates a new catalog template subfield with the primary key. Does not add the catalog template subfield to the database.
	 *
	 * @param catalogTemplateSubfieldId the primary key for the new catalog template subfield
	 * @return the new catalog template subfield
	 */
	@Override
	public CatalogTemplateSubfield create(long catalogTemplateSubfieldId) {
		CatalogTemplateSubfield catalogTemplateSubfield = new CatalogTemplateSubfieldImpl();

		catalogTemplateSubfield.setNew(true);
		catalogTemplateSubfield.setPrimaryKey(catalogTemplateSubfieldId);

		return catalogTemplateSubfield;
	}

	/**
	 * Removes the catalog template subfield with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param catalogTemplateSubfieldId the primary key of the catalog template subfield
	 * @return the catalog template subfield that was removed
	 * @throws com.kencana.lms.NoSuchCatalogTemplateSubfieldException if a catalog template subfield with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogTemplateSubfield remove(long catalogTemplateSubfieldId)
		throws NoSuchCatalogTemplateSubfieldException, SystemException {
		return remove((Serializable)catalogTemplateSubfieldId);
	}

	/**
	 * Removes the catalog template subfield with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the catalog template subfield
	 * @return the catalog template subfield that was removed
	 * @throws com.kencana.lms.NoSuchCatalogTemplateSubfieldException if a catalog template subfield with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogTemplateSubfield remove(Serializable primaryKey)
		throws NoSuchCatalogTemplateSubfieldException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CatalogTemplateSubfield catalogTemplateSubfield = (CatalogTemplateSubfield)session.get(CatalogTemplateSubfieldImpl.class,
					primaryKey);

			if (catalogTemplateSubfield == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCatalogTemplateSubfieldException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(catalogTemplateSubfield);
		}
		catch (NoSuchCatalogTemplateSubfieldException nsee) {
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
	protected CatalogTemplateSubfield removeImpl(
		CatalogTemplateSubfield catalogTemplateSubfield)
		throws SystemException {
		catalogTemplateSubfield = toUnwrappedModel(catalogTemplateSubfield);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(catalogTemplateSubfield)) {
				catalogTemplateSubfield = (CatalogTemplateSubfield)session.get(CatalogTemplateSubfieldImpl.class,
						catalogTemplateSubfield.getPrimaryKeyObj());
			}

			if (catalogTemplateSubfield != null) {
				session.delete(catalogTemplateSubfield);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (catalogTemplateSubfield != null) {
			clearCache(catalogTemplateSubfield);
		}

		return catalogTemplateSubfield;
	}

	@Override
	public CatalogTemplateSubfield updateImpl(
		com.kencana.lms.model.CatalogTemplateSubfield catalogTemplateSubfield)
		throws SystemException {
		catalogTemplateSubfield = toUnwrappedModel(catalogTemplateSubfield);

		boolean isNew = catalogTemplateSubfield.isNew();

		CatalogTemplateSubfieldModelImpl catalogTemplateSubfieldModelImpl = (CatalogTemplateSubfieldModelImpl)catalogTemplateSubfield;

		Session session = null;

		try {
			session = openSession();

			if (catalogTemplateSubfield.isNew()) {
				session.save(catalogTemplateSubfield);

				catalogTemplateSubfield.setNew(false);
			}
			else {
				session.merge(catalogTemplateSubfield);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CatalogTemplateSubfieldModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((catalogTemplateSubfieldModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						catalogTemplateSubfieldModelImpl.getOriginalCatalogTemplateTagId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAG,
					args);

				args = new Object[] {
						catalogTemplateSubfieldModelImpl.getCatalogTemplateTagId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAG,
					args);
			}
		}

		EntityCacheUtil.putResult(CatalogTemplateSubfieldModelImpl.ENTITY_CACHE_ENABLED,
			CatalogTemplateSubfieldImpl.class,
			catalogTemplateSubfield.getPrimaryKey(), catalogTemplateSubfield);

		return catalogTemplateSubfield;
	}

	protected CatalogTemplateSubfield toUnwrappedModel(
		CatalogTemplateSubfield catalogTemplateSubfield) {
		if (catalogTemplateSubfield instanceof CatalogTemplateSubfieldImpl) {
			return catalogTemplateSubfield;
		}

		CatalogTemplateSubfieldImpl catalogTemplateSubfieldImpl = new CatalogTemplateSubfieldImpl();

		catalogTemplateSubfieldImpl.setNew(catalogTemplateSubfield.isNew());
		catalogTemplateSubfieldImpl.setPrimaryKey(catalogTemplateSubfield.getPrimaryKey());

		catalogTemplateSubfieldImpl.setCatalogTemplateSubfieldId(catalogTemplateSubfield.getCatalogTemplateSubfieldId());
		catalogTemplateSubfieldImpl.setCatalogTemplateTagId(catalogTemplateSubfield.getCatalogTemplateTagId());
		catalogTemplateSubfieldImpl.setSubfield(catalogTemplateSubfield.getSubfield());
		catalogTemplateSubfieldImpl.setGroupId(catalogTemplateSubfield.getGroupId());
		catalogTemplateSubfieldImpl.setCompanyId(catalogTemplateSubfield.getCompanyId());
		catalogTemplateSubfieldImpl.setRepeatable(catalogTemplateSubfield.isRepeatable());
		catalogTemplateSubfieldImpl.setMandatory(catalogTemplateSubfield.isMandatory());
		catalogTemplateSubfieldImpl.setIsURL(catalogTemplateSubfield.isIsURL());

		return catalogTemplateSubfieldImpl;
	}

	/**
	 * Returns the catalog template subfield with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the catalog template subfield
	 * @return the catalog template subfield
	 * @throws com.kencana.lms.NoSuchCatalogTemplateSubfieldException if a catalog template subfield with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogTemplateSubfield findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCatalogTemplateSubfieldException, SystemException {
		CatalogTemplateSubfield catalogTemplateSubfield = fetchByPrimaryKey(primaryKey);

		if (catalogTemplateSubfield == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCatalogTemplateSubfieldException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return catalogTemplateSubfield;
	}

	/**
	 * Returns the catalog template subfield with the primary key or throws a {@link com.kencana.lms.NoSuchCatalogTemplateSubfieldException} if it could not be found.
	 *
	 * @param catalogTemplateSubfieldId the primary key of the catalog template subfield
	 * @return the catalog template subfield
	 * @throws com.kencana.lms.NoSuchCatalogTemplateSubfieldException if a catalog template subfield with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogTemplateSubfield findByPrimaryKey(
		long catalogTemplateSubfieldId)
		throws NoSuchCatalogTemplateSubfieldException, SystemException {
		return findByPrimaryKey((Serializable)catalogTemplateSubfieldId);
	}

	/**
	 * Returns the catalog template subfield with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the catalog template subfield
	 * @return the catalog template subfield, or <code>null</code> if a catalog template subfield with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogTemplateSubfield fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CatalogTemplateSubfield catalogTemplateSubfield = (CatalogTemplateSubfield)EntityCacheUtil.getResult(CatalogTemplateSubfieldModelImpl.ENTITY_CACHE_ENABLED,
				CatalogTemplateSubfieldImpl.class, primaryKey);

		if (catalogTemplateSubfield == _nullCatalogTemplateSubfield) {
			return null;
		}

		if (catalogTemplateSubfield == null) {
			Session session = null;

			try {
				session = openSession();

				catalogTemplateSubfield = (CatalogTemplateSubfield)session.get(CatalogTemplateSubfieldImpl.class,
						primaryKey);

				if (catalogTemplateSubfield != null) {
					cacheResult(catalogTemplateSubfield);
				}
				else {
					EntityCacheUtil.putResult(CatalogTemplateSubfieldModelImpl.ENTITY_CACHE_ENABLED,
						CatalogTemplateSubfieldImpl.class, primaryKey,
						_nullCatalogTemplateSubfield);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CatalogTemplateSubfieldModelImpl.ENTITY_CACHE_ENABLED,
					CatalogTemplateSubfieldImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return catalogTemplateSubfield;
	}

	/**
	 * Returns the catalog template subfield with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param catalogTemplateSubfieldId the primary key of the catalog template subfield
	 * @return the catalog template subfield, or <code>null</code> if a catalog template subfield with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogTemplateSubfield fetchByPrimaryKey(
		long catalogTemplateSubfieldId) throws SystemException {
		return fetchByPrimaryKey((Serializable)catalogTemplateSubfieldId);
	}

	/**
	 * Returns all the catalog template subfields.
	 *
	 * @return the catalog template subfields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogTemplateSubfield> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the catalog template subfields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogTemplateSubfieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of catalog template subfields
	 * @param end the upper bound of the range of catalog template subfields (not inclusive)
	 * @return the range of catalog template subfields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogTemplateSubfield> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the catalog template subfields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogTemplateSubfieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of catalog template subfields
	 * @param end the upper bound of the range of catalog template subfields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of catalog template subfields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogTemplateSubfield> findAll(int start, int end,
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

		List<CatalogTemplateSubfield> list = (List<CatalogTemplateSubfield>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CATALOGTEMPLATESUBFIELD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CATALOGTEMPLATESUBFIELD;

				if (pagination) {
					sql = sql.concat(CatalogTemplateSubfieldModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CatalogTemplateSubfield>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CatalogTemplateSubfield>(list);
				}
				else {
					list = (List<CatalogTemplateSubfield>)QueryUtil.list(q,
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
	 * Removes all the catalog template subfields from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CatalogTemplateSubfield catalogTemplateSubfield : findAll()) {
			remove(catalogTemplateSubfield);
		}
	}

	/**
	 * Returns the number of catalog template subfields.
	 *
	 * @return the number of catalog template subfields
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

				Query q = session.createQuery(_SQL_COUNT_CATALOGTEMPLATESUBFIELD);

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
	 * Initializes the catalog template subfield persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.kencana.lms.model.CatalogTemplateSubfield")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CatalogTemplateSubfield>> listenersList = new ArrayList<ModelListener<CatalogTemplateSubfield>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CatalogTemplateSubfield>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CatalogTemplateSubfieldImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CATALOGTEMPLATESUBFIELD = "SELECT catalogTemplateSubfield FROM CatalogTemplateSubfield catalogTemplateSubfield";
	private static final String _SQL_SELECT_CATALOGTEMPLATESUBFIELD_WHERE = "SELECT catalogTemplateSubfield FROM CatalogTemplateSubfield catalogTemplateSubfield WHERE ";
	private static final String _SQL_COUNT_CATALOGTEMPLATESUBFIELD = "SELECT COUNT(catalogTemplateSubfield) FROM CatalogTemplateSubfield catalogTemplateSubfield";
	private static final String _SQL_COUNT_CATALOGTEMPLATESUBFIELD_WHERE = "SELECT COUNT(catalogTemplateSubfield) FROM CatalogTemplateSubfield catalogTemplateSubfield WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "catalogTemplateSubfield.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CatalogTemplateSubfield exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CatalogTemplateSubfield exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CatalogTemplateSubfieldPersistenceImpl.class);
	private static CatalogTemplateSubfield _nullCatalogTemplateSubfield = new CatalogTemplateSubfieldImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CatalogTemplateSubfield> toCacheModel() {
				return _nullCatalogTemplateSubfieldCacheModel;
			}
		};

	private static CacheModel<CatalogTemplateSubfield> _nullCatalogTemplateSubfieldCacheModel =
		new CacheModel<CatalogTemplateSubfield>() {
			@Override
			public CatalogTemplateSubfield toEntityModel() {
				return _nullCatalogTemplateSubfield;
			}
		};
}