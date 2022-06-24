<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>ERROR</title>
		<style>
			a{
				text-decoration:none;
				color:black;
			}
		</style>
	</head>
	<body>
		
		<h1>찾을 수 없거나 존재하지 않는 페이지입니다.</h1>
		
		<br><hr><br>
		${requestScope.error}  
		<br>
		
		<a href="guestbook.do"> 리스트로 돌아가기</a>
		
	</body>
</html>