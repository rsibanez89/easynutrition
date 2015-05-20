$(document).ready(function() {
	$('#patients').dataTable({
		processing: true,
		serverSide: true,
		ajax: 'rest/table/patients',
		columns: [
            { "data": "firstName" },
            { "data": "lastName" },
            { "data": "email" },
            { "data": "phoneNumber" }
        ]
	});			
});