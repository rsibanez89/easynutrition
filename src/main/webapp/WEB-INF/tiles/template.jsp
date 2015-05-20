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
		
		<link rel="shortcut icon" href="<c:url value='/assets/img/easynutrition.ico'/>" />
		<link href="<c:url value='/assets/css/bootstrap.min.css'/>" rel="stylesheet" />
		<link href="<c:url value='/assets/css/font-awesome.css'/>" rel="stylesheet" />
    	<link href="<c:url value='/assets/css/morris-0.4.3.min.css'/>" rel="stylesheet" />
		<link href="<c:url value='/assets/css/custom.css'/>" rel="stylesheet" />
		<link href="<c:url value='/assets/css/bootstrap-datetimepicker.min.css'/>" rel="stylesheet" />
	    
	    <script src="<c:url value='/assets/js/jquery-1.11.3.min.js'/>"></script>
	    <script src="<c:url value='/assets/js/moment.js'/>"></script>
		<script src="<c:url value='/assets/js/jquery.metisMenu.js'/>"></script>
		<script src="<c:url value='/assets/js/morris/raphael-2.1.0.min.js'/>"></script>
		<script src="<c:url value='/assets/js/morris/morris.js'/>"></script>
 		<script src="<c:url value='/assets/js/custom.js'/>"></script>
 	    <script src="<c:url value='/assets/js/bootstrap.min.js'/>"></script>
	    <script src="<c:url value='/assets/js/bootstrap-datetimepicker.min.js'/>"></script>
	    <script src="<c:url value='/assets/js/easy/patient.js'/>"></script>
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