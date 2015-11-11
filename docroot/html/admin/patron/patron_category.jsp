<%@ include file="/html/patron/init.jsp" %>

<%
	
	String redirect = currentURL.toString();

%>
<liferay-portlet:renderURL var="newPatronCategoryURL">
	<liferay-portlet:param name="mvcPath" value="/html/patron/edit_patron_category.jsp"/>
	<liferay-portlet:param name="redirect" value="<%=redirect%>"/>
	
</liferay-portlet:renderURL>

<aui:nav>
	<aui:nav-item href="<%= newPatronCategoryURL %>" label="permissions" title="edit-permissions" useDialog="<%= false %>" />
	

</aui:nav>

<liferay-ui:search-container delta="20" emptyResultsMessage="no-patron-category-defined">
	
	<liferay-ui:search-container-results>
		<%
		
	
		
		int start = searchContainer.getStart();
		int end = searchContainer.getEnd();
		total = PatronCategoryLocalServiceUtil.countByCompany(themeDisplay.getCompanyId());
		List<PatronCategory> patronCategories = PatronCategoryLocalServiceUtil.findByCompany(themeDisplay.getCompanyId(),
				start, end);
		
		
		searchContainer.setTotal(total);
		results = patronCategories; 
		searchContainer.setResults(results);
		%>
	
	
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row
			className="com.kencana.lms.model.PatronCategory"
			keyProperty="patronCategoryId"
			modelVar="patronCategory"
		>
		
		<liferay-ui:search-container-column-text
				name="name"
				value="<%= HtmlUtil.escape(patronCategory.getPatronCategoryName()) %>"
				orderable="<%= true %>"
		/>
		<liferay-ui:search-container-column-text
				name="notes"
				value="<%= HtmlUtil.escape(patronCategory.getNotes()) %>"
				
		/>
		<liferay-portlet:renderURL varImpl="editPatronCategoryURL">
				<portlet:param name="mvcPath" value="/html/patron/edit_patron_category.jsp" />
				<portlet:param name="patronCategoryId" value="<%= String.valueOf(patronCategory.getPatronCategoryId()) %>"/>
				<portlet:param name="redirect" value="<%= currentURL %>" />
				
				
		</liferay-portlet:renderURL>
		<liferay-portlet:renderURL varImpl="newPatronURL">
				<portlet:param name="mvcPath" value="/html/patron/edit_patron.jsp" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="patronCategoryId" value="<%= String.valueOf(patronCategory.getPatronCategoryId()) %>"/>
				
		</liferay-portlet:renderURL>
		<liferay-ui:search-container-column-text>
			<liferay-ui:icon-menu>
				<liferay-ui:icon image="edit" message="edit-patron-category" label="edit" url="<%= editPatronCategoryURL.toString() %>" />
				<liferay-ui:icon image="view" message="add-patron" label="add-patron" url="<%= newPatronURL.toString() %>" />
			</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>
		
			
		
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
	
</liferay-ui:search-container>
