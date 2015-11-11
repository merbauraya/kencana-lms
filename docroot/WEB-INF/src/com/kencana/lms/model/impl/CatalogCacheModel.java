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

import com.kencana.lms.model.Catalog;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Catalog in entity cache.
 *
 * @author Mazlan Mat
 * @see Catalog
 * @generated
 */
public class CatalogCacheModel implements CacheModel<Catalog>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{catalogId=");
		sb.append(catalogId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createdByUserId=");
		sb.append(createdByUserId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", itemTypeId=");
		sb.append(itemTypeId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", author=");
		sb.append(author);
		sb.append(", publisher=");
		sb.append(publisher);
		sb.append(", isbn=");
		sb.append(isbn);
		sb.append(", issn=");
		sb.append(issn);
		sb.append(", callNumber=");
		sb.append(callNumber);
		sb.append(", UUID=");
		sb.append(UUID);
		sb.append(", catalogAbstract=");
		sb.append(catalogAbstract);
		sb.append(", templateId=");
		sb.append(templateId);
		sb.append(", visible=");
		sb.append(visible);
		sb.append(", coverImageId=");
		sb.append(coverImageId);
		sb.append(", marc=");
		sb.append(marc);
		sb.append(", workflowStatus=");
		sb.append(workflowStatus);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Catalog toEntityModel() {
		CatalogImpl catalogImpl = new CatalogImpl();

		catalogImpl.setCatalogId(catalogId);
		catalogImpl.setCompanyId(companyId);
		catalogImpl.setGroupId(groupId);
		catalogImpl.setUserId(userId);

		if (userName == null) {
			catalogImpl.setUserName(StringPool.BLANK);
		}
		else {
			catalogImpl.setUserName(userName);
		}

		catalogImpl.setCreatedByUserId(createdByUserId);

		if (createDate == Long.MIN_VALUE) {
			catalogImpl.setCreateDate(null);
		}
		else {
			catalogImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			catalogImpl.setModifiedDate(null);
		}
		else {
			catalogImpl.setModifiedDate(new Date(modifiedDate));
		}

		catalogImpl.setItemTypeId(itemTypeId);

		if (title == null) {
			catalogImpl.setTitle(StringPool.BLANK);
		}
		else {
			catalogImpl.setTitle(title);
		}

		if (author == null) {
			catalogImpl.setAuthor(StringPool.BLANK);
		}
		else {
			catalogImpl.setAuthor(author);
		}

		if (publisher == null) {
			catalogImpl.setPublisher(StringPool.BLANK);
		}
		else {
			catalogImpl.setPublisher(publisher);
		}

		if (isbn == null) {
			catalogImpl.setIsbn(StringPool.BLANK);
		}
		else {
			catalogImpl.setIsbn(isbn);
		}

		if (issn == null) {
			catalogImpl.setIssn(StringPool.BLANK);
		}
		else {
			catalogImpl.setIssn(issn);
		}

		if (callNumber == null) {
			catalogImpl.setCallNumber(StringPool.BLANK);
		}
		else {
			catalogImpl.setCallNumber(callNumber);
		}

		if (UUID == null) {
			catalogImpl.setUUID(StringPool.BLANK);
		}
		else {
			catalogImpl.setUUID(UUID);
		}

		if (catalogAbstract == null) {
			catalogImpl.setCatalogAbstract(StringPool.BLANK);
		}
		else {
			catalogImpl.setCatalogAbstract(catalogAbstract);
		}

		catalogImpl.setTemplateId(templateId);
		catalogImpl.setVisible(visible);
		catalogImpl.setCoverImageId(coverImageId);

		if (marc == null) {
			catalogImpl.setMarc(StringPool.BLANK);
		}
		else {
			catalogImpl.setMarc(marc);
		}

		catalogImpl.setWorkflowStatus(workflowStatus);

		catalogImpl.resetOriginalValues();

		return catalogImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		catalogId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createdByUserId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		itemTypeId = objectInput.readLong();
		title = objectInput.readUTF();
		author = objectInput.readUTF();
		publisher = objectInput.readUTF();
		isbn = objectInput.readUTF();
		issn = objectInput.readUTF();
		callNumber = objectInput.readUTF();
		UUID = objectInput.readUTF();
		catalogAbstract = objectInput.readUTF();
		templateId = objectInput.readLong();
		visible = objectInput.readBoolean();
		coverImageId = objectInput.readLong();
		marc = objectInput.readUTF();
		workflowStatus = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(catalogId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createdByUserId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(itemTypeId);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (author == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(author);
		}

		if (publisher == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(publisher);
		}

		if (isbn == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(isbn);
		}

		if (issn == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(issn);
		}

		if (callNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(callNumber);
		}

		if (UUID == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(UUID);
		}

		if (catalogAbstract == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(catalogAbstract);
		}

		objectOutput.writeLong(templateId);
		objectOutput.writeBoolean(visible);
		objectOutput.writeLong(coverImageId);

		if (marc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(marc);
		}

		objectOutput.writeInt(workflowStatus);
	}

	public long catalogId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createdByUserId;
	public long createDate;
	public long modifiedDate;
	public long itemTypeId;
	public String title;
	public String author;
	public String publisher;
	public String isbn;
	public String issn;
	public String callNumber;
	public String UUID;
	public String catalogAbstract;
	public long templateId;
	public boolean visible;
	public long coverImageId;
	public String marc;
	public int workflowStatus;
}