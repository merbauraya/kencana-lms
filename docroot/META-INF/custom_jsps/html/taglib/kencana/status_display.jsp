<%@ include file="/html/taglib/init.jsp" %>

<%
	//boolean status = ParamUtil.getBoolean(request,"kencana:status-display:status");
	boolean status = GetterUtil.getBoolean(request.getAttribute("kencana:status-display:status"));
	String trueText = GetterUtil.getString(request.getAttribute("kencana:status-display:trueText"));
	String falseText = GetterUtil.getString(request.getAttribute("kencana:status-display:falseText"));

	String statusText = status ? trueText : falseText;
%>

<span class="taglib-status-display">
	<strong class="label"><liferay-ui:message key="<%= statusText %>" /></strong>

</span>


