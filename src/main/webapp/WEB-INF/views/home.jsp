<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<c:import url="temps/bootstrap_css.jsp"></c:import>	
	<title>Home</title>
</head>
<body>
<h1>
	<c:import url="temps/header.jsp"></c:import>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<c:import url="temps/bootstrap_js.jsp"></c:import>
</body>
</html>
