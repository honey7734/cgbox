<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVO login = (MemberVO) request.getAttribute("login");

	if(login != null){
	%>
	{
		"flag" : "<%=login.getMember_name() %>님 로그인 성공"
		<%
			//성공시 세션으로 저장
			session.setAttribute("member", login);
		%>
	}
	<%
	}else{
	%>
	{
		"flag" : "실패"	
	}	
	<%
	
	}
%>