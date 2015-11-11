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
 * This class is used by SOAP remote services, specifically {@link com.kencana.lms.service.http.PatronStatusServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.kencana.lms.service.http.PatronStatusServiceSoap
 * @generated
 */
public class PatronStatusSoap implements Serializable {
	public static PatronStatusSoap toSoapModel(PatronStatus model) {
		PatronStatusSoap soapModel = new PatronStatusSoap();

		soapModel.setPatronStatusId(model.getPatronStatusId());
		soapModel.setPatronStatusName(model.getPatronStatusName());
		soapModel.setNoLogin(model.getNoLogin());
		soapModel.setNoCheckout(model.getNoCheckout());
		soapModel.setNoReserve(model.getNoReserve());
		soapModel.setNoRenew(model.getNoRenew());
		soapModel.setColor(model.getColor());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());

		return soapModel;
	}

	public static PatronStatusSoap[] toSoapModels(PatronStatus[] models) {
		PatronStatusSoap[] soapModels = new PatronStatusSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PatronStatusSoap[][] toSoapModels(PatronStatus[][] models) {
		PatronStatusSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PatronStatusSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PatronStatusSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PatronStatusSoap[] toSoapModels(List<PatronStatus> models) {
		List<PatronStatusSoap> soapModels = new ArrayList<PatronStatusSoap>(models.size());

		for (PatronStatus model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PatronStatusSoap[soapModels.size()]);
	}

	public PatronStatusSoap() {
	}

	public long getPrimaryKey() {
		return _patronStatusId;
	}

	public void setPrimaryKey(long pk) {
		setPatronStatusId(pk);
	}

	public long getPatronStatusId() {
		return _patronStatusId;
	}

	public void setPatronStatusId(long patronStatusId) {
		_patronStatusId = patronStatusId;
	}

	public String getPatronStatusName() {
		return _patronStatusName;
	}

	public void setPatronStatusName(String patronStatusName) {
		_patronStatusName = patronStatusName;
	}

	public boolean getNoLogin() {
		return _noLogin;
	}

	public boolean isNoLogin() {
		return _noLogin;
	}

	public void setNoLogin(boolean noLogin) {
		_noLogin = noLogin;
	}

	public boolean getNoCheckout() {
		return _noCheckout;
	}

	public boolean isNoCheckout() {
		return _noCheckout;
	}

	public void setNoCheckout(boolean noCheckout) {
		_noCheckout = noCheckout;
	}

	public boolean getNoReserve() {
		return _noReserve;
	}

	public boolean isNoReserve() {
		return _noReserve;
	}

	public void setNoReserve(boolean noReserve) {
		_noReserve = noReserve;
	}

	public boolean getNoRenew() {
		return _noRenew;
	}

	public boolean isNoRenew() {
		return _noRenew;
	}

	public void setNoRenew(boolean noRenew) {
		_noRenew = noRenew;
	}

	public int getColor() {
		return _color;
	}

	public void setColor(int color) {
		_color = color;
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

	private long _patronStatusId;
	private String _patronStatusName;
	private boolean _noLogin;
	private boolean _noCheckout;
	private boolean _noReserve;
	private boolean _noRenew;
	private int _color;
	private long _groupId;
	private long _companyId;
}