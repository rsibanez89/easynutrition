$(document).ready(function() {
	// data table i18n
	var urls = {
			es: "//cdn.datatables.net/plug-ins/1.10.7/i18n/Spanish.json",
			en: "//cdn.datatables.net/plug-ins/1.10.7/i18n/English.json"
	};
	var url = urls[locale];

	// data columns
	var columns = [
	    { "data": "firstName" },
	    { "data": "lastName" },
	    { "data": "email" },
	    { "data": "phoneNumber" },
        {
            data: null,
            className: "centered",
            render: function (data, type, row) {
            	return $("<div>").append($("#buttons .edit").clone()).html();
            }
        },	
        {
            data: null,
            className: "centered",
            render: function (data, type, full) {
            	return $("<div>").append($("#buttons .delete").clone()).html();
            }
        }
	];
	
	// data table loading
	$('#patients').dataTable({
		processing: true,
		serverSide: true,
		ajax: {
			url: 'rest/table/patients',
			data: {
				columnsFilter: [columns[0].data, columns[1].data, columns[2].data]
			}
		},
		language: {
			url: url
		},
		columns: columns
	});
});