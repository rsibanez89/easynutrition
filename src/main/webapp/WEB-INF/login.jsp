<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title><spring:message code="page.title" /></title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		
		<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
		<link href="assets/css/easy-login.css" rel="stylesheet" />
		
		<script src="assets/js/jquery-1.11.3.min.js"></script>
		<script src="assets/js/bootstrap.min.js"></script>
		<script src="assets/js/easy-login.js"></script>
	</head>
	<body>
		<div class="container">
			<div class="login-container">
				<div id="logo"></div>
				<div id="output"></div>
				<div class="avatar"></div>
				<c:if test="${param.error != null}">
					<div class="alert alert-danger">
						<spring:message code='login.invalid'/>
					</div>
				</c:if>
				<div class="form-box">
					<form action="<c:url value='/login_post'/>" method="POST">
						<input name="username" type="text" placeholder="<spring:message code='login.username'/>">
						<input name="password" type="password" placeholder="<spring:message code='login.password'/>">
						<button class="btn btn-info btn-block login" type="submit"><spring:message code="login.button"/></button>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>