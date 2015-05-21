<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="easy" tagdir="/WEB-INF/tags" %>

<div class="row">
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-heading"><spring:message code="evaluations.subtitle"/>: ${patient.firstName} ${patient.lastName}</div>
			
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