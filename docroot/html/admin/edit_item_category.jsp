<%@ include file="/html/admin/init.jsp" %>

<%
	long itemCategoryId = ParamUtil.getLong(request, "itemCategoryId");
	ItemCategory itemCategory = null;
	long selectedLibraryId = 0;
	if (itemCategoryId > 0)
	{
		itemCategory = ItemCategoryLocalServiceUtil.fetchItemCategory(itemCategoryId);
		
	}
	String backPage = ParamUtil.getString(request, "backPage");
%>
<portlet:actionURL name="editItemCategory" var="editItemCategoryURL">
	
</portlet:actionURL>

<aui:form method="post" action="<%= editItemCategoryURL %>">

	<aui:model-context bean="<%= itemCategory %>" model="<%= ItemCategory.class%>" />
	<aui:input name="itemCategoryId" type="hidden"/>
	<aui:input name="backPage" value="<%= backPage %>" type="hidden"/>
	
	<aui:input name="itemCategoryName">
		<aui:validator name="required"/>
	</aui:input>
	
	<aui:button-row>
		<aui:button type="submit" value="save"></aui:button>
	</aui:button-row>
</aui:form>