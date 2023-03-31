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
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
<!--google icon -->
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

<script src="js/hello.js"></script>
<style>
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}
#main {
	height: auto;
}
h3#ht {
	color: #424242;
}
.carousel-inner img {
	/*RWD를 위해 처리 */
	width: 100%;
	height : 100%;
}
.fakeimg {
	height: 200px;
	background: #aaaaaa;
}

.modal-login {		
	color: #636363;
	width: 350px;
	margin: 80px auto 0;
	margin-top: 19%;
}

.modal-login .modal-content {
	padding: 20px;
	border-radius: 5px;
	border: none;
}
.modal-login .modal-header {
	border-bottom: none;   
    position: relative;
    justify-content: center;
}

.modal-login .form-control:focus {
	border-color: #BC8F8F;
}
.modal-login .form-control, .modal-login .btn {
	min-height: 40px;
	border-radius: 3px; 
}
.modal-login .close {
    position: absolute;
	top: -5px;
	right: -5px;
}	
.modal-login .modal-footer {
	background: #ecf0f1;
	border-color: #dee4e7;
	text-align: center;
    justify-content: center;
	margin: 0 -20px -20px;
	border-radius: 5px;
	font-size: 13px;
}
.modal-login .modal-footer a {
	color: #999;
}
		
.modal-login .avatar {
	position: absolute;
	margin: 0 auto;
	left: 0;
	right: 0;
	top: -70px;
	width: 95px;
	height: 95px;
	border-radius: 50%;
	z-index: 9;
	background: #BCAAA4;
	padding: 15px;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
}

.modal-login .avatar img {
	width: 100%;
}

.modal-login h4 {
	text-align: center;
	font-size: 26px;
	margin: 30px 0 -15px;
}

 .modal-login .btn {
    color: #fff;
    border-radius: 4px;
	background: #BCAAA4;
	text-decoration: none;
	transition: all 0.4s;
    line-height: normal;
    border: none;
}
.modal-login .btn:hover, .modal-login .btn:focus {
	background: #556B2F;
	outline: none;
}

.TH {
	color: #90A4AE;
}

</style>
</head>

<body>
<div class="container mt-1 p-0">
	<div class="jumbotron text-center mb-0">
		<h1>My First Bootstrap 4 Page</h1>
		<p>페이지 크기를 조정하여 RWD가 구현되는지 살펴보세요</p>
	</div>
</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark container">
	<a class="navbar-brand" href="https://www.naver.com" >
		<img src="https://t1.daumcdn.net/cfile/tistory/999F973F5D05896D27" style="width: 40px"alt="logo" />
	</a><!-- 브랜드나 로고, 클릭되어야 함 -->
	
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
	
		<ul class="navbar-nav d-flex"> <!-- 메뉴바의 메뉴는 ul로 만들며 기본 클래스는 navbar-nav -->
			<li class="nav-item">
				<a class="nav-link" href="home.do"><i class="fas fa-home" style="font-size:20px; color:white"></i> </a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#" >제품</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#">구매</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="list.do">게시판</a>
			</li>
		</ul>
		
		<ul class="navbar-nav ml-auto">
			<li class="nav-item">
			<button type="button" class="btn btn-secondary"  data-toggle="modal" data-target="#myModal">LOGIN</button>
			</li>
		</ul>
		
		<!--<ul class="navbar-nav ml-auto">
			<li class="nav-item">
				<a class="nav-link"  href="#">로그인</a>
			</li>
		</ul>
		-->
		
	</div>
</nav>


<div class="container border border-secondary p-0">
	<div id="demo" class="carousel slide" data-ride="carousel">
	<ul class="carousel-indicators">
    		<li data-target="#demo" data-slide-to="0" class="active"></li>
    		<li data-target="#demo" data-slide-to="1"></li>
    		<li data-target="#demo" data-slide-to="2"></li>
  	</ul>
  	
  	  <div class="carousel-inner margin-top">
    		<div class="carousel-item active">
      			<img src="https://bootstrapious.com/tutorial/carousel/img/carousel1.jpg"  class="img-fluid" alt="chania" >
      				<div class="carousel-caption">
        				<h3>Carousel in a container</h3>
       					 <p>This is a demo for the Bootstrap Carousel Guide.</p>
      				</div>   
    		</div>
    		<div class="carousel-item">
      			<img src="https://bootstrapious.com/tutorial/carousel/img/carousel2.jpg" class="img-fluid" alt="flower" >
      				<div class="carousel-caption">
        				<h3>SKY</h3>
        				<p>We love Sky!</p>
      				</div>   
    		</div>
    		<div class="carousel-item">
      			<img src="https://bootstrapious.com/tutorial/carousel/img/carousel3.jpg"alt="flower2" class="img-fluid">
      				 <div class="carousel-caption">
        				<h3>MOUNTAIN</h3>
        				<p>We love mountain!</p>
      				</div>   
    		</div>
	</div>
	
			<a class="carousel-control-prev" href="#demo" data-slide="prev">
    			<span class="carousel-control-prev-icon"></span>
  			</a>
  			<a class="carousel-control-next" href="#demo" data-slide="next">
    			<span class="carousel-control-next-icon"></span>
  			</a>
	</div>
</div>

<div>
<!-- 게시판 영역 -->
<div id="main" class="container mt-5">
	<h3 id="ht" class="text-center text-dager">게시판</h3>
	<table class="table table-bordered table-hover">
		<thead class="thead-dark">
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>날짜</th>
				<th>히트수</th>
			</tr>
		</thead>
		<tbody> <!-- 게시판 리스트 부분으로 tr을 반복하여 출력 -->
			<!-- EL에서는 request의 attribute를 바로 사용 -->
			<!-- forEach반복문에서 items은 콜렉션(배열, list, set...)의 값 -->
			<!-- var은 items에 들어있는 원소를 나타냄 -->
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.bId}</td>
					<td>${dto.bName}</td>
					<td>
						<!-- 제목에 댓글 갯수를 --으로 표시하고 제목 클릭시 이 게시판 라인의
							  게시판 번호를 이용하여 db에서 해당 게시판번호 내용을 가져오는 것 처리 -->
						<c:forEach begin="1" end="${dto.bIndent}">-</c:forEach>
						<a href="contentView?bId=${dto.bId}">${dto.bTitle}</a>		
					</td>
					<td>${dto.bDate}</td>
					<td>${dto.bHit}</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot class="table=secondary">
			<tr>
				<td colspan="5"> <a class="btn btn-secondary" href="writeForm">글작성</a></td>
			</tr>
		</tfoot>
	</table>
	</div>
</div>

<footer class="mt-5">
	<div class="jumbotron text-center" style="margin-bottom:0">
			<h2>Footer</h2>
	</div>
</footer>

<div id="myModal" class="modal fade">
	<div class="modal-dialog modal-login">
		<div class="modal-content">
			<div class="modal-header">
				<div class="avatar">
					<img src="https://cdn-icons-png.flaticon.com/512/1000/1000997.png" alt="Avatar">
				</div>
				<h4 class="modal-title">Member Login</h4>
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>	
			</div>
			<div class="modal-body">
				<form action="#" method="post">
					<div class="form-group">
						<input type="text" class="form-control" name="id" placeholder="Username" required="required">		
					</div>
					<div class="form-group">
						<input type="password" class="form-control" name="pw" placeholder="Password" required="required">	
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-lg btn-block login-btn">Login</button>
					</div>					
				</form>
			</div>
			<div class="modal-footer">
				<a href="#">Forgot Password?</a>
			</div>
		</div>
	</div>
</div>
</body>
</html>
