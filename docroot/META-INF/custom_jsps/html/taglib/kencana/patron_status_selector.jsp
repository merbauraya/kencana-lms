<%@ include file="/html/taglib/kencana/init.jsp" %>



<%
	long companyId = themeDisplay.getCompanyId();
	long groupId = themeDisplay.getScopeGroupId();

	long selectedPatronStatusId = GetterUtil.getLong(request.getAttribute("kencana:patron-status-selector:selectedId"));
	String name = GetterUtil.getString(request.getAttribute("kencana:patron-status-selector:name"));
	//PortletURL viewItemTypeURL =(PortletURL) request.getAttribute("subur:item-itemtype-display:viewItemTypeURL");
	boolean addAllOption = GetterUtil.getBoolean(request.getAttribute("kencana:patron-status-selector:addAllOption"));
	String inlineLabel = GetterUtil.getString(request.getAttribute("kencana:patron-status-selector:inlineLabel"));
	Object patronStatusLocalService  = (Object)PortletBeanLocatorUtil.locate("kencana-portlet","PatronStatusLocalService");

	Method getPatronStatus = patronStatusLocalService.getClass().getMethod("findByCompany",new Class[]{long.class});

	List<?> patronStatuses =  (List<?>)getPatronStatus.invoke(patronStatusLocalService,companyId);
	
	
	
	
%>


<aui:select name="<%= name %>" inlineLabel="<%= inlineLabel %>">

	<c:if test="<%= addAllOption%>">
		<aui:option value="-1" selected="<%=  selectedPatronStatusId == -1 %>">
			<liferay-ui:message key="all"/>
		</aui:option>
		
	</c:if>



<%	
	if (patronStatuses != null ){
		for (Object patronStatus : patronStatuses)
		{
			//Object itemType = Array.get(itemTypeList,i);
			String statusName = (String)patronStatus.getClass().getMethod("getPatronStatusName", null).invoke(patronStatus);
			long statusId = (Long)patronStatus.getClass().getMethod("getPatronStatusId", null).invoke(patronStatus);
			boolean selected = (selectedPatronStatusId == statusId);
			
%>
			<aui:option value="<%=  statusId%>" selected="<%= selected %>">
				<%=  statusName%>
			
			</aui:option>
	
	
<%
		}
		
	}
%>

</aui:select>