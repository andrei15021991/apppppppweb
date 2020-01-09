<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Тест№1</h1>
	
	<ol>
		
    	<c:forEach var="question" items="${watch}">
    	
        	<li><c:out value="${question}" /></li><br/>
        	
        </c:forEach>
        
    </ol><br/>
    
    <form action="Controller" method="post">
	
		<input type="hidden" name="command" value="start_test" />
		<input type="hidden" name="testname" value="test1" />
		<input class="move" type="submit" value="start" /> <br/>
		
	</form>
	
	

</body>
</html>