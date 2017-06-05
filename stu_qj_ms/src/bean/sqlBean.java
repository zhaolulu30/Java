package bean;
import java.sql.*;
import java.io.*;
public class sqlBean {
	public Connection conn=null;
	public ResultSet rs=null;
	Statement st=null;

	public sqlBean(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/stu_qj_ms?user=root&password=root&useUnicode=true&characterEncoding=utf8";
			conn=DriverManager.getConnection(url);
			st=conn.createStatement(1004,1008);
		}
		catch(java.lang.ClassNotFoundException e){
			System.err.println("加载驱动器有错误:"+e.getMessage());
			System.out.print("执行插入有错误:"+e.getMessage());//输出到客户端
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int executeInsert(String sql){
		int num=0;
		try{
			num=st.executeUpdate(sql);
		}
		catch(SQLException e){
			System.err.println("执行插入有错误:"+e.getMessage());
			System.out.print("执行插入有错误:"+e.getMessage());
		}
		return num;
	}
	public ResultSet executeQuery(String sql){
		rs=null;
		try{
			rs=st.executeQuery(sql);
		}
		catch(SQLException e){
			System.err.println("执行查询有错误:"+e.getMessage());
			System.out.print("执行查询有错误:"+e.getMessage());//输出到客户端
		}
		return rs;
	}
	public int Update(String sql){
		int num=0;
		try{
			num=st.executeUpdate(sql);
		}catch(SQLException ex){
			System.err.println("执行修改有错误："+ex.getMessage());
			System.out.print("执行修改有错误："+ex.getMessage());//输出到客户端
		}
		return num;
	}
	public int executeDelete(String sql){
		int num=0;
		try{
			num=st.executeUpdate(sql);
		}
		catch(SQLException e){
			System.err.println("执行删除有错误:"+e.getMessage());
			System.out.print("执行删除有错误:"+e.getMessage());
		}
		CloseDataBase();
		return num;
	}
	public void CloseDataBase(){
		try{
			conn.close();
			st.close();
		}
		catch(Exception ex){
			System.err.println("执行关闭Connection对象有错误:"+ex.getMessage());
			System.out.print("执行关闭Connection对象有错误:"+ex.getMessage());
		}
	}

}
