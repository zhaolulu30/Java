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
			System.err.println("�����������д���:"+e.getMessage());
			System.out.print("ִ�в����д���:"+e.getMessage());//������ͻ���
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
			System.err.println("ִ�в����д���:"+e.getMessage());
			System.out.print("ִ�в����д���:"+e.getMessage());
		}
		return num;
	}
	public ResultSet executeQuery(String sql){
		rs=null;
		try{
			rs=st.executeQuery(sql);
		}
		catch(SQLException e){
			System.err.println("ִ�в�ѯ�д���:"+e.getMessage());
			System.out.print("ִ�в�ѯ�д���:"+e.getMessage());//������ͻ���
		}
		return rs;
	}
	public int Update(String sql){
		int num=0;
		try{
			num=st.executeUpdate(sql);
		}catch(SQLException ex){
			System.err.println("ִ���޸��д���"+ex.getMessage());
			System.out.print("ִ���޸��д���"+ex.getMessage());//������ͻ���
		}
		return num;
	}
	public int executeDelete(String sql){
		int num=0;
		try{
			num=st.executeUpdate(sql);
		}
		catch(SQLException e){
			System.err.println("ִ��ɾ���д���:"+e.getMessage());
			System.out.print("ִ��ɾ���д���:"+e.getMessage());
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
			System.err.println("ִ�йر�Connection�����д���:"+ex.getMessage());
			System.out.print("ִ�йر�Connection�����д���:"+ex.getMessage());
		}
	}

}
