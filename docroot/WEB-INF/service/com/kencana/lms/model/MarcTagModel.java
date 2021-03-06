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
 * The base model interface for the MarcTag service. Represents a row in the &quot;Kencana_MarcTag&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.kencana.lms.model.impl.MarcTagModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.kencana.lms.model.impl.MarcTagImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see MarcTag
 * @see com.kencana.lms.model.impl.MarcTagImpl
 * @see com.kencana.lms.model.impl.MarcTagModelImpl
 * @generated
 */
public interface MarcTagModel extends BaseModel<MarcTag> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a marc tag model instance should use the {@link MarcTag} interface instead.
	 */

	/**
	 * Returns the primary key of this marc tag.
	 *
	 * @return the primary key of this marc tag
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this marc tag.
	 *
	 * @param primaryKey the primary key of this marc tag
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the tag ID of this marc tag.
	 *
	 * @return the tag ID of this marc tag
	 */
	public long getTagId();

	/**
	 * Sets the tag ID of this marc tag.
	 *
	 * @param tagId the tag ID of this marc tag
	 */
	public void setTagId(long tagId);

	/**
	 * Returns the tag of this marc tag.
	 *
	 * @return the tag of this marc tag
	 */
	@AutoEscape
	public String getTag();

	/**
	 * Sets the tag of this marc tag.
	 *
	 * @param tag the tag of this marc tag
	 */
	public void setTag(String tag);

	/**
	 * Returns the description of this marc tag.
	 *
	 * @return the description of this marc tag
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this marc tag.
	 *
	 * @param description the description of this marc tag
	 */
	public void setDescription(String description);

	/**
	 * Returns the help text of this marc tag.
	 *
	 * @return the help text of this marc tag
	 */
	@AutoEscape
	public String getHelpText();

	/**
	 * Sets the help text of this marc tag.
	 *
	 * @param helpText the help text of this marc tag
	 */
	public void setHelpText(String helpText);

	/**
	 * Returns the repetable of this marc tag.
	 *
	 * @return the repetable of this marc tag
	 */
	public boolean getRepetable();

	/**
	 * Returns <code>true</code> if this marc tag is repetable.
	 *
	 * @return <code>true</code> if this marc tag is repetable; <code>false</code> otherwise
	 */
	public boolean isRepetable();

	/**
	 * Sets whether this marc tag is repetable.
	 *
	 * @param repetable the repetable of this marc tag
	 */
	public void setRepetable(boolean repetable);

	/**
	 * Returns the default value of this marc tag.
	 *
	 * @return the default value of this marc tag
	 */
	@AutoEscape
	public String getDefaultValue();

	/**
	 * Sets the default value of this marc tag.
	 *
	 * @param defaultValue the default value of this marc tag
	 */
	public void setDefaultValue(String defaultValue);

	/**
	 * Returns the indicator1 of this marc tag.
	 *
	 * @return the indicator1 of this marc tag
	 */
	public boolean getIndicator1();

	/**
	 * Returns <code>true</code> if this marc tag is indicator1.
	 *
	 * @return <code>true</code> if this marc tag is indicator1; <code>false</code> otherwise
	 */
	public boolean isIndicator1();

	/**
	 * Sets whether this marc tag is indicator1.
	 *
	 * @param indicator1 the indicator1 of this marc tag
	 */
	public void setIndicator1(boolean indicator1);

	/**
	 * Returns the indicator2 of this marc tag.
	 *
	 * @return the indicator2 of this marc tag
	 */
	public boolean getIndicator2();

	/**
	 * Returns <code>true</code> if this marc tag is indicator2.
	 *
	 * @return <code>true</code> if this marc tag is indicator2; <code>false</code> otherwise
	 */
	public boolean isIndicator2();

	/**
	 * Sets whether this marc tag is indicator2.
	 *
	 * @param indicator2 the indicator2 of this marc tag
	 */
	public void setIndicator2(boolean indicator2);

	/**
	 * Returns the tag type of this marc tag.
	 *
	 * @return the tag type of this marc tag
	 */
	@AutoEscape
	public String getTagType();

	/**
	 * Sets the tag type of this marc tag.
	 *
	 * @param tagType the tag type of this marc tag
	 */
	public void setTagType(String tagType);

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
	public int compareTo(com.kencana.lms.model.MarcTag marcTag);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.kencana.lms.model.MarcTag> toCacheModel();

	@Override
	public com.kencana.lms.model.MarcTag toEscapedModel();

	@Override
	public com.kencana.lms.model.MarcTag toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}