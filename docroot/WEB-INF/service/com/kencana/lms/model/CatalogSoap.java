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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.kencana.lms.service.http.CatalogServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.kencana.lms.service.http.CatalogServiceSoap
 * @generated
 */
public class CatalogSoap implements Serializable {
	public static CatalogSoap toSoapModel(Catalog model) {
		CatalogSoap soapModel = new CatalogSoap();

		soapModel.setCatalogId(model.getCatalogId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreatedByUserId(model.getCreatedByUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setItemTypeId(model.getItemTypeId());
		soapModel.setTitle(model.getTitle());
		soapModel.setAuthor(model.getAuthor());
		soapModel.setPublisher(model.getPublisher());
		soapModel.setIsbn(model.getIsbn());
		soapModel.setIssn(model.getIssn());
		soapModel.setCallNumber(model.getCallNumber());
		soapModel.setUUID(model.getUUID());
		soapModel.setCatalogAbstract(model.getCatalogAbstract());
		soapModel.setTemplateId(model.getTemplateId());
		soapModel.setVisible(model.getVisible());
		soapModel.setCoverImageId(model.getCoverImageId());
		soapModel.setMarc(model.getMarc());
		soapModel.setWorkflowStatus(model.getWorkflowStatus());

		return soapModel;
	}

	public static CatalogSoap[] toSoapModels(Catalog[] models) {
		CatalogSoap[] soapModels = new CatalogSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CatalogSoap[][] toSoapModels(Catalog[][] models) {
		CatalogSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CatalogSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CatalogSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CatalogSoap[] toSoapModels(List<Catalog> models) {
		List<CatalogSoap> soapModels = new ArrayList<CatalogSoap>(models.size());

		for (Catalog model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CatalogSoap[soapModels.size()]);
	}

	public CatalogSoap() {
	}

	public long getPrimaryKey() {
		return _catalogId;
	}

	public void setPrimaryKey(long pk) {
		setCatalogId(pk);
	}

	public long getCatalogId() {
		return _catalogId;
	}

	public void setCatalogId(long catalogId) {
		_catalogId = catalogId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public long getCreatedByUserId() {
		return _createdByUserId;
	}

	public void setCreatedByUserId(long createdByUserId) {
		_createdByUserId = createdByUserId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getItemTypeId() {
		return _itemTypeId;
	}

	public void setItemTypeId(long itemTypeId) {
		_itemTypeId = itemTypeId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getAuthor() {
		return _author;
	}

	public void setAuthor(String author) {
		_author = author;
	}

	public String getPublisher() {
		return _publisher;
	}

	public void setPublisher(String publisher) {
		_publisher = publisher;
	}

	public String getIsbn() {
		return _isbn;
	}

	public void setIsbn(String isbn) {
		_isbn = isbn;
	}

	public String getIssn() {
		return _issn;
	}

	public void setIssn(String issn) {
		_issn = issn;
	}

	public String getCallNumber() {
		return _callNumber;
	}

	public void setCallNumber(String callNumber) {
		_callNumber = callNumber;
	}

	public String getUUID() {
		return _UUID;
	}

	public void setUUID(String UUID) {
		_UUID = UUID;
	}

	public String getCatalogAbstract() {
		return _catalogAbstract;
	}

	public void setCatalogAbstract(String catalogAbstract) {
		_catalogAbstract = catalogAbstract;
	}

	public long getTemplateId() {
		return _templateId;
	}

	public void setTemplateId(long templateId) {
		_templateId = templateId;
	}

	public boolean getVisible() {
		return _visible;
	}

	public boolean isVisible() {
		return _visible;
	}

	public void setVisible(boolean visible) {
		_visible = visible;
	}

	public long getCoverImageId() {
		return _coverImageId;
	}

	public void setCoverImageId(long coverImageId) {
		_coverImageId = coverImageId;
	}

	public String getMarc() {
		return _marc;
	}

	public void setMarc(String marc) {
		_marc = marc;
	}

	public int getWorkflowStatus() {
		return _workflowStatus;
	}

	public void setWorkflowStatus(int workflowStatus) {
		_workflowStatus = workflowStatus;
	}

	private long _catalogId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private long _createdByUserId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _itemTypeId;
	private String _title;
	private String _author;
	private String _publisher;
	private String _isbn;
	private String _issn;
	private String _callNumber;
	private String _UUID;
	private String _catalogAbstract;
	private long _templateId;
	private boolean _visible;
	private long _coverImageId;
	private String _marc;
	private int _workflowStatus;
}