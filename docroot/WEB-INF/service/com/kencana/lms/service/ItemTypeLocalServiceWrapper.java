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
 * Provides a wrapper for {@link ItemTypeLocalService}.
 *
 * @author Mazlan Mat
 * @see ItemTypeLocalService
 * @generated
 */
public class ItemTypeLocalServiceWrapper implements ItemTypeLocalService,
	ServiceWrapper<ItemTypeLocalService> {
	public ItemTypeLocalServiceWrapper(
		ItemTypeLocalService itemTypeLocalService) {
		_itemTypeLocalService = itemTypeLocalService;
	}

	/**
	* Adds the item type to the database. Also notifies the appropriate model listeners.
	*
	* @param itemType the item type
	* @return the item type that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.ItemType addItemType(
		com.kencana.lms.model.ItemType itemType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeLocalService.addItemType(itemType);
	}

	/**
	* Creates a new item type with the primary key. Does not add the item type to the database.
	*
	* @param itemTypeId the primary key for the new item type
	* @return the new item type
	*/
	@Override
	public com.kencana.lms.model.ItemType createItemType(long itemTypeId) {
		return _itemTypeLocalService.createItemType(itemTypeId);
	}

	/**
	* Deletes the item type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemTypeId the primary key of the item type
	* @return the item type that was removed
	* @throws PortalException if a item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.ItemType deleteItemType(long itemTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeLocalService.deleteItemType(itemTypeId);
	}

	/**
	* Deletes the item type from the database. Also notifies the appropriate model listeners.
	*
	* @param itemType the item type
	* @return the item type that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.ItemType deleteItemType(
		com.kencana.lms.model.ItemType itemType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeLocalService.deleteItemType(itemType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _itemTypeLocalService.dynamicQuery();
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
		return _itemTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.ItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _itemTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.ItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _itemTypeLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _itemTypeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _itemTypeLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.kencana.lms.model.ItemType fetchItemType(long itemTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeLocalService.fetchItemType(itemTypeId);
	}

	/**
	* Returns the item type with the primary key.
	*
	* @param itemTypeId the primary key of the item type
	* @return the item type
	* @throws PortalException if a item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.ItemType getItemType(long itemTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeLocalService.getItemType(itemTypeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the item types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kencana.lms.model.impl.ItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of item types
	* @param end the upper bound of the range of item types (not inclusive)
	* @return the range of item types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.kencana.lms.model.ItemType> getItemTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeLocalService.getItemTypes(start, end);
	}

	/**
	* Returns the number of item types.
	*
	* @return the number of item types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getItemTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeLocalService.getItemTypesCount();
	}

	/**
	* Updates the item type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param itemType the item type
	* @return the item type that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kencana.lms.model.ItemType updateItemType(
		com.kencana.lms.model.ItemType itemType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeLocalService.updateItemType(itemType);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _itemTypeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_itemTypeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _itemTypeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.kencana.lms.model.ItemType updateCover(long itemTypeId,
		byte[] bytes)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeLocalService.updateCover(itemTypeId, bytes);
	}

	@Override
	public com.kencana.lms.model.ItemType updateItemType(long companyId,
		long groupId, long userId, long itemTypeId, java.lang.String name,
		java.lang.String checkoutMessage, java.lang.String checkinMessage,
		double rentalRate, boolean notForLoan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeLocalService.updateItemType(companyId, groupId, userId,
			itemTypeId, name, checkoutMessage, checkinMessage, rentalRate,
			notForLoan);
	}

	@Override
	public java.util.List<com.kencana.lms.model.ItemType> findByCompanyGroup(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeLocalService.findByCompanyGroup(companyId, groupId,
			start, end);
	}

	@Override
	public java.util.List<com.kencana.lms.model.ItemType> findByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeLocalService.findByCompanyGroup(companyId, groupId,
			start, end, obc);
	}

	@Override
	public java.util.List<com.kencana.lms.model.ItemType> findByCompanyGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeLocalService.findByCompanyGroup(companyId, groupId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ItemTypeLocalService getWrappedItemTypeLocalService() {
		return _itemTypeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedItemTypeLocalService(
		ItemTypeLocalService itemTypeLocalService) {
		_itemTypeLocalService = itemTypeLocalService;
	}

	@Override
	public ItemTypeLocalService getWrappedService() {
		return _itemTypeLocalService;
	}

	@Override
	public void setWrappedService(ItemTypeLocalService itemTypeLocalService) {
		_itemTypeLocalService = itemTypeLocalService;
	}

	private ItemTypeLocalService _itemTypeLocalService;
}