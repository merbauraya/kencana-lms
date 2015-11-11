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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MarcBatchUploadItem in entity cache.
 *
 * @author Mazlan Mat
 * @see MarcBatchUploadItem
 * @generated
 */
public class MarcBatchUploadItemCacheModel implements CacheModel<MarcBatchUploadItem>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{marcBatchUploadItemId=");
		sb.append(marcBatchUploadItemId);
		sb.append(", marcBatchUploadId=");
		sb.append(marcBatchUploadId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", processed=");
		sb.append(processed);
		sb.append(", importDate=");
		sb.append(importDate);
		sb.append(", importByUserId=");
		sb.append(importByUserId);
		sb.append(", marcContent=");
		sb.append(marcContent);
		sb.append(", fileName=");
		sb.append(fileName);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MarcBatchUploadItem toEntityModel() {
		MarcBatchUploadItemImpl marcBatchUploadItemImpl = new MarcBatchUploadItemImpl();

		marcBatchUploadItemImpl.setMarcBatchUploadItemId(marcBatchUploadItemId);
		marcBatchUploadItemImpl.setMarcBatchUploadId(marcBatchUploadId);
		marcBatchUploadItemImpl.setGroupId(groupId);
		marcBatchUploadItemImpl.setCompanyId(companyId);
		marcBatchUploadItemImpl.setCreatedBy(createdBy);

		if (createdDate == Long.MIN_VALUE) {
			marcBatchUploadItemImpl.setCreatedDate(null);
		}
		else {
			marcBatchUploadItemImpl.setCreatedDate(new Date(createdDate));
		}

		marcBatchUploadItemImpl.setProcessed(processed);

		if (importDate == Long.MIN_VALUE) {
			marcBatchUploadItemImpl.setImportDate(null);
		}
		else {
			marcBatchUploadItemImpl.setImportDate(new Date(importDate));
		}

		marcBatchUploadItemImpl.setImportByUserId(importByUserId);

		if (marcContent == null) {
			marcBatchUploadItemImpl.setMarcContent(StringPool.BLANK);
		}
		else {
			marcBatchUploadItemImpl.setMarcContent(marcContent);
		}

		if (fileName == null) {
			marcBatchUploadItemImpl.setFileName(StringPool.BLANK);
		}
		else {
			marcBatchUploadItemImpl.setFileName(fileName);
		}

		marcBatchUploadItemImpl.setFileEntryId(fileEntryId);

		marcBatchUploadItemImpl.resetOriginalValues();

		return marcBatchUploadItemImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		marcBatchUploadItemId = objectInput.readLong();
		marcBatchUploadId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		createdBy = objectInput.readLong();
		createdDate = objectInput.readLong();
		processed = objectInput.readBoolean();
		importDate = objectInput.readLong();
		importByUserId = objectInput.readLong();
		marcContent = objectInput.readUTF();
		fileName = objectInput.readUTF();
		fileEntryId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(marcBatchUploadItemId);
		objectOutput.writeLong(marcBatchUploadId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(createdDate);
		objectOutput.writeBoolean(processed);
		objectOutput.writeLong(importDate);
		objectOutput.writeLong(importByUserId);

		if (marcContent == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(marcContent);
		}

		if (fileName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fileName);
		}

		objectOutput.writeLong(fileEntryId);
	}

	public long marcBatchUploadItemId;
	public long marcBatchUploadId;
	public long groupId;
	public long companyId;
	public long createdBy;
	public long createdDate;
	public boolean processed;
	public long importDate;
	public long importByUserId;
	public String marcContent;
	public String fileName;
	public long fileEntryId;
}