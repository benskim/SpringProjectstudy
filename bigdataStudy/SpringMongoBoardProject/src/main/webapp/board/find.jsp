<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<style type="text/css">
.row {
   margin: 0px auto;
   width: 600px;
}
h3{
   text-align: center
}
</style>
</head>
<body>
   <div class="row">
      <h3>Search Result</h3>
      <c:if test="${count==0 }">
      <table class="table" width=600>
        <tr>
          <td class=text-center>
              There is no Result 
          </td>
        </tr>
      </table>
      </c:if>
      <c:if test="${count!=0 }">
     <table class="table" width=600>
          <thead>
              <tr>
                  <th width=10%>번호</th>
                  <th width=45%>제목</th>
                  <th width=15%>이름</th>
                  <th width=20%>작성일</th>
                  <th width=10%>조회수</th>
              </tr>
          </thead>
             <c:forEach var="vo" items="${list }">
                 <tr>
                      <td width=10%>${vo.no }</td>
                      <td width=45%><a href="content.do?no=${vo.no }">${vo.subject }</a></td>
                      <td width=15%>${vo.name }</td>
                      <td width=20%>${vo.regdate }</td>
                      <td width=10%>${vo.hit }</td>
                 </tr>
             </c:forEach>
             
          <tbody>
              
          </tbody>
     </table> 
     </c:if>
     
     <table class=table width=600>
     <tr>
     	<td class=text-right>
     	  <a href="list.do" class="button btn-sm btn-info">목록</a>
     	   
     	</td>
     </tr>
     
     </table>
     
   </div>
</body>
</html>







