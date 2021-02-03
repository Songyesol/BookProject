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
		function deleteAlert(str){
			var yn = confirm("정말 삭제할까요?");
			if(yn){
				location ="bookdelete.do?row="+str;
			}else{
				return false;
			}
		}
	 	function update(str){
	 		frm.bId.value = str;
	 		frm.submit();
	 	}
	 	function rentalAlert(str1){
	 		var yn = confirm("대여하시겠습니까");
			if(yn){
				window.open("","rental","width=600,height=200,top=200,left=400");
				frm3.bookCode.value=str1;
				frm3.action="bookrental.do";
				frm3.target="rental";
				frm3.submit();
			}else{
				alert("대여 취소");
			}
	 	}
	</script>	
<jsp:include page="../main/menu.jsp" />
<body>
	<div align="center">
	<div id="subbg">
		<h1>도서목록</h1>	
	</div>
	<form id="frm" name="frm" action="bookupdateform.do" method="post">
				<input type="hidden" id="bId" name="bId">
	</form>
	<form id="frm3" name="frm3" method="post">
		<input type="hidden" id="memberId" name="memberId" value="${memberId }">
		<input type="hidden" id="bookCode" name="bookCode">
	</form>
		<table border="1">
			<tr>
				<th>도서코드</th>
				<th>도서명</th>
				<th>기본수량</th>
				<th>현재수량</th>
				<c:if test="${memberAuth != 'ADMIN' }">
    				<th>대여가능여부</th>
    				<th>대여</th>
    			</c:if>
    			<c:if test="${memberAuth == 'ADMIN' }">
					<th>도서편집</th>
				</c:if>
			</tr>
			<c:if test="${empty list }">
			<tr>
				<td colspan="5">게시글이 없습니다</td>
			</tr>
			</c:if>
			<c:if test="${not empty list }">
			<c:forEach var="vo" items="${list }">
			<tr>
				<td>${vo.bookCode }</td>
				<td>${vo.bookName }</td>
				<td>${vo.quantity }</td>
				<td>${vo.bCount}</td>
				<td style="display:none;"><input type="hidden" id="bookCode" name="bookCode" value="${vo.bookCode }"></td>
    		<c:if test="${memberAuth == 'ADMIN' }">
    			<td width="200"><button type="button" onclick="location.href='bookupdateform.do?bId=' + '${vo.bookCode }' ">수정</button>&nbsp;
    			<button type="button" onclick="deleteAlert('${vo.bookCode }')">삭제</button></td>
    		</c:if>
    		<c:if test="${memberAuth != 'ADMIN' }">
    			<c:if test="${vo.bCount == 0}">
    				<td colspan="3">대여불가</td>
    			</c:if>
    			<c:if test="${vo.bCount != 0}">
    				<td>대여가능</td>
    				<td><button type="button" onclick="rentalAlert('${vo.bookCode }')">대여</button></td>
    			</c:if>
    		</c:if>
			</tr>
			</c:forEach>	
			</c:if>			
		</table><br>
		<c:if test="${memberAuth == 'ADMIN' }">
    			<button onclick="location.href='bookinsertform.do'">도서등록</button>
    		</c:if>		
	</div>
</body>
</html>