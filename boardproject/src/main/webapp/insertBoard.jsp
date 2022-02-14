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
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
 <style>
    .dellink{
      display: none;
    }
</style>
<script type="text/javascript" src="js/upload.js"></script>

<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>
</head>
<body class="is-preload">
	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Header -->
		<header id="header">
			<div class="inner">

				<!-- Logo -->
				<a href="main.do" class="logo"> 
					<span class="symbol">
						<img src="images/logo.svg" alt="로고이미지" />
					</span>
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
				<li><a href="main.do">Home</a></li>
			</ul>
		</nav>

		<!-- Main -->
		<div id="main">
			<div class="inner">
				<h1></h1>
				<span class="image main"><img src="images/pic13.jpg" alt="기본이미지" /></span>
				<hr>

				<!-- Table -->
				<section>
					<div class="table-wrapper">
						<h1>
							새 글 작성하기
						</h1>
						<a href="main.do">메인으로 돌아가기</a>
						<hr>
						<form action="insertBoard.do" method="post" enctype="multipart/form-data">
							<table class="alt">
								<thead></thead>
								<tbody>
									<tr>
										<td>글 제목</td>
										<td><input type="text" name="title"></td>
									</tr>
									<tr>
										<td>작성자</td>
										<td><input type="text" name="writer"></td>
									</tr>
									<tr>
										<td>글 내용</td>
										<td><input type="text" name="content"></td>
									</tr>
									<tr>
										<td>파일 업로드</td>
										<td>
											<span class="image">
												<img src="" class="thumb" alt="파일업로드 이미지 미리보기"/>
											</span>
											<input type="file" class="hidden_input" id="imageSelector" name="file" accept="image/jpeg, image/jpg, image/png" multiple />
										</td>
										<td>
										</td>
									</tr>
								</tbody>
								<tfoot>
									<tr>
										<td colspan="2"><input type="submit" value="글 등록하기"></td>
									</tr>
								</tfoot>
							</table>
						</form>
					</div>
				</section>
				<hr>
			</div>
		</div>

		<!-- Footer -->
		<footer id="footer">
			<div class="inner">
				<section>
					<h2>Follow</h2>
					<ul class="icons">
						<li><a href="https://blog.naver.com/jungmun256" class="icon brands style2 fa-instagram"><span class="label">Blog</span></a></li>
						<li><a href="https://github.com/jungmun256" class="icon brands style2 fa-github"><span class="label">GitHub</span></a></li>
						<li><a href="jungmun256@gmail.com" class="icon solid style2 fa-envelope"><span class="label">Email</span></a></li>
					</ul>
				</section>
				<ul class="copyright">
					<li>&copy; Untitled. All rights reserved</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
				</ul>
			</div>
		</footer>

	</div>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>

</body>
</html>