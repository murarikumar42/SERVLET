<%!	 public void method1(){
		try{
		Class.forName("java.util.Date");
		System.out.println("class loaded");
		}
		catch(Exception e){
			e.printStackTrace();
		}
}
%> 


<%! public String generateWishMessage(String user){
		java.util.Calendar calendar=null;
		int hour=0;
		
		//get system date and time
		calendar=java.util.Calendar.getInstance();
		
		//get current hour of the day
		hour=calendar.get(java.util.Calendar.HOUR_OF_DAY);
		
		if(hour<12)
			return "Good Morning"+user;
		else if(hour<16)
			return "Good AfterNoon"+user;
		else if(hour<20)
			return "Good evening"+user;
		else
			return "Good Night"+user;
}
%>

<!-- <h1 style="color:red;text-align:center">Welcome to Jsp page</h1> -->
Date and time::<%=new java.util.Date() %><br>
<%String name=request.getParameter("uname");%><br>
Wish message is::<%=generateWishMessage(name)%>
<%Class.forName("java.util.Date");
	System.out.println("class loaded");
	method1();
%>
<!--<jsp:expression>
	generateWishMessage(name)
</jsp:expression> -->

<!--<jsp:scriptlet>
	int a=10;
	out.println("a value"+a);
</jsp:scriptlet>-->



