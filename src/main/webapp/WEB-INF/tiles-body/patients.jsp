<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="easy" tagdir="/WEB-INF/tags" %>

<div class="row">
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-heading"><spring:message code="patients.subtitle"/></div>
			
			<div class="panel-body">
				<table id="patients" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%">
					<thead>
						<tr>
							<th><spring:message code="patient.firstName"/></th>
							<th><spring:message code="patient.lastName"/></th>
							<th><spring:message code="patient.email"/></th>
							<th><spring:message code="patient.phoneNumber"/></th>
							<th><spring:message code="button.edit"/></th>
							<th><spring:message code="button.delete"/></th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
				
				<form:form id="form" action="patient/add" role="form" method="GET">
					<div class="row">
						<div class="col-md-12">
							<button type="submit" class="btn btn-default"><spring:message code="button.add"/></button>
						</div>
					</div>
				</form:form>
				
				<div id="buttons">
					<button class="btn btn-sm primary edit"><i class="fa fa-pencil"></i><spring:message code="button.edit"/></button>
					<button class="btn btn-sm btn-danger delete"><i class="fa fa-pencil"></i><spring:message code="button.delete"/></button>
				</div>
			</div>			
		</div>
	</div>
</div>