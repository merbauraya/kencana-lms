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

package com.kencana.lms.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.kencana.lms.service.http.LibraryServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.kencana.lms.service.http.LibraryServiceSoap
 * @generated
 */
public class LibrarySoap implements Serializable {
	public static LibrarySoap toSoapModel(Library model) {
		LibrarySoap soapModel = new LibrarySoap();

		soapModel.setLibraryId(model.getLibraryId());
		soapModel.setLibraryName(model.getLibraryName());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setAddress1(model.getAddress1());
		soapModel.setAddress2(model.getAddress2());
		soapModel.setAddress3(model.getAddress3());
		soapModel.setZipcode(model.getZipcode());
		soapModel.setCity(model.getCity());
		soapModel.setState(model.getState());
		soapModel.setCountry(model.getCountry());
		soapModel.setPhone(model.getPhone());
		soapModel.setEmail(model.getEmail());
		soapModel.setWebsite(model.getWebsite());
		soapModel.setNotes(model.getNotes());

		return soapModel;
	}

	public static LibrarySoap[] toSoapModels(Library[] models) {
		LibrarySoap[] soapModels = new LibrarySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LibrarySoap[][] toSoapModels(Library[][] models) {
		LibrarySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LibrarySoap[models.length][models[0].length];
		}
		else {
			soapModels = new LibrarySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LibrarySoap[] toSoapModels(List<Library> models) {
		List<LibrarySoap> soapModels = new ArrayList<LibrarySoap>(models.size());

		for (Library model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LibrarySoap[soapModels.size()]);
	}

	public LibrarySoap() {
	}

	public long getPrimaryKey() {
		return _libraryId;
	}

	public void setPrimaryKey(long pk) {
		setLibraryId(pk);
	}

	public long getLibraryId() {
		return _libraryId;
	}

	public void setLibraryId(long libraryId) {
		_libraryId = libraryId;
	}

	public String getLibraryName() {
		return _libraryName;
	}

	public void setLibraryName(String libraryName) {
		_libraryName = libraryName;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getAddress1() {
		return _address1;
	}

	public void setAddress1(String address1) {
		_address1 = address1;
	}

	public String getAddress2() {
		return _address2;
	}

	public void setAddress2(String address2) {
		_address2 = address2;
	}

	public String getAddress3() {
		return _address3;
	}

	public void setAddress3(String address3) {
		_address3 = address3;
	}

	public String getZipcode() {
		return _zipcode;
	}

	public void setZipcode(String zipcode) {
		_zipcode = zipcode;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;
	}

	public String getCountry() {
		return _country;
	}

	public void setCountry(String country) {
		_country = country;
	}

	public String getPhone() {
		return _phone;
	}

	public void setPhone(String phone) {
		_phone = phone;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getWebsite() {
		return _website;
	}

	public void setWebsite(String website) {
		_website = website;
	}

	public String getNotes() {
		return _notes;
	}

	public void setNotes(String notes) {
		_notes = notes;
	}

	private long _libraryId;
	private String _libraryName;
	private long _groupId;
	private long _companyId;
	private String _address1;
	private String _address2;
	private String _address3;
	private String _zipcode;
	private String _city;
	private String _state;
	private String _country;
	private String _phone;
	private String _email;
	private String _website;
	private String _notes;
}