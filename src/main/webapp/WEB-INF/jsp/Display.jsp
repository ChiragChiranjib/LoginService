<jsp:useBean id="Response" scope="request" type="java.lang.String"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <title>Response of URL</title>
    <style>
        button {
        background-color: #008CBA;
        border: none;
        color: white;
        padding: 8px 30px;
        text-align: center;
        text-decoration: none;
        font-size: 16px;
        margin: 4px 2px;
        cursor: pointer;
        }
    </style>
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