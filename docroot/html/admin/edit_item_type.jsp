<%@ include file="/html/admin/init.jsp" %>

<%
	long itemTypeId = ParamUtil.getLong(request, "itemTypeId");
	ItemType itemType = null;
	
	double rentalRate = 0;
	if (itemTypeId > 0)
	{
		itemType = ItemTypeLocalServiceUtil.fetchItemType(itemTypeId);
		rentalRate = itemType.getRentalRate();
		
	}
	String backPage = ParamUtil.getString(request, "backPage");
%>
<portlet:actionURL name="editItemType" var="editItemTypeURL">
	
</portlet:actionURL>

<aui:form method="post" action="<%= editItemTypeURL %>">

	<aui:model-context bean="<%= itemType %>" model="<%= ItemType.class%>" />
	<aui:input name="itemTypeId" type="hidden"/>
	<aui:input name="backPage" value="<%= backPage %>" type="hidden"/>
	
	<aui:input name="itemTypeName">
		<aui:validator name="required"/>
	</aui:input>
	<aui:input name="notForLoan"></aui:input>
	<aui:input name="rentalRate" type="text" value="<%= doubleFormat.format(rentalRate) %>">
		<aui:validator name="number"></aui:validator>
	</aui:input>
	<aui:input name="checkinMessage"/>
	<aui:input name="checkoutMessage"/>
		
	<c:if test="<%= Validator.isNotNull(itemType) %>">
		<portlet:renderURL var="editItemTypeCoverURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
							<portlet:param name="mvcPath" value="/html/admin/edit_item_type_cover.jsp" />
							<portlet:param name="redirect" value="<%= currentURL %>" />
							<portlet:param name="itemTypeId" value="<%= String.valueOf(itemType.getItemTypeId()) %>" />
							<portlet:param name="coverId" value="<%= String.valueOf(itemType.getCoverId()) %>" />
						</portlet:renderURL>
		<liferay-ui:logo-selector
			currentLogoURL="<%= itemType.getCoverURL(themeDisplay) %>"
			defaultLogoURL="<%= KencanaUtil.getDefaultCoverURL(themeDisplay.getPathImage()) %>"
			editLogoURL="<%= editItemTypeCoverURL %>"
			imageId="<%= itemType.getCoverId() %>"
			logoDisplaySelector=".item-type-logo"
		/>
	
	
	</c:if>
	
	
	<aui:button-row>
		<aui:button type="submit" value="save"></aui:button>
	</aui:button-row>
</aui:form>