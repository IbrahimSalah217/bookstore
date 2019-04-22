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
            <div class="left-special left-sidebar-widget mb_50">
                <div class="heading-part mb_20 ">
                    <h2 class="main_title">On Sale</h2>
                </div>

                <div id="left-special" class="owl-carousel">
                    <c:forEach items="${sessionScope.onSale}" begin="2" step="3" varStatus="seq1">
                        <ul class="row ">
                            <c:forEach items="${sessionScope.onSale}" var="book" begin="${seq1.index-2}" end="${seq1.index}">
                                <li class="item product-layout-left mb_20">
                                    <div class="product-list col-xs-4">
                                        <div class="product-thumb">
                                            <div class="image product-imageblock">
                                                <a href="LoadBookPage?id=${book.bookId}">
                                                    <img class="img-responsive" title="${book.title}" alt="${book.title}" src='images/product/${book.img}'>
                                                    <img class="img-responsive" title="${book.title}" alt="${book.title}" src='images/product/${book.img}'>
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-8">
                                        <div class="caption product-detail">
                                            <h6 class="product-name"><a href="LoadBookPage?id=${book.bookId}"> Author Name: ${book.authorName}<br> Number Of Pages: ${book.pagesNumber}</a></h6>
                                            <div class="rating">
                                                <c:forEach  begin="1" end="${book.rate}"> 
                                                    <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-1x"></i><i class="fa fa-star fa-stack-1x"></i></span> 
                                                        </c:forEach>
                                                        <c:forEach  begin="1" end="${5-book.rate}"> 
                                                    <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-1x"></i><i class="fa fa-star fa-stack-x"></i></span> 
                                                        </c:forEach>
                                            </div>
                                            <span class="price"><span class="amount" style="text-decoration-line: line-through"><span class="currencySymbol">$</span>${book.price}</span>
                                            </span>
                                            <br/>
                                            <span class="price"><span class="amount"><span class="currencySymbol">$</span><fmt:formatNumber type = "number" 
                                                              pattern = "####.##" value = "${book.price-(book.price*book.offerPercent/100)}" /></span>
                                            </span>
                                        </div>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                    </c:forEach>  
                </div>
            </div>
        </div>
        <div class="col-sm-8 col-md-8 col-lg-9 mtb_30">
            <!-- =====  BANNER STRAT  ===== -->
            <div class="breadcrumb ptb_20">
                <h1>Shopping Cart</h1>
                <ul>
                    <li><a href="userhome">Home</a></li>
                    <li class="active">Shopping Cart</li>
                </ul>
            </div>
            <!-- =====  BREADCRUMB END===== -->
            <form enctype="multipart/form-data" method="post" action="#">
                <div class="table-responsive">
                    <table class="table table-bordered" id="table">
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
                        <c:set var="availability" value="false"></c:set>
                        <c:forEach items="${sessionScope.userCart}" var="cart" >
                            <c:choose>
                                <c:when test="${!cart.bookBean.available}">

                                    <tbody>
                                        <tr>
                                            <td class="text-center"><a href="LoadBookPage?id=${cart.bookBean.bookId}">
                                                    <img src="images/product/${cart.bookBean.img}"  title="${cart.bookBean.title}" width="90">
                                                </a></td>
                                            <td class="text-left" style="text-decoration-line: line-through"><a href="LoadBookPage?id=${cart.bookBean.bookId}">${cart.bookBean.title}</a></td>
                                            <td class="text-left" style="text-decoration-line: line-through">${cart.bookBean.authorName}</td>
                                            <td class="text-left">
                                                <div style="max-width: 200px;" class="input-group btn-block">
                                                    <input id="${cart.bookBean.bookId}" type="text" class="form-control quantity" size="1" value="Not Available" disabled="true">
                                                    <span class="input-group-btn">

                                                        <button  class="btn btn-danger" title="" data-toggle="tooltip" onclick="removeCart(${cart.bookBean.bookId}, this);" type="button" data-original-title="Remove"><i class="fa fa-times-circle"></i></button>
                                                    </span></div>
                                            </td>
                                            <td class="text-right">0</td>
                                            <td class="text-right">0</td>
                                        </tr>
                                    </tbody>

                                </c:when>    
                                <c:otherwise>
                                    <c:set var="availability" value="true" />
                                    <tbody>
                                        <tr>
                                            <td class="text-center"><a href="LoadBookPage?id=${cart.bookBean.bookId}">
                                                    <img src="images/product/${cart.bookBean.img}"  title="${cart.bookBean.title}" width="90">
                                                </a></td>
                                            <td class="text-left"><a href="LoadBookPage?id=${cart.bookBean.bookId}">${cart.bookBean.title}</a></td>
                                            <td class="text-left">${cart.bookBean.authorName}</td>
                                            <td class="text-left">
                                                <div style="max-width: 200px;" class="input-group btn-block">
                                                    <input id="${cart.bookBean.bookId}" type="number"  class="form-control quantity" size="1" value="${cart.reqQuantity}" name="quantity"/>
                                                    <span class="input-group-btn">
                                                        <button  class="btn btn-danger" title="" data-toggle="tooltip" onclick="updateCart(${cart.bookBean.bookId},${cart.bookBean.quantity});" type="button" data-original-title="Update"><i class="fa fa-refresh"></i></button>
                                                        <button  class="btn btn-danger" title="" data-toggle="tooltip" onclick="removeCart(${cart.bookBean.bookId}, this);" type="button" data-original-title="Remove"><i class="fa fa-times-circle"></i></button>
                                                    </span></div>
                                            </td>
                                            <td class="text-right"><fmt:formatNumber type = "number" pattern="####.##" value="${cart.bookBean.price}" /></td>
                                            <td class="text-right" name="subtotal"><fmt:formatNumber type = "number" pattern="####.##" value="${cart.total}" /></td>
                                        </tr>
                                    </tbody>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </table>
                </div>
            </form>

            <center>                    
                <c:if test="${!empty requestScope.error}">
                    <div style="color: #FF0000">
                        <label>Your Limit is ${sessionScope.user.creditLimit} And it is Not Enough</label>
                    </div>
                </c:if>
            </center>
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
            <div class="row">
                <div class="col-sm-4 col-sm-offset-8">
                    <table class="table table-bordered">
                        <tbody>

                            <tr>
                                <td class="text-right"><strong>Total:</strong></td>
                                <td class="text-right" id="totalPrice">${requestScope.totalPrice}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <form action="userhome">
                <input class="btn pull-left mt_30" type="submit" value="Continue Shopping" />
            </form>
            <c:choose>
                <c:when test="${!availability}">
                    <form action="ChechoutServlet">
                        <input class="btn pull-right mt_30" type="submit" value="Checkout" disabled="true" />
                    </form>
                </c:when>    
                <c:otherwise>
                    <form action="ChechoutServlet">
                        <input class="btn pull-right mt_30" type="submit" value="Checkout" />
                    </form>
                </c:otherwise>
            </c:choose>             
        </div>
    </div>
    <div id="brand_carouse" class="ptb_30 text-center">
        <div class="type-01">
            <div class="heading-part mb_20 ">
                <h2 class="main_title">Our Authors</h2>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <div class="brand owl-carousel ptb_20">
                        <div class="item text-center"> <img src="images/brand/brand1.png" style="border-radius: 50%" class="img-responsive" /></div>
                        <div class="item text-center"> <img src="images/brand/brand2.png" style="border-radius: 50%" class="img-responsive" /></div>
                        <div class="item text-center"> <img src="images/brand/brand3.png" style="border-radius: 50%" class="img-responsive" /></div>
                        <div class="item text-center"> <img src="images/brand/brand4.png" style="border-radius: 50%" class="img-responsive" /></div>
                        <div class="item text-center"> <img src="images/brand/brand5.png" style="border-radius: 50%" class="img-responsive" /></div>
                        <div class="item text-center"> <img src="images/brand/brand6.png" style="border-radius: 50%" class="img-responsive" /></div>
                        <div class="item text-center"> <img src="images/brand/brand7.png" style="border-radius: 50%" class="img-responsive" /></div>
                        <div class="item text-center"> <img src="images/brand/brand8.png" style="border-radius: 50%" class="img-responsive" /></div>
                        <div class="item text-center"> <img src="images/brand/brand9.png" style="border-radius: 50%" class="img-responsive" /></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- =====  CONTAINER END  ===== -->
<jsp:include page="Footer.jsp" />
<a id="scrollup">Scroll</a>
<script src="sweetalert2.all.min.js"></script>
<script src="sweetalert2.min.js"></script>
<script src="js/jQuery_v3.1.1.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.magnific-popup.js"></script>
<script src="js/custom.js"></script>
<script src="js/ajax.js"></script>
<script src="js/calcOperations.js"></script>
</body>

</html>
