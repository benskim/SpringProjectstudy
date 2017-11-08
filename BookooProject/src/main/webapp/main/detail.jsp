<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 
       부트스트랩
       layout==>   col-xs-* (모바일)
                col-sm-* (태블릿)
                col-md-* (데스크탑)
                col-lg-* (데스크탑)
     -->
<!DOCTYPE html>
<html>
<head>
<meta charset=EUC-KR">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>   
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script  src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>bookoo</title>
<!-- <link rel="stylesheet" href="../boot/css/bootstrap.min.css">
main.do 는 루트 디렉토리(webcontent) 에서 시작하므로 경로를 이렇게해야함
<link rel="stylesheet" href="../boot/css/bootstrap-theme.min.css">
<script type="text/javascript" src="../boot/js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="../boot/js/bootstrap.min.js"></script> -->
 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
 <!-- 긍정 부정 % script -->
    <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['feel', 'count'],
          <c:forEach var="vo" items="${rList}">
          ['<c:out value="${vo.key}"/>',     <c:out value="${vo.value}"/>],
          </c:forEach>
        ]);

        var options = {
          title: '감정분석차트',
          pieHole: 0.4,
        };

        var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
        chart.draw(data, options);
      }
 </script>
 
<style>
body {
	position: relative;
}

#section1 {
	padding-top: 50px;
	height: 500px;
	color: #fff;
	background-color: #1E88E5;
}

#section2 {
	padding-top: 50px;
	height: 500px;
	color: #fff;
	background-color: #673ab7;
}

#section3 {
	padding-top: 50px;
	height: 500px;
	color: #fff;
	background-color: #ff9800;
}

#section41 {
	padding-top: 50px;
	height: 500px;
	color: #fff;
	background-color: #00bcd4;
}

#section42 {
	padding-top: 50px;
	height: 500px;
	color: #fff;
	background-color: #009688;
}
.col-lg-4{
	align: center;
}


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
	<div class="container" style="padding-left: 30px;">
		<jsp:include page="header.jsp"></jsp:include>
		<h2>상세 페이지</h2>

<!-- 		<div>
			<select class="col-lg-2">

				<option>소설</option>
				<option>소설</option>
				<option>소설</option>
				<option>소설</option>
			</select>
		</div>
		<div>
			<select class="col-lg-2">

				<option>장편소설</option>
				<option>장편소설</option>
				<option>장편소설</option>
				<option>장편소설</option>
			</select>
		</div>
		<div>
			<select class="col-lg-2">

				<option>전쟁/역사</option>
				<option>전쟁/역사</option>
				<option>전쟁/역사</option>
				<option>전쟁/역사</option>
			</select>
		</div> -->

		<br>
		<br>
		<div>
			<h3>${vo.title}
			<br><br>
			
			</h3>
		</div>
		<div>
		<div class="hovereffect">
			<div class="col-lg-3">
				<img src="${vo.bimg }" alt="" style="width: 500; height: 500">
				
				
			
			</div>
			</div>
			<div class="col-lg-2">
				<h4 align="left">도서 정보</h4>
			
				<h5 align="left" style="margin-top: 30px;">저자이름 : ${vo.reviewer }</h5>
				<h5 align="left">가격 : ${vo.price }</h5>
				<h5 align="left">출판사 : ${vo.publisher }</h5>
			</div>
		<div class="col-lg-4">
			  <!-- <div > class="col-sm-6" -->
        <!-- <div id="piechart_3d" style="width: 900px; height: 500px;"></div> -->
			<div id="donutchart" style="width: 400px; height: 400px;"></div>
		
      </div>
       <div class="col-lg-3">
						<h3>책서평 워드클라우드</h3>
				<img src="wordcloud.png">
		</div>
		<!-- 	<div class="col-lg-3">
				<h4 align="center">성별 선호도</h4>
				<img class="img-responsive center-block" src="../image/index.jpeg" alt="">				
			</div> -->
			<!-- <div class="col-lg-4">
				<h4 align="center">연령별 선호도</h4>
				<img class="center-block" src="../image/index.jpeg" alt="">
			</div> -->
		</div>
	</div>
	<br><br>
	<div class="container">
		<div class="col-lg-8">
			
			<ul class="nav nav-tabs">
				<li class="active"><a data-toggle="tab" href="#home">책소개</a></li>
				<li><a data-toggle="tab" href="#menu1">책 속으로</a></li>
				
			</ul>

			<div class="tab-content">
				<div id="home" class="tab-pane fade in active">
					<h3>책소개</h3>
					<p>${vo.bookintro}</p>
				</div>
				<div id="menu1" class="tab-pane fade">
					<h3>책 속으로</h3>
					<c:choose>
						<c:when test="${vo.count>0 }">
							<p >${vo.bookin }</p>
						</c:when>
						<c:when test="${vo.count1>0 }">
							<p >${vo.pwriter }</p>
						</c:when>						
						<c:otherwise>
							<p >책 속으로 내용이 없습니다.</p>
						</c:otherwise>
					</c:choose>
				</div>


			</div>
		</div>
		<div class="col-lg-4">
			
			<h3>연관 추천도서</h3>
			
			
			
				<c:forEach var="rvo" items="${rentList}" begin="0" end="3" step="1">
				<div class="media">
				<div class="media-left">
				<a href="detail.do?isbn=${rvo.isbn }">
					
					<img src="${rvo.bimg }" class="media-object" style="width: 50px">
				
				</a>
				</div>
				<div class="media-body">
					<h4 class="media-heading">${rvo.title }</h4>
					
				</div>
				</div>
				</c:forEach>
			
			
			
			
		</div>
	</div>
	<br><br>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>