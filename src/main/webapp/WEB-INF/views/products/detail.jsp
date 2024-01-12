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

	<section class="container-fluid">
		<div>
			<c:if test="${detail != null }">	
			<h3>${requestScope.detail.productnum}</h3>
			<div>${detail.productname}</div>
			<div>${detail.productcontents}</div>
			<div>${detail.productrate}</div>
			<div>${detail.productjumsu}</div>
			<div>
				<h2>FILE</h2>
				<c:forEach items="${detail.fileDTOs}" var ="list">
				  <a href="/resources/upload/products/${list.filename}">${list.oriname}</a> 
				  </c:forEach>
			</div>  
			<br>
			<button id="up" data-product-id="${requestScope.detail.productnum}">Update</button>
			<form id="frm" action="delete" method="post">
				<input type="hidden" name="productnum" value="${detail.productnum}">
			<button id="del">Delete</button>
				
			</form>
			</c:if>
			<c:if test="${empty detail }">
				<h3>없는번호입니다</h3>
			</c:if>
		</div>
	</section>
	
<c:import url="../temps/bootstrap_js.jsp"></c:import>
</body>
</html>