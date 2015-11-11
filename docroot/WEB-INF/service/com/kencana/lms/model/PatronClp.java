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
import com.kencana.lms.service.PatronLocalServiceUtil;

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
public class PatronClp extends BaseModelImpl<Patron> implements Patron {
	public PatronClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Patron.class;
	}

	@Override
	public String getModelClassName() {
		return Patron.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _patronId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPatronId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _patronId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("patronId", getPatronId());
		attributes.put("cardNumber", getCardNumber());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("expiryDate", getExpiryDate());
		attributes.put("patronCategoryId", getPatronCategoryId());
		attributes.put("patronStatusId", getPatronStatusId());
		attributes.put("patronNote", getPatronNote());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long patronId = (Long)attributes.get("patronId");

		if (patronId != null) {
			setPatronId(patronId);
		}

		String cardNumber = (String)attributes.get("cardNumber");

		if (cardNumber != null) {
			setCardNumber(cardNumber);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		Date expiryDate = (Date)attributes.get("expiryDate");

		if (expiryDate != null) {
			setExpiryDate(expiryDate);
		}

		Long patronCategoryId = (Long)attributes.get("patronCategoryId");

		if (patronCategoryId != null) {
			setPatronCategoryId(patronCategoryId);
		}

		Long patronStatusId = (Long)attributes.get("patronStatusId");

		if (patronStatusId != null) {
			setPatronStatusId(patronStatusId);
		}

		String patronNote = (String)attributes.get("patronNote");

		if (patronNote != null) {
			setPatronNote(patronNote);
		}
	}

	@Override
	public long getPatronId() {
		return _patronId;
	}

	@Override
	public void setPatronId(long patronId) {
		_patronId = patronId;

		if (_patronRemoteModel != null) {
			try {
				Class<?> clazz = _patronRemoteModel.getClass();

				Method method = clazz.getMethod("setPatronId", long.class);

				method.invoke(_patronRemoteModel, patronId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCardNumber() {
		return _cardNumber;
	}

	@Override
	public void setCardNumber(String cardNumber) {
		_cardNumber = cardNumber;

		if (_patronRemoteModel != null) {
			try {
				Class<?> clazz = _patronRemoteModel.getClass();

				Method method = clazz.getMethod("setCardNumber", String.class);

				method.invoke(_patronRemoteModel, cardNumber);
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

		if (_patronRemoteModel != null) {
			try {
				Class<?> clazz = _patronRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_patronRemoteModel, userId);
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
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_patronRemoteModel != null) {
			try {
				Class<?> clazz = _patronRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_patronRemoteModel, groupId);
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

		if (_patronRemoteModel != null) {
			try {
				Class<?> clazz = _patronRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_patronRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLibraryId() {
		return _libraryId;
	}

	@Override
	public void setLibraryId(long libraryId) {
		_libraryId = libraryId;

		if (_patronRemoteModel != null) {
			try {
				Class<?> clazz = _patronRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryId", long.class);

				method.invoke(_patronRemoteModel, libraryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getExpiryDate() {
		return _expiryDate;
	}

	@Override
	public void setExpiryDate(Date expiryDate) {
		_expiryDate = expiryDate;

		if (_patronRemoteModel != null) {
			try {
				Class<?> clazz = _patronRemoteModel.getClass();

				Method method = clazz.getMethod("setExpiryDate", Date.class);

				method.invoke(_patronRemoteModel, expiryDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPatronCategoryId() {
		return _patronCategoryId;
	}

	@Override
	public void setPatronCategoryId(long patronCategoryId) {
		_patronCategoryId = patronCategoryId;

		if (_patronRemoteModel != null) {
			try {
				Class<?> clazz = _patronRemoteModel.getClass();

				Method method = clazz.getMethod("setPatronCategoryId",
						long.class);

				method.invoke(_patronRemoteModel, patronCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPatronStatusId() {
		return _patronStatusId;
	}

	@Override
	public void setPatronStatusId(long patronStatusId) {
		_patronStatusId = patronStatusId;

		if (_patronRemoteModel != null) {
			try {
				Class<?> clazz = _patronRemoteModel.getClass();

				Method method = clazz.getMethod("setPatronStatusId", long.class);

				method.invoke(_patronRemoteModel, patronStatusId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPatronNote() {
		return _patronNote;
	}

	@Override
	public void setPatronNote(String patronNote) {
		_patronNote = patronNote;

		if (_patronRemoteModel != null) {
			try {
				Class<?> clazz = _patronRemoteModel.getClass();

				Method method = clazz.getMethod("setPatronNote", String.class);

				method.invoke(_patronRemoteModel, patronNote);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPatronRemoteModel() {
		return _patronRemoteModel;
	}

	public void setPatronRemoteModel(BaseModel<?> patronRemoteModel) {
		_patronRemoteModel = patronRemoteModel;
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

		Class<?> remoteModelClass = _patronRemoteModel.getClass();

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

		Object returnValue = method.invoke(_patronRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PatronLocalServiceUtil.addPatron(this);
		}
		else {
			PatronLocalServiceUtil.updatePatron(this);
		}
	}

	@Override
	public Patron toEscapedModel() {
		return (Patron)ProxyUtil.newProxyInstance(Patron.class.getClassLoader(),
			new Class[] { Patron.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PatronClp clone = new PatronClp();

		clone.setPatronId(getPatronId());
		clone.setCardNumber(getCardNumber());
		clone.setUserId(getUserId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setLibraryId(getLibraryId());
		clone.setExpiryDate(getExpiryDate());
		clone.setPatronCategoryId(getPatronCategoryId());
		clone.setPatronStatusId(getPatronStatusId());
		clone.setPatronNote(getPatronNote());

		return clone;
	}

	@Override
	public int compareTo(Patron patron) {
		long primaryKey = patron.getPrimaryKey();

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

		if (!(obj instanceof PatronClp)) {
			return false;
		}

		PatronClp patron = (PatronClp)obj;

		long primaryKey = patron.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{patronId=");
		sb.append(getPatronId());
		sb.append(", cardNumber=");
		sb.append(getCardNumber());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", libraryId=");
		sb.append(getLibraryId());
		sb.append(", expiryDate=");
		sb.append(getExpiryDate());
		sb.append(", patronCategoryId=");
		sb.append(getPatronCategoryId());
		sb.append(", patronStatusId=");
		sb.append(getPatronStatusId());
		sb.append(", patronNote=");
		sb.append(getPatronNote());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.kencana.lms.model.Patron");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>patronId</column-name><column-value><![CDATA[");
		sb.append(getPatronId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cardNumber</column-name><column-value><![CDATA[");
		sb.append(getCardNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
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
			"<column><column-name>libraryId</column-name><column-value><![CDATA[");
		sb.append(getLibraryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expiryDate</column-name><column-value><![CDATA[");
		sb.append(getExpiryDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>patronCategoryId</column-name><column-value><![CDATA[");
		sb.append(getPatronCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>patronStatusId</column-name><column-value><![CDATA[");
		sb.append(getPatronStatusId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>patronNote</column-name><column-value><![CDATA[");
		sb.append(getPatronNote());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _patronId;
	private String _cardNumber;
	private long _userId;
	private String _userUuid;
	private long _groupId;
	private long _companyId;
	private long _libraryId;
	private Date _expiryDate;
	private long _patronCategoryId;
	private long _patronStatusId;
	private String _patronNote;
	private BaseModel<?> _patronRemoteModel;
	private Class<?> _clpSerializerClass = com.kencana.lms.service.ClpSerializer.class;
}