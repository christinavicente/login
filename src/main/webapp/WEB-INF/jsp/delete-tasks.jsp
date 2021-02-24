<html>

<head>
<title>User Login</title>
</head>

<body>
	<h1>Delete Task</h1>

	<form action = "<%=request.getContextPath()%>/delete-tasks" method= "post" >
    	<table>
    	    <tr>
    	        <td>Task ID </td>
    	        <td><input type = "number" name= "id" /></td>
    	    </tr>
    	    <br/>

    	        <td>I want to delete this task: </td>
    	    </tr>
    	        <td>yes</td><td><input type = "radio" name = "agree" value="yes"/></td>
    	        <td>no</td><input type: "radio" name= "agree" value="no" checked/></td>
    	    <br/>
    	    <input type = "submit" value = "delete task" />
    	</table>
</body>

</html>