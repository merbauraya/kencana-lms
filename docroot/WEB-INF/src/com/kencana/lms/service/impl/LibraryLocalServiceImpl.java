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

package com.kencana.lms.service.impl;

import java.util.List;

import com.kencana.lms.model.Library;
import com.kencana.lms.service.base.LibraryLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the library local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.kencana.lms.service.LibraryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.kencana.lms.service.base.LibraryLocalServiceBaseImpl
 * @see com.kencana.lms.service.LibraryLocalServiceUtil
 */
public class LibraryLocalServiceImpl extends LibraryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.kencana.lms.service.LibraryLocalServiceUtil} to access the library local service.
	 */
	public List<Library> findByGroupCompany(long companyId,long groupId) throws SystemException
	{
		return libraryPersistence.findByCompanyGroup(companyId, groupId);
	}
	public List<Library> findByCompany(long companyId,int start,int end) throws SystemException
	{
		return libraryPersistence.findByCompany(companyId, start, end);
	}
	public List<Library> findByCompany(long companyId) throws SystemException
	{
		return libraryPersistence.findByCompany(companyId);
	}
}