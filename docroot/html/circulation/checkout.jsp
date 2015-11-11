<%@ include file="/html/cataloging/init.jsp" %>


<liferay-portlet:actionURL name="actionCheckout" varImpl="checkOutURL">
	<liferay-portlet:param name="page" value="/html/circulation/checkout.jsp"/>
</liferay-portlet:actionURL>

<div class="row-fluid">
	<div class="span5">
	<aui:form name="fm" method="post" action="<%= checkOutURL %>">
	
		<aui:input name="cardNumber" inlineLabel="left"></aui:input>
		<div id="userInfo">
		
		</div>
		
		<aui:input name="barcode" inlineLabel="left"></aui:input>
		
		<aui:button-row>
			<aui:button name="checkOutBtn" cssClass="btn-primary" type="button" value="checkout"></aui:button>
		</aui:button-row>
	</aui:form>
	
	
	
	</div>
	<div class="span7">
		<div class="row-fluid">	
		<div>
			
		</div>	
			
			
			<div class="pull-left span3">
				<img id="patronImageX" alt="Patron Picture" src="/image/user_male_portrait?img_id=0"/>
			</div>
			<div class="patronSummary span9">
				<p id="pName">Patron Full Name</p>
				<p id="pStatus">Status: </p>
				<p id="pCategory">Category: </p>
				
			</div>
		</div>
		<div class="row-fluid" style="margin-top:5px;">	
			<div id="checkoutStatus" class="span8 alert">
					<span>Valid for checkout</span> 
					<aui:button name="btnViewItem" value="view"/>
					
			</div>
		
		</div>
		</div>
	</div>

<idv id="patronInfo">

</idv>



<portlet:resourceURL var="resourceURL"/>
<portlet:renderURL var="patronInfoURL">
	<liferay-util:param name="page" value="/html/circulation/patron_info.jsp"></liferay-util:param>
</portlet:renderURL>
<aui:script> 
AUI().use('aui-base', 'aui-io-request', 'aui-node', function(A) {

	var userEmailValidation = false;
	var userScreenNameValidation = false;
	var viewPatronItemURL = null;
	var viewCatalogItemURL = null;
	
	A.one("#<portlet:namespace/>cardNumber").on('blur', function() 
	{
		//aui ajax call
		var cardNumber = A.one("#<portlet:namespace/>cardNumber").get("value");
		A.io.request('<%=resourceURL%>', {
			dataType: 'json',
			method: 'GET',
			data: { 
				<portlet:namespace />cardNumber: cardNumber,
				<portlet:namespace />cmd: '<%= CirculationUtil.RESOURCE_VALIDATE_PATRON_CHECKOUT %>'
			},
			on: {
				success: function() {
					var data = this.get('responseData');
					console.log(data);
					
					var data = this.get('responseData');
					var validForCheckout = data.validForCheckout;
					var patronName = data.patronName;
					var portraitURL = data.patronPortrait;
					console.log(portraitURL);
					A.one('#patronImageX').setAttribute('src', portraitURL);
					A.one('#pName').text(patronName);
					A.one('#pStatus').text(data.patronStatus);
					A.one('#pCategory').text(data.patronCategory);
					
					if (!data.patronExists)
					{
						updatePatronStatusMsg(Liferay.Language.get('invalid-patron'))
						return;
					}
					
					var checkOutStatus = A.one('#checkoutStatus');
					var checkoutMsg;
					if (validForCheckout)
					{
						checkOutStatus.removeClass('alert-error')
						checkOutStatus.addClass('alert-info');
						checkoutMsg = Liferay.Language.get('valid-for-checkout');
					}else
					{
						checkOutStatus.removeClass('alert-info')
						checkOutStatus.addClass('alert-error');
						checkoutMsg = Liferay.Language.get('invalid-for-checkout');
					}
					
					updatePatronStatusMsg(checkoutMsg);
					
					var portletURL = Liferay.PortletURL.createRenderURL();
					portletURL.setParameter('patronId', data.patronId);
					portletURL.setParameter('mvcPath', '/html/circulation/patron_checkout.jsp');
					portletURL.setWindowState('pop_up');
					portletURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
					viewPatronItemURL = portletURL;
				}
			}
		});
		//try load info via ajax
		A.io.request('<%=patronInfoURL%>', {
			dataType: 'html',
			method: 'GET',
			data: { 
				<portlet:namespace />cardNumber: cardNumber,
				<portlet:namespace />cmd: '<%= CirculationUtil.RESOURCE_PATRON_INFO %>'
			},
			on: {
				success: function() {
					var data = this.get('responseData');
					console.log(data);
					
				}
			}
		});
		
		
		
	});
	
	
	function updatePatronStatusMsg(message)
	{
		A.one('#checkoutStatus span').html(message);
	}
	
	
	A.one("#<portlet:namespace/>barcode").on('blur', function() {
		var barcode = A.one("#<portlet:namespace/>barcode").get("value");
		A.io.request('<%=resourceURL%>', {
			dataType: 'json',
			method: 'GET',
			data: { <portlet:namespace />barcode: barcode,
				<portlet:namespace />cmd: '<%= CirculationUtil.RESOURCE_VALIDATE_CATALOGITEM_CHECKOUT %>'

			},
			on: {
				success: function() {
					var data = this.get('responseData');
					console.log(data);
					if (data.validForCheckout)
					{
							
					}else
					{
						
					}
					
					
					

					

				}
			}
		});
	});

	A.one('#<portlet:namespace/>checkOutBtn').on('click', function(event) {
		if (userEmailValidation == true && userScreenNameValidation == true) {
			document. <portlet:namespace />fm.submit();
		}
	});
	
	A.one('#<portlet:namespace/>btnViewItem').on('click', function(event) 
	{
		
		if (viewPatronItemURL == null)
			{
			return;
			}
		Liferay.Util.openWindow(
		        {
		            id: '<portlet:namespace />viewPatronItem',
		            uri: viewPatronItemURL.toString()
		        }
		    );
		
	});

}); 
</aui:script>