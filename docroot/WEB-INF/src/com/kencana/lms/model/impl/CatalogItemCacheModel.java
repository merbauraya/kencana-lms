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

import com.kencana.lms.model.CatalogItem;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CatalogItem in entity cache.
 *
 * @author Mazlan Mat
 * @see CatalogItem
 * @generated
 */
public class CatalogItemCacheModel implements CacheModel<CatalogItem>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(93);

		sb.append("{catalogItemId=");
		sb.append(catalogItemId);
		sb.append(", catalogId=");
		sb.append(catalogId);
		sb.append(", catalogTitle=");
		sb.append(catalogTitle);
		sb.append(", callNumber=");
		sb.append(callNumber);
		sb.append(", holdingLibraryId=");
		sb.append(holdingLibraryId);
		sb.append(", currentLibraryId=");
		sb.append(currentLibraryId);
		sb.append(", barcode=");
		sb.append(barcode);
		sb.append(", copyNumber=");
		sb.append(copyNumber);
		sb.append(", locationId=");
		sb.append(locationId);
		sb.append(", itemCategoryId=");
		sb.append(itemCategoryId);
		sb.append(", itemTypeId=");
		sb.append(itemTypeId);
		sb.append(", withdrawnStatus=");
		sb.append(withdrawnStatus);
		sb.append(", lostStatus=");
		sb.append(lostStatus);
		sb.append(", damageStatus=");
		sb.append(damageStatus);
		sb.append(", notForLoanStatus=");
		sb.append(notForLoanStatus);
		sb.append(", lastSeenDate=");
		sb.append(lastSeenDate);
		sb.append(", withdrawnDate=");
		sb.append(withdrawnDate);
		sb.append(", lostDate=");
		sb.append(lostDate);
		sb.append(", lastCheckOutDate=");
		sb.append(lastCheckOutDate);
		sb.append(", circulationCount=");
		sb.append(circulationCount);
		sb.append(", renewalCount=");
		sb.append(renewalCount);
		sb.append(", reservedCount=");
		sb.append(reservedCount);
		sb.append(", checkedOutDate=");
		sb.append(checkedOutDate);
		sb.append(", reservedBy=");
		sb.append(reservedBy);
		sb.append(", claimCount=");
		sb.append(claimCount);
		sb.append(", dueDate=");
		sb.append(dueDate);
		sb.append(", checkOutBy=");
		sb.append(checkOutBy);
		sb.append(", released=");
		sb.append(released);
		sb.append(", releaseDate=");
		sb.append(releaseDate);
		sb.append(", releaseByUserId=");
		sb.append(releaseByUserId);
		sb.append(", vendorId=");
		sb.append(vendorId);
		sb.append(", invoiceId=");
		sb.append(invoiceId);
		sb.append(", purchasePrice=");
		sb.append(purchasePrice);
		sb.append(", replacementPrice=");
		sb.append(replacementPrice);
		sb.append(", currencyId=");
		sb.append(currencyId);
		sb.append(", localPurchasePrice=");
		sb.append(localPurchasePrice);
		sb.append(", publicNote=");
		sb.append(publicNote);
		sb.append(", privateNote=");
		sb.append(privateNote);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", acquiredDate=");
		sb.append(acquiredDate);
		sb.append(", workflowStatus=");
		sb.append(workflowStatus);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CatalogItem toEntityModel() {
		CatalogItemImpl catalogItemImpl = new CatalogItemImpl();

		catalogItemImpl.setCatalogItemId(catalogItemId);
		catalogItemImpl.setCatalogId(catalogId);

		if (catalogTitle == null) {
			catalogItemImpl.setCatalogTitle(StringPool.BLANK);
		}
		else {
			catalogItemImpl.setCatalogTitle(catalogTitle);
		}

		if (callNumber == null) {
			catalogItemImpl.setCallNumber(StringPool.BLANK);
		}
		else {
			catalogItemImpl.setCallNumber(callNumber);
		}

		catalogItemImpl.setHoldingLibraryId(holdingLibraryId);
		catalogItemImpl.setCurrentLibraryId(currentLibraryId);

		if (barcode == null) {
			catalogItemImpl.setBarcode(StringPool.BLANK);
		}
		else {
			catalogItemImpl.setBarcode(barcode);
		}

		catalogItemImpl.setCopyNumber(copyNumber);
		catalogItemImpl.setLocationId(locationId);
		catalogItemImpl.setItemCategoryId(itemCategoryId);
		catalogItemImpl.setItemTypeId(itemTypeId);
		catalogItemImpl.setWithdrawnStatus(withdrawnStatus);
		catalogItemImpl.setLostStatus(lostStatus);
		catalogItemImpl.setDamageStatus(damageStatus);
		catalogItemImpl.setNotForLoanStatus(notForLoanStatus);

		if (lastSeenDate == Long.MIN_VALUE) {
			catalogItemImpl.setLastSeenDate(null);
		}
		else {
			catalogItemImpl.setLastSeenDate(new Date(lastSeenDate));
		}

		if (withdrawnDate == Long.MIN_VALUE) {
			catalogItemImpl.setWithdrawnDate(null);
		}
		else {
			catalogItemImpl.setWithdrawnDate(new Date(withdrawnDate));
		}

		if (lostDate == Long.MIN_VALUE) {
			catalogItemImpl.setLostDate(null);
		}
		else {
			catalogItemImpl.setLostDate(new Date(lostDate));
		}

		if (lastCheckOutDate == Long.MIN_VALUE) {
			catalogItemImpl.setLastCheckOutDate(null);
		}
		else {
			catalogItemImpl.setLastCheckOutDate(new Date(lastCheckOutDate));
		}

		catalogItemImpl.setCirculationCount(circulationCount);
		catalogItemImpl.setRenewalCount(renewalCount);
		catalogItemImpl.setReservedCount(reservedCount);

		if (checkedOutDate == Long.MIN_VALUE) {
			catalogItemImpl.setCheckedOutDate(null);
		}
		else {
			catalogItemImpl.setCheckedOutDate(new Date(checkedOutDate));
		}

		catalogItemImpl.setReservedBy(reservedBy);
		catalogItemImpl.setClaimCount(claimCount);

		if (dueDate == Long.MIN_VALUE) {
			catalogItemImpl.setDueDate(null);
		}
		else {
			catalogItemImpl.setDueDate(new Date(dueDate));
		}

		catalogItemImpl.setCheckOutBy(checkOutBy);
		catalogItemImpl.setReleased(released);

		if (releaseDate == Long.MIN_VALUE) {
			catalogItemImpl.setReleaseDate(null);
		}
		else {
			catalogItemImpl.setReleaseDate(new Date(releaseDate));
		}

		catalogItemImpl.setReleaseByUserId(releaseByUserId);
		catalogItemImpl.setVendorId(vendorId);
		catalogItemImpl.setInvoiceId(invoiceId);
		catalogItemImpl.setPurchasePrice(purchasePrice);
		catalogItemImpl.setReplacementPrice(replacementPrice);
		catalogItemImpl.setCurrencyId(currencyId);
		catalogItemImpl.setLocalPurchasePrice(localPurchasePrice);

		if (publicNote == null) {
			catalogItemImpl.setPublicNote(StringPool.BLANK);
		}
		else {
			catalogItemImpl.setPublicNote(publicNote);
		}

		if (privateNote == null) {
			catalogItemImpl.setPrivateNote(StringPool.BLANK);
		}
		else {
			catalogItemImpl.setPrivateNote(privateNote);
		}

		catalogItemImpl.setCompanyId(companyId);
		catalogItemImpl.setGroupId(groupId);
		catalogItemImpl.setUserId(userId);

		if (userName == null) {
			catalogItemImpl.setUserName(StringPool.BLANK);
		}
		else {
			catalogItemImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			catalogItemImpl.setCreateDate(null);
		}
		else {
			catalogItemImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			catalogItemImpl.setModifiedDate(null);
		}
		else {
			catalogItemImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (acquiredDate == Long.MIN_VALUE) {
			catalogItemImpl.setAcquiredDate(null);
		}
		else {
			catalogItemImpl.setAcquiredDate(new Date(acquiredDate));
		}

		catalogItemImpl.setWorkflowStatus(workflowStatus);

		catalogItemImpl.resetOriginalValues();

		return catalogItemImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		catalogItemId = objectInput.readLong();
		catalogId = objectInput.readLong();
		catalogTitle = objectInput.readUTF();
		callNumber = objectInput.readUTF();
		holdingLibraryId = objectInput.readLong();
		currentLibraryId = objectInput.readLong();
		barcode = objectInput.readUTF();
		copyNumber = objectInput.readInt();
		locationId = objectInput.readLong();
		itemCategoryId = objectInput.readLong();
		itemTypeId = objectInput.readLong();
		withdrawnStatus = objectInput.readBoolean();
		lostStatus = objectInput.readBoolean();
		damageStatus = objectInput.readBoolean();
		notForLoanStatus = objectInput.readBoolean();
		lastSeenDate = objectInput.readLong();
		withdrawnDate = objectInput.readLong();
		lostDate = objectInput.readLong();
		lastCheckOutDate = objectInput.readLong();
		circulationCount = objectInput.readInt();
		renewalCount = objectInput.readInt();
		reservedCount = objectInput.readInt();
		checkedOutDate = objectInput.readLong();
		reservedBy = objectInput.readLong();
		claimCount = objectInput.readDouble();
		dueDate = objectInput.readLong();
		checkOutBy = objectInput.readLong();
		released = objectInput.readBoolean();
		releaseDate = objectInput.readLong();
		releaseByUserId = objectInput.readLong();
		vendorId = objectInput.readLong();
		invoiceId = objectInput.readLong();
		purchasePrice = objectInput.readDouble();
		replacementPrice = objectInput.readDouble();
		currencyId = objectInput.readLong();
		localPurchasePrice = objectInput.readDouble();
		publicNote = objectInput.readUTF();
		privateNote = objectInput.readUTF();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		acquiredDate = objectInput.readLong();
		workflowStatus = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(catalogItemId);
		objectOutput.writeLong(catalogId);

		if (catalogTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(catalogTitle);
		}

		if (callNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(callNumber);
		}

		objectOutput.writeLong(holdingLibraryId);
		objectOutput.writeLong(currentLibraryId);

		if (barcode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(barcode);
		}

		objectOutput.writeInt(copyNumber);
		objectOutput.writeLong(locationId);
		objectOutput.writeLong(itemCategoryId);
		objectOutput.writeLong(itemTypeId);
		objectOutput.writeBoolean(withdrawnStatus);
		objectOutput.writeBoolean(lostStatus);
		objectOutput.writeBoolean(damageStatus);
		objectOutput.writeBoolean(notForLoanStatus);
		objectOutput.writeLong(lastSeenDate);
		objectOutput.writeLong(withdrawnDate);
		objectOutput.writeLong(lostDate);
		objectOutput.writeLong(lastCheckOutDate);
		objectOutput.writeInt(circulationCount);
		objectOutput.writeInt(renewalCount);
		objectOutput.writeInt(reservedCount);
		objectOutput.writeLong(checkedOutDate);
		objectOutput.writeLong(reservedBy);
		objectOutput.writeDouble(claimCount);
		objectOutput.writeLong(dueDate);
		objectOutput.writeLong(checkOutBy);
		objectOutput.writeBoolean(released);
		objectOutput.writeLong(releaseDate);
		objectOutput.writeLong(releaseByUserId);
		objectOutput.writeLong(vendorId);
		objectOutput.writeLong(invoiceId);
		objectOutput.writeDouble(purchasePrice);
		objectOutput.writeDouble(replacementPrice);
		objectOutput.writeLong(currencyId);
		objectOutput.writeDouble(localPurchasePrice);

		if (publicNote == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(publicNote);
		}

		if (privateNote == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(privateNote);
		}

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(acquiredDate);
		objectOutput.writeInt(workflowStatus);
	}

	public long catalogItemId;
	public long catalogId;
	public String catalogTitle;
	public String callNumber;
	public long holdingLibraryId;
	public long currentLibraryId;
	public String barcode;
	public int copyNumber;
	public long locationId;
	public long itemCategoryId;
	public long itemTypeId;
	public boolean withdrawnStatus;
	public boolean lostStatus;
	public boolean damageStatus;
	public boolean notForLoanStatus;
	public long lastSeenDate;
	public long withdrawnDate;
	public long lostDate;
	public long lastCheckOutDate;
	public int circulationCount;
	public int renewalCount;
	public int reservedCount;
	public long checkedOutDate;
	public long reservedBy;
	public Double claimCount;
	public long dueDate;
	public long checkOutBy;
	public boolean released;
	public long releaseDate;
	public long releaseByUserId;
	public long vendorId;
	public long invoiceId;
	public double purchasePrice;
	public double replacementPrice;
	public long currencyId;
	public double localPurchasePrice;
	public String publicNote;
	public String privateNote;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long acquiredDate;
	public int workflowStatus;
}