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

<h3>jquery .get과 .post메서드</h3>
<button id="btn1" class="btn btn-danger">Send an HTTP GET request</button><br /><br />
<button id="btn2" class="btn btn-danger">Send an HTTP POST request</button>

<script>
$(document).ready(function(){
	$("#btn1").click(function(){
		//ajax는 결과를 이곳에서 받는다
		$.get("ajaxGet",function(data,status){
			//ajaxGet은 요청경로
			//function(data,status)는 요청 완료후 롤백 함수, data는 응답데이터, status는 요청결과 상태
			alert("Data: " + data + "\nStatus: " + status);
		});
	});
	
	$("#btn2").click(function(){
		$.post("ajaxPost", { //서버로 보내는 data를 객체형으로 표시
			name : "Donald Duck",
			city : "Duckburg"
		},
		function(data, status) {
			alert("Data: " + data + "\nStatus: " + status); //data는 서버 응답값
		});
	});
});
</script>
</body>
</html>
