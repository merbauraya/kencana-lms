<%@ include file="/html/init.jsp" %>

<%
	long itemTypeId = ParamUtil.getLong(request, "itemTypeId");
	boolean addAllOption = ParamUtil.getBoolean(request, "addAllOption",false);
	List<ItemType> itemTypes = ItemTypeLocalServiceUtil.findByCompanyGroup(themeDisplay.getCompanyId(), 
			themeDisplay.getScopeGroupId(), -1, -1);
	//addAllOption = true;
	
%>
	<c:if test="<%= addAllOption%>">
		<aui:option value="-1" selected="<%=itemTypeId == -1 %>">
			<liferay-ui:message key="all"></liferay-ui:message>
		</aui:option>
	
	</c:if>

	<%for (ItemType itemType : itemTypes) 
	{
		boolean selected = false;
		if (itemType.getItemTypeId() == itemTypeId)
			selected = true;
	%>
		<aui:option value="<%=itemType.getItemTypeId() %>" selected="<%=selected %>">
			<%= itemType.getItemTypeName() %>
		</aui:option>
	
	<%
	}
	%>