<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <script src="../js/jquery.serializejson.min.js"></script>
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=East+Sea+Dokdo&display=swap" rel="stylesheet">
  
<style type="text/css">
#cont div{
	margin-top: 200px;
  	background-color: #333333;
	text-align: center;
	color: white;
	padding: 5px;
	font-family: 'East Sea Dokdo', cursive;
	font-size: 2.0em;
  }
  
.row div{
  	border : 1px solid lightgray;
}
  
 #movieList{
 	text-align: center;
 	padding: 0px;
 }
 
#inrow{
	border: 0px;
}

.list-group-item.active{
	background-color: #dc3545;
    border-color: #dc3545
}

#date{

	padding : 10px;
	text-align: center;
	font-weight: bold;
	border: 2px solid lightgray;
	border-radius:20px;
	margin-top:10px; 
	margin-bottom:10px; 
	
}
#month{
	font-size: 2.0em;
}
#year{
	font-size: 1.5em;
	color: gray;
}

#theather_div{
	border: 0px;
}
/* 스크롤 바 */
#inrow>div, 
#movieList
{
	padding: 0px;
	overflow: auto;
	height: 445px;
}
#inrow>div::-webkit-scrollbar,
#movieList::-webkit-scrollbar
{
	width: 5px;
}

#inrow>div::-webkit-scrollbar-thumb,
#movieList::-webkit-scrollbar-thumb
{
    background-color: lightgray;
    border-radius: 10px;
}
 
#img{
	margin-left : 10px;
	margin-bottom: 3px;
}

</style>

<script type="text/javascript">
$(function() {
	$('#movieList a').on('click', function() {
		$('#movieList a').removeClass('active');
		$(this).addClass('active')
	})

	$('#theather a').on('click', function() {
		$('#theather a').removeClass('active');
		$(this).addClass('active')
	})

	$('#thlist a').on('click', function() {
		$('#thlist a').removeClass('active');
		$(this).addClass('active')
	})
})
</script>

</head>
<body>

<!-- 네비게이션 바 -->
<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
  <!-- Brand -->
  <a class="navbar-brand" href="#">CGBOX</a>

  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="#">영화</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">극장</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">예매</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">스토어</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">이벤트</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">헤택</a>
    </li>


  </ul>
</nav>

<!-- ///////////////////////////////////////////////////////////// -->
<div class="container">

	<div class="row" id="cont">
	  <div class="col-sm-3">
	  	영화
	  </div>
	  
	  <div class="col-sm-3">
	  	극장
	  </div>
	  
	  <div class="col-sm-2">
	  	날짜
	  </div>
	  
	  <div class="col-sm-4">
	  	시간
	  </div>
	</div>
	
	<div class="row">
	  <div id="movieList" class="col-sm-3 list-group list-group-flush">
	  	<!-- DB에 저장되어있는 영화 번호(MOVIE_NO)를 의미한다 -->
	  		<a id="movie1" href="#" class="list-group-item list-group-item-action" >신기한 동물과 덤블도어의 비밀</a>
	  		<a id="movie2" href="#" class="list-group-item list-group-item-action" >세븐틴파워오브러브-더무비</a>
	  		<a id="movie3" href="#" class="list-group-item list-group-item-action" >앵커</a>
	  		<a id="movie3" href="#" class="list-group-item list-group-item-action" >앵커123</a>
	  		<a id="movie3" href="#" class="list-group-item list-group-item-action" >앵커132</a>
	  		<a id="movie3" href="#" class="list-group-item list-group-item-action" >앵커432</a>
	  		<a id="movie3" href="#" class="list-group-item list-group-item-action" >앵커1</a>
	  		<a id="movie3" href="#" class="list-group-item list-group-item-action" >앵커2</a>
	  		<a id="movie3" href="#" class="list-group-item list-group-item-action" >앵커3</a>
	  		<a id="movie3" href="#" class="list-group-item list-group-item-action" >앵커4</a>
	  		<a id="movie3" href="#" class="list-group-item list-group-item-action" >앵커6</a>
	  		<a id="movie3" href="#" class="list-group-item list-group-item-action" >앵커5</a>
	  </div>
	  
	  <div id="theather_div" class="col-sm-3">
	  	<!-- 극장 리스트 -->
	  	
	  	  	<!-- 지역리스트 -->
	  	  	<div id="inrow" class="row">
	  	  	
	  	  		
	  	  		<div class="theather col-sm-6 list-group list-group-flush">
	  	  			<a href="#" class="list-group-item list-group-item-action active">대전 
	  	  			<img id="img" src="https://img.icons8.com/fluency-systems-filled/15/ffffff/double-right.png"/>
	  	  			</a>
	  	  			
		  	  	</div>
	  	  		
	  	  		
	  	  		
	  	  		<div id="thlist" class="theather col-sm-6 list-group list-group-flush">
	  	  			<a href="#" class="list-group-item list-group-item-action">강남</a>
	  	  			<a href="#" class="list-group-item list-group-item-action">강서</a>
	  	  			<a href="#" class="list-group-item list-group-item-action">강북</a>
	  	  			<a href="#" class="list-group-item list-group-item-action">강남</a>
	  	  			<a href="#" class="list-group-item list-group-item-action">강서</a>
	  	  			<a href="#" class="list-group-item list-group-item-action">강북</a>
	  	  			<a href="#" class="list-group-item list-group-item-action">강남</a>
	  	  			<a href="#" class="list-group-item list-group-item-action">강서</a>
	  	  			<a href="#" class="list-group-item list-group-item-action">강북</a>
	  	  			<a href="#" class="list-group-item list-group-item-action">강남</a>
	  	  			<a href="#" class="list-group-item list-group-item-action">강서</a>
	  	  			<a href="#" class="list-group-item list-group-item-action">강북</a>
	  	  			<a href="#" class="list-group-item list-group-item-action">강남</a>
	  	  			<a href="#" class="list-group-item list-group-item-action">강서</a>
	  	  			<a href="#" class="list-group-item list-group-item-action">강북</a>
	  	  			<a href="#" class="list-group-item list-group-item-action">강남</a>
	  	  			<a href="#" class="list-group-item list-group-item-action">강서</a>
	  	  			<a href="#" class="list-group-item list-group-item-action">강북</a>
	  	  		</div>
				
				
	  	  	</div>
	  	  	
	  </div>
	  
	  <div class="col-sm-2">
	  	<div id="date" class="container">
	  		<span id="year">2022</span>
	  		<br>
	  		<span id="month">04</span>
	  	</div>
	  	<!-- 날짜 리스트 -->
	  	
	  	<!-- 
	  	
	  	<div id="dayList" class="col-sm-3 list-group list-group-flush">
	  		<a href="#" class="list-group-item list-group-item-action">강서</a>
	  	</div> 
	  	
	  	-->
	  	
	  </div>
	  
	  <div class="col-sm-4">
	  	영화 시간대별 리스트
	  </div>
	</div>

	<div class="row">
		<!-- <div class="col">
			예매 정보 출력용 div
		</div> -->
	</div>
</div>

</body>
</html>