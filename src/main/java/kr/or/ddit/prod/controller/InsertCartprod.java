package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;


@WebServlet("/InsertCartprod.do")
public class InsertCartprod extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int customer_no = Integer.parseInt(request.getParameter("customer_no"));
		int prod_no = Integer.parseInt(request.getParameter("prod_no"));
		
		
		IProdService service =  ProdServiceImpl.getInstance();
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("prod_no", prod_no);
		map.put("customer_no", customer_no);
		
		int count = service.insertCartprod(map);

		Gson gson = new Gson();
		
		String result = gson.toJson(count);
		
		response.setContentType("application/json; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
	}

}
