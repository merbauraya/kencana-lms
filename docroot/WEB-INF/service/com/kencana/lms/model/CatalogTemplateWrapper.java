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
 * This class is a wrapper for {@link CatalogTemplate}.
 * </p>
 *
 * @author Mazlan Mat
 * @see CatalogTemplate
 * @generated
 */
public class CatalogTemplateWrapper implements CatalogTemplate,
	ModelWrapper<CatalogTemplate> {
	public CatalogTemplateWrapper(CatalogTemplate catalogTemplate) {
		_catalogTemplate = catalogTemplate;
	}

	@Override
	public Class<?> getModelClass() {
		return CatalogTemplate.class;
	}

	@Override
	public String getModelClassName() {
		return CatalogTemplate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("templateId", getTemplateId());
		attributes.put("templateName", getTemplateName());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("description", getDescription());
		attributes.put("active", getActive());
		attributes.put("createBy", getCreateBy());
		attributes.put("createdDate", getCreatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long templateId = (Long)attributes.get("templateId");

		if (templateId != null) {
			setTemplateId(templateId);
		}

		String templateName = (String)attributes.get("templateName");

		if (templateName != null) {
			setTemplateName(templateName);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Long createBy = (Long)attributes.get("createBy");

		if (createBy != null) {
			setCreateBy(createBy);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}
	}

	/**
	* Returns the primary key of this catalog template.
	*
	* @return the primary key of this catalog template
	*/
	@Override
	public long getPrimaryKey() {
		return _catalogTemplate.getPrimaryKey();
	}

	/**
	* Sets the primary key of this catalog template.
	*
	* @param primaryKey the primary key of this catalog template
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_catalogTemplate.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the template ID of this catalog template.
	*
	* @return the template ID of this catalog template
	*/
	@Override
	public long getTemplateId() {
		return _catalogTemplate.getTemplateId();
	}

	/**
	* Sets the template ID of this catalog template.
	*
	* @param templateId the template ID of this catalog template
	*/
	@Override
	public void setTemplateId(long templateId) {
		_catalogTemplate.setTemplateId(templateId);
	}

	/**
	* Returns the template name of this catalog template.
	*
	* @return the template name of this catalog template
	*/
	@Override
	public java.lang.String getTemplateName() {
		return _catalogTemplate.getTemplateName();
	}

	/**
	* Sets the template name of this catalog template.
	*
	* @param templateName the template name of this catalog template
	*/
	@Override
	public void setTemplateName(java.lang.String templateName) {
		_catalogTemplate.setTemplateName(templateName);
	}

	/**
	* Returns the group ID of this catalog template.
	*
	* @return the group ID of this catalog template
	*/
	@Override
	public long getGroupId() {
		return _catalogTemplate.getGroupId();
	}

	/**
	* Sets the group ID of this catalog template.
	*
	* @param groupId the group ID of this catalog template
	*/
	@Override
	public void setGroupId(long groupId) {
		_catalogTemplate.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this catalog template.
	*
	* @return the company ID of this catalog template
	*/
	@Override
	public long getCompanyId() {
		return _catalogTemplate.getCompanyId();
	}

	/**
	* Sets the company ID of this catalog template.
	*
	* @param companyId the company ID of this catalog template
	*/
	@Override
	public void setCompanyId(long companyId) {
		_catalogTemplate.setCompanyId(companyId);
	}

	/**
	* Returns the description of this catalog template.
	*
	* @return the description of this catalog template
	*/
	@Override
	public java.lang.String getDescription() {
		return _catalogTemplate.getDescription();
	}

	/**
	* Sets the description of this catalog template.
	*
	* @param description the description of this catalog template
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_catalogTemplate.setDescription(description);
	}

	/**
	* Returns the active of this catalog template.
	*
	* @return the active of this catalog template
	*/
	@Override
	public boolean getActive() {
		return _catalogTemplate.getActive();
	}

	/**
	* Returns <code>true</code> if this catalog template is active.
	*
	* @return <code>true</code> if this catalog template is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _catalogTemplate.isActive();
	}

	/**
	* Sets whether this catalog template is active.
	*
	* @param active the active of this catalog template
	*/
	@Override
	public void setActive(boolean active) {
		_catalogTemplate.setActive(active);
	}

	/**
	* Returns the create by of this catalog template.
	*
	* @return the create by of this catalog template
	*/
	@Override
	public long getCreateBy() {
		return _catalogTemplate.getCreateBy();
	}

	/**
	* Sets the create by of this catalog template.
	*
	* @param createBy the create by of this catalog template
	*/
	@Override
	public void setCreateBy(long createBy) {
		_catalogTemplate.setCreateBy(createBy);
	}

	/**
	* Returns the created date of this catalog template.
	*
	* @return the created date of this catalog template
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _catalogTemplate.getCreatedDate();
	}

	/**
	* Sets the created date of this catalog template.
	*
	* @param createdDate the created date of this catalog template
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_catalogTemplate.setCreatedDate(createdDate);
	}

	@Override
	public boolean isNew() {
		return _catalogTemplate.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_catalogTemplate.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _catalogTemplate.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_catalogTemplate.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _catalogTemplate.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _catalogTemplate.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_catalogTemplate.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _catalogTemplate.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_catalogTemplate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_catalogTemplate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_catalogTemplate.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CatalogTemplateWrapper((CatalogTemplate)_catalogTemplate.clone());
	}

	@Override
	public int compareTo(com.kencana.lms.model.CatalogTemplate catalogTemplate) {
		return _catalogTemplate.compareTo(catalogTemplate);
	}

	@Override
	public int hashCode() {
		return _catalogTemplate.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.kencana.lms.model.CatalogTemplate> toCacheModel() {
		return _catalogTemplate.toCacheModel();
	}

	@Override
	public com.kencana.lms.model.CatalogTemplate toEscapedModel() {
		return new CatalogTemplateWrapper(_catalogTemplate.toEscapedModel());
	}

	@Override
	public com.kencana.lms.model.CatalogTemplate toUnescapedModel() {
		return new CatalogTemplateWrapper(_catalogTemplate.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _catalogTemplate.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _catalogTemplate.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_catalogTemplate.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CatalogTemplateWrapper)) {
			return false;
		}

		CatalogTemplateWrapper catalogTemplateWrapper = (CatalogTemplateWrapper)obj;

		if (Validator.equals(_catalogTemplate,
					catalogTemplateWrapper._catalogTemplate)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CatalogTemplate getWrappedCatalogTemplate() {
		return _catalogTemplate;
	}

	@Override
	public CatalogTemplate getWrappedModel() {
		return _catalogTemplate;
	}

	@Override
	public void resetOriginalValues() {
		_catalogTemplate.resetOriginalValues();
	}

	private CatalogTemplate _catalogTemplate;
}