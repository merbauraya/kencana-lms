<%@ include file="/html/taglib/kencana/init.jsp" %>



<%
	long companyId = themeDisplay.getCompanyId();
	long groupId = themeDisplay.getScopeGroupId();

	long selectedItemTypeId = GetterUtil.getLong(request.getAttribute("kencana:item-type-selector:selectedId"));
	String name = GetterUtil.getString(request.getAttribute("kencana:item-type-selector:name"));
	//PortletURL viewItemTypeURL =(PortletURL) request.getAttribute("subur:item-itemtype-display:viewItemTypeURL");
	boolean addAllOption = GetterUtil.getBoolean(request.getAttribute("kencana:item-type-selector:addAllOption"));
	String inlineLabel = GetterUtil.getString(request.getAttribute("kencana:item-type-selector:inlineLabel"));
	Object itemTypeLocalService  = (Object)PortletBeanLocatorUtil.locate("kencana-portlet","ItemTypeLocalService");

	Method getItemType = itemTypeLocalService.getClass().getMethod("findByCompanyGroup",new Class[]{long.class,long.class});

	List<?> itemTypes =  (List<?>)getItemType.invoke(itemTypeLocalService,companyId,groupId);
	
	
	
	
%>


<aui:select name="<%= name %>" inlineLabel="<%= inlineLabel %>">

	<c:if test="<%= addAllOption%>">
		<aui:option value="-1" selected="<%=  selectedItemTypeId == -1 %>">
			<liferay-ui:message key="all"/>
		</aui:option>
		
	</c:if>



<%	
	if (itemTypes != null ){
		for (Object itemType : itemTypes)
		{
			//Object itemType = Array.get(itemTypeList,i);
			String itemTypeName = (String)itemType.getClass().getMethod("getItemTypeName", null).invoke(itemType);
			long itemTypeId = (Long)itemType.getClass().getMethod("getItemTypeId", null).invoke(itemType);
			boolean selected = (selectedItemTypeId == itemTypeId);
			
%>
			<aui:option value="<%=  itemTypeId%>" selected="<%= selected %>">
				<%=  itemTypeName%>
			
			</aui:option>
	
	
<%
		}
		
	}
%>

</aui:select>