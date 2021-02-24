<html>

<head>
<title>User Login</title>
</head>

<body>
	<h1>Create New Task</h1>

        <form action = "<%=request.getContextPath()%>/create-tasks" method= "post" >
	    	<table>
        	    <tr>
        	        <td>Task Name: </td>
        	        <td><input type = "text" name= "name" /></td>
        	    </tr>
        	    <br/>
        	    <tr>
        	        <td>Task start: </td>
        	        <td><input type = "date" name= "startdate" /></td>
        	    </tr>
        	    <br/>
        	        <td>Task end: </td>
        	        <td><input type = "date" name= "enddate" /></td>
        	    </tr>
        	    <br/>
        	        <td>Description: </td>
        	        <td><input type = "text" name = "description"/></td>
        	    <br/>
        	    <br/>
        	        <td>email: </td>
        	        <td><input type = "text" name = "email"/></td>
        	    <br/>
        	    <br/>
        	        <td>severity: </td>
        	        <td><input type = "text" name = "severity"/></td>
        	    <br/>
        	        <td>User assigned to task: </td>
        	        <td><input type = "text" name = "userName"</td>
        	    <input type = "submit" value = "create-tasks" />
        	</table>




</body>

</html>