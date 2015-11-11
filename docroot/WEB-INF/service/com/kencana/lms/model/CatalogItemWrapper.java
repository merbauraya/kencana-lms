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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CatalogItem}.
 * </p>
 *
 * @author Mazlan Mat
 * @see CatalogItem
 * @generated
 */
public class CatalogItemWrapper implements CatalogItem,
	ModelWrapper<CatalogItem> {
	public CatalogItemWrapper(CatalogItem catalogItem) {
		_catalogItem = catalogItem;
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

	/**
	* Returns the primary key of this catalog item.
	*
	* @return the primary key of this catalog item
	*/
	@Override
	public long getPrimaryKey() {
		return _catalogItem.getPrimaryKey();
	}

	/**
	* Sets the primary key of this catalog item.
	*
	* @param primaryKey the primary key of this catalog item
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_catalogItem.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the catalog item ID of this catalog item.
	*
	* @return the catalog item ID of this catalog item
	*/
	@Override
	public long getCatalogItemId() {
		return _catalogItem.getCatalogItemId();
	}

	/**
	* Sets the catalog item ID of this catalog item.
	*
	* @param catalogItemId the catalog item ID of this catalog item
	*/
	@Override
	public void setCatalogItemId(long catalogItemId) {
		_catalogItem.setCatalogItemId(catalogItemId);
	}

	/**
	* Returns the catalog ID of this catalog item.
	*
	* @return the catalog ID of this catalog item
	*/
	@Override
	public long getCatalogId() {
		return _catalogItem.getCatalogId();
	}

	/**
	* Sets the catalog ID of this catalog item.
	*
	* @param catalogId the catalog ID of this catalog item
	*/
	@Override
	public void setCatalogId(long catalogId) {
		_catalogItem.setCatalogId(catalogId);
	}

	/**
	* Returns the catalog title of this catalog item.
	*
	* @return the catalog title of this catalog item
	*/
	@Override
	public java.lang.String getCatalogTitle() {
		return _catalogItem.getCatalogTitle();
	}

	/**
	* Sets the catalog title of this catalog item.
	*
	* @param catalogTitle the catalog title of this catalog item
	*/
	@Override
	public void setCatalogTitle(java.lang.String catalogTitle) {
		_catalogItem.setCatalogTitle(catalogTitle);
	}

	/**
	* Returns the call number of this catalog item.
	*
	* @return the call number of this catalog item
	*/
	@Override
	public java.lang.String getCallNumber() {
		return _catalogItem.getCallNumber();
	}

	/**
	* Sets the call number of this catalog item.
	*
	* @param callNumber the call number of this catalog item
	*/
	@Override
	public void setCallNumber(java.lang.String callNumber) {
		_catalogItem.setCallNumber(callNumber);
	}

	/**
	* Returns the holding library ID of this catalog item.
	*
	* @return the holding library ID of this catalog item
	*/
	@Override
	public long getHoldingLibraryId() {
		return _catalogItem.getHoldingLibraryId();
	}

	/**
	* Sets the holding library ID of this catalog item.
	*
	* @param holdingLibraryId the holding library ID of this catalog item
	*/
	@Override
	public void setHoldingLibraryId(long holdingLibraryId) {
		_catalogItem.setHoldingLibraryId(holdingLibraryId);
	}

	/**
	* Returns the current library ID of this catalog item.
	*
	* @return the current library ID of this catalog item
	*/
	@Override
	public long getCurrentLibraryId() {
		return _catalogItem.getCurrentLibraryId();
	}

	/**
	* Sets the current library ID of this catalog item.
	*
	* @param currentLibraryId the current library ID of this catalog item
	*/
	@Override
	public void setCurrentLibraryId(long currentLibraryId) {
		_catalogItem.setCurrentLibraryId(currentLibraryId);
	}

	/**
	* Returns the barcode of this catalog item.
	*
	* @return the barcode of this catalog item
	*/
	@Override
	public java.lang.String getBarcode() {
		return _catalogItem.getBarcode();
	}

	/**
	* Sets the barcode of this catalog item.
	*
	* @param barcode the barcode of this catalog item
	*/
	@Override
	public void setBarcode(java.lang.String barcode) {
		_catalogItem.setBarcode(barcode);
	}

	/**
	* Returns the copy number of this catalog item.
	*
	* @return the copy number of this catalog item
	*/
	@Override
	public int getCopyNumber() {
		return _catalogItem.getCopyNumber();
	}

	/**
	* Sets the copy number of this catalog item.
	*
	* @param copyNumber the copy number of this catalog item
	*/
	@Override
	public void setCopyNumber(int copyNumber) {
		_catalogItem.setCopyNumber(copyNumber);
	}

	/**
	* Returns the location ID of this catalog item.
	*
	* @return the location ID of this catalog item
	*/
	@Override
	public long getLocationId() {
		return _catalogItem.getLocationId();
	}

	/**
	* Sets the location ID of this catalog item.
	*
	* @param locationId the location ID of this catalog item
	*/
	@Override
	public void setLocationId(long locationId) {
		_catalogItem.setLocationId(locationId);
	}

	/**
	* Returns the item category ID of this catalog item.
	*
	* @return the item category ID of this catalog item
	*/
	@Override
	public long getItemCategoryId() {
		return _catalogItem.getItemCategoryId();
	}

	/**
	* Sets the item category ID of this catalog item.
	*
	* @param itemCategoryId the item category ID of this catalog item
	*/
	@Override
	public void setItemCategoryId(long itemCategoryId) {
		_catalogItem.setItemCategoryId(itemCategoryId);
	}

	/**
	* Returns the item type ID of this catalog item.
	*
	* @return the item type ID of this catalog item
	*/
	@Override
	public long getItemTypeId() {
		return _catalogItem.getItemTypeId();
	}

	/**
	* Sets the item type ID of this catalog item.
	*
	* @param itemTypeId the item type ID of this catalog item
	*/
	@Override
	public void setItemTypeId(long itemTypeId) {
		_catalogItem.setItemTypeId(itemTypeId);
	}

	/**
	* Returns the withdrawn status of this catalog item.
	*
	* @return the withdrawn status of this catalog item
	*/
	@Override
	public boolean getWithdrawnStatus() {
		return _catalogItem.getWithdrawnStatus();
	}

	/**
	* Returns <code>true</code> if this catalog item is withdrawn status.
	*
	* @return <code>true</code> if this catalog item is withdrawn status; <code>false</code> otherwise
	*/
	@Override
	public boolean isWithdrawnStatus() {
		return _catalogItem.isWithdrawnStatus();
	}

	/**
	* Sets whether this catalog item is withdrawn status.
	*
	* @param withdrawnStatus the withdrawn status of this catalog item
	*/
	@Override
	public void setWithdrawnStatus(boolean withdrawnStatus) {
		_catalogItem.setWithdrawnStatus(withdrawnStatus);
	}

	/**
	* Returns the lost status of this catalog item.
	*
	* @return the lost status of this catalog item
	*/
	@Override
	public boolean getLostStatus() {
		return _catalogItem.getLostStatus();
	}

	/**
	* Returns <code>true</code> if this catalog item is lost status.
	*
	* @return <code>true</code> if this catalog item is lost status; <code>false</code> otherwise
	*/
	@Override
	public boolean isLostStatus() {
		return _catalogItem.isLostStatus();
	}

	/**
	* Sets whether this catalog item is lost status.
	*
	* @param lostStatus the lost status of this catalog item
	*/
	@Override
	public void setLostStatus(boolean lostStatus) {
		_catalogItem.setLostStatus(lostStatus);
	}

	/**
	* Returns the damage status of this catalog item.
	*
	* @return the damage status of this catalog item
	*/
	@Override
	public boolean getDamageStatus() {
		return _catalogItem.getDamageStatus();
	}

	/**
	* Returns <code>true</code> if this catalog item is damage status.
	*
	* @return <code>true</code> if this catalog item is damage status; <code>false</code> otherwise
	*/
	@Override
	public boolean isDamageStatus() {
		return _catalogItem.isDamageStatus();
	}

	/**
	* Sets whether this catalog item is damage status.
	*
	* @param damageStatus the damage status of this catalog item
	*/
	@Override
	public void setDamageStatus(boolean damageStatus) {
		_catalogItem.setDamageStatus(damageStatus);
	}

	/**
	* Returns the not for loan status of this catalog item.
	*
	* @return the not for loan status of this catalog item
	*/
	@Override
	public boolean getNotForLoanStatus() {
		return _catalogItem.getNotForLoanStatus();
	}

	/**
	* Returns <code>true</code> if this catalog item is not for loan status.
	*
	* @return <code>true</code> if this catalog item is not for loan status; <code>false</code> otherwise
	*/
	@Override
	public boolean isNotForLoanStatus() {
		return _catalogItem.isNotForLoanStatus();
	}

	/**
	* Sets whether this catalog item is not for loan status.
	*
	* @param notForLoanStatus the not for loan status of this catalog item
	*/
	@Override
	public void setNotForLoanStatus(boolean notForLoanStatus) {
		_catalogItem.setNotForLoanStatus(notForLoanStatus);
	}

	/**
	* Returns the last seen date of this catalog item.
	*
	* @return the last seen date of this catalog item
	*/
	@Override
	public java.util.Date getLastSeenDate() {
		return _catalogItem.getLastSeenDate();
	}

	/**
	* Sets the last seen date of this catalog item.
	*
	* @param lastSeenDate the last seen date of this catalog item
	*/
	@Override
	public void setLastSeenDate(java.util.Date lastSeenDate) {
		_catalogItem.setLastSeenDate(lastSeenDate);
	}

	/**
	* Returns the withdrawn date of this catalog item.
	*
	* @return the withdrawn date of this catalog item
	*/
	@Override
	public java.util.Date getWithdrawnDate() {
		return _catalogItem.getWithdrawnDate();
	}

	/**
	* Sets the withdrawn date of this catalog item.
	*
	* @param withdrawnDate the withdrawn date of this catalog item
	*/
	@Override
	public void setWithdrawnDate(java.util.Date withdrawnDate) {
		_catalogItem.setWithdrawnDate(withdrawnDate);
	}

	/**
	* Returns the lost date of this catalog item.
	*
	* @return the lost date of this catalog item
	*/
	@Override
	public java.util.Date getLostDate() {
		return _catalogItem.getLostDate();
	}

	/**
	* Sets the lost date of this catalog item.
	*
	* @param lostDate the lost date of this catalog item
	*/
	@Override
	public void setLostDate(java.util.Date lostDate) {
		_catalogItem.setLostDate(lostDate);
	}

	/**
	* Returns the last check out date of this catalog item.
	*
	* @return the last check out date of this catalog item
	*/
	@Override
	public java.util.Date getLastCheckOutDate() {
		return _catalogItem.getLastCheckOutDate();
	}

	/**
	* Sets the last check out date of this catalog item.
	*
	* @param lastCheckOutDate the last check out date of this catalog item
	*/
	@Override
	public void setLastCheckOutDate(java.util.Date lastCheckOutDate) {
		_catalogItem.setLastCheckOutDate(lastCheckOutDate);
	}

	/**
	* Returns the circulation count of this catalog item.
	*
	* @return the circulation count of this catalog item
	*/
	@Override
	public int getCirculationCount() {
		return _catalogItem.getCirculationCount();
	}

	/**
	* Sets the circulation count of this catalog item.
	*
	* @param circulationCount the circulation count of this catalog item
	*/
	@Override
	public void setCirculationCount(int circulationCount) {
		_catalogItem.setCirculationCount(circulationCount);
	}

	/**
	* Returns the renewal count of this catalog item.
	*
	* @return the renewal count of this catalog item
	*/
	@Override
	public int getRenewalCount() {
		return _catalogItem.getRenewalCount();
	}

	/**
	* Sets the renewal count of this catalog item.
	*
	* @param renewalCount the renewal count of this catalog item
	*/
	@Override
	public void setRenewalCount(int renewalCount) {
		_catalogItem.setRenewalCount(renewalCount);
	}

	/**
	* Returns the reserved count of this catalog item.
	*
	* @return the reserved count of this catalog item
	*/
	@Override
	public int getReservedCount() {
		return _catalogItem.getReservedCount();
	}

	/**
	* Sets the reserved count of this catalog item.
	*
	* @param reservedCount the reserved count of this catalog item
	*/
	@Override
	public void setReservedCount(int reservedCount) {
		_catalogItem.setReservedCount(reservedCount);
	}

	/**
	* Returns the checked out date of this catalog item.
	*
	* @return the checked out date of this catalog item
	*/
	@Override
	public java.util.Date getCheckedOutDate() {
		return _catalogItem.getCheckedOutDate();
	}

	/**
	* Sets the checked out date of this catalog item.
	*
	* @param checkedOutDate the checked out date of this catalog item
	*/
	@Override
	public void setCheckedOutDate(java.util.Date checkedOutDate) {
		_catalogItem.setCheckedOutDate(checkedOutDate);
	}

	/**
	* Returns the reserved by of this catalog item.
	*
	* @return the reserved by of this catalog item
	*/
	@Override
	public long getReservedBy() {
		return _catalogItem.getReservedBy();
	}

	/**
	* Sets the reserved by of this catalog item.
	*
	* @param reservedBy the reserved by of this catalog item
	*/
	@Override
	public void setReservedBy(long reservedBy) {
		_catalogItem.setReservedBy(reservedBy);
	}

	/**
	* Returns the claim count of this catalog item.
	*
	* @return the claim count of this catalog item
	*/
	@Override
	public java.lang.Double getClaimCount() {
		return _catalogItem.getClaimCount();
	}

	/**
	* Sets the claim count of this catalog item.
	*
	* @param claimCount the claim count of this catalog item
	*/
	@Override
	public void setClaimCount(java.lang.Double claimCount) {
		_catalogItem.setClaimCount(claimCount);
	}

	/**
	* Returns the due date of this catalog item.
	*
	* @return the due date of this catalog item
	*/
	@Override
	public java.util.Date getDueDate() {
		return _catalogItem.getDueDate();
	}

	/**
	* Sets the due date of this catalog item.
	*
	* @param dueDate the due date of this catalog item
	*/
	@Override
	public void setDueDate(java.util.Date dueDate) {
		_catalogItem.setDueDate(dueDate);
	}

	/**
	* Returns the check out by of this catalog item.
	*
	* @return the check out by of this catalog item
	*/
	@Override
	public long getCheckOutBy() {
		return _catalogItem.getCheckOutBy();
	}

	/**
	* Sets the check out by of this catalog item.
	*
	* @param checkOutBy the check out by of this catalog item
	*/
	@Override
	public void setCheckOutBy(long checkOutBy) {
		_catalogItem.setCheckOutBy(checkOutBy);
	}

	/**
	* Returns the released of this catalog item.
	*
	* @return the released of this catalog item
	*/
	@Override
	public boolean getReleased() {
		return _catalogItem.getReleased();
	}

	/**
	* Returns <code>true</code> if this catalog item is released.
	*
	* @return <code>true</code> if this catalog item is released; <code>false</code> otherwise
	*/
	@Override
	public boolean isReleased() {
		return _catalogItem.isReleased();
	}

	/**
	* Sets whether this catalog item is released.
	*
	* @param released the released of this catalog item
	*/
	@Override
	public void setReleased(boolean released) {
		_catalogItem.setReleased(released);
	}

	/**
	* Returns the release date of this catalog item.
	*
	* @return the release date of this catalog item
	*/
	@Override
	public java.util.Date getReleaseDate() {
		return _catalogItem.getReleaseDate();
	}

	/**
	* Sets the release date of this catalog item.
	*
	* @param releaseDate the release date of this catalog item
	*/
	@Override
	public void setReleaseDate(java.util.Date releaseDate) {
		_catalogItem.setReleaseDate(releaseDate);
	}

	/**
	* Returns the release by user ID of this catalog item.
	*
	* @return the release by user ID of this catalog item
	*/
	@Override
	public long getReleaseByUserId() {
		return _catalogItem.getReleaseByUserId();
	}

	/**
	* Sets the release by user ID of this catalog item.
	*
	* @param releaseByUserId the release by user ID of this catalog item
	*/
	@Override
	public void setReleaseByUserId(long releaseByUserId) {
		_catalogItem.setReleaseByUserId(releaseByUserId);
	}

	/**
	* Returns the release by user uuid of this catalog item.
	*
	* @return the release by user uuid of this catalog item
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getReleaseByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogItem.getReleaseByUserUuid();
	}

	/**
	* Sets the release by user uuid of this catalog item.
	*
	* @param releaseByUserUuid the release by user uuid of this catalog item
	*/
	@Override
	public void setReleaseByUserUuid(java.lang.String releaseByUserUuid) {
		_catalogItem.setReleaseByUserUuid(releaseByUserUuid);
	}

	/**
	* Returns the vendor ID of this catalog item.
	*
	* @return the vendor ID of this catalog item
	*/
	@Override
	public long getVendorId() {
		return _catalogItem.getVendorId();
	}

	/**
	* Sets the vendor ID of this catalog item.
	*
	* @param vendorId the vendor ID of this catalog item
	*/
	@Override
	public void setVendorId(long vendorId) {
		_catalogItem.setVendorId(vendorId);
	}

	/**
	* Returns the invoice ID of this catalog item.
	*
	* @return the invoice ID of this catalog item
	*/
	@Override
	public long getInvoiceId() {
		return _catalogItem.getInvoiceId();
	}

	/**
	* Sets the invoice ID of this catalog item.
	*
	* @param invoiceId the invoice ID of this catalog item
	*/
	@Override
	public void setInvoiceId(long invoiceId) {
		_catalogItem.setInvoiceId(invoiceId);
	}

	/**
	* Returns the purchase price of this catalog item.
	*
	* @return the purchase price of this catalog item
	*/
	@Override
	public double getPurchasePrice() {
		return _catalogItem.getPurchasePrice();
	}

	/**
	* Sets the purchase price of this catalog item.
	*
	* @param purchasePrice the purchase price of this catalog item
	*/
	@Override
	public void setPurchasePrice(double purchasePrice) {
		_catalogItem.setPurchasePrice(purchasePrice);
	}

	/**
	* Returns the replacement price of this catalog item.
	*
	* @return the replacement price of this catalog item
	*/
	@Override
	public double getReplacementPrice() {
		return _catalogItem.getReplacementPrice();
	}

	/**
	* Sets the replacement price of this catalog item.
	*
	* @param replacementPrice the replacement price of this catalog item
	*/
	@Override
	public void setReplacementPrice(double replacementPrice) {
		_catalogItem.setReplacementPrice(replacementPrice);
	}

	/**
	* Returns the currency ID of this catalog item.
	*
	* @return the currency ID of this catalog item
	*/
	@Override
	public long getCurrencyId() {
		return _catalogItem.getCurrencyId();
	}

	/**
	* Sets the currency ID of this catalog item.
	*
	* @param currencyId the currency ID of this catalog item
	*/
	@Override
	public void setCurrencyId(long currencyId) {
		_catalogItem.setCurrencyId(currencyId);
	}

	/**
	* Returns the local purchase price of this catalog item.
	*
	* @return the local purchase price of this catalog item
	*/
	@Override
	public double getLocalPurchasePrice() {
		return _catalogItem.getLocalPurchasePrice();
	}

	/**
	* Sets the local purchase price of this catalog item.
	*
	* @param localPurchasePrice the local purchase price of this catalog item
	*/
	@Override
	public void setLocalPurchasePrice(double localPurchasePrice) {
		_catalogItem.setLocalPurchasePrice(localPurchasePrice);
	}

	/**
	* Returns the public note of this catalog item.
	*
	* @return the public note of this catalog item
	*/
	@Override
	public java.lang.String getPublicNote() {
		return _catalogItem.getPublicNote();
	}

	/**
	* Sets the public note of this catalog item.
	*
	* @param publicNote the public note of this catalog item
	*/
	@Override
	public void setPublicNote(java.lang.String publicNote) {
		_catalogItem.setPublicNote(publicNote);
	}

	/**
	* Returns the private note of this catalog item.
	*
	* @return the private note of this catalog item
	*/
	@Override
	public java.lang.String getPrivateNote() {
		return _catalogItem.getPrivateNote();
	}

	/**
	* Sets the private note of this catalog item.
	*
	* @param privateNote the private note of this catalog item
	*/
	@Override
	public void setPrivateNote(java.lang.String privateNote) {
		_catalogItem.setPrivateNote(privateNote);
	}

	/**
	* Returns the company ID of this catalog item.
	*
	* @return the company ID of this catalog item
	*/
	@Override
	public long getCompanyId() {
		return _catalogItem.getCompanyId();
	}

	/**
	* Sets the company ID of this catalog item.
	*
	* @param companyId the company ID of this catalog item
	*/
	@Override
	public void setCompanyId(long companyId) {
		_catalogItem.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this catalog item.
	*
	* @return the group ID of this catalog item
	*/
	@Override
	public long getGroupId() {
		return _catalogItem.getGroupId();
	}

	/**
	* Sets the group ID of this catalog item.
	*
	* @param groupId the group ID of this catalog item
	*/
	@Override
	public void setGroupId(long groupId) {
		_catalogItem.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this catalog item.
	*
	* @return the user ID of this catalog item
	*/
	@Override
	public long getUserId() {
		return _catalogItem.getUserId();
	}

	/**
	* Sets the user ID of this catalog item.
	*
	* @param userId the user ID of this catalog item
	*/
	@Override
	public void setUserId(long userId) {
		_catalogItem.setUserId(userId);
	}

	/**
	* Returns the user uuid of this catalog item.
	*
	* @return the user uuid of this catalog item
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalogItem.getUserUuid();
	}

	/**
	* Sets the user uuid of this catalog item.
	*
	* @param userUuid the user uuid of this catalog item
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_catalogItem.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this catalog item.
	*
	* @return the user name of this catalog item
	*/
	@Override
	public java.lang.String getUserName() {
		return _catalogItem.getUserName();
	}

	/**
	* Sets the user name of this catalog item.
	*
	* @param userName the user name of this catalog item
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_catalogItem.setUserName(userName);
	}

	/**
	* Returns the create date of this catalog item.
	*
	* @return the create date of this catalog item
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _catalogItem.getCreateDate();
	}

	/**
	* Sets the create date of this catalog item.
	*
	* @param createDate the create date of this catalog item
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_catalogItem.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this catalog item.
	*
	* @return the modified date of this catalog item
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _catalogItem.getModifiedDate();
	}

	/**
	* Sets the modified date of this catalog item.
	*
	* @param modifiedDate the modified date of this catalog item
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_catalogItem.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the acquired date of this catalog item.
	*
	* @return the acquired date of this catalog item
	*/
	@Override
	public java.util.Date getAcquiredDate() {
		return _catalogItem.getAcquiredDate();
	}

	/**
	* Sets the acquired date of this catalog item.
	*
	* @param acquiredDate the acquired date of this catalog item
	*/
	@Override
	public void setAcquiredDate(java.util.Date acquiredDate) {
		_catalogItem.setAcquiredDate(acquiredDate);
	}

	/**
	* Returns the workflow status of this catalog item.
	*
	* @return the workflow status of this catalog item
	*/
	@Override
	public int getWorkflowStatus() {
		return _catalogItem.getWorkflowStatus();
	}

	/**
	* Sets the workflow status of this catalog item.
	*
	* @param workflowStatus the workflow status of this catalog item
	*/
	@Override
	public void setWorkflowStatus(int workflowStatus) {
		_catalogItem.setWorkflowStatus(workflowStatus);
	}

	@Override
	public boolean isNew() {
		return _catalogItem.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_catalogItem.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _catalogItem.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_catalogItem.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _catalogItem.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _catalogItem.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_catalogItem.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _catalogItem.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_catalogItem.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_catalogItem.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_catalogItem.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CatalogItemWrapper((CatalogItem)_catalogItem.clone());
	}

	@Override
	public int compareTo(com.kencana.lms.model.CatalogItem catalogItem) {
		return _catalogItem.compareTo(catalogItem);
	}

	@Override
	public int hashCode() {
		return _catalogItem.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.kencana.lms.model.CatalogItem> toCacheModel() {
		return _catalogItem.toCacheModel();
	}

	@Override
	public com.kencana.lms.model.CatalogItem toEscapedModel() {
		return new CatalogItemWrapper(_catalogItem.toEscapedModel());
	}

	@Override
	public com.kencana.lms.model.CatalogItem toUnescapedModel() {
		return new CatalogItemWrapper(_catalogItem.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _catalogItem.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _catalogItem.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_catalogItem.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CatalogItemWrapper)) {
			return false;
		}

		CatalogItemWrapper catalogItemWrapper = (CatalogItemWrapper)obj;

		if (Validator.equals(_catalogItem, catalogItemWrapper._catalogItem)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CatalogItem getWrappedCatalogItem() {
		return _catalogItem;
	}

	@Override
	public CatalogItem getWrappedModel() {
		return _catalogItem;
	}

	@Override
	public void resetOriginalValues() {
		_catalogItem.resetOriginalValues();
	}

	private CatalogItem _catalogItem;
}