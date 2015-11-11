<%@ include file="/html/patron/init.jsp" %>


<%
	String navPage = ParamUtil.getString(request, "page");
	if (Validator.isNull(navPage))
	{
		navPage="/html/admin/default.jsp";
	}
%>
<div class="row-fluid">
	<div class="span2 sidebar">
		<liferay-util:include 
			page="/html/admin/navigation.jsp" 
			useCustomPage="<%=true %>"
			servletContext="<%=application %>"
		/>
	</div>
	
	<div class="span10">
		<liferay-util:include 
			page="<%= navPage %>" 
			useCustomPage="<%=true %>"
			servletContext="<%=application %>"
		/>
	</div>
</div>
