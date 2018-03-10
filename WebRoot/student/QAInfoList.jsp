
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
</head>

<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<!-- NAVBAR -->
		<nav class="navbar navbar-default navbar-fixed-top">
		<div class="brand">
			<a href="index.jsp"><img src="../images/logo/logo5.jpg"
				alt="Klorofil Logo" height="30px" width="130px" class="img-responsive logo"></a>
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
							class="img-circle" alt=""> <span id="username"></span> <i
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
					<div class="row">
						<div class="col-md-12">
							<!-- BASIC TABLE -->
							<div class="panel">
								<div class="panel-heading">
									<h3 class="panel-title">
										<span class="glyphicon glyphicon-pencil"></span>&nbsp; 答疑列表
									</h3>
								</div>
								<div class="panel-body">
									<form action="/recruitms/student/listQAInfos" method="get">
										<div>
											<input type="hidden" id="pageIndex" name="pageIndex"
												value="1" /> <input type="hidden" id="pageSize"
												name="pageSize" value="8" /> <label class="form-inline">问题搜索：
												<input type="text" class="form-control" id="sQuestion"
												name="sQuestion" style="width: 120px" />
											</label><label class="form-inline" style="margin-left: 10px;">
												<button class="btn btn-primary" type="submit"
													style="text-align: center; align-content: right;">查询</button>
											</label>
										</div>
										<hr>
									</form>

									<table class="table" style="table-layout: fixed;">
										<thead>
											<tr>
												<!-- <th><input id="checkboxAll" type="checkbox"></th> -->
												<th class="col-md-1" style="text-align: center;">序号</th>
												<th class="col-md-3" style="text-align: center;">问题</th>
												<th class="col-md-3" style="text-align: center;">答案</th>
												<th class="col-md-2" style="text-align: center;">备注</th>
												<th class="col-md-1" style="text-align: center;">创建者</th>
												<th class="col-md-2" style="text-align: center;">操作</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td><input type="hidden" id="initialPage" /></td>
											</tr>
											<c:forEach items="${listQAInfos.list}" var="QAInfo">
												<tr>
													<td>${QAInfo.sSortNo}</td>
													<td>${QAInfo.sQuestion}</td>
													<td style="white-space: nowrap; overflow: hidden; text-overflow: ellipsis"
														data-toggle="tooltip" data-placement="right"
														title="${QAInfo.sAnswer}">${QAInfo.sAnswer}</td>
													<td>${QAInfo.sRemark}</td>
													<td>${QAInfo.sCreator}</td>
													<td style="text-align: center;">
														<button type="button" class="btn btn-primary btn-xs" id=""
															data-toggle="modal" data-target="#editModal"
															data-whatever="${QAInfo.nQaId}">详情</button>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<div class="panel-footer" align="right">
									<div class="row">
										<!-- 分页文字信息 ：拿到控制器处理请求时封装在listQAInfos里面的分页信息-->
										<div class="col-md-6" align="left">
											当前${listQAInfos.pageNum}页,共${listQAInfos.pages }页,总${listQAInfos.total }条记录
										</div>
										<!-- 分页码 -->
										<div class="col-md-6">
											<nav aria-label="Page navigation">
											<ul class="pagination">
												<!-- 
								                        1.pageContext.request.contextPath表示当前项目路径，采用的是绝对路径表达方式。一般为http:localhost:8080/项目名 。
								                        2.首页，末页的逻辑：pn=1访问第一次，pn=${listQAInfos.pages}访问最后一页
								                      -->
												<li><a
													href="/recruitms/student/listQAInfos?pageIndex=1&pageSize=8&sQuestion">首页</a>
												</li>
												<!-- 如果还有前页就访问当前页码-1的页面， -->
												<c:if test="${listQAInfos.hasPreviousPage}">
													<li><a
														href="/recruitms/student/listQAInfos?pageIndex=${page_Nums}&pageSize=${listQAInfos.pageNum-1}&sDeptCode&sShortName&sFullName&sRegion&dbEnrolScore"
														aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
													</a></li>
												</c:if>
												<li>
													<!--遍历所有导航页码，如果遍历的页码页当前页码相等就高亮显示，如果相等就普通显示  --> <c:forEach
														items="${listQAInfos.navigatepageNums }" var="page_Nums">
														<c:if test="${page_Nums==listQAInfos.pageNum }">
															<li class="active"><a href="#">${page_Nums}</a></li>
														</c:if>
														<c:if test="${page_Nums!=listQAInfos.pageNum }">
															<li><a
																href="/recruitms/student/listQAInfos?pageIndex=${page_Nums}&pageSize=8&sQuestion">${page_Nums}</a></li>
														</c:if>
													</c:forEach>
												</li>
												<!-- 如果还有后页就访问当前页码+1的页面， -->
												<c:if test="${listQAInfos.hasNextPage}">
													<li><a
														href="/recruitms/student/listQAInfos?pageIndex=${listQAInfos.pageNum+1}&pageSize=8&sQuestion"
														aria-label="Next"> <span aria-hidden="true">&raquo;</span>
													</a></li>
												</c:if>
												<li><a
													href="/recruitms/student/listQAInfos?pageIndex=${listQAInfos.pages}&pageSize=8&sQuestion">末页</a></li>
											</ul>
											</nav>
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
						<h4 class="modal-title" id="exampleModalLabel">查看问题信息</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">
								<h4 style="color: #4876FF;">
									<span class="glyphicon glyphicon-search"></span> <strong>&nbsp;
									</strong>
								</h4>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12" id="answer"></div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					</div>
				</div>
			</div>
		</div>

		<!-- 修改模态框end -->
		<div class="clearfix"></div>
	</div>
	<!-- END WRAPPER -->

	<script>
		$(document)
				.ready(
						function() {
							var username = localStorage.getItem("username");
							$('#username').text(username);
							/*-----------------------------------/
							/*	initial index 初始化界面
							/*----------------------------------*/

							$
									.ajax({
										type : "get",
										url : "/recruitms/student/listQAInfos?pageIndex=1&pageSize=8&sQuestion",
										dataType : 'json',
										async : true,
										success : function(resp) {
											if (resp.code != 0) {
												//将token存在本地存储，然后跳转到主页面
												alert("系统初始化热门问题列表失败！");
											}
										}
									});
						})
		$('#editModal').on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget) // Button that triggered the modal
			var recipient = button.data('whatever') // Extract info from data-* attributes
			var modal = $(this)
			// If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
			// Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
			$.ajax({
				//几个参数需要注意一下
				type : "GET",//方法类型
				url : "/recruitms/student/qaInfo/" + recipient,
				dataType : "json",
				async : true,
				success : function(result) {
					console.log(result);//打印服务端返回的数据(调试用)
					modal.find('strong').html(result.data.sQuestion);
					modal.find('#answer').html(result.data.sAnswer);
				},
				error : function() {
					alert("获取答疑信息失败！");
				}
			});
		})
	</script>
	<script type="text/javascript">
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
