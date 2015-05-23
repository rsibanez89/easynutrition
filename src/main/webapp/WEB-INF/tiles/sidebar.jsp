<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar-default navbar-side" role="navigation">
	<div class="sidebar-collapse">
		<ul class="nav" id="main-menu">
			<li class="text-center">
				<img src='<c:url value="/assets/img/find_user.png"/>' class="user-image img-responsive" />
			</li>
		
			<li>
				<a class="${home}" href='<c:url value="/home"/>'>
					<i class="fa fa-dashboard fa-3x"></i>&nbsp;<spring:message code="menu.dashboard"/>
				</a>
			</li>
			<sec:authorize access="hasRole('ADMIN')">	
			<li>
				<a class="${patients}" href='<c:url value="/patients"/>'>
					<i class="fa fa-users fa-3x"></i>&nbsp;<spring:message code="menu.patients"/>
				</a>
			</li>
			</sec:authorize>
		</ul>
	</div>
</nav>