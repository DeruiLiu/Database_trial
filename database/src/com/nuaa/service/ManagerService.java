package com.nuaa.service;

import java.util.List;

import com.nuaa.dao.ManagerDao;
import com.nuaa.vo.Manager;

public class ManagerService {
	ManagerDao managerDao = new ManagerDao();

	// 查询全部管理员信息
	public List<Manager> QueryAllManager() {
		return managerDao.QueryAllManager();
	}

	// 查询单个管理员信息
	public Manager QueryManagerById(String ManagerNum) {
		return managerDao.QueryManagerById(ManagerNum);
	}

	// 修改某个管理员信息
	public void UpdateManager(Manager manager) {
		managerDao.UpdateManager(manager);
	}

	// 插入某个管理员的信息
	public void InsertManager(Manager manager) {
		managerDao.InsertManager(manager);
	}

	// 删除某个管理员的信息
	public void DeleteManager(String ManagerNum) {
		managerDao.DeleteManager(ManagerNum);
	}

	// 判断是否存在该条管理员信息，即是否登陆成功
	public Manager login(String ManagerNum, String ManagerPassword) {
		return managerDao.LoginJudge(ManagerNum, ManagerPassword);
	}
}
