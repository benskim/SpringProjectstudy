<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
<style type="text/css">
.row{
     margin: 0px auto;
     width: 600px;
}
</style>
</head>
<body>
	<div class="row">
		<table class="table">
			<tr>
				<td class="info">이름</td>
				<td width=30%>${vo.name }</td>
				<td class="warning"></td>
				<td width=30%>${vo.regdate }</td>
				<td class="success"></td>
				<td width=30%>${vo.hit }</td>
				
			</tr>
			<tr>
				<td width=20%>제목</td>
				<td colspan=5>${vo.subject }</td>
			</tr>
			<c:if test="">
				<tr>
					<td width=20%>첨부파일</td>
					<td colspan="3">
						<ul style="list-style-type: none">
						<!--  delim: stringToken !!!-->
							<c:forEach var="fn" items="${vo.filename }" delims=",">
								<li>${fn }</li>
							</c:forEach>
						</ul>
					</td>
				</tr>
			</c:if>
			
			<tr>
				<td colspan="6" valign="top" align="left"  height=100>
				</td>
			</tr>
		</table> 
	</div>
</body>
</html>