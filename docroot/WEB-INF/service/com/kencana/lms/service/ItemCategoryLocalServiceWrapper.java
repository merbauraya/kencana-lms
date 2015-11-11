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

package com.kencana.lms.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ItemCategoryLocalService}.
 *
 * @author Mazlan Mat
 * @see ItemCategoryLocalService
 * @generated
 */
public class ItemCategoryLocalServiceWrapper implements ItemCategoryLocalService,
	ServiceWrapper<ItemCategoryLocalService> {
	public ItemCategoryLocalServiceWrapper(
		ItemCategoryLocalService itemCategoryLocalService) {
		_itemCategoryLocalService = itemCategoryLocalService;
	}

	/**
	* Adds the item category to the database. Also notifies the appropriate model listeners.
	*
	* @param itemCategory the item category
	* @return the item category that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.ItemCategory addItemCategory(
		com.kencana.lms.model.ItemCategory itemCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemCategoryLocalService.addItemCategory(itemCategory);
	}

	/**
	* Creates a new item category with the primary key. Does not add the item category to the database.
	*
	* @param itemCategoryId the primary key for the new item category
	* @return the new item category
	*/
	@Override
	public com.kencana.lms.model.ItemCategory createItemCategory(
		long itemCategoryId) {
		return _itemCategoryLocalService.createItemCategory(itemCategoryId);
	}

	/**
	* Deletes the item category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemCategoryId the primary key of the item category
	* @return the item category that was removed
	* @throws PortalException if a item category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.ItemCategory deleteItemCategory(
		long itemCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _itemCategoryLocalService.deleteItemCategory(itemCategoryId);
	}

	/**
	* Deletes the item category from the database. Also notifies the appropriate model listeners.
	*
	* @param itemCategory the item category
	* @return the item category that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.ItemCategory deleteItemCategory(
		com.kencana.lms.model.ItemCategory itemCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemCategoryLocalService.deleteItemCategory(itemCategory);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _itemCategoryLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemCategoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.ItemCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _itemCategoryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.ItemCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemCategoryLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemCategoryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemCategoryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.kencana.lms.model.ItemCategory fetchItemCategory(
		long itemCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemCategoryLocalService.fetchItemCategory(itemCategoryId);
	}

	/**
	* Returns the item category with the primary key.
	*
	* @param itemCategoryId the primary key of the item category
	* @return the item category
	* @throws PortalException if a item category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.ItemCategory getItemCategory(
		long itemCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _itemCategoryLocalService.getItemCategory(itemCategoryId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _itemCategoryLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.kencana.lms.model.ItemCategory> getItemCategories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemCategoryLocalService.getItemCategories(start, end);
	}

	/**
	* Returns the number of item categories.
	*
	* @return the number of item categories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getItemCategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemCategoryLocalService.getItemCategoriesCount();
	}

	/**
	* Updates the item category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param itemCategory the item category
	* @return the item category that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.ItemCategory updateItemCategory(
		com.kencana.lms.model.ItemCategory itemCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemCategoryLocalService.updateItemCategory(itemCategory);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _itemCategoryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_itemCategoryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _itemCategoryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.kencana.lms.model.ItemCategory updateItemCategory(
		long companyId, long groupId, long userId, long itemCategoryId,
		java.lang.String name)
		throws com.kencana.lms.NoSuchItemCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return _itemCategoryLocalService.updateItemCategory(companyId, groupId,
			userId, itemCategoryId, name);
	}

	@Override
	public java.util.List<com.kencana.lms.model.ItemCategory> findByCompanyGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemCategoryLocalService.findByCompanyGroup(companyId, groupId);
	}

	@Override
	public java.util.List<com.kencana.lms.model.ItemCategory> findByCompanyGroup(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemCategoryLocalService.findByCompanyGroup(companyId, groupId,
			start, end);
	}

	@Override
	public java.util.List<com.kencana.lms.model.ItemCategory> findByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemCategoryLocalService.findByCompanyGroup(companyId, groupId,
			start, end, obc);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ItemCategoryLocalService getWrappedItemCategoryLocalService() {
		return _itemCategoryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedItemCategoryLocalService(
		ItemCategoryLocalService itemCategoryLocalService) {
		_itemCategoryLocalService = itemCategoryLocalService;
	}

	@Override
	public ItemCategoryLocalService getWrappedService() {
		return _itemCategoryLocalService;
	}

	@Override
	public void setWrappedService(
		ItemCategoryLocalService itemCategoryLocalService) {
		_itemCategoryLocalService = itemCategoryLocalService;
	}

	private ItemCategoryLocalService _itemCategoryLocalService;
}