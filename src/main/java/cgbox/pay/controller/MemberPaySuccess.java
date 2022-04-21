package cgbox.pay.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cgbox.pay.service.IPayService;
import cgbox.pay.service.PayServiceImpl;
import cgbox.vo.ReserveVO;
import cgbox.vo.ScreenVO;
import cgbox.vo.SeatVO;
import cgbox.vo.TheaterVO;

/**
 * Servlet implementation class MemberPaySuccess
 */
@WebServlet("/MemberPaySuccess.do")
public class MemberPaySuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberPaySuccess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		//회원구하기 
		HttpSession session = request.getSession();
		session.setAttribute("customer_no", 3);
		int customer_no = (int) session.getAttribute("customer_no");

		//이곳에서 할일 ==> 티켓 상태 완료로 바꿔주기 /고객이 예약한 영화 정보 구해서 돌려주기 
		IPayService service = PayServiceImpl.getInstance();
		
		//티켓 상태 완료로 바꿔주기 
	
		// 보유한 예약 정보 불러오기
				List<ReserveVO> reservelist = service.selectreserve(customer_no);
				System.out.println("멤버완료 성공 ~!여기오나?");
			   System.out.println(reservelist);
		        System.out.println(reservelist.get(0).getScreen_no()+"입니다 ");
				
				
				HashMap<String, Object> map = new HashMap<String, Object>();
				// 영화제목
				int screenno = reservelist.get(0).getScreen_no(); // 상영일정번호

				String movieName = service.selectMname(screenno); // 영화이름
				TheaterVO tinfo = service.selectTinfo(screenno); // 상영관정보
			    ScreenVO  startend = service.startend(screenno);
				
				 System.out.println(tinfo);
				
				
				
				String theaterName = service.getTname(tinfo.getMtheater_no()); // 영화관이름얻기!
				String[] arr = new String[reservelist.size()]; // list만한 사이즈의 좌석행열을 담을 배열 생성
		        
				int index = 0;
				
				for (ReserveVO reserve : reservelist) { // 좌석 담아주기
					int seatno = reserve.getSeat_no();
					SeatVO vo = service.rowcol(seatno);
					String temp = "" + vo.getSeat_row() + vo.getSeat_col().toString(); //공유테이블에서 col의 타입은 number입니다!
					arr[index] = temp;
					index++;
				}

				map.put("movieName", movieName);
				map.put("theatername", tinfo.getTheater_name());
				map.put("theaterkind",tinfo.getTheater_kind());
				map.put("theaterprice", tinfo.getTheater_price());
				
				map.put("theaterName", theaterName);
				

				
				map.put("start",startend.getScreen_start());
				
				map.put("end",startend.getScreen_end());
				request.setAttribute("info", map);
				request.setAttribute("arr", arr);
				
				request.getRequestDispatcher("pay/PaySuccess.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
