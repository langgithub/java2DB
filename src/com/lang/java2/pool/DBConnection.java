package com.lang.java2.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lang.java2.db.DBManager;

/**
 * ���ӳؿ��Ƕ����ݿ��������
 * @author lang
 *
 */
public class DBConnection {

	private  List<Connection> pool;//�����ض���
	
	/**
	 * ���������
	 */
	private static  int  POOL_MAX_SIZE;
	/**
	 * ��С������
	 */
	private static  int POOL_MIN_SIZE;
	static{
		POOL_MAX_SIZE=DBManager.getConfig().getPoolMaxSize();
		POOL_MIN_SIZE=DBManager.getConfig().getPoolMinSize();
	}
	public DBConnection() {
		init();
	}
	public void init(){
		if(pool==null){
			pool=new ArrayList<Connection>();
		}
		while(pool.size()<POOL_MIN_SIZE){
			pool.add(DBManager.createConnection());
			System.out.println();
		}
	}
	/**
	 * �����ӳ���ȡһ������
	 * @return
	 */
	public synchronized  Connection getConnetion(){
		int last_index=pool.size()-1;
		Connection conn=pool.get(last_index);
		pool.remove(last_index);
		return conn;
	}
	
	public synchronized void close(Connection conn){
		if(pool.size()>POOL_MAX_SIZE){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		pool.add(conn);
	}
}
