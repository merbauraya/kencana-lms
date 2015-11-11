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

import com.kencana.lms.model.Patron;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Patron in entity cache.
 *
 * @author Mazlan Mat
 * @see Patron
 * @generated
 */
public class PatronCacheModel implements CacheModel<Patron>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{patronId=");
		sb.append(patronId);
		sb.append(", cardNumber=");
		sb.append(cardNumber);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", libraryId=");
		sb.append(libraryId);
		sb.append(", expiryDate=");
		sb.append(expiryDate);
		sb.append(", patronCategoryId=");
		sb.append(patronCategoryId);
		sb.append(", patronStatusId=");
		sb.append(patronStatusId);
		sb.append(", patronNote=");
		sb.append(patronNote);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Patron toEntityModel() {
		PatronImpl patronImpl = new PatronImpl();

		patronImpl.setPatronId(patronId);

		if (cardNumber == null) {
			patronImpl.setCardNumber(StringPool.BLANK);
		}
		else {
			patronImpl.setCardNumber(cardNumber);
		}

		patronImpl.setUserId(userId);
		patronImpl.setGroupId(groupId);
		patronImpl.setCompanyId(companyId);
		patronImpl.setLibraryId(libraryId);

		if (expiryDate == Long.MIN_VALUE) {
			patronImpl.setExpiryDate(null);
		}
		else {
			patronImpl.setExpiryDate(new Date(expiryDate));
		}

		patronImpl.setPatronCategoryId(patronCategoryId);
		patronImpl.setPatronStatusId(patronStatusId);

		if (patronNote == null) {
			patronImpl.setPatronNote(StringPool.BLANK);
		}
		else {
			patronImpl.setPatronNote(patronNote);
		}

		patronImpl.resetOriginalValues();

		return patronImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		patronId = objectInput.readLong();
		cardNumber = objectInput.readUTF();
		userId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		libraryId = objectInput.readLong();
		expiryDate = objectInput.readLong();
		patronCategoryId = objectInput.readLong();
		patronStatusId = objectInput.readLong();
		patronNote = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(patronId);

		if (cardNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cardNumber);
		}

		objectOutput.writeLong(userId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(libraryId);
		objectOutput.writeLong(expiryDate);
		objectOutput.writeLong(patronCategoryId);
		objectOutput.writeLong(patronStatusId);

		if (patronNote == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(patronNote);
		}
	}

	public long patronId;
	public String cardNumber;
	public long userId;
	public long groupId;
	public long companyId;
	public long libraryId;
	public long expiryDate;
	public long patronCategoryId;
	public long patronStatusId;
	public String patronNote;
}