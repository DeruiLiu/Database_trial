package com.nuaa.service;

import java.util.List;

import com.nuaa.dao.CourseDao;
import com.nuaa.vo.Course;
import com.nuaa.vo.Major;

public class CourseService {
	CourseDao courseDao = new CourseDao();

	// 查询全部课程信息
	public List<Course> QueryAllCourse() {
		return courseDao.QueryAllCourse();
	}

	// 查询单个课程信息
	public Course QueryCourseById(String CourseNum) {
		return courseDao.QueryCourseById(CourseNum);
	}

	// 修改某个课程信息
	public void UpdateCourse(Course course) {
		courseDao.UpdateCourse(course);
	}

	// 插入某个课程的信息
	public void InsertCourse(Course course) {
		courseDao.InsertCourse(course);

	}

	// 删除某个课程的信息
	public void DeleteCourse(String CourseNum) {
		courseDao.DeleteCourse(CourseNum);
	}
	//按课程名字查询课程信息
	public List<Course> QueryCourseByCourseName(String CourseName){
		return courseDao.QueryClourseByCourseName(CourseName);
	}
	//按照老师工号查询所授课程
	public List<Course> QueryAllCourseByTeacherNum(String TeacherNum){
		return courseDao.QueryAllCourseByTeacherNum(TeacherNum);
	}
	//查询某个学号没有选课的选课信息
	public List<Object> QueryAllCourseByNotStudentNum(String StudentNum){
		return courseDao.QueryAllCourseByNotStudentNum(StudentNum);
	}
}
