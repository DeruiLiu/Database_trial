package com.nuaa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nuaa.util.DButil;

public class PageDao {
	private DButil util = DButil.getInstance();
	private String sql = null;
	private PreparedStatement ps;
	private Connection connection;
	private ResultSet rSet;
	
	public int CountNumbers() {
		util.getconnection();
		sql="select count(*) from student";
		rSet=util.query(sql, null);
		int Count = 0;
		try {
			while(rSet.next()) {
				Count=rSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.close();
		}
		return Count;
	}
}
