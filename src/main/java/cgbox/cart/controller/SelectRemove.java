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
import cgbox.vo.allcartVO;

/**
 * Servlet implementation class SelectRemove
 */
@WebServlet("/SelectRemove.do")
public class SelectRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectRemove() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   request.setCharacterEncoding("utf-8");
	  System.out.println("리무브 서블릿 오나요?");
	   String[] chkval = request.getParameterValues("prod");
	   
	   String[] prodList = request.getParameterValues("prod");
	   System.out.println("prodList : " + prodList);
	   
	   if(prodList.length > 0){
			for(int x=0; x<prodList.length;x++){
				System.out.println(prodList[x] + "입니다.");
			}
		}
	   
	     
	   HttpSession session = request.getSession();
		session.setAttribute("customer_no",3);
		//세션을 통해서 id를 얻는다
		int customer_no = (int) session.getAttribute("customer_no");
		ICartService service = CartServiceImpl.getInstance();
		
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for(String chk : chkval) {
			int chkv = Integer.parseInt(chk);
			System.out.println("chk: " + chk);
		    System.out.println("chk밑입니다 ");
			map.put("prod_no", chkv);
			map.put("customer_no",customer_no);
		
			int count = service.selectdelete(map);
			System.out.println("selectdelet밑입니다 ");
			if(count >0) {
				System.out.println("해당 상품을 삭제하였습니다");
			}else {
				System.out.println("삭제하는데 실패하였습니다");
			}
		}
		
		List<allcartVO> prodlist =null;
		   
	    prodlist = service.allcart(customer_no);
		request.setAttribute("prodlist", prodlist);  
		request.getRequestDispatcher("cart/cartView.jsp").forward(request, response);	
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	

}
