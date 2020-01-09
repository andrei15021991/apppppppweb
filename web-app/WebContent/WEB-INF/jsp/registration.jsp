<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>

	<meta charset="utf-8">
	<title>Insert title here</title>
	
	<link href="../css/style.css" rel="stylesheet"/>
	
	<style type="text/css">
	
   		<%@include file="../css/style.css" %>
   		
   	</style>

	<fmt:setLocale value="${sessionScope.local}" />
   	<fmt:setBundle basename="localization/local" var="loc" />
   	
   	<fmt:message bundle="${loc}" key="local.message1" var="message1" />
   	<fmt:message bundle="${loc}" key="local.message2" var="message2" />
   	<fmt:message bundle="${loc}" key="local.message3" var="message3" />
   	<fmt:message bundle="${loc}" key="local.message4" var="message4" />
   	<fmt:message bundle="${loc}" key="local.message5" var="message5" />
   	<fmt:message bundle="${loc}" key="local.message6" var="message6" />
   	<fmt:message bundle="${loc}" key="local.message8" var="message8" />
   	<fmt:message bundle="${loc}" key="local.message9" var="message9" />
   	
   	<fmt:message bundle="${loc}" key="local.locbutton.name.en" var="en_button" />
   	<fmt:message bundle="${loc}" key="local.locbutton.name.ru" var="ru_button" />
   	
</head>

<body>

<form action="Controller" method="post">
	
		<input type="hidden" name="command" value="registration" />
		<c:out value="${message1}" />
		<input type="text" name="login" value="" required="required" pattern="^[a-z0-9_-]{3,16}$"/>
		<c:out value="${message2}" />
		<input type="text" name="password" value="" required="required" pattern="^[a-z0-9_-]{3,16}$" /><br/>
		<br/>
		<c:out value="${message5}" />
		<input type="text" name="firstname" value="" required="required" pattern="^[А-Яа-я]+$" />
		<c:out value="${message8}" />
		<input type="text" name="lastname" value="" required="required" pattern="^[А-Яа-я]+$" />
		<c:out value="${message9}" />
		<input type="email" name="email" value="" required="required" pattern="^([a-z0-9_\.-]+)@([a-z0-9_\.-]+)\.([a-z\.]{2,6})$" /><br/>
		<br/>
		<input class="move" type="submit" value="${message6}" />
		
	</form> <br/>
	
	<c:if test="${not empty param.errorMessage}">
	
		<c:out value="${param.errorMessage}"></c:out>
		
	</c:if>
	
	<form action="Controller" method="post">
	
		<input type="hidden" name="command" value="localization" />
		<input type="hidden" name="local" value="ru" />
		<input class="move" type="submit" value="${ru_button}" /> <br/>
		
	</form>
	
	<form action="Controller" method="post">
	
		<input type="hidden" name="command" value="localization" />
		<input type="hidden" name="local" value="en" />
		<input class="move" type="submit" value="${en_button}" /> <br/>
		
	</form>

</body>

</html>