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

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the CirculationTrans service. Represents a row in the &quot;Kencana_CirculationTrans&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.kencana.lms.model.impl.CirculationTransModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.kencana.lms.model.impl.CirculationTransImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see CirculationTrans
 * @see com.kencana.lms.model.impl.CirculationTransImpl
 * @see com.kencana.lms.model.impl.CirculationTransModelImpl
 * @generated
 */
public interface CirculationTransModel extends BaseModel<CirculationTrans> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a circulation trans model instance should use the {@link CirculationTrans} interface instead.
	 */

	/**
	 * Returns the primary key of this circulation trans.
	 *
	 * @return the primary key of this circulation trans
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this circulation trans.
	 *
	 * @param primaryKey the primary key of this circulation trans
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the trans ID of this circulation trans.
	 *
	 * @return the trans ID of this circulation trans
	 */
	public long getTransId();

	/**
	 * Sets the trans ID of this circulation trans.
	 *
	 * @param transId the trans ID of this circulation trans
	 */
	public void setTransId(long transId);

	/**
	 * Returns the company ID of this circulation trans.
	 *
	 * @return the company ID of this circulation trans
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this circulation trans.
	 *
	 * @param companyId the company ID of this circulation trans
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this circulation trans.
	 *
	 * @return the group ID of this circulation trans
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this circulation trans.
	 *
	 * @param groupId the group ID of this circulation trans
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the library ID of this circulation trans.
	 *
	 * @return the library ID of this circulation trans
	 */
	public long getLibraryId();

	/**
	 * Sets the library ID of this circulation trans.
	 *
	 * @param libraryId the library ID of this circulation trans
	 */
	public void setLibraryId(long libraryId);

	/**
	 * Returns the patron ID of this circulation trans.
	 *
	 * @return the patron ID of this circulation trans
	 */
	public long getPatronId();

	/**
	 * Sets the patron ID of this circulation trans.
	 *
	 * @param patronId the patron ID of this circulation trans
	 */
	public void setPatronId(long patronId);

	/**
	 * Returns the catalog item ID of this circulation trans.
	 *
	 * @return the catalog item ID of this circulation trans
	 */
	public long getCatalogItemId();

	/**
	 * Sets the catalog item ID of this circulation trans.
	 *
	 * @param catalogItemId the catalog item ID of this circulation trans
	 */
	public void setCatalogItemId(long catalogItemId);

	/**
	 * Returns the trans date of this circulation trans.
	 *
	 * @return the trans date of this circulation trans
	 */
	public Date getTransDate();

	/**
	 * Sets the trans date of this circulation trans.
	 *
	 * @param transDate the trans date of this circulation trans
	 */
	public void setTransDate(Date transDate);

	/**
	 * Returns the due date of this circulation trans.
	 *
	 * @return the due date of this circulation trans
	 */
	public Date getDueDate();

	/**
	 * Sets the due date of this circulation trans.
	 *
	 * @param dueDate the due date of this circulation trans
	 */
	public void setDueDate(Date dueDate);

	/**
	 * Returns the overdue of this circulation trans.
	 *
	 * @return the overdue of this circulation trans
	 */
	public boolean getOverdue();

	/**
	 * Returns <code>true</code> if this circulation trans is overdue.
	 *
	 * @return <code>true</code> if this circulation trans is overdue; <code>false</code> otherwise
	 */
	public boolean isOverdue();

	/**
	 * Sets whether this circulation trans is overdue.
	 *
	 * @param overdue the overdue of this circulation trans
	 */
	public void setOverdue(boolean overdue);

	/**
	 * Returns the return date of this circulation trans.
	 *
	 * @return the return date of this circulation trans
	 */
	public Date getReturnDate();

	/**
	 * Sets the return date of this circulation trans.
	 *
	 * @param returnDate the return date of this circulation trans
	 */
	public void setReturnDate(Date returnDate);

	/**
	 * Returns the last renew date of this circulation trans.
	 *
	 * @return the last renew date of this circulation trans
	 */
	public Date getLastRenewDate();

	/**
	 * Sets the last renew date of this circulation trans.
	 *
	 * @param lastRenewDate the last renew date of this circulation trans
	 */
	public void setLastRenewDate(Date lastRenewDate);

	/**
	 * Returns the renew count of this circulation trans.
	 *
	 * @return the renew count of this circulation trans
	 */
	public int getRenewCount();

	/**
	 * Sets the renew count of this circulation trans.
	 *
	 * @param renewCount the renew count of this circulation trans
	 */
	public void setRenewCount(int renewCount);

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
		com.kencana.lms.model.CirculationTrans circulationTrans);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.kencana.lms.model.CirculationTrans> toCacheModel();

	@Override
	public com.kencana.lms.model.CirculationTrans toEscapedModel();

	@Override
	public com.kencana.lms.model.CirculationTrans toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}