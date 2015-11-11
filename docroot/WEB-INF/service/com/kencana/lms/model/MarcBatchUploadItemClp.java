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
import com.kencana.lms.service.MarcBatchUploadItemLocalServiceUtil;

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
public class MarcBatchUploadItemClp extends BaseModelImpl<MarcBatchUploadItem>
	implements MarcBatchUploadItem {
	public MarcBatchUploadItemClp() {
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

	@Override
	public long getMarcBatchUploadItemId() {
		return _marcBatchUploadItemId;
	}

	@Override
	public void setMarcBatchUploadItemId(long marcBatchUploadItemId) {
		_marcBatchUploadItemId = marcBatchUploadItemId;

		if (_marcBatchUploadItemRemoteModel != null) {
			try {
				Class<?> clazz = _marcBatchUploadItemRemoteModel.getClass();

				Method method = clazz.getMethod("setMarcBatchUploadItemId",
						long.class);

				method.invoke(_marcBatchUploadItemRemoteModel,
					marcBatchUploadItemId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMarcBatchUploadId() {
		return _marcBatchUploadId;
	}

	@Override
	public void setMarcBatchUploadId(long marcBatchUploadId) {
		_marcBatchUploadId = marcBatchUploadId;

		if (_marcBatchUploadItemRemoteModel != null) {
			try {
				Class<?> clazz = _marcBatchUploadItemRemoteModel.getClass();

				Method method = clazz.getMethod("setMarcBatchUploadId",
						long.class);

				method.invoke(_marcBatchUploadItemRemoteModel, marcBatchUploadId);
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

		if (_marcBatchUploadItemRemoteModel != null) {
			try {
				Class<?> clazz = _marcBatchUploadItemRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_marcBatchUploadItemRemoteModel, groupId);
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

		if (_marcBatchUploadItemRemoteModel != null) {
			try {
				Class<?> clazz = _marcBatchUploadItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_marcBatchUploadItemRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCreatedBy() {
		return _createdBy;
	}

	@Override
	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;

		if (_marcBatchUploadItemRemoteModel != null) {
			try {
				Class<?> clazz = _marcBatchUploadItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedBy", long.class);

				method.invoke(_marcBatchUploadItemRemoteModel, createdBy);
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

		if (_marcBatchUploadItemRemoteModel != null) {
			try {
				Class<?> clazz = _marcBatchUploadItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_marcBatchUploadItemRemoteModel, createdDate);
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

		if (_marcBatchUploadItemRemoteModel != null) {
			try {
				Class<?> clazz = _marcBatchUploadItemRemoteModel.getClass();

				Method method = clazz.getMethod("setProcessed", boolean.class);

				method.invoke(_marcBatchUploadItemRemoteModel, processed);
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

		if (_marcBatchUploadItemRemoteModel != null) {
			try {
				Class<?> clazz = _marcBatchUploadItemRemoteModel.getClass();

				Method method = clazz.getMethod("setImportDate", Date.class);

				method.invoke(_marcBatchUploadItemRemoteModel, importDate);
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

		if (_marcBatchUploadItemRemoteModel != null) {
			try {
				Class<?> clazz = _marcBatchUploadItemRemoteModel.getClass();

				Method method = clazz.getMethod("setImportByUserId", long.class);

				method.invoke(_marcBatchUploadItemRemoteModel, importByUserId);
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
	public String getMarcContent() {
		return _marcContent;
	}

	@Override
	public void setMarcContent(String marcContent) {
		_marcContent = marcContent;

		if (_marcBatchUploadItemRemoteModel != null) {
			try {
				Class<?> clazz = _marcBatchUploadItemRemoteModel.getClass();

				Method method = clazz.getMethod("setMarcContent", String.class);

				method.invoke(_marcBatchUploadItemRemoteModel, marcContent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFileName() {
		return _fileName;
	}

	@Override
	public void setFileName(String fileName) {
		_fileName = fileName;

		if (_marcBatchUploadItemRemoteModel != null) {
			try {
				Class<?> clazz = _marcBatchUploadItemRemoteModel.getClass();

				Method method = clazz.getMethod("setFileName", String.class);

				method.invoke(_marcBatchUploadItemRemoteModel, fileName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFileEntryId() {
		return _fileEntryId;
	}

	@Override
	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;

		if (_marcBatchUploadItemRemoteModel != null) {
			try {
				Class<?> clazz = _marcBatchUploadItemRemoteModel.getClass();

				Method method = clazz.getMethod("setFileEntryId", long.class);

				method.invoke(_marcBatchUploadItemRemoteModel, fileEntryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMarcBatchUploadItemRemoteModel() {
		return _marcBatchUploadItemRemoteModel;
	}

	public void setMarcBatchUploadItemRemoteModel(
		BaseModel<?> marcBatchUploadItemRemoteModel) {
		_marcBatchUploadItemRemoteModel = marcBatchUploadItemRemoteModel;
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

		Class<?> remoteModelClass = _marcBatchUploadItemRemoteModel.getClass();

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

		Object returnValue = method.invoke(_marcBatchUploadItemRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MarcBatchUploadItemLocalServiceUtil.addMarcBatchUploadItem(this);
		}
		else {
			MarcBatchUploadItemLocalServiceUtil.updateMarcBatchUploadItem(this);
		}
	}

	@Override
	public MarcBatchUploadItem toEscapedModel() {
		return (MarcBatchUploadItem)ProxyUtil.newProxyInstance(MarcBatchUploadItem.class.getClassLoader(),
			new Class[] { MarcBatchUploadItem.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MarcBatchUploadItemClp clone = new MarcBatchUploadItemClp();

		clone.setMarcBatchUploadItemId(getMarcBatchUploadItemId());
		clone.setMarcBatchUploadId(getMarcBatchUploadId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setCreatedBy(getCreatedBy());
		clone.setCreatedDate(getCreatedDate());
		clone.setProcessed(getProcessed());
		clone.setImportDate(getImportDate());
		clone.setImportByUserId(getImportByUserId());
		clone.setMarcContent(getMarcContent());
		clone.setFileName(getFileName());
		clone.setFileEntryId(getFileEntryId());

		return clone;
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

		if (!(obj instanceof MarcBatchUploadItemClp)) {
			return false;
		}

		MarcBatchUploadItemClp marcBatchUploadItem = (MarcBatchUploadItemClp)obj;

		long primaryKey = marcBatchUploadItem.getPrimaryKey();

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

	private long _marcBatchUploadItemId;
	private long _marcBatchUploadId;
	private long _groupId;
	private long _companyId;
	private long _createdBy;
	private Date _createdDate;
	private boolean _processed;
	private Date _importDate;
	private long _importByUserId;
	private String _importByUserUuid;
	private String _marcContent;
	private String _fileName;
	private long _fileEntryId;
	private BaseModel<?> _marcBatchUploadItemRemoteModel;
	private Class<?> _clpSerializerClass = com.kencana.lms.service.ClpSerializer.class;
}