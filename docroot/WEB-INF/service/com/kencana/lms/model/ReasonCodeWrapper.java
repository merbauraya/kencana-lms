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
 * This class is a wrapper for {@link ReasonCode}.
 * </p>
 *
 * @author Mazlan Mat
 * @see ReasonCode
 * @generated
 */
public class ReasonCodeWrapper implements ReasonCode, ModelWrapper<ReasonCode> {
	public ReasonCodeWrapper(ReasonCode reasonCode) {
		_reasonCode = reasonCode;
	}

	@Override
	public Class<?> getModelClass() {
		return ReasonCode.class;
	}

	@Override
	public String getModelClassName() {
		return ReasonCode.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("reasonCodeId", getReasonCodeId());
		attributes.put("reasonCodeName", getReasonCodeName());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long reasonCodeId = (Long)attributes.get("reasonCodeId");

		if (reasonCodeId != null) {
			setReasonCodeId(reasonCodeId);
		}

		String reasonCodeName = (String)attributes.get("reasonCodeName");

		if (reasonCodeName != null) {
			setReasonCodeName(reasonCodeName);
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
	* Returns the primary key of this reason code.
	*
	* @return the primary key of this reason code
	*/
	@Override
	public long getPrimaryKey() {
		return _reasonCode.getPrimaryKey();
	}

	/**
	* Sets the primary key of this reason code.
	*
	* @param primaryKey the primary key of this reason code
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_reasonCode.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the reason code ID of this reason code.
	*
	* @return the reason code ID of this reason code
	*/
	@Override
	public long getReasonCodeId() {
		return _reasonCode.getReasonCodeId();
	}

	/**
	* Sets the reason code ID of this reason code.
	*
	* @param reasonCodeId the reason code ID of this reason code
	*/
	@Override
	public void setReasonCodeId(long reasonCodeId) {
		_reasonCode.setReasonCodeId(reasonCodeId);
	}

	/**
	* Returns the reason code name of this reason code.
	*
	* @return the reason code name of this reason code
	*/
	@Override
	public java.lang.String getReasonCodeName() {
		return _reasonCode.getReasonCodeName();
	}

	/**
	* Sets the reason code name of this reason code.
	*
	* @param reasonCodeName the reason code name of this reason code
	*/
	@Override
	public void setReasonCodeName(java.lang.String reasonCodeName) {
		_reasonCode.setReasonCodeName(reasonCodeName);
	}

	/**
	* Returns the group ID of this reason code.
	*
	* @return the group ID of this reason code
	*/
	@Override
	public long getGroupId() {
		return _reasonCode.getGroupId();
	}

	/**
	* Sets the group ID of this reason code.
	*
	* @param groupId the group ID of this reason code
	*/
	@Override
	public void setGroupId(long groupId) {
		_reasonCode.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this reason code.
	*
	* @return the company ID of this reason code
	*/
	@Override
	public long getCompanyId() {
		return _reasonCode.getCompanyId();
	}

	/**
	* Sets the company ID of this reason code.
	*
	* @param companyId the company ID of this reason code
	*/
	@Override
	public void setCompanyId(long companyId) {
		_reasonCode.setCompanyId(companyId);
	}

	@Override
	public boolean isNew() {
		return _reasonCode.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_reasonCode.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _reasonCode.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_reasonCode.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _reasonCode.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _reasonCode.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_reasonCode.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _reasonCode.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_reasonCode.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_reasonCode.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_reasonCode.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ReasonCodeWrapper((ReasonCode)_reasonCode.clone());
	}

	@Override
	public int compareTo(com.kencana.lms.model.ReasonCode reasonCode) {
		return _reasonCode.compareTo(reasonCode);
	}

	@Override
	public int hashCode() {
		return _reasonCode.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.kencana.lms.model.ReasonCode> toCacheModel() {
		return _reasonCode.toCacheModel();
	}

	@Override
	public com.kencana.lms.model.ReasonCode toEscapedModel() {
		return new ReasonCodeWrapper(_reasonCode.toEscapedModel());
	}

	@Override
	public com.kencana.lms.model.ReasonCode toUnescapedModel() {
		return new ReasonCodeWrapper(_reasonCode.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _reasonCode.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _reasonCode.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_reasonCode.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ReasonCodeWrapper)) {
			return false;
		}

		ReasonCodeWrapper reasonCodeWrapper = (ReasonCodeWrapper)obj;

		if (Validator.equals(_reasonCode, reasonCodeWrapper._reasonCode)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ReasonCode getWrappedReasonCode() {
		return _reasonCode;
	}

	@Override
	public ReasonCode getWrappedModel() {
		return _reasonCode;
	}

	@Override
	public void resetOriginalValues() {
		_reasonCode.resetOriginalValues();
	}

	private ReasonCode _reasonCode;
}