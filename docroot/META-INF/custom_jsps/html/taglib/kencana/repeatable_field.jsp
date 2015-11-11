<%@ include file="/html/taglib/init.jsp" %>

<%

	String fieldName = GetterUtil.getString(request.getAttribute("kencana:repeatable-field:fieldName"));
	List<String> valueList = (List<String>)request.getAttribute("kencana:repeatable-field:valueList");
	namespace = GetterUtil.getString(request.getAttribute("kencana:repeatable-field:namespace"));
	String inputClass = GetterUtil.getString(request.getAttribute("kencana:repeatable-field:inputClass"));
	String controlName = namespace + fieldName;// + i;
%>

<aui:fieldset>
<%
	for (int i = 0; i < valueList.size(); i++)
	{
		
	%>
	<div class="control-group form-inline k-form-row">
		<label class="control-label"><liferay-ui:message key="<%= fieldName %>" /></label>
			<input class="<%= inputClass %>" type="text" name="<%= controlName %>" value ="<%= valueList.get(i) %>"></input>
			<aui:button cssClass="icon-plus add-row btn-primary" />
			<aui:button cssClass="icon-minus delete-row btn-warning"/>
	</div>
	<%
		}
	%>
	<c:if test="<%=  valueList.size() == 0%>">
		<div class="control-group form-inline k-form-row">
			<label class="control-label"><liferay-ui:message key="<%= fieldName %>" /></label>
			<input class="<%= inputClass %>" type="text" name="<%= controlName %>" value =""></input>
			<aui:button cssClass="icon-plus add-row btn-primary" />
			<aui:button cssClass="icon-minus delete-row btn-warning"/>
		</div>
	</c:if>
	
	</aui:fieldset>