<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!--
	Phantom by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>Spring</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
	</head>
	<body class="is-preload">
		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Header -->
					<header id="header">
						<div class="inner">
							<!-- Logo -->
							<a href="index.jsp" class="logo">
								<span class="symbol"><img src="images/logo.svg" alt="로고이미지" /></span>
								<span class="title">Spring</span>
							</a>
							<!-- Nav -->
							<nav>
								<ul>
									<li><a href="#menu">Menu</a></li>
								</ul>
							</nav>
						</div>
					</header>

				<!-- Menu -->
					<nav id="menu">
						<h2>Menu</h2>
						<ul>
							<li><a href="index.jsp">Home</a></li>
						</ul>
					</nav>

				<!-- Main -->
					<div id="main">
						<div class="inner">
							<header>
								<h1>spring을 <br />
								이용한 게시판</h1>
							</header>
							<section class="tiles">
								
								<article class="style4"></article>
								
								<div class="inner">
									<section>
										<h2>L O G I N</h2>
										<form action="login.do" method="post">
											<div class="fields">
												<div class="field half">
													아이디
													<input type="text" name="mid" value="${user.mid}" placeholder="ID">
												</div>
												<div class="field half">
													비밀번호
													<input type="password" name="password" value="${user.password}" placeholder="password">
												</div>
											</div>
											<ul class="actions">
												<li>
												<input type="submit" value="로그인">
												</li>
											</ul>
										</form>
									</section>
									<section>
										<p><a href="signin.do">회원가입</a></p>
										<a href="login.do?lang=en">영어로</a>&nbsp;&nbsp;&nbsp;
										<a href="login.do?lang=ko">한국어로</a>
									</section>
								</div>
							</section>
						</div>
					</div>

				<!-- Footer -->
				<footer id="footer"></footer>
			</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>
</html>