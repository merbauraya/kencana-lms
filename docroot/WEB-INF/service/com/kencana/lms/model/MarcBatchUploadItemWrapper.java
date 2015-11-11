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
 * This class is a wrapper for {@link MarcBatchUploadItem}.
 * </p>
 *
 * @author Mazlan Mat
 * @see MarcBatchUploadItem
 * @generated
 */
public class MarcBatchUploadItemWrapper implements MarcBatchUploadItem,
	ModelWrapper<MarcBatchUploadItem> {
	public MarcBatchUploadItemWrapper(MarcBatchUploadItem marcBatchUploadItem) {
		_marcBatchUploadItem = marcBatchUploadItem;
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

	/**
	* Returns the primary key of this marc batch upload item.
	*
	* @return the primary key of this marc batch upload item
	*/
	@Override
	public long getPrimaryKey() {
		return _marcBatchUploadItem.getPrimaryKey();
	}

	/**
	* Sets the primary key of this marc batch upload item.
	*
	* @param primaryKey the primary key of this marc batch upload item
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_marcBatchUploadItem.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the marc batch upload item ID of this marc batch upload item.
	*
	* @return the marc batch upload item ID of this marc batch upload item
	*/
	@Override
	public long getMarcBatchUploadItemId() {
		return _marcBatchUploadItem.getMarcBatchUploadItemId();
	}

	/**
	* Sets the marc batch upload item ID of this marc batch upload item.
	*
	* @param marcBatchUploadItemId the marc batch upload item ID of this marc batch upload item
	*/
	@Override
	public void setMarcBatchUploadItemId(long marcBatchUploadItemId) {
		_marcBatchUploadItem.setMarcBatchUploadItemId(marcBatchUploadItemId);
	}

	/**
	* Returns the marc batch upload ID of this marc batch upload item.
	*
	* @return the marc batch upload ID of this marc batch upload item
	*/
	@Override
	public long getMarcBatchUploadId() {
		return _marcBatchUploadItem.getMarcBatchUploadId();
	}

	/**
	* Sets the marc batch upload ID of this marc batch upload item.
	*
	* @param marcBatchUploadId the marc batch upload ID of this marc batch upload item
	*/
	@Override
	public void setMarcBatchUploadId(long marcBatchUploadId) {
		_marcBatchUploadItem.setMarcBatchUploadId(marcBatchUploadId);
	}

	/**
	* Returns the group ID of this marc batch upload item.
	*
	* @return the group ID of this marc batch upload item
	*/
	@Override
	public long getGroupId() {
		return _marcBatchUploadItem.getGroupId();
	}

	/**
	* Sets the group ID of this marc batch upload item.
	*
	* @param groupId the group ID of this marc batch upload item
	*/
	@Override
	public void setGroupId(long groupId) {
		_marcBatchUploadItem.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this marc batch upload item.
	*
	* @return the company ID of this marc batch upload item
	*/
	@Override
	public long getCompanyId() {
		return _marcBatchUploadItem.getCompanyId();
	}

	/**
	* Sets the company ID of this marc batch upload item.
	*
	* @param companyId the company ID of this marc batch upload item
	*/
	@Override
	public void setCompanyId(long companyId) {
		_marcBatchUploadItem.setCompanyId(companyId);
	}

	/**
	* Returns the created by of this marc batch upload item.
	*
	* @return the created by of this marc batch upload item
	*/
	@Override
	public long getCreatedBy() {
		return _marcBatchUploadItem.getCreatedBy();
	}

	/**
	* Sets the created by of this marc batch upload item.
	*
	* @param createdBy the created by of this marc batch upload item
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_marcBatchUploadItem.setCreatedBy(createdBy);
	}

	/**
	* Returns the created date of this marc batch upload item.
	*
	* @return the created date of this marc batch upload item
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _marcBatchUploadItem.getCreatedDate();
	}

	/**
	* Sets the created date of this marc batch upload item.
	*
	* @param createdDate the created date of this marc batch upload item
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_marcBatchUploadItem.setCreatedDate(createdDate);
	}

	/**
	* Returns the processed of this marc batch upload item.
	*
	* @return the processed of this marc batch upload item
	*/
	@Override
	public boolean getProcessed() {
		return _marcBatchUploadItem.getProcessed();
	}

	/**
	* Returns <code>true</code> if this marc batch upload item is processed.
	*
	* @return <code>true</code> if this marc batch upload item is processed; <code>false</code> otherwise
	*/
	@Override
	public boolean isProcessed() {
		return _marcBatchUploadItem.isProcessed();
	}

	/**
	* Sets whether this marc batch upload item is processed.
	*
	* @param processed the processed of this marc batch upload item
	*/
	@Override
	public void setProcessed(boolean processed) {
		_marcBatchUploadItem.setProcessed(processed);
	}

	/**
	* Returns the import date of this marc batch upload item.
	*
	* @return the import date of this marc batch upload item
	*/
	@Override
	public java.util.Date getImportDate() {
		return _marcBatchUploadItem.getImportDate();
	}

	/**
	* Sets the import date of this marc batch upload item.
	*
	* @param importDate the import date of this marc batch upload item
	*/
	@Override
	public void setImportDate(java.util.Date importDate) {
		_marcBatchUploadItem.setImportDate(importDate);
	}

	/**
	* Returns the import by user ID of this marc batch upload item.
	*
	* @return the import by user ID of this marc batch upload item
	*/
	@Override
	public long getImportByUserId() {
		return _marcBatchUploadItem.getImportByUserId();
	}

	/**
	* Sets the import by user ID of this marc batch upload item.
	*
	* @param importByUserId the import by user ID of this marc batch upload item
	*/
	@Override
	public void setImportByUserId(long importByUserId) {
		_marcBatchUploadItem.setImportByUserId(importByUserId);
	}

	/**
	* Returns the import by user uuid of this marc batch upload item.
	*
	* @return the import by user uuid of this marc batch upload item
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getImportByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _marcBatchUploadItem.getImportByUserUuid();
	}

	/**
	* Sets the import by user uuid of this marc batch upload item.
	*
	* @param importByUserUuid the import by user uuid of this marc batch upload item
	*/
	@Override
	public void setImportByUserUuid(java.lang.String importByUserUuid) {
		_marcBatchUploadItem.setImportByUserUuid(importByUserUuid);
	}

	/**
	* Returns the marc content of this marc batch upload item.
	*
	* @return the marc content of this marc batch upload item
	*/
	@Override
	public java.lang.String getMarcContent() {
		return _marcBatchUploadItem.getMarcContent();
	}

	/**
	* Sets the marc content of this marc batch upload item.
	*
	* @param marcContent the marc content of this marc batch upload item
	*/
	@Override
	public void setMarcContent(java.lang.String marcContent) {
		_marcBatchUploadItem.setMarcContent(marcContent);
	}

	/**
	* Returns the file name of this marc batch upload item.
	*
	* @return the file name of this marc batch upload item
	*/
	@Override
	public java.lang.String getFileName() {
		return _marcBatchUploadItem.getFileName();
	}

	/**
	* Sets the file name of this marc batch upload item.
	*
	* @param fileName the file name of this marc batch upload item
	*/
	@Override
	public void setFileName(java.lang.String fileName) {
		_marcBatchUploadItem.setFileName(fileName);
	}

	/**
	* Returns the file entry ID of this marc batch upload item.
	*
	* @return the file entry ID of this marc batch upload item
	*/
	@Override
	public long getFileEntryId() {
		return _marcBatchUploadItem.getFileEntryId();
	}

	/**
	* Sets the file entry ID of this marc batch upload item.
	*
	* @param fileEntryId the file entry ID of this marc batch upload item
	*/
	@Override
	public void setFileEntryId(long fileEntryId) {
		_marcBatchUploadItem.setFileEntryId(fileEntryId);
	}

	@Override
	public boolean isNew() {
		return _marcBatchUploadItem.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_marcBatchUploadItem.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _marcBatchUploadItem.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_marcBatchUploadItem.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _marcBatchUploadItem.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _marcBatchUploadItem.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_marcBatchUploadItem.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _marcBatchUploadItem.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_marcBatchUploadItem.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_marcBatchUploadItem.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_marcBatchUploadItem.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MarcBatchUploadItemWrapper((MarcBatchUploadItem)_marcBatchUploadItem.clone());
	}

	@Override
	public int compareTo(
		com.kencana.lms.model.MarcBatchUploadItem marcBatchUploadItem) {
		return _marcBatchUploadItem.compareTo(marcBatchUploadItem);
	}

	@Override
	public int hashCode() {
		return _marcBatchUploadItem.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.kencana.lms.model.MarcBatchUploadItem> toCacheModel() {
		return _marcBatchUploadItem.toCacheModel();
	}

	@Override
	public com.kencana.lms.model.MarcBatchUploadItem toEscapedModel() {
		return new MarcBatchUploadItemWrapper(_marcBatchUploadItem.toEscapedModel());
	}

	@Override
	public com.kencana.lms.model.MarcBatchUploadItem toUnescapedModel() {
		return new MarcBatchUploadItemWrapper(_marcBatchUploadItem.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _marcBatchUploadItem.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _marcBatchUploadItem.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_marcBatchUploadItem.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MarcBatchUploadItemWrapper)) {
			return false;
		}

		MarcBatchUploadItemWrapper marcBatchUploadItemWrapper = (MarcBatchUploadItemWrapper)obj;

		if (Validator.equals(_marcBatchUploadItem,
					marcBatchUploadItemWrapper._marcBatchUploadItem)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MarcBatchUploadItem getWrappedMarcBatchUploadItem() {
		return _marcBatchUploadItem;
	}

	@Override
	public MarcBatchUploadItem getWrappedModel() {
		return _marcBatchUploadItem;
	}

	@Override
	public void resetOriginalValues() {
		_marcBatchUploadItem.resetOriginalValues();
	}

	private MarcBatchUploadItem _marcBatchUploadItem;
}