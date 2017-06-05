<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%@page import="bean.QingJia" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'searchqj.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
  </head>

    <body  background="b.jpg" ><br>
      <% String s_id =(String)session.getAttribute("id");%>
  <%!ResultSet rs; %>
    
    <center>
   精确查找：<br/>
					<form action="<%=request.getContextPath()%>/exactquery1" method="post">
				

 
      请假类型：    <td height="20" bgcolor="#FFFFFF" class="STYLE6">
          <select name="ktype"><br><br><br><br>
		  	<option value="病假">病假</option>
			<option value="事假">事假</option>
		  </select>
       </td>
     
 请假日期：<input type="text" name="redate"/><br><br>
					 <input type="submit" value="查询"/>
					 <input type="reset" value="重置  " />
					</form>
    </center>
   
  
  </body>
</html>
