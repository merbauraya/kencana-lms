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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the MarcSubfield service. Represents a row in the &quot;Kencana_MarcSubfield&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.kencana.lms.model.impl.MarcSubfieldModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.kencana.lms.model.impl.MarcSubfieldImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see MarcSubfield
 * @see com.kencana.lms.model.impl.MarcSubfieldImpl
 * @see com.kencana.lms.model.impl.MarcSubfieldModelImpl
 * @generated
 */
public interface MarcSubfieldModel extends BaseModel<MarcSubfield> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a marc subfield model instance should use the {@link MarcSubfield} interface instead.
	 */

	/**
	 * Returns the primary key of this marc subfield.
	 *
	 * @return the primary key of this marc subfield
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this marc subfield.
	 *
	 * @param primaryKey the primary key of this marc subfield
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the marc subfield ID of this marc subfield.
	 *
	 * @return the marc subfield ID of this marc subfield
	 */
	public long getMarcSubfieldId();

	/**
	 * Sets the marc subfield ID of this marc subfield.
	 *
	 * @param MarcSubfieldId the marc subfield ID of this marc subfield
	 */
	public void setMarcSubfieldId(long MarcSubfieldId);

	/**
	 * Returns the tag of this marc subfield.
	 *
	 * @return the tag of this marc subfield
	 */
	@AutoEscape
	public String getTag();

	/**
	 * Sets the tag of this marc subfield.
	 *
	 * @param tag the tag of this marc subfield
	 */
	public void setTag(String tag);

	/**
	 * Returns the tag type of this marc subfield.
	 *
	 * @return the tag type of this marc subfield
	 */
	@AutoEscape
	public String getTagType();

	/**
	 * Sets the tag type of this marc subfield.
	 *
	 * @param tagType the tag type of this marc subfield
	 */
	public void setTagType(String tagType);

	/**
	 * Returns the subfield of this marc subfield.
	 *
	 * @return the subfield of this marc subfield
	 */
	@AutoEscape
	public String getSubfield();

	/**
	 * Sets the subfield of this marc subfield.
	 *
	 * @param subfield the subfield of this marc subfield
	 */
	public void setSubfield(String subfield);

	/**
	 * Returns the description of this marc subfield.
	 *
	 * @return the description of this marc subfield
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this marc subfield.
	 *
	 * @param description the description of this marc subfield
	 */
	public void setDescription(String description);

	/**
	 * Returns the repetable of this marc subfield.
	 *
	 * @return the repetable of this marc subfield
	 */
	public boolean getRepetable();

	/**
	 * Returns <code>true</code> if this marc subfield is repetable.
	 *
	 * @return <code>true</code> if this marc subfield is repetable; <code>false</code> otherwise
	 */
	public boolean isRepetable();

	/**
	 * Sets whether this marc subfield is repetable.
	 *
	 * @param repetable the repetable of this marc subfield
	 */
	public void setRepetable(boolean repetable);

	/**
	 * Returns the mandatory of this marc subfield.
	 *
	 * @return the mandatory of this marc subfield
	 */
	public boolean getMandatory();

	/**
	 * Returns <code>true</code> if this marc subfield is mandatory.
	 *
	 * @return <code>true</code> if this marc subfield is mandatory; <code>false</code> otherwise
	 */
	public boolean isMandatory();

	/**
	 * Sets whether this marc subfield is mandatory.
	 *
	 * @param mandatory the mandatory of this marc subfield
	 */
	public void setMandatory(boolean mandatory);

	/**
	 * Returns the authorised value of this marc subfield.
	 *
	 * @return the authorised value of this marc subfield
	 */
	@AutoEscape
	public String getAuthorisedValue();

	/**
	 * Sets the authorised value of this marc subfield.
	 *
	 * @param authorisedValue the authorised value of this marc subfield
	 */
	public void setAuthorisedValue(String authorisedValue);

	/**
	 * Returns the auth type code of this marc subfield.
	 *
	 * @return the auth type code of this marc subfield
	 */
	@AutoEscape
	public String getAuthTypeCode();

	/**
	 * Sets the auth type code of this marc subfield.
	 *
	 * @param authTypeCode the auth type code of this marc subfield
	 */
	public void setAuthTypeCode(String authTypeCode);

	/**
	 * Returns the is u r l of this marc subfield.
	 *
	 * @return the is u r l of this marc subfield
	 */
	public boolean getIsURL();

	/**
	 * Returns <code>true</code> if this marc subfield is is u r l.
	 *
	 * @return <code>true</code> if this marc subfield is is u r l; <code>false</code> otherwise
	 */
	public boolean isIsURL();

	/**
	 * Sets whether this marc subfield is is u r l.
	 *
	 * @param isURL the is u r l of this marc subfield
	 */
	public void setIsURL(boolean isURL);

	/**
	 * Returns the help text of this marc subfield.
	 *
	 * @return the help text of this marc subfield
	 */
	@AutoEscape
	public String getHelpText();

	/**
	 * Sets the help text of this marc subfield.
	 *
	 * @param helpText the help text of this marc subfield
	 */
	public void setHelpText(String helpText);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(com.kencana.lms.model.MarcSubfield marcSubfield);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.kencana.lms.model.MarcSubfield> toCacheModel();

	@Override
	public com.kencana.lms.model.MarcSubfield toEscapedModel();

	@Override
	public com.kencana.lms.model.MarcSubfield toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}