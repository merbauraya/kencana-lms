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
 * This class is used by SOAP remote services, specifically {@link com.kencana.lms.service.http.ReasonCodeServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.kencana.lms.service.http.ReasonCodeServiceSoap
 * @generated
 */
public class ReasonCodeSoap implements Serializable {
	public static ReasonCodeSoap toSoapModel(ReasonCode model) {
		ReasonCodeSoap soapModel = new ReasonCodeSoap();

		soapModel.setReasonCodeId(model.getReasonCodeId());
		soapModel.setReasonCodeName(model.getReasonCodeName());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());

		return soapModel;
	}

	public static ReasonCodeSoap[] toSoapModels(ReasonCode[] models) {
		ReasonCodeSoap[] soapModels = new ReasonCodeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ReasonCodeSoap[][] toSoapModels(ReasonCode[][] models) {
		ReasonCodeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ReasonCodeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ReasonCodeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ReasonCodeSoap[] toSoapModels(List<ReasonCode> models) {
		List<ReasonCodeSoap> soapModels = new ArrayList<ReasonCodeSoap>(models.size());

		for (ReasonCode model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ReasonCodeSoap[soapModels.size()]);
	}

	public ReasonCodeSoap() {
	}

	public long getPrimaryKey() {
		return _reasonCodeId;
	}

	public void setPrimaryKey(long pk) {
		setReasonCodeId(pk);
	}

	public long getReasonCodeId() {
		return _reasonCodeId;
	}

	public void setReasonCodeId(long reasonCodeId) {
		_reasonCodeId = reasonCodeId;
	}

	public String getReasonCodeName() {
		return _reasonCodeName;
	}

	public void setReasonCodeName(String reasonCodeName) {
		_reasonCodeName = reasonCodeName;
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

	private long _reasonCodeId;
	private String _reasonCodeName;
	private long _groupId;
	private long _companyId;
}