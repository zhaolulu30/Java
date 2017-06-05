<%@ page language="java" import="java.util.*" pageEncoding="utf-8" errorPage="errorpage.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<script type="text/javascript">
function checkForm(){
	return checkPassword(); 
}

	function checkPassword(){
		var input_password=document.getElementById("input_password");
		var span_password_error=document.getElementById("span_password_error");
		var password=input_password.value;
		if(password.length<6 ||password.length>10){
			span_password_error.innerHTML="密码长度必须是6-10位";
			return false;
		}else{
			span_password_error.innerHTML="";
			return true;
		}
	}

</script>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <title>学生请假管理系统</title>

  <SCRIPT Language = javascript>
 <!--
  function isValid()
  {	
  	if(nameform.id.value == "")
  	{	
  		window.alert("您必须完成帐号的输入!"); 
 		document.isValid.elements(0).focus();	
  		return  false;
  	}
  	
  	if(nameform.password.value == "")
  	{
  		window.alert("您必须完成密码的输入!");
  		document.isValid.elements(1).focus();
  		return  false; 
  	}
  	nameform.submit(); 
 }
 
  -->
  </SCRIPT>		
  <body  background="2082016_103229071_2.jpg" >
  
  
  <center>
   <frameset rows="15%,*">
    <frame src="student/s2.jsp" name="f3left">
    </frameset>
   <img src="27.jpg" width="50" height="50">
    <font size="6" color="green" face="华文行楷">欢迎进入哈尔滨商业大学学生请假管理系统</font>
 <font size=6 color="CCFFCC"><br><br><br></font>
<form action="servlet/check" method=post name="nameform"onsubmit="return checkForm();" onSubmit="return isValid(this);">
<p>用户名：<input type="text" name="id" value="" size="15" maxlength="18" ><br><br></p>
<p>密&nbsp;&nbsp;&nbsp;&nbsp;码：<input id="input_password" type="password" name="password" value="" size="15"  onblur="checkPassword();" ><br><br></p>
<span id="span_password_error" style="color: red;"></span>
<p>身份:
<input type="radio" name="kind"  value="manager" >管理员
<input type="radio" name="kind" value="teacher">教师
<input type="radio" name="kind" value="instructor">辅导员
<input type="radio" name="kind"  value="student" checked>学生<br><br>
</p><p align="center" style="color: red">
			<%=request.getAttribute("error")==null?"":request.getAttribute("error") %>
		</p>
<input name=b1 type="submit" value="登录">
<input name=b2 type="reset" value="重置">
</form></center>
  <br><br><br><br>
   <p id="time" align="right">
<script>
 setInterval("time.innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay())",1000);
</script>&nbsp;</p>
  </body>
</html>