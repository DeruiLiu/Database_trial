package com.nuaa.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nuaa.service.StuCourseService;
import com.nuaa.service.TeacherService;

/**
 * Servlet implementation class QueryAllStuCourseServltByTeacherNum
 */
@WebServlet("/QueryAllStuCourseServltByTeacherNum")
public class QueryAllStuCourseServltByTeacherNum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryAllStuCourseServltByTeacherNum() {
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
		String TeacherNum=request.getParameter("TeacherNum");
		StuCourseService stuCourseService=new StuCourseService();
		List<Object> list=stuCourseService.QueryStuCourseByTeacherId(TeacherNum);
		
		//´«Öµ
		request.setAttribute("list", list);
		//Ìø×ª
		request.getRequestDispatcher("Teacher/ListStuCourseByTeacherNum.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
