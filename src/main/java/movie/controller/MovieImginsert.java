package movie.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import movie.service.IMovieService;
import movie.service.MovieServiceImpl;


@WebServlet("/MovieImginsert.do")
public class MovieImginsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String[] movieNm = request.getParameterValues("movieName");
		IMovieService service = MovieServiceImpl.getInstance();
		
		// 테스트용으로 0번째 뽑아서 출력
		String img = service.selectImg(movieNm[0]);
		System.out.println(img);
		
		List<String> list = new ArrayList<String>();
		for(int i = 0; i < movieNm.length; i++) {
			list.add(service.selectImg(movieNm[i]));
		}
		
		Gson gson = new Gson();
		
		String result = gson.toJson(list);
		
		response.setContentType("application/json; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
