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

import com.kencana.lms.model.Vendor;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Vendor in entity cache.
 *
 * @author Mazlan Mat
 * @see Vendor
 * @generated
 */
public class VendorCacheModel implements CacheModel<Vendor>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{vendorId=");
		sb.append(vendorId);
		sb.append(", vendorCode=");
		sb.append(vendorCode);
		sb.append(", vendorName=");
		sb.append(vendorName);
		sb.append(", email=");
		sb.append(email);
		sb.append(", url=");
		sb.append(url);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", address1=");
		sb.append(address1);
		sb.append(", address2=");
		sb.append(address2);
		sb.append(", address3=");
		sb.append(address3);
		sb.append(", city=");
		sb.append(city);
		sb.append(", zipcode=");
		sb.append(zipcode);
		sb.append(", contactPerson=");
		sb.append(contactPerson);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", fax=");
		sb.append(fax);
		sb.append(", isPublisher=");
		sb.append(isPublisher);
		sb.append(", isBinder=");
		sb.append(isBinder);
		sb.append(", isActive=");
		sb.append(isActive);
		sb.append(", rating=");
		sb.append(rating);
		sb.append(", bankName=");
		sb.append(bankName);
		sb.append(", bankAccount=");
		sb.append(bankAccount);
		sb.append(", lastOrderDate=");
		sb.append(lastOrderDate);
		sb.append(", note=");
		sb.append(note);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Vendor toEntityModel() {
		VendorImpl vendorImpl = new VendorImpl();

		vendorImpl.setVendorId(vendorId);

		if (vendorCode == null) {
			vendorImpl.setVendorCode(StringPool.BLANK);
		}
		else {
			vendorImpl.setVendorCode(vendorCode);
		}

		if (vendorName == null) {
			vendorImpl.setVendorName(StringPool.BLANK);
		}
		else {
			vendorImpl.setVendorName(vendorName);
		}

		if (email == null) {
			vendorImpl.setEmail(StringPool.BLANK);
		}
		else {
			vendorImpl.setEmail(email);
		}

		if (url == null) {
			vendorImpl.setUrl(StringPool.BLANK);
		}
		else {
			vendorImpl.setUrl(url);
		}

		vendorImpl.setCompanyId(companyId);
		vendorImpl.setGroupId(groupId);

		if (address1 == null) {
			vendorImpl.setAddress1(StringPool.BLANK);
		}
		else {
			vendorImpl.setAddress1(address1);
		}

		if (address2 == null) {
			vendorImpl.setAddress2(StringPool.BLANK);
		}
		else {
			vendorImpl.setAddress2(address2);
		}

		if (address3 == null) {
			vendorImpl.setAddress3(StringPool.BLANK);
		}
		else {
			vendorImpl.setAddress3(address3);
		}

		if (city == null) {
			vendorImpl.setCity(StringPool.BLANK);
		}
		else {
			vendorImpl.setCity(city);
		}

		if (zipcode == null) {
			vendorImpl.setZipcode(StringPool.BLANK);
		}
		else {
			vendorImpl.setZipcode(zipcode);
		}

		if (contactPerson == null) {
			vendorImpl.setContactPerson(StringPool.BLANK);
		}
		else {
			vendorImpl.setContactPerson(contactPerson);
		}

		if (phone == null) {
			vendorImpl.setPhone(StringPool.BLANK);
		}
		else {
			vendorImpl.setPhone(phone);
		}

		if (fax == null) {
			vendorImpl.setFax(StringPool.BLANK);
		}
		else {
			vendorImpl.setFax(fax);
		}

		vendorImpl.setIsPublisher(isPublisher);
		vendorImpl.setIsBinder(isBinder);
		vendorImpl.setIsActive(isActive);

		if (rating == null) {
			vendorImpl.setRating(StringPool.BLANK);
		}
		else {
			vendorImpl.setRating(rating);
		}

		if (bankName == null) {
			vendorImpl.setBankName(StringPool.BLANK);
		}
		else {
			vendorImpl.setBankName(bankName);
		}

		if (bankAccount == null) {
			vendorImpl.setBankAccount(StringPool.BLANK);
		}
		else {
			vendorImpl.setBankAccount(bankAccount);
		}

		if (lastOrderDate == Long.MIN_VALUE) {
			vendorImpl.setLastOrderDate(null);
		}
		else {
			vendorImpl.setLastOrderDate(new Date(lastOrderDate));
		}

		if (note == null) {
			vendorImpl.setNote(StringPool.BLANK);
		}
		else {
			vendorImpl.setNote(note);
		}

		vendorImpl.resetOriginalValues();

		return vendorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		vendorId = objectInput.readLong();
		vendorCode = objectInput.readUTF();
		vendorName = objectInput.readUTF();
		email = objectInput.readUTF();
		url = objectInput.readUTF();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		address1 = objectInput.readUTF();
		address2 = objectInput.readUTF();
		address3 = objectInput.readUTF();
		city = objectInput.readUTF();
		zipcode = objectInput.readUTF();
		contactPerson = objectInput.readUTF();
		phone = objectInput.readUTF();
		fax = objectInput.readUTF();
		isPublisher = objectInput.readBoolean();
		isBinder = objectInput.readBoolean();
		isActive = objectInput.readBoolean();
		rating = objectInput.readUTF();
		bankName = objectInput.readUTF();
		bankAccount = objectInput.readUTF();
		lastOrderDate = objectInput.readLong();
		note = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(vendorId);

		if (vendorCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(vendorCode);
		}

		if (vendorName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(vendorName);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (url == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(url);
		}

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);

		if (address1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(address1);
		}

		if (address2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(address2);
		}

		if (address3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(address3);
		}

		if (city == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (zipcode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zipcode);
		}

		if (contactPerson == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactPerson);
		}

		if (phone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(phone);
		}

		if (fax == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fax);
		}

		objectOutput.writeBoolean(isPublisher);
		objectOutput.writeBoolean(isBinder);
		objectOutput.writeBoolean(isActive);

		if (rating == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(rating);
		}

		if (bankName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bankName);
		}

		if (bankAccount == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bankAccount);
		}

		objectOutput.writeLong(lastOrderDate);

		if (note == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(note);
		}
	}

	public long vendorId;
	public String vendorCode;
	public String vendorName;
	public String email;
	public String url;
	public long companyId;
	public long groupId;
	public String address1;
	public String address2;
	public String address3;
	public String city;
	public String zipcode;
	public String contactPerson;
	public String phone;
	public String fax;
	public boolean isPublisher;
	public boolean isBinder;
	public boolean isActive;
	public String rating;
	public String bankName;
	public String bankAccount;
	public long lastOrderDate;
	public String note;
}