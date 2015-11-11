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
 * This class is a wrapper for {@link CircTransHistory}.
 * </p>
 *
 * @author Mazlan Mat
 * @see CircTransHistory
 * @generated
 */
public class CircTransHistoryWrapper implements CircTransHistory,
	ModelWrapper<CircTransHistory> {
	public CircTransHistoryWrapper(CircTransHistory circTransHistory) {
		_circTransHistory = circTransHistory;
	}

	@Override
	public Class<?> getModelClass() {
		return CircTransHistory.class;
	}

	@Override
	public String getModelClassName() {
		return CircTransHistory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("transId", getTransId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("patronId", getPatronId());
		attributes.put("catalogItemId", getCatalogItemId());
		attributes.put("transDate", getTransDate());
		attributes.put("dueDate", getDueDate());
		attributes.put("overdue", getOverdue());
		attributes.put("returnDate", getReturnDate());
		attributes.put("lastRenewDate", getLastRenewDate());
		attributes.put("renewCount", getRenewCount());
		attributes.put("fineAmount", getFineAmount());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long transId = (Long)attributes.get("transId");

		if (transId != null) {
			setTransId(transId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		Long patronId = (Long)attributes.get("patronId");

		if (patronId != null) {
			setPatronId(patronId);
		}

		Long catalogItemId = (Long)attributes.get("catalogItemId");

		if (catalogItemId != null) {
			setCatalogItemId(catalogItemId);
		}

		Date transDate = (Date)attributes.get("transDate");

		if (transDate != null) {
			setTransDate(transDate);
		}

		Date dueDate = (Date)attributes.get("dueDate");

		if (dueDate != null) {
			setDueDate(dueDate);
		}

		Boolean overdue = (Boolean)attributes.get("overdue");

		if (overdue != null) {
			setOverdue(overdue);
		}

		Date returnDate = (Date)attributes.get("returnDate");

		if (returnDate != null) {
			setReturnDate(returnDate);
		}

		Date lastRenewDate = (Date)attributes.get("lastRenewDate");

		if (lastRenewDate != null) {
			setLastRenewDate(lastRenewDate);
		}

		Integer renewCount = (Integer)attributes.get("renewCount");

		if (renewCount != null) {
			setRenewCount(renewCount);
		}

		Double fineAmount = (Double)attributes.get("fineAmount");

		if (fineAmount != null) {
			setFineAmount(fineAmount);
		}
	}

	/**
	* Returns the primary key of this circ trans history.
	*
	* @return the primary key of this circ trans history
	*/
	@Override
	public long getPrimaryKey() {
		return _circTransHistory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this circ trans history.
	*
	* @param primaryKey the primary key of this circ trans history
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_circTransHistory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the trans ID of this circ trans history.
	*
	* @return the trans ID of this circ trans history
	*/
	@Override
	public long getTransId() {
		return _circTransHistory.getTransId();
	}

	/**
	* Sets the trans ID of this circ trans history.
	*
	* @param transId the trans ID of this circ trans history
	*/
	@Override
	public void setTransId(long transId) {
		_circTransHistory.setTransId(transId);
	}

	/**
	* Returns the company ID of this circ trans history.
	*
	* @return the company ID of this circ trans history
	*/
	@Override
	public long getCompanyId() {
		return _circTransHistory.getCompanyId();
	}

	/**
	* Sets the company ID of this circ trans history.
	*
	* @param companyId the company ID of this circ trans history
	*/
	@Override
	public void setCompanyId(long companyId) {
		_circTransHistory.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this circ trans history.
	*
	* @return the group ID of this circ trans history
	*/
	@Override
	public long getGroupId() {
		return _circTransHistory.getGroupId();
	}

	/**
	* Sets the group ID of this circ trans history.
	*
	* @param groupId the group ID of this circ trans history
	*/
	@Override
	public void setGroupId(long groupId) {
		_circTransHistory.setGroupId(groupId);
	}

	/**
	* Returns the library ID of this circ trans history.
	*
	* @return the library ID of this circ trans history
	*/
	@Override
	public long getLibraryId() {
		return _circTransHistory.getLibraryId();
	}

	/**
	* Sets the library ID of this circ trans history.
	*
	* @param libraryId the library ID of this circ trans history
	*/
	@Override
	public void setLibraryId(long libraryId) {
		_circTransHistory.setLibraryId(libraryId);
	}

	/**
	* Returns the patron ID of this circ trans history.
	*
	* @return the patron ID of this circ trans history
	*/
	@Override
	public long getPatronId() {
		return _circTransHistory.getPatronId();
	}

	/**
	* Sets the patron ID of this circ trans history.
	*
	* @param patronId the patron ID of this circ trans history
	*/
	@Override
	public void setPatronId(long patronId) {
		_circTransHistory.setPatronId(patronId);
	}

	/**
	* Returns the catalog item ID of this circ trans history.
	*
	* @return the catalog item ID of this circ trans history
	*/
	@Override
	public long getCatalogItemId() {
		return _circTransHistory.getCatalogItemId();
	}

	/**
	* Sets the catalog item ID of this circ trans history.
	*
	* @param catalogItemId the catalog item ID of this circ trans history
	*/
	@Override
	public void setCatalogItemId(long catalogItemId) {
		_circTransHistory.setCatalogItemId(catalogItemId);
	}

	/**
	* Returns the trans date of this circ trans history.
	*
	* @return the trans date of this circ trans history
	*/
	@Override
	public java.util.Date getTransDate() {
		return _circTransHistory.getTransDate();
	}

	/**
	* Sets the trans date of this circ trans history.
	*
	* @param transDate the trans date of this circ trans history
	*/
	@Override
	public void setTransDate(java.util.Date transDate) {
		_circTransHistory.setTransDate(transDate);
	}

	/**
	* Returns the due date of this circ trans history.
	*
	* @return the due date of this circ trans history
	*/
	@Override
	public java.util.Date getDueDate() {
		return _circTransHistory.getDueDate();
	}

	/**
	* Sets the due date of this circ trans history.
	*
	* @param dueDate the due date of this circ trans history
	*/
	@Override
	public void setDueDate(java.util.Date dueDate) {
		_circTransHistory.setDueDate(dueDate);
	}

	/**
	* Returns the overdue of this circ trans history.
	*
	* @return the overdue of this circ trans history
	*/
	@Override
	public boolean getOverdue() {
		return _circTransHistory.getOverdue();
	}

	/**
	* Returns <code>true</code> if this circ trans history is overdue.
	*
	* @return <code>true</code> if this circ trans history is overdue; <code>false</code> otherwise
	*/
	@Override
	public boolean isOverdue() {
		return _circTransHistory.isOverdue();
	}

	/**
	* Sets whether this circ trans history is overdue.
	*
	* @param overdue the overdue of this circ trans history
	*/
	@Override
	public void setOverdue(boolean overdue) {
		_circTransHistory.setOverdue(overdue);
	}

	/**
	* Returns the return date of this circ trans history.
	*
	* @return the return date of this circ trans history
	*/
	@Override
	public java.util.Date getReturnDate() {
		return _circTransHistory.getReturnDate();
	}

	/**
	* Sets the return date of this circ trans history.
	*
	* @param returnDate the return date of this circ trans history
	*/
	@Override
	public void setReturnDate(java.util.Date returnDate) {
		_circTransHistory.setReturnDate(returnDate);
	}

	/**
	* Returns the last renew date of this circ trans history.
	*
	* @return the last renew date of this circ trans history
	*/
	@Override
	public java.util.Date getLastRenewDate() {
		return _circTransHistory.getLastRenewDate();
	}

	/**
	* Sets the last renew date of this circ trans history.
	*
	* @param lastRenewDate the last renew date of this circ trans history
	*/
	@Override
	public void setLastRenewDate(java.util.Date lastRenewDate) {
		_circTransHistory.setLastRenewDate(lastRenewDate);
	}

	/**
	* Returns the renew count of this circ trans history.
	*
	* @return the renew count of this circ trans history
	*/
	@Override
	public int getRenewCount() {
		return _circTransHistory.getRenewCount();
	}

	/**
	* Sets the renew count of this circ trans history.
	*
	* @param renewCount the renew count of this circ trans history
	*/
	@Override
	public void setRenewCount(int renewCount) {
		_circTransHistory.setRenewCount(renewCount);
	}

	/**
	* Returns the fine amount of this circ trans history.
	*
	* @return the fine amount of this circ trans history
	*/
	@Override
	public java.lang.Double getFineAmount() {
		return _circTransHistory.getFineAmount();
	}

	/**
	* Sets the fine amount of this circ trans history.
	*
	* @param fineAmount the fine amount of this circ trans history
	*/
	@Override
	public void setFineAmount(java.lang.Double fineAmount) {
		_circTransHistory.setFineAmount(fineAmount);
	}

	@Override
	public boolean isNew() {
		return _circTransHistory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_circTransHistory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _circTransHistory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_circTransHistory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _circTransHistory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _circTransHistory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_circTransHistory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _circTransHistory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_circTransHistory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_circTransHistory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_circTransHistory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CircTransHistoryWrapper((CircTransHistory)_circTransHistory.clone());
	}

	@Override
	public int compareTo(
		com.kencana.lms.model.CircTransHistory circTransHistory) {
		return _circTransHistory.compareTo(circTransHistory);
	}

	@Override
	public int hashCode() {
		return _circTransHistory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.kencana.lms.model.CircTransHistory> toCacheModel() {
		return _circTransHistory.toCacheModel();
	}

	@Override
	public com.kencana.lms.model.CircTransHistory toEscapedModel() {
		return new CircTransHistoryWrapper(_circTransHistory.toEscapedModel());
	}

	@Override
	public com.kencana.lms.model.CircTransHistory toUnescapedModel() {
		return new CircTransHistoryWrapper(_circTransHistory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _circTransHistory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _circTransHistory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_circTransHistory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CircTransHistoryWrapper)) {
			return false;
		}

		CircTransHistoryWrapper circTransHistoryWrapper = (CircTransHistoryWrapper)obj;

		if (Validator.equals(_circTransHistory,
					circTransHistoryWrapper._circTransHistory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CircTransHistory getWrappedCircTransHistory() {
		return _circTransHistory;
	}

	@Override
	public CircTransHistory getWrappedModel() {
		return _circTransHistory;
	}

	@Override
	public void resetOriginalValues() {
		_circTransHistory.resetOriginalValues();
	}

	private CircTransHistory _circTransHistory;
}