<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="easy" tagdir="/WEB-INF/tags" %>

<div class="row">
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-heading"><spring:message code="profile.subtitle"/></div>

			<div class="panel-body">
				<div class="row">
  					<div class="col-md-2"><img src='<c:url value="/assets/img/find_user.png"/>' class="img-thumbnail"></div>
  					<div class="col-md-8">
  						<div class="patient-detail">
	  						<p><strong><spring:message code="patient.firstName"/>:</strong> ${patient.firstName}</p>
	  						<p><strong><spring:message code="patient.lastName"/>:</strong> ${patient.lastName}</p>
	  						<p><strong><spring:message code="patient.email"/>:</strong> ${patient.email}</p>
	  						<p><strong><spring:message code="patient.phoneNumber"/>:</strong> ${patient.phoneNumber}</p>
  						</div>
  					</div>
  					<div class="col-md-2">
    					<button id="editButton" class="btn btn-default pull-right"><spring:message code="button.edit"/></button>	
  					</div>
				</div>
			</div>
			
			<c:choose>
				<c:when test="${evaluations.size()==0}">
					<em></em>
				</c:when>
				<c:otherwise>
					<div class="panel-body">
						<div class="row">                     
			               <div class="col-md-6 col-sm-12 col-xs-12">                     
			                    <div class="panel panel-default">
			                        <div class="panel-heading">Peso</div>
			                        <div class="panel-body">
			                            <div id="weight-chart"></div>
			                        </div>
			                    </div>            
			                </div>
			                
			                <div class="col-md-6 col-sm-12 col-xs-12">                     
			                    <div class="panel panel-default">
			                        <div class="panel-heading">Altura</div>
			                        <div class="panel-body">
			                            <div id="height-chart"></div>
			                        </div>
			                    </div>            
			                </div> 
			           	</div>
					</div>
					
					<div class="panel-body">
						<div class="row">                     
			               <div class="col-md-6 col-sm-12 col-xs-12">                     
			                    <div class="panel panel-default">
			                        <div class="panel-heading">Circunferencia de cintura</div>
			                        <div class="panel-body">
			                            <div id="waist-chart"></div>
			                        </div>
			                    </div>            
			                </div>
			                
			                <div class="col-md-6 col-sm-12 col-xs-12">                     
			                    <div class="panel panel-default">
			                        <div class="panel-heading">Circunferencia de cadera</div>
			                        <div class="panel-body">
			                            <div id="hip-chart"></div>
			                        </div>
			                    </div>            
			                </div> 
			           	</div>
					</div>
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${evaluations.size()==0}">
					<em>No hay evaluaciones para el paciente</em>
				</c:when>
				<c:otherwise>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>Date</th>
										<th>Weight</th>
										<th>Height</th>
										<th>Observation</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${evaluations}" var="evaluation">
										<tr>
											<td><fmt:formatDate value="${evaluation.date.getTime()}" pattern="dd/MM/yyyy"/></td>
											<td>${evaluation.weight}</td>
											<td>${evaluation.height}</td>
											<td>${evaluation.observation}</td>
										</tr>									
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>