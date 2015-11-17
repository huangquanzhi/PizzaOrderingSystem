<%-- 
    Document   : index
    Created on : Nov 10, 2015, 2:13:49 PM
    Author     : Jackie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Pizza Ordering</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://code.jquery.com/jquery-2.1.4.min.js" type="text/javascript"></script>       
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <link href="css/indexstyle.css" rel="stylesheet" type="text/css"/>
        <style>
            body{
                background-image: url("img/main.jpg");
            }
        </style>
        <script>
$('#register').on('shown.bs.modal', function () {
    $('#register').focus()
})
        </script>



    </head>
    <body>
        <div class="container" id="frame">
            <div class="row" style="margin-top:10%">

            </div>
            <div class="row" id="mainlog">
                <div class="col-md-6 col-md-offset-3">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Welcome to Pizza Shop
                        </div>
                        <div class="panel-body" style="padding: 10%">
                            <form action="<c:url value="UserLogin" />" method="post">
                                <div class="row">
                                    Username: <input type="text" class="form-control" name="username" required/> 
                                </div>
                                <div class="row">
                                    Password: <input type="password" class="form-control" name="password" required/>
                                </div>
                                <div class="row" style="margin-top: 3%">
                                    <button type="submit" class="btn btn-success btn-block" >Log In</button>   
                                </div>
                            </form>
                        </div>
                        <div class="panel-footer">
                            <div class="row">
                                <div class="col-md-4 col-md-offset-2">
                                    <a class="btn btn-default" data-toggle="modal" data-target="#register" >Register</a>
                                </div>
                                <div class="col-md-4">
                                    <a class="btn btn-warning " href="admin/dashboard.jsp" >Go to Admin</a>
                                </div>
                            </div>
                        </div>  
                    </div>
                </div>

            </div>

            <div class="row" style="margin-bottom: 20%">

            </div>

            <!-- register -->
            <div class="modal fade" id="register" tabindex="-1" role="dialog" aria-labelledby="register">
                <div class="modal-dialog  modal-lg"  role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">Register</h4>
                        </div>
                        <div class="modal-body">

                            <form action="<c:url value="UserRegister" />" method="post" class="form-horizontal">
                                <div class="form-group">
                                    <label for="regusername" class="col-sm-2 control-label"> Username: </label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="username" id="regusername" required pattern=".{3,}" title="3 characters minimum">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="regusername" class="col-sm-2 control-label"> Password: </label>
                                    <div class="col-sm-10">
                                        <input type="password" class="form-control" name="password" required pattern=".{3,}" title="3 characters minimum">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="regusername" class="col-sm-2 control-label"> First Name: </label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="firstname" required pattern=".{1,}" title="1 characters minimum">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="regusername" class="col-sm-2 control-label"> Last Name: </label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="lastname" required pattern=".{1,}" title="1 characters minimum">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="regusername" class="col-sm-2 control-label"> Phone: </label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="phone"  required pattern="[0-9]{10}" title="10 numbers required">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="regusername" class="col-sm-2 control-label"> Address: </label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="address" required pattern=".{3,}" title="3 characters minimum">
                                    </div>
                                </div>
                                <button type="submit" class="btn btn-success btn-lg btn-block"> Register </button>

                            </form>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->


        </div>
    </body>
</html>
