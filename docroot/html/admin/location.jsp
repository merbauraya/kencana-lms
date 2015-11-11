<%@ include file="/html/admin/init.jsp" %>

<liferay-portlet:renderURL varImpl="addLocationURL">
	<portlet:param name="page" value="/html/admin/edit_location.jsp" />
	
</liferay-portlet:renderURL>

<aui:a icon="icon-plus" href="<%= addLocationURL.toString() %>" cssClass="btn" label="add-location"></aui:a>

<liferay-ui:search-container delta="20" emptyResultsMessage="no-location-defined">
<%
	List<Location> locations = LocationLocalServiceUtil.findByGroupCompany(themeDisplay.getCompanyId(),
		themeDisplay.getScopeGroupId(),searchContainer.getStart(),searchContainer.getEnd(),null);

%>
			<liferay-ui:search-container-results>
			<%
				searchContainer.setTotal(locations.size());
				results = locations; 
				searchContainer.setResults(locations);
			%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row
				className="com.kencana.lms.model.Location"
				keyProperty="locationId"
				modelVar="location"
			>
			
				<liferay-ui:search-container-column-text
						name="name"
						value="<%= location.getLocationName()%>"
						orderable="<%= true %>"
				/>
				
				
				
				<liferay-portlet:renderURL varImpl="editLocationURL">
						<portlet:param name="page" value="/html/admin/edit_location.jsp" />
						<portlet:param name="redirect" value="<%= currentURL %>" />
						<portlet:param name="locationId" value="<%= String.valueOf(location.getLocationId()) %>" />
						
				</liferay-portlet:renderURL>
				
				<liferay-ui:search-container-column-text>
					<liferay-ui:icon-menu>
						<liferay-ui:icon image="edit" message="edit-location" label="edit" url="<%= editLocationURL.toString() %>" />
					</liferay-ui:icon-menu>
				</liferay-ui:search-container-column-text>
			
				
			
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>