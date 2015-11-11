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

import com.kencana.lms.service.ClpSerializer;
import com.kencana.lms.service.VendorLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mazlan Mat
 */
public class VendorClp extends BaseModelImpl<Vendor> implements Vendor {
	public VendorClp() {
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
	public long getPrimaryKey() {
		return _vendorId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVendorId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _vendorId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getVendorId() {
		return _vendorId;
	}

	@Override
	public void setVendorId(long vendorId) {
		_vendorId = vendorId;

		if (_vendorRemoteModel != null) {
			try {
				Class<?> clazz = _vendorRemoteModel.getClass();

				Method method = clazz.getMethod("setVendorId", long.class);

				method.invoke(_vendorRemoteModel, vendorId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVendorCode() {
		return _vendorCode;
	}

	@Override
	public void setVendorCode(String vendorCode) {
		_vendorCode = vendorCode;

		if (_vendorRemoteModel != null) {
			try {
				Class<?> clazz = _vendorRemoteModel.getClass();

				Method method = clazz.getMethod("setVendorCode", String.class);

				method.invoke(_vendorRemoteModel, vendorCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVendorName() {
		return _vendorName;
	}

	@Override
	public void setVendorName(String vendorName) {
		_vendorName = vendorName;

		if (_vendorRemoteModel != null) {
			try {
				Class<?> clazz = _vendorRemoteModel.getClass();

				Method method = clazz.getMethod("setVendorName", String.class);

				method.invoke(_vendorRemoteModel, vendorName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmail() {
		return _email;
	}

	@Override
	public void setEmail(String email) {
		_email = email;

		if (_vendorRemoteModel != null) {
			try {
				Class<?> clazz = _vendorRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_vendorRemoteModel, email);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUrl() {
		return _url;
	}

	@Override
	public void setUrl(String url) {
		_url = url;

		if (_vendorRemoteModel != null) {
			try {
				Class<?> clazz = _vendorRemoteModel.getClass();

				Method method = clazz.getMethod("setUrl", String.class);

				method.invoke(_vendorRemoteModel, url);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_vendorRemoteModel != null) {
			try {
				Class<?> clazz = _vendorRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_vendorRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_vendorRemoteModel != null) {
			try {
				Class<?> clazz = _vendorRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_vendorRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAddress1() {
		return _address1;
	}

	@Override
	public void setAddress1(String address1) {
		_address1 = address1;

		if (_vendorRemoteModel != null) {
			try {
				Class<?> clazz = _vendorRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress1", String.class);

				method.invoke(_vendorRemoteModel, address1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAddress2() {
		return _address2;
	}

	@Override
	public void setAddress2(String address2) {
		_address2 = address2;

		if (_vendorRemoteModel != null) {
			try {
				Class<?> clazz = _vendorRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress2", String.class);

				method.invoke(_vendorRemoteModel, address2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAddress3() {
		return _address3;
	}

	@Override
	public void setAddress3(String address3) {
		_address3 = address3;

		if (_vendorRemoteModel != null) {
			try {
				Class<?> clazz = _vendorRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress3", String.class);

				method.invoke(_vendorRemoteModel, address3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCity() {
		return _city;
	}

	@Override
	public void setCity(String city) {
		_city = city;

		if (_vendorRemoteModel != null) {
			try {
				Class<?> clazz = _vendorRemoteModel.getClass();

				Method method = clazz.getMethod("setCity", String.class);

				method.invoke(_vendorRemoteModel, city);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZipcode() {
		return _zipcode;
	}

	@Override
	public void setZipcode(String zipcode) {
		_zipcode = zipcode;

		if (_vendorRemoteModel != null) {
			try {
				Class<?> clazz = _vendorRemoteModel.getClass();

				Method method = clazz.getMethod("setZipcode", String.class);

				method.invoke(_vendorRemoteModel, zipcode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContactPerson() {
		return _contactPerson;
	}

	@Override
	public void setContactPerson(String contactPerson) {
		_contactPerson = contactPerson;

		if (_vendorRemoteModel != null) {
			try {
				Class<?> clazz = _vendorRemoteModel.getClass();

				Method method = clazz.getMethod("setContactPerson", String.class);

				method.invoke(_vendorRemoteModel, contactPerson);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPhone() {
		return _phone;
	}

	@Override
	public void setPhone(String phone) {
		_phone = phone;

		if (_vendorRemoteModel != null) {
			try {
				Class<?> clazz = _vendorRemoteModel.getClass();

				Method method = clazz.getMethod("setPhone", String.class);

				method.invoke(_vendorRemoteModel, phone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFax() {
		return _fax;
	}

	@Override
	public void setFax(String fax) {
		_fax = fax;

		if (_vendorRemoteModel != null) {
			try {
				Class<?> clazz = _vendorRemoteModel.getClass();

				Method method = clazz.getMethod("setFax", String.class);

				method.invoke(_vendorRemoteModel, fax);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsPublisher() {
		return _isPublisher;
	}

	@Override
	public boolean isIsPublisher() {
		return _isPublisher;
	}

	@Override
	public void setIsPublisher(boolean isPublisher) {
		_isPublisher = isPublisher;

		if (_vendorRemoteModel != null) {
			try {
				Class<?> clazz = _vendorRemoteModel.getClass();

				Method method = clazz.getMethod("setIsPublisher", boolean.class);

				method.invoke(_vendorRemoteModel, isPublisher);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsBinder() {
		return _isBinder;
	}

	@Override
	public boolean isIsBinder() {
		return _isBinder;
	}

	@Override
	public void setIsBinder(boolean isBinder) {
		_isBinder = isBinder;

		if (_vendorRemoteModel != null) {
			try {
				Class<?> clazz = _vendorRemoteModel.getClass();

				Method method = clazz.getMethod("setIsBinder", boolean.class);

				method.invoke(_vendorRemoteModel, isBinder);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsActive() {
		return _isActive;
	}

	@Override
	public boolean isIsActive() {
		return _isActive;
	}

	@Override
	public void setIsActive(boolean isActive) {
		_isActive = isActive;

		if (_vendorRemoteModel != null) {
			try {
				Class<?> clazz = _vendorRemoteModel.getClass();

				Method method = clazz.getMethod("setIsActive", boolean.class);

				method.invoke(_vendorRemoteModel, isActive);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRating() {
		return _rating;
	}

	@Override
	public void setRating(String rating) {
		_rating = rating;

		if (_vendorRemoteModel != null) {
			try {
				Class<?> clazz = _vendorRemoteModel.getClass();

				Method method = clazz.getMethod("setRating", String.class);

				method.invoke(_vendorRemoteModel, rating);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBankName() {
		return _bankName;
	}

	@Override
	public void setBankName(String bankName) {
		_bankName = bankName;

		if (_vendorRemoteModel != null) {
			try {
				Class<?> clazz = _vendorRemoteModel.getClass();

				Method method = clazz.getMethod("setBankName", String.class);

				method.invoke(_vendorRemoteModel, bankName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBankAccount() {
		return _bankAccount;
	}

	@Override
	public void setBankAccount(String bankAccount) {
		_bankAccount = bankAccount;

		if (_vendorRemoteModel != null) {
			try {
				Class<?> clazz = _vendorRemoteModel.getClass();

				Method method = clazz.getMethod("setBankAccount", String.class);

				method.invoke(_vendorRemoteModel, bankAccount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLastOrderDate() {
		return _lastOrderDate;
	}

	@Override
	public void setLastOrderDate(Date lastOrderDate) {
		_lastOrderDate = lastOrderDate;

		if (_vendorRemoteModel != null) {
			try {
				Class<?> clazz = _vendorRemoteModel.getClass();

				Method method = clazz.getMethod("setLastOrderDate", Date.class);

				method.invoke(_vendorRemoteModel, lastOrderDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNote() {
		return _note;
	}

	@Override
	public void setNote(String note) {
		_note = note;

		if (_vendorRemoteModel != null) {
			try {
				Class<?> clazz = _vendorRemoteModel.getClass();

				Method method = clazz.getMethod("setNote", String.class);

				method.invoke(_vendorRemoteModel, note);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVendorRemoteModel() {
		return _vendorRemoteModel;
	}

	public void setVendorRemoteModel(BaseModel<?> vendorRemoteModel) {
		_vendorRemoteModel = vendorRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _vendorRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_vendorRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VendorLocalServiceUtil.addVendor(this);
		}
		else {
			VendorLocalServiceUtil.updateVendor(this);
		}
	}

	@Override
	public Vendor toEscapedModel() {
		return (Vendor)ProxyUtil.newProxyInstance(Vendor.class.getClassLoader(),
			new Class[] { Vendor.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VendorClp clone = new VendorClp();

		clone.setVendorId(getVendorId());
		clone.setVendorCode(getVendorCode());
		clone.setVendorName(getVendorName());
		clone.setEmail(getEmail());
		clone.setUrl(getUrl());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setAddress1(getAddress1());
		clone.setAddress2(getAddress2());
		clone.setAddress3(getAddress3());
		clone.setCity(getCity());
		clone.setZipcode(getZipcode());
		clone.setContactPerson(getContactPerson());
		clone.setPhone(getPhone());
		clone.setFax(getFax());
		clone.setIsPublisher(getIsPublisher());
		clone.setIsBinder(getIsBinder());
		clone.setIsActive(getIsActive());
		clone.setRating(getRating());
		clone.setBankName(getBankName());
		clone.setBankAccount(getBankAccount());
		clone.setLastOrderDate(getLastOrderDate());
		clone.setNote(getNote());

		return clone;
	}

	@Override
	public int compareTo(Vendor vendor) {
		long primaryKey = vendor.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VendorClp)) {
			return false;
		}

		VendorClp vendor = (VendorClp)obj;

		long primaryKey = vendor.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{vendorId=");
		sb.append(getVendorId());
		sb.append(", vendorCode=");
		sb.append(getVendorCode());
		sb.append(", vendorName=");
		sb.append(getVendorName());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", url=");
		sb.append(getUrl());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", address1=");
		sb.append(getAddress1());
		sb.append(", address2=");
		sb.append(getAddress2());
		sb.append(", address3=");
		sb.append(getAddress3());
		sb.append(", city=");
		sb.append(getCity());
		sb.append(", zipcode=");
		sb.append(getZipcode());
		sb.append(", contactPerson=");
		sb.append(getContactPerson());
		sb.append(", phone=");
		sb.append(getPhone());
		sb.append(", fax=");
		sb.append(getFax());
		sb.append(", isPublisher=");
		sb.append(getIsPublisher());
		sb.append(", isBinder=");
		sb.append(getIsBinder());
		sb.append(", isActive=");
		sb.append(getIsActive());
		sb.append(", rating=");
		sb.append(getRating());
		sb.append(", bankName=");
		sb.append(getBankName());
		sb.append(", bankAccount=");
		sb.append(getBankAccount());
		sb.append(", lastOrderDate=");
		sb.append(getLastOrderDate());
		sb.append(", note=");
		sb.append(getNote());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(73);

		sb.append("<model><model-name>");
		sb.append("com.kencana.lms.model.Vendor");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>vendorId</column-name><column-value><![CDATA[");
		sb.append(getVendorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>vendorCode</column-name><column-value><![CDATA[");
		sb.append(getVendorCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>vendorName</column-name><column-value><![CDATA[");
		sb.append(getVendorName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>url</column-name><column-value><![CDATA[");
		sb.append(getUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address1</column-name><column-value><![CDATA[");
		sb.append(getAddress1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address2</column-name><column-value><![CDATA[");
		sb.append(getAddress2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address3</column-name><column-value><![CDATA[");
		sb.append(getAddress3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>city</column-name><column-value><![CDATA[");
		sb.append(getCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zipcode</column-name><column-value><![CDATA[");
		sb.append(getZipcode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactPerson</column-name><column-value><![CDATA[");
		sb.append(getContactPerson());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phone</column-name><column-value><![CDATA[");
		sb.append(getPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fax</column-name><column-value><![CDATA[");
		sb.append(getFax());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isPublisher</column-name><column-value><![CDATA[");
		sb.append(getIsPublisher());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isBinder</column-name><column-value><![CDATA[");
		sb.append(getIsBinder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isActive</column-name><column-value><![CDATA[");
		sb.append(getIsActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rating</column-name><column-value><![CDATA[");
		sb.append(getRating());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bankName</column-name><column-value><![CDATA[");
		sb.append(getBankName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bankAccount</column-name><column-value><![CDATA[");
		sb.append(getBankAccount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastOrderDate</column-name><column-value><![CDATA[");
		sb.append(getLastOrderDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>note</column-name><column-value><![CDATA[");
		sb.append(getNote());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _vendorRemoteModel;
	private Class<?> _clpSerializerClass = com.kencana.lms.service.ClpSerializer.class;
}