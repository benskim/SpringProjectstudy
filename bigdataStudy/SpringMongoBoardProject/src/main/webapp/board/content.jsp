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
     <h3>내용보기</h3>
     <table class="table" width=600>
        <tr>
           <td width=20% class="text-center">번호</td>
           <td width=30% class="text-center">${vo.no }</td>
           <td width=20% class="text-center">작성일</td>
           <td width=30% class="text-center">${vo.regdate }</td>
        </tr>
        <tr>
           <td width=20% class="text-center">이름</td>
           <td width=30% class="text-center">${vo.name }</td>
           <td width=20% class="text-center">조회수</td>
           <td width=30% class="text-center">${vo.hit }</td>
        </tr>
        <tr>
           <td width=20% class="text-center">제목</td>
           <td colspan="3" class="text-left">${vo.subject }</td>
        </tr>
        <tr>
           <td colspan="4" class="text-left" valign="top" height=150>
              ${vo.content }
           </td>
        </tr>
        <tr>
           <td colspan="4" class="text-right">
              <a href="update.do?no=${vo.no }" class="button btn-success btn-sm">수정</a>
              <a href="delete.do" class="button btn-warning btn-sm">삭제</a>
              <a href="list.do" class="button btn-info btn-sm">목록</a>
           </td>
        </tr>
     </table>
   </div>
</body>
</html>





