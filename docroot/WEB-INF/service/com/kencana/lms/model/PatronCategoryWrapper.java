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
 * This class is a wrapper for {@link PatronCategory}.
 * </p>
 *
 * @author Mazlan Mat
 * @see PatronCategory
 * @generated
 */
public class PatronCategoryWrapper implements PatronCategory,
	ModelWrapper<PatronCategory> {
	public PatronCategoryWrapper(PatronCategory patronCategory) {
		_patronCategory = patronCategory;
	}

	@Override
	public Class<?> getModelClass() {
		return PatronCategory.class;
	}

	@Override
	public String getModelClassName() {
		return PatronCategory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("patronCategoryId", getPatronCategoryId());
		attributes.put("patronCategoryName", getPatronCategoryName());
		attributes.put("notes", getNotes());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long patronCategoryId = (Long)attributes.get("patronCategoryId");

		if (patronCategoryId != null) {
			setPatronCategoryId(patronCategoryId);
		}

		String patronCategoryName = (String)attributes.get("patronCategoryName");

		if (patronCategoryName != null) {
			setPatronCategoryName(patronCategoryName);
		}

		String notes = (String)attributes.get("notes");

		if (notes != null) {
			setNotes(notes);
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
	* Returns the primary key of this patron category.
	*
	* @return the primary key of this patron category
	*/
	@Override
	public long getPrimaryKey() {
		return _patronCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this patron category.
	*
	* @param primaryKey the primary key of this patron category
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_patronCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the patron category ID of this patron category.
	*
	* @return the patron category ID of this patron category
	*/
	@Override
	public long getPatronCategoryId() {
		return _patronCategory.getPatronCategoryId();
	}

	/**
	* Sets the patron category ID of this patron category.
	*
	* @param patronCategoryId the patron category ID of this patron category
	*/
	@Override
	public void setPatronCategoryId(long patronCategoryId) {
		_patronCategory.setPatronCategoryId(patronCategoryId);
	}

	/**
	* Returns the patron category name of this patron category.
	*
	* @return the patron category name of this patron category
	*/
	@Override
	public java.lang.String getPatronCategoryName() {
		return _patronCategory.getPatronCategoryName();
	}

	/**
	* Sets the patron category name of this patron category.
	*
	* @param patronCategoryName the patron category name of this patron category
	*/
	@Override
	public void setPatronCategoryName(java.lang.String patronCategoryName) {
		_patronCategory.setPatronCategoryName(patronCategoryName);
	}

	/**
	* Returns the notes of this patron category.
	*
	* @return the notes of this patron category
	*/
	@Override
	public java.lang.String getNotes() {
		return _patronCategory.getNotes();
	}

	/**
	* Sets the notes of this patron category.
	*
	* @param notes the notes of this patron category
	*/
	@Override
	public void setNotes(java.lang.String notes) {
		_patronCategory.setNotes(notes);
	}

	/**
	* Returns the group ID of this patron category.
	*
	* @return the group ID of this patron category
	*/
	@Override
	public long getGroupId() {
		return _patronCategory.getGroupId();
	}

	/**
	* Sets the group ID of this patron category.
	*
	* @param groupId the group ID of this patron category
	*/
	@Override
	public void setGroupId(long groupId) {
		_patronCategory.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this patron category.
	*
	* @return the company ID of this patron category
	*/
	@Override
	public long getCompanyId() {
		return _patronCategory.getCompanyId();
	}

	/**
	* Sets the company ID of this patron category.
	*
	* @param companyId the company ID of this patron category
	*/
	@Override
	public void setCompanyId(long companyId) {
		_patronCategory.setCompanyId(companyId);
	}

	@Override
	public boolean isNew() {
		return _patronCategory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_patronCategory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _patronCategory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_patronCategory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _patronCategory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _patronCategory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_patronCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _patronCategory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_patronCategory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_patronCategory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_patronCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PatronCategoryWrapper((PatronCategory)_patronCategory.clone());
	}

	@Override
	public int compareTo(com.kencana.lms.model.PatronCategory patronCategory) {
		return _patronCategory.compareTo(patronCategory);
	}

	@Override
	public int hashCode() {
		return _patronCategory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.kencana.lms.model.PatronCategory> toCacheModel() {
		return _patronCategory.toCacheModel();
	}

	@Override
	public com.kencana.lms.model.PatronCategory toEscapedModel() {
		return new PatronCategoryWrapper(_patronCategory.toEscapedModel());
	}

	@Override
	public com.kencana.lms.model.PatronCategory toUnescapedModel() {
		return new PatronCategoryWrapper(_patronCategory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _patronCategory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _patronCategory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_patronCategory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PatronCategoryWrapper)) {
			return false;
		}

		PatronCategoryWrapper patronCategoryWrapper = (PatronCategoryWrapper)obj;

		if (Validator.equals(_patronCategory,
					patronCategoryWrapper._patronCategory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PatronCategory getWrappedPatronCategory() {
		return _patronCategory;
	}

	@Override
	public PatronCategory getWrappedModel() {
		return _patronCategory;
	}

	@Override
	public void resetOriginalValues() {
		_patronCategory.resetOriginalValues();
	}

	private PatronCategory _patronCategory;
}