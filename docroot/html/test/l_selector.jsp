<%@ include file="/html/init.jsp" %>

<%
	long selectedId = ParamUtil.getLong(request, "selectedId");
	long libraryId = ParamUtil.getLong(request, "libraryId");
	List<Location> locations = LocationLocalServiceUtil.findByLibrary(libraryId);
	
	out.print(libraryId +"::"+selectedId);
%>


	<%for (Location location : locations) 
	{
		boolean selected = false;
		if (Validator.isNotNull(selectedId) && location.getLocationId() == selectedId)
			selected = true;
	%>
		<aui:option value="<%=location.getLocationId() %>" selected="<%=selected %>">
			<%= location.getLocationName() %>
		</aui:option>
	
	<%
	}
	%>