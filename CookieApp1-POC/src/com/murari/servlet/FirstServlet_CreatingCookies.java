package com.murari.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/createurl")
public class FirstServlet_CreatingCookies extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		Cookie ck1=null,ck2=null,ck3=null,ck4=null;
		
		//get PrintWriter
		pw=res.getWriter();
		
		//set content type
		res.setContentType("text/html");
		
		//create cookies(InMemory cookies)
		ck1=new Cookie("ap","hyd");
		ck2=new Cookie("mh","mumbai");
		res.addCookie(ck1);res.addCookie(ck2);
		
		//create cookie(Persistent cookie)
		ck3=new Cookie("ts","hyd");
		ck4=new Cookie("mp","bhopal");
		ck3.setMaxAge(120);ck4.setMaxAge(60);
		res.addCookie(ck3);res.addCookie(ck4);
		
		pw.println("<b>Cookies created and added response.........</b>");
	}
		
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
