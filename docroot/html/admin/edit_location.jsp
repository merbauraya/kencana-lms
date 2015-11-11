<%@ include file="/html/admin/init.jsp" %>

<%
	long locationId = ParamUtil.getLong(request, "locationId");
	Location location = null;
	long selectedLibraryId = 0;
	if (locationId > 0)
	{
		location = LocationLocalServiceUtil.fetchLocation(locationId);
		selectedLibraryId = location.getLibraryId();
	}

%>
<portlet:actionURL name="editLocation" var="editLocationURL" />

<aui:form method="post" action="<%= editLocationURL %>">

	<aui:model-context bean="<%= location%>" model="<%=Location.class%>" />
	<aui:input name="locationId" type="hidden"/>
	
	<aui:select name="libraryId">
		<jsp:include page="/html/common/library_selector.jsp">
			
			<jsp:param name="selectedId" value="<%=selectedLibraryId %>"/>
		</jsp:include>
	
	</aui:select>
	<aui:input name="locationName">
		<aui:validator name="required"/>
	</aui:input>
	
	<aui:button-row>
		<aui:button type="submit" value="save"></aui:button>
	</aui:button-row>
</aui:form>