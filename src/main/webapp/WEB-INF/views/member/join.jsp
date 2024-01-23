<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html lang="en">
    <head>
        <style>
            div.yes{color:green;}
            div.no{color:red;}
         </style>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Join</title>
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
                    	<h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">회원가입</span></h1>
                	 </div>
               
                <div class="row gx-5 justify-content-center">
                    	<div class="col-lg-11 col-xl-9 col-xxl-8">
                    	
                    		<form class="form-control"  method="POST" enctype = "multipart/form-data">
                    		
                    			<div class="mb-3">
								  <label for="ID" class="form-label">아이디 입력</label>
								  <input type="text" class="form-control must " id="ID" name = "userName" required >
								  
								</div>
								<div class="mb-3">
									<label for="password" class="form-label ">비밀번호 입력</label>
									<input type="password"  class="form-control must" id="password" name = "password" required>
                                    <div id="pwResult"></div>
									<label for="password2" class="form-label ">2차 비밀번호 입력</label>
									<input type="password"  class="form-control must" id="password2"  required >
                                    <div id="pwResult2"></div>
								</div>
								<div class="mb-3">
								  <label for="email" class="form-label ">이메일</label>
							  	  <input type="email"  class="form-control must" id="email" name = "eMail" required>
								</div>
								<div class="mb-3">
								  <label for="phone" class="form-label must">번호</label>
							  	  <input type="text"  class="form-control" id="phone" name = "phone" required>
								</div>
								<div class="mb-3">
								  <label for="address" class="form-label must">주소</label>
							  	  <input type="text"  class="form-control" id="address" name = "address" required>
							  	    	<input type="text" id="postcode" placeholder="우편번호">
										<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
										<input type="text" id="road" placeholder="도로명주소">
										<input type="text" id="jibun" placeholder="지번주소">
										<span id="guide" style="color:#999;display:none"></span>
										<input type="text" id="detail" placeholder="상세주소">
										<input type="text" id="extra" placeholder="참고항목">
							  	  
								</div>
								<div class="mb-3">
								  <label for="name" class="form-label ">이름</label>
							  	  <input type="text"  class="form-control must" id="name" name = "name" required>
								</div>
								
								
								<div class="mb-3">
									<input class="form-control" type="file" name="attach">
								</div>
								
								<div class="mb-3">
									<button id="Btn" type="button" class="btn btn-primary">등록</button>
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
    <script src="/resources/js/member/joinCheck.js"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	let address1 = document.getElementById("address");
	let road = document.getElementById("road");
	let detail = document.getElementById("detail");
	let jibun = document.getElementById("jibun");
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById("road").value = roadAddr;
                document.getElementById("jibun").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("extra").value = extraRoadAddr;
                } else {
                    document.getElementById("extra").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
				address1.value = road.value;
            }
        }).open();
    }
</script>
    </body>
</html>
