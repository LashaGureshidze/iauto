<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>www.IAuto.ge</title>

<style type="text/css">
.menu ul {
	font: bold 18px calibri;
	height: 25px;
}

.menu ul li {
	list-style: none;
	display: inline;
}

.menu ul li a {
	padding: 10px 25px 10px 25px;
	text-decoration: none;
	float: left;
	color: white;
	background-color: rgb(10, 10, 255);
	border: 1px solid rgb(10, 10, 15);
}

.menu ul li a:hover {
	background-color: #99FF99;
	color: rgb(10, 10, 255);
}
</style>
</head>
<body>
	<table>
		<tr>
			<td class="menu">
				<ul>
					<li><a href="/IAUTO/home-page.jsp">მთავარი</a></li>
					<li><a href="/IAUTO/my-page.jsp">ჩემი გვერდი</a></li>
					<li><a href="/IAUTO/calculator.jsp">განბჟების კალკულატორი</a></li>
					<li><a href="/IAUTO/user-register.jsp">რეგისტრაცია</a></li>
					<li><a href="/IAUTO/log-in.jsp">შესვლა</a></li>
				</ul>
			</td>
		</tr>
		<tr>
			<td><img alt="iauto-logo.jpg" src="logo" height="40" width="100"
				onclick="window.location = '/IAUTO/add-aplication.jsp';"></td>
		</tr>
	</table>
	<div style="position:;right:260px;top:30px;"  align="right">
			<br/>
				<a href="https://www.facebook.com/pages/IAutoge/155285524650712" target="_blank"  ><img src="facebook_share.png" /></a>
				<br/>
				
			</div>
</body>
</html>