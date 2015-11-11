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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.kencana.lms.service.http.VendorServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.kencana.lms.service.http.VendorServiceSoap
 * @generated
 */
public class VendorSoap implements Serializable {
	public static VendorSoap toSoapModel(Vendor model) {
		VendorSoap soapModel = new VendorSoap();

		soapModel.setVendorId(model.getVendorId());
		soapModel.setVendorCode(model.getVendorCode());
		soapModel.setVendorName(model.getVendorName());
		soapModel.setEmail(model.getEmail());
		soapModel.setUrl(model.getUrl());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setAddress1(model.getAddress1());
		soapModel.setAddress2(model.getAddress2());
		soapModel.setAddress3(model.getAddress3());
		soapModel.setCity(model.getCity());
		soapModel.setZipcode(model.getZipcode());
		soapModel.setContactPerson(model.getContactPerson());
		soapModel.setPhone(model.getPhone());
		soapModel.setFax(model.getFax());
		soapModel.setIsPublisher(model.getIsPublisher());
		soapModel.setIsBinder(model.getIsBinder());
		soapModel.setIsActive(model.getIsActive());
		soapModel.setRating(model.getRating());
		soapModel.setBankName(model.getBankName());
		soapModel.setBankAccount(model.getBankAccount());
		soapModel.setLastOrderDate(model.getLastOrderDate());
		soapModel.setNote(model.getNote());

		return soapModel;
	}

	public static VendorSoap[] toSoapModels(Vendor[] models) {
		VendorSoap[] soapModels = new VendorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VendorSoap[][] toSoapModels(Vendor[][] models) {
		VendorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VendorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VendorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VendorSoap[] toSoapModels(List<Vendor> models) {
		List<VendorSoap> soapModels = new ArrayList<VendorSoap>(models.size());

		for (Vendor model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VendorSoap[soapModels.size()]);
	}

	public VendorSoap() {
	}

	public long getPrimaryKey() {
		return _vendorId;
	}

	public void setPrimaryKey(long pk) {
		setVendorId(pk);
	}

	public long getVendorId() {
		return _vendorId;
	}

	public void setVendorId(long vendorId) {
		_vendorId = vendorId;
	}

	public String getVendorCode() {
		return _vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		_vendorCode = vendorCode;
	}

	public String getVendorName() {
		return _vendorName;
	}

	public void setVendorName(String vendorName) {
		_vendorName = vendorName;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
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

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getZipcode() {
		return _zipcode;
	}

	public void setZipcode(String zipcode) {
		_zipcode = zipcode;
	}

	public String getContactPerson() {
		return _contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		_contactPerson = contactPerson;
	}

	public String getPhone() {
		return _phone;
	}

	public void setPhone(String phone) {
		_phone = phone;
	}

	public String getFax() {
		return _fax;
	}

	public void setFax(String fax) {
		_fax = fax;
	}

	public boolean getIsPublisher() {
		return _isPublisher;
	}

	public boolean isIsPublisher() {
		return _isPublisher;
	}

	public void setIsPublisher(boolean isPublisher) {
		_isPublisher = isPublisher;
	}

	public boolean getIsBinder() {
		return _isBinder;
	}

	public boolean isIsBinder() {
		return _isBinder;
	}

	public void setIsBinder(boolean isBinder) {
		_isBinder = isBinder;
	}

	public boolean getIsActive() {
		return _isActive;
	}

	public boolean isIsActive() {
		return _isActive;
	}

	public void setIsActive(boolean isActive) {
		_isActive = isActive;
	}

	public String getRating() {
		return _rating;
	}

	public void setRating(String rating) {
		_rating = rating;
	}

	public String getBankName() {
		return _bankName;
	}

	public void setBankName(String bankName) {
		_bankName = bankName;
	}

	public String getBankAccount() {
		return _bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		_bankAccount = bankAccount;
	}

	public Date getLastOrderDate() {
		return _lastOrderDate;
	}

	public void setLastOrderDate(Date lastOrderDate) {
		_lastOrderDate = lastOrderDate;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	private long _vendorId;
	private String _vendorCode;
	private String _vendorName;
	private String _email;
	private String _url;
	private long _companyId;
	private long _groupId;
	private String _address1;
	private String _address2;
	private String _address3;
	private String _city;
	private String _zipcode;
	private String _contactPerson;
	private String _phone;
	private String _fax;
	private boolean _isPublisher;
	private boolean _isBinder;
	private boolean _isActive;
	private String _rating;
	private String _bankName;
	private String _bankAccount;
	private Date _lastOrderDate;
	private String _note;
}