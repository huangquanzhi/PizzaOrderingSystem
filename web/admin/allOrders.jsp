<%-- 
    Document   : allOrders
    Created on : Nov 16, 2015, 4:11:22 PM
    Author     : Jackie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show All Orders</title>
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
            <div class="row" style="margin-top: 5%">
                <div class="col-md-8 col-md-offset-2">
                    <div class="alert alert-success" role="alert">
                        <div class="row">
                            <div class="col-sm-8">
                                All Orders
                            </div>
                            <div class="col-sm-2 col-sm-offset-1">
                                <a href="dashboard.jsp" class="btn btn-info" >Return to Admin</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <div class="scroll" style="overflow-y: scroll;height:500px !important;">
                        <table class="table table-responsive">
                            <thead>
                                <tr>
                                    <th> # </th>
                                    <th>Size</th>
                                    <th> Qty </th>
                                    <th>Price</th>
                                    <th>Customer ID</th>
                                    <th>Customer Name</th>
                                    <th>Customer Phone</th>
                                    <th>Customer Address</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="p" items="${pizzas}" varStatus="i">
                                    <tr>
                                        <td>${i.index}</td>
                                        <td>${p.size}</td>
                                        <td>${p.qty}</td>
                                        <td>$ ${p.price}</td>
                                        <td><c:out value="${users[i.index].userID}" /></td>
                                        <td><c:out value="${users[i.index].firstName}" /> ,<c:out value="${users[i.index].lastName}" /></td>
                                        <td>
                                            <c:set value="${users[i.index].phone}" var="phone"/>
                                            <c:out value="(${fn:substring(phone, 0, 3)}) ${fn:substring(phone, 3, 6)} - ${fn:substring(phone, 6, fn:length(phone))}" />
                                        </td>
                                        <td><c:out value="${users[i.index].address}" /></td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="row" style="margin-bottom: 10%; margin-top: 5%">
                <div class="col-md-3 col-md-offset-1">
                    <div class="form-group has-success has-feedback">
                        <label class="control-label col-sm-3" for="inputGroupSuccess1">Total Orders</label>
                        <div class="col-sm-9">
                            <div class="input-group">
                                <span class="input-group-addon">Amount: </span>
                                <input type="text" class="form-control" id="inputGroupSuccess1" aria-describedby="inputGroupSuccess1Status" disabled="disabled" value="${totalOrders}">
                            </div>
                            <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                            <span id="inputGroupSuccess1Status" class="sr-only">(success)</span>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="form-group has-success has-feedback">
                        <label class="control-label col-sm-3" for="inputGroupSuccess2">Total Qty</label>
                        <div class="col-sm-9">
                            <div class="input-group">
                                <span class="input-group-addon"> Qty: </span>
                                <input type="text" class="form-control" id="inputGroupSuccess2" aria-describedby="inputGroupSuccess2Status"  disabled="disabled" value="${totalQty}" />
                            </div>
                            <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                            <span id="inputGroupSuccess2Status" class="sr-only">(success)</span>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="form-group has-success has-feedback">
                        <label class="control-label col-sm-3" for="inputGroupSuccess3">Total Balance</label>
                        <div class="col-sm-9">
                            <div class="input-group">
                                <span class="input-group-addon">$ </span>
                                <input type="text" class="form-control" id="inputGroupSuccess3" aria-describedby="inputGroupSuccess3Status"  disabled="disabled" value="<fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${balance}" />">
                            </div>
                            <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                            <span id="inputGroupSuccess3Status" class="sr-only">(success)</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
