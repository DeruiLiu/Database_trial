package com.nuaa.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nuaa.service.StuCourseService;
import com.nuaa.service.StudentService;
import com.nuaa.vo.StuCourse;
import com.nuaa.vo.Student;

/**
 * Servlet implementation class QueryAllStuCourseServlt
 */
@WebServlet("/QueryAllStuCourseServlt")
public class QueryAllStuCourseServlt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QueryAllStuCourseServlt() {
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
		// stubresponse.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		StuCourseService stuCourseService = new StuCourseService();
		String StudentNum = request.getParameter("StudentNum");
		List<StuCourse> list = stuCourseService.QueryStuCourseByStudentId(StudentNum);

		// ´«Öµ
		request.setAttribute("list", list);
		// Ìø×ª
		request.getRequestDispatcher("Course/ListAllCourseGrade.jsp").forward(request, response);
	}

	private char[] list(int i) {
		// TODO Auto-generated method stub
		return null;
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
