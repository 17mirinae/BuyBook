<%@page import="com.graduate.DTO.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Buy Book</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="../assets/favicon.ico" />
<!-- Bootstrap icons-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" type="text/css" />
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="../css/styles.css" rel="stylesheet" />
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script type="text/javascript" src="../js/scripts.js"></script>
<!--    사용자 정의 추가용-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- Responsive navbar-->
	<nav class="navbar navbar-expand-lg bg-light static-top ">
		<div class="container px-5">
			<%
			// 세션값 가져오기
			UserDTO userDTO = (UserDTO) session.getAttribute("userSessionDTO"); // Object 타입이므로 다운캐스팅
			%>
			<a class="navbar-brand" href="/">Buy Book</a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<li class="nav-item">
						<a class="nav-link" href="/cart/Cart?cartEmail=<%=userDTO.getUserEmail()%>">My Cart</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/user/userDetail">My Page</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/user/userSignOut">Sign Out</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Navigation-->
	<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
		<div class="container">
			<a class="btn" style="background-color: #e3f2fd; color: dodgerblue;" href="/book/bookSearch">도서 검색</a>
			<div class="dropdown show">
				<a class="btn dropdown-toggle" style="background-color: #e3f2fd; color: dodgerblue;" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">신청 / 참여</a>
				<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
					<a class="dropdown-item" href="/book/userHope">희망 도서 신청</a>
					<a class="dropdown-item" href="/board/boardSearch">자유 게시판</a>
				</div>
			</div>
			<div class="dropdown show">
				<a class="btn dropdown-toggle" style="background-color: #e3f2fd; color: dodgerblue;" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">서점 이용</a>
				<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
					<a class="dropdown-item" href="/book/goodSearch">추천 도서</a>
					<a class="dropdown-item" href="/book/hitBookSearch">인기 도서</a>
					<a class="dropdown-item" href="/book/newBookSearch">신간 도서</a>
				</div>
			</div>
			<div class="dropdown show">
				<a class="btn dropdown-toggle" style="background-color: #e3f2fd; color: dodgerblue;" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">서점 정보</a>
				<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
					<a class="dropdown-item" href="/storeIntroduce">서점 소개</a>
					<a class="dropdown-item" href="/board/noticeSearch">공지 사항</a>
				</div>
			</div>
		</div>
	</nav>
	<div class="row justify-content-center" style="padding: 250px;">
		<div class="text-center">
			<h1>Thank You For Purchase!</h1>
			<h1 style="visibility: hidden;">여백</h1>
			<img src="../assets/img/Success.png" alt="..." style="height: 20rem" />
		</div>
	</div>
	<!-- Footer-->
	<footer class="footer bg-light">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 h-100 text-center text-lg-start my-auto">
					<ul class="list-inline mb-2">
						<li class="list-inline-item">
							<a href="#!">About</a>
						</li>
						<li class="list-inline-item">⋅</li>
						<li class="list-inline-item">
							<a href="#!">Contact</a>
						</li>
					</ul>
					<p class="text-muted small mb-4 mb-lg-0">&copy; Buy Book 2021. All Rights Reserved.</p>
				</div>
				<div class="col-lg-6 h-100 text-center text-lg-end my-auto">
					<ul class="list-inline mb-0">
						<li class="list-inline-item">
							<a href="https://www.github.com/17mirinae/Graduate">
								<i class="bi-github fs-3"></i>
							</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>
