<%@ page language="java" contentType="text/html; charset=EUC-KR"
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
								<h1>This is Sign Up page ,<br />
								Please fill in the fields</h1>
							</header>
							<section class="tiles">
								<article class="style4"></article>
								<div class="inner">
									
									<section>
										<h2>S I G N U P</h2>
										<form action="signin.do" method="post">
											<input type="hidden" name="role" value="USER">
											<div class="fields">
											
												<div class="field half">
													아이디<input type="text" name="mid">
												</div>
												<div class="field half">
													비밀번호<input type="password" name="password">
												</div>
												<div class="field half">
													이름<input type="text" name="name">
												</div>
											</div>
											<ul class="actions">
												<li><input type="submit" value="회원가입"></li>
											</ul>
										</form>
									</section>
									<a href="index.jsp">맨 처음으로</a>
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