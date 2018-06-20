package com.nuaa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nuaa.util.DButil;
import com.nuaa.vo.Manager;
import com.nuaa.vo.Teacher;

public class ManagerDao {
	private DButil util = DButil.getInstance();
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rSet;
	private String sql = null;

	// ��ѯȫ������Ա��Ϣ
	public List<Manager> QueryAllManager() {
		util.getconnection();
		sql = "select * from manager";
		rSet = util.query(sql, null);
		List<Manager> list = new ArrayList<Manager>();
		try {
			while (rSet.next()) {
				Manager manager = new Manager();
				manager.setManagerBirthday(rSet.getString("ManagerBirthday"));
				manager.setManagerName(rSet.getString("ManagerName"));
				manager.setManagerNum(rSet.getString("ManagerNum"));
				manager.setManagerPassword(rSet.getString("ManagerPassword"));
				manager.setManagerSex(rSet.getString("ManagerSex"));
				list.add(manager);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close();
		}
		return list;
	}

	// ��ѯ��������Ա��Ϣ
	public Manager QueryManagerById(String ManagerNum) {
		util.getconnection();
		sql = "select * from manager where ManagerNum=?";
		List<Object> list=new ArrayList<Object>();
		list.add(ManagerNum);
		Manager manager=new Manager();
		rSet=util.query(sql, list);
		try {
			while(rSet.next()) {
				manager.setManagerBirthday(rSet.getString("ManagerBirthday"));
				manager.setManagerName(rSet.getString("ManagerName"));
				manager.setManagerNum(rSet.getString("ManagerNum"));
				manager.setManagerPassword(rSet.getString("ManagerPassword"));
				manager.setManagerSex(rSet.getString("ManagerSex"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.close();
		}
		return manager;
	}
	//���뵥������Ա����Ϣ
	public void InsertManager(Manager manager) {
		util.getconnection();
		sql="insert into manager(ManagerNum,ManagerName,ManagerSex,ManagerBirthday,"
				+ "ManagerPassword) values(?,?,?,?,?)";
		List<Object> list=new ArrayList<Object>();
		list.add(manager.getManagerNum());
		list.add(manager.getManagerName());
		list.add(manager.getManagerSex());
		list.add(manager.getManagerBirthday());
		list.add(manager.getManagerPassword());
		util.update(sql, list);
		util.close();
	}
	//����ĳ������Ա����Ϣ
	public void UpdateManager(Manager manager) {
		util.getconnection();
		sql="update manager set ManagerName=?,ManagerSex=?,ManagerBirthday=?,"
				+ "ManagerPassword=? where ManagerNum=?";
		List<Object>list=new ArrayList<Object>();
		list.add(manager.getManagerName());
		list.add(manager.getManagerSex());
		list.add(manager.getManagerBirthday());
		list.add(manager.getManagerPassword());
		list.add(manager.getManagerNum());
		util.update(sql, list);
		util.close();
	}
	//ɾ��ĳ������Ա����Ϣ
	public void DeleteManager(String ManagerNum) {
		util.getconnection();
		sql="delete from manager where ManagerNum=?";
		List<Object> list=new ArrayList<Object>();
		list.add(ManagerNum);
		util.update(sql, list);
		util.close();
	}
	//�жϹ���Ա�Ƿ��½�ɹ�
			public Manager LoginJudge(String ManagerNum,String ManagerPassword) {
				util.getconnection();
				sql="select * from manager where ManagerNum=? and ManagerPassword=?";
				List<Object> params=new ArrayList<Object>();
				Manager manager=new Manager();
				params.add(ManagerNum);
				params.add(ManagerPassword);
				rSet=util.query(sql, params);
				try {
					if(rSet.next()) {
						manager.setManagerBirthday(rSet.getString("ManagerBirthday"));
						manager.setManagerName(rSet.getString("ManagerName"));
						manager.setManagerNum(rSet.getString("ManagerNum"));
						manager.setManagerPassword(rSet.getString("ManagerPassword"));
						manager.setManagerSex(rSet.getString("ManagerSex"));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					util.close();
				}
				return manager;
			}
}
