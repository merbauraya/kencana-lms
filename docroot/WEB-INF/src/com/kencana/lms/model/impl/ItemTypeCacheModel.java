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

import com.kencana.lms.model.ItemType;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ItemType in entity cache.
 *
 * @author Mazlan Mat
 * @see ItemType
 * @generated
 */
public class ItemTypeCacheModel implements CacheModel<ItemType>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{itemTypeId=");
		sb.append(itemTypeId);
		sb.append(", itemTypeName=");
		sb.append(itemTypeName);
		sb.append(", notForLoan=");
		sb.append(notForLoan);
		sb.append(", coverId=");
		sb.append(coverId);
		sb.append(", checkoutMessage=");
		sb.append(checkoutMessage);
		sb.append(", checkinMessage=");
		sb.append(checkinMessage);
		sb.append(", rentalRate=");
		sb.append(rentalRate);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ItemType toEntityModel() {
		ItemTypeImpl itemTypeImpl = new ItemTypeImpl();

		itemTypeImpl.setItemTypeId(itemTypeId);

		if (itemTypeName == null) {
			itemTypeImpl.setItemTypeName(StringPool.BLANK);
		}
		else {
			itemTypeImpl.setItemTypeName(itemTypeName);
		}

		itemTypeImpl.setNotForLoan(notForLoan);
		itemTypeImpl.setCoverId(coverId);

		if (checkoutMessage == null) {
			itemTypeImpl.setCheckoutMessage(StringPool.BLANK);
		}
		else {
			itemTypeImpl.setCheckoutMessage(checkoutMessage);
		}

		if (checkinMessage == null) {
			itemTypeImpl.setCheckinMessage(StringPool.BLANK);
		}
		else {
			itemTypeImpl.setCheckinMessage(checkinMessage);
		}

		itemTypeImpl.setRentalRate(rentalRate);
		itemTypeImpl.setCompanyId(companyId);
		itemTypeImpl.setGroupId(groupId);
		itemTypeImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			itemTypeImpl.setCreateDate(null);
		}
		else {
			itemTypeImpl.setCreateDate(new Date(createDate));
		}

		itemTypeImpl.resetOriginalValues();

		return itemTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		itemTypeId = objectInput.readLong();
		itemTypeName = objectInput.readUTF();
		notForLoan = objectInput.readBoolean();
		coverId = objectInput.readLong();
		checkoutMessage = objectInput.readUTF();
		checkinMessage = objectInput.readUTF();
		rentalRate = objectInput.readDouble();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(itemTypeId);

		if (itemTypeName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(itemTypeName);
		}

		objectOutput.writeBoolean(notForLoan);
		objectOutput.writeLong(coverId);

		if (checkoutMessage == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(checkoutMessage);
		}

		if (checkinMessage == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(checkinMessage);
		}

		objectOutput.writeDouble(rentalRate);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
	}

	public long itemTypeId;
	public String itemTypeName;
	public boolean notForLoan;
	public long coverId;
	public String checkoutMessage;
	public String checkinMessage;
	public Double rentalRate;
	public long companyId;
	public long groupId;
	public long userId;
	public long createDate;
}