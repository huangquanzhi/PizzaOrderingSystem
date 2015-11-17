<%-- 
    Document   : dashboard
    Created on : Nov 9, 2015, 10:43:39 AM
    Author     : Jackie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Dashboard</title>
        <script src="https://code.jquery.com/jquery-2.1.4.min.js" type="text/javascript"></script>       
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="../js/bootstrap.js" type="text/javascript"></script>
        <style>
            body{
                background-image: url("../img/paper_background.jpg");
            }
        </style>

    </head>
    <body>
        <div class="container">
            <div class="row" style="margin-top:20%">
                <div class="panel panel-default">
                    <div class="panel-heading">Admin Actions Panel</div>
                    <div class="panel-body">

                        <a href="AdminController" class="btn btn-info btn-lg">Show all orders</a>
                        <a href="../" class="btn btn-warning btn-lg">Return to Index</a>
                    </div>
                </div>
            </div>
    </body>
</html>
