package com.nuaa.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class DButil {
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/people";
	private String user = "root";
	private String password = "0208";
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rSet;
	private String sql = null;	//����ģʽ������ÿ��ʹ��ʱ������һ��DButil
	private static final DButil util=new DButil();

	private DButil() {

	}

	public static DButil getInstance() {
		return util;
	}

	public Connection getconnection() {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
	}

	// ����
	public void update(String sql, List<Object> params) {
		try {
			ps = connection.prepareStatement(sql);
			if (params != null && params.size() > 0) {
				for (int i = 0; i < params.size(); i++) {
					ps.setObject(i + 1, params.get(i));
				}
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ��ѯ
	public ResultSet query(String sql, List<Object> params) {
		try {
			ps = connection.prepareStatement(sql);// ���ܲ�ѯ��������params����Ϊ��
			if (params != null && params.size() > 0) {
				for (int i = 0; i < params.size(); i++) {
					ps.setObject(i + 1, params.get(i));
				}
			}
			rSet = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rSet;

	}

	public void close() {
		try {
			if (rSet != null) {
				rSet.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
