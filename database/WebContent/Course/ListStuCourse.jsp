<%@page import="com.nuaa.vo.Course"%>
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
<script type="text/javascript">
	function InsertStuCourse(CourseNum, TeacherName, StudentNum) {
		alert("选课成功");
		location.href = "AddStuCourseServlet?CourseNum=" + CourseNum
				+ "&StudentNum=" + StudentNum + "&TeacherName=" + TeacherName;
	}
</script>
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
					<li><a href="NewFile.jsp" class=""> <span>首页</span></a></li>
					<li><a
						href="QueryStudentByIdServlet?StudentNum=<%=(String) session.getAttribute("logname")%>"
						class=""> <span>个人信息查询</span></a></li>
					<li><a
						href="PreUpdateStudentServlet?StudentNum=<%=(String) session.getAttribute("logname")%>"
						class=""><span>个人基本信息修改</span></a></li>
					<li><a
						href="QueryAllCourseServlet?StudentNum=<%=(String) session.getAttribute("logname")%>"
						class="active"> <span>学期选课</span></a></li>
					<li><a
						href="QueryAllStuCourseServlt?StudentNum=<%=(String) session.getAttribute("logname")%>"
						class=""> <span>历年成绩查询</span></a></li>
					<li><a href="" class=""><span>学期修读课程查询</span></a></li>
					<li><a href="" class=""> <span>使用帮助</span></a></li>
					<li><a href="" class=""> <span>新系统测试</span></a></li>
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
						<table align="center" border="1" class="table" width="50%">
							<tr>
								<td>课程号</td>
								<td>课程名</td>
								<td>课程学分</td>
								<td>课程学时</td>
								<td>教师</td>
								<td>操作</td>
							</tr>
							<%
								List<Course> list = (List<Course>) request.getAttribute("list");
								for (int i = 0; i < list.size(); i++) {
							%>
							<tr>
								<td><%=list.get(i).getCourseNum()%></td>
								<td><%=list.get(i).getCourseName()%></td>
								<td><%=list.get(i).getCourseCredit()%></td>
								<td><%=list.get(i).getCourseTime()%></td>
								<td><%=list.get(i).getTeacherName()%></td>
								<td><a
									href="javascript:InsertStuCourse('<%=list.get(i).getCourseNum()%>','<%=list.get(i).getTeacherName()%>','<%=session.getAttribute("logname")%>')">选课</a>
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