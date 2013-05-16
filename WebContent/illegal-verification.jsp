<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>www.IAuto.ge - რეგისტრაცია</title>
<%@include file="menu-bar.jsp"%>
<style>
div.centerStyle {
    width:600px;
    height:100px;
    position:absolute;
    left:400px;
    top:200px;
    margin:-100px 0 0 -300px;
}
</style>
</head>
<body>
	<div class="centerStyle" align="center">
		<p>თქვენ მიერ მითითებული დამადასტურებელი კოდი არ არის სწორი! გთხოვთ, შეიყვანოთ თავიდან.</p>
			<form method="post" action="Register">
				<input type="text" size="20" name="code">
				<input type="submit" value="დადასტურება"/>
			</form>
	</div>
</body>
</html>
