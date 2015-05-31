$(document).ready(function() {
	// table columns
	var columns = [
	    { data: 'firstName' },
	    { data: 'lastName' },
	    { data: 'email' },
	    { data: 'phoneNumber' },
	    addButton('.view', 'goToProfile(this)'),
	    addButton('.edit', 'goToEdit(this)'),
	    addButton('.delete', '')
	];
	
	// table columns to filter
	var columnsFilter = ['firstName', 'lastName', 'email', 'phoneNumber'];
	
	// table loading
	var table = dataTableCreate('#patients', 'rest/patients/table', columns, columnsFilter);
	
	
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
			url: absoluteUrl('rest/patient/' + patientId),
			method: 'DELETE',
			success: function() {
				table.ajax.reload();
			}
		});
	});
	
	// FUNCTIONS
	function addButton(cssClass, onclickHandler) {
		return {
			data: null,
			className: 'centered',
			orderable: false,
			render: function (data, type, row, meta) {
				var button = $(cssClass, '#buttons').clone().attr('data-id', data.id).attr('onclick', onclickHandler);
				return $('<div>').append(button).html();
			}
		};
	}	
});

function goToProfile(button) {
	location.href = 'patient/' + $(button).data('id') + '/profile';
}

function goToEdit(button) {
	location.href = 'patient/' + $(button).data('id');
}
