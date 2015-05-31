<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="easy" tagdir="/WEB-INF/tags" %>

<div class="row">
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-heading"><spring:message code="profile.subtitle"/></div>

			<div class="panel-body">
				<div class="row">
  					<div class="col-md-2"><img src='<c:url value="/assets/img/find_user.png"/>' class="img-thumbnail"></div>
  					<div class="col-md-8">
  						<div class="patient-detail">
	  						<p><strong><spring:message code="patient.firstName"/>:</strong> ${patient.firstName}</p>
	  						<p><strong><spring:message code="patient.lastName"/>:</strong> ${patient.lastName}</p>
	  						<p><strong><spring:message code="patient.email"/>:</strong> ${patient.email}</p>
	  						<p><strong><spring:message code="patient.phoneNumber"/>:</strong> ${patient.phoneNumber}</p>
  						</div>
  					</div>
  					<div class="col-md-2">
    					<button id="editButton" class="btn btn-default pull-right"><spring:message code="button.edit"/></button>	
  					</div>
				</div>
			</div>
			
			<div id="dataEmpty">
				<em><spring:message code="profile.evaluations.empty"/></em>
			</div>
			<div id="dataNonEmpty" style="display: none;">
				<div class="panel-body">
					<div class="row">                    
		               <easy:chart id="weight-chart" label="profile.weight"/>
		               <easy:chart id="height-chart" label="profile.height"/>
		           	</div>
				</div>
				
				<div class="panel-body">
					<div class="row">                     
		               <easy:chart id="waist-chart" label="profile.waist"/>
		               <easy:chart id="hip-chart" label="profile.hip"/>
		           	</div>
				</div>

				<div class="panel-body">
					<div class="table-responsive">
						<table id="evaluations" class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th><spring:message code="profile.date"/></th>
									<th><spring:message code="profile.weight"/></th>
									<th><spring:message code="profile.height"/></th>
									<th><spring:message code="profile.observation"/></th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>