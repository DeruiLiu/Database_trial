package com.nuaa.service;

import com.nuaa.dao.PageDao;

public class PageService {
	PageDao pageDao=new PageDao();
	
	public int CountNumer() {
		return pageDao.CountNumbers();
	}
}
