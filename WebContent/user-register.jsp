<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>www.IAuto.ge - რეგისტრაცია</title>

<style>
#dzebna {
	background: #66CCFF;
	padding: 3px 17px;
	color: black;
	font-family: 'Helvetica Neue', sans-serif;
	font-size: 15px;
	border-radius: 2px;
	-moz-border-radius: 4px;
	-webkit-border-radius: 4px;
	border: 0px solid rgb(213, 150, 17);
	cursor: pointer;
}

#dzebna.hover{
	background-color: #3399FF;
	color: black;
}
</style>

<script type="text/javascript">
function checkPasswordMatch(){
	var pass = document.getElementById("pass").value;
	var rpass = document.getElementById("rpass").value;
	if (pass != rpass) {
		document.getElementById("passError").innerHTML="არ ემთხვევა ზემოთ შეყვანილ პაროლს!";
		document.getElementById("dzebna").disabled = true;
	} else {
		document.getElementById("passError").innerHTML="";
		document.getElementById("dzebna").disabled = false;
	}
}
</script>

<%@include file="menu-bar.jsp"%>
</head>
<body>
	<fieldset style="background-color:rgb(240,240,240); width:750px; margin:auto;">
	<form action="Verification" method="post">
	<table width="100%" border="0">
		<%
			@SuppressWarnings("unchecked")
			List<String> error = (List<String>)request.getAttribute("errorList");
		%>
		<tr>
			<td class="reg_class_label" style="width:300px;">
				მომხმარებელი (username)<font color="red">*</font>: 
			</td>
			<td class="reg_class_value">					
				<input type="text" size="20" name="username" <% if (error != null) out.println("value='" + request.getParameter("username") + "'"); %> >
				<% if (error != null && error.get(0) != null) out.println("<font size='2' color='red' >" + error.get(0) + "</font>"); %>
			</td>
		</tr>
		
		<tr>
			<td class="reg_class_label" style="width:300px;">
				პაროლი<font color="red">*</font>: 
			</td>
			<td class="reg_class_value">					
				<input id="pass" type="password" size="20" name="password">
				<% if (error != null && error.get(1) != null) out.println("<font size='2' color='red'>" + error.get(1) + "</font>"); %>
			</td>
		</tr>
		
		<tr>
			<td class="reg_class_label" style="width:300px;">
				გაიმეორეთ პაროლი<font color="red">*</font>: 
			</td>
			<td class="reg_class_value">					
				<input id="rpass" type="password" size="20" name="rpassword" onchange="checkPasswordMatch()">
				<% out.print("<font size='2' color='red' id='passError'>" + "" + "</font>"); %>
			</td>
		</tr>
		
		<tr>
			<td class="reg_class_label" style="width:300px;">
				სახელი: 
			</td>
			<td class="reg_class_value">					
				<input type="text" size="20" name="name" <% if (error != null) out.println("value='" + request.getParameter("name") + "'"); %> >
			</td>
		</tr>
		
		<tr>
			<td class="reg_class_label" style="width:300px;">
				გვარი: 
			</td>
			<td class="reg_class_value">					
				<input type="text" size="20" name="lastname" <% if (error != null) out.println("value='" + request.getParameter("lastname") + "'"); %> >
			</td>
		</tr>
		
		<tr>
			<td class="reg_class_label" style="width:300px;">
				ელ-ფოსტა<font color="red">*</font>: 
			</td>
			<td class="reg_class_value">					
				<input type="text" size="20" name="email" <% if (error != null) out.println("value='" + request.getParameter("email") + "'"); %> >
				<% if (error != null && error.get(2) != null) out.println("<font size='2' color='red'>" + error.get(2) + "</font>"); %>
			</td>
		</tr>
		
		<tr>
			<td class="reg_class_label" style="width:300px;">
				სქესი<font color="red">*</font>: 
			</td>
			<td class="reg_class_value">					
				<input type="radio" name="sex" value="male" checked='checked' >მამრობითი<br>
				<input type="radio" name="sex" value="female" <% if (error != null && request.getParameter("sex").equals("female")) out.println("checked='checked'"); %> >მდედრობითი
			</td>
		</tr>
		
		<tr>
			<td class="reg_class_label" style="width:300px;">
				დაბადების წელი<font color="red">*</font>:
			</td>
			<td class="reg_class_value">					
				<select name="birthday">
				<%
					for (int i = 1913; i < 2004; i++)
						out.println("<option value='" + i + "'>" + i + "</option>");
				%>
			</select>
			</td>
		</tr>
		<tr>
			<td align="center">
				<br><input id="dzebna" type="submit" value="რეგისტრაცია"/>
			</td>
		</tr>
	</table>
	</form>
	</fieldset>
</body>
</html>
