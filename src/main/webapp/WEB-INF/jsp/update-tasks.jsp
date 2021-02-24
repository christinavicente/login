<html>

<head>
<title>User Login</title>
</head>

<body>

	<form action = "<%=request.getContextPath()%>/update-tasks" method= "post" >
        <h1>Update Task</h1>


    	<table>
    	    <tr>
    	        <td>Task ID: </td>
    	        <td><input type = "number" name= "taskID" /></td>
    	    </tr>
    	    <br/>
    	    <tr>
    	        <td>Task Name: </td>
    	        <td><input type = "text" name= "name" /></td>
    	    </tr>
    	    <br/>
    	    <tr>
    	        <td>Task ID: </td>
    	        <td><input type = "date" name= "startdate" /></td>
    	    </tr>
    	    <br/>
    	        <td>Task ID: </td>
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
    	        <td>User assigned to task</td>
    	        <td><input type = "text" name = "userName"</td>
    	    <input type = "submit" value = "update task" />
    	</table>


</body>

</html>