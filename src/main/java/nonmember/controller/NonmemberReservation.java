package nonmember.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import nonmember.service.INonMemberService;
import nonmember.service.NonMemberServiceImpl;
import vo.NonMemberVO;


@WebServlet("/nonmemberReservation.do")
public class NonmemberReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		request.setAttribute("application/json; charset=utf-8", response);
		
		NonMemberVO vo = new NonMemberVO();
		
		
		
		vo.setNonmember_birth(request.getParameter("nonmember_birth"));
		vo.setNonmember_pass(request.getParameter("nonmember_pass"));
		String mail = request.getParameter("mail1") + "@" + request.getParameter("mail2"); 
		vo.setNonmember_mail(mail);
		
		//vo의 값은 max값 검색 후 해당값 +1 으로 지정
		INonMemberService service = NonMemberServiceImpl.getInstance();
		
		System.out.println(service.selectMaxCustomer());
		
		int num = service.selectMaxCustomer() + 1;
		
		vo.setCustomer_no(num);
		
		
		// 세선에 정보 저장하기
		HttpSession session = request.getSession();
		session.setAttribute("nonMember", vo);
		
		// jsp문서로 이동
		response.sendRedirect(request.getContextPath() + "/ticketing/sessionTest.jsp");
		
		
		
		
		//비회원 멤버 추가
//		INonMemberService service = NonMemberServiceImpl.getInstance();
//		
//		int res = service.insertNonMember(vo);
//		
//		request.setAttribute("nonMemInsert", res);
//		request.getRequestDispatcher("ticketing/test.jsp").forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
