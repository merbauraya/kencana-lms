<%@ include file="/html/taglib/kencana/init.jsp" %>



<%
	long companyId = themeDisplay.getCompanyId();
	long groupId = themeDisplay.getScopeGroupId();

	long selectedLibraryId = GetterUtil.getLong(request.getAttribute("kencana:library-selector:selectedId"));
	String name = GetterUtil.getString(request.getAttribute("kencana:library-selector:name"));
	boolean addAllOption = GetterUtil.getBoolean(request.getAttribute("kencana:library-selector:addAllOption"));
	String inlineLabel = GetterUtil.getString(request.getAttribute("kencana:library-selector:inlineLabel"));
	Object libraryLocalService  = (Object)PortletBeanLocatorUtil.locate("kencana-portlet","LibraryLocalService");

	Method getLibrary = libraryLocalService.getClass().getMethod("findByCompany",new Class[]{long.class});

	List<?> libraries =  (List<?>)getLibrary.invoke(libraryLocalService,companyId);
	
	
	
	
%>



	<aui:select name="<%= name %>" inlineLabel="<%= inlineLabel %>">



	<c:if test="<%= addAllOption%>">
		<aui:option value="-1" selected="<%=  selectedLibraryId == -1 %>">
			<liferay-ui:message key="all"/>
		</aui:option>
		
	</c:if>



<%	
	if (libraries != null ){
		for (Object library : libraries)
		{
			//Object itemType = Array.get(itemTypeList,i);
			String libraryName = (String)library.getClass().getMethod("getLibraryName", null).invoke(library);
			long libraryId = (Long)library.getClass().getMethod("getLibraryId", null).invoke(library);
			boolean selected = (selectedLibraryId == libraryId);
			
%>
			<aui:option value="<%=  libraryId%>" selected="<%= selected %>">
				<%=  libraryName%>
			
			</aui:option>
	
	
<%
		}
		
	}
%>

</aui:select>