<%@ include file="/html/patron/init.jsp" %>
<%@ page import="com.kencana.lms.NoSuchPatronException" %>
<%
	String redirect = ParamUtil.getString(request, "redirect");
	String backURL = ParamUtil.getString(request, "backURL", redirect);
	long userId = ParamUtil.getLong(request, "userId");
	long patronId = ParamUtil.getLong(request, "patronId");
	
	
	User selUser = PortalUtil.getSelectedUser(request);
	if (selUser == null) {
		selUser = user;
	}
	long companyId = selUser.getCompanyId();
	
	
	List<PatronStatus> patronStatuses = PatronStatusLocalServiceUtil.findByCompany(companyId, -1, -1);
	List<PatronCategory> patronCategories = PatronCategoryLocalServiceUtil.findByCompany(companyId, -1, -1);
	
	
	List<Library> libraries = LibraryLocalServiceUtil.findByCompany(companyId, -1, -1);
	
	Patron patron = null;
	try
	{
		patron = PatronLocalServiceUtil.findByUserId(selUser.getUserId());
	} catch (NoSuchPatronException e)
	{}
	
	long selPatronStatusId=0,selPatronCategoryId = 0,selLibrary = 0;
	String cardNumber = StringPool.BLANK;
	if (Validator.isNotNull(patron))
	{
		selPatronStatusId = patron.getPatronStatusId();
		selPatronCategoryId = patron.getPatronCategoryId();
		selLibrary = patron.getLibraryId();
		cardNumber = patron.getCardNumber();
	}
%>


<aui:select name="library">
<%
	for (Library library : libraries)
	{
		boolean selected = false;
		if (selLibrary == library.getLibraryId())
		{
			selected = true;
		}
%>
		<aui:option value="<%= library.getLibraryId() %>">
			<%= library.getLibraryName() %>
		</aui:option>

<%
	}
%>
</aui:select>


<aui:input name="cardNumber" value="<%= cardNumber %>">

</aui:input>

<aui:select name="patronCategory">
<%
	for (PatronCategory patronCategory : patronCategories)
	{
		boolean selected = false;
		if (patronCategory.getPatronCategoryId() == selPatronCategoryId)
			selected = true;
%>
		<aui:option value="<%=patronCategory.getPatronCategoryId() %>" selected="<%= selected %>">
			<%=patronCategory.getPatronCategoryName() %>
		</aui:option>
<%
	} 
%>
</aui:select>

<aui:select name="patronStatus">
<%
	for (PatronStatus patronStatus : patronStatuses)
	{
		boolean selected = false;
		if (patronStatus.getPatronStatusId() == selPatronStatusId)
		{
			selected = true;
		}
%>
		<aui:option value="<%= patronStatus.getPatronStatusId() %>">
			<%= patronStatus.getPatronStatusName() %>
		</aui:option>

<%
	}
%>
</aui:select>