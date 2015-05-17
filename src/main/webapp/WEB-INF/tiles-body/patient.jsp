<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="easy" tagdir="/WEB-INF/tags" %>

<div class="panel-heading"><spring:message code="patient.subtitle"/></div>

<div class="row">
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-body">
				<form:form commandName="newPatient" id="reg" role="form">
					<div class="row">
						<easy:control path="firstName" label="patient.firstName" cssCol="col-md-6">
							<form:input path="firstName" cssClass="form-control" tabindex="1"/>
						</easy:control>
			
						<easy:control path="lastName" label="patient.lastName" cssCol="col-md-6">
							<form:input path="lastName" cssClass="form-control" tabindex="2"/>
						</easy:control>
					</div>
			
					<div class="row">
						<easy:control path="gender" label="patient.gender" cssCol="col-md-3">
							<form:select path="gender" cssClass="form-control" tabindex="3">
								<form:option value="MALE"><spring:message code="patient.male"/></form:option>
								<form:option value="FEMALE"><spring:message code="patient.female"/></form:option>	
							</form:select>
						</easy:control>
			
						<easy:control path="birthday" label="patient.birthday" cssCol="col-md-3">
							<form:input path="birthday" cssClass="form-control" tabindex="4"/>
						</easy:control>
					
						<easy:control path="email" label="patient.email" cssCol="col-md-6">
							<form:input path="email" cssClass="form-control" tabindex="5"/>
						</easy:control>
					</div>
			
					<div class="row">
						<easy:control path="phoneNumber" label="patient.phoneNumber" cssCol="col-md-6">
							<form:input path="phoneNumber" cssClass="form-control" tabindex="6"/>
						</easy:control>
					</div>
					
					<div class="row">
						<div class="col-md-12">
							<button type="submit" class="btn btn-default"><spring:message code="button.register"/></button>
						</div>
					</div>
				</form:form>
			</div>
			
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