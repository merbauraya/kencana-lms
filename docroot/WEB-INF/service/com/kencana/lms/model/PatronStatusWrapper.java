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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PatronStatus}.
 * </p>
 *
 * @author Mazlan Mat
 * @see PatronStatus
 * @generated
 */
public class PatronStatusWrapper implements PatronStatus,
	ModelWrapper<PatronStatus> {
	public PatronStatusWrapper(PatronStatus patronStatus) {
		_patronStatus = patronStatus;
	}

	@Override
	public Class<?> getModelClass() {
		return PatronStatus.class;
	}

	@Override
	public String getModelClassName() {
		return PatronStatus.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("patronStatusId", getPatronStatusId());
		attributes.put("patronStatusName", getPatronStatusName());
		attributes.put("noLogin", getNoLogin());
		attributes.put("noCheckout", getNoCheckout());
		attributes.put("noReserve", getNoReserve());
		attributes.put("noRenew", getNoRenew());
		attributes.put("color", getColor());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long patronStatusId = (Long)attributes.get("patronStatusId");

		if (patronStatusId != null) {
			setPatronStatusId(patronStatusId);
		}

		String patronStatusName = (String)attributes.get("patronStatusName");

		if (patronStatusName != null) {
			setPatronStatusName(patronStatusName);
		}

		Boolean noLogin = (Boolean)attributes.get("noLogin");

		if (noLogin != null) {
			setNoLogin(noLogin);
		}

		Boolean noCheckout = (Boolean)attributes.get("noCheckout");

		if (noCheckout != null) {
			setNoCheckout(noCheckout);
		}

		Boolean noReserve = (Boolean)attributes.get("noReserve");

		if (noReserve != null) {
			setNoReserve(noReserve);
		}

		Boolean noRenew = (Boolean)attributes.get("noRenew");

		if (noRenew != null) {
			setNoRenew(noRenew);
		}

		Integer color = (Integer)attributes.get("color");

		if (color != null) {
			setColor(color);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}
	}

	/**
	* Returns the primary key of this patron status.
	*
	* @return the primary key of this patron status
	*/
	@Override
	public long getPrimaryKey() {
		return _patronStatus.getPrimaryKey();
	}

	/**
	* Sets the primary key of this patron status.
	*
	* @param primaryKey the primary key of this patron status
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_patronStatus.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the patron status ID of this patron status.
	*
	* @return the patron status ID of this patron status
	*/
	@Override
	public long getPatronStatusId() {
		return _patronStatus.getPatronStatusId();
	}

	/**
	* Sets the patron status ID of this patron status.
	*
	* @param patronStatusId the patron status ID of this patron status
	*/
	@Override
	public void setPatronStatusId(long patronStatusId) {
		_patronStatus.setPatronStatusId(patronStatusId);
	}

	/**
	* Returns the patron status name of this patron status.
	*
	* @return the patron status name of this patron status
	*/
	@Override
	public java.lang.String getPatronStatusName() {
		return _patronStatus.getPatronStatusName();
	}

	/**
	* Sets the patron status name of this patron status.
	*
	* @param patronStatusName the patron status name of this patron status
	*/
	@Override
	public void setPatronStatusName(java.lang.String patronStatusName) {
		_patronStatus.setPatronStatusName(patronStatusName);
	}

	/**
	* Returns the no login of this patron status.
	*
	* @return the no login of this patron status
	*/
	@Override
	public boolean getNoLogin() {
		return _patronStatus.getNoLogin();
	}

	/**
	* Returns <code>true</code> if this patron status is no login.
	*
	* @return <code>true</code> if this patron status is no login; <code>false</code> otherwise
	*/
	@Override
	public boolean isNoLogin() {
		return _patronStatus.isNoLogin();
	}

	/**
	* Sets whether this patron status is no login.
	*
	* @param noLogin the no login of this patron status
	*/
	@Override
	public void setNoLogin(boolean noLogin) {
		_patronStatus.setNoLogin(noLogin);
	}

	/**
	* Returns the no checkout of this patron status.
	*
	* @return the no checkout of this patron status
	*/
	@Override
	public boolean getNoCheckout() {
		return _patronStatus.getNoCheckout();
	}

	/**
	* Returns <code>true</code> if this patron status is no checkout.
	*
	* @return <code>true</code> if this patron status is no checkout; <code>false</code> otherwise
	*/
	@Override
	public boolean isNoCheckout() {
		return _patronStatus.isNoCheckout();
	}

	/**
	* Sets whether this patron status is no checkout.
	*
	* @param noCheckout the no checkout of this patron status
	*/
	@Override
	public void setNoCheckout(boolean noCheckout) {
		_patronStatus.setNoCheckout(noCheckout);
	}

	/**
	* Returns the no reserve of this patron status.
	*
	* @return the no reserve of this patron status
	*/
	@Override
	public boolean getNoReserve() {
		return _patronStatus.getNoReserve();
	}

	/**
	* Returns <code>true</code> if this patron status is no reserve.
	*
	* @return <code>true</code> if this patron status is no reserve; <code>false</code> otherwise
	*/
	@Override
	public boolean isNoReserve() {
		return _patronStatus.isNoReserve();
	}

	/**
	* Sets whether this patron status is no reserve.
	*
	* @param noReserve the no reserve of this patron status
	*/
	@Override
	public void setNoReserve(boolean noReserve) {
		_patronStatus.setNoReserve(noReserve);
	}

	/**
	* Returns the no renew of this patron status.
	*
	* @return the no renew of this patron status
	*/
	@Override
	public boolean getNoRenew() {
		return _patronStatus.getNoRenew();
	}

	/**
	* Returns <code>true</code> if this patron status is no renew.
	*
	* @return <code>true</code> if this patron status is no renew; <code>false</code> otherwise
	*/
	@Override
	public boolean isNoRenew() {
		return _patronStatus.isNoRenew();
	}

	/**
	* Sets whether this patron status is no renew.
	*
	* @param noRenew the no renew of this patron status
	*/
	@Override
	public void setNoRenew(boolean noRenew) {
		_patronStatus.setNoRenew(noRenew);
	}

	/**
	* Returns the color of this patron status.
	*
	* @return the color of this patron status
	*/
	@Override
	public int getColor() {
		return _patronStatus.getColor();
	}

	/**
	* Sets the color of this patron status.
	*
	* @param color the color of this patron status
	*/
	@Override
	public void setColor(int color) {
		_patronStatus.setColor(color);
	}

	/**
	* Returns the group ID of this patron status.
	*
	* @return the group ID of this patron status
	*/
	@Override
	public long getGroupId() {
		return _patronStatus.getGroupId();
	}

	/**
	* Sets the group ID of this patron status.
	*
	* @param groupId the group ID of this patron status
	*/
	@Override
	public void setGroupId(long groupId) {
		_patronStatus.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this patron status.
	*
	* @return the company ID of this patron status
	*/
	@Override
	public long getCompanyId() {
		return _patronStatus.getCompanyId();
	}

	/**
	* Sets the company ID of this patron status.
	*
	* @param companyId the company ID of this patron status
	*/
	@Override
	public void setCompanyId(long companyId) {
		_patronStatus.setCompanyId(companyId);
	}

	@Override
	public boolean isNew() {
		return _patronStatus.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_patronStatus.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _patronStatus.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_patronStatus.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _patronStatus.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _patronStatus.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_patronStatus.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _patronStatus.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_patronStatus.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_patronStatus.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_patronStatus.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PatronStatusWrapper((PatronStatus)_patronStatus.clone());
	}

	@Override
	public int compareTo(com.kencana.lms.model.PatronStatus patronStatus) {
		return _patronStatus.compareTo(patronStatus);
	}

	@Override
	public int hashCode() {
		return _patronStatus.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.kencana.lms.model.PatronStatus> toCacheModel() {
		return _patronStatus.toCacheModel();
	}

	@Override
	public com.kencana.lms.model.PatronStatus toEscapedModel() {
		return new PatronStatusWrapper(_patronStatus.toEscapedModel());
	}

	@Override
	public com.kencana.lms.model.PatronStatus toUnescapedModel() {
		return new PatronStatusWrapper(_patronStatus.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _patronStatus.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _patronStatus.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_patronStatus.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PatronStatusWrapper)) {
			return false;
		}

		PatronStatusWrapper patronStatusWrapper = (PatronStatusWrapper)obj;

		if (Validator.equals(_patronStatus, patronStatusWrapper._patronStatus)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PatronStatus getWrappedPatronStatus() {
		return _patronStatus;
	}

	@Override
	public PatronStatus getWrappedModel() {
		return _patronStatus;
	}

	@Override
	public void resetOriginalValues() {
		_patronStatus.resetOriginalValues();
	}

	private PatronStatus _patronStatus;
}