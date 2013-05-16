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

<style type="text/css">
.hovermenu ul {
	font: bold 18px calibri;
	height: 25px;
}

.hovermenu ul li {
	list-style: none;
	display: inline;
}

.hovermenu ul li a {
	padding: 10px 25px 10px 25px;
	text-decoration: none;
	float: left;
	color: white;
	background-color: rgb(255, 216, 100);
	border: 1px solid rgb(255, 216, 100);
}

.hovermenu ul li a:hover {
	background-color: #FFFFFF;
	color: rgb(255, 216, 100);
}
</style>

<style type="text/css">
#axali_dzebna {
	width: 814px;
	background: url(http://myauto.ge/images/maxo.png);
	border: 5px solid rgb(255, 255, 255);
	box-shadow: 0px 4px 21px -4px #858585;
	text-shadow: rgba(78, 78, 78, 0.12) 0.1em 0.1em 0.2em;
	font-weight: normal;
}

#gamochenili {
	height: 97px;
}

.sigane {
	display: inline-block;
	width: 200px;
	text-align: center;
}

.fasi_weli_garbeni {
	width: 71px;
	height: 22px;
}

.seleqtebi {
	width: 150px;
	height: 28px;
	margin-top: 3px;
	text-shadow: rgba(78, 78, 78, 0.12) 0.1em 0.1em 0.2em;
}

#kompleqtacia {
	border: 1px solid rgb(255, 195, 118);
	background-color: rgba(255, 173, 0, 0.07);
	margin-left: 20px;
	margin-top: 4px;
	width: 570px;
	padding-bottom: 4px;
}

#dzebna {
	background: rgb(255, 153, 0);
	background: -moz-linear-gradient(top, rgb(255, 208, 60) 0%,
		rgb(255, 169, 16) 100% );
	background: -webkit-linear-gradient(top, rgb(255, 208, 60) 0%,
		rgb(255, 169, 16) 100% );
	background: -o-linear-gradient(top, rgb(255, 208, 60) 0%,
		rgb(255, 169, 16) 100% );
	background: -ms-linear-gradient(top, rgb(255, 208, 60) 0%,
		rgb(255, 169, 16) 100% );
	background: linear-gradient(top, rgb(255, 208, 60) 0%, rgb(255, 169, 16)
		100% );
	padding: 3px 17px;
	color: #fff;
	font-family: 'Helvetica Neue', sans-serif;
	font-size: 17px;
	border-radius: 4px;
	-moz-border-radius: 4px;
	-webkit-border-radius: 4px;
	border: 1px solid rgb(213, 150, 17);
	cursor: pointer;
}

.search_rect_down {
	cursor: pointer;
	padding-right: 4px;
	background-image: url('http://myjobs.ge/new/images/rect_down.gif');
	background-repeat: no-repeat;
	display: inline-block;
	text-indent: 15px;
	background-position: 0 3px;
}

.search_rect_up {
	background-image: url('http://myjobs.ge/new/images/rect_up.gif');
}

.search_rect_down:hover {
	color: rgb(255, 163, 0);
}

.search_rect_down1 {
	cursor: pointer;
	padding-right: 4px;
	background-image: url('http://myjobs.ge/new/images/rect_down.gif');
	background-repeat: no-repeat;
	display: inline-block;
	text-indent: 15px;
	background-position: 0 3px;
}

.search_rect_up1 {
	background-image: url('http://myjobs.ge/new/images/rect_up.gif');
}

.search_rect_down1:hover {
	color: rgb(255, 163, 0);
}
</style>
	<style type="text/css">
.button {
	color: rgb(255, 163, 100);
	width: 105px;
	height: 40px;
	background-image: url('tiny.gif');
	line-height: 20px;
	padding-bottom: 2px;
	vertical-align: middle;
	font-family: "Lucida Grande", Geneva, Verdana, Arial, Helvetica,
		sans-serif;
	font-size: 18px; <!--
	font-weight: bold; -->
	text-transform: none;
	border: 1px solid transparent;
}
</style>

</head>
<body>
	<table>
		<tr>
			<td>
				<div class="hovermenu">
					<ul>
						<li><a href="home-page.jsp">მთავარი</a></li>
						<li><a href="my-page.jsp">ჩემი გვერდი</a></li>
						<li><a href="log-in.jsp">შესვლა</a></li>
						<li><a href="user-register.jsp">რეგისტრაცია</a></li>
					</ul>
				</div>
			</td>
			<td width="30px">
				<form action="Add_Application" method="post">
					<input type="submit" name="add app" value="დამატება" class="button">
				</form>
			</td>
			<td width="30px">
				<form action="Log_Out" method="post">
					<input type="submit" name="log out" value="გამოსვლა" class="button">
				</form>
			</td>
		</tr>
	</table>
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
