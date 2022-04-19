package screen.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import mtheater.service.IMTheaterService;
import mtheater.service.MTheaterServiceImpl;
import screen.service.IScreenService;
import screen.service.ScreenServiceImpl;
import theater.service.ITheaterService;
import theater.service.TheaterServiceImpl;
import vo.MTheaterVO;
import vo.ScreenVO;
import vo.TheaterVO;


@WebServlet("/screenList.do")
public class ScreenList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//결과 출력용 리스트
		List<ScreenVO> resultList = new ArrayList<ScreenVO>();
		
		ScreenVO parameterVO = new ScreenVO();
		parameterVO.setMovie_no(request.getParameter("movie_no"));
		
		
		//영화관 이름으로 영화관 번호 찾기
		String mtname = request.getParameter("mtheaterName");
		
		IMTheaterService mservice = MTheaterServiceImpl.getInstance();
		MTheaterVO mvo = mservice.selectAllByName(mtname);
		
		//영화관 번호
		int mnum = mvo.getMtheater_no();
		
		//영화관 번호로 상영관 번호 찾기 -> 여러개나옴(상영관 번호) : 1,2,3..(관)
		
		ITheaterService tservice = TheaterServiceImpl.getInstance();
		
		List<TheaterVO> tlist = tservice.selectAllByMtheaterNo(mnum);
		//상영관 번호 리스트를 구한다 > tlist.get(0).getTheater_no(); => 파라미터 리스트의 theater_no에 등록
		
		
		IScreenService sservice = 
		// 상영관 번호를 이용해 -> 여러개의 상영관 번호로 상영관 번호가 가진 스크린 번호 리스트를 출력한다
		for(TheaterVO tvo : tlist) {
			
		}
		
		
	}

}
