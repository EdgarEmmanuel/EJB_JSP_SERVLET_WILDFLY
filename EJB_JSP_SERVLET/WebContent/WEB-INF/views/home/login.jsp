<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" type="text/css"  href="<c:out value="${base}public/css/login.css"/>" />
<link rel="shortcut icon" href="<c:out value="${base}asset/favicon.ico"/>" type="image/x-icon">
<link rel="icon" href="<c:out value="${base}asset/favicon.ico"/>" type="image/x-icon">
<title>LOGIN | PAGE </title>
</head>
<body>
	<div class="body_tert">
		<div class="left">
			<img src="${base}asset/logo_senForage.png" alt="forage image" />
		</div>
		<div class="right">
			<form action="connex.conne" method="post">
				<input type="text" placeholder="login" name="login" required/><br/><br/><br/>
				<input type="password" placeholder="password" name="password" required/>
				<label>ROLE</label><br/>
				<select required name="role">
					<option>...</option>
					<option value="administrateur">Administrateur</option>
				</select>
				<input type="submit" value="SE CONNECTER" />
			</form>
			<div class="message">
			 	<p>${message}</p>
			</div>
		</div>
	</div>
</body>
</html>