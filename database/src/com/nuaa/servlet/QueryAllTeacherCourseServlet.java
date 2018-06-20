package com.nuaa.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nuaa.service.CourseService;
import com.nuaa.vo.Course;

/**
 * Servlet implementation class QueryAllTeacherCourseServlet
 */
@WebServlet("/QueryAllTeacherCourseServlet")
public class QueryAllTeacherCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QueryAllTeacherCourseServlet() {
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
		String TeacherNum = request.getParameter("TeacherNum");
		
		CourseService courseService = new CourseService();
		List<Course> list = courseService.QueryAllCourseByTeacherNum(TeacherNum);
		
		// ´«Öµ
		request.setAttribute("list", list);
		// Ìø×ª
		request.getRequestDispatcher("Teacher/ListTeacherCourse.jsp").forward(request, response);
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
