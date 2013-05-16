<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>www.IAuto.ge - რეგისტრაცია</title>

<style>
input.regStyle {
    position:absolute;
    top:380px;
    left:280px;
}
</style>

<style>
table.id {
    width:50%;
    position:absolute;
    left:80px;
    top:100px;
}
</style>
<%@include file="menu-bar.jsp"%>
</head>
<body>
	<form action="Verification" method="post">
	<table class="id" border="0" width="50%">
		<%
			@SuppressWarnings("unchecked")
			List<String> error = (List<String>)request.getAttribute("errorList");
				if (error != null) {
					for (int i = 0; i < error.size(); i++) {
						out.println("<tr><td class='reg_class_label'>" +
								"<font color='red'>" + error.get(i) + "</font></td></tr>");
					}
				}
		%>
		<tr>
			<td class="reg_class_label" style="width:300px;">
				მომხმარებელი (username)<font color="red">*</font>: 
			</td>
			<td class="reg_class_value">					
				<input type="text" size="20" name="username" <% if (error != null) out.println("value='" + request.getParameter("username") + "'"); %> >
			</td>
		</tr>
		
		<tr>
			<td class="reg_class_label" style="width:300px;">
				პაროლი<font color="red">*</font>: 
			</td>
			<td class="reg_class_value">					
				<input type="password" size="20" name="password">
			</td>
		</tr>
		
		<tr>
			<td class="reg_class_label" style="width:300px;">
				გაიმეორეთ პაროლი<font color="red">*</font>: 
			</td>
			<td class="reg_class_value">					
				<input type="password" size="20" name="rpassword">
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
				<br><input type="submit" value="რეგისტრაცია"/>
			</td>
		</tr>
	</table><br>
	</form>
</body>
</html>
