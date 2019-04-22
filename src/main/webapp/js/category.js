/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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



