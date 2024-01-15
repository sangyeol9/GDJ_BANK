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
        
        <table>
        	<tr>
        		<th>num</th>
        		<th>name</th>
        		<th>rate</th>
        	</tr>
        
        <c:forEach items="${list}" var="list">
        <tr>
        	<td>${list.productNum}</td>
        	<td><a href="detail?productNum=${list.productNum}">${list.productName}</a></td>
        	<td>${list.productRate}</td>		
        </tr>
        </c:forEach>
        </table>
        
    </div>
    
    <div>
			<nav aria-label="Page navigation example">
			  <ul class="pagination">
			    <c:if test="${page.start_page != 1}">
			    <li class="page-item ">
			      <a class="page-link" href="list?page=${page.start_page-1}&search=${page.search}&kind=${page.kind}" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			    </c:if>
			    <c:forEach begin="${page.start_page}" end="${page.last_page}"   var = "i">
			    <li class="page-item"><a class="page-link" href="list?page=${i}&search=${page.search}&kind=${page.kind}">${i}</a></li>
			    </c:forEach>
			    <c:if test="${page.start_page != page.totalBlock*page.perBlock-(page.perBlock-1)}">
			    <li class="page-item">
			      <a class="page-link" href="list?page=${page.last_page+1}&search=${page.search}&kind=${page.kind}" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			    </c:if>
			  </ul>
			</nav>
		</div> 
    
<div>
    <a href="add">상품등록</a>
</div>
</div>
	
<c:import url="../temps/footer.jsp"></c:import>
</body>
</html>