	package www.aodong.cn;
	import java.sql.SQLException;
import java.sql.Statement;
	import java.sql.Connection;
	import java.sql.DriverManager;
import java.sql.ResultSet;
	public class DBUtils {
		
		// Ĭ�ϵ����ݿ����
		private String driver = "com.mysql.jdbc.Driver"; // ��ȡmysql���ݿ��������
		private String url = "jdbc:mysql://localhost:3306/test";
		private String name = "root";// ����mysql���û���
		private String pwd = "603996277";// ����mysql������    
		private String sql = "select * from test.use order by id desc limit 1 ";
		private volatile static DBUtils dbUtils;// ���Լ�����Ϊ������
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
			Connection conn = DriverManager.getConnection(url, name, pwd);// ��ȡ���Ӷ���
			Statement statement = conn.createStatement();
			return statement.executeQuery(sql);
			}
		public int getUPResultSet() throws Exception {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, name, pwd);// ��ȡ���Ӷ���
			Statement statement = conn.createStatement();
			return statement.executeUpdate(sql);
			}

	   
		/**
		 * �������ݿ�������
		 * 
		 * @param driver
		 */
		public void setDriver(String driver) {
			this.driver = driver;
		}
	
		/**
		 * ����URL
		 * 
		 * @param url
		 */
		public void setUrl(String url) {
			this.url = url;
		}
	
		/**
		 * �������û���
		 * 
		 * @param name
		 */
		public void setName(String name) {
			this.name = name;
		}
	
		/**
		 * �������ݿ�����
		 * 
		 * @param pwd
		 */
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
	
		/**
		 * �������ݿ�SQL��ѯ���
		 * 
		 * @param sql
		 */
		public void setSql(String sql) {
			this.sql = sql;
		}
		/*public static void main(String[] args) {
	
			DBUtils dbUtils = DBUtils.getInstance();  
			// �������ó�ʼֵ ����Ҫ�Ļ�
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
