/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function checkDate() {
    var bDate = new Date($("#expire").val());
    var expire = bDate.getTime() - new Date().getTime();
    if (expire < 0) {
        $("#dateError").css("color", "red");
        $("#dateError").html("Enter Valid Birth Date");
        $("#save").attr("disabled", true);
    } else {
        $("#dateError").css("color", "green");
        $("#dateError").html("");
        $('#save').attr("disabled", false);
    }
}

function checkPerc() {
    var perc = $("#perc").val();
    console.log(perc);
    if (perc > 100 || perc < 1) {
        $("#percError").css("color", "red");
        $("#percError").html("Enter Valid percent between 1,100");
        $("#save").attr("disabled", true);
    } else {
        $("#percError").css("color", "green");
        $("#percError").html("");
        $('#save').attr("disabled", false);
    }
}

function saveOffer() {
    $("#payment-button-sending").css("disply","block");
    var perc = $("#perc").val();
    var dat = $("#expire").val();
    $.post("../addoffer", {percent: perc,date:dat}, ajaxCallBack);
}

function ajaxCallBack(responseTxt, statusTxt, xhr) {
    if (statusTxt === "success") {
        $("#payment-button-sending").css("disply","none");
        console.log(responseTxt);
        $("#offerAdded").html(responseTxt);
        $("#perc").val("");
    }
}