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
 * This class is used by SOAP remote services, specifically {@link com.kencana.lms.service.http.CirculationTransServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.kencana.lms.service.http.CirculationTransServiceSoap
 * @generated
 */
public class CirculationTransSoap implements Serializable {
	public static CirculationTransSoap toSoapModel(CirculationTrans model) {
		CirculationTransSoap soapModel = new CirculationTransSoap();

		soapModel.setTransId(model.getTransId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setLibraryId(model.getLibraryId());
		soapModel.setPatronId(model.getPatronId());
		soapModel.setCatalogItemId(model.getCatalogItemId());
		soapModel.setTransDate(model.getTransDate());
		soapModel.setDueDate(model.getDueDate());
		soapModel.setOverdue(model.getOverdue());
		soapModel.setReturnDate(model.getReturnDate());
		soapModel.setLastRenewDate(model.getLastRenewDate());
		soapModel.setRenewCount(model.getRenewCount());

		return soapModel;
	}

	public static CirculationTransSoap[] toSoapModels(CirculationTrans[] models) {
		CirculationTransSoap[] soapModels = new CirculationTransSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CirculationTransSoap[][] toSoapModels(
		CirculationTrans[][] models) {
		CirculationTransSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CirculationTransSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CirculationTransSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CirculationTransSoap[] toSoapModels(
		List<CirculationTrans> models) {
		List<CirculationTransSoap> soapModels = new ArrayList<CirculationTransSoap>(models.size());

		for (CirculationTrans model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CirculationTransSoap[soapModels.size()]);
	}

	public CirculationTransSoap() {
	}

	public long getPrimaryKey() {
		return _transId;
	}

	public void setPrimaryKey(long pk) {
		setTransId(pk);
	}

	public long getTransId() {
		return _transId;
	}

	public void setTransId(long transId) {
		_transId = transId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getLibraryId() {
		return _libraryId;
	}

	public void setLibraryId(long libraryId) {
		_libraryId = libraryId;
	}

	public long getPatronId() {
		return _patronId;
	}

	public void setPatronId(long patronId) {
		_patronId = patronId;
	}

	public long getCatalogItemId() {
		return _catalogItemId;
	}

	public void setCatalogItemId(long catalogItemId) {
		_catalogItemId = catalogItemId;
	}

	public Date getTransDate() {
		return _transDate;
	}

	public void setTransDate(Date transDate) {
		_transDate = transDate;
	}

	public Date getDueDate() {
		return _dueDate;
	}

	public void setDueDate(Date dueDate) {
		_dueDate = dueDate;
	}

	public boolean getOverdue() {
		return _overdue;
	}

	public boolean isOverdue() {
		return _overdue;
	}

	public void setOverdue(boolean overdue) {
		_overdue = overdue;
	}

	public Date getReturnDate() {
		return _returnDate;
	}

	public void setReturnDate(Date returnDate) {
		_returnDate = returnDate;
	}

	public Date getLastRenewDate() {
		return _lastRenewDate;
	}

	public void setLastRenewDate(Date lastRenewDate) {
		_lastRenewDate = lastRenewDate;
	}

	public int getRenewCount() {
		return _renewCount;
	}

	public void setRenewCount(int renewCount) {
		_renewCount = renewCount;
	}

	private long _transId;
	private long _companyId;
	private long _groupId;
	private long _libraryId;
	private long _patronId;
	private long _catalogItemId;
	private Date _transDate;
	private Date _dueDate;
	private boolean _overdue;
	private Date _returnDate;
	private Date _lastRenewDate;
	private int _renewCount;
}