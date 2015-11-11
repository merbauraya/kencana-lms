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
 * This class is used by SOAP remote services, specifically {@link com.kencana.lms.service.http.CatalogTemplateSubfieldServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.kencana.lms.service.http.CatalogTemplateSubfieldServiceSoap
 * @generated
 */
public class CatalogTemplateSubfieldSoap implements Serializable {
	public static CatalogTemplateSubfieldSoap toSoapModel(
		CatalogTemplateSubfield model) {
		CatalogTemplateSubfieldSoap soapModel = new CatalogTemplateSubfieldSoap();

		soapModel.setCatalogTemplateSubfieldId(model.getCatalogTemplateSubfieldId());
		soapModel.setCatalogTemplateTagId(model.getCatalogTemplateTagId());
		soapModel.setSubfield(model.getSubfield());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setRepeatable(model.getRepeatable());
		soapModel.setMandatory(model.getMandatory());
		soapModel.setIsURL(model.getIsURL());

		return soapModel;
	}

	public static CatalogTemplateSubfieldSoap[] toSoapModels(
		CatalogTemplateSubfield[] models) {
		CatalogTemplateSubfieldSoap[] soapModels = new CatalogTemplateSubfieldSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CatalogTemplateSubfieldSoap[][] toSoapModels(
		CatalogTemplateSubfield[][] models) {
		CatalogTemplateSubfieldSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CatalogTemplateSubfieldSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CatalogTemplateSubfieldSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CatalogTemplateSubfieldSoap[] toSoapModels(
		List<CatalogTemplateSubfield> models) {
		List<CatalogTemplateSubfieldSoap> soapModels = new ArrayList<CatalogTemplateSubfieldSoap>(models.size());

		for (CatalogTemplateSubfield model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CatalogTemplateSubfieldSoap[soapModels.size()]);
	}

	public CatalogTemplateSubfieldSoap() {
	}

	public long getPrimaryKey() {
		return _catalogTemplateSubfieldId;
	}

	public void setPrimaryKey(long pk) {
		setCatalogTemplateSubfieldId(pk);
	}

	public long getCatalogTemplateSubfieldId() {
		return _catalogTemplateSubfieldId;
	}

	public void setCatalogTemplateSubfieldId(long catalogTemplateSubfieldId) {
		_catalogTemplateSubfieldId = catalogTemplateSubfieldId;
	}

	public long getCatalogTemplateTagId() {
		return _catalogTemplateTagId;
	}

	public void setCatalogTemplateTagId(long catalogTemplateTagId) {
		_catalogTemplateTagId = catalogTemplateTagId;
	}

	public String getSubfield() {
		return _subfield;
	}

	public void setSubfield(String subfield) {
		_subfield = subfield;
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

	public boolean getRepeatable() {
		return _repeatable;
	}

	public boolean isRepeatable() {
		return _repeatable;
	}

	public void setRepeatable(boolean repeatable) {
		_repeatable = repeatable;
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

	public boolean getIsURL() {
		return _isURL;
	}

	public boolean isIsURL() {
		return _isURL;
	}

	public void setIsURL(boolean isURL) {
		_isURL = isURL;
	}

	private long _catalogTemplateSubfieldId;
	private long _catalogTemplateTagId;
	private String _subfield;
	private long _groupId;
	private long _companyId;
	private boolean _repeatable;
	private boolean _mandatory;
	private boolean _isURL;
}