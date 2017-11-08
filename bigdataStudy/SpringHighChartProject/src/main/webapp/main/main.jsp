<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type ="text/javascript">

$(function() {
	$('#graph').change(function() {
		var no = $('#graph').val();
		if (no != -1) {
			$.ajax({
				type : 'post',
				url : 'graph.do',
				data : {
					"no" : no
				},
				success : function(response) {
					$('#print').html(response);
				}
			})
		}
	});
});
</script>
</head>
<body>
<center>
	Search:
	<select id="graph">
	 <option value=-1>choose</option>
	 <option value=0>pieChart</option>
	 <option value=1>barChart</option>
	</select>
	<br>
	<div id="print"></div>
	
</center>
</body>
</html>