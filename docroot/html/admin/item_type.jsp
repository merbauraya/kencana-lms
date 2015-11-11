<%@ include file="/html/admin/init.jsp" %>

<liferay-portlet:renderURL varImpl="addItemTypeURL">
	<portlet:param name="page" value="/html/admin/edit_item_type.jsp" />
	<portlet:param name="backPage" value="/html/admin/item_type.jsp" />
</liferay-portlet:renderURL>

<aui:a icon="icon-plus" href="<%= addItemTypeURL.toString() %>" cssClass="btn" label="add"></aui:a>

<liferay-ui:search-container delta="20" emptyResultsMessage="no-item-defined">
<%
	List<ItemType> itemTypes = ItemTypeLocalServiceUtil.findByCompanyGroup(themeDisplay.getCompanyId(),
		themeDisplay.getScopeGroupId(),searchContainer.getStart(),searchContainer.getEnd(),null);

%>
			<liferay-ui:search-container-results>
			<%
				searchContainer.setTotal(itemTypes.size());
				results = itemTypes; 
				searchContainer.setResults(itemTypes);
			%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row
				className="com.kencana.lms.model.ItemType"
				keyProperty="itemTypeId"
				modelVar="itemType"
			>
			
				<liferay-ui:search-container-column-text
						name="name"
						value="<%= itemType.getItemTypeName() %>"
						orderable="<%= true %>"
				/>
				
				
				
				<liferay-portlet:renderURL varImpl="editItemTypeURL">
						<portlet:param name="page" value="/html/admin/edit_item_type.jsp" />
						<portlet:param name="redirect" value="<%= currentURL %>" />
						<portlet:param name="itemTypeId" value="<%= String.valueOf(itemType.getItemTypeId()) %>" />
						
				</liferay-portlet:renderURL>
				
				<liferay-ui:search-container-column-text>
					<liferay-ui:icon-menu>
						<liferay-ui:icon image="edit" message="edit" label="edit" url="<%= editItemTypeURL.toString() %>" />
					</liferay-ui:icon-menu>
				</liferay-ui:search-container-column-text>
			
				
			
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>