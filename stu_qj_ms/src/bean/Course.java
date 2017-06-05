package bean;

import java.sql.*;

import bean.sqlBean;

public class Course {
	private String cid;
	
	private String cname;
	private double credit;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	
	
	public ResultSet getCourse(){
		String sql="select * from course";
		sqlBean db=new sqlBean();
		ResultSet rs=db.executeQuery(sql);
		return rs;
	}

	public ResultSet getCinfo(String cid){
	    String sql="select * from course where cid='"+cid+"'";
	    sqlBean db=new sqlBean();
	    ResultSet rs=db.executeQuery(sql);
	    return rs;
	}
	public boolean isValid(String cno){
		boolean f=true;
		String sql="select cid from course where cid='"+cid+"'";
		sqlBean db=new sqlBean();
		try{
			ResultSet rs=db.executeQuery(sql);
			if(rs.next()){
				f=true;
			}
			else{
				f=false;
				}
		}
		catch(Exception e){
			e.getMessage();
		}
		return f;
		
	}
	public ResultSet  getCouOne(String c_id){
		String sql="select * from course where cid ='"+c_id+"'";
		sqlBean db= new sqlBean();
		ResultSet rs = db.executeQuery(sql);
		return rs;
	}	
	public void addCourse(){
		String sql="insert into course(cid,cname,credit) values ('"+cid+"','"+cname+"',"+credit+")";
		sqlBean db=new sqlBean();
		db.executeInsert(sql);
	}
	public int delcourse(String cid){
		int num=0;
		String sql="delete from course where cid='"+cid+"'";
		sqlBean db=new sqlBean();
		num=db.executeDelete(sql);
		return num;
	}
	public void updateCourse(){
		String sql="update course set cid='"+cid+"',cname='"+cname+"',credit="+credit
		+" where cid='"+cid+"'";
		sqlBean db=new sqlBean();
		db.Update(sql);
	}

}
