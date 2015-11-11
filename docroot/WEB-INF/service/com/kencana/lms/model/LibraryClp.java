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
import com.kencana.lms.service.LibraryLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mazlan Mat
 */
public class LibraryClp extends BaseModelImpl<Library> implements Library {
	public LibraryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Library.class;
	}

	@Override
	public String getModelClassName() {
		return Library.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _libraryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLibraryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _libraryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("libraryId", getLibraryId());
		attributes.put("libraryName", getLibraryName());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("address1", getAddress1());
		attributes.put("address2", getAddress2());
		attributes.put("address3", getAddress3());
		attributes.put("zipcode", getZipcode());
		attributes.put("city", getCity());
		attributes.put("state", getState());
		attributes.put("country", getCountry());
		attributes.put("phone", getPhone());
		attributes.put("email", getEmail());
		attributes.put("website", getWebsite());
		attributes.put("notes", getNotes());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		String libraryName = (String)attributes.get("libraryName");

		if (libraryName != null) {
			setLibraryName(libraryName);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		String zipcode = (String)attributes.get("zipcode");

		if (zipcode != null) {
			setZipcode(zipcode);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String website = (String)attributes.get("website");

		if (website != null) {
			setWebsite(website);
		}

		String notes = (String)attributes.get("notes");

		if (notes != null) {
			setNotes(notes);
		}
	}

	@Override
	public long getLibraryId() {
		return _libraryId;
	}

	@Override
	public void setLibraryId(long libraryId) {
		_libraryId = libraryId;

		if (_libraryRemoteModel != null) {
			try {
				Class<?> clazz = _libraryRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryId", long.class);

				method.invoke(_libraryRemoteModel, libraryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLibraryName() {
		return _libraryName;
	}

	@Override
	public void setLibraryName(String libraryName) {
		_libraryName = libraryName;

		if (_libraryRemoteModel != null) {
			try {
				Class<?> clazz = _libraryRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryName", String.class);

				method.invoke(_libraryRemoteModel, libraryName);
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

		if (_libraryRemoteModel != null) {
			try {
				Class<?> clazz = _libraryRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_libraryRemoteModel, groupId);
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

		if (_libraryRemoteModel != null) {
			try {
				Class<?> clazz = _libraryRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_libraryRemoteModel, companyId);
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

		if (_libraryRemoteModel != null) {
			try {
				Class<?> clazz = _libraryRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress1", String.class);

				method.invoke(_libraryRemoteModel, address1);
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

		if (_libraryRemoteModel != null) {
			try {
				Class<?> clazz = _libraryRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress2", String.class);

				method.invoke(_libraryRemoteModel, address2);
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

		if (_libraryRemoteModel != null) {
			try {
				Class<?> clazz = _libraryRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress3", String.class);

				method.invoke(_libraryRemoteModel, address3);
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

		if (_libraryRemoteModel != null) {
			try {
				Class<?> clazz = _libraryRemoteModel.getClass();

				Method method = clazz.getMethod("setZipcode", String.class);

				method.invoke(_libraryRemoteModel, zipcode);
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

		if (_libraryRemoteModel != null) {
			try {
				Class<?> clazz = _libraryRemoteModel.getClass();

				Method method = clazz.getMethod("setCity", String.class);

				method.invoke(_libraryRemoteModel, city);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getState() {
		return _state;
	}

	@Override
	public void setState(String state) {
		_state = state;

		if (_libraryRemoteModel != null) {
			try {
				Class<?> clazz = _libraryRemoteModel.getClass();

				Method method = clazz.getMethod("setState", String.class);

				method.invoke(_libraryRemoteModel, state);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCountry() {
		return _country;
	}

	@Override
	public void setCountry(String country) {
		_country = country;

		if (_libraryRemoteModel != null) {
			try {
				Class<?> clazz = _libraryRemoteModel.getClass();

				Method method = clazz.getMethod("setCountry", String.class);

				method.invoke(_libraryRemoteModel, country);
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

		if (_libraryRemoteModel != null) {
			try {
				Class<?> clazz = _libraryRemoteModel.getClass();

				Method method = clazz.getMethod("setPhone", String.class);

				method.invoke(_libraryRemoteModel, phone);
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

		if (_libraryRemoteModel != null) {
			try {
				Class<?> clazz = _libraryRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_libraryRemoteModel, email);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWebsite() {
		return _website;
	}

	@Override
	public void setWebsite(String website) {
		_website = website;

		if (_libraryRemoteModel != null) {
			try {
				Class<?> clazz = _libraryRemoteModel.getClass();

				Method method = clazz.getMethod("setWebsite", String.class);

				method.invoke(_libraryRemoteModel, website);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNotes() {
		return _notes;
	}

	@Override
	public void setNotes(String notes) {
		_notes = notes;

		if (_libraryRemoteModel != null) {
			try {
				Class<?> clazz = _libraryRemoteModel.getClass();

				Method method = clazz.getMethod("setNotes", String.class);

				method.invoke(_libraryRemoteModel, notes);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLibraryRemoteModel() {
		return _libraryRemoteModel;
	}

	public void setLibraryRemoteModel(BaseModel<?> libraryRemoteModel) {
		_libraryRemoteModel = libraryRemoteModel;
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

		Class<?> remoteModelClass = _libraryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_libraryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LibraryLocalServiceUtil.addLibrary(this);
		}
		else {
			LibraryLocalServiceUtil.updateLibrary(this);
		}
	}

	@Override
	public Library toEscapedModel() {
		return (Library)ProxyUtil.newProxyInstance(Library.class.getClassLoader(),
			new Class[] { Library.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LibraryClp clone = new LibraryClp();

		clone.setLibraryId(getLibraryId());
		clone.setLibraryName(getLibraryName());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setAddress1(getAddress1());
		clone.setAddress2(getAddress2());
		clone.setAddress3(getAddress3());
		clone.setZipcode(getZipcode());
		clone.setCity(getCity());
		clone.setState(getState());
		clone.setCountry(getCountry());
		clone.setPhone(getPhone());
		clone.setEmail(getEmail());
		clone.setWebsite(getWebsite());
		clone.setNotes(getNotes());

		return clone;
	}

	@Override
	public int compareTo(Library library) {
		long primaryKey = library.getPrimaryKey();

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

		if (!(obj instanceof LibraryClp)) {
			return false;
		}

		LibraryClp library = (LibraryClp)obj;

		long primaryKey = library.getPrimaryKey();

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
		StringBundler sb = new StringBundler(31);

		sb.append("{libraryId=");
		sb.append(getLibraryId());
		sb.append(", libraryName=");
		sb.append(getLibraryName());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", address1=");
		sb.append(getAddress1());
		sb.append(", address2=");
		sb.append(getAddress2());
		sb.append(", address3=");
		sb.append(getAddress3());
		sb.append(", zipcode=");
		sb.append(getZipcode());
		sb.append(", city=");
		sb.append(getCity());
		sb.append(", state=");
		sb.append(getState());
		sb.append(", country=");
		sb.append(getCountry());
		sb.append(", phone=");
		sb.append(getPhone());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", website=");
		sb.append(getWebsite());
		sb.append(", notes=");
		sb.append(getNotes());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("com.kencana.lms.model.Library");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>libraryId</column-name><column-value><![CDATA[");
		sb.append(getLibraryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>libraryName</column-name><column-value><![CDATA[");
		sb.append(getLibraryName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
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
			"<column><column-name>zipcode</column-name><column-value><![CDATA[");
		sb.append(getZipcode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>city</column-name><column-value><![CDATA[");
		sb.append(getCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>state</column-name><column-value><![CDATA[");
		sb.append(getState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>country</column-name><column-value><![CDATA[");
		sb.append(getCountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phone</column-name><column-value><![CDATA[");
		sb.append(getPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>website</column-name><column-value><![CDATA[");
		sb.append(getWebsite());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>notes</column-name><column-value><![CDATA[");
		sb.append(getNotes());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _libraryRemoteModel;
	private Class<?> _clpSerializerClass = com.kencana.lms.service.ClpSerializer.class;
}