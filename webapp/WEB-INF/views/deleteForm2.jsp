<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>비밀번호 확인</h1>

	<form action="${pageContext.request.contextPath }/delete2" method="post">
		비밀번호:<input type="password" name="password"> 		
		<input type="hidden" name = "no" value="${param.no }">
		<input type="hidden" name="action" value="delete">
		<button type="submit">확인</button>
	</form>
	<a href="${pageContext.request.contextPath }/list">메인으로 돌아가기</a>
</body>
</html>