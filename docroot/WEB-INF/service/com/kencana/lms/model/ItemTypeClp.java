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
import com.kencana.lms.service.ItemTypeLocalServiceUtil;

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
public class ItemTypeClp extends BaseModelImpl<ItemType> implements ItemType {
	public ItemTypeClp() {
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
	public long getPrimaryKey() {
		return _itemTypeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setItemTypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _itemTypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getItemTypeId() {
		return _itemTypeId;
	}

	@Override
	public void setItemTypeId(long itemTypeId) {
		_itemTypeId = itemTypeId;

		if (_itemTypeRemoteModel != null) {
			try {
				Class<?> clazz = _itemTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setItemTypeId", long.class);

				method.invoke(_itemTypeRemoteModel, itemTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getItemTypeName() {
		return _itemTypeName;
	}

	@Override
	public void setItemTypeName(String itemTypeName) {
		_itemTypeName = itemTypeName;

		if (_itemTypeRemoteModel != null) {
			try {
				Class<?> clazz = _itemTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setItemTypeName", String.class);

				method.invoke(_itemTypeRemoteModel, itemTypeName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getNotForLoan() {
		return _notForLoan;
	}

	@Override
	public boolean isNotForLoan() {
		return _notForLoan;
	}

	@Override
	public void setNotForLoan(boolean notForLoan) {
		_notForLoan = notForLoan;

		if (_itemTypeRemoteModel != null) {
			try {
				Class<?> clazz = _itemTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setNotForLoan", boolean.class);

				method.invoke(_itemTypeRemoteModel, notForLoan);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCoverId() {
		return _coverId;
	}

	@Override
	public void setCoverId(long coverId) {
		_coverId = coverId;

		if (_itemTypeRemoteModel != null) {
			try {
				Class<?> clazz = _itemTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCoverId", long.class);

				method.invoke(_itemTypeRemoteModel, coverId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCheckoutMessage() {
		return _checkoutMessage;
	}

	@Override
	public void setCheckoutMessage(String checkoutMessage) {
		_checkoutMessage = checkoutMessage;

		if (_itemTypeRemoteModel != null) {
			try {
				Class<?> clazz = _itemTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCheckoutMessage",
						String.class);

				method.invoke(_itemTypeRemoteModel, checkoutMessage);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCheckinMessage() {
		return _checkinMessage;
	}

	@Override
	public void setCheckinMessage(String checkinMessage) {
		_checkinMessage = checkinMessage;

		if (_itemTypeRemoteModel != null) {
			try {
				Class<?> clazz = _itemTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCheckinMessage",
						String.class);

				method.invoke(_itemTypeRemoteModel, checkinMessage);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Double getRentalRate() {
		return _rentalRate;
	}

	@Override
	public void setRentalRate(Double rentalRate) {
		_rentalRate = rentalRate;

		if (_itemTypeRemoteModel != null) {
			try {
				Class<?> clazz = _itemTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setRentalRate", Double.class);

				method.invoke(_itemTypeRemoteModel, rentalRate);
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

		if (_itemTypeRemoteModel != null) {
			try {
				Class<?> clazz = _itemTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_itemTypeRemoteModel, companyId);
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

		if (_itemTypeRemoteModel != null) {
			try {
				Class<?> clazz = _itemTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_itemTypeRemoteModel, groupId);
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

		if (_itemTypeRemoteModel != null) {
			try {
				Class<?> clazz = _itemTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_itemTypeRemoteModel, userId);
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
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_itemTypeRemoteModel != null) {
			try {
				Class<?> clazz = _itemTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_itemTypeRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.lang.String getCoverURL(
		com.liferay.portal.theme.ThemeDisplay themeDisplay) {
		try {
			String methodName = "getCoverURL";

			Class<?>[] parameterTypes = new Class<?>[] {
					com.liferay.portal.theme.ThemeDisplay.class
				};

			Object[] parameterValues = new Object[] { themeDisplay };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getItemTypeRemoteModel() {
		return _itemTypeRemoteModel;
	}

	public void setItemTypeRemoteModel(BaseModel<?> itemTypeRemoteModel) {
		_itemTypeRemoteModel = itemTypeRemoteModel;
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

		Class<?> remoteModelClass = _itemTypeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_itemTypeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ItemTypeLocalServiceUtil.addItemType(this);
		}
		else {
			ItemTypeLocalServiceUtil.updateItemType(this);
		}
	}

	@Override
	public ItemType toEscapedModel() {
		return (ItemType)ProxyUtil.newProxyInstance(ItemType.class.getClassLoader(),
			new Class[] { ItemType.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ItemTypeClp clone = new ItemTypeClp();

		clone.setItemTypeId(getItemTypeId());
		clone.setItemTypeName(getItemTypeName());
		clone.setNotForLoan(getNotForLoan());
		clone.setCoverId(getCoverId());
		clone.setCheckoutMessage(getCheckoutMessage());
		clone.setCheckinMessage(getCheckinMessage());
		clone.setRentalRate(getRentalRate());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());

		return clone;
	}

	@Override
	public int compareTo(ItemType itemType) {
		long primaryKey = itemType.getPrimaryKey();

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

		if (!(obj instanceof ItemTypeClp)) {
			return false;
		}

		ItemTypeClp itemType = (ItemTypeClp)obj;

		long primaryKey = itemType.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{itemTypeId=");
		sb.append(getItemTypeId());
		sb.append(", itemTypeName=");
		sb.append(getItemTypeName());
		sb.append(", notForLoan=");
		sb.append(getNotForLoan());
		sb.append(", coverId=");
		sb.append(getCoverId());
		sb.append(", checkoutMessage=");
		sb.append(getCheckoutMessage());
		sb.append(", checkinMessage=");
		sb.append(getCheckinMessage());
		sb.append(", rentalRate=");
		sb.append(getRentalRate());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.kencana.lms.model.ItemType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>itemTypeId</column-name><column-value><![CDATA[");
		sb.append(getItemTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemTypeName</column-name><column-value><![CDATA[");
		sb.append(getItemTypeName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>notForLoan</column-name><column-value><![CDATA[");
		sb.append(getNotForLoan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>coverId</column-name><column-value><![CDATA[");
		sb.append(getCoverId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>checkoutMessage</column-name><column-value><![CDATA[");
		sb.append(getCheckoutMessage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>checkinMessage</column-name><column-value><![CDATA[");
		sb.append(getCheckinMessage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rentalRate</column-name><column-value><![CDATA[");
		sb.append(getRentalRate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _itemTypeId;
	private String _itemTypeName;
	private boolean _notForLoan;
	private long _coverId;
	private String _checkoutMessage;
	private String _checkinMessage;
	private Double _rentalRate;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private BaseModel<?> _itemTypeRemoteModel;
	private Class<?> _clpSerializerClass = com.kencana.lms.service.ClpSerializer.class;
}