<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>

<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	
	<link href="WEB-INF/css/style.css" rel="stylesheet"/>
	<style type="text/css">
   		<%@include file="WEB-INF/css/style.css" %>
   	</style>
   	
</head>

<body>

	<c:redirect url="Controller?command=go_to_sign_in" />

</body>

</html>