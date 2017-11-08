<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <center>
  <table border=1 width=600 height=500>
    <tr>
      <td height=100 colspan="2">
       <tiles:insertAttribute name="header"/>
      </td>
    </tr>
    <tr>
      <td height=300 width=200>
        <tiles:insertAttribute name="menu"/>
      </td>
      <td height=300 width=400>
        <tiles:insertAttribute name="body"/>
      </td>
    </tr>
    <tr>
      <td height=100 colspan="2">
         <tiles:insertAttribute name="footer"/>
      </td>
    </tr>
  </table>
  </center>
</body>
</html>