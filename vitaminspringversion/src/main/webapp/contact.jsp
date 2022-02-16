<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ogani</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Humberger Begin -->
    <mytag:humberger/>
    <!-- Humberger End -->

    <!-- Header Section Begin -->
    <mytag:header/>
    <!-- Header Section End -->

    <!-- Hero Section Begin -->
    <mytag:herosection/>
    <!-- Hero Section End -->

    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>Contact Us</h2>
                        <div class="breadcrumb__option">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->




	<c:choose>

		<c:when test="${mrole == 'ADMIN'}">
			
			<div class="bodytext_area box_inner">
                <form action="contact.con">
                    <fieldset>
                        <legend>검색</legend>
                        <select name="searchCondition">
							<c:forEach items="${conditionMap}" var="v">
								<option value="${v.value}">${v.key}</option>
							</c:forEach>
						</select>
						<input type="text" name="searchword" placeholder="검색어를 입력하세요">
                        <input type="submit" class="btn_basecolor btn_srch" value="<spring:message code="message.contact.search" />">
                    </fieldset>
                </form>
                <!-- summary : 접근성을 위한 속성 -->
                <table class="bbsListTbl" summary="번호, 제목, 작성자 등을 제공하는 표">
                    <!-- 테이블 제목 -->
                    <caption class="hdd"><spring:message code="message.contact.list" /></caption>
                    <thead>
                        <tr>
                            <th scope="col" style="width:8%"><spring:message code="message.contact.num" /></th>
                            <th scope="col" style="width:50%"><spring:message code="message.contact.writer" /></th>
                            <th scope="col" style="width:50%"><spring:message code="message.contact.content" /></th>
                        </tr>
                    </thead>
                    <tbody>
                    	<c:forEach var="v" items="${cdatas}">
	                        <tr>
	                            <td>${v.msgno}</td>
	                            <td class="tit_notice"><a href="contact_detail.con?msgno=${v.msgno}">${v.msgname}</a></td>
	                            <td>${v.msgtext}</td>
	                        </tr>
                        </c:forEach>
	                            <!-- <td class="tit_notice"><a href="javascript:showdetails()">test(테스트 후 지우는 부분)</a></td> -->
                    </tbody>
                </table>

                
            </div>
			
		</c:when>

	
		
		<c:otherwise>
		
		    <!-- Contact Section Begin -->
		    <section class="contact spad">
		        <div class="container">
		            <div class="row">
		                <div class="col-lg-3 col-md-3 col-sm-6 text-center">
		                    <div class="contact__widget">
		                        <span class="icon_phone"></span>
		                        <h4>Phone</h4>
		                        <p>+82-1-8888-6868</p>
		                    </div>
		                </div>
		                <div class="col-lg-3 col-md-3 col-sm-6 text-center">
		                    <div class="contact__widget">
		                        <span class="icon_pin_alt"></span>
		                        <h4>Address</h4>
		                        <p>60-49 Road 11378 Seoul</p>
		                    </div>
		                </div>
		                <div class="col-lg-3 col-md-3 col-sm-6 text-center">
		                    <div class="contact__widget">
		                        <span class="icon_clock_alt"></span>
		                        <h4>Open time</h4>
		                        <p>10:00 am to 23:00 pm</p>
		                    </div>
		                </div>
		                <div class="col-lg-3 col-md-3 col-sm-6 text-center">
		                    <div class="contact__widget">
		                        <span class="icon_mail_alt"></span>
		                        <h4>Email</h4>
		                        <p>hello@ogani.com</p>
		                    </div>
		                </div>
		            </div>
		        </div>
		    </section>
		    <!-- Contact Section End -->
		
		
		    <!-- Contact Form Begin -->
		    <div class="contact-form spad">
		        <div class="container">
		            <div class="row">
		                <div class="col-lg-12">
		                    <div class="contact__form__title">
		                        <h2><spring:message code="message.contact.leavemessage" /></h2>
		                    </div>
		                </div>
		            </div>
		            <form action="contact_insert.con" method="post">
		                <div class="row">
		                    <div class="col-lg-6 col-md-6">
		                        <input type="text" placeholder="Your name" name="msgname">
		                    </div>
		                    <div class="col-lg-6 col-md-6">
		                        <input type="text" placeholder="Your Email" name="msgemail">
		                    </div>
		                    <div class="col-lg-12 text-center">
		                        <textarea placeholder="Your message" name="msgtext"></textarea>
		                    </div>
		                </div>               
		                <button type="submit" class="site-btn"><spring:message code="message.contact.sendemessage" /></button>
		            </form>
		        </div>
		    </div>
		    <!-- Contact Form End -->

		</c:otherwise>

	</c:choose>


	<!-- Footer Section Begin -->
	<jsp:include page="/footer.jsp"/>
    <!-- Footer Section End -->

    <!-- Js Plugins -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/main.js"></script>



</body>

</html>
    