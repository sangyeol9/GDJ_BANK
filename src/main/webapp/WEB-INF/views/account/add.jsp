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
        <title>account Add</title>
        <!-- 사용전 경로를 꼭 수정하세요 -->
       <c:import url="../temps/head_css.jsp"></c:import>
       <c:import url="../temps/summerNote.jsp"></c:import>
    </head>
    <body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
            <!-- 사용전 경로를 꼭 수정하세요 -->
          <c:import url="../temps/header.jsp"></c:import>
        
        	<section class="py-5">
           	 <div class="container px-5 mb-5">
            	   	 <div class="text-center mb-5">
                    	<h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">account ADD</span></h1>
                	 </div>
               		 <form class="form-control"  method="POST" enctype = "multipart/form-data">
                    		
                    		 <input type="hidden" class="form-control must "  name = "productNum" value=${detail.productNum}  >
								 
                    			<div class="mb-3">
								  <label for="pw" class="form-label">패스워드 입력</label>
								  <input type="text" class="form-control must " id="pw" name = "account_pw"  >
								  
								</div>
								<button id ="btn" class="btn-primary">가입하기</button>
					</form>
             </div>
            </section>
        
        </main>
        <!-- Footer-->
        <!-- 사용전 경로를 꼭 수정하세요 -->
	<c:import url="../temps/footer.jsp"></c:import>
	
	<script type="text/javascript">
        const pw = document.getElementById("pw");
        const btn = document.getElementById('btn');
        btn.addEventListener("click",function(e){
            let check;
            console.log(Number(pw.value));
           
           
           check = Number(pw.value);
        	if(isNaN(check)) {
                    e.preventDefault();
                    alert("숫자만 입력하시오");
                }  
           
        })

        pw.addEventListener("blur",function(){
            console.log(Number(pw.value));
            
        })

	</script>
    </body>
</html>
