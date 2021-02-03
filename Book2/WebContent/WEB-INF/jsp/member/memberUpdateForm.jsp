<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="../main/menu.jsp" />
<body>
<style>
	table td{text-align:left;}
</style>
<div align="center" id="memberform">
	<h1>${vo.memberId }회원 정보 수정페이지</h1>
	<div>
	<form id="frm" name="frm" action="memberUpdate.do" method="post">
		<div>
		<table border="1">
			<tr>
				<th>회원아이디</th>
				<td><input type="text" id= "memberId" name="memberId" value="${vo.memberId }" readonly></td>
			</tr>
			<tr>
				<th>회원명</th>
				<td>${vo.memberName }</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" id="memberTel" name="memberTel" value="${vo.memberTel }"></td>
			</tr>
			<tr>
				<th>회원주소</th>
				<td><input type="text" id="memberAddress" name="memberAddress" value="${vo.memberAddress }"></td>
			</tr>
			<tr>
				<th>권한</th>
				<td>${vo.memberAuth }</td>
			</tr>
			
		</table>
		</div>
		<div><br>
			<button type="submit" value="저장">저장</button>
			<button type="reset" value="취소">취소</button>
		</div>
		</form>
		</div>
	</div>
</body>
</html>