<%@ include file="/html/cataloging/init.jsp" %>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="page" value="/html/cataloging/release_accession.jsp" />
	
</liferay-portlet:renderURL>

<%
	
	CatalogItemSearch catalogItemSearch = new CatalogItemSearch(renderRequest, iteratorURL); 


	long companyId = themeDisplay.getCompanyId();
	long groupId = themeDisplay.getScopeGroupId();
	String orderByCol = ParamUtil.getString(request, "orderByCol");
	String orderByType = ParamUtil.getString(request, "orderByType");
	

%>

<liferay-portlet:actionURL name="releaseAccession" varImpl="releaseAccessionURL">
	<liferay-util:param name="page" value="/html/cataloging/release_accession.jsp"></liferay-util:param>
</liferay-portlet:actionURL>



<aui:form method="post" action="<%= releaseAccessionURL %>" name="fm">
	<aui:input name="catalogItemIds" type="hidden"/>
	<liferay-ui:search-container delta="20" 
		emptyResultsMessage="no-catalog-defined"
		iteratorURL="<%= iteratorURL %>"
		rowChecker="<%= new RowChecker(renderResponse) %>"
		searchContainer ="<%= catalogItemSearch%>"
		 >
		
		<liferay-ui:search-container-results>
			<%
			
		
			total = CatalogItemLocalServiceUtil.countUnreleasedByCompanyGroup(companyId, groupId);
			
			
			List<CatalogItem> catalogItems = CatalogItemLocalServiceUtil.getUnreleasedByCompanyGroup(companyId, groupId,
					searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator()) ;
			
			
			searchContainer.setTotal(total);
			results = catalogItems; 
			searchContainer.setResults(results);
			%>
		
		
		</liferay-ui:search-container-results>
		<liferay-ui:search-container-row
				className="com.kencana.lms.model.CatalogItem"
				keyProperty="catalogItemId"
				modelVar="catalogItem"
			>
			<liferay-ui:search-container-column-text
					name="catalogId"
					value="<%= String.valueOf(catalogItem.getCatalogId()) %>"
					orderable="<%= true %>"
			/>
			<liferay-ui:search-container-column-text
					name="title"
					value="<%= catalogItem.getCatalogTitle() %>"
					orderable="<%= true %>"
			/>
			
			<liferay-ui:search-container-column-text
					name="createDate"
					value="<%= dateFormatDate.format(catalogItem.getCreateDate()) %>"
					orderable="<%= true %>"
			/>
			<liferay-ui:search-container-column-text
					name="callNumber"
					value="<%= catalogItem.getCallNumber() %>"
					orderable="<%= true %>"
			/>
			<liferay-ui:search-container-column-text
					name="copy"
					value="<%= String.valueOf(catalogItem.getCopyNumber()) %>"
					
			/>
			<liferay-ui:search-container-column-text
					name="purchase-price"
					value="<%= String.valueOf(catalogItem.getPurchasePrice()) %>"
					
			/>
			<liferay-portlet:renderURL varImpl="editCatalogItemURL">
					<portlet:param name="page" value="/html/cataloging/edit_catalog_item.jsp" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="catalogItemId" value="<%= String.valueOf(catalogItem.getCatalogItemId()) %>" />
					
			</liferay-portlet:renderURL>
			<liferay-portlet:renderURL varImpl="viewCatalogURL">
					<portlet:param name="page" value="/html/cataloging/view_catalog.jsp" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="catalogId" value="<%= String.valueOf(catalogItem.getCatalogId()) %>" />
					
			</liferay-portlet:renderURL>
			<liferay-ui:search-container-column-text>
				<liferay-ui:icon-menu>
					<liferay-ui:icon image="edit" message="edit-catalog-item" label="edit" url="<%= editCatalogItemURL.toString() %>" />
					<liferay-ui:icon image="view" message="view-catalog" label="view-catalog" url="<%= viewCatalogURL.toString() %>" />
				</liferay-ui:icon-menu>
			</liferay-ui:search-container-column-text>
			
				
			
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
		
	</liferay-ui:search-container>
	<aui:button-row>
		<%
		String releaseAccessionOnClick = renderResponse.getNamespace() + "releaseAccession();";
		%>
		<aui:button onClick="<%= releaseAccessionOnClick %>" value="release-for-circulation" cssClass="btn-primary"></aui:button>
	</aui:button-row>
</aui:form>

<script type="text/javascript" >
        Liferay.provide(
        window,
        '<portlet:namespace />releaseAccession',
        function() {
        	var form =  document.<portlet:namespace />fm;
            form.<portlet:namespace />catalogItemIds.value = Liferay.Util.listCheckedExcept(form, "<portlet:namespace />allRowIds");

            submitForm(form);
                       
        },
        ['liferay-util-list-fields']
    );
</script>