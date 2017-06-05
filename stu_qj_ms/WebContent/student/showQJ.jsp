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
    <jsp:useBean id="e" scope="page" class="bean.Instructor"></jsp:useBean>
  <body bgcolor="#CCCCCC">
      <%  
   String s_id = (String)session.getAttribute("id");  
   String sid="",cid="",courseTime="",ktype="",tid="",fid="",content="",redate="",ison="",isfu="";
   int days,kid;
 
  %><br>
   <input type="hidden" name="id" value="<%=s_id %>">

  <center><font size="6" color="blue">你的请假信息为</font></center>
  <div align="center">
    <table width="60%"  border="1">
      <tr> 
         <tr> 
        <th align="center">请假号</th>
        <th align="center">请假人</th>
        <th align="center">课程名</th>
        <th align="center">课程时间</th>
        <th align="center">请假类型</th>
        <th align="center">请假日期</th>
        <th align="center">请假天数</th>  
        <th align="center">任课教师</th>    
        <th align="center">任辅导员</th> 
          <th align="center">备注</th>
          <th align="center">老师审批意见</th>
          <th align="center">辅导员审批意见</th>
           <th align="center">附件</th>
           <td align="center">基本操作</td>      
      </tr>
      <%ResultSet  rs=a.getQingJia1(s_id);
      while(rs.next()){
    	  kid=Integer.parseInt(rs.getString("kid"));
    	  sid=rs.getString("sid");
      cid=rs.getString("cid");
      courseTime=rs.getString("courseTime");
      ktype=rs.getString("ktype"); 
      redate=rs.getString("redate");
      tid=rs.getString("tid");
      fid=rs.getString("fid");
      content=rs.getString("content");
      days=Integer.parseInt(rs.getString("days"));
      ison=rs.getString("ison");
      isfu=rs.getString("isfu");
      ResultSet  rs1=b.getTeaOne(tid);
      while(rs1.next()){
      tid=rs1.getString("tname");
      
      ResultSet  rs4=e.getInsOne(fid);
      while(rs4.next()){
      fid=rs4.getString("fname");
      
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
        <td align="center"><%=fid%></td>
        <td align="center"><%=content%></td>
        <td align="center"><%=rs.getInt("ison")==0 ? "不批准" : "批准"%></td>
        <td align="center"><%=rs.getInt("isfu")==0 ? "不批准" : "批准"%></td>
       <td align="center"><a href="myPics" title="删除请假">查看详情</a></td>
         <td align="center"><a href="/stu_qj_ms/student/updateqj.jsp?k_id=<%=kid%>" title="修改信息">修改</a></td>  
        <td align="center"><a href="servlet/delqj1?k_id=<%=kid%>" title="删除请假">删除</a></td>
      <%} %>
      <%} %>
      <%} %>
      <%} %>
        <%} %>
      
      </tr>
      </table>
      </div>
  </body>
</html>
    