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
        <div id="column-right" class="col-sm-8 col-md-8 col-lg-9 mtb_30">
            <!-- contact  -->
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <div class="panel-login">
                        <div class="panel-heading">
                            <div class="row mb_20">
                                <div class="col-xs-6">
                                    <a href="#" class="active" id="login-form-link">Login</a>
                                </div>
                                <div class="col-xs-6">
                                    <a href="#" id="register-form-link">Register</a>
                                </div>
                            </div>
                            <hr>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <form id="login-form" action="LoginServlet" method="post">
                                        <div class="form-group">
                                            <input type="email" name="useremail" id="useremail" tabindex="1" class="form-control" placeholder="UserEmail" value="" required>
                                        </div>
                                        <div class="form-group">
                                            <input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password" required>
                                            <label id="userError"></label>
                                        </div>
                                        <div class="form-group text-center">
                                            <input type="checkbox" tabindex="3" class="" name="remember" id="remember">
                                            <label for="remember"> Remember Me</label>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-sm-6 col-sm-offset-3">
                                                    <input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Log In">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-lg-12">
                                                    <div class="text-center">
                                                        <a href="#" tabindex="5" class="forgot-password">Forgot Password?</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                    <form id="register-form" action="RegisterationServlet" method="post" >
                                        <div class="form-group">
                                            <label >User Name</label>
                                            <input type="text" name="username" id="username" tabindex="1" class="form-control" placeholder="Username" value="" required>
                                        </div>
                                        <div class="form-group">
                                            <label >Email</label>
                                            <input type="email" name="email" id="email" onkeydown="checkEmail();" onblur="checkEmail();" tabindex="1" class="form-control" placeholder="Email Address" value="" required>
                                            <label id="emailError"></label>
                                        </div>
                                        <div class="form-group">
                                            <label >Password</label>
                                            <input type="password" name="password" id="password2" tabindex="2" class="form-control" placeholder="Password" required>
                                        </div>
                                        <div class="form-group">
                                            <label >Birth Of Date</label>
                                            <input type="date" name="BirthOfDate" onkeydown ="checkDate();" onblur="checkDate();" id="date" tabindex="1" class="form-control" required>
                                            <label id="dateError"></label>
                                        </div>
                                        <div class="form-group">
                                            <label >Job</label>
                                            <input type="text" name="job" id="job" tabindex="1" class="form-control" placeholder="your job" required>
                                        </div>
                                        <div class="form-group">
                                            <label >Phone Number</label>
                                            <input type="tel" name="phone" id="phone" onkeydown="checkPhone();" tabindex="1" class="form-control" placeholder="Phone Number" required>
                                            <label id="phoneError"></label>
                                        </div>
                                        <div class="form-group">
                                            <label >Address</label>
                                            <input type="text" name="address" id="address" tabindex="1" class="form-control" placeholder="Address" required>
                                        </div>
                                        <div class="form-group">
                                            <label class="radio-inline">
                                                <input type="radio" name="genderradio" checked>Male
                                            </label>
                                            <label class="radio-inline">
                                                <input type="radio" name="genderradio">Female
                                            </label>
                                        </div>
                                        <div class="form-group">
                                            <label>Interests</label>
                                            <br>
                                            <select class="selectpicker" name="interests" multiple data-live-search="true"  title="Interests" required>
                                                <c:forEach items="${applicationScope.categories}" var="cate">
                                                    <option>${cate.categoryName}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label>Credit Limit</label>
                                            <input type="number" name="creditLimit" id="creditLimit" tabindex="2" class="form-control" placeholder="Credit Limit" required>

                                        </div>

                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-sm-6 col-sm-offset-3">
                                                    <br><br>
                                                    <input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-register" value="Register Now">
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Single Blog  -->
<!-- End Blog   -->
<!-- =====  CONTAINER END  ===== -->
<jsp:include page="Footer.jsp" />
<a id="scrollup">Scroll</a>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>
<script>
                                                        $('select').selectpicker();
                                                        $(function () {
                                                            if (window.location.search.split("=")[1] === "invalid") {
                                                                $("#userError").css("color", "red");
                                                                document.getElementById("userError").innerHTML
                                                                        = "Invalid user name or password";
                                                            } else {
                                                                $("#userError").css("color", "green");
                                                                $("#userError").html("");
                                                            }
                                                        });
</script>
<script src="js/register.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.magnific-popup.js"></script>
<script src="js/custom.js"></script>

<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script src="js/logincookie.js"></script>

</body>

</html>
