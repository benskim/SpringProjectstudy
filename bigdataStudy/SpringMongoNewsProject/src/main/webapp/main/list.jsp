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
var i=0;
$(function(){
	$('.btn-news').click(function(){
		var value=$(this).attr("value");
		if(i==0)
		{
			$('#m'+value).show();
			i=1;
		}
		else
		{
			$('#m'+value).hide();
			i=0;
		}
	});
});
</script>
</head>
<body>
  <div class="row">
    <%-- <%= application.getRealPath("/") %>  --%>
    <h3>네이버 뉴스</h3>
    <table class="table">
      <tr>
       <td class="text-left">
        <form action="list.do" method="post">
        검색:<input type=text name="data" size=15
              class="input">
           <input type=submit value="검색"
             class="input btn-success">
         </form>
       </td>
      </tr>
    </table>
    <table class="table">
      <c:forEach var="vo" items="${list }" varStatus="s">
        <tr>
          <th class="btn-news btn" value="${s.index }">
          ${vo.title }
          </th>
        </tr>
        <tr id="m${s.index }" style="display:none">
           <td class="text-left" valign="top">
              <a href="${vo.link }">${vo.description }</a>
           </td>
        </tr>
      </c:forEach>
    </table>
    <table class="table">
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
    </table>
  </div>
</body>
</html>






