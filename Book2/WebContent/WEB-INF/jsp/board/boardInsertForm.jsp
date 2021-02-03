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
 	<div align="center" id="memberform">
		<h1>등록하기</h1>
		<form id="frm" name="frm" method="post" action="bookinsert.do">
			<table> 
				<tr>
					<th>도서명</th>
					<td><input type="text" id="bookName" name="bookName" value="${vo.bookName }" ></td>
				</tr>
				<tr>
					<th>기본수량</th>
					<td><input type="number" id="quantity" name="quantity" value="${vo.quantity }" ></td>
				</tr>
			</table><br>
			<button type="submit">등록하기</button>	
			<button type="button" onclick="location.href='boardlist.do'">돌아가기</button>															
		</form>
	</div>
</body>
</html>