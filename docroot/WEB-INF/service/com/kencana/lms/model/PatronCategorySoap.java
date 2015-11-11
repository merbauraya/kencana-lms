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
 * This class is used by SOAP remote services, specifically {@link com.kencana.lms.service.http.PatronCategoryServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.kencana.lms.service.http.PatronCategoryServiceSoap
 * @generated
 */
public class PatronCategorySoap implements Serializable {
	public static PatronCategorySoap toSoapModel(PatronCategory model) {
		PatronCategorySoap soapModel = new PatronCategorySoap();

		soapModel.setPatronCategoryId(model.getPatronCategoryId());
		soapModel.setPatronCategoryName(model.getPatronCategoryName());
		soapModel.setNotes(model.getNotes());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());

		return soapModel;
	}

	public static PatronCategorySoap[] toSoapModels(PatronCategory[] models) {
		PatronCategorySoap[] soapModels = new PatronCategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PatronCategorySoap[][] toSoapModels(PatronCategory[][] models) {
		PatronCategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PatronCategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new PatronCategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PatronCategorySoap[] toSoapModels(List<PatronCategory> models) {
		List<PatronCategorySoap> soapModels = new ArrayList<PatronCategorySoap>(models.size());

		for (PatronCategory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PatronCategorySoap[soapModels.size()]);
	}

	public PatronCategorySoap() {
	}

	public long getPrimaryKey() {
		return _patronCategoryId;
	}

	public void setPrimaryKey(long pk) {
		setPatronCategoryId(pk);
	}

	public long getPatronCategoryId() {
		return _patronCategoryId;
	}

	public void setPatronCategoryId(long patronCategoryId) {
		_patronCategoryId = patronCategoryId;
	}

	public String getPatronCategoryName() {
		return _patronCategoryName;
	}

	public void setPatronCategoryName(String patronCategoryName) {
		_patronCategoryName = patronCategoryName;
	}

	public String getNotes() {
		return _notes;
	}

	public void setNotes(String notes) {
		_notes = notes;
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

	private long _patronCategoryId;
	private String _patronCategoryName;
	private String _notes;
	private long _groupId;
	private long _companyId;
}