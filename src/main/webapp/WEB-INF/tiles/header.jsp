<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-default navbar-cls-top "style="margin-bottom: 0">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="index">Easy Nutrition</a>
	</div>
	<div
		style="color: white; padding: 15px 50px 5px 50px; float: right; font-size: 16px;">
		<span style="margin-right: 20px">
			<sec:authentication property="principal.username" />
		</span>
		<a href="<c:url value='/logout'/>" class="btn btn-danger square-btn-adjust">Logout</a>
	</div>
</nav>