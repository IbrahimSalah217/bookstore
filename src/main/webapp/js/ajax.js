/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function updateCart(bookId,oldQuantity) {
    var quantity = document.getElementById(bookId).value;
    if (quantity == "" || quantity <= 0) {
        Swal.fire({
            title: 'Error!',
            text: 'Please Insert a valid Quantity',
            type: 'info',
            confirmButtonText: 'Ok'
        });
    }else if(oldQuantity<quantity){
        Swal.fire({
            title: 'Error!',
            text: 'Unable to order This Quantity',
            type: 'error',
            confirmButtonText: 'Ok'
        });
        document.getElementById(bookId).value = oldQuantity;
    }else {
        var jsonData = {"quantity": quantity, "bookId": bookId};
        $.ajax({url: 'UpdateCart', //servlet url
            type: 'POST', //servlet request type
            data: jsonData, //input data
            success: function (data) {
                Swal.fire({
                    title: 'Done!',
                    text: 'Your Item Updated',
                    type: 'success',
                    confirmButtonText: 'Ok'
        });
            }});
    }
}
function removeCart(bookId, button) {
    console.log(bookId);
    var jsonData = {"bookId": bookId};
    $.ajax({url: 'RemoveCart', //servlet url
        type: 'POST', //servlet request type
        data: jsonData, //input data
        success: function (data) {
            Swal.fire({
                    title: 'Done!',
                    text: 'Your Item Deleted',
                    type: 'success',
                    confirmButtonText: 'Ok'
        });
        }});
    document.getElementById("table").removeChild(button.parentNode.parentNode.parentNode.parentNode.parentNode)
}
const urlParams = new URLSearchParams(window.location.search);
const error = urlParams.get('error');
if(error == "limit"){
    Swal.fire({
            title: 'Error!',
            text: 'Your Limit is not enough',
            type: 'error',
            confirmButtonText: 'Ok'
        });
    }