package com.nuaa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nuaa.util.DButil;
import com.nuaa.vo.Dept;
import com.nuaa.vo.Major;

public class DeptDao {
	private DButil util = DButil.getInstance();
	private String sql = null;
	private PreparedStatement ps;
	private Connection connection;
	private ResultSet rSet;

	// 查询全部院系信息
	public List<Object> QueryAllDept() {
		util.getconnection();
		sql = "select * from dept";
		List<Object> list = new ArrayList<Object>();
		rSet = util.query(sql, null);
		try {
			while (rSet.next()) {
				Dept dept = new Dept();
				dept.setDeptChairman(rSet.getString("DeptChairman"));
				dept.setDeptName(rSet.getString("DeptName"));
				dept.setDeptNum(rSet.getString("DeptNum"));
				dept.setDeptTel(rSet.getString("DeptTel"));
				list.add(dept);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close();
		}
		return list;
	}

	// 插入单个院系的信息
	public void InsertDept(Dept dept) {
		util.getconnection();
		sql = "insert into dept(DeptNum,DeptName,DeptChairman,DeptTel) values(?,?,?,?)";
		List<Object> list = new ArrayList<Object>();
		list.add(dept.getDeptNum());
		list.add(dept.getDeptName());
		list.add(dept.getDeptChairman());
		list.add(dept.getDeptTel());
		util.update(sql, list);
		util.close();
	}

	// 查询单个院系信息
	public Dept QueryDeptById(String DeptNum) {
		util.getconnection();
		sql = "select * from dept where DeptNum=?";
		List<Object> list = new ArrayList<Object>();
		list.add(DeptNum);
		Dept dept=new Dept();
		rSet = util.query(sql, list);
		try {
			while (rSet.next()) {
				dept.setDeptChairman(rSet.getString("DeptChairman"));
				dept.setDeptName(rSet.getString("DeptName"));
				dept.setDeptNum(rSet.getString("DeptNum"));
				dept.setDeptTel(rSet.getString("DeptTel"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close();
		}
		return dept;
	}

	// 更新某个院系的信息
	public void UpdateDept(Dept dept) {
		util.getconnection();
		sql = "update dept set DeptName=?,DeptChairman=?,DeptTel=? where DeptNum=?";
		List<Object> list = new ArrayList<Object>();
		list.add(dept.getDeptName());
		list.add(dept.getDeptChairman());
		list.add(dept.getDeptTel());
		list.add(dept.getDeptNum());
		util.update(sql, list);
		util.close();
	}

	// 删除某个专业的信息
	public void DeleteDept(String DeptNum) {
		util.getconnection();
		sql = "delete from dept where DeptNum=?";
		List<Object> list = new ArrayList<Object>();
		list.add(DeptNum);
		util.update(sql, list);
		util.close();
	}
}
