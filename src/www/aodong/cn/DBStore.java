package www.aodong.cn;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import www.aodong.cn.DBUtils;
public class DBStore {
    DBUtils dbUtils = DBUtils.getInstance(); 
 // 重新设置初始值 有需要的话
 		// dbUtils.setName(name);
 		// dbUtils.setDriver(sql);
 		// dbUtils.setPwd(pwd);
 		// dbUtils.setUrl(url);  
 		// dbUtils.setSql(sql);
    
    //空仓判定
     public String dealNullStare(String sstoreName){
    	 ResultSet rs;
    	 String sstoreNumber="";
    	 String sqlString="SELECT storeNumber FROM test.`use` WHERE storeName='"+sstoreName+"';" ; 
    	 dbUtils.setSql(sqlString);
    	 try {
			rs=dbUtils.getResultSet();
			while (rs.next()) {
				sstoreNumber=rs.getString("storeNumber");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 return sstoreNumber;
     }
   //功能一：提示空的仓库
    public String nullStore() {
    	ResultSet rs;
    	String sstring = "";
    	 dbUtils.setSql("SELECT storeName FROM test.`use` WHERE storeNumber=0 ; ");
		    try {
				rs=dbUtils.getResultSet();
		        String storeNameString="";
			    while (rs.next()) {
			    	
				    storeNameString=rs.getString("storeName");
					sstring+=storeNameString+"  ";
					System.out.println(storeNameString); 
					}
			    System.out.println("空的仓库：  "+sstring);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return sstring;
		    
    }
  //空仓时间归零
    public void setZero() {
        int updatrs;
    	dbUtils.setSql("UPDATE test.`use`SET Etime='0000-00-00 00:00:00',palletName=NULL,palletNumber=Null WHERE storeNumber=0; ");
	    try {
			updatrs=dbUtils.getUPResultSet();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("归零成功"); 
    }
  //功能二：存货，指定仓库添加盘号和盘里物品数量
    public void saveStore(String spalletName,String spalletNumber,String sstoreName) {
    	 String sql2;
    	 int updatrs;
    	// sql ="UPDATE test.`use` SET palletName='A0001',storeNumber='1',palletNumber=3,Etime=CURRENT_TIMESTAMP WHERE storeName='00';";
    	 sql2="UPDATE test.`use` SET palletName='"+spalletName+"',storeNumber='1'"+",palletNumber="+spalletNumber+",Etime=CURRENT_TIMESTAMP"
		    		+" WHERE storeName='"+sstoreName+"';";
		    System.out.println(sql2);
		    dbUtils.setSql(sql2);
		    try {
				updatrs=dbUtils.getUPResultSet();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
    //功能三： 取货，根据盘号获取仓库号和盘内物品数量，整 盘取
    
    public Map getStore(String spalletName){
        int updatrs;
    	String sql3;
    	String sql;
    	String sstoreName = null;
    	String spalletNumber=null;
    	@SuppressWarnings("rawtypes")
		Map map=new HashMap();
    	sql="SELECT storeName,palletNumber FROM test.`use` WHERE palletName='"+spalletName+"';";
    	System.out.println(sql);
    	dbUtils.setSql(sql);
        ResultSet rs = null;
		try {
			rs = dbUtils.getResultSet();
			while (rs.next()) {
				 sstoreName=rs.getString("storeName");
					System.out.println(sstoreName);
					
				spalletNumber=rs.getString("palletNumber");
				    System.out.println(spalletNumber);
				   map.put("1",sstoreName);
				   map.put("2",spalletNumber);
				   
		        }
			System.out.println(map.get("1"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
       
    	//sql="UPDATE test.`use` SET palletName=NULL,storeNumber=0,palletNumber=null,Etime='0000-00-00 00:00:00' WHERE storeName='00';";
	    sql3="UPDATE test.`use` SET palletName=NULL,storeNumber=0,palletNumber=null,Etime='0000-00-00 00:00:00' WHERE storeName='"+sstoreName+"';";
	    System.out.println(sql3);
	    dbUtils.setSql(sql3);
	    try {
			updatrs=dbUtils.getUPResultSet();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return  map;
	    
    }
    
    //图二
	public static void main(String[] args) throws Exception {
		DBUtils dbUtils = DBUtils.getInstance();  
	    DBStore dbStore=new DBStore();
	   Map  rs=   dbStore.getStore("A0002");
		
		
			//功能一：提示空的仓库
		    //空仓时间归零
		    //功能三： 取货，根据盘号获取仓库信息和盘内物品数量
	}
}
