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
import com.kencana.lms.service.PatronCategoryLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mazlan Mat
 */
public class PatronCategoryClp extends BaseModelImpl<PatronCategory>
	implements PatronCategory {
	public PatronCategoryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return PatronCategory.class;
	}

	@Override
	public String getModelClassName() {
		return PatronCategory.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _patronCategoryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPatronCategoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _patronCategoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("patronCategoryId", getPatronCategoryId());
		attributes.put("patronCategoryName", getPatronCategoryName());
		attributes.put("notes", getNotes());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long patronCategoryId = (Long)attributes.get("patronCategoryId");

		if (patronCategoryId != null) {
			setPatronCategoryId(patronCategoryId);
		}

		String patronCategoryName = (String)attributes.get("patronCategoryName");

		if (patronCategoryName != null) {
			setPatronCategoryName(patronCategoryName);
		}

		String notes = (String)attributes.get("notes");

		if (notes != null) {
			setNotes(notes);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}
	}

	@Override
	public long getPatronCategoryId() {
		return _patronCategoryId;
	}

	@Override
	public void setPatronCategoryId(long patronCategoryId) {
		_patronCategoryId = patronCategoryId;

		if (_patronCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _patronCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setPatronCategoryId",
						long.class);

				method.invoke(_patronCategoryRemoteModel, patronCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPatronCategoryName() {
		return _patronCategoryName;
	}

	@Override
	public void setPatronCategoryName(String patronCategoryName) {
		_patronCategoryName = patronCategoryName;

		if (_patronCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _patronCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setPatronCategoryName",
						String.class);

				method.invoke(_patronCategoryRemoteModel, patronCategoryName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNotes() {
		return _notes;
	}

	@Override
	public void setNotes(String notes) {
		_notes = notes;

		if (_patronCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _patronCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setNotes", String.class);

				method.invoke(_patronCategoryRemoteModel, notes);
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

		if (_patronCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _patronCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_patronCategoryRemoteModel, groupId);
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

		if (_patronCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _patronCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_patronCategoryRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPatronCategoryRemoteModel() {
		return _patronCategoryRemoteModel;
	}

	public void setPatronCategoryRemoteModel(
		BaseModel<?> patronCategoryRemoteModel) {
		_patronCategoryRemoteModel = patronCategoryRemoteModel;
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

		Class<?> remoteModelClass = _patronCategoryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_patronCategoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PatronCategoryLocalServiceUtil.addPatronCategory(this);
		}
		else {
			PatronCategoryLocalServiceUtil.updatePatronCategory(this);
		}
	}

	@Override
	public PatronCategory toEscapedModel() {
		return (PatronCategory)ProxyUtil.newProxyInstance(PatronCategory.class.getClassLoader(),
			new Class[] { PatronCategory.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PatronCategoryClp clone = new PatronCategoryClp();

		clone.setPatronCategoryId(getPatronCategoryId());
		clone.setPatronCategoryName(getPatronCategoryName());
		clone.setNotes(getNotes());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());

		return clone;
	}

	@Override
	public int compareTo(PatronCategory patronCategory) {
		long primaryKey = patronCategory.getPrimaryKey();

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

		if (!(obj instanceof PatronCategoryClp)) {
			return false;
		}

		PatronCategoryClp patronCategory = (PatronCategoryClp)obj;

		long primaryKey = patronCategory.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{patronCategoryId=");
		sb.append(getPatronCategoryId());
		sb.append(", patronCategoryName=");
		sb.append(getPatronCategoryName());
		sb.append(", notes=");
		sb.append(getNotes());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.kencana.lms.model.PatronCategory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>patronCategoryId</column-name><column-value><![CDATA[");
		sb.append(getPatronCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>patronCategoryName</column-name><column-value><![CDATA[");
		sb.append(getPatronCategoryName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>notes</column-name><column-value><![CDATA[");
		sb.append(getNotes());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _patronCategoryId;
	private String _patronCategoryName;
	private String _notes;
	private long _groupId;
	private long _companyId;
	private BaseModel<?> _patronCategoryRemoteModel;
	private Class<?> _clpSerializerClass = com.kencana.lms.service.ClpSerializer.class;
}