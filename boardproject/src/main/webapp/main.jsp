<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
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
				<a href="main.do" class="logo"> <span class="symbol">
					<img src="images/logo.svg" alt="로고이미지" /></span> 
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

				<!-- Image -->
				<section>
					<div class="box alt">
						<div class="row gtr-uniform">
							<div class="col-12">
								<span class="image fit">
								<img src="images/pic13.jpg" alt="기본이미지" /></span>
							</div>

						</div>
					</div>

				</section>

				<section>
					<h2>${memData.name}<spring:message code="message.header.hello" />
					</h2>
					<ul class="actions">
						<!-- <li><input type="submit" value="Send" class="primary" /></li> -->
						<li><a href="logout.do"><spring:message code="message.header.logout" /></a></li>
						<li><a href="insertBoard.jsp"><spring:message code="message.footer.board" /></a></li>
						<li><a href="mypage.do"><spring:message code="message.footer.member" /></a></li>
					</ul>
				</section>

				<form action="main.do" method="post">
					<table>
						<tr>
							<td>
								<select name="searchCondition">
									<c:forEach items="${conditionMap}" var="v">
										<option value="${v.value}">${v.key}</option>
									</c:forEach>
								</select>
							</td>
							<td><input type="text" name="searchContent" /></td>
							<td><input type="submit" value="<spring:message code="message.body.search" />" /></td>
						</tr>
					</table>
				</form>

				<!-- Table -->
				<section>
					<h3>
						<spring:message code="message.header.title" />
					</h3>
					<div class="table-wrapper">
						<table>
							<thead>
								<tr>
									<th><spring:message code="message.body.table.num" /></th>
									<th><spring:message code="message.body.table.title" /></th>
									<th><spring:message code="message.body.table.writer" /></th>
									<th><spring:message code="message.body.table.reg" /></th>
									<th><spring:message code="message.body.table.cnt" /></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="v" items="${datas}">
									<tr>
										<td><a href="board.do?bid=${v.bid}">${v.bid}</a></td>
										<td>${v.title}</td>
										<td>${v.writer}</td>
										<td>${v.bdate}</td>
										<td>${v.cnt}</td>
									</tr>
								</c:forEach>
							</tbody>
							<tfoot></tfoot>
						</table>
					</div>
				</section>
			</div>
		</div>

		<!-- Footer -->
		<footer id="footer">
			<div class="inner">
				<section></section>
				<section>
					<h2>Follow</h2>
					<ul class="icons">
						<li><a href="https://blog.naver.com/jungmun256"
							class="icon brands style2 fa-instagram"><span class="label">Blog</span></a></li>
						<li><a href="https://github.com/jungmun256"
							class="icon brands style2 fa-github"><span class="label">GitHub</span></a></li>
						<li><a href="jungmun256@gmail.com"
							class="icon solid style2 fa-envelope"><span class="label">Email</span></a></li>
					</ul>
				</section>
				<ul class="copyright">
					<li>&copy; Untitled. All rights reserved</li>
					<li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
				</ul>
				<ul class="copyright">
					<li>&copy; Untitled. All rights reserved</li>
					<li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
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