package com.lang.java2.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.lang.java2.model.Configuration;
import com.lang.java2.pool.DBConnection;


/**
 * ����������Ϣ��ά�����Ӷ���Ĺ����������ӳع��ܣ�
 * @author lang
 *
 */
@SuppressWarnings("all")
public class DBManager {

	private static Configuration config;
	private static DBConnection dbc;
	static{
		Properties pro=new Properties();
		try {
			pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		config=new Configuration();
		config.setDriver(pro.getProperty("driver"));
		config.setUrl(pro.getProperty("url"));
		config.setUser(pro.getProperty("user"));
		config.setPwd(pro.getProperty("pwd"));
		config.setUsingDB(pro.getProperty("userDB"));
		config.setPoPackage(pro.getProperty("poPackage"));
		config.setSrcPath(pro.getProperty("srcPath"));
		config.setClassName(pro.getProperty("queryClass"));
		config.setPoolMaxSize(Integer.parseInt(pro.getProperty("poolMaxSize")));
		config.setPoolMinSize(Integer.parseInt(pro.getProperty("poolMinSize")));
		config.setTableName(pro.getProperty("tableName"));
		config.setExcelUrl(pro.getProperty("excelUrl"));
		
		
	}
	/**
	 * ����connection ����
	 * @return
	 */
	public static Connection createConnection(){
		try {
			Class.forName(config.getDriver());
			return DriverManager.getConnection(config.getUrl(),config.getUser(),config.getPwd());
		}  catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * ���connection ����
	 * @return
	 */
	public static Connection getConnection(){
		if(dbc==null){
			dbc=new DBConnection();
		}
		return dbc.getConnetion();
	}
	/**
	 * �ر�connetion����
	 * @param rs
	 * @param conn
	 * @param statement
	 */
	public static void close(ResultSet rs,Connection conn,PreparedStatement statement){
		if(statement!=null){
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		dbc.close(conn);
	}
	public static void close(Connection conn,PreparedStatement statement){
		if(statement!=null){
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		dbc.close(conn);
	}
	/**
	 * ��ȡ��ȡ�����ļ���properties
	 * @return
	 */
	public static Configuration getConfig(){
		return config;
	}
}
