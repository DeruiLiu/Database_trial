package com.nuaa.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nuaa.service.CourseService;
import com.nuaa.service.StudentService;
import com.nuaa.vo.Student;

/**
 * Servlet implementation class PreUpdateCourseServlet
 */
@WebServlet("/PreUpdateCourseServlet")
public class PreUpdateCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreUpdateCourseServlet() {
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
		PrintWriter out=response.getWriter();
		String CourseNum=request.getParameter("CourseNum");
		CourseService courseService=new CourseService();
		List<Object> list=new ArrayList<Object>();
		list.add(courseService.QueryCourseById(CourseNum));
		
		//先查询到这个学生
		request.setAttribute("list", list);
		//跳转
		request.getRequestDispatcher("Teacher/UpdateCourse.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
