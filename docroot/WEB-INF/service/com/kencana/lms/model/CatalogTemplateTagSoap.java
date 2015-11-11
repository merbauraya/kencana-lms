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
 * This class is used by SOAP remote services, specifically {@link com.kencana.lms.service.http.CatalogTemplateTagServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.kencana.lms.service.http.CatalogTemplateTagServiceSoap
 * @generated
 */
public class CatalogTemplateTagSoap implements Serializable {
	public static CatalogTemplateTagSoap toSoapModel(CatalogTemplateTag model) {
		CatalogTemplateTagSoap soapModel = new CatalogTemplateTagSoap();

		soapModel.setCatelogTemplateTagId(model.getCatelogTemplateTagId());
		soapModel.setCatelogTemplateId(model.getCatelogTemplateId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setTag(model.getTag());
		soapModel.setRepeatable(model.getRepeatable());
		soapModel.setMandatory(model.getMandatory());
		soapModel.setHelpText(model.getHelpText());

		return soapModel;
	}

	public static CatalogTemplateTagSoap[] toSoapModels(
		CatalogTemplateTag[] models) {
		CatalogTemplateTagSoap[] soapModels = new CatalogTemplateTagSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CatalogTemplateTagSoap[][] toSoapModels(
		CatalogTemplateTag[][] models) {
		CatalogTemplateTagSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CatalogTemplateTagSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CatalogTemplateTagSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CatalogTemplateTagSoap[] toSoapModels(
		List<CatalogTemplateTag> models) {
		List<CatalogTemplateTagSoap> soapModels = new ArrayList<CatalogTemplateTagSoap>(models.size());

		for (CatalogTemplateTag model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CatalogTemplateTagSoap[soapModels.size()]);
	}

	public CatalogTemplateTagSoap() {
	}

	public long getPrimaryKey() {
		return _catelogTemplateTagId;
	}

	public void setPrimaryKey(long pk) {
		setCatelogTemplateTagId(pk);
	}

	public long getCatelogTemplateTagId() {
		return _catelogTemplateTagId;
	}

	public void setCatelogTemplateTagId(long catelogTemplateTagId) {
		_catelogTemplateTagId = catelogTemplateTagId;
	}

	public long getCatelogTemplateId() {
		return _catelogTemplateId;
	}

	public void setCatelogTemplateId(long catelogTemplateId) {
		_catelogTemplateId = catelogTemplateId;
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

	public String getTag() {
		return _tag;
	}

	public void setTag(String tag) {
		_tag = tag;
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

	public String getHelpText() {
		return _helpText;
	}

	public void setHelpText(String helpText) {
		_helpText = helpText;
	}

	private long _catelogTemplateTagId;
	private long _catelogTemplateId;
	private long _groupId;
	private long _companyId;
	private String _tag;
	private boolean _repeatable;
	private boolean _mandatory;
	private String _helpText;
}