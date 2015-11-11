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

import com.kencana.lms.model.CirculationRule;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CirculationRule in entity cache.
 *
 * @author Mazlan Mat
 * @see CirculationRule
 * @generated
 */
public class CirculationRuleCacheModel implements CacheModel<CirculationRule>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{circulationRuleId=");
		sb.append(circulationRuleId);
		sb.append(", libraryId=");
		sb.append(libraryId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", patronCategoryId=");
		sb.append(patronCategoryId);
		sb.append(", itemTypeId=");
		sb.append(itemTypeId);
		sb.append(", itemCategoryId=");
		sb.append(itemCategoryId);
		sb.append(", maxCheckoutAllowed=");
		sb.append(maxCheckoutAllowed);
		sb.append(", renewalCountAllowed=");
		sb.append(renewalCountAllowed);
		sb.append(", reservedCountAllowed=");
		sb.append(reservedCountAllowed);
		sb.append(", periodUnit=");
		sb.append(periodUnit);
		sb.append(", loanPeriod=");
		sb.append(loanPeriod);
		sb.append(", loanPeriodIfReserved=");
		sb.append(loanPeriodIfReserved);
		sb.append(", rentalCharge=");
		sb.append(rentalCharge);
		sb.append(", finePerPeriod=");
		sb.append(finePerPeriod);
		sb.append(", fineGracePeriod=");
		sb.append(fineGracePeriod);
		sb.append(", maxFineAmount=");
		sb.append(maxFineAmount);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CirculationRule toEntityModel() {
		CirculationRuleImpl circulationRuleImpl = new CirculationRuleImpl();

		circulationRuleImpl.setCirculationRuleId(circulationRuleId);
		circulationRuleImpl.setLibraryId(libraryId);
		circulationRuleImpl.setCompanyId(companyId);
		circulationRuleImpl.setGroupId(groupId);
		circulationRuleImpl.setPatronCategoryId(patronCategoryId);
		circulationRuleImpl.setItemTypeId(itemTypeId);
		circulationRuleImpl.setItemCategoryId(itemCategoryId);
		circulationRuleImpl.setMaxCheckoutAllowed(maxCheckoutAllowed);
		circulationRuleImpl.setRenewalCountAllowed(renewalCountAllowed);
		circulationRuleImpl.setReservedCountAllowed(reservedCountAllowed);
		circulationRuleImpl.setPeriodUnit(periodUnit);
		circulationRuleImpl.setLoanPeriod(loanPeriod);
		circulationRuleImpl.setLoanPeriodIfReserved(loanPeriodIfReserved);
		circulationRuleImpl.setRentalCharge(rentalCharge);
		circulationRuleImpl.setFinePerPeriod(finePerPeriod);
		circulationRuleImpl.setFineGracePeriod(fineGracePeriod);
		circulationRuleImpl.setMaxFineAmount(maxFineAmount);
		circulationRuleImpl.setUserId(userId);

		if (createdDate == Long.MIN_VALUE) {
			circulationRuleImpl.setCreatedDate(null);
		}
		else {
			circulationRuleImpl.setCreatedDate(new Date(createdDate));
		}

		circulationRuleImpl.resetOriginalValues();

		return circulationRuleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		circulationRuleId = objectInput.readLong();
		libraryId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		patronCategoryId = objectInput.readLong();
		itemTypeId = objectInput.readLong();
		itemCategoryId = objectInput.readLong();
		maxCheckoutAllowed = objectInput.readInt();
		renewalCountAllowed = objectInput.readInt();
		reservedCountAllowed = objectInput.readInt();
		periodUnit = objectInput.readInt();
		loanPeriod = objectInput.readInt();
		loanPeriodIfReserved = objectInput.readInt();
		rentalCharge = objectInput.readDouble();
		finePerPeriod = objectInput.readDouble();
		fineGracePeriod = objectInput.readInt();
		maxFineAmount = objectInput.readDouble();
		userId = objectInput.readLong();
		createdDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(circulationRuleId);
		objectOutput.writeLong(libraryId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(patronCategoryId);
		objectOutput.writeLong(itemTypeId);
		objectOutput.writeLong(itemCategoryId);
		objectOutput.writeInt(maxCheckoutAllowed);
		objectOutput.writeInt(renewalCountAllowed);
		objectOutput.writeInt(reservedCountAllowed);
		objectOutput.writeInt(periodUnit);
		objectOutput.writeInt(loanPeriod);
		objectOutput.writeInt(loanPeriodIfReserved);
		objectOutput.writeDouble(rentalCharge);
		objectOutput.writeDouble(finePerPeriod);
		objectOutput.writeInt(fineGracePeriod);
		objectOutput.writeDouble(maxFineAmount);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createdDate);
	}

	public long circulationRuleId;
	public long libraryId;
	public long companyId;
	public long groupId;
	public long patronCategoryId;
	public long itemTypeId;
	public long itemCategoryId;
	public int maxCheckoutAllowed;
	public int renewalCountAllowed;
	public int reservedCountAllowed;
	public int periodUnit;
	public int loanPeriod;
	public int loanPeriodIfReserved;
	public double rentalCharge;
	public double finePerPeriod;
	public int fineGracePeriod;
	public double maxFineAmount;
	public long userId;
	public long createdDate;
}