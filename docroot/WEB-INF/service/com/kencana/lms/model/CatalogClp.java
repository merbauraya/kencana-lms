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

import com.kencana.lms.service.CatalogLocalServiceUtil;
import com.kencana.lms.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mazlan Mat
 */
public class CatalogClp extends BaseModelImpl<Catalog> implements Catalog {
	public CatalogClp() {
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
	public long getPrimaryKey() {
		return _catalogId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCatalogId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _catalogId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getCatalogId() {
		return _catalogId;
	}

	@Override
	public void setCatalogId(long catalogId) {
		_catalogId = catalogId;

		if (_catalogRemoteModel != null) {
			try {
				Class<?> clazz = _catalogRemoteModel.getClass();

				Method method = clazz.getMethod("setCatalogId", long.class);

				method.invoke(_catalogRemoteModel, catalogId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_catalogRemoteModel != null) {
			try {
				Class<?> clazz = _catalogRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_catalogRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_catalogRemoteModel != null) {
			try {
				Class<?> clazz = _catalogRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_catalogRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_catalogRemoteModel != null) {
			try {
				Class<?> clazz = _catalogRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_catalogRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_catalogRemoteModel != null) {
			try {
				Class<?> clazz = _catalogRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_catalogRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCreatedByUserId() {
		return _createdByUserId;
	}

	@Override
	public void setCreatedByUserId(long createdByUserId) {
		_createdByUserId = createdByUserId;

		if (_catalogRemoteModel != null) {
			try {
				Class<?> clazz = _catalogRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedByUserId", long.class);

				method.invoke(_catalogRemoteModel, createdByUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCreatedByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getCreatedByUserId(), "uuid",
			_createdByUserUuid);
	}

	@Override
	public void setCreatedByUserUuid(String createdByUserUuid) {
		_createdByUserUuid = createdByUserUuid;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_catalogRemoteModel != null) {
			try {
				Class<?> clazz = _catalogRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_catalogRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_catalogRemoteModel != null) {
			try {
				Class<?> clazz = _catalogRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_catalogRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getItemTypeId() {
		return _itemTypeId;
	}

	@Override
	public void setItemTypeId(long itemTypeId) {
		_itemTypeId = itemTypeId;

		if (_catalogRemoteModel != null) {
			try {
				Class<?> clazz = _catalogRemoteModel.getClass();

				Method method = clazz.getMethod("setItemTypeId", long.class);

				method.invoke(_catalogRemoteModel, itemTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_catalogRemoteModel != null) {
			try {
				Class<?> clazz = _catalogRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_catalogRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAuthor() {
		return _author;
	}

	@Override
	public void setAuthor(String author) {
		_author = author;

		if (_catalogRemoteModel != null) {
			try {
				Class<?> clazz = _catalogRemoteModel.getClass();

				Method method = clazz.getMethod("setAuthor", String.class);

				method.invoke(_catalogRemoteModel, author);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPublisher() {
		return _publisher;
	}

	@Override
	public void setPublisher(String publisher) {
		_publisher = publisher;

		if (_catalogRemoteModel != null) {
			try {
				Class<?> clazz = _catalogRemoteModel.getClass();

				Method method = clazz.getMethod("setPublisher", String.class);

				method.invoke(_catalogRemoteModel, publisher);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIsbn() {
		return _isbn;
	}

	@Override
	public void setIsbn(String isbn) {
		_isbn = isbn;

		if (_catalogRemoteModel != null) {
			try {
				Class<?> clazz = _catalogRemoteModel.getClass();

				Method method = clazz.getMethod("setIsbn", String.class);

				method.invoke(_catalogRemoteModel, isbn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIssn() {
		return _issn;
	}

	@Override
	public void setIssn(String issn) {
		_issn = issn;

		if (_catalogRemoteModel != null) {
			try {
				Class<?> clazz = _catalogRemoteModel.getClass();

				Method method = clazz.getMethod("setIssn", String.class);

				method.invoke(_catalogRemoteModel, issn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCallNumber() {
		return _callNumber;
	}

	@Override
	public void setCallNumber(String callNumber) {
		_callNumber = callNumber;

		if (_catalogRemoteModel != null) {
			try {
				Class<?> clazz = _catalogRemoteModel.getClass();

				Method method = clazz.getMethod("setCallNumber", String.class);

				method.invoke(_catalogRemoteModel, callNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUUID() {
		return _UUID;
	}

	@Override
	public void setUUID(String UUID) {
		_UUID = UUID;

		if (_catalogRemoteModel != null) {
			try {
				Class<?> clazz = _catalogRemoteModel.getClass();

				Method method = clazz.getMethod("setUUID", String.class);

				method.invoke(_catalogRemoteModel, UUID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCatalogAbstract() {
		return _catalogAbstract;
	}

	@Override
	public void setCatalogAbstract(String catalogAbstract) {
		_catalogAbstract = catalogAbstract;

		if (_catalogRemoteModel != null) {
			try {
				Class<?> clazz = _catalogRemoteModel.getClass();

				Method method = clazz.getMethod("setCatalogAbstract",
						String.class);

				method.invoke(_catalogRemoteModel, catalogAbstract);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTemplateId() {
		return _templateId;
	}

	@Override
	public void setTemplateId(long templateId) {
		_templateId = templateId;

		if (_catalogRemoteModel != null) {
			try {
				Class<?> clazz = _catalogRemoteModel.getClass();

				Method method = clazz.getMethod("setTemplateId", long.class);

				method.invoke(_catalogRemoteModel, templateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getVisible() {
		return _visible;
	}

	@Override
	public boolean isVisible() {
		return _visible;
	}

	@Override
	public void setVisible(boolean visible) {
		_visible = visible;

		if (_catalogRemoteModel != null) {
			try {
				Class<?> clazz = _catalogRemoteModel.getClass();

				Method method = clazz.getMethod("setVisible", boolean.class);

				method.invoke(_catalogRemoteModel, visible);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCoverImageId() {
		return _coverImageId;
	}

	@Override
	public void setCoverImageId(long coverImageId) {
		_coverImageId = coverImageId;

		if (_catalogRemoteModel != null) {
			try {
				Class<?> clazz = _catalogRemoteModel.getClass();

				Method method = clazz.getMethod("setCoverImageId", long.class);

				method.invoke(_catalogRemoteModel, coverImageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMarc() {
		return _marc;
	}

	@Override
	public void setMarc(String marc) {
		_marc = marc;

		if (_catalogRemoteModel != null) {
			try {
				Class<?> clazz = _catalogRemoteModel.getClass();

				Method method = clazz.getMethod("setMarc", String.class);

				method.invoke(_catalogRemoteModel, marc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getWorkflowStatus() {
		return _workflowStatus;
	}

	@Override
	public void setWorkflowStatus(int workflowStatus) {
		_workflowStatus = workflowStatus;

		if (_catalogRemoteModel != null) {
			try {
				Class<?> clazz = _catalogRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkflowStatus", int.class);

				method.invoke(_catalogRemoteModel, workflowStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCatalogRemoteModel() {
		return _catalogRemoteModel;
	}

	public void setCatalogRemoteModel(BaseModel<?> catalogRemoteModel) {
		_catalogRemoteModel = catalogRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _catalogRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_catalogRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CatalogLocalServiceUtil.addCatalog(this);
		}
		else {
			CatalogLocalServiceUtil.updateCatalog(this);
		}
	}

	@Override
	public Catalog toEscapedModel() {
		return (Catalog)ProxyUtil.newProxyInstance(Catalog.class.getClassLoader(),
			new Class[] { Catalog.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CatalogClp clone = new CatalogClp();

		clone.setCatalogId(getCatalogId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreatedByUserId(getCreatedByUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setItemTypeId(getItemTypeId());
		clone.setTitle(getTitle());
		clone.setAuthor(getAuthor());
		clone.setPublisher(getPublisher());
		clone.setIsbn(getIsbn());
		clone.setIssn(getIssn());
		clone.setCallNumber(getCallNumber());
		clone.setUUID(getUUID());
		clone.setCatalogAbstract(getCatalogAbstract());
		clone.setTemplateId(getTemplateId());
		clone.setVisible(getVisible());
		clone.setCoverImageId(getCoverImageId());
		clone.setMarc(getMarc());
		clone.setWorkflowStatus(getWorkflowStatus());

		return clone;
	}

	@Override
	public int compareTo(Catalog catalog) {
		long primaryKey = catalog.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CatalogClp)) {
			return false;
		}

		CatalogClp catalog = (CatalogClp)obj;

		long primaryKey = catalog.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{catalogId=");
		sb.append(getCatalogId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createdByUserId=");
		sb.append(getCreatedByUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", itemTypeId=");
		sb.append(getItemTypeId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", author=");
		sb.append(getAuthor());
		sb.append(", publisher=");
		sb.append(getPublisher());
		sb.append(", isbn=");
		sb.append(getIsbn());
		sb.append(", issn=");
		sb.append(getIssn());
		sb.append(", callNumber=");
		sb.append(getCallNumber());
		sb.append(", UUID=");
		sb.append(getUUID());
		sb.append(", catalogAbstract=");
		sb.append(getCatalogAbstract());
		sb.append(", templateId=");
		sb.append(getTemplateId());
		sb.append(", visible=");
		sb.append(getVisible());
		sb.append(", coverImageId=");
		sb.append(getCoverImageId());
		sb.append(", marc=");
		sb.append(getMarc());
		sb.append(", workflowStatus=");
		sb.append(getWorkflowStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(70);

		sb.append("<model><model-name>");
		sb.append("com.kencana.lms.model.Catalog");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>catalogId</column-name><column-value><![CDATA[");
		sb.append(getCatalogId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdByUserId</column-name><column-value><![CDATA[");
		sb.append(getCreatedByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemTypeId</column-name><column-value><![CDATA[");
		sb.append(getItemTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>author</column-name><column-value><![CDATA[");
		sb.append(getAuthor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publisher</column-name><column-value><![CDATA[");
		sb.append(getPublisher());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isbn</column-name><column-value><![CDATA[");
		sb.append(getIsbn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>issn</column-name><column-value><![CDATA[");
		sb.append(getIssn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>callNumber</column-name><column-value><![CDATA[");
		sb.append(getCallNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>UUID</column-name><column-value><![CDATA[");
		sb.append(getUUID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>catalogAbstract</column-name><column-value><![CDATA[");
		sb.append(getCatalogAbstract());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>templateId</column-name><column-value><![CDATA[");
		sb.append(getTemplateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>visible</column-name><column-value><![CDATA[");
		sb.append(getVisible());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>coverImageId</column-name><column-value><![CDATA[");
		sb.append(getCoverImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>marc</column-name><column-value><![CDATA[");
		sb.append(getMarc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workflowStatus</column-name><column-value><![CDATA[");
		sb.append(getWorkflowStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _catalogId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private long _createdByUserId;
	private String _createdByUserUuid;
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
	private BaseModel<?> _catalogRemoteModel;
	private Class<?> _clpSerializerClass = com.kencana.lms.service.ClpSerializer.class;
}