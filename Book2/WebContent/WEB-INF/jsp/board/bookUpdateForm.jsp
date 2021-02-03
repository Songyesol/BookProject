<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<script>
		function UpdateCheck(){
			var yn = confirm("수정하시겠습니까");
			if(yn){
				frm2.action ="bookupdate.do";
				frm2.submit();
			}else{
				return false;
			}
		}
	</script>
<jsp:include page="../main/menu.jsp" />
<body>
	<div align="center" id="memberform">
		<h1>수정하기</h1>
		<form id="frm2" name="frm2" method="post" action="bookupdate.do">
			<table> 
				<tr>
					<th>도서코드</th>
					<td><input type="text" id="bookCode" name="bookCode" value="${vo.bookCode }" readonly="readonly">
				</tr>
				<tr>
					<th>도서명</th>
					<td><input type="text" id="bookName" name="bookName" value="${vo.bookName }" ></td>
				</tr>
				<tr>
					<th>기본수량</th>
					<td><input type="number" id="quantity" name="quantity" value="${vo.quantity }" ></td>
				</tr>
			</table><br>
			<button type="button" onclick="UpdateCheck()">수정하기</button>	
			<button type="button" onclick="location.href='boardlist.do'">돌아가기</button>															
		</form>
	</div>
</body>
</html>