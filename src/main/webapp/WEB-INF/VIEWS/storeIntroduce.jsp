<%@page import="com.graduate.DTO.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Buy Book</title>
<link rel="icon" type="image/x-icon" href="/assets/favicon.ico" />
<!-- Bootstrap icons-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
<!-- Google fonts-->
<link rel="preconnect" href="https://fonts.gstatic.com" />
<link href="https://fonts.googleapis.com/css2?family=Newsreader:ital,wght@0,600;1,600&amp;display=swap" rel="stylesheet" />
<link href="https://fonts.googleapis.com/css2?family=Mulish:ital,wght@0,300;0,500;0,600;0,700;1,300;1,500;1,600;1,700&amp;display=swap" rel="stylesheet" />
<link href="https://fonts.googleapis.com/css2?family=Kanit:ital,wght@0,400;1,400&amp;display=swap" rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="/css/styles3.css" rel="stylesheet" />
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="/js/scripts.js"></script>
</head>
<body id="page-top">
	<!-- Navigation-->
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
					<%
					// 세션값 가져오기
					if (userDTO == null) {
					%>
					<li class="nav-item">
						<a class="nav-link" href="/user/userSignUp">Sign Up</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/user/userSignIn">Sign In</a>
					</li>
					<%
					} else if (userDTO.getUserEmail().equals("admin@admin")) {
					%>
					<li class="nav-item">
						<a class="nav-link" href="/admin/">Admin Page</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/user/userSignOut">Sign Out</a>
					</li>
					<%
					} else {
					%>
					<li class="nav-item">
						<a class="nav-link" href="/cart/Cart?cartEmail=<%=userDTO.getUserEmail()%>">My Cart</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/user/userDetail">My Page</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/user/userSignOut">Sign Out</a>
					</li>
					<%
					}
					%>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Mashead header-->
	<header class="masthead">
		<div class="container px-5">
			<div class="row gx-5 align-items-center">
				<div class="col-lg-6">
					<!-- Mashead text and app badges-->
					<div class="mb-5 mb-lg-0 text-center text-lg-start">
						<h1 class="display-1 lh-1 mb-3">
							BOOK, READ,
							<br />
							STAR AND CITY
						</h1>
						<p class="lead fw-normal text-muted mb-5">부디 당신의 책을 찾으실 수 있기를.</p>
						<div class="d-flex flex-column flex-lg-row align-items-center">
							<a class="me-lg-3 mb-4 mb-lg-0" href="https://github.com/17mirinae/Graduate">
								<img class="app-badge" src="/assets/img/GitHub.png" alt="..." />
							</a>
						</div>
					</div>
				</div>
				<div class="col-lg-6">
					<!-- Masthead device mockup feature-->
					<div class="masthead-device-mockup">
						<svg class="circle" viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
                            <defs>
                                <linearGradient id="circleGradient" gradientTransform="rotate(45)">
                                    <stop class="gradient-start-color" offset="0%"></stop>
                                    <stop class="gradient-end-color" offset="100%"></stop>
                                </linearGradient>
                            </defs>
                            <circle cx="50" cy="50" r="50"></circle>
                        </svg>
						<svg class="shape-1 d-none d-sm-block" viewBox="0 0 240.83 240.83" xmlns="http://www.w3.org/2000/svg">
                            <rect x="-32.54" y="78.39" width="305.92" height="84.05" rx="42.03" transform="translate(120.42 -49.88) rotate(45)"></rect>
                            <rect x="-32.54" y="78.39" width="305.92" height="84.05" rx="42.03" transform="translate(-49.88 120.42) rotate(-45)"></rect>
                        </svg>
						<svg class="shape-2 d-none d-sm-block" viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
                            <circle cx="50" cy="50" r="50"></circle>
                        </svg>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- Quote/testimonial aside-->
	<aside class="text-center bg-gradient-primary-to-secondary">
		<div class="container px-5">
			<div class="row gx-5 justify-content-center">
				<div class="col-xl-8">
					<div class="h2 fs-1 text-white mb-4">"사람은 책을 만들고, 책은 사람을 만든다."</div>
					<img src="/assets/img/Logo.png" alt="..." style="height: 25rem" />
				</div>
			</div>
		</div>
	</aside>
	<!-- App features section-->
	<section id="features">
		<div class="container px-5">
			<div class="row gx-5 align-items-center">
				<div class="col-lg-8 order-lg-1 mb-5 mb-lg-0">
					<div class="container-fluid px-5">
						<div class="row gx-5">
							<div class="col-md-6 mb-5">
								<!-- Feature item-->
								<div class="text-center">
									<img src="/assets/img/book.png" alt="..." style="height: 5rem" />
									<h3 class="font-alt">Reading, Search</h3>
									<p class="text-muted mb-0">종합목록 검색 시스템을 구축하여 원스톱 자료 검색 서비스를 운영</p>
								</div>
							</div>
							<div class="col-md-6 mb-5">
								<!-- Feature item-->
								<div class="text-center">
									<img src="/assets/img/good.png" alt="..." style="height: 5rem" />
									<h3 class="font-alt">Reading, Culture</h3>
									<p class="text-muted mb-0">
										독서에 대한 관심을 높이기 위한
										<br />
										관리자 추천 도서 및 신작/인기 도서 정보 제공
									</p>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6 mb-5 mb-md-0">
								<!-- Feature item-->
								<div class="text-center">
									<img src="/assets/img/noticeboard.png" alt="..." style="height: 5rem" />
									<h3 class="font-alt">Reading, Communication</h3>
									<p class="text-muted mb-0">
										도서를 읽고 자유 게시판에
										<br />
										본인의 의견을 자유롭게 작성!
									</p>
								</div>
							</div>
							<div class="col-md-6">
								<!-- Feature item-->
								<div class="text-center">
									<img src="/assets/img/open-book.png" alt="..." style="height: 5rem" />
									<h3 class="font-alt">Reading, Dream</h3>
									<p class="text-muted mb-0">
										원하는 도서가 없다면
										<br />
										직접 관리자에게 신청 가능
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 order-lg-0">
					<!-- Features section device mockup-->
					<div class="features-device-mockup">
						<svg class="circle" viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
                            <defs>
                                <linearGradient id="circleGradient" gradientTransform="rotate(45)">
                                    <stop class="gradient-start-color" offset="0%"></stop>
                                    <stop class="gradient-end-color" offset="100%"></stop>
                                </linearGradient>
                            </defs>
                            <circle cx="50" cy="50" r="50"></circle>
                        </svg>
						<svg class="shape-1 d-none d-sm-block" viewBox="0 0 240.83 240.83" xmlns="http://www.w3.org/2000/svg">
                            <rect x="-32.54" y="78.39" width="305.92" height="84.05" rx="42.03" transform="translate(120.42 -49.88) rotate(45)"></rect>
                            <rect x="-32.54" y="78.39" width="305.92" height="84.05" rx="42.03" transform="translate(-49.88 120.42) rotate(-45)"></rect>
                        </svg>
						<svg class="shape-2 d-none d-sm-block" viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
                            <circle cx="50" cy="50" r="50"></circle>
                        </svg>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Basic features section-->
	<section class="bg-light">
		<div class="container px-5">
			<div class="row gx-5 align-items-center justify-content-center justify-content-lg-between">
				<div class="col-12 col-lg-5">
					<h2 class="display-4 lh-1 mb-4">Enter a new age of web book store</h2>
					<p class="lead fw-normal text-muted mb-5 mb-lg-0">
						읽고 싶은 도서를 직접 신청하고, 읽은 도서에 대한
						<br />
						후기를 작성 해 다른 회원들과 감상을 나누며
						<br />
						책에 대한 경험을 배로 얻어보세요.
					</p>
				</div>
				<div class="col-sm-8 col-md-6">
					<div class="px-5 px-sm-0">
						<img class="img-fluid rounded-circle" src="/assets/img/StopWaiting.png" alt="..." />
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Call to action section-->
	<section class="cta">
		<div class="cta-content">
			<div class="container px-5">
				<h2 class="text-white display-1 lh-1 mb-4">
					Stop Waiting.
					<br />
					Start Reading.
				</h2>
				<a class="btn btn-outline-light py-3 px-4 rounded-pill" href="/user/userSignUp">Register for free</a>
			</div>
		</div>
	</section>
	<!-- App badge section-->
	<section class="bg-gradient-primary-to-secondary" id="download">
		<div class="container px-5">
			<h2 class="text-center text-white font-alt mb-4">Get the code now!</h2>
			<div class="d-flex flex-column flex-lg-row align-items-center justify-content-center">
				<a class="me-lg-3 mb-4 mb-lg-0" href="https://github.com/17mirinae/Graduate">
					<img class="app-badge" src="/assets/img/GitHub.png" alt="..." />
				</a>
			</div>
		</div>
	</section>
	<!-- Footer-->
	<footer class="bg-black text-center py-5">
		<div class="container px-5">
			<div class="text-white-50 small">
				<div class="mb-2">&copy; Buy Book 2021. All Rights Reserved.</div>
			</div>
		</div>
	</footer>
</body>
</html>