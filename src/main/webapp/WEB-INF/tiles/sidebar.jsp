<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar-default navbar-side">
	<div class="sidebar-collapse">
		<ul class="nav" id="main-menu">
			<li class="text-center">
				<img src="<c:url value='/assets/img/find_user.png'/>" class="user-image img-responsive" />
			</li>
		
			<sec:authorize access="hasRole('ADMIN')">	
			<li>
				<a class="${patients}" href="<c:url value='/patients'/>">
					<i class="fa fa-users fa-3x"></i>&nbsp;Patients
				</a>
			</li>
			</sec:authorize>
			<li>
				<a class="${home}" href="<c:url value='/home'/>">
					<i class="fa fa-dashboard fa-3x"></i>&nbsp;Dashboard
				</a>
			</li>
		</ul>
	</div>
</nav>