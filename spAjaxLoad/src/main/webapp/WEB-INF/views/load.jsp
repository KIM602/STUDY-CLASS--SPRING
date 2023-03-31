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

<div id="div1">
	<h2>Let jQuery AJAX Change This Text</h2>
</div>
<button id="btn1" class="btn btn-primary">외부문서 내용을 표시</button><br /><br />
<button id="btn2" class="btn btn-primary">외부문서 내용을 일부 표시(id로 지정)</button><br /><br />
<button id="btn3" class="btn btn-primary">callback 처리</button>

<script>
$(document).ready(function(){
	$("#btn1").click(function(){
		$("#div1").load("txt/demo_text.txt");
		//서버의 txt/demo_test.txt를 가져와 #div1엘리먼트 내용에 출력(로딩)
	});
	
	$("#btn2").click(function(){
		$("#div1").load("txt/demo_text.txt #p1");
		//서버의 txt/demo_test.txt 중 id가 p1인 부분을 가져와 #div1엘리먼트 내용에 출력(로딩)
	});
	
	$("#btn3").click(function(){
		$("#div1").load("txt/demo_text.txt",function(responseTxt, statusTxt, xhr){
			if(statusTxt == "success")
				alert("External content loaded successfully!");
			if(statusTxt == "error")
				alert("Error: " + xhr.status + ": " + xhr.statusText);
		});
	});
});
</script>
</body>
</html>
