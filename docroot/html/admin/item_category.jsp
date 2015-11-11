<%@ include file="/html/admin/init.jsp" %>

<liferay-portlet:renderURL varImpl="addItemCategoryURL">
	<portlet:param name="page" value="/html/admin/edit_item_category.jsp" />
	<portlet:param name="backPage" value="/html/admin/item_category.jsp" />
</liferay-portlet:renderURL>

<aui:a icon="icon-plus" href="<%= addItemCategoryURL.toString() %>" cssClass="btn" label="add"></aui:a>

<liferay-ui:search-container delta="20" emptyResultsMessage="no-item-defined">
<%
	List<ItemCategory> itemCategories = ItemCategoryLocalServiceUtil.findByCompanyGroup(themeDisplay.getCompanyId(),
		themeDisplay.getScopeGroupId(),searchContainer.getStart(),searchContainer.getEnd(),null);

%>
			<liferay-ui:search-container-results>
			<%
				searchContainer.setTotal(itemCategories.size());
				results = itemCategories; 
				searchContainer.setResults(itemCategories);
			%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row
				className="com.kencana.lms.model.ItemCategory"
				keyProperty="itemCategoryId"
				modelVar="itemCategory"
			>
			
				<liferay-ui:search-container-column-text
						name="name"
						value="<%= itemCategory.getItemCategoryName()%>"
						orderable="<%= true %>"
				/>
				
				
				
				<liferay-portlet:renderURL varImpl="editItemCategoryURL">
						<portlet:param name="page" value="/html/admin/edit_item_category.jsp" />
						<portlet:param name="redirect" value="<%= currentURL %>" />
						<portlet:param name="locationId" value="<%= String.valueOf(itemCategory.getItemCategoryId()) %>" />
						
				</liferay-portlet:renderURL>
				
				<liferay-ui:search-container-column-text>
					<liferay-ui:icon-menu>
						<liferay-ui:icon image="edit" message="edit" label="edit" url="<%= editItemCategoryURL.toString() %>" />
					</liferay-ui:icon-menu>
				</liferay-ui:search-container-column-text>
			
				
			
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>