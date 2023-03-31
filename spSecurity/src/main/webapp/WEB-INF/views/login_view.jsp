<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<!-- RWD -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- MS -->
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8,IE=EmulateIE9"/>
<meta id="_csfr" name="_csrf" content="${_csrf.token}"/> <!-- 페이지위조요청 방지를 위한 태그 -->
<title>JSP</title>
<!--bootstrap-->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!--jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!--propper jquery -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!--latest javascript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<!--fontawesome icon-->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<!--google icon -->
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>
<body>

<div class="container mt-5">
	<h3 class="text-center text-info">로그인</h3>
	<div id="div1" class="text-success"></div>
	<!-- 로그인 관련 메세지를 서버에서 받아 작성 -->
	<form id="frm1" name="frm1" method="post" action="login"></form>
		<!-- security에서 action은 login으로 기본설정하면 컨트롤러로 요청하는게 아니고 security의
				login-processing-url = "/login"으로 요청 -->
		<!-- csrf를 방지하기위한 헤더부분을 숨겨서 추가 -->
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<div class="form-group">
			<label for="uId">아이디</label>
			<input type="email" class="form-control" name="pid" placeholder="E-mail 주소입력" id="uId" required/>
		</div>
		<div class="form-group">
			<label for="uPw">비밀번호</label>
			<input type="password" class="form-control" name="ppw" id="uPw" placeholder="비밀번호 입력" required/>
		</div>
		<!-- 로그아웃 안하고 접속 단절 후 일정시간 로그인 없이 재접속 -->
		<div class="form-group form-check">
			<input type="checkbox" class="form-check-input" id="remeberMe" name="remember-me" checked/>
			<label class="form-check-label" for="remeberMe" aria-describedby="rememberMeHelp">remember-me</label><br />
			<!-- aria-describedby는 스크린리더에서 설명을 할 내용 -->
			<button type="submit" class="btn btn-success">로그인</button>&nbsp;&nbsp;
			<a href="join_view" class="btn btn-danger">회원가입</a>
		</div>
</div>

<script>
$(document).ready(function(){
	<c:choose>
		<c:when test="${not empty log}">
			$("#div1").text("Welcome!");
		</c:when>
		<c:when test="${not empty logout}">
			$("#div1").text("Logout 성공");
		</c:when>
		<c:when test="${not empty error}">
			$("#div1").text("로그인 실패"); //로그인 실패시
		</c:when>
		<c:otherwise>
			$("#div1").text("로그인 성공"); //로그인 성공시
		</c:otherwise>
	</c:choose>
});
</script>
</body>
</html>
