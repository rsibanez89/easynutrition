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

	// table columns
	var columns = [
	    { data: 'date', 
	      render: function (data, type, row) {
	    	  return dateFormat(data);
	      }
	    },
	    { data: 'weight' },
	    { data: 'height' },
	    { data: 'observation' }
	];
	
	// table columns to filter
	var columnsFilter = ['date', 'weight', 'height', 'observation'];
	
	// table loading
	dataTableCreate('#evaluations', 'rest/patient/' + patientId + '/evaluations/table', columns, columnsFilter);
	
	
    // FUNCTIONS
    function handleData(i18n, data) {
    	if (data.length > 0) {
    		morrisLine('weight-chart', data, 'weight', i18n.weight);
    		morrisLine('height-chart', data, 'height', i18n.height);
    		morrisLine('waist-chart', data, 'waistCircumference', i18n.waist);
    		morrisLine('hip-chart', data, 'hipCircumference', i18n.hip);
    	}
    }
    
	function morrisLine(element, data, ykey, label) {
		Morris.Line({
		    element: element,
		    data: data,
			xkey: 'date',
		    ykeys: [ykey],
		    labels: [label],
		    hideHover: 'auto',
		    pointFillColors:['#ffffff'],
		    pointStrokeColors: ['black'],
		    resize: true,
		    dateFormat: dateFormat,
		    xLabelFormat: xLabelFormat
		});
	}
	
	function xLabelFormat(date) {
		return (date.getMonth() + 1) + "/" + date.getFullYear();
	}
});