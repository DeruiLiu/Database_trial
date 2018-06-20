package com.nuaa.service;

import java.util.List;

import com.nuaa.dao.CourseDao;
import com.nuaa.vo.Course;
import com.nuaa.vo.Major;

public class CourseService {
	CourseDao courseDao = new CourseDao();

	// ��ѯȫ���γ���Ϣ
	public List<Course> QueryAllCourse() {
		return courseDao.QueryAllCourse();
	}

	// ��ѯ�����γ���Ϣ
	public Course QueryCourseById(String CourseNum) {
		return courseDao.QueryCourseById(CourseNum);
	}

	// �޸�ĳ���γ���Ϣ
	public void UpdateCourse(Course course) {
		courseDao.UpdateCourse(course);
	}

	// ����ĳ���γ̵���Ϣ
	public void InsertCourse(Course course) {
		courseDao.InsertCourse(course);

	}

	// ɾ��ĳ���γ̵���Ϣ
	public void DeleteCourse(String CourseNum) {
		courseDao.DeleteCourse(CourseNum);
	}
	//���γ����ֲ�ѯ�γ���Ϣ
	public List<Course> QueryCourseByCourseName(String CourseName){
		return courseDao.QueryClourseByCourseName(CourseName);
	}
	//������ʦ���Ų�ѯ���ڿγ�
	public List<Course> QueryAllCourseByTeacherNum(String TeacherNum){
		return courseDao.QueryAllCourseByTeacherNum(TeacherNum);
	}
	//��ѯĳ��ѧ��û��ѡ�ε�ѡ����Ϣ
	public List<Object> QueryAllCourseByNotStudentNum(String StudentNum){
		return courseDao.QueryAllCourseByNotStudentNum(StudentNum);
	}
}
