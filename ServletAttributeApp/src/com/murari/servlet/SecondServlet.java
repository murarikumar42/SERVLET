package com.murari.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/secondServlet")
public class SecondServlet extends HttpServlet {
	
   
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd=null;
		PrintWriter pw=null;
		HttpSession ses=null;
		
		//get printWriter
		pw=res.getWriter();
		res.setContentType("text/html");
		
		//get session object
		ses=req.getSession();
		
		//read and display request attribute values
		pw.println("<br><b>(SecondServlet)req attribute(attr1)value::"+req.getAttribute("attr1")+"</b>");
		pw.println("<br><b>(SecondServlet)ses attribute(attr2)value::"+ses.getAttribute("attr2")+"</b>");
		
		
		//forward request to third servlet
		rd=req.getRequestDispatcher("/thirdurl");
		rd.forward(req, res);
		
		//close stream
		pw.close();
		}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
