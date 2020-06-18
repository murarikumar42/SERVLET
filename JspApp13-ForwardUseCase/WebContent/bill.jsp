<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <% //read form data
    String name=request.getParameter("iname");
    float price=Float.parseFloat(request.getParameter("iprice"));
    float qty=Float.parseFloat(request.getParameter("iqty"));
    
    //calculate bill amount
    float billAmount=price*qty;
    if(billAmount>=50000){%>
    	<jsp:forward page="discount.jsp">
    		<jsp:param value="<%=billAmount %>" name="bAmt"/>
    	</jsp:forward>
    <% 
    }
    else{
    	%>
    	<h1 style="color:red;text-align:center">from bill.jsp</h1>
    	<br><b>Item name::<%=name %>
    	<br>Item price::<%=price %>
    	<br>Item qty::<%=qty %>
    	<br>Bill amount::<%=billAmount %>
    	</b>
    	<% 
    }
    	%>
    	<br><br><br>
    	<a href="input.html">home</a>
    