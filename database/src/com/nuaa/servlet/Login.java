package com.nuaa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import javax.websocket.Session;

import com.nuaa.service.ManagerService;
import com.nuaa.service.StudentService;
import com.nuaa.service.TeacherService;
import com.nuaa.vo.Manager;
import com.nuaa.vo.Student;
import com.nuaa.vo.Teacher;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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

		String name = request.getParameter("logname");
		String password = request.getParameter("logpass");
		PrintWriter out = response.getWriter();
		if (name.length() == 9) {// 如果是学生
			StudentService studentService = new StudentService();
			Student student = studentService.login(name, password);
			if (student.getStudentNum() != null) {
				// 创建session对象
				HttpSession session = request.getSession();
				// 把用户数据保存在session域对象中
				session.setAttribute("logname", student.getStudentNum());

				// 跳转
				request.getRequestDispatcher("NewFile.jsp").forward(request, response);
			} else {
				JOptionPane.showMessageDialog(null, "登陆失败，用户名或密码错误", "登陆失败", JOptionPane.PLAIN_MESSAGE);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}

		} else if (name.length() == 7) {// 如果是老师
			TeacherService teacherService = new TeacherService();
			Teacher teacher = teacherService.login(name, password);
			System.out.println(teacher);
			System.out.println(teacher.getTeacherNum());
			if (teacher.getTeacherNum() != null) {
				// 创建session对象
				HttpSession session = request.getSession();
				// 把用户数据保存在session域对象中
				session.setAttribute("logname", teacher.getTeacherNum());

				// 跳转
				request.getRequestDispatcher("TeacherHome.jsp").forward(request, response);
			} else {
				JOptionPane.showMessageDialog(null, "登陆失败，用户名或密码错误", "登陆失败", JOptionPane.PLAIN_MESSAGE);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} else if (name.length() == 3) {// 如果是管理员
			ManagerService managerService = new ManagerService();
			Manager manager = managerService.login(name, password);
			if (manager.getManagerNum() != null) {
				// 创建session对象
				HttpSession session = request.getSession();
				// 把用户数据保存在session域对象中
				session.setAttribute("logname", manager.getManagerNum());

				// 跳转
				request.getRequestDispatcher("ManagerHome.jsp").forward(request, response);
			} else {
				JOptionPane.showMessageDialog(null, "登陆失败，用户名或密码错误", "登陆失败", JOptionPane.PLAIN_MESSAGE);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
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
