<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Тест№1</h1>

		<form action="Controller" method="post">
		
			<input type="hidden" name="command" value="test_result"/>
			<input type="hidden" name="testname" value="test1"/>
			
			<ol>
				<li>
					<p>${questions[0].question}</p>
					
   					<p><input type="checkbox" name="a1" value="wrong"> Полиморфизм</p>
   					<p><input type="checkbox" name="a1" value="wrong"> Наследование</p>
   					<p><input type="checkbox" name="a1" value="correct"> ${questions[0].answer}</p>
  					<p><input type="checkbox" name="a1" value="wrong"> ООП</p>
  					
  					<input type="hidden" name="a1" value="wrong" checked="checked"/>
				</li>
				
				<li>
					<p>${questions[1].question}</p>
					
   					<p><input type="checkbox" name="a2" value="wrong"> Полиморфизм</p>
   					<p><input type="checkbox" name="a2" value="wrong"> Инкапсуляция</p>
   					<p><input type="checkbox" name="a2" value="correct"> ${questions[1].answer}</p>
  					<p><input type="checkbox" name="a2" value="wrong"> ООП</p>
  					
  					<input type="hidden" name="a2" value="wrong" checked="checked"/>
				</li>
				
				<li>
					<p>${questions[2].question}</p>
					
   					<p><input type="checkbox" name="a3" value="wrong"> Наследование</p>
   					<p><input type="checkbox" name="a3" value="wrong"> Инкапсуляция</p>
   					<p><input type="checkbox" name="a3" value="correct"> ${questions[2].answer}</p>
  					<p><input type="checkbox" name="a3" value="wrong"> ООП</p>
  					
  					<input type="hidden" name="a3" value="wrong" checked="checked"/>
				</li>
			</ol>
			
			<input class="move" type="submit" value="finish"/>
			
		</form>


</body>
</html>