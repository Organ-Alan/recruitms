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
<meta charset="utf-8">
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
<link rel="stylesheet" href="../assets/css/myPage.css">
<script src="../assets/vendor/page/myPage.js" type="text/javascript"></script>
<script src="../assets/vendor/page/jqPaginator.min.js"
	type="text/javascript"></script>
</head>

<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<!-- NAVBAR -->
		<nav class="navbar navbar-default navbar-fixed-top">
		<div class="brand">
			<a href="index.jsp"><img src="../images/logo/logo5.jpg"
				height="30px" width="130px" alt="Klorofil Logo"
				class="img-responsive logo"></a>
		</div>
		<div class="container-fluid">
			<div class="navbar-btn">
				<button type="button" class="btn-toggle-fullwidth">
					<i class="lnr lnr-arrow-left-circle"></i>
				</button>
			</div>
			<div id="navbar-menu">
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><img src="../assets/img/user1.png"
							class="img-circle" alt=""> <span id="username">Student</span> <i
							class="icon-submenu lnr lnr-chevron-down"></i></a>
						<ul class="dropdown-menu">
							<li><a onclick="logoutForStudent()"><i
									class="lnr lnr-exit"></i> <span>退出登录</span></a></li>
						</ul></li>
				</ul>
			</div>
		</div>
		</nav>
		<!-- END NAVBAR -->
		<!-- LEFT SIDEBAR -->
		<div id="sidebar-nav" class="sidebar">
			<div class="sidebar-scroll"
				style="width: 100%; height: 100%; overflow: scroll; overflow-y: auto; overflow-x: hidden;">
				<nav>
				<ul class="nav">
					<li><a href="index.jsp" class="active"> <i
							class="lnr lnr-home"></i> <span>首页</span>
					</a></li>
					<li><a href="enrollmentPlan.jsp" class=""><i
							class="lnr lnr-code"></i> <span>招生计划查看</span></a></li>
					<li><a href="QAInfoList.jsp" class=""><i
							class="lnr lnr-alarm"></i> <span>答疑</span></a></li>
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
					<div class="panel panel-profile">
						<div class="clearfix">
							<!-- LEFT COLUMN -->
							<div class="profile-left">
								<!-- PROFILE HEADER -->
								<div class="profile-header">
									<div class="overlay"></div>
									<div class="profile-main">
										<img src="../assets/img/user-medium.png" class="img-circle"
											alt="Avatar">
										<h3 class="name">彭靖怡</h3>
										<span class="online-status status-available"
											style="font-size: 18px" id="age"></span> 
									</div>
									<div class="profile-stat">
										<div class="row">
											<div class="col-md-4 stat-item">
												<span style="font-size: 18px"><strong>录取专业</strong></span> <span id="major">
												</span>
											</div>
											<div class="col-md-4 stat-item">
												<span style="font-size: 18px"><strong>学号</strong></span> <span id="candidateNum"></span>
											</div>
											<div class="col-md-4 stat-item">
												<span style="font-size: 18px"><strong>高考分数</strong></span> <span
													style="font-size: 16px" id="totalScore"></span>
											</div>
										</div>
									</div>
								</div>
								<!-- END PROFILE HEADER -->
								<!-- PROFILE DETAIL -->
								<div class="profile-detail">
									<div class="profile-info">
										<h4 class="heading">基本信息</h4>
										<ul class="list-unstyled list-justify">
											<li>通讯地址 <span id="address"></span></li>
											<li>联系方式 <span id="contact"></span></li>
											<li>邮箱 <span id="email"></span></li>
											<li>政治面貌 <span id="politics"></span></li>
										</ul>
									</div>
									<div class="profile-info"></div>
									<!-- <div class="profile-info">
                              <h4 class="heading">About</h4>
                              <p>Interactively fashion excellent information after distinctive outsourcing.</p>
                           </div> -->
									<!-- <div class="text-center"><a href="#" class="btn btn-primary">Edit Profile</a></div> -->
								</div>
								<!-- END PROFILE DETAIL -->
							</div>
							<!-- END LEFT COLUMN -->
							<!-- RIGHT COLUMN -->
							<div class="profile-right">
								<h4 class="heading">
									<span class="glyphicon glyphicon-bookmark"></span>&nbsp; 招生情况
								</h4>
								<!-- AWARDS -->
								<div class="awards">
									<div class="row">
										<div class="col-md-3 col-sm-6">
											<div class="award-item">
												<div class="hexagon">
													<span class=" award-icon">3707</span>
												</div>
												<span>全院计划招生人数</span>
											</div>
										</div>
										<div class="col-md-3 col-sm-6">
											<div class="award-item">
												<div class="hexagon">
													<span class="award-icon">100</span>
												</div>
												<span>全院补录人数</span>
											</div>
										</div>
										<div class="col-md-3 col-sm-6">
											<div class="award-item">
												<div class="hexagon">
													<span class="award-icon">480</span>
												</div>
												<span>最低录取分数线</span>
											</div>
										</div>
										<div class="col-md-3 col-sm-6">
											<div class="award-item">
												<div class="hexagon">
													<span class="award-icon">12618</span>
												</div>
												<span>招生代码</span>
											</div>
										</div>
									</div>
									<!-- <div class="text-center"><a href="#" class="btn btn-default">See all awards</a></div> -->
								</div>
								<!-- END AWARDS -->
								<!-- TABBED CONTENT -->
								<div class="custom-tabs-line tabs-line-bottom left-aligned">
									<ul class="nav" role="tablist">
										<li class="active"><a href="#tab-bottom-left1" role="tab"
											data-toggle="tab">招生进度</a></li>
										<li><a href="#tab-bottom-left2" role="tab"
											data-toggle="tab">招生办联系方式 <!-- <span class="badge">7</span> --></a></li>
									</ul>
								</div>
								<div class="tab-content">
									<div class="tab-pane fade in active" id="tab-bottom-left1">
										<ul class="list-unstyled activity-timeline">
											<li><i class="fa fa-check activity-icon"></i>
												<p>
													录取公布 <span class="timestamp">2017年7月13日</span>
												</p></li>
											<li><i class="fa fa-comment activity-icon"></i>
												<p>
													答疑服务 <span class="timestamp">2017年7月10日 ——2017年7月20日</span>
												</p></li>
											<li><i class="fa fa-check activity-icon"></i>
												<p>
													考生报考 <span class="timestamp">2017年6月28日 ——2017年7月2日</span>
												</p></li>
										</ul>
									</div>
									<div class="tab-pane fade" id="tab-bottom-left2">
										<!-- <div class="table-responsive"> -->
										<div class="row">
											<label class="col-md-3" style="text-align: right">地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址：</label>
											<div class="col-md-8">
												<span style="font-size: 16px">广东从化经济开发区高技术产业园广从南路548号</span>
											</div>
										</div>
										<br>
										<div class="row">
											<label class="col-md-3" style="text-align: right">联系电话：</label>
											<div class="col-md-6">
												<span style="font-size: 18px">020－87818918</span>
											</div>
										</div>
										<br>
										<div class="row">
											<label class="col-md-3" style="text-align: right">邮政编码：</label>
											<div class="col-md-6">
												<span style="font-size: 18px"> 510990 </span>
											</div>
										</div>
										<!-- </div> -->
									</div>
								</div>
								<!-- END TABBED CONTENT -->
							</div>
							<!-- END RIGHT COLUMN -->
						</div>
					</div>
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
	<script src="../assets/vendor/jquery/jquery.min.js"></script>
	<script src="../assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="../assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script
		src="../assets/vendor/jquery.easy-pie-chart/jquery.easypiechart.min.js"></script>
	<script src="../assets/vendor/chartist/js/chartist.min.js"></script>
	<script src="../assets/scripts/klorofil-common.js"></script>
	<script src="../js/recruitmsFuncJs/initialTool.js"></script>
	<script>
		$(document).ready(function() {
			var username = localStorage.getItem("username");
			
			/*-----------------------------------/
			/*	initial index 初始化界面
			/*----------------------------------*/
			$.ajax({
				type : "get",
				url : "/recruitms/student/getIndexInfo?&sStudentName="+username,
				dataType : 'json',
				async : true,
				success : function(resp) {
					if (resp.code == 0) {
						//将token存在本地存储，然后跳转到主页面
						initialScoreInfo(resp.data.score);
						initialBaseInfo(resp.data.recruitInfo);
						initialMajor(resp.data.sAdmitedMajor,resp.data.deptName);

					} else {
						$('#LoadError').click();
						return;
					}
				}
			});
		})
		function initialScoreInfo(result) {
			$('#totalScore').text(result.sTotalScore);
		}
		function initialBaseInfo(result) {
			$('.name').text(result.sStudentName);
			$('#candidateNum').text(result.sStudentNo);
			$('#age').text(result.nAge);
			$('#address').text(result.sAddress);
			$('#contact').text(result.sContact);
			$('#email').text(result.sEmail);
			if(result.sPolitiis == 'zgdy'){
				$('#politics').text("中共党员");
			}
			if(result.sPolitiis == 'zgybdy'){
				$('#politics').text("中共预备党员");
			}
			if(result.sPolitiis == 'gqty'){
				$('#politics').text("共青团员");
			}
			if(result.sPolitiis == 'qz'){
				$('#politics').text("群众");
			}
			$('#username').text(result.sStudentName);
		}
		function initialMajor(sAdmitedMajor,deptName) {
			$('#major').text(deptName+"  "+sAdmitedMajor);
		}
		function logoutForStudent() {
			$.ajax({
				type : "get",
				url : "/recruitms/admin/logout",
				dataType : 'json',
				async : true,
				success : function(resp) {
					if (resp.code == 0) {
						//将token存在本地存储，然后跳转到主页面
						location.href = "/recruitms/admin/login.jsp";

					} else {
						$('#LoadError').click();
						return;
					}
				}
			});
		}
	</script>
</body>

</html>
