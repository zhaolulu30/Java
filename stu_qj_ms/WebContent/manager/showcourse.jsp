<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showcourse.jsp' starting page</title>
    
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
  
  <jsp:useBean id="a" scope="page" class="bean.Course"></jsp:useBean>
  <body background="c.jpg">
    <%  
   String c_id = (String)session.getAttribute("id");  
   String cname="";
   double credit=0.0; 
  %><br>
  <center><font size="6" color="blue">所有课程名单</font></center>
  <div align="center">
    <table width="60%"  border="1">
      <tr> 
        <td align="center">课程号</td>
        
        <td align="center">课程名</td> 
        <td align="center">学分</td> 
        
        <td align=center>更改</td>
	    <td align=center>删除</td>
      </tr>
   <%
      ResultSet rs = a.getCourse();
      while(rs.next()){
      c_id=rs.getString("cid");
    
      cname=rs.getString("cname");
      credit=rs.getDouble("credit");
    
   %>
      <tr>
        <td align="center"><%=c_id%></td>
    
        <td align="center"><%=cname%></td>
        <td align="center"><%=credit%></td>  
 
        <td width=12% align=center><a href="manager/updatecourse.jsp?id=<%=c_id%>" >修改</a></td>
	    <td width=12% align=center><a href="servlet/delcourse?id=<%=c_id%>">删除</a></td>            
      </tr>
  <%}%>
    </table>
  </div>
  <br>
  </body>
</html>
