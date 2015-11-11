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
 * This class is used by SOAP remote services, specifically {@link com.kencana.lms.service.http.PatronServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.kencana.lms.service.http.PatronServiceSoap
 * @generated
 */
public class PatronSoap implements Serializable {
	public static PatronSoap toSoapModel(Patron model) {
		PatronSoap soapModel = new PatronSoap();

		soapModel.setPatronId(model.getPatronId());
		soapModel.setCardNumber(model.getCardNumber());
		soapModel.setUserId(model.getUserId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setLibraryId(model.getLibraryId());
		soapModel.setExpiryDate(model.getExpiryDate());
		soapModel.setPatronCategoryId(model.getPatronCategoryId());
		soapModel.setPatronStatusId(model.getPatronStatusId());
		soapModel.setPatronNote(model.getPatronNote());

		return soapModel;
	}

	public static PatronSoap[] toSoapModels(Patron[] models) {
		PatronSoap[] soapModels = new PatronSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PatronSoap[][] toSoapModels(Patron[][] models) {
		PatronSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PatronSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PatronSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PatronSoap[] toSoapModels(List<Patron> models) {
		List<PatronSoap> soapModels = new ArrayList<PatronSoap>(models.size());

		for (Patron model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PatronSoap[soapModels.size()]);
	}

	public PatronSoap() {
	}

	public long getPrimaryKey() {
		return _patronId;
	}

	public void setPrimaryKey(long pk) {
		setPatronId(pk);
	}

	public long getPatronId() {
		return _patronId;
	}

	public void setPatronId(long patronId) {
		_patronId = patronId;
	}

	public String getCardNumber() {
		return _cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		_cardNumber = cardNumber;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
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

	public long getLibraryId() {
		return _libraryId;
	}

	public void setLibraryId(long libraryId) {
		_libraryId = libraryId;
	}

	public Date getExpiryDate() {
		return _expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		_expiryDate = expiryDate;
	}

	public long getPatronCategoryId() {
		return _patronCategoryId;
	}

	public void setPatronCategoryId(long patronCategoryId) {
		_patronCategoryId = patronCategoryId;
	}

	public long getPatronStatusId() {
		return _patronStatusId;
	}

	public void setPatronStatusId(long patronStatusId) {
		_patronStatusId = patronStatusId;
	}

	public String getPatronNote() {
		return _patronNote;
	}

	public void setPatronNote(String patronNote) {
		_patronNote = patronNote;
	}

	private long _patronId;
	private String _cardNumber;
	private long _userId;
	private long _groupId;
	private long _companyId;
	private long _libraryId;
	private Date _expiryDate;
	private long _patronCategoryId;
	private long _patronStatusId;
	private String _patronNote;
}