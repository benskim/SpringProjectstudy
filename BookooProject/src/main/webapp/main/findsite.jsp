<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="padding-right: 300px;">
	<!-- 
String URL = "www.myhome.com/";

String subURL = "한글값";

String thirdURL = "/index";


sbuURL =  URLEncoder.encode(subURL, "UTF-8");


URL = URL + subURL + thirdURL;


 -->
 
	<jsp:include page="header.jsp"></jsp:include>
	<br><br><br><br>
	
	<h3 style="text-align: center;">" ${serch } "에서 " ${sbuURL } " 검색결과 입니다.</h3>
	
	<br><br>
	<div class="container">
		<iframe
			src="${fs }"
			style="width: 1500px; height: 1000px; "> </iframe>
	</div>
	
	<br><br>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>