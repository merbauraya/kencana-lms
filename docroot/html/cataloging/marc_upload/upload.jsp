<%@ include file="/html/cataloging/init.jsp" %>

<%
	Ticket ticket = TicketLocalServiceUtil.addTicket(user.getCompanyId(), User.class.getName(), user.getUserId(), TicketConstants.TYPE_IMPERSONATE, null, null, new ServiceContext());


%>
<portlet:actionURL name="importMARC" var="uploadFileURL"></portlet:actionURL>

<aui:form action="<%= uploadFileURL %>" enctype="multipart/form-data" method="post">
 	
 	<aui:input name="description" cssClass="fullWidth">
 		<aui:validator name="required"></aui:validator>
 	</aui:input>
	<aui:row>

	


    
<div class="lfr-dynamic-uploader">
    <div class="lfr-upload-container" id="<portlet:namespace />fileUpload">
    &nbsp;
    </div>
</div>




<aui:script use="liferay-upload,aui-base">
    var liferayUpload = new Liferay.Upload(
        {
            boundingBox: '#<portlet:namespace />fileUpload',
            deleteFile: '<liferay-portlet:actionURL name="deleteTempFile" doAsUserId="<%= user.getUserId() %>"><portlet:param name="struts_action" value="/document_library/edit_file_entry" /><portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE_TEMP %>" /><portlet:param name="folderId" value="<%= String.valueOf(DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) %>" /></liferay-portlet:actionURL>&ticketKey=<%= ticket.getKey() %><liferay-ui:input-permissions-params modelName="<%= DLFileEntryConstants.getClassName() %>" />',
            fileDescription: '<%= StringUtil.merge(PrefsPropsUtil.getStringArray(PropsKeys.DL_FILE_EXTENSIONS, StringPool.COMMA)) %>',
            maxFileSize: '<%= PrefsPropsUtil.getLong(PropsKeys.DL_FILE_MAX_SIZE) %>',
            metadataContainer: '#<portlet:namespace />commonFileMetadataContainer',
            metadataExplanationContainer: '#<portlet:namespace />metadataExplanationContainer',
            namespace: '<portlet:namespace />',
            tempFileURL: {
                method: Liferay.Service.bind('/dlapp/get-temp-file-entry-names'),
                params: {
                    groupId: <%= scopeGroupId %>,
                    folderId: <%= DLFolderConstants.DEFAULT_PARENT_FOLDER_ID %>,
                    tempFolderName: '<%=KencanaConstant.TEMP_UPLOAD_FOLDER%>'
                }
            },
            uploadFile: '<liferay-portlet:actionURL name="manageTempFileUpload" doAsUserId="<%= user.getUserId() %>"><portlet:param name="struts_action" value="/document_library/edit_file_entry" /><portlet:param name="<%= Constants.CMD %>" value="<%= Constants.ADD_TEMP %>" /><portlet:param name="folderId" value="<%= String.valueOf(DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) %>" /></liferay-portlet:actionURL>&ticketKey=<%= ticket.getKey() %><liferay-ui:input-permissions-params modelName="<%= DLFileEntryConstants.getClassName() %>" />'
        }
    );
    
    //var continueButton = A.one('#<portlet:namespace />continueButton');

    function toggleContinueButton() {
        var uploadedFiles = liferayUpload._fileListContent.all('.upload-file.upload-complete');
        //continueButton.show();
        /*
        if (uploadedFiles.size() == 1) {
            console.log('One file Upload');
            console.log(uploadedFiles);
            continueButton.show();
        }
        else {
            console.log(uploadedFiles);
            continueButton.hide();
        }*/
    }
    liferayUpload._uploader.on(
            'fileuploadstart',
            function(event) {
                console.log('File Upload Start');               
            }
        );  
    
    Liferay.on(
            'uploadcomplete',
            function(event) {
                console.log('File Upload Complete');
            }
        );
    
    liferayUpload._uploader.on(
            'alluploadscomplete',
            function(event) {
                console.log('All Uploads Complete');
                toggleContinueButton();
            }
        );      
    
    Liferay.on(
            'tempFileRemoved',
            function(event) {
                console.log('Temp File Removed');
                toggleContinueButton();
            }
        );      
    
</aui:script>

</aui:row>
	
	<aui:button name="Save" value="process" type="submit" />
 
</aui:form>