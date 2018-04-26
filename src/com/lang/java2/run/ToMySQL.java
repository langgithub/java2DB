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
	 * Excel·��
	 */
	static String excelUrl=DBManager.getConfig().getExcelUrl();
	/**
	 * ���ݿ�����
	 */
	static String tableName=DBManager.getConfig().getTableName();
	/**
	 * ���ӹ�����
	 */
	DBConnection dbConnection=null;
	Connection conn=null;
	
	public ToMySQL() {
		dbConnection=new DBConnection();
		conn=dbConnection.getConnetion();
	}
	
	/**
	 * �������ݿ�
	 * @param sql 
	 */
	public void createTb(String sql){
		Statement statement = null;
	    try {
			statement=conn.createStatement();
			statement.execute(sql);
			//���ӳعر�
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
			//Excel��ȡ
			List<List<Object>> allRow = ReadExcel.readExcel(new File(excelUrl));
			//sql���
			String createSql = "";
			String primary_key="";
			
			createSql += "create table " + tableName + "(";
			for (int i = 0; i < allRow.size(); i++) {
				List<Object> row = allRow.get(i);
				if (i == 0) {
					createSql += row.get(0) + " " + row.get(1) + "(" + row.get(2).toString().substring(0, 2)
							+ ") not null,";
					primary_key=String.valueOf(row.get(0));
				} else {
					if ("varchar".equals(row.get(1))||"char".equals(row.get(1))||"int".equals(row.get(1))||
                            "decimal".equals(row.get(1))){
						createSql += row.get(0) + " " + row.get(1) + "(" + row.get(2).toString()
								+ ") default null";
						createSql += " comment" + " '" + row.get(3) + "',";
					}else {
						createSql += row.get(0) + " " + row.get(1) + " default null";
						createSql += " comment" + " '" + row.get(2) + "',";
					}

				}
			}
			createSql += "primary key ("+primary_key+"))";
			createSql += "engine=INNODB default charset=utf8;";
			System.out.println(createSql);
			createTb(createSql);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
   public static void main(String[] args) {
		new ToMySQL().createTableTest();
	}

}
