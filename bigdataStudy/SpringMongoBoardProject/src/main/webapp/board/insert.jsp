<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
     <h3>글쓰기</h3>
     <form method=post action="insert_ok.do">
     <table class="table" width=600>
       <tr>
          <td width=15% class="text-right">이름</td>
          <td width=85% class="text-left">
         
             <input type=text class="input" size=12 name=name>
          </td>
       </tr>
       <tr>
          <td width=15% class="text-right">제목</td>
          <td width=85% class="text-left">
             <input type=text class="input" size=40 name=subject>
          </td>
       </tr>
       <tr>
          <td width=15% class="text-right">내용</td>
          <td width=85% class="text-left">
             <textarea rows="7" cols="45" name=content></textarea>
          </td>
       </tr>
       <tr>
          <td width=15% class="text-right">비밀번호</td>
          <td width=85% class="text-left">
             <input type=password class="input" size=10 name=pwd>
          </td>
       </tr>
       <tr>
          <td colspan="2" class="text-center">
             <input type=submit value="글쓰기" class="button btn-success">
             <input type=button value="취소" class="button btn-warning"
                onclick="javascript:history.back()">
          </td>
       </tr>
     </table>
     </form>
   </div>
</body>
</html>







