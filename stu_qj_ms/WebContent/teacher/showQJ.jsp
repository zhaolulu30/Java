<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showqj.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <jsp:useBean id="a" scope="page" class="bean.QingJia"></jsp:useBean>
  <jsp:useBean id="b" scope="page" class="bean.Teacher"></jsp:useBean>
  <jsp:useBean id="c" scope="page" class="bean.Student"></jsp:useBean>
  <jsp:useBean id="d" scope="page" class="bean.Course"></jsp:useBean>
  <body  background="d.jpg" >
      <%  
   String t_id = (String)session.getAttribute("id");  
     
   String cid="",courseTime="",ktype="",tid="",content="",redate="",ison="",sid="";
   int days,kid;
 
  %><br>
   <input type="hidden" name="id" value="<%=t_id %>">
 
  <center><font size="6" color="blue">学生请假信息列表</font></center>
  <div align="center">
    <table width="60%"  border="1">
    
      <tr> 
        <td align="center">请假号</td>
        <td align="center">请假人</td>
        <td align="center">课程名</td>
        <td align="center">课程时间</td>
        <td align="center">请假类型</td>
        <td align="center">请假日期</td>
        <td align="center">请假天数</td>  
        <td align="center">任课教师</td>    
          <td align="center">备注</td>
          <td align="center">老师审批</td>
           <td align="center">附件</td>
           <td align="center" >修改</td>  
           <td align="center" >删除</td>          
      </tr>
      <%ResultSet  rs=a.getQingJia(t_id);
      while(rs.next()){
    	  kid=Integer.parseInt(rs.getString("kid"));
    	  sid=rs.getString("sid");
      cid=rs.getString("cid");
      courseTime=rs.getString("courseTime");
      ktype=rs.getString("ktype"); 
      redate=rs.getString("redate");
      tid=rs.getString("tid");
      content=rs.getString("content");
      days=Integer.parseInt(rs.getString("days"));
      ison=rs.getString("ison");
      
      ResultSet  rs1=b.getTeaOne(tid);
      while(rs1.next()){
      tid=rs1.getString("tname");
      
      ResultSet  rs2=c.getStuOne(sid);
      while(rs2.next()){
      sid=rs2.getString("sname");
      
      ResultSet  rs3=d.getCouOne(cid);
      while(rs3.next()){
      cid=rs3.getString("cname");
      %>
      <tr>
       <td align="center"><%=kid%></td>
       <td align="center"><%=sid%></td>
        <td align="center"><%=cid%></td>
        <td align="center"><%=courseTime%></td>
        <td align="center"><%=ktype%></td>
        <td align="center"><%=redate%></td>
        <td align="center"><%=days%></td>
        <td align="center"><%=tid%></td>
        <td align="center"><%=content%></td>
        <td align="center"><%=rs.getInt("ison")==0 ? "不批准" : "批准"%></td>
       <td><a href="<%=request.getContextPath()%>/studentDetail?k_id=<%=kid%>">详情</a> </td>
         <td align="center"><a href="/stu_qj_ms/teacher/updateqj.jsp?k_id=<%=kid%>" title="修改信息">审批</a></td>  
        <td align="center"><a href="servlet/delqj?k_id=<%=kid%>" title="删除请假">删除</a></td>
      <%} %>
      <%} %>
      <%} %>
      <%} %>
      </tr>
      </table>
      </div>
  </body>
</html>
