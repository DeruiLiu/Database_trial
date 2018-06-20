<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="css/component.css" />
<!--[if IE]>
<script src="js/html5.js"></script>
<![endif]-->
<script type="text/javascript">
	function Login() {
		var logname = document.getElementById("logname").value;
		var logpass = document.getElementById("logpass").value;
		location.href = "Login?logname=" + logname + "&logpass=" + logpass;
	}
</script>
</head>
<body>
	<div class="container demo-1">
		<div class="content">
			<div id="large-header" class="large-header">
				<canvas id="demo-canvas"></canvas>
				<div class="logo_box">
					<h3>欢迎</h3>
					<form action="Login" name="f" method="post">
						<div class="input_outer">
							<span class="u_user"></span> <input id="logname" class="text"
								style="color: #FFFFFF !important" type="text"
								placeholder="请输入账户">
						</div>
						<div class="input_outer">
							<span class="us_uer"></span> <input id="logpass" class="text"
								style="color: #FFFFFF !important; position: absolute; z-index: 100;"
								type="password" placeholder="请输入密码">
						</div>
						<div class="mb2">
							<a class="act-but submit" href="javascript:Login()"
								style="color: #FFFFFF">登录</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- /container -->
	<script src="js/TweenLite.min.js"></script>
	<script src="js/EasePack.min.js"></script>
	<script src="js/rAF.js"></script>
	<script src="js/demo-1.js"></script>
	<div style="text-align: center;"></div>
</body>
</html>