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

import com.kencana.lms.NoSuchItemCategoryException;
import com.kencana.lms.model.ItemCategory;
import com.kencana.lms.model.impl.ItemCategoryImpl;
import com.kencana.lms.model.impl.ItemCategoryModelImpl;

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
 * The persistence implementation for the item category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemCategoryPersistence
 * @see ItemCategoryUtil
 * @generated
 */
public class ItemCategoryPersistenceImpl extends BasePersistenceImpl<ItemCategory>
	implements ItemCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ItemCategoryUtil} to access the item category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ItemCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ItemCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ItemCategoryModelImpl.FINDER_CACHE_ENABLED, ItemCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ItemCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ItemCategoryModelImpl.FINDER_CACHE_ENABLED, ItemCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ItemCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ItemCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPCOMPANY =
		new FinderPath(ItemCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ItemCategoryModelImpl.FINDER_CACHE_ENABLED, ItemCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCOMPANY =
		new FinderPath(ItemCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ItemCategoryModelImpl.FINDER_CACHE_ENABLED, ItemCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupCompany",
			new String[] { Long.class.getName(), Long.class.getName() },
			ItemCategoryModelImpl.COMPANYID_COLUMN_BITMASK |
			ItemCategoryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPCOMPANY = new FinderPath(ItemCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ItemCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupCompany",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the item categories where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching item categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemCategory> findByGroupCompany(long companyId, long groupId)
		throws SystemException {
		return findByGroupCompany(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the item categories where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.ItemCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of item categories
	 * @param end the upper bound of the range of item categories (not inclusive)
	 * @return the range of matching item categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemCategory> findByGroupCompany(long companyId, long groupId,
		int start, int end) throws SystemException {
		return findByGroupCompany(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the item categories where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.ItemCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of item categories
	 * @param end the upper bound of the range of item categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching item categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemCategory> findByGroupCompany(long companyId, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCOMPANY;
			finderArgs = new Object[] { companyId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPCOMPANY;
			finderArgs = new Object[] {
					companyId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<ItemCategory> list = (List<ItemCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ItemCategory itemCategory : list) {
				if ((companyId != itemCategory.getCompanyId()) ||
						(groupId != itemCategory.getGroupId())) {
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

			query.append(_SQL_SELECT_ITEMCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_GROUPCOMPANY_COMPANYID_2);

			query.append(_FINDER_COLUMN_GROUPCOMPANY_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ItemCategoryModelImpl.ORDER_BY_JPQL);
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
					list = (List<ItemCategory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ItemCategory>(list);
				}
				else {
					list = (List<ItemCategory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first item category in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching item category
	 * @throws com.kencana.lms.NoSuchItemCategoryException if a matching item category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemCategory findByGroupCompany_First(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchItemCategoryException, SystemException {
		ItemCategory itemCategory = fetchByGroupCompany_First(companyId,
				groupId, orderByComparator);

		if (itemCategory != null) {
			return itemCategory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemCategoryException(msg.toString());
	}

	/**
	 * Returns the first item category in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching item category, or <code>null</code> if a matching item category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemCategory fetchByGroupCompany_First(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ItemCategory> list = findByGroupCompany(companyId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last item category in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching item category
	 * @throws com.kencana.lms.NoSuchItemCategoryException if a matching item category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemCategory findByGroupCompany_Last(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchItemCategoryException, SystemException {
		ItemCategory itemCategory = fetchByGroupCompany_Last(companyId,
				groupId, orderByComparator);

		if (itemCategory != null) {
			return itemCategory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemCategoryException(msg.toString());
	}

	/**
	 * Returns the last item category in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching item category, or <code>null</code> if a matching item category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemCategory fetchByGroupCompany_Last(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupCompany(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<ItemCategory> list = findByGroupCompany(companyId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the item categories before and after the current item category in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param itemCategoryId the primary key of the current item category
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next item category
	 * @throws com.kencana.lms.NoSuchItemCategoryException if a item category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemCategory[] findByGroupCompany_PrevAndNext(long itemCategoryId,
		long companyId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchItemCategoryException, SystemException {
		ItemCategory itemCategory = findByPrimaryKey(itemCategoryId);

		Session session = null;

		try {
			session = openSession();

			ItemCategory[] array = new ItemCategoryImpl[3];

			array[0] = getByGroupCompany_PrevAndNext(session, itemCategory,
					companyId, groupId, orderByComparator, true);

			array[1] = itemCategory;

			array[2] = getByGroupCompany_PrevAndNext(session, itemCategory,
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

	protected ItemCategory getByGroupCompany_PrevAndNext(Session session,
		ItemCategory itemCategory, long companyId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ITEMCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_GROUPCOMPANY_COMPANYID_2);

		query.append(_FINDER_COLUMN_GROUPCOMPANY_GROUPID_2);

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
			query.append(ItemCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(itemCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ItemCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the item categories where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupCompany(long companyId, long groupId)
		throws SystemException {
		for (ItemCategory itemCategory : findByGroupCompany(companyId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(itemCategory);
		}
	}

	/**
	 * Returns the number of item categories where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching item categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupCompany(long companyId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPCOMPANY;

		Object[] finderArgs = new Object[] { companyId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ITEMCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_GROUPCOMPANY_COMPANYID_2);

			query.append(_FINDER_COLUMN_GROUPCOMPANY_GROUPID_2);

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

	private static final String _FINDER_COLUMN_GROUPCOMPANY_COMPANYID_2 = "itemCategory.companyId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPCOMPANY_GROUPID_2 = "itemCategory.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(ItemCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ItemCategoryModelImpl.FINDER_CACHE_ENABLED, ItemCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(ItemCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ItemCategoryModelImpl.FINDER_CACHE_ENABLED, ItemCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			ItemCategoryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(ItemCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ItemCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the item categories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching item categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemCategory> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the item categories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.ItemCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of item categories
	 * @param end the upper bound of the range of item categories (not inclusive)
	 * @return the range of matching item categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemCategory> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the item categories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.ItemCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of item categories
	 * @param end the upper bound of the range of item categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching item categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemCategory> findByGroup(long groupId, int start, int end,
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

		List<ItemCategory> list = (List<ItemCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ItemCategory itemCategory : list) {
				if ((groupId != itemCategory.getGroupId())) {
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

			query.append(_SQL_SELECT_ITEMCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ItemCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ItemCategory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ItemCategory>(list);
				}
				else {
					list = (List<ItemCategory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first item category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching item category
	 * @throws com.kencana.lms.NoSuchItemCategoryException if a matching item category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemCategory findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchItemCategoryException, SystemException {
		ItemCategory itemCategory = fetchByGroup_First(groupId,
				orderByComparator);

		if (itemCategory != null) {
			return itemCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemCategoryException(msg.toString());
	}

	/**
	 * Returns the first item category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching item category, or <code>null</code> if a matching item category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemCategory fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ItemCategory> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last item category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching item category
	 * @throws com.kencana.lms.NoSuchItemCategoryException if a matching item category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemCategory findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchItemCategoryException, SystemException {
		ItemCategory itemCategory = fetchByGroup_Last(groupId, orderByComparator);

		if (itemCategory != null) {
			return itemCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemCategoryException(msg.toString());
	}

	/**
	 * Returns the last item category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching item category, or <code>null</code> if a matching item category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemCategory fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		if (count == 0) {
			return null;
		}

		List<ItemCategory> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the item categories before and after the current item category in the ordered set where groupId = &#63;.
	 *
	 * @param itemCategoryId the primary key of the current item category
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next item category
	 * @throws com.kencana.lms.NoSuchItemCategoryException if a item category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemCategory[] findByGroup_PrevAndNext(long itemCategoryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchItemCategoryException, SystemException {
		ItemCategory itemCategory = findByPrimaryKey(itemCategoryId);

		Session session = null;

		try {
			session = openSession();

			ItemCategory[] array = new ItemCategoryImpl[3];

			array[0] = getByGroup_PrevAndNext(session, itemCategory, groupId,
					orderByComparator, true);

			array[1] = itemCategory;

			array[2] = getByGroup_PrevAndNext(session, itemCategory, groupId,
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

	protected ItemCategory getByGroup_PrevAndNext(Session session,
		ItemCategory itemCategory, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ITEMCATEGORY_WHERE);

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
			query.append(ItemCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(itemCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ItemCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the item categories where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroup(long groupId) throws SystemException {
		for (ItemCategory itemCategory : findByGroup(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(itemCategory);
		}
	}

	/**
	 * Returns the number of item categories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching item categories
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

			query.append(_SQL_COUNT_ITEMCATEGORY_WHERE);

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

	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "itemCategory.groupId = ?";

	public ItemCategoryPersistenceImpl() {
		setModelClass(ItemCategory.class);
	}

	/**
	 * Caches the item category in the entity cache if it is enabled.
	 *
	 * @param itemCategory the item category
	 */
	@Override
	public void cacheResult(ItemCategory itemCategory) {
		EntityCacheUtil.putResult(ItemCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ItemCategoryImpl.class, itemCategory.getPrimaryKey(), itemCategory);

		itemCategory.resetOriginalValues();
	}

	/**
	 * Caches the item categories in the entity cache if it is enabled.
	 *
	 * @param itemCategories the item categories
	 */
	@Override
	public void cacheResult(List<ItemCategory> itemCategories) {
		for (ItemCategory itemCategory : itemCategories) {
			if (EntityCacheUtil.getResult(
						ItemCategoryModelImpl.ENTITY_CACHE_ENABLED,
						ItemCategoryImpl.class, itemCategory.getPrimaryKey()) == null) {
				cacheResult(itemCategory);
			}
			else {
				itemCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all item categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ItemCategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ItemCategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the item category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ItemCategory itemCategory) {
		EntityCacheUtil.removeResult(ItemCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ItemCategoryImpl.class, itemCategory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ItemCategory> itemCategories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ItemCategory itemCategory : itemCategories) {
			EntityCacheUtil.removeResult(ItemCategoryModelImpl.ENTITY_CACHE_ENABLED,
				ItemCategoryImpl.class, itemCategory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new item category with the primary key. Does not add the item category to the database.
	 *
	 * @param itemCategoryId the primary key for the new item category
	 * @return the new item category
	 */
	@Override
	public ItemCategory create(long itemCategoryId) {
		ItemCategory itemCategory = new ItemCategoryImpl();

		itemCategory.setNew(true);
		itemCategory.setPrimaryKey(itemCategoryId);

		return itemCategory;
	}

	/**
	 * Removes the item category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param itemCategoryId the primary key of the item category
	 * @return the item category that was removed
	 * @throws com.kencana.lms.NoSuchItemCategoryException if a item category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemCategory remove(long itemCategoryId)
		throws NoSuchItemCategoryException, SystemException {
		return remove((Serializable)itemCategoryId);
	}

	/**
	 * Removes the item category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the item category
	 * @return the item category that was removed
	 * @throws com.kencana.lms.NoSuchItemCategoryException if a item category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemCategory remove(Serializable primaryKey)
		throws NoSuchItemCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ItemCategory itemCategory = (ItemCategory)session.get(ItemCategoryImpl.class,
					primaryKey);

			if (itemCategory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchItemCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(itemCategory);
		}
		catch (NoSuchItemCategoryException nsee) {
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
	protected ItemCategory removeImpl(ItemCategory itemCategory)
		throws SystemException {
		itemCategory = toUnwrappedModel(itemCategory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(itemCategory)) {
				itemCategory = (ItemCategory)session.get(ItemCategoryImpl.class,
						itemCategory.getPrimaryKeyObj());
			}

			if (itemCategory != null) {
				session.delete(itemCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (itemCategory != null) {
			clearCache(itemCategory);
		}

		return itemCategory;
	}

	@Override
	public ItemCategory updateImpl(
		com.kencana.lms.model.ItemCategory itemCategory)
		throws SystemException {
		itemCategory = toUnwrappedModel(itemCategory);

		boolean isNew = itemCategory.isNew();

		ItemCategoryModelImpl itemCategoryModelImpl = (ItemCategoryModelImpl)itemCategory;

		Session session = null;

		try {
			session = openSession();

			if (itemCategory.isNew()) {
				session.save(itemCategory);

				itemCategory.setNew(false);
			}
			else {
				session.merge(itemCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ItemCategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((itemCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						itemCategoryModelImpl.getOriginalCompanyId(),
						itemCategoryModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCOMPANY,
					args);

				args = new Object[] {
						itemCategoryModelImpl.getCompanyId(),
						itemCategoryModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCOMPANY,
					args);
			}

			if ((itemCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						itemCategoryModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] { itemCategoryModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(ItemCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ItemCategoryImpl.class, itemCategory.getPrimaryKey(), itemCategory);

		return itemCategory;
	}

	protected ItemCategory toUnwrappedModel(ItemCategory itemCategory) {
		if (itemCategory instanceof ItemCategoryImpl) {
			return itemCategory;
		}

		ItemCategoryImpl itemCategoryImpl = new ItemCategoryImpl();

		itemCategoryImpl.setNew(itemCategory.isNew());
		itemCategoryImpl.setPrimaryKey(itemCategory.getPrimaryKey());

		itemCategoryImpl.setItemCategoryId(itemCategory.getItemCategoryId());
		itemCategoryImpl.setItemCategoryName(itemCategory.getItemCategoryName());
		itemCategoryImpl.setGroupId(itemCategory.getGroupId());
		itemCategoryImpl.setCompanyId(itemCategory.getCompanyId());
		itemCategoryImpl.setCreateDate(itemCategory.getCreateDate());
		itemCategoryImpl.setUserId(itemCategory.getUserId());
		itemCategoryImpl.setModifiedDate(itemCategory.getModifiedDate());

		return itemCategoryImpl;
	}

	/**
	 * Returns the item category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the item category
	 * @return the item category
	 * @throws com.kencana.lms.NoSuchItemCategoryException if a item category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchItemCategoryException, SystemException {
		ItemCategory itemCategory = fetchByPrimaryKey(primaryKey);

		if (itemCategory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchItemCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return itemCategory;
	}

	/**
	 * Returns the item category with the primary key or throws a {@link com.kencana.lms.NoSuchItemCategoryException} if it could not be found.
	 *
	 * @param itemCategoryId the primary key of the item category
	 * @return the item category
	 * @throws com.kencana.lms.NoSuchItemCategoryException if a item category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemCategory findByPrimaryKey(long itemCategoryId)
		throws NoSuchItemCategoryException, SystemException {
		return findByPrimaryKey((Serializable)itemCategoryId);
	}

	/**
	 * Returns the item category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the item category
	 * @return the item category, or <code>null</code> if a item category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemCategory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ItemCategory itemCategory = (ItemCategory)EntityCacheUtil.getResult(ItemCategoryModelImpl.ENTITY_CACHE_ENABLED,
				ItemCategoryImpl.class, primaryKey);

		if (itemCategory == _nullItemCategory) {
			return null;
		}

		if (itemCategory == null) {
			Session session = null;

			try {
				session = openSession();

				itemCategory = (ItemCategory)session.get(ItemCategoryImpl.class,
						primaryKey);

				if (itemCategory != null) {
					cacheResult(itemCategory);
				}
				else {
					EntityCacheUtil.putResult(ItemCategoryModelImpl.ENTITY_CACHE_ENABLED,
						ItemCategoryImpl.class, primaryKey, _nullItemCategory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ItemCategoryModelImpl.ENTITY_CACHE_ENABLED,
					ItemCategoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return itemCategory;
	}

	/**
	 * Returns the item category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param itemCategoryId the primary key of the item category
	 * @return the item category, or <code>null</code> if a item category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemCategory fetchByPrimaryKey(long itemCategoryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)itemCategoryId);
	}

	/**
	 * Returns all the item categories.
	 *
	 * @return the item categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemCategory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the item categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.ItemCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of item categories
	 * @param end the upper bound of the range of item categories (not inclusive)
	 * @return the range of item categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemCategory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the item categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.ItemCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of item categories
	 * @param end the upper bound of the range of item categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of item categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemCategory> findAll(int start, int end,
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

		List<ItemCategory> list = (List<ItemCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ITEMCATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ITEMCATEGORY;

				if (pagination) {
					sql = sql.concat(ItemCategoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ItemCategory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ItemCategory>(list);
				}
				else {
					list = (List<ItemCategory>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the item categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ItemCategory itemCategory : findAll()) {
			remove(itemCategory);
		}
	}

	/**
	 * Returns the number of item categories.
	 *
	 * @return the number of item categories
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

				Query q = session.createQuery(_SQL_COUNT_ITEMCATEGORY);

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
	 * Initializes the item category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.kencana.lms.model.ItemCategory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ItemCategory>> listenersList = new ArrayList<ModelListener<ItemCategory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ItemCategory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ItemCategoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ITEMCATEGORY = "SELECT itemCategory FROM ItemCategory itemCategory";
	private static final String _SQL_SELECT_ITEMCATEGORY_WHERE = "SELECT itemCategory FROM ItemCategory itemCategory WHERE ";
	private static final String _SQL_COUNT_ITEMCATEGORY = "SELECT COUNT(itemCategory) FROM ItemCategory itemCategory";
	private static final String _SQL_COUNT_ITEMCATEGORY_WHERE = "SELECT COUNT(itemCategory) FROM ItemCategory itemCategory WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "itemCategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ItemCategory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ItemCategory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ItemCategoryPersistenceImpl.class);
	private static ItemCategory _nullItemCategory = new ItemCategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ItemCategory> toCacheModel() {
				return _nullItemCategoryCacheModel;
			}
		};

	private static CacheModel<ItemCategory> _nullItemCategoryCacheModel = new CacheModel<ItemCategory>() {
			@Override
			public ItemCategory toEntityModel() {
				return _nullItemCategory;
			}
		};
}