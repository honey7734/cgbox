package cgbox.cart.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cgbox.cart.service.CartServiceImpl;
import cgbox.cart.service.ICartService;
import cgbox.vo.CartProdVO;
import cgbox.vo.allcartVO;

/**
 * Servlet implementation class CartProdServlet
 */
@WebServlet("/CartProdServlet.do")
public class CartProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //상품이 나열되어 있는 곳에서 상품담기와 함께 장바구니에 온 경우
		//종민이의 상품스토어 페이지에서 넘어온다!
		request.setCharacterEncoding("utf-8");
		
		
		//내가 임시로 한 것!
		int prod_no =3;
		//int prod_no =Integer.parseInt(request.getParameter("prod_no"));
		
		//해당 상품을 cart_prod에 인서트해서한다
		HttpSession session = request.getSession();
		session.setAttribute("customer_no",3);

		
		//세션을 통해서 id를 얻는다
		
		
		int customer_no = (int) session.getAttribute("customer_no");

		ICartService service = CartServiceImpl.getInstance();
		
	
		//장바구니가 있는 회원인지 아닌지 먼저 확인한다!
		String cartno = service.checkcart(customer_no);
	    System.out.println("checkcart시행합니다"+ cartno);
		
		List<allcartVO> prodlist =null;
		
		if(cartno ==null) { //cartno의 값이 null인 경우, 아직 장바구니를 가지고 있지 않은 회원
         System.out.println("여기3");
			//장바구니를 생성해주기
			
			int ncartno =0;
			if(service.insertcartno(customer_no)>0) {
				//카트 번호 생성이 성공한 경우
				System.out.println("카트번호 생성완료");
				//카트번호가 제대로 생성 되었는지 확인가
				ncartno = service.cartnoselect(customer_no);
				
			} 
			System.out.println(ncartno);
			
			
			//해당상품을 cart_prod에 넣어준다
			CartProdVO cartprodVO = new CartProdVO();
			
			cartprodVO.setCart_no(ncartno);
			cartprodVO.setProd_no(prod_no);
			cartprodVO.setCustomer_no(customer_no);
			
			int count=	service.insertprod(cartprodVO);
			if(count <1) { //insert에 실패한것!
			 System.out.println("장바구니 없을 때 상품을 인서트하지 못했습니다");
			 
			}
			//1.상품을 장바구니에 담고 장바구니 페이지(CartView)로 가는 경우
			//ex)상품이 장바구니에 담겼습니다 해당 상품을 확인하시겠습니까? "Y"
		    prodlist = service.allcart(customer_no);
			request.setAttribute("prodlist", prodlist);  
			request.getRequestDispatcher("cart/cartView.jsp").forward(request, response);	
			
			//2.상품을 장바구니에 담고 쇼핑을 계속하는 경우
			//ex)상품이 장바구니에 담겼습니다 해당 상품을 확인하시겠습니까? "N"
		    //allcart가 시행되지 않고 스토어 페이지에 계속 있는다!
			
			
		}else{
			System.out.println("여기4");
			//이미 장바구니를 가지고 있는 회원 
			
			//해당상품을 이미 보유하고 있는지 체크해서 보유하고 있으면 cart_count +1을 해주고 
			//prodlist를 출력한다.
			
			HashMap<String,Integer> map = new HashMap<String, Integer>();
			map.put("prod_no",prod_no);
			map.put("customer_no",customer_no);
					
			if(service.checkprod(map) !=null) { //이미 상품을 보유한 경우
			   //수량 +1을 해준다
				int res = service.plusone(map);
				if(res>0) {System.out.println("수량+1에 성공했습니다");}

			}else {
				//해당 상품을 insert해준다.
			     int mcartno = Integer.parseInt(cartno);
				CartProdVO cartprodVO = new CartProdVO();
				cartprodVO.setCart_no(mcartno);
				cartprodVO.setProd_no(prod_no);
				cartprodVO.setCustomer_no(customer_no);
				
				int count=	service.insertprod(cartprodVO);
				if(count <1) { //insert에 실패한것!
				 System.out.println("장바구니번호가 있을 경우 상품을 인서트하지 못했습니다");
				}
				
			}
			
			//1.상품을 장바구니에 담고 장바구니 페이지(CartView)로 가는 경우
			//ex)상품이 장바구니에 담겼습니다 해당 상품을 확인하시겠습니까? "Y"
			 prodlist = service.allcart(customer_no);
			 request.setAttribute("prodlist", prodlist);
			 request.getRequestDispatcher("cart/cartView.jsp").forward(request, response);	
	
			 
			 
		}

		  
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
