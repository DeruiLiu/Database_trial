<%@page import="com.nuaa.vo.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/chartist-custom.css">
<!-- MAIN CSS -->
<link rel="stylesheet" href="css/main.css">
<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
<!-- GOOGLE FONTS -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700"
	rel="stylesheet">
<title>Insert title here</title>
</head>
<body>

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
					<li><a href="TeacherHome.jsp" class=""> <span>首页</span></a></li>
					<li><a
						href="QueryTeacherByIdServlet?TeacherNum=<%=(String) session.getAttribute("logname")%>"
						class=""> <span>个人信息查询</span></a></li>
					<li><a
						href="PreUpdateTeacherServlet?TeacherNum=<%=(String) session.getAttribute("logname")%>"
						class=""><span>个人基本信息修改</span></a></li>
					<li><a
						href="QueryAllTeacherCourseServlet?TeacherNum=<%=(String) session.getAttribute("logname")%>"
						class=""> <span>查询所授课程信息</span></a></li>
					<li><a
						href="QueryAllStuCourseServltByTeacherNum?TeacherNum=<%=(String) session.getAttribute("logname")%>"
						class=""> <span>查询学生选课信息</span></a></li>
					<li><a href="TeacherDispterServlet" class="active"><span>高级操作</span></a></li>

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
						<table align="center" border="1" class="table">
							<tr>
								<td>学号</td>
								<td>姓名</td>
								<td>性别</td>
								<td>生日</td>
								<td>专业号码</td>
								<td>操作</td>
							</tr>
							<%
							List<Student> list=(List<Student>)request.getAttribute("list");
								for (int i = 0; i < list.size(); i++) {
							%>
							<tr>
								<td><%=list.get(i).getStudentNum()%></td>
								<td><%=list.get(i).getStudentName()%></td>
								<td><%=list.get(i).getStudentSex()%></td>
								<td><%=list.get(i).getStudentBirthday()%></td>
								<td><%=list.get(i).getMajorNum()%></td>
								<td><a
									href="PreUpdateStudentServlet?StudentNum=<%=list.get(i).getStudentNum()%>">修改</a>
								</td>
							</tr>
							<%
								}
							%>
						</table>
					</div>

					<!-- END OVERVIEW -->
				</div>
			</div>
			<!-- END MAIN CONTENT -->
		</div>
		<!-- END MAIN -->
		<div class="clearfix"></div>

	</div>
</body>
</html>