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
import com.kencana.lms.service.ReasonCodeLocalServiceUtil;

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
public class ReasonCodeClp extends BaseModelImpl<ReasonCode>
	implements ReasonCode {
	public ReasonCodeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ReasonCode.class;
	}

	@Override
	public String getModelClassName() {
		return ReasonCode.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _reasonCodeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setReasonCodeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _reasonCodeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("reasonCodeId", getReasonCodeId());
		attributes.put("reasonCodeName", getReasonCodeName());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long reasonCodeId = (Long)attributes.get("reasonCodeId");

		if (reasonCodeId != null) {
			setReasonCodeId(reasonCodeId);
		}

		String reasonCodeName = (String)attributes.get("reasonCodeName");

		if (reasonCodeName != null) {
			setReasonCodeName(reasonCodeName);
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
	public long getReasonCodeId() {
		return _reasonCodeId;
	}

	@Override
	public void setReasonCodeId(long reasonCodeId) {
		_reasonCodeId = reasonCodeId;

		if (_reasonCodeRemoteModel != null) {
			try {
				Class<?> clazz = _reasonCodeRemoteModel.getClass();

				Method method = clazz.getMethod("setReasonCodeId", long.class);

				method.invoke(_reasonCodeRemoteModel, reasonCodeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReasonCodeName() {
		return _reasonCodeName;
	}

	@Override
	public void setReasonCodeName(String reasonCodeName) {
		_reasonCodeName = reasonCodeName;

		if (_reasonCodeRemoteModel != null) {
			try {
				Class<?> clazz = _reasonCodeRemoteModel.getClass();

				Method method = clazz.getMethod("setReasonCodeName",
						String.class);

				method.invoke(_reasonCodeRemoteModel, reasonCodeName);
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

		if (_reasonCodeRemoteModel != null) {
			try {
				Class<?> clazz = _reasonCodeRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_reasonCodeRemoteModel, groupId);
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

		if (_reasonCodeRemoteModel != null) {
			try {
				Class<?> clazz = _reasonCodeRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_reasonCodeRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getReasonCodeRemoteModel() {
		return _reasonCodeRemoteModel;
	}

	public void setReasonCodeRemoteModel(BaseModel<?> reasonCodeRemoteModel) {
		_reasonCodeRemoteModel = reasonCodeRemoteModel;
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

		Class<?> remoteModelClass = _reasonCodeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_reasonCodeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ReasonCodeLocalServiceUtil.addReasonCode(this);
		}
		else {
			ReasonCodeLocalServiceUtil.updateReasonCode(this);
		}
	}

	@Override
	public ReasonCode toEscapedModel() {
		return (ReasonCode)ProxyUtil.newProxyInstance(ReasonCode.class.getClassLoader(),
			new Class[] { ReasonCode.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ReasonCodeClp clone = new ReasonCodeClp();

		clone.setReasonCodeId(getReasonCodeId());
		clone.setReasonCodeName(getReasonCodeName());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());

		return clone;
	}

	@Override
	public int compareTo(ReasonCode reasonCode) {
		long primaryKey = reasonCode.getPrimaryKey();

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

		if (!(obj instanceof ReasonCodeClp)) {
			return false;
		}

		ReasonCodeClp reasonCode = (ReasonCodeClp)obj;

		long primaryKey = reasonCode.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{reasonCodeId=");
		sb.append(getReasonCodeId());
		sb.append(", reasonCodeName=");
		sb.append(getReasonCodeName());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.kencana.lms.model.ReasonCode");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>reasonCodeId</column-name><column-value><![CDATA[");
		sb.append(getReasonCodeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reasonCodeName</column-name><column-value><![CDATA[");
		sb.append(getReasonCodeName());
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

	private long _reasonCodeId;
	private String _reasonCodeName;
	private long _groupId;
	private long _companyId;
	private BaseModel<?> _reasonCodeRemoteModel;
	private Class<?> _clpSerializerClass = com.kencana.lms.service.ClpSerializer.class;
}