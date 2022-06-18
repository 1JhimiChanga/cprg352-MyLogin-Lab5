<%-- 
    Document   : home
    Created on : 11-Jun-2022, 2:20:01 PM
    Author     : Jimmy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <h4>Hello ${loggedUsername}.</h4>
        <a href="login?logout">Log out</a>
    </body>
</html>
