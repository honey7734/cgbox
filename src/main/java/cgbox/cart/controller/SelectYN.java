package cgbox.cart.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

/**
 * Servlet implementation class SelectYN
 */
@WebServlet("/SelectYN.do")
public class SelectYN extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectYN() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.setCharacterEncoding("utf-8");
		  System.out.println("셀렉YN 서블릿 오나요?");
		  //체크가 된것들의 리스트 
		   String[] chkval = request.getParameterValues("prod"); //시리얼라이즈 했을 경우에는 name으로 한다!

		   
		   HttpSession session = request.getSession();
			session.setAttribute("customer_no",3);
			//세션을 통해서 id를 얻는다
			int customer_no = (int) session.getAttribute("customer_no");
			ICartService service = CartServiceImpl.getInstance();
		   
		   
			//cart_status를 전부 'n'으로 한다
		     int count = service.updatestatusN(customer_no);
		     System.out.println(count);
			 if(count>0) {
				System.out.println("전부 n으로 바꾸기 성공!");
			}
			
			
			HashMap<String,Integer> map = new HashMap<String,Integer>();
			//체크가 된 것들'y' 로 바꿔주기
		   if(chkval !=null) {
		   for(String val : chkval) {
			 map.put("prod_no",Integer.parseInt(val));
			 map.put("customer_no", customer_no);
			 
		     count = service.updatestatus(map);
		     if(count>0) {
		    	 System.out.println("체크박스 업데이트 성공 ");
		    	 }
		     
		   		}
		   }
		   

		  //최종적으로 cartsum!!
		 count =  service.cartsum(customer_no);
		if(count>0) {
			System.out.println("cartsum구하기 성공!!");
		}
		  int sum = service.sumreturn(customer_no);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html/charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(sum);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
