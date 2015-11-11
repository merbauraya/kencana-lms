<%@ include file="/html/cataloging/init.jsp" %>

<liferay-portlet:actionURL name="z3950Search" varImpl="z3950URL"></liferay-portlet:actionURL>

<aui:form method="post" action="<%= z3950URL %>">
	<aui:input name="server"></aui:input>
	<aui:input name="port"></aui:input>
	<aui:input name="keyword"></aui:input>
	
	<aui:button-row>
		<aui:button type="submit" value="search"></aui:button>
	</aui:button-row>
	
</aui:form>