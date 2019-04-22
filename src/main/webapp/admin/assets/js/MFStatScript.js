startRequest();
//pie chart
var request;
var section = document.getElementById("pieChart");
section.height = 300;
function startRequest() {
    createXMLHttpRequest();
    request.onreadystatechange = handleRequest;
    request.open("GET", "/BookStore/piechart", true);
    request.send(null);
}
function handleRequest() {
    if ( request.readyState == 4) {
        var response = request.responseText;
        if (response != null) {
            var data = JSON.parse(response);
            var females = data.females;
            var males = data.males;
            display(males, females);
        }
    }
}
function createXMLHttpRequest(){
    if (window.ActiveXObject)
        request = new ActiveXObject("Microsoft.XMLHTTP");
    else if (window.XMLHttpRequest)
        request = new XMLHttpRequest();
}
function display(male, female) {
    var myChart = new Chart(section, {
        type: 'pie',
        data: {
            datasets: [{
                    data: [male, female],
                    backgroundColor: [
                        "rgba(0, 0, 146,0.9)",
                        "rgba(0, 194, 146,0.7)"
                    ],
                    hoverBackgroundColor: [
                        "rgba(0, 194, 146,0.9)",
                        "rgba(0, 194, 146,0.7)"
                    ]

                }],
            labels: [
                "male",
                "female"
            ]
        },
        options: {
            responsive: true
        }
    });
}


