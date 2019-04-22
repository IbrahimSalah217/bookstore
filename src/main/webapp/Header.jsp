<!DOCTYPE html>
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="en">
    <!--<![endif]-->

    <head>
        <!-- =====  BASIC PAGE NEEDS  ===== -->
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">

        <title>Books-R-Us</title>
        <!-- =====  SEO MATE  ===== -->
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="description" content="">
        <meta name="keywords" content="">
        <meta name="distribution" content="global">
        <meta name="revisit-after" content="2 Days">
        <meta name="robots" content="ALL">
        <meta name="rating" content="8 YEARS">
        <meta name="Language" content="en-us">
        <meta name="GOOGLEBOT" content="NOARCHIVE">
        <!-- =====  MOBILE SPECIFICATION  ===== -->
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta name="viewport" content="width=device-width">
        <!-- =====  CSS  ===== -->
        <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css" />
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/magnific-popup.css">
        <link rel="stylesheet" type="text/css" href="css/owl.carousel.css">
        <link rel="stylesheet" type="text/css" href="css/jquery-ui.css">
        <link rel="stylesheet" href="css/bootstrap-multiselect.css" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.css" />
       
        <link rel="shortcut icon" href="images/favicon.png">
        <link rel="apple-touch-icon" href="images/apple-touch-icon.png">
        <link rel="apple-touch-icon" sizes="72x72" href="images/apple-touch-icon-72x72.png">
        <link rel="apple-touch-icon" sizes="114x114" href="images/apple-touch-icon-114x114.png">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css">
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@8"></script>
        <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
        <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
        <%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
        <script src="js/logincookie.js"></script>
        

    </head>

    <body onload="getookie()">
        <!-- loader-->
        <div class="loder"></div>
    

        <!-- =====  HEADER START  ===== -->
        <header id="header">
            <div class="header-top">
                <div class="container">
                    <div class="row">

                        <div class="col-sm-6">
                            <ul class="header-top-right text-right">
                                <li class="account"><a href="userhome">Home</a></li>
                                    <c:choose>
                                        <c:when test="${sessionScope.user==null}">
                                        <li class="sitemap"><a href="login.jsp">My Account</a></li> 
                                        <li class="cart"><a href="LoadCartServlet" >My Cart</a></li>


                                    </c:when>    
                                    <c:otherwise>
                                        <li class="sitemap"><a href="editProfile.jsp">${sessionScope.user.name}</a></li>

                                        <li class="cart"><a href="LoadCartServlet">My Cart</a></li>
                                        <li class="sitemap"><a href="logout">LogOut</a></li>

                                    </c:otherwise>
                                </c:choose>

                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="header">
                <div class="container">
                    <nav class="navbar">
                        <div class="navbar-header mtb_20">
                            <a class="navbar-brand" href="home"> <img alt="Books-R-Us" src="images/logo.png" width="250" height="250"> </a>
                        </div>
                        <!-- Cart shortcut -->
                        <div class="header-right pull-right mtb_50">
                            <button class="navbar-toggle pull-left" type="button" data-toggle="collapse" data-target=".js-navbar-collapse"> <span class="i-bar"><i class="fa fa-bars"></i></span></button>
                            <div class="shopping-icon">
                                <div class="cart-item " data-target="#cart-dropdown" data-toggle="collapse" aria-expanded="true" role="button">Item's : <span class="cart-qty">${sessionScope.userCart.size()}</span></div>
                                <div id="cart-dropdown" class="cart-menu collapse">
                                    <ul>
                                        <li>
                                            <table class="table table-striped">
                                                <tbody>
                                                    <c:forEach items="${sessionScope.userCart}" var = "cart" begin="0" end="1">
                                                        <tr>
                                                            <td class="text-center">
                                                                <a href="LoadBookPage?id=${cart.bookBean.bookId}">
                                                                    <img src="images/product/${cart.bookBean.img}" width="50">
                                                                </a>
                                                            </td>
                                                            <td class="text-left product-name"><a href="LoadBookPage?id=${cart.bookBean.bookId}">${cart.bookBean.title}</a>
                                                                <span class="text-left price">$ ${cart.total}</span>
                                                                <input class="cart-qty" name="product_quantity" min="1" value="${cart.reqQuantity}" type="number" disabled="true">
                                                            </td>
                                                            <td class="text-center"><a class="close-cart"><i class="fa fa-times-circle"></i></a></td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </li>
                                        <li>
                                            <a><i class="fa fa-spinner fa-spin" ></i></a>

                                        </li>
<!--                                        <li>
                                            <table class="table">
                                                <tbody>
                                                    <tr>
                                                        <td class="text-right"><strong>Sub-Total</strong></td>
                                                        <td class="text-right"></td>
                                                    </tr>

                                                    <tr>
                                                        <td class="text-right"><strong>VAT (5%)</strong></td>
                                                    </tr>
                                                    <tr>
                                                        <td class="text-right"><strong>Total</strong></td>
                                                        <td class="text-right"></td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </li>-->
                                        <li>
                                            <form action="LoadCartServlet">
                                                <input class="btn pull-left mt_10" value="View cart" type="submit">
                                            </form>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="main-search pull-right">
                                <div class="search-overlay">
                                    <!-- Close Icon -->
                                    <a href="javascript:void(0)" class="search-overlay-close"></a>
                                    <!-- End Close Icon -->
                                    <div class="container">
                                        <!-- Search Form -->
                                        <form role="search" id="searchform" action="search" method="get">
                                            <label class="h5 normal search-input-label">Enter keywords To Search Entire Store</label>
                                            <input value="" name="name" placeholder="Search here..." type="search">
                                            <button type="submit"></button>
                                        </form>
                                        <!-- End Search Form -->
                                    </div>
                                </div>
                                <div class="header-search">
                                    <a id="search-overlay-btn"></a>
                                </div>
                            </div>
                        </div>

                        <!-- /.nav-collapse -->
                    </nav>
                </div>
            </div>
            <div class="header-bottom">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-4 col-md-4 col-lg-3">
                            <div class="category">
                                <div class="menu-bar" data-target="#category-menu,#category-menu-responsive" data-toggle="collapse" aria-expanded="true" role="button">
                                    <h4 class="category_text">Top Categories</h4>
                                    <span class="i-bar"><i class="fa fa-bars"></i></span></div>
                            </div>
                            <div id="category-menu-responsive" class="navbar collapse " aria-expanded="true" style="" role="button">
                                <div class="nav-responsive">
                                    <ul class="nav  main-navigation collapse in">
                                        <c:forEach items="${applicationScope.categories}" var="cate">
                                            <li><a href="category?name=${cate.categoryName}">${cate.categoryName}</a></li>
                                            </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-8 col-md-8 col-lg-9">
                            <div class="header-bottom-right offers">
                                <div class="marquee"><span><i class="fa fa-circle" aria-hidden="true"></i>A room without books is like a body without a soul!</span>
                                    <span><i class="fa fa-circle" aria-hidden="true"></i>Books are a uniquely portable magic.</span>
                                    <span><i class="fa fa-circle" aria-hidden="true"></i>There is no friend as loyal as a book.</span>
                                    <span><i class="fa fa-circle" aria-hidden="true"></i>A book is a dream that you hold in your hand.</span>
                                    <span><i class="fa fa-circle" aria-hidden="true"></i>We lose ourselves in books. We find ourselves there too.</span>
                                    <span><i class="fa fa-circle" aria-hidden="true"></i>Welcome to our online store ^^</span></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <!-- =====  HEADER END  ===== -->
