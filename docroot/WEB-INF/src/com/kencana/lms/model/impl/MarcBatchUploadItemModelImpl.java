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

import com.kencana.lms.model.MarcBatchUploadItem;
import com.kencana.lms.model.MarcBatchUploadItemModel;
import com.kencana.lms.model.MarcBatchUploadItemSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

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
 * The base model implementation for the MarcBatchUploadItem service. Represents a row in the &quot;Kencana_MarcBatchUploadItem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.kencana.lms.model.MarcBatchUploadItemModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MarcBatchUploadItemImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see MarcBatchUploadItemImpl
 * @see com.kencana.lms.model.MarcBatchUploadItem
 * @see com.kencana.lms.model.MarcBatchUploadItemModel
 * @generated
 */
@JSON(strict = true)
public class MarcBatchUploadItemModelImpl extends BaseModelImpl<MarcBatchUploadItem>
	implements MarcBatchUploadItemModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a marc batch upload item model instance should use the {@link com.kencana.lms.model.MarcBatchUploadItem} interface instead.
	 */
	public static final String TABLE_NAME = "Kencana_MarcBatchUploadItem";
	public static final Object[][] TABLE_COLUMNS = {
			{ "marcBatchUploadItemId", Types.BIGINT },
			{ "marcBatchUploadId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "createdBy", Types.BIGINT },
			{ "createdDate", Types.TIMESTAMP },
			{ "processed", Types.BOOLEAN },
			{ "importDate", Types.TIMESTAMP },
			{ "importByUserId", Types.BIGINT },
			{ "marcContent", Types.VARCHAR },
			{ "fileName", Types.VARCHAR },
			{ "fileEntryId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table Kencana_MarcBatchUploadItem (marcBatchUploadItemId LONG not null primary key,marcBatchUploadId LONG,groupId LONG,companyId LONG,createdBy LONG,createdDate DATE null,processed BOOLEAN,importDate DATE null,importByUserId LONG,marcContent VARCHAR(75) null,fileName VARCHAR(75) null,fileEntryId LONG)";
	public static final String TABLE_SQL_DROP = "drop table Kencana_MarcBatchUploadItem";
	public static final String ORDER_BY_JPQL = " ORDER BY marcBatchUploadItem.marcBatchUploadItemId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Kencana_MarcBatchUploadItem.marcBatchUploadItemId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.kencana.lms.model.MarcBatchUploadItem"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.kencana.lms.model.MarcBatchUploadItem"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.kencana.lms.model.MarcBatchUploadItem"),
			true);
	public static long MARCBATCHUPLOADID_COLUMN_BITMASK = 1L;
	public static long PROCESSED_COLUMN_BITMASK = 2L;
	public static long MARCBATCHUPLOADITEMID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static MarcBatchUploadItem toModel(MarcBatchUploadItemSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		MarcBatchUploadItem model = new MarcBatchUploadItemImpl();

		model.setMarcBatchUploadItemId(soapModel.getMarcBatchUploadItemId());
		model.setMarcBatchUploadId(soapModel.getMarcBatchUploadId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setCreatedBy(soapModel.getCreatedBy());
		model.setCreatedDate(soapModel.getCreatedDate());
		model.setProcessed(soapModel.getProcessed());
		model.setImportDate(soapModel.getImportDate());
		model.setImportByUserId(soapModel.getImportByUserId());
		model.setMarcContent(soapModel.getMarcContent());
		model.setFileName(soapModel.getFileName());
		model.setFileEntryId(soapModel.getFileEntryId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<MarcBatchUploadItem> toModels(
		MarcBatchUploadItemSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<MarcBatchUploadItem> models = new ArrayList<MarcBatchUploadItem>(soapModels.length);

		for (MarcBatchUploadItemSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.kencana.lms.model.MarcBatchUploadItem"));

	public MarcBatchUploadItemModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _marcBatchUploadItemId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMarcBatchUploadItemId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _marcBatchUploadItemId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return MarcBatchUploadItem.class;
	}

	@Override
	public String getModelClassName() {
		return MarcBatchUploadItem.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("marcBatchUploadItemId", getMarcBatchUploadItemId());
		attributes.put("marcBatchUploadId", getMarcBatchUploadId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("processed", getProcessed());
		attributes.put("importDate", getImportDate());
		attributes.put("importByUserId", getImportByUserId());
		attributes.put("marcContent", getMarcContent());
		attributes.put("fileName", getFileName());
		attributes.put("fileEntryId", getFileEntryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long marcBatchUploadItemId = (Long)attributes.get(
				"marcBatchUploadItemId");

		if (marcBatchUploadItemId != null) {
			setMarcBatchUploadItemId(marcBatchUploadItemId);
		}

		Long marcBatchUploadId = (Long)attributes.get("marcBatchUploadId");

		if (marcBatchUploadId != null) {
			setMarcBatchUploadId(marcBatchUploadId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Boolean processed = (Boolean)attributes.get("processed");

		if (processed != null) {
			setProcessed(processed);
		}

		Date importDate = (Date)attributes.get("importDate");

		if (importDate != null) {
			setImportDate(importDate);
		}

		Long importByUserId = (Long)attributes.get("importByUserId");

		if (importByUserId != null) {
			setImportByUserId(importByUserId);
		}

		String marcContent = (String)attributes.get("marcContent");

		if (marcContent != null) {
			setMarcContent(marcContent);
		}

		String fileName = (String)attributes.get("fileName");

		if (fileName != null) {
			setFileName(fileName);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}
	}

	@JSON
	@Override
	public long getMarcBatchUploadItemId() {
		return _marcBatchUploadItemId;
	}

	@Override
	public void setMarcBatchUploadItemId(long marcBatchUploadItemId) {
		_marcBatchUploadItemId = marcBatchUploadItemId;
	}

	@JSON
	@Override
	public long getMarcBatchUploadId() {
		return _marcBatchUploadId;
	}

	@Override
	public void setMarcBatchUploadId(long marcBatchUploadId) {
		_columnBitmask |= MARCBATCHUPLOADID_COLUMN_BITMASK;

		if (!_setOriginalMarcBatchUploadId) {
			_setOriginalMarcBatchUploadId = true;

			_originalMarcBatchUploadId = _marcBatchUploadId;
		}

		_marcBatchUploadId = marcBatchUploadId;
	}

	public long getOriginalMarcBatchUploadId() {
		return _originalMarcBatchUploadId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getCreatedBy() {
		return _createdBy;
	}

	@Override
	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;
	}

	@JSON
	@Override
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	@JSON
	@Override
	public boolean getProcessed() {
		return _processed;
	}

	@Override
	public boolean isProcessed() {
		return _processed;
	}

	@Override
	public void setProcessed(boolean processed) {
		_columnBitmask |= PROCESSED_COLUMN_BITMASK;

		if (!_setOriginalProcessed) {
			_setOriginalProcessed = true;

			_originalProcessed = _processed;
		}

		_processed = processed;
	}

	public boolean getOriginalProcessed() {
		return _originalProcessed;
	}

	@JSON
	@Override
	public Date getImportDate() {
		return _importDate;
	}

	@Override
	public void setImportDate(Date importDate) {
		_importDate = importDate;
	}

	@JSON
	@Override
	public long getImportByUserId() {
		return _importByUserId;
	}

	@Override
	public void setImportByUserId(long importByUserId) {
		_importByUserId = importByUserId;
	}

	@Override
	public String getImportByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getImportByUserId(), "uuid",
			_importByUserUuid);
	}

	@Override
	public void setImportByUserUuid(String importByUserUuid) {
		_importByUserUuid = importByUserUuid;
	}

	@JSON
	@Override
	public String getMarcContent() {
		if (_marcContent == null) {
			return StringPool.BLANK;
		}
		else {
			return _marcContent;
		}
	}

	@Override
	public void setMarcContent(String marcContent) {
		_marcContent = marcContent;
	}

	@JSON
	@Override
	public String getFileName() {
		if (_fileName == null) {
			return StringPool.BLANK;
		}
		else {
			return _fileName;
		}
	}

	@Override
	public void setFileName(String fileName) {
		_fileName = fileName;
	}

	@JSON
	@Override
	public long getFileEntryId() {
		return _fileEntryId;
	}

	@Override
	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			MarcBatchUploadItem.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public MarcBatchUploadItem toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (MarcBatchUploadItem)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		MarcBatchUploadItemImpl marcBatchUploadItemImpl = new MarcBatchUploadItemImpl();

		marcBatchUploadItemImpl.setMarcBatchUploadItemId(getMarcBatchUploadItemId());
		marcBatchUploadItemImpl.setMarcBatchUploadId(getMarcBatchUploadId());
		marcBatchUploadItemImpl.setGroupId(getGroupId());
		marcBatchUploadItemImpl.setCompanyId(getCompanyId());
		marcBatchUploadItemImpl.setCreatedBy(getCreatedBy());
		marcBatchUploadItemImpl.setCreatedDate(getCreatedDate());
		marcBatchUploadItemImpl.setProcessed(getProcessed());
		marcBatchUploadItemImpl.setImportDate(getImportDate());
		marcBatchUploadItemImpl.setImportByUserId(getImportByUserId());
		marcBatchUploadItemImpl.setMarcContent(getMarcContent());
		marcBatchUploadItemImpl.setFileName(getFileName());
		marcBatchUploadItemImpl.setFileEntryId(getFileEntryId());

		marcBatchUploadItemImpl.resetOriginalValues();

		return marcBatchUploadItemImpl;
	}

	@Override
	public int compareTo(MarcBatchUploadItem marcBatchUploadItem) {
		long primaryKey = marcBatchUploadItem.getPrimaryKey();

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

		if (!(obj instanceof MarcBatchUploadItem)) {
			return false;
		}

		MarcBatchUploadItem marcBatchUploadItem = (MarcBatchUploadItem)obj;

		long primaryKey = marcBatchUploadItem.getPrimaryKey();

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
		MarcBatchUploadItemModelImpl marcBatchUploadItemModelImpl = this;

		marcBatchUploadItemModelImpl._originalMarcBatchUploadId = marcBatchUploadItemModelImpl._marcBatchUploadId;

		marcBatchUploadItemModelImpl._setOriginalMarcBatchUploadId = false;

		marcBatchUploadItemModelImpl._originalProcessed = marcBatchUploadItemModelImpl._processed;

		marcBatchUploadItemModelImpl._setOriginalProcessed = false;

		marcBatchUploadItemModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<MarcBatchUploadItem> toCacheModel() {
		MarcBatchUploadItemCacheModel marcBatchUploadItemCacheModel = new MarcBatchUploadItemCacheModel();

		marcBatchUploadItemCacheModel.marcBatchUploadItemId = getMarcBatchUploadItemId();

		marcBatchUploadItemCacheModel.marcBatchUploadId = getMarcBatchUploadId();

		marcBatchUploadItemCacheModel.groupId = getGroupId();

		marcBatchUploadItemCacheModel.companyId = getCompanyId();

		marcBatchUploadItemCacheModel.createdBy = getCreatedBy();

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			marcBatchUploadItemCacheModel.createdDate = createdDate.getTime();
		}
		else {
			marcBatchUploadItemCacheModel.createdDate = Long.MIN_VALUE;
		}

		marcBatchUploadItemCacheModel.processed = getProcessed();

		Date importDate = getImportDate();

		if (importDate != null) {
			marcBatchUploadItemCacheModel.importDate = importDate.getTime();
		}
		else {
			marcBatchUploadItemCacheModel.importDate = Long.MIN_VALUE;
		}

		marcBatchUploadItemCacheModel.importByUserId = getImportByUserId();

		marcBatchUploadItemCacheModel.marcContent = getMarcContent();

		String marcContent = marcBatchUploadItemCacheModel.marcContent;

		if ((marcContent != null) && (marcContent.length() == 0)) {
			marcBatchUploadItemCacheModel.marcContent = null;
		}

		marcBatchUploadItemCacheModel.fileName = getFileName();

		String fileName = marcBatchUploadItemCacheModel.fileName;

		if ((fileName != null) && (fileName.length() == 0)) {
			marcBatchUploadItemCacheModel.fileName = null;
		}

		marcBatchUploadItemCacheModel.fileEntryId = getFileEntryId();

		return marcBatchUploadItemCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{marcBatchUploadItemId=");
		sb.append(getMarcBatchUploadItemId());
		sb.append(", marcBatchUploadId=");
		sb.append(getMarcBatchUploadId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", processed=");
		sb.append(getProcessed());
		sb.append(", importDate=");
		sb.append(getImportDate());
		sb.append(", importByUserId=");
		sb.append(getImportByUserId());
		sb.append(", marcContent=");
		sb.append(getMarcContent());
		sb.append(", fileName=");
		sb.append(getFileName());
		sb.append(", fileEntryId=");
		sb.append(getFileEntryId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.kencana.lms.model.MarcBatchUploadItem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>marcBatchUploadItemId</column-name><column-value><![CDATA[");
		sb.append(getMarcBatchUploadItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>marcBatchUploadId</column-name><column-value><![CDATA[");
		sb.append(getMarcBatchUploadId());
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
			"<column><column-name>createdBy</column-name><column-value><![CDATA[");
		sb.append(getCreatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processed</column-name><column-value><![CDATA[");
		sb.append(getProcessed());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>importDate</column-name><column-value><![CDATA[");
		sb.append(getImportDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>importByUserId</column-name><column-value><![CDATA[");
		sb.append(getImportByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>marcContent</column-name><column-value><![CDATA[");
		sb.append(getMarcContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileName</column-name><column-value><![CDATA[");
		sb.append(getFileName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileEntryId</column-name><column-value><![CDATA[");
		sb.append(getFileEntryId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = MarcBatchUploadItem.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			MarcBatchUploadItem.class
		};
	private long _marcBatchUploadItemId;
	private long _marcBatchUploadId;
	private long _originalMarcBatchUploadId;
	private boolean _setOriginalMarcBatchUploadId;
	private long _groupId;
	private long _companyId;
	private long _createdBy;
	private Date _createdDate;
	private boolean _processed;
	private boolean _originalProcessed;
	private boolean _setOriginalProcessed;
	private Date _importDate;
	private long _importByUserId;
	private String _importByUserUuid;
	private String _marcContent;
	private String _fileName;
	private long _fileEntryId;
	private long _columnBitmask;
	private MarcBatchUploadItem _escapedModel;
}