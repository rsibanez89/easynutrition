var jsonResponse;

$(document).ready(function(){
	document.getElementById("editButton").onclick = function () {
        location.href = 'edit';
    };
    
    jQuery.ajax({
        url: "/easynutrition/rest/patient/1/evaluations",
        dataType: 'json',
        success: handleJsonResponse
    });
});

function handleJsonResponse(data) {
	
	for (var i = 0; i < data.length; i++) {
		data[i].date = changeDateFormat(data[i].date);
	}
	
	jsonResponse = data;
	
	Morris.Line({
	    element: 'weight-chart',
	    data: jsonResponse,
		xkey: 'date',
	    ykeys: ['weight'],
	    labels: ['Peso'],
	    hideHover: 'auto',
	    resize: true
	});
	
	Morris.Line({
	    element: 'height-chart',
	    data: jsonResponse,
		xkey: 'date',
	    ykeys: ['height'],
	    labels: ['Altura'],
	    hideHover: 'auto',
	    resize: true
	});
	
	Morris.Line({
	    element: 'waist-chart',
	    data: jsonResponse,
		xkey: 'date',
	    ykeys: ['waistCircumference'],
	    labels: ['Circunferencia de cintura'],
	    hideHover: 'auto',
	    resize: true
	});
	
	Morris.Line({
	    element: 'hip-chart',
	    data: jsonResponse,
		xkey: 'date',
	    ykeys: ['hipCircumference'],
	    labels: ['Circunferencia de cadera'],
	    hideHover: 'auto',
	    resize: true
	});
        
}

function changeDateFormat(date)
{
	var parts = date.split('/');
	return parts[2] + "-" + parts[1] + "-" + parts[0]; 
}