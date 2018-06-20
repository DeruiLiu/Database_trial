package com.nuaa.service;

import java.util.List;

import com.nuaa.dao.StuCourseDao;
import com.nuaa.vo.Dept;
import com.nuaa.vo.StuCourse;

public class StuCourseService {
	StuCourseDao stuCourseDao = new StuCourseDao();

	// ��ѯȫ��ѡ����Ϣ
	public List<StuCourse> QueryAllStuCourse() {
		return stuCourseDao.QueryAllStuCourse();
	}

	// ��ѧ�Ų�ѯѡ����Ϣ
	public List<StuCourse> QueryStuCourseByStudentId(String StudentNum) {
		return stuCourseDao.QueryStuCourseByStudentId(StudentNum);
	}
	
	// ����ʦ���Ų�ѯѡ����Ϣ
	public List<Object> QueryStuCourseByTeacherId(String TeacherNum) {
		return stuCourseDao.QueryStuCourseByTeacherId(TeacherNum);
	}

	// ���γ̺Ų�ѯѡ����Ϣ
	public List<Object> QueryStuCourseByCourseId(String CourseNum) {
		return stuCourseDao.QueryStuCourseByCourseId(CourseNum);
	}

	// �޸�ĳ��ѡ����Ϣ
	public void UpdateStuCourse(StuCourse stuCourse) {
		stuCourseDao.UpdateStuCourse(stuCourse);
	}

	// ����ĳ��ѡ����Ϣ
	public void InsertStuCourse(StuCourse stuCourse) {
		stuCourseDao.InsertCourse(stuCourse);

	}

	// ��ѧ�ſγ̺Ž�ʦ����ɾ��ĳ��ѡ����Ϣ
	public void DeleteStuCourseBySCTNum(String StudentNum,String CourseNum,String TeacherNum) {
		stuCourseDao.DeleteStuCourseBySCTNum(StudentNum, CourseNum, TeacherNum);
	}
	public StuCourse QueryStuCourseBySCTNum(String StudentNum,String CourseNum,String TeacherNum) {
		return stuCourseDao.QueryStuCourseBySCTNum(StudentNum, CourseNum, TeacherNum);
	}
	// ����ʦ����ɾ��ĳ��ѡ����Ϣ
	public void DeleteStuCourseByTeacherNum(String TeacherNum) {
		stuCourseDao.DeleteStuCourseByTeacherNum(TeacherNum);
	}
}
