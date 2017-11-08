<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<style type="text/css">
.row{
     margin: 0px auto;
     width: 600px;
}
</style>
</head>
<body>
  <div class="row">
  <h3>내용보기</h3>
    <table class="table table-hover">
      <tr>
        <td>
          <a href="insert.do" class="btn btn-success">새글</a>
        </td>
      </tr>
    </table>
    <table class="table table-hover">
      <thead>
         <tr>
            <th width=10%>no</th>
            <th width=45%>subject</th>
            <th width=15%>name</th>
            <th width=20%>date</th>
            <th width=10%>hit</th>
         </tr>
      </thead>
      <tbody>
         <c:forEach var="vo" items="${list }">
            <tr>
               <td width=10% class="text-center">${vo.no }</td>
               <td width=45%>
                 <a href="content.do?no=${vo.no }">${vo.subject }</a>
               </td>
               <td width=15% class="text-center">${vo.name }</td>
               <td width=20% class="text-center">${vo.regdate }</td>
               <td width=10% class="text-center">${vo.hit }</td>
            </tr>
         </c:forEach>
      </tbody>
    </table>
  </div>
</body>
</html>





