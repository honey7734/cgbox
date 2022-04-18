package kr.or.ddit.member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;

import kr.or.ddit.member.vo.MemberVO;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert.do")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		request.setAttribute("application/json; charset=utf-8", response);
		
		
		MemberVO vo = new MemberVO();
		//////
		
//		vo.setMem_id(request.getParameter("mem_id"));
//		vo.setMem_name(request.getParameter("mem_name"));
		
		// D:\C_Lib\beanUtil\commons-beanutils-1.8.3-bin\commons-beanutils-1.8.3\\commons-beanutils-1.8.3.jar
		// D:\C_Lib\beanUtil\commons-logging-1.1.1-bin\commons-logging-1.1.1\\commons-logging-1.1.1.jar瑜� 異붽��빐�빞�븳�떎.
		 try {
	         BeanUtils.populate(vo, request.getParameterMap());
	      } catch (IllegalAccessException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } catch (InvocationTargetException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
		 
		 IMemberService service = MemberServiceImpl.getInstance();
		 
		 int num = service.selectMaxNo();
		 vo.setCustomer_no(num);
		 service.insertCustomerNo(num);
		 String res = service.insertMember(vo);
		 
		 
		
		 System.out.println(num);

		 
//		 vo.setCustomer_no(num);
		 
//		 vo.setMember_id(res);
		 
		 // 4. 寃곌낵媛믪쓣 request�뿉 ���옣�븯湲�
		 request.setAttribute("gogogo", res);
//		 request.setAttribute("num", num);
		 
		 
//		 request.setAttribute("dododo", vo.getMember_id());
//		 request.setAttribute("dododo", vo.getCustomer_no());
//		 System.out.println(vo);
		 // 5. jsp濡� foward
		 request.getRequestDispatcher("member/result.jsp").forward(request, response);
	}

}
