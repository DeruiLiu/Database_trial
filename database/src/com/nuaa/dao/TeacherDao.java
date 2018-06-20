package com.nuaa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nuaa.util.DButil;
import com.nuaa.vo.Student;
import com.nuaa.vo.Teacher;
import com.sun.javafx.sg.prism.web.NGWebView;
import com.sun.org.apache.bcel.internal.generic.NEWARRAY;
import com.sun.org.apache.bcel.internal.generic.RETURN;

public class TeacherDao {
	private DButil util = DButil.getInstance();
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rSet;
	private String sql = null;

	// 查询全部老师信息
	public List<Teacher> QueryAllTeacher() {
		util.getconnection();
		sql = "select * from teacher";
		rSet = util.query(sql, null);
		List<Teacher> list = new ArrayList<>();
		try {
			while (rSet.next()) {
				Teacher teacher = new Teacher();
				teacher.setDeptNum(rSet.getString("DeptNum"));
				teacher.setTeacherBirthday(rSet.getString("TeacherBirthday"));
				teacher.setTeacherName(rSet.getString("TeacherName"));
				teacher.setTeacherNum(rSet.getString("TeacherNum"));
				teacher.setTeacherPassword(rSet.getString("TeacherPassword"));
				teacher.setTeacherSex(rSet.getString("TeacherSex"));
				teacher.setTeacherTitle(rSet.getString("TeacherTitle"));
				list.add(teacher);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close();
		}
		return list;
	}
	//高级教师查询
		public List<Teacher> QueryTeacherByTop(String TeacherNum){
			util.getconnection();
			sql="select * from teacher where TeacherNum like concat('%',?,'%')";
			List<Object> list2=new ArrayList<Object>();
			list2.add(TeacherNum);
			rSet=util.query(sql, list2);
			List<Teacher> list = new ArrayList<Teacher>();
			try {
				while(rSet.next()) {
					Teacher teacher = new Teacher();
					teacher.setDeptNum(rSet.getString("DeptNum"));
					teacher.setTeacherBirthday(rSet.getString("TeacherBirthday"));
					teacher.setTeacherName(rSet.getString("TeacherName"));
					teacher.setTeacherNum(rSet.getString("TeacherNum"));
					teacher.setTeacherPassword(rSet.getString("TeacherPassword"));
					teacher.setTeacherSex(rSet.getString("TeacherSex"));
					teacher.setTeacherTitle(rSet.getString("TeacherTitle"));
					list.add(teacher);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				util.close();
			}
			return list;
		}
	// 查询单个老师信息
	public Teacher QueryTeacherById(String TeacherNum) {
		util.getconnection();
		sql = "select * from teacher where TeacherNum=?";
		List<Object> list = new ArrayList<Object>();
		list.add(TeacherNum);
		rSet = util.query(sql, list);
		Teacher teacher = new Teacher();
		try {
			while (rSet.next()) {
				teacher.setDeptNum(rSet.getString("DeptNum"));
				teacher.setTeacherBirthday(rSet.getString("TeacherBirthday"));
				teacher.setTeacherName(rSet.getString("TeacherName"));
				teacher.setTeacherNum(rSet.getString("TeacherNum"));
				teacher.setTeacherPassword(rSet.getString("TeacherPassword"));
				teacher.setTeacherSex(rSet.getString("TeacherSex"));
				teacher.setTeacherTitle(rSet.getString("TeacherTitle"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close();
		}
		return teacher;
	}
	//按姓名查找老师
	public Teacher QueryTeacherByName(String TeacherName) {
		util.getconnection();
		sql = "select * from teacher where TeacherName=?";
		List<Object> list = new ArrayList<Object>();
		list.add(TeacherName);
		rSet = util.query(sql, list);
		Teacher teacher = new Teacher();
		try {
			while (rSet.next()) {
				teacher.setDeptNum(rSet.getString("DeptNum"));
				teacher.setTeacherBirthday(rSet.getString("TeacherBirthday"));
				teacher.setTeacherName(rSet.getString("TeacherName"));
				teacher.setTeacherNum(rSet.getString("TeacherNum"));
				teacher.setTeacherPassword(rSet.getString("TeacherPassword"));
				teacher.setTeacherSex(rSet.getString("TeacherSex"));
				teacher.setTeacherTitle(rSet.getString("TeacherTitle"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close();
		}
		return teacher;
	}
	//插入单个老师的信息
	public void InsertTeacher(Teacher teacher) {
		util.getconnection();
		sql="insert into Teacher(TeacherNum,DeptNum,TeacherName,TeacherSex,TeacherBirthday"
				+ "TeacherTitle,TeacherPassword) values (?,?,?,?,?,?,?)";
		List<Object> list=new ArrayList<Object>();
		list.add(teacher.getTeacherNum());
		list.add(teacher.getDeptNum());
		list.add(teacher.getTeacherName());
		list.add(teacher.getTeacherSex());
		list.add(teacher.getTeacherBirthday());
		list.add(teacher.getTeacherBirthday());
		list.add(teacher.getTeacherTitle());
		list.add(teacher.getTeacherPassword());
		util.update(sql, list);
		util.close();
	}
	
	//更新某个老师的信息
	public void UpdateTeacher(Teacher teacher) {
		util.getconnection();
		sql="update teacher set DeptNum=?,TeacherName=?,TeacherSex=?,"
				+ "TeacherBirthday=?,TeacherTitle=?,TeacherPassword=? where TeacherNum=?";
		List<Object> list=new ArrayList<Object>();
		list.add(teacher.getDeptNum());
		list.add(teacher.getTeacherName());
		list.add(teacher.getTeacherSex());
		list.add(teacher.getTeacherBirthday());
		list.add(teacher.getTeacherTitle());
		list.add(teacher.getTeacherPassword());
		list.add(teacher.getTeacherNum());
		util.update(sql, list);
		util.close();
	}
	
	//删除某个老师的信息
	public void DeleteTeacher(String TeacherNum) {
		util.getconnection();
		sql="delete from teacher where TeacherNum=?";
		List<Object> list=new ArrayList<Object>();
		list.add(TeacherNum);
		util.update(sql, list);
		util.close();
	}
	
	//判断是否登陆成功
		public Teacher LoginJudge(String TeacherNum,String TeacherPassword) {
			util.getconnection();
			sql="select * from teacher where TeacherNum=? and TeacherPassword=?";
			List<Object> params=new ArrayList<Object>();
			Teacher teacher=new Teacher();
			params.add(TeacherNum);
			params.add(TeacherPassword);
			rSet=util.query(sql, params);
			try {
				if(rSet.next()) {
					teacher.setDeptNum(rSet.getString("DeptNum"));
					teacher.setTeacherBirthday(rSet.getString("TeacherBirthday"));
					teacher.setTeacherName(rSet.getString("TeacherName"));
					teacher.setTeacherNum(rSet.getString("TeacherNum"));
					teacher.setTeacherPassword(rSet.getString("TeacherPassword"));
					teacher.setTeacherSex(rSet.getString("TeacherSex"));
					teacher.setTeacherTitle(rSet.getString("TeacherTitle"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				util.close();
			}
			return teacher;
		}
}
