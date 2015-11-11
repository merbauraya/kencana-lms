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
import com.kencana.lms.service.MarcBatchUploadLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mazlan Mat
 */
public class MarcBatchUploadClp extends BaseModelImpl<MarcBatchUpload>
	implements MarcBatchUpload {
	public MarcBatchUploadClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return MarcBatchUpload.class;
	}

	@Override
	public String getModelClassName() {
		return MarcBatchUpload.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _marcBatchUploadId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMarcBatchUploadId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _marcBatchUploadId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("marcBatchUploadId", getMarcBatchUploadId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createBy", getCreateBy());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("processed", getProcessed());
		attributes.put("importDate", getImportDate());
		attributes.put("importByUserId", getImportByUserId());
		attributes.put("partialImport", getPartialImport());
		attributes.put("fileCount", getFileCount());
		attributes.put("description", getDescription());
		attributes.put("recordCount", getRecordCount());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
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

		Long createBy = (Long)attributes.get("createBy");

		if (createBy != null) {
			setCreateBy(createBy);
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

		Boolean partialImport = (Boolean)attributes.get("partialImport");

		if (partialImport != null) {
			setPartialImport(partialImport);
		}

		Integer fileCount = (Integer)attributes.get("fileCount");

		if (fileCount != null) {
			setFileCount(fileCount);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Integer recordCount = (Integer)attributes.get("recordCount");

		if (recordCount != null) {
			setRecordCount(recordCount);
		}
	}

	@Override
	public long getMarcBatchUploadId() {
		return _marcBatchUploadId;
	}

	@Override
	public void setMarcBatchUploadId(long marcBatchUploadId) {
		_marcBatchUploadId = marcBatchUploadId;

		if (_marcBatchUploadRemoteModel != null) {
			try {
				Class<?> clazz = _marcBatchUploadRemoteModel.getClass();

				Method method = clazz.getMethod("setMarcBatchUploadId",
						long.class);

				method.invoke(_marcBatchUploadRemoteModel, marcBatchUploadId);
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

		if (_marcBatchUploadRemoteModel != null) {
			try {
				Class<?> clazz = _marcBatchUploadRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_marcBatchUploadRemoteModel, groupId);
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

		if (_marcBatchUploadRemoteModel != null) {
			try {
				Class<?> clazz = _marcBatchUploadRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_marcBatchUploadRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCreateBy() {
		return _createBy;
	}

	@Override
	public void setCreateBy(long createBy) {
		_createBy = createBy;

		if (_marcBatchUploadRemoteModel != null) {
			try {
				Class<?> clazz = _marcBatchUploadRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateBy", long.class);

				method.invoke(_marcBatchUploadRemoteModel, createBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;

		if (_marcBatchUploadRemoteModel != null) {
			try {
				Class<?> clazz = _marcBatchUploadRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_marcBatchUploadRemoteModel, createdDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

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
		_processed = processed;

		if (_marcBatchUploadRemoteModel != null) {
			try {
				Class<?> clazz = _marcBatchUploadRemoteModel.getClass();

				Method method = clazz.getMethod("setProcessed", boolean.class);

				method.invoke(_marcBatchUploadRemoteModel, processed);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getImportDate() {
		return _importDate;
	}

	@Override
	public void setImportDate(Date importDate) {
		_importDate = importDate;

		if (_marcBatchUploadRemoteModel != null) {
			try {
				Class<?> clazz = _marcBatchUploadRemoteModel.getClass();

				Method method = clazz.getMethod("setImportDate", Date.class);

				method.invoke(_marcBatchUploadRemoteModel, importDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getImportByUserId() {
		return _importByUserId;
	}

	@Override
	public void setImportByUserId(long importByUserId) {
		_importByUserId = importByUserId;

		if (_marcBatchUploadRemoteModel != null) {
			try {
				Class<?> clazz = _marcBatchUploadRemoteModel.getClass();

				Method method = clazz.getMethod("setImportByUserId", long.class);

				method.invoke(_marcBatchUploadRemoteModel, importByUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
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

	@Override
	public boolean getPartialImport() {
		return _partialImport;
	}

	@Override
	public boolean isPartialImport() {
		return _partialImport;
	}

	@Override
	public void setPartialImport(boolean partialImport) {
		_partialImport = partialImport;

		if (_marcBatchUploadRemoteModel != null) {
			try {
				Class<?> clazz = _marcBatchUploadRemoteModel.getClass();

				Method method = clazz.getMethod("setPartialImport",
						boolean.class);

				method.invoke(_marcBatchUploadRemoteModel, partialImport);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getFileCount() {
		return _fileCount;
	}

	@Override
	public void setFileCount(int fileCount) {
		_fileCount = fileCount;

		if (_marcBatchUploadRemoteModel != null) {
			try {
				Class<?> clazz = _marcBatchUploadRemoteModel.getClass();

				Method method = clazz.getMethod("setFileCount", int.class);

				method.invoke(_marcBatchUploadRemoteModel, fileCount);
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

		if (_marcBatchUploadRemoteModel != null) {
			try {
				Class<?> clazz = _marcBatchUploadRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_marcBatchUploadRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getRecordCount() {
		return _recordCount;
	}

	@Override
	public void setRecordCount(int recordCount) {
		_recordCount = recordCount;

		if (_marcBatchUploadRemoteModel != null) {
			try {
				Class<?> clazz = _marcBatchUploadRemoteModel.getClass();

				Method method = clazz.getMethod("setRecordCount", int.class);

				method.invoke(_marcBatchUploadRemoteModel, recordCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMarcBatchUploadRemoteModel() {
		return _marcBatchUploadRemoteModel;
	}

	public void setMarcBatchUploadRemoteModel(
		BaseModel<?> marcBatchUploadRemoteModel) {
		_marcBatchUploadRemoteModel = marcBatchUploadRemoteModel;
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

		Class<?> remoteModelClass = _marcBatchUploadRemoteModel.getClass();

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

		Object returnValue = method.invoke(_marcBatchUploadRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MarcBatchUploadLocalServiceUtil.addMarcBatchUpload(this);
		}
		else {
			MarcBatchUploadLocalServiceUtil.updateMarcBatchUpload(this);
		}
	}

	@Override
	public MarcBatchUpload toEscapedModel() {
		return (MarcBatchUpload)ProxyUtil.newProxyInstance(MarcBatchUpload.class.getClassLoader(),
			new Class[] { MarcBatchUpload.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MarcBatchUploadClp clone = new MarcBatchUploadClp();

		clone.setMarcBatchUploadId(getMarcBatchUploadId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setCreateBy(getCreateBy());
		clone.setCreatedDate(getCreatedDate());
		clone.setProcessed(getProcessed());
		clone.setImportDate(getImportDate());
		clone.setImportByUserId(getImportByUserId());
		clone.setPartialImport(getPartialImport());
		clone.setFileCount(getFileCount());
		clone.setDescription(getDescription());
		clone.setRecordCount(getRecordCount());

		return clone;
	}

	@Override
	public int compareTo(MarcBatchUpload marcBatchUpload) {
		long primaryKey = marcBatchUpload.getPrimaryKey();

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

		if (!(obj instanceof MarcBatchUploadClp)) {
			return false;
		}

		MarcBatchUploadClp marcBatchUpload = (MarcBatchUploadClp)obj;

		long primaryKey = marcBatchUpload.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{marcBatchUploadId=");
		sb.append(getMarcBatchUploadId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createBy=");
		sb.append(getCreateBy());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", processed=");
		sb.append(getProcessed());
		sb.append(", importDate=");
		sb.append(getImportDate());
		sb.append(", importByUserId=");
		sb.append(getImportByUserId());
		sb.append(", partialImport=");
		sb.append(getPartialImport());
		sb.append(", fileCount=");
		sb.append(getFileCount());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", recordCount=");
		sb.append(getRecordCount());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.kencana.lms.model.MarcBatchUpload");
		sb.append("</model-name>");

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
			"<column><column-name>createBy</column-name><column-value><![CDATA[");
		sb.append(getCreateBy());
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
			"<column><column-name>partialImport</column-name><column-value><![CDATA[");
		sb.append(getPartialImport());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileCount</column-name><column-value><![CDATA[");
		sb.append(getFileCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recordCount</column-name><column-value><![CDATA[");
		sb.append(getRecordCount());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _marcBatchUploadId;
	private long _groupId;
	private long _companyId;
	private long _createBy;
	private Date _createdDate;
	private boolean _processed;
	private Date _importDate;
	private long _importByUserId;
	private String _importByUserUuid;
	private boolean _partialImport;
	private int _fileCount;
	private String _description;
	private int _recordCount;
	private BaseModel<?> _marcBatchUploadRemoteModel;
	private Class<?> _clpSerializerClass = com.kencana.lms.service.ClpSerializer.class;
}