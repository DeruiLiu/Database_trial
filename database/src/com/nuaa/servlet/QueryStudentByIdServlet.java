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
import javax.websocket.Session;

import com.nuaa.service.ManagerService;
import com.nuaa.service.StudentService;
import com.nuaa.service.TeacherService;
import com.nuaa.vo.Manager;
import com.nuaa.vo.Student;
import com.nuaa.vo.Teacher;

/**
 * Servlet implementation class QueryStudentByIdServlet
 */
@WebServlet("/QueryStudentByIdServlet")
public class QueryStudentByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QueryStudentByIdServlet() {
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
		
		String StudentNum = request.getParameter("StudentNum");//获取传过来的账号信息
		if(StudentNum.length()==9)
		{
		StudentService studentService = new StudentService();
		List<Student> list = new ArrayList<Student>();
		list.add(studentService.querystudentbuid(StudentNum));
		PrintWriter out = response.getWriter();
		// 传值
		request.setAttribute("list", list);
		// 跳转
		request.getRequestDispatcher("Student/liststudent.jsp").forward(request, response);
		}else if(StudentNum.length()==7){
			TeacherService teacherService=new TeacherService();
			List<Teacher> list=new ArrayList<Teacher>();
			list.add(teacherService.QueryTeacherById(StudentNum));
			PrintWriter out = response.getWriter();
			//传值
			request.setAttribute("list", list);
			//跳转
			request.getRequestDispatcher("Teacher/ListTeacher.jsp").forward(request, response);
		}
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
