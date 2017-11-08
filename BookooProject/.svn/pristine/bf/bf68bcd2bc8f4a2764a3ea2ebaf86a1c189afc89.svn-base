<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 검색 페이지</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
	

	<!-- 컨텐츠 시작 -->
	<div class="container">
	
	 <!-- 상단바 : 타 사이트 링크 및 검색창 -->
	<jsp:include page="header.jsp"></jsp:include>
	<br><br>
	<!-- 상단바 끝 -->
		<div class="container">
			<label class="radio-inline"> 
				<input type="radio"	name="findtype" value=""> 책 검색
			</label>
			<label class="radio-inline"> 
				<input type="radio"	name="findtype" value=""> 본문 검색
			</label> <br><br>
		</div>
		<!-- 사이드 메뉴 시작 -->
		<!-- span태그에다가 수량 넣어주시면 됩니다. 분야별은 분야 뭐뭐할지 정해지는대로 추가하시면 됩니다. -->
		<div class="col-lg-2">
			<ul class="list-group">
				<li class="list-group-item"><strong><a href="#">전체</a></strong>
					<span class="badge">1,014</span></li>
				<li class="list-group-item"><strong>화제의 책</strong> 
					<span class="badge">5</span></li>
				<li class="list-group-item"><a href="#"> - 신간</a></li>
				<li class="list-group-item"><a href="#"> - 베스트</a></li>
				<li class="list-group-item"><strong>분야별 <i class="fa fa-caret-down"></i></strong></li>
				<li class="list-group-item"><a href="#"> - 소설</a> 
					<span class="badge">3</span></li>
				<li class="list-group-item"><a href="#"> - 여행</a>
					<span class="badge">7</span></li>
			</ul>
		</div>
		<!-- 사이드 메뉴 끝 -->
		
		<!-- 검색결과부분 시작 -->
		<!-- 네이버 책의 경우 한 페이지에 20개씩 출력하더군요. 5개만 띄워놓았으니 나중에 지우고 쓰시기 바랍니다. -->
		<div class="col-lg-10">
			<table class="table table-bordered">
				<tr>
					<!-- 한 페이지에 출력하는 개수 / 총 개수 -->
					<td><strong>책 검색</strong> (1 - 20 / 1,014건)</td>
				</tr>
				<tr>
					<!-- 관련도,출간일,판매량(대출횟수별) 정렬 -->
					<td>
						<label class="radio-inline"> 
							<input type="radio"	name="sort" value="">관련도순
						</label>
						<label class="radio-inline"> 
							<input type="radio" name="sort" value="">출간일순
						</label> 
						<label class="radio-inline"> 
							<input type="radio" name="sort" value="">판매량순
						</label>
					</td>
				</tr>
				
				<!-- 검색결과 출력 시작 -->
				<!-- 책표지,책제목 둘 중 하나라도 클릭 시 상세정보 넘어가도록 링크 -->
				<tr>
					<td>
						<div class="col-lg-2">
							<a href="#"> 
								<img src="http://bookthumb.phinf.naver.net/cover/092/206/09220655.jpg?type=m140&udate=20160924" alt="책표지">
							</a>
						</div>
						<div class="col-lg-8">
							<dl>
								<dt>
									<a href="#">꽃을 보듯 너를 본다</a>
								</dt>
								<br>
								<dd>나태주 저 (글쓴이) | 지혜 (출판사) | 2015.06.20 (출간일) | 9,000원 (가격)</dd>
								<br>
								<dd>(소개) 독자들이 선정한 나태주 시 모음집.나태주 시집 『꽃을 보듯 너를 본다』. 이 시집은 시인
									나태주의 시 가운데 인터넷의 블로그나 트위터에서 자주 오르내리는 시들만 모아 엮은 책이다. '내가 너를', '그
									말', '좋다', '사랑에 답함', '바람 부는 날', '그리움', '못난이 인형', '허방다리', '첫눈',
									'섬...</dd>
							</dl>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="col-lg-2">
							<a href="#"> <img
								src="http://bookthumb.phinf.naver.net/cover/092/206/09220655.jpg?type=m140&udate=20160924">
							</a>
						</div>
						<div class="col-lg-8">
							<dl>
								<dt>
									<a href="#">꽃을 보듯 너를 본다</a>
								</dt>
								<br>
								<dd>나태주 저 | 지혜 | 2015.06.20 | 9,000원</dd>
								<br>
								<dd>독자들이 선정한 나태주 시 모음집.나태주 시집 『꽃을 보듯 너를 본다』. 이 시집은 시인 나태주의
									시 가운데 인터넷의 블로그나 트위터에서 자주 오르내리는 시들만 모아 엮은 책이다. '내가 너를', '그 말',
									'좋다', '사랑에 답함', '바람 부는 날', '그리움', '못난이 인형', '허방다리', '첫눈', '섬...
								</dd>
							</dl>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="col-lg-2">
							<a href="#"> <img
								src="http://bookthumb.phinf.naver.net/cover/092/206/09220655.jpg?type=m140&udate=20160924">
							</a>
						</div>
						<div class="col-lg-8">
							<dl>
								<dt>
									<a href="#">꽃을 보듯 너를 본다</a>
								</dt>
								<br>
								<dd>나태주 저 | 지혜 | 2015.06.20 | 9,000원</dd>
								<br>
								<dd>독자들이 선정한 나태주 시 모음집.나태주 시집 『꽃을 보듯 너를 본다』. 이 시집은 시인 나태주의
									시 가운데 인터넷의 블로그나 트위터에서 자주 오르내리는 시들만 모아 엮은 책이다. '내가 너를', '그 말',
									'좋다', '사랑에 답함', '바람 부는 날', '그리움', '못난이 인형', '허방다리', '첫눈', '섬...
								</dd>
							</dl>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="col-lg-2">
							<a href="#"> <img
								src="http://bookthumb.phinf.naver.net/cover/092/206/09220655.jpg?type=m140&udate=20160924">
							</a>
						</div>
						<div class="col-lg-8">
							<dl>
								<dt>
									<a href="#">꽃을 보듯 너를 본다</a>
								</dt>
								<br>
								<dd>나태주 저 | 지혜 | 2015.06.20 | 9,000원</dd>
								<br>
								<dd>독자들이 선정한 나태주 시 모음집.나태주 시집 『꽃을 보듯 너를 본다』. 이 시집은 시인 나태주의
									시 가운데 인터넷의 블로그나 트위터에서 자주 오르내리는 시들만 모아 엮은 책이다. '내가 너를', '그 말',
									'좋다', '사랑에 답함', '바람 부는 날', '그리움', '못난이 인형', '허방다리', '첫눈', '섬...
								</dd>
							</dl>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="col-lg-2">
							<a href="#"> <img
								src="http://bookthumb.phinf.naver.net/cover/092/206/09220655.jpg?type=m140&udate=20160924">
							</a>
						</div>
						<div class="col-lg-8">
							<dl>
								<dt>
									<a href="#">꽃을 보듯 너를 본다</a>
								</dt>
								<br>
								<dd>나태주 저 | 지혜 | 2015.06.20 | 9,000원</dd>
								<br>
								<dd>독자들이 선정한 나태주 시 모음집.나태주 시집 『꽃을 보듯 너를 본다』. 이 시집은 시인 나태주의
									시 가운데 인터넷의 블로그나 트위터에서 자주 오르내리는 시들만 모아 엮은 책이다. '내가 너를', '그 말',
									'좋다', '사랑에 답함', '바람 부는 날', '그리움', '못난이 인형', '허방다리', '첫눈', '섬...
								</dd>
							</dl>
						</div>
					</td>
				</tr>
				<!-- 검색결과출력 끝 -->
			</table>
		</div>
		<!-- 검색결과부분 끝 -->
	
		<!-- 페이지 처리 시작-->
		<div class="container">
			<ul class="pager">
				<li class="previous"><a href="#">Previous</a></li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li class="next"><a href="#">Next</a></li>
			</ul>
		</div>
		<!-- 페이지 처리 끝 -->
		
		  <!-- 링크 -->
        <br> <br> <br>
        <nav class="navbar navbar-default">
		<div class="container">
			<div class="navbar-header">
				<strong><a class="navbar-brand" href="#">BOOKOO</a></strong>
			</div>
			<ul class="nav navbar-nav">
				<li><a
					href="http://www.yes24.com">YES24</a></li>
				<li><a
					href="http://www.aladin.co.kr">알라딘</a></li>
				<li><a
					href="http://www.kyobobook.co.kr">교보문고</a></li>
				<li><a
					href="http://bsearch.interpark.com">인터파크</a></li>
			</ul>
		</div>
	</nav>
   
    <!-- 링크끝 -->
    <!-- container 끝-->
    <br>
    <br>
    <br>

    <!-- footer 시작 -->
    <jsp:include page="footer.jsp"></jsp:include>
	</div>
	<!-- 컨텐츠 끝 -->

</body>
</html>