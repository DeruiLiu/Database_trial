package com.nuaa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class UpdateTeacherServlet
 */
@WebServlet("/UpdateTeacherServlet")
public class UpdateTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTeacherServlet() {
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
		TeacherService teacherService=new TeacherService();
		Teacher teacher=new Teacher();
		teacher.setDeptNum(request.getParameter("DeptNum"));
		teacher.setTeacherBirthday(request.getParameter("TeacherBirthday"));
		teacher.setTeacherName(request.getParameter("TeacherName"));
		teacher.setTeacherNum(request.getParameter("TeacherNum"));
		teacher.setTeacherPassword(request.getParameter("TeacherPassword"));
		teacher.setTeacherSex(request.getParameter("TeacherSex"));
		teacher.setTeacherTitle(request.getParameter("TeacherTitle"));
		teacherService.UpdateTeacher(teacher);
		request.getRequestDispatcher("TeacherHome.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
