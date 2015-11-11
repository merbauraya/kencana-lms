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
 * This class is a wrapper for {@link CirculationRule}.
 * </p>
 *
 * @author Mazlan Mat
 * @see CirculationRule
 * @generated
 */
public class CirculationRuleWrapper implements CirculationRule,
	ModelWrapper<CirculationRule> {
	public CirculationRuleWrapper(CirculationRule circulationRule) {
		_circulationRule = circulationRule;
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

	/**
	* Returns the primary key of this circulation rule.
	*
	* @return the primary key of this circulation rule
	*/
	@Override
	public long getPrimaryKey() {
		return _circulationRule.getPrimaryKey();
	}

	/**
	* Sets the primary key of this circulation rule.
	*
	* @param primaryKey the primary key of this circulation rule
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_circulationRule.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the circulation rule ID of this circulation rule.
	*
	* @return the circulation rule ID of this circulation rule
	*/
	@Override
	public long getCirculationRuleId() {
		return _circulationRule.getCirculationRuleId();
	}

	/**
	* Sets the circulation rule ID of this circulation rule.
	*
	* @param circulationRuleId the circulation rule ID of this circulation rule
	*/
	@Override
	public void setCirculationRuleId(long circulationRuleId) {
		_circulationRule.setCirculationRuleId(circulationRuleId);
	}

	/**
	* Returns the library ID of this circulation rule.
	*
	* @return the library ID of this circulation rule
	*/
	@Override
	public long getLibraryId() {
		return _circulationRule.getLibraryId();
	}

	/**
	* Sets the library ID of this circulation rule.
	*
	* @param libraryId the library ID of this circulation rule
	*/
	@Override
	public void setLibraryId(long libraryId) {
		_circulationRule.setLibraryId(libraryId);
	}

	/**
	* Returns the company ID of this circulation rule.
	*
	* @return the company ID of this circulation rule
	*/
	@Override
	public long getCompanyId() {
		return _circulationRule.getCompanyId();
	}

	/**
	* Sets the company ID of this circulation rule.
	*
	* @param companyId the company ID of this circulation rule
	*/
	@Override
	public void setCompanyId(long companyId) {
		_circulationRule.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this circulation rule.
	*
	* @return the group ID of this circulation rule
	*/
	@Override
	public long getGroupId() {
		return _circulationRule.getGroupId();
	}

	/**
	* Sets the group ID of this circulation rule.
	*
	* @param groupId the group ID of this circulation rule
	*/
	@Override
	public void setGroupId(long groupId) {
		_circulationRule.setGroupId(groupId);
	}

	/**
	* Returns the patron category ID of this circulation rule.
	*
	* @return the patron category ID of this circulation rule
	*/
	@Override
	public long getPatronCategoryId() {
		return _circulationRule.getPatronCategoryId();
	}

	/**
	* Sets the patron category ID of this circulation rule.
	*
	* @param patronCategoryId the patron category ID of this circulation rule
	*/
	@Override
	public void setPatronCategoryId(long patronCategoryId) {
		_circulationRule.setPatronCategoryId(patronCategoryId);
	}

	/**
	* Returns the item type ID of this circulation rule.
	*
	* @return the item type ID of this circulation rule
	*/
	@Override
	public long getItemTypeId() {
		return _circulationRule.getItemTypeId();
	}

	/**
	* Sets the item type ID of this circulation rule.
	*
	* @param itemTypeId the item type ID of this circulation rule
	*/
	@Override
	public void setItemTypeId(long itemTypeId) {
		_circulationRule.setItemTypeId(itemTypeId);
	}

	/**
	* Returns the item category ID of this circulation rule.
	*
	* @return the item category ID of this circulation rule
	*/
	@Override
	public long getItemCategoryId() {
		return _circulationRule.getItemCategoryId();
	}

	/**
	* Sets the item category ID of this circulation rule.
	*
	* @param itemCategoryId the item category ID of this circulation rule
	*/
	@Override
	public void setItemCategoryId(long itemCategoryId) {
		_circulationRule.setItemCategoryId(itemCategoryId);
	}

	/**
	* Returns the max checkout allowed of this circulation rule.
	*
	* @return the max checkout allowed of this circulation rule
	*/
	@Override
	public int getMaxCheckoutAllowed() {
		return _circulationRule.getMaxCheckoutAllowed();
	}

	/**
	* Sets the max checkout allowed of this circulation rule.
	*
	* @param maxCheckoutAllowed the max checkout allowed of this circulation rule
	*/
	@Override
	public void setMaxCheckoutAllowed(int maxCheckoutAllowed) {
		_circulationRule.setMaxCheckoutAllowed(maxCheckoutAllowed);
	}

	/**
	* Returns the renewal count allowed of this circulation rule.
	*
	* @return the renewal count allowed of this circulation rule
	*/
	@Override
	public int getRenewalCountAllowed() {
		return _circulationRule.getRenewalCountAllowed();
	}

	/**
	* Sets the renewal count allowed of this circulation rule.
	*
	* @param renewalCountAllowed the renewal count allowed of this circulation rule
	*/
	@Override
	public void setRenewalCountAllowed(int renewalCountAllowed) {
		_circulationRule.setRenewalCountAllowed(renewalCountAllowed);
	}

	/**
	* Returns the reserved count allowed of this circulation rule.
	*
	* @return the reserved count allowed of this circulation rule
	*/
	@Override
	public int getReservedCountAllowed() {
		return _circulationRule.getReservedCountAllowed();
	}

	/**
	* Sets the reserved count allowed of this circulation rule.
	*
	* @param reservedCountAllowed the reserved count allowed of this circulation rule
	*/
	@Override
	public void setReservedCountAllowed(int reservedCountAllowed) {
		_circulationRule.setReservedCountAllowed(reservedCountAllowed);
	}

	/**
	* Returns the period unit of this circulation rule.
	*
	* @return the period unit of this circulation rule
	*/
	@Override
	public int getPeriodUnit() {
		return _circulationRule.getPeriodUnit();
	}

	/**
	* Sets the period unit of this circulation rule.
	*
	* @param periodUnit the period unit of this circulation rule
	*/
	@Override
	public void setPeriodUnit(int periodUnit) {
		_circulationRule.setPeriodUnit(periodUnit);
	}

	/**
	* Returns the loan period of this circulation rule.
	*
	* @return the loan period of this circulation rule
	*/
	@Override
	public int getLoanPeriod() {
		return _circulationRule.getLoanPeriod();
	}

	/**
	* Sets the loan period of this circulation rule.
	*
	* @param loanPeriod the loan period of this circulation rule
	*/
	@Override
	public void setLoanPeriod(int loanPeriod) {
		_circulationRule.setLoanPeriod(loanPeriod);
	}

	/**
	* Returns the loan period if reserved of this circulation rule.
	*
	* @return the loan period if reserved of this circulation rule
	*/
	@Override
	public int getLoanPeriodIfReserved() {
		return _circulationRule.getLoanPeriodIfReserved();
	}

	/**
	* Sets the loan period if reserved of this circulation rule.
	*
	* @param loanPeriodIfReserved the loan period if reserved of this circulation rule
	*/
	@Override
	public void setLoanPeriodIfReserved(int loanPeriodIfReserved) {
		_circulationRule.setLoanPeriodIfReserved(loanPeriodIfReserved);
	}

	/**
	* Returns the rental charge of this circulation rule.
	*
	* @return the rental charge of this circulation rule
	*/
	@Override
	public double getRentalCharge() {
		return _circulationRule.getRentalCharge();
	}

	/**
	* Sets the rental charge of this circulation rule.
	*
	* @param rentalCharge the rental charge of this circulation rule
	*/
	@Override
	public void setRentalCharge(double rentalCharge) {
		_circulationRule.setRentalCharge(rentalCharge);
	}

	/**
	* Returns the fine per period of this circulation rule.
	*
	* @return the fine per period of this circulation rule
	*/
	@Override
	public double getFinePerPeriod() {
		return _circulationRule.getFinePerPeriod();
	}

	/**
	* Sets the fine per period of this circulation rule.
	*
	* @param finePerPeriod the fine per period of this circulation rule
	*/
	@Override
	public void setFinePerPeriod(double finePerPeriod) {
		_circulationRule.setFinePerPeriod(finePerPeriod);
	}

	/**
	* Returns the fine grace period of this circulation rule.
	*
	* @return the fine grace period of this circulation rule
	*/
	@Override
	public int getFineGracePeriod() {
		return _circulationRule.getFineGracePeriod();
	}

	/**
	* Sets the fine grace period of this circulation rule.
	*
	* @param fineGracePeriod the fine grace period of this circulation rule
	*/
	@Override
	public void setFineGracePeriod(int fineGracePeriod) {
		_circulationRule.setFineGracePeriod(fineGracePeriod);
	}

	/**
	* Returns the max fine amount of this circulation rule.
	*
	* @return the max fine amount of this circulation rule
	*/
	@Override
	public double getMaxFineAmount() {
		return _circulationRule.getMaxFineAmount();
	}

	/**
	* Sets the max fine amount of this circulation rule.
	*
	* @param maxFineAmount the max fine amount of this circulation rule
	*/
	@Override
	public void setMaxFineAmount(double maxFineAmount) {
		_circulationRule.setMaxFineAmount(maxFineAmount);
	}

	/**
	* Returns the user ID of this circulation rule.
	*
	* @return the user ID of this circulation rule
	*/
	@Override
	public long getUserId() {
		return _circulationRule.getUserId();
	}

	/**
	* Sets the user ID of this circulation rule.
	*
	* @param userId the user ID of this circulation rule
	*/
	@Override
	public void setUserId(long userId) {
		_circulationRule.setUserId(userId);
	}

	/**
	* Returns the user uuid of this circulation rule.
	*
	* @return the user uuid of this circulation rule
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _circulationRule.getUserUuid();
	}

	/**
	* Sets the user uuid of this circulation rule.
	*
	* @param userUuid the user uuid of this circulation rule
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_circulationRule.setUserUuid(userUuid);
	}

	/**
	* Returns the created date of this circulation rule.
	*
	* @return the created date of this circulation rule
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _circulationRule.getCreatedDate();
	}

	/**
	* Sets the created date of this circulation rule.
	*
	* @param createdDate the created date of this circulation rule
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_circulationRule.setCreatedDate(createdDate);
	}

	@Override
	public boolean isNew() {
		return _circulationRule.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_circulationRule.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _circulationRule.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_circulationRule.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _circulationRule.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _circulationRule.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_circulationRule.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _circulationRule.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_circulationRule.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_circulationRule.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_circulationRule.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CirculationRuleWrapper((CirculationRule)_circulationRule.clone());
	}

	@Override
	public int compareTo(com.kencana.lms.model.CirculationRule circulationRule) {
		return _circulationRule.compareTo(circulationRule);
	}

	@Override
	public int hashCode() {
		return _circulationRule.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.kencana.lms.model.CirculationRule> toCacheModel() {
		return _circulationRule.toCacheModel();
	}

	@Override
	public com.kencana.lms.model.CirculationRule toEscapedModel() {
		return new CirculationRuleWrapper(_circulationRule.toEscapedModel());
	}

	@Override
	public com.kencana.lms.model.CirculationRule toUnescapedModel() {
		return new CirculationRuleWrapper(_circulationRule.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _circulationRule.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _circulationRule.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_circulationRule.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CirculationRuleWrapper)) {
			return false;
		}

		CirculationRuleWrapper circulationRuleWrapper = (CirculationRuleWrapper)obj;

		if (Validator.equals(_circulationRule,
					circulationRuleWrapper._circulationRule)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CirculationRule getWrappedCirculationRule() {
		return _circulationRule;
	}

	@Override
	public CirculationRule getWrappedModel() {
		return _circulationRule;
	}

	@Override
	public void resetOriginalValues() {
		_circulationRule.resetOriginalValues();
	}

	private CirculationRule _circulationRule;
}