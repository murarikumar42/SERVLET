package com.murari.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	/*
	 * public TestServlet() {
	 * System.out.println("TestServlet.::0-param constructor"); ServletConfig
	 * cg=getServletConfig(); ServletContext sc=cg.getServletContext();
	 * System.out.println("dbuser init param value::"+cg.getInitParameter("dbuser"))
	 * ; System.out.println("dbuser context param value::"+sc.getInitParameter(
	 * "dbuser"));
	 * 
	 * }
	 */
	
	@Override
	public void init() throws ServletException {
		System.out.println("TestServlet.init()");
		ServletConfig cg=getServletConfig();
		ServletContext sc=cg.getServletContext();
		System.out.println("dbuser init param value::"+cg.getInitParameter("dbuser"));
		System.out.println("dbuser context param value::"+sc.getInitParameter("dbuser"));
		
		
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	PrintWriter pw=null;
	ServletContext sc=null;
	ServletConfig cg=null;
	pw=res.getWriter();
    res.setContentType("text/html");
    //get Access ServletContext object
	sc=getServletContext();
	pw.println("<br> db user context parameter value::"+sc.getInitParameter("dbuser"));
	//get Access to SErvletConfig object
	cg=getServletConfig();
	pw.println("<br> dbuser init parameter value::"+cg.getInitParameter("dbuser"));
	
	pw.println("<br><br><br>  Details usisg SErvletContext object <br><br>");
	pw.println("<br> Server Info ::"+sc.getServerInfo());
	pw.println("<br> Servlet api version::"+sc.getMajorVersion()+"."+sc.getMinorVersion());
	pw.println("<br> MIME type of input.html is:"+sc.getMimeType("input.html"));
	pw.println("<br> Path of  input.html :"+sc.getRealPath("/input.html"));
	pw.println("<br> path of web root folder ::"+sc.getRealPath("/"));
	pw.println("<br> context path of the web application::"+sc.getContextPath());
	
	//close stream
	pw.close();
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
