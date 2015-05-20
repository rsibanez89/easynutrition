<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="easy" tagdir="/WEB-INF/tags" %>

<div class="row">
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-heading"><spring:message code="patients.subtitle"/></div>
			
			<div class="panel-body">
				<table id="patients" class="table table-striped table-bordered" cellspacing="0" width="100%">
					<thead>
						<tr>
							<th><spring:message code="patient.firstName"/></th>
							<th><spring:message code="patient.lastName"/></th>
							<th><spring:message code="patient.email"/></th>
							<th><spring:message code="patient.phoneNumber"/></th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
				
				<form:form id="form" action="patient/add" role="form" method="GET">
					<div class="row">
						<div class="col-md-12">
							<button type="submit" class="btn btn-default"><spring:message code="button.register"/></button>
						</div>
					</div>
				</form:form>
			</div>			
		</div>
	</div>
</div>