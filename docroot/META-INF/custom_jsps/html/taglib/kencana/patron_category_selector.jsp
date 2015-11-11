<%@ include file="/html/taglib/kencana/init.jsp" %>



<%
	long companyId = themeDisplay.getCompanyId();
	long groupId = themeDisplay.getScopeGroupId();

	long selectedCategoryId = GetterUtil.getLong(request.getAttribute("kencana:patron-category-selector:selectedId"));
	String name = GetterUtil.getString(request.getAttribute("kencana:patron-category-selector:name"));
	//PortletURL viewItemTypeURL =(PortletURL) request.getAttribute("subur:item-itemtype-display:viewItemTypeURL");
	boolean addAllOption = GetterUtil.getBoolean(request.getAttribute("kencana:patron-category-selector:addAllOption"));
	String inlineLabel = GetterUtil.getString(request.getAttribute("kencana:patron-category-selector:inlineLabel"));
	Object patronCategoryLocalService  = (Object)PortletBeanLocatorUtil.locate("kencana-portlet","PatronCategoryLocalService");

	Method getPatronCategories = patronCategoryLocalService.getClass().getMethod("findByCompany",new Class[]{long.class});

	List<?> patronCategories =  (List<?>)getPatronCategories.invoke(patronCategoryLocalService,companyId);
	
	
	
	
%>


<aui:select name="<%= name %>" inlineLabel="<%= inlineLabel %>">

	<c:if test="<%= addAllOption%>">
		<aui:option value="-1" selected="<%=  selectedCategoryId == -1 %>">
			<liferay-ui:message key="all"/>
		</aui:option>
		
	</c:if>



<%	
	if (patronCategories != null ){
		for (Object patronCategory : patronCategories)
		{
			//Object itemType = Array.get(itemTypeList,i);
			String categoryName = (String)patronCategory.getClass().getMethod("getPatronCategoryName", null).invoke(patronCategory);
			long categoryId = (Long)patronCategory.getClass().getMethod("getPatronCategoryId", null).invoke(patronCategory);
			boolean selected = (selectedCategoryId == categoryId);
			
%>
			<aui:option value="<%=  categoryId%>" selected="<%= selected %>">
				<%=  categoryName%>
			
			</aui:option>
	
	
<%
		}
		
	}
%>

</aui:select>