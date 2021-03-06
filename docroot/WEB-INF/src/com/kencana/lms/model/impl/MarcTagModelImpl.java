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

package com.kencana.lms.model.impl;

import com.kencana.lms.model.MarcTag;
import com.kencana.lms.model.MarcTagModel;
import com.kencana.lms.model.MarcTagSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the MarcTag service. Represents a row in the &quot;Kencana_MarcTag&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.kencana.lms.model.MarcTagModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MarcTagImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see MarcTagImpl
 * @see com.kencana.lms.model.MarcTag
 * @see com.kencana.lms.model.MarcTagModel
 * @generated
 */
@JSON(strict = true)
public class MarcTagModelImpl extends BaseModelImpl<MarcTag>
	implements MarcTagModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a marc tag model instance should use the {@link com.kencana.lms.model.MarcTag} interface instead.
	 */
	public static final String TABLE_NAME = "Kencana_MarcTag";
	public static final Object[][] TABLE_COLUMNS = {
			{ "tagId", Types.BIGINT },
			{ "tag", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "helpText", Types.VARCHAR },
			{ "repetable", Types.BOOLEAN },
			{ "defaultValue", Types.VARCHAR },
			{ "indicator1", Types.BOOLEAN },
			{ "indicator2", Types.BOOLEAN },
			{ "tagType", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table Kencana_MarcTag (tagId LONG not null primary key,tag VARCHAR(75) null,description VARCHAR(75) null,helpText VARCHAR(75) null,repetable BOOLEAN,defaultValue VARCHAR(75) null,indicator1 BOOLEAN,indicator2 BOOLEAN,tagType VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table Kencana_MarcTag";
	public static final String ORDER_BY_JPQL = " ORDER BY marcTag.tag ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Kencana_MarcTag.tag ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.kencana.lms.model.MarcTag"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.kencana.lms.model.MarcTag"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.kencana.lms.model.MarcTag"),
			true);
	public static long TAG_COLUMN_BITMASK = 1L;
	public static long TAGTYPE_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static MarcTag toModel(MarcTagSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		MarcTag model = new MarcTagImpl();

		model.setTagId(soapModel.getTagId());
		model.setTag(soapModel.getTag());
		model.setDescription(soapModel.getDescription());
		model.setHelpText(soapModel.getHelpText());
		model.setRepetable(soapModel.getRepetable());
		model.setDefaultValue(soapModel.getDefaultValue());
		model.setIndicator1(soapModel.getIndicator1());
		model.setIndicator2(soapModel.getIndicator2());
		model.setTagType(soapModel.getTagType());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<MarcTag> toModels(MarcTagSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<MarcTag> models = new ArrayList<MarcTag>(soapModels.length);

		for (MarcTagSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.kencana.lms.model.MarcTag"));

	public MarcTagModelImpl() {
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
	public Class<?> getModelClass() {
		return MarcTag.class;
	}

	@Override
	public String getModelClassName() {
		return MarcTag.class.getName();
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

	@JSON
	@Override
	public long getTagId() {
		return _tagId;
	}

	@Override
	public void setTagId(long tagId) {
		_tagId = tagId;
	}

	@JSON
	@Override
	public String getTag() {
		if (_tag == null) {
			return StringPool.BLANK;
		}
		else {
			return _tag;
		}
	}

	@Override
	public void setTag(String tag) {
		_columnBitmask = -1L;

		if (_originalTag == null) {
			_originalTag = _tag;
		}

		_tag = tag;
	}

	public String getOriginalTag() {
		return GetterUtil.getString(_originalTag);
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@JSON
	@Override
	public String getHelpText() {
		if (_helpText == null) {
			return StringPool.BLANK;
		}
		else {
			return _helpText;
		}
	}

	@Override
	public void setHelpText(String helpText) {
		_helpText = helpText;
	}

	@JSON
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
	}

	@JSON
	@Override
	public String getDefaultValue() {
		if (_defaultValue == null) {
			return StringPool.BLANK;
		}
		else {
			return _defaultValue;
		}
	}

	@Override
	public void setDefaultValue(String defaultValue) {
		_defaultValue = defaultValue;
	}

	@JSON
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
	}

	@JSON
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
	}

	@JSON
	@Override
	public String getTagType() {
		if (_tagType == null) {
			return StringPool.BLANK;
		}
		else {
			return _tagType;
		}
	}

	@Override
	public void setTagType(String tagType) {
		_columnBitmask |= TAGTYPE_COLUMN_BITMASK;

		if (_originalTagType == null) {
			_originalTagType = _tagType;
		}

		_tagType = tagType;
	}

	public String getOriginalTagType() {
		return GetterUtil.getString(_originalTagType);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			MarcTag.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public MarcTag toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (MarcTag)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		MarcTagImpl marcTagImpl = new MarcTagImpl();

		marcTagImpl.setTagId(getTagId());
		marcTagImpl.setTag(getTag());
		marcTagImpl.setDescription(getDescription());
		marcTagImpl.setHelpText(getHelpText());
		marcTagImpl.setRepetable(getRepetable());
		marcTagImpl.setDefaultValue(getDefaultValue());
		marcTagImpl.setIndicator1(getIndicator1());
		marcTagImpl.setIndicator2(getIndicator2());
		marcTagImpl.setTagType(getTagType());

		marcTagImpl.resetOriginalValues();

		return marcTagImpl;
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

		if (!(obj instanceof MarcTag)) {
			return false;
		}

		MarcTag marcTag = (MarcTag)obj;

		long primaryKey = marcTag.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		MarcTagModelImpl marcTagModelImpl = this;

		marcTagModelImpl._originalTag = marcTagModelImpl._tag;

		marcTagModelImpl._originalTagType = marcTagModelImpl._tagType;

		marcTagModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<MarcTag> toCacheModel() {
		MarcTagCacheModel marcTagCacheModel = new MarcTagCacheModel();

		marcTagCacheModel.tagId = getTagId();

		marcTagCacheModel.tag = getTag();

		String tag = marcTagCacheModel.tag;

		if ((tag != null) && (tag.length() == 0)) {
			marcTagCacheModel.tag = null;
		}

		marcTagCacheModel.description = getDescription();

		String description = marcTagCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			marcTagCacheModel.description = null;
		}

		marcTagCacheModel.helpText = getHelpText();

		String helpText = marcTagCacheModel.helpText;

		if ((helpText != null) && (helpText.length() == 0)) {
			marcTagCacheModel.helpText = null;
		}

		marcTagCacheModel.repetable = getRepetable();

		marcTagCacheModel.defaultValue = getDefaultValue();

		String defaultValue = marcTagCacheModel.defaultValue;

		if ((defaultValue != null) && (defaultValue.length() == 0)) {
			marcTagCacheModel.defaultValue = null;
		}

		marcTagCacheModel.indicator1 = getIndicator1();

		marcTagCacheModel.indicator2 = getIndicator2();

		marcTagCacheModel.tagType = getTagType();

		String tagType = marcTagCacheModel.tagType;

		if ((tagType != null) && (tagType.length() == 0)) {
			marcTagCacheModel.tagType = null;
		}

		return marcTagCacheModel;
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

	private static ClassLoader _classLoader = MarcTag.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			MarcTag.class
		};
	private long _tagId;
	private String _tag;
	private String _originalTag;
	private String _description;
	private String _helpText;
	private boolean _repetable;
	private String _defaultValue;
	private boolean _indicator1;
	private boolean _indicator2;
	private String _tagType;
	private String _originalTagType;
	private long _columnBitmask;
	private MarcTag _escapedModel;
}