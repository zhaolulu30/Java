	package impl;

	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.QingJia;
import bean.QueryCondition;
import bean.QueryCondition1;
import bean.Student;
import dao.QingjiaDao;


	public class QingJiaDaoImp implements QingjiaDao {
		
		@Override
		

	
		public List<QingJia> findByCondition(QueryCondition condition)
				throws Exception {
			Connection conn = null;
			List<QingJia> qjList = new ArrayList<QingJia>();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/stu_qj_ms", "root", "root");
				String sql="select * from qingjia  where 1=1 ";
				
				List<Object> params=new ArrayList<Object>();
				if(condition.getDays()!=0){
					sql+="and days>? ";
					params.add(condition.getDays());
				}else {
					
				}
				if(!condition.getRedate().equals("")){
					sql+="and redate =?";
					params.add(condition.getRedate());
				}else{
					
				}if(!condition.getTid().equals("")){
					sql+="and tid=?";
					params.add(condition.getTid());
				}
				
				PreparedStatement pStmt = conn
						.prepareStatement(sql);
				
				 
				//System.out.print("赵露露"+params.get(0)+params.get(1));  
			            for(int i =0 ; i < params.size(); i++)  
				            {  
				                //+1 是因为有一个确定的参数，如果都为动态不确定的参数，可以多判断一下  
			           			   pStmt.setObject(i+1 , params.get(i));  
				            }  
				        
				 ResultSet rs = pStmt.executeQuery();
				 while (rs.next()) {
						QingJia qj = new QingJia();
						
						qj.setKid(rs.getInt("kid"));
						qj.setSid(rs.getString("sid"));
						qj.setCid(rs.getString("cid"));
						qj.setCourseTime(rs.getString("courseTime"));
						qj.setKtype(rs.getString("ktype"));
						qj.setRedate(rs.getString("redate"));
						// ResultSet的getDate方法返回的是java.sql.Date对象
						// java.sql.Date只表示日期，对应数据库中的date类型
						// java.sql.Date是java.util.Date的子类，子类对象赋值给父类参数没问题
						qj.setTid(rs.getString("tid"));
						qj.setFid(rs.getString("fid"));
						qj.setContent(rs.getString("content"));
						qj.setDays(rs.getInt("days"));
						qj.setIson(rs.getInt("ison"));
						qj.setIsfu(rs.getInt("isfu"));
						qjList.add(qj);
					}
					pStmt.close();
				} finally {
					if (conn != null)
						conn.close();
				}
				return qjList;
			}

		@Override
		public List<QingJia> findByCondition1(QueryCondition1 condition1)
				throws Exception {
			Connection conn = null;
			List<QingJia> qjList1 = new ArrayList<QingJia>();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/stu_qj_ms", "root", "root");
				String sql="select * from qingjia  where 1=1 ";
				
				List<Object> params=new ArrayList<Object>();
				if(!condition1.getKtype().equals("")){
					sql+="and days=? ";
					params.add(condition1.getKtype());
				}else {
					
				}
				if(!condition1.getRedate().equals("")){
					sql+="and redate =?";
					params.add(condition1.getRedate());
				}else{
					
				}
				
				PreparedStatement pStmt = conn
						.prepareStatement(sql);
				
				 
				//System.out.print("赵露露"+params.get(0)+params.get(1));  
			            for(int i =0 ; i < params.size(); i++)  
				            {  
				                //+1 是因为有一个确定的参数，如果都为动态不确定的参数，可以多判断一下  
			           			   pStmt.setObject(i+1 , params.get(i));  
				            }  
				        
				 ResultSet rs = pStmt.executeQuery();
				 while (rs.next()) {
						QingJia qj1 = new QingJia();
						
						qj1.setKid(rs.getInt("kid"));
						qj1.setSid(rs.getString("sid"));
						qj1.setCid(rs.getString("cid"));
						qj1.setCourseTime(rs.getString("courseTime"));
						qj1.setKtype(rs.getString("ktype"));
						qj1.setRedate(rs.getString("redate"));
						// ResultSet的getDate方法返回的是java.sql.Date对象
						// java.sql.Date只表示日期，对应数据库中的date类型
						// java.sql.Date是java.util.Date的子类，子类对象赋值给父类参数没问题
						qj1.setTid(rs.getString("tid"));
						qj1.setFid(rs.getString("fid"));
						qj1.setContent(rs.getString("content"));
						qj1.setDays(rs.getInt("days"));
						qj1.setIson(rs.getInt("ison"));
						qj1.setIsfu(rs.getInt("isfu"));
						qjList1.add(qj1);
					}
					pStmt.close();
				} finally {
					if (conn != null)
						conn.close();
				}
				return qjList1;
			}
	}
