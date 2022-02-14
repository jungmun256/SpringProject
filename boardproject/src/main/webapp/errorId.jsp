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
								<span class="symbol">
								<img src="images/logo.svg" alt="로고이미지" /></span>
								<span class="title">Spring</span>
							</a>
						</div>
					</header>

				<!-- Main -->
					<div id="main">
						<div class="inner">
							<header>
								<h1>아이디를 입력하지 않은 오류</h1>
							</header>
							<section class="tiles">
								<article class="style4"></article>
								<div class="inner">
									<section>
										<img alt="오류메시지" src="images/jm.jpg">
										<h4>Message: ${exception.message}</h4>
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