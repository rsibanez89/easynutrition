<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<title>login form layered - Bootsnipp.com</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<style type="text/css">
body {
	background: #eee url(assets/img/easynutrition_login_bg.jpg);
	background-repeat: no-repeat;
	background-size: 100%
}

html,body {
	position: relative;
	height: 100%;
}

.login-container {
	position: relative;
	width: 300px;
	margin: 80px auto;
	padding: 20px 40px 40px;
	text-align: center;
}

#output {
	position: absolute;
	width: 300px;
	top: -75px;
	left: 0;
	color: #fff;
}

#output.alert-success {
	background: rgb(25, 204, 25);
}

#output.alert-danger {
	background: rgb(228, 105, 105);
}

.login-container::before,.login-container::after {
	content: "";
	position: absolute;
	width: 100%;
	height: 100%;
	top: 3.5px;
	left: 0;
	z-index: -1;
	-webkit-transform: rotateZ(4deg);
	-moz-transform: rotateZ(4deg);
	-ms-transform: rotateZ(4deg);
}

.login-container::after {
	top: 5px;
	z-index: -2;
	-webkit-transform: rotateZ(-2deg);
	-moz-transform: rotateZ(-2deg);
	-ms-transform: rotateZ(-2deg);
}

.avatar {
	width: 100px;
	height: 100px;
	margin: 10px auto 30px;
	border-radius: 100%;
	background-size: cover;
}

.form-box input {
	width: 100%;
	padding: 10px;
	text-align: center;
	height: 40px;
	border: 1px solid #ccc;;
	background: #fafafa;
	transition: 0.2s ease-in-out;
}

.form-box input:focus {
	outline: 0;
	background: #eee;
}

.form-box input[type="text"] {
	border-radius: 5px 5px 0 0;
	text-transform: lowercase;
}

.form-box input[type="password"] {
	border-radius: 0 0 5px 5px;
	border-top: 0;
}

.form-box button.login {
	margin-top: 15px;
	padding: 10px 20px;
}

.animated {
	-webkit-animation-duration: 1s;
	animation-duration: 1s;
	-webkit-animation-fill-mode: both;
	animation-fill-mode: both;
}

.fadeInUp {
	-webkit-animation-name: fadeInUp;
	animation-name: fadeInUp;
}
</style>
<script src="assets/js/jquery-1.11.3.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script type="text/javascript">
	/* 	window.alert = function() {
	 };
	 var defaultCSS = document.getElementById('bootstrap-css');
	 function changeCSS(css) {
	 if (css)
	 $('head > link')
	 .filter(':first')
	 .replaceWith(
	 '<link rel="stylesheet" href="'+ css +'" type="text/css" />');
	 else
	 $('head > link').filter(':first').replaceWith(defaultCSS);
	 }
	 $(document).ready(function() {
	 var iframe_height = parseInt($('html').height());
	 window.parent.postMessage(iframe_height, 'http://bootsnipp.com');
	 }); */
</script>
</head>
<body>
	<div class="container">
		<div class="login-container">
			<div id="output"></div>
			<div class="avatar"></div>
			<div class="form-box">
				<form action="<c:url value='/j_spring_security_check'/>"
					method="POST">
					<input name="j_username" type="text" placeholder="username">
					<input name="j_password" type="password" placeholder="password">
					<button class="btn btn-info btn-block login" type="submit">Login</button>
				</form>
			</div>
		</div>

	</div>
	<script type="text/javascript">
		$(function() {
			$("input[name=j_username]").focus();
		});
	</script>
</body>
</html>