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
 * The base model interface for the CatalogTemplateSubfield service. Represents a row in the &quot;Kencana_CatalogTemplateSubfield&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.kencana.lms.model.impl.CatalogTemplateSubfieldModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.kencana.lms.model.impl.CatalogTemplateSubfieldImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see CatalogTemplateSubfield
 * @see com.kencana.lms.model.impl.CatalogTemplateSubfieldImpl
 * @see com.kencana.lms.model.impl.CatalogTemplateSubfieldModelImpl
 * @generated
 */
public interface CatalogTemplateSubfieldModel extends BaseModel<CatalogTemplateSubfield> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a catalog template subfield model instance should use the {@link CatalogTemplateSubfield} interface instead.
	 */

	/**
	 * Returns the primary key of this catalog template subfield.
	 *
	 * @return the primary key of this catalog template subfield
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this catalog template subfield.
	 *
	 * @param primaryKey the primary key of this catalog template subfield
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the catalog template subfield ID of this catalog template subfield.
	 *
	 * @return the catalog template subfield ID of this catalog template subfield
	 */
	public long getCatalogTemplateSubfieldId();

	/**
	 * Sets the catalog template subfield ID of this catalog template subfield.
	 *
	 * @param catalogTemplateSubfieldId the catalog template subfield ID of this catalog template subfield
	 */
	public void setCatalogTemplateSubfieldId(long catalogTemplateSubfieldId);

	/**
	 * Returns the catalog template tag ID of this catalog template subfield.
	 *
	 * @return the catalog template tag ID of this catalog template subfield
	 */
	public long getCatalogTemplateTagId();

	/**
	 * Sets the catalog template tag ID of this catalog template subfield.
	 *
	 * @param catalogTemplateTagId the catalog template tag ID of this catalog template subfield
	 */
	public void setCatalogTemplateTagId(long catalogTemplateTagId);

	/**
	 * Returns the subfield of this catalog template subfield.
	 *
	 * @return the subfield of this catalog template subfield
	 */
	@AutoEscape
	public String getSubfield();

	/**
	 * Sets the subfield of this catalog template subfield.
	 *
	 * @param subfield the subfield of this catalog template subfield
	 */
	public void setSubfield(String subfield);

	/**
	 * Returns the group ID of this catalog template subfield.
	 *
	 * @return the group ID of this catalog template subfield
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this catalog template subfield.
	 *
	 * @param groupId the group ID of this catalog template subfield
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this catalog template subfield.
	 *
	 * @return the company ID of this catalog template subfield
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this catalog template subfield.
	 *
	 * @param companyId the company ID of this catalog template subfield
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the repeatable of this catalog template subfield.
	 *
	 * @return the repeatable of this catalog template subfield
	 */
	public boolean getRepeatable();

	/**
	 * Returns <code>true</code> if this catalog template subfield is repeatable.
	 *
	 * @return <code>true</code> if this catalog template subfield is repeatable; <code>false</code> otherwise
	 */
	public boolean isRepeatable();

	/**
	 * Sets whether this catalog template subfield is repeatable.
	 *
	 * @param repeatable the repeatable of this catalog template subfield
	 */
	public void setRepeatable(boolean repeatable);

	/**
	 * Returns the mandatory of this catalog template subfield.
	 *
	 * @return the mandatory of this catalog template subfield
	 */
	public boolean getMandatory();

	/**
	 * Returns <code>true</code> if this catalog template subfield is mandatory.
	 *
	 * @return <code>true</code> if this catalog template subfield is mandatory; <code>false</code> otherwise
	 */
	public boolean isMandatory();

	/**
	 * Sets whether this catalog template subfield is mandatory.
	 *
	 * @param mandatory the mandatory of this catalog template subfield
	 */
	public void setMandatory(boolean mandatory);

	/**
	 * Returns the is u r l of this catalog template subfield.
	 *
	 * @return the is u r l of this catalog template subfield
	 */
	public boolean getIsURL();

	/**
	 * Returns <code>true</code> if this catalog template subfield is is u r l.
	 *
	 * @return <code>true</code> if this catalog template subfield is is u r l; <code>false</code> otherwise
	 */
	public boolean isIsURL();

	/**
	 * Sets whether this catalog template subfield is is u r l.
	 *
	 * @param isURL the is u r l of this catalog template subfield
	 */
	public void setIsURL(boolean isURL);

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
	public int compareTo(
		com.kencana.lms.model.CatalogTemplateSubfield catalogTemplateSubfield);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.kencana.lms.model.CatalogTemplateSubfield> toCacheModel();

	@Override
	public com.kencana.lms.model.CatalogTemplateSubfield toEscapedModel();

	@Override
	public com.kencana.lms.model.CatalogTemplateSubfield toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}