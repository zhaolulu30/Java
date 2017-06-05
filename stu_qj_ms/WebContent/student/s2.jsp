<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 's2.jsp' starting page</title>
    
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
    用户菜单:<br><br>
   &nbsp;&nbsp;<a href="student/updateSpassword.jsp" target="f3main"><font size="4">修改密码</font></a><br><br>
   &nbsp;&nbsp;<a href="exist.jsp" target="_top"><font size="4">退出登录</font></a><br><br>
  <br><br>
   &nbsp;&nbsp;<a href="student/qj.jsp" target="f3main"><font size="4">申请请假</font></a><br><br>
   &nbsp;&nbsp;<A href="student/uploadPic.jsp" target="f3main" align="center"><font size="4" >上传凭证</font></A></td><br><br>
  
 <br><br>
   &nbsp;&nbsp;<a href="student/showQJ.jsp" target="f3main"><font size="4">请假信息</font></a><br><br>
    &nbsp;&nbsp;<a href="student/showteacher.jsp" target="f3main"><font size="4">友情链接</font></a><br><br>
   
  </body>
</html>
