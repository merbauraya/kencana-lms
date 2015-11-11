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

import com.kencana.lms.NoSuchCatalogItemException;
import com.kencana.lms.NoSuchCirculationTransException;
import com.kencana.lms.model.Catalog;
import com.kencana.lms.model.CatalogItem;
import com.kencana.lms.model.CirculationTrans;
import com.kencana.lms.portlet.Cataloging;
import com.kencana.lms.service.base.CatalogItemLocalServiceBaseImpl;
import com.kencana.lms.util.KencanaUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetLinkLocalServiceUtil;

/**
 * The implementation of the catalog item local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.kencana.lms.service.CatalogItemLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.kencana.lms.service.base.CatalogItemLocalServiceBaseImpl
 * @see com.kencana.lms.service.CatalogItemLocalServiceUtil
 */
public class CatalogItemLocalServiceImpl extends CatalogItemLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.kencana.lms.service.CatalogItemLocalServiceUtil} to access the catalog item local service.
	 */
	
	
	
	public CatalogItem newCatalogItem(long userId,long catalogId) throws SystemException
	{
		long id = CounterLocalServiceUtil.increment(CatalogItem.class.getName());
		CatalogItem catalogItem = catalogItemPersistence.create(id);
		catalogItem.setCreateDate(new Date());
		catalogItem.setUserId(userId);
		catalogItem.setCatalogId(catalogId);
		
		
		Catalog catalog = catalogPersistence.fetchByPrimaryKey(catalogId);
		
		catalogItem.setCatalogTitle(StringUtil.shorten(catalog.getTitle(),75));
		
		return catalogItemPersistence.update(catalogItem);
	}
	
	public List<CatalogItem> getByCompanyGroup(long companyId,long groupId, int start, int end,OrderByComparator obc) throws SystemException
	{
		return catalogItemPersistence.findByCompanyGroup( companyId, groupId,start,end,obc);
	}
	public int countByCompanyGroup(long companyId,long groupId) throws SystemException
	{
		return catalogItemPersistence.countByCompanyGroup(companyId,groupId); 
	}
	public int countUnreleasedByCompanyGroup(long companyId,long groupId) throws SystemException
	{
		return catalogItemPersistence.countByReleasedCompanyGroup(companyId, groupId, false);
	}
	public int countReleasedByCompanyGroup(long companyId,long groupId) throws SystemException
	{
		return catalogItemPersistence.countByReleasedCompanyGroup(companyId, groupId, true);
	}
	public List<CatalogItem> getUnreleasedByCompanyGroup(long companyId,long groupId,int start,int end,OrderByComparator obc) throws SystemException
	{
		return catalogItemPersistence.findByReleasedCompanyGroup(companyId, groupId, false, start, end, obc);
	}
	
	
	public List<CatalogItem> getReleaseByCompanyGroup(long companyId,long groupId,int start,int end,OrderByComparator obc) throws SystemException
	{
		return catalogItemPersistence.findByReleasedCompanyGroup(companyId, groupId, true, start, end, obc);
	}
	
	
	
	public CatalogItem update(CatalogItem catalogItem,ServiceContext serviceContext) throws SystemException, PortalException
	{
		
		 
		resourceLocalService.addResources(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(), serviceContext.getUserId(),
                 CatalogItem.class.getName(), catalogItem.getCatalogItemId(), false, true, true);
		
		String catalogItemUUID = null; 
		String title = "Catalog Item";
		boolean isVisible = true;
		
		if (catalogItem.getWithdrawnStatus() || catalogItem.getLostStatus() || catalogItem.getDamageStatus())
		{
			isVisible = false;
		}
		
		AssetEntry assetEntry = AssetEntryLocalServiceUtil.updateEntry(serviceContext.getUserId(),
				 serviceContext.getScopeGroupId(), catalogItem.getCreateDate(),
				 catalogItem.getModifiedDate(), CatalogItem.class.getName(),
				 catalogItem.getCatalogItemId(), catalogItemUUID, 0,
                 serviceContext.getAssetCategoryIds(),
                 serviceContext.getAssetTagNames(), isVisible, null, null, null,
                 ContentTypes.TEXT_HTML, title, null, null, null,
                 null, 0, 0, null, false);
		 
		
		AssetLinkLocalServiceUtil.updateLinks(serviceContext.getUserId(), assetEntry.getEntryId(),
                serviceContext.getAssetLinkEntryIds(),
                AssetLinkConstants.TYPE_RELATED);
		
		
		
		Catalog catalog = catalogPersistence.fetchByPrimaryKey(catalogItem.getCatalogId());
		if (Validator.isNull(catalog))
		{
			LOGGER.error("Catalog not found for catalogItem {"+catalogItem.getCatalogItemId() +"}" );
		}
		
		
		catalogItem.setCatalogTitle(StringUtil.shorten(catalog.getTitle(),75));
		catalogItem.setCompanyId(serviceContext.getCompanyId());
		catalogItem.setGroupId(serviceContext.getScopeGroupId());
		catalogItem.setModifiedDate(new Date());
		
		return catalogItemPersistence.update(catalogItem);
		
	}
	@Override
	public CatalogItem findByBarcode(long companyId,String barcode) throws NoSuchCatalogItemException,SystemException
	{
		return catalogItemPersistence.findByBarcode(companyId,barcode);
	}
	
	@Override
	public boolean isCheckOut(long companyId,long catalogItemId) throws SystemException
	{
		try {
			CirculationTrans circulationTrans = circulationTransPersistence.findByCatalogItem(companyId, catalogItemId);
			return true;
		} catch (NoSuchCirculationTransException e) {
			return false;
		}
		
	}
	public void releaseCatalogItems(long[] catalogItemIds,ServiceContext serviceContext) throws SystemException
	{
		List<CatalogItem> catalogItems = getByIds(catalogItemIds);
		
		for (CatalogItem catalogItem : catalogItems)
		{
			catalogItem.setReleased(true);
			catalogItem.setReleaseDate(new Date());
			catalogItem.setReleaseByUserId(serviceContext.getUserId());
			catalogItemPersistence.update(catalogItem);
		}
	}
	
	public CatalogItem withdrawCatalogItem(long catalogItemId,boolean lostStatus,boolean damageStatus,ServiceContext serviceContext) throws NoSuchCatalogItemException, SystemException
	{
		CatalogItem catalogItem = catalogItemPersistence.findByPrimaryKey(catalogItemId);
		catalogItem.setWithdrawnStatus(true);
		catalogItem.setWithdrawnDate(new Date());
		catalogItem.setLostStatus(lostStatus);
		catalogItem.setDamageStatus(damageStatus);
		
		return 	catalogItemPersistence.update(catalogItem);
		
	}
	
	public List<CatalogItem> getByIds(long[] catalogItemIds) throws SystemException
	{
		if (!ArrayUtil.isNotEmpty(catalogItemIds))
			return null;
		
		Object[] ids = KencanaUtil.toObject(catalogItemIds);
		DynamicQuery dynamicQuery=DynamicQueryFactoryUtil.forClass(CatalogItem.class);  
		dynamicQuery.add(RestrictionsFactoryUtil.in("catalogItemId", ids));  
		
		
		return catalogItemPersistence.findWithDynamicQuery(dynamicQuery);

	}
	private static Log LOGGER = LogFactoryUtil.getLog(CatalogItemLocalServiceImpl.class);

}