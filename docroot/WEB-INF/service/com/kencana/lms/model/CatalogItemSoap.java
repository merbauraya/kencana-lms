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
 * This class is used by SOAP remote services, specifically {@link com.kencana.lms.service.http.CatalogItemServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.kencana.lms.service.http.CatalogItemServiceSoap
 * @generated
 */
public class CatalogItemSoap implements Serializable {
	public static CatalogItemSoap toSoapModel(CatalogItem model) {
		CatalogItemSoap soapModel = new CatalogItemSoap();

		soapModel.setCatalogItemId(model.getCatalogItemId());
		soapModel.setCatalogId(model.getCatalogId());
		soapModel.setCatalogTitle(model.getCatalogTitle());
		soapModel.setCallNumber(model.getCallNumber());
		soapModel.setHoldingLibraryId(model.getHoldingLibraryId());
		soapModel.setCurrentLibraryId(model.getCurrentLibraryId());
		soapModel.setBarcode(model.getBarcode());
		soapModel.setCopyNumber(model.getCopyNumber());
		soapModel.setLocationId(model.getLocationId());
		soapModel.setItemCategoryId(model.getItemCategoryId());
		soapModel.setItemTypeId(model.getItemTypeId());
		soapModel.setWithdrawnStatus(model.getWithdrawnStatus());
		soapModel.setLostStatus(model.getLostStatus());
		soapModel.setDamageStatus(model.getDamageStatus());
		soapModel.setNotForLoanStatus(model.getNotForLoanStatus());
		soapModel.setLastSeenDate(model.getLastSeenDate());
		soapModel.setWithdrawnDate(model.getWithdrawnDate());
		soapModel.setLostDate(model.getLostDate());
		soapModel.setLastCheckOutDate(model.getLastCheckOutDate());
		soapModel.setCirculationCount(model.getCirculationCount());
		soapModel.setRenewalCount(model.getRenewalCount());
		soapModel.setReservedCount(model.getReservedCount());
		soapModel.setCheckedOutDate(model.getCheckedOutDate());
		soapModel.setReservedBy(model.getReservedBy());
		soapModel.setClaimCount(model.getClaimCount());
		soapModel.setDueDate(model.getDueDate());
		soapModel.setCheckOutBy(model.getCheckOutBy());
		soapModel.setReleased(model.getReleased());
		soapModel.setReleaseDate(model.getReleaseDate());
		soapModel.setReleaseByUserId(model.getReleaseByUserId());
		soapModel.setVendorId(model.getVendorId());
		soapModel.setInvoiceId(model.getInvoiceId());
		soapModel.setPurchasePrice(model.getPurchasePrice());
		soapModel.setReplacementPrice(model.getReplacementPrice());
		soapModel.setCurrencyId(model.getCurrencyId());
		soapModel.setLocalPurchasePrice(model.getLocalPurchasePrice());
		soapModel.setPublicNote(model.getPublicNote());
		soapModel.setPrivateNote(model.getPrivateNote());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setAcquiredDate(model.getAcquiredDate());
		soapModel.setWorkflowStatus(model.getWorkflowStatus());

		return soapModel;
	}

	public static CatalogItemSoap[] toSoapModels(CatalogItem[] models) {
		CatalogItemSoap[] soapModels = new CatalogItemSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CatalogItemSoap[][] toSoapModels(CatalogItem[][] models) {
		CatalogItemSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CatalogItemSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CatalogItemSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CatalogItemSoap[] toSoapModels(List<CatalogItem> models) {
		List<CatalogItemSoap> soapModels = new ArrayList<CatalogItemSoap>(models.size());

		for (CatalogItem model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CatalogItemSoap[soapModels.size()]);
	}

	public CatalogItemSoap() {
	}

	public long getPrimaryKey() {
		return _catalogItemId;
	}

	public void setPrimaryKey(long pk) {
		setCatalogItemId(pk);
	}

	public long getCatalogItemId() {
		return _catalogItemId;
	}

	public void setCatalogItemId(long catalogItemId) {
		_catalogItemId = catalogItemId;
	}

	public long getCatalogId() {
		return _catalogId;
	}

	public void setCatalogId(long catalogId) {
		_catalogId = catalogId;
	}

	public String getCatalogTitle() {
		return _catalogTitle;
	}

	public void setCatalogTitle(String catalogTitle) {
		_catalogTitle = catalogTitle;
	}

	public String getCallNumber() {
		return _callNumber;
	}

	public void setCallNumber(String callNumber) {
		_callNumber = callNumber;
	}

	public long getHoldingLibraryId() {
		return _holdingLibraryId;
	}

	public void setHoldingLibraryId(long holdingLibraryId) {
		_holdingLibraryId = holdingLibraryId;
	}

	public long getCurrentLibraryId() {
		return _currentLibraryId;
	}

	public void setCurrentLibraryId(long currentLibraryId) {
		_currentLibraryId = currentLibraryId;
	}

	public String getBarcode() {
		return _barcode;
	}

	public void setBarcode(String barcode) {
		_barcode = barcode;
	}

	public int getCopyNumber() {
		return _copyNumber;
	}

	public void setCopyNumber(int copyNumber) {
		_copyNumber = copyNumber;
	}

	public long getLocationId() {
		return _locationId;
	}

	public void setLocationId(long locationId) {
		_locationId = locationId;
	}

	public long getItemCategoryId() {
		return _itemCategoryId;
	}

	public void setItemCategoryId(long itemCategoryId) {
		_itemCategoryId = itemCategoryId;
	}

	public long getItemTypeId() {
		return _itemTypeId;
	}

	public void setItemTypeId(long itemTypeId) {
		_itemTypeId = itemTypeId;
	}

	public boolean getWithdrawnStatus() {
		return _withdrawnStatus;
	}

	public boolean isWithdrawnStatus() {
		return _withdrawnStatus;
	}

	public void setWithdrawnStatus(boolean withdrawnStatus) {
		_withdrawnStatus = withdrawnStatus;
	}

	public boolean getLostStatus() {
		return _lostStatus;
	}

	public boolean isLostStatus() {
		return _lostStatus;
	}

	public void setLostStatus(boolean lostStatus) {
		_lostStatus = lostStatus;
	}

	public boolean getDamageStatus() {
		return _damageStatus;
	}

	public boolean isDamageStatus() {
		return _damageStatus;
	}

	public void setDamageStatus(boolean damageStatus) {
		_damageStatus = damageStatus;
	}

	public boolean getNotForLoanStatus() {
		return _notForLoanStatus;
	}

	public boolean isNotForLoanStatus() {
		return _notForLoanStatus;
	}

	public void setNotForLoanStatus(boolean notForLoanStatus) {
		_notForLoanStatus = notForLoanStatus;
	}

	public Date getLastSeenDate() {
		return _lastSeenDate;
	}

	public void setLastSeenDate(Date lastSeenDate) {
		_lastSeenDate = lastSeenDate;
	}

	public Date getWithdrawnDate() {
		return _withdrawnDate;
	}

	public void setWithdrawnDate(Date withdrawnDate) {
		_withdrawnDate = withdrawnDate;
	}

	public Date getLostDate() {
		return _lostDate;
	}

	public void setLostDate(Date lostDate) {
		_lostDate = lostDate;
	}

	public Date getLastCheckOutDate() {
		return _lastCheckOutDate;
	}

	public void setLastCheckOutDate(Date lastCheckOutDate) {
		_lastCheckOutDate = lastCheckOutDate;
	}

	public int getCirculationCount() {
		return _circulationCount;
	}

	public void setCirculationCount(int circulationCount) {
		_circulationCount = circulationCount;
	}

	public int getRenewalCount() {
		return _renewalCount;
	}

	public void setRenewalCount(int renewalCount) {
		_renewalCount = renewalCount;
	}

	public int getReservedCount() {
		return _reservedCount;
	}

	public void setReservedCount(int reservedCount) {
		_reservedCount = reservedCount;
	}

	public Date getCheckedOutDate() {
		return _checkedOutDate;
	}

	public void setCheckedOutDate(Date checkedOutDate) {
		_checkedOutDate = checkedOutDate;
	}

	public long getReservedBy() {
		return _reservedBy;
	}

	public void setReservedBy(long reservedBy) {
		_reservedBy = reservedBy;
	}

	public Double getClaimCount() {
		return _claimCount;
	}

	public void setClaimCount(Double claimCount) {
		_claimCount = claimCount;
	}

	public Date getDueDate() {
		return _dueDate;
	}

	public void setDueDate(Date dueDate) {
		_dueDate = dueDate;
	}

	public long getCheckOutBy() {
		return _checkOutBy;
	}

	public void setCheckOutBy(long checkOutBy) {
		_checkOutBy = checkOutBy;
	}

	public boolean getReleased() {
		return _released;
	}

	public boolean isReleased() {
		return _released;
	}

	public void setReleased(boolean released) {
		_released = released;
	}

	public Date getReleaseDate() {
		return _releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		_releaseDate = releaseDate;
	}

	public long getReleaseByUserId() {
		return _releaseByUserId;
	}

	public void setReleaseByUserId(long releaseByUserId) {
		_releaseByUserId = releaseByUserId;
	}

	public long getVendorId() {
		return _vendorId;
	}

	public void setVendorId(long vendorId) {
		_vendorId = vendorId;
	}

	public long getInvoiceId() {
		return _invoiceId;
	}

	public void setInvoiceId(long invoiceId) {
		_invoiceId = invoiceId;
	}

	public double getPurchasePrice() {
		return _purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		_purchasePrice = purchasePrice;
	}

	public double getReplacementPrice() {
		return _replacementPrice;
	}

	public void setReplacementPrice(double replacementPrice) {
		_replacementPrice = replacementPrice;
	}

	public long getCurrencyId() {
		return _currencyId;
	}

	public void setCurrencyId(long currencyId) {
		_currencyId = currencyId;
	}

	public double getLocalPurchasePrice() {
		return _localPurchasePrice;
	}

	public void setLocalPurchasePrice(double localPurchasePrice) {
		_localPurchasePrice = localPurchasePrice;
	}

	public String getPublicNote() {
		return _publicNote;
	}

	public void setPublicNote(String publicNote) {
		_publicNote = publicNote;
	}

	public String getPrivateNote() {
		return _privateNote;
	}

	public void setPrivateNote(String privateNote) {
		_privateNote = privateNote;
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

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public Date getAcquiredDate() {
		return _acquiredDate;
	}

	public void setAcquiredDate(Date acquiredDate) {
		_acquiredDate = acquiredDate;
	}

	public int getWorkflowStatus() {
		return _workflowStatus;
	}

	public void setWorkflowStatus(int workflowStatus) {
		_workflowStatus = workflowStatus;
	}

	private long _catalogItemId;
	private long _catalogId;
	private String _catalogTitle;
	private String _callNumber;
	private long _holdingLibraryId;
	private long _currentLibraryId;
	private String _barcode;
	private int _copyNumber;
	private long _locationId;
	private long _itemCategoryId;
	private long _itemTypeId;
	private boolean _withdrawnStatus;
	private boolean _lostStatus;
	private boolean _damageStatus;
	private boolean _notForLoanStatus;
	private Date _lastSeenDate;
	private Date _withdrawnDate;
	private Date _lostDate;
	private Date _lastCheckOutDate;
	private int _circulationCount;
	private int _renewalCount;
	private int _reservedCount;
	private Date _checkedOutDate;
	private long _reservedBy;
	private Double _claimCount;
	private Date _dueDate;
	private long _checkOutBy;
	private boolean _released;
	private Date _releaseDate;
	private long _releaseByUserId;
	private long _vendorId;
	private long _invoiceId;
	private double _purchasePrice;
	private double _replacementPrice;
	private long _currencyId;
	private double _localPurchasePrice;
	private String _publicNote;
	private String _privateNote;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _acquiredDate;
	private int _workflowStatus;
}