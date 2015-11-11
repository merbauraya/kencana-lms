<%@ include file="/html/cataloging/init.jsp" %>

<%
	String navPage = ParamUtil.getString(request, "page");
	if (Validator.isNull(navPage))
	{
		navPage="/html/cataloging/default.jsp";
	}
%>
<div class="row-fluid">

	<div class="span3">
		<liferay-util:include 
			page="/html/cataloging/navigation.jsp" 
			useCustomPage="<%=true %>"
			servletContext="<%=application %>"
		/>
	</div>
	
	<div class="span9 block" id="pageContent">
		<liferay-util:include 
			page="<%= navPage %>" 
			useCustomPage="<%=true %>"
			servletContext="<%=application %>"
		/>
	</div>
</div>





