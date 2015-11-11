<%@ include file="/html/patron/init.jsp" %>

<%
	PatronCategory patronCategory = null;
	String redirect = ParamUtil.getString(request, "redirect");
	long patronCategoryId = ParamUtil.getShort(request, "patronCategoryId");
	if (patronCategoryId > 0)
	{
		patronCategory = PatronCategoryLocalServiceUtil.fetchPatronCategory(patronCategoryId);
	}
%>


<liferay-portlet:actionURL name="editPatronCategory" var="editPatronCategoryURL"></liferay-portlet:actionURL>


<aui:form name="fm" action="<%=editPatronCategoryURL %>">
	
		<aui:model-context bean="<%=patronCategory%>" model="<%=PatronCategory.class%>" />
		<aui:input type="hidden" name="patronCategory"/>
		<aui:input type="hidden" name="patronCategoryId" value="<%=patronCategoryId %>"/>
		<aui:input type="hidden" name="redirect" value="<%=redirect %>"/>
		<aui:input name="patronCategoryName"/>
		<aui:input name="notes"/>
		
		<aui:button-row>
			<aui:button name="submitBtn" type="submit" value="save" last="true" />
		</aui:button-row>



</aui:form>
