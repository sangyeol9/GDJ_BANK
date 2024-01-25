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
        

            <button id="btn">삭제</button>
        	<table class="table table-hover">
				<tr>
                    <th><input id="checkAll" type="checkbox"><label for="checkAll">전체 선택</label></th>
					<th>상품번호</th>
					<th>상품명</th>
					<th>이자율</th>
					
				</tr>

				<c:forEach items="${list}" var="list">
						
					<tr>
                            <td><input id="${list.productNum}b" value="${list.productNum}" type="checkbox" class="wishlist"></td>
							<td>${list.productNum}</td>
							<td>${list.productName}</td>
							<td>${list.productRate }</td>
                            
							
					</tr>
						
				</c:forEach>
			</table>
        	
        	
        
        </main>
        <!-- Footer-->
        <!-- 사용전 경로를 꼭 수정하세요 -->
	<c:import url="../temps/footer.jsp"></c:import>
    <script src="/resources/js/wishlist/list.js"></script>
    </body>
</html>
