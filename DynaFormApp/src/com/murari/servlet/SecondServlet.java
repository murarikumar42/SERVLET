package com.murari.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String pname=null,fname=null,ms=null;
		String f2val1=null,f2val2=null;
		//get printWriter
		pw=res.getWriter();
		
		//set content type
		res.setContentType("text/html");
		
		//read form1/req1 data
		pname=req.getParameter("pname");
		fname=req.getParameter("fname");
		ms=req.getParameter("ms");
		
		//read form2/req2 data
		f2val1=req.getParameter("f2t1");
		f2val2=req.getParameter("f2t2");
		
		//display dynamic webpage having both form1/req1  data and form2/req2 data
		pw.println("<h1 style='color:red;text-align:center'>Result Page</h1>");
		pw.println("<br> form1/req1 data::"+pname+"   "+fname+"  "+ms);
		pw.println("<br> form2/req2 data::"+f2val1+"   "+f2val2);
		
		//add hyperlink
		pw.println("<br><br> <a href='input.html'>home</a>");
		
		//close stream
		pw.close();
		}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
