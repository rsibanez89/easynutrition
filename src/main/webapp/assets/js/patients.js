$(document).ready(function() {
	// data table i18n
	var url = "";
	switch (locale) {
	case "es":
		url = "//cdn.datatables.net/plug-ins/1.10.7/i18n/Spanish.json";
		break;
	default:
		url = "//cdn.datatables.net/plug-ins/1.10.7/i18n/English.json";
	}

	// data table loading
	$('#patients').dataTable({
		processing: true,
		serverSide: true,
		ajax: 'rest/table/patients',
		language: {
			url: url
		},
		columns: [
            { "data": "firstName" },
            { "data": "lastName" },
            { "data": "email" },
            { "data": "phoneNumber" }
        ]
	});			
});