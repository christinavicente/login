<html>

<head>
<title>User Login</title>
</head>

<body>
    <h1>User Login</h1>
	<form action = "<%=request.getContextPath()%>/login" method= "post" >
	<table>
	    <tr>
	        <td>User Name: </td>
	        <td><input type = "text" name= "username" /></td>
	    </tr>
	    <br/>

	        <td>Password: </td>
	        <td><input type = "text" name = "password"/></td>
	    <br/>
	    <input type = "submit" value = "Login" />
	</table>
</body>

</html>
