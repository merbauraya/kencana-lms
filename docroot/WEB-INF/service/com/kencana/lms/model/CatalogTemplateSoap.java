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
 * This class is used by SOAP remote services, specifically {@link com.kencana.lms.service.http.CatalogTemplateServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.kencana.lms.service.http.CatalogTemplateServiceSoap
 * @generated
 */
public class CatalogTemplateSoap implements Serializable {
	public static CatalogTemplateSoap toSoapModel(CatalogTemplate model) {
		CatalogTemplateSoap soapModel = new CatalogTemplateSoap();

		soapModel.setTemplateId(model.getTemplateId());
		soapModel.setTemplateName(model.getTemplateName());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setDescription(model.getDescription());
		soapModel.setActive(model.getActive());
		soapModel.setCreateBy(model.getCreateBy());
		soapModel.setCreatedDate(model.getCreatedDate());

		return soapModel;
	}

	public static CatalogTemplateSoap[] toSoapModels(CatalogTemplate[] models) {
		CatalogTemplateSoap[] soapModels = new CatalogTemplateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CatalogTemplateSoap[][] toSoapModels(
		CatalogTemplate[][] models) {
		CatalogTemplateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CatalogTemplateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CatalogTemplateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CatalogTemplateSoap[] toSoapModels(
		List<CatalogTemplate> models) {
		List<CatalogTemplateSoap> soapModels = new ArrayList<CatalogTemplateSoap>(models.size());

		for (CatalogTemplate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CatalogTemplateSoap[soapModels.size()]);
	}

	public CatalogTemplateSoap() {
	}

	public long getPrimaryKey() {
		return _templateId;
	}

	public void setPrimaryKey(long pk) {
		setTemplateId(pk);
	}

	public long getTemplateId() {
		return _templateId;
	}

	public void setTemplateId(long templateId) {
		_templateId = templateId;
	}

	public String getTemplateName() {
		return _templateName;
	}

	public void setTemplateName(String templateName) {
		_templateName = templateName;
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

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public long getCreateBy() {
		return _createBy;
	}

	public void setCreateBy(long createBy) {
		_createBy = createBy;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	private long _templateId;
	private String _templateName;
	private long _groupId;
	private long _companyId;
	private String _description;
	private boolean _active;
	private long _createBy;
	private Date _createdDate;
}