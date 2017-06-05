<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%@ page import="bean.QingJia"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css" />

</head>
<body  bgcolor="white">
		  <center><font size="6" color="blue">学生请假信息列表</font></center>
  <div align="center">
    <table width="60%"  border="1">
						<tr class="table_header">
							<td>
								请假号
							</td>
							<td>
								请假人
							</td>
							<td>
								课程名
							</td>
							<td>
								课程时间
							</td>
							<td>
								请假类型
							</td>
							<td>
								请假日期
							</td>
							<td>
								请假天数
							</td>
							<td>
								任课教师
							</td>
				
							<td>
								任课教师意见
							</td>
						<td>
								附件
							</td>
							 <td align="center" clospan="2">基本操作</td>      
						</tr>
						 
					<%
		List<QingJia> qjList = (List<QingJia>) request
				.getAttribute("qjList");
	%>
				<%
			for (int i=0;i<qjList.size();i++) {
				QingJia qj=qjList.get(i);
		%>		
					
						<tr class="row1">
						
			<td><%=qj.getKid() %></td>
			<td><%=qj.getSid() %></td>
			<td><%=qj.getCid() %></td>
			<td><%=qj.getCourseTime() %></td>
			<td><%=qj.getKtype() %></td>
			<td><%=qj.getRedate() %></td>
			<td><%=qj.getDays() %></td>
		     <td><%=qj.getTid() %></td>
			<td><%=qj.getIson()==0?"不批准":"批准" %></td>
		
			 <td><a href="<%=request.getContextPath()%>/studentDetail?k_id=<%=qj.getKid()%>">详情</a> </td>
			  <td align="center"><a href="/stu_qj_ms/teacher/updateqj.jsp?k_id=<%=qj.getKid()%>" title="修改信息">审批</a></td>  
        <td align="center"><a href="servlet/delqj?k_id=<%=qj.getKid()%>" title="删除请假">删除</a></td>
		   </tr>
						<%} %>	
					
					</table>
					
				</div>
	</body>
</html>
