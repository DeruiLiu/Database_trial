package com.nuaa.service;

import java.util.List;

import com.nuaa.dao.DeptDao;
import com.nuaa.vo.Course;
import com.nuaa.vo.Dept;

public class DeptService {
	DeptDao deptDao = new DeptDao();

	// 查询全部院系信息
	public List<Object> QueryAllDept() {
		return deptDao.QueryAllDept();
	}

	// 查询单个专业信息
	public Dept QueryDeptById(String DeptNum) {
		return deptDao.QueryDeptById(DeptNum);
	}

	// 修改某个专业信息
	public void UpdateDept(Dept dept) {
		deptDao.UpdateDept(dept);
	}

	// 插入某个专业的信息
	public void InsertDept(Dept dept) {
		deptDao.InsertDept(dept);

	}

	// 删除某个专业的信息
	public void DeleteDept(String DeptNum) {
		deptDao.DeleteDept(DeptNum);
	}
}
