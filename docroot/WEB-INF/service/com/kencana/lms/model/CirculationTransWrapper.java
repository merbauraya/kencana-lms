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
 * This class is a wrapper for {@link CirculationTrans}.
 * </p>
 *
 * @author Mazlan Mat
 * @see CirculationTrans
 * @generated
 */
public class CirculationTransWrapper implements CirculationTrans,
	ModelWrapper<CirculationTrans> {
	public CirculationTransWrapper(CirculationTrans circulationTrans) {
		_circulationTrans = circulationTrans;
	}

	@Override
	public Class<?> getModelClass() {
		return CirculationTrans.class;
	}

	@Override
	public String getModelClassName() {
		return CirculationTrans.class.getName();
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
	}

	/**
	* Returns the primary key of this circulation trans.
	*
	* @return the primary key of this circulation trans
	*/
	@Override
	public long getPrimaryKey() {
		return _circulationTrans.getPrimaryKey();
	}

	/**
	* Sets the primary key of this circulation trans.
	*
	* @param primaryKey the primary key of this circulation trans
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_circulationTrans.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the trans ID of this circulation trans.
	*
	* @return the trans ID of this circulation trans
	*/
	@Override
	public long getTransId() {
		return _circulationTrans.getTransId();
	}

	/**
	* Sets the trans ID of this circulation trans.
	*
	* @param transId the trans ID of this circulation trans
	*/
	@Override
	public void setTransId(long transId) {
		_circulationTrans.setTransId(transId);
	}

	/**
	* Returns the company ID of this circulation trans.
	*
	* @return the company ID of this circulation trans
	*/
	@Override
	public long getCompanyId() {
		return _circulationTrans.getCompanyId();
	}

	/**
	* Sets the company ID of this circulation trans.
	*
	* @param companyId the company ID of this circulation trans
	*/
	@Override
	public void setCompanyId(long companyId) {
		_circulationTrans.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this circulation trans.
	*
	* @return the group ID of this circulation trans
	*/
	@Override
	public long getGroupId() {
		return _circulationTrans.getGroupId();
	}

	/**
	* Sets the group ID of this circulation trans.
	*
	* @param groupId the group ID of this circulation trans
	*/
	@Override
	public void setGroupId(long groupId) {
		_circulationTrans.setGroupId(groupId);
	}

	/**
	* Returns the library ID of this circulation trans.
	*
	* @return the library ID of this circulation trans
	*/
	@Override
	public long getLibraryId() {
		return _circulationTrans.getLibraryId();
	}

	/**
	* Sets the library ID of this circulation trans.
	*
	* @param libraryId the library ID of this circulation trans
	*/
	@Override
	public void setLibraryId(long libraryId) {
		_circulationTrans.setLibraryId(libraryId);
	}

	/**
	* Returns the patron ID of this circulation trans.
	*
	* @return the patron ID of this circulation trans
	*/
	@Override
	public long getPatronId() {
		return _circulationTrans.getPatronId();
	}

	/**
	* Sets the patron ID of this circulation trans.
	*
	* @param patronId the patron ID of this circulation trans
	*/
	@Override
	public void setPatronId(long patronId) {
		_circulationTrans.setPatronId(patronId);
	}

	/**
	* Returns the catalog item ID of this circulation trans.
	*
	* @return the catalog item ID of this circulation trans
	*/
	@Override
	public long getCatalogItemId() {
		return _circulationTrans.getCatalogItemId();
	}

	/**
	* Sets the catalog item ID of this circulation trans.
	*
	* @param catalogItemId the catalog item ID of this circulation trans
	*/
	@Override
	public void setCatalogItemId(long catalogItemId) {
		_circulationTrans.setCatalogItemId(catalogItemId);
	}

	/**
	* Returns the trans date of this circulation trans.
	*
	* @return the trans date of this circulation trans
	*/
	@Override
	public java.util.Date getTransDate() {
		return _circulationTrans.getTransDate();
	}

	/**
	* Sets the trans date of this circulation trans.
	*
	* @param transDate the trans date of this circulation trans
	*/
	@Override
	public void setTransDate(java.util.Date transDate) {
		_circulationTrans.setTransDate(transDate);
	}

	/**
	* Returns the due date of this circulation trans.
	*
	* @return the due date of this circulation trans
	*/
	@Override
	public java.util.Date getDueDate() {
		return _circulationTrans.getDueDate();
	}

	/**
	* Sets the due date of this circulation trans.
	*
	* @param dueDate the due date of this circulation trans
	*/
	@Override
	public void setDueDate(java.util.Date dueDate) {
		_circulationTrans.setDueDate(dueDate);
	}

	/**
	* Returns the overdue of this circulation trans.
	*
	* @return the overdue of this circulation trans
	*/
	@Override
	public boolean getOverdue() {
		return _circulationTrans.getOverdue();
	}

	/**
	* Returns <code>true</code> if this circulation trans is overdue.
	*
	* @return <code>true</code> if this circulation trans is overdue; <code>false</code> otherwise
	*/
	@Override
	public boolean isOverdue() {
		return _circulationTrans.isOverdue();
	}

	/**
	* Sets whether this circulation trans is overdue.
	*
	* @param overdue the overdue of this circulation trans
	*/
	@Override
	public void setOverdue(boolean overdue) {
		_circulationTrans.setOverdue(overdue);
	}

	/**
	* Returns the return date of this circulation trans.
	*
	* @return the return date of this circulation trans
	*/
	@Override
	public java.util.Date getReturnDate() {
		return _circulationTrans.getReturnDate();
	}

	/**
	* Sets the return date of this circulation trans.
	*
	* @param returnDate the return date of this circulation trans
	*/
	@Override
	public void setReturnDate(java.util.Date returnDate) {
		_circulationTrans.setReturnDate(returnDate);
	}

	/**
	* Returns the last renew date of this circulation trans.
	*
	* @return the last renew date of this circulation trans
	*/
	@Override
	public java.util.Date getLastRenewDate() {
		return _circulationTrans.getLastRenewDate();
	}

	/**
	* Sets the last renew date of this circulation trans.
	*
	* @param lastRenewDate the last renew date of this circulation trans
	*/
	@Override
	public void setLastRenewDate(java.util.Date lastRenewDate) {
		_circulationTrans.setLastRenewDate(lastRenewDate);
	}

	/**
	* Returns the renew count of this circulation trans.
	*
	* @return the renew count of this circulation trans
	*/
	@Override
	public int getRenewCount() {
		return _circulationTrans.getRenewCount();
	}

	/**
	* Sets the renew count of this circulation trans.
	*
	* @param renewCount the renew count of this circulation trans
	*/
	@Override
	public void setRenewCount(int renewCount) {
		_circulationTrans.setRenewCount(renewCount);
	}

	@Override
	public boolean isNew() {
		return _circulationTrans.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_circulationTrans.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _circulationTrans.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_circulationTrans.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _circulationTrans.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _circulationTrans.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_circulationTrans.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _circulationTrans.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_circulationTrans.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_circulationTrans.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_circulationTrans.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CirculationTransWrapper((CirculationTrans)_circulationTrans.clone());
	}

	@Override
	public int compareTo(
		com.kencana.lms.model.CirculationTrans circulationTrans) {
		return _circulationTrans.compareTo(circulationTrans);
	}

	@Override
	public int hashCode() {
		return _circulationTrans.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.kencana.lms.model.CirculationTrans> toCacheModel() {
		return _circulationTrans.toCacheModel();
	}

	@Override
	public com.kencana.lms.model.CirculationTrans toEscapedModel() {
		return new CirculationTransWrapper(_circulationTrans.toEscapedModel());
	}

	@Override
	public com.kencana.lms.model.CirculationTrans toUnescapedModel() {
		return new CirculationTransWrapper(_circulationTrans.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _circulationTrans.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _circulationTrans.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_circulationTrans.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CirculationTransWrapper)) {
			return false;
		}

		CirculationTransWrapper circulationTransWrapper = (CirculationTransWrapper)obj;

		if (Validator.equals(_circulationTrans,
					circulationTransWrapper._circulationTrans)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CirculationTrans getWrappedCirculationTrans() {
		return _circulationTrans;
	}

	@Override
	public CirculationTrans getWrappedModel() {
		return _circulationTrans;
	}

	@Override
	public void resetOriginalValues() {
		_circulationTrans.resetOriginalValues();
	}

	private CirculationTrans _circulationTrans;
}