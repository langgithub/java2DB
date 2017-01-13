package com.lang.java2.model;
/**
 * ����������Ϣ
 * @author lang
 *
 */
public class Configuration {

	/**
	 * ���ݿ�����
	 */
	private String driver;
	/**
	 * jdbc url
	 */
	private String url;
	/**
	 * ���ݿ��û���
	 */
	private String user;
	/**
	 * ���ݿ�����
	 */
	private String pwd;
	/**
	 * ʹ���������ݿ�
	 */
	private String usingDB;
	/**
	 * ��ĿԴ��·��
	 */
	private String srcPath;
	/**
	 * ɨ������java��İ���po��˼��persistent object��
	 */
	private String poPackage;
	
	private String className;
	/**
	 * ���ӳ�������������
	 */
	private int poolMaxSize;
	/**
	 * ���ӳ��е���С������
	 */
	private int poolMinSize;
	/**
	 * ���ݿ�����
	 */
	private String tableName;
	/**
	 * Excel·��
	 */
    private String excelUrl;
	
	public String getExcelUrl() {
		return excelUrl;
	}

	public void setExcelUrl(String excelUrl) {
		this.excelUrl = excelUrl;
	}

	public int getPoolMaxSize() {
		return poolMaxSize;
	}
	public void setPoolMaxSize(int poolMaxSize) {
		this.poolMaxSize = poolMaxSize;
	}
	public int getPoolMinSize() {
		return poolMinSize;
	}
	public void setPoolMinSize(int poolMinSize) {
		this.poolMinSize = poolMinSize;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Configuration() {

	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUsingDB() {
		return usingDB;
	}
	public void setUsingDB(String usingDB) {
		this.usingDB = usingDB;
	}
	public String getSrcPath() {
		return srcPath;
	}
	public void setSrcPath(String srcPath) {
		this.srcPath = srcPath;
	}
	public String getPoPackage() {
		return poPackage;
	}
	public void setPoPackage(String poPackage) {
		this.poPackage = poPackage;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
}
