<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateTpassword.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body  background="b.jpg" >
    <%String t_password=(String)session.getAttribute("password");
    
    String t_id=(String)session.getAttribute("id");%>
    
   <br>
   <center><font size=6 color="blue">修改密码</font></center><br>
   <form name="form1" method="post" action="servlet/updateIpassword">
    <input type="hidden" name="id" value="<%=t_id %>">
     <input type="hidden" name="password" value="<%=t_password %>">
   <table width="40%" border="1" align="center">
   <tr>
   <td width="25%"><center>原始密码:</center></td>
  <td width="30%"><input type="password" name="oldpassword" id="oldpassword"></td>
  </tr>
  <tr>
  <td><center>新密码:</center></td>
  <td><input name="password1" type="password" id="password1"></td>
  </tr>
  <tr>
  <td><center>确认密码:</center></td>
  <td><input name="password2" type="password" id="password2"></td>
  </tr>
  </table><br><br>
  <center><input type="submit" name="Submit" value="提取"></center>
  </form>
  </body>
</html>
