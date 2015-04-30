<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Spring MVC Starter Application</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" type="text/css" href="<c:url value="/static/resources/css/screen.css"/>" />
		<link href="<c:url value="assets/css/bootstrap.css"/>" rel="stylesheet" />
		<link href="<c:url value="assets/css/font-awesome.css"/>" rel="stylesheet" />
		<link href="<c:url value="assets/js/morris/morris-0.4.3.min.css"/>" rel="stylesheet" />
		<link href="<c:url value="assets/css/custom.css"/>" rel="stylesheet" />
		<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
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
								<div class="panel-heading">Person Registration</div>
								<div class="panel-body">
									<div class="row">
										<div class="col-md-6">
											<h3>Enforces annotation-based constraints defined on the model class.</h3>
											<form:form commandName="newPerson" id="reg" role="form">
												<div class="form-group">
													<form:label path="name">Name:</form:label>
													<form:input path="name" cssClass="form-control"/>
													<p><form:errors cssClass="alert alert-danger" role="alert" path="name" /></p>
												</div>
												<div class="form-group">
													<form:label path="email">Email:</form:label>
													<form:input path="email" cssClass="form-control"/>
													<p><form:errors cssClass="alert alert-danger" role="alert" path="email" /></p>
												</div>
												<div class="form-group">
													<form:label path="phoneNumber">Phone #:</form:label>
													<form:input path="phoneNumber" cssClass="form-control"/>
													<p><form:errors cssClass="alert alert-danger" role="alert" path="phoneNumber" /></p>
												</div>
												<input type="submit" value="Register" class="btn btn-default" />
											</form:form>
										</div>
									</div>
								</div>
					
								<c:choose>
									<c:when test="${people.size()==0}">
										<em>No registered people.</em>
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
														<c:forEach items="${people}" var="person">
															<tr>
																<td>${person.id}</td>
																<td>${person.name}</td>
																<td>${person.email}</td>
																<td>${person.phoneNumber}</td>
																<td><a href="<c:url value="/rest/person/${person.id}"/>">/rest/person/${person.id}</a></td>
														</c:forEach>
													</tbody>
												</table>
											</div>
											REST URL for all people: <a href="<c:url value="/rest/people"/>">/rest/people</a>
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