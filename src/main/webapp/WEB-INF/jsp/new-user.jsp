<html>

<head>
<title>User Login</title>
</head>

<body>
	<form action = "<%=request.getContextPath()%>/newUser" method= "post" >
	<h1> New User</h1>
	<table>
	    <tr>
	        <td>User Name: </td>
	        <td><input type = "text" name= "New Username" /></td>
	    </tr>
	    <br/>

	        <td>Password: </td>
	        <td><input type = "text" name = "New password"/></td>
	    <br/>
	    <input type = "submit" value = "Create User" />
	</table>

</body>

</html>