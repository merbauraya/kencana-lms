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

import com.kencana.lms.model.CircTransHistory;
import com.kencana.lms.model.CircTransHistoryModel;
import com.kencana.lms.model.CircTransHistorySoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the CircTransHistory service. Represents a row in the &quot;Kencana_CircTransHistory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.kencana.lms.model.CircTransHistoryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CircTransHistoryImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see CircTransHistoryImpl
 * @see com.kencana.lms.model.CircTransHistory
 * @see com.kencana.lms.model.CircTransHistoryModel
 * @generated
 */
@JSON(strict = true)
public class CircTransHistoryModelImpl extends BaseModelImpl<CircTransHistory>
	implements CircTransHistoryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a circ trans history model instance should use the {@link com.kencana.lms.model.CircTransHistory} interface instead.
	 */
	public static final String TABLE_NAME = "Kencana_CircTransHistory";
	public static final Object[][] TABLE_COLUMNS = {
			{ "transId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "libraryId", Types.BIGINT },
			{ "patronId", Types.BIGINT },
			{ "catalogItemId", Types.BIGINT },
			{ "transDate", Types.TIMESTAMP },
			{ "dueDate", Types.TIMESTAMP },
			{ "overdue", Types.BOOLEAN },
			{ "returnDate", Types.TIMESTAMP },
			{ "lastRenewDate", Types.TIMESTAMP },
			{ "renewCount", Types.INTEGER },
			{ "fineAmount", Types.DOUBLE }
		};
	public static final String TABLE_SQL_CREATE = "create table Kencana_CircTransHistory (transId LONG not null primary key,companyId LONG,groupId LONG,libraryId LONG,patronId LONG,catalogItemId LONG,transDate DATE null,dueDate DATE null,overdue BOOLEAN,returnDate DATE null,lastRenewDate DATE null,renewCount INTEGER,fineAmount DOUBLE)";
	public static final String TABLE_SQL_DROP = "drop table Kencana_CircTransHistory";
	public static final String ORDER_BY_JPQL = " ORDER BY circTransHistory.transId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Kencana_CircTransHistory.transId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.kencana.lms.model.CircTransHistory"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.kencana.lms.model.CircTransHistory"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.kencana.lms.model.CircTransHistory"),
			true);
	public static long CATALOGITEMID_COLUMN_BITMASK = 1L;
	public static long COMPANYID_COLUMN_BITMASK = 2L;
	public static long GROUPID_COLUMN_BITMASK = 4L;
	public static long LIBRARYID_COLUMN_BITMASK = 8L;
	public static long PATRONID_COLUMN_BITMASK = 16L;
	public static long TRANSID_COLUMN_BITMASK = 32L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CircTransHistory toModel(CircTransHistorySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CircTransHistory model = new CircTransHistoryImpl();

		model.setTransId(soapModel.getTransId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setGroupId(soapModel.getGroupId());
		model.setLibraryId(soapModel.getLibraryId());
		model.setPatronId(soapModel.getPatronId());
		model.setCatalogItemId(soapModel.getCatalogItemId());
		model.setTransDate(soapModel.getTransDate());
		model.setDueDate(soapModel.getDueDate());
		model.setOverdue(soapModel.getOverdue());
		model.setReturnDate(soapModel.getReturnDate());
		model.setLastRenewDate(soapModel.getLastRenewDate());
		model.setRenewCount(soapModel.getRenewCount());
		model.setFineAmount(soapModel.getFineAmount());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CircTransHistory> toModels(
		CircTransHistorySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CircTransHistory> models = new ArrayList<CircTransHistory>(soapModels.length);

		for (CircTransHistorySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.kencana.lms.model.CircTransHistory"));

	public CircTransHistoryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _transId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTransId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _transId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CircTransHistory.class;
	}

	@Override
	public String getModelClassName() {
		return CircTransHistory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("transId", getTransId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("patronId", getPatronId());
		attributes.put("catalogItemId", getCatalogItemId());
		attributes.put("transDate", getTransDate());
		attributes.put("dueDate", getDueDate());
		attributes.put("overdue", getOverdue());
		attributes.put("returnDate", getReturnDate());
		attributes.put("lastRenewDate", getLastRenewDate());
		attributes.put("renewCount", getRenewCount());
		attributes.put("fineAmount", getFineAmount());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long transId = (Long)attributes.get("transId");

		if (transId != null) {
			setTransId(transId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		Long patronId = (Long)attributes.get("patronId");

		if (patronId != null) {
			setPatronId(patronId);
		}

		Long catalogItemId = (Long)attributes.get("catalogItemId");

		if (catalogItemId != null) {
			setCatalogItemId(catalogItemId);
		}

		Date transDate = (Date)attributes.get("transDate");

		if (transDate != null) {
			setTransDate(transDate);
		}

		Date dueDate = (Date)attributes.get("dueDate");

		if (dueDate != null) {
			setDueDate(dueDate);
		}

		Boolean overdue = (Boolean)attributes.get("overdue");

		if (overdue != null) {
			setOverdue(overdue);
		}

		Date returnDate = (Date)attributes.get("returnDate");

		if (returnDate != null) {
			setReturnDate(returnDate);
		}

		Date lastRenewDate = (Date)attributes.get("lastRenewDate");

		if (lastRenewDate != null) {
			setLastRenewDate(lastRenewDate);
		}

		Integer renewCount = (Integer)attributes.get("renewCount");

		if (renewCount != null) {
			setRenewCount(renewCount);
		}

		Double fineAmount = (Double)attributes.get("fineAmount");

		if (fineAmount != null) {
			setFineAmount(fineAmount);
		}
	}

	@JSON
	@Override
	public long getTransId() {
		return _transId;
	}

	@Override
	public void setTransId(long transId) {
		_transId = transId;
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
	public long getLibraryId() {
		return _libraryId;
	}

	@Override
	public void setLibraryId(long libraryId) {
		_columnBitmask |= LIBRARYID_COLUMN_BITMASK;

		if (!_setOriginalLibraryId) {
			_setOriginalLibraryId = true;

			_originalLibraryId = _libraryId;
		}

		_libraryId = libraryId;
	}

	public long getOriginalLibraryId() {
		return _originalLibraryId;
	}

	@JSON
	@Override
	public long getPatronId() {
		return _patronId;
	}

	@Override
	public void setPatronId(long patronId) {
		_columnBitmask |= PATRONID_COLUMN_BITMASK;

		if (!_setOriginalPatronId) {
			_setOriginalPatronId = true;

			_originalPatronId = _patronId;
		}

		_patronId = patronId;
	}

	public long getOriginalPatronId() {
		return _originalPatronId;
	}

	@JSON
	@Override
	public long getCatalogItemId() {
		return _catalogItemId;
	}

	@Override
	public void setCatalogItemId(long catalogItemId) {
		_columnBitmask |= CATALOGITEMID_COLUMN_BITMASK;

		if (!_setOriginalCatalogItemId) {
			_setOriginalCatalogItemId = true;

			_originalCatalogItemId = _catalogItemId;
		}

		_catalogItemId = catalogItemId;
	}

	public long getOriginalCatalogItemId() {
		return _originalCatalogItemId;
	}

	@JSON
	@Override
	public Date getTransDate() {
		return _transDate;
	}

	@Override
	public void setTransDate(Date transDate) {
		_transDate = transDate;
	}

	@JSON
	@Override
	public Date getDueDate() {
		return _dueDate;
	}

	@Override
	public void setDueDate(Date dueDate) {
		_dueDate = dueDate;
	}

	@JSON
	@Override
	public boolean getOverdue() {
		return _overdue;
	}

	@Override
	public boolean isOverdue() {
		return _overdue;
	}

	@Override
	public void setOverdue(boolean overdue) {
		_overdue = overdue;
	}

	@JSON
	@Override
	public Date getReturnDate() {
		return _returnDate;
	}

	@Override
	public void setReturnDate(Date returnDate) {
		_returnDate = returnDate;
	}

	@JSON
	@Override
	public Date getLastRenewDate() {
		return _lastRenewDate;
	}

	@Override
	public void setLastRenewDate(Date lastRenewDate) {
		_lastRenewDate = lastRenewDate;
	}

	@JSON
	@Override
	public int getRenewCount() {
		return _renewCount;
	}

	@Override
	public void setRenewCount(int renewCount) {
		_renewCount = renewCount;
	}

	@JSON
	@Override
	public Double getFineAmount() {
		return _fineAmount;
	}

	@Override
	public void setFineAmount(Double fineAmount) {
		_fineAmount = fineAmount;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			CircTransHistory.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CircTransHistory toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CircTransHistory)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CircTransHistoryImpl circTransHistoryImpl = new CircTransHistoryImpl();

		circTransHistoryImpl.setTransId(getTransId());
		circTransHistoryImpl.setCompanyId(getCompanyId());
		circTransHistoryImpl.setGroupId(getGroupId());
		circTransHistoryImpl.setLibraryId(getLibraryId());
		circTransHistoryImpl.setPatronId(getPatronId());
		circTransHistoryImpl.setCatalogItemId(getCatalogItemId());
		circTransHistoryImpl.setTransDate(getTransDate());
		circTransHistoryImpl.setDueDate(getDueDate());
		circTransHistoryImpl.setOverdue(getOverdue());
		circTransHistoryImpl.setReturnDate(getReturnDate());
		circTransHistoryImpl.setLastRenewDate(getLastRenewDate());
		circTransHistoryImpl.setRenewCount(getRenewCount());
		circTransHistoryImpl.setFineAmount(getFineAmount());

		circTransHistoryImpl.resetOriginalValues();

		return circTransHistoryImpl;
	}

	@Override
	public int compareTo(CircTransHistory circTransHistory) {
		long primaryKey = circTransHistory.getPrimaryKey();

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

		if (!(obj instanceof CircTransHistory)) {
			return false;
		}

		CircTransHistory circTransHistory = (CircTransHistory)obj;

		long primaryKey = circTransHistory.getPrimaryKey();

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
		CircTransHistoryModelImpl circTransHistoryModelImpl = this;

		circTransHistoryModelImpl._originalCompanyId = circTransHistoryModelImpl._companyId;

		circTransHistoryModelImpl._setOriginalCompanyId = false;

		circTransHistoryModelImpl._originalGroupId = circTransHistoryModelImpl._groupId;

		circTransHistoryModelImpl._setOriginalGroupId = false;

		circTransHistoryModelImpl._originalLibraryId = circTransHistoryModelImpl._libraryId;

		circTransHistoryModelImpl._setOriginalLibraryId = false;

		circTransHistoryModelImpl._originalPatronId = circTransHistoryModelImpl._patronId;

		circTransHistoryModelImpl._setOriginalPatronId = false;

		circTransHistoryModelImpl._originalCatalogItemId = circTransHistoryModelImpl._catalogItemId;

		circTransHistoryModelImpl._setOriginalCatalogItemId = false;

		circTransHistoryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CircTransHistory> toCacheModel() {
		CircTransHistoryCacheModel circTransHistoryCacheModel = new CircTransHistoryCacheModel();

		circTransHistoryCacheModel.transId = getTransId();

		circTransHistoryCacheModel.companyId = getCompanyId();

		circTransHistoryCacheModel.groupId = getGroupId();

		circTransHistoryCacheModel.libraryId = getLibraryId();

		circTransHistoryCacheModel.patronId = getPatronId();

		circTransHistoryCacheModel.catalogItemId = getCatalogItemId();

		Date transDate = getTransDate();

		if (transDate != null) {
			circTransHistoryCacheModel.transDate = transDate.getTime();
		}
		else {
			circTransHistoryCacheModel.transDate = Long.MIN_VALUE;
		}

		Date dueDate = getDueDate();

		if (dueDate != null) {
			circTransHistoryCacheModel.dueDate = dueDate.getTime();
		}
		else {
			circTransHistoryCacheModel.dueDate = Long.MIN_VALUE;
		}

		circTransHistoryCacheModel.overdue = getOverdue();

		Date returnDate = getReturnDate();

		if (returnDate != null) {
			circTransHistoryCacheModel.returnDate = returnDate.getTime();
		}
		else {
			circTransHistoryCacheModel.returnDate = Long.MIN_VALUE;
		}

		Date lastRenewDate = getLastRenewDate();

		if (lastRenewDate != null) {
			circTransHistoryCacheModel.lastRenewDate = lastRenewDate.getTime();
		}
		else {
			circTransHistoryCacheModel.lastRenewDate = Long.MIN_VALUE;
		}

		circTransHistoryCacheModel.renewCount = getRenewCount();

		circTransHistoryCacheModel.fineAmount = getFineAmount();

		return circTransHistoryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{transId=");
		sb.append(getTransId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", libraryId=");
		sb.append(getLibraryId());
		sb.append(", patronId=");
		sb.append(getPatronId());
		sb.append(", catalogItemId=");
		sb.append(getCatalogItemId());
		sb.append(", transDate=");
		sb.append(getTransDate());
		sb.append(", dueDate=");
		sb.append(getDueDate());
		sb.append(", overdue=");
		sb.append(getOverdue());
		sb.append(", returnDate=");
		sb.append(getReturnDate());
		sb.append(", lastRenewDate=");
		sb.append(getLastRenewDate());
		sb.append(", renewCount=");
		sb.append(getRenewCount());
		sb.append(", fineAmount=");
		sb.append(getFineAmount());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.kencana.lms.model.CircTransHistory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>transId</column-name><column-value><![CDATA[");
		sb.append(getTransId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>libraryId</column-name><column-value><![CDATA[");
		sb.append(getLibraryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>patronId</column-name><column-value><![CDATA[");
		sb.append(getPatronId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>catalogItemId</column-name><column-value><![CDATA[");
		sb.append(getCatalogItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>transDate</column-name><column-value><![CDATA[");
		sb.append(getTransDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dueDate</column-name><column-value><![CDATA[");
		sb.append(getDueDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>overdue</column-name><column-value><![CDATA[");
		sb.append(getOverdue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>returnDate</column-name><column-value><![CDATA[");
		sb.append(getReturnDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastRenewDate</column-name><column-value><![CDATA[");
		sb.append(getLastRenewDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>renewCount</column-name><column-value><![CDATA[");
		sb.append(getRenewCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fineAmount</column-name><column-value><![CDATA[");
		sb.append(getFineAmount());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = CircTransHistory.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			CircTransHistory.class
		};
	private long _transId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _libraryId;
	private long _originalLibraryId;
	private boolean _setOriginalLibraryId;
	private long _patronId;
	private long _originalPatronId;
	private boolean _setOriginalPatronId;
	private long _catalogItemId;
	private long _originalCatalogItemId;
	private boolean _setOriginalCatalogItemId;
	private Date _transDate;
	private Date _dueDate;
	private boolean _overdue;
	private Date _returnDate;
	private Date _lastRenewDate;
	private int _renewCount;
	private Double _fineAmount;
	private long _columnBitmask;
	private CircTransHistory _escapedModel;
}