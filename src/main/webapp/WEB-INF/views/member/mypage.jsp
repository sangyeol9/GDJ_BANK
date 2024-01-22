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
        <title>mypage</title>
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
                    <h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">mypage</span></h1>
                </div>
                <div class="row gx-5 justify-content-center">
                    <div class="col-lg-11 col-xl-9 col-xxl-8">
                        <!-- Project Card 1-->
                        <div class="card overflow-hidden shadow rounded-4 border-0 mb-5">
                            <div class="card-body p-0">
                                <div class="row d-flex align-items-center">
                                    
                                    <div class="col-6">
                                        <h2 class="fw-bolder">아이디 : ${mypage.userName}</h2>
                                   		<div>
                                   			
                                   		이메일 :	${mypage.eMail}
                                   		</div>
										
										
                                       
                           				
                           				<div>
                           					전화번호 : ${mypage.phone}
                           				</div>
                           				<div>
                           					이름 : ${mypage.name}
                           				</div>
                           				<div>
                           					주소 : ${mypage.address}
                           				</div>
                           				</div>
                           				 <div class="col-6" >
	                                           <img  style="width:180px" src="/resources/upload/member/${mypage.fileDTO.fileName}">
                           				</div>
                                    
                                </div>
                            </div>
                        </div>
						
                        <div>
                            <a class="btn btn-primary" href="./update">수정</a>
                            <a class="btn btn-primary" href="./updatePassword">비밀번호 수정</a>
                            <a class="btn btn-primary" href="./delete">회원탈퇴</a>
                        </div>

                        
                    </div>
                </div>
            </div>
            </section>
        </main>
        <!-- Footer-->
        <!-- 사용전 경로를 꼭 수정하세요 -->
	<c:import url="../temps/footer.jsp"></c:import>
    <script src="/resources//js/boardDetail.js"></script>
    </body>
</html>
