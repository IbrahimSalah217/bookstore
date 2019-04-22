<%-- 
    Document   : AddBook
    Created on : Apr 3, 2019, 6:59:46 PM
    Author     : Menna Helmy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title> Books-R-US Admin</title>
        <meta name="description" content="Ela Admin - HTML5 Admin Template">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="apple-touch-icon" href="images/favicon.png">
        <link rel="shortcut icon" href="images/favicon.png">

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/normalize.css@8.0.0/normalize.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/pixeden-stroke-7-icon@1.2.3/pe-icon-7-stroke/dist/pe-icon-7-stroke.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.2.0/css/flag-icon.min.css">
        <link rel="stylesheet" href="/BookStore/admin/assets/css/cs-skin-elastic.css">
        <link rel="stylesheet" href="/BookStore/admin/assets/css/style.css">

        <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>

        <!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->

    </head>
    <body >
        <!-- Left Panel -->
        <%@include file="AsideBar.html" %>

        <!-- /#left-panel -->

        <!-- Left Panel -->

        <!-- Right Panel -->

        <div id="right-panel" class="right-panel">

            <!-- Header-->

            <jsp:include page="Header.jsp" />
            <!-- /header -->
            <!-- Header-->

            

            <div class="content">
                <div class="animated fadeIn">

                    <div class="row">
                        <div class="col-xs-10 col-sm-10">
                            <div class="card">
                                <div class="card-header">
                                    <strong>Add a new Book</strong>
                                </div>
                                <form name="form" action="addProduct" method="POST" enctype="multipart/form-data">
                                    <small class="form-text text-success" id="bookAdded">${bookAdded}</small>

                                    <div class="card-body card-block">
                                        <div class="form-group">
                                            <label class=" form-control-label">Book Title</label>
                                            <div class="input-group">
                                                <div class="input-group-addon"><i class="fa fa-book"></i></div>
                                                <input required id="title" name="title" type="text" placeholder="Enter book title" required class="form-control">
                                            </div>
                                            <small class="form-text text-muted">ex. java SE referance</small>
                                        </div>
                                        <div class="form-group">
                                            <label class=" form-control-label">Author Name</label>
                                            <div class="input-group">
                                                <div class="input-group-addon"><i class="fa fa-user"></i></div>
                                                <input required id="author" name="author" type="text" placeholder="Enter author name" required class="form-control">
                                            </div>
                                            <small class="form-text text-muted">ex. Shakespeare</small>
                                        </div>
                                        <div class="form-group">
                                            <label class=" form-control-label">Book Description</label>
                                            <div class="input-group">
                                                <div class="input-group-addon"><i class="fa fa-text-height"></i></div>
                                                <textarea required name="desc" id="desc" rows="9" placeholder="description..." class="form-control"></textarea>
                                            </div>
                                            <small class="form-text text-muted">ex. This books is about...</small>
                                        </div>
                                        <div class="form-group">
                                            <label class=" form-control-label">Quantity</label>
                                            <div class="input-group">
                                                <div class="input-group-addon"><i class="fa fa-suitcase"></i></div>
                                                <input required id="quantity" name="quantity" placeholder="Enter book quantity" min="0" max="200" type="number"class="form-control">
                                            </div>
                                            <small class="form-text text-muted">ex. from 0..200</small>
                                        </div>
                                        <div class="form-group">
                                            <label class=" form-control-label">Pages Number</label>
                                            <div class="input-group">
                                                <div class="input-group-addon"><i class="fa fa-paper-plane"></i></div>
                                                <input id="pages" name="pages" type="number" min="1" class="form-control">
                                            </div>
                                            <small class="form-text text-muted">ex. min is 1</small>
                                        </div>
                                        <div class="form-group">
                                            <label class=" form-control-label">Price</label>
                                            <div class="input-group">
                                                <div class="input-group-addon"><i class="fa fa-dollar"></i></div>
                                                <input required placeholder="Enter the book price" id="price" name="price" type="number" class="form-control cc-cvc"  data-val="true" data-val-required="Please enter the book price" data-val-cc-cvc="Please enter a valid price" autocomplete="off">

                                            </div>
                                            <small class="form-text text-muted">ex. $250</small>
                                        </div>
                                        <div class="form-group">
                                            <label class=" form-control-label">Book main Image</label>
                                            <div class="input-group">
                                                <div class="input-group-addon"><i class="fa fa-picture-o"></i></div>
                                                <input required type="file" id="img" accept=".jpg" name="img"  class="form-control-file">
                                            </div>
                                            <small class="form-text text-muted">ex. you can choose multiple</small>
                                        </div>

                                        <div class="form-group">
                                            <label class=" form-control-label">Book Second Image</label>
                                            <div class="input-group">
                                                <div class="input-group-addon"><i class="fa fa-picture-o"></i></div>
                                                <input  type="file" id="img" accept=".jpg" name="img2"  class="form-control-file">
                                            </div>

                                        </div>
                                        <div class="form-group">
                                            <label class=" form-control-label">Book Thired Image</label>
                                            <div class="input-group">
                                                <div class="input-group-addon"><i class="fa fa-picture-o"></i></div>
                                                <input  type="file" id="img" accept=".jpg" name="img3"  class="form-control-file">
                                            </div>

                                        </div>
                                        <div class="form-group">
                                            <label class=" form-control-label">Book Category</label>
                                            <div class="input-group">
                                                <div class="input-group-addon"><i class="fa fa-th"></i></div>

                                                <select name="categ" id="categ" class="form-control" placeholder="Select Category. . . ">
                                                    <c:forEach items="${requestScope.categories}" var="category">
                                                        <option value="${category.categoryName}">${category.categoryName}</option>
                                                    </c:forEach>

                                                </select>


                                            </div>
                                            <small class="form-text text-muted">ex. you can choose multiple</small>
                                        </div>
                                        <div class="form-group">
                                            <label class=" form-control-label">Book Offer</label>
                                            <div class="input-group">
                                                <div class="input-group-addon"><i class="fa fa-picture-o"></i></div>
                                                <select name="offer" id="offer" class="form-control" placeholder="Select Offer. . . ">
                                                    <c:forEach items="${requestScope.offers}" var="offer">
                                                        <option value="${offer.offerPercentage},${offer.expireDate}">${offer.offerPercentage} %, ${offer.expireDate}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <small class="form-text text-muted">ex. you can choose multiple</small>
                                        </div>
                                    </div>
                                    <div>
                                        <button id="save" type="submit" class="btn btn-lg btn-info btn-block">
                                            <i class="fa fa-save fa-lg"></i>&nbsp;
                                            <span id="payment-button-amount">Save Book</span>
                                            <span id="payment-button-sending" style="display:none;">Saving…</span>
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>





                    </div>


                </div><!-- .animated -->
            </div><!-- .content -->


            <div class="clearfix"></div>

            <jsp:include page="Footer.html" />


        </div><!-- /#right-panel -->

        <!-- Right Panel -->

        <!-- Scripts -->
        <script src="https://cdn.jsdelivr.net/npm/jquery@2.2.4/dist/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.4/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/jquery-match-height@0.7.2/dist/jquery.matchHeight.min.js"></script>
        <script src="/BookStore/admin/assets/js/main.js"></script>


    </body>
</html>

