<%@ include file="/html/cataloging/init.jsp" %>

<%
	long libraryId = ParamUtil.getLong(request, "libraryId");
	Library library = null;
	
	if (Validator.isNotNull(libraryId))
	{
		library = LibraryLocalServiceUtil.fetchLibrary(libraryId);
	}		

%>
<liferay-portlet:actionURL name="editLibrary" var="editLibraryURL">

</liferay-portlet:actionURL>


<aui:form action="<%=editLibraryURL %>">
	<aui:model-context bean="<%=library%>" model="<%=Library.class%>" />
	
	
	<aui:input name="libraryName"/>
	<aui:input name="address1"/>
	<aui:input name="address2"/>
	<aui:input name="address3"/>
	
	<aui:input name="zipcode"/>
	<aui:input name="city"/>
	<aui:input name="country"/>
	
	
	<aui:button-row>
		<aui:button type="submit" value="save"></aui:button>
	</aui:button-row>
	
</aui:form>