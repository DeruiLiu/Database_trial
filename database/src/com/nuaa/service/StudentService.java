package com.nuaa.service;

import java.util.List;

import com.nuaa.dao.StudentDao;
import com.nuaa.vo.Student;

public class StudentService {
	StudentDao studentDao=new StudentDao();
	
	//查询全部学生信息
	public List<Student> queryallstudent(){
		return studentDao.queryallstudent();	
	}
	//分页查询全部信息
	public List<Student> QueryAllStudentByLimit(String page){
		return studentDao.QueryAllStudentByLimit(page);
	}
	//高级学生查询
	public List<Student> QueryStudentByTop(String StudentNum){
		return studentDao.QueryStudentByTop(StudentNum);
	}
	
	//查询单个学生信息
	public Student querystudentbuid(String StudentNum) {
		return studentDao.querystudentbyid(StudentNum);
	}
	
	//修改某个学生信息
	public void updatestudentbyid(Student student) {
		studentDao.updatestudent(student);
	}
	
	//插入某个学生的信息
	public void insertstudent(Student student) {
		studentDao.insertstudent(student);
	}
	
	//删除某个学生的信息
	public void deletestudent(String StudentNum) {
		studentDao.delete(StudentNum);
	}
	//判断是否存在该条学生信息，即是否登陆成功
	public Student login(String StudentNum,String StudentPassword) {
		return studentDao.LoginJudge(StudentNum, StudentPassword);
	}
}
