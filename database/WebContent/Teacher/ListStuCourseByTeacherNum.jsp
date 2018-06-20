<%@page import="com.nuaa.vo.StuCourse"%>
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
function PreUpdateStuCourseGrade(CourseNum,TeacherNum,StudentNum) {

	var Grade=document.getElementById("StuCourseGrade"+StudentNum).value;
	alert("修改成功");
	location.href="PreUpdateStuCourseGradeServlet?CourseNum="+CourseNum+"&TeacherNum="+TeacherNum+
			"&StudentNum="+StudentNum+"&Grade="+Grade;
}
</script>
</head>
<body>
<div id="wrapper">
		<!-- NAVBAR -->
		<nav class="navbar navbar-default navbar-fixed-top">
		<h1 style="text-align: center">欢迎来到老师管理系统</h1>
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
						class="active"> <span>查询学生选课信息</span></a></li>
					<li><a href="TeacherDispterServlet" class=""><span>高级操作</span></a></li>
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
					<div class="panel-body">
						<table align="center" class="table" border="1">
							<tr>
								<td>学号</td>
								<td>姓名</td>
								<td>课程号</td>
								<td>教师</td>
								<td>成绩</td>
								<td>操作</td>
							</tr>
							<%
							List<StuCourse> list=(List<StuCourse>) request.getAttribute("list");
								for (int i = 0; i < list.size(); i++) {
							%>
							<tr>
								<td><%=list.get(i).getStudentNum()%></td>
								<td><%=list.get(i).getStudentName()%></td>
								<td><%=list.get(i).getCourseNum()%></td>
								<td><%=list.get(i).getTeacherName()%></td>
								<td><input type="text" id="StuCourseGrade<%=list.get(i).getStudentNum()%>"
									value="<%=list.get(i).getGrade()%>"
									onclick="javascript:this.value=''"></td>
								<td><a
									href="javascript:PreUpdateStuCourseGrade('<%=list.get(i).getCourseNum()%>',
								'<%=list.get(i).getTeacherNum()%>',
								'<%=list.get(i).getStudentNum()%>')">修改</a>

								</td>
							</tr>
							<%
								}
							%>

							<!-- <tr>
								<td colspan="7"><input type="button" value="增加"
									onclick="AddStudent()" /></td>
							</tr> -->
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