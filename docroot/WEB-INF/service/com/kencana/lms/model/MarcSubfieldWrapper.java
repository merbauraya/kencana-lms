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
 * This class is a wrapper for {@link MarcSubfield}.
 * </p>
 *
 * @author Mazlan Mat
 * @see MarcSubfield
 * @generated
 */
public class MarcSubfieldWrapper implements MarcSubfield,
	ModelWrapper<MarcSubfield> {
	public MarcSubfieldWrapper(MarcSubfield marcSubfield) {
		_marcSubfield = marcSubfield;
	}

	@Override
	public Class<?> getModelClass() {
		return MarcSubfield.class;
	}

	@Override
	public String getModelClassName() {
		return MarcSubfield.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("MarcSubfieldId", getMarcSubfieldId());
		attributes.put("tag", getTag());
		attributes.put("tagType", getTagType());
		attributes.put("subfield", getSubfield());
		attributes.put("description", getDescription());
		attributes.put("repetable", getRepetable());
		attributes.put("mandatory", getMandatory());
		attributes.put("authorisedValue", getAuthorisedValue());
		attributes.put("authTypeCode", getAuthTypeCode());
		attributes.put("isURL", getIsURL());
		attributes.put("helpText", getHelpText());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long MarcSubfieldId = (Long)attributes.get("MarcSubfieldId");

		if (MarcSubfieldId != null) {
			setMarcSubfieldId(MarcSubfieldId);
		}

		String tag = (String)attributes.get("tag");

		if (tag != null) {
			setTag(tag);
		}

		String tagType = (String)attributes.get("tagType");

		if (tagType != null) {
			setTagType(tagType);
		}

		String subfield = (String)attributes.get("subfield");

		if (subfield != null) {
			setSubfield(subfield);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Boolean repetable = (Boolean)attributes.get("repetable");

		if (repetable != null) {
			setRepetable(repetable);
		}

		Boolean mandatory = (Boolean)attributes.get("mandatory");

		if (mandatory != null) {
			setMandatory(mandatory);
		}

		String authorisedValue = (String)attributes.get("authorisedValue");

		if (authorisedValue != null) {
			setAuthorisedValue(authorisedValue);
		}

		String authTypeCode = (String)attributes.get("authTypeCode");

		if (authTypeCode != null) {
			setAuthTypeCode(authTypeCode);
		}

		Boolean isURL = (Boolean)attributes.get("isURL");

		if (isURL != null) {
			setIsURL(isURL);
		}

		String helpText = (String)attributes.get("helpText");

		if (helpText != null) {
			setHelpText(helpText);
		}
	}

	/**
	* Returns the primary key of this marc subfield.
	*
	* @return the primary key of this marc subfield
	*/
	@Override
	public long getPrimaryKey() {
		return _marcSubfield.getPrimaryKey();
	}

	/**
	* Sets the primary key of this marc subfield.
	*
	* @param primaryKey the primary key of this marc subfield
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_marcSubfield.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the marc subfield ID of this marc subfield.
	*
	* @return the marc subfield ID of this marc subfield
	*/
	@Override
	public long getMarcSubfieldId() {
		return _marcSubfield.getMarcSubfieldId();
	}

	/**
	* Sets the marc subfield ID of this marc subfield.
	*
	* @param MarcSubfieldId the marc subfield ID of this marc subfield
	*/
	@Override
	public void setMarcSubfieldId(long MarcSubfieldId) {
		_marcSubfield.setMarcSubfieldId(MarcSubfieldId);
	}

	/**
	* Returns the tag of this marc subfield.
	*
	* @return the tag of this marc subfield
	*/
	@Override
	public java.lang.String getTag() {
		return _marcSubfield.getTag();
	}

	/**
	* Sets the tag of this marc subfield.
	*
	* @param tag the tag of this marc subfield
	*/
	@Override
	public void setTag(java.lang.String tag) {
		_marcSubfield.setTag(tag);
	}

	/**
	* Returns the tag type of this marc subfield.
	*
	* @return the tag type of this marc subfield
	*/
	@Override
	public java.lang.String getTagType() {
		return _marcSubfield.getTagType();
	}

	/**
	* Sets the tag type of this marc subfield.
	*
	* @param tagType the tag type of this marc subfield
	*/
	@Override
	public void setTagType(java.lang.String tagType) {
		_marcSubfield.setTagType(tagType);
	}

	/**
	* Returns the subfield of this marc subfield.
	*
	* @return the subfield of this marc subfield
	*/
	@Override
	public java.lang.String getSubfield() {
		return _marcSubfield.getSubfield();
	}

	/**
	* Sets the subfield of this marc subfield.
	*
	* @param subfield the subfield of this marc subfield
	*/
	@Override
	public void setSubfield(java.lang.String subfield) {
		_marcSubfield.setSubfield(subfield);
	}

	/**
	* Returns the description of this marc subfield.
	*
	* @return the description of this marc subfield
	*/
	@Override
	public java.lang.String getDescription() {
		return _marcSubfield.getDescription();
	}

	/**
	* Sets the description of this marc subfield.
	*
	* @param description the description of this marc subfield
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_marcSubfield.setDescription(description);
	}

	/**
	* Returns the repetable of this marc subfield.
	*
	* @return the repetable of this marc subfield
	*/
	@Override
	public boolean getRepetable() {
		return _marcSubfield.getRepetable();
	}

	/**
	* Returns <code>true</code> if this marc subfield is repetable.
	*
	* @return <code>true</code> if this marc subfield is repetable; <code>false</code> otherwise
	*/
	@Override
	public boolean isRepetable() {
		return _marcSubfield.isRepetable();
	}

	/**
	* Sets whether this marc subfield is repetable.
	*
	* @param repetable the repetable of this marc subfield
	*/
	@Override
	public void setRepetable(boolean repetable) {
		_marcSubfield.setRepetable(repetable);
	}

	/**
	* Returns the mandatory of this marc subfield.
	*
	* @return the mandatory of this marc subfield
	*/
	@Override
	public boolean getMandatory() {
		return _marcSubfield.getMandatory();
	}

	/**
	* Returns <code>true</code> if this marc subfield is mandatory.
	*
	* @return <code>true</code> if this marc subfield is mandatory; <code>false</code> otherwise
	*/
	@Override
	public boolean isMandatory() {
		return _marcSubfield.isMandatory();
	}

	/**
	* Sets whether this marc subfield is mandatory.
	*
	* @param mandatory the mandatory of this marc subfield
	*/
	@Override
	public void setMandatory(boolean mandatory) {
		_marcSubfield.setMandatory(mandatory);
	}

	/**
	* Returns the authorised value of this marc subfield.
	*
	* @return the authorised value of this marc subfield
	*/
	@Override
	public java.lang.String getAuthorisedValue() {
		return _marcSubfield.getAuthorisedValue();
	}

	/**
	* Sets the authorised value of this marc subfield.
	*
	* @param authorisedValue the authorised value of this marc subfield
	*/
	@Override
	public void setAuthorisedValue(java.lang.String authorisedValue) {
		_marcSubfield.setAuthorisedValue(authorisedValue);
	}

	/**
	* Returns the auth type code of this marc subfield.
	*
	* @return the auth type code of this marc subfield
	*/
	@Override
	public java.lang.String getAuthTypeCode() {
		return _marcSubfield.getAuthTypeCode();
	}

	/**
	* Sets the auth type code of this marc subfield.
	*
	* @param authTypeCode the auth type code of this marc subfield
	*/
	@Override
	public void setAuthTypeCode(java.lang.String authTypeCode) {
		_marcSubfield.setAuthTypeCode(authTypeCode);
	}

	/**
	* Returns the is u r l of this marc subfield.
	*
	* @return the is u r l of this marc subfield
	*/
	@Override
	public boolean getIsURL() {
		return _marcSubfield.getIsURL();
	}

	/**
	* Returns <code>true</code> if this marc subfield is is u r l.
	*
	* @return <code>true</code> if this marc subfield is is u r l; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsURL() {
		return _marcSubfield.isIsURL();
	}

	/**
	* Sets whether this marc subfield is is u r l.
	*
	* @param isURL the is u r l of this marc subfield
	*/
	@Override
	public void setIsURL(boolean isURL) {
		_marcSubfield.setIsURL(isURL);
	}

	/**
	* Returns the help text of this marc subfield.
	*
	* @return the help text of this marc subfield
	*/
	@Override
	public java.lang.String getHelpText() {
		return _marcSubfield.getHelpText();
	}

	/**
	* Sets the help text of this marc subfield.
	*
	* @param helpText the help text of this marc subfield
	*/
	@Override
	public void setHelpText(java.lang.String helpText) {
		_marcSubfield.setHelpText(helpText);
	}

	@Override
	public boolean isNew() {
		return _marcSubfield.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_marcSubfield.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _marcSubfield.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_marcSubfield.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _marcSubfield.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _marcSubfield.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_marcSubfield.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _marcSubfield.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_marcSubfield.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_marcSubfield.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_marcSubfield.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MarcSubfieldWrapper((MarcSubfield)_marcSubfield.clone());
	}

	@Override
	public int compareTo(com.kencana.lms.model.MarcSubfield marcSubfield) {
		return _marcSubfield.compareTo(marcSubfield);
	}

	@Override
	public int hashCode() {
		return _marcSubfield.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.kencana.lms.model.MarcSubfield> toCacheModel() {
		return _marcSubfield.toCacheModel();
	}

	@Override
	public com.kencana.lms.model.MarcSubfield toEscapedModel() {
		return new MarcSubfieldWrapper(_marcSubfield.toEscapedModel());
	}

	@Override
	public com.kencana.lms.model.MarcSubfield toUnescapedModel() {
		return new MarcSubfieldWrapper(_marcSubfield.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _marcSubfield.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _marcSubfield.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_marcSubfield.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MarcSubfieldWrapper)) {
			return false;
		}

		MarcSubfieldWrapper marcSubfieldWrapper = (MarcSubfieldWrapper)obj;

		if (Validator.equals(_marcSubfield, marcSubfieldWrapper._marcSubfield)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MarcSubfield getWrappedMarcSubfield() {
		return _marcSubfield;
	}

	@Override
	public MarcSubfield getWrappedModel() {
		return _marcSubfield;
	}

	@Override
	public void resetOriginalValues() {
		_marcSubfield.resetOriginalValues();
	}

	private MarcSubfield _marcSubfield;
}