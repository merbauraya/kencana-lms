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

import com.kencana.lms.service.base.PatronCategoryLocalServiceBaseImpl;
import com.kencana.lms.model.PatronCategory;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
/**
 * The implementation of the patron category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.kencana.lms.service.PatronCategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.kencana.lms.service.base.PatronCategoryLocalServiceBaseImpl
 * @see com.kencana.lms.service.PatronCategoryLocalServiceUtil
 */
public class PatronCategoryLocalServiceImpl
	extends PatronCategoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.kencana.lms.service.PatronCategoryLocalServiceUtil} to access the patron category local service.
	 */
	public int countByCompany(long companyId) throws SystemException
	{
		return patronCategoryPersistence.countByCompany(companyId);
	}
	public PatronCategory add(long companyId,long groupId,String name,String notes) throws SystemException
	{
		long newId = CounterLocalServiceUtil.increment(PatronCategory.class.getName());
		PatronCategory patronCategory = patronCategoryPersistence.create(newId);
		patronCategory.setCompanyId(companyId);
		patronCategory.setGroupId(groupId);
		patronCategory.setPatronCategoryName(name);
		patronCategory.setNotes(notes);
		patronCategory = patronCategoryPersistence.update(patronCategory);
		
		return patronCategory;
	}
	public PatronCategory update(long patronCategoryId,long groupId,long companyId,String name,String notes) throws SystemException
	{
		PatronCategory patronCategory = patronCategoryPersistence.fetchByPrimaryKey(patronCategoryId);
		patronCategory.setCompanyId(companyId);
		patronCategory.setGroupId(groupId);
		patronCategory.setPatronCategoryName(name);
		patronCategory = patronCategoryPersistence.update(patronCategory);
		patronCategory.setNotes(notes);
		return patronCategory;
	}
	
	public List<PatronCategory> findByCompany(long companyId) throws SystemException
	{
		return patronCategoryPersistence.findByCompany(companyId);
	}
	
	public List<PatronCategory> findByCompany(long companyId,int start,int end) throws SystemException
	{
		return patronCategoryPersistence.findByCompany(companyId, start, end);
	}
	public List<PatronCategory> findByCompanyGroup(long companyId,long groupId) throws SystemException
	{
		return patronCategoryPersistence.findByCompanyGroup(companyId, groupId);
	}
	public List<PatronCategory> findByGroupCompany(long companyId,long groupId,int start,int end) throws SystemException
	{
		return patronCategoryPersistence.findByCompanyGroup(companyId, groupId, start, end);
	} 
}