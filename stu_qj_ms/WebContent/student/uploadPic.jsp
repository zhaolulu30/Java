<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%@page import="bean.Teacher" %>
<%@page import="bean.Instructor" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css" />
<%
String s_id = (String)session.getAttribute("id"); 
	if (session.getAttribute("id") == null) { 
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}
%>
<title>上传图片</title>
</head>
<body>

 <input type="hidden" name="id" value="<%=s_id %>">
  
 
	<div id="wrap">
		<div id="top_content">
		
			<div id="content">
				<h1>
					上传照片:
				</h1>
	  <%!ResultSet rs; %>
						<form action="<%=request.getContextPath()%>/uploadpic" method="post"
								name="uploadForm" enctype="multipart/form-data">
								
								上传图片：<input type="file" name="file">&nbsp;<input type="submit" value="上传">	
						<tr>
					</tr>
					  <tr>
   
        <td height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="left">
   		<h2>
					任课老师:
				</h2></td><select name="teacher" style="width:150px">
		  	<%
				bean.sqlBean conn = new bean.sqlBean();
				ResultSet rs = conn.executeQuery("select id,tname from teacher");
				
				while(rs.next()){ 
			%>
		  	<option value="<%=rs.getString("id")%>"><%=rs.getString("tname")%></option>
			<%}
				rs.close();
			
			%>
		  </select>
        </div></td>
      </tr>

      <tr>
        
        <td height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="left">
          <h2>
					辅导员:
				</h2><select name="instructor" style="width:150px">
		  	<%
				bean.sqlBean conn1 = new bean.sqlBean();
				ResultSet rs2= conn.executeQuery("select id,fname from instructor");
				
				while(rs2.next()){ 
			%>
		  	<option value="<%=rs2.getString("id")%>"><%=rs2.getString("fname")%></option>
			<%}
				rs.close();
			
			%>
		  </select>
        </div></td>
      </tr>
  
      
					<br><br><br><br>
						</form>
			</div>
		</div>

	</div>
</body>
</html>