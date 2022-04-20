<%@page import="java.util.List"%>
<%@page import="vo.TicketVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비회원 예매내역 확인</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <script src="../js/jquery.serializejson.min.js"></script>

<style type="text/css">


nav{
	background: rgb(220,53,69);
	background: linear-gradient(90deg, rgba(220,53,69,1) 0%, rgba(220,53,69,1) 29%, rgba(255,66,0,1) 100%);
}

.container{
	margin-top: 100px;
}


h1{
	font-weight: bold;
	text-align: center;

}

.container h1{
	color: white;
}
.row{
 	border: 1px solid lightgray;
 }
 img{
 	width: 150px;
 	height: 300px;
 	margin: 10px;
 }
 
.tittle{
	padding-top : 20px;
	padding-bottom : 20px;
	font-size : 2.0em;
	text-align: center;
	color: black;
	vertical-align: middle;
	font-weight:bold;
	border-radius: 0.25rem;
	/* border: 1px solid blue; */
	
	
background: #D3CCE3;  /* fallback for old browsers */
background: -webkit-linear-gradient(to right, #E9E4F0, #D3CCE3);  /* Chrome 10-25, Safari 5.1-6 */
background: linear-gradient(to right, #E9E4F0, #D3CCE3); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
	

}
.card{
	margin: 0px auto;
	box-shadow: rgba(0, 0, 0, 0.25) 0px 14px 28px, rgba(0, 0, 0, 0.22) 0px 10px 10px;
	
	
}



</style>


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






 	<!-- 
 	<div class="container" style="margin-top: 300px; text-align: center;">
		<img src="https://img.icons8.com/glyph-neue/300/dc3545/xbox-x.png" style="margin-bottom: 50px;"/>
		
		<h1>예매내역이 존재하지 않거나<br> 확인할 수 없습니다</h1>
	</div>  
	-->







<div class="container">
	<h1>202220님의 예매정보</h1>
	<br>
	<!-- <div class="ticket">
		<h3>스타워즈 깨어난 포스(IMAX)</h3><br>
		<p>CGBOX 대전터미널점</p>
		<p>3관</p>
		<hr>
		<p>2022.04.01(월)</p>
		<p>09:00 ~ 10:00</p>
		<hr>
		<div class="row">
			<div class="col">
				A3, B3
			</div>
			<div class="col">
				예약중
			</div>
		</div>
		
	</div> -->
		
  <div class="card " style="width:500px">
  	<div class="tittle">덤블도어와 신비한 뭐시기</div>
    <img class="card-img-top" src="../image/영화포스터샘플2.jpg" alt="영화포스터" style="width:96%;object-fit: cover;">
    <div class="card-body">
      <h4 class="card-title">CGBOX 대전터미널점</h4>
      <p class="card-text">
      	<span>3관</span>&nbsp;&nbsp;|&nbsp;&nbsp;<span>2022.04.01(월)</span>&nbsp;&nbsp;|&nbsp;&nbsp;<span>09:00 ~ 10:00</span>
      </p>
      <hr>
      <p class="card-text">A3, B3</p>
   		<!--    
   	  <div class="btn-group btn-block">
	    <button type="button" class="btn btn-success">결제 하기</button>
	    <button type="button" class="btn btn-danger">예매 취소</button>

	  </div>
	   -->
	
	  <div class="btn-group btn-block">
	    <button type="button" class="btn btn-outline-success" disabled>결제 완료</button>
	    <button type="button" class="btn btn-danger">예매 취소</button>
	  </div> 
	  
	
    
    </div>
  </div>
	
	
	


</div>



</body>
</html>