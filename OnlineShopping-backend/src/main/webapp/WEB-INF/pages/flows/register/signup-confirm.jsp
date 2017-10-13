<%@include file="../shared/flows-header.jsp" %>
<div class="container">
	
	<div class="row">
	
		<div class="col-sm-6">
	
			<div class="panel panel-primary">
				
				<div class="panel-heading">
					<h4>Personal Details</h4>
				</div>
			
				<div class="panel-body">
					<div class="text-center">
						<h4>${registerModel.user.firstName} ${registerModel.user.lastName}</h4>
						<h4>Email: ${registerModel.user.email}</h4>
						<h4>${registerModel.user.contactNumber}</h4>
						<h4>${registerModel.user.role}</h4>
						
					
						<p>
							<a href="${flowExecutionUrl}&_eventId_personal" class="btn btn-primary">Edit</a>
						</p>
					</div>
				</div>
			
			</div>
					
		
		</div>
		
		<div class="col-sm-6">
		
			<div class="panel panel-primary">
				
				<div class="panel-heading">
					<h4>Billing Address</h4>
				</div>
			
				<div class="panel-body">
					<div class="text-center">
					    <h4>${registerModel.billing.addressLineOne}</h4>
					    <h4>${registerModel.billing.addressLineTwo}</h4>
						<h4>City:${registerModel.billing.city}</h4>
						<h4>State:${registerModel.billing.state}</h4>
						<h4>Postalcode:${registerModel.billing.postalCode}</h4>
					     
					
						<p>
							<a href="${flowExecutionUrl}&_eventId_billing" class="btn btn-primary">Edit</a>
						</p>
					</div>
				</div>
			
			</div>
		
		</div>
	
	</div>
	
	<div class="row">
		
		<div class="col-sm-4 col-sm-offset-4">
			
			<div class="text-center">
				
				<a href="${flowExecutionUrl}&_eventId_submit" class="btn btn-lg btn-primary">Confirm</a>
				
			</div>
			
		</div>
		
	</div>

</div>
<%@include file="../shared/flows-footer.jsp" %>