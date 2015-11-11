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

import com.kencana.lms.NoSuchMarcTagException;
import com.kencana.lms.model.MarcTag;
import com.kencana.lms.model.impl.MarcTagImpl;
import com.kencana.lms.model.impl.MarcTagModelImpl;

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
 * The persistence implementation for the marc tag service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see MarcTagPersistence
 * @see MarcTagUtil
 * @generated
 */
public class MarcTagPersistenceImpl extends BasePersistenceImpl<MarcTag>
	implements MarcTagPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MarcTagUtil} to access the marc tag persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MarcTagImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MarcTagModelImpl.ENTITY_CACHE_ENABLED,
			MarcTagModelImpl.FINDER_CACHE_ENABLED, MarcTagImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MarcTagModelImpl.ENTITY_CACHE_ENABLED,
			MarcTagModelImpl.FINDER_CACHE_ENABLED, MarcTagImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MarcTagModelImpl.ENTITY_CACHE_ENABLED,
			MarcTagModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_TAGTAGTYPE = new FinderPath(MarcTagModelImpl.ENTITY_CACHE_ENABLED,
			MarcTagModelImpl.FINDER_CACHE_ENABLED, MarcTagImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByTagTagType",
			new String[] { String.class.getName(), String.class.getName() },
			MarcTagModelImpl.TAG_COLUMN_BITMASK |
			MarcTagModelImpl.TAGTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TAGTAGTYPE = new FinderPath(MarcTagModelImpl.ENTITY_CACHE_ENABLED,
			MarcTagModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTagTagType",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns the marc tag where tag = &#63; and tagType = &#63; or throws a {@link com.kencana.lms.NoSuchMarcTagException} if it could not be found.
	 *
	 * @param tag the tag
	 * @param tagType the tag type
	 * @return the matching marc tag
	 * @throws com.kencana.lms.NoSuchMarcTagException if a matching marc tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcTag findByTagTagType(String tag, String tagType)
		throws NoSuchMarcTagException, SystemException {
		MarcTag marcTag = fetchByTagTagType(tag, tagType);

		if (marcTag == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("tag=");
			msg.append(tag);

			msg.append(", tagType=");
			msg.append(tagType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchMarcTagException(msg.toString());
		}

		return marcTag;
	}

	/**
	 * Returns the marc tag where tag = &#63; and tagType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tag the tag
	 * @param tagType the tag type
	 * @return the matching marc tag, or <code>null</code> if a matching marc tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcTag fetchByTagTagType(String tag, String tagType)
		throws SystemException {
		return fetchByTagTagType(tag, tagType, true);
	}

	/**
	 * Returns the marc tag where tag = &#63; and tagType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tag the tag
	 * @param tagType the tag type
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching marc tag, or <code>null</code> if a matching marc tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcTag fetchByTagTagType(String tag, String tagType,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { tag, tagType };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TAGTAGTYPE,
					finderArgs, this);
		}

		if (result instanceof MarcTag) {
			MarcTag marcTag = (MarcTag)result;

			if (!Validator.equals(tag, marcTag.getTag()) ||
					!Validator.equals(tagType, marcTag.getTagType())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_MARCTAG_WHERE);

			boolean bindTag = false;

			if (tag == null) {
				query.append(_FINDER_COLUMN_TAGTAGTYPE_TAG_1);
			}
			else if (tag.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TAGTAGTYPE_TAG_3);
			}
			else {
				bindTag = true;

				query.append(_FINDER_COLUMN_TAGTAGTYPE_TAG_2);
			}

			boolean bindTagType = false;

			if (tagType == null) {
				query.append(_FINDER_COLUMN_TAGTAGTYPE_TAGTYPE_1);
			}
			else if (tagType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TAGTAGTYPE_TAGTYPE_3);
			}
			else {
				bindTagType = true;

				query.append(_FINDER_COLUMN_TAGTAGTYPE_TAGTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTag) {
					qPos.add(tag);
				}

				if (bindTagType) {
					qPos.add(tagType);
				}

				List<MarcTag> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TAGTAGTYPE,
						finderArgs, list);
				}
				else {
					MarcTag marcTag = list.get(0);

					result = marcTag;

					cacheResult(marcTag);

					if ((marcTag.getTag() == null) ||
							!marcTag.getTag().equals(tag) ||
							(marcTag.getTagType() == null) ||
							!marcTag.getTagType().equals(tagType)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TAGTAGTYPE,
							finderArgs, marcTag);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TAGTAGTYPE,
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
			return (MarcTag)result;
		}
	}

	/**
	 * Removes the marc tag where tag = &#63; and tagType = &#63; from the database.
	 *
	 * @param tag the tag
	 * @param tagType the tag type
	 * @return the marc tag that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcTag removeByTagTagType(String tag, String tagType)
		throws NoSuchMarcTagException, SystemException {
		MarcTag marcTag = findByTagTagType(tag, tagType);

		return remove(marcTag);
	}

	/**
	 * Returns the number of marc tags where tag = &#63; and tagType = &#63;.
	 *
	 * @param tag the tag
	 * @param tagType the tag type
	 * @return the number of matching marc tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTagTagType(String tag, String tagType)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TAGTAGTYPE;

		Object[] finderArgs = new Object[] { tag, tagType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MARCTAG_WHERE);

			boolean bindTag = false;

			if (tag == null) {
				query.append(_FINDER_COLUMN_TAGTAGTYPE_TAG_1);
			}
			else if (tag.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TAGTAGTYPE_TAG_3);
			}
			else {
				bindTag = true;

				query.append(_FINDER_COLUMN_TAGTAGTYPE_TAG_2);
			}

			boolean bindTagType = false;

			if (tagType == null) {
				query.append(_FINDER_COLUMN_TAGTAGTYPE_TAGTYPE_1);
			}
			else if (tagType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TAGTAGTYPE_TAGTYPE_3);
			}
			else {
				bindTagType = true;

				query.append(_FINDER_COLUMN_TAGTAGTYPE_TAGTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTag) {
					qPos.add(tag);
				}

				if (bindTagType) {
					qPos.add(tagType);
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

	private static final String _FINDER_COLUMN_TAGTAGTYPE_TAG_1 = "marcTag.tag IS NULL AND ";
	private static final String _FINDER_COLUMN_TAGTAGTYPE_TAG_2 = "marcTag.tag = ? AND ";
	private static final String _FINDER_COLUMN_TAGTAGTYPE_TAG_3 = "(marcTag.tag IS NULL OR marcTag.tag = '') AND ";
	private static final String _FINDER_COLUMN_TAGTAGTYPE_TAGTYPE_1 = "marcTag.tagType IS NULL";
	private static final String _FINDER_COLUMN_TAGTAGTYPE_TAGTYPE_2 = "marcTag.tagType = ?";
	private static final String _FINDER_COLUMN_TAGTAGTYPE_TAGTYPE_3 = "(marcTag.tagType IS NULL OR marcTag.tagType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TAGTYPE = new FinderPath(MarcTagModelImpl.ENTITY_CACHE_ENABLED,
			MarcTagModelImpl.FINDER_CACHE_ENABLED, MarcTagImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTagType",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAGTYPE =
		new FinderPath(MarcTagModelImpl.ENTITY_CACHE_ENABLED,
			MarcTagModelImpl.FINDER_CACHE_ENABLED, MarcTagImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTagType",
			new String[] { String.class.getName() },
			MarcTagModelImpl.TAGTYPE_COLUMN_BITMASK |
			MarcTagModelImpl.TAG_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TAGTYPE = new FinderPath(MarcTagModelImpl.ENTITY_CACHE_ENABLED,
			MarcTagModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTagType",
			new String[] { String.class.getName() });

	/**
	 * Returns all the marc tags where tagType = &#63;.
	 *
	 * @param tagType the tag type
	 * @return the matching marc tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MarcTag> findByTagType(String tagType)
		throws SystemException {
		return findByTagType(tagType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the marc tags where tagType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tagType the tag type
	 * @param start the lower bound of the range of marc tags
	 * @param end the upper bound of the range of marc tags (not inclusive)
	 * @return the range of matching marc tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MarcTag> findByTagType(String tagType, int start, int end)
		throws SystemException {
		return findByTagType(tagType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the marc tags where tagType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tagType the tag type
	 * @param start the lower bound of the range of marc tags
	 * @param end the upper bound of the range of marc tags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching marc tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MarcTag> findByTagType(String tagType, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAGTYPE;
			finderArgs = new Object[] { tagType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TAGTYPE;
			finderArgs = new Object[] { tagType, start, end, orderByComparator };
		}

		List<MarcTag> list = (List<MarcTag>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MarcTag marcTag : list) {
				if (!Validator.equals(tagType, marcTag.getTagType())) {
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

			query.append(_SQL_SELECT_MARCTAG_WHERE);

			boolean bindTagType = false;

			if (tagType == null) {
				query.append(_FINDER_COLUMN_TAGTYPE_TAGTYPE_1);
			}
			else if (tagType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TAGTYPE_TAGTYPE_3);
			}
			else {
				bindTagType = true;

				query.append(_FINDER_COLUMN_TAGTYPE_TAGTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MarcTagModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTagType) {
					qPos.add(tagType);
				}

				if (!pagination) {
					list = (List<MarcTag>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MarcTag>(list);
				}
				else {
					list = (List<MarcTag>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first marc tag in the ordered set where tagType = &#63;.
	 *
	 * @param tagType the tag type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marc tag
	 * @throws com.kencana.lms.NoSuchMarcTagException if a matching marc tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcTag findByTagType_First(String tagType,
		OrderByComparator orderByComparator)
		throws NoSuchMarcTagException, SystemException {
		MarcTag marcTag = fetchByTagType_First(tagType, orderByComparator);

		if (marcTag != null) {
			return marcTag;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tagType=");
		msg.append(tagType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMarcTagException(msg.toString());
	}

	/**
	 * Returns the first marc tag in the ordered set where tagType = &#63;.
	 *
	 * @param tagType the tag type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marc tag, or <code>null</code> if a matching marc tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcTag fetchByTagType_First(String tagType,
		OrderByComparator orderByComparator) throws SystemException {
		List<MarcTag> list = findByTagType(tagType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last marc tag in the ordered set where tagType = &#63;.
	 *
	 * @param tagType the tag type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marc tag
	 * @throws com.kencana.lms.NoSuchMarcTagException if a matching marc tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcTag findByTagType_Last(String tagType,
		OrderByComparator orderByComparator)
		throws NoSuchMarcTagException, SystemException {
		MarcTag marcTag = fetchByTagType_Last(tagType, orderByComparator);

		if (marcTag != null) {
			return marcTag;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tagType=");
		msg.append(tagType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMarcTagException(msg.toString());
	}

	/**
	 * Returns the last marc tag in the ordered set where tagType = &#63;.
	 *
	 * @param tagType the tag type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marc tag, or <code>null</code> if a matching marc tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcTag fetchByTagType_Last(String tagType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTagType(tagType);

		if (count == 0) {
			return null;
		}

		List<MarcTag> list = findByTagType(tagType, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the marc tags before and after the current marc tag in the ordered set where tagType = &#63;.
	 *
	 * @param tagId the primary key of the current marc tag
	 * @param tagType the tag type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next marc tag
	 * @throws com.kencana.lms.NoSuchMarcTagException if a marc tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcTag[] findByTagType_PrevAndNext(long tagId, String tagType,
		OrderByComparator orderByComparator)
		throws NoSuchMarcTagException, SystemException {
		MarcTag marcTag = findByPrimaryKey(tagId);

		Session session = null;

		try {
			session = openSession();

			MarcTag[] array = new MarcTagImpl[3];

			array[0] = getByTagType_PrevAndNext(session, marcTag, tagType,
					orderByComparator, true);

			array[1] = marcTag;

			array[2] = getByTagType_PrevAndNext(session, marcTag, tagType,
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

	protected MarcTag getByTagType_PrevAndNext(Session session,
		MarcTag marcTag, String tagType, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MARCTAG_WHERE);

		boolean bindTagType = false;

		if (tagType == null) {
			query.append(_FINDER_COLUMN_TAGTYPE_TAGTYPE_1);
		}
		else if (tagType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_TAGTYPE_TAGTYPE_3);
		}
		else {
			bindTagType = true;

			query.append(_FINDER_COLUMN_TAGTYPE_TAGTYPE_2);
		}

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
			query.append(MarcTagModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTagType) {
			qPos.add(tagType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(marcTag);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MarcTag> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the marc tags where tagType = &#63; from the database.
	 *
	 * @param tagType the tag type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTagType(String tagType) throws SystemException {
		for (MarcTag marcTag : findByTagType(tagType, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(marcTag);
		}
	}

	/**
	 * Returns the number of marc tags where tagType = &#63;.
	 *
	 * @param tagType the tag type
	 * @return the number of matching marc tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTagType(String tagType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TAGTYPE;

		Object[] finderArgs = new Object[] { tagType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MARCTAG_WHERE);

			boolean bindTagType = false;

			if (tagType == null) {
				query.append(_FINDER_COLUMN_TAGTYPE_TAGTYPE_1);
			}
			else if (tagType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TAGTYPE_TAGTYPE_3);
			}
			else {
				bindTagType = true;

				query.append(_FINDER_COLUMN_TAGTYPE_TAGTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTagType) {
					qPos.add(tagType);
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

	private static final String _FINDER_COLUMN_TAGTYPE_TAGTYPE_1 = "marcTag.tagType IS NULL";
	private static final String _FINDER_COLUMN_TAGTYPE_TAGTYPE_2 = "marcTag.tagType = ?";
	private static final String _FINDER_COLUMN_TAGTYPE_TAGTYPE_3 = "(marcTag.tagType IS NULL OR marcTag.tagType = '')";

	public MarcTagPersistenceImpl() {
		setModelClass(MarcTag.class);
	}

	/**
	 * Caches the marc tag in the entity cache if it is enabled.
	 *
	 * @param marcTag the marc tag
	 */
	@Override
	public void cacheResult(MarcTag marcTag) {
		EntityCacheUtil.putResult(MarcTagModelImpl.ENTITY_CACHE_ENABLED,
			MarcTagImpl.class, marcTag.getPrimaryKey(), marcTag);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TAGTAGTYPE,
			new Object[] { marcTag.getTag(), marcTag.getTagType() }, marcTag);

		marcTag.resetOriginalValues();
	}

	/**
	 * Caches the marc tags in the entity cache if it is enabled.
	 *
	 * @param marcTags the marc tags
	 */
	@Override
	public void cacheResult(List<MarcTag> marcTags) {
		for (MarcTag marcTag : marcTags) {
			if (EntityCacheUtil.getResult(
						MarcTagModelImpl.ENTITY_CACHE_ENABLED,
						MarcTagImpl.class, marcTag.getPrimaryKey()) == null) {
				cacheResult(marcTag);
			}
			else {
				marcTag.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all marc tags.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MarcTagImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MarcTagImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the marc tag.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MarcTag marcTag) {
		EntityCacheUtil.removeResult(MarcTagModelImpl.ENTITY_CACHE_ENABLED,
			MarcTagImpl.class, marcTag.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(marcTag);
	}

	@Override
	public void clearCache(List<MarcTag> marcTags) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MarcTag marcTag : marcTags) {
			EntityCacheUtil.removeResult(MarcTagModelImpl.ENTITY_CACHE_ENABLED,
				MarcTagImpl.class, marcTag.getPrimaryKey());

			clearUniqueFindersCache(marcTag);
		}
	}

	protected void cacheUniqueFindersCache(MarcTag marcTag) {
		if (marcTag.isNew()) {
			Object[] args = new Object[] { marcTag.getTag(), marcTag.getTagType() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TAGTAGTYPE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TAGTAGTYPE, args,
				marcTag);
		}
		else {
			MarcTagModelImpl marcTagModelImpl = (MarcTagModelImpl)marcTag;

			if ((marcTagModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TAGTAGTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						marcTag.getTag(), marcTag.getTagType()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TAGTAGTYPE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TAGTAGTYPE,
					args, marcTag);
			}
		}
	}

	protected void clearUniqueFindersCache(MarcTag marcTag) {
		MarcTagModelImpl marcTagModelImpl = (MarcTagModelImpl)marcTag;

		Object[] args = new Object[] { marcTag.getTag(), marcTag.getTagType() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAGTAGTYPE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TAGTAGTYPE, args);

		if ((marcTagModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TAGTAGTYPE.getColumnBitmask()) != 0) {
			args = new Object[] {
					marcTagModelImpl.getOriginalTag(),
					marcTagModelImpl.getOriginalTagType()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAGTAGTYPE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TAGTAGTYPE, args);
		}
	}

	/**
	 * Creates a new marc tag with the primary key. Does not add the marc tag to the database.
	 *
	 * @param tagId the primary key for the new marc tag
	 * @return the new marc tag
	 */
	@Override
	public MarcTag create(long tagId) {
		MarcTag marcTag = new MarcTagImpl();

		marcTag.setNew(true);
		marcTag.setPrimaryKey(tagId);

		return marcTag;
	}

	/**
	 * Removes the marc tag with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tagId the primary key of the marc tag
	 * @return the marc tag that was removed
	 * @throws com.kencana.lms.NoSuchMarcTagException if a marc tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcTag remove(long tagId)
		throws NoSuchMarcTagException, SystemException {
		return remove((Serializable)tagId);
	}

	/**
	 * Removes the marc tag with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the marc tag
	 * @return the marc tag that was removed
	 * @throws com.kencana.lms.NoSuchMarcTagException if a marc tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcTag remove(Serializable primaryKey)
		throws NoSuchMarcTagException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MarcTag marcTag = (MarcTag)session.get(MarcTagImpl.class, primaryKey);

			if (marcTag == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMarcTagException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(marcTag);
		}
		catch (NoSuchMarcTagException nsee) {
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
	protected MarcTag removeImpl(MarcTag marcTag) throws SystemException {
		marcTag = toUnwrappedModel(marcTag);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(marcTag)) {
				marcTag = (MarcTag)session.get(MarcTagImpl.class,
						marcTag.getPrimaryKeyObj());
			}

			if (marcTag != null) {
				session.delete(marcTag);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (marcTag != null) {
			clearCache(marcTag);
		}

		return marcTag;
	}

	@Override
	public MarcTag updateImpl(com.kencana.lms.model.MarcTag marcTag)
		throws SystemException {
		marcTag = toUnwrappedModel(marcTag);

		boolean isNew = marcTag.isNew();

		MarcTagModelImpl marcTagModelImpl = (MarcTagModelImpl)marcTag;

		Session session = null;

		try {
			session = openSession();

			if (marcTag.isNew()) {
				session.save(marcTag);

				marcTag.setNew(false);
			}
			else {
				session.merge(marcTag);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MarcTagModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((marcTagModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAGTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						marcTagModelImpl.getOriginalTagType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAGTYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAGTYPE,
					args);

				args = new Object[] { marcTagModelImpl.getTagType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAGTYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAGTYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(MarcTagModelImpl.ENTITY_CACHE_ENABLED,
			MarcTagImpl.class, marcTag.getPrimaryKey(), marcTag);

		clearUniqueFindersCache(marcTag);
		cacheUniqueFindersCache(marcTag);

		return marcTag;
	}

	protected MarcTag toUnwrappedModel(MarcTag marcTag) {
		if (marcTag instanceof MarcTagImpl) {
			return marcTag;
		}

		MarcTagImpl marcTagImpl = new MarcTagImpl();

		marcTagImpl.setNew(marcTag.isNew());
		marcTagImpl.setPrimaryKey(marcTag.getPrimaryKey());

		marcTagImpl.setTagId(marcTag.getTagId());
		marcTagImpl.setTag(marcTag.getTag());
		marcTagImpl.setDescription(marcTag.getDescription());
		marcTagImpl.setHelpText(marcTag.getHelpText());
		marcTagImpl.setRepetable(marcTag.isRepetable());
		marcTagImpl.setDefaultValue(marcTag.getDefaultValue());
		marcTagImpl.setIndicator1(marcTag.isIndicator1());
		marcTagImpl.setIndicator2(marcTag.isIndicator2());
		marcTagImpl.setTagType(marcTag.getTagType());

		return marcTagImpl;
	}

	/**
	 * Returns the marc tag with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the marc tag
	 * @return the marc tag
	 * @throws com.kencana.lms.NoSuchMarcTagException if a marc tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcTag findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMarcTagException, SystemException {
		MarcTag marcTag = fetchByPrimaryKey(primaryKey);

		if (marcTag == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMarcTagException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return marcTag;
	}

	/**
	 * Returns the marc tag with the primary key or throws a {@link com.kencana.lms.NoSuchMarcTagException} if it could not be found.
	 *
	 * @param tagId the primary key of the marc tag
	 * @return the marc tag
	 * @throws com.kencana.lms.NoSuchMarcTagException if a marc tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcTag findByPrimaryKey(long tagId)
		throws NoSuchMarcTagException, SystemException {
		return findByPrimaryKey((Serializable)tagId);
	}

	/**
	 * Returns the marc tag with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the marc tag
	 * @return the marc tag, or <code>null</code> if a marc tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcTag fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		MarcTag marcTag = (MarcTag)EntityCacheUtil.getResult(MarcTagModelImpl.ENTITY_CACHE_ENABLED,
				MarcTagImpl.class, primaryKey);

		if (marcTag == _nullMarcTag) {
			return null;
		}

		if (marcTag == null) {
			Session session = null;

			try {
				session = openSession();

				marcTag = (MarcTag)session.get(MarcTagImpl.class, primaryKey);

				if (marcTag != null) {
					cacheResult(marcTag);
				}
				else {
					EntityCacheUtil.putResult(MarcTagModelImpl.ENTITY_CACHE_ENABLED,
						MarcTagImpl.class, primaryKey, _nullMarcTag);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MarcTagModelImpl.ENTITY_CACHE_ENABLED,
					MarcTagImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return marcTag;
	}

	/**
	 * Returns the marc tag with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tagId the primary key of the marc tag
	 * @return the marc tag, or <code>null</code> if a marc tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcTag fetchByPrimaryKey(long tagId) throws SystemException {
		return fetchByPrimaryKey((Serializable)tagId);
	}

	/**
	 * Returns all the marc tags.
	 *
	 * @return the marc tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MarcTag> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the marc tags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of marc tags
	 * @param end the upper bound of the range of marc tags (not inclusive)
	 * @return the range of marc tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MarcTag> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the marc tags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of marc tags
	 * @param end the upper bound of the range of marc tags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of marc tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MarcTag> findAll(int start, int end,
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

		List<MarcTag> list = (List<MarcTag>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MARCTAG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MARCTAG;

				if (pagination) {
					sql = sql.concat(MarcTagModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MarcTag>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MarcTag>(list);
				}
				else {
					list = (List<MarcTag>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the marc tags from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (MarcTag marcTag : findAll()) {
			remove(marcTag);
		}
	}

	/**
	 * Returns the number of marc tags.
	 *
	 * @return the number of marc tags
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

				Query q = session.createQuery(_SQL_COUNT_MARCTAG);

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
	 * Initializes the marc tag persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.kencana.lms.model.MarcTag")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MarcTag>> listenersList = new ArrayList<ModelListener<MarcTag>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MarcTag>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MarcTagImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MARCTAG = "SELECT marcTag FROM MarcTag marcTag";
	private static final String _SQL_SELECT_MARCTAG_WHERE = "SELECT marcTag FROM MarcTag marcTag WHERE ";
	private static final String _SQL_COUNT_MARCTAG = "SELECT COUNT(marcTag) FROM MarcTag marcTag";
	private static final String _SQL_COUNT_MARCTAG_WHERE = "SELECT COUNT(marcTag) FROM MarcTag marcTag WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "marcTag.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MarcTag exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MarcTag exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MarcTagPersistenceImpl.class);
	private static MarcTag _nullMarcTag = new MarcTagImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MarcTag> toCacheModel() {
				return _nullMarcTagCacheModel;
			}
		};

	private static CacheModel<MarcTag> _nullMarcTagCacheModel = new CacheModel<MarcTag>() {
			@Override
			public MarcTag toEntityModel() {
				return _nullMarcTag;
			}
		};
}