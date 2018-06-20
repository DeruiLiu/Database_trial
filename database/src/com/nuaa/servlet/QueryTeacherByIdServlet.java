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

import com.nuaa.service.TeacherService;
import com.nuaa.vo.Teacher;

/**
 * Servlet implementation class QueryTeacherByIdServlet
 */
@WebServlet("/QueryTeacherByIdServlet")
public class QueryTeacherByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryTeacherByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubTeacherService teacherService=new TeacherService();
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String StudentNum = request.getParameter("TeacherNum");//获取传过来的账号信息
		List<Teacher> list=new ArrayList<Teacher>();
		TeacherService teacherService=new TeacherService();
		list.add(teacherService.QueryTeacherById(StudentNum));
		PrintWriter out = response.getWriter();
		//传值
		request.setAttribute("list", list);
		//跳转
		request.getRequestDispatcher("Teacher/ListTeacher.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
