package impl;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PicDao;
import entity.Pic;
import bean.Student;

public class PicDaoImp implements PicDao {
	
		
	

	   public List<Pic> findBySid(String id)throws Exception{
		   List<Pic> picList = new ArrayList<Pic>();
			Connection conn = null;
			try {
				// 加载数据库驱动
				Class.forName("com.mysql.jdbc.Driver");

				// 获取数据库连接
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/stu_qj_ms", "root", "root");

				// 创建预处理语句对象
				PreparedStatement pStmt = conn
						.prepareStatement("select * from pic where sid= ?");
				pStmt.setString(1, id);

				// 执行sql语句，得到结果集对象
				ResultSet rs = pStmt.executeQuery();

				// List是一个接口，相当于数据结构中的线性表(包括顺序表、链表)
				// ArrayList是List接口的一个实现类，相当于线性表中的顺序表，是一种可伸缩的动态数组
				// 创建存放查询结果的集合对象
				

				// 将结果集转化为对象集合
				while (rs.next()) {
					// 将结果集中的一条记录转化为一个Employee对象
					Pic pic=new Pic();
					pic.setId(rs.getInt("id"));
					pic.setFilename(rs.getString("filename"));
				    pic.setSid(rs.getString("sid"));
				    picList.add(pic);
					
					// ResultSet的getDate方法返回的是java.sql.Date对象
					// java.sql.Date只表示日期，对应数据库中的date类型
					// java.sql.Date是java.util.Date的子类，子类对象赋值给父类参数没问题
					
				}
				// 关闭结果集对象
				rs.close();
				// 关闭语句对象
				pStmt.close();

				// 遍历对象列表
				return picList;
			
			} catch (Exception e) {
				// 打印异常的调用链信息
				e.printStackTrace();
			} finally {
				// 关闭数据库连接
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {

					}
				}
				
			}
			return picList;
	   }
	   
	   public void delete(int id)throws Exception{
			Connection conn = null;
			try {
				// 加载数据库驱动
				Class.forName("com.mysql.jdbc.Driver");

				// 获取数据库连接
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/stu_qj_ms", "root", "root");

				// 创建预处理语句对象
				PreparedStatement pStmt = conn
						.prepareStatement("delete  from pic where id=? ");

				// 设置预处理语句的参数
			   pStmt.setInt(1, id);
				pStmt.executeUpdate();

				// 关闭语句对象
				pStmt.close();
			} finally {
				// 关闭数据库连接
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {

					}
				}
			}

	   }

	   public void add(Pic pic) throws Exception{
			Connection conn = null;
			try {
				// 加载数据库驱动
				Class.forName("com.mysql.jdbc.Driver");

				// 获取数据库连接
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/stu_qj_ms", "root", "root");

				// 创建预处理语句对象
				PreparedStatement pStmt = conn
						.prepareStatement("insert into pic(filename,sid,tid,fid) values(?,?,?,?)");

				// 设置预处理语句的参数
				pStmt.setString(1,pic.getFilename());
				pStmt.setString(2,pic.getSid());
				pStmt.setString(3,pic.getTid());
				pStmt.setString(4,pic.getFid());
				
			// 执行sql语句
				pStmt.executeUpdate();

				// 关闭语句对象
				pStmt.close();
			} finally {
				// 关闭数据库连接
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {

					}
				}
			}

		}
	
}
