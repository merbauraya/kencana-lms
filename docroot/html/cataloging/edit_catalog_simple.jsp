<%@ include file="/html/cataloging/init.jsp" %>

<%
	long catalogId = ParamUtil.getLong(request, "catalogId");
	Catalog catalog = null;
	String title = StringPool.BLANK;
	MarcHelper marcHelper = new MarcHelper();
	
	List<String> ISBNList = new ArrayList<String>();
	List<String> ISSNList = new ArrayList<String>();
	ISBNList.add(StringPool.BLANK);
	if (catalogId > 0)
	{
		catalog = CatalogLocalServiceUtil.fetchCatalog(catalogId);
		title = catalog.getTitle();
		String marc = catalog.getMarc();
		
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(marc.getBytes());
		
		
		MarcReader marcReader = new MarcXmlReader(byteArrayInputStream);
		if (marcReader.hasNext())
		{
			Record record = marcReader.next();
			marcHelper.setRecord(record);
			ISBNList = marcHelper.getISBNs();
			ISSNList = marcHelper.getISSNs();
			if (ISBNList.size() == 0)
			{
				ISBNList.add(StringPool.BLANK);
			}
			
		}
	}
	List<ItemType> itemTypes = ItemTypeLocalServiceUtil.getItemTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

%>


<liferay-portlet:actionURL name="editCatalogSimple" varImpl="editCatalogURL">

</liferay-portlet:actionURL>

<aui:form action="<%= editCatalogURL  %>">
	<aui:model-context bean="<%= catalog%>" model="<%=Catalog.class%>" />
	<aui:input type="hidden" name="catalogId"/>
	<aui:select inlineLabel="left" label="item-type" name="<%=KencanaField.ITEM_TYPE %>">
		<%for (ItemType itemType: itemTypes) 
		{
			boolean selected = Validator.isNull(catalog)? false : (itemType.getItemTypeId() == catalog.getItemTypeId());
		%>
			<aui:option value="<%= itemType.getItemTypeId() %>" selected="<%= selected %>">
				<%=itemType.getItemTypeName() %>
			</aui:option>
		<%
		}
		%>
	</aui:select>
	
	<aui:input inlineLabel="left" name="callNumber" type="text" />

	<kencana:repeatable-field
					fieldName="isbn"
					valueList="<%= ISBNList %>"
					namespace="<%= renderResponse.getNamespace() %>"
					inputClass="medianWidth"
							
				/>
	<kencana:repeatable-field
					fieldName="issn"
					valueList="<%= ISSNList %>"
					namespace="<%= renderResponse.getNamespace() %>"
					inputClass="medianWidth"
							
				/>
	
	
	
	<aui:input inlineLabel="left" name="edition" type="text" value="<%= marcHelper.getEdition250_a() %>" />
	

	
<%
	
	String tabs2Names = "title,author,publication,physical-description";
%>
<aui:row>
<liferay-ui:tabs
	names="<%= tabs2Names %>"
	refresh="<%= false %>"
	>
	<liferay-ui:section>
			<aui:input inlineLabel="left" cssClass="mediumwidth" name="<%=KencanaField.TITLE_245A %>" type="text" value="<%= title %>">
			<aui:validator name="required"/>
		</aui:input>
		<aui:input inlineLabel="left" cssClass="mediumwidth" type="text" name="<%=KencanaField.TITLE_245B %>" value="<%= marcHelper.getTitle245_b() %>"></aui:input>
		<aui:input inlineLabel="left" cssClass="mediumwidth" type="text" name="<%=KencanaField.TITLE_245C %>" value="<%= marcHelper.getTitle245_c() %>"></aui:input>

	
	</liferay-ui:section>
	<liferay-ui:section>
		<aui:input type="text" name="<%=KencanaField.AUTHOR_100A %>" value="<%= marcHelper.getAuthor() %>" >
			<aui:validator name="required"/>
		</aui:input>
	
	</liferay-ui:section>
	<liferay-ui:section>
		<aui:input type="text" name="<%=KencanaField.PUBLICATION_260A %>" value="<%= marcHelper.get264_placeOfPublication() %>">
			
		</aui:input>
		<aui:input type="text" name="<%=KencanaField.PUBLICATION_260B %>" value="<%= marcHelper.get264_nameOfPublisher() %>"></aui:input>
		<aui:input type="text" name="<%=KencanaField.PUBLICATION_260C %>" value="<%= marcHelper.get264_dateOfPublication() %>"></aui:input>
	
	</liferay-ui:section>
	
	<liferay-ui:section>
			<aui:input type="text" name="<%=KencanaField.PHYSICAL_EXTENT_300A %>" value="<%= marcHelper.getPhysicalExtent300_a() %>">
			
		</aui:input>
		<aui:input type="text" name="<%=KencanaField.PHYSICAL_OTHER_300B %>" value="<%= marcHelper.getPhysicalExtent300_b() %>"></aui:input>
		<aui:input type="text" name="<%=KencanaField.PHYSICAL_DIMENSIONS_300C %>" value="<%= marcHelper.getPhysicalExtent300_c() %>"></aui:input>
	
	</liferay-ui:section>
	
	
	

</liferay-ui:tabs>	
</aui:row>	
	
	
	
	<aui:button-row>
		<aui:button name="submitBtn" type="submit" value="save" last="true" />
	
	</aui:button-row>
	

</aui:form>
<aui:script>
	var A = AUI();
	
	
	
	A.use('event','node',function (A){
		var isbnNode = A.one('form'); //A.one('#<portlet:namespace/>isbnDiv');
		var isbnIdx = A.one("#<portlet:namespace/>idxIsbn");
		isbnNode.delegate(
			'click', 
			function(event){
				var link = event.currentTarget;
				
				var currentRow = link.ancestor('.k-form-row');
				if (link.hasClass('add-row')) {
					addRow(currentRow);
				}
				else if (link.hasClass('delete-row')) {
					link.fire('change');

					deleteRow(currentRow);
				}

				
			},".btn");
			
			function deleteRow(node)
			{
				
				var fld = node.ancestor('.fieldset');
				var rowCount = fld.getElementsByTagName('input').size();// fld.all('input').length; //fld.getElementsByTagName('input').length();
				
				
				if (rowCount <= 1)
					return;
				node.remove();

			}
			function addRow(node)
			{
				var clone = createClone(node);
				clone.resetId();
				
				node.placeAfter(clone);
				Liferay.Util.focusFormField(clone.one('input[type=text], input[type=password], textarea'));

			}
			function clearForm(node)
			{
				node.all('input, select, textarea').each(
						function(item, index, collection) {
							var type = item.getAttribute('type');
							var tag = item.get('nodeName').toLowerCase();

							if (type == 'text' || type == 'password' || tag == 'textarea') {
								item.val('');
							}
							else if (type == 'checkbox' || type == 'radio') {
								item.set('checked', false);
							}
							else if (tag == 'select') {
								item.set('selectedIndex', -1);
							}
						}
					);
			}
			function createClone(node)
			{
				var currentRow = node;
				var clone = currentRow.clone();
				clone.all('input, select, textarea, span').each(
						function(item, index, collection) {
							//var rowCount = parseInt(isbnIdx.val());
							//var guid = rowCount + 1;
							var oldName = item.attr('name') || item.attr('id');
							//var originalName = oldName.replace(/([0-9]+)$/, '');
							//var newName = originalName + guid;
							var inputType = item.attr('type');
							var inputNodeName = item.attr('nodeName');
							newName = oldName;
							if (inputType == 'radio') {
								oldName = item.attr('id');

								item.attr('checked', '');
								item.attr('value', guid);
								item.attr('id', newName);
							}
							else if (inputNodeName == 'button' || inputNodeName == 'span') {
								if (oldName) {
									item.attr('id', newName);
								}
							}
							else {
								item.attr('name', newName);
								item.attr('id', newName);
							}
/*
							if (rules && rules[oldName]) {
								rules[newName] = rules[oldName];
							}*/

							clone.all('label[for=' + oldName + ']').attr('for', newName);
							//isbnIdx.set('value',guid);
						}
					);

					clone.all('.help-inline').remove();

					
					clearForm(clone);
					clone.all('input[type=hidden]').val('');

					return clone;
			}
		
		}
	
	
	
	
	
	
	);
	
	
	

</aui:script>