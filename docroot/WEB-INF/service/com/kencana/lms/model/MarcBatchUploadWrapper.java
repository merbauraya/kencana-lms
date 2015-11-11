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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link MarcBatchUpload}.
 * </p>
 *
 * @author Mazlan Mat
 * @see MarcBatchUpload
 * @generated
 */
public class MarcBatchUploadWrapper implements MarcBatchUpload,
	ModelWrapper<MarcBatchUpload> {
	public MarcBatchUploadWrapper(MarcBatchUpload marcBatchUpload) {
		_marcBatchUpload = marcBatchUpload;
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

	/**
	* Returns the primary key of this marc batch upload.
	*
	* @return the primary key of this marc batch upload
	*/
	@Override
	public long getPrimaryKey() {
		return _marcBatchUpload.getPrimaryKey();
	}

	/**
	* Sets the primary key of this marc batch upload.
	*
	* @param primaryKey the primary key of this marc batch upload
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_marcBatchUpload.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the marc batch upload ID of this marc batch upload.
	*
	* @return the marc batch upload ID of this marc batch upload
	*/
	@Override
	public long getMarcBatchUploadId() {
		return _marcBatchUpload.getMarcBatchUploadId();
	}

	/**
	* Sets the marc batch upload ID of this marc batch upload.
	*
	* @param marcBatchUploadId the marc batch upload ID of this marc batch upload
	*/
	@Override
	public void setMarcBatchUploadId(long marcBatchUploadId) {
		_marcBatchUpload.setMarcBatchUploadId(marcBatchUploadId);
	}

	/**
	* Returns the group ID of this marc batch upload.
	*
	* @return the group ID of this marc batch upload
	*/
	@Override
	public long getGroupId() {
		return _marcBatchUpload.getGroupId();
	}

	/**
	* Sets the group ID of this marc batch upload.
	*
	* @param groupId the group ID of this marc batch upload
	*/
	@Override
	public void setGroupId(long groupId) {
		_marcBatchUpload.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this marc batch upload.
	*
	* @return the company ID of this marc batch upload
	*/
	@Override
	public long getCompanyId() {
		return _marcBatchUpload.getCompanyId();
	}

	/**
	* Sets the company ID of this marc batch upload.
	*
	* @param companyId the company ID of this marc batch upload
	*/
	@Override
	public void setCompanyId(long companyId) {
		_marcBatchUpload.setCompanyId(companyId);
	}

	/**
	* Returns the create by of this marc batch upload.
	*
	* @return the create by of this marc batch upload
	*/
	@Override
	public long getCreateBy() {
		return _marcBatchUpload.getCreateBy();
	}

	/**
	* Sets the create by of this marc batch upload.
	*
	* @param createBy the create by of this marc batch upload
	*/
	@Override
	public void setCreateBy(long createBy) {
		_marcBatchUpload.setCreateBy(createBy);
	}

	/**
	* Returns the created date of this marc batch upload.
	*
	* @return the created date of this marc batch upload
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _marcBatchUpload.getCreatedDate();
	}

	/**
	* Sets the created date of this marc batch upload.
	*
	* @param createdDate the created date of this marc batch upload
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_marcBatchUpload.setCreatedDate(createdDate);
	}

	/**
	* Returns the processed of this marc batch upload.
	*
	* @return the processed of this marc batch upload
	*/
	@Override
	public boolean getProcessed() {
		return _marcBatchUpload.getProcessed();
	}

	/**
	* Returns <code>true</code> if this marc batch upload is processed.
	*
	* @return <code>true</code> if this marc batch upload is processed; <code>false</code> otherwise
	*/
	@Override
	public boolean isProcessed() {
		return _marcBatchUpload.isProcessed();
	}

	/**
	* Sets whether this marc batch upload is processed.
	*
	* @param processed the processed of this marc batch upload
	*/
	@Override
	public void setProcessed(boolean processed) {
		_marcBatchUpload.setProcessed(processed);
	}

	/**
	* Returns the import date of this marc batch upload.
	*
	* @return the import date of this marc batch upload
	*/
	@Override
	public java.util.Date getImportDate() {
		return _marcBatchUpload.getImportDate();
	}

	/**
	* Sets the import date of this marc batch upload.
	*
	* @param importDate the import date of this marc batch upload
	*/
	@Override
	public void setImportDate(java.util.Date importDate) {
		_marcBatchUpload.setImportDate(importDate);
	}

	/**
	* Returns the import by user ID of this marc batch upload.
	*
	* @return the import by user ID of this marc batch upload
	*/
	@Override
	public long getImportByUserId() {
		return _marcBatchUpload.getImportByUserId();
	}

	/**
	* Sets the import by user ID of this marc batch upload.
	*
	* @param importByUserId the import by user ID of this marc batch upload
	*/
	@Override
	public void setImportByUserId(long importByUserId) {
		_marcBatchUpload.setImportByUserId(importByUserId);
	}

	/**
	* Returns the import by user uuid of this marc batch upload.
	*
	* @return the import by user uuid of this marc batch upload
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getImportByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _marcBatchUpload.getImportByUserUuid();
	}

	/**
	* Sets the import by user uuid of this marc batch upload.
	*
	* @param importByUserUuid the import by user uuid of this marc batch upload
	*/
	@Override
	public void setImportByUserUuid(java.lang.String importByUserUuid) {
		_marcBatchUpload.setImportByUserUuid(importByUserUuid);
	}

	/**
	* Returns the partial import of this marc batch upload.
	*
	* @return the partial import of this marc batch upload
	*/
	@Override
	public boolean getPartialImport() {
		return _marcBatchUpload.getPartialImport();
	}

	/**
	* Returns <code>true</code> if this marc batch upload is partial import.
	*
	* @return <code>true</code> if this marc batch upload is partial import; <code>false</code> otherwise
	*/
	@Override
	public boolean isPartialImport() {
		return _marcBatchUpload.isPartialImport();
	}

	/**
	* Sets whether this marc batch upload is partial import.
	*
	* @param partialImport the partial import of this marc batch upload
	*/
	@Override
	public void setPartialImport(boolean partialImport) {
		_marcBatchUpload.setPartialImport(partialImport);
	}

	/**
	* Returns the file count of this marc batch upload.
	*
	* @return the file count of this marc batch upload
	*/
	@Override
	public int getFileCount() {
		return _marcBatchUpload.getFileCount();
	}

	/**
	* Sets the file count of this marc batch upload.
	*
	* @param fileCount the file count of this marc batch upload
	*/
	@Override
	public void setFileCount(int fileCount) {
		_marcBatchUpload.setFileCount(fileCount);
	}

	/**
	* Returns the description of this marc batch upload.
	*
	* @return the description of this marc batch upload
	*/
	@Override
	public java.lang.String getDescription() {
		return _marcBatchUpload.getDescription();
	}

	/**
	* Sets the description of this marc batch upload.
	*
	* @param description the description of this marc batch upload
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_marcBatchUpload.setDescription(description);
	}

	/**
	* Returns the record count of this marc batch upload.
	*
	* @return the record count of this marc batch upload
	*/
	@Override
	public int getRecordCount() {
		return _marcBatchUpload.getRecordCount();
	}

	/**
	* Sets the record count of this marc batch upload.
	*
	* @param recordCount the record count of this marc batch upload
	*/
	@Override
	public void setRecordCount(int recordCount) {
		_marcBatchUpload.setRecordCount(recordCount);
	}

	@Override
	public boolean isNew() {
		return _marcBatchUpload.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_marcBatchUpload.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _marcBatchUpload.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_marcBatchUpload.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _marcBatchUpload.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _marcBatchUpload.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_marcBatchUpload.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _marcBatchUpload.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_marcBatchUpload.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_marcBatchUpload.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_marcBatchUpload.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MarcBatchUploadWrapper((MarcBatchUpload)_marcBatchUpload.clone());
	}

	@Override
	public int compareTo(com.kencana.lms.model.MarcBatchUpload marcBatchUpload) {
		return _marcBatchUpload.compareTo(marcBatchUpload);
	}

	@Override
	public int hashCode() {
		return _marcBatchUpload.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.kencana.lms.model.MarcBatchUpload> toCacheModel() {
		return _marcBatchUpload.toCacheModel();
	}

	@Override
	public com.kencana.lms.model.MarcBatchUpload toEscapedModel() {
		return new MarcBatchUploadWrapper(_marcBatchUpload.toEscapedModel());
	}

	@Override
	public com.kencana.lms.model.MarcBatchUpload toUnescapedModel() {
		return new MarcBatchUploadWrapper(_marcBatchUpload.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _marcBatchUpload.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _marcBatchUpload.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_marcBatchUpload.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MarcBatchUploadWrapper)) {
			return false;
		}

		MarcBatchUploadWrapper marcBatchUploadWrapper = (MarcBatchUploadWrapper)obj;

		if (Validator.equals(_marcBatchUpload,
					marcBatchUploadWrapper._marcBatchUpload)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MarcBatchUpload getWrappedMarcBatchUpload() {
		return _marcBatchUpload;
	}

	@Override
	public MarcBatchUpload getWrappedModel() {
		return _marcBatchUpload;
	}

	@Override
	public void resetOriginalValues() {
		_marcBatchUpload.resetOriginalValues();
	}

	private MarcBatchUpload _marcBatchUpload;
}