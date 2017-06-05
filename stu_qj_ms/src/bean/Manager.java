package bean;

import java.sql.ResultSet;

public class Manager {
	private String id;
	private String password;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isValid(String id){   
		boolean f=true;
		String sql="select id from manager where id ='"+id+"'";
		sqlBean db =new sqlBean();
		try{
		    ResultSet rs=db.executeQuery(sql);
		  	if(rs.next()){f=true;}
		  	else{f=false;}
	    }catch(Exception e){ e.getMessage();}
		return f;
	}
}
