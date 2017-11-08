<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
<script type="text/javascript" src="../js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<style type="text/css">
 .jumbotron{
    margin-top:10px;
    background: #636363;
    color: white;
    padding-bottom: 0px;
}
.myrow{
	width:80%;
	margin: 0px auto;
}
</style>
<script type="text/javascript">
$(function(){
	$.ajax({
		type:'post',
		url:'graph.do',
		success:function(response){
			$('.jumbotron').html(response);
		}
	});
});
</script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="jumbotron">
				
			</div>
		</div>
	</div>
	<div class="container">
	<div class="row myrow">
		<table class="table">
			<tr>
				<th>순위</th>
				<th>변경</th>
				<th></th>
				<th>노래명</th>
				<th>가수명</th>
				<th></th>
			</tr>
			<c:forEach var="vo" items="${list }">
			<tr>
				<td>${vo.rank }</td>
				<td>
					<c:choose>
						<c:when test="${vo.status=='상승' }">
							<font color="blue">▲&nbsp;${vo.idIncrement }</font>
						</c:when>
						<c:when test="${vo.status=='하강' }">
							<font color="red">▼&nbsp;${vo.idIncrement }</font>
						</c:when>
						<c:otherwise>-</c:otherwise>
					</c:choose>
				</td>
				<td>
					<img src="${vo.poster }" width=50 height=50>
				</td>
				<td>${vo.title }</td>
				<td>${vo.singer }</td>
				<td>
					<a href="#" class="btn btn-warning btn-sm">듣기</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>