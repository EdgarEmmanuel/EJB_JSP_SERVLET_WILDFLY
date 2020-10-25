<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="Pragma" content="no-cache"> 
    <meta http-equiv="Cache-Control" content="no-cache"> 
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"  href=<c:out value="${base}public/css/client.css"/> />
<link rel="stylesheet" type="text/css"  href=<c:out value="${base}public/css/layout.css"/> />
<link rel="shortcut icon" href=<c:out value="${base}asset/favicon.ico"/> type="image/x-icon">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="icon" href=<c:out value="${base}asset/favicon.ico"/> type="image/x-icon">
<title>CLIENT | PAGE </title>
<% if(session.getAttribute("nom_admin")==null){
	response.sendRedirect("home");
}%>
</head>
<body>
	<jsp:include page="../layout/layout.jsp"></jsp:include>
	<main>
		<form action="insert_client.act" method="post">
			<input type="text" placeholder="nom" name="nom" required /><br/>
			<input type="email" placeholder="email" name="email" required /><br/>
			<input type="text" placeholder="prenom" name="prenom" required /><br/>
			<input type="text" placeholder="addresse" name="addresse" required /><br/>
			<input type="text" placeholder="telephone" name="telephone" required /><br/>
			<select  name="id_village"  required>
				<c:forEach items="${villages}" var="village" >
					<option value="${village.id}"><c:out value="${village.nom}"/></option>
				</c:forEach>
			</select>
			<div class="buttons">
			<input type="submit" value="ENREGISTRER" /><input type="reset" value="ANNULER" />
			</div>
		</form>
	</main>
</body>
</html>