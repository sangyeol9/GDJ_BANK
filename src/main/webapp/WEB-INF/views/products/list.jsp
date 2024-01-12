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
		
		<div>
			
				<form class="row g-3" action="list" method="get">
					<div class = "col-auto">
					  <select name="kind" class="form-select" aria-label="Default select example">
					  <option value="kind1">name</option>
					  <option value="kind2">contents</option>
					  <option value="kind3">rate</option>
					  <option value="kind4">name+writer+contents</option>
						</select>
						<!-- JS를 사용하여 ATRRIBUTE 값을 넣어준다! -->
					</div>
				  <div class="col-auto">
				    <label for="search" class="visually-hidden">search</label>
				    <input type="text" name="search" class="form-control" id="search" placeholder="search" value="${page.search}">
				  </div>
				  <div class="col-auto">
				    <button type="submit" class="btn btn-primary mb-3">검색</button>
				  </div>
				</form>
			
		</div>
		
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
					<td><a href="detail?productnum=${dto.productnum}">${dto.productname}</a></td>
					<td>${dto.productrate}</td>
					<td>${dto.productjumsu}</td>
				
			</tr>
				</c:forEach>
			
		</table>
		
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
		
		<a href="./add" class="btn btn-outline-success">ADD</a>
		
		<c:import url="../temps/bootstrap_js.jsp"></c:import> 
</body>
</html>