<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta http-equiv="Pragma" content="no-cache"> 
    <meta http-equiv="Cache-Control" content="no-store"> 
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
<link rel="stylesheet" type="text/css"  href=<c:out value="${base}public/css/home.css"/> />
<link rel="stylesheet" type="text/css"  href=<c:out value="${base}public/css/layout.css"/> />
<link rel="shortcut icon" href=<c:out value="${base}asset/favicon.ico"/> type="image/x-icon">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="icon" href=<c:out value="${base}asset/favicon.ico"/> type="image/x-icon">
<title>HOME | PAGE </title>
<% if(session.getAttribute("nom_admin")==null){
	response.sendRedirect("home");
} %>
</head>
<body>
	<jsp:include page="../layout/layout.jsp"></jsp:include>
	
	<main>
		<div class="section-1">
			<div class="left">
				<p>WELCOME MR <br/><c:out  value="${nom_admin}" /> </p>
			</div>
			<div class="right">
				<img src="${base}asset/admin.png" alt="admin sen forage"/>
			</div>
		</div>
	</main>
</body>
</html>