<%@ include file="/html/admin/init.jsp" %>

<%
	long circulationRuleId = ParamUtil.getLong(request, "circulationRuleId");
	CirculationRule circulationRule = null;
	
	long patronCategoryId = -1;
	long itemTypeId = -1;
	long itemCategoryId = -1;
	if (circulationRuleId > 0)
	{
		circulationRule = CirculationRuleLocalServiceUtil.fetchCirculationRule(circulationRuleId);
		patronCategoryId = circulationRule.getPatronCategoryId();
		itemTypeId = circulationRule.getItemTypeId();
	}
%>

<liferay-portlet:actionURL name="editCirculationRule" varImpl="editCirculationRuleURL">
	
</liferay-portlet:actionURL>


<aui:form name="fm" method="post" action="<%= editCirculationRuleURL %>">

	<aui:model-context bean="<%= circulationRule%>" model="<%= CirculationRule.class%>" />
	<aui:input name="circulationRuleId" type="hidden" value="<%= circulationRuleId %>"></aui:input>
	
	
	<kencana:patron-category-selector 
		selectedId="<%= patronCategoryId %>" 
		addAllOption="<%= true %>" 
		name="patronCategoryId"
		inlineLabel="left"
	/> 
	<kencana:item-category-selector 
		selectedId="<%= itemCategoryId %>" 
		name="itemCategoryId"
		inlineLabel="left"
		addAllOption="<%= true %>" 
	/>
	
	<kencana:item-type-selector 
		selectedId="<%= itemTypeId%>" 
		addAllOption="<%= true %>" 
		name="itemTypeId"
		inlineLabel="left"
	/>
	
	
	<hr/>
	<aui:field-wrapper cssClass="form-inline" name="periodUnit">
		<aui:input name="periodUnit" inlineLabel="left" value="<%= CirculationUtil.UNIT_DAY %>" type="radio" label="day"></aui:input>
		<aui:input name="periodUnit" inlineLabel="left" value="<%= CirculationUtil.UNIT_HOUR %>" type="radio" label="hour"></aui:input>
	</aui:field-wrapper>
	
	<aui:input name="loanPeriod" inlineLabel="left">
		<aui:validator name="number"></aui:validator>
	</aui:input>
	<aui:input name="loanPeriodIfReserved" inlineLabel="left">
		<aui:validator name="number"></aui:validator>
	</aui:input>
	<aui:input name="finePerPeriod" inlineLabel="left">
		<aui:validator name="number"></aui:validator>
	</aui:input>
	
	<aui:input name="fineGracePeriod" inlineLabel="left">
		<aui:validator name="number"></aui:validator>
	</aui:input>
	<aui:input name="maxFineAmount" inlineLabel="left">
		<aui:validator name="number"></aui:validator>
	</aui:input>
	<hr/>
	<div>
		<div class="span3">
			<aui:input name="maxCheckoutAllowed"/>
		
		</div>
		<div class="span3">
			<aui:input name="renewalCountAllowed"/>
		
		</div>
		<div class="span3">
			<aui:input name="reservedCountAllowed"/>
		
		</div>
	</div>
	
	
	<aui:button-row>
		<hr/>
		<aui:button type="submit" value="save"></aui:button>
	
	</aui:button-row>
	

</aui:form>