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
<%-- <script src="../assets/vendor/page/myPage.js" type="text/javascript"></script>
<script src="../assets/vendor/page/jqPaginator.min.js"
	type="text/javascript"></script> --%>
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
				style="width: 100%; height: 100%; overflow: scroll; overflow-y: auto; overflow-x: hidden;">
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
					<div class="row">
						<div class="col-md-12">
							<!-- BASIC TABLE -->
							<div class="panel">
								<div class="panel-heading">
									<h3 class="panel-title">
										<span class="glyphicon glyphicon-bookmark"></span>&nbsp; 招生计划
									</h3>
								</div>
								<div class="panel-body">
									<form action="/recruitms/admin/listDepartments" method="get">
										<div>
											<input type="hidden" id="pageIndex" name="pageIndex"
												value="1" /> <input type="hidden" id="pageSize"
												name="pageSize" value="10" /> <label class="form-inline">专业代码：
												<input type="text" class="form-control" id="sDeptCode"
												name="sDeptCode" style="width: 120px" />
											</label> <label class="form-inline" style="margin-left: 10px;">专业名称：
												<input type="text" class="form-control" id="sShortName"
												name="sShortName" style="width: 120px" />
											</label> <label class="form-inline" style="margin-left: 10px;">
												<button class="btn btn-primary" type="submit"
													style="text-align: center; align-content: right;">查询</button>
											</label>
										</div>
										<hr>
									</form>
									<div align="left">
										<label class="form-inline">
											<button class="btn btn-primary" type="button" id=""
												data-toggle="modal" data-target="#addModal"
												data-whatever="@mdo">新建</button>
										</label> <label class="form-inline" style="margin-left: 10px;">
											<button class="btn btn-primary"
											 type="button" onclick="window.location.href='/recruitms/admin/export/deptInfoList?sDeptCode&sShortName&sFullName&sRegion&dbEnrolScore&nDeptNoList='">导出</button>
										</label>
									</div>
									<table class="table" style="table-layout: fixed;">
										<thead>
											<tr>
												<th class="col-md-1" style="text-align: center;">专业代码</th>
												<th class="col-md-1" style="text-align: center;">专业全称</th>
												<th class="col-md-1" style="text-align: center;">专业简称</th>
												<th class="col-md-1" style="text-align: center;">所属院系</th>
												<th class="col-md-1" style="text-align: center;">学费</th>
												<th class="col-md-1" style="text-align: center;">计划招生人数</th>
												<th class="col-md-1" style="text-align: center;">补录人数</th>
												<th class="col-md-1" style="text-align: center;">备注</th>
												<th class="col-md-3" style="text-align: center;">审核操作</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td><input type="hidden" id="initialPage" /></td>
											</tr>
											<c:forEach items="${departmentListDic.list}" var="deptnfo">
												<tr>
													<td>${deptnfo.sDeptCode}</td>
													<td>${deptnfo.sShortName}</td>
													<td>${deptnfo.sFullName}</td>
													<td><c:if test="${deptnfo.sRegion == 'rjgcx'}">软件工程系</c:if>
														<c:if test="${deptnfo.sRegion == 'wljsx'}">网络技术系</c:if>
														<c:if test="${deptnfo.sRegion == 'dzx'}">电子系</c:if>
														<c:if test="${deptnfo.sRegion == 'Jsjx'}">计算机系</c:if>
														<c:if test="${deptnfo.sRegion == 'yxx'}">游戏系</c:if>
														<c:if test="${deptnfo.sRegion == 'smmtx'}">数码媒体系</c:if>
														<c:if test="${deptnfo.sRegion == 'glx'}">管理系</c:if>
														<c:if test="${deptnfo.sRegion == 'gjjmx'}">国际经贸系</c:if>
														<c:if test="${deptnfo.sRegion == 'ckx'}">财会系</c:if>
														<c:if test="${deptnfo.sRegion == 'wyx'}">外语系</c:if>
													</td>
													<td>${deptnfo.sTuition}</td>
													<td>${deptnfo.nCountEnrol}</td>
													<td>${deptnfo.nCountExtRnrol}</td>
													<td
														style="white-space: nowrap; overflow: hidden; text-overflow: ellipsis"
														data-toggle="tooltip" data-placement="right"
														title="${deptnfo.sRemark}">${deptnfo.sRemark}</td>
													<td style="text-align: center;">
														<button type="button" class="btn btn-primary btn-xs"
															data-whatever="${deptnfo.nDeptNo}"
															class="btn btn-primary" data-toggle="modal"
															data-target="#editModal">修改</button>
														<button type="button" class="btn btn-danger btn-xs"
															data-whatever="${deptnfo.nDeptNo}"
															class="btn btn-primary" data-toggle="modal"
															data-target="#falseModal">删除</button>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<div class="panel-footer" align="right">
									<div class="row">
										<!-- 分页文字信息 ：拿到控制器处理请求时封装在departmentListDic里面的分页信息-->
										<div class="col-md-6" align="left">
											当前${departmentListDic.pageNum}页,共${departmentListDic.pages }页,总${departmentListDic.total }条记录
										</div>
										<!-- 分页码 -->
										<div class="col-md-6">
											<nav aria-label="Page navigation">
											<ul class="pagination">
												<!-- 
							                        1.pageContext.request.contextPath表示当前项目路径，采用的是绝对路径表达方式。一般为http:localhost:8080/项目名 。
							                        2.首页，末页的逻辑：pn=1访问第一次，pn=${departmentListDic.pages}访问最后一页
							                      -->
												<li><a
													href="/recruitms/admin/listDepartments?pageIndex=1&pageSize=8&sDeptCode&sShortName&sFullName&sRegion&dbEnrolScore">首页</a>
												</li>
												<!-- 如果还有前页就访问当前页码-1的页面， -->
												<c:if test="${departmentListDic.hasPreviousPage}">
													<li><a
														href="/recruitms/admin/listDepartments?pageIndex=${departmentListDic.pageNum-1}&pageSize=6&sDeptCode&sShortName&sFullName&sRegion&dbEnrolScore"
														aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
													</a></li>
												</c:if>
												<li>
													<!--遍历所有导航页码，如果遍历的页码页当前页码相等就高亮显示，如果相等就普通显示  --> <c:forEach
														items="${departmentListDic.navigatepageNums }"
														var="page_Nums">
														<c:if test="${page_Nums==departmentListDic.pageNum }">
															<li class="active"><a href="#">${page_Nums}</a></li>
														</c:if>
														<c:if test="${page_Nums!=departmentListDic.pageNum }">
															<li><a
																href="/recruitms/admin/listDepartments?pageIndex=${page_Nums}&pageSize=8&sDeptCode&sShortName&sFullName&sRegion&dbEnrolScore">${page_Nums}</a></li>
														</c:if>
													</c:forEach>
												</li>
												<!-- 如果还有后页就访问当前页码+1的页面， -->
												<c:if test="${departmentListDic.hasNextPage}">
													<li><a
														href="/recruitms/admin/listDepartments?pageIndex=${departmentListDic.pageNum+1}&pageSize=8&sDeptCode&sShortName&sFullName&sRegion&dbEnrolScore"
														aria-label="Next"> <span aria-hidden="true">&raquo;</span>
													</a></li>
												</c:if>
												<li><a
													href="/recruitms/admin/listDepartments?pageIndex=${departmentListDic.pages}&pageSize=8&sDeptCode&sShortName&sFullName&sRegion&dbEnrolScore">末页</a></li>
											</ul>
											</nav>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- END BASIC TABLE -->
					</div>
				</div>

			</div>
		</div>
		<!-- END MAIN CONTENT -->
	</div>

	<!-- 审核通过模态框 begin-->
	<div class="modal fade" id="delModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">温馨提示</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<input type="hidden" id="passId">
						<div class="col-md-6" align="center">你确定删除吗？</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-danger" onclick="del()">确定</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 审核通过模态框end -->
	<!-- 添加模态框 begin-->
	<div class="modal fade" id="addModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">新建招生计划</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="form" action="##" onsubmit="return false" method="post">
						<div class="form-group">
							<label class="col-sm-3 control-label">专业代码：</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="sDeptCode" name="sDeptCode"
									placeholder="请输入专业代码">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">专业全称：</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="sShortName" name="sShortName"
									placeholder="请输入专业全称">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">专业简称：</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="sFullName" name="sFullName"
									placeholder="请输入专业简称">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">所属院系：</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="sRegion" name="sRegion"
									placeholder="请输入所属院系">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">学费：</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="sTuition" name="sTuition"
									placeholder="请输入学费">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">计划招生人数：</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="nCountEnrol" name="nCountEnrol"
									placeholder="请输入计划招生人数">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">补录人数：</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="nCountExtRnrol" name="nCountExtRnrol"
									placeholder="请输入补录人数">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">录取分数：</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="dbEnrolScore" name="dbEnrolScore"
									placeholder="请输入录取分数">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">备注：</label>
							<div class="col-sm-6">
								<textarea class="form-control" rows="2" id="sRemark" name="sRemark"></textarea>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" onclick="addInfo()">提交</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 添加模态框end -->
	<!-- 修改模态框 begin-->
	<div class="modal fade" id="editModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">修改招生计划信息</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="form1" action="##" onsubmit="return false" method="post">
						<div class="form-group">
							<label class="col-sm-3 control-label">专业代码：</label>
							<div class="col-sm-6">
								<input type="hidden" id="nDeptNo1" name="nDeptNo">
								<input type="text" class="form-control" id="sDeptCode1" name="sDeptCode"
									placeholder="请输入专业代码">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">专业全称：</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="sShortName1" name="sShortName"
									placeholder="请输入专业全称">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">专业简称：</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="sFullName1" name="sFullName"
									placeholder="请输入专业简称">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">所属院系：</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="sRegion1" name="sRegion"
									placeholder="请输入所属院系">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">学费：</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="sTuition1" name="sTuition"
									placeholder="请输入学费">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">计划招生人数：</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="nCountEnrol1" name="nCountEnrol"
									placeholder="请输入计划招生人数">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">补录人数：</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="nCountExtRnrol1" name="nCountExtRnrol"
									placeholder="请输入补录人数">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">录取分数：</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="dbEnrolScore1" name="dbEnrolScore"
									placeholder="请输入录取分数">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">备注：</label>
							<div class="col-sm-6">
								<textarea class="form-control" rows="2" id="sRemark1" name="sRemark"></textarea>
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
	<div class="modal fade" id="falseModal" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="exampleModalLabel">温馨提示</h4>
						</div>
						<div class="modal-body">
							<div class="row">
								<input type="hidden" id="delId">
								<div class="col-md-6" align="center">你确定删除吗？</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">取消</button>
							<button type="button" class="btn btn-danger" onclick="delInfo()">删除</button>
						</div>
					</div>
				</div>
			</div>
	<!-- 修改模态框end -->
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
	<script
		src="../assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script
		src="../assets/vendor/jquery.easy-pie-chart/jquery.easypiechart.min.js"></script>
	<script src="../assets/vendor/chartist/js/chartist.min.js"></script>
	<script src="../assets/scripts/klorofil-common.js"></script>
	<script type="text/javascript"></script>
	<script type="text/javascript">
		function refresh() {
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
										url : "/recruitms/admin/listDepartments?pageIndex=1&pageSize=6&sDeptCode&sShortName&sFullName&sRegion&dbEnrolScore",
										dataType : 'json',
										async : true,
										success : function(resp) {
											if (resp.code != 0) {
												//将token存在本地存储，然后跳转到主页面
												alert("系统初始化院系专业失败！");
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
				url : "/recruitms/admin/department",//url
				data : jsondata,
				headers : {
					"content-Type" : "application/json",
				},
				success : function(result) {
					console.log(result);//打印服务端返回的数据(调试用)
					window.location.reload() = "enrollmentPlan.jsp";
				},
				error : function() {
					alert("添加院系专业信息失败！");
				}
			});
		}
		$('#falseModal').on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget) // Button that triggered the modal
			var recipient = button.data('whatever') // Extract info from data-* attributes
			// If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
			// Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
			//var url = "/recruitms/admin/RevisonreviewRecruitInfo?nStudentId=["+recipient+"]";
			$("#delId").val(recipient);
		})
		
		$('#editModal').on(
				'show.bs.modal',
				function(event) {
					var button = $(event.relatedTarget) // Button that triggered the modal
					var recipient = button.data('whatever') // Extract info from data-* attributes
					var modal = $(this)
					// If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
					// Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
					$.ajax({
						//几个参数需要注意一下
						type : "GET",//方法类型
						url : "/recruitms/admin/department/" + recipient,
						dataType : "json",
						async : true,
						success : function(result) {
							console.log(result);//打印服务端返回的数据(调试用)
							//alert(result.data.nDeptNo);
							modal.find('#nDeptNo1').val(
									result.data.nDeptNo);
							modal.find('#sDeptCode1').val(
									result.data.sDeptCode);
							modal.find('#sShortName1').val(
									result.data.sShortName);
							modal.find('#sFullName1').val(
									result.data.sFullName);
							modal.find('#sRegion1').val(result.data.sRegion);
							modal.find('#sTuition1').val(result.data.sTuition);
							modal.find('#nCountEnrol1').val(result.data.nCountEnrol);
							modal.find('#nCountExtRnrol1').val(result.data.nCountExtRnrol);
							modal.find('#dbEnrolScore1').val(
									result.data.dbEnrolScore);
							modal.find('#sRemark1')
									.val(result.data.sRemark);
						},
						error : function() {
							alert("获取院系专业信息失败！");
						}
					});
				})
				
		function delInfo() {
				var delId = $('#delId').val();
				$.ajax({
					//几个参数需要注意一下
					type : "POST",//方法类型
					url : "/recruitms/admin/delDepartment/"+delId,//url
					success : function(result) {
						console.log(result);//打印服务端返回的数据(调试用)
						window.location.reload() = "enrollmentPlan.jsp";
					},
					error : function() {
						alert("删除失败！");
					}
				});
			}
		
		function updateInfo() {
			var dataCollect = $('#form1').serialize();
			dataCollect = decodeURIComponent(dataCollect, true);//防止中文乱码
			var jsondata = DataDeal.formToJson(dataCollect);//转化为json
			//alert(jsondata);
			$.ajax({
				//几个参数需要注意一下
				type : "POST",//方法类型
				url : "/recruitms/admin/deptInfo?sUsername=admin",//url
				data : jsondata,
				headers : {
					"content-Type" : "application/json",
				},
				success : function(result) {
					console.log(result);//打印服务端返回的数据(调试用)
					window.location.reload() = "enrollmentPlan.jsp";
				},
				error : function() {
					alert("请输入正确格式的录取人数及补录人数！");
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

