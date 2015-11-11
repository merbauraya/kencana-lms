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

package com.kencana.lms.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ItemCategory}.
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemCategory
 * @generated
 */
public class ItemCategoryWrapper implements ItemCategory,
	ModelWrapper<ItemCategory> {
	public ItemCategoryWrapper(ItemCategory itemCategory) {
		_itemCategory = itemCategory;
	}

	@Override
	public Class<?> getModelClass() {
		return ItemCategory.class;
	}

	@Override
	public String getModelClassName() {
		return ItemCategory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("itemCategoryId", getItemCategoryId());
		attributes.put("itemCategoryName", getItemCategoryName());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("userId", getUserId());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long itemCategoryId = (Long)attributes.get("itemCategoryId");

		if (itemCategoryId != null) {
			setItemCategoryId(itemCategoryId);
		}

		String itemCategoryName = (String)attributes.get("itemCategoryName");

		if (itemCategoryName != null) {
			setItemCategoryName(itemCategoryName);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	* Returns the primary key of this item category.
	*
	* @return the primary key of this item category
	*/
	@Override
	public long getPrimaryKey() {
		return _itemCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this item category.
	*
	* @param primaryKey the primary key of this item category
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_itemCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the item category ID of this item category.
	*
	* @return the item category ID of this item category
	*/
	@Override
	public long getItemCategoryId() {
		return _itemCategory.getItemCategoryId();
	}

	/**
	* Sets the item category ID of this item category.
	*
	* @param itemCategoryId the item category ID of this item category
	*/
	@Override
	public void setItemCategoryId(long itemCategoryId) {
		_itemCategory.setItemCategoryId(itemCategoryId);
	}

	/**
	* Returns the item category name of this item category.
	*
	* @return the item category name of this item category
	*/
	@Override
	public java.lang.String getItemCategoryName() {
		return _itemCategory.getItemCategoryName();
	}

	/**
	* Sets the item category name of this item category.
	*
	* @param itemCategoryName the item category name of this item category
	*/
	@Override
	public void setItemCategoryName(java.lang.String itemCategoryName) {
		_itemCategory.setItemCategoryName(itemCategoryName);
	}

	/**
	* Returns the group ID of this item category.
	*
	* @return the group ID of this item category
	*/
	@Override
	public long getGroupId() {
		return _itemCategory.getGroupId();
	}

	/**
	* Sets the group ID of this item category.
	*
	* @param groupId the group ID of this item category
	*/
	@Override
	public void setGroupId(long groupId) {
		_itemCategory.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this item category.
	*
	* @return the company ID of this item category
	*/
	@Override
	public long getCompanyId() {
		return _itemCategory.getCompanyId();
	}

	/**
	* Sets the company ID of this item category.
	*
	* @param companyId the company ID of this item category
	*/
	@Override
	public void setCompanyId(long companyId) {
		_itemCategory.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this item category.
	*
	* @return the create date of this item category
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _itemCategory.getCreateDate();
	}

	/**
	* Sets the create date of this item category.
	*
	* @param createDate the create date of this item category
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_itemCategory.setCreateDate(createDate);
	}

	/**
	* Returns the user ID of this item category.
	*
	* @return the user ID of this item category
	*/
	@Override
	public long getUserId() {
		return _itemCategory.getUserId();
	}

	/**
	* Sets the user ID of this item category.
	*
	* @param userId the user ID of this item category
	*/
	@Override
	public void setUserId(long userId) {
		_itemCategory.setUserId(userId);
	}

	/**
	* Returns the user uuid of this item category.
	*
	* @return the user uuid of this item category
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemCategory.getUserUuid();
	}

	/**
	* Sets the user uuid of this item category.
	*
	* @param userUuid the user uuid of this item category
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_itemCategory.setUserUuid(userUuid);
	}

	/**
	* Returns the modified date of this item category.
	*
	* @return the modified date of this item category
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _itemCategory.getModifiedDate();
	}

	/**
	* Sets the modified date of this item category.
	*
	* @param modifiedDate the modified date of this item category
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_itemCategory.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _itemCategory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_itemCategory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _itemCategory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_itemCategory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _itemCategory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _itemCategory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_itemCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _itemCategory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_itemCategory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_itemCategory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_itemCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ItemCategoryWrapper((ItemCategory)_itemCategory.clone());
	}

	@Override
	public int compareTo(com.kencana.lms.model.ItemCategory itemCategory) {
		return _itemCategory.compareTo(itemCategory);
	}

	@Override
	public int hashCode() {
		return _itemCategory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.kencana.lms.model.ItemCategory> toCacheModel() {
		return _itemCategory.toCacheModel();
	}

	@Override
	public com.kencana.lms.model.ItemCategory toEscapedModel() {
		return new ItemCategoryWrapper(_itemCategory.toEscapedModel());
	}

	@Override
	public com.kencana.lms.model.ItemCategory toUnescapedModel() {
		return new ItemCategoryWrapper(_itemCategory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _itemCategory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _itemCategory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_itemCategory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ItemCategoryWrapper)) {
			return false;
		}

		ItemCategoryWrapper itemCategoryWrapper = (ItemCategoryWrapper)obj;

		if (Validator.equals(_itemCategory, itemCategoryWrapper._itemCategory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ItemCategory getWrappedItemCategory() {
		return _itemCategory;
	}

	@Override
	public ItemCategory getWrappedModel() {
		return _itemCategory;
	}

	@Override
	public void resetOriginalValues() {
		_itemCategory.resetOriginalValues();
	}

	private ItemCategory _itemCategory;
}