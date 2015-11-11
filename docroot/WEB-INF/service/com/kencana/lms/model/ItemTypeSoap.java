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
 * This class is used by SOAP remote services, specifically {@link com.kencana.lms.service.http.ItemTypeServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.kencana.lms.service.http.ItemTypeServiceSoap
 * @generated
 */
public class ItemTypeSoap implements Serializable {
	public static ItemTypeSoap toSoapModel(ItemType model) {
		ItemTypeSoap soapModel = new ItemTypeSoap();

		soapModel.setItemTypeId(model.getItemTypeId());
		soapModel.setItemTypeName(model.getItemTypeName());
		soapModel.setNotForLoan(model.getNotForLoan());
		soapModel.setCoverId(model.getCoverId());
		soapModel.setCheckoutMessage(model.getCheckoutMessage());
		soapModel.setCheckinMessage(model.getCheckinMessage());
		soapModel.setRentalRate(model.getRentalRate());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static ItemTypeSoap[] toSoapModels(ItemType[] models) {
		ItemTypeSoap[] soapModels = new ItemTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ItemTypeSoap[][] toSoapModels(ItemType[][] models) {
		ItemTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ItemTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ItemTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ItemTypeSoap[] toSoapModels(List<ItemType> models) {
		List<ItemTypeSoap> soapModels = new ArrayList<ItemTypeSoap>(models.size());

		for (ItemType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ItemTypeSoap[soapModels.size()]);
	}

	public ItemTypeSoap() {
	}

	public long getPrimaryKey() {
		return _itemTypeId;
	}

	public void setPrimaryKey(long pk) {
		setItemTypeId(pk);
	}

	public long getItemTypeId() {
		return _itemTypeId;
	}

	public void setItemTypeId(long itemTypeId) {
		_itemTypeId = itemTypeId;
	}

	public String getItemTypeName() {
		return _itemTypeName;
	}

	public void setItemTypeName(String itemTypeName) {
		_itemTypeName = itemTypeName;
	}

	public boolean getNotForLoan() {
		return _notForLoan;
	}

	public boolean isNotForLoan() {
		return _notForLoan;
	}

	public void setNotForLoan(boolean notForLoan) {
		_notForLoan = notForLoan;
	}

	public long getCoverId() {
		return _coverId;
	}

	public void setCoverId(long coverId) {
		_coverId = coverId;
	}

	public String getCheckoutMessage() {
		return _checkoutMessage;
	}

	public void setCheckoutMessage(String checkoutMessage) {
		_checkoutMessage = checkoutMessage;
	}

	public String getCheckinMessage() {
		return _checkinMessage;
	}

	public void setCheckinMessage(String checkinMessage) {
		_checkinMessage = checkinMessage;
	}

	public Double getRentalRate() {
		return _rentalRate;
	}

	public void setRentalRate(Double rentalRate) {
		_rentalRate = rentalRate;
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	private long _itemTypeId;
	private String _itemTypeName;
	private boolean _notForLoan;
	private long _coverId;
	private String _checkoutMessage;
	private String _checkinMessage;
	private Double _rentalRate;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
}