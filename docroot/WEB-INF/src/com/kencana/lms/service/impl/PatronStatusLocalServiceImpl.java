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

import com.kencana.lms.NoSuchPatronStatusException;
import com.kencana.lms.model.PatronStatus;
import com.kencana.lms.service.base.PatronStatusLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the patron status local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.kencana.lms.service.PatronStatusLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.kencana.lms.service.base.PatronStatusLocalServiceBaseImpl
 * @see com.kencana.lms.service.PatronStatusLocalServiceUtil
 */
public class PatronStatusLocalServiceImpl
	extends PatronStatusLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.kencana.lms.service.PatronStatusLocalServiceUtil} to access the patron status local service.
	 */
	
	public PatronStatus addPatronStatus(long groupId,long companyId,String patronStatusName,
			boolean noLogin,boolean noCheckout,boolean noReserve,int color) throws SystemException
	{
		long patronStatusId = CounterLocalServiceUtil.increment(PatronStatus.class.getName());
		PatronStatus patronStatus = patronStatusPersistence.create(patronStatusId);
		patronStatus.setGroupId(groupId);
		patronStatus.setCompanyId(companyId);
		patronStatus.setPatronStatusName(patronStatusName);
		patronStatus.setNoCheckout(noCheckout);
		patronStatus.setNoLogin(noLogin);
		patronStatus.setNoReserve(noReserve);
		
			
		patronStatusPersistence.update(patronStatus);
		
		return patronStatus;
		
	}
	
	public PatronStatus updatePatronStatus(long patronStatusId,long groupId,long companyId,String patronStatusName,
			boolean noLogin,boolean noCheckout,boolean noReserve,int color) throws NoSuchPatronStatusException, SystemException
	{
		PatronStatus patronStatus = patronStatusPersistence.findByPrimaryKey(patronStatusId);
		patronStatus.setGroupId(groupId);
		patronStatus.setCompanyId(companyId);
		patronStatus.setPatronStatusName(patronStatusName);
		patronStatus.setNoCheckout(noCheckout);
		patronStatus.setNoLogin(noLogin);
		patronStatus.setNoReserve(noReserve);
		
		return patronStatus;

	}
	public PatronStatus deletePatronStatus(long patronStatusId) throws NoSuchPatronStatusException, SystemException
	{
		return patronStatusPersistence.remove(patronStatusId);
				
	}
	public int countByGroup(long groupId) throws SystemException
	{
		return patronStatusPersistence.countByGroup(groupId);
	}
	public List<PatronStatus> findByGroup(long groupId,int start, int end) throws SystemException
	{
		return patronStatusPersistence.findByGroup(groupId, start, end);
	}
	public List<PatronStatus> findByCompany(long companyId,int start, int end) throws SystemException
	{
		return patronStatusPersistence.findByCompany(companyId, start, end);
	}
	public List<PatronStatus> findByCompany(long companyId) throws SystemException
	{
		return patronStatusPersistence.findByCompany(companyId);
	}
}