<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
		<form action = "${pageContext.request.contextPath }/add" method = "post">
			<table border = "1">
				<tr>
					<td>이름</td>
					<td><input type = "text" name = "name"></td>
					<td>비밀번호</td>
					<td><input type = "password" name = "password"></td>
				</tr>
			
				<tr>
					<td colspan = "5"><textarea name = "content"></textarea></td>
				</tr>
				
				<tr>
					<td colspan = "5"><button type = "submit">확인</button></td>
				</tr>
			</table>
			<input type = "hidden" name = "action" value = "add">
		</form>
		<br>
	
	<c:forEach items = "${requestScope.guestList }" var = "guestList">
		<table border = "1">
			<tr>
				<td>${guestList.no }</td>
				<td>${guestList.name }</td>
				<td>${guestList.regDate }</td>	
				<td><a href="${pageContext.request.contextPath }/deleteForm?no=${guestList.no }">삭제</a></td>
			</tr>
	
			<tr>
				<td colspan = "4">${guestList.content }</td>
			</tr>
		</table>
		<br>
	</c:forEach>
	

</body>
</html>