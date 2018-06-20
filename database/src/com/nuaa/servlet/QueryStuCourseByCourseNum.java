package com.nuaa.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nuaa.service.StuCourseService;

/**
 * Servlet implementation class QueryStuCourseByCourseNum
 */
@WebServlet("/QueryStuCourseByCourseNum")
public class QueryStuCourseByCourseNum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryStuCourseByCourseNum() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String CourseNum=request.getParameter("CourseNum");
		
		StuCourseService stuCourseService=new StuCourseService();
		List<Object> list=stuCourseService.QueryStuCourseByCourseId(CourseNum);
		
		//´«Öµ
		request.setAttribute("list", list);
		//Ìø×ª
		request.getRequestDispatcher("Teacher/ListStuCourseByCourseNum.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
