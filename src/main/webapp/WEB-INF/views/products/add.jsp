<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
 <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
	<!-- summer note -->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
 	
	<c:import url="../temps/bootstrap_css.jsp"></c:import>
    
  </head>
</head>
<body>
		<c:import url="../temps/header.jsp"></c:import>
	
		<section id="contents" class = "container-fluid">
			<div class="row">
				<form action = "add" method="post" enctype="multipart/form-data">
				  <div class="mb-3">
				    <label for="PRODUCTNUM" class="form-label">PRODUCTNUM</label>
				    <input type="text" class="form-control" id="PRODUCTNUM" aria-describedby="emailHelp" name="productnum" readonly="readonly" value =999>
				    <div id="emailHelp" class="form-text">We'll never share your regionId with anyone else.</div>
				  </div>
				  <div class="mb-3">
				    <label for="productname" class="form-label">productname</label>
				    <input type="text" class="form-control" id="productname" name="productname">
				  </div>
				   <div class="mb-3">
				    <label for="productrate" class="form-label">productrate</label>
				    <input type="text" class="form-control" id="productrate" name="productrate">
				  </div>
				  <div class="mb-3">
				    <label for="productjumsu" class="form-label">productjumsu</label>
				    <input type="text" class="form-control" id="productjumsu" name="productjumsu">
				  </div>
				 
				 	
				  
				  <div class="mb-3">
					<label for="productContents" class="form-label">product_Contents</label>
				    <textarea id="productContents" class="form-control" name= "productcontents"></textarea>
				  </div>

				  <div class="mb-3">
					<input type="file" name = "photo">
					<input type="file" name = "photo">
					<input type="file" name = "photo">

				  </div>
				  <button type="submit" class="btn btn-primary">Add</button>
</form>	
			
		 	</div>
		
		</section>
	
	<script>
		$('#productContents').summernote();

	</script>
	
	<c:import url="../temps/bootstrap_js.jsp"></c:import> 

</body>
</html>