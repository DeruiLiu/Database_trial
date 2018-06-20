package com.nuaa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nuaa.service.StuCourseService;
import com.nuaa.service.TeacherService;
import com.nuaa.vo.StuCourse;
import com.nuaa.vo.Teacher;
import com.sun.org.apache.bcel.internal.generic.NEWARRAY;

/**
 * Servlet implementation class PreUpdateStuCourseGradeServlet
 */
@WebServlet("/PreUpdateStuCourseGradeServlet")
public class PreUpdateStuCourseGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreUpdateStuCourseGradeServlet() {
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
		String TeacherNum=request.getParameter("TeacherNum");
		String StudentNum=request.getParameter("StudentNum");
		String Grade=request.getParameter("Grade");

		System.out.println("111111111111111111111");
		System.out.println(CourseNum+","+TeacherNum+","+StudentNum+","+Grade);
		
		StuCourse stuCourse=new StuCourse();
		stuCourse.setCourseNum(CourseNum);
		stuCourse.setTeacherNum(TeacherNum);
		stuCourse.setStudentNum(StudentNum);
		stuCourse.setGrade(Grade);
		StuCourseService stuCourseService=new StuCourseService();
		stuCourseService.UpdateStuCourse(stuCourse);
		System.out.println("okokokokokokokokoko");
		//Ò³ÃæÌø×ª
		request.getRequestDispatcher("QueryStuCourseByCourseNum").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
