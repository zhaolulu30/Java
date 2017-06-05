package bean;

import java.sql.*;

public class Instructor {
	private String id;
	private String fname;
	private String password;
	private String sex;
	private String office;
	private String age;
	private String remark;
	private String course;
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public String getName() {return fname;}
	public void setName(String fname) {this.fname = fname;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	
	public ResultSet  getInstructor(){
		String sql="select * from instructor";
		sqlBean db= new sqlBean();
		ResultSet rs = db.executeQuery(sql);
		return rs;
	}	
	public ResultSet  getInsOne(String f_id){
		String sql="select * from Instructor where id ='"+f_id+"'";
		sqlBean db= new sqlBean();
		ResultSet rs = db.executeQuery(sql);
		return rs;
	}	
	public boolean isValid(String id){   
		boolean f=true;
		String sql="select id from teacher where id ='"+id+"'";
		sqlBean db =new sqlBean();
		try{
		    ResultSet rs=db.executeQuery(sql);
		  	if(rs.next()){f=true;}
		  	else{f=false;}
	    }catch(Exception e){ e.getMessage();}
		return f;
	}
	public void addTeacher(){		  
		String sql="insert into teacher(id,tname,password,course,sex,office,age,remark) values ('"
				+id+"','"+fname+"','"+password+"','"+course+"','"+sex+"','"+office+"','"+age+"','"+remark+"')";
			sqlBean db=new sqlBean();
			db.executeInsert(sql);
    }
	public int deleteTeacher(String id){
	    int num=0;
	    String sql="delete  from teacher where id ='"+id+"' ";
	    sqlBean db= new sqlBean();
	    num=db.executeDelete(sql);
	    return num;
	}  
	public void updateTeacher(){	
	    String sql="update teacher "+" set tname='"+fname+"',"+" password='"+password+"',"+" age='"+age+"',"+" course='"+course+"',"+" remark='"+remark+"',"+" sex='"+sex+"',"+" office='"+office+"' "+" where id='"+id+"'";
	    sqlBean db= new sqlBean();
	    db.executeInsert(sql);
    }
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
	public boolean haslogin(String tid){
		boolean f=true;
		String sql="select id from teacher where id='"+tid+"'";
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

}
