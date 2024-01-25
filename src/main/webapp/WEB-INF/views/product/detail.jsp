<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Personal - Start Bootstrap Theme</title>
<!-- 사용전 경로를 꼭 수정하세요 -->
<c:import url="../temps/head_css.jsp"></c:import>
</head>
<body class="d-flex flex-column h-100">
	<main class="flex-shrink-0">
		<!-- 사용전 경로를 꼭 수정하세요 -->
		<c:import url="../temps/header.jsp"></c:import>

		<h1>product name = ${detail.productName}</h1>
		<c:if test="${member != null}">
		<div>
			<a href="update"> 수정하기 </a>
		</div>
		<div>
			<a href="delete?productNum=${detail.productNum}"> 삭제하기 </a>
		</div>
		<div>
			<a href = "/account/add?productNum=${detail.productNum}">상품 가입하기</a>
		</div>
		<div>
			<button data-wish="${detail.productNum}" id="wish" type="button">관심추가</button>
		</div>
		</c:if>
	</main>
	<!-- Footer-->
	<!-- 사용전 경로를 꼭 수정하세요 -->
	<c:import url="../temps/footer.jsp"></c:import>
	<script src="/resources/js/product/wishlist.js"></script>
</body>
</html>
