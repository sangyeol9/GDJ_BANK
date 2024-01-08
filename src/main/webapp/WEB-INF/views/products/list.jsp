<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
 <c:import url="../temps/bootstrap_css.jsp"></c:import> 
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
		<c:import url="../temps/header.jsp"></c:import>
		
		<table>
			<tr>
				<th>num</th>
				<th>name</th>
				<th>rate</th>
				<th>jumsu</th>
			</tr>
			
				<c:forEach items="${requestScope.list}" var ="dto" >
			<tr>
					<td>${dto.productnum}</td>
					<td>${dto.productname}</td>
					<td>${dto.productrate}</td>
					<td>${dto.productjumsu}</td>
				
			</tr>
				</c:forEach>
			
		</table>
		
		<c:import url="../temps/bootstrap_js.jsp"></c:import> 
</body>
</html>