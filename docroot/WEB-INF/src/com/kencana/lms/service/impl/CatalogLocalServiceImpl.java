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

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.marc4j.MarcStreamWriter;
import org.marc4j.MarcWriter;
import org.marc4j.MarcXmlWriter;
import org.marc4j.converter.impl.AnselToUnicode;
import org.marc4j.marc.Record;

import com.kencana.lms.NoSuchCatalogException;
import com.kencana.lms.marc.MarcHelper;
import com.kencana.lms.model.Catalog;
import com.kencana.lms.model.CatalogItem;
import com.kencana.lms.service.base.CatalogLocalServiceBaseImpl;
import com.kencana.lms.util.KencanaUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetLinkLocalServiceUtil;

/**
 * The implementation of the catalog local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.kencana.lms.service.CatalogLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.kencana.lms.service.base.CatalogLocalServiceBaseImpl
 * @see com.kencana.lms.service.CatalogLocalServiceUtil
 */
public class CatalogLocalServiceImpl extends CatalogLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.kencana.lms.service.CatalogLocalServiceUtil} to access the catalog local service.
	 */
	
	public Catalog addCatalog(long userId,long companyId,
			long groupId,long itemTypeId,Record marcRecord,ServiceContext serviceContext) throws SystemException, PortalException
	{
		
		User user = userLocalService.getUserById(userId);
		long catalogId = CounterLocalServiceUtil.increment(Catalog.class.getName());
		
		LOGGER.info("addCatalog");
		LOGGER.info("grp="+groupId);
		MarcHelper marcHelper = new MarcHelper(marcRecord); 
		
		
		
		
		Catalog catalog = catalogPersistence.create(catalogId);
		catalog = updateCatalogFromMarc(catalog,marcHelper);
		
		
		catalog.setUserId(userId);
		catalog.setCompanyId(companyId);
		catalog.setGroupId(groupId);
		catalog.setUUID(PortalUUIDUtil.generate());
		
		
		
		
		
		
		
		Date now = new Date();
		
		catalog.setCreateDate(now);
		catalog.setModifiedDate(now);
		catalog.setCreatedByUserId(userId);
		
		
		resourceLocalService.addResources(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(), serviceContext.getUserId(),
                Catalog.class.getName(), catalog.getCatalogId(), false, true, true);
		
		//assetentry
		boolean isVisible = false;
		AssetEntry assetEntry = AssetEntryLocalServiceUtil.updateEntry(serviceContext.getUserId(),
				 serviceContext.getScopeGroupId(), catalog.getCreateDate(),
				 catalog.getModifiedDate(), Catalog.class.getName(),
				 catalog.getCatalogId(), catalog.getUUID(), 0,
                serviceContext.getAssetCategoryIds(),
                serviceContext.getAssetTagNames(), isVisible, null, null, null,
                ContentTypes.TEXT_HTML, catalog.getTitle(), null, null, null,
                null, 0, 0, null, false);
		
		
		AssetLinkLocalServiceUtil.updateLinks(serviceContext.getUserId(), assetEntry.getEntryId(),
                serviceContext.getAssetLinkEntryIds(),
                AssetLinkConstants.TYPE_RELATED);
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
                Catalog.class);

		indexer.reindex(catalog);
		
		return catalogPersistence.update(catalog);
		
		
		
		
		 
		 
	}
	@Override
	public void deleteCatalog(long[] catalogIds,boolean removeCatalogItem,ServiceContext serviceContext) throws PortalException, SystemException
	{
		
		for (long catalogId : catalogIds)
		{
		
			resourceLocalService.deleteResource(serviceContext.getCompanyId(),
                Catalog.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
                catalogId);
		
			Catalog catalog = catalogPersistence.fetchByPrimaryKey(catalogId);
		
			AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
				 Catalog.class.getName(), catalogId);
			
			if (Validator.isNotNull(assetEntry))
			{
				AssetLinkLocalServiceUtil.deleteLinks(assetEntry.getEntryId());

				AssetEntryLocalServiceUtil.deleteEntry(assetEntry);
			}
			Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
	                        Catalog.class);
	     
		     if (removeCatalogItem)
		     {
		    	 List<CatalogItem> catalogItems = getItems(catalogId);
		    	 for (CatalogItem catalogItem : catalogItems)
		    	 {
		    		 catalogItemPersistence.remove(catalogItem);
		    	 }
		     }
	     
	     
	     	indexer.delete(catalog);

		 
	     	catalogPersistence.remove(catalogId);
		}
	}
	
	
	
	private Catalog updateCatalogFromMarc(Catalog catalog, MarcHelper marcHelper)
	{
		//marc content
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		//MarcWriter writer = new MarcStreamWriter(os);
		
		MarcWriter writer = new MarcXmlWriter(os, false);
		writer.setConverter(new AnselToUnicode());
		writer.write(marcHelper.getRecord());
		writer.close(); 
		
		
			//String marcContent = new String(os.toByteArray(),"UTF-8");
		String marcContent = new String(os.toByteArray());
		
		catalog.setMarc(marcContent);
		catalog.setItemTypeId(marcHelper.getItemType_980_1());
		catalog.setIsbn(marcHelper.getISBN());
		catalog.setIssn(marcHelper.getISSN());
		catalog.setTitle(marcHelper.getFullTitle());
		catalog.setCallNumber(marcHelper.getCallNumber090_a());
		catalog.setAuthor(marcHelper.getAuthor());
		catalog.setPublisher(marcHelper.getPublication260_b());
		
		return catalog;
	}
	
	public void indexCatalog(long[] catalogIds) throws SystemException, SearchException
	{
		List<Catalog> catalogs = getByIds(catalogIds);
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
                Catalog.class);
		for (Catalog catalog : catalogs)
		{
			catalog.setVisible(true);
			indexer.reindex(catalog);
			catalogPersistence.update(catalog);
			
		}
	}
	
	public Catalog updateCatalog(Catalog catalog,long userId, Record marcRecord,ServiceContext serviceContext) throws PortalException, SystemException
	{
		MarcHelper marcHelper = new MarcHelper(marcRecord); 
		catalog = updateCatalogFromMarc(catalog,marcHelper);
		Date now = new Date();
		catalog.setModifiedDate(now);
		catalog.setUserId(userId);
		
		resourceLocalService.addResources(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(), serviceContext.getUserId(),
                Catalog.class.getName(), catalog.getCatalogId(), false, true, true);
	
		
		boolean isVisible = false;
		AssetEntry assetEntry = AssetEntryLocalServiceUtil.updateEntry(serviceContext.getUserId(),
				 serviceContext.getScopeGroupId(), catalog.getCreateDate(),
				 catalog.getModifiedDate(), Catalog.class.getName(),
				 catalog.getCatalogId(), catalog.getUUID(), 0,
                serviceContext.getAssetCategoryIds(),
                serviceContext.getAssetTagNames(), isVisible, null, null, null,
                ContentTypes.TEXT_HTML, catalog.getTitle(), null, null, null,
                null, 0, 0, null, false);
		
		
		AssetLinkLocalServiceUtil.updateLinks(serviceContext.getUserId(), assetEntry.getEntryId(),
                serviceContext.getAssetLinkEntryIds(),
                AssetLinkConstants.TYPE_RELATED);
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
                Catalog.class);

		indexer.reindex(catalog);
		
		return catalogPersistence.update(catalog);
		

	}
	
	@Override
	public Catalog editCatalog(long userId,long catalogId,long itemTypeId,Record marcRecord,ServiceContext serviceContext) throws SystemException,PortalException 
	{
		MarcHelper marcHelper = new MarcHelper(marcRecord); 
		Catalog catalog = catalogPersistence.fetchByPrimaryKey(catalogId);
		
		Date now = new Date();
		catalog.setUserId(userId);
		catalog = updateCatalogFromMarc(catalog,marcHelper);
		
		
		catalog.setModifiedDate(now);
		//assetentry
		boolean isVisible = false;
		AssetEntry assetEntry = AssetEntryLocalServiceUtil.updateEntry(serviceContext.getUserId(),
				 serviceContext.getScopeGroupId(), catalog.getCreateDate(),
				 catalog.getModifiedDate(), Catalog.class.getName(),
				 catalog.getCatalogId(), catalog.getUUID(), 0,
                serviceContext.getAssetCategoryIds(),
                serviceContext.getAssetTagNames(), isVisible, null, null, null,
                ContentTypes.TEXT_HTML, catalog.getTitle(), null, null, null,
                null, 0, 0, null, false);
		
		
		AssetLinkLocalServiceUtil.updateLinks(serviceContext.getUserId(), assetEntry.getEntryId(),
                serviceContext.getAssetLinkEntryIds(),
                AssetLinkConstants.TYPE_RELATED);
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
                Catalog.class);

		indexer.reindex(catalog);
		
		return catalogPersistence.update(catalog);

		
	}
	
	
	public List<Catalog> findByGroupCompany(long companyId,long groupId,int start,int end) throws SystemException
	{
		return catalogPersistence.findByGroupCompany(groupId, companyId, start, end);
		
	}
	
	public int countByGroupCompany(long groupId,long companyId) throws SystemException
	{
		return catalogPersistence.countByGroupCompany(groupId, companyId);
	}
	
	public List<Catalog> findByGroup(long groupId,int start, int end) throws SystemException
	{
		return catalogPersistence.findByGroup(groupId, start, end);
	}
	public int countByGroup(long groupId) throws SystemException
	{
		return catalogPersistence.countByGroup(groupId);
		
	}
	public List<CatalogItem> getItems(long catalogId) throws SystemException
	{
		return catalogItemPersistence.findByCatalog(catalogId);
	}
	
	/**
	 * Return list of catalog based long array of catalog Id
	 * @param catalogIds
	 * @return list of catalog 
	 * @throws SystemException
	 */
	public List<Catalog> getByIds(long[] catalogIds) throws SystemException
	{
		if (!ArrayUtil.isNotEmpty(catalogIds))
			return null;
		
		Object[] ids = KencanaUtil.toObject(catalogIds);
		DynamicQuery dynamicQuery=DynamicQueryFactoryUtil.forClass(Catalog.class);  
		dynamicQuery.add(RestrictionsFactoryUtil.in("catalogId", ids));  
		
		
		return catalogPersistence.findWithDynamicQuery(dynamicQuery);

	}

	
	private static Log LOGGER = LogFactoryUtil.getLog(CatalogLocalServiceImpl.class);
}