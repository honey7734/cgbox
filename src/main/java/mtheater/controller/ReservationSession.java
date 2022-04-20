package mtheater.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ReservationSession.do")
public class ReservationSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		session.setAttribute("moiveName", request.getParameter("moiveName"));
		session.setAttribute("mtheaterName", request.getParameter("mtheaterName"));
		session.setAttribute("resmonth", request.getParameter("resmonth"));
		session.setAttribute("resday", request.getParameter("resday"));
		session.setAttribute("theaterNo", request.getParameter("theaterNo"));
		session.setAttribute("screenTime", request.getParameter("screenTime"));
		session.setAttribute("resweek", request.getParameter("resweek"));
		session.setAttribute("screenNo", request.getParameter("screenNo"));
		session.setAttribute("screen_end", request.getParameter("screen_end"));

	}

}
