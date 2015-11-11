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

import com.kencana.lms.model.ItemCategory;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ItemCategory in entity cache.
 *
 * @author Mazlan Mat
 * @see ItemCategory
 * @generated
 */
public class ItemCategoryCacheModel implements CacheModel<ItemCategory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{itemCategoryId=");
		sb.append(itemCategoryId);
		sb.append(", itemCategoryName=");
		sb.append(itemCategoryName);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ItemCategory toEntityModel() {
		ItemCategoryImpl itemCategoryImpl = new ItemCategoryImpl();

		itemCategoryImpl.setItemCategoryId(itemCategoryId);

		if (itemCategoryName == null) {
			itemCategoryImpl.setItemCategoryName(StringPool.BLANK);
		}
		else {
			itemCategoryImpl.setItemCategoryName(itemCategoryName);
		}

		itemCategoryImpl.setGroupId(groupId);
		itemCategoryImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			itemCategoryImpl.setCreateDate(null);
		}
		else {
			itemCategoryImpl.setCreateDate(new Date(createDate));
		}

		itemCategoryImpl.setUserId(userId);

		if (modifiedDate == Long.MIN_VALUE) {
			itemCategoryImpl.setModifiedDate(null);
		}
		else {
			itemCategoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		itemCategoryImpl.resetOriginalValues();

		return itemCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		itemCategoryId = objectInput.readLong();
		itemCategoryName = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		userId = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(itemCategoryId);

		if (itemCategoryName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(itemCategoryName);
		}

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(modifiedDate);
	}

	public long itemCategoryId;
	public String itemCategoryName;
	public long groupId;
	public long companyId;
	public long createDate;
	public long userId;
	public long modifiedDate;
}