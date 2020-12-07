<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="header.jsp"/>

    <div class="container">

        <div class="row">
      
            <div class="col-md-12">
<style type="text/css">
.paymentWrap {
	padding: 50px;
}

.paymentWrap .paymentBtnGroup {
	max-width: 800px;
	margin: auto;
}

.paymentWrap .paymentBtnGroup .paymentMethod {
	padding: 40px;
	box-shadow: none;
	position: relative;
}

.paymentWrap .paymentBtnGroup .paymentMethod.active {
	outline: none !important;
}

.paymentWrap .paymentBtnGroup .paymentMethod.active .method {
	border-color: #4cd264;
	outline: none !important;
	box-shadow: 0px 3px 22px 0px #7b7b7b;
}

.paymentWrap .paymentBtnGroup .paymentMethod .method {
	position: absolute;
	right: 3px;
	top: 3px;
	bottom: 3px;
	left: 3px;
	background-size: contain;
	background-position: center;
	background-repeat: no-repeat;
	border: 2px solid transparent;
	transition: all 0.5s;
}

.paymentWrap .paymentBtnGroup .paymentMethod .method.visa {
	background-image: url("data:image/png;base64,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");
}

.paymentWrap .paymentBtnGroup .paymentMethod .method.master-card {
	background-image: url("data:image/png;base64,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");
}

.paymentWrap .paymentBtnGroup .paymentMethod .method.amex {
	background-image: url("data:image/png;base64,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");
}

.paymentWrap .paymentBtnGroup .paymentMethod .method.vishwa {
	background-image: url("data:image/png;base64,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");
}

.paymentWrap .paymentBtnGroup .paymentMethod .method.ez-cash {
	background-image: url("data:image/png;base64,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");
}


.paymentWrap .paymentBtnGroup .paymentMethod .method:hover {
	border-color: #4cd264;
	outline: none !important;
}
.panel-default .panel-heading {
	background: transparent; font-weight: bold;
}
</style>
                <div>
                    <ol class="breadcrumb">
                        <li class="active">Payment</li>
                    </ol>
                </div>
                <!-- /.div -->
	<div class="row col-sm-8 col-md-12">

                    <div class="col-sm-8 col-md-6 panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title" style="font-weight: bold; padding: 8px 0;">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
                                    Contact and Billing Information</a>
                            </h3>
                        </div><form action="" method="post">
                        <div id="collapseTwo" class="panel-collapse">
                            <div class="panel-body">
                                <table class="table table-striped" style="font-weight: bold;">
                                    <tr>
                                        <td>
                                            <label for="id_first_name">Your name:</label></td>
                                        <td>
                                            <input class="form-control" id="id_first_name" name="first_name"
                                                   required="required" type="text" value="${user.name}"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label for="id_phone">Phone:</label></td>
                                        <td>
                                            <input class="form-control" id="id_phone" name="phone" type="text" value="${user.phone}" required />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label for="id_address_line_1">Address:</label></td>
                                        <td>
                                            <input class="form-control" id="id_address_line_1"
                                                   name="address_line_1" required="required" type="text" value="${user.addr}"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label for="id_postalcode">Credit Card:</label></td>
                                        <td>
                                            <input class="form-control" id="id_card" name="card"
                                                   type="text" value="" required/>
                                        </td>
                                    </tr>
                                </table></form>
                            </div>
                        </div>
                    </div>

		<div class="col-sm-8 col-md-6 paymentCont">
			<div class="headingWrap">
				<h3 class="headingTop text-center">Supported Payment Method</h3>	
				<p class="text-center"></p>
			</div>
			<br><br>
			<div class="paymentWrap">
			  <div class="btn-group paymentBtnGroup btn-group-justified" data-toggle="buttons">
		            <label class="btn paymentMethod">
		            	<div class="method visa"></div>
		                <input type="radio" name="options" value="visa" checked> 
		            </label>
		            <label class="btn paymentMethod">
		            	<div class="method master-card"></div>
		                <input type="radio" name="options" value="mastercard"> 
		            </label>
		            <label class="btn paymentMethod">
	            		<div class="method amex"></div>
		                <input type="radio" name="options" value="gpay">
		            </label>
		             <label class="btn paymentMethod">
	             		<div class="method vishwa"></div>
		                <input type="radio" name="options" value="paypal"> 
		            </label>
		            <label class="btn paymentMethod">
	            		<div class="method ez-cash"></div>
		                <input type="radio" name="options" value="alipay"> 
		            </label>
		            </div>        
			</div>
			<div id="div-pay" style="text-align:center;visibility:hidden;"></div>
			<div class="footerNavWrap clearfix">
				<div class="btn btn-primary pull-left btn-fyi" onclick="location.href='./';"><span class="glyphicon glyphicon-chevron-left"></span> Continue Shopping</div>
				<div class="btn btn-success pull-right btn-fyi" onclick="doCheckOut()">Confirm Order <span class="glyphicon glyphicon-chevron-right"></span><i class="fa fa-paypal"></i></div>
			</div>
		</div>

	</div>

	<script type="text/javascript">
		function doCheckOut(){
			if($('#id_card').val().length < 6){
				alert('Please input credit card');
				$('#id_card').focus();
				return;
			}
			$('form').submit();
		}
	</script>
                </div>
                <!-- /.row -->
                
            </div>
            <!-- /.col -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /.container -->

<c:import url="footer.jsp"/>