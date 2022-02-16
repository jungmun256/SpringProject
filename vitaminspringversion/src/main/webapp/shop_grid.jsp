<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                        <h2>Shop</h2>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Product Section Begin -->
    <section class="product spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-5">
                    <div class="sidebar">
                        <div class="sidebar__item">
                            <h4><spring:message code="message.product.title" /></h4>
                            <ul>
                                <li><a href="product_filterselect.pro?pcode=VITA"><spring:message code="message.product.vita" /></a></li>
                                <li><a href="product_filterselect.pro?pcode=LACT"><spring:message code="message.product.lacto" /></a></li>
                                <li><a href="product_filterselect.pro?pcode=EYES"><spring:message code="message.product.lutain" /></a></li>
                            </ul>
                        </div>
                        <div class="sidebar__item"></div>
                        <div class="sidebar__item sidebar__item__color--option"></div>
                        <div class="sidebar__item"></div>
                    </div>
                </div>
                <div class="col-lg-9 col-md-7">
                    
                    <div class="filter__item">
                        <div class="row">
                            <div class="col-lg-8 col-md-5">
                               
                               <div class="featured__controls">
			                        <ul>
			                        	<c:choose>
			                        	<c:when test="${pcode != null}">
			                        		<li><a href="product_filterselect.pro?pcode=${pcode}"><spring:message code="message.product.filter" /></a></li>
				                            <li><a href="product_selectalltop.pro?pcode=${pcode}"><spring:message code="message.product.soldfilter" /></a></li>
				                            <li><a href="product_selectalllow.pro?pcode=${pcode}"><spring:message code="message.product.lowpricefilter" /></a></li>
				                            <li><a href="product_selectallhigh.pro?pcode=${pcode}"><spring:message code="message.product.highpricefilter" /></a></li>
				                            <li><a href="product_selectsoldout.pro?pcode=${pcode}"><spring:message code="message.product.soldoutfilter" /></a></li>
			                        	</c:when>
			                       
			                        	<c:otherwise>
			                            <li><a href="product_filterselect.pro?"><spring:message code="message.product.filter" /></a></li>
			                            <li><a href="product_selectalltop.pro?"><spring:message code="message.product.soldfilter" /></a></li>
			                            <li><a href="product_selectalllow.pro?"><spring:message code="message.product.lowpricefilter" /></a></li>
			                            <li><a href="product_selectallhigh.pro?"><spring:message code="message.product.highpricefilter" /></a></li>
			                            <li><a href="product_selectsoldout.pro?"><spring:message code="message.product.soldoutfilter" /></a></li>
			                            </c:otherwise>
			                            </c:choose>
			                        </ul>
			                    </div>
                            </div>
                           
                        </div>
                    </div>
                    <div class="row">
                    	<c:forEach var="v" items="${pdatas}">
	                        <div class="col-lg-4 col-md-6 col-sm-6">
	                            <div class="product__item">
	                                <div class="product__item__pic set-bg" data-setbg="${v.pimg_src}">
	                                   
	                                </div>
	                                <div class="product__item__text">
	                                    <h6><a href="product_detail.pro?pno=${v.pno}">${v.pname}</a></h6>
	                                    <h5><fmt:formatNumber value="${v.pprice}" pattern="#,###" /><spring:message code="message.product.unit" /></h5>
	                                </div>
	                            </div>
	                        </div>
                     	</c:forEach>   
                    </div>
                    
                </div>
            </div>
        </div>
    </section>
    <!-- Product Section End -->

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
