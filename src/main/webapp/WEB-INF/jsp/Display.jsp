<jsp:useBean id="Response" scope="request" type="java.lang.String"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <title>Response of URL</title>
</head>
<body>
<center>
<h1 style="color: darkblue ">
    Response
</h1>

<textarea rows="4" cols="50"
          name="url" disabled>${Response}
</textarea>

    <form action="/logout">
        <button type="submit">Logout</button>
    </form>
</center>
</body>
</html>