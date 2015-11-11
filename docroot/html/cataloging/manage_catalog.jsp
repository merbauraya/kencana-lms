<%@ include file="/html/cataloging/init.jsp" %>

<%
	long companyId = themeDisplay.getCompanyId();
	long groupId = themeDisplay.getScopeGroupId();
%>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="page" value="/html/cataloging/manage_catalog.jsp" />
	
</liferay-portlet:renderURL>

<aui:form method="post" name="fm">
	<aui:input name="catalogIds" type="hidden"/>
	<liferay-ui:search-container delta="20" 
		emptyResultsMessage="no-catalog-defined"
		rowChecker="<%= new RowChecker(renderResponse) %>"
		iteratorURL="<%= iteratorURL %>"
	>
	
	<liferay-ui:search-container-results>
		<%
		
	
		total = CatalogLocalServiceUtil.countByGroupCompany(groupId, companyId);
		
		
		List<Catalog> catalogs = CatalogLocalServiceUtil.findByGroupCompany(companyId, groupId, 
				searchContainer.getStart(), searchContainer.getEnd());
		
		
		searchContainer.setTotal(total);
		results = catalogs; 
		searchContainer.setResults(results);
		%>
	
	
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row
			className="com.kencana.lms.model.Catalog"
			keyProperty="catalogId"
			modelVar="catalog"
		>
		
		<liferay-ui:search-container-column-text
				name="title"
				value="<%= HtmlUtil.escape(catalog.getTitle()) %>"
				orderable="<%= true %>"
		/>
		<liferay-ui:search-container-column-text
				name="author"
				value="<%= HtmlUtil.escape(catalog.getAuthor()) %>"
				orderable="<%= true %>"
		/>
		
		<liferay-ui:search-container-column-date
				name="create-date"
				value="<%= catalog.getCreateDate() %>"
				orderable="<%= false %>"
				orderableProperty="lastPublishedDate"
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
		<liferay-portlet:renderURL varImpl="deleteCatalogItemURL">
				<portlet:param name="page" value="/html/cataloging/view_catalog_item.jsp" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="catalogId" value="<%= String.valueOf(catalog.getCatalogId()) %>" />
				
		</liferay-portlet:renderURL>
		<liferay-ui:search-container-column-text>
			<liferay-ui:icon-menu>
				<liferay-ui:icon image="edit" message="edit-catalog" label="edit" url="<%= editCatalogURL.toString() %>" />
				<liferay-ui:icon image="view" message="view-catalog-item" label="view-item" url="<%= viewCatalogItemURL.toString() %>" />
			</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>
		
			
		
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
	
</liferay-ui:search-container>
<aui:button-row>
<%
	String deleteCatalog = renderResponse.getNamespace() + "deleteCatalog();";
%>
	<aui:button onClick="<%= deleteCatalog %>" value="delete-catalog" cssClass="btn-danger"></aui:button>
	
</aui:button-row>

</aui:form>
<liferay-portlet:actionURL name="deleteCatalog" var="deleteCatalogURL"></liferay-portlet:actionURL>
<script type="text/javascript" >
        Liferay.provide(
        window,
        '<portlet:namespace />deleteCatalog',
        function() {
        	if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-delete-this") %>')) {
        	var form =  document.<portlet:namespace />fm;
            form.<portlet:namespace />catalogIds.value = Liferay.Util.listCheckedExcept(form, "<portlet:namespace />allRowIds");

            submitForm(form,"<%= deleteCatalogURL.toString()%>");
        	}
        },
        ['liferay-util-list-fields']
    );
</script>