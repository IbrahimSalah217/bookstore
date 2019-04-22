<%@ include file="Header.jsp" %>
<!-- =====  CONTAINER START  ===== -->
<div class="container">
    <div class="row ">
        <div id="column-left" class="col-sm-4 col-md-4 col-lg-3 ">
            <div id="category-menu" class="navbar collapse mb_40 hidden-sm-down in" aria-expanded="true" style="" role="button">
                <div class="nav-responsive">
                    <ul class="nav  main-navigation collapse in ">
                        <c:forEach items="${applicationScope.categories}" var="cate">
                            <li><a href="category?name=${cate.categoryName}">${cate.categoryName}</a></li>
                            </c:forEach>
                    </ul>
                </div>
            </div>

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
            <div class="left-special left-sidebar-widget mb_50">
                <div class="heading-part mb_20 ">
                    <h2 class="main_title">On Sale</h2>
                </div>
                <div id="left-special" class="owl-carousel">

                    <c:forEach items="${requestScope.onSale}" begin="2" step="3" varStatus="seq1">
                        <ul class="row ">
                            <c:forEach items="${requestScope.onSale}" var="book" begin="${seq1.index-2}" end="${seq1.index}">
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
                        <div class="client-title  mt_30"><strong>Mohamed A. Elbagoury</strong></div>
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
        <div id="column-right" class="col-sm-8 col-md-8 col-lg-9 mtb_30">
            <!-- =====  BANNER STRAT  ===== -->
            <div class="banner">
                <div class=" main-banner owl-carousel mt_30">
                    <div class="item">
                        <a href="#"><img src="images/main_banner2.jpg" alt="Main Banner" class="img-responsive" width="400" /></a>
                    </div>
                    <div class="item">
                        <a href="#"><img src="images/main_banner1.jpg" alt="Main Banner" class="img-responsive" width="400" /></a>
                    </div>
                </div>
            </div>
            <!-- =====  BANNER END  ===== -->

            <!-- =====  PRODUCT TAB  ===== -->
            <div id="product-tab" class="mt_40">
                <div class="heading-part mb_20 ">
                    <h2 class="main_title">Home Books</h2>
                </div>
                <ul class="nav text-right">
                    <li class="active"> <a href="#nArrivals" data-toggle="tab">Recommended</a> </li>
                    <li><a href="#Bestsellers" data-toggle="tab">Best Sellers</a> </li>
                    <li><a href="#Featured" data-toggle="tab">Top Rated</a> </li>
                </ul>
                <div class="tab-content clearfix box">
                    <div class="tab-pane active" id="nArrivals">
                        <div class="nArrivals owl-carousel">
                            <c:forEach items="${requestScope.newItems}" begin="1" step="2" varStatus="seq1">
                                <div class="product-grid">
                                    <c:forEach items="${requestScope.newItems}" var="book" begin="${seq1.index-1}" end="${seq1.index}">
                                        <div class="item">
                                            <div class="product-thumb">
                                                <div class="image product-imageblock">
                                                    <a href="LoadBookPage?id=${book.bookId}">
                                                        <img data-name="product_image" width="200" src='images/product/${book.img}' alt="${book.title}" title="${book.title}" class="img-responsive">
                                                        <img data-name="product_image" width="200" src='images/product/${book.img}' alt="${book.title}" title="${book.title}" class="img-responsive">
                                                    </a>
                                                </div>
                                                <div class="caption product-detail text-left">
                                                    <h6 data-name="product_name" class="product-name mt_20"><a href="LoadBookPage?id=${book.bookId}" title="${book.title}"> Author Name: ${book.authorName}<br> Number Of Pages: ${book.pagesNumber}</a></h6>
                                                    <div class="rating"> 
                                                        <c:forEach  begin="1" end="${book.rate}"> 
                                                            <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-1x"></i><i class="fa fa-star fa-stack-1x"></i></span> 
                                                                </c:forEach>
                                                                <c:forEach  begin="1" end="${5-book.rate}"> 
                                                            <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-1x"></i><i class="fa fa-star fa-stack-x"></i></span> 
                                                                </c:forEach>

                                                    </div>
                                                    <span class="price"><span class="amount"><span class="currencySymbol">$</span>${book.price}</span>
                                                    </span>
                                                    <div class="button-group mt_30">
                                                        <c:choose>
                                                            <c:when test="${!book.available}">
                            <!--                                    <a href="UpdateCart?id=${book.bookId}"><div class="add-to-cart"><span hidden="true">Add to cart</span></div></a>-->
                                                            </c:when>    
                                                            <c:otherwise>
                                                                <a href="UpdateCart?id=${book.bookId}"><div class="add-to-cart"><span>Add to cart</span></div></a>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <a type="button" onclick="likeBook(${book.bookId});"><div class="wishlist"><span>wishlist</span></div></a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                    </c:forEach>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="tab-pane" id="Bestsellers">
                        <div class="Bestsellers owl-carousel">
                            <c:forEach items="${requestScope.bestSeller}" begin="1" step="2" varStatus="seq1">
                                <div class="product-grid">
                                    <c:forEach items="${requestScope.bestSeller}" var="book" begin="${seq1.index-1}" end="${seq1.index}">
                                        <div class="item">
                                            <div class="product-thumb">
                                                <div class="image product-imageblock">
                                                    <a href="LoadBookPage?id=${book.bookId}"> 
                                                        <img width="200" data-name="product_image" src='images/product/${book.img}' alt="${book.title}" title="${book.title}" class="img-responsive">
                                                        <img width="200" data-name="product_image" src='images/product/${book.img}' alt="${book.title}" title="${book.title}" class="img-responsive">                                                        
                                                    </a>
                                                </div>
                                                <div class="caption product-detail text-left">
                                                    <h6 data-name="product_name" class="product-name mt_20"><a href="LoadBookPage?id=${book.bookId}" title="${book.title}"> Author Name: ${book.authorName}<br> Number Of Pages: ${book.pagesNumber}</a></h6>
                                                    <div class="rating"> 
                                                        <c:forEach  begin="1" end="${book.rate}"> 
                                                            <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-1x"></i><i class="fa fa-star fa-stack-1x"></i></span> 
                                                                </c:forEach>
                                                                <c:forEach  begin="1" end="${5-book.rate}"> 
                                                            <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-1x"></i><i class="fa fa-star fa-stack-x"></i></span> 
                                                                </c:forEach>

                                                    </div>
                                                    <span class="price"><span class="amount"><span class="currencySymbol">$</span>${book.price}</span>
                                                    </span>
                                                    <div class="button-group mt_30">
                                                        <c:choose>
                                                            <c:when test="${!book.available}">
                            <!--                                    <a href="UpdateCart?id=${book.bookId}"><div class="add-to-cart"><span hidden="true">Add to cart</span></div></a>-->
                                                            </c:when>    
                                                            <c:otherwise>
                                                                <a href="UpdateCart?id=${book.bookId}"><div class="add-to-cart"><span>Add to cart</span></div></a>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <a type="button" onclick="likeBook(${book.bookId});"><div class="wishlist"><span>wishlist</span></div></a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                    </c:forEach>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="tab-pane" id="Featured">
                        <div class="Featured owl-carousel">
                            <c:forEach items="${requestScope.topRated}" begin="1" step="2" varStatus="seq1">
                                <div class="product-grid">
                                    <c:forEach items="${requestScope.topRated}" var="book" begin="${seq1.index-1}" end="${seq1.index}">
                                        <div class="item">
                                            <div class="product-thumb">
                                                <div class="image product-imageblock">
                                                    <a href="LoadBookPage?id=${book.bookId}">
                                                        <img width="200" data-name="product_image" src='images/product/${book.img}' alt="${book.title}" title="${book.title}" class="img-responsive">
                                                        <img width="200" data-name="product_image" src='images/product/${book.img}' alt="${book.title}" title="${book.title}" class="img-responsive">
                                                    </a>
                                                </div>
                                                <div class="caption product-detail text-left">
                                                    <h6 data-name="product_name" class="product-name mt_20"><a href="LoadBookPage?id=${book.bookId}" title="${book.title}"> Author Name: ${book.authorName}<br> Number Of Pages: ${book.pagesNumber}</a></h6>
                                                    <div class="rating"> 
                                                        <c:forEach  begin="1" end="${book.rate}"> 
                                                            <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-1x"></i><i class="fa fa-star fa-stack-1x"></i></span> 
                                                                </c:forEach>
                                                                <c:forEach  begin="1" end="${5-book.rate}"> 
                                                            <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-1x"></i><i class="fa fa-star fa-stack-x"></i></span> 
                                                                </c:forEach>

                                                    </div>
                                                    <span class="price"><span class="amount"><span class="currencySymbol">$</span>${book.price}</span>
                                                    </span>
                                                    <div class="button-group mt_30">
                                                        <c:choose>
                                                            <c:when test="${!book.available}">
                            <!--                                    <a href="UpdateCart?id=${selectedProduct.bookId}"><div class="add-to-cart"><span hidden="true">Add to cart</span></div></a>-->
                                                            </c:when>    
                                                            <c:otherwise>
                                                                <a href="UpdateCart?id=${book.bookId}"><div class="add-to-cart"><span>Add to cart</span></div></a>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <a type="button" onclick="likeBook(${book.bookId});"><div class="wishlist"><span>wishlist</span></div></a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                    </c:forEach>
                                </div>
                            </c:forEach>
                        </div>         
                    </div>
                </div>
                <!-- =====  PRODUCT TAB  END ===== -->
                <!-- =====  SUB BANNER  STRAT ===== -->
                <div class="row">
                    <div class="cms_banner mt_40 mb_50">
                        <div class="col-xs-12">
                            <div id="subbanner3" class="banner sub-hover">
                                <a href="#"><img src="images/sub3.jpg" alt="Sub Banner3" class="img-responsive"></a>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- =====  SUB BANNER END  ===== -->



                <!-- =====  product ===== -->
                <div class="row">
                    <div class="col-md-4">
                        <div class="heading-part mb_20 ">
                            <h2 class="main_title">Popular Books</h2>
                        </div>
                        <div id="featu-pro" class="owl-carousel">
                            <c:forEach items="${requestScope.mostVisited}" begin="2" step="3" varStatus="seq1">

                                <ul class="row ">
                                    <c:forEach items="${requestScope.mostVisited}" var="book" begin="${seq1.index-2}" end="${seq1.index}">
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
                                                    <span class="price"><span class="amount"><span class="currencySymbol">$</span>${book.price}</span>
                                                    </span>
                                                </div>
                                            </div>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="heading-part mb_20 ">
                            <h2 class="main_title">History</h2>
                        </div>
                        <div id="bests-pro" class="owl-carousel">
                            <c:set var="remenderHistory" value="${fn:length(requestScope.history) %3}"/>

                            <c:forEach items="${requestScope.history}" begin="2" step="3" varStatus="seq1">

                                <ul class="row ">
                                    <c:forEach items="${requestScope.history}" var="book" begin="${seq1.index-2}" end="${seq1.index}">
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
                                                    <span class="price"><span class="amount"><span class="currencySymbol">$</span>${book.price}</span>
                                                    </span>
                                                </div>
                                            </div>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </c:forEach>
                            <ul class="row ">
                                <c:forEach items="${requestScope.history}" var="book" begin="${fn:length(requestScope.history)-remenderHistory}" end="${fn:length(requestScope.history)}">
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
                                                <span class="price"><span class="amount"><span class="currencySymbol">$</span>${book.price}</span>
                                                </span>
                                            </div>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="heading-part mb_20 ">
                            <h2 class="main_title">Wish List</h2>
                        </div>
                        <div id="bests-pro" class="owl-carousel">
                            <c:set var="remenderWishList" value="${fn:length(requestScope.wishList) %3}"/>
                            <c:forEach items="${requestScope.wishList}" begin="2" step="3" varStatus="seq1">

                                <ul class="row ">

                                    <c:forEach items="${requestScope.wishList}" var="book" begin="${seq1.index-2}" end="${seq1.index}">
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
                                                    <span class="price"><span class="amount"><span class="currencySymbol">$</span>${book.price}</span>
                                                    </span>
                                                </div>
                                            </div>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </c:forEach>

                            <ul class="row ">
                                <c:forEach items="${requestScope.wishList}" var="book" begin="${fn:length(requestScope.wishList)-remenderWishList}" end="${fn:length(requestScope.wishList)}">
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
                                                <span class="price"><span class="amount"><span class="currencySymbol">$</span>${book.price}</span>
                                                </span>
                                            </div>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>

                        </div>
                    </div>
                </div>
            </div>
            <!-- =====  product end  ===== -->
            <!-- =====  Blog ===== -->

        </div>
    </div>
</div>
<!-- =====  CONTAINER END  ===== -->
<jsp:include page="Footer.jsp" />
<a id="scrollup">Scroll</a>    
<script src="js/wishList.js"></script>
<script src="js/jQuery_v3.1.1.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.magnific-popup.js"></script>
<script src="js/jquery.firstVisitPopup.js"></script>
<script src="js/custom.js"></script>
<script src="js/unAvailable.js"></script>
</body>

</html>
