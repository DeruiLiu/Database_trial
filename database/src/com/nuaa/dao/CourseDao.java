package com.nuaa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nuaa.util.DButil;
import com.nuaa.vo.Course;
import com.nuaa.vo.Manager;
import com.nuaa.vo.Student;

public class CourseDao {
	private DButil util = DButil.getInstance();
	private String sql = null;
	private PreparedStatement ps;
	private Connection connection;
	private ResultSet rSet;

	// 查询全部课程信息
	public List<Course> QueryAllCourse() {
		util.getconnection();
		sql = "select * from course";
		List<Course> list = new ArrayList<Course>();
		rSet = util.query(sql, null);
		try {
			while (rSet.next()) {
				Course course = new Course();
				course.setCourseCredit(rSet.getString("CourseCredit"));
				course.setCourseName(rSet.getString("CourseName"));
				course.setCourseNum(rSet.getString("CourseNum"));
				course.setCourseTime(rSet.getString("CourseTime"));
				course.setTeacherName(rSet.getString("TeacherName"));
				list.add(course);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close();
		}
		return list;
	}
	
	//查询某个学号没有选的课程信息
	public List<Object> QueryAllCourseByNotStudentNum(String StudentNum){
		util.getconnection();
		sql="SELECT * from course " + 
				"where CourseNum not in "+ 
				"(SELECT CourseNum" + 
				" FROM stucourse " + 
				"where studentNum=?)";
		List<Object> list2=new ArrayList<Object>();
		list2.add(StudentNum);
		List<Object> list=new ArrayList<Object>();
		rSet=util.query(sql, list2);
		try {
			while(rSet.next()) {
				Course course=new Course();
				course.setCourseCredit(rSet.getString("CourseCredit"));
				course.setCourseName(rSet.getString("CourseName"));
				course.setCourseNum(rSet.getString("CourseNum"));
				course.setCourseTime(rSet.getString("CourseTime"));
				course.setTeacherName(rSet.getString("TeacherName"));
				list.add(course);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.close();
		}
		return list;
	}

	// 插入单个课程的信息
	public void InsertCourse(Course course) {
		util.getconnection();
		sql = "insert into course(CourseName,CourseCredit,CourseTime,TeacherName) values(?,?,?,?)";
		List<Object> list = new ArrayList<Object>();
		list.add(course.getCourseName());
		list.add(course.getCourseCredit());
		list.add(course.getCourseTime());
		list.add(course.getTeacherName());
		util.update(sql, list);
		util.close();
	}
	// 查询单个课程信息
		public Course QueryCourseById(String CourseNum) {
			util.getconnection();
			sql = "select * from course where CourseNum=?";
			List<Object> list=new ArrayList<Object>();
			list.add(CourseNum);
			Course course=new Course();
			rSet=util.query(sql, list);
			try {
				while(rSet.next()) {
					course.setCourseCredit(rSet.getString("CourseCredit"));
					course.setCourseName(rSet.getString("CourseName"));
					course.setCourseNum(rSet.getString("CourseNum"));
					course.setCourseTime(rSet.getString("CourseTime"));
					course.setTeacherName(rSet.getString("TeacherName"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				util.close();
			}
			return course;
		}
		
		//更新某个课程的信息
		public void UpdateCourse(Course course) {
			util.getconnection();
			sql="update course set CourseName=?,CourseCredit=?,CourseTime=?,TeacherName=? where CourseNum=?";
			List<Object>list=new ArrayList<Object>();
			list.add(course.getCourseName());
			list.add(course.getCourseCredit());
			list.add(course.getCourseTime());
			list.add(course.getTeacherName());
			list.add(course.getCourseNum());
			util.update(sql, list);
			util.close();
		}
		//删除某个课程的信息
		public void DeleteCourse(String CourseNum) {
			util.getconnection();
			sql="delete from course where CourseNum=?";
			List<Object> list=new ArrayList<Object>();
			list.add(CourseNum);
			util.update(sql, list);
			util.close();
		}
		
		//按照老师学号查询所有所授课程信息
		public List<Course> QueryAllCourseByTeacherNum(String TeacherNum) {
			util.getconnection();
			sql = "select CourseNum,CourseCredit,CourseName,CourseTime,course.TeacherName "
					+ "from course,teacher "
					+ "where course.TeacherName=teacher.TeacherName"
					+ " and TeacherNum=?";
			List<Course> list = new ArrayList<Course>();
			List<Object> list2=new ArrayList<Object>();
			list2.add(TeacherNum);
			rSet = util.query(sql, list2);
			try {
				while (rSet.next()) {
					Course course = new Course();
					course.setCourseCredit(rSet.getString("CourseCredit"));
					course.setCourseName(rSet.getString("CourseName"));
					course.setCourseNum(rSet.getString("CourseNum"));
					course.setCourseTime(rSet.getString("CourseTime"));
					course.setTeacherName(rSet.getString("TeacherName"));
					list.add(course);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				util.close();
			}
			return list;
		}
		
	//按课程名字查询课程信息
		public List<Course> QueryClourseByCourseName(String CourseName) {
			util.getconnection();
			sql = "select * from course where CourseName=?";
			List<Object> list2=new ArrayList<Object>();
			list2.add(CourseName);
			List<Course> list = new ArrayList<Course>();
			rSet = util.query(sql, list2);
			try {
				while (rSet.next()) {
					Course course = new Course();
					course.setCourseCredit(rSet.getString("CourseCredit"));
					course.setCourseName(rSet.getString("CourseName"));
					course.setCourseNum(rSet.getString("CourseNum"));
					course.setCourseTime(rSet.getString("CourseTime"));
					course.setTeacherName(rSet.getString("TeacherName"));
					list.add(course);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				util.close();
			}
			return list;
		}
}
