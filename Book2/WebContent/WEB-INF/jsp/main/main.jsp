<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="menu.jsp" />
<style>
	table input{width:200px;}
	button {border:1px solid gray;padding:5px 10px;margin:5px;cursor:pointer;}
	table{width:auto;border:none;}
	#memberform th{background:none;}
	#memberform table tr{border-bottom:none;}
	#memberform table tr input{border:1px solid rgb(125,125,125);}
</style>
<body>
	<div align="center" id="memberform">
		<c:if test="${memberId == null }">
		<h1>로그인</h1>
		<form id="frm" name="frm" action="login.do" method="post">
			<table>
				<tr>
					<th width="100">아이디</th>
					<td><input type="text" id="memberid" name="memberid"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" id="memberpassword" name="memberpassword"></td>
				</tr>
			</table><br>
			<div>
			<button type="submit">로그인</button>
			<button type="button" onclick="location.href='memberinsertform.do'">회원가입</button>
			</div>
		</form>
		</c:if>
		<c:if test="${memberId ne null }">
			<div id="bg">
				<img src="img/bg5.jpg">
				<div id="bg_content">
				</div>
			</div>
		</c:if>
	</div>
</body>
</html>