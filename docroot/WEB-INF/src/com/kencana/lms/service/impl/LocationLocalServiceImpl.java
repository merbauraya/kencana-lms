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

import com.kencana.lms.model.Location;
import com.kencana.lms.service.base.LocationLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * The implementation of the location local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.kencana.lms.service.LocationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.kencana.lms.service.base.LocationLocalServiceBaseImpl
 * @see com.kencana.lms.service.LocationLocalServiceUtil
 */
public class LocationLocalServiceImpl extends LocationLocalServiceBaseImpl 
{
	/**
	 * Return list of locations based on library
	 * @param libraryId
	 * @return
	 * @throws SystemException
	 */
	public List<Location> findByLibrary(long libraryId) throws SystemException
	{
		return locationPersistence.findByLibrary(libraryId);
	}
	
	/**
	 * Add/Update location
	 * @param userId
	 * @param companyId
	 * @param groupId
	 * @param libaryId
	 * @param locationId
	 * @param description
	 * @return
	 * @throws SystemException
	 */
	public Location updateLocation(long userId,long companyId,long groupId,long libraryId,
			long locationId,String name) throws SystemException
	{
		Location location = null;
		if (locationId <= 0)
		{
			long id = CounterLocalServiceUtil.increment(Location.class.getName());
			location  = locationPersistence.create(id);
		}else
		{
			location = locationPersistence.fetchByPrimaryKey(locationId);
		}
		
		location.setCompanyId(companyId);
		location.setGroupId(groupId);
		location.setLocationName(name);
		location.setLibraryId(libraryId);
		
		
		return locationPersistence.update(location);
	}
	
	public List<Location> findByGroupCompany(long companyId,long groupId) throws SystemException
	{
		return locationPersistence.findByCompanyGroup(companyId, groupId);
	}
	
	public List<Location> findByGroupCompany(long companyId,long groupId,int start,int end,OrderByComparator obc) throws SystemException
	{
		return locationPersistence.findByCompanyGroup(companyId, groupId, start, end, obc);
	}
	
}