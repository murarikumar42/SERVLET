package com.murari.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CoronaPatientRegistrationServlet extends HttpServlet{

	private static final String INSERT_CORONA_QUERY="INSERT INTO CORONA_REGISTRATION VALUES(CORONA_PATID_SEQ.NEXTVAL,?,?,?,?,?)";
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		PrintWriter pw=null;
		String patName=null,patAddrs=null,gender=null,stage=null;
		int age=0;
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		
		//get PrintWriter
		pw=res.getWriter();
		
		//set response content type
		res.setContentType("text/html");
		
		//read from data
		patName=req.getParameter("PatName");
		patAddrs=req.getParameter("patAddrs");
		age=Integer.parseInt(req.getParameter("patAge"));
		gender=req.getParameter("gender");
		stage=req.getParameter("stage");
		try {
			//get pooled jdbc con object
			con=getPooledConnection();
			
			//create jdbc preparedStatement Object
			ps=con.prepareStatement(INSERT_CORONA_QUERY);
			
			//Set values to query params
			ps.setString(1,patName);
			ps.setString(2,patAddrs);
			ps.setInt(3, age);
			ps.setString(4, gender);
			ps.setString(5, stage);
			
			//execute the query
			count=ps.executeUpdate();
			
			//process the result
			if(count==0)
				pw.println("<h1 style='color:red;text-align:center'>Registration failed </h1>");
			else
				pw.println("<h1 style='color:green;text-align:center'>Registration succeed </h1>");
		}
		catch(SQLException se) {
			se.printStackTrace();
			pw.println("<h1 style='color:red;text-align:center'>Registration failed </h1>");
		}
		catch(Exception e) {
			e.printStackTrace();
			pw.println("<h1 style='color:red;text-align:center'>Unknown problem </h1>");
		}
		finally {
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			pw.println("<h1><a href='register.html'>home</a></h1>");
			try {
				if(pw!=null)
					pw.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}//finally
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
	
	private Connection getPooledConnection() throws Exception{
		InitialContext ic=null;
		DataSource ds=null;
		Connection con=null;
		
		//create initial context object
		ic=new InitialContext();
		
		//get dataSource object through lookup operation
		ds=(DataSource) ic.lookup("java:/comp/env/DsJndi");
		
		//get pooled jdbc con object
		con=ds.getConnection();
		
		return con;
	}//getPooledConnection
}//class
