package com.nuaa.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nuaa.service.PageService;
import com.nuaa.service.StudentService;
import com.nuaa.vo.Student;
import com.sun.javafx.sg.prism.web.NGWebView;

/**
 * Servlet implementation class queryallstudent
 */
@WebServlet("/queryallstudent")
public class queryallstudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public queryallstudent() {
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
		
		int page=1;//开始时是第一页
		if(request.getParameter("page")!=null) {
			page=Integer.valueOf(request.getParameter("page"));
			System.out.println("111111111111"+page);
		}
		System.out.println("2222222"+page);
		int limitstart=(page-1)*50;//每页显示50条数据
		StudentService studentService=new StudentService();
		List<Student> list=studentService.QueryAllStudentByLimit(String.valueOf(limitstart));//查得数据
		//传值
		request.setAttribute("list", list);
		request.setAttribute("page", String.valueOf(page));
		String totalpages;//计算查询总页数
		PageService pageService=new PageService();
		int count=pageService.CountNumer();
		totalpages=String.valueOf(count/100);
		request.setAttribute("totalpages", totalpages);
		
		//跳转
		request.getRequestDispatcher("Teacher/liststudent.jsp").forward(request, response);
		
		
	}

	private String String(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
