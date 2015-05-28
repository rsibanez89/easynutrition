<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="easy" tagdir="/WEB-INF/tags" %>

<div class="row">
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-heading"><spring:message code="evaluations.subtitle"/>: ${patient.firstName} ${patient.lastName}</div>
			
			<div class="panel-body">
				<form:form id="form" commandName="evaluation" role="form">
					<form:hidden path="id"/>
					
					<div class="row">
						<easy:control path="weight" label="evaluation.weight" cssCol="col-md-6">
							<form:input path="weight" cssClass="form-control" tabindex="1"/>
						</easy:control>
			
						<easy:control path="height" label="evaluation.height" cssCol="col-md-6">
							<form:input path="height" cssClass="form-control" tabindex="2"/>
						</easy:control>
					</div>
					
					<div class="row">
						<div class="col-md-12">
							<button type="submit" class="btn btn-default"><spring:message code="button.accept"/></button>
						</div>
					</div>
				</form:form>
			</div>
			
			
		</div>
	</div>
</div>