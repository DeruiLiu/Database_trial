package com.nuaa.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nuaa.service.StudentService;
import com.nuaa.service.TeacherService;
import com.nuaa.vo.Student;
import com.nuaa.vo.Teacher;

/**
 * Servlet implementation class SearchTeacherByTeacherNumServlet
 */
@WebServlet("/SearchTeacherByTeacherNumServlet")
public class SearchTeacherByTeacherNumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchTeacherByTeacherNumServlet() {
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
		String TeacherNum=request.getParameter("TeacherNum");
		TeacherService teacherService=new TeacherService();
		List<Teacher> list=teacherService.QueryAllTeacherByTop(TeacherNum);
		
		request.setAttribute("list", list);
		
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
