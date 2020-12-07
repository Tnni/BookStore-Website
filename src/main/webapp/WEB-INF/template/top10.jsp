<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="header.jsp"/>

    <div class="container">

        <div class="row">
      
            <div class="col-md-12">
                <div>
                    <ol class="breadcrumb">
                        <li class="active">Top 10</li>
                    </ol>
                </div>
                <!-- /.div -->
                <div class="row">

    <div class="modal-dialog" style="margin-bottom: 10%;">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title text-center" id="myModalLabel">Books sold top 10</h4>
            </div>
            <div class="modal-body" id = "model-body">
                <div class="form-group">
                    <table class="col-md-12">
                    	<tr><th>Book Name</th><th>Sold Total</th></tr><c:forEach var="it" items="${list}">
                    	<tr><td>${it.title}</td><td>${it.sold}</td></tr></c:forEach>
                    </table>
                </div>
            </div>
            <div class="modal-footer" style="border:0;">
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->

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