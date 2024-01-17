<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board} List</title>
<c:import url="../temps/head_css.jsp"></c:import>
</head>
<body>
<c:import url="../temps/header.jsp"></c:import>
	
        <section class="py-5">
            <div class="container px-5 mb-5">
                <div class="text-center mb-5">
                    <h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">${board}  List</span></h1>
                </div>
                <div class="row gx-5 justify-content-center">
                    <div class="col-lg-11 col-xl-9 col-xxl-8">
                        <!-- Project Card 1-->
                        <table class="table table-hover">
                            <tr class="table-dark">
                                <th>no</th>
                                <th>title</th>
                                <th>writter</th>
                                <th>time</th> 
                                <th>view</th>
                            </tr>
                            
                           <c:forEach items="${list}" var="dto">
                           	<tr>
                           		<td>${dto.notice_Num}</td>
                           		<td>
                           			<a href="detail?notice_Num=${dto.notice_Num}">
                           				<c:catch>
                           				<c:forEach begin="1" end="${dto.notice_Depth}"> -- </c:forEach>
</c:catch>
                           				${dto.notice_Title}
                           				
                           			</a>
                          		</td>
                           		<td>${dto.notice_Writter}</td>
                           		<td>${dto.notice_Time}</td>
                           		<td>${dto.notice_View}</td>
                           		</tr>
                           </c:forEach>
                        </table>

                        <div>
							<nav aria-label="Page navigation example">
							  <ul class="pagination">
							    <c:if test="${page.start_page != 1}">
							    <li class="page-item ">
							      <a class="page-link " href="list?page=${page.start_page-1}&search=${page.search}&kind=${page.kind}" aria-label="Previous"
                                  >
							        <span class = 'pager' aria-hidden="true" data-page="${page.start_page-1}">&laquo;</span>
							      </a>
							    </li>
							    </c:if>
							    <c:forEach begin="${page.start_page}" end="${page.last_page}"   var = "i">
							    <li class="page-item "><a class="page-link pager" href="list?page=${i}&search=${page.search}&kind=${page.kind}" data-page="${i}">${i}</a></li>
							    </c:forEach>
                                <c:if test="${page.start_page != page.totalBlock*page.perBlock-(page.perBlock-1)}">
							    <li class="page-item">
							      <a class="page-link " href="list?page=${page.last_page+1}&search=${page.search}&kind=${page.kind}" aria-label="Next">
							        <span class="pager" aria-hidden="true" data-page="${page.last_page+1}">&raquo;</span>
							      </a>
							    </li>
							   </c:if>
							  </ul>
							</nav>
						</div> 
                        
                        <div>
                        	<a href="add" class="btn btn-primary">글 쓰기</a>
                        </div>
                        
                </div>
            </div>
        </section>

    
<c:import url="../temps/footer.jsp"></c:import>
<script src="/resources/js/boardSearch.js"></script>
</body>
</html>