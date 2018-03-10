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
									<h3 class="panel-title">录取通知书管理列表</h3>
								</div>
								<div class="panel-body">
									<form action="/recruitms/admin/listStudentInfos" method="get">
										<div>
											<input type="hidden" id="pageIndex" name="pageIndex"
												value="1" /> <input type="hidden" id="pageSize"
												name="pageSize" value="10" /> <label class="form-inline">准考证：<input
												type="text" class="form-control" id="sCandidateNum"
												name="sCandidateNum" style="width: 120px" /></label> <label
												class="form-inline">学生姓名：<input type="text"
												class="form-control" id="sStudentName" name="sStudentName"
												style="width: 100px" /></label> <label class="form-inline">志愿专业：<select
												id="sEnrolMajor" name="sEnrolMajor" class="form-control"
												style="width: 90px">
													<option value="">全部</option>
													<c:forEach items="${departmentListDic.list}" var="deptInfo">
														<option value="${deptInfo.sDeptCode} ">${deptInfo.sFullName}</option>
													</c:forEach>

											</select></label> <label class="form-inline">是否已发放:<select
												id="sDataFlag" name="sDataFlag" class="form-control"
												style="width: 80px">
													<option value="">全部</option>
													<option value="1">未发放</option>
													<option value="2">已发放</option>
											</select></label>
										</div>
										<hr>
										<div align="left">
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
												<th><input id="checkboxAll" type="checkbox"></th>
												<th>准考证</th>
												<th>姓名</th>
												<th>年龄</th>
												<th>报考专业</th>
												<th>通讯地址</th>
												<th>联系方式</th>
												<th>是否已发放</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td><input type="hidden" id="initialPage" /></td>
											</tr>
											<c:forEach items="${studentInfoList.list}" var="studentInfo">
												<tr>
													<td><input id="checkBox" type="checkbox" name="che" /></td>
													<td><a data-toggle="modal" data-target="#myModal">${studentInfo.sCandidateNum}</a></td>
													<td>${studentInfo.sStudentName}</td>
													<td>${studentInfo.nAge}</td>
													<td>${studentInfo.sEnrolMajor}</td>
													<td>${studentInfo.sAddress}</td>
													<td>${studentInfo.sContact}</td>
													<td>
														<c:if test="${studentInfo.sDataFlag ==1}">已发放</c:if>
														<c:if test="${studentInfo.sDataFlag ==2}">未发放</c:if>
													</td>
													<td  style="text-align: center;">
													<c:if test="${studentInfo.sDataFlag ==2}">
													<button type="button" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#sendNoticeFile" data-whatever="${studentInfo.nStudentId}">发放通知书</button>
													</c:if>
												</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<div class="panel-footer" align="right">
									<div class="row">
										<!-- 分页文字信息 ：拿到控制器处理请求时封装在studentInfoList里面的分页信息-->
										<div class="col-md-6" align="left">
											当前${studentInfoList.pageNum}页,共${studentInfoList.pages }页,总${studentInfoList.total }条记录
										</div>
										<!-- 分页码 -->
										<div class="col-md-6">
											<nav aria-label="Page navigation">
											<ul class="pagination">
												<!-- 
							                        1.pageContext.request.contextPath表示当前项目路径，采用的是绝对路径表达方式。一般为http:localhost:8080/项目名 。
							                        2.首页，末页的逻辑：pn=1访问第一次，pn=${studentInfoList.pages}访问最后一页
							                      -->
												<li><a
													href="/recruitms/admin/listStudentInfos?pageIndex=1&pageSize=8&sCandidateNum&sStudentName&sNativePlace&sEnrolMajor&sDataFlag">首页</a>
												</li>
												<!-- 如果还有前页就访问当前页码-1的页面， -->
												<c:if test="${studentInfoList.hasPreviousPage}">
													<li><a
														href="/recruitms/admin/listStudentInfos?pageIndex=${studentInfoList.pageNum-1}&pageSize=8&sCandidateNum&sStudentName&sNativePlace&sEnrolMajor&sDataFlag"
														aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
													</a></li>
												</c:if>
												<li>
													<!--遍历所有导航页码，如果遍历的页码页当前页码相等就高亮显示，如果相等就普通显示  --> <c:forEach
														items="${studentInfoList.navigatepageNums }" var="page_Nums">
														<c:if test="${page_Nums==studentInfoList.pageNum }">
															<li class="active"><a href="#">${page_Nums}</a></li>
														</c:if>
														<c:if test="${page_Nums!=studentInfoList.pageNum }">
															<li><a
																href="/recruitms/admin/listStudentInfos?pageIndex=${page_Nums}&pageSize=8&sCandidateNum&sStudentName&sNativePlace&sEnrolMajor&sDataFlag">${page_Nums}</a></li>
														</c:if>
													</c:forEach>
												</li>
												<!-- 如果还有后页就访问当前页码+1的页面， -->
												<c:if test="${studentInfoList.hasNextPage}">
													<li><a
														href="/recruitms/admin/listStudentInfos?pageIndex=${studentInfoList.pageNum+1}&pageSize=8&sCandidateNum&sStudentName&sNativePlace&sEnrolMajor&sDataFlag"
														aria-label="Next"> <span aria-hidden="true">&raquo;</span>
													</a></li>
												</c:if>
												<li><a
													href="/recruitms/admin/listStudentInfos?pageIndex=${studentInfoList.pages}&pageSize=8&sCandidateNum&sStudentName&sNativePlace&sEnrolMajor&sDataFlag">末页</a></li>
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
			<!-- 审核通过模态框 begin-->
			<div class="modal fade" id="sendNoticeFile" tabindex="-1" role="dialog"
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
								<input type="hidden" id="studentFileId">
								<div class="col-md-6" align="center">你确定发放通知吗？</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">取消</button>
							<button type="button" class="btn btn-primary" onclick="send()">确定</button>
						</div>
					</div>
				</div>
			</div>
			<!-- 审核通过模态框end -->
			<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">新生详细信息</h4>
						</div>
						<div class="modal-body">
							<form id="form1" action="##" method="" onsubmit="return false">
								<div>
								<input type="hidden" id="nStudentId1" name="nStudentId" value=""/>
									<label class="form-inline">学&emsp;&emsp;号：<input
										type="text" class="form-control" id="sStudentNo1"
										name="sStudentNo" value=""
										style="width: 180px" value="" /></label> <label class="form-inline">学生姓名：<input
										type="text" class="form-control" id="sStudentName1"
										name="sStudentName" style="width: 180px"
										value="" /></label>
								</div>
								<div>
									<label class="form-inline"> 年龄：<input type="text"
										class="form-control" id="nAge1" name="nAge"
										style="width: 180px" value="" data-toggle="tooltip"  title="请输入正整数！" /></label> <label
										class="form-inline">性别：<input type="text"
										class="form-control" id="1cSex" name="cSex"
										style="width: 180px" /></label>
								</div>
								<div>
									<label class="form-inline">通讯地址<input type="text"
										class="form-control" id="sAddress1" name="sAddress"
										style="width: 180px" value="" /></label>
									<label class="form-inline">联系方式<input type="text"
										class="form-control" id="sContact1" name="sContact"
										style="width: 180px" value="" /></label>
								</div>
								<div>
									<label class="form-inline">家属联系方式<input type="text"
										class="form-control" id="sOtherCtact1" name="sOtherCtact"
										style="width: 180px" value="" /></label>
									<label class="form-inline">政治面貌<input type="text"
										class="form-control" id="sPolitiis1" name="sPolitiis"
										style="width: 180px" /></label>
								</div>
								<div>
									<label class="form-inline">录取专业：<select
										id="sAdmitedMajor1" name="sAdmitedMajor" class="form-control"
										style="width: 200px"
										value="">
											<c:forEach items="${departmentListDic.list}" var="deptInfo">
												<option value="${deptInfo.sDeptCode}">${deptInfo.sFullName}</option>
											</c:forEach>

									</select></label> <label class="form-inline">是否已已发放:<select
										id="sPayFlag1" name="sPayFlag" class="form-control"
										style="width: 80px" value="">
											<option value="">全部</option>
											<option value="0">未缴费</option>
											<option value="1">已缴费</option>
											<option value="2">已缴部分费用</option>
									</select></label>
								</div>
								<div>
									<label class="form-inline">审核状态:<select
										class="form-control" id="sStatus1" name="sStatus"
										style="width: 100px" value="">
											<option value="1">待审核</option>
											<option value="2">审核通过</option>
											<option value="3">审核不通过</option>
									</select></label> <label class="form-inline">年级:<select
										class="form-control" id="sGrade1" name="sGrade"
										style="width: 70px" value="">
											<option value="2014">14级</option>
											<option value="2015">15级</option>
											<option value="2016">16级</option>
									</select></label>

								</div>
								<hr>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">关闭</button>
									<button type="submit" onclick="updateInfo()"
										class="btn btn-primary">提交更改</button>
								</div>
							</form>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			
			<!-- END MAIN -->
			<div class="clearfix"></div>
		</div>
		<!-- END WRAPPER -->
		<script src="../js/recruitmsFuncJs/initialTool.js"></script>
		<script type="text/javascript">
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
											url : "/recruitms/admin/listStudentInfos?pageIndex=1&pageSize=8&sCandidateNum&sStudentName&sNativePlace&sEnrolMajor&sDataFlag",
											dataType : 'json',
											async : true,
											success : function(resp) {
												if (resp.code != 0) {
													//将token存在本地存储，然后跳转到主页面
													alert("系统学习失败！");
												}
											}
										});
							})

			$('#').on('show.bs.modal', function(event) {
				var button = $(event.relatedTarget) // Button that triggered the modal
				var recipient = button.data('whatever') // Extract info from data-* attributes
				// If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
				// Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
				//var url = "/recruitms/admin/RevisonreviewRecruitInfo?nStudentId=["+recipient+"]";
				$("#studentFileId").val(recipient);
			})
			function send() {
				var studentFileId= $("#studentFileId").val();
				$.ajax({
					//几个参数需要注意一下
					type : "POST",//方法类型
					url : "/recruitms/admin/sendNoticeFile",//url
					data:{
						nStudentId:studentFileId
					},
					success : function(result) {
						console.log(result);//打印服务端返回的数据(调试用)
						location.reload() = "enrollmentNotice.jsp";
					},
					error : function() {
						alert("已经发送过通知书，请确认！");
					}
				});
			}
			/*  function addInfo() {
			     var form = document.forms[1];
			     form.action = "/recruitms/admin/recruitInfo";
			     form.method = "post";
			     
			     form.submit();
			 } */
		</script>
		<script type="text/javascript">
			$("#loginout").on("click", function() {
				localStorage.removeItem("token");
				location.href = "login.jsp";
			});
		</script>
</body>

</html>
