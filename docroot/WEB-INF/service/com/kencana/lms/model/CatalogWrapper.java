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
 * This class is a wrapper for {@link Catalog}.
 * </p>
 *
 * @author Mazlan Mat
 * @see Catalog
 * @generated
 */
public class CatalogWrapper implements Catalog, ModelWrapper<Catalog> {
	public CatalogWrapper(Catalog catalog) {
		_catalog = catalog;
	}

	@Override
	public Class<?> getModelClass() {
		return Catalog.class;
	}

	@Override
	public String getModelClassName() {
		return Catalog.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("catalogId", getCatalogId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createdByUserId", getCreatedByUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("itemTypeId", getItemTypeId());
		attributes.put("title", getTitle());
		attributes.put("author", getAuthor());
		attributes.put("publisher", getPublisher());
		attributes.put("isbn", getIsbn());
		attributes.put("issn", getIssn());
		attributes.put("callNumber", getCallNumber());
		attributes.put("UUID", getUUID());
		attributes.put("catalogAbstract", getCatalogAbstract());
		attributes.put("templateId", getTemplateId());
		attributes.put("visible", getVisible());
		attributes.put("coverImageId", getCoverImageId());
		attributes.put("marc", getMarc());
		attributes.put("workflowStatus", getWorkflowStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long catalogId = (Long)attributes.get("catalogId");

		if (catalogId != null) {
			setCatalogId(catalogId);
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

		Long createdByUserId = (Long)attributes.get("createdByUserId");

		if (createdByUserId != null) {
			setCreatedByUserId(createdByUserId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long itemTypeId = (Long)attributes.get("itemTypeId");

		if (itemTypeId != null) {
			setItemTypeId(itemTypeId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String author = (String)attributes.get("author");

		if (author != null) {
			setAuthor(author);
		}

		String publisher = (String)attributes.get("publisher");

		if (publisher != null) {
			setPublisher(publisher);
		}

		String isbn = (String)attributes.get("isbn");

		if (isbn != null) {
			setIsbn(isbn);
		}

		String issn = (String)attributes.get("issn");

		if (issn != null) {
			setIssn(issn);
		}

		String callNumber = (String)attributes.get("callNumber");

		if (callNumber != null) {
			setCallNumber(callNumber);
		}

		String UUID = (String)attributes.get("UUID");

		if (UUID != null) {
			setUUID(UUID);
		}

		String catalogAbstract = (String)attributes.get("catalogAbstract");

		if (catalogAbstract != null) {
			setCatalogAbstract(catalogAbstract);
		}

		Long templateId = (Long)attributes.get("templateId");

		if (templateId != null) {
			setTemplateId(templateId);
		}

		Boolean visible = (Boolean)attributes.get("visible");

		if (visible != null) {
			setVisible(visible);
		}

		Long coverImageId = (Long)attributes.get("coverImageId");

		if (coverImageId != null) {
			setCoverImageId(coverImageId);
		}

		String marc = (String)attributes.get("marc");

		if (marc != null) {
			setMarc(marc);
		}

		Integer workflowStatus = (Integer)attributes.get("workflowStatus");

		if (workflowStatus != null) {
			setWorkflowStatus(workflowStatus);
		}
	}

	/**
	* Returns the primary key of this catalog.
	*
	* @return the primary key of this catalog
	*/
	@Override
	public long getPrimaryKey() {
		return _catalog.getPrimaryKey();
	}

	/**
	* Sets the primary key of this catalog.
	*
	* @param primaryKey the primary key of this catalog
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_catalog.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the catalog ID of this catalog.
	*
	* @return the catalog ID of this catalog
	*/
	@Override
	public long getCatalogId() {
		return _catalog.getCatalogId();
	}

	/**
	* Sets the catalog ID of this catalog.
	*
	* @param catalogId the catalog ID of this catalog
	*/
	@Override
	public void setCatalogId(long catalogId) {
		_catalog.setCatalogId(catalogId);
	}

	/**
	* Returns the company ID of this catalog.
	*
	* @return the company ID of this catalog
	*/
	@Override
	public long getCompanyId() {
		return _catalog.getCompanyId();
	}

	/**
	* Sets the company ID of this catalog.
	*
	* @param companyId the company ID of this catalog
	*/
	@Override
	public void setCompanyId(long companyId) {
		_catalog.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this catalog.
	*
	* @return the group ID of this catalog
	*/
	@Override
	public long getGroupId() {
		return _catalog.getGroupId();
	}

	/**
	* Sets the group ID of this catalog.
	*
	* @param groupId the group ID of this catalog
	*/
	@Override
	public void setGroupId(long groupId) {
		_catalog.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this catalog.
	*
	* @return the user ID of this catalog
	*/
	@Override
	public long getUserId() {
		return _catalog.getUserId();
	}

	/**
	* Sets the user ID of this catalog.
	*
	* @param userId the user ID of this catalog
	*/
	@Override
	public void setUserId(long userId) {
		_catalog.setUserId(userId);
	}

	/**
	* Returns the user uuid of this catalog.
	*
	* @return the user uuid of this catalog
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalog.getUserUuid();
	}

	/**
	* Sets the user uuid of this catalog.
	*
	* @param userUuid the user uuid of this catalog
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_catalog.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this catalog.
	*
	* @return the user name of this catalog
	*/
	@Override
	public java.lang.String getUserName() {
		return _catalog.getUserName();
	}

	/**
	* Sets the user name of this catalog.
	*
	* @param userName the user name of this catalog
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_catalog.setUserName(userName);
	}

	/**
	* Returns the created by user ID of this catalog.
	*
	* @return the created by user ID of this catalog
	*/
	@Override
	public long getCreatedByUserId() {
		return _catalog.getCreatedByUserId();
	}

	/**
	* Sets the created by user ID of this catalog.
	*
	* @param createdByUserId the created by user ID of this catalog
	*/
	@Override
	public void setCreatedByUserId(long createdByUserId) {
		_catalog.setCreatedByUserId(createdByUserId);
	}

	/**
	* Returns the created by user uuid of this catalog.
	*
	* @return the created by user uuid of this catalog
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getCreatedByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _catalog.getCreatedByUserUuid();
	}

	/**
	* Sets the created by user uuid of this catalog.
	*
	* @param createdByUserUuid the created by user uuid of this catalog
	*/
	@Override
	public void setCreatedByUserUuid(java.lang.String createdByUserUuid) {
		_catalog.setCreatedByUserUuid(createdByUserUuid);
	}

	/**
	* Returns the create date of this catalog.
	*
	* @return the create date of this catalog
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _catalog.getCreateDate();
	}

	/**
	* Sets the create date of this catalog.
	*
	* @param createDate the create date of this catalog
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_catalog.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this catalog.
	*
	* @return the modified date of this catalog
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _catalog.getModifiedDate();
	}

	/**
	* Sets the modified date of this catalog.
	*
	* @param modifiedDate the modified date of this catalog
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_catalog.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the item type ID of this catalog.
	*
	* @return the item type ID of this catalog
	*/
	@Override
	public long getItemTypeId() {
		return _catalog.getItemTypeId();
	}

	/**
	* Sets the item type ID of this catalog.
	*
	* @param itemTypeId the item type ID of this catalog
	*/
	@Override
	public void setItemTypeId(long itemTypeId) {
		_catalog.setItemTypeId(itemTypeId);
	}

	/**
	* Returns the title of this catalog.
	*
	* @return the title of this catalog
	*/
	@Override
	public java.lang.String getTitle() {
		return _catalog.getTitle();
	}

	/**
	* Sets the title of this catalog.
	*
	* @param title the title of this catalog
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_catalog.setTitle(title);
	}

	/**
	* Returns the author of this catalog.
	*
	* @return the author of this catalog
	*/
	@Override
	public java.lang.String getAuthor() {
		return _catalog.getAuthor();
	}

	/**
	* Sets the author of this catalog.
	*
	* @param author the author of this catalog
	*/
	@Override
	public void setAuthor(java.lang.String author) {
		_catalog.setAuthor(author);
	}

	/**
	* Returns the publisher of this catalog.
	*
	* @return the publisher of this catalog
	*/
	@Override
	public java.lang.String getPublisher() {
		return _catalog.getPublisher();
	}

	/**
	* Sets the publisher of this catalog.
	*
	* @param publisher the publisher of this catalog
	*/
	@Override
	public void setPublisher(java.lang.String publisher) {
		_catalog.setPublisher(publisher);
	}

	/**
	* Returns the isbn of this catalog.
	*
	* @return the isbn of this catalog
	*/
	@Override
	public java.lang.String getIsbn() {
		return _catalog.getIsbn();
	}

	/**
	* Sets the isbn of this catalog.
	*
	* @param isbn the isbn of this catalog
	*/
	@Override
	public void setIsbn(java.lang.String isbn) {
		_catalog.setIsbn(isbn);
	}

	/**
	* Returns the issn of this catalog.
	*
	* @return the issn of this catalog
	*/
	@Override
	public java.lang.String getIssn() {
		return _catalog.getIssn();
	}

	/**
	* Sets the issn of this catalog.
	*
	* @param issn the issn of this catalog
	*/
	@Override
	public void setIssn(java.lang.String issn) {
		_catalog.setIssn(issn);
	}

	/**
	* Returns the call number of this catalog.
	*
	* @return the call number of this catalog
	*/
	@Override
	public java.lang.String getCallNumber() {
		return _catalog.getCallNumber();
	}

	/**
	* Sets the call number of this catalog.
	*
	* @param callNumber the call number of this catalog
	*/
	@Override
	public void setCallNumber(java.lang.String callNumber) {
		_catalog.setCallNumber(callNumber);
	}

	/**
	* Returns the u u i d of this catalog.
	*
	* @return the u u i d of this catalog
	*/
	@Override
	public java.lang.String getUUID() {
		return _catalog.getUUID();
	}

	/**
	* Sets the u u i d of this catalog.
	*
	* @param UUID the u u i d of this catalog
	*/
	@Override
	public void setUUID(java.lang.String UUID) {
		_catalog.setUUID(UUID);
	}

	/**
	* Returns the catalog abstract of this catalog.
	*
	* @return the catalog abstract of this catalog
	*/
	@Override
	public java.lang.String getCatalogAbstract() {
		return _catalog.getCatalogAbstract();
	}

	/**
	* Sets the catalog abstract of this catalog.
	*
	* @param catalogAbstract the catalog abstract of this catalog
	*/
	@Override
	public void setCatalogAbstract(java.lang.String catalogAbstract) {
		_catalog.setCatalogAbstract(catalogAbstract);
	}

	/**
	* Returns the template ID of this catalog.
	*
	* @return the template ID of this catalog
	*/
	@Override
	public long getTemplateId() {
		return _catalog.getTemplateId();
	}

	/**
	* Sets the template ID of this catalog.
	*
	* @param templateId the template ID of this catalog
	*/
	@Override
	public void setTemplateId(long templateId) {
		_catalog.setTemplateId(templateId);
	}

	/**
	* Returns the visible of this catalog.
	*
	* @return the visible of this catalog
	*/
	@Override
	public boolean getVisible() {
		return _catalog.getVisible();
	}

	/**
	* Returns <code>true</code> if this catalog is visible.
	*
	* @return <code>true</code> if this catalog is visible; <code>false</code> otherwise
	*/
	@Override
	public boolean isVisible() {
		return _catalog.isVisible();
	}

	/**
	* Sets whether this catalog is visible.
	*
	* @param visible the visible of this catalog
	*/
	@Override
	public void setVisible(boolean visible) {
		_catalog.setVisible(visible);
	}

	/**
	* Returns the cover image ID of this catalog.
	*
	* @return the cover image ID of this catalog
	*/
	@Override
	public long getCoverImageId() {
		return _catalog.getCoverImageId();
	}

	/**
	* Sets the cover image ID of this catalog.
	*
	* @param coverImageId the cover image ID of this catalog
	*/
	@Override
	public void setCoverImageId(long coverImageId) {
		_catalog.setCoverImageId(coverImageId);
	}

	/**
	* Returns the marc of this catalog.
	*
	* @return the marc of this catalog
	*/
	@Override
	public java.lang.String getMarc() {
		return _catalog.getMarc();
	}

	/**
	* Sets the marc of this catalog.
	*
	* @param marc the marc of this catalog
	*/
	@Override
	public void setMarc(java.lang.String marc) {
		_catalog.setMarc(marc);
	}

	/**
	* Returns the workflow status of this catalog.
	*
	* @return the workflow status of this catalog
	*/
	@Override
	public int getWorkflowStatus() {
		return _catalog.getWorkflowStatus();
	}

	/**
	* Sets the workflow status of this catalog.
	*
	* @param workflowStatus the workflow status of this catalog
	*/
	@Override
	public void setWorkflowStatus(int workflowStatus) {
		_catalog.setWorkflowStatus(workflowStatus);
	}

	@Override
	public boolean isNew() {
		return _catalog.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_catalog.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _catalog.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_catalog.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _catalog.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _catalog.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_catalog.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _catalog.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_catalog.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_catalog.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_catalog.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CatalogWrapper((Catalog)_catalog.clone());
	}

	@Override
	public int compareTo(com.kencana.lms.model.Catalog catalog) {
		return _catalog.compareTo(catalog);
	}

	@Override
	public int hashCode() {
		return _catalog.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.kencana.lms.model.Catalog> toCacheModel() {
		return _catalog.toCacheModel();
	}

	@Override
	public com.kencana.lms.model.Catalog toEscapedModel() {
		return new CatalogWrapper(_catalog.toEscapedModel());
	}

	@Override
	public com.kencana.lms.model.Catalog toUnescapedModel() {
		return new CatalogWrapper(_catalog.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _catalog.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _catalog.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_catalog.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CatalogWrapper)) {
			return false;
		}

		CatalogWrapper catalogWrapper = (CatalogWrapper)obj;

		if (Validator.equals(_catalog, catalogWrapper._catalog)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Catalog getWrappedCatalog() {
		return _catalog;
	}

	@Override
	public Catalog getWrappedModel() {
		return _catalog;
	}

	@Override
	public void resetOriginalValues() {
		_catalog.resetOriginalValues();
	}

	private Catalog _catalog;
}