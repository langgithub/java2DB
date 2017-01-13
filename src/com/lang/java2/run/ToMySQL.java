package com.lang.java2.run;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.lang.java2.db.DBManager;
import com.lang.java2.pool.DBConnection;
import com.lang.java2.util.ReadExcel;

public class ToMySQL {
	
	/**
	 * Excel路径
	 */
	static String excelUrl=DBManager.getConfig().getExcelUrl();
	/**
	 * 数据库名称
	 */
	static String tableName=DBManager.getConfig().getTableName();
	/**
	 * 连接管理器
	 */
	DBConnection dbConnection=null;
	Connection conn=null;
	
	public ToMySQL() {
		dbConnection=new DBConnection();
		conn=dbConnection.getConnetion();
	}
	
	/**
	 * 创建数据库
	 * @param sql 
	 */
	public void createTb(String sql){
		Statement statement = null;
	    try {
			statement=conn.createStatement();
			statement.execute(sql);
			//连接池关闭
			dbConnection.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(statement!=null){
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}	
	}
	
	public void createTableTest() {

		try {
			//Excel读取
			List<List<Object>> allRow = ReadExcel.readExcel(new File(excelUrl));
			//sql语句
			String createSql = "";
			
			createSql += "create table " + tableName + "(";
			for (int i = 0; i < allRow.size(); i++) {
				List<Object> row = allRow.get(i);
				if (i == 0) {
					createSql += row.get(0) + " " + row.get(1) + "(" + row.get(2).toString().substring(0, 2)
							+ ") not null,";
				} else {
					createSql += row.get(0) + " " + row.get(1) + "(" + row.get(2).toString().substring(0, 2)
							+ ") default null";
					createSql += " comment" + " '" + row.get(3) + "',";
				}
			}
			createSql += "primary key (id))";
			createSql += "engine=myisam default charset=utf8;";
			System.out.println(createSql);
			createTb(createSql);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
   /* public static void main(String[] args) {
		new ToMySQL().createTableTest();
	}*/

}
