<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="easy" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:importAttribute scope="request"/>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title><spring:message code="page.title"/></title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		
		<link rel="shortcut icon" href='<c:url value="/assets/img/easynutrition.ico"/>' />
		<link rel="apple-touch-icon" href='<c:url value="/assets/img/easynutrition128.png"/>' />
		
		<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet" />
		<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" />
		<link href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.7.14/css/bootstrap-datetimepicker.min.css" rel="stylesheet" />
		<link href="//cdn.datatables.net/plug-ins/1.10.7/integration/bootstrap/3/dataTables.bootstrap.css" rel="stylesheet" />
		<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css">
		<link href='<c:url value="/assets/css/template.css"/>' rel="stylesheet" />
		
		<!-- TILE SPECIFIC CSS -->
		<c:forEach var="css" items="${styles}">
			<link href='<c:url value="/assets/css/${css}"/>' rel="stylesheet" />
		</c:forEach>

		<script type="text/javascript">
			var locale = "${pageContext.response.locale}";
			var baseUrl = "${pageContext.servletContext.contextPath}"; // o <c:url value="/"/>
			var patientId = "${patientId}";
		</script>
		<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
 	    <script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
 	    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	    <script src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js"></script>
	    <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.7.14/js/bootstrap-datetimepicker.min.js"></script>
	    <script src="//cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>
	    <script src="//cdn.datatables.net/plug-ins/1.10.7/integration/bootstrap/3/dataTables.bootstrap.js"></script>
	    <script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
	    <script src="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>
 		<script src='<c:url value="/assets/js/template.js"/>'></script>

		<!-- TILE SPECIFIC JS -->
		<c:forEach var="js" items="${scripts}">
			<script src='<c:url value="/assets/js/${js}"/>'></script>
		</c:forEach>
	</head>
	
	<body>
    	<div id="wrapper">
    		<%-- HEADER --%>
    		<tiles:insertAttribute name="header"/>

    		<%-- SIDEBAR --%>
			<tiles:insertAttribute name="sidebar"/>

			<div id="page-wrapper">
				<div id="page-inner">
					<%-- BODY --%>
					<tiles:insertAttribute name="body"/>
				</div>
			</div>
		</div>
	</body>
</html>