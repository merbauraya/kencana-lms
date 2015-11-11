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

import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.kencana.lms.NoSuchItemTypeException;
import com.kencana.lms.model.ItemType;
import com.kencana.lms.service.base.ItemTypeLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.UserPortraitSizeException;
import com.liferay.portal.UserPortraitTypeException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.image.ImageBag;
import com.liferay.portal.kernel.image.ImageToolUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portlet.documentlibrary.ImageSizeException;
import com.liferay.util.portlet.PortletProps;

/**
 * The implementation of the item type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.kencana.lms.service.ItemTypeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.kencana.lms.service.base.ItemTypeLocalServiceBaseImpl
 * @see com.kencana.lms.service.ItemTypeLocalServiceUtil
 */
public class ItemTypeLocalServiceImpl extends ItemTypeLocalServiceBaseImpl {
	
	
	public ItemType updateCover(long itemTypeId,byte[] bytes)
			throws  SystemException, com.liferay.portal.kernel.exception.PortalException 
	{

			ItemType itemType = itemTypePersistence.findByPrimaryKey(itemTypeId);

			long imageMaxSize = Long.valueOf(PortletProps.get("cover.image.max.size"));

			if ((imageMaxSize > 0) &&
				((bytes == null) || (bytes.length > imageMaxSize))) {

				throw new UserPortraitSizeException();
			}

			long coverId = itemType.getCoverId();

			if (coverId <= 0) {
				coverId = counterLocalService.increment();
				itemType.setCoverId(coverId);
				
			}

			try {
				ImageBag imageBag = ImageToolUtil.read(bytes);

				RenderedImage renderedImage = imageBag.getRenderedImage();

				if (renderedImage == null) {
					throw new UserPortraitTypeException();
				}
				int maxHeight = Integer.valueOf(PortletProps.get("cover.image.max.height"));
				int maxWidth = Integer.valueOf(PortletProps.get("cover.image.max.width"));
				renderedImage = ImageToolUtil.scale(
					renderedImage, maxHeight,
					maxWidth);

				String contentType = imageBag.getType();

				ImageLocalServiceUtil.updateImage(
					coverId,
					ImageToolUtil.getBytes(renderedImage, contentType));
			}
			catch (IOException ioe) {
				throw new ImageSizeException(ioe);
			}
			itemTypePersistence.update(itemType);
			

			return itemType; 
	}
	
	public ItemType updateItemType(long companyId,long groupId,long userId,long itemTypeId,String name,
			String checkoutMessage,String checkinMessage,double rentalRate,
			boolean notForLoan) throws SystemException 
	{
		ItemType itemType;
		if (itemTypeId <= 0)
		{
			long id = CounterLocalServiceUtil.increment(ItemType.class.getName());
			itemType = itemTypePersistence.create(id);
			itemType.setCreateDate(new Date());
		}else
		{
			itemType = itemTypePersistence.fetchByPrimaryKey(itemTypeId);
		}
		itemType.setItemTypeName(name);
		itemType.setUserId(userId);
		itemType.setCompanyId(companyId);
		itemType.setGroupId(groupId);
		itemType.setCheckoutMessage(checkoutMessage);
		itemType.setCheckinMessage(checkinMessage);
		itemType.setRentalRate(rentalRate);
		itemType.setNotForLoan(notForLoan);
		
		return itemTypePersistence.update(itemType);
	}
	
	
	public List<ItemType> findByCompanyGroup(long companyId,long groupId,int start,int end) throws SystemException
	{
		return itemTypePersistence.findByCompanyGroup(companyId,groupId,start,end);
	}
	public List<ItemType> findByCompanyGroup(long companyId,long groupId,int start,int end,OrderByComparator obc) throws SystemException
	{
		return itemTypePersistence.findByCompanyGroup(companyId,groupId,start,end,obc);
	}
	
	public List<ItemType> findByCompanyGroup(long companyId,long groupId) throws SystemException
	{
		return itemTypePersistence.findByCompanyGroup(companyId,groupId);

	}
	
	
}