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
<form action="QueryStudentByIdServlet" method="post">
<table>
			<tr>
				<td>请输入你要查找的学号</td>
				<td><input type="text" name="StudentNum"></td>
			</tr>
			<tr>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="确定" /></td>
			</tr>
		</table></form>
</body>
</html>