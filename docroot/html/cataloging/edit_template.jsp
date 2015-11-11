<%@ include file="/html/cataloging/init.jsp" %>
<%@ page import="com.kencana.lms.model.CatalogTemplate"%>
<%@ page import="com.kencana.lms.service.CatalogTemplateLocalServiceUtil"%>


<%
	long templateId = ParamUtil.getLong(request, "templateId");

	CatalogTemplate catalogTemplate = null;
	if (Validator.isNotNull(templateId))
		catalogTemplate = CatalogTemplateLocalServiceUtil.fetchCatalogTemplate(templateId);
	
%>

<liferay-portlet:actionURL name="editTemplate" var="editTemplateURL">


</liferay-portlet:actionURL>

<aui:form action="<%=editTemplateURL %>">
	
	<aui:input cssClass="fullWidth" 
		name="templateName" 
		value="<%=catalogTemplate==null ? StringPool.BLANK :catalogTemplate.getTemplateName() %>" />
	
	<aui:input cssClass="fullWidth"
		name="description"
		value="<%=catalogTemplate==null ? StringPool.BLANK :catalogTemplate.getDescription() %>" />
	
	<aui:input type="checkbox" name="active"
		value="<%=catalogTemplate==null ? StringPool.BLANK :catalogTemplate.getActive() %>" />
	
	
	
</aui:form>