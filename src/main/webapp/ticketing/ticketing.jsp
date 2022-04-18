<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <script src="../js/jquery.serializejson.min.js"></script>
  <link href="https://fonts.googleapis.com/css2?family=East+Sea+Dokdo&display=swap" rel="stylesheet">
<title>좌석 예약</title>
<style type="text/css">
nav{
	background: rgb(220,53,69);
	background: linear-gradient(90deg, rgba(220,53,69,1) 0%, rgba(220,53,69,1) 29%, rgba(255,66,0,1) 100%);
}

#cont div{
	margin-top: 200px;
  	background-color: #333333;
	text-align: center;
	color: white;
	padding: 5px;
	font-family: 'East Sea Dokdo', cursive;
	font-size: 2.0em;
  }

#choosen{
	text-align:center;
}

.text{
	color: gray;
}

.page-link{
	font-size: 2.0em;
	font-weight: bold;
}

#timeInfo{
	font-size: 1.3em;
	font-weight: bold;
}

#price{
	font-size: 2.0em;
}

#seatsCont{
	border:1px solid lightgray;
	padding: 20px;
}

#screenDiv{
    text-align: center;
	font-size: 1.5em;
}

.seatKind{
	text-align: right;
}

#seatsDiv .seat{
	text-align: center;
	margin: 3px;
	border: 1px solid gray;
}

.seat:hover{
	background: #dc3545;
	color: white;
}

.select{
	background: #dc3545;
	color: white;
}

#ybtn,
#nbtn{
	width: 74px;
}
</style>
<script type="text/javascript">
$(function() {
	//1표당 기준가격
	var vprice = 8000;
	$('#price span').text(vprice);
	
	//인원수를 체크하여 1이하 8이상인 경우 disabled속성을 추가하는 함수
	function chkcnt() {
		var cnt = parseInt($('span[class="page-link"]').text());
		
		
		//1 이하인경우 
		if(cnt <= 1){
			$('#liDown').addClass('disabled')
		}else{
			$('#liDown').removeClass('disabled')
		}
		
		if(cnt >= 8){
			$('#liUp').addClass('disabled')
		}else{
			$('#liUp').removeClass('disabled')
		}
		
		
		//가격 변경
		$('#price span').text(cnt * vprice);
	}
	
	$('#cntDown').on('click', function() {
		var cnt = parseInt($('span[class="page-link"]').text());
		
		$('span[class="page-link"]').text(cnt - 1);
		
		chkcnt();
	})
	
	$('#cntUp').on('click', function() {
		var cnt = parseInt($('span[class="page-link"]').text());
		
		$('span[class="page-link"]').text(cnt + 1);
		
		chkcnt();
	})
	
	
	
	
	
	$('.seat').on('click', function() {
		if($(this).hasClass('select')){
			$('#minfo').text('이미 선택한 좌석입니다!');
			$("#overModal").modal();
		}

		$(this).addClass('select');
		
		if($('.select').length >  parseInt($('span[class="page-link"]').text())){
			$(this).removeClass('select');
			$('#minfo').text('선택한 인원 수 이상으로 선택하셨습니다!');
			$("#overModal").modal();
		}
		
	})
	
	
	//다시 선택 -> 예 클릭시
	$('#ybtn').on('click', function() {
		$('.seat').removeClass('select');
		
	})
})
</script>
</head>
<body>
	
<!-- 네비게이션 바 -->
<nav class="navbar navbar-expand-sm navbar-dark fixed-top">
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
      <a class="nav-link" href="#" style="font-weight : bold; color: white">예매</a>
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

<!-- //////////////////////////////////////////////////////////////////////////// -->

<div class="container">
	<div class="row" id="cont">
	  <div class="col">
	  	인원/좌석
	  </div>
	</div>
	<div class="row">
	  	<div id="choosenCnt" class="container p-3 my-3 border col-sm-6">
	  		<span class="text"> 
	  			예매 할 인원 수를 선택해 주세요
	  			<br>
	  			<span style="color: red; font-size:13px;">*최대 8명까지 선택가능</span>
	  		</span>
	  		<hr>
	  		<ul class="pagination pagination-lg justify-content-center">
			  <li id="liDown" class="page-item disabled">
			  	<a id="cntDown" class="page-link" href="#">
					-
			  	</a>
			  </li>
			  <li class="page-item active">
			  	<span class="page-link">1</span>
			  </li>
			  <li id="liUp" class="page-item">
			  	<a id="cntUp" class="page-link" href="#">
					+
			  	</a>
			  </li>
			</ul>
	  	</div>
	  <div class="container p-3 my-3 border col-sm-6">
		<div class="col">
			<ul class="breadcrumb justify-content-center">
  				<li class="breadcrumb-item active">CGBOX <%=session.getAttribute("mtheaterName") %>점</li>
  				<li class="breadcrumb-item active"><%=session.getAttribute("theaterNo") %>관</li>
  				<li class="breadcrumb-item active">남은좌석 <span id="seatCnt" style="color: #dc3545; font-weight:bold;">121</span>/150</li>
			</ul>
		</div>
		<div id="timeInfo"class="col">
  			2020.<%=session.getAttribute("resmonth") %>.<%=session.getAttribute("resday") %>(<%=session.getAttribute("resweek") %>)
  			<%=session.getAttribute("screenTime") %> ~ <%=session.getAttribute("screenTime") %>
		</div>	  	
		<div id="price" class="col d-flex justify-content-end">
			<span>0</span>원
		</div>	  	
	  </div>
	</div>
	<div id="seatsCont" class="row justify-content-center">
		
		<div id="screenDiv" class="container p-3 my-3 bg-secondary text-white">
			SCREEN
		</div>
		
		<div id="seatsDiv"class="container p-3 my-3">
  			
  			<div class="row">
  				<div class="col-sm-2 seatKind">A</div>
  				<div class="col-sm-1 seat">1</div>
  				<div class="col-sm-1 seat">2</div>
  				<div class="col-sm-1 seat">3</div>
  				<div class="col-sm-3" style="margin: 9px;"></div>
  				<div class="col-sm-1 seat">4</div>
  				<div class="col-sm-1 seat">5</div>
  				<div class="col-sm-1 seat">6</div>
			</div>
			
  			<div class="row">
  				<div class="col-sm-2 seatKind">B</div>
  				<div class="col-sm-1 seat">1</div>
  				<div class="col-sm-1 seat">2</div>
  				<div class="col-sm-1 seat">3</div>
  				<div class="col-sm-1 seat">4</div>
  				<div class="col-sm-1 seat">5</div>
  				<div class="col-sm-1 seat">6</div>
  				<div class="col-sm-1 seat">7</div>
  				<div class="col-sm-1 seat">8</div>
  				<div class="col-sm-1 seat">9</div>
			</div>
  			<div class="row">
  				<div class="col-sm-2 seatKind">C</div>
  				<div class="col-sm-1 seat">1</div>
  				<div class="col-sm-1 seat">2</div>
  				<div class="col-sm-1 seat">3</div>
  				<div class="col-sm-1 seat">4</div>
  				<div class="col-sm-1 seat">5</div>
  				<div class="col-sm-1 seat">6</div>
  				<div class="col-sm-1 seat">7</div>
  				<div class="col-sm-1 seat">8</div>
  				<div class="col-sm-1 seat">9</div>
			</div>
  			<div class="row">
  				<div class="col-sm-2 seatKind">D</div>
  				<div class="col-sm-1 seat">1</div>
  				<div class="col-sm-1 seat">2</div>
  				<div class="col-sm-1 seat">3</div>
  				<div class="col-sm-1 seat">4</div>
  				<div class="col-sm-1 seat">5</div>
  				<div class="col-sm-1 seat">6</div>
  				<div class="col-sm-1 seat">7</div>
  				<div class="col-sm-1 seat">8</div>
  				<div class="col-sm-1 seat">9</div>
			</div>
  			<div class="row">
  				<div class="col-sm-2 seatKind">E</div>
  				<div class="col-sm-1 seat">1</div>
  				<div class="col-sm-1 seat">2</div>
  				<div class="col-sm-1 seat">3</div>
  				<div class="col-sm-1 seat">4</div>
  				<div class="col-sm-1 seat">5</div>
  				<div class="col-sm-1 seat">6</div>
  				<div class="col-sm-1 seat">7</div>
  				<div class="col-sm-1 seat">8</div>
  				<div class="col-sm-1 seat">9</div>
			</div>
  			<div class="row">
  				<div class="col-sm-2 seatKind">F</div>
  				<div class="col-sm-1 seat">1</div>
  				<div class="col-sm-1 seat">2</div>
  				<div class="col-sm-2" style="margin: 6px;"></div>
  				<div class="col-sm-1 seat">3</div>
  				<div class="col-sm-1 seat">4</div>
  				<div class="col-sm-1" style="margin: 3px;"></div>
  				<div class="col-sm-1 seat">5</div>
  				<div class="col-sm-1 seat">6</div>
			</div>
  			<div class="row">
  				<div class="col-sm-2 seatKind">G</div>
  				<div class="col-sm-1 seat">1</div>
  				<div class="col-sm-1 seat">2</div>
  				<div class="col-sm-2" style="margin: 6px;"></div>
  				<div class="col-sm-1 seat">3</div>
  				<div class="col-sm-1 seat">4</div>
  				<div class="col-sm-1" style="margin: 3px;"></div>
  				<div class="col-sm-1 seat">5</div>
  				<div class="col-sm-1 seat">6</div>
			</div>
		</div>
	</div>
	
</div>

<!-- The Modal -->
<div class="modal" id="overModal">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">

      <!-- Modal body -->
      <div class="modal-body">
        <h4 id="minfo">선택한 인원 수 이상으로 선택하셨습니다!</h4><br>
        다시 선택하시겠습니까?<br>
        <hr>
        <div class="d-flex justify-content-around">
	        <button id="ybtn" type="button" class="btn btn-primary" data-dismiss="modal">예</button>
	        <button id="nbtn" type="button" class="btn btn-danger" data-dismiss="modal">아니오</button>
        </div>
      </div>


    </div>
  </div>
</div>


</body>
</html>