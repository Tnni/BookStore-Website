<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="header.jsp"/>

    <div class="container">

        <div class="row">
      
            <div class="col-md-12">
                <div>
                    <ol class="breadcrumb">
                        <li class="active">Shopping Cart</li>
                    </ol>
                </div>
                <!-- /.div -->
    <div class="row">
        <div class="col-sm-12 col-md-10 col-md-offset-1">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Book Name</th>
                        <th>Quantity</th>
                        <th class="text-center">Price</th>
                        <th class="text-center">Total</th>
                        <th> </th>
                    </tr>
                </thead>
                <tbody><c:forEach var="it" items="${cart}">
                	<tr>
                        <td class="col-sm-8 col-md-6">
                        <div class="media">
                            <a class="thumbnail pull-left" href="detail?id=${it.bookId}"> <img class="media-object" src="assets/img/<c:if test="${it.bookImg !='' }">${it.bookImg}</c:if><c:if test="${it.bookImg ==null }">no.gif</c:if>" style="width: 72px; height: 72px;"> </a>
                            <div class="media-body">
                                <h4 class="media-heading"><a href="detail?id=${it.bookId}">${it.bookName}</a></h4>
                            </div>
                        </div></td>
                        <td class="col-sm-1 col-md-1" style="text-align: center">
                            <input type="number" class="form-control" id="exampleInputEmail1" value="${it.quantity}" min="1" onchange="chgNum(${it.bookId}, this.value)">
                        </td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>$${it.price}</strong></td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>$${it.total}</strong></td>
                        <td class="col-sm-1 col-md-1">
                        <button type="button" class="btn btn-danger" onclick="del(${it.bookId})">
                            <span class="glyphicon glyphicon-remove"></span> Remove
                        </button></td>
                    </tr></c:forEach>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h3>Total</h3></td>
                        <td class="text-right"><h3><strong>$${subTotal}</strong></h3></td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td>
                        <button type="button" class="btn btn-primary" onclick="location.href='./';">
                            <span class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping
                        </button></td>
                        <td>
                        <button type="button" class="btn btn-success" onclick="location.href='payment';">
                            Pay the Bill <span class="glyphicon glyphicon-play"></span>
                        </button></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
    <script type="text/javascript">
        function chgNum(id, num){
            window.location.replace('?act=change&id='+id+'&num='+num);
        }
        function del(id){
        	window.location.replace('?act=delete&id='+id);
        }
    </script>                </div>
                <!-- /.row -->
                
            </div>
            <!-- /.col -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /.container -->

<c:import url="footer.jsp"/>