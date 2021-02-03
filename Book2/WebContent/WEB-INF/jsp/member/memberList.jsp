<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
	function deleteCheck(str){
		var yn = confirm("정말 삭제할까요?");
		if(yn){
			location = "memberdelete.do?row=" + str;
		}else{
			return false;
		}		
	}
	
	function updateMember(str){
		var yn = confirm("수정페이지로 이동하시겠습니까?");
		if(yn){
			location="memberUpdateForm.do?memberId="+str;
		}else{
			return false;
		}
	}
</script>
<jsp:include page="../main/menu.jsp" />
<body>
	<div align="center">
	<h1>회원관리</h1>
		<table border="1">
			<tr>
				<th>회원아이디</th>
				<th>회원명</th>
				<th>전화번호</th>
				<th>회원주소</th>
				<th>권한</th>
				<th>편집</th>
			</tr>
			<c:if test="${empty list }">
				<tr>
					<td colspan="5">회원이 없습니다.</td>
				</tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach var="vo" items="${list }">
				<c:if test="${vo.memberAuth == 'USER' }">
				<tr>
					<td style="display:none;"><input type="hidden" id="memberid" name="memberid" value="${vo.memberId }"></td>
					<td>${vo.memberId }</td>
					<td>${vo.memberName }</td>
					<td>${vo.memberTel }</td>
					<td>${vo.memberAddress }</td>
					<td>${vo.memberAuth }</td>
					<td width="200"><button type="button" onclick="updateMember('${vo.memberId }')">수정</button>&nbsp;&nbsp;
						<button type="button" onclick="deleteCheck('${vo.memberId }')">삭제</button></td>
				</tr>	
				</c:if>
				</c:forEach>
				</c:if>
		</table>
	</div>
</body>
</html>