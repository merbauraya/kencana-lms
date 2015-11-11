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
import com.kencana.lms.service.PatronStatusLocalServiceUtil;

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
public class PatronStatusClp extends BaseModelImpl<PatronStatus>
	implements PatronStatus {
	public PatronStatusClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return PatronStatus.class;
	}

	@Override
	public String getModelClassName() {
		return PatronStatus.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _patronStatusId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPatronStatusId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _patronStatusId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("patronStatusId", getPatronStatusId());
		attributes.put("patronStatusName", getPatronStatusName());
		attributes.put("noLogin", getNoLogin());
		attributes.put("noCheckout", getNoCheckout());
		attributes.put("noReserve", getNoReserve());
		attributes.put("noRenew", getNoRenew());
		attributes.put("color", getColor());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long patronStatusId = (Long)attributes.get("patronStatusId");

		if (patronStatusId != null) {
			setPatronStatusId(patronStatusId);
		}

		String patronStatusName = (String)attributes.get("patronStatusName");

		if (patronStatusName != null) {
			setPatronStatusName(patronStatusName);
		}

		Boolean noLogin = (Boolean)attributes.get("noLogin");

		if (noLogin != null) {
			setNoLogin(noLogin);
		}

		Boolean noCheckout = (Boolean)attributes.get("noCheckout");

		if (noCheckout != null) {
			setNoCheckout(noCheckout);
		}

		Boolean noReserve = (Boolean)attributes.get("noReserve");

		if (noReserve != null) {
			setNoReserve(noReserve);
		}

		Boolean noRenew = (Boolean)attributes.get("noRenew");

		if (noRenew != null) {
			setNoRenew(noRenew);
		}

		Integer color = (Integer)attributes.get("color");

		if (color != null) {
			setColor(color);
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
	public long getPatronStatusId() {
		return _patronStatusId;
	}

	@Override
	public void setPatronStatusId(long patronStatusId) {
		_patronStatusId = patronStatusId;

		if (_patronStatusRemoteModel != null) {
			try {
				Class<?> clazz = _patronStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setPatronStatusId", long.class);

				method.invoke(_patronStatusRemoteModel, patronStatusId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPatronStatusName() {
		return _patronStatusName;
	}

	@Override
	public void setPatronStatusName(String patronStatusName) {
		_patronStatusName = patronStatusName;

		if (_patronStatusRemoteModel != null) {
			try {
				Class<?> clazz = _patronStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setPatronStatusName",
						String.class);

				method.invoke(_patronStatusRemoteModel, patronStatusName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getNoLogin() {
		return _noLogin;
	}

	@Override
	public boolean isNoLogin() {
		return _noLogin;
	}

	@Override
	public void setNoLogin(boolean noLogin) {
		_noLogin = noLogin;

		if (_patronStatusRemoteModel != null) {
			try {
				Class<?> clazz = _patronStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setNoLogin", boolean.class);

				method.invoke(_patronStatusRemoteModel, noLogin);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getNoCheckout() {
		return _noCheckout;
	}

	@Override
	public boolean isNoCheckout() {
		return _noCheckout;
	}

	@Override
	public void setNoCheckout(boolean noCheckout) {
		_noCheckout = noCheckout;

		if (_patronStatusRemoteModel != null) {
			try {
				Class<?> clazz = _patronStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setNoCheckout", boolean.class);

				method.invoke(_patronStatusRemoteModel, noCheckout);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getNoReserve() {
		return _noReserve;
	}

	@Override
	public boolean isNoReserve() {
		return _noReserve;
	}

	@Override
	public void setNoReserve(boolean noReserve) {
		_noReserve = noReserve;

		if (_patronStatusRemoteModel != null) {
			try {
				Class<?> clazz = _patronStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setNoReserve", boolean.class);

				method.invoke(_patronStatusRemoteModel, noReserve);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getNoRenew() {
		return _noRenew;
	}

	@Override
	public boolean isNoRenew() {
		return _noRenew;
	}

	@Override
	public void setNoRenew(boolean noRenew) {
		_noRenew = noRenew;

		if (_patronStatusRemoteModel != null) {
			try {
				Class<?> clazz = _patronStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setNoRenew", boolean.class);

				method.invoke(_patronStatusRemoteModel, noRenew);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getColor() {
		return _color;
	}

	@Override
	public void setColor(int color) {
		_color = color;

		if (_patronStatusRemoteModel != null) {
			try {
				Class<?> clazz = _patronStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setColor", int.class);

				method.invoke(_patronStatusRemoteModel, color);
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

		if (_patronStatusRemoteModel != null) {
			try {
				Class<?> clazz = _patronStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_patronStatusRemoteModel, groupId);
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

		if (_patronStatusRemoteModel != null) {
			try {
				Class<?> clazz = _patronStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_patronStatusRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPatronStatusRemoteModel() {
		return _patronStatusRemoteModel;
	}

	public void setPatronStatusRemoteModel(BaseModel<?> patronStatusRemoteModel) {
		_patronStatusRemoteModel = patronStatusRemoteModel;
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

		Class<?> remoteModelClass = _patronStatusRemoteModel.getClass();

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

		Object returnValue = method.invoke(_patronStatusRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PatronStatusLocalServiceUtil.addPatronStatus(this);
		}
		else {
			PatronStatusLocalServiceUtil.updatePatronStatus(this);
		}
	}

	@Override
	public PatronStatus toEscapedModel() {
		return (PatronStatus)ProxyUtil.newProxyInstance(PatronStatus.class.getClassLoader(),
			new Class[] { PatronStatus.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PatronStatusClp clone = new PatronStatusClp();

		clone.setPatronStatusId(getPatronStatusId());
		clone.setPatronStatusName(getPatronStatusName());
		clone.setNoLogin(getNoLogin());
		clone.setNoCheckout(getNoCheckout());
		clone.setNoReserve(getNoReserve());
		clone.setNoRenew(getNoRenew());
		clone.setColor(getColor());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());

		return clone;
	}

	@Override
	public int compareTo(PatronStatus patronStatus) {
		long primaryKey = patronStatus.getPrimaryKey();

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

		if (!(obj instanceof PatronStatusClp)) {
			return false;
		}

		PatronStatusClp patronStatus = (PatronStatusClp)obj;

		long primaryKey = patronStatus.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{patronStatusId=");
		sb.append(getPatronStatusId());
		sb.append(", patronStatusName=");
		sb.append(getPatronStatusName());
		sb.append(", noLogin=");
		sb.append(getNoLogin());
		sb.append(", noCheckout=");
		sb.append(getNoCheckout());
		sb.append(", noReserve=");
		sb.append(getNoReserve());
		sb.append(", noRenew=");
		sb.append(getNoRenew());
		sb.append(", color=");
		sb.append(getColor());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.kencana.lms.model.PatronStatus");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>patronStatusId</column-name><column-value><![CDATA[");
		sb.append(getPatronStatusId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>patronStatusName</column-name><column-value><![CDATA[");
		sb.append(getPatronStatusName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noLogin</column-name><column-value><![CDATA[");
		sb.append(getNoLogin());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noCheckout</column-name><column-value><![CDATA[");
		sb.append(getNoCheckout());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noReserve</column-name><column-value><![CDATA[");
		sb.append(getNoReserve());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noRenew</column-name><column-value><![CDATA[");
		sb.append(getNoRenew());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>color</column-name><column-value><![CDATA[");
		sb.append(getColor());
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

	private long _patronStatusId;
	private String _patronStatusName;
	private boolean _noLogin;
	private boolean _noCheckout;
	private boolean _noReserve;
	private boolean _noRenew;
	private int _color;
	private long _groupId;
	private long _companyId;
	private BaseModel<?> _patronStatusRemoteModel;
	private Class<?> _clpSerializerClass = com.kencana.lms.service.ClpSerializer.class;
}