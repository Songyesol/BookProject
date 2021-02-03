<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
   function passCheck(){
   var form = document.frm2;
   var memberPassword = form.memberPassword.value;
   var rmemberPassword = form.rmemberPassword.value;
   
   if(memberPassword != rmemberPassword){
      alert("패스워드가 일치하지 않습니다!!!");
      form.rmemberPassword.value = "";
      form.memberPassword.value = "";
      form.memberPassword.focus();
      return false;
   }
   return true;

   }
</script>
<jsp:include page="../main/menu.jsp" />
</head>
<body>
   <div align="center" id="memberform">
      <h1>회원가입</h1>
      <form id="frm2" name="frm2" onsubmit="return passCheck()" action="memberinsert.do" method="post" >
         <table> 
            <tr>
               <th>회원아이디</th>
               <td><input type="text" id="memberId2" name="memberId2" required="required"></td>
            </tr>
            <tr>
               <th>회원명</th>
               <td><input type="text" id="memberName" name="memberName" required="required"></td>
            </tr>
            <tr>
               <th>회원패스워드</th>
               <td><input type="password" id="memberPassword" name="memberPassword" required="required"></td>
            </tr>
            <tr>
               <th>패스워드확인</th>
               <td><input type="password" id="rmemberPassword" name="rmemberPassword" required="required"></td>
            </tr>
            <tr>
               <th>전화번호</th>
               <td><input type="tel" id="memberTel" name="memberTel" required="required"></td>
            </tr>
            <tr>
               <th>회원주소</th>
               <td><input type="text" id="memberAddress" name="memberAddress" required="required"></td>
            </tr>
         </table><br>
         <button type="submit" >가 입</button>      
         <button type="reset">취 소</button>      
         <button type="button" onclick="location.href='main.do'">돌아가기</button>                                             
      </form>
   </div>
</body>
</html>