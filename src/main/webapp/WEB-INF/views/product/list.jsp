<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temps/head_css.jsp"></c:import>
</head>
<body>
<c:import url="../temps/header.jsp"></c:import>
<div class="container px-5 my-5">
    <div class="text-center mb-5">
        <h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">Product List</span></h1>
    </div>
<div>
    <a href="add">상품등록</a>
</div>
</div>
	
<c:import url="../temps/footer.jsp"></c:import>
</body>
</html>