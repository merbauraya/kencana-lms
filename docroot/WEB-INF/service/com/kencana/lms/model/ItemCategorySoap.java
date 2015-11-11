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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.kencana.lms.service.http.ItemCategoryServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.kencana.lms.service.http.ItemCategoryServiceSoap
 * @generated
 */
public class ItemCategorySoap implements Serializable {
	public static ItemCategorySoap toSoapModel(ItemCategory model) {
		ItemCategorySoap soapModel = new ItemCategorySoap();

		soapModel.setItemCategoryId(model.getItemCategoryId());
		soapModel.setItemCategoryName(model.getItemCategoryName());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static ItemCategorySoap[] toSoapModels(ItemCategory[] models) {
		ItemCategorySoap[] soapModels = new ItemCategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ItemCategorySoap[][] toSoapModels(ItemCategory[][] models) {
		ItemCategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ItemCategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ItemCategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ItemCategorySoap[] toSoapModels(List<ItemCategory> models) {
		List<ItemCategorySoap> soapModels = new ArrayList<ItemCategorySoap>(models.size());

		for (ItemCategory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ItemCategorySoap[soapModels.size()]);
	}

	public ItemCategorySoap() {
	}

	public long getPrimaryKey() {
		return _itemCategoryId;
	}

	public void setPrimaryKey(long pk) {
		setItemCategoryId(pk);
	}

	public long getItemCategoryId() {
		return _itemCategoryId;
	}

	public void setItemCategoryId(long itemCategoryId) {
		_itemCategoryId = itemCategoryId;
	}

	public String getItemCategoryName() {
		return _itemCategoryName;
	}

	public void setItemCategoryName(String itemCategoryName) {
		_itemCategoryName = itemCategoryName;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _itemCategoryId;
	private String _itemCategoryName;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private long _userId;
	private Date _modifiedDate;
}