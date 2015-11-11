<%@ include file="/html/cataloging/init.jsp" %>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	List<MarcBatchUpload> batchUploads = MarcBatchUploadLocalServiceUtil.getUnprocessed(themeDisplay.getCompanyId(),
			themeDisplay.getScopeGroupId(),-1,-1);
%>

<liferay-portlet:actionURL name="processUploadedMarc" varImpl="processMarcURL"></liferay-portlet:actionURL>



<aui:form action="<%=processMarcURL %>">
    <liferay-portlet:renderURL var="redirectURL">
		<liferay-portlet:param name="mvcPath" value="/html/cataloging/view_upload.jsp" />
		
	</liferay-portlet:renderURL>
    <aui:input name="redirect" type="hidden" value="<%= redirectURL %>" />

    
    <liferay-ui:search-container delta="20" emptyResultsMessage="No locations available!" rowChecker="<%= new RowChecker(renderResponse) %>">

    <liferay-ui:search-container-results
        results="<%= batchUploads%>"
        total="<%= batchUploads.size()%>"
    />

    <liferay-ui:search-container-row
        className="com.kencana.lms.model.MarcBatchUpload"
        keyProperty="marcBatchUploadId"
        modelVar="batch"
    >

        <liferay-ui:search-container-column-text
				name="description"
				orderable="<%= false %>"
		/>
	
        <liferay-ui:search-container-column-date
				name="createdDate"
				value="<%= batch.getCreatedDate() %>"
				orderable="<%= false %>"
				
		/>
		 <liferay-ui:search-container-column-text
				name="fileCount"
				value="<%= String.valueOf(batch.getFileCount()) %>"
				orderable="<%= false %>"
				
		/>
		 <liferay-ui:search-container-column-text
				name="recordCount"
				value="<%= String.valueOf(batch.getRecordCount()) %>"
				orderable="<%= false %>"
				
		/>
		
		<liferay-ui:search-container-column-text name="Action">		
		<liferay-ui:icon-menu>
			
			
			<portlet:actionURL var="deleteBatchURL" name="deleteMarcUpload">
				<portlet:param name="bacthId" value="<%=String.valueOf(batch.getMarcBatchUploadId()) %>" />
				<portlet:param name="redirect" value="<%=portletURL.toString() %>"/>
				<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE %>" />
			</portlet:actionURL>
			
			<portlet:actionURL var="importMarcURL" name="processUploadedMarc">
				<portlet:param name="batchId" value="<%=String.valueOf(batch.getMarcBatchUploadId()) %>" />
				<portlet:param name="redirect" value="<%=redirectURL.toString() %>"/>
			</portlet:actionURL>
			
			
			
			
				
				<liferay-ui:icon image="delete" message="delete" label="delete" url="<%= deleteBatchURL.toString() %>" />
				<liferay-ui:icon image="process" message="import" label="import" url="<%= importMarcURL.toString() %>" />
			
				
			
		
		</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>
		

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator />

    </liferay-ui:search-container>
    <aui:button-row>
    	<aui:button type="submit" value="Process"></aui:button>
    </aui:button-row>
</aui:form>