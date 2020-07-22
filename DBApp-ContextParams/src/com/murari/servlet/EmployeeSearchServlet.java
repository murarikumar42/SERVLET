package com.murari.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/testurl")
public class EmployeeSearchServlet extends HttpServlet {
	
	private static final String GET_EMP_DETAILS_BY_NO="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		int eno=0;
		ServletContext sc=null;
		ServletConfig cg=null;
		String driver=null,url=null,user=null,pwd=null;
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		try {
			//get PrintWriter
			pw=res.getWriter();
			
			//set response content type
			res.setContentType("text/html");
			
			//read from data
			eno=Integer.parseInt(req.getParameter("eno"));
			
			//get access to servletContext,setvletconfig object
			sc=getServletContext();
			cg=getServletConfig();
			
			//read servlet Init params
			driver=sc.getInitParameter("driver");
			url=sc.getInitParameter("url");
			user=sc.getInitParameter("dbuser");
			pwd=sc.getInitParameter("dbpwd"); 
			
			//regiser jdbc driver
			Class.forName(driver);
			
			//create connection
			con=DriverManager.getConnection(url, user,pwd);
			
			//create preparedStatement having pre-compiled query
			ps=con.prepareStatement(GET_EMP_DETAILS_BY_NO);
			//set query param values
			ps.setInt(1,eno);
			//execute the query
			rs=ps.executeQuery();
			//process the resultset object
			if(rs.next()){
				pw.println("<h1> Employee Details are </h1>");
				pw.println("<b> empno::"+rs.getInt(1)+"<br>");
				pw.println("<b> emp name::"+rs.getString(2)+"<br>");
				pw.println("<b> emp JOB::"+rs.getString(3)+"<br>");
				pw.println("<b> emp SAL::"+rs.getString(4)+"<br>");
				pw.println("<b> emp DEPTNO::"+rs.getString(5)+"<br>");
			}
			else{
				pw.println("<h1 style='color:red'> Employee Not Found </h1>");
			}
				pw.println("<br> ServletContext obj class name::"+sc.getClass());
				pw.println("<br> ServletConfig obj class name::"+cg.getClass());
				
		}//try
		catch(SQLException se){
			pw.println("<h1 style='color:red'> Internal DB Problem </h1>");
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnfe){
			pw.println("<h1 style='color:red'> DB Problem </h1>");
			cnfe.printStackTrace();
		}
		catch(Exception e){
			pw.println("<h1 style='color:red'> DB Problem </h1>");
			e.printStackTrace();
		}
			
		
		finally{
			//close jbdc objects
			try{
				if(rs!=null){
					rs.close();
				}
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			
			try{
				if(con!=null){
					rs.close();
				}
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			
			//home hyperlink
			pw.println("<br><br><a href='input.html'>home</a>");

			try{
				if(pw!=null){
					pw.close();
				}
			}
			catch(Exception se){
				se.printStackTrace();
			}
			
			
			
		}//finally
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
