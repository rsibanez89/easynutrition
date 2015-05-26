var jsonResponse;

$(document).ready(function(){
	document.getElementById("editButton").onclick = function () {
        location.href = 'edit';
    };
    
    jQuery.ajax({
        url: "/publicaciones",
        dataType: 'json',
        success: handleJsonResponse
    });
});

function handleJsonResponse(data) {
	jsonResponse = data;
}


(function ($) {
    "use strict";
    var mainApp = {

        main_fun: function () {
        	
        	Morris.Line({
                element: 'morris-line-chart',
                data: jsonResponse
                /*data: [{
                    y: '2006',
                    a: 100,
                    b: 90
                }, {
                    y: '2007',
                    a: 75,
                    b: 65
                }, {
                    y: '2008',
                    a: 50,
                    b: 40
                }, {
                    y: '2009',
                    a: 75,
                    b: 65
                }, {
                    y: '2010',
                    a: 50,
                    b: 40
                }, {
                    y: '2011',
                    a: 75,
                    b: 65
                }, {
                    y: '2012',
                    a: 100,
                    b: 90
                }]*/,
                xkey: 'y',
                ykeys: ['a', 'b'],
                labels: ['Peso', 'Circunferencia de cintura'],
                hideHover: 'auto',
                resize: true
            });
           
     
        },

        initialization: function () {
            mainApp.main_fun();

        }

    };
    // Initializing ///

    $(document).ready(function () {
        mainApp.main_fun();
    });

}(jQuery));