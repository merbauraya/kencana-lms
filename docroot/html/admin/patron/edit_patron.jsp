<%@ include file="/html/admin/init.jsp"%>

<%
	User selUser = (User)request.getAttribute("user.selUser");
	Patron patron = PatronLocalServiceUtil.safeFindByUserId(selUser.getUserId());
	
	Calendar expiryDate = CalendarFactoryUtil.getCalendar();
	
	
	expiryDate.set(Calendar.MONTH, Calendar.DECEMBER);
	expiryDate.set(Calendar.DATE, 31);
	expiryDate.set(Calendar.YEAR, 2050);
	
	if (Validator.isNotNull(patron.getExpiryDate()))
	{
		expiryDate.setTime(patron.getExpiryDate());
	}
%>

<aui:input name="cardNumber" bean="<%= patron %>" model="<%= Patron.class %>" ></aui:input>


<kencana:library-selector 
	selectedId="<%= patron.getLibraryId() %>" 
	name="libraryId"
	addAllOption="<%= true %>"

/>

<kencana:patron-category-selector 
	selectedId="<%= patron.getPatronCategoryId() %>" 
	name="patronCategoryId"
/>


<kencana:patron-status-selector 
	selectedId="<%= patron.getPatronStatusId() %>" 
	name="patronStatusId"
/>

<liferay-ui:error exception="<%= ExpiryDateException.class %>" message="please-enter-a-valid-date" />

<aui:input bean="<%= patron %>" cssClass="modify-link"  model="<%= Patron.class %>" name="expiryDate" value="<%= expiryDate %>" />


<aui:input bean="<%= patron %>" name="patronNote" model="<%= Patron.class %>" />








