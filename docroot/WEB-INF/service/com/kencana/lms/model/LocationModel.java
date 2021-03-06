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
 * The base model interface for the Location service. Represents a row in the &quot;Kencana_Location&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.kencana.lms.model.impl.LocationModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.kencana.lms.model.impl.LocationImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see Location
 * @see com.kencana.lms.model.impl.LocationImpl
 * @see com.kencana.lms.model.impl.LocationModelImpl
 * @generated
 */
public interface LocationModel extends BaseModel<Location> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a location model instance should use the {@link Location} interface instead.
	 */

	/**
	 * Returns the primary key of this location.
	 *
	 * @return the primary key of this location
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this location.
	 *
	 * @param primaryKey the primary key of this location
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the location ID of this location.
	 *
	 * @return the location ID of this location
	 */
	public long getLocationId();

	/**
	 * Sets the location ID of this location.
	 *
	 * @param locationId the location ID of this location
	 */
	public void setLocationId(long locationId);

	/**
	 * Returns the library ID of this location.
	 *
	 * @return the library ID of this location
	 */
	public long getLibraryId();

	/**
	 * Sets the library ID of this location.
	 *
	 * @param libraryId the library ID of this location
	 */
	public void setLibraryId(long libraryId);

	/**
	 * Returns the company ID of this location.
	 *
	 * @return the company ID of this location
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this location.
	 *
	 * @param companyId the company ID of this location
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this location.
	 *
	 * @return the group ID of this location
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this location.
	 *
	 * @param groupId the group ID of this location
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the location name of this location.
	 *
	 * @return the location name of this location
	 */
	@AutoEscape
	public String getLocationName();

	/**
	 * Sets the location name of this location.
	 *
	 * @param locationName the location name of this location
	 */
	public void setLocationName(String locationName);

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
	public int compareTo(com.kencana.lms.model.Location location);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.kencana.lms.model.Location> toCacheModel();

	@Override
	public com.kencana.lms.model.Location toEscapedModel();

	@Override
	public com.kencana.lms.model.Location toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}