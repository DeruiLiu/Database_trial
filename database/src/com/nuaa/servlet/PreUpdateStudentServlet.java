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

import com.nuaa.service.ManagerService;
import com.nuaa.service.StudentService;
import com.nuaa.service.TeacherService;
import com.nuaa.vo.Manager;
import com.nuaa.vo.Student;
import com.nuaa.vo.Teacher;
import com.sun.org.apache.bcel.internal.generic.NEWARRAY;

/**
 * Servlet implementation class PreUpdateStudentServlet
 */
@WebServlet("/PreUpdateStudentServlet")
public class PreUpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreUpdateStudentServlet() {
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
		
		String StudentNum=request.getParameter("StudentNum");
		
		if(StudentNum.length()==9) {
			StudentService studentService=new StudentService();
			List<Student> list=new ArrayList<Student>();
			list.add(studentService.querystudentbuid(StudentNum));
			//先查询到这个学生
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("Student/UpdateStudent.jsp").forward(request, response);
		}else if(StudentNum.length()==7) {
			TeacherService teacherService=new TeacherService();
			List<Teacher> list=new ArrayList<Teacher>();
			list.add(teacherService.QueryTeacherById(StudentNum));
			//先查询到该老师
			request.setAttribute("list", list);
			request.getRequestDispatcher("Teacher/UpdateTeacher.jsp").forward(request, response);
		}else {
			ManagerService managerService=new ManagerService();
			List<Manager> list=new ArrayList<Manager>();
			list.add(managerService.QueryManagerById(StudentNum));
			//先查到该管理员
			request.setAttribute("list", list);
			request.getRequestDispatcher("Manager/UpdateManager.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
