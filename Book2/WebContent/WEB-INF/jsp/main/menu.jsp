<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
	body {font-family: "Lato", sans-serif}
	.mySlides {display: none}
</style>
<script>
 function userListView(str){
		frm.memberId.value=str;
		frm.submit();
 }
</script>
<body>
<form name="frm" id="frm" action = "userBookList.do" method="post">
	<input type="hidden" name="memberId" id="memberId" value="${memberId }">
</form>
<!-- Navbar -->
<div class="w3-top">
  <div class="w3-bar w3-black w3-card">
  <c:if test="${memberId ne null }">
    <a class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right" href="javascript:void(0)" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
    <a href="boardlist.do" class="w3-bar-item w3-button w3-padding-large">도서목록</a>
    <c:if test="${memberAuth == 'ADMIN' }">
	    <a href="rentalManage.do" class="w3-bar-item w3-button w3-padding-large w3-hide-small">대여관리</a>
	    <a href="member.do" class="w3-bar-item w3-button w3-padding-large w3-hide-small">회원관리</a>
    </c:if>
    <c:if test="${memberAuth != 'ADMIN' }">
    	<a onclick="location.href='userBookList.do?memberId='+'${memberId }'" class="w3-bar-item w3-button w3-padding-large w3-hide-small">내서재</a>
    </c:if>
    <a href="logout.do" class="w3-bar-item w3-button w3-padding-large w3-hide-small">로그아웃</a>
  <a id="mname"  class="w3-bar-item w3-button w3-padding-large w3-hide-small">🎉${memberName }님 환영합니다! </a>
  </c:if>
  </div>
</div>
</body>
</html>