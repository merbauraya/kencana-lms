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

import com.kencana.lms.NoSuchCatalogTemplateException;
import com.kencana.lms.model.CatalogTemplate;
import com.kencana.lms.model.impl.CatalogTemplateImpl;
import com.kencana.lms.model.impl.CatalogTemplateModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
 * The persistence implementation for the catalog template service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see CatalogTemplatePersistence
 * @see CatalogTemplateUtil
 * @generated
 */
public class CatalogTemplatePersistenceImpl extends BasePersistenceImpl<CatalogTemplate>
	implements CatalogTemplatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CatalogTemplateUtil} to access the catalog template persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CatalogTemplateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CatalogTemplateModelImpl.ENTITY_CACHE_ENABLED,
			CatalogTemplateModelImpl.FINDER_CACHE_ENABLED,
			CatalogTemplateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CatalogTemplateModelImpl.ENTITY_CACHE_ENABLED,
			CatalogTemplateModelImpl.FINDER_CACHE_ENABLED,
			CatalogTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CatalogTemplateModelImpl.ENTITY_CACHE_ENABLED,
			CatalogTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public CatalogTemplatePersistenceImpl() {
		setModelClass(CatalogTemplate.class);
	}

	/**
	 * Caches the catalog template in the entity cache if it is enabled.
	 *
	 * @param catalogTemplate the catalog template
	 */
	@Override
	public void cacheResult(CatalogTemplate catalogTemplate) {
		EntityCacheUtil.putResult(CatalogTemplateModelImpl.ENTITY_CACHE_ENABLED,
			CatalogTemplateImpl.class, catalogTemplate.getPrimaryKey(),
			catalogTemplate);

		catalogTemplate.resetOriginalValues();
	}

	/**
	 * Caches the catalog templates in the entity cache if it is enabled.
	 *
	 * @param catalogTemplates the catalog templates
	 */
	@Override
	public void cacheResult(List<CatalogTemplate> catalogTemplates) {
		for (CatalogTemplate catalogTemplate : catalogTemplates) {
			if (EntityCacheUtil.getResult(
						CatalogTemplateModelImpl.ENTITY_CACHE_ENABLED,
						CatalogTemplateImpl.class,
						catalogTemplate.getPrimaryKey()) == null) {
				cacheResult(catalogTemplate);
			}
			else {
				catalogTemplate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all catalog templates.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CatalogTemplateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CatalogTemplateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the catalog template.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CatalogTemplate catalogTemplate) {
		EntityCacheUtil.removeResult(CatalogTemplateModelImpl.ENTITY_CACHE_ENABLED,
			CatalogTemplateImpl.class, catalogTemplate.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CatalogTemplate> catalogTemplates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CatalogTemplate catalogTemplate : catalogTemplates) {
			EntityCacheUtil.removeResult(CatalogTemplateModelImpl.ENTITY_CACHE_ENABLED,
				CatalogTemplateImpl.class, catalogTemplate.getPrimaryKey());
		}
	}

	/**
	 * Creates a new catalog template with the primary key. Does not add the catalog template to the database.
	 *
	 * @param templateId the primary key for the new catalog template
	 * @return the new catalog template
	 */
	@Override
	public CatalogTemplate create(long templateId) {
		CatalogTemplate catalogTemplate = new CatalogTemplateImpl();

		catalogTemplate.setNew(true);
		catalogTemplate.setPrimaryKey(templateId);

		return catalogTemplate;
	}

	/**
	 * Removes the catalog template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param templateId the primary key of the catalog template
	 * @return the catalog template that was removed
	 * @throws com.kencana.lms.NoSuchCatalogTemplateException if a catalog template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogTemplate remove(long templateId)
		throws NoSuchCatalogTemplateException, SystemException {
		return remove((Serializable)templateId);
	}

	/**
	 * Removes the catalog template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the catalog template
	 * @return the catalog template that was removed
	 * @throws com.kencana.lms.NoSuchCatalogTemplateException if a catalog template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogTemplate remove(Serializable primaryKey)
		throws NoSuchCatalogTemplateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CatalogTemplate catalogTemplate = (CatalogTemplate)session.get(CatalogTemplateImpl.class,
					primaryKey);

			if (catalogTemplate == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCatalogTemplateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(catalogTemplate);
		}
		catch (NoSuchCatalogTemplateException nsee) {
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
	protected CatalogTemplate removeImpl(CatalogTemplate catalogTemplate)
		throws SystemException {
		catalogTemplate = toUnwrappedModel(catalogTemplate);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(catalogTemplate)) {
				catalogTemplate = (CatalogTemplate)session.get(CatalogTemplateImpl.class,
						catalogTemplate.getPrimaryKeyObj());
			}

			if (catalogTemplate != null) {
				session.delete(catalogTemplate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (catalogTemplate != null) {
			clearCache(catalogTemplate);
		}

		return catalogTemplate;
	}

	@Override
	public CatalogTemplate updateImpl(
		com.kencana.lms.model.CatalogTemplate catalogTemplate)
		throws SystemException {
		catalogTemplate = toUnwrappedModel(catalogTemplate);

		boolean isNew = catalogTemplate.isNew();

		Session session = null;

		try {
			session = openSession();

			if (catalogTemplate.isNew()) {
				session.save(catalogTemplate);

				catalogTemplate.setNew(false);
			}
			else {
				session.merge(catalogTemplate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(CatalogTemplateModelImpl.ENTITY_CACHE_ENABLED,
			CatalogTemplateImpl.class, catalogTemplate.getPrimaryKey(),
			catalogTemplate);

		return catalogTemplate;
	}

	protected CatalogTemplate toUnwrappedModel(CatalogTemplate catalogTemplate) {
		if (catalogTemplate instanceof CatalogTemplateImpl) {
			return catalogTemplate;
		}

		CatalogTemplateImpl catalogTemplateImpl = new CatalogTemplateImpl();

		catalogTemplateImpl.setNew(catalogTemplate.isNew());
		catalogTemplateImpl.setPrimaryKey(catalogTemplate.getPrimaryKey());

		catalogTemplateImpl.setTemplateId(catalogTemplate.getTemplateId());
		catalogTemplateImpl.setTemplateName(catalogTemplate.getTemplateName());
		catalogTemplateImpl.setGroupId(catalogTemplate.getGroupId());
		catalogTemplateImpl.setCompanyId(catalogTemplate.getCompanyId());
		catalogTemplateImpl.setDescription(catalogTemplate.getDescription());
		catalogTemplateImpl.setActive(catalogTemplate.isActive());
		catalogTemplateImpl.setCreateBy(catalogTemplate.getCreateBy());
		catalogTemplateImpl.setCreatedDate(catalogTemplate.getCreatedDate());

		return catalogTemplateImpl;
	}

	/**
	 * Returns the catalog template with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the catalog template
	 * @return the catalog template
	 * @throws com.kencana.lms.NoSuchCatalogTemplateException if a catalog template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogTemplate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCatalogTemplateException, SystemException {
		CatalogTemplate catalogTemplate = fetchByPrimaryKey(primaryKey);

		if (catalogTemplate == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCatalogTemplateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return catalogTemplate;
	}

	/**
	 * Returns the catalog template with the primary key or throws a {@link com.kencana.lms.NoSuchCatalogTemplateException} if it could not be found.
	 *
	 * @param templateId the primary key of the catalog template
	 * @return the catalog template
	 * @throws com.kencana.lms.NoSuchCatalogTemplateException if a catalog template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogTemplate findByPrimaryKey(long templateId)
		throws NoSuchCatalogTemplateException, SystemException {
		return findByPrimaryKey((Serializable)templateId);
	}

	/**
	 * Returns the catalog template with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the catalog template
	 * @return the catalog template, or <code>null</code> if a catalog template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogTemplate fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CatalogTemplate catalogTemplate = (CatalogTemplate)EntityCacheUtil.getResult(CatalogTemplateModelImpl.ENTITY_CACHE_ENABLED,
				CatalogTemplateImpl.class, primaryKey);

		if (catalogTemplate == _nullCatalogTemplate) {
			return null;
		}

		if (catalogTemplate == null) {
			Session session = null;

			try {
				session = openSession();

				catalogTemplate = (CatalogTemplate)session.get(CatalogTemplateImpl.class,
						primaryKey);

				if (catalogTemplate != null) {
					cacheResult(catalogTemplate);
				}
				else {
					EntityCacheUtil.putResult(CatalogTemplateModelImpl.ENTITY_CACHE_ENABLED,
						CatalogTemplateImpl.class, primaryKey,
						_nullCatalogTemplate);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CatalogTemplateModelImpl.ENTITY_CACHE_ENABLED,
					CatalogTemplateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return catalogTemplate;
	}

	/**
	 * Returns the catalog template with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param templateId the primary key of the catalog template
	 * @return the catalog template, or <code>null</code> if a catalog template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CatalogTemplate fetchByPrimaryKey(long templateId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)templateId);
	}

	/**
	 * Returns all the catalog templates.
	 *
	 * @return the catalog templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogTemplate> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the catalog templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of catalog templates
	 * @param end the upper bound of the range of catalog templates (not inclusive)
	 * @return the range of catalog templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogTemplate> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the catalog templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.CatalogTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of catalog templates
	 * @param end the upper bound of the range of catalog templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of catalog templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CatalogTemplate> findAll(int start, int end,
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

		List<CatalogTemplate> list = (List<CatalogTemplate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CATALOGTEMPLATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CATALOGTEMPLATE;

				if (pagination) {
					sql = sql.concat(CatalogTemplateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CatalogTemplate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CatalogTemplate>(list);
				}
				else {
					list = (List<CatalogTemplate>)QueryUtil.list(q,
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
	 * Removes all the catalog templates from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CatalogTemplate catalogTemplate : findAll()) {
			remove(catalogTemplate);
		}
	}

	/**
	 * Returns the number of catalog templates.
	 *
	 * @return the number of catalog templates
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

				Query q = session.createQuery(_SQL_COUNT_CATALOGTEMPLATE);

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
	 * Initializes the catalog template persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.kencana.lms.model.CatalogTemplate")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CatalogTemplate>> listenersList = new ArrayList<ModelListener<CatalogTemplate>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CatalogTemplate>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CatalogTemplateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CATALOGTEMPLATE = "SELECT catalogTemplate FROM CatalogTemplate catalogTemplate";
	private static final String _SQL_COUNT_CATALOGTEMPLATE = "SELECT COUNT(catalogTemplate) FROM CatalogTemplate catalogTemplate";
	private static final String _ORDER_BY_ENTITY_ALIAS = "catalogTemplate.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CatalogTemplate exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CatalogTemplatePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"active"
			});
	private static CatalogTemplate _nullCatalogTemplate = new CatalogTemplateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CatalogTemplate> toCacheModel() {
				return _nullCatalogTemplateCacheModel;
			}
		};

	private static CacheModel<CatalogTemplate> _nullCatalogTemplateCacheModel = new CacheModel<CatalogTemplate>() {
			@Override
			public CatalogTemplate toEntityModel() {
				return _nullCatalogTemplate;
			}
		};
}