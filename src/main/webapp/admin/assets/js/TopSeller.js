
(function ($) {
    var request;
    if (window.ActiveXObject)
        request = new ActiveXObject("Microsoft.XMLHTTP");
    else if (window.XMLHttpRequest)
        request = new XMLHttpRequest();
    // single bar chart
    var ctx = document.getElementById("singelBarChart");
    console.log(ctx);
    ctx.height = 150;
    request.onreadystatechange = function () {
        if (request.readyState == 4) {
            var response = request.responseText;
            if (response != null) {
                var data = JSON.parse(response);
                console.log(data);
      
                var myChart = new Chart(ctx, {
                    type: 'bar',
                    data: {
                        labels: [data[3], data[5], data[4], data[0], data[2], data[1]
                            ],
                        datasets: [
                            {
                                label: "Top 6 AuthorBooks Seller",
                                data: [data[13],data[15],data[14],data[10],data[12],
                                    data[11]],
                                borderColor: "rgba(0, 194, 146, 0.9)",
                                borderWidth: "0",
                                backgroundColor: "rgba(0, 194, 146, 0.5)"
                            }
                        ]
                    },
                    options: {
                        scales: {
                            yAxes: [{
                                    ticks: {
                                        beginAtZero: true
                                    }
                                }]
                        }
                    }
                });
            }
        }
    }
 request.open("GET", "/BookStore/barchart", true);
    request.send(null);



})(jQuery);