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

import com.kencana.lms.service.CatalogTemplateSubfieldLocalServiceUtil;
import com.kencana.lms.service.ClpSerializer;

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
public class CatalogTemplateSubfieldClp extends BaseModelImpl<CatalogTemplateSubfield>
	implements CatalogTemplateSubfield {
	public CatalogTemplateSubfieldClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CatalogTemplateSubfield.class;
	}

	@Override
	public String getModelClassName() {
		return CatalogTemplateSubfield.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _catalogTemplateSubfieldId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCatalogTemplateSubfieldId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _catalogTemplateSubfieldId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("catalogTemplateSubfieldId",
			getCatalogTemplateSubfieldId());
		attributes.put("catalogTemplateTagId", getCatalogTemplateTagId());
		attributes.put("subfield", getSubfield());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("repeatable", getRepeatable());
		attributes.put("mandatory", getMandatory());
		attributes.put("isURL", getIsURL());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long catalogTemplateSubfieldId = (Long)attributes.get(
				"catalogTemplateSubfieldId");

		if (catalogTemplateSubfieldId != null) {
			setCatalogTemplateSubfieldId(catalogTemplateSubfieldId);
		}

		Long catalogTemplateTagId = (Long)attributes.get("catalogTemplateTagId");

		if (catalogTemplateTagId != null) {
			setCatalogTemplateTagId(catalogTemplateTagId);
		}

		String subfield = (String)attributes.get("subfield");

		if (subfield != null) {
			setSubfield(subfield);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Boolean repeatable = (Boolean)attributes.get("repeatable");

		if (repeatable != null) {
			setRepeatable(repeatable);
		}

		Boolean mandatory = (Boolean)attributes.get("mandatory");

		if (mandatory != null) {
			setMandatory(mandatory);
		}

		Boolean isURL = (Boolean)attributes.get("isURL");

		if (isURL != null) {
			setIsURL(isURL);
		}
	}

	@Override
	public long getCatalogTemplateSubfieldId() {
		return _catalogTemplateSubfieldId;
	}

	@Override
	public void setCatalogTemplateSubfieldId(long catalogTemplateSubfieldId) {
		_catalogTemplateSubfieldId = catalogTemplateSubfieldId;

		if (_catalogTemplateSubfieldRemoteModel != null) {
			try {
				Class<?> clazz = _catalogTemplateSubfieldRemoteModel.getClass();

				Method method = clazz.getMethod("setCatalogTemplateSubfieldId",
						long.class);

				method.invoke(_catalogTemplateSubfieldRemoteModel,
					catalogTemplateSubfieldId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCatalogTemplateTagId() {
		return _catalogTemplateTagId;
	}

	@Override
	public void setCatalogTemplateTagId(long catalogTemplateTagId) {
		_catalogTemplateTagId = catalogTemplateTagId;

		if (_catalogTemplateSubfieldRemoteModel != null) {
			try {
				Class<?> clazz = _catalogTemplateSubfieldRemoteModel.getClass();

				Method method = clazz.getMethod("setCatalogTemplateTagId",
						long.class);

				method.invoke(_catalogTemplateSubfieldRemoteModel,
					catalogTemplateTagId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubfield() {
		return _subfield;
	}

	@Override
	public void setSubfield(String subfield) {
		_subfield = subfield;

		if (_catalogTemplateSubfieldRemoteModel != null) {
			try {
				Class<?> clazz = _catalogTemplateSubfieldRemoteModel.getClass();

				Method method = clazz.getMethod("setSubfield", String.class);

				method.invoke(_catalogTemplateSubfieldRemoteModel, subfield);
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

		if (_catalogTemplateSubfieldRemoteModel != null) {
			try {
				Class<?> clazz = _catalogTemplateSubfieldRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_catalogTemplateSubfieldRemoteModel, groupId);
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

		if (_catalogTemplateSubfieldRemoteModel != null) {
			try {
				Class<?> clazz = _catalogTemplateSubfieldRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_catalogTemplateSubfieldRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getRepeatable() {
		return _repeatable;
	}

	@Override
	public boolean isRepeatable() {
		return _repeatable;
	}

	@Override
	public void setRepeatable(boolean repeatable) {
		_repeatable = repeatable;

		if (_catalogTemplateSubfieldRemoteModel != null) {
			try {
				Class<?> clazz = _catalogTemplateSubfieldRemoteModel.getClass();

				Method method = clazz.getMethod("setRepeatable", boolean.class);

				method.invoke(_catalogTemplateSubfieldRemoteModel, repeatable);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getMandatory() {
		return _mandatory;
	}

	@Override
	public boolean isMandatory() {
		return _mandatory;
	}

	@Override
	public void setMandatory(boolean mandatory) {
		_mandatory = mandatory;

		if (_catalogTemplateSubfieldRemoteModel != null) {
			try {
				Class<?> clazz = _catalogTemplateSubfieldRemoteModel.getClass();

				Method method = clazz.getMethod("setMandatory", boolean.class);

				method.invoke(_catalogTemplateSubfieldRemoteModel, mandatory);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsURL() {
		return _isURL;
	}

	@Override
	public boolean isIsURL() {
		return _isURL;
	}

	@Override
	public void setIsURL(boolean isURL) {
		_isURL = isURL;

		if (_catalogTemplateSubfieldRemoteModel != null) {
			try {
				Class<?> clazz = _catalogTemplateSubfieldRemoteModel.getClass();

				Method method = clazz.getMethod("setIsURL", boolean.class);

				method.invoke(_catalogTemplateSubfieldRemoteModel, isURL);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCatalogTemplateSubfieldRemoteModel() {
		return _catalogTemplateSubfieldRemoteModel;
	}

	public void setCatalogTemplateSubfieldRemoteModel(
		BaseModel<?> catalogTemplateSubfieldRemoteModel) {
		_catalogTemplateSubfieldRemoteModel = catalogTemplateSubfieldRemoteModel;
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

		Class<?> remoteModelClass = _catalogTemplateSubfieldRemoteModel.getClass();

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

		Object returnValue = method.invoke(_catalogTemplateSubfieldRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CatalogTemplateSubfieldLocalServiceUtil.addCatalogTemplateSubfield(this);
		}
		else {
			CatalogTemplateSubfieldLocalServiceUtil.updateCatalogTemplateSubfield(this);
		}
	}

	@Override
	public CatalogTemplateSubfield toEscapedModel() {
		return (CatalogTemplateSubfield)ProxyUtil.newProxyInstance(CatalogTemplateSubfield.class.getClassLoader(),
			new Class[] { CatalogTemplateSubfield.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CatalogTemplateSubfieldClp clone = new CatalogTemplateSubfieldClp();

		clone.setCatalogTemplateSubfieldId(getCatalogTemplateSubfieldId());
		clone.setCatalogTemplateTagId(getCatalogTemplateTagId());
		clone.setSubfield(getSubfield());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setRepeatable(getRepeatable());
		clone.setMandatory(getMandatory());
		clone.setIsURL(getIsURL());

		return clone;
	}

	@Override
	public int compareTo(CatalogTemplateSubfield catalogTemplateSubfield) {
		int value = 0;

		value = getSubfield()
					.compareToIgnoreCase(catalogTemplateSubfield.getSubfield());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CatalogTemplateSubfieldClp)) {
			return false;
		}

		CatalogTemplateSubfieldClp catalogTemplateSubfield = (CatalogTemplateSubfieldClp)obj;

		long primaryKey = catalogTemplateSubfield.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{catalogTemplateSubfieldId=");
		sb.append(getCatalogTemplateSubfieldId());
		sb.append(", catalogTemplateTagId=");
		sb.append(getCatalogTemplateTagId());
		sb.append(", subfield=");
		sb.append(getSubfield());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", repeatable=");
		sb.append(getRepeatable());
		sb.append(", mandatory=");
		sb.append(getMandatory());
		sb.append(", isURL=");
		sb.append(getIsURL());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.kencana.lms.model.CatalogTemplateSubfield");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>catalogTemplateSubfieldId</column-name><column-value><![CDATA[");
		sb.append(getCatalogTemplateSubfieldId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>catalogTemplateTagId</column-name><column-value><![CDATA[");
		sb.append(getCatalogTemplateTagId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subfield</column-name><column-value><![CDATA[");
		sb.append(getSubfield());
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
			"<column><column-name>repeatable</column-name><column-value><![CDATA[");
		sb.append(getRepeatable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mandatory</column-name><column-value><![CDATA[");
		sb.append(getMandatory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isURL</column-name><column-value><![CDATA[");
		sb.append(getIsURL());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _catalogTemplateSubfieldId;
	private long _catalogTemplateTagId;
	private String _subfield;
	private long _groupId;
	private long _companyId;
	private boolean _repeatable;
	private boolean _mandatory;
	private boolean _isURL;
	private BaseModel<?> _catalogTemplateSubfieldRemoteModel;
	private Class<?> _clpSerializerClass = com.kencana.lms.service.ClpSerializer.class;
}