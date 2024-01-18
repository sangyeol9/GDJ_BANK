<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

               	 <div class="row gx-5 justify-content-center">
                    	<div class="col-lg-11 col-xl-9 col-xxl-8">
                    	
                    		<form class="form-control"  method="POST" enctype = "multipart/form-data">
                    			<input type="hidden" name ="notice_Num" value = "${dto.notice_Num}">
                    			<div class="mb-3">
								  <label for="title" class="form-label">제목 입력</label>
								  <input type="text" class="form-control" id="title" name = "notice_Title" value = "${dto.notice_Title }">
								  
								</div>
							<%-- 	<div class="mb-3">
									<label for="writter" class="form-label">writter 입력</label>
									<input type="text" readonly	value="${member.userName}"  class="form-control" id="writter" name = "notice_Writter">
								</div> --%>
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
             	
     