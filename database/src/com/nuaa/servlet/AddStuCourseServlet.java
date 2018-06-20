package com.nuaa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nuaa.service.StuCourseService;
import com.nuaa.service.TeacherService;
import com.nuaa.vo.StuCourse;
import com.nuaa.vo.Teacher;

/**
 * Servlet implementation class AddStuCourseServlet
 */
@WebServlet("/AddStuCourseServlet")
public class AddStuCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStuCourseServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String StudentNum = request.getParameter("StudentNum");
		String CourseNum = request.getParameter("CourseNum");
		String TeacherName = request.getParameter("TeacherName");
		
		TeacherService teacherService = new TeacherService();
		Teacher teacher = teacherService.QueryTeacherByName(TeacherName);
		String TeacherNum = teacher.getTeacherNum();
		// 判断该记录是否已存在于数据库中
		StuCourseService stuCourseService = new StuCourseService();
		StuCourse stuCourse1 = stuCourseService.QueryStuCourseBySCTNum(StudentNum, CourseNum, TeacherNum);
		if (stuCourse1.getStudentNum() != null) {
			
		} else {
			StuCourse stuCourse = new StuCourse();
			stuCourse.setCourseNum(CourseNum);
			stuCourse.setGrade(null);
			stuCourse.setStudentNum(StudentNum);
			stuCourse.setTeacherName(TeacherName);
			stuCourse.setTeacherNum(teacher.getTeacherNum());
			stuCourseService.InsertStuCourse(stuCourse);
		}

		// 页面跳转
		request.getRequestDispatcher("QueryAllCourseServlet").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
