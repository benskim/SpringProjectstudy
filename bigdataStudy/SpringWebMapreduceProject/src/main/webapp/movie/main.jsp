<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>Movie Center</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<style type="text/css">
.row{
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
	<center>
	  <h2>영화정보공유</h2>
	</center>
		<table class=table table-hover>
			<tr>
				<c:forEach var="vo" items="${list}">
					<td>
					<a href="detail.do?mno=${vo.mno }">
					<img alt="aa" src="${vo.poster }" width=150 height="200">
					</a>
					</td>					
				</c:forEach>				
			</tr>	
			<tr>
				<c:forEach var="vo" items="${list}">
					<td class="success text-center">
					${vo.title}
					</td>					
				</c:forEach>				
			</tr>			
		</table>
	</div>
	<div class=row>
	 <div class=col-lg-6>
	 <h3>예매 점유율
	 </h3>
	 <hr/>
	 <img alt="" src="reserve.png">
	 
	 </div>
	 <div class=col-lg-6>
	 	<table class=table>
	 	   <h3>이시각 영화뉴스!</h3>
	 		<c:forEach var="vo" items="${nlist }" varStatus="s"><!--index num-->
	 			<c:if test="${s.index<5 }">
	 			<tr>
	 				<td>${vo.title }</td>
	 				</tr>
	 				<tr>
	 				<td class=danger>${vo.description }
	 				</td>
	 			</tr>
	 			</c:if>
	 		</c:forEach>
	 	</table>
	 </div>
	 
	</div>
</div>
</body>
</html>