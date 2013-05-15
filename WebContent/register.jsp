<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>www.IAuto.ge</title>
</head>
<body>
		<form action="Verification" method="post">
		<p>მომხმარებელი (username): <input type="text" name="username"></p>
		<p>პაროლი: <input type="text" name="password"></p>
		<p>გაიმეორეთ პაროლი: <input type="text" name="rpassword"></p>
		<p>სახელი: <input type="text" name="name"></p>
		<p>გვარი: <input type="text" name="lastName"></p>
		<p>ელ-ფოსტა: <input type="text" name="email"></p>
 		<p>სქესი: 
			<select name="sex">
  				<option value="ms">მდედრობითი</option>
  				<option value="mrs">მამრობითი</option>
			</select>
		  </p>
		<p>დაბადების წელი: <input type="text" name="birthday"></p>
		<input type="submit" value="რეგისტრაცია"/>
	</form>
</body>
</html>