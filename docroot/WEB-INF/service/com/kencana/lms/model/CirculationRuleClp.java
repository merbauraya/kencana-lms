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

import com.kencana.lms.service.CirculationRuleLocalServiceUtil;
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
public class CirculationRuleClp extends BaseModelImpl<CirculationRule>
	implements CirculationRule {
	public CirculationRuleClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CirculationRule.class;
	}

	@Override
	public String getModelClassName() {
		return CirculationRule.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _circulationRuleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCirculationRuleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _circulationRuleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("circulationRuleId", getCirculationRuleId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("patronCategoryId", getPatronCategoryId());
		attributes.put("itemTypeId", getItemTypeId());
		attributes.put("itemCategoryId", getItemCategoryId());
		attributes.put("maxCheckoutAllowed", getMaxCheckoutAllowed());
		attributes.put("renewalCountAllowed", getRenewalCountAllowed());
		attributes.put("reservedCountAllowed", getReservedCountAllowed());
		attributes.put("periodUnit", getPeriodUnit());
		attributes.put("loanPeriod", getLoanPeriod());
		attributes.put("loanPeriodIfReserved", getLoanPeriodIfReserved());
		attributes.put("rentalCharge", getRentalCharge());
		attributes.put("finePerPeriod", getFinePerPeriod());
		attributes.put("fineGracePeriod", getFineGracePeriod());
		attributes.put("maxFineAmount", getMaxFineAmount());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long circulationRuleId = (Long)attributes.get("circulationRuleId");

		if (circulationRuleId != null) {
			setCirculationRuleId(circulationRuleId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long patronCategoryId = (Long)attributes.get("patronCategoryId");

		if (patronCategoryId != null) {
			setPatronCategoryId(patronCategoryId);
		}

		Long itemTypeId = (Long)attributes.get("itemTypeId");

		if (itemTypeId != null) {
			setItemTypeId(itemTypeId);
		}

		Long itemCategoryId = (Long)attributes.get("itemCategoryId");

		if (itemCategoryId != null) {
			setItemCategoryId(itemCategoryId);
		}

		Integer maxCheckoutAllowed = (Integer)attributes.get(
				"maxCheckoutAllowed");

		if (maxCheckoutAllowed != null) {
			setMaxCheckoutAllowed(maxCheckoutAllowed);
		}

		Integer renewalCountAllowed = (Integer)attributes.get(
				"renewalCountAllowed");

		if (renewalCountAllowed != null) {
			setRenewalCountAllowed(renewalCountAllowed);
		}

		Integer reservedCountAllowed = (Integer)attributes.get(
				"reservedCountAllowed");

		if (reservedCountAllowed != null) {
			setReservedCountAllowed(reservedCountAllowed);
		}

		Integer periodUnit = (Integer)attributes.get("periodUnit");

		if (periodUnit != null) {
			setPeriodUnit(periodUnit);
		}

		Integer loanPeriod = (Integer)attributes.get("loanPeriod");

		if (loanPeriod != null) {
			setLoanPeriod(loanPeriod);
		}

		Integer loanPeriodIfReserved = (Integer)attributes.get(
				"loanPeriodIfReserved");

		if (loanPeriodIfReserved != null) {
			setLoanPeriodIfReserved(loanPeriodIfReserved);
		}

		Double rentalCharge = (Double)attributes.get("rentalCharge");

		if (rentalCharge != null) {
			setRentalCharge(rentalCharge);
		}

		Double finePerPeriod = (Double)attributes.get("finePerPeriod");

		if (finePerPeriod != null) {
			setFinePerPeriod(finePerPeriod);
		}

		Integer fineGracePeriod = (Integer)attributes.get("fineGracePeriod");

		if (fineGracePeriod != null) {
			setFineGracePeriod(fineGracePeriod);
		}

		Double maxFineAmount = (Double)attributes.get("maxFineAmount");

		if (maxFineAmount != null) {
			setMaxFineAmount(maxFineAmount);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}
	}

	@Override
	public long getCirculationRuleId() {
		return _circulationRuleId;
	}

	@Override
	public void setCirculationRuleId(long circulationRuleId) {
		_circulationRuleId = circulationRuleId;

		if (_circulationRuleRemoteModel != null) {
			try {
				Class<?> clazz = _circulationRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setCirculationRuleId",
						long.class);

				method.invoke(_circulationRuleRemoteModel, circulationRuleId);
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

		if (_circulationRuleRemoteModel != null) {
			try {
				Class<?> clazz = _circulationRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryId", long.class);

				method.invoke(_circulationRuleRemoteModel, libraryId);
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

		if (_circulationRuleRemoteModel != null) {
			try {
				Class<?> clazz = _circulationRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_circulationRuleRemoteModel, companyId);
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

		if (_circulationRuleRemoteModel != null) {
			try {
				Class<?> clazz = _circulationRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_circulationRuleRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPatronCategoryId() {
		return _patronCategoryId;
	}

	@Override
	public void setPatronCategoryId(long patronCategoryId) {
		_patronCategoryId = patronCategoryId;

		if (_circulationRuleRemoteModel != null) {
			try {
				Class<?> clazz = _circulationRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setPatronCategoryId",
						long.class);

				method.invoke(_circulationRuleRemoteModel, patronCategoryId);
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

		if (_circulationRuleRemoteModel != null) {
			try {
				Class<?> clazz = _circulationRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setItemTypeId", long.class);

				method.invoke(_circulationRuleRemoteModel, itemTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getItemCategoryId() {
		return _itemCategoryId;
	}

	@Override
	public void setItemCategoryId(long itemCategoryId) {
		_itemCategoryId = itemCategoryId;

		if (_circulationRuleRemoteModel != null) {
			try {
				Class<?> clazz = _circulationRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setItemCategoryId", long.class);

				method.invoke(_circulationRuleRemoteModel, itemCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getMaxCheckoutAllowed() {
		return _maxCheckoutAllowed;
	}

	@Override
	public void setMaxCheckoutAllowed(int maxCheckoutAllowed) {
		_maxCheckoutAllowed = maxCheckoutAllowed;

		if (_circulationRuleRemoteModel != null) {
			try {
				Class<?> clazz = _circulationRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setMaxCheckoutAllowed",
						int.class);

				method.invoke(_circulationRuleRemoteModel, maxCheckoutAllowed);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getRenewalCountAllowed() {
		return _renewalCountAllowed;
	}

	@Override
	public void setRenewalCountAllowed(int renewalCountAllowed) {
		_renewalCountAllowed = renewalCountAllowed;

		if (_circulationRuleRemoteModel != null) {
			try {
				Class<?> clazz = _circulationRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setRenewalCountAllowed",
						int.class);

				method.invoke(_circulationRuleRemoteModel, renewalCountAllowed);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getReservedCountAllowed() {
		return _reservedCountAllowed;
	}

	@Override
	public void setReservedCountAllowed(int reservedCountAllowed) {
		_reservedCountAllowed = reservedCountAllowed;

		if (_circulationRuleRemoteModel != null) {
			try {
				Class<?> clazz = _circulationRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setReservedCountAllowed",
						int.class);

				method.invoke(_circulationRuleRemoteModel, reservedCountAllowed);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPeriodUnit() {
		return _periodUnit;
	}

	@Override
	public void setPeriodUnit(int periodUnit) {
		_periodUnit = periodUnit;

		if (_circulationRuleRemoteModel != null) {
			try {
				Class<?> clazz = _circulationRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setPeriodUnit", int.class);

				method.invoke(_circulationRuleRemoteModel, periodUnit);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getLoanPeriod() {
		return _loanPeriod;
	}

	@Override
	public void setLoanPeriod(int loanPeriod) {
		_loanPeriod = loanPeriod;

		if (_circulationRuleRemoteModel != null) {
			try {
				Class<?> clazz = _circulationRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setLoanPeriod", int.class);

				method.invoke(_circulationRuleRemoteModel, loanPeriod);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getLoanPeriodIfReserved() {
		return _loanPeriodIfReserved;
	}

	@Override
	public void setLoanPeriodIfReserved(int loanPeriodIfReserved) {
		_loanPeriodIfReserved = loanPeriodIfReserved;

		if (_circulationRuleRemoteModel != null) {
			try {
				Class<?> clazz = _circulationRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setLoanPeriodIfReserved",
						int.class);

				method.invoke(_circulationRuleRemoteModel, loanPeriodIfReserved);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getRentalCharge() {
		return _rentalCharge;
	}

	@Override
	public void setRentalCharge(double rentalCharge) {
		_rentalCharge = rentalCharge;

		if (_circulationRuleRemoteModel != null) {
			try {
				Class<?> clazz = _circulationRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setRentalCharge", double.class);

				method.invoke(_circulationRuleRemoteModel, rentalCharge);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getFinePerPeriod() {
		return _finePerPeriod;
	}

	@Override
	public void setFinePerPeriod(double finePerPeriod) {
		_finePerPeriod = finePerPeriod;

		if (_circulationRuleRemoteModel != null) {
			try {
				Class<?> clazz = _circulationRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setFinePerPeriod", double.class);

				method.invoke(_circulationRuleRemoteModel, finePerPeriod);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getFineGracePeriod() {
		return _fineGracePeriod;
	}

	@Override
	public void setFineGracePeriod(int fineGracePeriod) {
		_fineGracePeriod = fineGracePeriod;

		if (_circulationRuleRemoteModel != null) {
			try {
				Class<?> clazz = _circulationRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setFineGracePeriod", int.class);

				method.invoke(_circulationRuleRemoteModel, fineGracePeriod);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getMaxFineAmount() {
		return _maxFineAmount;
	}

	@Override
	public void setMaxFineAmount(double maxFineAmount) {
		_maxFineAmount = maxFineAmount;

		if (_circulationRuleRemoteModel != null) {
			try {
				Class<?> clazz = _circulationRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setMaxFineAmount", double.class);

				method.invoke(_circulationRuleRemoteModel, maxFineAmount);
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

		if (_circulationRuleRemoteModel != null) {
			try {
				Class<?> clazz = _circulationRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_circulationRuleRemoteModel, userId);
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
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;

		if (_circulationRuleRemoteModel != null) {
			try {
				Class<?> clazz = _circulationRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_circulationRuleRemoteModel, createdDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCirculationRuleRemoteModel() {
		return _circulationRuleRemoteModel;
	}

	public void setCirculationRuleRemoteModel(
		BaseModel<?> circulationRuleRemoteModel) {
		_circulationRuleRemoteModel = circulationRuleRemoteModel;
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

		Class<?> remoteModelClass = _circulationRuleRemoteModel.getClass();

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

		Object returnValue = method.invoke(_circulationRuleRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CirculationRuleLocalServiceUtil.addCirculationRule(this);
		}
		else {
			CirculationRuleLocalServiceUtil.updateCirculationRule(this);
		}
	}

	@Override
	public CirculationRule toEscapedModel() {
		return (CirculationRule)ProxyUtil.newProxyInstance(CirculationRule.class.getClassLoader(),
			new Class[] { CirculationRule.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CirculationRuleClp clone = new CirculationRuleClp();

		clone.setCirculationRuleId(getCirculationRuleId());
		clone.setLibraryId(getLibraryId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setPatronCategoryId(getPatronCategoryId());
		clone.setItemTypeId(getItemTypeId());
		clone.setItemCategoryId(getItemCategoryId());
		clone.setMaxCheckoutAllowed(getMaxCheckoutAllowed());
		clone.setRenewalCountAllowed(getRenewalCountAllowed());
		clone.setReservedCountAllowed(getReservedCountAllowed());
		clone.setPeriodUnit(getPeriodUnit());
		clone.setLoanPeriod(getLoanPeriod());
		clone.setLoanPeriodIfReserved(getLoanPeriodIfReserved());
		clone.setRentalCharge(getRentalCharge());
		clone.setFinePerPeriod(getFinePerPeriod());
		clone.setFineGracePeriod(getFineGracePeriod());
		clone.setMaxFineAmount(getMaxFineAmount());
		clone.setUserId(getUserId());
		clone.setCreatedDate(getCreatedDate());

		return clone;
	}

	@Override
	public int compareTo(CirculationRule circulationRule) {
		long primaryKey = circulationRule.getPrimaryKey();

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

		if (!(obj instanceof CirculationRuleClp)) {
			return false;
		}

		CirculationRuleClp circulationRule = (CirculationRuleClp)obj;

		long primaryKey = circulationRule.getPrimaryKey();

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
		StringBundler sb = new StringBundler(39);

		sb.append("{circulationRuleId=");
		sb.append(getCirculationRuleId());
		sb.append(", libraryId=");
		sb.append(getLibraryId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", patronCategoryId=");
		sb.append(getPatronCategoryId());
		sb.append(", itemTypeId=");
		sb.append(getItemTypeId());
		sb.append(", itemCategoryId=");
		sb.append(getItemCategoryId());
		sb.append(", maxCheckoutAllowed=");
		sb.append(getMaxCheckoutAllowed());
		sb.append(", renewalCountAllowed=");
		sb.append(getRenewalCountAllowed());
		sb.append(", reservedCountAllowed=");
		sb.append(getReservedCountAllowed());
		sb.append(", periodUnit=");
		sb.append(getPeriodUnit());
		sb.append(", loanPeriod=");
		sb.append(getLoanPeriod());
		sb.append(", loanPeriodIfReserved=");
		sb.append(getLoanPeriodIfReserved());
		sb.append(", rentalCharge=");
		sb.append(getRentalCharge());
		sb.append(", finePerPeriod=");
		sb.append(getFinePerPeriod());
		sb.append(", fineGracePeriod=");
		sb.append(getFineGracePeriod());
		sb.append(", maxFineAmount=");
		sb.append(getMaxFineAmount());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("com.kencana.lms.model.CirculationRule");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>circulationRuleId</column-name><column-value><![CDATA[");
		sb.append(getCirculationRuleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>libraryId</column-name><column-value><![CDATA[");
		sb.append(getLibraryId());
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
			"<column><column-name>patronCategoryId</column-name><column-value><![CDATA[");
		sb.append(getPatronCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemTypeId</column-name><column-value><![CDATA[");
		sb.append(getItemTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemCategoryId</column-name><column-value><![CDATA[");
		sb.append(getItemCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxCheckoutAllowed</column-name><column-value><![CDATA[");
		sb.append(getMaxCheckoutAllowed());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>renewalCountAllowed</column-name><column-value><![CDATA[");
		sb.append(getRenewalCountAllowed());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reservedCountAllowed</column-name><column-value><![CDATA[");
		sb.append(getReservedCountAllowed());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>periodUnit</column-name><column-value><![CDATA[");
		sb.append(getPeriodUnit());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loanPeriod</column-name><column-value><![CDATA[");
		sb.append(getLoanPeriod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loanPeriodIfReserved</column-name><column-value><![CDATA[");
		sb.append(getLoanPeriodIfReserved());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rentalCharge</column-name><column-value><![CDATA[");
		sb.append(getRentalCharge());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>finePerPeriod</column-name><column-value><![CDATA[");
		sb.append(getFinePerPeriod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fineGracePeriod</column-name><column-value><![CDATA[");
		sb.append(getFineGracePeriod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxFineAmount</column-name><column-value><![CDATA[");
		sb.append(getMaxFineAmount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _circulationRuleId;
	private long _libraryId;
	private long _companyId;
	private long _groupId;
	private long _patronCategoryId;
	private long _itemTypeId;
	private long _itemCategoryId;
	private int _maxCheckoutAllowed;
	private int _renewalCountAllowed;
	private int _reservedCountAllowed;
	private int _periodUnit;
	private int _loanPeriod;
	private int _loanPeriodIfReserved;
	private double _rentalCharge;
	private double _finePerPeriod;
	private int _fineGracePeriod;
	private double _maxFineAmount;
	private long _userId;
	private String _userUuid;
	private Date _createdDate;
	private BaseModel<?> _circulationRuleRemoteModel;
	private Class<?> _clpSerializerClass = com.kencana.lms.service.ClpSerializer.class;
}