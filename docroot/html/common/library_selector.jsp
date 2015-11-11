<%@ include file="/html/cataloging/init.jsp" %>


<%
	long selectedId = ParamUtil.getLong(request, "selectedId");
	String controlName = ParamUtil.getString(request, "selectName");
	List<Library> libraries = LibraryLocalServiceUtil.findByGroupCompany(themeDisplay.getCompanyId(),
			themeDisplay.getScopeGroupId());
	
	out.print(controlName);
%>


	<%for (Library library : libraries) 
	{
		boolean selected = false;
		if (Validator.isNotNull(selectedId) && library.getLibraryId() == selectedId)
			selected = true;
	%>
		<aui:option value="<%=library.getLibraryId() %>" selected="<%=selected %>">
			<%=library.getLibraryName() %>
		</aui:option>
	
	<%
	}
	%>

