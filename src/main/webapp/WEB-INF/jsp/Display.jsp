<jsp:useBean id="Response" scope="request" type="java.lang.String"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Display page: Response of URL</title>
</head>
<body align="center">
<textarea rows="4" cols="50"
          name="url" disabled>[[${Response}]]
</textarea>
</body>
</html>