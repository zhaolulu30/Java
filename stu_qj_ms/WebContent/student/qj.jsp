<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%@page import="bean.Teacher" %>
<%@page import="bean.Instructor" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="js/laydate.js"></script>
    <title>My JSP 'addstucourse.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
   <style type="text/css">
a{
color:blue;
text-decoration:none;
} 
a:hover{
color:red;
text-decoration:underline;
}
</style>
  <body bgcolor="#CCCCCC">
  
  <% String s_id =(String)session.getAttribute("id");%>
  <%!ResultSet rs; %>
   <form name="form1" method="post" action="servlet/addQingJia">
 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="6%" height="19" valign="bottom"><div align="center"><img src="images/tb.gif" width="14" height="14" /></div></td>
                <td width="94%" valign="bottom"><span class="STYLE1">学生申请请假</span></td>
              </tr>
            </table></td>
            <td><div align="right"><span class="STYLE1">
              &nbsp;&nbsp;</span><span class="STYLE1">&nbsp; <br /></span></div></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce" onmouseover="changeto()"  onmouseout="changeback()">
      <tr>
        <td width="28%" height="20" bgcolor="d3eaef" class="STYLE10"><div align="center">课程名：</div></td>
        <td width="72%" height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="left">
          <select name="course" style="width:150px">
		  	<%
				bean.sqlBean con = new bean.sqlBean();
				ResultSet rs1 = con.executeQuery("select cid,cname from course");
				
				while(rs1.next()){  
			%>
		  	<option value="<%=rs1.getString("cid")%>"><%=rs1.getString("cname")%></option>
			<%}
				rs1.close();
			
			%>
		  </select>
        </div></td>
      </tr>
       <tr>
        <td height="20" bgcolor="d3eaef" class="STYLE10"><div align="center">课程时间：</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="left">
		 <input type="text" name="courseTime" />
      </tr>
	  <tr>
        <td height="20" bgcolor="d3eaef" class="STYLE10"><div align="center">请假类型：</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="left">
          <select name="ktype">
		  	<option value="病假">病假</option>
			<option value="事假">事假</option>
		  </select>
        </div></td>
      </tr>
      <tr>
        <td width="28%" height="20" bgcolor="d3eaef" class="STYLE10"><div align="center">请假天数：</div></td>
        <td width="72%" height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="left">
          <input type="text" name="days" value="0" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" />天</div></td>
      </tr><tr>
           <td width="28%" height="20" bgcolor="d3eaef" class="STYLE10"><div align="center">请假日期：</div><i class="require-red"></i></div></td>
           <td width="72%" height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="left">
										<input name="redate" class="laydate-icon" id="demo" value="2015-10-12" type="text"> 
									</td>
<script type="text/javascript">
!function(){
	laydate.skin('molv');
	laydate({elem: '#demo'});
}();

var start = {
    elem: '#start',
    format: 'YYYY-MM-DD',
    min: laydate.now(), 
    max: '2099-06-16', 
    istime: true,
    istoday: false,
    choose: function(datas){
         end.min = datas; 
         end.start = datas 
    }
};

var end = {
    elem: '#end',
    format: 'YYYY-MM-DD',
    min: laydate.now(),
    max: '2099-06-16',
    istime: true,
    istoday: false,
    choose: function(datas){
        start.max = datas; 
    }
};
laydate(start);
laydate(end);


</script>
</tr>
  <tr>
        <td height="20" bgcolor="d3eaef" class="STYLE10"><div align="center">任课老师：</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="left">
          <select name="teacher" style="width:150px">
		  	<%
				bean.sqlBean conn = new bean.sqlBean();
				ResultSet rs = conn.executeQuery("select id,tname from teacher");
				
				while(rs.next()){ 
			%>
		  	<option value="<%=rs.getString("id")%>"><%=rs.getString("tname")%></option>
			<%}
				rs.close();
			
			%>
		  </select>
        </div></td>
      </tr>
      <tr>
        <td height="20" bgcolor="d3eaef" class="STYLE10"><div align="center">辅导员：</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="left">
          <select name="instructor" style="width:150px">
		  	<%
				bean.sqlBean conn1 = new bean.sqlBean();
				ResultSet rs2= conn.executeQuery("select id,fname from instructor");
				
				while(rs2.next()){ 
			%>
		  	<option value="<%=rs2.getString("id")%>"><%=rs2.getString("fname")%></option>
			<%}
				rs.close();
			
			%>
		  </select>
        </div></td>
      </tr>
	  <tr>
        <td height="20" bgcolor="d3eaef" class="STYLE10"><div align="center">学号：</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="left">
           <input type="text" name="sid" value="<%=s_id %>" readonly="false" />
	
        </div></td>
      </tr>
	  <tr>
        <td height="20" bgcolor="d3eaef" class="STYLE10"><div align="center">请假原因：</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="left">
          <textarea name="content" cols="50" rows="5"> </textarea>
        </div></td>
      </tr>
     
    </table></td>
  </tr>
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="33%">&nbsp;</td>
       <td width="67%"><input type="submit" value=" << 申 请  " /></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
</body>
</html>