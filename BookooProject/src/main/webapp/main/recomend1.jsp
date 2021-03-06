<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>추천도서 페이지</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- main.do 는 루트 디렉토리(webcontent) 에서 시작하므로 경로를 이렇게해야함 -->
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript">
/* $(function(){
	$('#thema').change(function(){
		var thema=$('#thema').val();
		$.ajax({
			type: 'POST',
			url: 'recomend.do',
			data: {"thema":thema},
			success:function(response){
				$('#recomend.jsp')
			}
		});
	});
}); */
 /* 
 <select id="thema" name="thema">
			<option value="1">인간관게</option>
			<option value="2">연애/사랑</option>
			<option value="3">꿈</option>
			<option value="4">죽음</option>
		</select>
 */ 
</script>
<style>

.checkbox label:after, .radio label:after {
	content: '';
	display: table;
	clear: both;
}

.checkbox .cr, .radio .cr {
	position: relative;
	display: inline-block;
	border: 1px solid #a9a9a9;
	border-radius: .25em;
	width: 1.3em;
	height: 1.3em;
	float: left;
	margin-right: .5em;
}

.radio .cr {
	border-radius: 50%;
}

.checkbox .cr .cr-icon, .radio .cr .cr-icon {
	position: absolute;
	font-size: .8em;
	line-height: 0;
	top: 50%;
	left: 20%;
}

.radio .cr .cr-icon {
	margin-left: 0.04em;
}

.checkbox label input[type="checkbox"], .radio label input[type="radio"]
	{
	display: none;
}

.checkbox label input[type="checkbox"]+.cr>.cr-icon, .radio label input[type="radio"]+.cr>.cr-icon
	{
	transform: scale(3) rotateZ(-20deg);
	opacity: 0;
	transition: all .3s ease-in;
}

.checkbox label input[type="checkbox"]:checked+.cr>.cr-icon, .radio label input[type="radio"]:checked+.cr>.cr-icon
	{
	transform: scale(1) rotateZ(0deg);
	opacity: 1;
}

.checkbox label input[type="checkbox"]:disabled+.cr, .radio label input[type="radio"]:disabled+.cr
	{
	opacity: .5;
}

.hovereffect {
	width: 100%;
	height: 100%;
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
#footer-foot {
    border-top: 1px solid;
    width: 980px;
}
.footer-list li {
    list-style: none;
    display: inline;
}
</style>

</head>
<body>
	
      <!-- 
		<h3>추천도서</h3>
		<hr />
		<select id="thema" name="thema">
			<option value="1">인간관게</option>
			<option value="2">연애/사랑</option>
			<option value="3">꿈</option>
			<option value="4">죽음</option>
		</select>
		<hr/> <br> -->
		<!-- ---------------상단 라디오 체크박스 끝----------------------------------------------- -->
		<div class="container-fluid bg-3 text-center">

			<br>
			<div class="row">
				<c:set var="i" value="1"/>
				<c:forEach var="vo" items="${list }" varStatus="">
					
					<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
						<div class="hovereffect">
							<img class="img-responsive" src="${vo.bimg2 }" alt="" style="width: 220px; height: 240px;"> 
							<a href="detail.do?isbn=${vo.isbn2 }">
								<div class="overlay">
									<h2>
										평점: ${vo.star2 }<br>
									</h2>
								</div>
							</a>
	
						</div>
						<div>
							<b>${vo.title2 }</b>
							<p>${vo.publisher2 }</p>
							<br>
						</div>
					</div>
					
					<c:if test="${i%6==0 }">
						
					</c:if>
					<c:set var="i" value="${i+1 }"/>
				</c:forEach>			
				
			</div>
		</div>
		
</body>
</html>