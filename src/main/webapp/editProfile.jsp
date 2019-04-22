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
            <div class="left_banner left-sidebar-widget mt_30 mb_50">
                <a href="#"><img src="images/left1.jpg" alt="Left Banner" class="img-responsive" /></a>
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

        <!-- edit form column -->

        <div id="column-right" class="col-md-9 personal-info">

            <br>
            <h1>Edit Profile</h1>
            <br>
            <div class="alert alert-info alert-dismissable">
                <a class="panel-close close" data-dismiss="alert">×</a> 
                <i class="fa fa-coffee"></i>
                This is an <strong>.alert</strong>. edit your data then click on submit button to keep it 
            </div>
            <h3>Personal info</h3>
            <br>
            <form class="form-horizontal" action="EditProfileServlet" method="POST" role="form">
                <div class="form-group">
                    <label class="col-lg-3 control-label">User Name:</label>
                    <div class="col-lg-8">
                        <input class="form-control" name="username" id="username" type="text" value="${sessionScope.user.name}" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-3 control-label">Email:</label>
                    <div class="col-lg-8">
                        <input class="form-control" name="email" id="email" type="email" value="${sessionScope.user.email}" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-3 control-label">Birth Of Date:</label>
                    <div class="col-lg-8">
                        <input class="form-control" name="BirthOfDate" id="date" onkeydown ="checkDate();" onblur="checkDate();" type="date" value="${sessionScope.user.birthDate}" required>
                        <label id="dateError"></label>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-3 control-label">Job:</label>
                    <div class="col-md-8">
                        <input class="form-control" name="job" id="job" type="text" value="${sessionScope.user.job}" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label">phone Number:</label>
                    <div class="col-md-8">
                        <input class="form-control" name="phone" id="phone" onkeydown="checkPhone();" onblur="checkPhone();" type="tel" value="${sessionScope.user.phone}" required>
                        <label id="phoneError"></label>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label">Address:</label>
                    <div class="col-md-8">
                        <input class="form-control" name="address" id="address" type="text" value="${sessionScope.user.address}" required>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-3 control-label">Interests:</label>
                    <div class="col-lg-8">
                        <div class="ui-select">
                            <select id="user_time_zone" name="interests" class="form-control selectpicker" multiple data-live-search="true"  title="Interests" required>
                                <c:set var="contains" value="false"/>
                                <c:forEach items="${applicationScope.categories}" var="cate">
                                    <c:forEach items="${sessionScope.user.intersts}" var="interst">
                                        <c:if test="${interst eq cate.categoryName}">
                                            <c:set var="contains" value="true" />
                                        </c:if>
                                    </c:forEach> 
                                    <c:choose>
                                        <c:when test='${contains eq "true"}'>
                                            <option selected>${cate.categoryName}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option>${cate.categoryName}</option>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:set var="contains" value="false" />
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label">Password:</label>
                    <div class="col-md-8">
                        <input class="form-control" name="password" id="password2" type="password" value="${sessionScope.user.password}" required>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-3 control-label">Credit Limit:</label>
                    <div class="col-md-8">
                        <input class="form-control"name="creditLimit" id="creditLimit" type="text" value='<fmt:formatNumber type = "number" pattern="####.##" value="${sessionScope.user.creditLimit}" />' required>

                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label"></label>
                    <div class="col-md-8">
                        <input type="submit" class="btn btn-primary" value="Save Changes">
                        <span></span>
                        <a href="userhome"><input type="button" class="btn btn-default" value="Cancel"/></a>
                    </div>
                </div>
            </form>
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
<jsp:include page="Footer.jsp" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>
<script>
                            $('select').selectpicker();
</script>

<script src="js/register.js"></script>
<script src="js/jQuery_v3.1.1.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.magnific-popup.js"></script>
<script src="js/custom.js"></script>
</body>

</html>
