
<%@ page import="java.sql.*,java.net.*,java.io.*,java.lang.*,java.util.*"%>
<html>
<head>
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
</head>
<body>


<script type='text/javascript'>
    /* attach a submit handler to the form */
    $("#submit").submit(function(event) {
    	alert("inside submit fucntion");
      /* stop form from submitting normally */
      event.preventDefault();

      /* get some values from elements on the page: */
      var $form = $( this ),
          url = "/updatePassword";

      /* Send the data using post */
      var posting = $.post( url, { username: $('#name').val(), password: $('#password').val()} );

      /* Alerts the results */
      posting.done(function( data ) {
	  alert(data);
        alert("success");
      });
    });
</script>
<%
String key=request.getParameter("key");
out.println("key value:" + key);
String uName="";
try{
    URL oracle = new URL("http://52.76.83.72:8080/eStore/getUserByKeyValue?keyValue="+key);
    BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));

    String inputLine;
    while ((inputLine = in.readLine()) != null)
        out.println("user name:" + inputLine);
    uName=inputLine;
		
    in.close();
    }catch(Exception ex){
    	out.println("exception :"+ex);
    	
    }
%>
<form id="pwd"  method="POST">
UserName: <input type="text" id="name" value=<%=uName%> name="name"/>
<br />
New Password: <input type="text" name="password"  id="password"/>
<br />
Reenter Password: <input type="text" name="rpassword" id="rpassword" />
<input type="submit" id="submit" value="Submit" />
</form>
</body>
</html>