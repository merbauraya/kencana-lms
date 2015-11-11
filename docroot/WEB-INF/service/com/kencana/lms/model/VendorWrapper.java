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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Vendor}.
 * </p>
 *
 * @author Mazlan Mat
 * @see Vendor
 * @generated
 */
public class VendorWrapper implements Vendor, ModelWrapper<Vendor> {
	public VendorWrapper(Vendor vendor) {
		_vendor = vendor;
	}

	@Override
	public Class<?> getModelClass() {
		return Vendor.class;
	}

	@Override
	public String getModelClassName() {
		return Vendor.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("vendorId", getVendorId());
		attributes.put("vendorCode", getVendorCode());
		attributes.put("vendorName", getVendorName());
		attributes.put("email", getEmail());
		attributes.put("url", getUrl());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("address1", getAddress1());
		attributes.put("address2", getAddress2());
		attributes.put("address3", getAddress3());
		attributes.put("city", getCity());
		attributes.put("zipcode", getZipcode());
		attributes.put("contactPerson", getContactPerson());
		attributes.put("phone", getPhone());
		attributes.put("fax", getFax());
		attributes.put("isPublisher", getIsPublisher());
		attributes.put("isBinder", getIsBinder());
		attributes.put("isActive", getIsActive());
		attributes.put("rating", getRating());
		attributes.put("bankName", getBankName());
		attributes.put("bankAccount", getBankAccount());
		attributes.put("lastOrderDate", getLastOrderDate());
		attributes.put("note", getNote());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long vendorId = (Long)attributes.get("vendorId");

		if (vendorId != null) {
			setVendorId(vendorId);
		}

		String vendorCode = (String)attributes.get("vendorCode");

		if (vendorCode != null) {
			setVendorCode(vendorCode);
		}

		String vendorName = (String)attributes.get("vendorName");

		if (vendorName != null) {
			setVendorName(vendorName);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String address1 = (String)attributes.get("address1");

		if (address1 != null) {
			setAddress1(address1);
		}

		String address2 = (String)attributes.get("address2");

		if (address2 != null) {
			setAddress2(address2);
		}

		String address3 = (String)attributes.get("address3");

		if (address3 != null) {
			setAddress3(address3);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String zipcode = (String)attributes.get("zipcode");

		if (zipcode != null) {
			setZipcode(zipcode);
		}

		String contactPerson = (String)attributes.get("contactPerson");

		if (contactPerson != null) {
			setContactPerson(contactPerson);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String fax = (String)attributes.get("fax");

		if (fax != null) {
			setFax(fax);
		}

		Boolean isPublisher = (Boolean)attributes.get("isPublisher");

		if (isPublisher != null) {
			setIsPublisher(isPublisher);
		}

		Boolean isBinder = (Boolean)attributes.get("isBinder");

		if (isBinder != null) {
			setIsBinder(isBinder);
		}

		Boolean isActive = (Boolean)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
		}

		String rating = (String)attributes.get("rating");

		if (rating != null) {
			setRating(rating);
		}

		String bankName = (String)attributes.get("bankName");

		if (bankName != null) {
			setBankName(bankName);
		}

		String bankAccount = (String)attributes.get("bankAccount");

		if (bankAccount != null) {
			setBankAccount(bankAccount);
		}

		Date lastOrderDate = (Date)attributes.get("lastOrderDate");

		if (lastOrderDate != null) {
			setLastOrderDate(lastOrderDate);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}
	}

	/**
	* Returns the primary key of this vendor.
	*
	* @return the primary key of this vendor
	*/
	@Override
	public long getPrimaryKey() {
		return _vendor.getPrimaryKey();
	}

	/**
	* Sets the primary key of this vendor.
	*
	* @param primaryKey the primary key of this vendor
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_vendor.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the vendor ID of this vendor.
	*
	* @return the vendor ID of this vendor
	*/
	@Override
	public long getVendorId() {
		return _vendor.getVendorId();
	}

	/**
	* Sets the vendor ID of this vendor.
	*
	* @param vendorId the vendor ID of this vendor
	*/
	@Override
	public void setVendorId(long vendorId) {
		_vendor.setVendorId(vendorId);
	}

	/**
	* Returns the vendor code of this vendor.
	*
	* @return the vendor code of this vendor
	*/
	@Override
	public java.lang.String getVendorCode() {
		return _vendor.getVendorCode();
	}

	/**
	* Sets the vendor code of this vendor.
	*
	* @param vendorCode the vendor code of this vendor
	*/
	@Override
	public void setVendorCode(java.lang.String vendorCode) {
		_vendor.setVendorCode(vendorCode);
	}

	/**
	* Returns the vendor name of this vendor.
	*
	* @return the vendor name of this vendor
	*/
	@Override
	public java.lang.String getVendorName() {
		return _vendor.getVendorName();
	}

	/**
	* Sets the vendor name of this vendor.
	*
	* @param vendorName the vendor name of this vendor
	*/
	@Override
	public void setVendorName(java.lang.String vendorName) {
		_vendor.setVendorName(vendorName);
	}

	/**
	* Returns the email of this vendor.
	*
	* @return the email of this vendor
	*/
	@Override
	public java.lang.String getEmail() {
		return _vendor.getEmail();
	}

	/**
	* Sets the email of this vendor.
	*
	* @param email the email of this vendor
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_vendor.setEmail(email);
	}

	/**
	* Returns the url of this vendor.
	*
	* @return the url of this vendor
	*/
	@Override
	public java.lang.String getUrl() {
		return _vendor.getUrl();
	}

	/**
	* Sets the url of this vendor.
	*
	* @param url the url of this vendor
	*/
	@Override
	public void setUrl(java.lang.String url) {
		_vendor.setUrl(url);
	}

	/**
	* Returns the company ID of this vendor.
	*
	* @return the company ID of this vendor
	*/
	@Override
	public long getCompanyId() {
		return _vendor.getCompanyId();
	}

	/**
	* Sets the company ID of this vendor.
	*
	* @param companyId the company ID of this vendor
	*/
	@Override
	public void setCompanyId(long companyId) {
		_vendor.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this vendor.
	*
	* @return the group ID of this vendor
	*/
	@Override
	public long getGroupId() {
		return _vendor.getGroupId();
	}

	/**
	* Sets the group ID of this vendor.
	*
	* @param groupId the group ID of this vendor
	*/
	@Override
	public void setGroupId(long groupId) {
		_vendor.setGroupId(groupId);
	}

	/**
	* Returns the address1 of this vendor.
	*
	* @return the address1 of this vendor
	*/
	@Override
	public java.lang.String getAddress1() {
		return _vendor.getAddress1();
	}

	/**
	* Sets the address1 of this vendor.
	*
	* @param address1 the address1 of this vendor
	*/
	@Override
	public void setAddress1(java.lang.String address1) {
		_vendor.setAddress1(address1);
	}

	/**
	* Returns the address2 of this vendor.
	*
	* @return the address2 of this vendor
	*/
	@Override
	public java.lang.String getAddress2() {
		return _vendor.getAddress2();
	}

	/**
	* Sets the address2 of this vendor.
	*
	* @param address2 the address2 of this vendor
	*/
	@Override
	public void setAddress2(java.lang.String address2) {
		_vendor.setAddress2(address2);
	}

	/**
	* Returns the address3 of this vendor.
	*
	* @return the address3 of this vendor
	*/
	@Override
	public java.lang.String getAddress3() {
		return _vendor.getAddress3();
	}

	/**
	* Sets the address3 of this vendor.
	*
	* @param address3 the address3 of this vendor
	*/
	@Override
	public void setAddress3(java.lang.String address3) {
		_vendor.setAddress3(address3);
	}

	/**
	* Returns the city of this vendor.
	*
	* @return the city of this vendor
	*/
	@Override
	public java.lang.String getCity() {
		return _vendor.getCity();
	}

	/**
	* Sets the city of this vendor.
	*
	* @param city the city of this vendor
	*/
	@Override
	public void setCity(java.lang.String city) {
		_vendor.setCity(city);
	}

	/**
	* Returns the zipcode of this vendor.
	*
	* @return the zipcode of this vendor
	*/
	@Override
	public java.lang.String getZipcode() {
		return _vendor.getZipcode();
	}

	/**
	* Sets the zipcode of this vendor.
	*
	* @param zipcode the zipcode of this vendor
	*/
	@Override
	public void setZipcode(java.lang.String zipcode) {
		_vendor.setZipcode(zipcode);
	}

	/**
	* Returns the contact person of this vendor.
	*
	* @return the contact person of this vendor
	*/
	@Override
	public java.lang.String getContactPerson() {
		return _vendor.getContactPerson();
	}

	/**
	* Sets the contact person of this vendor.
	*
	* @param contactPerson the contact person of this vendor
	*/
	@Override
	public void setContactPerson(java.lang.String contactPerson) {
		_vendor.setContactPerson(contactPerson);
	}

	/**
	* Returns the phone of this vendor.
	*
	* @return the phone of this vendor
	*/
	@Override
	public java.lang.String getPhone() {
		return _vendor.getPhone();
	}

	/**
	* Sets the phone of this vendor.
	*
	* @param phone the phone of this vendor
	*/
	@Override
	public void setPhone(java.lang.String phone) {
		_vendor.setPhone(phone);
	}

	/**
	* Returns the fax of this vendor.
	*
	* @return the fax of this vendor
	*/
	@Override
	public java.lang.String getFax() {
		return _vendor.getFax();
	}

	/**
	* Sets the fax of this vendor.
	*
	* @param fax the fax of this vendor
	*/
	@Override
	public void setFax(java.lang.String fax) {
		_vendor.setFax(fax);
	}

	/**
	* Returns the is publisher of this vendor.
	*
	* @return the is publisher of this vendor
	*/
	@Override
	public boolean getIsPublisher() {
		return _vendor.getIsPublisher();
	}

	/**
	* Returns <code>true</code> if this vendor is is publisher.
	*
	* @return <code>true</code> if this vendor is is publisher; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsPublisher() {
		return _vendor.isIsPublisher();
	}

	/**
	* Sets whether this vendor is is publisher.
	*
	* @param isPublisher the is publisher of this vendor
	*/
	@Override
	public void setIsPublisher(boolean isPublisher) {
		_vendor.setIsPublisher(isPublisher);
	}

	/**
	* Returns the is binder of this vendor.
	*
	* @return the is binder of this vendor
	*/
	@Override
	public boolean getIsBinder() {
		return _vendor.getIsBinder();
	}

	/**
	* Returns <code>true</code> if this vendor is is binder.
	*
	* @return <code>true</code> if this vendor is is binder; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsBinder() {
		return _vendor.isIsBinder();
	}

	/**
	* Sets whether this vendor is is binder.
	*
	* @param isBinder the is binder of this vendor
	*/
	@Override
	public void setIsBinder(boolean isBinder) {
		_vendor.setIsBinder(isBinder);
	}

	/**
	* Returns the is active of this vendor.
	*
	* @return the is active of this vendor
	*/
	@Override
	public boolean getIsActive() {
		return _vendor.getIsActive();
	}

	/**
	* Returns <code>true</code> if this vendor is is active.
	*
	* @return <code>true</code> if this vendor is is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsActive() {
		return _vendor.isIsActive();
	}

	/**
	* Sets whether this vendor is is active.
	*
	* @param isActive the is active of this vendor
	*/
	@Override
	public void setIsActive(boolean isActive) {
		_vendor.setIsActive(isActive);
	}

	/**
	* Returns the rating of this vendor.
	*
	* @return the rating of this vendor
	*/
	@Override
	public java.lang.String getRating() {
		return _vendor.getRating();
	}

	/**
	* Sets the rating of this vendor.
	*
	* @param rating the rating of this vendor
	*/
	@Override
	public void setRating(java.lang.String rating) {
		_vendor.setRating(rating);
	}

	/**
	* Returns the bank name of this vendor.
	*
	* @return the bank name of this vendor
	*/
	@Override
	public java.lang.String getBankName() {
		return _vendor.getBankName();
	}

	/**
	* Sets the bank name of this vendor.
	*
	* @param bankName the bank name of this vendor
	*/
	@Override
	public void setBankName(java.lang.String bankName) {
		_vendor.setBankName(bankName);
	}

	/**
	* Returns the bank account of this vendor.
	*
	* @return the bank account of this vendor
	*/
	@Override
	public java.lang.String getBankAccount() {
		return _vendor.getBankAccount();
	}

	/**
	* Sets the bank account of this vendor.
	*
	* @param bankAccount the bank account of this vendor
	*/
	@Override
	public void setBankAccount(java.lang.String bankAccount) {
		_vendor.setBankAccount(bankAccount);
	}

	/**
	* Returns the last order date of this vendor.
	*
	* @return the last order date of this vendor
	*/
	@Override
	public java.util.Date getLastOrderDate() {
		return _vendor.getLastOrderDate();
	}

	/**
	* Sets the last order date of this vendor.
	*
	* @param lastOrderDate the last order date of this vendor
	*/
	@Override
	public void setLastOrderDate(java.util.Date lastOrderDate) {
		_vendor.setLastOrderDate(lastOrderDate);
	}

	/**
	* Returns the note of this vendor.
	*
	* @return the note of this vendor
	*/
	@Override
	public java.lang.String getNote() {
		return _vendor.getNote();
	}

	/**
	* Sets the note of this vendor.
	*
	* @param note the note of this vendor
	*/
	@Override
	public void setNote(java.lang.String note) {
		_vendor.setNote(note);
	}

	@Override
	public boolean isNew() {
		return _vendor.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_vendor.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _vendor.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_vendor.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _vendor.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _vendor.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vendor.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vendor.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_vendor.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_vendor.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vendor.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VendorWrapper((Vendor)_vendor.clone());
	}

	@Override
	public int compareTo(com.kencana.lms.model.Vendor vendor) {
		return _vendor.compareTo(vendor);
	}

	@Override
	public int hashCode() {
		return _vendor.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.kencana.lms.model.Vendor> toCacheModel() {
		return _vendor.toCacheModel();
	}

	@Override
	public com.kencana.lms.model.Vendor toEscapedModel() {
		return new VendorWrapper(_vendor.toEscapedModel());
	}

	@Override
	public com.kencana.lms.model.Vendor toUnescapedModel() {
		return new VendorWrapper(_vendor.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vendor.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _vendor.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vendor.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VendorWrapper)) {
			return false;
		}

		VendorWrapper vendorWrapper = (VendorWrapper)obj;

		if (Validator.equals(_vendor, vendorWrapper._vendor)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Vendor getWrappedVendor() {
		return _vendor;
	}

	@Override
	public Vendor getWrappedModel() {
		return _vendor;
	}

	@Override
	public void resetOriginalValues() {
		_vendor.resetOriginalValues();
	}

	private Vendor _vendor;
}