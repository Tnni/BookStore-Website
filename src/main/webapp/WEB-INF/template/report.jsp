<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="header.jsp"/>

    <div class="container">

        <div class="row">
      
            <div class="col-md-12">
                <div>
                    <ol class="breadcrumb">
                        <li class="active">Report</li>
                    </ol>
                </div>
                <!-- /.div -->
                <div class="row">

    <div class="modal-dialog" style="margin-bottom: 10%;">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title text-center" id="myModalLabel">Books sold ${month}</h4>
            </div>
            <div class="modal-body" id = "model-body">
                <div class="form-group center">
                    Choose month:
                    <select name="month" id="month" onchange="location.href='?month='+this.value">
                    	<option value="2020-11">November</option>
                    	<option value="2020-12">December</option>
                    </select>
                </div>
                    <table class="col-md-12">
                    	<tr><th>Book ID</th><th>Book Name</th><th>Sold</th></tr><c:forEach var="it" items="${list}">
                    	<tr><td>${it.bid}</td><td>${it.title}</td><td>${it.sold}</td></tr></c:forEach>
                    </table>
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