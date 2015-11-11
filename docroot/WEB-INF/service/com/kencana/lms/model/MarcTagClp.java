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
import com.kencana.lms.service.MarcTagLocalServiceUtil;

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
public class MarcTagClp extends BaseModelImpl<MarcTag> implements MarcTag {
	public MarcTagClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return MarcTag.class;
	}

	@Override
	public String getModelClassName() {
		return MarcTag.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _tagId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTagId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tagId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tagId", getTagId());
		attributes.put("tag", getTag());
		attributes.put("description", getDescription());
		attributes.put("helpText", getHelpText());
		attributes.put("repetable", getRepetable());
		attributes.put("defaultValue", getDefaultValue());
		attributes.put("indicator1", getIndicator1());
		attributes.put("indicator2", getIndicator2());
		attributes.put("tagType", getTagType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tagId = (Long)attributes.get("tagId");

		if (tagId != null) {
			setTagId(tagId);
		}

		String tag = (String)attributes.get("tag");

		if (tag != null) {
			setTag(tag);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String helpText = (String)attributes.get("helpText");

		if (helpText != null) {
			setHelpText(helpText);
		}

		Boolean repetable = (Boolean)attributes.get("repetable");

		if (repetable != null) {
			setRepetable(repetable);
		}

		String defaultValue = (String)attributes.get("defaultValue");

		if (defaultValue != null) {
			setDefaultValue(defaultValue);
		}

		Boolean indicator1 = (Boolean)attributes.get("indicator1");

		if (indicator1 != null) {
			setIndicator1(indicator1);
		}

		Boolean indicator2 = (Boolean)attributes.get("indicator2");

		if (indicator2 != null) {
			setIndicator2(indicator2);
		}

		String tagType = (String)attributes.get("tagType");

		if (tagType != null) {
			setTagType(tagType);
		}
	}

	@Override
	public long getTagId() {
		return _tagId;
	}

	@Override
	public void setTagId(long tagId) {
		_tagId = tagId;

		if (_marcTagRemoteModel != null) {
			try {
				Class<?> clazz = _marcTagRemoteModel.getClass();

				Method method = clazz.getMethod("setTagId", long.class);

				method.invoke(_marcTagRemoteModel, tagId);
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

		if (_marcTagRemoteModel != null) {
			try {
				Class<?> clazz = _marcTagRemoteModel.getClass();

				Method method = clazz.getMethod("setTag", String.class);

				method.invoke(_marcTagRemoteModel, tag);
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

		if (_marcTagRemoteModel != null) {
			try {
				Class<?> clazz = _marcTagRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_marcTagRemoteModel, description);
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

		if (_marcTagRemoteModel != null) {
			try {
				Class<?> clazz = _marcTagRemoteModel.getClass();

				Method method = clazz.getMethod("setHelpText", String.class);

				method.invoke(_marcTagRemoteModel, helpText);
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

		if (_marcTagRemoteModel != null) {
			try {
				Class<?> clazz = _marcTagRemoteModel.getClass();

				Method method = clazz.getMethod("setRepetable", boolean.class);

				method.invoke(_marcTagRemoteModel, repetable);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDefaultValue() {
		return _defaultValue;
	}

	@Override
	public void setDefaultValue(String defaultValue) {
		_defaultValue = defaultValue;

		if (_marcTagRemoteModel != null) {
			try {
				Class<?> clazz = _marcTagRemoteModel.getClass();

				Method method = clazz.getMethod("setDefaultValue", String.class);

				method.invoke(_marcTagRemoteModel, defaultValue);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIndicator1() {
		return _indicator1;
	}

	@Override
	public boolean isIndicator1() {
		return _indicator1;
	}

	@Override
	public void setIndicator1(boolean indicator1) {
		_indicator1 = indicator1;

		if (_marcTagRemoteModel != null) {
			try {
				Class<?> clazz = _marcTagRemoteModel.getClass();

				Method method = clazz.getMethod("setIndicator1", boolean.class);

				method.invoke(_marcTagRemoteModel, indicator1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIndicator2() {
		return _indicator2;
	}

	@Override
	public boolean isIndicator2() {
		return _indicator2;
	}

	@Override
	public void setIndicator2(boolean indicator2) {
		_indicator2 = indicator2;

		if (_marcTagRemoteModel != null) {
			try {
				Class<?> clazz = _marcTagRemoteModel.getClass();

				Method method = clazz.getMethod("setIndicator2", boolean.class);

				method.invoke(_marcTagRemoteModel, indicator2);
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

		if (_marcTagRemoteModel != null) {
			try {
				Class<?> clazz = _marcTagRemoteModel.getClass();

				Method method = clazz.getMethod("setTagType", String.class);

				method.invoke(_marcTagRemoteModel, tagType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMarcTagRemoteModel() {
		return _marcTagRemoteModel;
	}

	public void setMarcTagRemoteModel(BaseModel<?> marcTagRemoteModel) {
		_marcTagRemoteModel = marcTagRemoteModel;
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

		Class<?> remoteModelClass = _marcTagRemoteModel.getClass();

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

		Object returnValue = method.invoke(_marcTagRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MarcTagLocalServiceUtil.addMarcTag(this);
		}
		else {
			MarcTagLocalServiceUtil.updateMarcTag(this);
		}
	}

	@Override
	public MarcTag toEscapedModel() {
		return (MarcTag)ProxyUtil.newProxyInstance(MarcTag.class.getClassLoader(),
			new Class[] { MarcTag.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MarcTagClp clone = new MarcTagClp();

		clone.setTagId(getTagId());
		clone.setTag(getTag());
		clone.setDescription(getDescription());
		clone.setHelpText(getHelpText());
		clone.setRepetable(getRepetable());
		clone.setDefaultValue(getDefaultValue());
		clone.setIndicator1(getIndicator1());
		clone.setIndicator2(getIndicator2());
		clone.setTagType(getTagType());

		return clone;
	}

	@Override
	public int compareTo(MarcTag marcTag) {
		int value = 0;

		value = getTag().compareToIgnoreCase(marcTag.getTag());

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

		if (!(obj instanceof MarcTagClp)) {
			return false;
		}

		MarcTagClp marcTag = (MarcTagClp)obj;

		long primaryKey = marcTag.getPrimaryKey();

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

		sb.append("{tagId=");
		sb.append(getTagId());
		sb.append(", tag=");
		sb.append(getTag());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", helpText=");
		sb.append(getHelpText());
		sb.append(", repetable=");
		sb.append(getRepetable());
		sb.append(", defaultValue=");
		sb.append(getDefaultValue());
		sb.append(", indicator1=");
		sb.append(getIndicator1());
		sb.append(", indicator2=");
		sb.append(getIndicator2());
		sb.append(", tagType=");
		sb.append(getTagType());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.kencana.lms.model.MarcTag");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>tagId</column-name><column-value><![CDATA[");
		sb.append(getTagId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tag</column-name><column-value><![CDATA[");
		sb.append(getTag());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>helpText</column-name><column-value><![CDATA[");
		sb.append(getHelpText());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>repetable</column-name><column-value><![CDATA[");
		sb.append(getRepetable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>defaultValue</column-name><column-value><![CDATA[");
		sb.append(getDefaultValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>indicator1</column-name><column-value><![CDATA[");
		sb.append(getIndicator1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>indicator2</column-name><column-value><![CDATA[");
		sb.append(getIndicator2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tagType</column-name><column-value><![CDATA[");
		sb.append(getTagType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _tagId;
	private String _tag;
	private String _description;
	private String _helpText;
	private boolean _repetable;
	private String _defaultValue;
	private boolean _indicator1;
	private boolean _indicator2;
	private String _tagType;
	private BaseModel<?> _marcTagRemoteModel;
	private Class<?> _clpSerializerClass = com.kencana.lms.service.ClpSerializer.class;
}