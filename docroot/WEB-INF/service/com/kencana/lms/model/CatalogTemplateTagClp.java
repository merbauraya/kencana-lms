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

import com.kencana.lms.service.CatalogTemplateTagLocalServiceUtil;
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
public class CatalogTemplateTagClp extends BaseModelImpl<CatalogTemplateTag>
	implements CatalogTemplateTag {
	public CatalogTemplateTagClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CatalogTemplateTag.class;
	}

	@Override
	public String getModelClassName() {
		return CatalogTemplateTag.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _catelogTemplateTagId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCatelogTemplateTagId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _catelogTemplateTagId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("catelogTemplateTagId", getCatelogTemplateTagId());
		attributes.put("catelogTemplateId", getCatelogTemplateId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("tag", getTag());
		attributes.put("repeatable", getRepeatable());
		attributes.put("mandatory", getMandatory());
		attributes.put("helpText", getHelpText());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long catelogTemplateTagId = (Long)attributes.get("catelogTemplateTagId");

		if (catelogTemplateTagId != null) {
			setCatelogTemplateTagId(catelogTemplateTagId);
		}

		Long catelogTemplateId = (Long)attributes.get("catelogTemplateId");

		if (catelogTemplateId != null) {
			setCatelogTemplateId(catelogTemplateId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String tag = (String)attributes.get("tag");

		if (tag != null) {
			setTag(tag);
		}

		Boolean repeatable = (Boolean)attributes.get("repeatable");

		if (repeatable != null) {
			setRepeatable(repeatable);
		}

		Boolean mandatory = (Boolean)attributes.get("mandatory");

		if (mandatory != null) {
			setMandatory(mandatory);
		}

		String helpText = (String)attributes.get("helpText");

		if (helpText != null) {
			setHelpText(helpText);
		}
	}

	@Override
	public long getCatelogTemplateTagId() {
		return _catelogTemplateTagId;
	}

	@Override
	public void setCatelogTemplateTagId(long catelogTemplateTagId) {
		_catelogTemplateTagId = catelogTemplateTagId;

		if (_catalogTemplateTagRemoteModel != null) {
			try {
				Class<?> clazz = _catalogTemplateTagRemoteModel.getClass();

				Method method = clazz.getMethod("setCatelogTemplateTagId",
						long.class);

				method.invoke(_catalogTemplateTagRemoteModel,
					catelogTemplateTagId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCatelogTemplateId() {
		return _catelogTemplateId;
	}

	@Override
	public void setCatelogTemplateId(long catelogTemplateId) {
		_catelogTemplateId = catelogTemplateId;

		if (_catalogTemplateTagRemoteModel != null) {
			try {
				Class<?> clazz = _catalogTemplateTagRemoteModel.getClass();

				Method method = clazz.getMethod("setCatelogTemplateId",
						long.class);

				method.invoke(_catalogTemplateTagRemoteModel, catelogTemplateId);
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

		if (_catalogTemplateTagRemoteModel != null) {
			try {
				Class<?> clazz = _catalogTemplateTagRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_catalogTemplateTagRemoteModel, groupId);
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

		if (_catalogTemplateTagRemoteModel != null) {
			try {
				Class<?> clazz = _catalogTemplateTagRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_catalogTemplateTagRemoteModel, companyId);
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

		if (_catalogTemplateTagRemoteModel != null) {
			try {
				Class<?> clazz = _catalogTemplateTagRemoteModel.getClass();

				Method method = clazz.getMethod("setTag", String.class);

				method.invoke(_catalogTemplateTagRemoteModel, tag);
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

		if (_catalogTemplateTagRemoteModel != null) {
			try {
				Class<?> clazz = _catalogTemplateTagRemoteModel.getClass();

				Method method = clazz.getMethod("setRepeatable", boolean.class);

				method.invoke(_catalogTemplateTagRemoteModel, repeatable);
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

		if (_catalogTemplateTagRemoteModel != null) {
			try {
				Class<?> clazz = _catalogTemplateTagRemoteModel.getClass();

				Method method = clazz.getMethod("setMandatory", boolean.class);

				method.invoke(_catalogTemplateTagRemoteModel, mandatory);
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

		if (_catalogTemplateTagRemoteModel != null) {
			try {
				Class<?> clazz = _catalogTemplateTagRemoteModel.getClass();

				Method method = clazz.getMethod("setHelpText", String.class);

				method.invoke(_catalogTemplateTagRemoteModel, helpText);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCatalogTemplateTagRemoteModel() {
		return _catalogTemplateTagRemoteModel;
	}

	public void setCatalogTemplateTagRemoteModel(
		BaseModel<?> catalogTemplateTagRemoteModel) {
		_catalogTemplateTagRemoteModel = catalogTemplateTagRemoteModel;
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

		Class<?> remoteModelClass = _catalogTemplateTagRemoteModel.getClass();

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

		Object returnValue = method.invoke(_catalogTemplateTagRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CatalogTemplateTagLocalServiceUtil.addCatalogTemplateTag(this);
		}
		else {
			CatalogTemplateTagLocalServiceUtil.updateCatalogTemplateTag(this);
		}
	}

	@Override
	public CatalogTemplateTag toEscapedModel() {
		return (CatalogTemplateTag)ProxyUtil.newProxyInstance(CatalogTemplateTag.class.getClassLoader(),
			new Class[] { CatalogTemplateTag.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CatalogTemplateTagClp clone = new CatalogTemplateTagClp();

		clone.setCatelogTemplateTagId(getCatelogTemplateTagId());
		clone.setCatelogTemplateId(getCatelogTemplateId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setTag(getTag());
		clone.setRepeatable(getRepeatable());
		clone.setMandatory(getMandatory());
		clone.setHelpText(getHelpText());

		return clone;
	}

	@Override
	public int compareTo(CatalogTemplateTag catalogTemplateTag) {
		int value = 0;

		value = getTag().compareToIgnoreCase(catalogTemplateTag.getTag());

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

		if (!(obj instanceof CatalogTemplateTagClp)) {
			return false;
		}

		CatalogTemplateTagClp catalogTemplateTag = (CatalogTemplateTagClp)obj;

		long primaryKey = catalogTemplateTag.getPrimaryKey();

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

		sb.append("{catelogTemplateTagId=");
		sb.append(getCatelogTemplateTagId());
		sb.append(", catelogTemplateId=");
		sb.append(getCatelogTemplateId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", tag=");
		sb.append(getTag());
		sb.append(", repeatable=");
		sb.append(getRepeatable());
		sb.append(", mandatory=");
		sb.append(getMandatory());
		sb.append(", helpText=");
		sb.append(getHelpText());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.kencana.lms.model.CatalogTemplateTag");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>catelogTemplateTagId</column-name><column-value><![CDATA[");
		sb.append(getCatelogTemplateTagId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>catelogTemplateId</column-name><column-value><![CDATA[");
		sb.append(getCatelogTemplateId());
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
			"<column><column-name>tag</column-name><column-value><![CDATA[");
		sb.append(getTag());
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
			"<column><column-name>helpText</column-name><column-value><![CDATA[");
		sb.append(getHelpText());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _catelogTemplateTagId;
	private long _catelogTemplateId;
	private long _groupId;
	private long _companyId;
	private String _tag;
	private boolean _repeatable;
	private boolean _mandatory;
	private String _helpText;
	private BaseModel<?> _catalogTemplateTagRemoteModel;
	private Class<?> _clpSerializerClass = com.kencana.lms.service.ClpSerializer.class;
}