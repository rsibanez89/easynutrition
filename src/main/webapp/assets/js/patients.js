$(document).ready(function() {
	// data table i18n
	var urls = {
			es: "//cdn.datatables.net/plug-ins/1.10.7/i18n/Spanish.json",
			en: "//cdn.datatables.net/plug-ins/1.10.7/i18n/English.json"
	};
	var url = urls[locale];

	// data columns
	var columns = [
//	    { data: "id", className: "hidden"},
	    { data: "firstName" },
	    { data: "lastName" },
	    { data: "email" },
	    { data: "phoneNumber" },
//        { data: null, className: "centered",
//            render: function (data, type, full) {
//            	return $("<div>").append($("#buttons .edit").clone()).html();
//            }
//        },	
//        { data: null, className: "centered",
//            render: function (data, type, full) {
//            	return $("<div>").append($("#buttons .delete").clone()).html();
//            }
//        }
	];
	
	// data table loading
	var table = $('#patients').DataTable({
		processing: true,
		serverSide: true,
		ajax: {
			url: 'rest/table/patients',
			data: {
				columnsFilter: ["firstName", "lastName", "email", "phoneNumber"]
			}
		},
		language: {
			url: url
		},
		columns: columns,
		initComplete: function(settings, json) {
			complete(json);
		}
	});
	
	// modal panel event handler
	$('#patientModal').on('show.bs.modal', function(e) {
	    // get patient id
	    var patientId = $(e.relatedTarget).data('id');
	    
	    // set patient id
	    $('#buttonDelete', e.currentTarget).data('id', patientId);
	});
	
	// delete button handler
	$('#buttonDelete').on('click', function() {
		// close modal
		$('#patientModal').modal('toggle');
		
		// delete patient
		var patientId = $(this).data('id');
		$.ajax({
			url: 'rest/patient/' + patientId,
			method: 'DELETE',
			success: function() {
				table.ajax.reload(complete);
			}
		});
	});
	
	// utility function
	function complete(json) {
		$("#patients tbody tr").each(function(index, elem) {
			// add row buttons
			addButton(elem, ".edit", json.data[index]);
			addButton(elem, ".delete", json.data[index]);
    	});
	}
	
	function addButton(tableRow, selector, data) {
		var button = $(selector, "#buttons").clone().data("id", data.id);
		var td = $("<td class='centered'/>").append(button);
		$(tableRow).append(td);
	};
});