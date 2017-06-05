<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%@page import="bean.sqlBean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <jsp:useBean id="a" scope="page" class="bean.QingJia"></jsp:useBean>
    <title>My JSP 'updatestudent.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
    <script language=javascript>
  <!--
  function isValid(){
  if(updateform.id.value==""){
  window.alert("学号不能为空！");
  return false;
  }
  if(updateform.name.value==""){
  window.alert("姓名不能为空！");
  return false;
  }
  if(updateform.password.value==""){
  window.alert("请为学生设置初始密码！");
  return false;
  }
  }
  -->
  </script>
  <body  background="b.jpg" >
    <div align="center"><font color="blue" size="6" face="华文行楷">审批请假信息</font></div>
    
    <%!String cid,tid,sql,sex; %>
    <%!int kid; %>
    <%!ResultSet rs; %>
    <%request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    kid=Integer.parseInt(request.getParameter("k_id"));
    String f_id = (String)session.getAttribute("id");
    
    String sql="select * from qingjia where kid='"+kid+"'";
    sqlBean db=new sqlBean();
    rs=db.executeQuery(sql);
    while(rs.next()){
     %>
     <input type="hidden" name="id" value="<%=f_id %>">
     
 
    <form action="servlet/updateqj2?k_id=<%=kid %>" method="post" name="updateform" onSubmit="return isValid()">
        <table width="55%" align="center" border="1">
           <tr>
             <td width="36%" align="center">课程号</td>
             <td width="54%">&nbsp;&nbsp;&nbsp;<input type="text" name="cid" value=<%=rs.getString("cid") %> size="16"  readonly="false"></td>
           </tr>
           <tr>
             <td width="36%" align="center">请假时间</td>
             <td width="54%">&nbsp;&nbsp;&nbsp;<input type="text" name="courseTime" value=<%=rs.getString("courseTime") %> size="16"  readonly="false"></td>
           </tr>
           <tr>
             <td width="36%" align="center">请假类型</td>
             <td width="54%">&nbsp;&nbsp;&nbsp;<input type="text" name="ktype" value=<%=rs.getString("ktype") %> size="16"  readonly="false"></td>
           </tr>
           <tr>
             <td width="36%" align="center">请假日期</td>
             <td width="54%">&nbsp;&nbsp;&nbsp;<input type="text" name="redate" value=<%=rs.getString("redate") %> size="16" readonly="false"></td>
           </tr>
           <tr>
             <td width="36%" align="center">任课教师</td>
             <td width="54%">&nbsp;&nbsp;&nbsp;<input type="text" name="tid" value=<%=rs.getString("tid") %> size="16" readonly="false"></td>
           </tr>
            <tr>
             <td width="36%" align="center">备注</td>
             <td width="54%">&nbsp;&nbsp;&nbsp;<input type="text" name="content" value=<%=rs.getString("content") %> size="16"  readonly="false"></td>
           </tr>
            <tr>
             <td width="36%" align="center">审批</td>
             <td width="54%">&nbsp;&nbsp;&nbsp;
             <input type="radio" name="isfu" value="0" <%=rs.getInt("isfu")==0?"checked":"" %>>不批准
	<input type="radio" name="isfu" value="1" <%=rs.getInt("isfu")==1?"checked":"" %>>批准<br><br>
           </tr>								
           
           <tr align="center">
    		<td colspan="2" align="center">
    		<input type="submit" name="Submit" value="提交">&nbsp;&nbsp;&nbsp;
    		</td>
    	   </tr>
    	       <%} %>
        </table> <center><a href="javascript:history.back()">返回</a></center>
        
    </form>
  </body>
</html>
