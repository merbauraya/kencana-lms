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
 * This class is a wrapper for {@link CatalogTemplateSubfield}.
 * </p>
 *
 * @author Mazlan Mat
 * @see CatalogTemplateSubfield
 * @generated
 */
public class CatalogTemplateSubfieldWrapper implements CatalogTemplateSubfield,
	ModelWrapper<CatalogTemplateSubfield> {
	public CatalogTemplateSubfieldWrapper(
		CatalogTemplateSubfield catalogTemplateSubfield) {
		_catalogTemplateSubfield = catalogTemplateSubfield;
	}

	@Override
	public Class<?> getModelClass() {
		return CatalogTemplateSubfield.class;
	}

	@Override
	public String getModelClassName() {
		return CatalogTemplateSubfield.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("catalogTemplateSubfieldId",
			getCatalogTemplateSubfieldId());
		attributes.put("catalogTemplateTagId", getCatalogTemplateTagId());
		attributes.put("subfield", getSubfield());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("repeatable", getRepeatable());
		attributes.put("mandatory", getMandatory());
		attributes.put("isURL", getIsURL());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long catalogTemplateSubfieldId = (Long)attributes.get(
				"catalogTemplateSubfieldId");

		if (catalogTemplateSubfieldId != null) {
			setCatalogTemplateSubfieldId(catalogTemplateSubfieldId);
		}

		Long catalogTemplateTagId = (Long)attributes.get("catalogTemplateTagId");

		if (catalogTemplateTagId != null) {
			setCatalogTemplateTagId(catalogTemplateTagId);
		}

		String subfield = (String)attributes.get("subfield");

		if (subfield != null) {
			setSubfield(subfield);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Boolean repeatable = (Boolean)attributes.get("repeatable");

		if (repeatable != null) {
			setRepeatable(repeatable);
		}

		Boolean mandatory = (Boolean)attributes.get("mandatory");

		if (mandatory != null) {
			setMandatory(mandatory);
		}

		Boolean isURL = (Boolean)attributes.get("isURL");

		if (isURL != null) {
			setIsURL(isURL);
		}
	}

	/**
	* Returns the primary key of this catalog template subfield.
	*
	* @return the primary key of this catalog template subfield
	*/
	@Override
	public long getPrimaryKey() {
		return _catalogTemplateSubfield.getPrimaryKey();
	}

	/**
	* Sets the primary key of this catalog template subfield.
	*
	* @param primaryKey the primary key of this catalog template subfield
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_catalogTemplateSubfield.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the catalog template subfield ID of this catalog template subfield.
	*
	* @return the catalog template subfield ID of this catalog template subfield
	*/
	@Override
	public long getCatalogTemplateSubfieldId() {
		return _catalogTemplateSubfield.getCatalogTemplateSubfieldId();
	}

	/**
	* Sets the catalog template subfield ID of this catalog template subfield.
	*
	* @param catalogTemplateSubfieldId the catalog template subfield ID of this catalog template subfield
	*/
	@Override
	public void setCatalogTemplateSubfieldId(long catalogTemplateSubfieldId) {
		_catalogTemplateSubfield.setCatalogTemplateSubfieldId(catalogTemplateSubfieldId);
	}

	/**
	* Returns the catalog template tag ID of this catalog template subfield.
	*
	* @return the catalog template tag ID of this catalog template subfield
	*/
	@Override
	public long getCatalogTemplateTagId() {
		return _catalogTemplateSubfield.getCatalogTemplateTagId();
	}

	/**
	* Sets the catalog template tag ID of this catalog template subfield.
	*
	* @param catalogTemplateTagId the catalog template tag ID of this catalog template subfield
	*/
	@Override
	public void setCatalogTemplateTagId(long catalogTemplateTagId) {
		_catalogTemplateSubfield.setCatalogTemplateTagId(catalogTemplateTagId);
	}

	/**
	* Returns the subfield of this catalog template subfield.
	*
	* @return the subfield of this catalog template subfield
	*/
	@Override
	public java.lang.String getSubfield() {
		return _catalogTemplateSubfield.getSubfield();
	}

	/**
	* Sets the subfield of this catalog template subfield.
	*
	* @param subfield the subfield of this catalog template subfield
	*/
	@Override
	public void setSubfield(java.lang.String subfield) {
		_catalogTemplateSubfield.setSubfield(subfield);
	}

	/**
	* Returns the group ID of this catalog template subfield.
	*
	* @return the group ID of this catalog template subfield
	*/
	@Override
	public long getGroupId() {
		return _catalogTemplateSubfield.getGroupId();
	}

	/**
	* Sets the group ID of this catalog template subfield.
	*
	* @param groupId the group ID of this catalog template subfield
	*/
	@Override
	public void setGroupId(long groupId) {
		_catalogTemplateSubfield.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this catalog template subfield.
	*
	* @return the company ID of this catalog template subfield
	*/
	@Override
	public long getCompanyId() {
		return _catalogTemplateSubfield.getCompanyId();
	}

	/**
	* Sets the company ID of this catalog template subfield.
	*
	* @param companyId the company ID of this catalog template subfield
	*/
	@Override
	public void setCompanyId(long companyId) {
		_catalogTemplateSubfield.setCompanyId(companyId);
	}

	/**
	* Returns the repeatable of this catalog template subfield.
	*
	* @return the repeatable of this catalog template subfield
	*/
	@Override
	public boolean getRepeatable() {
		return _catalogTemplateSubfield.getRepeatable();
	}

	/**
	* Returns <code>true</code> if this catalog template subfield is repeatable.
	*
	* @return <code>true</code> if this catalog template subfield is repeatable; <code>false</code> otherwise
	*/
	@Override
	public boolean isRepeatable() {
		return _catalogTemplateSubfield.isRepeatable();
	}

	/**
	* Sets whether this catalog template subfield is repeatable.
	*
	* @param repeatable the repeatable of this catalog template subfield
	*/
	@Override
	public void setRepeatable(boolean repeatable) {
		_catalogTemplateSubfield.setRepeatable(repeatable);
	}

	/**
	* Returns the mandatory of this catalog template subfield.
	*
	* @return the mandatory of this catalog template subfield
	*/
	@Override
	public boolean getMandatory() {
		return _catalogTemplateSubfield.getMandatory();
	}

	/**
	* Returns <code>true</code> if this catalog template subfield is mandatory.
	*
	* @return <code>true</code> if this catalog template subfield is mandatory; <code>false</code> otherwise
	*/
	@Override
	public boolean isMandatory() {
		return _catalogTemplateSubfield.isMandatory();
	}

	/**
	* Sets whether this catalog template subfield is mandatory.
	*
	* @param mandatory the mandatory of this catalog template subfield
	*/
	@Override
	public void setMandatory(boolean mandatory) {
		_catalogTemplateSubfield.setMandatory(mandatory);
	}

	/**
	* Returns the is u r l of this catalog template subfield.
	*
	* @return the is u r l of this catalog template subfield
	*/
	@Override
	public boolean getIsURL() {
		return _catalogTemplateSubfield.getIsURL();
	}

	/**
	* Returns <code>true</code> if this catalog template subfield is is u r l.
	*
	* @return <code>true</code> if this catalog template subfield is is u r l; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsURL() {
		return _catalogTemplateSubfield.isIsURL();
	}

	/**
	* Sets whether this catalog template subfield is is u r l.
	*
	* @param isURL the is u r l of this catalog template subfield
	*/
	@Override
	public void setIsURL(boolean isURL) {
		_catalogTemplateSubfield.setIsURL(isURL);
	}

	@Override
	public boolean isNew() {
		return _catalogTemplateSubfield.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_catalogTemplateSubfield.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _catalogTemplateSubfield.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_catalogTemplateSubfield.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _catalogTemplateSubfield.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _catalogTemplateSubfield.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_catalogTemplateSubfield.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _catalogTemplateSubfield.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_catalogTemplateSubfield.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_catalogTemplateSubfield.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_catalogTemplateSubfield.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CatalogTemplateSubfieldWrapper((CatalogTemplateSubfield)_catalogTemplateSubfield.clone());
	}

	@Override
	public int compareTo(
		com.kencana.lms.model.CatalogTemplateSubfield catalogTemplateSubfield) {
		return _catalogTemplateSubfield.compareTo(catalogTemplateSubfield);
	}

	@Override
	public int hashCode() {
		return _catalogTemplateSubfield.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.kencana.lms.model.CatalogTemplateSubfield> toCacheModel() {
		return _catalogTemplateSubfield.toCacheModel();
	}

	@Override
	public com.kencana.lms.model.CatalogTemplateSubfield toEscapedModel() {
		return new CatalogTemplateSubfieldWrapper(_catalogTemplateSubfield.toEscapedModel());
	}

	@Override
	public com.kencana.lms.model.CatalogTemplateSubfield toUnescapedModel() {
		return new CatalogTemplateSubfieldWrapper(_catalogTemplateSubfield.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _catalogTemplateSubfield.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _catalogTemplateSubfield.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_catalogTemplateSubfield.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CatalogTemplateSubfieldWrapper)) {
			return false;
		}

		CatalogTemplateSubfieldWrapper catalogTemplateSubfieldWrapper = (CatalogTemplateSubfieldWrapper)obj;

		if (Validator.equals(_catalogTemplateSubfield,
					catalogTemplateSubfieldWrapper._catalogTemplateSubfield)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CatalogTemplateSubfield getWrappedCatalogTemplateSubfield() {
		return _catalogTemplateSubfield;
	}

	@Override
	public CatalogTemplateSubfield getWrappedModel() {
		return _catalogTemplateSubfield;
	}

	@Override
	public void resetOriginalValues() {
		_catalogTemplateSubfield.resetOriginalValues();
	}

	private CatalogTemplateSubfield _catalogTemplateSubfield;
}