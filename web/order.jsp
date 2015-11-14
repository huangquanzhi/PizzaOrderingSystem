<%-- 
    Document   : order.jsp
    Created on : Nov 9, 2015, 10:42:58 AM
    Author     : Jackie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome To the Order Page</title>
        <script src="https://code.jquery.com/jquery-2.1.4.min.js" type="text/javascript"></script>       
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="js/bootstrap.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">

            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">Pizza Online</a>
                    </div>
                    <ul class="nav navbar-nav navbar-right">
                        <!-- Collect the nav links, forms, and other content for toggling -->
                        <li style='cursor:pointer'><a data-toggle="modal" data-target="#cart"><span
                                    class="glyphicon glyphicon-list-alt"></span> Cart </a></li>
                    </ul>
                    <div class="modal fade  bs-modal-lg" id="cart">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                            aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title">Cart</h4>
                                </div>
                                <div class="modal-body" id="invent-pop">

                                    <table class='table table-hover'>
                                        <thead><tr><th>Pizza Size</th><th>Pizza Toppings</th><th>Pizza Topping Count</th><th>Pizza Price</th><th>Qty</th><th>Method</th></tr></thead>
                                        <tbody>

                                            <c:if test="${fn:length(cart) > 0}">
                                                <c:forEach var="pizza" items="${cart}" varStatus="loop">
                                                    <tr>
                                                        <td>${pizza.size}</td>
                                                        <td>
                                                            <c:forEach var="toppings" items="${pizza.topping}">
                                                                ${toppings}     
                                                            </c:forEach>
                                                        </td>
                                                        <td>${pizza.toppingCount}</td>
                                                        <td>$ ${pizza.price}</td>
                                                        <td>${pizza.qty}</td>
                                                        <td>
                                                            <c:choose>
                                                                <c:when test="${pizza.delivery}">
                                                                    Delivery
                                                                </c:when>
                                                                <c:when test="${!pizza.delivery}">
                                                                    Pick Up
                                                                </c:when>
                                                            </c:choose>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </c:if>
                                        </tbody>
                                    </table>
                                    <div class="modal-footer">
                                        <a class="btn btn-success" href="<%= response.encodeURL("checkout.jsp")%>">Check Out</a>
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                    </div>
                                </div>
                                <!-- modal-content -->
                            </div>
                            <!-- modal-dialog -->
                        </div>
                        <!-- modal -->
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>
            <div class="row" style="margin-top: 30%">



            </div>

            <div class="row">
                <div class="col-sm-7">

                    <form action="PizzaOrder" method="post">

                        <div class="row">
                            <div class="form-group">
                                <div class="panel panel-info">
                                    <div class="panel-heading">Pick up or delivery? </div>
                                    <div class="panel-body">
                                        <select class="form-control" name="delivery">
                                            <option value="false">Pickup</option>
                                            <option value="true">Delivery</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>    
                        <div class="row">
                            <div class="form-group">
                                <div class="panel panel-info">
                                    <div class="panel-heading">Pizza Size</div>
                                    <div class="panel-body">
                                        <label class="radio-inline">
                                            <input type="radio" name="pizzasize" value="small"> ($5) Small
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="pizzasize" value="large"> ($7) Large
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <div class="panel panel-info">
                                    <div class="panel-heading">Choose toppings: <br> ($1/topping -  If 3 toppings are selected, the 4th is free) </div>
                                    <div class="panel-body">
                                        <label class="checkbox-inline">
                                            <input type="checkbox" name="toppings" value="Pepperoni"> Pepperoni
                                        </label>
                                        <label class="checkbox-inline">
                                            <input type="checkbox" name="toppings" value="Sausage"> Sausage
                                        </label>
                                        <label class="checkbox-inline">
                                            <input type="checkbox" name="toppings" value="Minced Garlic"> Minced Garlic
                                        </label>
                                        <label class="checkbox-inline">
                                            <input type="checkbox" name="toppings" value="Brocoli"> Brocoli
                                        </label>
                                        <label class="checkbox-inline">
                                            <input type="checkbox" name="toppings" value="Chicken"> Chicken
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            Qty : <input type="number" class="form-control" name="qty">
                        </div>
                        <div class="row">

                            <div class="well well-lg">

                                Reminder:<br>
                                <br>
                                ---------------------------------------<br>
                                - Delivery time is 1 hr after your order is placed!<br>
                                - Pick up time is 2 hrs after your order is placed!<br>
                                ---------------------------------------<br>
                            </div>
                        </div>
                        <div class="row">
                            <button type="submit" class="btn btn-block btn-success">Add to Cart</button>
                        </div>
                    </form>
                </div>

                <!-- right side information -->
                <div class="col-sm-5">
                    <div class="panel panel-info">
                        <div class="panel-heading">Your Information </div>
                        <div class="panel-body">

                            <div class="form-horizontal">
                                <div class="form-group">
                                    <label class="col-sm-4 control-label">User Name: </label>
                                    <div class="col-sm-8">
                                        <p class="form-control-static">${user.userName}</p>
                                    </div>
                                </div>

                                <div class="form-horizontal">
                                    <div class="form-group">
                                        <label class="col-sm-4 control-label">Customer Name: </label>
                                        <div class="col-sm-8">
                                            <p class="form-control-static">${user.firstName}, ${user.lastName}</p>
                                        </div>
                                    </div>

                                    <div class="form-horizontal">
                                        <div class="form-group">
                                            <label class="col-sm-4 control-label">Phone Number: </label>
                                            <div class="col-sm-8">
                                                <p class="form-control-static">${user.phone}</p>
                                            </div>
                                        </div>
                                        <div class="form-horizontal">
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label">Address: </label>
                                                <div class="col-sm-8">
                                                    <p class="form-control-static">${user.address}</p>
                                                </div>
                                            </div>
                                            <form action="Checkout" method="post">
                                                <button type="button" class="btn btn-info btn-block">View Cart: items</button>

                                                <button type="button" class="btn btn-success btn-block">Check Out</button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row" style="margin-bottom: 20%">


            </div>

        </div>

    </body>
</html>
