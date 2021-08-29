<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Input URL</title>
</head>
<style>
    #A{
        border-width:6px;
        padding:2em;
        font-size: 1.1em;
    }
    input {
        margin: .4rem;
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
    <fieldset id="A">
      URL:  <input type="text" name="URL">

    <input type= "submit">
    </fieldset>
</form>

</center>
</body>
</html>