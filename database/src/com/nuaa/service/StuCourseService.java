package com.nuaa.service;

import java.util.List;

import com.nuaa.dao.StuCourseDao;
import com.nuaa.vo.Dept;
import com.nuaa.vo.StuCourse;

public class StuCourseService {
	StuCourseDao stuCourseDao = new StuCourseDao();

	// 查询全部选课信息
	public List<StuCourse> QueryAllStuCourse() {
		return stuCourseDao.QueryAllStuCourse();
	}

	// 按学号查询选课信息
	public List<StuCourse> QueryStuCourseByStudentId(String StudentNum) {
		return stuCourseDao.QueryStuCourseByStudentId(StudentNum);
	}
	
	// 按老师工号查询选课信息
	public List<Object> QueryStuCourseByTeacherId(String TeacherNum) {
		return stuCourseDao.QueryStuCourseByTeacherId(TeacherNum);
	}

	// 按课程号查询选课信息
	public List<Object> QueryStuCourseByCourseId(String CourseNum) {
		return stuCourseDao.QueryStuCourseByCourseId(CourseNum);
	}

	// 修改某个选课信息
	public void UpdateStuCourse(StuCourse stuCourse) {
		stuCourseDao.UpdateStuCourse(stuCourse);
	}

	// 插入某个选课信息
	public void InsertStuCourse(StuCourse stuCourse) {
		stuCourseDao.InsertCourse(stuCourse);

	}

	// 按学号课程号教师工号删除某个选课信息
	public void DeleteStuCourseBySCTNum(String StudentNum,String CourseNum,String TeacherNum) {
		stuCourseDao.DeleteStuCourseBySCTNum(StudentNum, CourseNum, TeacherNum);
	}
	public StuCourse QueryStuCourseBySCTNum(String StudentNum,String CourseNum,String TeacherNum) {
		return stuCourseDao.QueryStuCourseBySCTNum(StudentNum, CourseNum, TeacherNum);
	}
	// 按老师工号删除某个选课信息
	public void DeleteStuCourseByTeacherNum(String TeacherNum) {
		stuCourseDao.DeleteStuCourseByTeacherNum(TeacherNum);
	}
}
