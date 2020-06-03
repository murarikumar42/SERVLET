<%@ page buffer="1kb" autoFlush="false" %>

<%for(int i=1;i<100000;i++){
	if(i%50==0)
		out.flush();
	out.print("hello "+i+"<br>");
}

	
	%>

