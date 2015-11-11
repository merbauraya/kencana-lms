<%@ include file="/html/circulation/init.jsp" %>

<div class="sidenav">
	<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>"  persistState="<%= false %>" title="catalog">
		<liferay-portlet:renderURL varImpl="checkOutURL">
	        <portlet:param name="page" value="/html/circulation/checkout.jsp" />
		</liferay-portlet:renderURL>
		
		<liferay-portlet:renderURL varImpl="checkinURL">
		        <portlet:param name="page" value="/html/circulation/checkin.jsp" />
		</liferay-portlet:renderURL>
		
		
			
			<ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
				<li>
					<aui:a href="<%= checkOutURL.toString() %>" label="checkout"/>
				</li>
				
				<li>
					<aui:a href="<%= checkinURL.toString() %>" label="checkin"/>
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