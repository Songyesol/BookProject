<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function returnRentalView(){
		opener.location.reload();
		window.close();
	}
</script>
</head>
<body>
	<div align="center">
		<h1>${memberId }님 반납 완료되었습니다.</h1>
		<button type="button" onclick="returnRentalView()">대여목록으로 돌아가기</button>
		</div>
</body>
</html>