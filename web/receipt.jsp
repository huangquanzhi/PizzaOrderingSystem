<%-- 
    Document   : receipt
    Created on : Nov 9, 2015, 10:43:08 AM
    Author     : Jackie
--%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thank you for your order</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="js/bootstrap.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">
            <c:if test="${fn:length(cart) > 0}">
                <c:if test="${deliveryQty > 0}">


                    <div class="row">
                        <div class="col-md-8 col-md-offset-2">
                            <div class="alert alert-success" role="alert">Customer Information</div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-8 col-md-offset-2">
                            <table class='table table-hover'>
                                <tbody>
                                    <tr>
                                        <td><strong>Customer ID</strong></td>
                                        <td>${user.userID}</td>
                                    </tr>
                                    <tr>
                                        <td><strong>Customer Name</strong></td>
                                        <td>${user.firstName}, ${user.lastName}</td>
                                    </tr>
                                    <tr>
                                        <td><strong>Address</strong></td>
                                        <td>${user.address}</td>
                                    </tr>
                                    <tr>
                                        <td><strong>Phone</strong></td>
                                        <td>${user.phone}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>


                    <div class="row">
                        <div class="col-md-8 col-md-offset-2">
                            <div class="alert alert-success" role="alert">Delivery Orders</div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-8 col-md-offset-2">
                            <table class='table table-hover'>
                                <thead><tr><th>Pizza Size</th><th>Pizza Toppings</th><th>Pizza Topping Count</th><th>Pizza Price</th><th>Qty</th></tr></thead>
                                <tbody>

                                    <c:forEach var="pizza" items="${cart}" varStatus="loop">
                                        <c:if test="${pizza.delivery eq true}">
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
                                            </tr>
                                        </c:if>
                                    </c:forEach>
                                </tbody>
                            </table>

                            <blockquote>
                                <p>Reminder: Delivery takes around 1 hour!</p>
                            </blockquote>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-4 col-md-offset-6">
                            <table class="table table-bordered">
                                <thead><tr><th>Delivery Qty</th><th>Delivery Price</th></tr></thead>
                                <tbody>
                                    <tr><td>${deliveryQty}</td><td>${deliveryPrice}</td></tr>
                                </tbody>
                            </table>
                        </div>
                    </div>

                </c:if>

                <c:if test="${pickupQty > 0}">
                    <div class="row">
                        <div class="col-md-8 col-md-offset-2">
                            <div class="alert alert-success" role="alert">Pickup Orders</div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-8 col-md-offset-2">
                            <table class='table table-hover'>   
                                <thead><tr><th>Pizza Size</th><th>Pizza Toppings</th><th>Pizza Topping Count</th><th>Pizza Price</th><th>Qty</th></tr></thead>
                                <tbody>
                                    <c:forEach var="pizza" items="${cart}" varStatus="loop">
                                        <c:if test="${pizza.delivery eq false}">
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
                                            </tr>
                                        </c:if>
                                    </c:forEach>
                                </tbody>
                            </table>

                            <blockquote>
                                <p>Pickup takes around 2 hours!</p>
                            </blockquote>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-4 col-md-offset-6">
                            <table class="table table-bordered">
                                <thead><tr><th>Pickup Qty</th><th>Pickup Price</th></tr></thead>
                                <tbody>
                                    <tr><td>${pickupQty}</td><td>${pickupPrice}</td></tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </c:if>
            </c:if>
            <div class="row">
                <div class="col-md-3 col-md-offset-1">
                    <div class="form-group has-success has-feedback">
                        <label class="control-label col-sm-3" for="inputGroupSuccess1">Total Qty</label>
                        <div class="col-sm-9">
                            <div class="input-group">
                                <span class="input-group-addon">Qty </span>
                                <input type="text" class="form-control" id="inputGroupSuccess1" aria-describedby="inputGroupSuccess1Status" disabled="disabled" value="${totalQty}">
                            </div>
                            <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                            <span id="inputGroupSuccess1Status" class="sr-only">(success)</span>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="form-group has-success has-feedback">
                        <label class="control-label col-sm-3" for="inputGroupSuccess2">Total Price</label>
                        <div class="col-sm-9">
                            <div class="input-group">
                                <span class="input-group-addon">$ </span>
                                <input type="text" class="form-control" id="inputGroupSuccess2" aria-describedby="inputGroupSuccess2Status"  disabled="disabled" value="<fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${totalPrice}" />">
                            </div>
                            <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                            <span id="inputGroupSuccess2Status" class="sr-only">(success)</span>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="form-group has-success has-feedback">
                        <label class="control-label col-sm-3" for="inputGroupSuccess3">After Tax (13%)</label>
                        <div class="col-sm-9">
                            <div class="input-group">
                                <span class="input-group-addon">$ </span>
                                <input type="text" class="form-control" id="inputGroupSuccess3" aria-describedby="inputGroupSuccess3Status"  disabled="disabled" value="<fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${totalPriceAfterTax}" />">
                            </div>
                            <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                            <span id="inputGroupSuccess3Status" class="sr-only">(success)</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <a href="<c:url value="index.jsp" />" class="btn btn-block btn-success" type="button" role="button" >Back to Login</a>
                </div>
            </div>

        </div>
    </body>
</html>
