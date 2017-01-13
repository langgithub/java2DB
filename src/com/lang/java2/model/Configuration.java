package com.lang.java2.model;
/**
 * 管理配置信息
 * @author lang
 *
 */
public class Configuration {

	/**
	 * 数据库驱动
	 */
	private String driver;
	/**
	 * jdbc url
	 */
	private String url;
	/**
	 * 数据库用户名
	 */
	private String user;
	/**
	 * 数据库密码
	 */
	private String pwd;
	/**
	 * 使用哪种数据库
	 */
	private String usingDB;
	/**
	 * 项目源码路径
	 */
	private String srcPath;
	/**
	 * 扫描生成java类的包（po意思：persistent object）
	 */
	private String poPackage;
	
	private String className;
	/**
	 * 连接池中最大的连接数
	 */
	private int poolMaxSize;
	/**
	 * 连接池中的最小连接数
	 */
	private int poolMinSize;
	/**
	 * 数据库名称
	 */
	private String tableName;
	/**
	 * Excel路径
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
