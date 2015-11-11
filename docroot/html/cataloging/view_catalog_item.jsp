<%@ include file="/html/cataloging/init.jsp" %>

<%
	Catalog catalog = null;
	long catalogId = ParamUtil.getLong(request, "catalogId");
	
	if (catalogId > 0)
	{
		catalog = CatalogLocalServiceUtil.fetchCatalog(catalogId);
	}
%>

<c:if test="<%=!Validator.isNotNull(catalog)%>">
	<liferay-ui:error key="invalid-catalog" message="invalid-catalog" />

</c:if>
<%
	List<CatalogItem> items = CatalogLocalServiceUtil.getItems(catalogId);
%>
<h1><%=catalog.getTitle() %></h1>

<liferay-portlet:renderURL varImpl="newCatalogItemURL">
	<portlet:param name="catalogId" value="<%=String.valueOf(catalogId)%>"/>
	<portlet:param name="page" value="<%= CatalogingConstants.PAGE_EDIT_CATALOG_ITEM %>"/>
</liferay-portlet:renderURL>

<aui:a href="<%= newCatalogItemURL.toString()  %>" label="new-item"></aui:a>

<liferay-ui:tabs names="catalog-detail,existing-items" refresh="false">
    <liferay-ui:section>
        Info for catalog Detail
    </liferay-ui:section>
    <liferay-ui:section>
        <liferay-ui:search-container delta="20" emptyResultsMessage="no-item-defined">
			<liferay-ui:search-container-results>
			<%
				searchContainer.setTotal(items.size());
				results = items; 
				searchContainer.setResults(results);
			%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row
				className="com.kencana.lms.model.CatalogItem"
				keyProperty="catalogItemId"
				modelVar="catalogItem"
			>
				
				<liferay-ui:search-container-column-text
						name="copy-number"
						value="<%= String.valueOf(catalogItem.getCopyNumber()) %>"
						orderable="<%= true %>"
				/>
				<liferay-ui:search-container-column-text
						name="call-number"
						value="<%= catalogItem.getCallNumber() %>"
						orderable="<%= true %>"
				/>
				<liferay-ui:search-container-column-text
						name="circulation-count"
						value="<%= String.valueOf(catalogItem.getCirculationCount()) %>"
						orderable="<%= true %>"
				/>
				<liferay-ui:search-container-column-status
						name="withdrawn"
						status="<%=catalogItem.getWithdrawnStatus() ? 1 : 0 %>"
				
				/>
				<liferay-ui:search-container-column-date
						name="last-seen"
						value="<%=catalogItem.getLastSeenDate() %>"
				
				/>
				
				<liferay-ui:search-container-column-text
						name="purchase-price"
						value="<%= String.valueOf(catalogItem.getPurchasePrice()) %>"
						valign="right"
						orderable="<%= true %>"
				/>
				
				
				
				<liferay-portlet:renderURL varImpl="editCatalogURL">
						<portlet:param name="page" value="/html/cataloging/edit_catalog_simple.jsp" />
						<portlet:param name="redirect" value="<%= currentURL %>" />
						<portlet:param name="catalogId" value="<%= String.valueOf(catalog.getCatalogId()) %>" />
						
				</liferay-portlet:renderURL>
				<liferay-portlet:renderURL varImpl="viewCatalogItemURL">
						<portlet:param name="page" value="/html/cataloging/view_catalog_item.jsp" />
						<portlet:param name="redirect" value="<%= currentURL %>" />
						<portlet:param name="catalogId" value="<%= String.valueOf(catalog.getCatalogId()) %>" />
						
				</liferay-portlet:renderURL>
				<liferay-portlet:renderURL varImpl="editCatalogItemURL">
					<portlet:param name="page" value="/html/cataloging/edit_catalog_item.jsp" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="catalogItemId" value="<%= String.valueOf(catalogItem.getCatalogItemId()) %>" />
					<portlet:param name="catalogId" value="<%= String.valueOf(catalog.getCatalogId()) %>" />
					
						
				</liferay-portlet:renderURL>
				<liferay-ui:search-container-column-text>
					<liferay-ui:icon-menu>
						<liferay-ui:icon image="view" message="view-catalog-item" label="view-item" url="<%= viewCatalogItemURL.toString() %>" />
						<liferay-ui:icon image="view" message="edit-catalog-item" label="edit-catelog-item" url="<%= editCatalogItemURL.toString() %>" />
						
					</liferay-ui:icon-menu>
				</liferay-ui:search-container-column-text>
			
				
			
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
    </liferay-ui:section>
    
</liferay-ui:tabs>

