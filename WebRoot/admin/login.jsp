<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="fullscreen-bg">

<head>
<title>Login | 广州大学华软软件学院招生管理系统</title>
<meta charset="utf-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<!-- VENDOR CSS -->
<link rel="stylesheet" href="../assets/css/bootstrap.min.css">
<link rel="stylesheet"
	href="../assets/vendor/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="../assets/vendor/linearicons/style.css">
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
	href="../assets/img/logo/title-logo.jpg">
<link rel="icon" type="image/png" sizes="96x96"
	href="../assets/img/logo/title-logo.jpg">
</head>

<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<div class="vertical-align-wrap">
			<div class="vertical-align-middle">
				<div class="auth-box ">
					<div class="left">
						<div class="content">
							<div class="header">
								<div class="logo text-center">
									<img src="../assets/img/logo/logo-v2.png" alt="GU Logo">
								</div>
								<p class="lead">Login to your account</p>
							</div>
							<div class="form-group">
								<label for="signin-email" class="control-label sr-only">Username</label>
								<input type="text" class="form-control" id="sUsername"
									name="sUsername" value="admin" placeholder="Username">
							</div>
							<div class="form-group">
								<label for="Password" class="control-label sr-only">Password</label>
								<input type="password" class="form-control" name="sPassword"
									id="sPassword" value="111111" placeholder="Password">
							</div>
							<div class="form-group">
								<label class="control-label sr-only">用户身份</label>
								<select class="form-control" id="sUserType" name="sUserType">
										<option value="1">学生</option>
										<option value="2">系招生办</option>
										<option value="3">院招生办</option>
									</select>
							</div>
							<div class="form-group clearfix">
								<label class="fancy-checkbox element-left"> <input
									type="checkbox"> <span>Remember me</span>
								</label>
							</div>
							<button type="submit" class="btn btn-primary btn-lg btn-block"
								id="login">登录</button>
						</div>
					</div>
					<div class="right">
						<div class="overlay"></div>
						<div class="content text">
							<h1 class="heading">Welcome To The South China Institute of
								Software Engineering.GU</h1>
							<br>
							<p>博学笃行 & 与时俱进</p>
						</div>
					</div>
					<div id="toastr-demo" class="panel">
						<div class="panel-body">
							<p class="demo-button">
								<button type="button" class="btn btn-danger btn-toastr"
									id="checkUsername" data-context="error" data-message="用户名不允许为空"
									data-position="top-center" style="display: none;"></button>
								<button type="button" class="btn btn-danger btn-toastr"
									id="checkPassword" data-context="error" data-message="密码不允许为空"
									data-position="top-center" style="display: none;"></button>
								<button type="button" class="btn btn-danger btn-toastr"
									id="checkLogin" data-context="error"
									data-message="用户名或密码错误，请重新填写！" data-position="top-center"
									style="display: none;"></button>
								<button type="button"
									class="btn btn-default btn-toastr-callback"
									id="toastr-callback1" data-context="info"
									data-message="onShown and onHidden callback demo"
									style="display: none;"></button>
							</p>
							<!-- END CALLBACK -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- END WRAPPER -->

	<script src="../assets/vendor/jquery/jquery.min.js"></script>
	<script src="../assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="../assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script src="../assets/vendor/toastr/toastr.min.js"></script>
	<script src="../assets/scripts/klorofil-common.js"></script>
	<script type="text/javascript" src="../js/jquery-1.9.1.js"></script>
	<script>
		$('#login').on(
				'click',
				function(e) {
					var userName = $.trim($('#sUsername').val());
					var password = $.trim($('#sPassword').val());
					var userID = $.trim($('#sUserType').val());
					//判断用户名是否为空
					if (userName == "") {
						$('#checkUsername').click();
						$('#checkUsername').mouseover();
						return;
					}
					if (password == "") {
						$('#checkPassword').click();
						$('#checkPassword').mouseover();
						return;
					}
					$.ajax({
						type : "post",
						url : "/recruitms/admin/login?sUsername="
								+ userName + "&sPassword=" + password+"&sUserType="+userID,
						/* data : {
							userName : userName,
							password : password
						}, */
						dataType : 'json',
						success : function(resp) {
							
							if (resp.code == 0) {
								if (resp.data.checkRerult == "1") {
									//将token存在本地存储，然后跳转到主页面
									
									localStorage.setItem('token', resp.data.token);
									localStorage.setItem('username',resp.data.UserID)
									location.href = "/recruitms/student/index.jsp";
								}
								if (resp.data.checkRerult == "2") {
									//将token存在本地存储，然后跳转到主页面
									localStorage.setItem('token', resp.data.token);
									location.href = "/recruitms/admin/index.jsp";
								}
							}else{
								$('#checkLogin').click();
								$('#checkLogin').mouseover();
								return;
							}
						}
					});

				})
	</script>
</body>

</html>
