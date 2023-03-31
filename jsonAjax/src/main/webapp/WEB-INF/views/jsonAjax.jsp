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

<h3>jsonAjaxmap</h3>
<p>JSON으로 보내고 MAP형태의 데이터를 서버에서 받는 경우</p>
<button id="btn1" class="btn btn-primary">stringify</button><br />

<h2 id="result">서버에서 온 결과 보여주는 곳</h2>

<h3>form에서 보내기(보류)</h3>
<form action="stringify" method="post" id="frm1">
	이름 : <input type="text" name="name" /> <br />
	나이 : <input type="text" name="age"/> <br />
	<input type="submit" value="전송" />
</form>

<script>
$(document).ready(function() {
	$('#btn1').on("click",function() {
		let form = {
			name : "jamong",
			age : 30
		};
		$.ajax({
			url : "stringify",
			type : "post",
			data : JSON.stringify(form), //자바스크립트의 객체 form을 JSON문자열로 변환
			contentType : "application/json; charset=UTF8", //서버로 보내는 데이터 형식과 문자 인코딩
			dataType : "json", //dataType은 브라우저가 알아서 처리하므로 생략 가능
			success : function(data) { //JSON문자열 형태로 data가 자바스크립트 객체형으로 변경
				let txt = data.name + data.age;
				$('#result').text(txt);
			},
			error : function() {
				alert("stringify err");
			}
		});
	});
	
	$("#frm1").submit(function(event) {
		event.preventDefault();
		var arrayData = $('#frm1').serializeArray();
		let form = convertToObject(arrayData);
		$.ajax({
			url : $("#frm1").attr("action"),
			type : $("#frm1").attr("method"),
			data : JSON.stringify(form),
			contentType: "application/json; charset=UTF-8;",
			success : function(data) {
				let txt = data.name + data.age;
				$("#result").text(txt);
			},
			error : function(data) {
				alert("form submit시 에러");
			}
		});
	});
	
	function convertToObject(arrayData) { //배열을 객체형으로 변환
			var object = {};
			for (var i = 0; i < arrayData.length; i++) {
				object[arrayData[i]['name']] = arrayData[i]['value'];
			}
			return object;
		}
});
</script>
</body>
</html>
