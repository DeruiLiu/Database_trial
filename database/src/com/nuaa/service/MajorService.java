package com.nuaa.service;

import java.util.List;

import com.nuaa.dao.MajorDao;
import com.nuaa.dao.ManagerDao;
import com.nuaa.vo.Major;
import com.nuaa.vo.Manager;

public class MajorService {
	MajorDao majorDao = new MajorDao();

	// ��ѯȫ��רҵ��Ϣ
	public List<Major> QueryAllMajor() {
		return majorDao.QueryAllMajor();
	}

	// ��ѯ����רҵ��Ϣ
	public Major QueryMajorById(String MajorNum) {
		return majorDao.QueryMajorById(MajorNum);
	}

	// �޸�ĳ��רҵ��Ϣ
	public void UpdateMajor(Major major) {
		majorDao.UpdateMajor(major);
	}

	// ����ĳ��רҵ����Ϣ
	public void InsertMajor(Major major) {
		majorDao.InsertMajor(major);
	}

	// ɾ��ĳ��רҵ����Ϣ
	public void DeleteMajor(String MajorNum) {
		majorDao.DeleteMajor(MajorNum);
	}

}
