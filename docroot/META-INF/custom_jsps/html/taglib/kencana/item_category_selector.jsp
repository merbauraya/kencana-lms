<%@ include file="/html/taglib/kencana/init.jsp" %>



<%
	long companyId = themeDisplay.getCompanyId();
	long groupId = themeDisplay.getScopeGroupId();

	long selectedId = GetterUtil.getLong(request.getAttribute("kencana:item-category-selector:selectedId"));
	String name = GetterUtil.getString(request.getAttribute("kencana:item-category-selector:name"));
	//PortletURL viewItemTypeURL =(PortletURL) request.getAttribute("subur:item-itemtype-display:viewItemTypeURL");
	boolean addAllOption = GetterUtil.getBoolean(request.getAttribute("kencana:item-category-selector:addAllOption"));
	String inlineLabel = GetterUtil.getString(request.getAttribute("kencana:item-category-selector:inlineLabel"));
	Object itemCategoryLocalService  = (Object)PortletBeanLocatorUtil.locate("kencana-portlet","ItemCategoryLocalService");

	Method getItemCategory = itemCategoryLocalService.getClass().getMethod("findByCompanyGroup",new Class[]{long.class,long.class});

	List<?> itemCategories =  (List<?>)getItemCategory.invoke(itemCategoryLocalService,companyId,groupId);
	
	
	
	
%>


<aui:select name="<%= name %>" inlineLabel="<%= inlineLabel %>">

	<c:if test="<%= addAllOption%>">
		<aui:option value="-1" selected="<%=  selectedId == -1 %>">
			<liferay-ui:message key="all"/>
		</aui:option>
		
	</c:if>



<%	
	if (itemCategories != null ){
		for (Object itemCategory : itemCategories)
		{
			//Object itemType = Array.get(itemTypeList,i);
			String itemCategoryName = (String)itemCategory.getClass().getMethod("getItemCategoryName", null).invoke(itemCategory);
			long itemCategoryId = (Long)itemCategory.getClass().getMethod("getItemCategoryId", null).invoke(itemCategory);
			boolean selected = (selectedId == itemCategoryId);
			
%>
			<aui:option value="<%=  itemCategoryId%>" selected="<%= selected %>">
				<%=  itemCategoryName%>
			
			</aui:option>
	
	
<%
		}
		
	}
%>

</aui:select>