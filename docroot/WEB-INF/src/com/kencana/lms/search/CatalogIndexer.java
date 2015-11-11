package com.kencana.lms.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import javax.portlet.PortletURL;













import com.kencana.lms.marc.MarcHelper;
import com.kencana.lms.model.Catalog;
import com.kencana.lms.service.CatalogLocalServiceUtil;
import com.kencana.lms.service.persistence.CatalogActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;



public class CatalogIndexer extends BaseIndexer {
	public static final String[] CLASS_NAMES = { Catalog.class.getName() };
	public static final String PORTLET_ID = "kencana-portlet";

	@Override
	public String[] getClassNames() {
		
		return CLASS_NAMES;
	}

	@Override
	public String getPortletId() {
		
		return PORTLET_ID;
	}

	@Override
	protected void doDelete(Object arg0) throws Exception {
		Catalog catalog = (Catalog)arg0;
		deleteDocument(catalog.getCompanyId(), catalog.getCatalogId());
		
	}

	@Override
	protected Document doGetDocument(Object arg0) throws Exception {
		Catalog catalog = (Catalog)arg0;
		
		MarcHelper marcHelper = new MarcHelper();
		marcHelper.setMarcXML(catalog.getMarc());
		
		Document document = getBaseModelDocument(PORTLET_ID, catalog);
		
		document.addText(KencanaField.TITLE, catalog.getTitle());
		
		String[] titles = marcHelper.getTitles245();
		Field otherTitle = new Field(KencanaField.TAG_245, titles );
        document.add(otherTitle);
		
        document.addKeyword(KencanaField.ITEM_TYPE, marcHelper.getItemType_980_1());
        document.addKeyword(KencanaField.CATALOG_VISIBLE, catalog.getVisible());
		
		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale arg1, String arg2,
			PortletURL arg3) throws Exception {
		
		 Summary summary = createSummary(document);

	     summary.setMaxContentLength(200);

	     return summary;
	}

	@Override
	protected void doReindex(Object arg0) throws Exception {
		Catalog catalog = (Catalog)arg0;

        Document document = getDocument(catalog);

        SearchEngineUtil.updateDocument(
                getSearchEngineId(), catalog.getCompanyId(), document,true);
		
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		
		long companyId = GetterUtil.getLong(ids[0]);

        reindexEntries(companyId);
		
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		
		Catalog catalog = CatalogLocalServiceUtil.getCatalog(classPK);// .getSuburItem(classPK);

        doReindex(catalog);
	}
	protected void reindexEntries(long companyId) throws PortalException,
    SystemException {

		final Collection<Document> documents = new ArrayList<Document>();
		
		ActionableDynamicQuery actionableDynamicQuery = new CatalogActionableDynamicQuery() {
		
		    @Override
		    protected void addCriteria(DynamicQuery dynamicQuery) {
		    }
		
		    @Override
		    protected void performAction(Object object) throws PortalException {
		    	Catalog catalog = (Catalog) object;
		
		            Document document = getDocument(catalog);
		
		            documents.add(document);
		    }
		
		};
		
		actionableDynamicQuery.setCompanyId(companyId);
		
		actionableDynamicQuery.performActions();
		
		SearchEngineUtil.updateDocuments(getSearchEngineId(), companyId,documents,true);
		}

	@Override
	protected String getPortletId(SearchContext arg0) {
		
		return PORTLET_ID;
	}

}
