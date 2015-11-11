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

import com.kencana.lms.model.CircTransHistory;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CircTransHistory in entity cache.
 *
 * @author Mazlan Mat
 * @see CircTransHistory
 * @generated
 */
public class CircTransHistoryCacheModel implements CacheModel<CircTransHistory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{transId=");
		sb.append(transId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", libraryId=");
		sb.append(libraryId);
		sb.append(", patronId=");
		sb.append(patronId);
		sb.append(", catalogItemId=");
		sb.append(catalogItemId);
		sb.append(", transDate=");
		sb.append(transDate);
		sb.append(", dueDate=");
		sb.append(dueDate);
		sb.append(", overdue=");
		sb.append(overdue);
		sb.append(", returnDate=");
		sb.append(returnDate);
		sb.append(", lastRenewDate=");
		sb.append(lastRenewDate);
		sb.append(", renewCount=");
		sb.append(renewCount);
		sb.append(", fineAmount=");
		sb.append(fineAmount);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CircTransHistory toEntityModel() {
		CircTransHistoryImpl circTransHistoryImpl = new CircTransHistoryImpl();

		circTransHistoryImpl.setTransId(transId);
		circTransHistoryImpl.setCompanyId(companyId);
		circTransHistoryImpl.setGroupId(groupId);
		circTransHistoryImpl.setLibraryId(libraryId);
		circTransHistoryImpl.setPatronId(patronId);
		circTransHistoryImpl.setCatalogItemId(catalogItemId);

		if (transDate == Long.MIN_VALUE) {
			circTransHistoryImpl.setTransDate(null);
		}
		else {
			circTransHistoryImpl.setTransDate(new Date(transDate));
		}

		if (dueDate == Long.MIN_VALUE) {
			circTransHistoryImpl.setDueDate(null);
		}
		else {
			circTransHistoryImpl.setDueDate(new Date(dueDate));
		}

		circTransHistoryImpl.setOverdue(overdue);

		if (returnDate == Long.MIN_VALUE) {
			circTransHistoryImpl.setReturnDate(null);
		}
		else {
			circTransHistoryImpl.setReturnDate(new Date(returnDate));
		}

		if (lastRenewDate == Long.MIN_VALUE) {
			circTransHistoryImpl.setLastRenewDate(null);
		}
		else {
			circTransHistoryImpl.setLastRenewDate(new Date(lastRenewDate));
		}

		circTransHistoryImpl.setRenewCount(renewCount);
		circTransHistoryImpl.setFineAmount(fineAmount);

		circTransHistoryImpl.resetOriginalValues();

		return circTransHistoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		transId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		libraryId = objectInput.readLong();
		patronId = objectInput.readLong();
		catalogItemId = objectInput.readLong();
		transDate = objectInput.readLong();
		dueDate = objectInput.readLong();
		overdue = objectInput.readBoolean();
		returnDate = objectInput.readLong();
		lastRenewDate = objectInput.readLong();
		renewCount = objectInput.readInt();
		fineAmount = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(transId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(libraryId);
		objectOutput.writeLong(patronId);
		objectOutput.writeLong(catalogItemId);
		objectOutput.writeLong(transDate);
		objectOutput.writeLong(dueDate);
		objectOutput.writeBoolean(overdue);
		objectOutput.writeLong(returnDate);
		objectOutput.writeLong(lastRenewDate);
		objectOutput.writeInt(renewCount);
		objectOutput.writeDouble(fineAmount);
	}

	public long transId;
	public long companyId;
	public long groupId;
	public long libraryId;
	public long patronId;
	public long catalogItemId;
	public long transDate;
	public long dueDate;
	public boolean overdue;
	public long returnDate;
	public long lastRenewDate;
	public int renewCount;
	public Double fineAmount;
}