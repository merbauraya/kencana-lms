<%@ include file="/html/patron/init.jsp" %>

<%
	boolean showAddEntry = true;
	boolean showAdminItem = true;
	boolean showPermission = true;
	boolean showSearch = true;
	SearchContainer searchContainer = new SearchContainer();//(renderRequest, currentURLObj);
%>

<portlet:renderURL var="addPatronURL">
	<portlet:param name="mvcPath" value="/html/patron/edit_patron.jsp" />
	<portlet:param name="redirect" value="<%= currentURL %>" />
	<portlet:param name="backURL" value="<%= currentURL %>" />
				 
</portlet:renderURL>
<portlet:renderURL var="viewPatronStatusURL">
	<portlet:param name="mvcPath" value="/html/patron/view_patron_status.jsp" />
	<portlet:param name="redirect" value="<%= currentURL %>" />
	<portlet:param name="backURL" value="<%= currentURL %>" />
		 
</portlet:renderURL>
<portlet:renderURL var="viewPatronCategoryURL">
	<portlet:param name="mvcPath" value="/html/patron/view_patron_category.jsp" />
	<portlet:param name="redirect" value="<%= currentURL %>" />
	<portlet:param name="backURL" value="<%= currentURL %>" />
		 
</portlet:renderURL>

<aui:nav-bar>
	
	<aui:nav>
		
		
		
		<aui:nav-item dropdown="true" iconCssClass="icon-plus"
                      label="manage">
        	
        	<aui:nav-item href="<%=viewPatronCategoryURL %>" label="patron-category" />              
            <aui:nav-item href="<%=viewPatronStatusURL %>" label="patron-status" />            
		</aui:nav-item>

		<aui:nav-item href="<%= addPatronURL %>" label="add-patron" name="addPatronButton" />
			
			
			
			
	
				
				
			
			
			
				<liferay-security:permissionsURL
					modelResource="com.idetronic.subur"
					modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
					resourcePrimKey="<%= String.valueOf(scopeGroupId) %>"
					var="permissionsURL"
					windowState="<%= LiferayWindowState.POP_UP.toString() %>"
				/>
				<aui:nav-item href="<%= permissionsURL %>" label="permissions" title="edit-permissions" useDialog="<%= true %>" />
				
			
			<portlet:renderURL var="testURL">
					<portlet:param name="mvcPath" value="/html/test/view.jsp"/>
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="backURL" value="<%= currentURL %>" />
					
				</portlet:renderURL>
			<aui:nav-item href="<%= testURL %>" label="test" title="test" useDialog="<%= false %>" />
			
		</aui:nav>
		
	
	
		
	
	<c:if test="<%= showSearch %>">
        <aui:nav-bar-search cssClass="pull-right">
			<liferay-ui:search-form
				page="/html/patron/patron_search_form.jsp"
				 searchContainer="<%= searchContainer %>"
				 showAddButton="<%=true %>"
				 servletContext="<%= this.getServletConfig().getServletContext() %>"
					/>
		</aui:nav-bar-search>
	</c:if>
   
	
</aui:nav-bar>

