<%@ include file="/html/patron/init.jsp" %>

<%
	PatronStatus patronStatus = null;
	String redirect = ParamUtil.getString(request, "redirect");
	long patronStatusId = ParamUtil.getShort(request, "patronStatusId");
	if (patronStatusId > 0)
	{
		patronStatus = PatronStatusLocalServiceUtil.fetchPatronStatus(patronStatusId);
		
	}
%>


<liferay-portlet:actionURL name="editPatronStatus" var="editPatronCategoryURL"></liferay-portlet:actionURL>


<aui:form name="fm" action="<%=editPatronCategoryURL %>">
	
		<aui:model-context bean="<%=patronStatus%>" model="<%=PatronStatus.class%>" />
		
		<aui:input type="hidden" name="patronStatusId" value="<%=patronStatusId %>"/>
		<aui:input type="hidden" name="redirect" value="<%=redirect %>"/>
		<aui:input name="patronStatusName"/>
		<aui:input name="noLogin"/>
		<aui:input name="noCheckout"/>
		<aui:input name="noReserve"/>
		<aui:input name="noRenew"/>
		
		<aui:button-row>
			<aui:button name="submitBtn" type="submit" value="save" last="true" />
		</aui:button-row>



</aui:form>
