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
 * The base model interface for the ReasonCode service. Represents a row in the &quot;Kencana_ReasonCode&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.kencana.lms.model.impl.ReasonCodeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.kencana.lms.model.impl.ReasonCodeImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see ReasonCode
 * @see com.kencana.lms.model.impl.ReasonCodeImpl
 * @see com.kencana.lms.model.impl.ReasonCodeModelImpl
 * @generated
 */
public interface ReasonCodeModel extends BaseModel<ReasonCode> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a reason code model instance should use the {@link ReasonCode} interface instead.
	 */

	/**
	 * Returns the primary key of this reason code.
	 *
	 * @return the primary key of this reason code
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this reason code.
	 *
	 * @param primaryKey the primary key of this reason code
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the reason code ID of this reason code.
	 *
	 * @return the reason code ID of this reason code
	 */
	public long getReasonCodeId();

	/**
	 * Sets the reason code ID of this reason code.
	 *
	 * @param reasonCodeId the reason code ID of this reason code
	 */
	public void setReasonCodeId(long reasonCodeId);

	/**
	 * Returns the reason code name of this reason code.
	 *
	 * @return the reason code name of this reason code
	 */
	@AutoEscape
	public String getReasonCodeName();

	/**
	 * Sets the reason code name of this reason code.
	 *
	 * @param reasonCodeName the reason code name of this reason code
	 */
	public void setReasonCodeName(String reasonCodeName);

	/**
	 * Returns the group ID of this reason code.
	 *
	 * @return the group ID of this reason code
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this reason code.
	 *
	 * @param groupId the group ID of this reason code
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this reason code.
	 *
	 * @return the company ID of this reason code
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this reason code.
	 *
	 * @param companyId the company ID of this reason code
	 */
	public void setCompanyId(long companyId);

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
	public int compareTo(com.kencana.lms.model.ReasonCode reasonCode);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.kencana.lms.model.ReasonCode> toCacheModel();

	@Override
	public com.kencana.lms.model.ReasonCode toEscapedModel();

	@Override
	public com.kencana.lms.model.ReasonCode toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}