<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/bootstrap-theme.min.css">
<style type="text/css">
/*
   섹션 나눈 것 확인 용
   div{
      border:1px solid #ccc;
   } */
   #twt_box{
      border:1px solid #ccc;
      height: 200px;
   } 
   .list_info {
      border-top:1px solid #ccc;
      padding-top:0.9em;
      background-color: #ddd;
      margin-bottom: 1em;
   } 
   .list_order li{
      display: inline;
      margin-right:5px;
   }
   .list_info > .col-lg-7{ 
      padding-left:0px;
   }
   .writer_info > div{
      height:230px;
      margin-top:5px;
   }
   .writer_info > .col-lg-2{
      text-align: center;
   }

   .writer_img_200{
      max-width:200px; 
      height:200px;       
      overflow: hidden; 
   }
   .writer_img_200 > img{
     
      height:100%;
      overflow: hidden;
   }
   .writer_info > .col-lg-7{
      padding:0;
   }
   .book_img_120{
      padding:0px; 
      margin-left:2%;
      max-width: 120px;
      max-height:260px;    
      overflow: hidden;
      float: left;
   }
   .book_img_120 > img{
      width:100%;
      height:200px;
      overflow: hidden;
      
   }
   
   .book_img_120 > span{
   		 height:50px;
   }
    .writer_detail_intro{
    	background-color:#EEEEEE;
    	
   		margin:5%;
   		padding:1%;
   }

</style>

<script type="text/javascript">
var i=0;
    $(function(){
        $('.writer_intro_btn').click(function(){
            var value=$(this).attr("value");
            if(i==0){
                $('#m'+value).show();
                i=1;
            }else{
                $('#m'+value).hide();
                i=0;
            }
        });
    });
    
</script>


<style type="text/css">
@import 'https://code.highcharts.com/css/highcharts.css';

#chart_container {
	height: 400px;
	max-width: 800px;
	margin: 0 auto;
}

/* Link the series colors to axis colors */
.highcharts-color-0 {
	fill: #7cb5ec;
	stroke: #7cb5ec;
}
.highcharts-axis.highcharts-color-0 .highcharts-axis-line {
	stroke: #7cb5ec;
}
.highcharts-axis.highcharts-color-0 text {
	fill: #7cb5ec;
}
.highcharts-color-1 {
	fill: #90ed7d;
	stroke: #90ed7d;
}
.highcharts-axis.highcharts-color-1 .highcharts-axis-line {
	stroke: #90ed7d;
}
.highcharts-axis.highcharts-color-1 text {
	fill: #90ed7d;
}


.highcharts-yaxis .highcharts-axis-line {
	stroke-width: 2px;
}

</style>
</head>
<body><!-- 저자 서재 default -->


   <div class="container"> 
      
      <jsp:include page="header.jsp"></jsp:include>
    
       
   </div>   
 
   <br>
  	<div class="row">
 	 <div id="chart_container"></div>

 	</div>
 
 <script src="https://code.highcharts.com/js/highcharts.js"></script>
<script src="https://code.highcharts.com/js/modules/exporting.js"></script>
<script type="text/javascript">
Highcharts.chart('chart_container', {

    chart: {
        type: 'column'
    },

    title: {
        text: '주간 판매순 작가 TOP10'
    },

    yAxis: [{
        className: 'highcharts-color-0',
        title: {
            text: '출간 (권)'
        }
    }, {
        className: 'highcharts-color-1',
        opposite: true,
        title: {
            text: '누적 판매 (권)'
        }
    }],

    plotOptions: {
        column: {
            borderRadius: 5
        }
    },

    series: [{
        data: [35, 36, 78, 40, 11, 29, 35, 174, 63, 137]
    }, {
        data: [1400, 111, 31, 31, 27, 26, 25, 25,  	25, 24],
        yAxis: 1
    }]

});

</script>
 
   <!-- 저자 & 저서 리스트 start-->    
   <div class="container" style="margin-top:50px;">
      <!-- 정렬 기준 선택-->
      <div class="row list_info">
         <div class="col-lg-7">
            <ul class="list_order">
               <li><a href="writer.do">누적 판매순</a>&nbsp;&nbsp;|</li>
               <li><a href="writer_week.do">주간 판매순</a>&nbsp;&nbsp; </li>
              
            </ul>    
         </div>
         <div class="col-lg-5" align="right">
            2003년 1월 이후 인터파크 판매량 기준(매주 월요일 결산)
         </div>
      </div>
    
  

			<!-- 리스트 작가+저서 -->
			      
			      <c:forEach var="wvo" items="${wwlist }" varStatus="wrt">
			      <c:if test="${wrt.index lt 10}">
			      <div class="row writer_info">
			         <!-- 작가 사진 -->
			         <div class="col-lg-2">
			            <a href="#"> 
			            <div class="writer_img_200">                   
			               <img src="${wvo.wwpic }">          
			            </div>
			            </a>
			          
			           <button class="btn btn-md writer_intro_btn" value="${wrt.index }" style="margin-top:2%">작가 소개 <font color="red">▼</font></button>
			
			         </div>
			         <!-- 작가 정보 -->
			         <div class="col-lg-3">
			            <table>
			               <tr>
			                  <th colspan="2">${wvo.wwname }</th>
			               </tr>
			           
			               <tr>
			                  <td>출간도서 : </td>
			                  <td> ${wvo.wwpubbs }권</td>
			               </tr>
			               <tr>
			                  <td>주간판매 : </td>
			                  <td> ${wvo.wwweek }권</td>
			               </tr>
			            </table>
			         </div>
			         <!-- 책 목록 이미지 -->
			         
			         <div class="col-lg-7 writer_books">
			            <a href="detail.do?${wvo.wwbisbn1 }">
			               <div class="book_img_120">
			                  <img src="${wvo.wwbimg1 }">
			                  <br><span>${wvo.wwbtitle1 }</span>
			               </div>
			            </a>
			            <a href="detail.do?${wvo.wwbisbn2 }">
			               <div class="book_img_120">
			                  <img src="${wvo.wwbimg2 }">
			                  <br><span>${wvo.wwbtitle2 }</span>
			               </div>
			            </a>
			            <a href="detail.do?${wvo.wwbisbn3 }">
			               <div class="book_img_120">
			                  <img src="${wvo.wwbimg3 }">
			                  <br><span>${wvo.wwbtitle3 }</span>
			               </div>
			            </a>
			            <a href="detail.do?${wvo.wwbisbn4 }">
			               <div class="book_img_120">
			                  <img src="${wvo.wwbimg4 }">
			                  <br><span>${wvo.wwbtitle4 }</span>
			               </div>
			            </a>
			           <a href="detail.do?${wvo.wwbisbn5 }">
			               <div class="book_img_120">
			                  <img src="${wvo.wwbimg5 }">
			                  <br><span>${wvo.wwbtitle5 }</span>
			               </div>
			            </a>
			         </div>
			      </div>
			         <div class="col-12-lg writer_detail_intro" id="m${wrt.index }" style="display:none">         
			             ${wvo.wwintro }
			         </div>
			     <hr style="margin-top:40px;">
			      </c:if>
			     </c:forEach>
    			
		
        </div>
       							

    <div class="container">     
    
     <jsp:include page="footer.jsp"></jsp:include>
 
   </div> <!-- 저자 & 저서 리스트 end--> 
  
  
       
</body>
</html>