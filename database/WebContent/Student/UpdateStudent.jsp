<%@page import="java.util.List"%>
<%@page import="com.nuaa.vo.Student"%>
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
					<li><a href="NewFile.jsp" class=""> <span>首页</span></a></li>
					<li><a
						href="QueryStudentByIdServlet?StudentNum=<%=(String) session.getAttribute("logname")%>"
						class=""> <span>个人信息查询</span></a></li>
					<li><a
						href="PreUpdateStudentServlet?StudentNum=<%=(String) session.getAttribute("logname")%>"
						class="active"><span>个人基本信息修改</span></a></li>
					<li><a
						href="QueryAllCourseServlet?StudentNum=<%=(String) session.getAttribute("logname")%>"
						class=""> <span>学期选课</span></a></li>
					<li><a href="QueryAllStuCourseServlt?StudentNum=<%=(String) session.getAttribute("logname")%>" class=""> <span>历年成绩查询</span></a></li>
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
				<!-- OVERVIEW -->
				<div>
					<%
						List<Student> list = (List<Student>) request.getAttribute("list");
						Student student = list.get(0);
					%>
					<form action="UpdateStudentServlet" method="post"
						style="margin-left: 200px">
						<table class="table" >
							<tr>
								<td><input type="hidden" name="StudentNum"
									value="<%=student.getStudentNum()%>"></td>
							</tr>
							<tr>
								<td>姓名</td>
								<td><input type="text" name="StudentName"
									value="<%=student.getStudentName()%>"
									onclick=javascript:this.value=''></td>
							</tr>
							<tr>
								<td>专业号码</td>
								<td><input type="text" name="MajorNum"
									value="<%=student.getMajorNum()%>"
									onclick=javascript:this.value=''></td>
							</tr>
							<tr>
								<%
									if (student.getStudentSex().equals("男")) {
								%>
								<td><input type="radio" name="StudentSex" value="男"
									checked="checked" />男 <input type="radio" name="StudentSex"
									value="女" />女</td>
								<%
									} else {
								%>
								<td><input type="radio" name="StudentSex" value="男" />男 <input
									type="radio" name="StudentSex" value="女" checked="checked" />女</td>
								<%
									}
								%>
							</tr>
							<tr>
								<td>生日</td>
								<td><input type="text" name="StudentBirthday"
									value="<%=student.getStudentBirthday()%>"
									onclick=javascript:this.value=''></td>
							</tr>
							<tr>
								<td>密码</td>
								<td><input type="text" name="StudentPassword"
									value="<%=student.getStudentPassword()%>"
									onclick=javascript:this.value=''></td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="确定" /></td>
							</tr>
						</table>
					</form>
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