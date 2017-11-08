<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>   
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script  src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
.content1 {
	padding-left: 15px;
	padding-right: 15px;
}

#footer-foot {
	border-top: 1px solid;
	width: 980px;
}

.footer-list li {
	list-style: none;
	display: inline;
}

.bookslide {
	padding: 0px;
}

.feel {
	padding: 0px;
}

.well {
	border: 1px solid;
	height: 246px;
}

.left {
	padding-left: 15px;
}

.right {
	padding-right: 15px;
}

.bookslidename {
	text-align: center;
}

.movie_img {
	border: 0px;
}

.feel_img {
	width: 100%;
	height: 266px;
}

.vs {
	text-align: center;
}

.bookvs {
	height: 82px;
}


.floating { background-color:#f9f9f9;
 border:2px solid ; 
 position: fixed; right: 45%; 
 top: 180px; margin-right: -615px; 
 text-align:center; width:70px; 
 border-radius: 8px; 
 -webkit-border-radius: 8px; } 
/*  .floating div:nth-child(1){ border:2px  ; border-radius: 8px; } 
 .floating div:nth-child(2){ border:2px ; border-radius: 8px; } 
 .floating div:nth-child(3){ } */
 
 
 .floating2 { position: fixed;
  left: 45%; top: 180px;
   margin-left: -600px; 
   text-align:center; 
   width: 120px; }



</style>
</head>
<body>

	<div class="container">
		<jsp:include page="header.jsp"></jsp:include>
		<!-- 상단바 끝 -->
		<!-- ************************** header ************************끝  -->
		<br>
		<br>

		<!-- 책 이미지 4개  -->
		<div class="row">
			<div class="col-md-12">
				<blockquote>누구나 한번쯤 읽었을 요즘 책</blockquote>
				<div id="Carousel" class="carousel slide">

					<ol class="carousel-indicators">
						<li data-target="#Carousel" data-slide-to="0" class="active"></li>
						<li data-target="#Carousel" data-slide-to="1"></li>					
						<li data-target="#Carousel" data-slide-to="2"></li>
					</ol>

					<div class="carousel-inner">
                        <div class="item active">
                            <div class="row">
                                <c:forEach var="vo" items="${list }" varStatus="status">
                                    <div class="col-md-3 bookslide">
                                        <a href="detail.do?isbn=${vo.isbn }" class="thumbnail">
                                            <img src="${vo.bimg }" style="max-width:300px; height: 250px;">
                                        </a>
                                        <div class="bookslidename">${vo.title } | ${vo.price }</div>
                                    </div>
                                </c:forEach>
                                </div>                           
                            <!--.row-->
                        </div>
                        <!--.item-->

                        <div class="item">
                            <div class="row">
                                <c:forEach var="vo2" items="${list2 }">
                                    <div class="col-md-3 bookslide">
                                        <a href="detail.do?isbn=${vo2.isbn }"class="thumbnail">
                                            <img src="${vo2.bimg }" style="max-width:100%; max-height: 250px;">
                                        </a>
                                        <div class="bookslidename">${vo2.title } | ${vo2.price }</div>
                                    </div>
                                </c:forEach>
                                </div>
                            <!--.row-->
                        </div>
                        <!--.item-->                       

                            <div class="item">
                            <div class="row">
                                <c:forEach var="vo3" items="${list3 }">
                                    <div class="col-md-3 bookslide">
                                        <a href="detail.do?isbn=${vo3.isbn }"class="thumbnail">
                                            <img src="${vo3.bimg }" style="max-width:100%; max-height: 250px;">
                                        </a>
                                        <div class="bookslidename">${vo3.title } | ${vo3.price }</div>
                                    </div>
                                </c:forEach>
                                </div>
                            <!--.row-->
                        </div>
                        <!--.item-->      		


					</div>
					<!--.carousel-inner-->
					<a data-slide="prev" href="#Carousel" class="left carousel-control"></a>
					<a data-slide="next" href="#Carousel" class="right carousel-control"></a>
				</div>
				<!--.Carousel-->

			</div>
		</div>
		<br>
		<!-- 책 이미지 4개  끝-->
		
		<nav>
			<div class="floating"> 
			
			<div>
			<a href="#" onclick="javascript:window.open('https://plus.google.com/share?url=' +encodeURIComponent(document.URL), 'googleplussharedialog','menubar=no,toolbar=no,resizable=yes, scrollbars=yes,height=350,width=600');return false;" target="_blank" alt="Share on Google+"> <img src="images/googleplus.png" style="width:30px; height:30px;margin-bottom: 10px;margin-top: 10px;"></a>			</div>
			
			 <div> 
			 <a href="#" onclick="javascript:window.open('https://www.facebook.com/sharer/sharer.php?u=' +encodeURIComponent(document.URL)+'&t='+encodeURIComponent(document.title), 'facebooksharedialog', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=300,width=600');return false;" target="_blank" alt="Share on Facebook" ><img src="images/facebook.png" style="width:30px; height:30px;margin-bottom: 10px;margin-top: 10px;"></a>
			</div> 
			
			 <div>	
			 <a href="#" onclick="javascript:window.open('https://twitter.com/intent/tweet?text=[%EA%B3%B5%EC%9C%A0]%20' +encodeURIComponent(document.URL)+'%20-%20'+encodeURIComponent(document.title), 'twittersharedialog', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=300,width=600');return false;" target="_blank" alt="Share on Twitter" ><img src="images/twitter.jpg" style="width:30px; height:30px;margin-bottom: 10px;margin-top: 10px;"></a>
			 </div>
		
			<div>
			<a href="#" onclick="javascript:window.open('https://story.kakao.com/s/share?url=' +encodeURIComponent(document.URL), 'kakaostorysharedialog', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes, height=400,width=600');return false;" target="_blank" alt="Share on kakaostory"> <img src="images/kakaostory.jpg" style="width:30px; height:30px;margin-bottom: 10px;margin-top: 10px;"></a>
			</div>
		
			<div>
			<a href="#" onclick="javascript:window.open('http://share.naver.com/web/shareView.nhn?url=' +encodeURIComponent(document.URL)+'&title='+encodeURIComponent(document.title), 'naversharedialog', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=300,width=600');return false;" target="_blank" alt="Share on Naver" ><img src="images/naver.png" style="width:30px; height:30px;margin-bottom: 10px;margin-top: 10px;"></a>
			</div>
		
			</div>
		</nav>
		
		<!--동영상 책vs책  -->
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
			</ol>

			<!-- 첫번째 슬라이드 -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src="https://placehold.it/1200x400?text=Hoooou" alt="IMAGE">
					<div class="carousel-caption">
					<div class="container">
						<div class="row">
							<div class="col-lg-6">
								<div class="ifrmdiv" style="position:absolute; left:-180px; top:-50px">
								<iframe width=500 height=350 style="left:1px;" src="https://www.youtube.com/embed/gKoUa_E1Ydk" gesture="media"></iframe>
								</div>
							
							</div>
							<div class="col-lg-3" style="left:-220px; top:-10px;">
								<a href="#" class="thumbnail movie_img" ">
									<img src="../image/mv_img.jpg" style="width:55%; height:100%; border: 0;"></a>
								<div class="bookslidename">저자 | 책이름</div>
							</div>

							<div class="col-lg-3" style="left:-220px; top:-35px;">
								<div class="bookvs">
									<h3>도서 평점</h3>
									<img src="../image/img_star.jpg">
								</div>
								<div class="bookvs">
									<img src="../image/img_vs.jpg">
								</div>
								<div class="bookvs">
									<img src="../image/img_star.jpg">
									<h3>영화 평점</h3>
								</div>
							</div>
						</div>
						</div>
					</div>
				</div>
				<!-- 두번째 슬라이드 -->
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" 	data-slide="prev">
			</a>
			<a class="right carousel-control" href="#myCarousel" data-slide="next">
			</a>
		</div>

		<!-- 동영상 책vs책 끝 -->
		<br> <br>
		<!--감정 row -->
		<h3><b>당신의 감정에 따라 책을 추천해 드립니다. </b></h3>
		<br> <br>
		
		<div class="row">
		
			<div class="col-md-2 feel left">
				<a href="recomend.do?thema=1">
				<img src="images/friends.png" class="feel_img" style="width:150px; height:150px; border: 7px solid black; border-radius: 8px;">
				<br><br>
				<b style="color: black;">인간관계가 힘든 당신께..>></b>
				<!-- <img src="../image/feel_happy.jpg" class="feel_img"> --></a>

			</div>
			<div class="col-md-2 feel">
		<a href="recomend.do?thema=2">
				<img src="images/love.png" class="feel_img" style="width:150px; height:150px; border: 7px solid black; border-radius: 8px;">
			<br><br>
				<b style="color: black;">사랑/연애 중인 당신께..>></b>
<!-- 
				<img src="../image/feel_sad.jpg" class="feel_img"> --></a>

			</div>
			<div class="col-md-2 feel">
				<a href="recomend.do?thema=3">
				<img src="images/goal.png" class="feel_img" style="width:150px; height:150px; border: 7px solid black; border-radius: 8px;">
				<br><br>
				<b style="color: black;">목표가 있는 당신께..>></b>
				

				<!-- <img src="../image/feel_cri.jpg" class="feel_img" --></a>

			</div>
			<div class="col-md-2 feel">
			<a href="recomend.do?thema=4">
				<img src="images/death.png" class="feel_img" style="width:150px; height:150px; border: 7px solid black; border-radius: 8px;">
				<br><br>
				<b style="color: black;">하루하루가 힘겨운 당신께..>></b>

			<!-- 	<img src="../image/feel_ang.JPG" class="feel_img"> --></a>

			</div>
			<div class="col-sm-4 feel right">
				<div class="well">
				<h5>실시간 독서뉴스</h5>
					<table style="width:100%">
						<c:forEach var="nvo" items="${newslist }" varStatus="s">
						<tr>
							<th class="btn-nes btn" value="${s.index }"><a href="${nvo.link }">${nvo.title }</a></th>
						</tr>					
						<tr id="" style="display:none">
							<td class="text-left" valign="top">${nvo.description }</td>
						</tr>
						</c:forEach>
						<tr></tr>					
					</table>
					<table class="table">
						<tr>
							<td align=right>
								<a href="main.do?data=${data }&page=${curpage>1?curpage-1:curpage}" class="btn btn-info btn-xs">이전</a> &nbsp;
								<a href="main.do?data=${data }&page=${curpage<totalpage?curpage+1:curpage}" class="btn btn-danger btn-xs">다음</a>&nbsp;  ${curpage } / ${totalpage}  쪽
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<!--감정 row 끝  -->
				<!-- 링크 -->
		<br> <br> <br>
		<nav class="navbar navbar-default">
			<div class="container">
				<div class="navbar-header">
					<strong><a class="navbar-brand" href="#">BOOKOO</a></strong>
				</div>
				<ul class="nav navbar-nav">
					<li><a href="http://www.yes24.com">YES24</a></li>
					<li><a href="http://www.aladin.co.kr">알라딘</a></li>
					<li><a href="http://www.kyobobook.co.kr">교보문고</a></li>
					<li><a href="http://bsearch.interpark.com">인터파크</a></li>
				</ul>
			
			
				<form action="findsite.do" method="post" style="float: right; padding-right: 50px;">
					
					<select class="input" name=fs>
						<option value="kyobo">교보문고</option>
						<option value="aladdin">알라딘</option>
						<option value="interpark">인터파크</option>
						<option value="yes24">YES24</option>
						
					</select>
					<input type="text" name=ss class="input">
					<input type="submit" value="찾기" class="button btn-info">
				</form>
				
				</div>
		</nav>

		<!-- 링크끝 -->
		<!-- container 끝-->
		<br> <br> <br>

		<!-- footer 시작 -->
		<jsp:include page="footer.jsp"></jsp:include>
		</div>
</body>
</html>
