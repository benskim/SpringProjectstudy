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
	$('.btn-success').click(function(){
		history.back();
	});
});
</script>
</head>
<body>
  <div class="row">
    <h3>성적등록</h3>
     <form action="insert_ok.do" method="post">
    
    <table class="table">
     
      <tr>
       <td width=20% class="text-cetner">이름</td>
       <td width=80%>
        <input type=text name="name" size=15 class="input">
       </td>
     </tr><tr>
       <td width=20% class="text-cetner">전공</td>
       <td width=80%>
				<select name=subject>
					<option>computer</option>
					<option>statics</option>
					<option>economics</option>
					<option>korean</option>
				   <option>math</option>
				</select>
       </td>
     </tr><tr>
       <td width=20% class="text-cetner">국어</td>
       <td width=80%>
        <input type=text name="kor" size=15 class="input">
       </td>
      </tr><tr>
       <td width=20% class="text-cetner">영어</td>
       <td width=80%>
        <input type=text name="eng" size=15 class="input">
       </td>
       </tr><tr>
       <td width=20% class="text-cetner">수학</td>
       <td width=80%>
        <input type=text name="math" size=15 class="input">
       </td>
       </tr><tr>
       <td width=20% class="text-cetner">국사</td>
       <td width=80%>
        <input type=text name="history" size=15 class="input">
       </td>
       </tr><tr>
       <td width=20% class="text-cetner">물리</td>
       <td width=80%>
        <input type=text name="phy" size=15 class="input">
       </td>
       </tr><tr>
       <td width=20% class="text-cetner">화학</td>
       <td width=80%>
        <input type=text name="chem" size=15 class="input">
       </td>
      </tr>
     
       <tr>
        <td colspan="2" class="text-center">
      		<input type=submit value="등록" class="btn btn-info">
      		<input type=button value="취소" class="btn btn-success">  
        </td>
       </tr>
      
    </table>
     </form>
    
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


  </div>
</body>
</html>






