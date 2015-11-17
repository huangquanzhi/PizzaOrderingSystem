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
        <style>
            body{
                background-image: url(" img/welcome.png"); 
            }
        </style>
        
        
    </head>
    <body>


        <div class="container">
            <div class="row" style="margin-top: 25%">
                
            </div>
            <div class="jumbotron">
                <h1>Welcome Back, </h1>
                <p>${user.firstName}, ${user.lastName}</p>
                <p>
                <form action="<c:url value="order.jsp"/>" method="post">
                    <button class="btn btn-block btn-success"> Order Pizza </button>
                </form>
                </p>
            </div>
        </div>
    </body>
</html>
