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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ItemCategory service. Represents a row in the &quot;Kencana_ItemCategory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.kencana.lms.model.impl.ItemCategoryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.kencana.lms.model.impl.ItemCategoryImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemCategory
 * @see com.kencana.lms.model.impl.ItemCategoryImpl
 * @see com.kencana.lms.model.impl.ItemCategoryModelImpl
 * @generated
 */
public interface ItemCategoryModel extends BaseModel<ItemCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a item category model instance should use the {@link ItemCategory} interface instead.
	 */

	/**
	 * Returns the primary key of this item category.
	 *
	 * @return the primary key of this item category
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this item category.
	 *
	 * @param primaryKey the primary key of this item category
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the item category ID of this item category.
	 *
	 * @return the item category ID of this item category
	 */
	public long getItemCategoryId();

	/**
	 * Sets the item category ID of this item category.
	 *
	 * @param itemCategoryId the item category ID of this item category
	 */
	public void setItemCategoryId(long itemCategoryId);

	/**
	 * Returns the item category name of this item category.
	 *
	 * @return the item category name of this item category
	 */
	@AutoEscape
	public String getItemCategoryName();

	/**
	 * Sets the item category name of this item category.
	 *
	 * @param itemCategoryName the item category name of this item category
	 */
	public void setItemCategoryName(String itemCategoryName);

	/**
	 * Returns the group ID of this item category.
	 *
	 * @return the group ID of this item category
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this item category.
	 *
	 * @param groupId the group ID of this item category
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this item category.
	 *
	 * @return the company ID of this item category
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this item category.
	 *
	 * @param companyId the company ID of this item category
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this item category.
	 *
	 * @return the create date of this item category
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this item category.
	 *
	 * @param createDate the create date of this item category
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the user ID of this item category.
	 *
	 * @return the user ID of this item category
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this item category.
	 *
	 * @param userId the user ID of this item category
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this item category.
	 *
	 * @return the user uuid of this item category
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this item category.
	 *
	 * @param userUuid the user uuid of this item category
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the modified date of this item category.
	 *
	 * @return the modified date of this item category
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this item category.
	 *
	 * @param modifiedDate the modified date of this item category
	 */
	public void setModifiedDate(Date modifiedDate);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(com.kencana.lms.model.ItemCategory itemCategory);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.kencana.lms.model.ItemCategory> toCacheModel();

	@Override
	public com.kencana.lms.model.ItemCategory toEscapedModel();

	@Override
	public com.kencana.lms.model.ItemCategory toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}