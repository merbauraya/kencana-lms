<%@ include file="/html/cataloging/init.jsp" %>

<%
	List<Library> libraries = LibraryLocalServiceUtil.findByGroupCompany(themeDisplay.getCompanyId(),
		themeDisplay.getScopeGroupId());
%>

<liferay-ui:search-container delta="20" emptyResultsMessage="no-item-defined">
			<liferay-ui:search-container-results>
			<%
				searchContainer.setTotal(libraries.size());
				results = libraries; 
				searchContainer.setResults(libraries);
			%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row
				className="com.kencana.lms.model.Library"
				keyProperty="libraryId"
				modelVar="library"
			>
			
				<liferay-ui:search-container-column-text
						name="copy-number"
						value="<%= library.getLibraryName() %>"
						orderable="<%= true %>"
				/>
				
				
				
				<liferay-portlet:renderURL varImpl="editLibraryURL">
						<portlet:param name="mvcPath" value="/html/common/edit_library.jsp" />
						<portlet:param name="redirect" value="<%= currentURL %>" />
						<portlet:param name="libraryId" value="<%= String.valueOf(library.getLibraryId()) %>" />
						
				</liferay-portlet:renderURL>
				
				<liferay-ui:search-container-column-text>
					<liferay-ui:icon-menu>
						<liferay-ui:icon image="edit" message="edit-catalog" label="edit" url="<%= editLibraryURL.toString() %>" />
					</liferay-ui:icon-menu>
				</liferay-ui:search-container-column-text>
			
				
			
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>