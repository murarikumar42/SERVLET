package com.murari.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Firsturl")
public class FirstServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd=null;
		HttpSession ses=null;
		//create request attribute
		req.setAttribute("attr1", "val1");
		
		//forward request second servlet
		rd=req.getRequestDispatcher("/secondurl");
		rd.forward(req, res);
		
		//create /location HttpSession object
		ses=req.getSession();
		ses.setAttribute("attr2", "val2");
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
