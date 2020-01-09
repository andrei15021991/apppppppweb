<%@ page language="java" import="by.htp.wa.bean.User" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

	<fmt:setLocale value="${sessionScope.local}" />
   	<fmt:setBundle basename="localization/local" var="loc" />
   	
   	<fmt:message bundle="${loc}" key="local.message1" var="message1" />
   	<fmt:message bundle="${loc}" key="local.message2" var="message2" />
   	<fmt:message bundle="${loc}" key="local.message3" var="message3" />
   	<fmt:message bundle="${loc}" key="local.message4" var="message4" />
   	<fmt:message bundle="${loc}" key="local.message5" var="message5" />
   	<fmt:message bundle="${loc}" key="local.message6" var="message6" />
   	<fmt:message bundle="${loc}" key="local.message7" var="message7" />
   	<fmt:message bundle="${loc}" key="local.message10" var="message10" />
   	<fmt:message bundle="${loc}" key="local.message11" var="message11" />
   	
   	<fmt:message bundle="${loc}" key="local.locbutton.name.en" var="en_button" />
   	<fmt:message bundle="${loc}" key="local.locbutton.name.ru" var="ru_button" />
   	
</head>
<body>

	<% 
		User user = (User)session.getAttribute("user");
		out.println("Hello, " + user.getFirstName() + " " + user.getLastName() + " " + user.getEmail());
			
	%>
	
	<div>
		<h3>${message10}</h3>
		
		<form action="Controller" method="post">
	
		<input type="hidden" name="command" value="go_to_test" />
		<input type="hidden" name="testname" value="test1" />
		<input class="move" type="submit" value="${message11}" />
		
	</form>
	</div><br/>
	
	<form action="Controller" method="post">
	
		<input type="hidden" name="command" value="sign_out" />
		<input class="move" type="submit" value="${message7}" /> <br/>
		
	</form>
	
	<br/>
	<br/>
	
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