<%@page import="jdk.internal.org.objectweb.asm.tree.analysis.Value"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/chartist-custom.css">
<!-- MAIN CSS -->
<link rel="stylesheet" href="css/main.css">
<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
<!-- GOOGLE FONTS -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700"
	rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.3.1.min.js">
	function Help() {
		alert("无任何帮助。。。")
		location.href = "NewFile.jsp";
	}
</script>
</head>
<body>
	<a href="queryallstudent">查询全部学生信息</a>
	<a href="Student/querystudentbyid.jsp">查询某个学生的信息</a>
	<a href="Student/AddStudent.jsp">增加某个学生的信息</a>
	<div id="wrapper">
		<!-- NAVBAR -->
		<nav class="navbar navbar-default navbar-fixed-top">
		<h1 style="text-align: center">欢迎来到学生选课系统</h1>
		</nav>
		<!-- END NAVBAR -->
		<!-- LEFT SIDEBAR -->
		<div id="sidebar-nav" class="sidebar">
			<div class="sidebar-scroll">
				<nav>
				<ul class="nav">
					<li><a href="NewFile.jsp" class="active"> <span>首页</span></a></li>
					<li><a
						href="QueryStudentByIdServlet?StudentNum=<%=(String) session.getAttribute("logname")%>"
						class=""> <span>个人信息查询</span></a></li>
					<li><a
						href="PreUpdateStudentServlet?StudentNum=<%=(String) session.getAttribute("logname")%>"
						class=""><span>个人基本信息修改</span></a></li>
					<li><a
						href="QueryAllCourseServlet?StudentNum=<%=(String) session.getAttribute("logname")%>"
						class=""> <span>学期选课</span></a></li>
					<li><a
						href="QueryAllStuCourseServlt?StudentNum=<%=(String) session.getAttribute("logname")%>"
						class=""> <span>历年成绩查询</span></a></li>
					<li><a
						href="QueryAllStuCourseServlt?StudentNum=<%=(String) session.getAttribute("logname")%>"
						class=""><span>学期修读课程查询</span></a></li>

					<li><a href="javascript:Help()" class=""> <span>使用帮助</span></a></li>
					<li><a href="javascript:Help()" class=""> <span>新系统测试</span></a></li>
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
					<div>

						<img height="500px" width="1000px" src="img/demo-1-bg.jpg">
						<div class="panel-body">
							<div class="row">
								<!-- 面板，代码放在这个里面 -->
								<div class="col-md-3"></div>
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
</body>
</html>