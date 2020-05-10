package com.murari.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testurl")
public class TestServlet extends HttpServlet implements SingleThreadModel{
	
	public TestServlet() {
		System.out.println("TestServlet.TestServlet()");
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("TestServlet.doGet()::hashcode::"+this.hashCode());
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("<h1>Date and time::"+new java.util.Date()+"</h1> hashcode::"+this.hashCode());
		
		try {
			Thread.sleep(30000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		pw.close();
	}
		
		
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
