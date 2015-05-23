<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="row">
	<div class="col-md-12">
		<div class="error-container">
			<h2><spring:message code="error.subtitle"/></h2>
	
			<h1>Oops!</h1>
	
			<div class="error-details">
				<spring:message code="error.details"/>
			</div>
	
			<div class="error-actions">
				<a href='<c:url value="/home"/>' class="btn btn-primary btn-lg"> 
					<i class="fa fa-chevron-left"></i>&nbsp;<spring:message code="error.back"/>
				</a> 
				<a href="mailto:easynutrition.info@gmail.com" class="btn btn-warning btn-lg"> 
					<i class="fa fa-envelope"></i>&nbsp;<spring:message code="error.contact"/>
				</a>
			</div>
		</div>
	</div>
</div>