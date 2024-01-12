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
        
          <section class="py-5">
            <div class="container px-5">
                <!-- Contact form-->
                <div class="bg-light rounded-4 py-5 px-4 px-md-5">
                    <div class="text-center mb-5">
                        <div class="feature bg-primary bg-gradient-primary-to-secondary text-white rounded-3 mb-3"><i class="bi bi-envelope"></i></div>
                        <h1 class="fw-bolder">상품 추가</h1>
                        <p class="lead fw-normal text-muted mb-0">양식에 맞춰 적으세요</p>
                    </div>
                    <div class="row gx-5 justify-content-center">
                        <div class="col-lg-8 col-xl-6">
                            <!-- * * * * * * * * * * * * * * *-->
                            <!-- * * SB Forms Contact Form * *-->
                            <!-- * * * * * * * * * * * * * * *-->
                            <!-- This form is pre-integrated with SB Forms.-->
                            <!-- To make this form functional, sign up at-->
                            <!-- https://startbootstrap.com/solution/contact-forms-->
                            <!-- to get an API token!-->
                            <form id="contactForm" action="add" method="post" enctype="multipart/form-data">
                                <!-- 상품명 input-->
                                <div class="form-floating mb-3">
                                    <input name="productName" class="form-control" id="name" type="text" data-sb-validations="required,email"   />
                                    <label for="name">Product Name</label>
                                    <div class="invalid-feedback" data-sb-feedback="email:required">상품명 필수</div>
                               </div>
                                <!-- 이자율 input-->
                                <div class="form-floating mb-3">
                                    <input name="productRate" class="form-control" id="rate" type="rate" data-sb-validations="required,rate"/>
                                    <label for="rate">Product Rate</label>
                                    <div class="invalid-feedback" data-sb-feedback="rate:required">상품 이자율 필수</div>
                                </div>
                                
                                <!-- 설명 input-->
                                <div class="form-floating mb-3">
                                    <textarea name="productContents" class="form-control" id="contents" type="text" style="height: 10rem" data-sb-validations="required,contents"></textarea>
                                    <label for="contents">Contents</label>
                                    <div class="invalid-feedback" data-sb-feedback="contents:required">상품설명 필수</div>
                                </div>
                                <!-- 첨부파일 -->
                                <div class="form-floating mc-3">
                                    <input type="file" name="attach">
                                    <input type="file" name="attach">
                                    <input type="file" name="attach">
                                    <input type="file" name="attach">
                                    <input type="file" name="attach">

                                </div>

                               
                                <div class="d-none" id="submitErrorMessage"><div class="text-center text-danger mb-3">상품 추가 실패!</div></div>
                                <!-- Submit Button-->
                                <div class="d-grid"><button class="btn btn-primary btn-lg " id="submitButton" type="submit">상품 등록</button></div>
                            </form>
                        </div>
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
