package com.nuaa.service;

import java.util.List;

import com.nuaa.dao.StudentDao;
import com.nuaa.dao.TeacherDao;
import com.nuaa.vo.Student;
import com.nuaa.vo.Teacher;

public class TeacherService {
	TeacherDao teacherDao=new TeacherDao();
	
	//查询全部老师信息
	public List<Teacher> QueryAllTeacher(){
		return teacherDao.QueryAllTeacher();
	}
	//高级查询教师信息
	public List<Teacher> QueryAllTeacherByTop(String TeacherNum){
		return teacherDao.QueryTeacherByTop(TeacherNum);
	}
	
	//查询单个老师信息
	public Teacher QueryTeacherById(String TeacherNum) {
		return teacherDao.QueryTeacherById(TeacherNum);
	}
	public Teacher QueryTeacherByName(String TeacherName) {
		return teacherDao.QueryTeacherByName(TeacherName);
	}
	//修改某个老师信息
	public void UpdateTeacher(Teacher teacher) {
		teacherDao.UpdateTeacher(teacher);
	}
	
	//插入某个老师的信息
	public void InsertTeacher(Teacher teacher) {
		teacherDao.InsertTeacher(teacher);
	}
	
	//删除某个老师的信息
	public void DeleteTeacher(String TeacherNum) {
		teacherDao.DeleteTeacher(TeacherNum);
	}
	//判断是否存在该条老师信息，即是否登陆成功
	public Teacher login(String TeacherNum,String TeacherPassword) {
		return teacherDao.LoginJudge(TeacherNum, TeacherPassword);
	}
}
