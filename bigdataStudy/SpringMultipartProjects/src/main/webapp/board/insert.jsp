<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<script type="text/javascript">
var fileIndex=0;
$(function(){
	$('#addBtn').click(function(){
		$('#insert_file').append(
		   '<tr id=f'+fileIndex+'>'
		   +'<td width=15%>파일'+(fileIndex+1)+'</td>'
		   +'<td width=85% align=left>'
		   +'<input type=file name=files['+fileIndex+'] size=25>'
		   +'</td></tr>'
		);
		fileIndex=fileIndex+1;
	});
	$('#removeBtn').click(function(){
		if(fileIndex>0)
		{
		 $('#f'+(fileIndex-1)).remove();
		 fileIndex=fileIndex-1;
		}
	});
});
</script>
</head>
<body>
  <div class="row">
     <h3>글쓰기</h3>
     <form:form method="post" action="insert_ok.do"
       modelAttribute="uploadForm"
       enctype="multipart/form-data"
      >
     <table class="table">
       <tr>
          <td width=15% align=right>이름</td>
          <td width=85% align=left>
             <input type=text name=name size=15>
          </td>
       </tr>
       <tr>
          <td width=15% align=right>제목</td>
          <td width=85% align=left>
             <input type=text name=subject size=45>
          </td>
       </tr>
       <tr>
          <td width=15% align=right>내용</td>
          <td width=85% align=left>
             <textarea rows="5" cols="55" name=content></textarea>
          </td>
       </tr>
       <tr>
          <td width=15% align=right>첨부파일</td>
          <td width=85% align=left>
             <table class="table" id="file_view">
                 <tr>
                     <td colspan="2" align=right>
                     <input type=button value="추가" class="btn-info" id="addBtn">
                     <input type=button value="삭제" class="btn-primary" id="removeBtn">
                     </td>
                 </tr>
             </table>
             <table class="table" id="insert_file">
             
             </table>
          </td>
       </tr>
       <tr>
          <td width=15% align=right>비밀번호</td>
          <td width=85% align=left>
             <input type=password name=pwd size=10>
          </td>
       </tr>
       <tr>
           <td colspan="2"
               align=center>
               <input type=submit value=글쓰기 class="btn-success"> 
               <input type=button value="취소" class="btn-warning"> 
           </td>
       </tr>
     </table>
     </form:form>
  </div>
</body>
</html>










