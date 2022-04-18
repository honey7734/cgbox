<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	
 <script src="../js/store.js"></script>		
<title>CGBOX STORE</title>


<script>
	// 상품 카테고리
	category= "";
	// 회원 고객번호로 장바구니가 있는지 확인하는 변수
	customer_no =1;
	$(function(){
		
		// 스토어 전체항목 소개문구
		storestr = "<h3>CGVBOX STORE</h3>";
		
		findCart();
		prodList();
		cartCount();
		
		
		$('.menu').on('click',function(){
			category = $(this).attr('id').trim();
				
			switch(category){
			case "영화관람권":
				storestr = "<h3>영화관람권<span> 영화, 모두에게 즐거운 경험</span></h3>";
				break;
			case "콤보":
				storestr = "<h3>콤보<span> 맛있으면 0칼로리, 아는 맛이 제일 맛있어요</span></h3>";
				break;
			case "팝콘":
				storestr = "<h3>팝콘<span> 영화에는 팝콘이죠! 안먹으면 서운해요</span></h3>";
				break;
			case "음료":
				storestr = "<h3>음료<span> 탄산음료부터 에이드까지, 마시는 즐거움!</span></h3>";
				break;
			case "스낵":
				storestr = "<h3>스낵<span> 출출할땐 다양한 스낵이 정답이죠</span></h3>";
				break;
			default :
				storestr = "<h3>CGVBOX STORE</h3>";
			}
			
			prodList();
		})
		
		$('.cartMove').on('click',function(){
			alert("장바구니로 이동합니다.");
		})
		
		$(document).on('click',".cart",function(){
			prod_no = $(this).next().text();
			
			insertCartprod();
		})
		
		$(document).on('click',".buy",function(){
			alert("구매를 위해 장바구니로 이동합니다.")
		})
	})
	

</script>

<style>

	.nav-item > .active {
	
	color : red !important;
    background-color:white !important;
    text-decoration: underline !important;
    
	}

	span{
		font-size: 15px;
	}
	
	ul {
		list-style: none;
	}
	
	.wrapper{
		float: left; 
		
		margin-right: 40px;
		margin-bottom: 80px;
	}
	
	
	.wrapper{

		position:relative;
		 width:200px;
  		height:200px;
	}
	
	.wrapper img {
		position:relative;
		width:inherit;
	  height:inherit;
	}
	
	.darkness {
  position:absolute;
  top:0;
  left:0;
  width:inherit;
  height:inherit;
  background:#000000;
  /* 추가된 부분 */
  opacity:0;

}
	
	.wrapper .cart {
  position:absolute;
  top:70px;
  left:30px;
   width:55px;
  height:55px;
  background:white;
  border-radius:30%;
  border : 3px solid black;
  
  /* 추가된 부분 */
  opacity:0;
 
}

.wrapper .buy {
  position:absolute;
  top:70px;
  left:120px;
   width:55px;
  height:55px;
  background:white;
  border-radius:30%;
  border : 3px solid black;
  
  /* 추가된 부분 */
  opacity:0;
 
}
  
	
	
.wrapper:hover .darkness{
  opacity:0.2;
}

/* 추가된 부분 */
.wrapper:hover .cart, .wrapper:hover .buy{
  opacity:1;
  
  
}

  #list{
  	margin: 50px 50px;
  	
  }
  .nav{
  	margin: 20px 50px;
  }
  
  .leftMenu{
  	float:left;
  	width: 70%;
  }

  .rightMenu{
  	float:right;
  	width: 25%;
  }
  
  .menuLine{
  	clear : both;
  }
  
  .cartCount{
  	background-color: red;
  	border-radius: 50%;
  	color: white;
  	width: 25px;
	height: 25px;
	text-align:center;
  }
</style>
</head>
<body>

<div class="container" >
 <div class="leftMenu">
  <ul class="nav" role="tablist">
    <li class="nav-item">
      <strong class="nav-link active menu" data-toggle="pill" id="">전체</strong>
    </li>
    <li class="nav-item">
      <strong class="nav-link menu" data-toggle="pill" id="영화관람권">영화관람권</strong>
    </li>
    <li class="nav-item">
      <strong class="nav-link menu" data-toggle="pill" id="콤보">콤보</strong>
    </li>
    <li class="nav-item">
      <strong class="nav-link menu" data-toggle="pill" id="팝콘">팝콘</strong>
    </li>
    <li class="nav-item">
      <strong class="nav-link menu" data-toggle="pill" id="음료">음료</strong>
    </li>
    <li class="nav-item">
      <strong class="nav-link menu" data-toggle="pill" id="스낵">스낵</strong>
    </li>
  </ul>
</div>  
<div class="rightMenu">
  <ul class="nav justify-content-end" role="tablist">
  	<li>
  		 <strong class="nav-link cartMove">장바구니</strong>
  	</li>
  	<li>
  		 <div class="cartCount"></div>
  	</li>
  </ul>
</div>
 
  <hr class="menuLine" style="border:1px solid red;">
  
  
    <div id="list"></div>
  
  
</div>


</body>
</html>