<%@ include file="/html/cataloging/init.jsp" %>

<%
	String cardNumber = ParamUtil.getString(request, "cardNumber");
%>

This is circulation info <%= cardNumber %>
