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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Vendor service. Represents a row in the &quot;Kencana_Vendor&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.kencana.lms.model.impl.VendorModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.kencana.lms.model.impl.VendorImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see Vendor
 * @see com.kencana.lms.model.impl.VendorImpl
 * @see com.kencana.lms.model.impl.VendorModelImpl
 * @generated
 */
public interface VendorModel extends BaseModel<Vendor> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a vendor model instance should use the {@link Vendor} interface instead.
	 */

	/**
	 * Returns the primary key of this vendor.
	 *
	 * @return the primary key of this vendor
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this vendor.
	 *
	 * @param primaryKey the primary key of this vendor
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the vendor ID of this vendor.
	 *
	 * @return the vendor ID of this vendor
	 */
	public long getVendorId();

	/**
	 * Sets the vendor ID of this vendor.
	 *
	 * @param vendorId the vendor ID of this vendor
	 */
	public void setVendorId(long vendorId);

	/**
	 * Returns the vendor code of this vendor.
	 *
	 * @return the vendor code of this vendor
	 */
	@AutoEscape
	public String getVendorCode();

	/**
	 * Sets the vendor code of this vendor.
	 *
	 * @param vendorCode the vendor code of this vendor
	 */
	public void setVendorCode(String vendorCode);

	/**
	 * Returns the vendor name of this vendor.
	 *
	 * @return the vendor name of this vendor
	 */
	@AutoEscape
	public String getVendorName();

	/**
	 * Sets the vendor name of this vendor.
	 *
	 * @param vendorName the vendor name of this vendor
	 */
	public void setVendorName(String vendorName);

	/**
	 * Returns the email of this vendor.
	 *
	 * @return the email of this vendor
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this vendor.
	 *
	 * @param email the email of this vendor
	 */
	public void setEmail(String email);

	/**
	 * Returns the url of this vendor.
	 *
	 * @return the url of this vendor
	 */
	@AutoEscape
	public String getUrl();

	/**
	 * Sets the url of this vendor.
	 *
	 * @param url the url of this vendor
	 */
	public void setUrl(String url);

	/**
	 * Returns the company ID of this vendor.
	 *
	 * @return the company ID of this vendor
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this vendor.
	 *
	 * @param companyId the company ID of this vendor
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this vendor.
	 *
	 * @return the group ID of this vendor
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this vendor.
	 *
	 * @param groupId the group ID of this vendor
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the address1 of this vendor.
	 *
	 * @return the address1 of this vendor
	 */
	@AutoEscape
	public String getAddress1();

	/**
	 * Sets the address1 of this vendor.
	 *
	 * @param address1 the address1 of this vendor
	 */
	public void setAddress1(String address1);

	/**
	 * Returns the address2 of this vendor.
	 *
	 * @return the address2 of this vendor
	 */
	@AutoEscape
	public String getAddress2();

	/**
	 * Sets the address2 of this vendor.
	 *
	 * @param address2 the address2 of this vendor
	 */
	public void setAddress2(String address2);

	/**
	 * Returns the address3 of this vendor.
	 *
	 * @return the address3 of this vendor
	 */
	@AutoEscape
	public String getAddress3();

	/**
	 * Sets the address3 of this vendor.
	 *
	 * @param address3 the address3 of this vendor
	 */
	public void setAddress3(String address3);

	/**
	 * Returns the city of this vendor.
	 *
	 * @return the city of this vendor
	 */
	@AutoEscape
	public String getCity();

	/**
	 * Sets the city of this vendor.
	 *
	 * @param city the city of this vendor
	 */
	public void setCity(String city);

	/**
	 * Returns the zipcode of this vendor.
	 *
	 * @return the zipcode of this vendor
	 */
	@AutoEscape
	public String getZipcode();

	/**
	 * Sets the zipcode of this vendor.
	 *
	 * @param zipcode the zipcode of this vendor
	 */
	public void setZipcode(String zipcode);

	/**
	 * Returns the contact person of this vendor.
	 *
	 * @return the contact person of this vendor
	 */
	@AutoEscape
	public String getContactPerson();

	/**
	 * Sets the contact person of this vendor.
	 *
	 * @param contactPerson the contact person of this vendor
	 */
	public void setContactPerson(String contactPerson);

	/**
	 * Returns the phone of this vendor.
	 *
	 * @return the phone of this vendor
	 */
	@AutoEscape
	public String getPhone();

	/**
	 * Sets the phone of this vendor.
	 *
	 * @param phone the phone of this vendor
	 */
	public void setPhone(String phone);

	/**
	 * Returns the fax of this vendor.
	 *
	 * @return the fax of this vendor
	 */
	@AutoEscape
	public String getFax();

	/**
	 * Sets the fax of this vendor.
	 *
	 * @param fax the fax of this vendor
	 */
	public void setFax(String fax);

	/**
	 * Returns the is publisher of this vendor.
	 *
	 * @return the is publisher of this vendor
	 */
	public boolean getIsPublisher();

	/**
	 * Returns <code>true</code> if this vendor is is publisher.
	 *
	 * @return <code>true</code> if this vendor is is publisher; <code>false</code> otherwise
	 */
	public boolean isIsPublisher();

	/**
	 * Sets whether this vendor is is publisher.
	 *
	 * @param isPublisher the is publisher of this vendor
	 */
	public void setIsPublisher(boolean isPublisher);

	/**
	 * Returns the is binder of this vendor.
	 *
	 * @return the is binder of this vendor
	 */
	public boolean getIsBinder();

	/**
	 * Returns <code>true</code> if this vendor is is binder.
	 *
	 * @return <code>true</code> if this vendor is is binder; <code>false</code> otherwise
	 */
	public boolean isIsBinder();

	/**
	 * Sets whether this vendor is is binder.
	 *
	 * @param isBinder the is binder of this vendor
	 */
	public void setIsBinder(boolean isBinder);

	/**
	 * Returns the is active of this vendor.
	 *
	 * @return the is active of this vendor
	 */
	public boolean getIsActive();

	/**
	 * Returns <code>true</code> if this vendor is is active.
	 *
	 * @return <code>true</code> if this vendor is is active; <code>false</code> otherwise
	 */
	public boolean isIsActive();

	/**
	 * Sets whether this vendor is is active.
	 *
	 * @param isActive the is active of this vendor
	 */
	public void setIsActive(boolean isActive);

	/**
	 * Returns the rating of this vendor.
	 *
	 * @return the rating of this vendor
	 */
	@AutoEscape
	public String getRating();

	/**
	 * Sets the rating of this vendor.
	 *
	 * @param rating the rating of this vendor
	 */
	public void setRating(String rating);

	/**
	 * Returns the bank name of this vendor.
	 *
	 * @return the bank name of this vendor
	 */
	@AutoEscape
	public String getBankName();

	/**
	 * Sets the bank name of this vendor.
	 *
	 * @param bankName the bank name of this vendor
	 */
	public void setBankName(String bankName);

	/**
	 * Returns the bank account of this vendor.
	 *
	 * @return the bank account of this vendor
	 */
	@AutoEscape
	public String getBankAccount();

	/**
	 * Sets the bank account of this vendor.
	 *
	 * @param bankAccount the bank account of this vendor
	 */
	public void setBankAccount(String bankAccount);

	/**
	 * Returns the last order date of this vendor.
	 *
	 * @return the last order date of this vendor
	 */
	public Date getLastOrderDate();

	/**
	 * Sets the last order date of this vendor.
	 *
	 * @param lastOrderDate the last order date of this vendor
	 */
	public void setLastOrderDate(Date lastOrderDate);

	/**
	 * Returns the note of this vendor.
	 *
	 * @return the note of this vendor
	 */
	@AutoEscape
	public String getNote();

	/**
	 * Sets the note of this vendor.
	 *
	 * @param note the note of this vendor
	 */
	public void setNote(String note);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(com.kencana.lms.model.Vendor vendor);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.kencana.lms.model.Vendor> toCacheModel();

	@Override
	public com.kencana.lms.model.Vendor toEscapedModel();

	@Override
	public com.kencana.lms.model.Vendor toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}