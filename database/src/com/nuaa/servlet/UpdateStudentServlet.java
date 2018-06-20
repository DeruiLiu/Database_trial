package com.nuaa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nuaa.service.StudentService;
import com.nuaa.vo.Student;

/**
 * Servlet implementation class UpdateStudentServlet
 */
@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentServlet() {
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
		StudentService studentService=new StudentService();
		Student student=new Student();
		System.out.println(request.getParameter("StudentSex"));
		student.setMajorNum(request.getParameter("MajorNum"));
		student.setStudentName(request.getParameter("StudentName"));
		student.setStudentBirthday(request.getParameter("StudentBirthday"));
		student.setStudentPassword(request.getParameter("StudentPassword"));
		student.setStudentSex(request.getParameter("StudentSex"));
		student.setStudentNum(request.getParameter("StudentNum"));
		studentService.updatestudentbyid(student);
		request.getRequestDispatcher("NewFile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
