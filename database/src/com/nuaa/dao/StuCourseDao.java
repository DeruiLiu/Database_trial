package com.nuaa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nuaa.util.DButil;
import com.nuaa.vo.Course;
import com.nuaa.vo.StuCourse;

public class StuCourseDao {
	private DButil util = DButil.getInstance();
	private String sql = null;
	private PreparedStatement ps;
	private Connection connection;
	private ResultSet rSet;

	// 查询全部学生选课信息
	public List<StuCourse> QueryAllStuCourse() {
		util.getconnection();
		sql = "select * from stucourse";
		List<StuCourse> list = new ArrayList<StuCourse>();
		rSet = util.query(sql, null);
		try {
			while (rSet.next()) {
				StuCourse stuCourse = new StuCourse();
				stuCourse.setCourseNum(rSet.getString("CourseNum"));
				stuCourse.setGrade(rSet.getString("Grade"));
				stuCourse.setStudentNum(rSet.getString("StudentNum"));
				stuCourse.setTeacherNum(rSet.getString("TeacherNum"));
				stuCourse.setTeacherName(rSet.getString("StudentName"));
				list.add(stuCourse);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close();
		}
		return list;
	}

	// 插入单个选课的信息
	public void InsertCourse(StuCourse stuCourse) {
		util.getconnection();
		sql = "insert into stucourse(StudentNum,CourseNum,TeacherNum,TeacherName,Grade) values(?,?,?,?,?)";
		List<Object> list = new ArrayList<Object>();
		list.add(stuCourse.getStudentNum());
		list.add(stuCourse.getCourseNum());
		list.add(stuCourse.getTeacherNum());
		list.add(stuCourse.getTeacherName());
		list.add(stuCourse.getGrade());
		util.update(sql, list);
		util.close();
	}

	// 查询某个学生的所有选课信息
	public List<StuCourse> QueryStuCourseByStudentId(String StudentNum) {
		util.getconnection();
		sql = "select * from stucourse where StudentNum=?";
		List<Object> list = new ArrayList<Object>();
		list.add(StudentNum);
		rSet = util.query(sql, list);
		List<StuCourse> list2 = new ArrayList<StuCourse>();
		try {
			while (rSet.next()) {
				StuCourse stuCourse = new StuCourse();
				stuCourse.setCourseNum(rSet.getString("CourseNum"));
				stuCourse.setGrade(rSet.getString("Grade"));
				stuCourse.setStudentNum(rSet.getString("StudentNum"));
				stuCourse.setTeacherNum(rSet.getString("TeacherNum"));
				stuCourse.setTeacherName(rSet.getString("TeacherName"));
				list2.add(stuCourse);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close();
		}
		return list2;
	}

	// 查询某个老师所教课程的选课信息,按老师ID查看选课信息
	public List<Object> QueryStuCourseByTeacherId(String TeacherNum) {
		util.getconnection();
		sql="select stucourse.StudentNum,StudentName,CourseNum,Grade,TeacherNum,TeacherName "
				+ "from student,stucourse "
				+ "where TeacherNum=? and student.StudentNum=stucourse.StudentNum";
		List<Object> list = new ArrayList<Object>();
		list.add(TeacherNum);
		rSet = util.query(sql, list);
		List<Object> list2 = new ArrayList<Object>();
		try {
			while (rSet.next()) {
				StuCourse stuCourse = new StuCourse();
				stuCourse.setCourseNum(rSet.getString("CourseNum"));
				stuCourse.setGrade(rSet.getString("Grade"));
				stuCourse.setStudentNum(rSet.getString("StudentNum"));
				stuCourse.setStudentName(rSet.getString("StudentName"));
				stuCourse.setTeacherName(rSet.getString("TeacherName"));
				stuCourse.setTeacherNum(rSet.getString("TeacherNum"));
				list2.add(stuCourse);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close();
		}
		return list2;
	}

	// 查询某个课程的所有选课信息，即选了该课程的所有信息
	public List<Object> QueryStuCourseByCourseId(String CourseNum) {
		util.getconnection();
//		sql="select stucourse.StudentNum,StudentName,CourseNum,Grade,teacher.TeacherNum,teacher.TeacherName"
//				+ "from stucourse,student,teacher where student.StudentNum=stucourse.StudentNum "
//				+ "and CourseNum=? and stucourse.TeacherNum=teacher.TeacherNum"; 
				
		sql = "select stucourse.StudentNum,StudentName,CourseNum,Grade,TeacherNum"
				+ " from stucourse,student where student.StudentNum=stucourse.StudentNum"
				+ " and CourseNum=?";
		List<Object> list = new ArrayList<Object>();
		list.add(CourseNum);
		rSet = util.query(sql, list);
		List<Object> list2 = new ArrayList<Object>();
		try {
			while (rSet.next()) {
				StuCourse stuCourse = new StuCourse();
				stuCourse.setCourseNum(rSet.getString("CourseNum"));
				stuCourse.setGrade(rSet.getString("Grade"));
				stuCourse.setStudentNum(rSet.getString("StudentNum"));
				stuCourse.setStudentName(rSet.getString("StudentName"));
//				stuCourse.setTeacherName(rSet.getString("TeacherName"));
				stuCourse.setTeacherNum(rSet.getString("TeacherNum"));
				list2.add(stuCourse);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close();
		}
		return list2;
	}

	// 按老师工号学生学号课程号更新某个学生的课程成绩
	public void UpdateStuCourse(StuCourse stuCourse) {
		util.getconnection();
		sql = "update stucourse set Grade=? where TeacherNum=? and "
				+ "CourseNum=? and StudentNum=?";
		List<Object> list = new ArrayList<Object>();
		System.out.println(stuCourse.getGrade());
		System.out.println(stuCourse.getTeacherNum());
		System.out.println(stuCourse.getCourseNum());
		list.add(stuCourse.getGrade());
		list.add(stuCourse.getTeacherNum());
		list.add(stuCourse.getCourseNum());
		list.add(stuCourse.getStudentNum());
		util.update(sql, list);
		util.close();
	}

	// 按学号课程号教师工号删除某个选课的信息
	public void DeleteStuCourseBySCTNum(String StudentNum,String CourseNum,String TeacherNum) {
		util.getconnection();
		sql = "delete from stucourse where StudentNum=? and CourseNum=? and TeacherNum=?";
		List<Object> list = new ArrayList<Object>();
		list.add(StudentNum);
		list.add(CourseNum);
		list.add(TeacherNum);
		util.update(sql, list);
		util.close();
	}
	//按学号课程号教师工号查询某个选课的信息
	public StuCourse QueryStuCourseBySCTNum(String StudentNum,String CourseNum,String TeacherNum) {
		util.getconnection();
		sql="select * from stucourse where StudentNum=? and CourseNum=? and TeacherNum=?";
		List<Object> list=new ArrayList<Object>();
		list.add(StudentNum);
		list.add(CourseNum);
		list.add(TeacherNum);
		rSet=util.query(sql, list);
		StuCourse stuCourse=new StuCourse();
		try {
			while (rSet.next()) {
				stuCourse.setCourseNum(rSet.getString("CourseNum"));
				stuCourse.setGrade(rSet.getString("Grade"));
				stuCourse.setStudentNum(rSet.getString("StudentNum"));
				stuCourse.setTeacherName(rSet.getString("TeacherName"));
				stuCourse.setTeacherNum(rSet.getString("TeacherNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.close();
		}
		return stuCourse;
		
		
	}

	// 按老师工号删除某个选课的信息,老师可能不教了
	public void DeleteStuCourseByTeacherNum(String TeacherNum) {
		util.getconnection();
		sql = "delete from stucourse where TeacherNum=?";
		List<Object> list = new ArrayList<Object>();
		list.add(TeacherNum);
		util.update(sql, list);
		util.close();
	}
	
}
