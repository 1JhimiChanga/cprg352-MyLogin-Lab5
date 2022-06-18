<%-- 
    Document   : login
    Created on : 11-Jun-2022, 2:19:50 PM
    Author     : Jimmy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="post" action="login">
            <label>Username: </label>
            <input type="text" name="c_username" value="${v_user}">
            <br>
            <label>Password: </label>
            <input type="text" name="c_password" value="${v_password}">
            <br>
            <input type="submit" value="Log in">
            <p>${logoutMessage}</p>
        </form>
    </body>
</html>
