<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="header.jsp"/>

    <div class="container">

        <div class="row">
      
            <div class="col-md-12">
                <div>
                    <ol class="breadcrumb">
                        <li class="active">New User Sign Up</li>
                    </ol>
                </div>
                <!-- /.div -->
                <div class="row">
                    <form action="" method="post">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="modal-title text-center" id="myModalLabel">Create an account</h4>
                                </div>
                                <div class="modal-body" id = "model-body">
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="ni" placeholder="Username" required>
                                    </div>
                                    <div class="form-group">
                                        <input type="password" class="form-control" name="pw" placeholder="Password" autocomplete="off" required>
                                    </div>
                                    <div class="form-group">
                                        <input type="password" class="form-control" name="pw2" placeholder="Repeat your Password" autocomplete="off" required>
                                    </div>
                                    <div class="form-group">
                                        <input type="email" class="form-control" name="em" placeholder="Your Email" required>
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="na" placeholder="Full name" required>
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="ph" placeholder="Cellphone number" required>
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="ad" placeholder="Address" required>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <div class="form-group">
                                        <button type="submit" class="btn btn-primary form-control" name="su">Sign Up</button>
                                    </div>
                                    <div class="form-group">
                                        <button type="button" class="btn btn-default form-control" onclick="location.href='login';">Login</button>
                                    </div>
                                </div>
                            </div><!-- /.modal-content -->
                        </div><!-- /.modal -->
                    </form>
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