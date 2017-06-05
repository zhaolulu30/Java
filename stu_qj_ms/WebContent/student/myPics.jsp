<%@page import="java.util.List"%>
<%@page import="entity.Pic"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>我的图片</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css"  />
<title>修改密码</title>
<% if (session.getAttribute("id") == null) {
		response.sendRedirect(request.getContextPath() + "/index.jsp");
		return;
	}
%>
</head>
<body>

		<%
		String s_id = (String)session.getAttribute("id");%>
		
		   <input type="hidden" name="id" value="<%=s_id %>">
		<br><br><br>
	<div id="content">
				<br> <br>
				<table class="table" class="form_table">
				
						<tr>
							<td>
								图片
							</td>
							<td>
								操作
							</td>
							
							
						</tr>
						<%List<Pic> list = (List<Pic>)request.getAttribute("list");%>
						<% for(Pic pic:list) {%>
						<tr>
						<td><img width=200 height=150 src="<%=request.getContextPath()%>/upload/<%=pic.getFilename()%>"></td>
						<td><a href="delPic?id=<%=pic.getId()%>">删除</a></td>
						</tr>
						<%} %>
						
					</table>
			
	</div>



</body>
</html>