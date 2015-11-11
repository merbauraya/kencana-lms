<%@ include file="/html/init.jsp" %>

<%
	long patronCategoryId = ParamUtil.getLong(request, "patronCategoryId");
	long companyId = themeDisplay.getCompanyId();
	
	List<PatronCategory> categories = PatronCategoryLocalServiceUtil.findByCompany(companyId, -1, -1);
	
	
%>


	<%for (PatronCategory category : categories) 
	{
		boolean selected = false;
		if (category.getPatronCategoryId() == patronCategoryId)
			selected = true;
	%>
		<aui:option value="<%=category.getPatronCategoryId() %>" selected="<%=selected %>">
			<%= category.getPatronCategoryName() %>
		</aui:option>
	
	<%
	}
	%>