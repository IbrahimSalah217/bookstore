<%-- 
    Document   : AddBook
    Created on : Apr 3, 2019, 6:59:46 PM
    Author     : Menna Helmy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Books-R-Us Admin</title>
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
    <body>
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
                                    <strong>Add a new Offer</strong>
                                </div>
                                <form name="form" method="POST">

                                    <div class="card-body card-block">
                                        <div class="form-group">
                                            <label class=" form-control-label">Offer percentage</label>
                                            <div class="input-group">
                                                <div class="input-group-addon"><i class="fa fa-magic"></i></div>
                                                <input required id="perc" name="perc" onkeyup="checkPerc()" onblur="checkPerc()" type="number" placeholder="Enter Offer Percentage"  min="1" max="100" required class="form-control">
                                            </div>
                                            <small class="form-text text-danger" id="percError"></small>
                                            <small class="form-text text-muted">ex. Horror,Romantic,...</small>
                                        </div>
                                        <div class="form-group">
                                            <label class=" form-control-label">Expire Date</label>
                                            <div class="input-group">
                                                <div class="input-group-addon"><i class="fa fa-calendar-o"></i></div>
                                                <input required id="expire" onkeyup="checkDate();"   name="expire" type="date" placeholder="Enter Expire Date" required class="form-control">
                                            </div>
                                            <small class="form-text text-danger" id="dateError"></small>
                                            <small class="form-text text-muted">ex. Horror,Romantic,...</small>
                                        </div>
                                    <div>
                                        <button id="save" onclick="saveOffer()" type="button" class="btn btn-lg btn-info btn-block" disabled>
                                            <i class="fa fa-save fa-lg"></i>&nbsp;
                                            <span id="payment-button-amount">Save Offer</span>
                                            <span id="payment-button-sending" style="display:none;">Saving…</span>
                                        </button>
                                    </div>
                                        <small class="form-text text-success" id="offerAdded"></small>
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
        <script src="/BookStore/js/jQuery_v3.1.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/jquery@2.2.4/dist/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.4/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/jquery-match-height@0.7.2/dist/jquery.matchHeight.min.js"></script>
        <script src="/BookStore/admin/assets/js/main.js"></script>
        <script src="assets/js/addOffer.js"></script>


    </body>
</html>

