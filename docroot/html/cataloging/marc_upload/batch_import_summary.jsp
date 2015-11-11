<%@ include file="/html/cataloging/init.jsp" %>

<%
	
	String[] bacthIdString = ParamUtil.getParameterValues(request, "batchIds");
	String[] catalogIdString = ParamUtil.getParameterValues(request, "catalogIds");
	
	long[] catalogIds = KencanaUtil.toLongArray(catalogIdString);// .toArray(catalogIdString);
	
	List<Catalog> catalogs = CatalogLocalServiceUtil.getByIds(catalogIds);
	
%>

    <liferay-ui:search-container delta="20" emptyResultsMessage="no-catalog-imported" rowChecker="<%= new RowChecker(renderResponse) %>">

    <liferay-ui:search-container-results
        results="<%= catalogs%>"
        total="<%= catalogs.size()%>"
    />

    <liferay-ui:search-container-row
        className="com.kencana.lms.model.Catalog"
        keyProperty="catalogId"
        modelVar="catalog"
    >

        <liferay-ui:search-container-column-text
				name="title"
				orderable="<%= false %>"
		/>
	
        <liferay-ui:search-container-column-date
				name="author"
				
		/>
		 <liferay-ui:search-container-column-text
				name="isbn"
			
				
		/>
		 <liferay-ui:search-container-column-text
				name="issn"
			
				
		/>
		
		<liferay-ui:search-container-column-text name="Action">	
			
			<portlet:renderURL var="addItemURL"> 
				<portlet:param name="catalogId" value="<%=String.valueOf(catalog.getCatalogId()) %>" />
				<portlet:param name="redirect" value="<%=currentURL %>"/>
				<portlet:param name="mvcPath" value="/html/cataloging/edit_catalog_item.jsp"/>
			</portlet:renderURL>
			
			
			<aui:a href="<%=addItemURL %>" cssClass="btn"><liferay-ui:message key="add-item" /></aui:a>
		
		</liferay-ui:search-container-column-text>
		

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator />

    </liferay-ui:search-container>
    <aui:button-row>
    	<aui:button type="submit" value="Process"></aui:button>
    </aui:button-row>
<%!
	private static Log _log = LogFactoryUtil.getLog("kencana.html.batch_import_summary");
%>