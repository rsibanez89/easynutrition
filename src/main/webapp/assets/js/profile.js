$(document).ready(function(){
	// event handler
	$('#editButton').on('click', function () {
        location.href = absoluteUrl('patient/' + patientId);
    });
    
	// get i18n
	$.getJSON(absoluteUrl('assets/json/morris-patient-profile_' + locale + '.json'),
        function(i18n) {
			// get evaluations
            $.ajax({
                url: absoluteUrl('rest/patient/' + patientId + '/evaluations'),
                success: function(data) {
                	handleData(i18n, data);
                }
            });
   	});

    
    // FUNCTIONS
    function handleData(i18n, data) {
    	
    	if (data.length > 0) {
    		Morris.Line({
    		    element: 'weight-chart',
    		    data: data,
    			xkey: 'date',
    		    ykeys: ['weight'],
    		    labels: [i18n.weight],
    		    hideHover: 'auto',
    		    pointFillColors:['#ffffff'],
    		    pointStrokeColors: ['black'],
    		    resize: true,
    		    dateFormat: dateFormat,
    		    xLabelFormat: dateFormat
    		});

    		Morris.Line({
    		    element: 'height-chart',
    		    data: data,
    			xkey: 'date',
    		    ykeys: ['height'],
    		    labels: [i18n.height],
    		    hideHover: 'auto',
    		    resize: true,
    		    dateFormat: dateFormat,
    		    xLabelFormat: dateFormat
    		});
    		
    		Morris.Line({
    		    element: 'waist-chart',
    		    data: data,
    			xkey: 'date',
    		    ykeys: ['waistCircumference'],
    		    labels: [i18n.waist],
    		    hideHover: 'auto',
    		    resize: true,
    		    dateFormat: dateFormat,
    		    xLabelFormat: dateFormat
    		});
    		
    		Morris.Line({
    		    element: 'hip-chart',
    		    data: data,
    			xkey: 'date',
    		    ykeys: ['hipCircumference'],
    		    labels: [i18n.hip],
    		    hideHover: 'auto',
    		    resize: true,
    		    dateFormat: dateFormat,
    		    xLabelFormat: dateFormat
    		});
    	}
    }

    
    function dateFormat(value) {
		return new Date(value).toLocaleDateString(locale);
    } 
});