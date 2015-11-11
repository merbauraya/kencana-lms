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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Library}.
 * </p>
 *
 * @author Mazlan Mat
 * @see Library
 * @generated
 */
public class LibraryWrapper implements Library, ModelWrapper<Library> {
	public LibraryWrapper(Library library) {
		_library = library;
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

	/**
	* Returns the primary key of this library.
	*
	* @return the primary key of this library
	*/
	@Override
	public long getPrimaryKey() {
		return _library.getPrimaryKey();
	}

	/**
	* Sets the primary key of this library.
	*
	* @param primaryKey the primary key of this library
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_library.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the library ID of this library.
	*
	* @return the library ID of this library
	*/
	@Override
	public long getLibraryId() {
		return _library.getLibraryId();
	}

	/**
	* Sets the library ID of this library.
	*
	* @param libraryId the library ID of this library
	*/
	@Override
	public void setLibraryId(long libraryId) {
		_library.setLibraryId(libraryId);
	}

	/**
	* Returns the library name of this library.
	*
	* @return the library name of this library
	*/
	@Override
	public java.lang.String getLibraryName() {
		return _library.getLibraryName();
	}

	/**
	* Sets the library name of this library.
	*
	* @param libraryName the library name of this library
	*/
	@Override
	public void setLibraryName(java.lang.String libraryName) {
		_library.setLibraryName(libraryName);
	}

	/**
	* Returns the group ID of this library.
	*
	* @return the group ID of this library
	*/
	@Override
	public long getGroupId() {
		return _library.getGroupId();
	}

	/**
	* Sets the group ID of this library.
	*
	* @param groupId the group ID of this library
	*/
	@Override
	public void setGroupId(long groupId) {
		_library.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this library.
	*
	* @return the company ID of this library
	*/
	@Override
	public long getCompanyId() {
		return _library.getCompanyId();
	}

	/**
	* Sets the company ID of this library.
	*
	* @param companyId the company ID of this library
	*/
	@Override
	public void setCompanyId(long companyId) {
		_library.setCompanyId(companyId);
	}

	/**
	* Returns the address1 of this library.
	*
	* @return the address1 of this library
	*/
	@Override
	public java.lang.String getAddress1() {
		return _library.getAddress1();
	}

	/**
	* Sets the address1 of this library.
	*
	* @param address1 the address1 of this library
	*/
	@Override
	public void setAddress1(java.lang.String address1) {
		_library.setAddress1(address1);
	}

	/**
	* Returns the address2 of this library.
	*
	* @return the address2 of this library
	*/
	@Override
	public java.lang.String getAddress2() {
		return _library.getAddress2();
	}

	/**
	* Sets the address2 of this library.
	*
	* @param address2 the address2 of this library
	*/
	@Override
	public void setAddress2(java.lang.String address2) {
		_library.setAddress2(address2);
	}

	/**
	* Returns the address3 of this library.
	*
	* @return the address3 of this library
	*/
	@Override
	public java.lang.String getAddress3() {
		return _library.getAddress3();
	}

	/**
	* Sets the address3 of this library.
	*
	* @param address3 the address3 of this library
	*/
	@Override
	public void setAddress3(java.lang.String address3) {
		_library.setAddress3(address3);
	}

	/**
	* Returns the zipcode of this library.
	*
	* @return the zipcode of this library
	*/
	@Override
	public java.lang.String getZipcode() {
		return _library.getZipcode();
	}

	/**
	* Sets the zipcode of this library.
	*
	* @param zipcode the zipcode of this library
	*/
	@Override
	public void setZipcode(java.lang.String zipcode) {
		_library.setZipcode(zipcode);
	}

	/**
	* Returns the city of this library.
	*
	* @return the city of this library
	*/
	@Override
	public java.lang.String getCity() {
		return _library.getCity();
	}

	/**
	* Sets the city of this library.
	*
	* @param city the city of this library
	*/
	@Override
	public void setCity(java.lang.String city) {
		_library.setCity(city);
	}

	/**
	* Returns the state of this library.
	*
	* @return the state of this library
	*/
	@Override
	public java.lang.String getState() {
		return _library.getState();
	}

	/**
	* Sets the state of this library.
	*
	* @param state the state of this library
	*/
	@Override
	public void setState(java.lang.String state) {
		_library.setState(state);
	}

	/**
	* Returns the country of this library.
	*
	* @return the country of this library
	*/
	@Override
	public java.lang.String getCountry() {
		return _library.getCountry();
	}

	/**
	* Sets the country of this library.
	*
	* @param country the country of this library
	*/
	@Override
	public void setCountry(java.lang.String country) {
		_library.setCountry(country);
	}

	/**
	* Returns the phone of this library.
	*
	* @return the phone of this library
	*/
	@Override
	public java.lang.String getPhone() {
		return _library.getPhone();
	}

	/**
	* Sets the phone of this library.
	*
	* @param phone the phone of this library
	*/
	@Override
	public void setPhone(java.lang.String phone) {
		_library.setPhone(phone);
	}

	/**
	* Returns the email of this library.
	*
	* @return the email of this library
	*/
	@Override
	public java.lang.String getEmail() {
		return _library.getEmail();
	}

	/**
	* Sets the email of this library.
	*
	* @param email the email of this library
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_library.setEmail(email);
	}

	/**
	* Returns the website of this library.
	*
	* @return the website of this library
	*/
	@Override
	public java.lang.String getWebsite() {
		return _library.getWebsite();
	}

	/**
	* Sets the website of this library.
	*
	* @param website the website of this library
	*/
	@Override
	public void setWebsite(java.lang.String website) {
		_library.setWebsite(website);
	}

	/**
	* Returns the notes of this library.
	*
	* @return the notes of this library
	*/
	@Override
	public java.lang.String getNotes() {
		return _library.getNotes();
	}

	/**
	* Sets the notes of this library.
	*
	* @param notes the notes of this library
	*/
	@Override
	public void setNotes(java.lang.String notes) {
		_library.setNotes(notes);
	}

	@Override
	public boolean isNew() {
		return _library.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_library.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _library.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_library.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _library.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _library.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_library.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _library.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_library.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_library.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_library.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LibraryWrapper((Library)_library.clone());
	}

	@Override
	public int compareTo(com.kencana.lms.model.Library library) {
		return _library.compareTo(library);
	}

	@Override
	public int hashCode() {
		return _library.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.kencana.lms.model.Library> toCacheModel() {
		return _library.toCacheModel();
	}

	@Override
	public com.kencana.lms.model.Library toEscapedModel() {
		return new LibraryWrapper(_library.toEscapedModel());
	}

	@Override
	public com.kencana.lms.model.Library toUnescapedModel() {
		return new LibraryWrapper(_library.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _library.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _library.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_library.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LibraryWrapper)) {
			return false;
		}

		LibraryWrapper libraryWrapper = (LibraryWrapper)obj;

		if (Validator.equals(_library, libraryWrapper._library)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Library getWrappedLibrary() {
		return _library;
	}

	@Override
	public Library getWrappedModel() {
		return _library;
	}

	@Override
	public void resetOriginalValues() {
		_library.resetOriginalValues();
	}

	private Library _library;
}