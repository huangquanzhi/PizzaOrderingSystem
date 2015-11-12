<%-- 
    Document   : welcome
    Created on : Nov 11, 2015, 1:38:33 PM
    Author     : Jackie
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome!</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <div class="row">
        <h1>Welcome, ${user.firstName}, ${user.firstName}</h1>
            </div>
            <div class="row">
                <form action="<c:url value="PizzaOrder"/>" method="post">
                    <button class="btn btn-block btn-success">Order Pizza -> </button>
                </form>
            </div>
        </div>
    </body>
</html>
