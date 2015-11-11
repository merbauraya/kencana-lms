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
import com.kencana.lms.service.MarcSubfieldLocalServiceUtil;

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
public class MarcSubfieldClp extends BaseModelImpl<MarcSubfield>
	implements MarcSubfield {
	public MarcSubfieldClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return MarcSubfield.class;
	}

	@Override
	public String getModelClassName() {
		return MarcSubfield.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _MarcSubfieldId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMarcSubfieldId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _MarcSubfieldId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("MarcSubfieldId", getMarcSubfieldId());
		attributes.put("tag", getTag());
		attributes.put("tagType", getTagType());
		attributes.put("subfield", getSubfield());
		attributes.put("description", getDescription());
		attributes.put("repetable", getRepetable());
		attributes.put("mandatory", getMandatory());
		attributes.put("authorisedValue", getAuthorisedValue());
		attributes.put("authTypeCode", getAuthTypeCode());
		attributes.put("isURL", getIsURL());
		attributes.put("helpText", getHelpText());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long MarcSubfieldId = (Long)attributes.get("MarcSubfieldId");

		if (MarcSubfieldId != null) {
			setMarcSubfieldId(MarcSubfieldId);
		}

		String tag = (String)attributes.get("tag");

		if (tag != null) {
			setTag(tag);
		}

		String tagType = (String)attributes.get("tagType");

		if (tagType != null) {
			setTagType(tagType);
		}

		String subfield = (String)attributes.get("subfield");

		if (subfield != null) {
			setSubfield(subfield);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Boolean repetable = (Boolean)attributes.get("repetable");

		if (repetable != null) {
			setRepetable(repetable);
		}

		Boolean mandatory = (Boolean)attributes.get("mandatory");

		if (mandatory != null) {
			setMandatory(mandatory);
		}

		String authorisedValue = (String)attributes.get("authorisedValue");

		if (authorisedValue != null) {
			setAuthorisedValue(authorisedValue);
		}

		String authTypeCode = (String)attributes.get("authTypeCode");

		if (authTypeCode != null) {
			setAuthTypeCode(authTypeCode);
		}

		Boolean isURL = (Boolean)attributes.get("isURL");

		if (isURL != null) {
			setIsURL(isURL);
		}

		String helpText = (String)attributes.get("helpText");

		if (helpText != null) {
			setHelpText(helpText);
		}
	}

	@Override
	public long getMarcSubfieldId() {
		return _MarcSubfieldId;
	}

	@Override
	public void setMarcSubfieldId(long MarcSubfieldId) {
		_MarcSubfieldId = MarcSubfieldId;

		if (_marcSubfieldRemoteModel != null) {
			try {
				Class<?> clazz = _marcSubfieldRemoteModel.getClass();

				Method method = clazz.getMethod("setMarcSubfieldId", long.class);

				method.invoke(_marcSubfieldRemoteModel, MarcSubfieldId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTag() {
		return _tag;
	}

	@Override
	public void setTag(String tag) {
		_tag = tag;

		if (_marcSubfieldRemoteModel != null) {
			try {
				Class<?> clazz = _marcSubfieldRemoteModel.getClass();

				Method method = clazz.getMethod("setTag", String.class);

				method.invoke(_marcSubfieldRemoteModel, tag);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTagType() {
		return _tagType;
	}

	@Override
	public void setTagType(String tagType) {
		_tagType = tagType;

		if (_marcSubfieldRemoteModel != null) {
			try {
				Class<?> clazz = _marcSubfieldRemoteModel.getClass();

				Method method = clazz.getMethod("setTagType", String.class);

				method.invoke(_marcSubfieldRemoteModel, tagType);
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

		if (_marcSubfieldRemoteModel != null) {
			try {
				Class<?> clazz = _marcSubfieldRemoteModel.getClass();

				Method method = clazz.getMethod("setSubfield", String.class);

				method.invoke(_marcSubfieldRemoteModel, subfield);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_marcSubfieldRemoteModel != null) {
			try {
				Class<?> clazz = _marcSubfieldRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_marcSubfieldRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getRepetable() {
		return _repetable;
	}

	@Override
	public boolean isRepetable() {
		return _repetable;
	}

	@Override
	public void setRepetable(boolean repetable) {
		_repetable = repetable;

		if (_marcSubfieldRemoteModel != null) {
			try {
				Class<?> clazz = _marcSubfieldRemoteModel.getClass();

				Method method = clazz.getMethod("setRepetable", boolean.class);

				method.invoke(_marcSubfieldRemoteModel, repetable);
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

		if (_marcSubfieldRemoteModel != null) {
			try {
				Class<?> clazz = _marcSubfieldRemoteModel.getClass();

				Method method = clazz.getMethod("setMandatory", boolean.class);

				method.invoke(_marcSubfieldRemoteModel, mandatory);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAuthorisedValue() {
		return _authorisedValue;
	}

	@Override
	public void setAuthorisedValue(String authorisedValue) {
		_authorisedValue = authorisedValue;

		if (_marcSubfieldRemoteModel != null) {
			try {
				Class<?> clazz = _marcSubfieldRemoteModel.getClass();

				Method method = clazz.getMethod("setAuthorisedValue",
						String.class);

				method.invoke(_marcSubfieldRemoteModel, authorisedValue);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAuthTypeCode() {
		return _authTypeCode;
	}

	@Override
	public void setAuthTypeCode(String authTypeCode) {
		_authTypeCode = authTypeCode;

		if (_marcSubfieldRemoteModel != null) {
			try {
				Class<?> clazz = _marcSubfieldRemoteModel.getClass();

				Method method = clazz.getMethod("setAuthTypeCode", String.class);

				method.invoke(_marcSubfieldRemoteModel, authTypeCode);
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

		if (_marcSubfieldRemoteModel != null) {
			try {
				Class<?> clazz = _marcSubfieldRemoteModel.getClass();

				Method method = clazz.getMethod("setIsURL", boolean.class);

				method.invoke(_marcSubfieldRemoteModel, isURL);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHelpText() {
		return _helpText;
	}

	@Override
	public void setHelpText(String helpText) {
		_helpText = helpText;

		if (_marcSubfieldRemoteModel != null) {
			try {
				Class<?> clazz = _marcSubfieldRemoteModel.getClass();

				Method method = clazz.getMethod("setHelpText", String.class);

				method.invoke(_marcSubfieldRemoteModel, helpText);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMarcSubfieldRemoteModel() {
		return _marcSubfieldRemoteModel;
	}

	public void setMarcSubfieldRemoteModel(BaseModel<?> marcSubfieldRemoteModel) {
		_marcSubfieldRemoteModel = marcSubfieldRemoteModel;
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

		Class<?> remoteModelClass = _marcSubfieldRemoteModel.getClass();

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

		Object returnValue = method.invoke(_marcSubfieldRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MarcSubfieldLocalServiceUtil.addMarcSubfield(this);
		}
		else {
			MarcSubfieldLocalServiceUtil.updateMarcSubfield(this);
		}
	}

	@Override
	public MarcSubfield toEscapedModel() {
		return (MarcSubfield)ProxyUtil.newProxyInstance(MarcSubfield.class.getClassLoader(),
			new Class[] { MarcSubfield.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MarcSubfieldClp clone = new MarcSubfieldClp();

		clone.setMarcSubfieldId(getMarcSubfieldId());
		clone.setTag(getTag());
		clone.setTagType(getTagType());
		clone.setSubfield(getSubfield());
		clone.setDescription(getDescription());
		clone.setRepetable(getRepetable());
		clone.setMandatory(getMandatory());
		clone.setAuthorisedValue(getAuthorisedValue());
		clone.setAuthTypeCode(getAuthTypeCode());
		clone.setIsURL(getIsURL());
		clone.setHelpText(getHelpText());

		return clone;
	}

	@Override
	public int compareTo(MarcSubfield marcSubfield) {
		int value = 0;

		value = getTag().compareToIgnoreCase(marcSubfield.getTag());

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

		if (!(obj instanceof MarcSubfieldClp)) {
			return false;
		}

		MarcSubfieldClp marcSubfield = (MarcSubfieldClp)obj;

		long primaryKey = marcSubfield.getPrimaryKey();

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

		sb.append("{MarcSubfieldId=");
		sb.append(getMarcSubfieldId());
		sb.append(", tag=");
		sb.append(getTag());
		sb.append(", tagType=");
		sb.append(getTagType());
		sb.append(", subfield=");
		sb.append(getSubfield());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", repetable=");
		sb.append(getRepetable());
		sb.append(", mandatory=");
		sb.append(getMandatory());
		sb.append(", authorisedValue=");
		sb.append(getAuthorisedValue());
		sb.append(", authTypeCode=");
		sb.append(getAuthTypeCode());
		sb.append(", isURL=");
		sb.append(getIsURL());
		sb.append(", helpText=");
		sb.append(getHelpText());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.kencana.lms.model.MarcSubfield");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>MarcSubfieldId</column-name><column-value><![CDATA[");
		sb.append(getMarcSubfieldId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tag</column-name><column-value><![CDATA[");
		sb.append(getTag());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tagType</column-name><column-value><![CDATA[");
		sb.append(getTagType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subfield</column-name><column-value><![CDATA[");
		sb.append(getSubfield());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>repetable</column-name><column-value><![CDATA[");
		sb.append(getRepetable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mandatory</column-name><column-value><![CDATA[");
		sb.append(getMandatory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>authorisedValue</column-name><column-value><![CDATA[");
		sb.append(getAuthorisedValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>authTypeCode</column-name><column-value><![CDATA[");
		sb.append(getAuthTypeCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isURL</column-name><column-value><![CDATA[");
		sb.append(getIsURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>helpText</column-name><column-value><![CDATA[");
		sb.append(getHelpText());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _MarcSubfieldId;
	private String _tag;
	private String _tagType;
	private String _subfield;
	private String _description;
	private boolean _repetable;
	private boolean _mandatory;
	private String _authorisedValue;
	private String _authTypeCode;
	private boolean _isURL;
	private String _helpText;
	private BaseModel<?> _marcSubfieldRemoteModel;
	private Class<?> _clpSerializerClass = com.kencana.lms.service.ClpSerializer.class;
}