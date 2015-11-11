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

import com.kencana.lms.model.MarcBatchUpload;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MarcBatchUpload in entity cache.
 *
 * @author Mazlan Mat
 * @see MarcBatchUpload
 * @generated
 */
public class MarcBatchUploadCacheModel implements CacheModel<MarcBatchUpload>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{marcBatchUploadId=");
		sb.append(marcBatchUploadId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createBy=");
		sb.append(createBy);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", processed=");
		sb.append(processed);
		sb.append(", importDate=");
		sb.append(importDate);
		sb.append(", importByUserId=");
		sb.append(importByUserId);
		sb.append(", partialImport=");
		sb.append(partialImport);
		sb.append(", fileCount=");
		sb.append(fileCount);
		sb.append(", description=");
		sb.append(description);
		sb.append(", recordCount=");
		sb.append(recordCount);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MarcBatchUpload toEntityModel() {
		MarcBatchUploadImpl marcBatchUploadImpl = new MarcBatchUploadImpl();

		marcBatchUploadImpl.setMarcBatchUploadId(marcBatchUploadId);
		marcBatchUploadImpl.setGroupId(groupId);
		marcBatchUploadImpl.setCompanyId(companyId);
		marcBatchUploadImpl.setCreateBy(createBy);

		if (createdDate == Long.MIN_VALUE) {
			marcBatchUploadImpl.setCreatedDate(null);
		}
		else {
			marcBatchUploadImpl.setCreatedDate(new Date(createdDate));
		}

		marcBatchUploadImpl.setProcessed(processed);

		if (importDate == Long.MIN_VALUE) {
			marcBatchUploadImpl.setImportDate(null);
		}
		else {
			marcBatchUploadImpl.setImportDate(new Date(importDate));
		}

		marcBatchUploadImpl.setImportByUserId(importByUserId);
		marcBatchUploadImpl.setPartialImport(partialImport);
		marcBatchUploadImpl.setFileCount(fileCount);

		if (description == null) {
			marcBatchUploadImpl.setDescription(StringPool.BLANK);
		}
		else {
			marcBatchUploadImpl.setDescription(description);
		}

		marcBatchUploadImpl.setRecordCount(recordCount);

		marcBatchUploadImpl.resetOriginalValues();

		return marcBatchUploadImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		marcBatchUploadId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		createBy = objectInput.readLong();
		createdDate = objectInput.readLong();
		processed = objectInput.readBoolean();
		importDate = objectInput.readLong();
		importByUserId = objectInput.readLong();
		partialImport = objectInput.readBoolean();
		fileCount = objectInput.readInt();
		description = objectInput.readUTF();
		recordCount = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(marcBatchUploadId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createBy);
		objectOutput.writeLong(createdDate);
		objectOutput.writeBoolean(processed);
		objectOutput.writeLong(importDate);
		objectOutput.writeLong(importByUserId);
		objectOutput.writeBoolean(partialImport);
		objectOutput.writeInt(fileCount);

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeInt(recordCount);
	}

	public long marcBatchUploadId;
	public long groupId;
	public long companyId;
	public long createBy;
	public long createdDate;
	public boolean processed;
	public long importDate;
	public long importByUserId;
	public boolean partialImport;
	public int fileCount;
	public String description;
	public int recordCount;
}