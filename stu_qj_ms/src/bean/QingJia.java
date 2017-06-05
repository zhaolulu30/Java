package bean;

import java.sql.ResultSet;
import java.util.Date;

public class QingJia {
	private int kid;
	private String tid;
	private String sid;
	private String cid;
	private String fid;
	private String courseTime;
	private String ktype;
	private String content;
	private String redate;
	private int days;
	private int ison;
	private int isfu;

	public int getKid() {
		return kid;
	}
	public void setKid(int kid) {
		this.kid = kid;
	}
	public String getRedate() {
		return redate;
	}
	public void setRedate(String redate) {
		this.redate = redate;
	}

	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}

	public String getCourseTime() {
		return courseTime;
	}
	public void setCourseTime(String courseTime) {
		this.courseTime = courseTime;
	}
	public String getKtype() {
		return ktype;
	}
	public void setKtype(String ktype) {
		this.ktype = ktype;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public QingJia(){}
	
	public QingJia(int kid, String tid, String sid, String course,
			String courseTime, String ktype, String content, String redate) {
		this.kid = kid;
		this.setTid(tid);
		this.setSid(sid);
		this.setCid(cid);
		this.courseTime = courseTime;
		this.ktype = ktype;
		this.content = content;
		this.redate = redate;
	}
	
	public QingJia( String tid,String sid, String course,
			String courseTime, String ktype, String content,int days) {

	
		this.courseTime = courseTime;
		this.ktype = ktype;
		this.content = content;
		this.days = days;
	}
	public ResultSet getQingJia(String t_id){
		String sql="select * from qingjia where tid='"+t_id+"'"+"order by redate";
		sqlBean db=new sqlBean();
		ResultSet rs=db.executeQuery(sql);
		return rs;
	}
	public ResultSet getQingJia2(String f_id){
		String sql="select * from qingjia where fid='"+f_id+"'"+"order by redate";
		sqlBean db=new sqlBean();
		ResultSet rs=db.executeQuery(sql);
		return rs;
	}
	public ResultSet getQingJia1(String s_id){
		String sql="select * from qingjia where sid='"+s_id+"'"+"order by redate";
		sqlBean db=new sqlBean();
		ResultSet rs=db.executeQuery(sql);
		return rs;
	}
	public int deleteQingJia(String kid){
	    int num=0;
	    String sql="delete  from qingjia where kid ='"+kid+"' ";
	    sqlBean db= new sqlBean();
	    num=db.executeDelete(sql);
	    return num;
	}  
	public void addQingJia(){
		String sql="insert into qingjia(kid,tid,sid,cid,fid,courseTime,ktype,content,redate,days) values ('"+kid+"','"+tid+"','"+sid+"','"+cid+"','"+fid+"','"+courseTime+"','"+ktype+"','"+content+"','"+redate+"','"+days+"')";
		
        sqlBean db=new sqlBean();
        db.executeInsert(sql);
 
	}
    
        public ResultSet getQingJia(){
    		String sql="select * from qingjia"+"order by redate";
    		sqlBean db=new sqlBean();
    		ResultSet rs=db.executeQuery(sql);
    		return rs;
    	}
    	public ResultSet getStuCou(String cno,String clnum){
    		String sql="select studentcourse.sid,student.sname, studentcourse.cname,studentcourse.credit from student,studentcourse where (studentcourse.sid=student.id and cno='"+cno+"' and clnum='"+clnum+"')";
    		sqlBean db=new sqlBean();
    		ResultSet rs=db.executeQuery(sql);
    		return rs;
    	}
    	public void updateQingJia(){
    		String sql="update qingjia "+" set cid='"+cid+"',"+" tid='"+tid+"',"+" content='"+content+"',"+" courseTime='"+courseTime+"',"+" ktype='"+ktype+"',"+" ison='"+ison
    		+"' "+" where kid='"+kid+"'";
    		sqlBean db=new sqlBean();
    		db.executeInsert(sql);
    	}
    	public void updateQingJia2(){
    		String sql="update qingjia "+" set cid='"+cid+"',"+" tid='"+tid+"',"+" content='"+content+"',"+" courseTime='"+courseTime+"',"+" ktype='"+ktype+"',"+" isfu='"+isfu
    		+"' "+" where kid='"+kid+"'";
    		sqlBean db=new sqlBean();
    		db.executeInsert(sql);
    	}
    	public void updateQingJia1(){
    		String sql="update qingjia "+" set cid='"+cid+"',"+" tid='"+tid+"',"+" fid='"+fid+"',"+" content='"+content+"',"+" courseTime='"+courseTime+"',"+" ktype='"+ktype+"',"+" days='"+days
    		+"' "+" where kid='"+kid+"'";
    		sqlBean db=new sqlBean();
    		db.executeInsert(sql);
    	}
    	public boolean isValid(String sid,String cno){
    		boolean f=true;
    		String sql="select sid from studentcourse where (sid='"+sid+"' and cid='"+cno+"')";
    		sqlBean db=new sqlBean();	
    		try{
    			ResultSet rs=db.executeQuery(sql);
    			if(rs.next()) 
    				f=true;
    			else 
    				f=false;
    		}
    		catch(Exception e){e.getMessage();}
    		return f;
    	}
   

		public int getIson() {
			return ison;
		}
		public void setIson(int ison) {
			this.ison = ison;
		}
		public String getTid() {
			return tid;
		}
		public void setTid(String tid) {
			this.tid = tid;
		}
		public String getSid() {
			return sid;
		}
		public void setSid(String sid) {
			this.sid = sid;
		}
		public String getCid() {
			return cid;
		}
		public void setCid(String cid) {
			this.cid = cid;
		}
		public String getFid() {
			return fid;
		}
		public void setFid(String fid) {
			this.fid = fid;
		}
		public int getIsfu() {
			return isfu;
		}
		public void setIsfu(int isfu) {
			this.isfu = isfu;
		}


}
