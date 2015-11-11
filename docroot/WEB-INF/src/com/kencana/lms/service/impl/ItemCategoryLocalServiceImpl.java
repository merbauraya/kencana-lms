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

import java.util.Date;
import java.util.List;

import com.kencana.lms.NoSuchItemCategoryException;
import com.kencana.lms.model.ItemCategory;
import com.kencana.lms.service.base.ItemCategoryLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * The implementation of the item category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.kencana.lms.service.ItemCategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.kencana.lms.service.base.ItemCategoryLocalServiceBaseImpl
 * @see com.kencana.lms.service.ItemCategoryLocalServiceUtil
 */
public class ItemCategoryLocalServiceImpl
	extends ItemCategoryLocalServiceBaseImpl {
	
	
	
	
	public ItemCategory updateItemCategory(long companyId,long groupId,long userId,long itemCategoryId,String name) throws SystemException, NoSuchItemCategoryException
	{
		ItemCategory itemCategory;
		
		Date now = new Date();
		if (itemCategoryId <= 0)
		{
			long id = CounterLocalServiceUtil.increment(ItemCategory.class.getName());
			itemCategory = itemCategoryPersistence.create(id);
			itemCategory.setCreateDate(now);
			itemCategory.setUserId(userId);
		}else
		{
			itemCategory = itemCategoryPersistence.findByPrimaryKey(itemCategoryId);
		}
		itemCategory.setModifiedDate(now);
		itemCategory.setItemCategoryName(name);
		itemCategory.setCompanyId(companyId);
		itemCategory.setGroupId(groupId);
		
		return itemCategoryPersistence.update(itemCategory);
		
	}
	
	public List<ItemCategory> findByCompanyGroup(long companyId,long groupId) throws SystemException
	{
		return itemCategoryPersistence.findByGroupCompany(companyId, groupId);
	}
	
	public List<ItemCategory> findByCompanyGroup(long companyId,long groupId,int start,int end) throws SystemException
	{
		return itemCategoryPersistence.findByGroupCompany(companyId, groupId, start, end);
	}
	public List<ItemCategory> findByCompanyGroup(long companyId,long groupId,int start,int end,OrderByComparator obc) throws SystemException
	{
		return itemCategoryPersistence.findByGroupCompany(companyId, groupId, start, end,obc);
	}
	
}