<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="easy" tagdir="/WEB-INF/tags" %>

<div class="row">
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-heading"><spring:message code="patients.subtitle"/></div>
			
			<c:choose>
				<c:when test="${patients.size()==0}">
					<em>No hay pacientes registrados</em>
				</c:when>
				<c:otherwise>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>Id</th>
										<th>First Name</th>
										<th>Last Name</th>
										<th>Email</th>
										<th>Phone #</th>
										<th>REST URL</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${patients}" var="patient">
										<tr>
											<td>${patient.id}</td>
											<td>${patient.firstName}</td>
											<td>${patient.lastName}</td>
											<td>${patient.email}</td>
											<td>${patient.phoneNumber}</td>
											<td><a href="<c:url value="/rest/patient/${patient.id}"/>">/rest/patient/${patient.id}</a></td>
										</tr>									
									</c:forEach>
								</tbody>
							</table>
						</div>
						REST URL for all patients: <a href="<c:url value="/rest/patients"/>">/rest/patients</a>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>