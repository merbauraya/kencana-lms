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

import com.kencana.lms.service.CircTransHistoryLocalServiceUtil;
import com.kencana.lms.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mazlan Mat
 */
public class CircTransHistoryClp extends BaseModelImpl<CircTransHistory>
	implements CircTransHistory {
	public CircTransHistoryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CircTransHistory.class;
	}

	@Override
	public String getModelClassName() {
		return CircTransHistory.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _transId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTransId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _transId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("transId", getTransId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("patronId", getPatronId());
		attributes.put("catalogItemId", getCatalogItemId());
		attributes.put("transDate", getTransDate());
		attributes.put("dueDate", getDueDate());
		attributes.put("overdue", getOverdue());
		attributes.put("returnDate", getReturnDate());
		attributes.put("lastRenewDate", getLastRenewDate());
		attributes.put("renewCount", getRenewCount());
		attributes.put("fineAmount", getFineAmount());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long transId = (Long)attributes.get("transId");

		if (transId != null) {
			setTransId(transId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		Long patronId = (Long)attributes.get("patronId");

		if (patronId != null) {
			setPatronId(patronId);
		}

		Long catalogItemId = (Long)attributes.get("catalogItemId");

		if (catalogItemId != null) {
			setCatalogItemId(catalogItemId);
		}

		Date transDate = (Date)attributes.get("transDate");

		if (transDate != null) {
			setTransDate(transDate);
		}

		Date dueDate = (Date)attributes.get("dueDate");

		if (dueDate != null) {
			setDueDate(dueDate);
		}

		Boolean overdue = (Boolean)attributes.get("overdue");

		if (overdue != null) {
			setOverdue(overdue);
		}

		Date returnDate = (Date)attributes.get("returnDate");

		if (returnDate != null) {
			setReturnDate(returnDate);
		}

		Date lastRenewDate = (Date)attributes.get("lastRenewDate");

		if (lastRenewDate != null) {
			setLastRenewDate(lastRenewDate);
		}

		Integer renewCount = (Integer)attributes.get("renewCount");

		if (renewCount != null) {
			setRenewCount(renewCount);
		}

		Double fineAmount = (Double)attributes.get("fineAmount");

		if (fineAmount != null) {
			setFineAmount(fineAmount);
		}
	}

	@Override
	public long getTransId() {
		return _transId;
	}

	@Override
	public void setTransId(long transId) {
		_transId = transId;

		if (_circTransHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _circTransHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setTransId", long.class);

				method.invoke(_circTransHistoryRemoteModel, transId);
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

		if (_circTransHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _circTransHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_circTransHistoryRemoteModel, companyId);
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

		if (_circTransHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _circTransHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_circTransHistoryRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLibraryId() {
		return _libraryId;
	}

	@Override
	public void setLibraryId(long libraryId) {
		_libraryId = libraryId;

		if (_circTransHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _circTransHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryId", long.class);

				method.invoke(_circTransHistoryRemoteModel, libraryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPatronId() {
		return _patronId;
	}

	@Override
	public void setPatronId(long patronId) {
		_patronId = patronId;

		if (_circTransHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _circTransHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setPatronId", long.class);

				method.invoke(_circTransHistoryRemoteModel, patronId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCatalogItemId() {
		return _catalogItemId;
	}

	@Override
	public void setCatalogItemId(long catalogItemId) {
		_catalogItemId = catalogItemId;

		if (_circTransHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _circTransHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCatalogItemId", long.class);

				method.invoke(_circTransHistoryRemoteModel, catalogItemId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getTransDate() {
		return _transDate;
	}

	@Override
	public void setTransDate(Date transDate) {
		_transDate = transDate;

		if (_circTransHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _circTransHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setTransDate", Date.class);

				method.invoke(_circTransHistoryRemoteModel, transDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDueDate() {
		return _dueDate;
	}

	@Override
	public void setDueDate(Date dueDate) {
		_dueDate = dueDate;

		if (_circTransHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _circTransHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setDueDate", Date.class);

				method.invoke(_circTransHistoryRemoteModel, dueDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getOverdue() {
		return _overdue;
	}

	@Override
	public boolean isOverdue() {
		return _overdue;
	}

	@Override
	public void setOverdue(boolean overdue) {
		_overdue = overdue;

		if (_circTransHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _circTransHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setOverdue", boolean.class);

				method.invoke(_circTransHistoryRemoteModel, overdue);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getReturnDate() {
		return _returnDate;
	}

	@Override
	public void setReturnDate(Date returnDate) {
		_returnDate = returnDate;

		if (_circTransHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _circTransHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setReturnDate", Date.class);

				method.invoke(_circTransHistoryRemoteModel, returnDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLastRenewDate() {
		return _lastRenewDate;
	}

	@Override
	public void setLastRenewDate(Date lastRenewDate) {
		_lastRenewDate = lastRenewDate;

		if (_circTransHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _circTransHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setLastRenewDate", Date.class);

				method.invoke(_circTransHistoryRemoteModel, lastRenewDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getRenewCount() {
		return _renewCount;
	}

	@Override
	public void setRenewCount(int renewCount) {
		_renewCount = renewCount;

		if (_circTransHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _circTransHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setRenewCount", int.class);

				method.invoke(_circTransHistoryRemoteModel, renewCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Double getFineAmount() {
		return _fineAmount;
	}

	@Override
	public void setFineAmount(Double fineAmount) {
		_fineAmount = fineAmount;

		if (_circTransHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _circTransHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setFineAmount", Double.class);

				method.invoke(_circTransHistoryRemoteModel, fineAmount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCircTransHistoryRemoteModel() {
		return _circTransHistoryRemoteModel;
	}

	public void setCircTransHistoryRemoteModel(
		BaseModel<?> circTransHistoryRemoteModel) {
		_circTransHistoryRemoteModel = circTransHistoryRemoteModel;
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

		Class<?> remoteModelClass = _circTransHistoryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_circTransHistoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CircTransHistoryLocalServiceUtil.addCircTransHistory(this);
		}
		else {
			CircTransHistoryLocalServiceUtil.updateCircTransHistory(this);
		}
	}

	@Override
	public CircTransHistory toEscapedModel() {
		return (CircTransHistory)ProxyUtil.newProxyInstance(CircTransHistory.class.getClassLoader(),
			new Class[] { CircTransHistory.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CircTransHistoryClp clone = new CircTransHistoryClp();

		clone.setTransId(getTransId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setLibraryId(getLibraryId());
		clone.setPatronId(getPatronId());
		clone.setCatalogItemId(getCatalogItemId());
		clone.setTransDate(getTransDate());
		clone.setDueDate(getDueDate());
		clone.setOverdue(getOverdue());
		clone.setReturnDate(getReturnDate());
		clone.setLastRenewDate(getLastRenewDate());
		clone.setRenewCount(getRenewCount());
		clone.setFineAmount(getFineAmount());

		return clone;
	}

	@Override
	public int compareTo(CircTransHistory circTransHistory) {
		long primaryKey = circTransHistory.getPrimaryKey();

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

		if (!(obj instanceof CircTransHistoryClp)) {
			return false;
		}

		CircTransHistoryClp circTransHistory = (CircTransHistoryClp)obj;

		long primaryKey = circTransHistory.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{transId=");
		sb.append(getTransId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", libraryId=");
		sb.append(getLibraryId());
		sb.append(", patronId=");
		sb.append(getPatronId());
		sb.append(", catalogItemId=");
		sb.append(getCatalogItemId());
		sb.append(", transDate=");
		sb.append(getTransDate());
		sb.append(", dueDate=");
		sb.append(getDueDate());
		sb.append(", overdue=");
		sb.append(getOverdue());
		sb.append(", returnDate=");
		sb.append(getReturnDate());
		sb.append(", lastRenewDate=");
		sb.append(getLastRenewDate());
		sb.append(", renewCount=");
		sb.append(getRenewCount());
		sb.append(", fineAmount=");
		sb.append(getFineAmount());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.kencana.lms.model.CircTransHistory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>transId</column-name><column-value><![CDATA[");
		sb.append(getTransId());
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
			"<column><column-name>libraryId</column-name><column-value><![CDATA[");
		sb.append(getLibraryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>patronId</column-name><column-value><![CDATA[");
		sb.append(getPatronId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>catalogItemId</column-name><column-value><![CDATA[");
		sb.append(getCatalogItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>transDate</column-name><column-value><![CDATA[");
		sb.append(getTransDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dueDate</column-name><column-value><![CDATA[");
		sb.append(getDueDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>overdue</column-name><column-value><![CDATA[");
		sb.append(getOverdue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>returnDate</column-name><column-value><![CDATA[");
		sb.append(getReturnDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastRenewDate</column-name><column-value><![CDATA[");
		sb.append(getLastRenewDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>renewCount</column-name><column-value><![CDATA[");
		sb.append(getRenewCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fineAmount</column-name><column-value><![CDATA[");
		sb.append(getFineAmount());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _transId;
	private long _companyId;
	private long _groupId;
	private long _libraryId;
	private long _patronId;
	private long _catalogItemId;
	private Date _transDate;
	private Date _dueDate;
	private boolean _overdue;
	private Date _returnDate;
	private Date _lastRenewDate;
	private int _renewCount;
	private Double _fineAmount;
	private BaseModel<?> _circTransHistoryRemoteModel;
	private Class<?> _clpSerializerClass = com.kencana.lms.service.ClpSerializer.class;
}