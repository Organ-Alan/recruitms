<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>广州大学华软软件学院 招生管理系统</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<!-- VENDOR CSS -->
<link rel="stylesheet"
	href="../assets/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="../assets/vendor/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="../assets/vendor/linearicons/style.css">
<link href="../assets/css/myPage.css" rel="stylesheet" type="text/css" />
<!-- MAIN CSS -->
<link rel="stylesheet" href="../assets/css/main.css">
<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
<link rel="stylesheet" href="../assets/css/demo.css">

<!-- GOOGLE FONTS -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700"
	rel="stylesheet">
<!-- ICONS -->
<link rel="apple-touch-icon" sizes="76x76"
	href="../assets/img/apple-icon.png">
<link rel="icon" type="image/png" sizes="96x96"
	href="../assets/img/favicon.png">
	
	<script type="text/javascript">
        function loadData(num) {
            $("#PageCount").val("2");
        }
    </script>
</head>

<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<!-- NAVBAR -->
		<nav class="navbar navbar-default navbar-fixed-top">
		<div class="brand">
			<a href="index.html"><img src="../assets/img/logo-dark.png"
				alt="Klorofil Logo" class="img-responsive logo"></a>
		</div>
		<div class="container-fluid">
			<div class="navbar-btn">
				<button type="button" class="btn-toggle-fullwidth">
					<i class="lnr lnr-arrow-left-circle"></i>
				</button>
			</div>
			<form class="navbar-form navbar-left">
				<div class="input-group">
					<input type="text" value="" class="form-control"
						placeholder="Search dashboard..."> <span
						class="input-group-btn"><button type="button"
							class="btn btn-primary">Go</button></span>
				</div>
			</form>
			<div class="navbar-btn navbar-btn-right">
				<a class="btn btn-success update-pro"
					href="#downloads/klorofil-pro-bootstrap-admin-dashboard-template/?utm_source=klorofil&utm_medium=template&utm_campaign=KlorofilPro"
					title="Upgrade to Pro" target="_blank"><i class="fa fa-rocket"></i>
					<span>UPGRADE TO PRO</span></a>
			</div>
			<div id="navbar-menu">
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#"
						class="dropdown-toggle icon-menu" data-toggle="dropdown"> <i
							class="lnr lnr-alarm"></i> <span class="badge bg-danger">5</span>
					</a>
						<ul class="dropdown-menu notifications">
							<li><a href="#" class="notification-item"><span
									class="dot bg-warning"></span>System space is almost full</a></li>
							<li><a href="#" class="notification-item"><span
									class="dot bg-danger"></span>You have 9 unfinished tasks</a></li>
							<li><a href="#" class="notification-item"><span
									class="dot bg-success"></span>Monthly report is available</a></li>
							<li><a href="#" class="notification-item"><span
									class="dot bg-warning"></span>Weekly meeting in 1 hour</a></li>
							<li><a href="#" class="notification-item"><span
									class="dot bg-success"></span>Your request has been approved</a></li>
							<li><a href="#" class="more">See all notifications</a></li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><i class="lnr lnr-question-circle"></i>
							<span>Help</span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
						<ul class="dropdown-menu">
							<li><a href="#">Basic Use</a></li>
							<li><a href="#">Working With Data</a></li>
							<li><a href="#">Security</a></li>
							<li><a href="#">Troubleshooting</a></li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><img src="../assets/img/user.png"
							class="img-circle" alt="Avatar"> <span>Samuel</span> <i
							class="icon-submenu lnr lnr-chevron-down"></i></a>
						<ul class="dropdown-menu">
							<li><a href="#"><i class="lnr lnr-user"></i> <span>My
										Profile</span></a></li>
							<li><a href="#"><i class="lnr lnr-envelope"></i> <span>Message</span></a></li>
							<li><a href="#"><i class="lnr lnr-cog"></i> <span>Settings</span></a></li>
							<li><a href="#"><i class="lnr lnr-exit"></i> <span>Logout</span></a></li>
						</ul></li>
					<!-- <li>
							<a class="update-pro" href="#downloads/klorofil-pro-bootstrap-admin-dashboard-template/?utm_source=klorofil&utm_medium=template&utm_campaign=KlorofilPro" title="Upgrade to Pro" target="_blank"><i class="fa fa-rocket"></i> <span>UPGRADE TO PRO</span></a>
						</li> -->
				</ul>
			</div>
		</div>
		</nav>
		<!-- END NAVBAR -->
		<!-- LEFT SIDEBAR -->
		<div id="sidebar-nav" class="sidebar">
			<div class="sidebar-scroll">
				<nav>
				<ul class="nav">
					<li><a href="index.html" class=""><i class="lnr lnr-home"></i>
							<span>Dashboard</span></a></li>
					<li><a href="elements.html" class=""><i
							class="lnr lnr-code"></i> <span>Elements</span></a></li>
					<li><a href="charts.html" class=""><i
							class="lnr lnr-chart-bars"></i> <span>Charts</span></a></li>
					<li><a href="panels.html" class=""><i class="lnr lnr-cog"></i>
							<span>Panels</span></a></li>
					<li><a href="notifications.html" class=""><i
							class="lnr lnr-alarm"></i> <span>Notifications</span></a></li>
					<li><a href="#subPages" data-toggle="collapse"
						class="collapsed"><i class="lnr lnr-file-empty"></i> <span>Pages</span>
							<i class="icon-submenu lnr lnr-chevron-left"></i></a>
						<div id="subPages" class="collapse ">
							<ul class="nav">
								<li><a href="page-profile.html" class="">Profile</a></li>
								<li><a href="page-login.html" class="">Login</a></li>
								<li><a href="page-lockscreen.html" class="">Lockscreen</a></li>
							</ul>
						</div></li>
					<li><a href="tables.html" class="active"><i
							class="lnr lnr-dice"></i> <span>Tables</span></a></li>
					<li><a href="typography.html" class=""><i
							class="lnr lnr-text-format"></i> <span>Typography</span></a></li>
					<li><a href="icons.html" class=""><i
							class="lnr lnr-linearicons"></i> <span>Icons</span></a></li>
				</ul>
				</nav>
			</div>
		</div>
		<!-- END LEFT SIDEBAR -->
		<!-- MAIN -->
		<div class="main">
			<!-- MAIN CONTENT -->
			<div class="main-content">
				<div class="container-fluid">
					<h3 class="page-title">Tables</h3>
					<div class="row">
						<div class="col-md-6" style="width: 100%">
							<!-- TABLE HOVER -->
							<div class="panel">
								<div class="panel-heading">
									<h3 class="panel-title">Hover Row</h3>
								</div>
								<div class="panel-body">
									<table class="table table-hover">
										<thead>
											<tr>
												<th>#</th>
												<th>First Name</th>
												<th>Last Name</th>
												<th>Username</th>
												<th>Email</th>
												<th>Contacts</th>
												<th>Score</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>1</td>
												<td>Steve</td>
												<td>Jobs</td>
												<td>@steve</td>
												<td>Jobs</td>
												<td>@steve</td>
												<td>Jobs</td>
											</tr>
											<tr>
												<td>2</td>
												<td>Simon</td>
												<td>Philips</td>
												<td>@simon</td>
												<td>Jobs</td>
												<td>@steve</td>
												<td>Jobs</td>
											</tr>
											<tr>
												<td>3</td>
												<td>Jane</td>
												<td>Doe</td>
												<td>@jane</td>
												<td>Jobs</td>
												<td>@steve</td>
												<td>Jobs</td>
											</tr>
											<tr>
												<td>4</td>
												<td>Jane</td>
												<td>Doe</td>
												<td>@jane</td>
												<td>Jobs</td>
												<td>@steve</td>
												<td>Jobs</td>
											</tr>
											<tr>
												<td>5</td>
												<td>Jane</td>
												<td>Doe</td>
												<td>@jane</td>
												<td>Jobs</td>
												<td>@steve</td>
												<td>Jobs</td>
											</tr>
											<tr>
												<td>6</td>
												<td>Jane</td>
												<td>Doe</td>
												<td>@jane</td>
												<td>Jobs</td>
												<td>@steve</td>
												<td>Jobs</td>
											</tr>
											<tr>
												<td>7</td>
												<td>Jane</td>
												<td>Doe</td>
												<td>@jane</td>
												<td>Jobs</td>
												<td>@steve</td>
												<td>Jobs</td>
											</tr>
											<tr>
												<td>8</td>
												<td>Jane</td>
												<td>Doe</td>
												<td>@jane</td>
												<td>Jobs</td>
												<td>@steve</td>
												<td>Jobs</td>
											</tr>
											<tr>
												<td>9</td>
												<td>Jane</td>
												<td>Doe</td>
												<td>@jane</td>
												<td>Jobs</td>
												<td>@steve</td>
												<td>Jobs</td>
											</tr>
											<tr>
												<td>10</td>
												<td>Jane</td>
												<td>Doe</td>
												<td>@jane</td>
												<td>Jobs</td>
												<td>@steve</td>
												<td>Jobs</td>
											</tr>
											<tr>
												<td>11</td>
												<td>Jane</td>
												<td>Doe</td>
												<td>@jane</td>
												<td>Jobs</td>
												<td>@steve</td>
												<td>Jobs</td>
											</tr>
											<tr>
												<td>12</td>
												<td>Jane</td>
												<td>Doe</td>
												<td>@jane</td>
												<td>Jobs</td>
												<td>@steve</td>
												<td>Jobs</td>
											</tr>
											<tr>
												<td>13</td>
												<td>Jane</td>
												<td>Doe</td>
												<td>@jane</td>
												<td>Jobs</td>
												<td>@steve</td>
												<td>Jobs</td>
											</tr>
											<tr>
												<td>14</td>
												<td>Jane</td>
												<td>Doe</td>
												<td>@jane</td>
												<td>Jobs</td>
												<td>@steve</td>
												<td>Jobs</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
							<!-- END TABLE HOVER -->
						</div>
						<div style="text-align: center;">
							<ul class="pagination" id="pagination">
							</ul>
							<input type="hidden" id="PageCount" runat="server" /> 
							<input type="hidden" id="PageSize" runat="server" value="2" />
							<input type="hidden" id="countindex" runat="server" value="2" />
							<!--设置最多显示的页码数 可以手动设置 默认为7-->
							<input type="hidden" id="visiblePages" runat="server" value="2" />
						</div>
					</div>
				</div>
			</div>
			<!-- END MAIN CONTENT -->
		</div>
		<!-- END MAIN -->
		<div class="clearfix"></div>
	</div>
	<!-- END WRAPPER -->
	<!-- Javascript -->
	<script src="../assets/vendor/jquery/jquery.min.js"></script>
	<script src="../assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="../assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script src="../assets/vendor/bootstrap/js/jqPaginator.min.js"></script>
	<script src="../assets/scripts/klorofil-common.js"></script>
	<script src="../assets/vendor/page/myPage.js"></script>
</body>

</html>
