<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%
    //gather bill amount as additional req param value
    float billAmt=Float.parseFloat(request.getParameter("bAmt"));
    
    //calculate discount amount
    float discount=billAmt*0.3f;
    
    //calculate final bill amount
    float finalAmount=billAmt-discount;
    %>
    
    <!-- Display the details -->
    <h1 style="color:red;text-align:center">from discount.jsp --Bill are</h1>
    <b>
    	Item name::<%=request.getParameter("iname") %><br>
    	Item price::<%=request.getParameter("iprice") %><br>
    	Item qty::<%=request.getParameter("iqty") %><br>
    	Bill amount::<%=billAmt %><br>
    	Discount amount::<%=discount %><br>
    	Final Bill Amount::<%=finalAmount %>
     </b>
    	<br><br><br>
    	<a href="input.html">home</a>
    
   