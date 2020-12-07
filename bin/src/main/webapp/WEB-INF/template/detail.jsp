<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="header.jsp"/>
<style>
ul > li{margin-right:25px;font-weight:lighter;cursor:pointer}
li.active{border-bottom:3px solid silver;}
.container{margin:0px auto;}
.item-photo{display:flex;justify-content:center;align-items:center;border-right:1px solid #f6f6f6;}
.menu-items{list-style-type:none;font-size:11px;display:inline-flex;margin-bottom:0;margin-top:20px}
.btn-success{width:100%;border-radius:0;}
.section{width:100%;margin-left:-15px;padding:2px;padding-left:15px;padding-right:15px;background:#f8f9f9}
.title-price{margin-top:30px;margin-bottom:0;color:black}
.title-attr{margin-top:0;margin-bottom:0;color:black;}
.btn-minus{cursor:pointer;font-size:7px;display:flex;align-items:center;padding:5px;padding-left:10px;padding-right:10px;border:1px solid gray;border-radius:2px;border-right:0;}
.btn-plus{cursor:pointer;font-size:7px;display:flex;align-items:center;padding:5px;padding-left:10px;padding-right:10px;border:1px solid gray;border-radius:2px;border-left:0;}
div.section > div {width:100%;display:inline-flex;}
div.section > div > input {margin:0;padding-left:5px;font-size:10px;padding-right:5px;max-width:18%;text-align:center;}
.attr,.attr2{cursor:pointer;margin-right:5px;height:20px;font-size:10px;padding:2px;border:1px solid gray;border-radius:2px;}
.attr.active,.attr2.active{ border:1px solid orange;}

@media (max-width: 426px) {
    .container {margin-top:0px !important;}
    .container > .row{padding:0 !important;}
    .container > .row > .col-xs-12.col-sm-5{
        padding-right:0 ;    
    }
    .container > .row > .col-xs-12.col-sm-9 > div > p{
        padding-left:0 !important;
        padding-right:0 !important;
    }
    .container > .row > .col-xs-12.col-sm-9 > div > ul{
        padding-left:10px !important;
        
    }            
    .section{width:104%;}
    .menu-items{padding-left:0;}
}
</style>
        <div class="container">
        	<div class="row">
               <div class="col-xs-4 item-photo">
                    <img style="max-width:100%;" src="assets/img/<c:if test="${o.img !='' }">${o.img}</c:if><c:if test="${o.img ==null }">no.gif</c:if>" />
                </div>
                <div class="col-xs-5" style="border:0px solid gray">
                    <!-- Datos del vendedor y titulo del producto -->
                    <h3>${o.title}</h3>
                    <h5 style="color:#337ab7">
	                    <input type="range" value="${o.rank}" min="1.0" max="5.0" step="0.1" title="rate this book" onchange="rateBookPreview(this.value)" onclick="rateBook(this.value)" style="width:20%;float:left;margin-right:5px;">
	                    <span id="ratePreview"></span>
	                    Rating ${o.rank }
	                    <!--<a class="fa fa-star"></a><a class="fa fa-star"></a><a class="fa fa-star"></a><a class="fa fa-star-half-empty"></a><a class="fa fa-star-o"></a>-->
	                     · 
	                    <small style="color:#337ab7">(${o.ranker } votes)</small>
                    </h5>

                    <!-- Detalles especificos del producto -->
                    <div class="section">
                        <h6 class="title-attr" style="margin-top:15px;" ><small>Introduction</small></h6>
                        <div>
                            ${o.intro }
                        </div>
                    </div><!--
                    <div class="section">
                        <h6 class="title-attr" style="margin-top:15px;" ><small>COLOR</small></h6>
                        <div>
                            <div class="attr" style="width:25px;background:#5a5a5a;"></div>
                            <div class="attr" style="width:25px;background:white;"></div>
                        </div>
                    </div>
                    <div class="section" style="padding-bottom:5px;">
                        <h6 class="title-attr"><small>CAPACIDAD</small></h6>
                        <div>
                            <div class="attr2">16 GB</div>
                            <div class="attr2">32 GB</div>
                        </div>
                    </div>
                    -->

                    <!-- Price -->
                    <h6 class="title-price"><small>Price</small></h6>
                    <h3 style="margin-top:0px;">$${o.price }</h3>

                    <div class="section" style="padding-bottom:20px;">
                        <h6 class="title-attr"><small>Quantity</small></h6>
                        <div>
                            <div class="btn-minus"><span class="glyphicon glyphicon-minus"></span></div>
                            <input id="qu" value="1" />
                            <div class="btn-plus"><span class="glyphicon glyphicon-plus"></span></div>
                        </div>
                    </div>

                    <!-- Botones de compra -->
                    <div class="section" style="padding-bottom:20px;">
                        <button class="btn btn-success" onclick="add2cart(${o.bid})"><span style="margin-right:20px" class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> Add to Cart</button>
                    </div>
                </div>

                <div class="col-xs-9">
                    <ul class="menu-items">
                        <li class="active fa fa-comments"> Reviews</li><!--
                        <li>Garantía</li>
                        <li>Vendedor</li>
                        <li>Envío</li>-->
                    </ul>
                    <div style="width:100%;border-top:1px solid silver">
                        <p style="padding:15px;clear:both;"><!--
                            <small>
                            Stay connected either on the phone or the Web with the Galaxy S4 I337 from Samsung. With 16 GB of memory and a 4G connection, this phone stores precious photos and video and lets you upload them to a cloud or social network at blinding-fast speed. With a 17-hour operating life from one charge, this phone allows you keep in touch even on the go.

                            With its built-in photo editor, the Galaxy S4 allows you to edit photos with the touch of a finger, eliminating extraneous background items. Usable with most carriers, this smartphone is the perfect companion for work or entertainment.
                            </small>-->
                        </p>
                        <form class="form-horizontal" action="" method="post">
                        	<input type="hidden" name="bid" value="${o.bid}">
					        <div class="form-group">
					            <label class="col-sm-2 control-label"><i class="fa fa-edit"></i> Your Review</label>
					            <div class="col-sm-10">
					                <textarea class="form-control" name="rvw" cols="10" style="width:100%;"></textarea>
					            </div>
					        </div>
					        <div class="form-group">
					            <div class="col-sm-10 col-sm-offset-2">
					                <button class="btn btn-primary"><i class="fa fa-check"></i> Submit</button>
					            </div>
					        </div>
					    </form>
					    <ul><c:forEach var="it" items="${ol}">
		                  <li>
		                    <div class="comment-bubble">
		                      <h4>${it.dates } - <strong>${it.author }</strong></h4>
		                      ${it.content }
		                    </div>
		                  </li></c:forEach>
		                </ul>
                    </div>
                </div>
            </div>
        </div>
<script>
$(document).ready(function(){
    //-- Click on detail
    $("ul.menu-items > li").on("click",function(){
        $("ul.menu-items > li").removeClass("active");
        $(this).addClass("active");
    })

    $(".attr,.attr2").on("click",function(){
        var clase = $(this).attr("class");

        $("." + clase).removeClass("active");
        $(this).addClass("active");
    })

    //-- Click on QUANTITY
    $(".btn-minus").on("click",function(){
        var now = $(".section > div > input").val();
        if ($.isNumeric(now)){
            if (parseInt(now) -1 > 0){ now--;}
            $(".section > div > input").val(now);
        }else{
            $(".section > div > input").val("1");
        }
    })            
    $(".btn-plus").on("click",function(){
        var now = $(".section > div > input").val();
        if ($.isNumeric(now)){
            $(".section > div > input").val(parseInt(now)+1);
        }else{
            $(".section > div > input").val("1");
        }
    })                        
});
function add2cart(bid){
	window.location.href = 'cart?act=add&id='+bid+'&num='+$('#qu').val();
}
function rateBookPreview(val){
	$('#ratePreview').html(val);
}
function rateBook(val){
	$.post('rate', {'id':${o.bid}, 'v':val}, function(js){
		alert(js.msg);
	}, 'json');
}
</script>
<jsp:include page="footer.jsp"></jsp:include>
