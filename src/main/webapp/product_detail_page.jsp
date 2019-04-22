
<%@ include file="Header.jsp" %>
<!-- =====  CONTAINER START  ===== -->
<div class="container">
    <div class="row ">
        <div id="column-left" class="col-sm-4 col-md-4 col-lg-3 hidden-xs">
            <div id="category-menu" class="navbar collapse in  mb_40" aria-expanded="true" style="" role="button">
                <div class="nav-responsive">
                    <ul class="nav  main-navigation collapse in">
                        <c:forEach items="${applicationScope.categories}" var="cate">
                            <li><a href="category?name=${cate.categoryName}">${cate.categoryName}</a></li>
                            </c:forEach>
                    </ul>
                </div>
            </div>
            <div class="left_banner left-sidebar-widget mt_30 mb_40"> <a href="#"><img src="images/left2.jpg" alt="Left Banner" class="img-responsive" /></a> </div>
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
        <div id="column-right" class="col-sm-8 col-md-8 col-lg-9 mtb_30">
            <!-- =====  BANNER STRAT  ===== -->
            <div class="breadcrumb ptb_20">
                <h1>Book details</h1>
                <ul>
                    <li><a href="userhome">Home</a></li>
                    <li><a href="category?name=${selectedProduct.categoryName}">${selectedProduct.categoryName}</a></li>
                    <li class="active">Book details</li>
                </ul>
            </div>
            <!-- =====  BREADCRUMB END===== -->
            <div class="row mt_10 ">
                <div class="col-md-4">
                    <div><a class="thumbnails"> <img data-name="product_image" src='images/product/${selectedProduct.img}' alt="" /></a></div>
                    <div id="product-thumbnail" class="owl-carousel">
                        <div class="item">
                            <div class="image-additional"><a class="thumbnail" href='images/product/${selectedProduct.img}' data-fancybox="group1"> <img src='images/product/${selectedProduct.img}' alt="${selectedProduct.title}" /></a></div>
                        </div>
                        <c:forEach begin="0" end="${selectedProduct.imgsCount-1}" var="count">
                            <div class="item">
                                <div class="image-additional"><a class="thumbnail" href='images/product/${fn:replace(selectedProduct.img, ".jpg", "")}${count+1}.jpg' data-fancybox="group1"> <img src='images/product/${fn:replace(selectedProduct.img,".jpg", "")}${count+1}.jpg' alt="${selectedProduct.title}" /></a></div>
                            </div>
                        </c:forEach>

                    </div>
                </div>
                <div class="col-md-6 prodetail caption product-thumb">
                    <h4 data-name="product_name" class="product-name"><a href="#" title="Casual Shirt With Ruffle Hem">${selectedProduct.title}</a></h4>
                    <div class="rating">
                        <c:forEach  begin="1" end="${selectedProduct.rate}"> 
                            <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-1x"></i><i class="fa fa-star fa-stack-1x"></i></span> 
                                </c:forEach>
                                <c:forEach  begin="1" end="${5-selectedProduct.rate}"> 
                            <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-1x"></i><i class="fa fa-star fa-stack-x"></i></span> 
                                </c:forEach>
                    </div>
                    <span class="price mb_20"><span class="amount"><span class="currencySymbol">$</span>${selectedProduct.price}</span>
                    </span>
                    <hr>
                    <ul class="list-unstyled product_info mtb_20">
                        <li>
                            <label>Author:</label>
                            <span> <a href="#">${selectedProduct.authorName}</a></span></li>
                        <li>
                            <label>Number Of Pages:</label>
                            <span>${selectedProduct.pagesNumber}</span></li>
                        <li>
                            <label>Available:</label>
                            <span>${selectedProduct.available}</span></li>
                        <li>
                            <label>Visits:</label>
                            <span>${selectedProduct.visits}</span></li>
                    </ul>
                    <hr>
                    <p class="product-desc mtb_30"></p>
                    <div id="product">
                        <div class="qty mt_30 form-group2">
                            <div class="button-group mt_30">
                                <c:choose>
                                    <c:when test="${!selectedProduct.available}">
    <!--                                    <a href="UpdateCart?id=${selectedProduct.bookId}"><div class="add-to-cart"><span hidden="true">Add to cart</span></div></a>-->
                                    </c:when>    
                                    <c:otherwise>
                                        <a href="UpdateCart?id=${selectedProduct.bookId}"><div class="add-to-cart"><span>Add to cart</span></div></a>
                                    </c:otherwise>
                                </c:choose>
                                <a type="button" onclick="likeBook(${selectedProduct.bookId});"><div class="wishlist"><span>wishlist</span></div></a>
                            </div>
                        </div>
                    </div>
                </div>
            <div class="row">
                <div class="col-md-12">
                    <div id="exTab5" class="mtb_30">
                        <ul class="nav nav-tabs">
                            <li class="active"> <a href="#1c" data-toggle="tab">Overview</a> </li>
                            <li><a href="#2c" data-toggle="tab">Reviews </a> </li>
                        </ul>
                        <div class="tab-content mt_20">
                            <div class="tab-pane active" id="1c">
                                <p>${selectedProduct.description}</p>
                            </div>
                            <div class="tab-pane" id="2c">
                                <form class="form-horizontal">
                                    <div id="review"></div>
                                    <h4 class="mt_20 mb_30">Write a review</h4>
                                    <div class="form-group required">
                                        <div class="col-sm-12">
                                            <c:set var="userName" value="" />
                                            <c:set var="comment" value="" />
                                             <c:set var="rate" value="0" /> 
                                            <c:forEach items="${sessionScope.reviewsMap}" var="bookReviewed">
                                                <c:if test="${selectedProduct.bookId eq bookReviewed.key}">
                                                    <c:set var="userName" value="${bookReviewed.value.get(0)}" />
                                                    <c:set var="comment" value="${bookReviewed.value.get(1)}" />
                                                    <c:set var="rate" value="${bookReviewed.value.get(2)}" /> 
                                                </c:if>
                                            </c:forEach> 
                                            <label class="control-label" for="input-name">Your Name</label>
                                            <input name="name" value="${userName}" id="input-name" class="form-control" type="text">
                                        </div>
                                    </div>
                                    <div class="form-group required">
                                        <div class="col-sm-12">
                                            <label class="control-label" for="input-review">Your Review</label>
                                            <textarea form="2c" name="text" value="${comment}" rows="5" id="input-review" class="form-control">${comment}</textarea>
                                            <div class="help-block"><span class="text-danger">Note:</span> HTML is not translated!</div>
                                        </div>
                                    </div>
                                    <div class="form-group required">
                                        <div class="col-lg-6">
                                            <label class="control-label">Rating</label>
                                            <br>
                                            <div class="star-rating" id="ratingDiv">
                                                <span class="fa fa-star-o" data-rating="1"></span>
                                                <span class="fa fa-star-o" data-rating="2"></span>
                                                <span class="fa fa-star-o" data-rating="3"></span>
                                                <span class="fa fa-star-o" data-rating="4"></span>
                                                <span class="fa fa-star-o" data-rating="5"></span>
                                                <input type="hidden" name="whatever1" id="rateValue" class="rating-value" value="${rate}">
                                            </div>
                                        </div>
                                        <div>
                                            <label id="rateMsg"></label>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="buttons pull-right">
                                                <input type="button" class="btn btn-md btn-link" onclick="saveRating();" value="Continue"/>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">

            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="heading-part text-center">
                        <h2 class="main_title mt_50">Related Products</h2>

                    </div>
                </div>
            </div>
                <div class="row">
                    <div class="product-layout  product-grid related-pro  owl-carousel mb_5">
                        <c:forEach items="${requestScope.relatedProducts}" var="book">
                            <div class="item">
                                <div class="product-thumb">
                                    <div class="image product-imageblock"> <a href="LoadBookPage?id=${book.bookId}"> 
                                            <img data-name="product_image" src="images/product/${book.img}" alt="${book.title}" title="${book.title}" class="img-responsive"> 
                                            <img data-name="product_image" src="images/product/${book.img}" alt="${book.title}" title="${book.title}" class="img-responsive"> 

                                        </a> </div>
                                    <div class="caption product-detail text-center">
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
                                                    <!--<a href="UpdateCart?id=${book.bookId}"><div class="add-to-cart"><span hidden="true">Add to cart</span></div></a>-->
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
<script src="js/custom.js"></script>
<script src="js/calcOperations.js"></script>
<script src="js/rating.js"></script>
<style>.star-rating {
        line-height:32px;
        font-size:1.25em;
    }


    .star-rating .fa-star{color: yellow;}</style>
</body>

</html>
