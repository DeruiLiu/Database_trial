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
import com.nuaa.vo.Teacher;

/**
 * Servlet implementation class DeleteStuCourseServlet
 */
@WebServlet("/DeleteStuCourseServlet")
public class DeleteStuCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteStuCourseServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String StudentNum = request.getParameter("StudentNum");
		String CourseNum = request.getParameter("CourseNum");
		String TeacherName = request.getParameter("TeacherName");
		TeacherService teacherService = new TeacherService();
		Teacher teacher = teacherService.QueryTeacherByName(TeacherName);
		StuCourseService stuCourseService = new StuCourseService();
		String TeacherNum = teacher.getTeacherNum();
		stuCourseService.DeleteStuCourseBySCTNum(StudentNum, CourseNum, TeacherNum);

		// Ò³ÃæÌø×ª
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
