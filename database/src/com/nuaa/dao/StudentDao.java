package com.nuaa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nuaa.util.DButil;
import com.nuaa.vo.Student;

public class StudentDao {
	private DButil util=DButil.getInstance();
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rSet;
	private String sql=null;
	//分页查询全部信息
	public List<Student> QueryAllStudentByLimit(String page){
		util.getconnection();
		sql="select * from student order by StudentNum limit ?,50";
		List<Object> list2=new ArrayList<Object>();
		list2.add(page);
		rSet=util.query(sql, list2);
		List<Student> list = new ArrayList<Student>();
		try {
			while(rSet.next()) {
				Student student=new Student();
				student.setMajorNum(rSet.getString("MajorNum"));
				student.setStudentBirthday(rSet.getString("StudentBirthday"));
				student.setStudentName(rSet.getString("StudentName"));
				student.setStudentNum(rSet.getString("StudentNum"));
				student.setStudentPassword(rSet.getString("StudentPassword"));
				student.setStudentSex(rSet.getString("StudentSex"));
				list.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.close();
		}
		return list;
	}
	//查询全部信息
	public List<Student> queryallstudent(){
		util.getconnection();
		sql="select * from student ";
		rSet=util.query(sql, null);
		System.out.println("------------------------------");
		List<Student> list = new ArrayList<Student>();
		try {
			while(rSet.next()) {
				Student student=new Student();
				student.setMajorNum(rSet.getString("MajorNum"));
				student.setStudentBirthday(rSet.getString("StudentBirthday"));
				student.setStudentName(rSet.getString("StudentName"));
				student.setStudentNum(rSet.getString("StudentNum"));
				student.setStudentPassword(rSet.getString("StudentPassword"));
				student.setStudentSex(rSet.getString("StudentSex"));
				list.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.close();
		}
		return list;
	}
	
	//高级学生查询
	public List<Student> QueryStudentByTop(String StudentNum){
		util.getconnection();
		sql="select * from student where StudentNum like concat('%',?,'%')";
		List<Object> list2=new ArrayList<Object>();
		list2.add(StudentNum);
		rSet=util.query(sql, list2);
		List<Student> list = new ArrayList<Student>();
		try {
			while(rSet.next()) {
				Student student=new Student();
				student.setMajorNum(rSet.getString("MajorNum"));
				student.setStudentBirthday(rSet.getString("StudentBirthday"));
				student.setStudentName(rSet.getString("StudentName"));
				student.setStudentNum(rSet.getString("StudentNum"));
				student.setStudentPassword(rSet.getString("StudentPassword"));
				student.setStudentSex(rSet.getString("StudentSex"));
				list.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.close();
		}
		return list;
	}
	//查询单条信息
	public Student querystudentbyid(String StudentNum ) {
		util.getconnection();
		sql="select * from student where StudentNum=?";
		List<Object> params=new ArrayList<Object>();
		Student student=new Student();
		params.add(StudentNum);
		rSet=util.query(sql, params);
		try {
			if(rSet.next()) {
				student.setMajorNum(rSet.getString("MajorNum"));
				student.setStudentBirthday(rSet.getString("StudentBirthday"));
				student.setStudentName(rSet.getString("StudentName"));
				student.setStudentNum(rSet.getString("StudentNum"));
				student.setStudentPassword(rSet.getString("StudentPassword"));
				student.setStudentSex(rSet.getString("StudentSex"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.close();
		}
		return student;
	}
	//插入单条信息
	public void insertstudent(Student student) {
		sql ="insert into student(StudentNum,MajorNum,StudentName,StudentSex,StudentBirthday,StudentPassword) "
				+ "values(?,?,?,?,?,?)";
		util.getconnection();
		List<Object> list=new ArrayList<Object>();

		list.add(student.getStudentNum());
		list.add(student.getMajorNum());
		list.add(student.getStudentName());
		list.add(student.getStudentSex());
		list.add(student.getStudentBirthday());
		list.add(student.getStudentPassword());
		
		util.update(sql, list);
		util.close();
	}
	//更新某条信息
	public void updatestudent(Student student) {
		util.getconnection();
		sql="update student set MajorNum=?,StudentName=?,"
				+ "StudentSex=?,StudentBirthday=?,StudentPassword=? where StudentNum=?";
		List<Object> list=new ArrayList<Object>();
		list.add(student.getMajorNum());
		list.add(student.getStudentName());
		list.add(student.getStudentSex());
		list.add(student.getStudentBirthday());
		list.add(student.getStudentPassword());
		list.add(student.getStudentNum());
		util.update(sql, list);
		util.close();
	}
	//删除某条信息
	public void delete(String StudentNum) {
		util.getconnection();
		sql="delete from student where StudentNum =?";
		List<Object> list=new ArrayList<Object>();
		list.add(StudentNum);
		util.update(sql, list);
		util.close();
	}
	//判断是否登陆成功
	public Student LoginJudge(String StudentNum,String StudentPassword) {
		util.getconnection();
		sql="select * from student where StudentNum=? and StudentPassword=?";
		List<Object> params=new ArrayList<Object>();
		Student student=new Student();
		params.add(StudentNum);
		params.add(StudentPassword);
		rSet=util.query(sql, params);
		try {
			if(rSet.next()) {
				student.setMajorNum(rSet.getString("MajorNum"));
				student.setStudentBirthday(rSet.getString("StudentBirthday"));
				student.setStudentName(rSet.getString("StudentName"));
				student.setStudentNum(rSet.getString("StudentNum"));
				student.setStudentPassword(rSet.getString("StudentPassword"));
				student.setStudentSex(rSet.getString("StudentSex"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.close();
		}
		return student;
	}
}
