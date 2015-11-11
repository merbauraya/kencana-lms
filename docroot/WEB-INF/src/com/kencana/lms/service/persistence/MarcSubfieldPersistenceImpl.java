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

import com.kencana.lms.NoSuchMarcSubfieldException;
import com.kencana.lms.model.MarcSubfield;
import com.kencana.lms.model.impl.MarcSubfieldImpl;
import com.kencana.lms.model.impl.MarcSubfieldModelImpl;

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
 * The persistence implementation for the marc subfield service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see MarcSubfieldPersistence
 * @see MarcSubfieldUtil
 * @generated
 */
public class MarcSubfieldPersistenceImpl extends BasePersistenceImpl<MarcSubfield>
	implements MarcSubfieldPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MarcSubfieldUtil} to access the marc subfield persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MarcSubfieldImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MarcSubfieldModelImpl.ENTITY_CACHE_ENABLED,
			MarcSubfieldModelImpl.FINDER_CACHE_ENABLED, MarcSubfieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MarcSubfieldModelImpl.ENTITY_CACHE_ENABLED,
			MarcSubfieldModelImpl.FINDER_CACHE_ENABLED, MarcSubfieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MarcSubfieldModelImpl.ENTITY_CACHE_ENABLED,
			MarcSubfieldModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_SUBFIELD = new FinderPath(MarcSubfieldModelImpl.ENTITY_CACHE_ENABLED,
			MarcSubfieldModelImpl.FINDER_CACHE_ENABLED, MarcSubfieldImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBySubfield",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			MarcSubfieldModelImpl.TAG_COLUMN_BITMASK |
			MarcSubfieldModelImpl.TAGTYPE_COLUMN_BITMASK |
			MarcSubfieldModelImpl.SUBFIELD_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SUBFIELD = new FinderPath(MarcSubfieldModelImpl.ENTITY_CACHE_ENABLED,
			MarcSubfieldModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySubfield",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the marc subfield where tag = &#63; and tagType = &#63; and subfield = &#63; or throws a {@link com.kencana.lms.NoSuchMarcSubfieldException} if it could not be found.
	 *
	 * @param tag the tag
	 * @param tagType the tag type
	 * @param subfield the subfield
	 * @return the matching marc subfield
	 * @throws com.kencana.lms.NoSuchMarcSubfieldException if a matching marc subfield could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcSubfield findBySubfield(String tag, String tagType,
		String subfield) throws NoSuchMarcSubfieldException, SystemException {
		MarcSubfield marcSubfield = fetchBySubfield(tag, tagType, subfield);

		if (marcSubfield == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("tag=");
			msg.append(tag);

			msg.append(", tagType=");
			msg.append(tagType);

			msg.append(", subfield=");
			msg.append(subfield);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchMarcSubfieldException(msg.toString());
		}

		return marcSubfield;
	}

	/**
	 * Returns the marc subfield where tag = &#63; and tagType = &#63; and subfield = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tag the tag
	 * @param tagType the tag type
	 * @param subfield the subfield
	 * @return the matching marc subfield, or <code>null</code> if a matching marc subfield could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcSubfield fetchBySubfield(String tag, String tagType,
		String subfield) throws SystemException {
		return fetchBySubfield(tag, tagType, subfield, true);
	}

	/**
	 * Returns the marc subfield where tag = &#63; and tagType = &#63; and subfield = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tag the tag
	 * @param tagType the tag type
	 * @param subfield the subfield
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching marc subfield, or <code>null</code> if a matching marc subfield could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcSubfield fetchBySubfield(String tag, String tagType,
		String subfield, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { tag, tagType, subfield };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_SUBFIELD,
					finderArgs, this);
		}

		if (result instanceof MarcSubfield) {
			MarcSubfield marcSubfield = (MarcSubfield)result;

			if (!Validator.equals(tag, marcSubfield.getTag()) ||
					!Validator.equals(tagType, marcSubfield.getTagType()) ||
					!Validator.equals(subfield, marcSubfield.getSubfield())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_MARCSUBFIELD_WHERE);

			boolean bindTag = false;

			if (tag == null) {
				query.append(_FINDER_COLUMN_SUBFIELD_TAG_1);
			}
			else if (tag.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SUBFIELD_TAG_3);
			}
			else {
				bindTag = true;

				query.append(_FINDER_COLUMN_SUBFIELD_TAG_2);
			}

			boolean bindTagType = false;

			if (tagType == null) {
				query.append(_FINDER_COLUMN_SUBFIELD_TAGTYPE_1);
			}
			else if (tagType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SUBFIELD_TAGTYPE_3);
			}
			else {
				bindTagType = true;

				query.append(_FINDER_COLUMN_SUBFIELD_TAGTYPE_2);
			}

			boolean bindSubfield = false;

			if (subfield == null) {
				query.append(_FINDER_COLUMN_SUBFIELD_SUBFIELD_1);
			}
			else if (subfield.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SUBFIELD_SUBFIELD_3);
			}
			else {
				bindSubfield = true;

				query.append(_FINDER_COLUMN_SUBFIELD_SUBFIELD_2);
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

				if (bindSubfield) {
					qPos.add(subfield);
				}

				List<MarcSubfield> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SUBFIELD,
						finderArgs, list);
				}
				else {
					MarcSubfield marcSubfield = list.get(0);

					result = marcSubfield;

					cacheResult(marcSubfield);

					if ((marcSubfield.getTag() == null) ||
							!marcSubfield.getTag().equals(tag) ||
							(marcSubfield.getTagType() == null) ||
							!marcSubfield.getTagType().equals(tagType) ||
							(marcSubfield.getSubfield() == null) ||
							!marcSubfield.getSubfield().equals(subfield)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SUBFIELD,
							finderArgs, marcSubfield);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SUBFIELD,
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
			return (MarcSubfield)result;
		}
	}

	/**
	 * Removes the marc subfield where tag = &#63; and tagType = &#63; and subfield = &#63; from the database.
	 *
	 * @param tag the tag
	 * @param tagType the tag type
	 * @param subfield the subfield
	 * @return the marc subfield that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcSubfield removeBySubfield(String tag, String tagType,
		String subfield) throws NoSuchMarcSubfieldException, SystemException {
		MarcSubfield marcSubfield = findBySubfield(tag, tagType, subfield);

		return remove(marcSubfield);
	}

	/**
	 * Returns the number of marc subfields where tag = &#63; and tagType = &#63; and subfield = &#63;.
	 *
	 * @param tag the tag
	 * @param tagType the tag type
	 * @param subfield the subfield
	 * @return the number of matching marc subfields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySubfield(String tag, String tagType, String subfield)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SUBFIELD;

		Object[] finderArgs = new Object[] { tag, tagType, subfield };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_MARCSUBFIELD_WHERE);

			boolean bindTag = false;

			if (tag == null) {
				query.append(_FINDER_COLUMN_SUBFIELD_TAG_1);
			}
			else if (tag.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SUBFIELD_TAG_3);
			}
			else {
				bindTag = true;

				query.append(_FINDER_COLUMN_SUBFIELD_TAG_2);
			}

			boolean bindTagType = false;

			if (tagType == null) {
				query.append(_FINDER_COLUMN_SUBFIELD_TAGTYPE_1);
			}
			else if (tagType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SUBFIELD_TAGTYPE_3);
			}
			else {
				bindTagType = true;

				query.append(_FINDER_COLUMN_SUBFIELD_TAGTYPE_2);
			}

			boolean bindSubfield = false;

			if (subfield == null) {
				query.append(_FINDER_COLUMN_SUBFIELD_SUBFIELD_1);
			}
			else if (subfield.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SUBFIELD_SUBFIELD_3);
			}
			else {
				bindSubfield = true;

				query.append(_FINDER_COLUMN_SUBFIELD_SUBFIELD_2);
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

				if (bindSubfield) {
					qPos.add(subfield);
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

	private static final String _FINDER_COLUMN_SUBFIELD_TAG_1 = "marcSubfield.tag IS NULL AND ";
	private static final String _FINDER_COLUMN_SUBFIELD_TAG_2 = "marcSubfield.tag = ? AND ";
	private static final String _FINDER_COLUMN_SUBFIELD_TAG_3 = "(marcSubfield.tag IS NULL OR marcSubfield.tag = '') AND ";
	private static final String _FINDER_COLUMN_SUBFIELD_TAGTYPE_1 = "marcSubfield.tagType IS NULL AND ";
	private static final String _FINDER_COLUMN_SUBFIELD_TAGTYPE_2 = "marcSubfield.tagType = ? AND ";
	private static final String _FINDER_COLUMN_SUBFIELD_TAGTYPE_3 = "(marcSubfield.tagType IS NULL OR marcSubfield.tagType = '') AND ";
	private static final String _FINDER_COLUMN_SUBFIELD_SUBFIELD_1 = "marcSubfield.subfield IS NULL";
	private static final String _FINDER_COLUMN_SUBFIELD_SUBFIELD_2 = "marcSubfield.subfield = ?";
	private static final String _FINDER_COLUMN_SUBFIELD_SUBFIELD_3 = "(marcSubfield.subfield IS NULL OR marcSubfield.subfield = '')";

	public MarcSubfieldPersistenceImpl() {
		setModelClass(MarcSubfield.class);
	}

	/**
	 * Caches the marc subfield in the entity cache if it is enabled.
	 *
	 * @param marcSubfield the marc subfield
	 */
	@Override
	public void cacheResult(MarcSubfield marcSubfield) {
		EntityCacheUtil.putResult(MarcSubfieldModelImpl.ENTITY_CACHE_ENABLED,
			MarcSubfieldImpl.class, marcSubfield.getPrimaryKey(), marcSubfield);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SUBFIELD,
			new Object[] {
				marcSubfield.getTag(), marcSubfield.getTagType(),
				marcSubfield.getSubfield()
			}, marcSubfield);

		marcSubfield.resetOriginalValues();
	}

	/**
	 * Caches the marc subfields in the entity cache if it is enabled.
	 *
	 * @param marcSubfields the marc subfields
	 */
	@Override
	public void cacheResult(List<MarcSubfield> marcSubfields) {
		for (MarcSubfield marcSubfield : marcSubfields) {
			if (EntityCacheUtil.getResult(
						MarcSubfieldModelImpl.ENTITY_CACHE_ENABLED,
						MarcSubfieldImpl.class, marcSubfield.getPrimaryKey()) == null) {
				cacheResult(marcSubfield);
			}
			else {
				marcSubfield.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all marc subfields.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MarcSubfieldImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MarcSubfieldImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the marc subfield.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MarcSubfield marcSubfield) {
		EntityCacheUtil.removeResult(MarcSubfieldModelImpl.ENTITY_CACHE_ENABLED,
			MarcSubfieldImpl.class, marcSubfield.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(marcSubfield);
	}

	@Override
	public void clearCache(List<MarcSubfield> marcSubfields) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MarcSubfield marcSubfield : marcSubfields) {
			EntityCacheUtil.removeResult(MarcSubfieldModelImpl.ENTITY_CACHE_ENABLED,
				MarcSubfieldImpl.class, marcSubfield.getPrimaryKey());

			clearUniqueFindersCache(marcSubfield);
		}
	}

	protected void cacheUniqueFindersCache(MarcSubfield marcSubfield) {
		if (marcSubfield.isNew()) {
			Object[] args = new Object[] {
					marcSubfield.getTag(), marcSubfield.getTagType(),
					marcSubfield.getSubfield()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SUBFIELD, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SUBFIELD, args,
				marcSubfield);
		}
		else {
			MarcSubfieldModelImpl marcSubfieldModelImpl = (MarcSubfieldModelImpl)marcSubfield;

			if ((marcSubfieldModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_SUBFIELD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						marcSubfield.getTag(), marcSubfield.getTagType(),
						marcSubfield.getSubfield()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SUBFIELD, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SUBFIELD, args,
					marcSubfield);
			}
		}
	}

	protected void clearUniqueFindersCache(MarcSubfield marcSubfield) {
		MarcSubfieldModelImpl marcSubfieldModelImpl = (MarcSubfieldModelImpl)marcSubfield;

		Object[] args = new Object[] {
				marcSubfield.getTag(), marcSubfield.getTagType(),
				marcSubfield.getSubfield()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SUBFIELD, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SUBFIELD, args);

		if ((marcSubfieldModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_SUBFIELD.getColumnBitmask()) != 0) {
			args = new Object[] {
					marcSubfieldModelImpl.getOriginalTag(),
					marcSubfieldModelImpl.getOriginalTagType(),
					marcSubfieldModelImpl.getOriginalSubfield()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SUBFIELD, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SUBFIELD, args);
		}
	}

	/**
	 * Creates a new marc subfield with the primary key. Does not add the marc subfield to the database.
	 *
	 * @param MarcSubfieldId the primary key for the new marc subfield
	 * @return the new marc subfield
	 */
	@Override
	public MarcSubfield create(long MarcSubfieldId) {
		MarcSubfield marcSubfield = new MarcSubfieldImpl();

		marcSubfield.setNew(true);
		marcSubfield.setPrimaryKey(MarcSubfieldId);

		return marcSubfield;
	}

	/**
	 * Removes the marc subfield with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param MarcSubfieldId the primary key of the marc subfield
	 * @return the marc subfield that was removed
	 * @throws com.kencana.lms.NoSuchMarcSubfieldException if a marc subfield with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcSubfield remove(long MarcSubfieldId)
		throws NoSuchMarcSubfieldException, SystemException {
		return remove((Serializable)MarcSubfieldId);
	}

	/**
	 * Removes the marc subfield with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the marc subfield
	 * @return the marc subfield that was removed
	 * @throws com.kencana.lms.NoSuchMarcSubfieldException if a marc subfield with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcSubfield remove(Serializable primaryKey)
		throws NoSuchMarcSubfieldException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MarcSubfield marcSubfield = (MarcSubfield)session.get(MarcSubfieldImpl.class,
					primaryKey);

			if (marcSubfield == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMarcSubfieldException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(marcSubfield);
		}
		catch (NoSuchMarcSubfieldException nsee) {
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
	protected MarcSubfield removeImpl(MarcSubfield marcSubfield)
		throws SystemException {
		marcSubfield = toUnwrappedModel(marcSubfield);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(marcSubfield)) {
				marcSubfield = (MarcSubfield)session.get(MarcSubfieldImpl.class,
						marcSubfield.getPrimaryKeyObj());
			}

			if (marcSubfield != null) {
				session.delete(marcSubfield);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (marcSubfield != null) {
			clearCache(marcSubfield);
		}

		return marcSubfield;
	}

	@Override
	public MarcSubfield updateImpl(
		com.kencana.lms.model.MarcSubfield marcSubfield)
		throws SystemException {
		marcSubfield = toUnwrappedModel(marcSubfield);

		boolean isNew = marcSubfield.isNew();

		Session session = null;

		try {
			session = openSession();

			if (marcSubfield.isNew()) {
				session.save(marcSubfield);

				marcSubfield.setNew(false);
			}
			else {
				session.merge(marcSubfield);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MarcSubfieldModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(MarcSubfieldModelImpl.ENTITY_CACHE_ENABLED,
			MarcSubfieldImpl.class, marcSubfield.getPrimaryKey(), marcSubfield);

		clearUniqueFindersCache(marcSubfield);
		cacheUniqueFindersCache(marcSubfield);

		return marcSubfield;
	}

	protected MarcSubfield toUnwrappedModel(MarcSubfield marcSubfield) {
		if (marcSubfield instanceof MarcSubfieldImpl) {
			return marcSubfield;
		}

		MarcSubfieldImpl marcSubfieldImpl = new MarcSubfieldImpl();

		marcSubfieldImpl.setNew(marcSubfield.isNew());
		marcSubfieldImpl.setPrimaryKey(marcSubfield.getPrimaryKey());

		marcSubfieldImpl.setMarcSubfieldId(marcSubfield.getMarcSubfieldId());
		marcSubfieldImpl.setTag(marcSubfield.getTag());
		marcSubfieldImpl.setTagType(marcSubfield.getTagType());
		marcSubfieldImpl.setSubfield(marcSubfield.getSubfield());
		marcSubfieldImpl.setDescription(marcSubfield.getDescription());
		marcSubfieldImpl.setRepetable(marcSubfield.isRepetable());
		marcSubfieldImpl.setMandatory(marcSubfield.isMandatory());
		marcSubfieldImpl.setAuthorisedValue(marcSubfield.getAuthorisedValue());
		marcSubfieldImpl.setAuthTypeCode(marcSubfield.getAuthTypeCode());
		marcSubfieldImpl.setIsURL(marcSubfield.isIsURL());
		marcSubfieldImpl.setHelpText(marcSubfield.getHelpText());

		return marcSubfieldImpl;
	}

	/**
	 * Returns the marc subfield with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the marc subfield
	 * @return the marc subfield
	 * @throws com.kencana.lms.NoSuchMarcSubfieldException if a marc subfield with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcSubfield findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMarcSubfieldException, SystemException {
		MarcSubfield marcSubfield = fetchByPrimaryKey(primaryKey);

		if (marcSubfield == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMarcSubfieldException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return marcSubfield;
	}

	/**
	 * Returns the marc subfield with the primary key or throws a {@link com.kencana.lms.NoSuchMarcSubfieldException} if it could not be found.
	 *
	 * @param MarcSubfieldId the primary key of the marc subfield
	 * @return the marc subfield
	 * @throws com.kencana.lms.NoSuchMarcSubfieldException if a marc subfield with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcSubfield findByPrimaryKey(long MarcSubfieldId)
		throws NoSuchMarcSubfieldException, SystemException {
		return findByPrimaryKey((Serializable)MarcSubfieldId);
	}

	/**
	 * Returns the marc subfield with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the marc subfield
	 * @return the marc subfield, or <code>null</code> if a marc subfield with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcSubfield fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		MarcSubfield marcSubfield = (MarcSubfield)EntityCacheUtil.getResult(MarcSubfieldModelImpl.ENTITY_CACHE_ENABLED,
				MarcSubfieldImpl.class, primaryKey);

		if (marcSubfield == _nullMarcSubfield) {
			return null;
		}

		if (marcSubfield == null) {
			Session session = null;

			try {
				session = openSession();

				marcSubfield = (MarcSubfield)session.get(MarcSubfieldImpl.class,
						primaryKey);

				if (marcSubfield != null) {
					cacheResult(marcSubfield);
				}
				else {
					EntityCacheUtil.putResult(MarcSubfieldModelImpl.ENTITY_CACHE_ENABLED,
						MarcSubfieldImpl.class, primaryKey, _nullMarcSubfield);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MarcSubfieldModelImpl.ENTITY_CACHE_ENABLED,
					MarcSubfieldImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return marcSubfield;
	}

	/**
	 * Returns the marc subfield with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param MarcSubfieldId the primary key of the marc subfield
	 * @return the marc subfield, or <code>null</code> if a marc subfield with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MarcSubfield fetchByPrimaryKey(long MarcSubfieldId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)MarcSubfieldId);
	}

	/**
	 * Returns all the marc subfields.
	 *
	 * @return the marc subfields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MarcSubfield> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the marc subfields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcSubfieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of marc subfields
	 * @param end the upper bound of the range of marc subfields (not inclusive)
	 * @return the range of marc subfields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MarcSubfield> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the marc subfields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.MarcSubfieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of marc subfields
	 * @param end the upper bound of the range of marc subfields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of marc subfields
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MarcSubfield> findAll(int start, int end,
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

		List<MarcSubfield> list = (List<MarcSubfield>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MARCSUBFIELD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MARCSUBFIELD;

				if (pagination) {
					sql = sql.concat(MarcSubfieldModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MarcSubfield>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MarcSubfield>(list);
				}
				else {
					list = (List<MarcSubfield>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the marc subfields from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (MarcSubfield marcSubfield : findAll()) {
			remove(marcSubfield);
		}
	}

	/**
	 * Returns the number of marc subfields.
	 *
	 * @return the number of marc subfields
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

				Query q = session.createQuery(_SQL_COUNT_MARCSUBFIELD);

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
	 * Initializes the marc subfield persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.kencana.lms.model.MarcSubfield")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MarcSubfield>> listenersList = new ArrayList<ModelListener<MarcSubfield>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MarcSubfield>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MarcSubfieldImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MARCSUBFIELD = "SELECT marcSubfield FROM MarcSubfield marcSubfield";
	private static final String _SQL_SELECT_MARCSUBFIELD_WHERE = "SELECT marcSubfield FROM MarcSubfield marcSubfield WHERE ";
	private static final String _SQL_COUNT_MARCSUBFIELD = "SELECT COUNT(marcSubfield) FROM MarcSubfield marcSubfield";
	private static final String _SQL_COUNT_MARCSUBFIELD_WHERE = "SELECT COUNT(marcSubfield) FROM MarcSubfield marcSubfield WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "marcSubfield.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MarcSubfield exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MarcSubfield exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MarcSubfieldPersistenceImpl.class);
	private static MarcSubfield _nullMarcSubfield = new MarcSubfieldImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MarcSubfield> toCacheModel() {
				return _nullMarcSubfieldCacheModel;
			}
		};

	private static CacheModel<MarcSubfield> _nullMarcSubfieldCacheModel = new CacheModel<MarcSubfield>() {
			@Override
			public MarcSubfield toEntityModel() {
				return _nullMarcSubfield;
			}
		};
}