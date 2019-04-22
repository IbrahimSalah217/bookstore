<%@ include file="Header.jsp" %>
<!-- =====  CONTAINER START  ===== -->
<div class="container">
    <div class="row ">
        <div id="column-left" class="col-sm-4 col-md-4 col-lg-3 ">
            <div id="category-menu" class="navbar collapse in  mb_40" aria-expanded="true" style="" role="button">
                <div class="nav-responsive">
                    <ul class="nav  main-navigation collapse in">
                        <c:forEach items="${applicationScope.categories}" var="cate">
                            <li><a href="category?name=${cate.categoryName}">${cate.categoryName}</a></li>
                            </c:forEach>
                    </ul>
                </div>
            </div>
            <div class="left_banner left-sidebar-widget mb_50"> <a href="#"><img src="images/left2.jpg" alt="Left Banner" class="img-responsive" /></a> </div>
            <form method="post" action="category?name=${requestScope.categoryName}">
                <div class="filter left-sidebar-widget mb_50">
                    <div class="heading-part mtb_20 ">
                        <h2 class="main_title">Refine Search</h2>
                    </div>
                    <div class="filter-block">
                        <p>
                            <label for="amount">Price range:</label>
                            <input type="text" id="amount"  name="price" readonly>
                        </p>
                        <div id="slider-range" class="mtb_20"></div>
                        <p>
                            <label for="amount2">rate range:</label>
                            <input type="text" id="amount2" name="rate" readonly>
                        </p>
                        <div id="slider-range2" class="mtb_20"></div>

                        <div class="list-group">
                            <div class="list-group-item mb_10">
                                <label>In Stock</label>
                                <div id="filter-group1">
                                    <div class="checkbox">
                                        <label>
                                            <input value="true" type="radio" name="available" checked> AVAILABLE</label>
                                    </div>
                                    <div class="checkbox">
                                        <label>
                                            <input value="false" type="radio" name="available"> UNAVAILABLE</label>
                                    </div>
                                </div>
                            </div>
                            <div class="list-group-item mb_10">
                                <label class="control-label" for="input-sort">Sort By :</label>
                                <div class="sort-inner">
                                    <select id="input-sort" class="form-control" name="sort">
                                        <option value="title A" selected="selected">Default</option>
                                        <option value="title A">Name (A - Z)</option>
                                        <option value="title D">Name (Z - A)</option>
                                        <option value="price A">Price (Low &gt; High)</option>
                                        <option value="price D">Price (High &gt; Low)</option>
                                        <option value="rate D">Rating (Highest)</option>
                                        <option value="rate A">Rating (Lowest)</option>
                                    </select>
                                </div>
                                <span><i class="fa fa-angle-down" aria-hidden="true"></i></span> </div>
                            <br/>
                            <br/>
                            <button type="submit" class="btn">Refine Search</button>
                        </div>
                    </div>
                </div>            
            </form>
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
        <div id="column-right" class="col-sm-8 col-md-8 col-lg-9 mtb_30">
            <!-- =====  BANNER STRAT  ===== -->
            <div class="breadcrumb ptb_20">
                <h1>Products</h1>
                <ul>
                    <li><a href="userhome">Home</a></li>
                    <li class="active">Books</li>
                </ul>
            </div>

            <div id="product-tab" class="mt_40">
                <div class="heading-part mb_20 ">
                    <h2 class="main_title">${requestScope.categoryName} Books</h2>
                </div>
                <div class="tab-content clearfix box">
                    <div class="tab-pane active" id="nArrivals">
                        <div class="nArrivals owl-carousel">
                            <c:forEach items="${requestScope.CategoryProducts}" begin="1" step="2" varStatus="seq1">
                                <div class="product-grid">
                                    <c:forEach items="${requestScope.CategoryProducts}" var="book" begin="${seq1.index-1}" end="${seq1.index}">
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
                </div>         
            </div>
            <div class="left-special left-sidebar-widget mb_50">
                <div class="heading-part mb_20 ">
                    <h2 class="main_title">Top Rated</h2>
                </div>
                <div id="left-special" class="owl-carousel">
                    <c:forEach items="${requestScope.topProducts}" begin="2" step="3" varStatus="seq1">
                        <ul class="row ">
                            <c:forEach items="${requestScope.topProducts}" var="book" begin="${seq1.index-2}" end="${seq1.index}">
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

        <!-- =====  CONTAINER END  ===== -->
        <jsp:include page="Footer.jsp" />
        <a id="scrollup">Scroll</a>
        <script src="js/jQuery_v3.1.1.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.magnific-popup.js"></script>
        <script src="js/custom.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script>
                                                            $(function () {
                                                                $("#slider-range2").slider({
                                                                    range: true,
                                                                    min: 0,
                                                                    max: 7,
                                                                    values: [1, 3],
                                                                    slide: function (event1, ui1) {
                                                                        $("#amount2").val("*" + ui1.values[0] + " - *" + ui1.values[1]);
                                                                    }
                                                                });
                                                                $("#amount2").val("*" + $("#slider-range2").slider("values", 0) +
                                                                        " - *" + $("#slider-range2").slider("values", 1));
                                                                $("#slider-range").slider({
                                                                    range: true,
                                                                    min: 0,
                                                                    max: 200,
                                                                    values: [75, 150],
                                                                    slide: function (event, ui) {
                                                                        $("#amount").val("$" + ui.values[0] + " - $" + ui.values[1]);
                                                                    }
                                                                });
                                                                $("#amount").val("$" + $("#slider-range").slider("values", 0) +
                                                                        " - $" + $("#slider-range").slider("values", 1));

                                                            });
        </script>
        </body>

        </html>