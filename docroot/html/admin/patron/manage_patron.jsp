<%@ include file="/html/admin/init.jsp" %>


<%
	long companyId = themeDisplay.getCompanyId();
	long groupId = themeDisplay.getScopeGroupId();
	LinkedHashMap<String, Object> userParams = new LinkedHashMap<String, Object>();

	int status = WorkflowConstants.STATUS_APPROVED;
	int usersCount = UserLocalServiceUtil.searchCount(themeDisplay.getCompanyId(), null, WorkflowConstants.STATUS_APPROVED, userParams);
	int inactiveUsersCount = UserLocalServiceUtil.searchCount(companyId, null, WorkflowConstants.STATUS_INACTIVE, userParams);
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("page", "/html/admin/patron/manage_patron.jsp");
	request.setAttribute("view.jsp-portletURL", portletURL);
%>

<aui:form action="<%= portletURL %>" method="post" name="fm">


<%@ include file="/html/admin/patron/view_patrons.jspf" %>


</aui:form>