<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar-default navbar-side">
	<div class="sidebar-collapse">
		<ul class="nav" id="main-menu">
			<li class="text-center">
				<img src="assets/img/find_user.png" class="user-image img-responsive" />
			</li>
		
			<sec:authorize access="hasRole('ADMIN')">	
			<li>
				<a class="${patient}" href="patient">
					<i class="fa fa-users fa-3x"></i>&nbsp;Patients
				</a>
			</li>
			</sec:authorize>
			<li>
				<a class="${index}" href="index">
					<i class="fa fa-dashboard fa-3x"></i>&nbsp;Dashboard
				</a>
			</li>
			<li>
				<a class="${ui}" href="ui">
					<i class="fa fa-desktop fa-3x"></i>&nbsp;UI Elements
				</a>
			</li>
			<li>
				<a class="${tab_panel}" href="tab-panel">
					<i class="fa fa-qrcode fa-3x"></i>&nbsp;Tabs &amp; Panels
				</a>
			</li>
			<li>
				<a class="${chart}" href="chart">
					<i class="fa fa-bar-chart-o fa-3x"></i>&nbsp;Morris Charts
				</a>
			</li>
			<li>
				<a class="${table}" href="table">
					<i class="fa fa-table fa-3x"></i>&nbsp;Table Examples
				</a>
			</li>
			<li>
				<a class="${form}" href="form">
					<i class="fa fa-edit fa-3x"></i>&nbsp;Forms 
				</a>
			</li>
			<li>
				<a href="#">
					<i class="fa fa-sitemap fa-3x"></i>&nbsp;Multi-Level Dropdown
					<span class="fa arrow"></span>
				</a>
				<ul class="nav nav-second-level collapse">
					<li><a href="#">Second Level Link</a></li>
					<li><a href="#">Second Level Link</a></li>
					<li><a href="#">Second Level Link<span class="fa arrow"></span></a>
						<ul class="nav nav-third-level">
							<li><a href="#">Third Level Link</a></li>
							<li><a href="#">Third Level Link</a></li>
							<li><a href="#">Third Level Link</a></li>
						</ul>
					</li>
				</ul>
			</li>
		</ul>
	</div>
</nav>