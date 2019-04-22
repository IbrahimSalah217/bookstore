/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//var yr = new Date().getYear() - bDate.getYear();
$(function() {
    if (window.location.search.split("=")[1] === "invalid") {
        $("#userError").css("color", "red");
        document.getElementById("userError").innerHTML
                = "Invalid user name or password";
    } else {
        $("#userError").css("color", "green");
        $("#userError").html("");
    }
});
function checkEmail() {
    var userEmail = $("#email").val();
    console.log("dddddddddddddddddddddkkkkkkkkkkkkkkkkkkk");
    $.get("RegisterationServlet", {email: userEmail}, ajaxCallBack);
}

function ajaxCallBack(responseTxt, statusTxt, xhr) {
    console.log("ddddddddddddddddddddd");
    if (statusTxt === "success") {
        if (responseTxt === "valid") {
            $("#emailError").css("color", "green");
            $("#emailError").html("");
            $('#register-submit').attr("disabled", false);
        } else if (responseTxt === "invalid") {
            $("#emailError").css("color", "red");
            $("#emailError").html("email is already used");
            $("#register-submit").attr("disabled", true);
        }
    }
}

function checkDate() {
    var bDate = new Date($("#date").val());
    var age = new Date().getYear() - bDate.getYear();
    if (age > 0) {
        $("#dateError").css("color", "green");
        $("#dateError").html("");
        $('#register-submit').attr("disabled", false);
    } else {
        $("#dateError").css("color", "red");
        $("#dateError").html("Enter Valid Birth Date");
        $("#register-submit").attr("disabled", true);
    }
}

function checkPhone() {
    var phone = $("#phone").val();
    if (phone.match(/(01)[0|1|2|5][0-9]{8}/)) {
        $("#phoneError").css("color", "green");
        $("#phoneError").html("");
        $('#register-submit').attr("disabled", false);
    } else {
        $("#phoneError").css("color", "red");
        $("#phoneError").html("This Is Not Real Phone Number");
        $("#register-submit").attr("disabled", true);
    }
}