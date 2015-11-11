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
 * This class is used by SOAP remote services, specifically {@link com.kencana.lms.service.http.MarcSubfieldServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.kencana.lms.service.http.MarcSubfieldServiceSoap
 * @generated
 */
public class MarcSubfieldSoap implements Serializable {
	public static MarcSubfieldSoap toSoapModel(MarcSubfield model) {
		MarcSubfieldSoap soapModel = new MarcSubfieldSoap();

		soapModel.setMarcSubfieldId(model.getMarcSubfieldId());
		soapModel.setTag(model.getTag());
		soapModel.setTagType(model.getTagType());
		soapModel.setSubfield(model.getSubfield());
		soapModel.setDescription(model.getDescription());
		soapModel.setRepetable(model.getRepetable());
		soapModel.setMandatory(model.getMandatory());
		soapModel.setAuthorisedValue(model.getAuthorisedValue());
		soapModel.setAuthTypeCode(model.getAuthTypeCode());
		soapModel.setIsURL(model.getIsURL());
		soapModel.setHelpText(model.getHelpText());

		return soapModel;
	}

	public static MarcSubfieldSoap[] toSoapModels(MarcSubfield[] models) {
		MarcSubfieldSoap[] soapModels = new MarcSubfieldSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MarcSubfieldSoap[][] toSoapModels(MarcSubfield[][] models) {
		MarcSubfieldSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MarcSubfieldSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MarcSubfieldSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MarcSubfieldSoap[] toSoapModels(List<MarcSubfield> models) {
		List<MarcSubfieldSoap> soapModels = new ArrayList<MarcSubfieldSoap>(models.size());

		for (MarcSubfield model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MarcSubfieldSoap[soapModels.size()]);
	}

	public MarcSubfieldSoap() {
	}

	public long getPrimaryKey() {
		return _MarcSubfieldId;
	}

	public void setPrimaryKey(long pk) {
		setMarcSubfieldId(pk);
	}

	public long getMarcSubfieldId() {
		return _MarcSubfieldId;
	}

	public void setMarcSubfieldId(long MarcSubfieldId) {
		_MarcSubfieldId = MarcSubfieldId;
	}

	public String getTag() {
		return _tag;
	}

	public void setTag(String tag) {
		_tag = tag;
	}

	public String getTagType() {
		return _tagType;
	}

	public void setTagType(String tagType) {
		_tagType = tagType;
	}

	public String getSubfield() {
		return _subfield;
	}

	public void setSubfield(String subfield) {
		_subfield = subfield;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public boolean getRepetable() {
		return _repetable;
	}

	public boolean isRepetable() {
		return _repetable;
	}

	public void setRepetable(boolean repetable) {
		_repetable = repetable;
	}

	public boolean getMandatory() {
		return _mandatory;
	}

	public boolean isMandatory() {
		return _mandatory;
	}

	public void setMandatory(boolean mandatory) {
		_mandatory = mandatory;
	}

	public String getAuthorisedValue() {
		return _authorisedValue;
	}

	public void setAuthorisedValue(String authorisedValue) {
		_authorisedValue = authorisedValue;
	}

	public String getAuthTypeCode() {
		return _authTypeCode;
	}

	public void setAuthTypeCode(String authTypeCode) {
		_authTypeCode = authTypeCode;
	}

	public boolean getIsURL() {
		return _isURL;
	}

	public boolean isIsURL() {
		return _isURL;
	}

	public void setIsURL(boolean isURL) {
		_isURL = isURL;
	}

	public String getHelpText() {
		return _helpText;
	}

	public void setHelpText(String helpText) {
		_helpText = helpText;
	}

	private long _MarcSubfieldId;
	private String _tag;
	private String _tagType;
	private String _subfield;
	private String _description;
	private boolean _repetable;
	private boolean _mandatory;
	private String _authorisedValue;
	private String _authTypeCode;
	private boolean _isURL;
	private String _helpText;
}