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

<h3>jsonAjaxList</h3>
<p>JSON으로 보내고 MAP형태의 데이터를 서버에서 받는 경우</p>
<button id="btn1" class="btn btn-primary">ajaxList</button><br />
<button id="btn2" class="btn btn-primary">ajaxList</button><br />

<h2 id="result">서버에서 온 결과 보여주는 곳</h2> <br />

<script>
$(document).ready(function(){
	$('#btn1').on('click',function(){
		var form = {
				name : "jamong",
				age : 30
		}
		
		$.ajax({
			url : "ajaxList",
			type : "post",
			data : JSON.stringify(form),
			contentType : "application/json; charset=UTF-8",
			//dataType : "json",
			success : function(data) { //data가 List형식
				for(var i=0 ; i < data.length ; i++) {
					$("#result").append(data[i] + "<br/>");
				}
			},
			error : function() {
				alert("ajaxList err")
			}
		});
	});
});

$(document).ready(function(){
	$('#btn2').on('click',function(){
		var form = {
				name : "jamong",
				age : 30
		}
		
		$.ajax({
			url : "ajaxObj",
			type : "post",
			data : JSON.stringify(form),
			contentType : "application/json; charset=UTF-8",
			//dataType : "json",
			success : function(data) {
					$("#result").text(data.name + data.age);
			},
			error : function() {
				alert("ajaxList err")
			}
		});
	});
});
</script>
</body>
</html>
