<%@ include file="/html/cataloging/init.jsp" %>
<div class="navbar navbar-inner block-header">
	<div class="muted pull-left">Accession</div>
</div>
<%
	long catalogId = ParamUtil.getLong(request, "catalogId");
	long selectedLocationId = 0 ;
	long catalogItemId = ParamUtil.getLong(request, "catalogItemId");
	long selectedLibraryId = 0L;
	long currentLibraryId = 0L;
	long itemTypeId = 0L;
	Catalog catalog = null;
	CatalogItem catalogItem = null;
	String callNumber;
	
	if (catalogItemId > 0)
	{
		catalogItem = CatalogItemLocalServiceUtil.fetchCatalogItem(catalogItemId);
		catalogId = catalogItem.getCatalogId();
		selectedLibraryId = catalogItem.getHoldingLibraryId();
		selectedLocationId = catalogItem.getLocationId();
		currentLibraryId = catalogItem.getCurrentLibraryId();
		callNumber = catalogItem.getCallNumber();
		itemTypeId = catalogItem.getItemTypeId();
	}else
	{
		catalog = CatalogLocalServiceUtil.fetchCatalog(catalogId);
		callNumber = catalog.getCallNumber();
	}
	String libraryControlName = "holdingLibraryId";
	
%>

<c:if test="<%=(catalogId <= 0) %>">

	<liferay-ui:error key="invalid-catalog" message="invalid-catalog" />

</c:if>

<liferay-portlet:actionURL name="editCatalogItem" varImpl="editCatalogItemURL">
	<liferay-util:param name="page" value=""></liferay-util:param>
</liferay-portlet:actionURL>
<aui:form action="<%=editCatalogItemURL %>" name="fm">
	<aui:model-context bean="<%=catalogItem%>" model="<%=CatalogItem.class%>" />
	
	<aui:input type="hidden" name="catalogId" value="<%=catalogId %>"/>
	<aui:input type="hidden" name="catalogItemId"/>
	<aui:select inlineLabel="left" name="holdingLibraryId">
		<jsp:include page="/html/common/library_selector.jsp">
			
			<jsp:param name="selectedId" value="<%=selectedLibraryId %>"/>
		</jsp:include>
	
	</aui:select>
	<aui:select inlineLabel="left" name="currentLibraryId">
		<jsp:include page="/html/common/library_selector.jsp">
			
			<jsp:param name="selectedId" value="<%=currentLibraryId %>"/>
		</jsp:include>
	
	</aui:select>
	<aui:select inlineLabel="left" name="locationId">
	
	
	
	
		<liferay-util:include page="/html/common/location_selector.jsp" servletContext="<%= application %>">
			
			
			<liferay-util:param name="selectedId" value="<%= String.valueOf(selectedLocationId) %>" />
			<liferay-util:param name="libraryId" value="<%= String.valueOf(selectedLibraryId)%>" />
		</liferay-util:include>
		
		<liferay-util:include page="/html/test/l_selector" servletContext="<%= application %>">
			
			
			<liferay-util:param name="selectedId" value="<%= String.valueOf(selectedLocationId) %>" />
			<liferay-util:param name="libraryId" value="<%= String.valueOf(selectedLibraryId) %>" />
		</liferay-util:include>
	
	</aui:select>
	
	<kencana:item-type-selector selectedId="<%= itemTypeId %>" name="itemTypeId" inlineLabel="left">
	
	</kencana:item-type-selector>
	
	<aui:select inlineLabel="left" name="itemCategoryId">
	<%
		List<ItemCategory> itemCategories = ItemCategoryLocalServiceUtil.findByCompanyGroup(themeDisplay.getCompanyId(),
				themeDisplay.getScopeGroupId(), -1, -1);
		long itemCategoryId = Validator.isNull(catalogItem) ? 0 : catalogItem.getItemCategoryId();
		for (ItemCategory itemCategory : itemCategories)
		{
			
			boolean itemCategorySelected = (itemCategory.getItemCategoryId() == itemCategoryId);
	%>
		<aui:option value="<%= itemCategory.getItemCategoryId() %>" selected="<%= itemCategorySelected %>">
			<%= itemCategory.getItemCategoryName() %>
		</aui:option>
	<%
		}
	%>
	</aui:select>
	
	
	
	
	
	<aui:input inlineLabel="left" name="callNumber" label="full-call-number" />
	<aui:input inlineLabel="left" name="barcode" />
	
	
	<aui:input inlineLabel="left" name="copyNumber">
		 <aui:validator name="number"></aui:validator>
		 <aui:validator name="min">1</aui:validator>
	</aui:input>
	
	<aui:field-wrapper name="priceSection" helpMessage="help-price" label="prices-section">
		
		
		<aui:input inlineLabel="left" name="purchasePrice">
			<aui:validator name="number"></aui:validator>
		</aui:input>
		<aui:input inlineLabel="left" name="replacementPrice">
			<aui:validator name="number"></aui:validator>
		</aui:input>
		
	</aui:field-wrapper>
	
	
	
	
	<aui:field-wrapper name="statusSection" helpMessage="help-set-item-status" label="status-section">
		<aui:input inlineLabel="left" name="withdrawnStatus"/>
		<aui:input name="lostStatus"/>
		<aui:input name="damageStatus"/>
		<aui:input name="notForLoanStatus"/>
	</aui:field-wrapper>
	
	<%
		String noteTab = "private-note,public-note";
	%>
	<aui:field-wrapper name="noteSection" helpMessage="help-note" label="notes-section">
		<liferay-ui:tabs
		names="<%= noteTab %>"
		refresh="<%= false %>"
		>
		<liferay-ui:section>
			<aui:input name="privateNote" label=""/>
		</liferay-ui:section>
		
		<liferay-ui:section>
			<aui:input name="publicNote" label=""/>
		</liferay-ui:section>
		
		
		
	
	</liferay-ui:tabs>	
	
	
	
	
		
		
		
	</aui:field-wrapper>
	
	<aui:input 
		classPK="<%=catalogItemId %>" 
		model="<%= CatalogItem.class %>" 
		name="categories" 
		type="assetCategories" />	
	
	
	<aui:button-row>
		<aui:button type="submit" value="save"></aui:button>
	</aui:button-row>
</aui:form>


<portlet:resourceURL var="resourceURL" id="locationByLibrary" ></portlet:resourceURL>
<aui:script>

AUI().use('aui-base','aui-io-request','aui-node', function(A)
		{
    A.one("#<portlet:namespace/>holdingLibraryId").on('change',function(){        
        A.io.request('<%=resourceURL%>', //requesting call to serverResource method 
                {
            
             method: 'POST',
             data: { 
                        "<portlet:namespace/>libraryId" : A.one(<portlet:namespace/>holdingLibraryId).val()
                   
                    },

             dataType: 'json',
             on: {
	             success: function() {
	             	var locationList = this.get('responseData');   //on success fuction we will get response data
	
	             	A.one('#<portlet:namespace />locationId').empty();
	
	          		 for(var i in locationList){
	                
	               		A.one('#<portlet:namespace />locationId').append("<option  value='"+ locationList[i].locationId +"' >"+locationList[i].locationName+"</option> "); 
	             	}
	            
	             }
             }
            
                });
            });
    
});

</aui:script>