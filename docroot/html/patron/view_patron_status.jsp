<%@ include file="/html/patron/init.jsp" %>

<%
	
	String redirect = currentURL.toString();

%>
<liferay-portlet:renderURL var="newPatronStatusURL">
	<liferay-portlet:param name="mvcPath" value="/html/patron/edit_patron_status.jsp"/>
	<liferay-portlet:param name="redirect" value="<%=redirect%>"/>
	
</liferay-portlet:renderURL>

<aui:nav>
	<aui:nav-item href="<%= newPatronStatusURL %>" label="new" title="add" useDialog="<%= false %>" />
	

</aui:nav>

<liferay-ui:search-container delta="20" emptyResultsMessage="no-patron-status-defined">
	
	<liferay-ui:search-container-results>
		<%
		
	
		
		int start = searchContainer.getStart();
		int end = searchContainer.getEnd();
		total = PatronStatusLocalServiceUtil.countByGroup(themeDisplay.getScopeGroupId());
		List<PatronStatus> patronStatuses = PatronStatusLocalServiceUtil.findByGroup(themeDisplay.getScopeGroupId(),
				start, end);
		
		
		searchContainer.setTotal(total);
		results = patronStatuses; 
		searchContainer.setResults(results);
		%>
	
	
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row
			className="com.kencana.lms.model.PatronStatus"
			keyProperty="patronStatusId"
			modelVar="patronStatus"
		>
		
		<liferay-ui:search-container-column-text
				name="name"
				value="<%= HtmlUtil.escape(patronStatus.getPatronStatusName()) %>"
				orderable="<%= true %>"
		/>
		<liferay-ui:search-container-column-text name="no-checkout">
			<kencana:status-display status="<%=patronStatus.getNoCheckout() %>"
					trueText="Ya" falseText="Tidak"/>
				
				
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="no-reserve">
				<kencana:status-display status="<%=patronStatus.getNoReserve() %>"
					trueText="Ya" falseText="Tidak"/>
				
				
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="no-renew">
			<kencana:status-display status="<%=patronStatus.getNoRenew() %>"
					trueText="Ya" falseText="Tidak"/>
		
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="no-login">
			<kencana:status-display status="<%=patronStatus.getNoLogin() %>"
					trueText="Ya" falseText="Tidak"/>
		
		</liferay-ui:search-container-column-text>
		<liferay-portlet:renderURL varImpl="editPatronStatusURL">
				<portlet:param name="mvcPath" value="/html/patron/edit_patron_status.jsp" />
				<portlet:param name="patronStatusId" value="<%= String.valueOf(patronStatus.getPatronStatusId()) %>"/>
				<portlet:param name="redirect" value="<%= currentURL %>" />
				
				
		</liferay-portlet:renderURL>
		<liferay-portlet:renderURL varImpl="newPatronURL">
				<portlet:param name="mvcPath" value="/html/patron/edit_patron.jsp" />
				<portlet:param name="patronStatusId" value="<%= String.valueOf(patronStatus.getPatronStatusId()) %>"/>
				<portlet:param name="redirect" value="<%= currentURL %>" />
				
		</liferay-portlet:renderURL>
		<liferay-ui:search-container-column-text>
			<liferay-ui:icon-menu>
				<liferay-ui:icon image="edit" message="edit-patron-status" label="edit" url="<%= editPatronStatusURL.toString() %>" />
				<liferay-ui:icon image="view" message="add-patron" label="add-patron" url="<%= newPatronURL.toString() %>" />
			</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>
		
			
		
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
	
</liferay-ui:search-container>
