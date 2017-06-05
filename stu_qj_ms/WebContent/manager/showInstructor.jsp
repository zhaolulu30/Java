<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showteacher.jsp' starting page</title>
    
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
  <jsp:useBean id="a" scope="page" class="bean.Instructor"></jsp:useBean>
  <jsp:useBean id="d" scope="page" class="bean.Course"></jsp:useBean>
  <body background="c.jpg">
    <center><font size=6 color="blue" face="华文行楷">所有辅导员名单</font></center>
  <div align="center">
  <table width="60%" border="1">
   <tr>
    <th width=12% align=center>编号号</th>
    <th width=12% align=center>姓名</th>
    <th width=12% align=center>密码</th>
    
    
    <th width=12% align=center>办公室</th>

    <th width=12% align=center>更改</th>
	<th width=12% align=center>删除</th>
   </tr>
    <% 
    ResultSet rs=a.getInstructor();
    while(rs.next()){
    String id=rs.getString("id");
    String fname=rs.getString("fname");
    String password=rs.getString("password");  
   
    String office=rs.getString("office"); 
    

   
     %>
     <tr>
      <td align="center"><%=id%></td>
      <td align="center"><%=fname%></td>
      <td align="center"><%=password%></td>

      <td align="center"><%=office%></td>

      <td width=12% align=center><a href="manager/updateteacher.jsp?id=<%=id%>" >编辑</a></td>
	  <td width=12% align=center><a href="servlet/delteacher?id=<%=id%>">删除</a></td>
     </tr>
   <%} %> 
   
  </table>
  </div>
  </body>
</html>
