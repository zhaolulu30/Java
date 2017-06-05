<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'm2.jsp' starting page</title>
    
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
  <body background="c.jpg">
    用户菜单<br>
    &nbsp;&nbsp;<a href="manager/updateMpassword.jsp" target="f1main"><font size="2">修改密码</font></a><br>
    &nbsp;&nbsp;<a href="/stu_qj_ms/index.jsp" target="_top"><font size="2">退出登陆</font></a><br>
    学生管理<br>
    &nbsp;&nbsp;<a href="manager/showstudent.jsp" target="f1main"><font size="2">学生管理</font></a><br>
    &nbsp;&nbsp;<a href="manager/addstudent.jsp" target="f1main"><font size="2">添加学生</font></a><br>
    教师管理<br>
    &nbsp;&nbsp;<a href="manager/showteacher.jsp" target="f1main"><font size="2">教师管理</font></a><br>
    &nbsp;&nbsp;<a href="manager/addteacher.jsp" target="f1main"><font size="2">添加教师</font></a><br>
    &nbsp;&nbsp;<a href="manager/showInstructor.jsp" target="f1main"><font size="2">辅导员管理</font></a><br>
    课程管理<br>
    &nbsp;&nbsp;<a href="manager/showcourse.jsp" target="f1main"><font size="2">课程管理</font></a><br>
    &nbsp;&nbsp;<a href="manager/addcourse.jsp" target="f1main"><font size="2">添加课程</font></a><br>
 
  </body>
</html>
