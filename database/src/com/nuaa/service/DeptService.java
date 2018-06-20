package com.nuaa.service;

import java.util.List;

import com.nuaa.dao.DeptDao;
import com.nuaa.vo.Course;
import com.nuaa.vo.Dept;

public class DeptService {
	DeptDao deptDao = new DeptDao();

	// ��ѯȫ��Ժϵ��Ϣ
	public List<Object> QueryAllDept() {
		return deptDao.QueryAllDept();
	}

	// ��ѯ����רҵ��Ϣ
	public Dept QueryDeptById(String DeptNum) {
		return deptDao.QueryDeptById(DeptNum);
	}

	// �޸�ĳ��רҵ��Ϣ
	public void UpdateDept(Dept dept) {
		deptDao.UpdateDept(dept);
	}

	// ����ĳ��רҵ����Ϣ
	public void InsertDept(Dept dept) {
		deptDao.InsertDept(dept);

	}

	// ɾ��ĳ��רҵ����Ϣ
	public void DeleteDept(String DeptNum) {
		deptDao.DeleteDept(DeptNum);
	}
}
