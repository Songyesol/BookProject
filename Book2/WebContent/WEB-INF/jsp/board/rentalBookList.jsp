<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="../main/menu.jsp" />
<body>
		<div align="center">
			<h1>도서 대여 현황</h1>
			<div id="rentalbtn">
				<a href="rentalManage.do">반납완료</a>
				<a>|</a>
				<a href="noretalManage.do">미반납</a>
			</div>
			<table border=1>
				<tr>
					<th>대여번호</th>
					<th>이용자아이디</th>
					<th>도서코드</th>
					<th>도서명</th>
					<th>대여일자</th>
					<th>반납현황</th>
				</tr>
				<c:if test="${empty list }">
					<tr><td align="center" colspan="6"> 현재 반납완료된 도서가 없습니다.</td></tr>
				</c:if>
				<c:if test="${not empty list }">
				<c:forEach var="vo" items="${list }">
				<c:choose>
					<c:when test="${empty vo.returnDate}">
						<tr><td align="center" colspan="6"> 현재 반납완료된 도서가 없습니다.</td></tr>
					</c:when>
					<c:when test="${not empty vo.returnDate}">
						<tr>
							<td>${vo.rentalNumber }</td>
							<td>${vo.memberId }</td>
							<td>${vo.bookCode }</td>
							<td>${vo.bookName }</td>
							<td>${vo.rentalDate }</td>
							<td>반납완료</td>
						</tr>
					</c:when>
					</c:choose>
					</c:forEach>
				</c:if>
			</table>
		</div>
</body>
</html>