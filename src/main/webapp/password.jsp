<html>
<head>
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
</head>
<body>
    <jsp:include page="/latest_products.jsp" />
<%String key=request. getParameter("name");/>


<script type='text/javascript'>
    /* attach a submit handler to the form */
    $("#pwd").submit(function(event) {

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
        alert('success');
      });
    });
</script>
<form id="pwd" action="update" method="POST">
UserName: <input type="text" id="name" value=<%request. getParameter("name")/> name="name">
<br />
New Password: <input type="text" name="password"  id="password"/>
<br />
Reenter Password: <input type="text" name="rpassword" id="rpassword" />
<input type="submit" value="Submit" />
</form>
</body>
</html>