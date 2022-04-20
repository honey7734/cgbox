package nonmember.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ticket.service.ITicketService;
import ticket.service.TicketServiceImpl;
import vo.NonMemberVO;
import vo.TicketVO;

@WebServlet("/nonmemberReservationCheck.do")
public class NonmemberReservationCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//비회원 예매 확인용
		
		request.setCharacterEncoding("utf-8");
		request.setAttribute("application/json; charset=utf-8", response);
		
		NonMemberVO vo = new NonMemberVO();
		
		
		vo.setNonmember_birth(request.getParameter("nonmember_birth"));
		vo.setNonmember_pass(request.getParameter("nonmember_pass"));
		String mail = request.getParameter("mail1") + "@" + request.getParameter("mail2"); 
		vo.setNonmember_mail(mail);
		
		ITicketService service = TicketServiceImpl.getInstance();
		
		List<TicketVO> list = service.selectAllticketByNonMember(vo);
		
		
		HttpSession session = request.getSession();
		session.setAttribute("TicketList", list);
		
		response.sendRedirect(request.getContextPath() + "/ticketing/nonreservation.jsp");
	}

}
