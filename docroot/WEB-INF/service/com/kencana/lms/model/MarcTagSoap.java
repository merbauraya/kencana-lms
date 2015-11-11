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
 * This class is used by SOAP remote services, specifically {@link com.kencana.lms.service.http.MarcTagServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.kencana.lms.service.http.MarcTagServiceSoap
 * @generated
 */
public class MarcTagSoap implements Serializable {
	public static MarcTagSoap toSoapModel(MarcTag model) {
		MarcTagSoap soapModel = new MarcTagSoap();

		soapModel.setTagId(model.getTagId());
		soapModel.setTag(model.getTag());
		soapModel.setDescription(model.getDescription());
		soapModel.setHelpText(model.getHelpText());
		soapModel.setRepetable(model.getRepetable());
		soapModel.setDefaultValue(model.getDefaultValue());
		soapModel.setIndicator1(model.getIndicator1());
		soapModel.setIndicator2(model.getIndicator2());
		soapModel.setTagType(model.getTagType());

		return soapModel;
	}

	public static MarcTagSoap[] toSoapModels(MarcTag[] models) {
		MarcTagSoap[] soapModels = new MarcTagSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MarcTagSoap[][] toSoapModels(MarcTag[][] models) {
		MarcTagSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MarcTagSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MarcTagSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MarcTagSoap[] toSoapModels(List<MarcTag> models) {
		List<MarcTagSoap> soapModels = new ArrayList<MarcTagSoap>(models.size());

		for (MarcTag model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MarcTagSoap[soapModels.size()]);
	}

	public MarcTagSoap() {
	}

	public long getPrimaryKey() {
		return _tagId;
	}

	public void setPrimaryKey(long pk) {
		setTagId(pk);
	}

	public long getTagId() {
		return _tagId;
	}

	public void setTagId(long tagId) {
		_tagId = tagId;
	}

	public String getTag() {
		return _tag;
	}

	public void setTag(String tag) {
		_tag = tag;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getHelpText() {
		return _helpText;
	}

	public void setHelpText(String helpText) {
		_helpText = helpText;
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

	public String getDefaultValue() {
		return _defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		_defaultValue = defaultValue;
	}

	public boolean getIndicator1() {
		return _indicator1;
	}

	public boolean isIndicator1() {
		return _indicator1;
	}

	public void setIndicator1(boolean indicator1) {
		_indicator1 = indicator1;
	}

	public boolean getIndicator2() {
		return _indicator2;
	}

	public boolean isIndicator2() {
		return _indicator2;
	}

	public void setIndicator2(boolean indicator2) {
		_indicator2 = indicator2;
	}

	public String getTagType() {
		return _tagType;
	}

	public void setTagType(String tagType) {
		_tagType = tagType;
	}

	private long _tagId;
	private String _tag;
	private String _description;
	private String _helpText;
	private boolean _repetable;
	private String _defaultValue;
	private boolean _indicator1;
	private boolean _indicator2;
	private String _tagType;
}