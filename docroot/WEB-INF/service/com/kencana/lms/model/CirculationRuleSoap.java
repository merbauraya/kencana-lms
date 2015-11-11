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
 * This class is used by SOAP remote services, specifically {@link com.kencana.lms.service.http.CirculationRuleServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.kencana.lms.service.http.CirculationRuleServiceSoap
 * @generated
 */
public class CirculationRuleSoap implements Serializable {
	public static CirculationRuleSoap toSoapModel(CirculationRule model) {
		CirculationRuleSoap soapModel = new CirculationRuleSoap();

		soapModel.setCirculationRuleId(model.getCirculationRuleId());
		soapModel.setLibraryId(model.getLibraryId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setPatronCategoryId(model.getPatronCategoryId());
		soapModel.setItemTypeId(model.getItemTypeId());
		soapModel.setItemCategoryId(model.getItemCategoryId());
		soapModel.setMaxCheckoutAllowed(model.getMaxCheckoutAllowed());
		soapModel.setRenewalCountAllowed(model.getRenewalCountAllowed());
		soapModel.setReservedCountAllowed(model.getReservedCountAllowed());
		soapModel.setPeriodUnit(model.getPeriodUnit());
		soapModel.setLoanPeriod(model.getLoanPeriod());
		soapModel.setLoanPeriodIfReserved(model.getLoanPeriodIfReserved());
		soapModel.setRentalCharge(model.getRentalCharge());
		soapModel.setFinePerPeriod(model.getFinePerPeriod());
		soapModel.setFineGracePeriod(model.getFineGracePeriod());
		soapModel.setMaxFineAmount(model.getMaxFineAmount());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreatedDate(model.getCreatedDate());

		return soapModel;
	}

	public static CirculationRuleSoap[] toSoapModels(CirculationRule[] models) {
		CirculationRuleSoap[] soapModels = new CirculationRuleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CirculationRuleSoap[][] toSoapModels(
		CirculationRule[][] models) {
		CirculationRuleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CirculationRuleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CirculationRuleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CirculationRuleSoap[] toSoapModels(
		List<CirculationRule> models) {
		List<CirculationRuleSoap> soapModels = new ArrayList<CirculationRuleSoap>(models.size());

		for (CirculationRule model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CirculationRuleSoap[soapModels.size()]);
	}

	public CirculationRuleSoap() {
	}

	public long getPrimaryKey() {
		return _circulationRuleId;
	}

	public void setPrimaryKey(long pk) {
		setCirculationRuleId(pk);
	}

	public long getCirculationRuleId() {
		return _circulationRuleId;
	}

	public void setCirculationRuleId(long circulationRuleId) {
		_circulationRuleId = circulationRuleId;
	}

	public long getLibraryId() {
		return _libraryId;
	}

	public void setLibraryId(long libraryId) {
		_libraryId = libraryId;
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

	public long getPatronCategoryId() {
		return _patronCategoryId;
	}

	public void setPatronCategoryId(long patronCategoryId) {
		_patronCategoryId = patronCategoryId;
	}

	public long getItemTypeId() {
		return _itemTypeId;
	}

	public void setItemTypeId(long itemTypeId) {
		_itemTypeId = itemTypeId;
	}

	public long getItemCategoryId() {
		return _itemCategoryId;
	}

	public void setItemCategoryId(long itemCategoryId) {
		_itemCategoryId = itemCategoryId;
	}

	public int getMaxCheckoutAllowed() {
		return _maxCheckoutAllowed;
	}

	public void setMaxCheckoutAllowed(int maxCheckoutAllowed) {
		_maxCheckoutAllowed = maxCheckoutAllowed;
	}

	public int getRenewalCountAllowed() {
		return _renewalCountAllowed;
	}

	public void setRenewalCountAllowed(int renewalCountAllowed) {
		_renewalCountAllowed = renewalCountAllowed;
	}

	public int getReservedCountAllowed() {
		return _reservedCountAllowed;
	}

	public void setReservedCountAllowed(int reservedCountAllowed) {
		_reservedCountAllowed = reservedCountAllowed;
	}

	public int getPeriodUnit() {
		return _periodUnit;
	}

	public void setPeriodUnit(int periodUnit) {
		_periodUnit = periodUnit;
	}

	public int getLoanPeriod() {
		return _loanPeriod;
	}

	public void setLoanPeriod(int loanPeriod) {
		_loanPeriod = loanPeriod;
	}

	public int getLoanPeriodIfReserved() {
		return _loanPeriodIfReserved;
	}

	public void setLoanPeriodIfReserved(int loanPeriodIfReserved) {
		_loanPeriodIfReserved = loanPeriodIfReserved;
	}

	public double getRentalCharge() {
		return _rentalCharge;
	}

	public void setRentalCharge(double rentalCharge) {
		_rentalCharge = rentalCharge;
	}

	public double getFinePerPeriod() {
		return _finePerPeriod;
	}

	public void setFinePerPeriod(double finePerPeriod) {
		_finePerPeriod = finePerPeriod;
	}

	public int getFineGracePeriod() {
		return _fineGracePeriod;
	}

	public void setFineGracePeriod(int fineGracePeriod) {
		_fineGracePeriod = fineGracePeriod;
	}

	public double getMaxFineAmount() {
		return _maxFineAmount;
	}

	public void setMaxFineAmount(double maxFineAmount) {
		_maxFineAmount = maxFineAmount;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	private long _circulationRuleId;
	private long _libraryId;
	private long _companyId;
	private long _groupId;
	private long _patronCategoryId;
	private long _itemTypeId;
	private long _itemCategoryId;
	private int _maxCheckoutAllowed;
	private int _renewalCountAllowed;
	private int _reservedCountAllowed;
	private int _periodUnit;
	private int _loanPeriod;
	private int _loanPeriodIfReserved;
	private double _rentalCharge;
	private double _finePerPeriod;
	private int _fineGracePeriod;
	private double _maxFineAmount;
	private long _userId;
	private Date _createdDate;
}