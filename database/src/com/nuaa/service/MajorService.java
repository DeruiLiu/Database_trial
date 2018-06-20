package com.nuaa.service;

import java.util.List;

import com.nuaa.dao.MajorDao;
import com.nuaa.dao.ManagerDao;
import com.nuaa.vo.Major;
import com.nuaa.vo.Manager;

public class MajorService {
	MajorDao majorDao = new MajorDao();

	// 查询全部专业信息
	public List<Major> QueryAllMajor() {
		return majorDao.QueryAllMajor();
	}

	// 查询单个专业信息
	public Major QueryMajorById(String MajorNum) {
		return majorDao.QueryMajorById(MajorNum);
	}

	// 修改某个专业信息
	public void UpdateMajor(Major major) {
		majorDao.UpdateMajor(major);
	}

	// 插入某个专业的信息
	public void InsertMajor(Major major) {
		majorDao.InsertMajor(major);
	}

	// 删除某个专业的信息
	public void DeleteMajor(String MajorNum) {
		majorDao.DeleteMajor(MajorNum);
	}

}
