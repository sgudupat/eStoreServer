<%@ page import="java.sql.*,java.net.*,java.io.*,java.lang.*,java.util.*"%>
<html>
<title></title>
<head></head>
<body>

<%
String key=request. getParameter("Key");
try{
    URL oracle = new URL("/getUserByKeyValue?keyValue="+key);
    BufferedReader in = new BufferedReader(
    new InputStreamReader(oracle.openStream()));

    String inputLine;
    while ((inputLine = in.readLine()) != null)
        out.println(inputLine);
		request.setAttribute("name", inputLine);
		response.sendRedirect("http://52.76.83.72:8080/eStore/password.jsp?name="+inputLine);
    in.close();
    }catch(Exception ex){
    	out.prinltn("exception :"+ex);
    	
    }
%>
</body>
</html>