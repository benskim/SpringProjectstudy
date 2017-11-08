<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>베스트 페이지</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.js"></script>
	<link rel="stylesheet" href="/css/jquery-ui.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"/>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
    <script type='text/javascript' src='//code.jquery.com/jquery-1.8.3.js'></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker3.min.css">
    <script type='text/javascript' src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.min.js"></script>
    <script src="/js/bootstrap-datepicker.kr.js" charset="UTF-8"></script>

    <script type='text/javascript'>
    $(function(){
        $('.input-group.date').datepicker({
            calendarWeeks: false,
            todayHighlight: true,
            autoclose: true,
            format: "yyyy/mm/dd",
            language: "kr"
        });
    });
    </script>
<style type="text/css">
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

<div class="container">
  <!-- 상단바 : 타 사이트 링크 및 검색창 -->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- 상단바 끝 -->
    	<br>
    	<h2>
			<b style="color: orange;">장르별 베스트 도서</b>
		</h2>
        <br>
        <!--***************************header ********************************************8  -->
  <ul class="nav nav-pills">
    <li class="active">
    <a data-toggle="pill" href="#home">철학</a></li>
    <li><a data-toggle="pill" href="#menu1">종교</a></li>
    <li><a data-toggle="pill" href="#menu2">사회과학</a></li>
    <li><a data-toggle="pill" href="#menu3">자연과학</a></li>
    <li><a data-toggle="pill" href="#menu4">기술과학</a></li>
    <li><a data-toggle="pill" href="#menu5">예술</a></li>
    <li><a data-toggle="pill" href="#menu6">언어</a></li>
    <li><a data-toggle="pill" href="#menu7">문화</a></li>
    <li><a data-toggle="pill" href="#menu8">역사</a></li>
  </ul>
  <br><br>
 <!-- <div class="container">
        <br/>
        <div class="input-group date">
            <input type="text" class="form-control"><span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
        </div>
    </div> -->


		<div class="tab-content">
			<div id="home" class="tab-pane fade in active">
				<div>
					<c:forEach var="vo" items="${list }" begin="0" end="9" step="1">
						<div class="row">
							<div class="col-lg-3">
								<div class="well">
									<a href="detail.do?isbn=${vo.isbn }"><img src="${vo.bimg }" class="img" height="190" width="150"
										alt="Avatar"></a>
								</div>
							</div>
							<div class="col-lg-9">
								<div class="well">
									<p>
									제목 : <b>${vo.title }</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									평점 : <b>${vo.star }</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									출판사 : <b>${vo.publisher }</b>
									</p>
									<br>
									<p>줄거리 : ${vo.bookintro }</p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
				<div id="menu1" class="tab-pane fade">
					<c:forEach var="vo" items="${list }" begin="10" end="19" step="1">
						<div class="row">
							<div class="col-lg-3">
								<div class="well">
									<a href="detail.do?isbn=${vo.isbn }"><img src="${vo.bimg }" class="img" height="190" width="150"
										alt="Avatar"></a>
								</div>
							</div>
							<div class="col-lg-9">
								<div class="well">
									<p>
									제목 : <b>${vo.title }</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									평점 : <b>${vo.star }</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									출판사 : <b>${vo.publisher }</b>
									</p>
									<br>
									<p>줄거리 : ${vo.bookintro }</p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<div id="menu2" class="tab-pane fade">
					<c:forEach var="vo" items="${list }" begin="20" end="29" step="1">
						<div class="row">
							<div class="col-lg-3">
								<div class="well">
									<a href="detail.do?isbn=${vo.isbn }"><img src="${vo.bimg }" class="img" height="190" width="150"
										alt="Avatar"></a>
								</div>
							</div>
							<div class="col-lg-9">
								<div class="well">
									<p>
									제목 : <b>${vo.title }</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									평점 : <b>${vo.star }</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									출판사 : <b>${vo.publisher }</b>
									</p>
									<br>
									<p>줄거리 : ${vo.bookintro }</p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<div id="menu3" class="tab-pane fade">
					<c:forEach var="vo" items="${list }" begin="30" end="39" step="1">
						<div class="row">
							<div class="col-lg-3">
								<div class="well">
									<a href="detail.do?isbn=${vo.isbn }"><img src="${vo.bimg }" class="img" height="190" width="150"
										alt="Avatar"></a>
								</div>
							</div>
							<div class="col-lg-9">
								<div class="well">
									<p>
									제목 : <b>${vo.title }</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									평점 : <b>${vo.star }</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									출판사 : <b>${vo.publisher }</b>
									</p>
									<br>
									<p>줄거리 : ${vo.bookintro }</p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<div id="menu4" class="tab-pane fade">
					<c:forEach var="vo" items="${list }" begin="40" end="49" step="1">
						<div class="row">
							<div class="col-lg-3">
								<div class="well">
									<a href="detail.do?isbn=${vo.isbn }"><img src="${vo.bimg }" class="img" height="190" width="150"
										alt="Avatar"></a>
								</div>
							</div>
							<div class="col-lg-9">
								<div class="well">
									<p>
									제목 : <b>${vo.title }</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									평점 : <b>${vo.star }</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									출판사 : <b>${vo.publisher }</b>
									</p>
									<br>
									<p>줄거리 : ${vo.bookintro }</p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<div id="menu5" class="tab-pane fade">
					<c:forEach var="vo" items="${list }" begin="50" end="59" step="1">
						<div class="row">
							<div class="col-lg-3">
								<div class="well">
									<a href="detail.do?isbn=${vo.isbn }"><img src="${vo.bimg }" class="img" height="190" width="150"
										alt="Avatar"></a>
								</div>
							</div>
							<div class="col-lg-9">
								<div class="well">
									<p>
									제목 : <b>${vo.title }</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									평점 : <b>${vo.star }</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									출판사 : <b>${vo.publisher }</b>
									</p>
									<br>
									<p>줄거리 : ${vo.bookintro }</p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<div id="menu6" class="tab-pane fade">
					<c:forEach var="vo" items="${list }" begin="60" end="69" step="1">
						<div class="row">
							<div class="col-lg-3">
								<div class="well">
									<a href="detail.do?isbn=${vo.isbn }"><img src="${vo.bimg }" class="img" height="190" width="150"
										alt="Avatar"></a>
								</div>
							</div>
							<div class="col-lg-9">
								<div class="well">
									<p>
									제목 : <b>${vo.title }</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									평점 : <b>${vo.star }</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									출판사 : <b>${vo.publisher }</b>
									</p>
									<br>
									<p>줄거리 : ${vo.bookintro }</p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<div id="menu7" class="tab-pane fade">
					<c:forEach var="vo" items="${list }" begin="70" end="79" step="1">
						<div class="row">
							<div class="col-lg-3">
								<div class="well">
									<a href="detail.do?isbn=${vo.isbn }"><img src="${vo.bimg }" class="img" height="190" width="150"
										alt="Avatar"></a>
								</div>
							</div>
							<div class="col-lg-9">
								<div class="well">
									<p>
									제목 : <b>${vo.title }</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									평점 : <b>${vo.star }</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									출판사 : <b>${vo.publisher }</b>
									</p>
									<br>
									<p>줄거리 : ${vo.bookintro }</p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<div id="menu8" class="tab-pane fade">
					<c:forEach var="vo" items="${list }" begin="80" end="89" step="1">
						<div class="row">
							<div class="col-lg-3">
								<div class="well">
									<a href="detail.do?isbn=${vo.isbn }"><img src="${vo.bimg }" class="img" height="190" width="150"
										alt="Avatar"></a>
								</div>
							</div>
							<div class="col-lg-9">
								<div class="well">
									<p>
									제목 : <b>${vo.title }</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									평점 : <b>${vo.star }</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									출판사 : <b>${vo.publisher }</b>
									</p>
									<br>
									<p>줄거리 : ${vo.bookintro }</p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>				
			</div>
		</div>
		<!-- 링크 -->
        <br> <br> <br>

   
    <!-- 링크끝 -->
    <!-- container 끝-->
    <br>
    <br>
    <br>

    <!-- footer 시작 -->
   <jsp:include page="footer.jsp"></jsp:include>  

</body>
</html>

