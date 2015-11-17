<%-- 
    Document   : error
    Created on : Nov 9, 2015, 10:26:07 AM
    Author     : Jackie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
                <style>
            body{
                background-image: url("img/paper_background.jpg");
            }
        </style>
    </head>
    <body>
        

        <div class="container">
            <div class="row" style="margin-top: 25%">
                
            </div>
            <div class="jumbotron">
                <h1>${error} </h1>
                <p>
                    <a class="btn btn-block btn-success" href="index.jsp"> Back to Index </a>
             
                </p>
            </div>
        </div>
        
    </body>
</html>
