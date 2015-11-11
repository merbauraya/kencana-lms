<%@ include file="/html/admin/init.jsp" %>


<div>
		<liferay-portlet:renderURL varImpl="itemCategoryURL">
			<liferay-portlet:param name="page" value="/html/admin/item_category.jsp"/>
		</liferay-portlet:renderURL>
		
		<liferay-portlet:renderURL varImpl="itemTypeURL">
			<liferay-portlet:param name="page" value="/html/admin/item_type.jsp"/>
		</liferay-portlet:renderURL>
		
		<ul class="nav nav-list nav-sidebar bs-docs-sidenav nav-collapse collapse">
			<li class="nav-header">Cataloging</li>
			<li class="active">
				<aui:a href="<%= itemTypeURL.toString() %>" label="item-type">
					
				</aui:a>
			</li>
			
			<li>
				<aui:a href="<%= itemCategoryURL.toString() %>" label="item-category"/>
			</li>
		
		</ul>
	
	
		
		<liferay-portlet:renderURL varImpl="libraryURL">
			<liferay-portlet:param name="page" value="/html/admin/library.jsp"/>
		</liferay-portlet:renderURL>
		<liferay-portlet:renderURL varImpl="locationURL">
			<liferay-portlet:param name="page" value="/html/admin/location.jsp"/>
		</liferay-portlet:renderURL>
		
		
		<ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
			<li class="nav-header">Library</li>
			<li>
				<aui:a href="<%= libraryURL.toString() %>" label="library"/>
			</li>
		
			
			<li>
				<aui:a href="<%= locationURL.toString() %>" label="location"/>
			</li>
			
		
		</ul>
		
	
	
	
		
		<liferay-portlet:renderURL varImpl="patronCategoryURL">
			<liferay-portlet:param name="page" value="/html/admin/patron/patron_category.jsp"/>
		</liferay-portlet:renderURL>
		<liferay-portlet:renderURL varImpl="patronStatusURL">
			<liferay-portlet:param name="page" value="/html/admin/patron/patron_status.jsp"/>
		</liferay-portlet:renderURL>
		
		<liferay-portlet:renderURL varImpl="managePatronURL">
			<liferay-portlet:param name="page" value="/html/admin/patron/manage_patron.jsp"/>
		</liferay-portlet:renderURL>
		
		
		<ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
			<li class="nav-header">Patron</li>
			<li>
				<aui:a href="<%= patronCategoryURL.toString() %>" label="patron-category"/>
			</li>
		
			
			<li>
				<aui:a href="<%= patronStatusURL.toString() %>" label="patron-status"/>
			</li>
			<li>
				<aui:a href="<%= managePatronURL.toString() %>" label="manage-patron"/>
			</li>
			
		
		</ul>
		
	
	
		
		<liferay-portlet:renderURL varImpl="circulationRuleURL">
			<liferay-portlet:param name="page" value="/html/admin/circulation/circulation_rule.jsp"/>
		</liferay-portlet:renderURL>
		
		
		<ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
			<li class="nav-header">Circulation</li>
			<li>
				<aui:a href="<%= circulationRuleURL.toString() %>" label="circulation-rule"/>
			</li>
		
			
			<li>
				<aui:a href="<%= patronStatusURL.toString() %>" label="patron-status"/>
			</li>
			
		
		</ul>
		
		
		
	
	
	
	

</div>