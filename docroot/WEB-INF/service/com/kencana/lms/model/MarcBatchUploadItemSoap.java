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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.kencana.lms.service.http.MarcBatchUploadItemServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.kencana.lms.service.http.MarcBatchUploadItemServiceSoap
 * @generated
 */
public class MarcBatchUploadItemSoap implements Serializable {
	public static MarcBatchUploadItemSoap toSoapModel(MarcBatchUploadItem model) {
		MarcBatchUploadItemSoap soapModel = new MarcBatchUploadItemSoap();

		soapModel.setMarcBatchUploadItemId(model.getMarcBatchUploadItemId());
		soapModel.setMarcBatchUploadId(model.getMarcBatchUploadId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setProcessed(model.getProcessed());
		soapModel.setImportDate(model.getImportDate());
		soapModel.setImportByUserId(model.getImportByUserId());
		soapModel.setMarcContent(model.getMarcContent());
		soapModel.setFileName(model.getFileName());
		soapModel.setFileEntryId(model.getFileEntryId());

		return soapModel;
	}

	public static MarcBatchUploadItemSoap[] toSoapModels(
		MarcBatchUploadItem[] models) {
		MarcBatchUploadItemSoap[] soapModels = new MarcBatchUploadItemSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MarcBatchUploadItemSoap[][] toSoapModels(
		MarcBatchUploadItem[][] models) {
		MarcBatchUploadItemSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MarcBatchUploadItemSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MarcBatchUploadItemSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MarcBatchUploadItemSoap[] toSoapModels(
		List<MarcBatchUploadItem> models) {
		List<MarcBatchUploadItemSoap> soapModels = new ArrayList<MarcBatchUploadItemSoap>(models.size());

		for (MarcBatchUploadItem model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MarcBatchUploadItemSoap[soapModels.size()]);
	}

	public MarcBatchUploadItemSoap() {
	}

	public long getPrimaryKey() {
		return _marcBatchUploadItemId;
	}

	public void setPrimaryKey(long pk) {
		setMarcBatchUploadItemId(pk);
	}

	public long getMarcBatchUploadItemId() {
		return _marcBatchUploadItemId;
	}

	public void setMarcBatchUploadItemId(long marcBatchUploadItemId) {
		_marcBatchUploadItemId = marcBatchUploadItemId;
	}

	public long getMarcBatchUploadId() {
		return _marcBatchUploadId;
	}

	public void setMarcBatchUploadId(long marcBatchUploadId) {
		_marcBatchUploadId = marcBatchUploadId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public boolean getProcessed() {
		return _processed;
	}

	public boolean isProcessed() {
		return _processed;
	}

	public void setProcessed(boolean processed) {
		_processed = processed;
	}

	public Date getImportDate() {
		return _importDate;
	}

	public void setImportDate(Date importDate) {
		_importDate = importDate;
	}

	public long getImportByUserId() {
		return _importByUserId;
	}

	public void setImportByUserId(long importByUserId) {
		_importByUserId = importByUserId;
	}

	public String getMarcContent() {
		return _marcContent;
	}

	public void setMarcContent(String marcContent) {
		_marcContent = marcContent;
	}

	public String getFileName() {
		return _fileName;
	}

	public void setFileName(String fileName) {
		_fileName = fileName;
	}

	public long getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
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
	private String _marcContent;
	private String _fileName;
	private long _fileEntryId;
}