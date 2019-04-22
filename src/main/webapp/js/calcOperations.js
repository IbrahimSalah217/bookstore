$('input[name=quantity]').keyup(function (event) {
    var req = $(this).val();
    var pricsTag = $(this).closest('td').next();
    var totalTag = pricsTag.closest('td').next();

    var prics = pricsTag.text();
    totalTag.text(req * prics);
    var totalTags = document.getElementsByName("subtotal");

    var total = 0;
    for (var i of totalTags) {
        var sub = parseInt(i.childNodes[0].nodeValue);
        total = total + sub;
    }


    $('#totalPrice').text(total);
});
rate();
function rate(){
    $('#rate1').shieldRating({
        max: 5,
        step: 1,
        value: 3,
        markPreset: false
    });
}



