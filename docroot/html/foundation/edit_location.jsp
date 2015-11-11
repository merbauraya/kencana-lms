<%@ include file="/html/foundation/init.jsp" %>


<%
	long locationId = ParamUtil.getLong(request, "locationId");
	Location location = null ;
	
	long selectedLibraryId = 0;
	if (locationId > 0)
	{
		location = LocationLocalServiceUtil.fetchLocation(locationId);
		selectedLibraryId = location.getLibraryId();
	}

%>


<liferay-portlet:actionURL name="editLocation" varImpl="editLocationURL" />


<aui:form action="<%= editLocationURL%>" method="post">
	<aui:model-context bean="<%=location%>" model="<%= Location.class%>" />
	<aui:input type="hidden" name="locationId" />
	<aui:select name="libraryId">
		<jsp:include page="/html/common/library_selector.jsp">
			
			<jsp:param name="selectedId" value="<%=selectedLibraryId %>"/>
		</jsp:include>
	
	</aui:select>
	
	<aui:input name="description"/>
	
	<aui:button-row>
		<aui:button type="submit" value="save"></aui:button>
	</aui:button-row>
	

</aui:form>