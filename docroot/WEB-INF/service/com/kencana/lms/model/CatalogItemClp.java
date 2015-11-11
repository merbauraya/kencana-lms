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

import com.kencana.lms.service.CatalogItemLocalServiceUtil;
import com.kencana.lms.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mazlan Mat
 */
public class CatalogItemClp extends BaseModelImpl<CatalogItem>
	implements CatalogItem {
	public CatalogItemClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CatalogItem.class;
	}

	@Override
	public String getModelClassName() {
		return CatalogItem.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _catalogItemId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCatalogItemId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _catalogItemId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("catalogItemId", getCatalogItemId());
		attributes.put("catalogId", getCatalogId());
		attributes.put("catalogTitle", getCatalogTitle());
		attributes.put("callNumber", getCallNumber());
		attributes.put("holdingLibraryId", getHoldingLibraryId());
		attributes.put("currentLibraryId", getCurrentLibraryId());
		attributes.put("barcode", getBarcode());
		attributes.put("copyNumber", getCopyNumber());
		attributes.put("locationId", getLocationId());
		attributes.put("itemCategoryId", getItemCategoryId());
		attributes.put("itemTypeId", getItemTypeId());
		attributes.put("withdrawnStatus", getWithdrawnStatus());
		attributes.put("lostStatus", getLostStatus());
		attributes.put("damageStatus", getDamageStatus());
		attributes.put("notForLoanStatus", getNotForLoanStatus());
		attributes.put("lastSeenDate", getLastSeenDate());
		attributes.put("withdrawnDate", getWithdrawnDate());
		attributes.put("lostDate", getLostDate());
		attributes.put("lastCheckOutDate", getLastCheckOutDate());
		attributes.put("circulationCount", getCirculationCount());
		attributes.put("renewalCount", getRenewalCount());
		attributes.put("reservedCount", getReservedCount());
		attributes.put("checkedOutDate", getCheckedOutDate());
		attributes.put("reservedBy", getReservedBy());
		attributes.put("claimCount", getClaimCount());
		attributes.put("dueDate", getDueDate());
		attributes.put("checkOutBy", getCheckOutBy());
		attributes.put("released", getReleased());
		attributes.put("releaseDate", getReleaseDate());
		attributes.put("releaseByUserId", getReleaseByUserId());
		attributes.put("vendorId", getVendorId());
		attributes.put("invoiceId", getInvoiceId());
		attributes.put("purchasePrice", getPurchasePrice());
		attributes.put("replacementPrice", getReplacementPrice());
		attributes.put("currencyId", getCurrencyId());
		attributes.put("localPurchasePrice", getLocalPurchasePrice());
		attributes.put("publicNote", getPublicNote());
		attributes.put("privateNote", getPrivateNote());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("acquiredDate", getAcquiredDate());
		attributes.put("workflowStatus", getWorkflowStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long catalogItemId = (Long)attributes.get("catalogItemId");

		if (catalogItemId != null) {
			setCatalogItemId(catalogItemId);
		}

		Long catalogId = (Long)attributes.get("catalogId");

		if (catalogId != null) {
			setCatalogId(catalogId);
		}

		String catalogTitle = (String)attributes.get("catalogTitle");

		if (catalogTitle != null) {
			setCatalogTitle(catalogTitle);
		}

		String callNumber = (String)attributes.get("callNumber");

		if (callNumber != null) {
			setCallNumber(callNumber);
		}

		Long holdingLibraryId = (Long)attributes.get("holdingLibraryId");

		if (holdingLibraryId != null) {
			setHoldingLibraryId(holdingLibraryId);
		}

		Long currentLibraryId = (Long)attributes.get("currentLibraryId");

		if (currentLibraryId != null) {
			setCurrentLibraryId(currentLibraryId);
		}

		String barcode = (String)attributes.get("barcode");

		if (barcode != null) {
			setBarcode(barcode);
		}

		Integer copyNumber = (Integer)attributes.get("copyNumber");

		if (copyNumber != null) {
			setCopyNumber(copyNumber);
		}

		Long locationId = (Long)attributes.get("locationId");

		if (locationId != null) {
			setLocationId(locationId);
		}

		Long itemCategoryId = (Long)attributes.get("itemCategoryId");

		if (itemCategoryId != null) {
			setItemCategoryId(itemCategoryId);
		}

		Long itemTypeId = (Long)attributes.get("itemTypeId");

		if (itemTypeId != null) {
			setItemTypeId(itemTypeId);
		}

		Boolean withdrawnStatus = (Boolean)attributes.get("withdrawnStatus");

		if (withdrawnStatus != null) {
			setWithdrawnStatus(withdrawnStatus);
		}

		Boolean lostStatus = (Boolean)attributes.get("lostStatus");

		if (lostStatus != null) {
			setLostStatus(lostStatus);
		}

		Boolean damageStatus = (Boolean)attributes.get("damageStatus");

		if (damageStatus != null) {
			setDamageStatus(damageStatus);
		}

		Boolean notForLoanStatus = (Boolean)attributes.get("notForLoanStatus");

		if (notForLoanStatus != null) {
			setNotForLoanStatus(notForLoanStatus);
		}

		Date lastSeenDate = (Date)attributes.get("lastSeenDate");

		if (lastSeenDate != null) {
			setLastSeenDate(lastSeenDate);
		}

		Date withdrawnDate = (Date)attributes.get("withdrawnDate");

		if (withdrawnDate != null) {
			setWithdrawnDate(withdrawnDate);
		}

		Date lostDate = (Date)attributes.get("lostDate");

		if (lostDate != null) {
			setLostDate(lostDate);
		}

		Date lastCheckOutDate = (Date)attributes.get("lastCheckOutDate");

		if (lastCheckOutDate != null) {
			setLastCheckOutDate(lastCheckOutDate);
		}

		Integer circulationCount = (Integer)attributes.get("circulationCount");

		if (circulationCount != null) {
			setCirculationCount(circulationCount);
		}

		Integer renewalCount = (Integer)attributes.get("renewalCount");

		if (renewalCount != null) {
			setRenewalCount(renewalCount);
		}

		Integer reservedCount = (Integer)attributes.get("reservedCount");

		if (reservedCount != null) {
			setReservedCount(reservedCount);
		}

		Date checkedOutDate = (Date)attributes.get("checkedOutDate");

		if (checkedOutDate != null) {
			setCheckedOutDate(checkedOutDate);
		}

		Long reservedBy = (Long)attributes.get("reservedBy");

		if (reservedBy != null) {
			setReservedBy(reservedBy);
		}

		Double claimCount = (Double)attributes.get("claimCount");

		if (claimCount != null) {
			setClaimCount(claimCount);
		}

		Date dueDate = (Date)attributes.get("dueDate");

		if (dueDate != null) {
			setDueDate(dueDate);
		}

		Long checkOutBy = (Long)attributes.get("checkOutBy");

		if (checkOutBy != null) {
			setCheckOutBy(checkOutBy);
		}

		Boolean released = (Boolean)attributes.get("released");

		if (released != null) {
			setReleased(released);
		}

		Date releaseDate = (Date)attributes.get("releaseDate");

		if (releaseDate != null) {
			setReleaseDate(releaseDate);
		}

		Long releaseByUserId = (Long)attributes.get("releaseByUserId");

		if (releaseByUserId != null) {
			setReleaseByUserId(releaseByUserId);
		}

		Long vendorId = (Long)attributes.get("vendorId");

		if (vendorId != null) {
			setVendorId(vendorId);
		}

		Long invoiceId = (Long)attributes.get("invoiceId");

		if (invoiceId != null) {
			setInvoiceId(invoiceId);
		}

		Double purchasePrice = (Double)attributes.get("purchasePrice");

		if (purchasePrice != null) {
			setPurchasePrice(purchasePrice);
		}

		Double replacementPrice = (Double)attributes.get("replacementPrice");

		if (replacementPrice != null) {
			setReplacementPrice(replacementPrice);
		}

		Long currencyId = (Long)attributes.get("currencyId");

		if (currencyId != null) {
			setCurrencyId(currencyId);
		}

		Double localPurchasePrice = (Double)attributes.get("localPurchasePrice");

		if (localPurchasePrice != null) {
			setLocalPurchasePrice(localPurchasePrice);
		}

		String publicNote = (String)attributes.get("publicNote");

		if (publicNote != null) {
			setPublicNote(publicNote);
		}

		String privateNote = (String)attributes.get("privateNote");

		if (privateNote != null) {
			setPrivateNote(privateNote);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date acquiredDate = (Date)attributes.get("acquiredDate");

		if (acquiredDate != null) {
			setAcquiredDate(acquiredDate);
		}

		Integer workflowStatus = (Integer)attributes.get("workflowStatus");

		if (workflowStatus != null) {
			setWorkflowStatus(workflowStatus);
		}
	}

	@Override
	public long getCatalogItemId() {
		return _catalogItemId;
	}

	@Override
	public void setCatalogItemId(long catalogItemId) {
		_catalogItemId = catalogItemId;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCatalogItemId", long.class);

				method.invoke(_catalogItemRemoteModel, catalogItemId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCatalogId() {
		return _catalogId;
	}

	@Override
	public void setCatalogId(long catalogId) {
		_catalogId = catalogId;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCatalogId", long.class);

				method.invoke(_catalogItemRemoteModel, catalogId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCatalogTitle() {
		return _catalogTitle;
	}

	@Override
	public void setCatalogTitle(String catalogTitle) {
		_catalogTitle = catalogTitle;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCatalogTitle", String.class);

				method.invoke(_catalogItemRemoteModel, catalogTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCallNumber() {
		return _callNumber;
	}

	@Override
	public void setCallNumber(String callNumber) {
		_callNumber = callNumber;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCallNumber", String.class);

				method.invoke(_catalogItemRemoteModel, callNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getHoldingLibraryId() {
		return _holdingLibraryId;
	}

	@Override
	public void setHoldingLibraryId(long holdingLibraryId) {
		_holdingLibraryId = holdingLibraryId;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setHoldingLibraryId",
						long.class);

				method.invoke(_catalogItemRemoteModel, holdingLibraryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCurrentLibraryId() {
		return _currentLibraryId;
	}

	@Override
	public void setCurrentLibraryId(long currentLibraryId) {
		_currentLibraryId = currentLibraryId;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrentLibraryId",
						long.class);

				method.invoke(_catalogItemRemoteModel, currentLibraryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBarcode() {
		return _barcode;
	}

	@Override
	public void setBarcode(String barcode) {
		_barcode = barcode;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setBarcode", String.class);

				method.invoke(_catalogItemRemoteModel, barcode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getCopyNumber() {
		return _copyNumber;
	}

	@Override
	public void setCopyNumber(int copyNumber) {
		_copyNumber = copyNumber;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCopyNumber", int.class);

				method.invoke(_catalogItemRemoteModel, copyNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLocationId() {
		return _locationId;
	}

	@Override
	public void setLocationId(long locationId) {
		_locationId = locationId;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setLocationId", long.class);

				method.invoke(_catalogItemRemoteModel, locationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getItemCategoryId() {
		return _itemCategoryId;
	}

	@Override
	public void setItemCategoryId(long itemCategoryId) {
		_itemCategoryId = itemCategoryId;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setItemCategoryId", long.class);

				method.invoke(_catalogItemRemoteModel, itemCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getItemTypeId() {
		return _itemTypeId;
	}

	@Override
	public void setItemTypeId(long itemTypeId) {
		_itemTypeId = itemTypeId;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setItemTypeId", long.class);

				method.invoke(_catalogItemRemoteModel, itemTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getWithdrawnStatus() {
		return _withdrawnStatus;
	}

	@Override
	public boolean isWithdrawnStatus() {
		return _withdrawnStatus;
	}

	@Override
	public void setWithdrawnStatus(boolean withdrawnStatus) {
		_withdrawnStatus = withdrawnStatus;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setWithdrawnStatus",
						boolean.class);

				method.invoke(_catalogItemRemoteModel, withdrawnStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getLostStatus() {
		return _lostStatus;
	}

	@Override
	public boolean isLostStatus() {
		return _lostStatus;
	}

	@Override
	public void setLostStatus(boolean lostStatus) {
		_lostStatus = lostStatus;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setLostStatus", boolean.class);

				method.invoke(_catalogItemRemoteModel, lostStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getDamageStatus() {
		return _damageStatus;
	}

	@Override
	public boolean isDamageStatus() {
		return _damageStatus;
	}

	@Override
	public void setDamageStatus(boolean damageStatus) {
		_damageStatus = damageStatus;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setDamageStatus", boolean.class);

				method.invoke(_catalogItemRemoteModel, damageStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getNotForLoanStatus() {
		return _notForLoanStatus;
	}

	@Override
	public boolean isNotForLoanStatus() {
		return _notForLoanStatus;
	}

	@Override
	public void setNotForLoanStatus(boolean notForLoanStatus) {
		_notForLoanStatus = notForLoanStatus;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setNotForLoanStatus",
						boolean.class);

				method.invoke(_catalogItemRemoteModel, notForLoanStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLastSeenDate() {
		return _lastSeenDate;
	}

	@Override
	public void setLastSeenDate(Date lastSeenDate) {
		_lastSeenDate = lastSeenDate;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setLastSeenDate", Date.class);

				method.invoke(_catalogItemRemoteModel, lastSeenDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getWithdrawnDate() {
		return _withdrawnDate;
	}

	@Override
	public void setWithdrawnDate(Date withdrawnDate) {
		_withdrawnDate = withdrawnDate;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setWithdrawnDate", Date.class);

				method.invoke(_catalogItemRemoteModel, withdrawnDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLostDate() {
		return _lostDate;
	}

	@Override
	public void setLostDate(Date lostDate) {
		_lostDate = lostDate;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setLostDate", Date.class);

				method.invoke(_catalogItemRemoteModel, lostDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLastCheckOutDate() {
		return _lastCheckOutDate;
	}

	@Override
	public void setLastCheckOutDate(Date lastCheckOutDate) {
		_lastCheckOutDate = lastCheckOutDate;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setLastCheckOutDate",
						Date.class);

				method.invoke(_catalogItemRemoteModel, lastCheckOutDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getCirculationCount() {
		return _circulationCount;
	}

	@Override
	public void setCirculationCount(int circulationCount) {
		_circulationCount = circulationCount;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCirculationCount", int.class);

				method.invoke(_catalogItemRemoteModel, circulationCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getRenewalCount() {
		return _renewalCount;
	}

	@Override
	public void setRenewalCount(int renewalCount) {
		_renewalCount = renewalCount;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setRenewalCount", int.class);

				method.invoke(_catalogItemRemoteModel, renewalCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getReservedCount() {
		return _reservedCount;
	}

	@Override
	public void setReservedCount(int reservedCount) {
		_reservedCount = reservedCount;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setReservedCount", int.class);

				method.invoke(_catalogItemRemoteModel, reservedCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCheckedOutDate() {
		return _checkedOutDate;
	}

	@Override
	public void setCheckedOutDate(Date checkedOutDate) {
		_checkedOutDate = checkedOutDate;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCheckedOutDate", Date.class);

				method.invoke(_catalogItemRemoteModel, checkedOutDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getReservedBy() {
		return _reservedBy;
	}

	@Override
	public void setReservedBy(long reservedBy) {
		_reservedBy = reservedBy;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setReservedBy", long.class);

				method.invoke(_catalogItemRemoteModel, reservedBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Double getClaimCount() {
		return _claimCount;
	}

	@Override
	public void setClaimCount(Double claimCount) {
		_claimCount = claimCount;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setClaimCount", Double.class);

				method.invoke(_catalogItemRemoteModel, claimCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDueDate() {
		return _dueDate;
	}

	@Override
	public void setDueDate(Date dueDate) {
		_dueDate = dueDate;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setDueDate", Date.class);

				method.invoke(_catalogItemRemoteModel, dueDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCheckOutBy() {
		return _checkOutBy;
	}

	@Override
	public void setCheckOutBy(long checkOutBy) {
		_checkOutBy = checkOutBy;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCheckOutBy", long.class);

				method.invoke(_catalogItemRemoteModel, checkOutBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getReleased() {
		return _released;
	}

	@Override
	public boolean isReleased() {
		return _released;
	}

	@Override
	public void setReleased(boolean released) {
		_released = released;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setReleased", boolean.class);

				method.invoke(_catalogItemRemoteModel, released);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getReleaseDate() {
		return _releaseDate;
	}

	@Override
	public void setReleaseDate(Date releaseDate) {
		_releaseDate = releaseDate;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setReleaseDate", Date.class);

				method.invoke(_catalogItemRemoteModel, releaseDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getReleaseByUserId() {
		return _releaseByUserId;
	}

	@Override
	public void setReleaseByUserId(long releaseByUserId) {
		_releaseByUserId = releaseByUserId;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setReleaseByUserId", long.class);

				method.invoke(_catalogItemRemoteModel, releaseByUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReleaseByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getReleaseByUserId(), "uuid",
			_releaseByUserUuid);
	}

	@Override
	public void setReleaseByUserUuid(String releaseByUserUuid) {
		_releaseByUserUuid = releaseByUserUuid;
	}

	@Override
	public long getVendorId() {
		return _vendorId;
	}

	@Override
	public void setVendorId(long vendorId) {
		_vendorId = vendorId;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setVendorId", long.class);

				method.invoke(_catalogItemRemoteModel, vendorId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getInvoiceId() {
		return _invoiceId;
	}

	@Override
	public void setInvoiceId(long invoiceId) {
		_invoiceId = invoiceId;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setInvoiceId", long.class);

				method.invoke(_catalogItemRemoteModel, invoiceId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getPurchasePrice() {
		return _purchasePrice;
	}

	@Override
	public void setPurchasePrice(double purchasePrice) {
		_purchasePrice = purchasePrice;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setPurchasePrice", double.class);

				method.invoke(_catalogItemRemoteModel, purchasePrice);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getReplacementPrice() {
		return _replacementPrice;
	}

	@Override
	public void setReplacementPrice(double replacementPrice) {
		_replacementPrice = replacementPrice;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setReplacementPrice",
						double.class);

				method.invoke(_catalogItemRemoteModel, replacementPrice);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCurrencyId() {
		return _currencyId;
	}

	@Override
	public void setCurrencyId(long currencyId) {
		_currencyId = currencyId;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrencyId", long.class);

				method.invoke(_catalogItemRemoteModel, currencyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getLocalPurchasePrice() {
		return _localPurchasePrice;
	}

	@Override
	public void setLocalPurchasePrice(double localPurchasePrice) {
		_localPurchasePrice = localPurchasePrice;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setLocalPurchasePrice",
						double.class);

				method.invoke(_catalogItemRemoteModel, localPurchasePrice);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPublicNote() {
		return _publicNote;
	}

	@Override
	public void setPublicNote(String publicNote) {
		_publicNote = publicNote;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setPublicNote", String.class);

				method.invoke(_catalogItemRemoteModel, publicNote);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPrivateNote() {
		return _privateNote;
	}

	@Override
	public void setPrivateNote(String privateNote) {
		_privateNote = privateNote;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setPrivateNote", String.class);

				method.invoke(_catalogItemRemoteModel, privateNote);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_catalogItemRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_catalogItemRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_catalogItemRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_catalogItemRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_catalogItemRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_catalogItemRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getAcquiredDate() {
		return _acquiredDate;
	}

	@Override
	public void setAcquiredDate(Date acquiredDate) {
		_acquiredDate = acquiredDate;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setAcquiredDate", Date.class);

				method.invoke(_catalogItemRemoteModel, acquiredDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getWorkflowStatus() {
		return _workflowStatus;
	}

	@Override
	public void setWorkflowStatus(int workflowStatus) {
		_workflowStatus = workflowStatus;

		if (_catalogItemRemoteModel != null) {
			try {
				Class<?> clazz = _catalogItemRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkflowStatus", int.class);

				method.invoke(_catalogItemRemoteModel, workflowStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCatalogItemRemoteModel() {
		return _catalogItemRemoteModel;
	}

	public void setCatalogItemRemoteModel(BaseModel<?> catalogItemRemoteModel) {
		_catalogItemRemoteModel = catalogItemRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _catalogItemRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_catalogItemRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CatalogItemLocalServiceUtil.addCatalogItem(this);
		}
		else {
			CatalogItemLocalServiceUtil.updateCatalogItem(this);
		}
	}

	@Override
	public CatalogItem toEscapedModel() {
		return (CatalogItem)ProxyUtil.newProxyInstance(CatalogItem.class.getClassLoader(),
			new Class[] { CatalogItem.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CatalogItemClp clone = new CatalogItemClp();

		clone.setCatalogItemId(getCatalogItemId());
		clone.setCatalogId(getCatalogId());
		clone.setCatalogTitle(getCatalogTitle());
		clone.setCallNumber(getCallNumber());
		clone.setHoldingLibraryId(getHoldingLibraryId());
		clone.setCurrentLibraryId(getCurrentLibraryId());
		clone.setBarcode(getBarcode());
		clone.setCopyNumber(getCopyNumber());
		clone.setLocationId(getLocationId());
		clone.setItemCategoryId(getItemCategoryId());
		clone.setItemTypeId(getItemTypeId());
		clone.setWithdrawnStatus(getWithdrawnStatus());
		clone.setLostStatus(getLostStatus());
		clone.setDamageStatus(getDamageStatus());
		clone.setNotForLoanStatus(getNotForLoanStatus());
		clone.setLastSeenDate(getLastSeenDate());
		clone.setWithdrawnDate(getWithdrawnDate());
		clone.setLostDate(getLostDate());
		clone.setLastCheckOutDate(getLastCheckOutDate());
		clone.setCirculationCount(getCirculationCount());
		clone.setRenewalCount(getRenewalCount());
		clone.setReservedCount(getReservedCount());
		clone.setCheckedOutDate(getCheckedOutDate());
		clone.setReservedBy(getReservedBy());
		clone.setClaimCount(getClaimCount());
		clone.setDueDate(getDueDate());
		clone.setCheckOutBy(getCheckOutBy());
		clone.setReleased(getReleased());
		clone.setReleaseDate(getReleaseDate());
		clone.setReleaseByUserId(getReleaseByUserId());
		clone.setVendorId(getVendorId());
		clone.setInvoiceId(getInvoiceId());
		clone.setPurchasePrice(getPurchasePrice());
		clone.setReplacementPrice(getReplacementPrice());
		clone.setCurrencyId(getCurrencyId());
		clone.setLocalPurchasePrice(getLocalPurchasePrice());
		clone.setPublicNote(getPublicNote());
		clone.setPrivateNote(getPrivateNote());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setAcquiredDate(getAcquiredDate());
		clone.setWorkflowStatus(getWorkflowStatus());

		return clone;
	}

	@Override
	public int compareTo(CatalogItem catalogItem) {
		long primaryKey = catalogItem.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CatalogItemClp)) {
			return false;
		}

		CatalogItemClp catalogItem = (CatalogItemClp)obj;

		long primaryKey = catalogItem.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(93);

		sb.append("{catalogItemId=");
		sb.append(getCatalogItemId());
		sb.append(", catalogId=");
		sb.append(getCatalogId());
		sb.append(", catalogTitle=");
		sb.append(getCatalogTitle());
		sb.append(", callNumber=");
		sb.append(getCallNumber());
		sb.append(", holdingLibraryId=");
		sb.append(getHoldingLibraryId());
		sb.append(", currentLibraryId=");
		sb.append(getCurrentLibraryId());
		sb.append(", barcode=");
		sb.append(getBarcode());
		sb.append(", copyNumber=");
		sb.append(getCopyNumber());
		sb.append(", locationId=");
		sb.append(getLocationId());
		sb.append(", itemCategoryId=");
		sb.append(getItemCategoryId());
		sb.append(", itemTypeId=");
		sb.append(getItemTypeId());
		sb.append(", withdrawnStatus=");
		sb.append(getWithdrawnStatus());
		sb.append(", lostStatus=");
		sb.append(getLostStatus());
		sb.append(", damageStatus=");
		sb.append(getDamageStatus());
		sb.append(", notForLoanStatus=");
		sb.append(getNotForLoanStatus());
		sb.append(", lastSeenDate=");
		sb.append(getLastSeenDate());
		sb.append(", withdrawnDate=");
		sb.append(getWithdrawnDate());
		sb.append(", lostDate=");
		sb.append(getLostDate());
		sb.append(", lastCheckOutDate=");
		sb.append(getLastCheckOutDate());
		sb.append(", circulationCount=");
		sb.append(getCirculationCount());
		sb.append(", renewalCount=");
		sb.append(getRenewalCount());
		sb.append(", reservedCount=");
		sb.append(getReservedCount());
		sb.append(", checkedOutDate=");
		sb.append(getCheckedOutDate());
		sb.append(", reservedBy=");
		sb.append(getReservedBy());
		sb.append(", claimCount=");
		sb.append(getClaimCount());
		sb.append(", dueDate=");
		sb.append(getDueDate());
		sb.append(", checkOutBy=");
		sb.append(getCheckOutBy());
		sb.append(", released=");
		sb.append(getReleased());
		sb.append(", releaseDate=");
		sb.append(getReleaseDate());
		sb.append(", releaseByUserId=");
		sb.append(getReleaseByUserId());
		sb.append(", vendorId=");
		sb.append(getVendorId());
		sb.append(", invoiceId=");
		sb.append(getInvoiceId());
		sb.append(", purchasePrice=");
		sb.append(getPurchasePrice());
		sb.append(", replacementPrice=");
		sb.append(getReplacementPrice());
		sb.append(", currencyId=");
		sb.append(getCurrencyId());
		sb.append(", localPurchasePrice=");
		sb.append(getLocalPurchasePrice());
		sb.append(", publicNote=");
		sb.append(getPublicNote());
		sb.append(", privateNote=");
		sb.append(getPrivateNote());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", acquiredDate=");
		sb.append(getAcquiredDate());
		sb.append(", workflowStatus=");
		sb.append(getWorkflowStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(142);

		sb.append("<model><model-name>");
		sb.append("com.kencana.lms.model.CatalogItem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>catalogItemId</column-name><column-value><![CDATA[");
		sb.append(getCatalogItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>catalogId</column-name><column-value><![CDATA[");
		sb.append(getCatalogId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>catalogTitle</column-name><column-value><![CDATA[");
		sb.append(getCatalogTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>callNumber</column-name><column-value><![CDATA[");
		sb.append(getCallNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>holdingLibraryId</column-name><column-value><![CDATA[");
		sb.append(getHoldingLibraryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentLibraryId</column-name><column-value><![CDATA[");
		sb.append(getCurrentLibraryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>barcode</column-name><column-value><![CDATA[");
		sb.append(getBarcode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>copyNumber</column-name><column-value><![CDATA[");
		sb.append(getCopyNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>locationId</column-name><column-value><![CDATA[");
		sb.append(getLocationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemCategoryId</column-name><column-value><![CDATA[");
		sb.append(getItemCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemTypeId</column-name><column-value><![CDATA[");
		sb.append(getItemTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>withdrawnStatus</column-name><column-value><![CDATA[");
		sb.append(getWithdrawnStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lostStatus</column-name><column-value><![CDATA[");
		sb.append(getLostStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>damageStatus</column-name><column-value><![CDATA[");
		sb.append(getDamageStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>notForLoanStatus</column-name><column-value><![CDATA[");
		sb.append(getNotForLoanStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastSeenDate</column-name><column-value><![CDATA[");
		sb.append(getLastSeenDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>withdrawnDate</column-name><column-value><![CDATA[");
		sb.append(getWithdrawnDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lostDate</column-name><column-value><![CDATA[");
		sb.append(getLostDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastCheckOutDate</column-name><column-value><![CDATA[");
		sb.append(getLastCheckOutDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>circulationCount</column-name><column-value><![CDATA[");
		sb.append(getCirculationCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>renewalCount</column-name><column-value><![CDATA[");
		sb.append(getRenewalCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reservedCount</column-name><column-value><![CDATA[");
		sb.append(getReservedCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>checkedOutDate</column-name><column-value><![CDATA[");
		sb.append(getCheckedOutDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reservedBy</column-name><column-value><![CDATA[");
		sb.append(getReservedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>claimCount</column-name><column-value><![CDATA[");
		sb.append(getClaimCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dueDate</column-name><column-value><![CDATA[");
		sb.append(getDueDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>checkOutBy</column-name><column-value><![CDATA[");
		sb.append(getCheckOutBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>released</column-name><column-value><![CDATA[");
		sb.append(getReleased());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>releaseDate</column-name><column-value><![CDATA[");
		sb.append(getReleaseDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>releaseByUserId</column-name><column-value><![CDATA[");
		sb.append(getReleaseByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>vendorId</column-name><column-value><![CDATA[");
		sb.append(getVendorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>invoiceId</column-name><column-value><![CDATA[");
		sb.append(getInvoiceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>purchasePrice</column-name><column-value><![CDATA[");
		sb.append(getPurchasePrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>replacementPrice</column-name><column-value><![CDATA[");
		sb.append(getReplacementPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currencyId</column-name><column-value><![CDATA[");
		sb.append(getCurrencyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>localPurchasePrice</column-name><column-value><![CDATA[");
		sb.append(getLocalPurchasePrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publicNote</column-name><column-value><![CDATA[");
		sb.append(getPublicNote());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>privateNote</column-name><column-value><![CDATA[");
		sb.append(getPrivateNote());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>acquiredDate</column-name><column-value><![CDATA[");
		sb.append(getAcquiredDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workflowStatus</column-name><column-value><![CDATA[");
		sb.append(getWorkflowStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private String _releaseByUserUuid;
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
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _acquiredDate;
	private int _workflowStatus;
	private BaseModel<?> _catalogItemRemoteModel;
	private Class<?> _clpSerializerClass = com.kencana.lms.service.ClpSerializer.class;
}