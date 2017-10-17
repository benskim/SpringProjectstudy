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
<script type="text/javascript">

</script>
</head>
<body>
  <div class="row">
        
    <h3>성적표 목록</h3>
    <table class="table">
      <tr>
        <td align=text-left>
           <a href=insert.do class="btn btn-info">등록</a>
        </td>
        </tr>
        </table>
    
    <table class="table">
      <tr>
       	<th>학번</th>
       	<th>이름</th>
       	<th>전공</th>
       	<th>국어</th>
       	<th>영어</th>
       	<th>수학</th>
       	<th>국사</th>
       	<th>물리</th>
       	<th>화학</th>
       	<th>총점</th>
       	<th>평균</th>
       	<th>석차</th>
       </tr>
      <c:forEach var="vo" items="${list }" varStatus="s">
        <tr>
          <td class="btn-news btn" value="${s.index }">
          ${vo.hakbun }
          </td>
          <td>     ${vo.name }       </td>
          <td>     ${vo.subject }       </td>
          <td>     ${vo.kor }       </td>
          <td>     ${vo.eng }       </td>
          <td>     ${vo.math }       </td>
          <td>     ${vo.history }       </td>
          <td>     ${vo.phy }       </td>
          <td>     ${vo.chem }       </td>
          <td>     ${vo.total }       </td>
          <td>     ${vo.avg }       </td>
          <td>     ${vo.rank }       </td>
        </tr>
      </c:forEach>
    </table>
 <!--    <table class="table">
      <tr>
        <td align=right>
          <a href="list.do?data=${data }&page=${curpage>1?curpage-1:curpage}" class="btn btn-info">이전</a>&nbsp;
          <a href="list.do?data=${data }&page=${curpage<totalpage?curpage+1:curpage}" class="btn btn-warning">다음</a>
          &nbsp;&nbsp;
          ${curpage } page / ${totalpage } pages
        </td>
      </tr>
    </table>
    <table class="table">
      <tr>
        <td class="text-center">
          <img src="news.png">
        </td>
      </tr>
    </table> -->
  </div>
</body>
</html>






