$(document).ready(function() {
	// data table i18n
	var urls = {
			es: '//cdn.datatables.net/plug-ins/1.10.7/i18n/Spanish.json',
			en: '//cdn.datatables.net/plug-ins/1.10.7/i18n/English.json'
	};
	var url = urls[locale];

	// data columns
	var columns = [
	    { data: 'firstName' },
	    { data: 'lastName' },
	    { data: 'email' },
	    { data: 'phoneNumber' },
        {
            data: null,
            className: 'centered',
            render: function (data, type, row, meta) {
            	var button = $('#buttons .edit').clone().attr('data-id', data.id).attr('onclick', 'goToEdit(this)');
            	return $('<div>').append(button).html();
            }
        },	
        {
            data: null,
            className: 'centered',
            render: function (data, type, row, meta) {
            	var button = $('#buttons .delete').clone().attr('data-id', data.id);
            	return $('<div>').append(button).html();
            }
        }
	];
	
	// data table loading
	var table = $('#patients').DataTable({
		processing: true,
		serverSide: true,
		ajax: {
			url: 'rest/patients/table',
			data: {
				columnsFilter: ['firstName', 'lastName', 'email', 'phoneNumber']
			}
		},
		language: {
			url: url
		},
		columns: columns,
		scrollX: true
	});
	
	
	// modal panel event handler
	$('#patientModal').on('show.bs.modal', function(e) {
	    // get patient id
	    var patientId = $(e.relatedTarget).data('id');
	    
	    // set patient id
	    $('#buttonModalAccept', e.currentTarget).data('id', patientId);
	});
	
	
	// modal accept button handler
	$('#buttonModalAccept').on('click', function() {
		// close modal
		$('#patientModal').modal('toggle');
		
		// delete patient
		var patientId = $(this).data('id');
		$.ajax({
			url: 'rest/patient/' + patientId,
			method: 'DELETE',
			success: function() {
				table.ajax.reload();
			}
		});
	});
});


function goToEdit(button) {
	location.href = 'patient/' +  $(button).data('id');
}