<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="header.jsp"/>
    <div class="container">

        <div class="row">
      
            <div class="col-md-12">
                <div>
                    <ol class="breadcrumb">
                        <li class="active">Books List</li>
                    </ol>
                </div>
                <!-- /.div -->
                <div class="row">
                    <div class="btn-group alg-right-pad">
                        <button type="button" class="btn btn-danger"><strong>${cat.name}</strong></button>
                        <div class="btn-group">
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                Category &nbsp;<span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu"><c:forEach var="it" items="${catList}" varStatus="status">
                                <li><a href="?cat=${it.cid}">${it.name}</a></li>
                                <c:if test="${status.last == false}"><li class="divider"></li></c:if></c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- /.row -->
                <div class="row"><c:forEach var="it" items="${list}">
                    <div class="col-md-3 text-center col-sm-6 col-xs-6">
                        <div class="thumbnail product-box">
                            <a href="detail?id=${it.bid}"><img src="assets/img/<c:if test="${it.img !='' }">${it.img}</c:if><c:if test="${it.img ==null }">no.gif</c:if>" alt="" /></a>
                            <div class="caption">
                                <h3><a href="#">${it.title}</a></h3>
                                <p>Price : <strong>$ ${it.price}</strong>  </p>
                                <p><a href="cart?act=add&id=${it.bid}" class="btn btn-success" role="button"><span class="glyphicon glyphicon-shopping-cart"></span> Add To Cart</a></p>
                            </div>
                        </div>
                    </div>
                    <!-- /.col --></c:forEach>
                </div>
                <!-- /.row -->
                </div>
                <!-- /.row -->
                
            </div>
            <!-- /.col -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /.container -->
    
<c:import url="footer.jsp"/>