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
import com.kencana.lms.model.LibraryModel;
import com.kencana.lms.model.LibrarySoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Library service. Represents a row in the &quot;Kencana_Library&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.kencana.lms.model.LibraryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LibraryImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see LibraryImpl
 * @see com.kencana.lms.model.Library
 * @see com.kencana.lms.model.LibraryModel
 * @generated
 */
@JSON(strict = true)
public class LibraryModelImpl extends BaseModelImpl<Library>
	implements LibraryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a library model instance should use the {@link com.kencana.lms.model.Library} interface instead.
	 */
	public static final String TABLE_NAME = "Kencana_Library";
	public static final Object[][] TABLE_COLUMNS = {
			{ "libraryId", Types.BIGINT },
			{ "libraryName", Types.VARCHAR },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "address1", Types.VARCHAR },
			{ "address2", Types.VARCHAR },
			{ "address3", Types.VARCHAR },
			{ "zipcode", Types.VARCHAR },
			{ "city", Types.VARCHAR },
			{ "state_", Types.VARCHAR },
			{ "country", Types.VARCHAR },
			{ "phone", Types.VARCHAR },
			{ "email", Types.VARCHAR },
			{ "website", Types.VARCHAR },
			{ "notes", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table Kencana_Library (libraryId LONG not null primary key,libraryName VARCHAR(75) null,groupId LONG,companyId LONG,address1 VARCHAR(75) null,address2 VARCHAR(75) null,address3 VARCHAR(75) null,zipcode VARCHAR(75) null,city VARCHAR(75) null,state_ VARCHAR(75) null,country VARCHAR(75) null,phone VARCHAR(75) null,email VARCHAR(75) null,website STRING null,notes TEXT null)";
	public static final String TABLE_SQL_DROP = "drop table Kencana_Library";
	public static final String ORDER_BY_JPQL = " ORDER BY library.libraryId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Kencana_Library.libraryId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.kencana.lms.model.Library"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.kencana.lms.model.Library"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.kencana.lms.model.Library"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long LIBRARYID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Library toModel(LibrarySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Library model = new LibraryImpl();

		model.setLibraryId(soapModel.getLibraryId());
		model.setLibraryName(soapModel.getLibraryName());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setAddress1(soapModel.getAddress1());
		model.setAddress2(soapModel.getAddress2());
		model.setAddress3(soapModel.getAddress3());
		model.setZipcode(soapModel.getZipcode());
		model.setCity(soapModel.getCity());
		model.setState(soapModel.getState());
		model.setCountry(soapModel.getCountry());
		model.setPhone(soapModel.getPhone());
		model.setEmail(soapModel.getEmail());
		model.setWebsite(soapModel.getWebsite());
		model.setNotes(soapModel.getNotes());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Library> toModels(LibrarySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Library> models = new ArrayList<Library>(soapModels.length);

		for (LibrarySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.kencana.lms.model.Library"));

	public LibraryModelImpl() {
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

	@JSON
	@Override
	public long getLibraryId() {
		return _libraryId;
	}

	@Override
	public void setLibraryId(long libraryId) {
		_libraryId = libraryId;
	}

	@JSON
	@Override
	public String getLibraryName() {
		if (_libraryName == null) {
			return StringPool.BLANK;
		}
		else {
			return _libraryName;
		}
	}

	@Override
	public void setLibraryName(String libraryName) {
		_libraryName = libraryName;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public String getAddress1() {
		if (_address1 == null) {
			return StringPool.BLANK;
		}
		else {
			return _address1;
		}
	}

	@Override
	public void setAddress1(String address1) {
		_address1 = address1;
	}

	@JSON
	@Override
	public String getAddress2() {
		if (_address2 == null) {
			return StringPool.BLANK;
		}
		else {
			return _address2;
		}
	}

	@Override
	public void setAddress2(String address2) {
		_address2 = address2;
	}

	@JSON
	@Override
	public String getAddress3() {
		if (_address3 == null) {
			return StringPool.BLANK;
		}
		else {
			return _address3;
		}
	}

	@Override
	public void setAddress3(String address3) {
		_address3 = address3;
	}

	@JSON
	@Override
	public String getZipcode() {
		if (_zipcode == null) {
			return StringPool.BLANK;
		}
		else {
			return _zipcode;
		}
	}

	@Override
	public void setZipcode(String zipcode) {
		_zipcode = zipcode;
	}

	@JSON
	@Override
	public String getCity() {
		if (_city == null) {
			return StringPool.BLANK;
		}
		else {
			return _city;
		}
	}

	@Override
	public void setCity(String city) {
		_city = city;
	}

	@JSON
	@Override
	public String getState() {
		if (_state == null) {
			return StringPool.BLANK;
		}
		else {
			return _state;
		}
	}

	@Override
	public void setState(String state) {
		_state = state;
	}

	@JSON
	@Override
	public String getCountry() {
		if (_country == null) {
			return StringPool.BLANK;
		}
		else {
			return _country;
		}
	}

	@Override
	public void setCountry(String country) {
		_country = country;
	}

	@JSON
	@Override
	public String getPhone() {
		if (_phone == null) {
			return StringPool.BLANK;
		}
		else {
			return _phone;
		}
	}

	@Override
	public void setPhone(String phone) {
		_phone = phone;
	}

	@JSON
	@Override
	public String getEmail() {
		if (_email == null) {
			return StringPool.BLANK;
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		_email = email;
	}

	@JSON
	@Override
	public String getWebsite() {
		if (_website == null) {
			return StringPool.BLANK;
		}
		else {
			return _website;
		}
	}

	@Override
	public void setWebsite(String website) {
		_website = website;
	}

	@JSON
	@Override
	public String getNotes() {
		if (_notes == null) {
			return StringPool.BLANK;
		}
		else {
			return _notes;
		}
	}

	@Override
	public void setNotes(String notes) {
		_notes = notes;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Library.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Library toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Library)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		LibraryImpl libraryImpl = new LibraryImpl();

		libraryImpl.setLibraryId(getLibraryId());
		libraryImpl.setLibraryName(getLibraryName());
		libraryImpl.setGroupId(getGroupId());
		libraryImpl.setCompanyId(getCompanyId());
		libraryImpl.setAddress1(getAddress1());
		libraryImpl.setAddress2(getAddress2());
		libraryImpl.setAddress3(getAddress3());
		libraryImpl.setZipcode(getZipcode());
		libraryImpl.setCity(getCity());
		libraryImpl.setState(getState());
		libraryImpl.setCountry(getCountry());
		libraryImpl.setPhone(getPhone());
		libraryImpl.setEmail(getEmail());
		libraryImpl.setWebsite(getWebsite());
		libraryImpl.setNotes(getNotes());

		libraryImpl.resetOriginalValues();

		return libraryImpl;
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

		if (!(obj instanceof Library)) {
			return false;
		}

		Library library = (Library)obj;

		long primaryKey = library.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		LibraryModelImpl libraryModelImpl = this;

		libraryModelImpl._originalGroupId = libraryModelImpl._groupId;

		libraryModelImpl._setOriginalGroupId = false;

		libraryModelImpl._originalCompanyId = libraryModelImpl._companyId;

		libraryModelImpl._setOriginalCompanyId = false;

		libraryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Library> toCacheModel() {
		LibraryCacheModel libraryCacheModel = new LibraryCacheModel();

		libraryCacheModel.libraryId = getLibraryId();

		libraryCacheModel.libraryName = getLibraryName();

		String libraryName = libraryCacheModel.libraryName;

		if ((libraryName != null) && (libraryName.length() == 0)) {
			libraryCacheModel.libraryName = null;
		}

		libraryCacheModel.groupId = getGroupId();

		libraryCacheModel.companyId = getCompanyId();

		libraryCacheModel.address1 = getAddress1();

		String address1 = libraryCacheModel.address1;

		if ((address1 != null) && (address1.length() == 0)) {
			libraryCacheModel.address1 = null;
		}

		libraryCacheModel.address2 = getAddress2();

		String address2 = libraryCacheModel.address2;

		if ((address2 != null) && (address2.length() == 0)) {
			libraryCacheModel.address2 = null;
		}

		libraryCacheModel.address3 = getAddress3();

		String address3 = libraryCacheModel.address3;

		if ((address3 != null) && (address3.length() == 0)) {
			libraryCacheModel.address3 = null;
		}

		libraryCacheModel.zipcode = getZipcode();

		String zipcode = libraryCacheModel.zipcode;

		if ((zipcode != null) && (zipcode.length() == 0)) {
			libraryCacheModel.zipcode = null;
		}

		libraryCacheModel.city = getCity();

		String city = libraryCacheModel.city;

		if ((city != null) && (city.length() == 0)) {
			libraryCacheModel.city = null;
		}

		libraryCacheModel.state = getState();

		String state = libraryCacheModel.state;

		if ((state != null) && (state.length() == 0)) {
			libraryCacheModel.state = null;
		}

		libraryCacheModel.country = getCountry();

		String country = libraryCacheModel.country;

		if ((country != null) && (country.length() == 0)) {
			libraryCacheModel.country = null;
		}

		libraryCacheModel.phone = getPhone();

		String phone = libraryCacheModel.phone;

		if ((phone != null) && (phone.length() == 0)) {
			libraryCacheModel.phone = null;
		}

		libraryCacheModel.email = getEmail();

		String email = libraryCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			libraryCacheModel.email = null;
		}

		libraryCacheModel.website = getWebsite();

		String website = libraryCacheModel.website;

		if ((website != null) && (website.length() == 0)) {
			libraryCacheModel.website = null;
		}

		libraryCacheModel.notes = getNotes();

		String notes = libraryCacheModel.notes;

		if ((notes != null) && (notes.length() == 0)) {
			libraryCacheModel.notes = null;
		}

		return libraryCacheModel;
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

	private static ClassLoader _classLoader = Library.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Library.class
		};
	private long _libraryId;
	private String _libraryName;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
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
	private long _columnBitmask;
	private Library _escapedModel;
}