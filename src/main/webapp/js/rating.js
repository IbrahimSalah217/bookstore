/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var $star_rating = $('.star-rating .fa');
function saveRating(){
    console.log($("#rateValue").val());
    $.post("addRating", {rate: $("#rateValue").val()
        ,bookId:window.location.search.split("=")[1]
        ,username:$("#input-name").val()
        ,comment:$("#input-review").val()
    }, ajaxCallBack);
}

function ajaxCallBack(responseTxt, statusTxt, xhr) {
    
    if (statusTxt === "success") {
            $("#rateMsg").css("color", "green");
            $("#rateMsg").html(responseTxt);
            console.log(responseTxt);
    }
}

var SetRatingStar = function() {
  return $star_rating.each(function() {
    if (parseInt($star_rating.siblings('input.rating-value').val()) >= parseInt($(this).data('rating'))) {
      return $(this).removeClass('fa-star-o').addClass('fa-star');
    } else {
      return $(this).removeClass('fa-star').addClass('fa-star-o');
    }
  });
};

$star_rating.on('click', function() {
  $star_rating.siblings('input.rating-value').val($(this).data('rating'));
  return SetRatingStar();
});

SetRatingStar();
$(document).ready(function() {

});

