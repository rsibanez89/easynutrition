<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="easy" tagdir="/WEB-INF/tags" %>

<div class="row">
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-heading"><spring:message code="patient.subtitle"/></div>

			<div class="panel-body">
				<form:form id="form" commandName="patient" role="form">
					<form:hidden path="id"/>
					
					<div class="row">
						<easy:control path="firstName" label="patient.firstName" cssCol="col-md-6">
							<form:input path="firstName" cssClass="form-control" tabindex="1"/>
						</easy:control>
			
						<easy:control path="lastName" label="patient.lastName" cssCol="col-md-6">
							<form:input path="lastName" cssClass="form-control" tabindex="2"/>
						</easy:control>
					</div>
			
					<div class="row">
						<easy:control path="gender" label="patient.gender" cssCol="col-md-3">
							<form:select path="gender" cssClass="form-control" tabindex="3">
								<form:option value="MALE"><spring:message code="patient.male"/></form:option>
								<form:option value="FEMALE"><spring:message code="patient.female"/></form:option>	
							</form:select>
						</easy:control>
			
						<easy:control path="birthday" label="patient.birthday" cssCol="col-md-3">
							<form:input path="birthday" cssClass="form-control" tabindex="4"/>
						</easy:control>
					
						<easy:control path="email" label="patient.email" cssCol="col-md-6">
							<div class="form-group">
								<div class="col-md-8" style="padding: 0;">
									<form:input path="email" cssClass="form-control" tabindex="5"/>
								</div>
								<div class="col-md-4">
									<input name="sendmail" type="checkbox" tabindex="6"/>
									<label><spring:message code="patient.sendmail"/></label>
								</div>
							</div>
						</easy:control>
					</div>
			
					<div class="row">
						<easy:control path="phoneNumber" label="patient.phoneNumber" cssCol="col-md-6">
							<form:input path="phoneNumber" cssClass="form-control" tabindex="7"/>
						</easy:control>
					</div>
					
					<div class="row">
						<div class="col-md-12">
							<button type="submit" class="btn btn-default" tabindex="8"><spring:message code="button.accept"/></button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>