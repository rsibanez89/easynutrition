<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ attribute name="path" required="true" %>
<%@ attribute name="label" required="true" %>
<%@ attribute name="cssCol" required="true" %>

<div class="${cssCol}">
	<spring:bind path="${path}">										
		<div class="form-group ${status.error ? 'has-error' : '' }">
			<form:label path="${path}" cssClass="control-label"><spring:message code="${label}"/></form:label>
			<jsp:doBody/>
			<form:errors cssClass="alert alert-danger col-md-12" role="alert" path="${path}" />
		</div>
	</spring:bind>
</div>