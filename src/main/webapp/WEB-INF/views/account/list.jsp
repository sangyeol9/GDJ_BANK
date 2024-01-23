<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
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
        
        	<table class="table table-hover">
				<tr>
					<th>상품명</th>
					<th>계좌</th>
					<th>잔액</th>
					<th>이자율</th>
					<th>가입일</th>
				</tr>

				<c:forEach items="${list}" var="list">
						<c:forEach items="${list.accountDTOs}" var="alist">
					<tr>
					
							<td>${list.productName}</td>
							<td>${alist.account_num}</td>
							<td>${alist.account_balance}</td>
							<td>${list.productRate }</td>
							<td>${alist.account_date}</td>
					</tr>
						</c:forEach>
				</c:forEach>
			</table>
        	
        	<div>
			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<c:if test="${page.start_page != 1}">
						<li class="page-item "><a class="page-link"
							href="list?page=${page.start_page-1}"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
					</c:if>
					<c:forEach begin="${page.start_page}" end="${page.last_page}"
						var="i">
						<li class="page-item"><a class="page-link"
							href="list?page=${i}">${i}</a></li>
					</c:forEach>
					<c:if
						test="${page.start_page != page.totalBlock*page.perBlock-(page.perBlock-1)}">
						<li class="page-item"><a class="page-link"
							href="list?page=${page.last_page+1}"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</c:if>
				</ul>
			</nav>
		</div>
        
        </main>
        <!-- Footer-->
        <!-- 사용전 경로를 꼭 수정하세요 -->
	<c:import url="../temps/footer.jsp"></c:import>
    </body>
</html>
