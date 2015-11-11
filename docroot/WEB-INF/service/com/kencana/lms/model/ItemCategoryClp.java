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

import com.kencana.lms.service.ClpSerializer;
import com.kencana.lms.service.ItemCategoryLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mazlan Mat
 */
public class ItemCategoryClp extends BaseModelImpl<ItemCategory>
	implements ItemCategory {
	public ItemCategoryClp() {
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
	public long getPrimaryKey() {
		return _itemCategoryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setItemCategoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _itemCategoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getItemCategoryId() {
		return _itemCategoryId;
	}

	@Override
	public void setItemCategoryId(long itemCategoryId) {
		_itemCategoryId = itemCategoryId;

		if (_itemCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _itemCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setItemCategoryId", long.class);

				method.invoke(_itemCategoryRemoteModel, itemCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getItemCategoryName() {
		return _itemCategoryName;
	}

	@Override
	public void setItemCategoryName(String itemCategoryName) {
		_itemCategoryName = itemCategoryName;

		if (_itemCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _itemCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setItemCategoryName",
						String.class);

				method.invoke(_itemCategoryRemoteModel, itemCategoryName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_itemCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _itemCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_itemCategoryRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_itemCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _itemCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_itemCategoryRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_itemCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _itemCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_itemCategoryRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_itemCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _itemCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_itemCategoryRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_itemCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _itemCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_itemCategoryRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getItemCategoryRemoteModel() {
		return _itemCategoryRemoteModel;
	}

	public void setItemCategoryRemoteModel(BaseModel<?> itemCategoryRemoteModel) {
		_itemCategoryRemoteModel = itemCategoryRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _itemCategoryRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_itemCategoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ItemCategoryLocalServiceUtil.addItemCategory(this);
		}
		else {
			ItemCategoryLocalServiceUtil.updateItemCategory(this);
		}
	}

	@Override
	public ItemCategory toEscapedModel() {
		return (ItemCategory)ProxyUtil.newProxyInstance(ItemCategory.class.getClassLoader(),
			new Class[] { ItemCategory.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ItemCategoryClp clone = new ItemCategoryClp();

		clone.setItemCategoryId(getItemCategoryId());
		clone.setItemCategoryName(getItemCategoryName());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setCreateDate(getCreateDate());
		clone.setUserId(getUserId());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(ItemCategory itemCategory) {
		long primaryKey = itemCategory.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ItemCategoryClp)) {
			return false;
		}

		ItemCategoryClp itemCategory = (ItemCategoryClp)obj;

		long primaryKey = itemCategory.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{itemCategoryId=");
		sb.append(getItemCategoryId());
		sb.append(", itemCategoryName=");
		sb.append(getItemCategoryName());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.kencana.lms.model.ItemCategory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>itemCategoryId</column-name><column-value><![CDATA[");
		sb.append(getItemCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemCategoryName</column-name><column-value><![CDATA[");
		sb.append(getItemCategoryName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _itemCategoryId;
	private String _itemCategoryName;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private long _userId;
	private String _userUuid;
	private Date _modifiedDate;
	private BaseModel<?> _itemCategoryRemoteModel;
	private Class<?> _clpSerializerClass = com.kencana.lms.service.ClpSerializer.class;
}