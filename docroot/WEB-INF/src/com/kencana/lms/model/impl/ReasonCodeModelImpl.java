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

import com.kencana.lms.model.ReasonCode;
import com.kencana.lms.model.ReasonCodeModel;
import com.kencana.lms.model.ReasonCodeSoap;

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
 * The base model implementation for the ReasonCode service. Represents a row in the &quot;Kencana_ReasonCode&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.kencana.lms.model.ReasonCodeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ReasonCodeImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see ReasonCodeImpl
 * @see com.kencana.lms.model.ReasonCode
 * @see com.kencana.lms.model.ReasonCodeModel
 * @generated
 */
@JSON(strict = true)
public class ReasonCodeModelImpl extends BaseModelImpl<ReasonCode>
	implements ReasonCodeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a reason code model instance should use the {@link com.kencana.lms.model.ReasonCode} interface instead.
	 */
	public static final String TABLE_NAME = "Kencana_ReasonCode";
	public static final Object[][] TABLE_COLUMNS = {
			{ "reasonCodeId", Types.BIGINT },
			{ "reasonCodeName", Types.VARCHAR },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table Kencana_ReasonCode (reasonCodeId LONG not null primary key,reasonCodeName VARCHAR(75) null,groupId LONG,companyId LONG)";
	public static final String TABLE_SQL_DROP = "drop table Kencana_ReasonCode";
	public static final String ORDER_BY_JPQL = " ORDER BY reasonCode.reasonCodeId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Kencana_ReasonCode.reasonCodeId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.kencana.lms.model.ReasonCode"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.kencana.lms.model.ReasonCode"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.kencana.lms.model.ReasonCode"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long REASONCODEID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ReasonCode toModel(ReasonCodeSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ReasonCode model = new ReasonCodeImpl();

		model.setReasonCodeId(soapModel.getReasonCodeId());
		model.setReasonCodeName(soapModel.getReasonCodeName());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ReasonCode> toModels(ReasonCodeSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ReasonCode> models = new ArrayList<ReasonCode>(soapModels.length);

		for (ReasonCodeSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.kencana.lms.model.ReasonCode"));

	public ReasonCodeModelImpl() {
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
	public Class<?> getModelClass() {
		return ReasonCode.class;
	}

	@Override
	public String getModelClassName() {
		return ReasonCode.class.getName();
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

	@JSON
	@Override
	public long getReasonCodeId() {
		return _reasonCodeId;
	}

	@Override
	public void setReasonCodeId(long reasonCodeId) {
		_reasonCodeId = reasonCodeId;
	}

	@JSON
	@Override
	public String getReasonCodeName() {
		if (_reasonCodeName == null) {
			return StringPool.BLANK;
		}
		else {
			return _reasonCodeName;
		}
	}

	@Override
	public void setReasonCodeName(String reasonCodeName) {
		_reasonCodeName = reasonCodeName;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ReasonCode.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ReasonCode toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ReasonCode)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ReasonCodeImpl reasonCodeImpl = new ReasonCodeImpl();

		reasonCodeImpl.setReasonCodeId(getReasonCodeId());
		reasonCodeImpl.setReasonCodeName(getReasonCodeName());
		reasonCodeImpl.setGroupId(getGroupId());
		reasonCodeImpl.setCompanyId(getCompanyId());

		reasonCodeImpl.resetOriginalValues();

		return reasonCodeImpl;
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

		if (!(obj instanceof ReasonCode)) {
			return false;
		}

		ReasonCode reasonCode = (ReasonCode)obj;

		long primaryKey = reasonCode.getPrimaryKey();

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
		ReasonCodeModelImpl reasonCodeModelImpl = this;

		reasonCodeModelImpl._originalGroupId = reasonCodeModelImpl._groupId;

		reasonCodeModelImpl._setOriginalGroupId = false;

		reasonCodeModelImpl._originalCompanyId = reasonCodeModelImpl._companyId;

		reasonCodeModelImpl._setOriginalCompanyId = false;

		reasonCodeModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ReasonCode> toCacheModel() {
		ReasonCodeCacheModel reasonCodeCacheModel = new ReasonCodeCacheModel();

		reasonCodeCacheModel.reasonCodeId = getReasonCodeId();

		reasonCodeCacheModel.reasonCodeName = getReasonCodeName();

		String reasonCodeName = reasonCodeCacheModel.reasonCodeName;

		if ((reasonCodeName != null) && (reasonCodeName.length() == 0)) {
			reasonCodeCacheModel.reasonCodeName = null;
		}

		reasonCodeCacheModel.groupId = getGroupId();

		reasonCodeCacheModel.companyId = getCompanyId();

		return reasonCodeCacheModel;
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

	private static ClassLoader _classLoader = ReasonCode.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ReasonCode.class
		};
	private long _reasonCodeId;
	private String _reasonCodeName;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _columnBitmask;
	private ReasonCode _escapedModel;
}