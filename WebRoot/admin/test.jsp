<%@page import="com.hgl.recruitms.common.bean.EnrolmentInfo"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date currentTime = new Date();
	String time = simpleDateFormat.format(currentTime).toString();
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
<link rel="stylesheet"
	href="../assets/vendor/chartist/css/chartist-custom.css">
<link rel="stylesheet" href="../assets/vendor/toastr/toastr.min.css">
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
<!-- Javascript -->
<script src="../assets/vendor/jquery/jquery.min.js"></script>
<script src="../assets/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="../assets/vendor/toastr/toastr.min.js"></script>
<script src="../assets/vendor/chartist/js/chartist.min.js"></script>
<script src="../assets/scripts/klorofil-common.js"></script>
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
			<div class="navbar-btn navbar-btn-right">
				<a class="btn btn-success update-pro" id="logout" href="#"
					title="注销" target="_blank"><i class="lnr lnr-exit"></i> <span>&nbsp;&nbsp;&nbsp;注销</span></a>
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
			<div class="sidebar-scroll"
				style="width: 260px; height: 560px; overflow: scroll; overflow-y: auto; overflow-x: hidden; border: 1px solid;">
				<nav>
				<ul class="nav">
					<li><a href="index.html" class="active"><i
							class="lnr lnr-home"></i> <span>首页</span></a></li>
					<li><a href="#subPages3" data-toggle="collapse"
						class="collapsed"><i class="lnr lnr-cog"></i> <span>录取管理</span><i
							class="icon-submenu lnr lnr-chevron-left"></i></a>
						<div id="subPages3" class="collapse ">
							<ul class="nav">
								<li><a href="page-profile.html" class="">新生录取信息</a></li>
								<li><a href="page-login.html" class="">录取通知书管理</a></li>
								<li><a href="page-lockscreen.html" class="">录取场地管理</a></li>
							</ul>
						</div></li>
					<li><a href="#subPages1" data-toggle="collapse"
						class="collapsed"><i class="lnr lnr-code"></i> <span>考生数据提取</span>
							<i class="icon-submenu lnr lnr-chevron-left"></i></a>
						<div id="subPages1" class="collapse ">
							<ul class="nav">
								<li><a href="studentInfo.jsp" class="">考生信息抽取</a></li>
								<li><a href="page-login.html" class="">考生成绩抽取</a></li>
								<li><a href="page-lockscreen.html" class="">档案管理</a></li>
							</ul>
						</div></li>
					<li><a href="#subPages2" data-toggle="collapse"
						class="collapsed"><i class="lnr lnr-chart-bars"></i> <span>招生计划管理</span>
							<i class="icon-submenu lnr lnr-chevron-left"></i></a>
						<div id="subPages2" class="collapse ">
							<ul class="nav">
								<li><a href="page-profile.html" class="">招生信息管理</a></li>
								<li><a href="page-login.html" class="">报考指南管理</a></li>
							</ul>
						</div></li>
					<li><a href="#subPages4" data-toggle="collapse"
						class="collapsed"><i class="lnr lnr-cog"></i> <span>招生宣传管理</span><i
							class="icon-submenu lnr lnr-chevron-left"></i></a>
						<div id="subPages4" class="collapse ">
							<ul class="nav">
								<li><a href="page-profile.html" class="">招生宣传附件</a></li>
								<li><a href="page-login.html" class="">宣传设置</a></li>
							</ul>
						</div></li>
					<li><a href="#subPages5" data-toggle="collapse"
						class="collapsed"><i class="lnr lnr-alarm"></i> <span>新生入学管理</span><i
							class="icon-submenu lnr lnr-chevron-left"></i></a>
						<div id="subPages5" class="collapse ">
							<ul class="nav">
								<li><a href="page-profile.html" class="">新生信息管理</a></li>
								<li><a href="page-login.html" class="">新生入学须知管理</a></li>
								<li><a href="page-lockscreen.html" class="">转专业</a></li>
							</ul>
						</div></li>
					<li><a href="#subPages6" data-toggle="collapse"
						class="collapsed"><i class="lnr lnr-file-empty"></i> <span>综合查询功能</span>
							<i class="icon-submenu lnr lnr-chevron-left"></i></a>
						<div id="subPages6" class="collapse ">
							<ul class="nav">
								<li><a href="page-profile.html" class="">基本信息查询</a></li>
								<li><a href="page-login.html" class="">成绩查询</a></li>
								<li><a href="page-lockscreen.html" class="">文档查询</a></li>
							</ul>
						</div></li>
					<li><a href="#subPages8" data-toggle="collapse"
						class="collapsed"><i class="lnr lnr-text-format"></i> <span>系统管理</span><i
							class="icon-submenu lnr lnr-chevron-left"></i></a>
						<div id="subPages8" class="collapse ">
							<ul class="nav">
								<li><a href="page-profile.html" class="">字典管理</a></li>
								<li><a href="page-login.html" class="">账户管理</a></li>
								<li><a href="page-lockscreen.html" class="">院系专业管理</a></li>
								<li><a href="page-lockscreen.html" class="">修改审核</a></li>
							</ul>
						</div></li>
					<li><a href="#subPages9" data-toggle="collapse"
						class="collapsed"><i class="lnr lnr-linearicons"></i> <span>帮助功能</span><i
							class="icon-submenu lnr lnr-chevron-left"></i></a>
						<div id="subPages9" class="collapse ">
							<ul class="nav">
								<li><a href="page-profile.html" class="">答疑</a></li>
								<li><a href="page-login.html" class="">咨询服务</a></li>
							</ul>
						</div></li>
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
					<!-- OVERVIEW -->
					<div class="panel panel-headline">
						<div id="toastr-demo" class="panel">
							<div class="panel-body">
								<p class="demo-button">
									<button type="button" class="btn btn-danger btn-toastr"
										id="LoadError" data-context="error" data-message="用户名不允许为空"
										data-position="top-center" style="display: none;"></button>
									<button type="button" class="btn btn-success btn-toastr"
										id="LoadSuccsse" data-context="success"
										data-message="This is success info" data-position="top-right"
										style="display: none;"></button>
									<button type="button"
										class="btn btn-default btn-toastr-callback"
										id="toastr-callback1" data-context="info"
										data-message="onShown and onHidden callback demo"
										style="display: none;"></button>
								</p>
								<input type="text" value="${enrolmentInfo.nEnrolNumber}">
								<!-- END CALLBACK -->
							</div>
						</div>
					</div>
					<!-- END OVERVIEW -->
				</div>
			</div>
			<!-- END MAIN CONTENT -->
		</div>
		<!-- END MAIN -->
		<div class="clearfix"></div>
	</div>
	<!-- END WRAPPER -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*-----------------------------------/
			/*	initial index 初始化界面
			/*----------------------------------*/
			$.ajax({
				type : "get",
				url : "/recruitms/v1/dept/getIndexInfo",
				dataType : 'json',
				success : function(resp) {
					if (resp.code == 0) {
						//将token存在本地存储，然后跳转到主页面
						$('#LoadSuccsse').click();
					} else {
						$('#LoadError').click();
						return;
					}
				}
			});
		})
		$("#loginout").on("click", function() {
			localStorage.removeItem("token");
			location.href = "login.jsp";
		});
	</script>
</body>

</html>
