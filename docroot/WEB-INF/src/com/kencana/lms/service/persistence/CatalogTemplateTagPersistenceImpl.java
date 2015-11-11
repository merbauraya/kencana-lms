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

import com.kencana.lms.NoSuchCatalogTemplateTagException;
import com.kencana.lms.model.CatalogTemplateTag;
import com.kencana.lms.model.impl.CatalogTemplateTagImpl;
import com.kencana.lms.model.impl.CatalogTemplateTagModelImpl;

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
 * The persistence implementation for the catalog template tag service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see CatalogTemplateTagPersistence
 * @see CatalogTemplateTagUtil
 * @generated
 */
public class CatalogTemplateTagPersistenceImpl extends BasePersistenceImpl<CatalogTemplateTag>
	implements CatalogTemplateTagPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CatalogTemplateTagUtil} to access the catalog template tag persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CatalogTemplateTagImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CatalogTemplateTagModelImpl.ENTITY_CACHE_ENABLED,
			CatalogTemplateTagModelImpl.FINDER_CACHE_ENABLED,
			CatalogTemplateTagImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CatalogTemplateTagModelImpl.ENTITY_CACHE_ENABLED,
			CatalogTemplateTagModelImpl.FINDER_CACHE_ENABLED,
			CatalogTemplateTagImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CatalogTemplateTagModelImpl.ENTITY_CACHE_ENABLED,
			CatalogTemplateTagModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TEMPLATE = new FinderPath(CatalogTemplateTagModelImpl.ENTITY_CACHE_ENABLED,
			CatalogTemplateTagModelImpl.FINDER_CACHE_ENABLED,
			CatalogTemplateTagImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTemplate",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATE =
		new FinderPath(CatalogTemplateTagModelImpl.ENTITY_CACHE_ENABLED,
			CatalogTemplateTagModelImpl.FINDER_CACHE_ENABLED,
			CatalogTemplateTagImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTemplate",
			new String[] { Long.class.getName() },
			CatalogTemplateTagModelImpl.CATELOGTEMPLATEID_COLUMN_BITMASK |
			CatalogTemplateTagModelImpl.TAG_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TEMPLATE = new FinderPath(CatalogTemplateTagModelImpl.ENTITY_CACHE_ENABLED,
			CatalogTemplateTagModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTemplate",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the catalog template tags where catelogTemplateId = &#63;.
	 *
	 * @param catelogTemplateId the catelog template ID
	 * @return the matching catalog template tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogTemplateTag> findByTemplate(long catelogTemplateId)
		throws SystemException {
		return findByTemplate(catelogTemplateId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the catalog template tags where catelogTemplateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogTemplateTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param catelogTemplateId the catelog template ID
	 * @param start the lower bound of the range of catalog template tags
	 * @param end the upper bound of the range of catalog template tags (not inclusive)
	 * @return the range of matching catalog template tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogTemplateTag> findByTemplate(long catelogTemplateId,
		int start, int end) throws SystemException {
		return findByTemplate(catelogTemplateId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the catalog template tags where catelogTemplateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogTemplateTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param catelogTemplateId the catelog template ID
	 * @param start the lower bound of the range of catalog template tags
	 * @param end the upper bound of the range of catalog template tags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching catalog template tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogTemplateTag> findByTemplate(long catelogTemplateId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATE;
			finderArgs = new Object[] { catelogTemplateId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TEMPLATE;
			finderArgs = new Object[] {
					catelogTemplateId,
					
					start, end, orderByComparator
				};
		}

		List<CatalogTemplateTag> list = (List<CatalogTemplateTag>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CatalogTemplateTag catalogTemplateTag : list) {
				if ((catelogTemplateId != catalogTemplateTag.getCatelogTemplateId())) {
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

			query.append(_SQL_SELECT_CATALOGTEMPLATETAG_WHERE);

			query.append(_FINDER_COLUMN_TEMPLATE_CATELOGTEMPLATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CatalogTemplateTagModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(catelogTemplateId);

				if (!pagination) {
					list = (List<CatalogTemplateTag>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CatalogTemplateTag>(list);
				}
				else {
					list = (List<CatalogTemplateTag>)QueryUtil.list(q,
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
	 * Returns the first catalog template tag in the ordered set where catelogTemplateId = &#63;.
	 *
	 * @param catelogTemplateId the catelog template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog template tag
	 * @throws com.kencana.lms.NoSuchCatalogTemplateTagException if a matching catalog template tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogTemplateTag findByTemplate_First(long catelogTemplateId,
		OrderByComparator orderByComparator)
		throws NoSuchCatalogTemplateTagException, SystemException {
		CatalogTemplateTag catalogTemplateTag = fetchByTemplate_First(catelogTemplateId,
				orderByComparator);

		if (catalogTemplateTag != null) {
			return catalogTemplateTag;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("catelogTemplateId=");
		msg.append(catelogTemplateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCatalogTemplateTagException(msg.toString());
	}

	/**
	 * Returns the first catalog template tag in the ordered set where catelogTemplateId = &#63;.
	 *
	 * @param catelogTemplateId the catelog template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching catalog template tag, or <code>null</code> if a matching catalog template tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogTemplateTag fetchByTemplate_First(long catelogTemplateId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CatalogTemplateTag> list = findByTemplate(catelogTemplateId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last catalog template tag in the ordered set where catelogTemplateId = &#63;.
	 *
	 * @param catelogTemplateId the catelog template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog template tag
	 * @throws com.kencana.lms.NoSuchCatalogTemplateTagException if a matching catalog template tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogTemplateTag findByTemplate_Last(long catelogTemplateId,
		OrderByComparator orderByComparator)
		throws NoSuchCatalogTemplateTagException, SystemException {
		CatalogTemplateTag catalogTemplateTag = fetchByTemplate_Last(catelogTemplateId,
				orderByComparator);

		if (catalogTemplateTag != null) {
			return catalogTemplateTag;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("catelogTemplateId=");
		msg.append(catelogTemplateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCatalogTemplateTagException(msg.toString());
	}

	/**
	 * Returns the last catalog template tag in the ordered set where catelogTemplateId = &#63;.
	 *
	 * @param catelogTemplateId the catelog template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching catalog template tag, or <code>null</code> if a matching catalog template tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogTemplateTag fetchByTemplate_Last(long catelogTemplateId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTemplate(catelogTemplateId);

		if (count == 0) {
			return null;
		}

		List<CatalogTemplateTag> list = findByTemplate(catelogTemplateId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the catalog template tags before and after the current catalog template tag in the ordered set where catelogTemplateId = &#63;.
	 *
	 * @param catelogTemplateTagId the primary key of the current catalog template tag
	 * @param catelogTemplateId the catelog template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next catalog template tag
	 * @throws com.kencana.lms.NoSuchCatalogTemplateTagException if a catalog template tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogTemplateTag[] findByTemplate_PrevAndNext(
		long catelogTemplateTagId, long catelogTemplateId,
		OrderByComparator orderByComparator)
		throws NoSuchCatalogTemplateTagException, SystemException {
		CatalogTemplateTag catalogTemplateTag = findByPrimaryKey(catelogTemplateTagId);

		Session session = null;

		try {
			session = openSession();

			CatalogTemplateTag[] array = new CatalogTemplateTagImpl[3];

			array[0] = getByTemplate_PrevAndNext(session, catalogTemplateTag,
					catelogTemplateId, orderByComparator, true);

			array[1] = catalogTemplateTag;

			array[2] = getByTemplate_PrevAndNext(session, catalogTemplateTag,
					catelogTemplateId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CatalogTemplateTag getByTemplate_PrevAndNext(Session session,
		CatalogTemplateTag catalogTemplateTag, long catelogTemplateId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CATALOGTEMPLATETAG_WHERE);

		query.append(_FINDER_COLUMN_TEMPLATE_CATELOGTEMPLATEID_2);

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
			query.append(CatalogTemplateTagModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(catelogTemplateId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(catalogTemplateTag);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CatalogTemplateTag> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the catalog template tags where catelogTemplateId = &#63; from the database.
	 *
	 * @param catelogTemplateId the catelog template ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTemplate(long catelogTemplateId)
		throws SystemException {
		for (CatalogTemplateTag catalogTemplateTag : findByTemplate(
				catelogTemplateId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(catalogTemplateTag);
		}
	}

	/**
	 * Returns the number of catalog template tags where catelogTemplateId = &#63;.
	 *
	 * @param catelogTemplateId the catelog template ID
	 * @return the number of matching catalog template tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTemplate(long catelogTemplateId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TEMPLATE;

		Object[] finderArgs = new Object[] { catelogTemplateId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CATALOGTEMPLATETAG_WHERE);

			query.append(_FINDER_COLUMN_TEMPLATE_CATELOGTEMPLATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(catelogTemplateId);

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

	private static final String _FINDER_COLUMN_TEMPLATE_CATELOGTEMPLATEID_2 = "catalogTemplateTag.catelogTemplateId = ?";

	public CatalogTemplateTagPersistenceImpl() {
		setModelClass(CatalogTemplateTag.class);
	}

	/**
	 * Caches the catalog template tag in the entity cache if it is enabled.
	 *
	 * @param catalogTemplateTag the catalog template tag
	 */
	@Override
	public void cacheResult(CatalogTemplateTag catalogTemplateTag) {
		EntityCacheUtil.putResult(CatalogTemplateTagModelImpl.ENTITY_CACHE_ENABLED,
			CatalogTemplateTagImpl.class, catalogTemplateTag.getPrimaryKey(),
			catalogTemplateTag);

		catalogTemplateTag.resetOriginalValues();
	}

	/**
	 * Caches the catalog template tags in the entity cache if it is enabled.
	 *
	 * @param catalogTemplateTags the catalog template tags
	 */
	@Override
	public void cacheResult(List<CatalogTemplateTag> catalogTemplateTags) {
		for (CatalogTemplateTag catalogTemplateTag : catalogTemplateTags) {
			if (EntityCacheUtil.getResult(
						CatalogTemplateTagModelImpl.ENTITY_CACHE_ENABLED,
						CatalogTemplateTagImpl.class,
						catalogTemplateTag.getPrimaryKey()) == null) {
				cacheResult(catalogTemplateTag);
			}
			else {
				catalogTemplateTag.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all catalog template tags.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CatalogTemplateTagImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CatalogTemplateTagImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the catalog template tag.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CatalogTemplateTag catalogTemplateTag) {
		EntityCacheUtil.removeResult(CatalogTemplateTagModelImpl.ENTITY_CACHE_ENABLED,
			CatalogTemplateTagImpl.class, catalogTemplateTag.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CatalogTemplateTag> catalogTemplateTags) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CatalogTemplateTag catalogTemplateTag : catalogTemplateTags) {
			EntityCacheUtil.removeResult(CatalogTemplateTagModelImpl.ENTITY_CACHE_ENABLED,
				CatalogTemplateTagImpl.class, catalogTemplateTag.getPrimaryKey());
		}
	}

	/**
	 * Creates a new catalog template tag with the primary key. Does not add the catalog template tag to the database.
	 *
	 * @param catelogTemplateTagId the primary key for the new catalog template tag
	 * @return the new catalog template tag
	 */
	@Override
	public CatalogTemplateTag create(long catelogTemplateTagId) {
		CatalogTemplateTag catalogTemplateTag = new CatalogTemplateTagImpl();

		catalogTemplateTag.setNew(true);
		catalogTemplateTag.setPrimaryKey(catelogTemplateTagId);

		return catalogTemplateTag;
	}

	/**
	 * Removes the catalog template tag with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param catelogTemplateTagId the primary key of the catalog template tag
	 * @return the catalog template tag that was removed
	 * @throws com.kencana.lms.NoSuchCatalogTemplateTagException if a catalog template tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogTemplateTag remove(long catelogTemplateTagId)
		throws NoSuchCatalogTemplateTagException, SystemException {
		return remove((Serializable)catelogTemplateTagId);
	}

	/**
	 * Removes the catalog template tag with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the catalog template tag
	 * @return the catalog template tag that was removed
	 * @throws com.kencana.lms.NoSuchCatalogTemplateTagException if a catalog template tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogTemplateTag remove(Serializable primaryKey)
		throws NoSuchCatalogTemplateTagException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CatalogTemplateTag catalogTemplateTag = (CatalogTemplateTag)session.get(CatalogTemplateTagImpl.class,
					primaryKey);

			if (catalogTemplateTag == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCatalogTemplateTagException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(catalogTemplateTag);
		}
		catch (NoSuchCatalogTemplateTagException nsee) {
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
	protected CatalogTemplateTag removeImpl(
		CatalogTemplateTag catalogTemplateTag) throws SystemException {
		catalogTemplateTag = toUnwrappedModel(catalogTemplateTag);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(catalogTemplateTag)) {
				catalogTemplateTag = (CatalogTemplateTag)session.get(CatalogTemplateTagImpl.class,
						catalogTemplateTag.getPrimaryKeyObj());
			}

			if (catalogTemplateTag != null) {
				session.delete(catalogTemplateTag);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (catalogTemplateTag != null) {
			clearCache(catalogTemplateTag);
		}

		return catalogTemplateTag;
	}

	@Override
	public CatalogTemplateTag updateImpl(
		com.kencana.lms.model.CatalogTemplateTag catalogTemplateTag)
		throws SystemException {
		catalogTemplateTag = toUnwrappedModel(catalogTemplateTag);

		boolean isNew = catalogTemplateTag.isNew();

		CatalogTemplateTagModelImpl catalogTemplateTagModelImpl = (CatalogTemplateTagModelImpl)catalogTemplateTag;

		Session session = null;

		try {
			session = openSession();

			if (catalogTemplateTag.isNew()) {
				session.save(catalogTemplateTag);

				catalogTemplateTag.setNew(false);
			}
			else {
				session.merge(catalogTemplateTag);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CatalogTemplateTagModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((catalogTemplateTagModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						catalogTemplateTagModelImpl.getOriginalCatelogTemplateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEMPLATE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATE,
					args);

				args = new Object[] {
						catalogTemplateTagModelImpl.getCatelogTemplateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEMPLATE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATE,
					args);
			}
		}

		EntityCacheUtil.putResult(CatalogTemplateTagModelImpl.ENTITY_CACHE_ENABLED,
			CatalogTemplateTagImpl.class, catalogTemplateTag.getPrimaryKey(),
			catalogTemplateTag);

		return catalogTemplateTag;
	}

	protected CatalogTemplateTag toUnwrappedModel(
		CatalogTemplateTag catalogTemplateTag) {
		if (catalogTemplateTag instanceof CatalogTemplateTagImpl) {
			return catalogTemplateTag;
		}

		CatalogTemplateTagImpl catalogTemplateTagImpl = new CatalogTemplateTagImpl();

		catalogTemplateTagImpl.setNew(catalogTemplateTag.isNew());
		catalogTemplateTagImpl.setPrimaryKey(catalogTemplateTag.getPrimaryKey());

		catalogTemplateTagImpl.setCatelogTemplateTagId(catalogTemplateTag.getCatelogTemplateTagId());
		catalogTemplateTagImpl.setCatelogTemplateId(catalogTemplateTag.getCatelogTemplateId());
		catalogTemplateTagImpl.setGroupId(catalogTemplateTag.getGroupId());
		catalogTemplateTagImpl.setCompanyId(catalogTemplateTag.getCompanyId());
		catalogTemplateTagImpl.setTag(catalogTemplateTag.getTag());
		catalogTemplateTagImpl.setRepeatable(catalogTemplateTag.isRepeatable());
		catalogTemplateTagImpl.setMandatory(catalogTemplateTag.isMandatory());
		catalogTemplateTagImpl.setHelpText(catalogTemplateTag.getHelpText());

		return catalogTemplateTagImpl;
	}

	/**
	 * Returns the catalog template tag with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the catalog template tag
	 * @return the catalog template tag
	 * @throws com.kencana.lms.NoSuchCatalogTemplateTagException if a catalog template tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogTemplateTag findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCatalogTemplateTagException, SystemException {
		CatalogTemplateTag catalogTemplateTag = fetchByPrimaryKey(primaryKey);

		if (catalogTemplateTag == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCatalogTemplateTagException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return catalogTemplateTag;
	}

	/**
	 * Returns the catalog template tag with the primary key or throws a {@link com.kencana.lms.NoSuchCatalogTemplateTagException} if it could not be found.
	 *
	 * @param catelogTemplateTagId the primary key of the catalog template tag
	 * @return the catalog template tag
	 * @throws com.kencana.lms.NoSuchCatalogTemplateTagException if a catalog template tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogTemplateTag findByPrimaryKey(long catelogTemplateTagId)
		throws NoSuchCatalogTemplateTagException, SystemException {
		return findByPrimaryKey((Serializable)catelogTemplateTagId);
	}

	/**
	 * Returns the catalog template tag with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the catalog template tag
	 * @return the catalog template tag, or <code>null</code> if a catalog template tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogTemplateTag fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CatalogTemplateTag catalogTemplateTag = (CatalogTemplateTag)EntityCacheUtil.getResult(CatalogTemplateTagModelImpl.ENTITY_CACHE_ENABLED,
				CatalogTemplateTagImpl.class, primaryKey);

		if (catalogTemplateTag == _nullCatalogTemplateTag) {
			return null;
		}

		if (catalogTemplateTag == null) {
			Session session = null;

			try {
				session = openSession();

				catalogTemplateTag = (CatalogTemplateTag)session.get(CatalogTemplateTagImpl.class,
						primaryKey);

				if (catalogTemplateTag != null) {
					cacheResult(catalogTemplateTag);
				}
				else {
					EntityCacheUtil.putResult(CatalogTemplateTagModelImpl.ENTITY_CACHE_ENABLED,
						CatalogTemplateTagImpl.class, primaryKey,
						_nullCatalogTemplateTag);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CatalogTemplateTagModelImpl.ENTITY_CACHE_ENABLED,
					CatalogTemplateTagImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return catalogTemplateTag;
	}

	/**
	 * Returns the catalog template tag with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param catelogTemplateTagId the primary key of the catalog template tag
	 * @return the catalog template tag, or <code>null</code> if a catalog template tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogTemplateTag fetchByPrimaryKey(long catelogTemplateTagId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)catelogTemplateTagId);
	}

	/**
	 * Returns all the catalog template tags.
	 *
	 * @return the catalog template tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogTemplateTag> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the catalog template tags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogTemplateTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of catalog template tags
	 * @param end the upper bound of the range of catalog template tags (not inclusive)
	 * @return the range of catalog template tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogTemplateTag> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the catalog template tags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogTemplateTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of catalog template tags
	 * @param end the upper bound of the range of catalog template tags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of catalog template tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogTemplateTag> findAll(int start, int end,
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

		List<CatalogTemplateTag> list = (List<CatalogTemplateTag>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CATALOGTEMPLATETAG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CATALOGTEMPLATETAG;

				if (pagination) {
					sql = sql.concat(CatalogTemplateTagModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CatalogTemplateTag>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CatalogTemplateTag>(list);
				}
				else {
					list = (List<CatalogTemplateTag>)QueryUtil.list(q,
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
	 * Removes all the catalog template tags from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CatalogTemplateTag catalogTemplateTag : findAll()) {
			remove(catalogTemplateTag);
		}
	}

	/**
	 * Returns the number of catalog template tags.
	 *
	 * @return the number of catalog template tags
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

				Query q = session.createQuery(_SQL_COUNT_CATALOGTEMPLATETAG);

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
	 * Initializes the catalog template tag persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.kencana.lms.model.CatalogTemplateTag")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CatalogTemplateTag>> listenersList = new ArrayList<ModelListener<CatalogTemplateTag>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CatalogTemplateTag>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CatalogTemplateTagImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CATALOGTEMPLATETAG = "SELECT catalogTemplateTag FROM CatalogTemplateTag catalogTemplateTag";
	private static final String _SQL_SELECT_CATALOGTEMPLATETAG_WHERE = "SELECT catalogTemplateTag FROM CatalogTemplateTag catalogTemplateTag WHERE ";
	private static final String _SQL_COUNT_CATALOGTEMPLATETAG = "SELECT COUNT(catalogTemplateTag) FROM CatalogTemplateTag catalogTemplateTag";
	private static final String _SQL_COUNT_CATALOGTEMPLATETAG_WHERE = "SELECT COUNT(catalogTemplateTag) FROM CatalogTemplateTag catalogTemplateTag WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "catalogTemplateTag.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CatalogTemplateTag exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CatalogTemplateTag exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CatalogTemplateTagPersistenceImpl.class);
	private static CatalogTemplateTag _nullCatalogTemplateTag = new CatalogTemplateTagImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CatalogTemplateTag> toCacheModel() {
				return _nullCatalogTemplateTagCacheModel;
			}
		};

	private static CacheModel<CatalogTemplateTag> _nullCatalogTemplateTagCacheModel =
		new CacheModel<CatalogTemplateTag>() {
			@Override
			public CatalogTemplateTag toEntityModel() {
				return _nullCatalogTemplateTag;
			}
		};
}