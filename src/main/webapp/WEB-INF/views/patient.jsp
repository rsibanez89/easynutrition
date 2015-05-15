<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Easy Nutrition Application</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		
		<link href="assets/css/bootstrap.css" rel="stylesheet" />
		<link href="assets/css/font-awesome.css" rel="stylesheet" />
		<link href="assets/css/custom.css" rel="stylesheet" />
		<link href="assets/css/bootstrap-datetimepicker.min.css" rel="stylesheet" />
	    
	    <script src="assets/js/jquery-1.11.3.min.js"></script>
	    <script src="assets/js/moment.js"></script>
	    <script src="assets/js/bootstrap.min.js"></script>
	    <script src="assets/js/bootstrap-datetimepicker.min.js"></script>
	    <script src="assets/js/easy/patient.js"></script>
	</head>
	
	<body>
    	<div id="wrapper">
    		<jsp:include page="/WEB-INF/tiles/menu.jsp"/>

			<jsp:include page="/WEB-INF/tiles/sidebar.jsp"/>

			<div id="page-wrapper">
				<div id="page-inner">
					<div class="row">
						<div class="col-md-12">
							<div class="panel panel-default">
								<div class="panel-heading">Registro de pacientes</div>
								<div class="panel-body">

									<form:form commandName="newPatient" id="reg" role="form">
										<div class="row">
											<div class="col-md-6">											
												<div class="form-group">
													<form:label path="name">Nombre:</form:label>
													<form:input path="name" cssClass="form-control" tabindex="1"/>
													<form:errors cssClass="alert alert-danger col-md-12" role="alert" path="name" />
												</div>
											</div>
											
											<div class="col-md-3">											
												<div class="form-group">
													<form:label path="gender">Sexo:</form:label>
													<form:select path="gender" cssClass="form-control" tabindex="2">
														<form:option value="MALE">Masculino</form:option>
														<form:option value="FEMALE">Femenino</form:option>	
													</form:select>
													<form:errors cssClass="alert alert-danger col-md-12" role="alert" path="gender" />
												</div>
											</div>
									  		
											<div class="col-md-3">
												<div class="form-group">
													<form:label path="birthday">Fecha de nacimiento:</form:label>
													<form:input path="birthday" cssClass="form-control" tabindex="2"/>
													<form:errors cssClass="alert alert-danger col-md-12" role="alert" path="birthday" />
												</div>
											</div>
										</div>
										
										<div class="row">
											<div class="col-md-6">	
												<div class="form-group">
													<form:label path="email">Email:</form:label>
													<form:input path="email" cssClass="form-control" tabindex="2"/>
													<form:errors cssClass="alert alert-danger col-md-12" role="alert" path="email" />
												</div>																					
											</div>
											
											<div class="col-md-6">
												<div class="form-group">
													<form:label path="phoneNumber">Teléfono:</form:label>
													<form:input path="phoneNumber" cssClass="form-control" tabindex="3"/>
													<form:errors cssClass="alert alert-danger col-md-12" role="alert" path="phoneNumber" />
												</div>
											</div>
										</div>
										
										<div class="row">
											<div class="col-md-12">
												<input type="submit" value="Register" class="btn btn-default" />
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
															<th>Name</th>
															<th>Email</th>
															<th>Phone #</th>
															<th>REST URL</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach items="${patients}" var="patient">
															<tr>
																<td>${patient.id}</td>
																<td>${patient.name}</td>
																<td>${patient.email}</td>
																<td>${patient.phoneNumber}</td>
																<td><a href="<c:url value="/rest/patient/${patient.id}"/>">/rest/patient/${patient.id}</a></td>
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
				</div>
			</div>
		</div>
	</body>
</html>