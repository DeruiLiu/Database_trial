<%@page import="com.nuaa.vo.Teacher"%>
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
function DeleteTeacher(TeacherNum) {
	var flag = confirm("是否是删除该条记录？");
	if(flag) {
		location.href = "DeleteTeacher?TeacherNum=" + TeacherNum;
	}
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
						class="active"> <span>个人信息查询</span></a></li>
					<li><a
						href="PreUpdateTeacherServlet?TeacherNum=<%=(String) session.getAttribute("logname")%>"
						class=""><span>个人基本信息修改</span></a></li>
					<li><a
						href="QueryAllTeacherCourseServlet?TeacherNum=<%=(String) session.getAttribute("logname")%>"
						class=""> <span>查询所授课程信息</span></a></li>
					<li><a
						href="QueryAllStuCourseServltByTeacherNum?TeacherNum=<%=(String) session.getAttribute("logname")%>"
						class=""> <span>查询学生选课信息</span></a></li>
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
					<div>
						<table align="center" class="table" width="70%">
							<tr>
								<td>教师工号</td>
								<td>姓名</td>
								<td>院系号码</td>
								<td>性别</td>
								<td>生日</td>
								<td>职称</td>
								<td>操作</td>
							</tr>
							<%
								List<Teacher> list = (List<Teacher>) request.getAttribute("list");
								for (int i = 0; i < list.size(); i++) {
							%>
							<tr>
								<td><%=list.get(i).getTeacherNum()%></td>
								<td><%=list.get(i).getTeacherName()%></td>
								<td><%=list.get(i).getDeptNum()%></td>
								<td><%=list.get(i).getTeacherSex()%></td>
								<td><%=list.get(i).getTeacherBirthday()%></td>
								<td><%=list.get(i).getTeacherTitle()%></td>
								<td><a href="QueryAllTeacherCourseServlet?TeacherNum=<%= list.get(i).getTeacherNum() %>">查看</a>
								<a
									href="PreUpdateStudentServlet?StudentNum=<%=list.get(i).getTeacherNum()%>">修改</a>
									<a href="javascript:DeleteTeacher('<%= list.get(i).getTeacherNum() %>')">删除</a>
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