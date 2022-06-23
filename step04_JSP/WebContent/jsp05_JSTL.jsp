<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="model.domain.Student, java.util.ArrayList" %>
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
		<hr/><br/>
	
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
		<hr/><br/>
	
		<h3>step03: null값 검증</h3>
		<% request.setAttribute("data", null); %>
		<c:if test="${empty requestScope.data}">
			null 값입니다.
		</c:if>
		<c:if test="${not empty requestScope.data}">
			null 값이 아닙니다.
		</c:if>
		<hr/><br/>
	
		<h3>step04: JSTL의 반복</h3>
		<%
			ArrayList<String> arr = new ArrayList();
			arr.add("str1");
			arr.add("str2");
			arr.add("str3");
			arr.add("str4");
			arr.add("str5");
			
			session.setAttribute("arr", arr);
		%>
		
		1 ~ 5 출력 <br/>
		<c:forEach begin="1" end="5" var="num">
			${num} <br/>
		</c:forEach>
		<br/>
		
		1 ~ 5 출력 : step <br/>
		<c:forEach begin="1" end="5" step="2" var="num">
			${num}<br/>
		</c:forEach>
		
		 반복에 대한 상태 파악을 위해 count, index <br/>
		 <table id="arrayList" border="1">
		 	<tr><th>index</th><th>var</th><th>count</th></tr>
		 	<c:forEach begin="1" end="5" var="myVar" varStatus="LoopStatus">
		 		<tr>
		 			<td>${LoopStatus.index}</td>
		 			<td>${myVar}</td>
		 			<td>${LoopStatus.count}</td>
		 		</tr>
		 	</c:forEach>
		 </table>
		 <br/>
		
		반복에 대한 상태파악을 위해 count1, index2
		 <table id="arrayList2" border="1">
		 	<tr><th>NO</th><th>var</th></tr>
		 	<c:forEach var="myVar" items="${sessionScope.arr }" varStatus="LoopStatus">
		 		<tr>
		 			<td>${LoopStatus.index}</td>
		 			<td>${myVar}</td>
		 		</tr>
		 	</c:forEach>
		 </table>
		<hr/><br/>
		
		
		
	</body>
</html>