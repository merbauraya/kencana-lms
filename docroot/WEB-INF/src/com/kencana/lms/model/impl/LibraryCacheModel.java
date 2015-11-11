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

import com.kencana.lms.model.Library;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Library in entity cache.
 *
 * @author Mazlan Mat
 * @see Library
 * @generated
 */
public class LibraryCacheModel implements CacheModel<Library>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{libraryId=");
		sb.append(libraryId);
		sb.append(", libraryName=");
		sb.append(libraryName);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", address1=");
		sb.append(address1);
		sb.append(", address2=");
		sb.append(address2);
		sb.append(", address3=");
		sb.append(address3);
		sb.append(", zipcode=");
		sb.append(zipcode);
		sb.append(", city=");
		sb.append(city);
		sb.append(", state=");
		sb.append(state);
		sb.append(", country=");
		sb.append(country);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", email=");
		sb.append(email);
		sb.append(", website=");
		sb.append(website);
		sb.append(", notes=");
		sb.append(notes);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Library toEntityModel() {
		LibraryImpl libraryImpl = new LibraryImpl();

		libraryImpl.setLibraryId(libraryId);

		if (libraryName == null) {
			libraryImpl.setLibraryName(StringPool.BLANK);
		}
		else {
			libraryImpl.setLibraryName(libraryName);
		}

		libraryImpl.setGroupId(groupId);
		libraryImpl.setCompanyId(companyId);

		if (address1 == null) {
			libraryImpl.setAddress1(StringPool.BLANK);
		}
		else {
			libraryImpl.setAddress1(address1);
		}

		if (address2 == null) {
			libraryImpl.setAddress2(StringPool.BLANK);
		}
		else {
			libraryImpl.setAddress2(address2);
		}

		if (address3 == null) {
			libraryImpl.setAddress3(StringPool.BLANK);
		}
		else {
			libraryImpl.setAddress3(address3);
		}

		if (zipcode == null) {
			libraryImpl.setZipcode(StringPool.BLANK);
		}
		else {
			libraryImpl.setZipcode(zipcode);
		}

		if (city == null) {
			libraryImpl.setCity(StringPool.BLANK);
		}
		else {
			libraryImpl.setCity(city);
		}

		if (state == null) {
			libraryImpl.setState(StringPool.BLANK);
		}
		else {
			libraryImpl.setState(state);
		}

		if (country == null) {
			libraryImpl.setCountry(StringPool.BLANK);
		}
		else {
			libraryImpl.setCountry(country);
		}

		if (phone == null) {
			libraryImpl.setPhone(StringPool.BLANK);
		}
		else {
			libraryImpl.setPhone(phone);
		}

		if (email == null) {
			libraryImpl.setEmail(StringPool.BLANK);
		}
		else {
			libraryImpl.setEmail(email);
		}

		if (website == null) {
			libraryImpl.setWebsite(StringPool.BLANK);
		}
		else {
			libraryImpl.setWebsite(website);
		}

		if (notes == null) {
			libraryImpl.setNotes(StringPool.BLANK);
		}
		else {
			libraryImpl.setNotes(notes);
		}

		libraryImpl.resetOriginalValues();

		return libraryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		libraryId = objectInput.readLong();
		libraryName = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		address1 = objectInput.readUTF();
		address2 = objectInput.readUTF();
		address3 = objectInput.readUTF();
		zipcode = objectInput.readUTF();
		city = objectInput.readUTF();
		state = objectInput.readUTF();
		country = objectInput.readUTF();
		phone = objectInput.readUTF();
		email = objectInput.readUTF();
		website = objectInput.readUTF();
		notes = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(libraryId);

		if (libraryName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(libraryName);
		}

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);

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

		if (zipcode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zipcode);
		}

		if (city == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (state == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(state);
		}

		if (country == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(country);
		}

		if (phone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(phone);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (website == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(website);
		}

		if (notes == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(notes);
		}
	}

	public long libraryId;
	public String libraryName;
	public long groupId;
	public long companyId;
	public String address1;
	public String address2;
	public String address3;
	public String zipcode;
	public String city;
	public String state;
	public String country;
	public String phone;
	public String email;
	public String website;
	public String notes;
}