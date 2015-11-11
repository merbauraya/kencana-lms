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
 * This class is a wrapper for {@link ItemType}.
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemType
 * @generated
 */
public class ItemTypeWrapper implements ItemType, ModelWrapper<ItemType> {
	public ItemTypeWrapper(ItemType itemType) {
		_itemType = itemType;
	}

	@Override
	public Class<?> getModelClass() {
		return ItemType.class;
	}

	@Override
	public String getModelClassName() {
		return ItemType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("itemTypeId", getItemTypeId());
		attributes.put("itemTypeName", getItemTypeName());
		attributes.put("notForLoan", getNotForLoan());
		attributes.put("coverId", getCoverId());
		attributes.put("checkoutMessage", getCheckoutMessage());
		attributes.put("checkinMessage", getCheckinMessage());
		attributes.put("rentalRate", getRentalRate());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long itemTypeId = (Long)attributes.get("itemTypeId");

		if (itemTypeId != null) {
			setItemTypeId(itemTypeId);
		}

		String itemTypeName = (String)attributes.get("itemTypeName");

		if (itemTypeName != null) {
			setItemTypeName(itemTypeName);
		}

		Boolean notForLoan = (Boolean)attributes.get("notForLoan");

		if (notForLoan != null) {
			setNotForLoan(notForLoan);
		}

		Long coverId = (Long)attributes.get("coverId");

		if (coverId != null) {
			setCoverId(coverId);
		}

		String checkoutMessage = (String)attributes.get("checkoutMessage");

		if (checkoutMessage != null) {
			setCheckoutMessage(checkoutMessage);
		}

		String checkinMessage = (String)attributes.get("checkinMessage");

		if (checkinMessage != null) {
			setCheckinMessage(checkinMessage);
		}

		Double rentalRate = (Double)attributes.get("rentalRate");

		if (rentalRate != null) {
			setRentalRate(rentalRate);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	/**
	* Returns the primary key of this item type.
	*
	* @return the primary key of this item type
	*/
	@Override
	public long getPrimaryKey() {
		return _itemType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this item type.
	*
	* @param primaryKey the primary key of this item type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_itemType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the item type ID of this item type.
	*
	* @return the item type ID of this item type
	*/
	@Override
	public long getItemTypeId() {
		return _itemType.getItemTypeId();
	}

	/**
	* Sets the item type ID of this item type.
	*
	* @param itemTypeId the item type ID of this item type
	*/
	@Override
	public void setItemTypeId(long itemTypeId) {
		_itemType.setItemTypeId(itemTypeId);
	}

	/**
	* Returns the item type name of this item type.
	*
	* @return the item type name of this item type
	*/
	@Override
	public java.lang.String getItemTypeName() {
		return _itemType.getItemTypeName();
	}

	/**
	* Sets the item type name of this item type.
	*
	* @param itemTypeName the item type name of this item type
	*/
	@Override
	public void setItemTypeName(java.lang.String itemTypeName) {
		_itemType.setItemTypeName(itemTypeName);
	}

	/**
	* Returns the not for loan of this item type.
	*
	* @return the not for loan of this item type
	*/
	@Override
	public boolean getNotForLoan() {
		return _itemType.getNotForLoan();
	}

	/**
	* Returns <code>true</code> if this item type is not for loan.
	*
	* @return <code>true</code> if this item type is not for loan; <code>false</code> otherwise
	*/
	@Override
	public boolean isNotForLoan() {
		return _itemType.isNotForLoan();
	}

	/**
	* Sets whether this item type is not for loan.
	*
	* @param notForLoan the not for loan of this item type
	*/
	@Override
	public void setNotForLoan(boolean notForLoan) {
		_itemType.setNotForLoan(notForLoan);
	}

	/**
	* Returns the cover ID of this item type.
	*
	* @return the cover ID of this item type
	*/
	@Override
	public long getCoverId() {
		return _itemType.getCoverId();
	}

	/**
	* Sets the cover ID of this item type.
	*
	* @param coverId the cover ID of this item type
	*/
	@Override
	public void setCoverId(long coverId) {
		_itemType.setCoverId(coverId);
	}

	/**
	* Returns the checkout message of this item type.
	*
	* @return the checkout message of this item type
	*/
	@Override
	public java.lang.String getCheckoutMessage() {
		return _itemType.getCheckoutMessage();
	}

	/**
	* Sets the checkout message of this item type.
	*
	* @param checkoutMessage the checkout message of this item type
	*/
	@Override
	public void setCheckoutMessage(java.lang.String checkoutMessage) {
		_itemType.setCheckoutMessage(checkoutMessage);
	}

	/**
	* Returns the checkin message of this item type.
	*
	* @return the checkin message of this item type
	*/
	@Override
	public java.lang.String getCheckinMessage() {
		return _itemType.getCheckinMessage();
	}

	/**
	* Sets the checkin message of this item type.
	*
	* @param checkinMessage the checkin message of this item type
	*/
	@Override
	public void setCheckinMessage(java.lang.String checkinMessage) {
		_itemType.setCheckinMessage(checkinMessage);
	}

	/**
	* Returns the rental rate of this item type.
	*
	* @return the rental rate of this item type
	*/
	@Override
	public java.lang.Double getRentalRate() {
		return _itemType.getRentalRate();
	}

	/**
	* Sets the rental rate of this item type.
	*
	* @param rentalRate the rental rate of this item type
	*/
	@Override
	public void setRentalRate(java.lang.Double rentalRate) {
		_itemType.setRentalRate(rentalRate);
	}

	/**
	* Returns the company ID of this item type.
	*
	* @return the company ID of this item type
	*/
	@Override
	public long getCompanyId() {
		return _itemType.getCompanyId();
	}

	/**
	* Sets the company ID of this item type.
	*
	* @param companyId the company ID of this item type
	*/
	@Override
	public void setCompanyId(long companyId) {
		_itemType.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this item type.
	*
	* @return the group ID of this item type
	*/
	@Override
	public long getGroupId() {
		return _itemType.getGroupId();
	}

	/**
	* Sets the group ID of this item type.
	*
	* @param groupId the group ID of this item type
	*/
	@Override
	public void setGroupId(long groupId) {
		_itemType.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this item type.
	*
	* @return the user ID of this item type
	*/
	@Override
	public long getUserId() {
		return _itemType.getUserId();
	}

	/**
	* Sets the user ID of this item type.
	*
	* @param userId the user ID of this item type
	*/
	@Override
	public void setUserId(long userId) {
		_itemType.setUserId(userId);
	}

	/**
	* Returns the user uuid of this item type.
	*
	* @return the user uuid of this item type
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemType.getUserUuid();
	}

	/**
	* Sets the user uuid of this item type.
	*
	* @param userUuid the user uuid of this item type
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_itemType.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this item type.
	*
	* @return the create date of this item type
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _itemType.getCreateDate();
	}

	/**
	* Sets the create date of this item type.
	*
	* @param createDate the create date of this item type
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_itemType.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _itemType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_itemType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _itemType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_itemType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _itemType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _itemType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_itemType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _itemType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_itemType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_itemType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_itemType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ItemTypeWrapper((ItemType)_itemType.clone());
	}

	@Override
	public int compareTo(com.kencana.lms.model.ItemType itemType) {
		return _itemType.compareTo(itemType);
	}

	@Override
	public int hashCode() {
		return _itemType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.kencana.lms.model.ItemType> toCacheModel() {
		return _itemType.toCacheModel();
	}

	@Override
	public com.kencana.lms.model.ItemType toEscapedModel() {
		return new ItemTypeWrapper(_itemType.toEscapedModel());
	}

	@Override
	public com.kencana.lms.model.ItemType toUnescapedModel() {
		return new ItemTypeWrapper(_itemType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _itemType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _itemType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_itemType.persist();
	}

	@Override
	public java.lang.String getCoverURL(
		com.liferay.portal.theme.ThemeDisplay themeDisplay) {
		return _itemType.getCoverURL(themeDisplay);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ItemTypeWrapper)) {
			return false;
		}

		ItemTypeWrapper itemTypeWrapper = (ItemTypeWrapper)obj;

		if (Validator.equals(_itemType, itemTypeWrapper._itemType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ItemType getWrappedItemType() {
		return _itemType;
	}

	@Override
	public ItemType getWrappedModel() {
		return _itemType;
	}

	@Override
	public void resetOriginalValues() {
		_itemType.resetOriginalValues();
	}

	private ItemType _itemType;
}