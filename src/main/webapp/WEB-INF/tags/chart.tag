<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ attribute name="id" required="true" %>
<%@ attribute name="label" required="true" %>

<div class="col-md-6 col-sm-12 col-xs-12">
	<div class="panel panel-default">
		<div class="panel-heading">
			<spring:message code="${label}" />
		</div>
		<div class="panel-body">
			<div id="${id}"></div>
		</div>
	</div>
</div>