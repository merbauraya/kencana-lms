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
 * This class is used by SOAP remote services, specifically {@link com.kencana.lms.service.http.MarcBatchUploadServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.kencana.lms.service.http.MarcBatchUploadServiceSoap
 * @generated
 */
public class MarcBatchUploadSoap implements Serializable {
	public static MarcBatchUploadSoap toSoapModel(MarcBatchUpload model) {
		MarcBatchUploadSoap soapModel = new MarcBatchUploadSoap();

		soapModel.setMarcBatchUploadId(model.getMarcBatchUploadId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateBy(model.getCreateBy());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setProcessed(model.getProcessed());
		soapModel.setImportDate(model.getImportDate());
		soapModel.setImportByUserId(model.getImportByUserId());
		soapModel.setPartialImport(model.getPartialImport());
		soapModel.setFileCount(model.getFileCount());
		soapModel.setDescription(model.getDescription());
		soapModel.setRecordCount(model.getRecordCount());

		return soapModel;
	}

	public static MarcBatchUploadSoap[] toSoapModels(MarcBatchUpload[] models) {
		MarcBatchUploadSoap[] soapModels = new MarcBatchUploadSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MarcBatchUploadSoap[][] toSoapModels(
		MarcBatchUpload[][] models) {
		MarcBatchUploadSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MarcBatchUploadSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MarcBatchUploadSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MarcBatchUploadSoap[] toSoapModels(
		List<MarcBatchUpload> models) {
		List<MarcBatchUploadSoap> soapModels = new ArrayList<MarcBatchUploadSoap>(models.size());

		for (MarcBatchUpload model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MarcBatchUploadSoap[soapModels.size()]);
	}

	public MarcBatchUploadSoap() {
	}

	public long getPrimaryKey() {
		return _marcBatchUploadId;
	}

	public void setPrimaryKey(long pk) {
		setMarcBatchUploadId(pk);
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

	public long getCreateBy() {
		return _createBy;
	}

	public void setCreateBy(long createBy) {
		_createBy = createBy;
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

	public boolean getPartialImport() {
		return _partialImport;
	}

	public boolean isPartialImport() {
		return _partialImport;
	}

	public void setPartialImport(boolean partialImport) {
		_partialImport = partialImport;
	}

	public int getFileCount() {
		return _fileCount;
	}

	public void setFileCount(int fileCount) {
		_fileCount = fileCount;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public int getRecordCount() {
		return _recordCount;
	}

	public void setRecordCount(int recordCount) {
		_recordCount = recordCount;
	}

	private long _marcBatchUploadId;
	private long _groupId;
	private long _companyId;
	private long _createBy;
	private Date _createdDate;
	private boolean _processed;
	private Date _importDate;
	private long _importByUserId;
	private boolean _partialImport;
	private int _fileCount;
	private String _description;
	private int _recordCount;
}