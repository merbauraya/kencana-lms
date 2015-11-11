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

package com.kencana.lms.service.persistence;

import com.kencana.lms.model.CircTransHistory;
import com.kencana.lms.service.CircTransHistoryLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Mazlan Mat
 * @generated
 */
public abstract class CircTransHistoryActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public CircTransHistoryActionableDynamicQuery() throws SystemException {
		setBaseLocalService(CircTransHistoryLocalServiceUtil.getService());
		setClass(CircTransHistory.class);

		setClassLoader(com.kencana.lms.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("transId");
	}
}