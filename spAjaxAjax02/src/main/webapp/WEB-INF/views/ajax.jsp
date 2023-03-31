<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<button id="btn1" class="btn btn-dark">js객체값을 만들어 서버로 보내기</button>
<div id="result">이곳에 서버로부터 온 결과 출력</div>
<form action="format" id="frm1" name="frm1" method="POST">
	name : <input type="text" name="name" /> <br />
	age : <input type="text" name="age" /> <br />
	<input type="submit" value="call" />
</form>

<script>
$(document).ready(function(){
	$("#btn1").click(function(){
		//서버로 보낼 데이터는 js객체형 변수로 만들어 사용
		let form = {
			name : "jamong",
			age : 23
		};
		$.ajax({
			url : "requestObject", //서버요청경로
			type : "POST", //method방식
			data : form, //서버로 보낼 데이터 form변수
			success : function(data) {
				$("#result").text(data)
			},
			error : function(data) {
				alert("버튼클릭시 에러 발생");
			}
		});
	});
	
	$("#frm1").submit(function(event){
		//submit이벤트는 form의 이벤트이므로 form을 선택
		//원래의 form의 submit이벤트처리를 막아야 .ajax()사용 가능
		event.preventDefault();
		$.ajax({
			url : $("#frm1").attr("action"),
			type : $("#frm1").attr("method"),
			data : $("#frm1").serialize(), //form의 입력 값들을 직렬화 하여 문자열로 만듬
			success : function(data) {
				$("#result").text(data)
			},
			error : function(data) {
				alert("form submit시 에러 발생");
			}
		});
	});
});

</script>
</body>
</html>
