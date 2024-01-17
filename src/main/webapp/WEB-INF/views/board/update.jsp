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
        <title>${board} update</title>
        <!-- 사용전 경로를 꼭 수정하세요 -->
       <c:import url="../temps/head_css.jsp"></c:import>
    </head>
    <body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
            <!-- 사용전 경로를 꼭 수정하세요 -->
          <c:import url="../temps/header.jsp"></c:import>
        
        	<section class="py-5">
           	 <div class="container px-5 mb-5">
            	   	 <div class="text-center mb-5">
                    	<h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">${board}  update</span></h1>
                	</div>
               	 <div class="row gx-5 justify-content-center">
                    	<div class="col-lg-11 col-xl-9 col-xxl-8">
                    	
                    		<form class="form-control" action="update" method="POST" enctype = "multipart/form-data">
                    			<input type="hidden" name ="notice_Num" value = "${dto.notice_Num}">
                    			<div class="mb-3">
								  <label for="title" class="form-label">제목 입력</label>
								  <input type="text" class="form-control" id="title" name = "notice_Title" value = "${dto.notice_Title }">
								  
								</div>
								<div class="mb-3">
									<label for="writter" class="form-label">writter 입력</label>
									<input type="text" readonly	value="${dto.notice_Writter}"  class="form-control" id="writter" name = "notice_Writter">
								</div>
								<div class="mb-3">
								  <label for="contents" class="form-label">내용</label>
								  <textarea class="form-control" id="contents" rows="3" name="notice_Contents">${dto.notice_Contents}</textarea>
								</div>
								
								
								
								<div class="mb-3">
									<input class="form-control" type="file" name="attach">
									<input class="form-control" type="file" name="attach">
									<input class="form-control" type="file" name="attach">
								</div>
								
								<div class="mb-3">
									<button class="btn btn-primary">등록</button>
								</div>
                    		</form>
                    
                    	</div>
                	</div>
             	</div>
             </section>
        
        </main>
        <!-- Footer-->
        <!-- 사용전 경로를 꼭 수정하세요 -->
	<c:import url="../temps/footer.jsp"></c:import>
    </body>
</html>
