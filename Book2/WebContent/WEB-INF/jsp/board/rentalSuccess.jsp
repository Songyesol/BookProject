<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function windowClose(){
		opener.location.reload();
		window.close();
}
</script>
</head>
<jsp:include page="../main/menu.jsp" />
<body>
	<div align="center">
		<h1>대여완료</h1>
		<button type="button" onclick="windowClose()">닫기</button>
	</div>
</body>
</html>