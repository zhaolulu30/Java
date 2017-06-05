package bean;

import java.sql.*;

public class Student {
	private String sname;
	private String sid;
	private String password;
	private String sclass;
	private String sex;
	private String teacher;
	private String reDate;
	private String remark;

	public String getSname(){
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}

	public ResultSet getStudent(){
		String sql="select * from student";
		sqlBean db=new sqlBean();
		ResultSet rs=db.executeQuery(sql);
		return rs;		
	} 
	public ResultSet getSname(String s_id){
		String sql="select sname from student where id='"+s_id+"'";
		sqlBean db=new sqlBean();
		ResultSet rs=db.executeQuery(sql);
		return rs;
	}
	public ResultSet  getStuOne(String s_id){
		String sql="select * from student where id ='"+s_id+"'";
		sqlBean db= new sqlBean();
		ResultSet rs = db.executeQuery(sql);
		return rs;
	}	
	public ResultSet getSmajor(String s_id){
		String sql="select smajor from student where id='"+s_id+"'";
		sqlBean db=new sqlBean();
		ResultSet rs=db.executeQuery(sql);
		return rs;
	}
	public ResultSet getSnameId(String sclass){
		String sql="select id,sname,from student where sclass='"+sclass+"'";
		sqlBean db=new sqlBean();
		ResultSet rs=db.executeQuery(sql);
		return rs;
	}
	public boolean haslogin(String sid){
		boolean f=true;
		String sql="select id from student where id='"+sid+"'";
		sqlBean db=new sqlBean();
		try{
			ResultSet rs=db.executeQuery(sql);
			if(rs.next())
				f=true;
			else
				f=false;
			
		}
		catch(Exception e){
			e.getMessage();
		}
		return f;
	}
	public void addStudent(){
		String sql="insert into student(id,sname,password,sclass,sex,teacher,reDate,remark) values ('"
			+sid+"','"+sname+"','"+password+"','"+sclass+"','"+sex+"','"+teacher+"','"+reDate+"','"+remark+"')";
		sqlBean db=new sqlBean();
		db.executeInsert(sql);
	}
	public int deleteStudent(String id){
	    int num=0;
	    String sql="delete  from student where id ='"+id+"' ";
	    sqlBean db= new sqlBean();
	    num=db.executeDelete(sql);
	    return num;
	}  
	public void updateStudent(){
		String sql="update student "+" set sname='"+sname+"',"+" password='"+password+"',"+" sex='"+sex+"',"+" sclass='"+sclass
		+"' "+" where id='"+sid+"'";
		sqlBean db=new sqlBean();
		db.executeInsert(sql);
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getReDate() {
		return reDate;
	}
	public void setReDate(String reDate) {
		this.reDate = reDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
