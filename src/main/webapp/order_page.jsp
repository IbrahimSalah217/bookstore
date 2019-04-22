<%@ include file="Header.jsp" %>

<!-- =====  CONTAINER START  ===== -->
<div class="container">
    <div class="row ">
        <div id="column-left" class="col-sm-4 col-md-4 col-lg-3">
            <div id="category-menu" class="navbar collapse in  mb_40" aria-expanded="true" style="" role="button">
                <div class="nav-responsive">
                    <ul class="nav  main-navigation collapse in">
                        <c:forEach items="${applicationScope.categories}" var="cate">
                            <li><a href="category?name=${cate.categoryName}">${cate.categoryName}</a></li>
                            </c:forEach>
                    </ul>
                </div>
            </div>
            <div class="left_banner left-sidebar-widget mb_50 mt_30"> <a href="#"><img src="images/left1.jpg" alt="Left Banner" class="img-responsive" /></a> </div>
            <div class="left-special left-sidebar-widget mb_50">

                <div class="left-cms left-sidebar-widget mb_50">
                    <ul>
                        <li>
                            <div class="feature-i-left ptb_40">
                                <div class="icon-right Shipping"></div>
                                <h6>Free Shipping</h6>
                                <p>Free delivery worldwide</p>
                            </div>
                        </li>
                        <li>
                            <div class="feature-i-left ptb_40">
                                <div class="icon-right Order"></div>
                                <h6>Order Online</h6>
                                <p>Hours : 8am - 11pm</p>
                            </div>
                        </li>
                        <li>
                            <div class="feature-i-left ptb_40">
                                <div class="icon-right Save"></div>
                                <h6>Shop And Save</h6>
                                <p>For All Books</p>
                            </div>
                        </li>
                        <li>
                            <div class="feature-i-left ptb_40">
                                <div class="icon-right Safe"></div>
                                <h6>Safe Shoping</h6>
                                <p>Ensure genuine 100%</p>
                            </div>
                        </li>
                    </ul>
                </div>
                <div class="left_banner left-sidebar-widget mb_50">
                    <a href="#"><img src="images/left2.jpg" alt="Left Banner" class="img-responsive" /></a>
                </div>
                <div class="Testimonial left-sidebar-widget mb_50">
                    <div class="heading-part mb_20 ">
                        <h2 class="main_title">Team Members</h2>
                    </div>
                    <div class="client owl-carousel text-center pt_10">
                        <div class="item client-detail">
                            <div class="client-avatar"> <img alt="" src="images/user1.jpg"> </div>
                            <div class="client-title  mt_30"><strong>Bishoy Georgy</strong></div>
                            <div class="client-designation mb_10">Java Developer</div>
                            <p><i class="fa fa-quote-left" aria-hidden="true"></i>Web EE division-ITI</p>
                        </div>
                        <div class="item client-detail">
                            <div class="client-avatar"> <img alt="" src="images/user2.jpg"> </div>
                            <div class="client-title  mt_30"><strong>Ibrahem Salah</strong></div>
                            <div class="client-designation mb_10">Java Developer</div>
                            <p><i class="fa fa-quote-left" aria-hidden="true"></i>Web EE division-ITI</p>
                        </div>
                        <div class="item client-detail">
                            <div class="client-avatar"> <img alt="" src="images/user3.jpg"> </div>
                            <div class="client-title  mt_30"><strong>Menna Helmy</strong></div>
                            <div class="client-designation mb_10">Java Developer</div>
                            <p><i class="fa fa-quote-left" aria-hidden="true"></i>Spring division-ITI</p>
                        </div>
                        <div class="item client-detail">
                            <div class="client-avatar"> <img alt="" src="images/user4.jpg"> </div>
                            <div class="client-title  mt_30"><strong>Mohammed Elbagory</strong></div>
                            <div class="client-designation mb_10">Java Developer</div>
                            <p><i class="fa fa-quote-left" aria-hidden="true"></i>Web EE division-ITI</p>
                        </div>
                        <div class="item client-detail">
                            <div class="client-avatar"> <img alt="" src="images/user5.jpg"> </div>
                            <div class="client-title  mt_30"><strong>Hend Zabady</strong></div>
                            <div class="client-designation mb_10">Java Developer</div>
                            <p><i class="fa fa-quote-left" aria-hidden="true"></i>Spring division-ITI</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
            <div class="col-sm-8 col-md-8 col-lg-9 mtb_30">
                <!-- =====  BANNER STRAT  ===== -->
                <div class="breadcrumb ptb_20">
                    <h1>Orders History</h1>
                    <ul>
                        <li><a href="userhome">Home</a></li>
                        <li class="active">Orders</li>
                    </ul>
                </div>
                <!-- =====  BREADCRUMB END===== -->
                <form enctype="multipart/form-data" method="post" action="#">
                    <div class="table-responsive">
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <td class="text-center">Image</td>
                                    <td class="text-left">Book Name</td>
                                    <td class="text-left">Book Author</td>
                                    <td class="text-left">Quantity</td>
                                    <td class="text-right">Unit Price</td>
                                    <td class="text-right">Total</td>
                                </tr>
                            </thead>
                            <c:forEach items="${userOrders}" var="order" >

                                <tbody>
                                    <tr>
                                        <td class="text-center"><a href="LoadBookPage?id=${order.bookBean.bookId}">
                                                <img src="images/product/${order.bookBean.img}"  title="${order.bookBean.title}" width="90">


                                            </a></td>
                                        <td class="text-left"><a href="LoadBookPage?id=${order.bookBean.bookId}">${order.bookBean.title}</a></td>
                                        <td class="text-left">${order.bookBean.authorName}</td>
                                        <td class="text-left">
                                            <div style="max-width: 200px;" class="input-group btn-block">
                                                <input type="text" class="form-control quantity" size="1" value="${order.quantity}" name="quantity" disabled="true">
                                            </div>
                                        </td>
                                        <td class="text-right"><fmt:formatNumber type = "number" pattern="####.##" value="${order.bookBean.price}" /></td>

                                        <td class="text-right"><fmt:formatNumber type = "number" pattern="####.##" value="${(order.bookBean.price)*(order.quantity)}" /></td>
                                    </tr>
                                </tbody>
                            </c:forEach>
                        </table>
                    </div>
                </form>
                <!--
                    <h3 class="mtb_10">What would you like to do next?</h3>
                    <p>Choose if you have a discount code or would like to estimate your delivery cost.</p>
                    <div class="panel-group mt_20" id="accordion">
                        <div class="panel panel-default pull-left">
                            <div class="panel-heading">
                                <h4 class="panel-title"> <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">Use Coupon Code <i class="fa fa-caret-down"></i></a></h4>
                            </div>
                            <div id="collapseOne" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <label for="input-coupon" class="col-sm-4 control-label">Enter your coupon here</label>
                                    <div class="input-group">
                                        <input type="text" class="form-control" id="input-coupon" placeholder="Enter your coupon here" value="" name="coupon">
                                        <span class="input-group-btn">
                                            <input type="button" class="btn" data-loading-text="Loading..." id="button-coupon" value="Apply Coupon">
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                   
                    </div>
                -->

                <form action="userhome">
                    <input class="btn pull-left mt_30" type="submit" value="Continue Shopping" />
                </form>

            </div>
        </div>
            
    </div>
    <!-- =====  CONTAINER END  ===== -->
    <jsp:include page="Footer.jsp" />
    <a id="scrollup">Scroll</a>
    <script src="js/jQuery_v3.1.1.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.magnific-popup.js"></script>
    <script src="js/custom.js"></script>
</body>

</html>
