package com.nuaa.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nuaa.service.StudentService;
import com.nuaa.vo.Student;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentServlet() {
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
		
		StudentService studentService=new StudentService();
		Student student=new Student();
		student.setMajorNum(request.getParameter("MajorNum"));
		student.setStudentBirthday(request.getParameter("StudentBirthday"));
		student.setStudentName(request.getParameter("StudentName"));
		student.setStudentNum(request.getParameter("StudentNum"));
		student.setStudentPassword(request.getParameter("StudentPassword"));
		student.setStudentSex(request.getParameter("StudentSex"));
		studentService.insertstudent(student);
		
		//Ò³ÃæÌø×ª
		request.getRequestDispatcher("queryallstudent").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
