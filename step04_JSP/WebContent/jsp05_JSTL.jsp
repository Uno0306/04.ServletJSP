<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>jsp05_JSTL</title>
	</head>
	<body>
	
		<h3>stpe01: JSTL 단일 조건</h3>
		<c:if test="${'a' != 'a' }">
			여기가 출력된다면 이것은 참
		</c:if>
		<br/><br/>
	
		<h3>step02: JSTL 다중 조건</h3>
		<% session.setAttribute("busan", "7층"); %>
		<c:choose>
			<c:when test="${sessionScope.busan == '6층'}" >
				여기는 공사중<br/>
			</c:when>
			<c:when test="${sessionScope.busan == '7층'}">
				열공하고 집에 갑시다<br/>
			</c:when>
		</c:choose>
		<br/><br/>
	
		<h3>step03: null값 검증</h3>
		<% request.setAttribute("data", null); %>
		<c:if test="${empty requestScope.data}">
			null 값입니다.
		</c:if>
		<c:if test="${not empty requestScope.data}">
			null 값이 아닙니다.
		</c:if>
	
	</body>
</html>