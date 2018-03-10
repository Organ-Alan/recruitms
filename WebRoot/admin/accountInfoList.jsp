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
								<!-- BASIC TABLE -->
							<div class="panel">
								<div class="panel-heading">
									<h3 class="panel-title"><span class="glyphicon glyphicon-user"></span>&nbsp;  账号管理</h3>
								</div>
								<div class="panel-body">
									<form action="/recruitms/admin/listAcnInfos" method="get">
										<div>
											<input type="hidden" id="pageIndex" name="pageIndex" value="1" /> 
											<input type="hidden" id="pageSize" name="pageSize" value="6" />
											<label class="form-inline">账号：
												<input type="text" class="form-control" name="sUsername"
												style="width: 120px" />
											</label>
											<label class="form-inline" style="margin-left: 10px;">账号类型：
												<select  name="sUserType" class="form-control" style="width: 90px">
													<option value="">全部</option>
													<option value="3">院招生办</option>
													<option value="2">系招生办</option>
													<option value="1">学生</option>
												</select>
											</label>
											<label class="form-inline" style="margin-left: 10px;">
												<button class="btn btn-primary" type="submit" style="text-align: center;align-content: right;">查询</button>
											</label>
										</div>
										<hr>
										<div align="left">
											<label class="form-inline">
												<button class="btn btn-primary" type="button" id="" data-toggle="modal" data-target="#addModal" data-whatever="">新建</button>
											</label>
										</div>
									</form>

									<table class="table">
										<thead>
											<tr>
												
												<th style="text-align: center;">账号ID</th>
												<th  style="text-align: center;">账号</th>
												<th  style="text-align: center;">账号类型</th>
												<th  style="text-align: center;">注册时间</th>
												<th  style="text-align: center;">操作</th>
											</tr>
										</thead>
										<tbody>
										<tr>
												<td><input type="hidden" id="initialPage" /></td>
											</tr>
											<c:forEach items="${listAcnInfos.list}" var="account">
												<tr>
													<td style="text-align: center;">${account.sUserNo}</td>
													<td style="text-align: center;">${account.sUsername}</td>
													<td style="text-align: center;">
														<c:if test="${account.sUserType ==1}">学生</c:if>
														<c:if test="${account.sUserType ==2}">系招生办</c:if>
														<c:if test="${account.sUserType ==3}">院招生办</c:if>
													</td>
													<td style="text-align: center;">${account.dRgTime}</td>
													<td  style="text-align: center;">
													<button type="button" class="btn btn-primary btn-xs"  id="" data-toggle="modal" data-target="#editModal" data-whatever="${account.nAcnNo}">修改</button>
													<button type="button" class="btn btn-danger btn-xs" style="margin-left: 5px;" data-toggle="modal" data-target="#delModal" data-whatever="${account.nAcnNo}">删除</button>
												</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<div class="panel-footer" align="right">
									<div class="row">
										<!-- 分页文字信息 ：拿到控制器处理请求时封装在listAcnInfos里面的分页信息-->
										<div class="col-md-6" align="left">
											当前${listAcnInfos.pageNum}页,共${listAcnInfos.pages }页,总${listAcnInfos.total }条记录
										</div>
										<!-- 分页码 -->
										<div class="col-md-6">
											<nav aria-label="Page navigation">
											<ul class="pagination">
												<!-- 
							                        1.pageContext.request.contextPath表示当前项目路径，采用的是绝对路径表达方式。一般为http:localhost:8080/项目名 。
							                        2.首页，末页的逻辑：pn=1访问第一次，pn=${listAcnInfos.pages}访问最后一页
							                      -->
												<li><a
													href="/recruitms/admin/listAcnInfos?pageIndex=1&pageSize=6&sUsername&sUserType">首页</a>
												</li>
												<!-- 如果还有前页就访问当前页码-1的页面， -->
												<c:if test="${listAcnInfos.hasPreviousPage}">
													<li><a
														href="/recruitms/admin/listAcnInfos?pageIndex=${listAcnInfos.pageNum-1}&pageSize=6&sUsername&sUserType"
														aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
													</a></li>
												</c:if>
												<li>
													<!--遍历所有导航页码，如果遍历的页码页当前页码相等就高亮显示，如果相等就普通显示  --> <c:forEach
														items="${listAcnInfos.navigatepageNums }" var="page_Nums">
														<c:if test="${page_Nums==listAcnInfos.pageNum }">
															<li class="active"><a href="#">${page_Nums}</a></li>
														</c:if>
														<c:if test="${page_Nums!=listAcnInfos.pageNum }">
															<li><a
																href="/recruitms/admin/listAcnInfos?pageIndex=${page_Nums}&pageSize=6&sUsername&sUserType">${page_Nums}</a></li>
														</c:if>
													</c:forEach>
												</li>
												<!-- 如果还有后页就访问当前页码+1的页面， -->
												<c:if test="${listAcnInfos.hasNextPage}">
													<li><a
														href="/recruitms/admin/listAcnInfos?pageIndex=${listAcnInfos.pageNum+1}&pageSize=6&sUsername&sUserType"
														aria-label="Next"> <span aria-hidden="true">&raquo;</span>
													</a></li>
												</c:if>
												<li><a
													href="/recruitms/admin/listAcnInfos?pageIndex=${listAcnInfos.pages}&pageSize=6&sUsername&sUserType">末页</a></li>
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
		<!-- 添加模态框 begin-->
		<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="exampleModalLabel">新建账号</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal" id="form">
							<div class="form-group">
								<label  class="col-sm-3 control-label">账号ID：</label>
								<div class="col-sm-6">
									<input type="hidden" id="nAcnNo" name="nAcnNo" value=""/>
									<input type="text" class="form-control" id="sUserNo" name="sUserNo" placeholder="请输入账号ID">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-sm-3 control-label">账号：</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="sUsername" name="sUsername" placeholder="请输入账号">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-sm-3 control-label">口令：</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="sPassword" name=""sPassword"" placeholder="请输入口令">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-sm-3 control-label">账号类型：</label>
								<div class="col-sm-5">
									<select class="form-control" id="sUserType" name="sUserType">
										<option value="3">院招生办</option>
										<option value="2">系招生办</option>
										<option value="1">学生</option>
									</select>
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
		<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="exampleModalLabel">修改账号信息</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal" id="form1">
							<div class="form-group">
								<label  class="col-sm-3 control-label">账号：</label>
								<div class="col-sm-6">
								<input type="hidden" id="nAcnNo1" name="nAcnNo" placeholder="请输入账号">	
									<input type="text" class="form-control" id="sUsername1" name="sUsername" placeholder="请输入账号">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-sm-3 control-label">口令：</label>
								<div class="col-sm-6">
									<input type="password" class="form-control" id="sPassword1" name="sPassword" placeholder="请输入口令">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-sm-3 control-label">账号类型：</label>
								<div class="col-sm-5">
									<select class="form-control" id="sUserType1" name="sUserType">
										<option value="">全部</option>
													<option value="2">系招生办</option>
													<option value="3">院招生办</option>
													<option value="1">学生</option>
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
			<!-- END MAIN -->
			<div class="clearfix"></div>
		</div>
		<!-- END WRAPPER -->
		<!-- Javascript -->
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
								$.ajax({
									type : "get",
									url : "/recruitms/admin/listAcnInfos?pageIndex=1&pageSize=6&sUsername&sUserType",
									dataType : 'json',
									async : true,
									success : function(resp) {
										if (resp.code != 0) {
											//将token存在本地存储，然后跳转到主页面
											alert("系统初始化失败！");
										}
									}
								});
							})
							
			$(function () { $("[data-toggle='tooltip']").tooltip(); });
			$('#delModal').on('show.bs.modal', function(event) {
				var button = $(event.relatedTarget) // Button that triggered the modal
				var recipient = button.data('whatever') // Extract info from data-* attributes
				// If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
				// Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
				//var url = "/recruitms/admin/RevisonreviewRecruitInfo?nStudentId=["+recipient+"]";
				$("#delId").val(recipient);
			})
			$('#editModal').on('show.bs.modal', function (event) {
				  var button = $(event.relatedTarget) // Button that triggered the modal
				  var recipient = button.data('whatever') // Extract info from data-* attributes
				  var modal = $(this)
				  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
				  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
				  $.ajax({
						//几个参数需要注意一下
						type : "GET",//方法类型
						url : "/recruitms/admin/account/"+recipient,
						dataType:"json",
						async : true,
						success : function(result) {
							console.log(result);//打印服务端返回的数据(调试用)
							modal.find('#nAcnNo1').val(result.data.nAcnNo);
							modal.find('#sUsername1').val(result.data.sUsername);
							modal.find('#sPassword1').val(result.data.sPassword);
							modal.find('#sUserType1').val(result.data.sUserType);
						},
						error : function() {
							alert("获取考生信息失败！");
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
					url : "/recruitms/admin/updateAccount",//url
					data : jsondata,
					headers : {
						"content-Type" : "application/json",
					},
					success : function(result) {
						console.log(result);//打印服务端返回的数据(调试用)
						window.location.reload() = "accountInfoList.jsp";
					},
					error : function() {
						
					}
				});
			}
			function delInfo() {
				var delId = $('#delId').val();
				$.ajax({
					//几个参数需要注意一下
					type : "POST",//方法类型
					url : "/recruitms/admin/delScoreInfo",//url
					data : {
						nAcnNo :delId
					},
					success : function(result) {
						console.log(result);//打印服务端返回的数据(调试用)
						window.location.reload() = "accountInfoList.jsp";
					},
					error : function() {
						alert("删除失败！");
					}
				});
			}
		</script>
		<script type="text/javascript">
			function addInfo() {
				var dataCollect = $('#form').serialize();
				dataCollect = decodeURIComponent(dataCollect, true);//防止中文乱码
				var jsondata = DataDeal.formToJson(dataCollect);//转化为json
				$.ajax({
					//几个参数需要注意一下
					type : "POST",//方法类型
					url : "/recruitms/admin/account",//url
					data : jsondata,
					headers : {
						"content-Type" : "application/json",
					},
					success : function(result) {
						console.log(result);//打印服务端返回的数据(调试用)
						window.location.reload() = "accountInfoList.jsp";
					},
					error : function() {
						alert("新增失败！！");
					}
				});
				
			}
	    </script>
</body>

</html>
