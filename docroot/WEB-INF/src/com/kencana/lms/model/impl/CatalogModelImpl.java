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

package com.kencana.lms.model.impl;

import com.kencana.lms.model.Catalog;
import com.kencana.lms.model.CatalogModel;
import com.kencana.lms.model.CatalogSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Catalog service. Represents a row in the &quot;Kencana_Catalog&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.kencana.lms.model.CatalogModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CatalogImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see CatalogImpl
 * @see com.kencana.lms.model.Catalog
 * @see com.kencana.lms.model.CatalogModel
 * @generated
 */
@JSON(strict = true)
public class CatalogModelImpl extends BaseModelImpl<Catalog>
	implements CatalogModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a catalog model instance should use the {@link com.kencana.lms.model.Catalog} interface instead.
	 */
	public static final String TABLE_NAME = "Kencana_Catalog";
	public static final Object[][] TABLE_COLUMNS = {
			{ "catalogId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createdByUserId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "itemTypeId", Types.BIGINT },
			{ "title", Types.VARCHAR },
			{ "author", Types.VARCHAR },
			{ "publisher", Types.VARCHAR },
			{ "isbn", Types.VARCHAR },
			{ "issn", Types.VARCHAR },
			{ "callNumber", Types.VARCHAR },
			{ "UUID", Types.VARCHAR },
			{ "catalogAbstract", Types.VARCHAR },
			{ "templateId", Types.BIGINT },
			{ "visible", Types.BOOLEAN },
			{ "coverImageId", Types.BIGINT },
			{ "marc", Types.VARCHAR },
			{ "workflowStatus", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table Kencana_Catalog (catalogId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,userName VARCHAR(75) null,createdByUserId LONG,createDate DATE null,modifiedDate DATE null,itemTypeId LONG,title TEXT null,author TEXT null,publisher VARCHAR(75) null,isbn VARCHAR(75) null,issn VARCHAR(75) null,callNumber VARCHAR(75) null,UUID VARCHAR(75) null,catalogAbstract TEXT null,templateId LONG,visible BOOLEAN,coverImageId LONG,marc TEXT null,workflowStatus INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table Kencana_Catalog";
	public static final String ORDER_BY_JPQL = " ORDER BY catalog.catalogId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Kencana_Catalog.catalogId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.kencana.lms.model.Catalog"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.kencana.lms.model.Catalog"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.kencana.lms.model.Catalog"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long ITEMTYPEID_COLUMN_BITMASK = 4L;
	public static long TEMPLATEID_COLUMN_BITMASK = 8L;
	public static long WORKFLOWSTATUS_COLUMN_BITMASK = 16L;
	public static long CATALOGID_COLUMN_BITMASK = 32L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Catalog toModel(CatalogSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Catalog model = new CatalogImpl();

		model.setCatalogId(soapModel.getCatalogId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreatedByUserId(soapModel.getCreatedByUserId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setItemTypeId(soapModel.getItemTypeId());
		model.setTitle(soapModel.getTitle());
		model.setAuthor(soapModel.getAuthor());
		model.setPublisher(soapModel.getPublisher());
		model.setIsbn(soapModel.getIsbn());
		model.setIssn(soapModel.getIssn());
		model.setCallNumber(soapModel.getCallNumber());
		model.setUUID(soapModel.getUUID());
		model.setCatalogAbstract(soapModel.getCatalogAbstract());
		model.setTemplateId(soapModel.getTemplateId());
		model.setVisible(soapModel.getVisible());
		model.setCoverImageId(soapModel.getCoverImageId());
		model.setMarc(soapModel.getMarc());
		model.setWorkflowStatus(soapModel.getWorkflowStatus());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Catalog> toModels(CatalogSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Catalog> models = new ArrayList<Catalog>(soapModels.length);

		for (CatalogSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.kencana.lms.model.Catalog"));

	public CatalogModelImpl() {
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

	@JSON
	@Override
	public long getCatalogId() {
		return _catalogId;
	}

	@Override
	public void setCatalogId(long catalogId) {
		_catalogId = catalogId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public long getCreatedByUserId() {
		return _createdByUserId;
	}

	@Override
	public void setCreatedByUserId(long createdByUserId) {
		_createdByUserId = createdByUserId;
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

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getItemTypeId() {
		return _itemTypeId;
	}

	@Override
	public void setItemTypeId(long itemTypeId) {
		_columnBitmask |= ITEMTYPEID_COLUMN_BITMASK;

		if (!_setOriginalItemTypeId) {
			_setOriginalItemTypeId = true;

			_originalItemTypeId = _itemTypeId;
		}

		_itemTypeId = itemTypeId;
	}

	public long getOriginalItemTypeId() {
		return _originalItemTypeId;
	}

	@JSON
	@Override
	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		_title = title;
	}

	@JSON
	@Override
	public String getAuthor() {
		if (_author == null) {
			return StringPool.BLANK;
		}
		else {
			return _author;
		}
	}

	@Override
	public void setAuthor(String author) {
		_author = author;
	}

	@JSON
	@Override
	public String getPublisher() {
		if (_publisher == null) {
			return StringPool.BLANK;
		}
		else {
			return _publisher;
		}
	}

	@Override
	public void setPublisher(String publisher) {
		_publisher = publisher;
	}

	@JSON
	@Override
	public String getIsbn() {
		if (_isbn == null) {
			return StringPool.BLANK;
		}
		else {
			return _isbn;
		}
	}

	@Override
	public void setIsbn(String isbn) {
		_isbn = isbn;
	}

	@JSON
	@Override
	public String getIssn() {
		if (_issn == null) {
			return StringPool.BLANK;
		}
		else {
			return _issn;
		}
	}

	@Override
	public void setIssn(String issn) {
		_issn = issn;
	}

	@JSON
	@Override
	public String getCallNumber() {
		if (_callNumber == null) {
			return StringPool.BLANK;
		}
		else {
			return _callNumber;
		}
	}

	@Override
	public void setCallNumber(String callNumber) {
		_callNumber = callNumber;
	}

	@JSON
	@Override
	public String getUUID() {
		if (_UUID == null) {
			return StringPool.BLANK;
		}
		else {
			return _UUID;
		}
	}

	@Override
	public void setUUID(String UUID) {
		_UUID = UUID;
	}

	@JSON
	@Override
	public String getCatalogAbstract() {
		if (_catalogAbstract == null) {
			return StringPool.BLANK;
		}
		else {
			return _catalogAbstract;
		}
	}

	@Override
	public void setCatalogAbstract(String catalogAbstract) {
		_catalogAbstract = catalogAbstract;
	}

	@JSON
	@Override
	public long getTemplateId() {
		return _templateId;
	}

	@Override
	public void setTemplateId(long templateId) {
		_columnBitmask |= TEMPLATEID_COLUMN_BITMASK;

		if (!_setOriginalTemplateId) {
			_setOriginalTemplateId = true;

			_originalTemplateId = _templateId;
		}

		_templateId = templateId;
	}

	public long getOriginalTemplateId() {
		return _originalTemplateId;
	}

	@JSON
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
	}

	@JSON
	@Override
	public long getCoverImageId() {
		return _coverImageId;
	}

	@Override
	public void setCoverImageId(long coverImageId) {
		_coverImageId = coverImageId;
	}

	@JSON
	@Override
	public String getMarc() {
		if (_marc == null) {
			return StringPool.BLANK;
		}
		else {
			return _marc;
		}
	}

	@Override
	public void setMarc(String marc) {
		_marc = marc;
	}

	@JSON
	@Override
	public int getWorkflowStatus() {
		return _workflowStatus;
	}

	@Override
	public void setWorkflowStatus(int workflowStatus) {
		_columnBitmask |= WORKFLOWSTATUS_COLUMN_BITMASK;

		if (!_setOriginalWorkflowStatus) {
			_setOriginalWorkflowStatus = true;

			_originalWorkflowStatus = _workflowStatus;
		}

		_workflowStatus = workflowStatus;
	}

	public int getOriginalWorkflowStatus() {
		return _originalWorkflowStatus;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Catalog.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Catalog toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Catalog)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CatalogImpl catalogImpl = new CatalogImpl();

		catalogImpl.setCatalogId(getCatalogId());
		catalogImpl.setCompanyId(getCompanyId());
		catalogImpl.setGroupId(getGroupId());
		catalogImpl.setUserId(getUserId());
		catalogImpl.setUserName(getUserName());
		catalogImpl.setCreatedByUserId(getCreatedByUserId());
		catalogImpl.setCreateDate(getCreateDate());
		catalogImpl.setModifiedDate(getModifiedDate());
		catalogImpl.setItemTypeId(getItemTypeId());
		catalogImpl.setTitle(getTitle());
		catalogImpl.setAuthor(getAuthor());
		catalogImpl.setPublisher(getPublisher());
		catalogImpl.setIsbn(getIsbn());
		catalogImpl.setIssn(getIssn());
		catalogImpl.setCallNumber(getCallNumber());
		catalogImpl.setUUID(getUUID());
		catalogImpl.setCatalogAbstract(getCatalogAbstract());
		catalogImpl.setTemplateId(getTemplateId());
		catalogImpl.setVisible(getVisible());
		catalogImpl.setCoverImageId(getCoverImageId());
		catalogImpl.setMarc(getMarc());
		catalogImpl.setWorkflowStatus(getWorkflowStatus());

		catalogImpl.resetOriginalValues();

		return catalogImpl;
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

		if (!(obj instanceof Catalog)) {
			return false;
		}

		Catalog catalog = (Catalog)obj;

		long primaryKey = catalog.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		CatalogModelImpl catalogModelImpl = this;

		catalogModelImpl._originalCompanyId = catalogModelImpl._companyId;

		catalogModelImpl._setOriginalCompanyId = false;

		catalogModelImpl._originalGroupId = catalogModelImpl._groupId;

		catalogModelImpl._setOriginalGroupId = false;

		catalogModelImpl._originalItemTypeId = catalogModelImpl._itemTypeId;

		catalogModelImpl._setOriginalItemTypeId = false;

		catalogModelImpl._originalTemplateId = catalogModelImpl._templateId;

		catalogModelImpl._setOriginalTemplateId = false;

		catalogModelImpl._originalWorkflowStatus = catalogModelImpl._workflowStatus;

		catalogModelImpl._setOriginalWorkflowStatus = false;

		catalogModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Catalog> toCacheModel() {
		CatalogCacheModel catalogCacheModel = new CatalogCacheModel();

		catalogCacheModel.catalogId = getCatalogId();

		catalogCacheModel.companyId = getCompanyId();

		catalogCacheModel.groupId = getGroupId();

		catalogCacheModel.userId = getUserId();

		catalogCacheModel.userName = getUserName();

		String userName = catalogCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			catalogCacheModel.userName = null;
		}

		catalogCacheModel.createdByUserId = getCreatedByUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			catalogCacheModel.createDate = createDate.getTime();
		}
		else {
			catalogCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			catalogCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			catalogCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		catalogCacheModel.itemTypeId = getItemTypeId();

		catalogCacheModel.title = getTitle();

		String title = catalogCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			catalogCacheModel.title = null;
		}

		catalogCacheModel.author = getAuthor();

		String author = catalogCacheModel.author;

		if ((author != null) && (author.length() == 0)) {
			catalogCacheModel.author = null;
		}

		catalogCacheModel.publisher = getPublisher();

		String publisher = catalogCacheModel.publisher;

		if ((publisher != null) && (publisher.length() == 0)) {
			catalogCacheModel.publisher = null;
		}

		catalogCacheModel.isbn = getIsbn();

		String isbn = catalogCacheModel.isbn;

		if ((isbn != null) && (isbn.length() == 0)) {
			catalogCacheModel.isbn = null;
		}

		catalogCacheModel.issn = getIssn();

		String issn = catalogCacheModel.issn;

		if ((issn != null) && (issn.length() == 0)) {
			catalogCacheModel.issn = null;
		}

		catalogCacheModel.callNumber = getCallNumber();

		String callNumber = catalogCacheModel.callNumber;

		if ((callNumber != null) && (callNumber.length() == 0)) {
			catalogCacheModel.callNumber = null;
		}

		catalogCacheModel.UUID = getUUID();

		String UUID = catalogCacheModel.UUID;

		if ((UUID != null) && (UUID.length() == 0)) {
			catalogCacheModel.UUID = null;
		}

		catalogCacheModel.catalogAbstract = getCatalogAbstract();

		String catalogAbstract = catalogCacheModel.catalogAbstract;

		if ((catalogAbstract != null) && (catalogAbstract.length() == 0)) {
			catalogCacheModel.catalogAbstract = null;
		}

		catalogCacheModel.templateId = getTemplateId();

		catalogCacheModel.visible = getVisible();

		catalogCacheModel.coverImageId = getCoverImageId();

		catalogCacheModel.marc = getMarc();

		String marc = catalogCacheModel.marc;

		if ((marc != null) && (marc.length() == 0)) {
			catalogCacheModel.marc = null;
		}

		catalogCacheModel.workflowStatus = getWorkflowStatus();

		return catalogCacheModel;
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

	private static ClassLoader _classLoader = Catalog.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Catalog.class
		};
	private long _catalogId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private long _createdByUserId;
	private String _createdByUserUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private long _itemTypeId;
	private long _originalItemTypeId;
	private boolean _setOriginalItemTypeId;
	private String _title;
	private String _author;
	private String _publisher;
	private String _isbn;
	private String _issn;
	private String _callNumber;
	private String _UUID;
	private String _catalogAbstract;
	private long _templateId;
	private long _originalTemplateId;
	private boolean _setOriginalTemplateId;
	private boolean _visible;
	private long _coverImageId;
	private String _marc;
	private int _workflowStatus;
	private int _originalWorkflowStatus;
	private boolean _setOriginalWorkflowStatus;
	private long _columnBitmask;
	private Catalog _escapedModel;
}