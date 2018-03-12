<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="/struts-tags"%>
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
<link href="../assets/css/myPage.css" rel="stylesheet" type="text/css" />
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
</head>

<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<!-- NAVBAR -->
		<nav class="navbar navbar-default navbar-fixed-top">
		<div class="brand">
			<a href="index.jsp"><img src="../images/logo/logo5.jpg"
				alt="Klorofil Logo" class="img-responsive logo"></a>
		</div>
		<div class="container-fluid">
			<div class="navbar-btn">
				<button type="button" class="btn-toggle-fullwidth">
					<i class="lnr lnr-arrow-left-circle"></i>
				</button>
			</div>
			<div class="navbar-btn navbar-btn-right">
				<a class="btn btn-success update-pro" onclick="logout()" title="注销"
					target="_blank"><i class="lnr lnr-exit"></i> <span>&nbsp;&nbsp;&nbsp;注销</span></a>
			</div>
			<div id="navbar-menu">
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><img src="../assets/img/user.png"
							class="img-circle" alt="Avatar"> <span>Admin</span> <i
							class="icon-submenu lnr lnr-chevron-down"></i></a>
						<ul class="dropdown-menu">
							<li><a onclick="logout()"><i class="lnr lnr-exit"></i> <span>Logout</span></a></li>
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
					<li><a href="index.jsp" class="active"><i
							class="lnr lnr-home"></i> <span>首页</span></a></li>

					<li><a href="#subPages1" data-toggle="collapse"
						class="collapsed"><i class="lnr lnr-code"></i> <span>考生数据提取</span>
							<i class="icon-submenu lnr lnr-chevron-left"></i></a>
						<div id="subPages1" class="collapse ">
							<ul class="nav">
								<li><a href="studentInfoList.jsp" class="">考生信息提取</a></li>
								<li><a href="studentScoreList.jsp" class="">考生成绩抽取</a></li>

							</ul>
						</div></li>
					<li><a href="#subPages2" data-toggle="collapse"
						class="collapsed"><i class="lnr lnr-chart-bars"></i> <span>招生计划管理</span>
							<i class="icon-submenu lnr lnr-chevron-left"></i></a>
						<div id="subPages2" class="collapse ">
							<ul class="nav">
								<li><a href="enrollmentPlan.jsp" class="">招生信息管理</a></li>
								<li><a href="auditList.jsp" class="">招生信息变更审核</a></li>
							</ul>
						</div></li>
					<li><a href="#subPages4" data-toggle="collapse"
						class="collapsed"><i class="lnr lnr-cog"></i> <span>招生宣传管理</span><i
							class="icon-submenu lnr lnr-chevron-left"></i></a>
						<div id="subPages4" class="collapse ">
							<ul class="nav">
								<li><a href="attachList.jsp" class="">招生宣传附件</a></li>
							</ul>
						</div></li>
					<li><a href="#subPages3" data-toggle="collapse"
						class="collapsed"><i class="lnr lnr-cog"></i> <span>录取管理</span><i
							class="icon-submenu lnr lnr-chevron-left"></i></a>
						<div id="subPages3" class="collapse ">
							<ul class="nav">
								<li><a href="recruitInfoList.jsp" class="">新生录取信息</a></li>
								<li><a href="enrollmentNotice.jsp" class="">录取通知书管理</a></li>
								<li><a href="enrollmentAudit.jsp" class="">录取审核</a></li>
							</ul>
						</div></li>
					<li><a href="#subPages6" data-toggle="collapse"
						class="collapsed"><i class="lnr lnr-file-empty"></i> <span>综合查询功能</span>
							<i class="icon-submenu lnr lnr-chevron-left"></i></a>
						<div id="subPages6" class="collapse ">
							<ul class="nav">
								<li><a href="recruitInfoList.jsp" class="">基本信息查询</a></li>
								<li><a href="studentScoreList.jsp" class="">成绩查询</a></li>
								<li><a href="allAttachList.jsp" class="">文档查询</a></li>
							</ul>
						</div></li>
					<li><a href="#subPages8" data-toggle="collapse"
						class="collapsed"><i class="lnr lnr-text-format"></i> <span>系统管理</span><i
							class="icon-submenu lnr lnr-chevron-left"></i></a>
						<div id="subPages8" class="collapse ">
							<ul class="nav">
								<li><a href="dictionaryList.jsp" class="">字典管理</a></li>
								<li><a href="accountInfoList.jsp" class="">账户管理</a></li>
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
						<div class="panel-heading">
							<h3 class="panel-title">招生统计</h3>
							<p class="panel-subtitle">
								Period:
								<%=time%></p>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-md-3">
									<div class="metric">
										<span class="icon"><i class="fa fa-download"></i></span>
										<p>
											<span class="number">${enrolmentInfo.nEnrolNumber}</span> <span
												class="title">计划招生人数</span>
										</p>
									</div>
								</div>
								<div class="col-md-3">
									<div class="metric">
										<span class="icon"><i class="fa fa-shopping-bag"></i></span>
										<p>
											<span class="number">${enrolmentInfo.nAdmitedNumber}</span> <span
												class="title">录取人数</span>
										</p>
									</div>
								</div>
								<div class="col-md-3">
									<div class="metric">
										<span class="icon"><i class="fa fa-eye"></i></span>
										<p>
											<span class="number">${enrolmentInfo.nRecruitNumber}</span> <span
												class="title">审核通过新生</span>
										</p>
									</div>
								</div>
								<div class="col-md-3">
									<div class="metric">
										<span class="icon"><i class="fa fa-bar-chart"></i></span>
										<p>
											<span class="number">${enrolmentInfo.sRateRigister}%</span> <span
												class="title">报到率</span>
										</p>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-9" id="col-md-close">
									<!-- RECENT PURCHASES -->
									<div class="panel">
										<div class="panel-heading">
											<h3 class="panel-title">院系统计</h3>
											<div class="right">
												<button type="button" class="btn-toggle-collapse">
													<i class="lnr lnr-chevron-up"></i>
												</button>
												<button type="button" class="btn-remove">
													<i class="lnr lnr-cross"></i>
												</button>
											</div>
										</div>
										<div class="panel-body">
											<table class="table table-striped">
												<thead>
													<tr>
														<th style="text-align: center;">序号.</th>
														<th style="text-align: center;">院系</th>
														<th style="text-align: center;">招生人数</th>
														<th style="text-align: center;">是否已完成招生</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${enrolmentInfo.departments.list}"
														var="department">
														<tr>
															<td style="text-align: center;"><a href="#">${department.nSortNum}</a></td>
															<td style="text-align: center;">${department.sDepartmenName}</td>
															<td style="text-align: center;">${department.nCountEnrol}</td>
															<c:choose>
																<c:when test="${department.completeFlag== '0'}">
																	<td style="text-align: center;"><span class="label label-success">已完成招生</span></td>
																</c:when>
																<c:otherwise>
																	<td style="text-align: center;"><span class="label label-warning">未完成</span></td>

																</c:otherwise>
															</c:choose>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
										<div class="panel-footer">
											<div class="row">
												<div class="col-md-6" id="page_info_area"></div>
												<div class="col-md-6" id="page_nav_area"></div>
											</div>
										</div>
									</div>
								</div>
								<div class="col-md-3">
									<div class="weekly-summary text-right">
										<span class="number">${enrolmentInfo.nTotalNumber}</span> <span
											class="percentage"></span> <span class="info-label">学院总人数</span>
									</div>
									<div class="weekly-summary text-right">
										<span class="number">${enrolmentInfo.sRateEmployment}%</span>
										<span class="percentage"></span> <span class="info-label">就业率</span>
									</div>
									<div class="weekly-summary text-right">
										<span class="number">${enrolmentInfo.nInternationalClassNum}</span>
										<span class="percentage"></span> <span class="info-label">国际班数</span>
									</div>
								</div>
							</div>
						</div>
						<div id="toastr-demo" class="panel" style="display: none;">
							<div class="panel-body">
								<p class="demo-button">
									<button type="button" class="btn btn-danger btn-toastr"
										id="LoadError" data-context="error" data-message="数据加载失败"
										data-position="top-center"></button>
									<button type="button" class="btn btn-success btn-toastr"
										id="LoadSuccsse" data-context="success"
										data-message="首页招生统计数据初始化成功！" data-position="top-right"></button>
									<button type="button"
										class="btn btn-default btn-toastr-callback"
										id="toastr-callback1" data-context="info"
										data-message="onShown and onHidden callback demo"></button>
								</p>
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
		<footer>
		<div class="container-fluid">
			<p class="copyright">
				&copy; Copyright &copy; 2018 <a href="#">hgl Alan 
			</p>
		</div>
		</footer>
	</div>
	<!-- END WRAPPER -->
	<!-- Javascript -->
	<script src="../js/recruitmsFuncJs/initialTool.js"></script>
	<script src="../assets/vendor/jquery/jquery.min.js"></script>
	<script src="../assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="../assets/vendor/page/jqPaginator.min.js"></script>
	<script src="../assets/vendor/toastr/toastr.min.js"></script>
	<script src="../assets/vendor/chartist/js/chartist.min.js"></script>
	<script src="../assets/scripts/klorofil-common.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			/*-----------------------------------/
			/*	initial index 初始化界面
			/*----------------------------------*/
			$.ajax({
				type : "get",
				url : "/recruitms/admin/getIndexInfo",
				dataType : 'json',
				async : true,
				success : function(resp) {
					if (resp.code == 0) {
						//将token存在本地存储，然后跳转到主页面
						build_page_info(resp.data.departments);
						build_page_nav(resp.data.departments);

					} else {
						$('#LoadError').click();
						return;
					}
				}
			});
		})
		$('#closePanel').on('click', function(e) {
			$('#collapseTwo').attr("style", "display:none")
		})
	</script>
</body>

</html>
