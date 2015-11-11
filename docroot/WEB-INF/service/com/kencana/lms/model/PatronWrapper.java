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
 * This class is a wrapper for {@link Patron}.
 * </p>
 *
 * @author Mazlan Mat
 * @see Patron
 * @generated
 */
public class PatronWrapper implements Patron, ModelWrapper<Patron> {
	public PatronWrapper(Patron patron) {
		_patron = patron;
	}

	@Override
	public Class<?> getModelClass() {
		return Patron.class;
	}

	@Override
	public String getModelClassName() {
		return Patron.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("patronId", getPatronId());
		attributes.put("cardNumber", getCardNumber());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("expiryDate", getExpiryDate());
		attributes.put("patronCategoryId", getPatronCategoryId());
		attributes.put("patronStatusId", getPatronStatusId());
		attributes.put("patronNote", getPatronNote());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long patronId = (Long)attributes.get("patronId");

		if (patronId != null) {
			setPatronId(patronId);
		}

		String cardNumber = (String)attributes.get("cardNumber");

		if (cardNumber != null) {
			setCardNumber(cardNumber);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		Date expiryDate = (Date)attributes.get("expiryDate");

		if (expiryDate != null) {
			setExpiryDate(expiryDate);
		}

		Long patronCategoryId = (Long)attributes.get("patronCategoryId");

		if (patronCategoryId != null) {
			setPatronCategoryId(patronCategoryId);
		}

		Long patronStatusId = (Long)attributes.get("patronStatusId");

		if (patronStatusId != null) {
			setPatronStatusId(patronStatusId);
		}

		String patronNote = (String)attributes.get("patronNote");

		if (patronNote != null) {
			setPatronNote(patronNote);
		}
	}

	/**
	* Returns the primary key of this patron.
	*
	* @return the primary key of this patron
	*/
	@Override
	public long getPrimaryKey() {
		return _patron.getPrimaryKey();
	}

	/**
	* Sets the primary key of this patron.
	*
	* @param primaryKey the primary key of this patron
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_patron.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the patron ID of this patron.
	*
	* @return the patron ID of this patron
	*/
	@Override
	public long getPatronId() {
		return _patron.getPatronId();
	}

	/**
	* Sets the patron ID of this patron.
	*
	* @param patronId the patron ID of this patron
	*/
	@Override
	public void setPatronId(long patronId) {
		_patron.setPatronId(patronId);
	}

	/**
	* Returns the card number of this patron.
	*
	* @return the card number of this patron
	*/
	@Override
	public java.lang.String getCardNumber() {
		return _patron.getCardNumber();
	}

	/**
	* Sets the card number of this patron.
	*
	* @param cardNumber the card number of this patron
	*/
	@Override
	public void setCardNumber(java.lang.String cardNumber) {
		_patron.setCardNumber(cardNumber);
	}

	/**
	* Returns the user ID of this patron.
	*
	* @return the user ID of this patron
	*/
	@Override
	public long getUserId() {
		return _patron.getUserId();
	}

	/**
	* Sets the user ID of this patron.
	*
	* @param userId the user ID of this patron
	*/
	@Override
	public void setUserId(long userId) {
		_patron.setUserId(userId);
	}

	/**
	* Returns the user uuid of this patron.
	*
	* @return the user uuid of this patron
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _patron.getUserUuid();
	}

	/**
	* Sets the user uuid of this patron.
	*
	* @param userUuid the user uuid of this patron
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_patron.setUserUuid(userUuid);
	}

	/**
	* Returns the group ID of this patron.
	*
	* @return the group ID of this patron
	*/
	@Override
	public long getGroupId() {
		return _patron.getGroupId();
	}

	/**
	* Sets the group ID of this patron.
	*
	* @param groupId the group ID of this patron
	*/
	@Override
	public void setGroupId(long groupId) {
		_patron.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this patron.
	*
	* @return the company ID of this patron
	*/
	@Override
	public long getCompanyId() {
		return _patron.getCompanyId();
	}

	/**
	* Sets the company ID of this patron.
	*
	* @param companyId the company ID of this patron
	*/
	@Override
	public void setCompanyId(long companyId) {
		_patron.setCompanyId(companyId);
	}

	/**
	* Returns the library ID of this patron.
	*
	* @return the library ID of this patron
	*/
	@Override
	public long getLibraryId() {
		return _patron.getLibraryId();
	}

	/**
	* Sets the library ID of this patron.
	*
	* @param libraryId the library ID of this patron
	*/
	@Override
	public void setLibraryId(long libraryId) {
		_patron.setLibraryId(libraryId);
	}

	/**
	* Returns the expiry date of this patron.
	*
	* @return the expiry date of this patron
	*/
	@Override
	public java.util.Date getExpiryDate() {
		return _patron.getExpiryDate();
	}

	/**
	* Sets the expiry date of this patron.
	*
	* @param expiryDate the expiry date of this patron
	*/
	@Override
	public void setExpiryDate(java.util.Date expiryDate) {
		_patron.setExpiryDate(expiryDate);
	}

	/**
	* Returns the patron category ID of this patron.
	*
	* @return the patron category ID of this patron
	*/
	@Override
	public long getPatronCategoryId() {
		return _patron.getPatronCategoryId();
	}

	/**
	* Sets the patron category ID of this patron.
	*
	* @param patronCategoryId the patron category ID of this patron
	*/
	@Override
	public void setPatronCategoryId(long patronCategoryId) {
		_patron.setPatronCategoryId(patronCategoryId);
	}

	/**
	* Returns the patron status ID of this patron.
	*
	* @return the patron status ID of this patron
	*/
	@Override
	public long getPatronStatusId() {
		return _patron.getPatronStatusId();
	}

	/**
	* Sets the patron status ID of this patron.
	*
	* @param patronStatusId the patron status ID of this patron
	*/
	@Override
	public void setPatronStatusId(long patronStatusId) {
		_patron.setPatronStatusId(patronStatusId);
	}

	/**
	* Returns the patron note of this patron.
	*
	* @return the patron note of this patron
	*/
	@Override
	public java.lang.String getPatronNote() {
		return _patron.getPatronNote();
	}

	/**
	* Sets the patron note of this patron.
	*
	* @param patronNote the patron note of this patron
	*/
	@Override
	public void setPatronNote(java.lang.String patronNote) {
		_patron.setPatronNote(patronNote);
	}

	@Override
	public boolean isNew() {
		return _patron.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_patron.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _patron.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_patron.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _patron.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _patron.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_patron.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _patron.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_patron.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_patron.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_patron.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PatronWrapper((Patron)_patron.clone());
	}

	@Override
	public int compareTo(com.kencana.lms.model.Patron patron) {
		return _patron.compareTo(patron);
	}

	@Override
	public int hashCode() {
		return _patron.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.kencana.lms.model.Patron> toCacheModel() {
		return _patron.toCacheModel();
	}

	@Override
	public com.kencana.lms.model.Patron toEscapedModel() {
		return new PatronWrapper(_patron.toEscapedModel());
	}

	@Override
	public com.kencana.lms.model.Patron toUnescapedModel() {
		return new PatronWrapper(_patron.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _patron.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _patron.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_patron.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PatronWrapper)) {
			return false;
		}

		PatronWrapper patronWrapper = (PatronWrapper)obj;

		if (Validator.equals(_patron, patronWrapper._patron)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Patron getWrappedPatron() {
		return _patron;
	}

	@Override
	public Patron getWrappedModel() {
		return _patron;
	}

	@Override
	public void resetOriginalValues() {
		_patron.resetOriginalValues();
	}

	private Patron _patron;
}