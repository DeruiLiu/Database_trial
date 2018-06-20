package com.nuaa.service;

import java.util.List;

import com.nuaa.dao.StudentDao;
import com.nuaa.dao.TeacherDao;
import com.nuaa.vo.Student;
import com.nuaa.vo.Teacher;

public class TeacherService {
	TeacherDao teacherDao=new TeacherDao();
	
	//��ѯȫ����ʦ��Ϣ
	public List<Teacher> QueryAllTeacher(){
		return teacherDao.QueryAllTeacher();
	}
	//�߼���ѯ��ʦ��Ϣ
	public List<Teacher> QueryAllTeacherByTop(String TeacherNum){
		return teacherDao.QueryTeacherByTop(TeacherNum);
	}
	
	//��ѯ������ʦ��Ϣ
	public Teacher QueryTeacherById(String TeacherNum) {
		return teacherDao.QueryTeacherById(TeacherNum);
	}
	public Teacher QueryTeacherByName(String TeacherName) {
		return teacherDao.QueryTeacherByName(TeacherName);
	}
	//�޸�ĳ����ʦ��Ϣ
	public void UpdateTeacher(Teacher teacher) {
		teacherDao.UpdateTeacher(teacher);
	}
	
	//����ĳ����ʦ����Ϣ
	public void InsertTeacher(Teacher teacher) {
		teacherDao.InsertTeacher(teacher);
	}
	
	//ɾ��ĳ����ʦ����Ϣ
	public void DeleteTeacher(String TeacherNum) {
		teacherDao.DeleteTeacher(TeacherNum);
	}
	//�ж��Ƿ���ڸ�����ʦ��Ϣ�����Ƿ��½�ɹ�
	public Teacher login(String TeacherNum,String TeacherPassword) {
		return teacherDao.LoginJudge(TeacherNum, TeacherPassword);
	}
}
