<%@ include file="/html/admin/init.jsp" %>


<%
	long companyId = themeDisplay.getCompanyId();
	long groupId = themeDisplay.getScopeGroupId();
%>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="page" value="/html/admin/circulation/circulation_rule.jsp" />
	
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="addRuleURL">
	<portlet:param name="page" value="/html/admin/circulation/edit_circulation_rule.jsp" />
	
</liferay-portlet:renderURL>


<aui:button-row>
	<aui:button cssClass="btn-primary" icon="icon-plus" value="add" href="<%= addRuleURL.toString() %>"></aui:button>
	
</aui:button-row>




<aui:form name="fm">
	<aui:input name="catalogIds" type="hidden"/>
	<liferay-ui:search-container delta="20" 
		emptyResultsMessage="no-rule-defined"
		rowChecker="<%= new RowChecker(renderResponse) %>"
		iteratorURL="<%= iteratorURL %>"
	>
	
	<liferay-ui:search-container-results>
		<%
		
	
		total = CirculationRuleLocalServiceUtil.countByCompany(companyId);
		
		
		List<CirculationRule> cirRules = CirculationRuleLocalServiceUtil.getByCompany(companyId,  
				searchContainer.getStart(), searchContainer.getEnd());
		
		
		searchContainer.setTotal(total);
		results = cirRules; 
		searchContainer.setResults(results);
		%>
	
	
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row
			className="com.kencana.lms.model.CirculationRule"
			keyProperty="circulationRuleId"
			modelVar="circulationRule"
		>
		<%
			String patronCategoryName,itemTypeName,itemCategoryName;
			patronCategoryName = itemTypeName = itemCategoryName = LanguageUtil.get(request.getLocale(), "all"); 
			
			if (circulationRule.getPatronCategoryId() > 0)
			{
				PatronCategory patronCategory = PatronCategoryLocalServiceUtil.fetchPatronCategory(circulationRule.getPatronCategoryId());
				patronCategoryName = patronCategory.getPatronCategoryName();
			}
			if (circulationRule.getItemTypeId() > 0 )
			{
				ItemType itemType = ItemTypeLocalServiceUtil.fetchItemType(circulationRule.getItemTypeId());
				itemTypeName = itemType.getItemTypeName();
			}
			if (circulationRule.getItemCategoryId() > 0)
			{
				ItemCategory itemCategory = ItemCategoryLocalServiceUtil.fetchItemCategory(circulationRule.getItemCategoryId());
				itemCategoryName = itemCategory.getItemCategoryName();
			}
		%>
		
		
		<liferay-ui:search-container-column-text
				name="patron-category"
				value="<%= patronCategoryName %>"
				orderable="<%= false %>"
		/>
		<liferay-ui:search-container-column-text
				name="item-type"
				value="<%= itemTypeName %>"
				orderable="<%= false %>"
		/>
		<liferay-ui:search-container-column-text
				name="item-category"
				value="<%= itemCategoryName %>"
				orderable="<%= false %>"
		/>
		
		
		<liferay-portlet:renderURL varImpl="editRuleURL">
				<portlet:param name="page" value="/html/admin/circulation/edit_circulation_rule.jsp" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="circulationRuleId" value="<%= String.valueOf(circulationRule.getCirculationRuleId()) %>" />
				
		</liferay-portlet:renderURL>
		
		<liferay-ui:search-container-column-text>
			
			<liferay-ui:icon image="edit" message="edit-rule" label="edit" url="<%= editRuleURL.toString() %>" />
			
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
<liferay-portlet:actionURL name="deleteCirculationRule" var="deleteCirculationRuleURL"></liferay-portlet:actionURL>
<script type="text/javascript" >
        Liferay.provide(
        window,
        '<portlet:namespace />deleteCatalog',
        function() {
        	if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-delete-this") %>')) {
        	var form =  document.<portlet:namespace />fm;
            form.<portlet:namespace />catalogIds.value = Liferay.Util.listCheckedExcept(form, "<portlet:namespace />allRowIds");

            submitForm(form,"<%= deleteCirculationRuleURL.toString()%>");
        	}
        },
        ['liferay-util-list-fields']
    );
</script>