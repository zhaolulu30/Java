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
				// �������ݿ�����
				Class.forName("com.mysql.jdbc.Driver");

				// ��ȡ���ݿ�����
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/stu_qj_ms", "root", "root");

				// ����Ԥ����������
				PreparedStatement pStmt = conn
						.prepareStatement("select * from pic where sid= ?");
				pStmt.setString(1, id);

				// ִ��sql��䣬�õ����������
				ResultSet rs = pStmt.executeQuery();

				// List��һ���ӿڣ��൱�����ݽṹ�е����Ա�(����˳�������)
				// ArrayList��List�ӿڵ�һ��ʵ���࣬�൱�����Ա��е�˳�����һ�ֿ������Ķ�̬����
				// ������Ų�ѯ����ļ��϶���
				

				// �������ת��Ϊ���󼯺�
				while (rs.next()) {
					// ��������е�һ����¼ת��Ϊһ��Employee����
					Pic pic=new Pic();
					pic.setId(rs.getInt("id"));
					pic.setFilename(rs.getString("filename"));
				    pic.setSid(rs.getString("sid"));
				    picList.add(pic);
					
					// ResultSet��getDate�������ص���java.sql.Date����
					// java.sql.Dateֻ��ʾ���ڣ���Ӧ���ݿ��е�date����
					// java.sql.Date��java.util.Date�����࣬�������ֵ���������û����
					
				}
				// �رս��������
				rs.close();
				// �ر�������
				pStmt.close();

				// ���������б�
				return picList;
			
			} catch (Exception e) {
				// ��ӡ�쳣�ĵ�������Ϣ
				e.printStackTrace();
			} finally {
				// �ر����ݿ�����
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
				// �������ݿ�����
				Class.forName("com.mysql.jdbc.Driver");

				// ��ȡ���ݿ�����
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/stu_qj_ms", "root", "root");

				// ����Ԥ����������
				PreparedStatement pStmt = conn
						.prepareStatement("delete  from pic where id=? ");

				// ����Ԥ�������Ĳ���
			   pStmt.setInt(1, id);
				pStmt.executeUpdate();

				// �ر�������
				pStmt.close();
			} finally {
				// �ر����ݿ�����
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
				// �������ݿ�����
				Class.forName("com.mysql.jdbc.Driver");

				// ��ȡ���ݿ�����
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/stu_qj_ms", "root", "root");

				// ����Ԥ����������
				PreparedStatement pStmt = conn
						.prepareStatement("insert into pic(filename,sid,tid,fid) values(?,?,?,?)");

				// ����Ԥ�������Ĳ���
				pStmt.setString(1,pic.getFilename());
				pStmt.setString(2,pic.getSid());
				pStmt.setString(3,pic.getTid());
				pStmt.setString(4,pic.getFid());
				
			// ִ��sql���
				pStmt.executeUpdate();

				// �ر�������
				pStmt.close();
			} finally {
				// �ر����ݿ�����
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {

					}
				}
			}

		}
	
}
