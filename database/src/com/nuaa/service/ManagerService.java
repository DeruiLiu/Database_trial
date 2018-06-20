package com.nuaa.service;

import java.util.List;

import com.nuaa.dao.ManagerDao;
import com.nuaa.vo.Manager;

public class ManagerService {
	ManagerDao managerDao = new ManagerDao();

	// ��ѯȫ������Ա��Ϣ
	public List<Manager> QueryAllManager() {
		return managerDao.QueryAllManager();
	}

	// ��ѯ��������Ա��Ϣ
	public Manager QueryManagerById(String ManagerNum) {
		return managerDao.QueryManagerById(ManagerNum);
	}

	// �޸�ĳ������Ա��Ϣ
	public void UpdateManager(Manager manager) {
		managerDao.UpdateManager(manager);
	}

	// ����ĳ������Ա����Ϣ
	public void InsertManager(Manager manager) {
		managerDao.InsertManager(manager);
	}

	// ɾ��ĳ������Ա����Ϣ
	public void DeleteManager(String ManagerNum) {
		managerDao.DeleteManager(ManagerNum);
	}

	// �ж��Ƿ���ڸ�������Ա��Ϣ�����Ƿ��½�ɹ�
	public Manager login(String ManagerNum, String ManagerPassword) {
		return managerDao.LoginJudge(ManagerNum, ManagerPassword);
	}
}
