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
 * This class is a wrapper for {@link CatalogTemplateTag}.
 * </p>
 *
 * @author Mazlan Mat
 * @see CatalogTemplateTag
 * @generated
 */
public class CatalogTemplateTagWrapper implements CatalogTemplateTag,
	ModelWrapper<CatalogTemplateTag> {
	public CatalogTemplateTagWrapper(CatalogTemplateTag catalogTemplateTag) {
		_catalogTemplateTag = catalogTemplateTag;
	}

	@Override
	public Class<?> getModelClass() {
		return CatalogTemplateTag.class;
	}

	@Override
	public String getModelClassName() {
		return CatalogTemplateTag.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("catelogTemplateTagId", getCatelogTemplateTagId());
		attributes.put("catelogTemplateId", getCatelogTemplateId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("tag", getTag());
		attributes.put("repeatable", getRepeatable());
		attributes.put("mandatory", getMandatory());
		attributes.put("helpText", getHelpText());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long catelogTemplateTagId = (Long)attributes.get("catelogTemplateTagId");

		if (catelogTemplateTagId != null) {
			setCatelogTemplateTagId(catelogTemplateTagId);
		}

		Long catelogTemplateId = (Long)attributes.get("catelogTemplateId");

		if (catelogTemplateId != null) {
			setCatelogTemplateId(catelogTemplateId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String tag = (String)attributes.get("tag");

		if (tag != null) {
			setTag(tag);
		}

		Boolean repeatable = (Boolean)attributes.get("repeatable");

		if (repeatable != null) {
			setRepeatable(repeatable);
		}

		Boolean mandatory = (Boolean)attributes.get("mandatory");

		if (mandatory != null) {
			setMandatory(mandatory);
		}

		String helpText = (String)attributes.get("helpText");

		if (helpText != null) {
			setHelpText(helpText);
		}
	}

	/**
	* Returns the primary key of this catalog template tag.
	*
	* @return the primary key of this catalog template tag
	*/
	@Override
	public long getPrimaryKey() {
		return _catalogTemplateTag.getPrimaryKey();
	}

	/**
	* Sets the primary key of this catalog template tag.
	*
	* @param primaryKey the primary key of this catalog template tag
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_catalogTemplateTag.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the catelog template tag ID of this catalog template tag.
	*
	* @return the catelog template tag ID of this catalog template tag
	*/
	@Override
	public long getCatelogTemplateTagId() {
		return _catalogTemplateTag.getCatelogTemplateTagId();
	}

	/**
	* Sets the catelog template tag ID of this catalog template tag.
	*
	* @param catelogTemplateTagId the catelog template tag ID of this catalog template tag
	*/
	@Override
	public void setCatelogTemplateTagId(long catelogTemplateTagId) {
		_catalogTemplateTag.setCatelogTemplateTagId(catelogTemplateTagId);
	}

	/**
	* Returns the catelog template ID of this catalog template tag.
	*
	* @return the catelog template ID of this catalog template tag
	*/
	@Override
	public long getCatelogTemplateId() {
		return _catalogTemplateTag.getCatelogTemplateId();
	}

	/**
	* Sets the catelog template ID of this catalog template tag.
	*
	* @param catelogTemplateId the catelog template ID of this catalog template tag
	*/
	@Override
	public void setCatelogTemplateId(long catelogTemplateId) {
		_catalogTemplateTag.setCatelogTemplateId(catelogTemplateId);
	}

	/**
	* Returns the group ID of this catalog template tag.
	*
	* @return the group ID of this catalog template tag
	*/
	@Override
	public long getGroupId() {
		return _catalogTemplateTag.getGroupId();
	}

	/**
	* Sets the group ID of this catalog template tag.
	*
	* @param groupId the group ID of this catalog template tag
	*/
	@Override
	public void setGroupId(long groupId) {
		_catalogTemplateTag.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this catalog template tag.
	*
	* @return the company ID of this catalog template tag
	*/
	@Override
	public long getCompanyId() {
		return _catalogTemplateTag.getCompanyId();
	}

	/**
	* Sets the company ID of this catalog template tag.
	*
	* @param companyId the company ID of this catalog template tag
	*/
	@Override
	public void setCompanyId(long companyId) {
		_catalogTemplateTag.setCompanyId(companyId);
	}

	/**
	* Returns the tag of this catalog template tag.
	*
	* @return the tag of this catalog template tag
	*/
	@Override
	public java.lang.String getTag() {
		return _catalogTemplateTag.getTag();
	}

	/**
	* Sets the tag of this catalog template tag.
	*
	* @param tag the tag of this catalog template tag
	*/
	@Override
	public void setTag(java.lang.String tag) {
		_catalogTemplateTag.setTag(tag);
	}

	/**
	* Returns the repeatable of this catalog template tag.
	*
	* @return the repeatable of this catalog template tag
	*/
	@Override
	public boolean getRepeatable() {
		return _catalogTemplateTag.getRepeatable();
	}

	/**
	* Returns <code>true</code> if this catalog template tag is repeatable.
	*
	* @return <code>true</code> if this catalog template tag is repeatable; <code>false</code> otherwise
	*/
	@Override
	public boolean isRepeatable() {
		return _catalogTemplateTag.isRepeatable();
	}

	/**
	* Sets whether this catalog template tag is repeatable.
	*
	* @param repeatable the repeatable of this catalog template tag
	*/
	@Override
	public void setRepeatable(boolean repeatable) {
		_catalogTemplateTag.setRepeatable(repeatable);
	}

	/**
	* Returns the mandatory of this catalog template tag.
	*
	* @return the mandatory of this catalog template tag
	*/
	@Override
	public boolean getMandatory() {
		return _catalogTemplateTag.getMandatory();
	}

	/**
	* Returns <code>true</code> if this catalog template tag is mandatory.
	*
	* @return <code>true</code> if this catalog template tag is mandatory; <code>false</code> otherwise
	*/
	@Override
	public boolean isMandatory() {
		return _catalogTemplateTag.isMandatory();
	}

	/**
	* Sets whether this catalog template tag is mandatory.
	*
	* @param mandatory the mandatory of this catalog template tag
	*/
	@Override
	public void setMandatory(boolean mandatory) {
		_catalogTemplateTag.setMandatory(mandatory);
	}

	/**
	* Returns the help text of this catalog template tag.
	*
	* @return the help text of this catalog template tag
	*/
	@Override
	public java.lang.String getHelpText() {
		return _catalogTemplateTag.getHelpText();
	}

	/**
	* Sets the help text of this catalog template tag.
	*
	* @param helpText the help text of this catalog template tag
	*/
	@Override
	public void setHelpText(java.lang.String helpText) {
		_catalogTemplateTag.setHelpText(helpText);
	}

	@Override
	public boolean isNew() {
		return _catalogTemplateTag.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_catalogTemplateTag.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _catalogTemplateTag.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_catalogTemplateTag.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _catalogTemplateTag.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _catalogTemplateTag.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_catalogTemplateTag.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _catalogTemplateTag.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_catalogTemplateTag.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_catalogTemplateTag.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_catalogTemplateTag.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CatalogTemplateTagWrapper((CatalogTemplateTag)_catalogTemplateTag.clone());
	}

	@Override
	public int compareTo(
		com.kencana.lms.model.CatalogTemplateTag catalogTemplateTag) {
		return _catalogTemplateTag.compareTo(catalogTemplateTag);
	}

	@Override
	public int hashCode() {
		return _catalogTemplateTag.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.kencana.lms.model.CatalogTemplateTag> toCacheModel() {
		return _catalogTemplateTag.toCacheModel();
	}

	@Override
	public com.kencana.lms.model.CatalogTemplateTag toEscapedModel() {
		return new CatalogTemplateTagWrapper(_catalogTemplateTag.toEscapedModel());
	}

	@Override
	public com.kencana.lms.model.CatalogTemplateTag toUnescapedModel() {
		return new CatalogTemplateTagWrapper(_catalogTemplateTag.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _catalogTemplateTag.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _catalogTemplateTag.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_catalogTemplateTag.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CatalogTemplateTagWrapper)) {
			return false;
		}

		CatalogTemplateTagWrapper catalogTemplateTagWrapper = (CatalogTemplateTagWrapper)obj;

		if (Validator.equals(_catalogTemplateTag,
					catalogTemplateTagWrapper._catalogTemplateTag)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CatalogTemplateTag getWrappedCatalogTemplateTag() {
		return _catalogTemplateTag;
	}

	@Override
	public CatalogTemplateTag getWrappedModel() {
		return _catalogTemplateTag;
	}

	@Override
	public void resetOriginalValues() {
		_catalogTemplateTag.resetOriginalValues();
	}

	private CatalogTemplateTag _catalogTemplateTag;
}