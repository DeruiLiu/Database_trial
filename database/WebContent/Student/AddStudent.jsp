<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="AddStudentServlet" method="get">
		<table class="table">
			<tr>
				<td>学号</td>
				<td><input type="text" name="StudentNum"></td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="StudentName"></td>
			</tr>
			<tr>
				<td>专业号码</td>
				<td><input type="text" name="MajorNum"></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><input type="radio" name="StudentSex" value="男">男 <input
					type="radio" name="StudentSex" value="女">女</td>
			</tr>
			<tr>
				<td>生日</td>
				<td><input type="text" name="StudentBirthday"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="text" name="StudentPassword"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="确定" /></td>
			</tr>
		</table>
	</form>
</body>
</html>