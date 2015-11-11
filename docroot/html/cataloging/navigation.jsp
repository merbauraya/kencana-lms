<%@ include file="/html/cataloging/init.jsp" %>

<div class="sidenav">
	<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>"  persistState="<%= false %>" title="catalog">
		<liferay-portlet:renderURL varImpl="newCatalogURL">
	        <portlet:param name="mvcPath" value="/html/cataloging/edit_catalog_simple.jsp" />
		</liferay-portlet:renderURL>
		
		<liferay-portlet:renderURL varImpl="uploadMarcURL">
		        <portlet:param name="page" value="/html/cataloging/marc_upload/upload.jsp" />
		</liferay-portlet:renderURL>
		
		<liferay-portlet:renderURL varImpl="viewBatchUploadURL">
		        <portlet:param name="page" value="/html/cataloging/marc_upload/view_upload.jsp" />
		</liferay-portlet:renderURL>
		
		<liferay-portlet:renderURL varImpl="manageCatalogURL">
		        <portlet:param name="page" value="/html/cataloging/manage_catalog.jsp" />
		</liferay-portlet:renderURL>
		
		
		<liferay-portlet:renderURL varImpl="viewLibraryURL">
		        <portlet:param name="page" value="/html/common/edit_library.jsp" />
		</liferay-portlet:renderURL>
		
		
		<liferay-portlet:renderURL varImpl="patronURL">
		        <portlet:param name="page" value="/html/patron/view.jsp" />
		</liferay-portlet:renderURL>
		
		<liferay-portlet:renderURL varImpl="locationURL">
		        <portlet:param name="page" value="/html/foundation/location.jsp" />
		</liferay-portlet:renderURL>
		<liferay-portlet:renderURL varImpl="z3950URL">
		        <portlet:param name="mvcPath" value="/html/cataloging/z3950.jsp" />
		</liferay-portlet:renderURL>
			
			<liferay-portlet:renderURL varImpl="itemCategoryURL">
				<liferay-portlet:param name="page" value="/html/cataloging/release_for_circulation.jsp"/>
			</liferay-portlet:renderURL>
			
			<liferay-portlet:renderURL varImpl="itemTypeURL">
				<liferay-portlet:param name="page" value="/html/admin/item_type.jsp"/>
			</liferay-portlet:renderURL>
			
			<ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
				<li>
					<aui:a href="<%= newCatalogURL.toString() %>" label="new-catalog"/>
				</li>
				
				<li>
					<aui:a href="<%= uploadMarcURL.toString() %>" label="upload-marc"/>
				</li>
				
				<li>
					<aui:a href="<%= viewBatchUploadURL.toString() %>" label="process-uploaded-marc"/>
				</li>
				
				<li>
					<aui:a href="<%= manageCatalogURL.toString() %>" label="manage-catalog"/>
				</li>
			
			</ul>
	</liferay-ui:panel>
	<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>"  persistState="<%= false %>" title="accession">
		<liferay-portlet:renderURL varImpl="manageAccessionURL">
		        <portlet:param name="page" value="/html/cataloging/manage_accession.jsp" />
		</liferay-portlet:renderURL>
		<liferay-portlet:renderURL varImpl="releaseAccessionURL">
		        <portlet:param name="page" value="/html/cataloging/release_accession.jsp" />
		</liferay-portlet:renderURL>
		<liferay-portlet:renderURL varImpl="withdrawAccessionURL">
		        <portlet:param name="page" value="/html/cataloging/withdraw_accession.jsp" />
		</liferay-portlet:renderURL>
		<ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
			<li>
				<aui:a href="<%= manageAccessionURL.toString() %>" label="manage-accession"/>
			</li>
			<li>
				<aui:a href="<%= releaseAccessionURL.toString() %>" label="release-accession"/>
			</li>
			<li>
				<aui:a href="<%= withdrawAccessionURL.toString() %>" label="withdraw-accession"/>
			</li>
		
		</ul>
	</liferay-ui:panel>

</div>