<%!
	public void jspInit(){
	
	//get access to servletConfig obj
	ServletConfig cg=getServletConfig();
	System.out.println("p2 init param value"+cg.getInitParameter("p2"));
	
	//get access to servletContext objs
	ServletContext sc=getServletContext();
	System.out.println("p1 context param value"+sc.getInitParameter("p1"));
}
%>    
p1 context param value::<%=application.getInitParameter("p1") %><br>
p2 init param value::<%=config.getInitParameter("p2") %>
