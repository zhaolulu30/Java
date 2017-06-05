package bean;

import java.sql.*;

public class Teacher {
	private String id;
	private String tname;
	private String password;
	private String sex;
	private String office;
	private String age;
	private String remark;
	private String cid;
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public String getTname() {return tname;}
	public void setTname(String tname) {this.tname = tname;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	
	public ResultSet  getTeacher(){
		String sql="select * from teacher";
		sqlBean db= new sqlBean();
		ResultSet rs = db.executeQuery(sql);
		return rs;
	}	
	public ResultSet  getTeaOne(String t_id){
		String sql="select * from teacher where id ='"+t_id+"'";
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
				+id+"','"+tname+"','"+password+"','"+cid+"','"+sex+"','"+office+"','"+age+"','"+remark+"')";
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
	    String sql="update teacher "+" set tname='"+tname+"',"+" password='"+password+"',"+" age='"+age+"',"+" cid='"+cid+"',"+" remark='"+remark+"',"+" sex='"+sex+"',"+" office='"+office+"' "+" where id='"+id+"'";
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
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}

}
