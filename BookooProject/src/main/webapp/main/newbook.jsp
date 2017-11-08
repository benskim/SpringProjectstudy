<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>신간 페이지</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {

		$("#tabs").tabs();

	});
</script>

<style type="text/css">

#more {
	float: right;
}
#footer-foot {
    border-top: 1px solid;
    width: 980px;
}
.footer-list li {
    list-style: none;
    display: inline;
}
.col-lg-3{
	text-align: left;
}

@-webkit-keyframes grow {
    0% { font-size: 0px; }
    75% { font-size: 10px; }
    100% { font-size: 20px; }
}

/* html, body { 
    height: 100%; 
    margin: 0; 
} */


/* .rating {
    position: absolute;
    width: 100px;
    height: 20px;
    top:50%; left:50%;
    margin: -45px 0 0 -225px;
} */

.rating .star {
    float: left;
    width: 20px;
    line-height: 20px;
    text-align: center;
    font-size: 20px;
    -webkit-animation: grow .8s cubic-bezier(0,3,.3,0);
    text-shadow: 0 4px 4px rgba(0,0,0,.3);
}
.rating .star:after {
    content: '\2605';
    color: gold;
}
.rating .star:nth-child(2) { -webkit-animation-duration: .9s; }
.rating .star:nth-child(3) { -webkit-animation-duration: 1s; }
.rating .star:nth-child(4) { -webkit-animation-duration: 1.1s; }
.rating .star:nth-child(5) { -webkit-animation-duration: 1.2s; }}


.hovereffect {
	width: 220px;
	height: 250px;
	float: left;
	overflow: hidden;
	position: relative;
	text-align: center;
	cursor: default;
}

.hovereffect .overlay {
	width: 100%;
	height: 100%;
	position: absolute;
	overflow: hidden;
	top: 0;
	left: 0;
	opacity: 0;
	background-color: rgba(0, 0, 0, 0.5);
	-webkit-transition: all .4s ease-in-out;
	transition: all .4s ease-in-out
}

.hovereffect img {
	display: block;
	position: relative;
	-webkit-transition: all .4s linear;
	transition: all .4s linear;
}

.hovereffect h2 {
	text-transform: uppercase;
	color: #fff;
	text-align: center;
	position: relative;
	font-size: 17px;
	background: rgba(0, 0, 0, 0.6);
	-webkit-transform: translatey(-100px);
	-ms-transform: translatey(-100px);
	transform: translatey(-100px);
	-webkit-transition: all .2s ease-in-out;
	transition: all .2s ease-in-out;
	padding: 10px;
}

.hovereffect a.info {
	text-decoration: none;
	display: inline-block;
	text-transform: uppercase;
	color: #fff;
	border: 1px solid #fff;
	background-color: transparent;
	opacity: 0;
	filter: alpha(opacity = 0);
	-webkit-transition: all .2s ease-in-out;
	transition: all .2s ease-in-out;
	margin: 50px 0 0;
	padding: 7px 14px;
}

.hovereffect a.info:hover {
	box-shadow: 0 0 5px #fff;
}

.hovereffect:hover img {
	-ms-transform: scale(1.2);
	-webkit-transform: scale(1.2);
	transform: scale(1.2);
}

.hovereffect:hover .overlay {
	opacity: 1;
	filter: alpha(opacity = 100);
}

.hovereffect:hover h2, .hovereffect:hover a.info {
	opacity: 1;
	filter: alpha(opacity = 100);
	-ms-transform: translatey(0);
	-webkit-transform: translatey(0);
	transform: translatey(0);
}

.hovereffect:hover a.info {
	-webkit-transition-delay: .2s;
	transition-delay: .2s;
}



</style>

</head>
<body>
 <div class="container"> 
	 <!-- 상단바 : 타 사이트 링크 및 검색창 -->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- 상단바 끝 -->
	<br><br>

	<div style="margin-left: 20px;">
		<h2>
			<b style="color: orange;">종합 신간도서 목록</b>
		</h2>
	</div>
		<!-- <ul>

			<li><a href="#tabs-1">금주의 주요신간</a></li>

			<li><a href="#tabs-2">편집회의 선정신간</a></li>

			<li><a href="#tabs-3">예약 판매 베스트</a></li>

		</ul>
 -->

			<div class="container-fluid bg-3 text-center">

			<!-- 	<div>
					<a href="#"><img alt="" src="../img/tap.png"
						style="float: right; width: 30px; height: 30px; margin-right: 10px; margin-left: 2000px; margin-bottom: 10px;"></a>
				</div> -->
				<c:forEach var="bookvo" items="${list }">
					
					<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
					<div class="hovereffect">
					<a href="detail.do?isbn=${bookvo.isbn }">
						<img src="${bookvo.bimg }"
							class="img-responsive" style="width: 220px; height: 250px;" alt="Image">	
					<!-- 	<div class="overlay">
								<h2>
									평점<br><br>별 개수
								</h2>
								<p>줄거리 요악 이책은 무슨무슨 내용입니다.</p>
							</div> -->
						</a>										
					</div>
						<p><B>${ bookvo.title}</B></p>									
						<p>작가 : ${bookvo.publisher }</p>
						<%-- <p>출판사 : ${bookvo.reviewer } --%>
						<p>가격 : ${bookvo.price } 원</p>					
						
						<p class="rating">
						 	<c:choose>
						 		<c:when test="${bookvo.star > 0 }">  ${bookvo.star} / 5
						 		<c:forEach begin="1" end="${bookvo.star }" step="1">
						    		<span class="star" ></span>
						        </c:forEach>
						   </c:when>

						   <c:otherwise>
						  	
						  	 <span>별점이 없습니다. ★ </span>
						   
						   
						   </c:otherwise>					   

						   </c:choose>
						</p>
						<p></p>
						<br>
					</div>					
				</c:forEach>
			</div>
	
    	<br>
		<div align="center">
			<ul class="pagination">
				<c:set var="i" value="1"/>
				<c:forEach var="page" begin="1" end="${totalpage}" step="1">					
						<li><a href="newbook.do?page=${i }">${i }</a></li>
						<c:set var="i" value="${i+1 }"/>	
				</c:forEach>
			</ul>
		</div>
		<br>
    <br>

    <!-- footer 시작 -->
    <jsp:include page="footer.jsp"></jsp:include>
</div>
</body>

</html>