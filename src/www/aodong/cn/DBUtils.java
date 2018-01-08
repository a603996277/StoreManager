	package www.aodong.cn;
	import java.sql.SQLException;
import java.sql.Statement;
	import java.sql.Connection;
	import java.sql.DriverManager;
import java.sql.ResultSet;
	public class DBUtils {
		
		// 默认的数据库参数
		private String driver = "com.mysql.jdbc.Driver"; // 获取mysql数据库的驱动类
		private String url = "jdbc:mysql://localhost:3306/test";
		private String name = "root";// 连接mysql的用户名
		private String pwd = "603996277";// 连接mysql的密码    
		private String sql = "select * from test.use order by id desc limit 1 ";
		private volatile static DBUtils dbUtils;// 把自己定义为变量名
		static ResultSet	rs;
		static String str="";
		public static DBUtils getInstance() {
			if (null == dbUtils) {
				synchronized (DBUtils.class) {
					if (null == dbUtils) {  
						dbUtils = new DBUtils();
					}
				}
			}
			return dbUtils;
		}
		
	
		public ResultSet getResultSet() throws Exception {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, name, pwd);// 获取连接对象
			Statement statement = conn.createStatement();
			return statement.executeQuery(sql);
			}
		public int getUPResultSet() throws Exception {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, name, pwd);// 获取连接对象
			Statement statement = conn.createStatement();
			return statement.executeUpdate(sql);
			}

	   
		/**
		 * 设置数据库驱动类
		 * 
		 * @param driver
		 */
		public void setDriver(String driver) {
			this.driver = driver;
		}
	
		/**
		 * 设置URL
		 * 
		 * @param url
		 */
		public void setUrl(String url) {
			this.url = url;
		}
	
		/**
		 * 设置数用户名
		 * 
		 * @param name
		 */
		public void setName(String name) {
			this.name = name;
		}
	
		/**
		 * 设置数据库密码
		 * 
		 * @param pwd
		 */
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
	
		/**
		 * 设置数据库SQL查询语句
		 * 
		 * @param sql
		 */
		public void setSql(String sql) {
			this.sql = sql;
		}
		/*public static void main(String[] args) {
	
			DBUtils dbUtils = DBUtils.getInstance();  
			// 重新设置初始值 有需要的话
			// dbUtils.setName(name);
			// dbUtils.setDriver(sql);
			// dbUtils.setPwd(pwd);
			// dbUtils.setUrl(url);
			// dbUtils.setSql(sql);
			try {
				rs = dbUtils.getResultSet();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				while (rs.next()) {
					str = rs.getString("name");
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(str);
		}*/


		
	}
