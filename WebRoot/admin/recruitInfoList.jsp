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
<script src="../assets/vendor/jquery-slimscroll/jquery.slimscroll.js"></script>
<script
	src="../assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<script
	src="../assets/vendor/jquery.easy-pie-chart/jquery.easypiechart.min.js"></script>
<script src="../assets/vendor/chartist/js/chartist.min.js"></script>
<script src="../assets/scripts/klorofil-common.js"></script>
<script src="../js/recruitmsFuncJs/initialTool.js"></script>
<script src="../js/model.js"></script>
<script src="../assets/vendor/page/jqPaginator.min.js"></script>
<link rel="stylesheet" href="../assets/css/main.css">
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
					<div class="col-md-6" style="width: 100%;">
						<!-- start input -->
						<div class="panel">
							<!-- INPUTS -->
							<!-- start search -->
							<div class="panel">
								<div class="panel-heading">
									<h3 class="panel-title">新生录取信息</h3>
								</div>
								<div class="panel-body">
									<form action="/recruitms/admin/listRecruitInfos" method="get">
										<div>
											<input type="hidden" id="pageIndex" name="pageIndex"
												value="1" /> <input type="hidden" id="pageSize"
												name="pageSize" value="6" /> <label class="form-inline">学号：<input
												type="text" class="form-control" id="sStudentNo"
												name="sStudentNo" style="width: 120px" /></label> <label
												class="form-inline">学生姓名：<input type="text"
												class="form-control" id="sStudentName" name="sStudentName"
												style="width: 100px" /></label> <label class="form-inline">录取专业：<select
												id="sAdmitedMajor" name="sAdmitedMajor" class="form-control"
												style="width: 90px">
													<option value="">全部</option>
													<c:forEach items="${departmentListDic.list}" var="deptInfo">
														<option value="${deptInfo.sDeptCode}">${deptInfo.sFullName}</option>
													</c:forEach>

											</select></label> <label class="form-inline">是否已缴费:<select
												id="sPayFlag" name="sPayFlag" class="form-control"
												style="width: 80px">
													<option value="">全部</option>
													<option value="0">未缴费</option>
													<option value="1">已缴费</option>
													<option value="2">已缴部分费用</option>
											</select></label> <label class="form-inline">审核状态:<select
												class="form-control" id="sStatus" name="sStatus"
												style="width: 100px">
													<option value="">全部</option>
													<option value="1">待审核</option>
													<option value="2">审核通过</option>
													<option value="3">审核不通过</option>
											</select></label> <label class="form-inline">年级:<select
												class="form-control" id="sGrade" name="sGrade"
												style="width: 120px">
													<option value="">全部</option>
													<option value="2014">14级</option>
													<option value="2015">15级</option>
													<option value="2016">16级</option>
											</select></label>
										</div>
										<hr>
										<div align="left">
											<label class="form-inline"><button
													class="btn btn-primary" type="button" data-toggle="modal"
													data-target="#myModal">新增</button></label> <label
												class="form-inline"><button class="btn btn-primary"
													type="button"
													onclick="window.location.href='/recruitms/admin/export/recruitInfoList?sStudentNo&sStudentName&sAdmitedMajor&sGrade&sPayFlag&sStatus=2&nStudentIdList='">
导出</button></label>
											<label class="form-inline"><button
													class="btn btn-primary" type="submit"
													style="text-align: center; align-content: right;">查询</button></label>
													
										</div>
									</form>
									<br>
									<!-- end search -->
									<!-- TABLE HOVER -->
									<table class="table table-hover">
										<thead>
											<tr>
												<th>学号</th>
												<th>姓名</th>
												<th>年龄</th>
												<th>录取专业</th>
												<th>通讯地址</th>
												<th>联系方式</th>
												<th>年级</th>
												<th>是否已缴费</th>
												<th>审核状态</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td><input type="hidden" id="initialPage" /></td>
											</tr>
											<c:forEach items="${recruitInfoList.list}" var="recruitInfo">
												<tr>
													<td>${recruitInfo.sStudentNo}</td>
													<td>${recruitInfo.sStudentName}</td>
													<td>${recruitInfo.nAge}</td>
													<td>${recruitInfo.sAdmitedMajor}</td>
													<td>${recruitInfo.sAddress}</td>
													<td>${recruitInfo.sContact}</td>
													<td>${recruitInfo.sGrade}</td>
													<td>
														<c:if test="${recruitInfo.sPayFlag ==0}">未缴费</c:if>
														<c:if test="${recruitInfo.sPayFlag ==1}">已缴费</c:if>
														<c:if test="${recruitInfo.sPayFlag ==2}">已缴部分费用</c:if>
													</td>
													<td><c:if test="${recruitInfo.sStatus ==1}">待审核</c:if>
														<c:if test="${recruitInfo.sStatus ==2}">已审核</c:if>
														<c:if test="${recruitInfo.sStatus ==3}">审核不通过</c:if>
													</td>
													<td style="text-align: center;">
														<button type="button" class="btn btn-primary btn-xs" data-whatever="${recruitInfo.nStudentId}" class="btn btn-primary" data-toggle="modal" data-target="#editModal">修改</button>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<div class="panel-footer" align="right">
									<div class="row">
										<!-- 分页文字信息 ：拿到控制器处理请求时封装在pageInfo里面的分页信息-->
										<div class="col-md-6" align="left">
											当前${recruitInfoList.pageNum}页,共${recruitInfoList.pages }页,总${recruitInfoList.total }条记录
										</div>
										<!-- 分页码 -->
										<div class="col-md-6">
											<nav aria-label="Page navigation">
											<ul class="pagination">
												<!-- 
							                        1.pageContext.request.contextPath表示当前项目路径，采用的是绝对路径表达方式。一般为http:localhost:8080/项目名 。
							                        2.首页，末页的逻辑：pn=1访问第一次，pn=${recruitInfoList.pages}访问最后一页
							                      -->
												<li><a
													href="/recruitms/admin/listRecruitInfos?pageIndex=1&pageSize=8&sStudentNo&sStudentName&sAdmitedMajor&sGrade&sPayFlag&sStatus">首页</a>
												</li>
												<!-- 如果还有前页就访问当前页码-1的页面， -->
												<c:if test="${recruitInfoList.hasPreviousPage}">
													<li><a
														href="/recruitms/admin/listRecruitInfos?pageIndex=${recruitInfoList.pageNum-1}&pageSize=8&sStudentNo&sStudentName&sAdmitedMajor&sGrade&sPayFlag&sStatus"
														aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
													</a></li>
												</c:if>
												<li>
													<!--遍历所有导航页码，如果遍历的页码页当前页码相等就高亮显示，如果相等就普通显示  --> <c:forEach
														items="${recruitInfoList.navigatepageNums }" var="page_Nums">
														<c:if test="${page_Nums==recruitInfoList.pageNum }">
															<li class="active"><a href="#">${page_Nums}</a></li>
														</c:if>
														<c:if test="${page_Nums!=recruitInfoList.pageNum }">
															<li><a
																href="/recruitms/admin/listRecruitInfos?pageIndex=${page_Nums}&pageSize=8&sStudentNo&sStudentName&sAdmitedMajor&sGrade&sPayFlag&sStatus">${page_Nums}</a></li>
														</c:if>
													</c:forEach>
												</li>
												<!-- 如果还有后页就访问当前页码+1的页面， -->
												<c:if test="${recruitInfoList.hasNextPage}">
													<li><a
														href="/recruitms/admin/listRecruitInfos?pageIndex=${recruitInfoList.pageNum+1}&pageSize=8&sStudentNo&sStudentName&sAdmitedMajor&sGrade&sPayFlag&sStatus"
														aria-label="Next"> <span aria-hidden="true">&raquo;</span>
													</a></li>
												</c:if>
												<li><a
													href="/recruitms/admin/listRecruitInfos?pageIndex=${recruitInfoList.pages}&pageSize=8&sStudentNo&sStudentName&sAdmitedMajor&sGrade&sPayFlag&sStatus">末页</a></li>
											</ul>
											</nav>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- END OVERVIEW -->
					</div>
				</div>
				<!-- END MAIN CONTENT -->
			</div>
			<!-- /.modal -->
			<!-- 添加模态框 begin-->
		<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="exampleModalLabel">修改新生信息</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal" id="form1">
							<div class="form-group">
							<input type="hidden" id="nStudentId1" name="nStudentId" value=""/>
								<label  class="col-sm-3 control-label">学&emsp;&emsp;号：</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="sStudentNo1" name="sStudentNo" placeholder="请输入学号">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-sm-3 control-label">学生姓名：</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="sStudentName1"
										name="sStudentName" placeholder="请输入姓名">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-sm-3 control-label">年龄：</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="nAge1" name="nAge" data-toggle="tooltip"  title="请输入正整数！">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-sm-3 control-label">性别：</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="cSex1" name="cSex" placeholder="">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-sm-3 control-label">通讯地址：</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="sAddress1" name="sAddress" placeholder="请输入通讯地址">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-sm-3 control-label">联系方式：</label>
								<div class="col-sm-6">
									<input type="text" class="form-control"id="sContact1" name="sContact" placeholder="请输入家属联系方式">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-sm-3 control-label">政治面貌：</label>
								<div class="col-sm-6">
										<select
										id="sPolitiis1" name="sPolitiis" class="form-control">
											<option value="qz">群众</option>
											<option value="gqty">共青团员</option>
											<option value="zgybdy">中共预备党员</option>
											<option value="zgdy">中共党员</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label  class="col-sm-3 control-label">录取专业：</label>
								<div class="col-sm-6">
									<select
										id="sAdmitedMajor1" name="sAdmitedMajor" class="form-control"
										style="width: 200px"
										value="">
											<c:forEach items="${departmentListDic.list}" var="deptInfo">
												<option value="${deptInfo.sDeptCode}">${deptInfo.sFullName}</option>
											</c:forEach>

									</select>
								</div>
							</div>
							<div class="form-group">
								<label  class="col-sm-3 control-label">是否已缴费：</label>
								<div class="col-sm-6">
									<select
										id="sPayFlag1" name="sPayFlag" class="form-control"
										style="width: 200px" value="">
											<option value="">全部</option>
											<option value="0">未缴费</option>
											<option value="1">已缴费</option>
											<option value="2">已缴部分费用</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label  class="col-sm-3 control-label">年级：</label>
								<div class="col-sm-6">
									<select
										class="form-control" id="sGrade1" name="sGrade"
										style="width: 200px" value="">
											<option value="2014">14级</option>
											<option value="2015">15级</option>
											<option value="2016">16级</option>
									</select>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="button" class="btn btn-primary" onclick="updateInfo()">提交</button>
					</div>
				</div>
			</div>
		</div>
		<!-- 修改模态框end -->
		<!-- 添加模态框end -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="exampleModalLabel">录入新生信息</h4>
					</div>
					<div class="modal-body">
						<form id="form" class="form-horizontal" action="##" onsubmit="return false" method="post">
							<div class="form-group">
								<label  class="col-sm-3 control-label">学&emsp;&emsp;号：</label>
								<div class="col-sm-6">
									<input type="hidden" id="nStudentId">
									<input type="text" class="form-control" id="sStudentNo" name="sStudentNo" placeholder="请输入学号">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-sm-3 control-label">学生姓名：</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="" id="sStudentName"
										name="sStudentName" placeholder="请输入学生姓名">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-sm-3 control-label">年龄：</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="nAge" name="nAge" data-toggle="tooltip"  title="请输入正整数！">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-sm-3 control-label">性别：</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="cSex" name="cSex" placeholder="">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-sm-3 control-label">通讯地址：</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="sAddress" name="sAddress" placeholder="请输入通讯地址">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-sm-3 control-label">家属联系方式：</label>
								<div class="col-sm-6">
									<input type="text" class="form-control"id="sOtherCtact" name="sOtherCtact" placeholder="请输入家属联系方式">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-sm-3 control-label">政治面貌：</label>
								<div class="col-sm-6">
									<select
										id="sPolitiis" name="sPolitiis" class="form-control" >
											<option value="qz">群众</option>
											<option value="gqty">共青团员</option>
											<option value="zgybdy">中共预备党员</option>
											<option value="zgdy">中共党员</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label  class="col-sm-3 control-label">录取专业：</label>
								<div class="col-sm-6">
									<select
										id="sAdmitedMajor" name="sAdmitedMajor" class="form-control"
										style="width: 200px"
										value="">
											<c:forEach items="${departmentListDic.list}" var="deptInfo">
												<option value="${deptInfo.sDeptCode}">${deptInfo.sFullName}</option>
											</c:forEach>

									</select>
								</div>
							</div>
							<div class="form-group">
								<label  class="col-sm-3 control-label">录取专业：</label>
								<div class="col-sm-6">
									<select
										id="sAdmitedMajor" name="sAdmitedMajor" class="form-control"
										style="width: 200px"
										value="">
											<c:forEach items="${departmentListDic.list}" var="deptInfo">
												<option value="${deptInfo.sDeptCode}">${deptInfo.sFullName}</option>
											</c:forEach>

									</select>
								</div>
							</div>
							<div class="form-group">
								<label  class="col-sm-3 control-label">是否已缴费：</label>
								<div class="col-sm-6">
									<select
										id="sPayFlag" name="sPayFlag" class="form-control"
									 value="">
											<option value="">全部</option>
											<option value="0">未缴费</option>
											<option value="1">已缴费</option>
											<option value="2">已缴部分费用</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label  class="col-sm-3 control-label">审核状态:</label>
								<div class="col-sm-6">
									<select
										class="form-control" id="sStatus" name="sStatus"
										 value="">
											<option value="1">待审核</option>
											<option value="2">审核通过</option>
											<option value="3">审核不通过</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label  class="col-sm-3 control-label">年级：</label>
								<div class="col-sm-6">
									<select
										class="form-control" id="sGrade" name="sGrade"
										 value="">
											<option value="2014">14级</option>
											<option value="2015">15级</option>
											<option value="2016">16级</option>
									</select>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="submit" class="btn btn-primary" onclick="addInfo()">提交</button>
					</div>
				</div>
			</div>
		</div>
		<!-- 修改模态框end -->
			<!-- END MAIN -->
			<div class="clearfix"></div>
		</div>
		<!-- END WRAPPER -->
		<script src="../js/recruitmsFuncJs/initialTool.js"></script>
		<script type="text/javascript">
		function refresh(){
		    window.location.reload();//刷新当前页面.
		     
		    //或者下方刷新方法
		    //parent.location.reload()刷新父亲对象（用于框架）--需在iframe框架内使用
		    // opener.location.reload()刷新父窗口对象（用于单开窗口
		  //top.location.reload()刷新最顶端对象（用于多开窗口）
		}
			var DataDeal = {
				//将从form中通过$('#refer').serialize()获取的值转成json
				formToJson : function(data) {
					data = data.replace(/&/g, "\",\"");
					data = data.replace(/=/g, "\":\"");
					data = "{\"" + data + "\"}";
					return data;
				}
			};
			$(document)
					.ready(
							function() {
								/*-----------------------------------/
								/*	initial index 初始化界面
								/*----------------------------------*/

								$
										.ajax({
											type : "get",
											url : "/recruitms/admin/listDepartments?pageIndex=1&pageSize=32&sDeptCode&sShortName&sFullName&sRegion&dbEnrolScore",
											dataType : 'json',
											async : true,
											success : function(resp) {
												if (resp.code != 0) {
													//将token存在本地存储，然后跳转到主页面
													alert("系统初始化院系专业失败！");
												}
											}
										});

								$.ajax({
											type : "get",
											url : "/recruitms/admin/listRecruitInfos?pageIndex=1&pageSize=8&sStudentNo&sStudentName&sAdmitedMajor&sGrade&sPayFlag&sStatus",
											dataType : 'json',
											async : true,
											success : function(resp) {
												if (resp.code == 0) {
													//将token存在本地存储，然后跳转到主页面
													
												}
											}
										});
							})

			function addInfo() {
				var dataCollect = $('#form').serialize();
				dataCollect = decodeURIComponent(dataCollect, true);//防止中文乱码
				var jsondata = DataDeal.formToJson(dataCollect);//转化为json
				$.ajax({
					//几个参数需要注意一下
					type : "POST",//方法类型
					url : "/recruitms/admin/recruitInfo",//url
					data : jsondata,
					headers : {
						"content-Type" : "application/json",
					},
					success : function(result) {
						console.log(result);//打印服务端返回的数据(调试用)
						window.location.reload() = "recruitInfoList.jsp";
					},
					error : function() {
						alert("异常！");
					}
				});
			}
			$(function () { $("[data-toggle='tooltip']").tooltip(); });
			$('#editModal').on('show.bs.modal', function (event) {
				  var button = $(event.relatedTarget) // Button that triggered the modal
				  var recipient = button.data('whatever') // Extract info from data-* attributes
				  var modal = $(this)
				  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
				  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
				  $.ajax({
						//几个参数需要注意一下
						type : "GET",//方法类型
						url : "/recruitms/admin/recruitInfo/"+recipient,
						dataType:"json",
						async : true,
						success : function(result) {
							console.log(result);//打印服务端返回的数据(调试用)
							modal.find('#nStudentId1').val(result.data.nStudentId);
							modal.find('#sStudentNo1').val(result.data.sStudentNo);
							modal.find('#sStudentName1').val(result.data.sStudentName);
							modal.find('#nAge1').val(result.data.nAge);
							modal.find('#cSex1').val(result.data.cSex);
							modal.find('#sAddress1').val(result.data.sAddress);
							modal.find('#sContact1').val(result.data.sContact);
							modal.find('#sPolitiis1').val(result.data.sPolitiis);
							modal.find('#sAdmitedMajor1').val(result.data.sAdmitedMajor);
							modal.find('#sPayFlag1').val(result.data.sPayFlag);
							modal.find('#sGrade1').val(result.data.sGrade);
						},
						error : function() {
							alert("获取新生信息失败！");
						}
					});
				})
			function updateInfo() {
				var dataCollect = $('#form1').serialize();
				dataCollect = decodeURIComponent(dataCollect, true);//防止中文乱码
				var jsondata = DataDeal.formToJson(dataCollect);//转化为json
				$.ajax({

					//几个参数需要注意一下
					type : "POST",//方法类型
					url : "/recruitms/admin/updateRecruitInfo",//url
					data : jsondata,
					headers : {
						"content-Type" : "application/json",
					},
					success : function(result) {
						console.log(result);//打印服务端返回的数据(调试用)
						window.location.reload() = "recruitInfoList.jsp";
					},
					error : function() {
						alert("修改基础信息失败，该学生未被审核，不允许缴费！");
					}
				});
			}
		</script>
		<script type="text/javascript">
			$("#loginout").on("click", function() {
				localStorage.removeItem("token");
				location.href = "login.jsp";
			});
		</script>
</body>

</html>
