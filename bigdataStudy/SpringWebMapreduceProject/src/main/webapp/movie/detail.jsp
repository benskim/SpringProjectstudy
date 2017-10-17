<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>Movie Center</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<style type="text/css">
.row {
	margin: 0px auto;
}


</style>
</head>
<body>
	<%-- <%=application.getRealPath("/") %> 
 /home/sist/bigdataDev/bigdataStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/SpringWebMapreduceProject/ 
--%>
	<div class=container>
		<div class=row>
			<h3>[상세보기] ${vo.title }</h3>
			<table class="table table-hover" width=600>
				<tr>
					<td width=40% class=text-center rowspan=6><img
						src="${vo.poster }" width=240 height=350></td>
					<td colspan=2 class="text-center success" style="font-size: x-large;">${vo.title }
					</td>
				</tr>
				<tr>
					<td width=20% class=text-center>감독</td>
					<td width=40%>${vo.director }</td>
				</tr>
				<tr>
					<td width=20% class=text-center>배우</td>
					<td width=40%>${vo.actor }</td>
				</tr>
				<tr>
					<td width=20% class=text-center>장르</td>
					<td width=40%>${vo.genre }</td>
				</tr>
				<tr>
					<td width=20% class=text-center>등급</td>
					<td width=40%>${vo.grade }</td>
				</tr>
				<tr>
					<td width=20% class=text-center>예매율</td>
					<td width=40%>${vo.reserve }%</td>
				</tr>
				<tr>
					<td colspan=4 class=text-right><input
						class="button btn-success" type="button" value="추천"> <input
						class="button btn-warning" type="button" value="목록"
						onclick="javascript:history.back()"></td>
				</tr>
			</table>
		</div>
		<div class=row>

			<!-- <div lass=col-lg-6> -->
			<center>
			<table> 
				<tr>
					<td>
						<h3>[후기]감성분석결과</h3> <img src="feel.png">
					</td>
					<td>
						<h3>[댓글]연관어휘</h3> <img src="wordcloud.png" >
					</td>
				</tr>
			</table>
			</center>
			<!-- 	<h3>감성분석결과</h3>
					<img src="feel.png">
					<img src="wordcloud.png">
				</div>
				<div lass=col-lg-6>
					<h3>연관어휘</h3> -->

			<!-- </div> -->

		</div>
	</div>
</body>
</html>