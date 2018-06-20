package com.nuaa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nuaa.util.DButil;
import com.nuaa.vo.Major;

public class MajorDao {
	private DButil util = DButil.getInstance();
	private String sql = null;
	private PreparedStatement ps;
	private Connection connection;
	private ResultSet rSet;

	// 查询全部专业信息
	public List<Major> QueryAllMajor() {
		util.getconnection();
		sql = "select * from major";
		List<Major> list = new ArrayList<Major>();
		rSet = util.query(sql, null);
		try {
			while (rSet.next()) {
				Major major = new Major();
				major.setDeptNum(rSet.getString("DeptNum"));
				major.setMajorAssistant(rSet.getString("MajorAssistant"));
				major.setMajorName(rSet.getString("MajorName"));
				major.setMajorNum(rSet.getString("MajorNum"));
				list.add(major);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close();
		}
		return list;
	}

	// 插入单个专业的信息
	public void InsertMajor(Major major) {
		util.getconnection();
		sql = "insert into major(MajorNum,DeptNum,MajorName,MajorAssistant) values(?,?,?,?)";
		List<Object> list = new ArrayList<Object>();
		list.add(major.getMajorNum());
		list.add(major.getDeptNum());
		list.add(major.getMajorName());
		list.add(major.getMajorAssistant());
		util.update(sql, list);
		util.close();
	}

	// 查询单个专业信息
	public Major QueryMajorById(String MajorNum) {
		util.getconnection();
		sql = "select * from major where MajorNum=?";
		List<Object> list = new ArrayList<Object>();
		list.add(MajorNum);
		Major major = new Major();
		rSet = util.query(sql, list);
		try {
			while (rSet.next()) {
				major.setDeptNum(rSet.getString("DeptNum"));
				major.setMajorAssistant(rSet.getString("MajorAssistant"));
				major.setMajorName(rSet.getString("MajorName"));
				major.setMajorNum(rSet.getString("MajorNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close();
		}
		return major;
	}

	// 更新某个专业的信息
	public void UpdateMajor(Major major) {
		util.getconnection();
		sql = "update major set DeptNum=?,MajorName=?,MajorAssistant=? where MajorNum=?";
		List<Object> list = new ArrayList<Object>();
		list.add(major.getDeptNum());
		list.add(major.getMajorName());
		list.add(major.getMajorAssistant());
		list.add(major.getMajorNum());
		util.update(sql, list);
		util.close();
	}

	// 删除某个专业的信息
	public void DeleteMajor(String MajorNum) {
		util.getconnection();
		sql = "delete from major where MajorNum=?";
		List<Object> list = new ArrayList<Object>();
		list.add(MajorNum);
		util.update(sql, list);
		util.close();
	}
}
