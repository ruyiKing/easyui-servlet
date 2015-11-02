<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<%@include file="/jsp/public.jsp" %>
	<script type="text/javascript">
		$(function(){
			
		})
		
		
	</script>
</head>
<body>
	
	<form action="">
		<fieldset>
		<legend>hello easyui</legend>
		   <!--  input
		    button     checkbox    file    hidden    image    password    radio    reset    submit    text
			 -->
			<input type="text" name="username" id="userid" value=""><br/>
			
			<input type="button" name="butname" id="butid" value="BUTON" />
			<button type="button" >Click Me!</button>
			<input type="submit" value="Submit" /> <br/>
			
			<input type="radio" name="sex" value="male" /> Male
			<input type="radio" name="sex" value="female" /> Female<br />
			
			<input type="checkbox" name="bike" />I have a bike
			<input type="checkbox" name="car" />I have a car<br />
			
			<select>
				<option value="a">A</option>
				<option value="b">B</option>
				<option value="c" selected="selected">C</option>
			</select>
		
		</fieldset>
	</form>

</body>
</html>