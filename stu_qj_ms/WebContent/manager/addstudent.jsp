<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addstudent.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body background="c.jpg">
    <%String m_id=(String)session.getAttribute("id"); %><br>
    <center><font color="blue" size="6" face="隶书">添加学生信息</font></center><br>
    <form name="form1" method="post" action="servlet/addStudent">
<!--<input type="hidden" name="action" value="new">-->
    <table width="35%" border="1" align="center">
    <tr>
    <td width="25%" align="center">学号</td>
    <td width="35%"><input type="text" name="sid" id="sid"></td>
    </tr>
    <tr>
    <td  align="center">姓名</td>
    <td ><input type="text" name="sname" id="sname"></td>
    </tr>
    <tr>
    <td align="center">密码</td>
    <td><input type="text" name="password" id="spassword"></td>
    </tr>
    <tr>
    <td align="center">班级</td>
    <td><input type="text" name="sclass" id="sclass"></td>
    </tr>
    <tr>
    <td align="center">性别</td>
    <td><input type="text" name="sex" id="sex"></td>
    </tr>
    
     <tr>
    <td align="center">教师</td>
    <td><input type="text" name="teacher" id="teacher"></td>
    </tr>
     <tr>
    <td align="center">请假日期</td>
    <td><input type="text" name="reDate" id="reDate"></td>
    </tr>
     <tr>
    <td align="center">备注</td>
    <td><input type="text" name="remark" id="remark"></td>
    </tr>
    </table>
    <center><input type="submit" name="Submit" value="提交"></center>
    </form>
  </body> 
</html>
