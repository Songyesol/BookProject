<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내서재</title>
<script type="text/javascript">

 function bookReturn(rentalNumber, memberId,bookCode){
	var returnCheck = confirm("반납하시겠습니까?");
	if(returnCheck){
		window.open("","rentalSuccess","width=600,height=200,top=200,left=400");
		frm2.rentalNumber.value=rentalNumber;
		frm2.memberId.value=memberId;
		frm2.bookCode.value=bookCode;
		frm2.action="bookReturn.do";
		frm2.target="rentalSuccess";
		frm2.submit();
	}else{
		alert("반납을 취소");
	}
	
 }
</script>
</head>
<jsp:include page="../main/menu.jsp" />
<body>
	<div align="center"> 
	<div><h2>${memberId }님의 도서대여 현황</h2></div>
	<form id="frm2" name="frm2" method="post">
			<input type="hidden" id="memberId" name="memberId">
			<input type="hidden" id="rentalNumber" name="rentalNumber">
			<input type="hidden" id="bookCode" name="bookCode">
	</form>
			<div>
				<table border=1>
					<tr>
						<th>도서코드</th>
						<th>도서명</th>
						<th>대여일자</th>
						<th>반납일자</th>
						<th>반납</th>
					</tr>
					<c:if test="${empty list }">
						<tr><td align="center" colspan="5">대여중인 도서가 없습니다.</td></tr>
					</c:if>
					<c:if test="${not empty list }">
						<c:forEach var="vo" items="${list }">
						<tr>
							<td >${vo.bookCode }</td>
							<td>${vo.bookName }</td>
							<td>${vo.rentalDate }</td>
							<td>${vo.returnDate }</td>
							<c:if test="${empty vo.returnDate }">
								<td><button type="button" onclick="bookReturn('${vo.rentalNumber }','${memberId }','${vo.bookCode }')">반납</button></td>
							</c:if>
							<c:if test="${not empty vo.returnDate }">
								<td></td>
							</c:if>
						</tr>
						</c:forEach>
					</c:if>
				</table>
			</div>
	</div>
</body>
</html>