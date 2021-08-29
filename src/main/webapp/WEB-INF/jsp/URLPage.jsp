<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Input URL</title>
</head>
<style>
    div {
        width: 300px;
        border: 8px darkblue;
        padding: 50px;
        margin: 20px;
    }
</style>
<body >
<h1 align="center" id="page" > </h1>

<script>
    document.getElementById("page").innerHTML = "Welcome!";
    document.getElementById("page").style.fontSize = "25px";

    function validateForm() {
        let x = document.forms["Form"]["URL"].value;
        if (x === "") {
            alert("URL must be filled out");
            return false;
        }
    }
</script>
<center>

<form action="urlInput" method="get" name="Form" onsubmit="return validateForm()">
    <div>
      URL:  <input type="text" name="URL">

    <input type= "submit">
    </div>
</form>

</center>
</body>
</html>