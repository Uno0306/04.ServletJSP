<%@page import="model.domain.Student, java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>jsp04_ELJava</title>
	</head>
	<body>
		<h3>String 데이터 출력</h3>
		<%
			session.setAttribute("sessionData", "hi");
			request.setAttribute("requestData", "hello");
		%>
		
		${sessionScope.sessionData}	<br/>
		${requestScope.requestData} <br/>
	
		<h3>DTO 데이터 출력</h3>
		<%
			Student student1 = new Student("김윤호", 26);
			Student student2 = new Student("김도헌", 26);
			session.setAttribute("yh", student1);
			session.setAttribute("dh", student2);
		%>
		
		${sessionScope.yh.name }	<br/>
		${sessionScope.dh }	<br/>
	
		
		<h3>ArrayList 데이터 출력</h3>
		<%
			ArrayList arr = new ArrayList();
			arr.add(student1);
			arr.add(student2);
			
			session.setAttribute("arr", arr);
		%>
		${sessionScope.arr.get(1).age } <br/>
		${sessionScope.arr[1].age }	<br/>
		
		
		
		
		
	</body>
</html>