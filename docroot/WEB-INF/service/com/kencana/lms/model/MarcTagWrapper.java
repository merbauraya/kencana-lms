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
 * This class is a wrapper for {@link MarcTag}.
 * </p>
 *
 * @author Mazlan Mat
 * @see MarcTag
 * @generated
 */
public class MarcTagWrapper implements MarcTag, ModelWrapper<MarcTag> {
	public MarcTagWrapper(MarcTag marcTag) {
		_marcTag = marcTag;
	}

	@Override
	public Class<?> getModelClass() {
		return MarcTag.class;
	}

	@Override
	public String getModelClassName() {
		return MarcTag.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tagId", getTagId());
		attributes.put("tag", getTag());
		attributes.put("description", getDescription());
		attributes.put("helpText", getHelpText());
		attributes.put("repetable", getRepetable());
		attributes.put("defaultValue", getDefaultValue());
		attributes.put("indicator1", getIndicator1());
		attributes.put("indicator2", getIndicator2());
		attributes.put("tagType", getTagType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tagId = (Long)attributes.get("tagId");

		if (tagId != null) {
			setTagId(tagId);
		}

		String tag = (String)attributes.get("tag");

		if (tag != null) {
			setTag(tag);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String helpText = (String)attributes.get("helpText");

		if (helpText != null) {
			setHelpText(helpText);
		}

		Boolean repetable = (Boolean)attributes.get("repetable");

		if (repetable != null) {
			setRepetable(repetable);
		}

		String defaultValue = (String)attributes.get("defaultValue");

		if (defaultValue != null) {
			setDefaultValue(defaultValue);
		}

		Boolean indicator1 = (Boolean)attributes.get("indicator1");

		if (indicator1 != null) {
			setIndicator1(indicator1);
		}

		Boolean indicator2 = (Boolean)attributes.get("indicator2");

		if (indicator2 != null) {
			setIndicator2(indicator2);
		}

		String tagType = (String)attributes.get("tagType");

		if (tagType != null) {
			setTagType(tagType);
		}
	}

	/**
	* Returns the primary key of this marc tag.
	*
	* @return the primary key of this marc tag
	*/
	@Override
	public long getPrimaryKey() {
		return _marcTag.getPrimaryKey();
	}

	/**
	* Sets the primary key of this marc tag.
	*
	* @param primaryKey the primary key of this marc tag
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_marcTag.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the tag ID of this marc tag.
	*
	* @return the tag ID of this marc tag
	*/
	@Override
	public long getTagId() {
		return _marcTag.getTagId();
	}

	/**
	* Sets the tag ID of this marc tag.
	*
	* @param tagId the tag ID of this marc tag
	*/
	@Override
	public void setTagId(long tagId) {
		_marcTag.setTagId(tagId);
	}

	/**
	* Returns the tag of this marc tag.
	*
	* @return the tag of this marc tag
	*/
	@Override
	public java.lang.String getTag() {
		return _marcTag.getTag();
	}

	/**
	* Sets the tag of this marc tag.
	*
	* @param tag the tag of this marc tag
	*/
	@Override
	public void setTag(java.lang.String tag) {
		_marcTag.setTag(tag);
	}

	/**
	* Returns the description of this marc tag.
	*
	* @return the description of this marc tag
	*/
	@Override
	public java.lang.String getDescription() {
		return _marcTag.getDescription();
	}

	/**
	* Sets the description of this marc tag.
	*
	* @param description the description of this marc tag
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_marcTag.setDescription(description);
	}

	/**
	* Returns the help text of this marc tag.
	*
	* @return the help text of this marc tag
	*/
	@Override
	public java.lang.String getHelpText() {
		return _marcTag.getHelpText();
	}

	/**
	* Sets the help text of this marc tag.
	*
	* @param helpText the help text of this marc tag
	*/
	@Override
	public void setHelpText(java.lang.String helpText) {
		_marcTag.setHelpText(helpText);
	}

	/**
	* Returns the repetable of this marc tag.
	*
	* @return the repetable of this marc tag
	*/
	@Override
	public boolean getRepetable() {
		return _marcTag.getRepetable();
	}

	/**
	* Returns <code>true</code> if this marc tag is repetable.
	*
	* @return <code>true</code> if this marc tag is repetable; <code>false</code> otherwise
	*/
	@Override
	public boolean isRepetable() {
		return _marcTag.isRepetable();
	}

	/**
	* Sets whether this marc tag is repetable.
	*
	* @param repetable the repetable of this marc tag
	*/
	@Override
	public void setRepetable(boolean repetable) {
		_marcTag.setRepetable(repetable);
	}

	/**
	* Returns the default value of this marc tag.
	*
	* @return the default value of this marc tag
	*/
	@Override
	public java.lang.String getDefaultValue() {
		return _marcTag.getDefaultValue();
	}

	/**
	* Sets the default value of this marc tag.
	*
	* @param defaultValue the default value of this marc tag
	*/
	@Override
	public void setDefaultValue(java.lang.String defaultValue) {
		_marcTag.setDefaultValue(defaultValue);
	}

	/**
	* Returns the indicator1 of this marc tag.
	*
	* @return the indicator1 of this marc tag
	*/
	@Override
	public boolean getIndicator1() {
		return _marcTag.getIndicator1();
	}

	/**
	* Returns <code>true</code> if this marc tag is indicator1.
	*
	* @return <code>true</code> if this marc tag is indicator1; <code>false</code> otherwise
	*/
	@Override
	public boolean isIndicator1() {
		return _marcTag.isIndicator1();
	}

	/**
	* Sets whether this marc tag is indicator1.
	*
	* @param indicator1 the indicator1 of this marc tag
	*/
	@Override
	public void setIndicator1(boolean indicator1) {
		_marcTag.setIndicator1(indicator1);
	}

	/**
	* Returns the indicator2 of this marc tag.
	*
	* @return the indicator2 of this marc tag
	*/
	@Override
	public boolean getIndicator2() {
		return _marcTag.getIndicator2();
	}

	/**
	* Returns <code>true</code> if this marc tag is indicator2.
	*
	* @return <code>true</code> if this marc tag is indicator2; <code>false</code> otherwise
	*/
	@Override
	public boolean isIndicator2() {
		return _marcTag.isIndicator2();
	}

	/**
	* Sets whether this marc tag is indicator2.
	*
	* @param indicator2 the indicator2 of this marc tag
	*/
	@Override
	public void setIndicator2(boolean indicator2) {
		_marcTag.setIndicator2(indicator2);
	}

	/**
	* Returns the tag type of this marc tag.
	*
	* @return the tag type of this marc tag
	*/
	@Override
	public java.lang.String getTagType() {
		return _marcTag.getTagType();
	}

	/**
	* Sets the tag type of this marc tag.
	*
	* @param tagType the tag type of this marc tag
	*/
	@Override
	public void setTagType(java.lang.String tagType) {
		_marcTag.setTagType(tagType);
	}

	@Override
	public boolean isNew() {
		return _marcTag.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_marcTag.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _marcTag.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_marcTag.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _marcTag.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _marcTag.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_marcTag.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _marcTag.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_marcTag.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_marcTag.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_marcTag.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MarcTagWrapper((MarcTag)_marcTag.clone());
	}

	@Override
	public int compareTo(com.kencana.lms.model.MarcTag marcTag) {
		return _marcTag.compareTo(marcTag);
	}

	@Override
	public int hashCode() {
		return _marcTag.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.kencana.lms.model.MarcTag> toCacheModel() {
		return _marcTag.toCacheModel();
	}

	@Override
	public com.kencana.lms.model.MarcTag toEscapedModel() {
		return new MarcTagWrapper(_marcTag.toEscapedModel());
	}

	@Override
	public com.kencana.lms.model.MarcTag toUnescapedModel() {
		return new MarcTagWrapper(_marcTag.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _marcTag.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _marcTag.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_marcTag.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MarcTagWrapper)) {
			return false;
		}

		MarcTagWrapper marcTagWrapper = (MarcTagWrapper)obj;

		if (Validator.equals(_marcTag, marcTagWrapper._marcTag)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MarcTag getWrappedMarcTag() {
		return _marcTag;
	}

	@Override
	public MarcTag getWrappedModel() {
		return _marcTag;
	}

	@Override
	public void resetOriginalValues() {
		_marcTag.resetOriginalValues();
	}

	private MarcTag _marcTag;
}