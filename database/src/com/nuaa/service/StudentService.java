package com.nuaa.service;

import java.util.List;

import com.nuaa.dao.StudentDao;
import com.nuaa.vo.Student;

public class StudentService {
	StudentDao studentDao=new StudentDao();
	
	//��ѯȫ��ѧ����Ϣ
	public List<Student> queryallstudent(){
		return studentDao.queryallstudent();	
	}
	//��ҳ��ѯȫ����Ϣ
	public List<Student> QueryAllStudentByLimit(String page){
		return studentDao.QueryAllStudentByLimit(page);
	}
	//�߼�ѧ����ѯ
	public List<Student> QueryStudentByTop(String StudentNum){
		return studentDao.QueryStudentByTop(StudentNum);
	}
	
	//��ѯ����ѧ����Ϣ
	public Student querystudentbuid(String StudentNum) {
		return studentDao.querystudentbyid(StudentNum);
	}
	
	//�޸�ĳ��ѧ����Ϣ
	public void updatestudentbyid(Student student) {
		studentDao.updatestudent(student);
	}
	
	//����ĳ��ѧ������Ϣ
	public void insertstudent(Student student) {
		studentDao.insertstudent(student);
	}
	
	//ɾ��ĳ��ѧ������Ϣ
	public void deletestudent(String StudentNum) {
		studentDao.delete(StudentNum);
	}
	//�ж��Ƿ���ڸ���ѧ����Ϣ�����Ƿ��½�ɹ�
	public Student login(String StudentNum,String StudentPassword) {
		return studentDao.LoginJudge(StudentNum, StudentPassword);
	}
}
